/**
 * Created by Broadcast Media Solutions on 29/10/2015.
 */
(function(AV) {
    AV.ViewManager.addViewFactory("cueSheetTest", function (options) {
        return new AV.View({

            var: win = undefined,
            var: markersStore = undefined,

            onInit: function () {
                this.name("Cue Sheet Export");
                this.dom().append('<div id="cuesheettestpanel" class="cueSheetTest"></div>');

                Ext4.define('markerData', {
                    extend: 'Ext4.data.Model',
                    fields: [
                        'start',
                        'duration',
                        'comment'
                    ]
                });

                markersStore = Ext4.create('Ext4.data.ArrayStore', {
                    id: 'marker-store',
                    model: markerData
                });

            },

            onRender: function () {
                Ext4.create('Ext.form.Panel', {
                    autoHeight: false,
                    autoScroll: true,
                    renderTo: Ext.get('cuesheettestpanel'),
                    width: 500,
                    items: [
                        {
                            xtype: 'fieldset',
                            title: 'OBS Cue Sheet Export Test',
                            //layout: 'column',
                            defaults: {
                                anchor: '100%',
                                labelWidth: 160,
                                labelAlign: 'right'
                            },
                            items: [
                                {
                                    xtype: 'textareafield',
                                    fieldLabel: 'Paste Story Link Here',
                                    id: 'export_link_text',
                                    grow: 'true',
                                    value: 'https://media-central/layout/inews-only-layout/#inews:INEWS%3AMDS.MX1.00%3A84955593.287885.11%7CStory',
                                    listeners:
                                    {
                                        blur: function () {
                                        },
                                        change: function (newValue, oldValue, eOpts) {
                                            var btn = Ext4.getCmp('export_sheet_button');
                                            btn.setDisabled(oldValue.toString().length == 0);
                                        }
                                    }
                                },
                                {
                                    xtype: 'button',
                                    text: 'Export',
                                    name: 'export_sheet',
                                    id: 'export_sheet_button',
                                    width: '100',
                                    margin: '0 0 0 165',
                                    handler: function () {
                                        exportcueSheetTest(Ext4.getCmp('export_link_text').value);
                                    }
                                }
                            ]
                        }
                    ]
                })
            }

        });

        function exportcueSheetTest(locator) {
            AV.messages.WaitBox.show({
                title: "Retrieving Markers",
                content: "Please wait while the markers are retrieved",
                isDelayed: true
            });

            try {
                if (undefined == locator) {
                    AV.Utilities.showErrorMessage("Failed to obtain the story reference");
                    return;
                }

                var txt = locator;
                // strip off initial identifier

                txt = txt.substring(txt.indexOf("%3A") + 3);
                var rundown = txt.substring(0, txt.indexOf("%3A"));
                txt = txt.substring(txt.indexOf("%3A") + 3);
                var story = txt.substring(0, txt.indexOf("%7C"));

                var cuesheet = new AV.obsPlugin.datamodel.CuesheetRequest(rundown, story);

                // post the request to create the export data
                $.ajax("/api/cuesheet/", {
                        method: "POST",
                        contentType: "application/json",
                        data: cuesheet.toJs(),
                        dataType: "json"
                    })
                    .done(function (res) {
                        AV.messages.WaitBox.hide();

                        if (res == undefined)
                        {
                            AV.Utilities.showErrorMessage("There was a problem communicating with the server.");
                            return;
                        }

                        if (0 == res.result)
                        {
                            AV.Utilities.showErrorMessage("There was a problem retrieving the markers: " + res.message);
                            return;
                        }

                        if (win == undefined) {
                            win = Ext4.create('Ext4.window.Window', {
                                closeAction: 'close',
                                id: 'myWin',
                                title: res.title,
                                height: 280,
                                width: 410,
                                constrain: true,
                                buttonAlign : 'center',
                                closable: false,
                                resizable: false,
                                items: [
                                    {
                                        xtype: 'grid',
                                        store: markersStore,
                                        id: 'export_markers_id',
                                        stateful: true,
                                        stateId: 'stateGrid',
                                        columns: [
                                            {
                                                text: 'Start',
                                                width: 80,
                                                sortable: false,
                                                dataIndex: 'start',
                                                height: 24,
                                                align: 'center'
                                            },
                                            {
                                                text: 'Durn.',
                                                width: 80,
                                                sortable: false,
                                                dataIndex: 'duration',
                                                height: 24,
                                                align: 'center'
                                            },
                                            {
                                                text: 'Comment',
                                                flex: 1,
                                                sortable: false,
                                                dataIndex: 'comment',
                                                height: 24
                                            }
                                        ],
                                        height: 200,
                                        width: 380,
                                        margin: '0 0 10 10'
                                    }
                                ],
                                dockedItems: [
                                    {
                                        xtype: 'toolbar',
                                        flex: 1,
                                        dock: 'bottom',
                                        ui: 'footer',
                                        layout: {
                                            pack: 'end',
                                            type: 'hbox'
                                        },
                                        items: [
                                            {
                                                xtype: 'button',
                                                text: 'Cancel',
                                                itemId: 'cancel',
                                                handler : function() {
                                                    win.close();
                                                    win == undefined;
                                                }
                                            },
                                            {
                                                xtype: 'button',
                                                text: 'Publish',
                                                id: 'export_cue_sheet_id',
                                                handler : function() {
                                                    win.close();
                                                    win == undefined;
                                                }
                                            }
                                        ]
                                    }
                                ]
                            });
                        }

                        var store = Ext4.getStore('marker-store');

                        store.loadData([], false);
                        for (var i = 0; i < res.markers.length; i++) {
                            var marker = res.markers[i];
                            var a = marker['Start'];
                            var b = marker['Duration'];
                            var c = marker['Comment'];
                            store.add({start: a, duration: b, comment: c});
                        }

                        var btn = Ext4.getCmp('export_cue_sheet_id');
                        btn.setDisabled(res.markers.length == 0);

                        win.show();

                    })


            }
            catch (ex) {
                AV.messages.WaitBox.hide();
                AV.Utilities.showErrorMessage("An error occurred: " + ex.message);
            }
        }

        function exportcueSheetTestX() {

            var txt = Ext4.getCmp('export_link_text').value;
            var res = $(".cueSheet");

            if (res.length > 0)
            {
                var view = AV.View.getView(".cueSheet");
                view.triggerGlobal("findSequence", {asset: txt});
                return;
            }
            var view = AV.ViewManager.createView({
                type: "cueSheet",
                name: "Cue Sheet Test",
                closable: true
            });

            AV.ComplexLayout.openView(view);
            //var objectData = {type: 'findSequece', systemID: '12345', systemType: 'story', base: 'findSequece | 12345 | story'};
            //var data = AV.commonObject.create(objectData);
            view.triggerGlobal("findSequence", {asset: txt});
         }
    })
})(AV);