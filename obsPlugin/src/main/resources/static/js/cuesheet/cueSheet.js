/**
 * Created by Broadcast Media Solutions on 29/10/2015.
 */
(function (AV) {
    AV.ViewManager.addViewFactory("cueSheet", function (options) {
        return new AV.View({


            onInit: function () {
                this.name("Cue Sheet Export");
                this.dom().append('<div id="cuesheetpanel" class="cuesheet"></div>');
                this.bindGlobal("findSequence", function (event, data) {
                    retrieveMarkers(data);
                });
            },

            onRender: function () {
                Ext4.define('markerData', {
                    extend: 'Ext4.data.Model',
                    fields: [
                        'start',
                        'duration',
                        'comment'
                    ]
                });

                var markersStore = Ext4.create('Ext4.data.ArrayStore', {
                    id: 'marker-store',
                    model: markerData
                });

                Ext4.create('Ext4.form.Panel', {
                    autoHeight: false,
                    autoScroll: true,
                    renderTo: Ext4.get('cuesheetpanel'),
                    width: 410,
                    layout: 'column',
                    defaults: {
                        margin: '0 0 10 10'
                    },
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
                            width: 380
                        },
                        {
                            xtype: 'button',
                            text: 'Export Cue Sheet',
                            name: 'export_cue_sheet',
                            id: 'export_cue_sheet_id',
                            width: 380,
                            margin: '0 0 10 10',
                            disabled: 'true',
                            handler: function () {
                                exportCuesheet();
                            }
                        },
                        {
                            xtype: 'label',
                            id: 'export_identifier',
                            text: 'dummy',
                            value: 'My Data',
                            hidden: 'true'
                        }

                    ]
                })

            }

        });

        function retrieveMarkers(url) {
            try {
                if (null == url || url.asset == undefined) {
                    AV.Utilities.showErrorMessage("Failed to obtain the story reference");
                    return;
                }

                var txt = url.asset;
                // strip off initial identifier

                txt = txt.substring(txt.indexOf("%3A") + 3);
                var rundown = txt.substring(0, txt.indexOf("%3A"));
                txt = txt.substring(txt.indexOf("%3A") + 3);
                var story = txt.substring(0, txt.indexOf("%7C"));

                var cuesheet = new AV.obsPlugin.datamodel.CuesheetRequest(rundown, story);

                AV.messages.WaitBox.show({
                    title: "Retrieving Markers",
                    content: "Please wait while the markers are retrieved",
                    isDelayed: true
                });

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

                        var label = Ext4.getCmp('export_identifier');
                        label.value = res.id;

                    })
            }
            catch (ex) {
                AV.messages.WaitBox.hide();
                AV.Utilities.showErrorMessage("An error occurred: " + ex.message);
            }
        }

        function exportCuesheet() {
            try {
                // get the id of the export to process
                var label = Ext4.getCmp('export_identifier');
                var id = label.value;

                AV.messages.WaitBox.show({
                    title: "Publishing Cue Sheet",
                    content: "Please wait while cue sheet is published to the story",
                    isDelayed: true
                });

                var path = "/api/cuesheet/" + id;
                $.ajax(path, {
                        method: "GET",
                        dataType: "json",
                    })
                    .done(function (res) {
                        AV.messages.WaitBox.hide();

                        if (res == undefined)
                        {
                            AV.Utilities.showErrorMessage("There was a problem communicating with the server.");
                            return;
                        }
                    });
            }
            catch (ex) {
                AV.messages.WaitBox.hide();
                AV.Utilities.showErrorMessage("An error occurred: " + ex.message);
            }
        }
    })
})(AV);