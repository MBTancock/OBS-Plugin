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
            },

            onRender: function () {
                Ext4.create('Ext.form.Panel', {
                    autoHeight: false,
                    autoScroll: true,
                    renderTo: Ext.get('cuesheettestpanel'),
                    width: 600,
                    items: [
                        {
                            xtype: 'fieldset',
                            title: 'OBS Cue Sheet Export Test',
                            //layout: 'column',
                            defaults: {
                                anchor: '100%',
                                labelWidth: 100,
                                labelAlign: 'right'
                            },
                            items: [
                                {
                                    xtype: 'textfield',
                                    fieldLabel: 'Title',
                                    id: 'export_title',
                                    value: 'My Story',
                                    listeners:
                                    {
                                        blur: function () {
                                        },
                                        change: function (newValue, oldValue, eOpts) {
                                            checkData();
                                        }
                                    }
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: 'Queue Full Path',
                                    id: 'export_queue',
                                    value: 'INEWS:MDS.MX1.00',
                                    listeners:
                                    {
                                        blur: function () {
                                        },
                                        change: function (newValue, oldValue, eOpts) {
                                            checkData();
                                        }
                                    }
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: 'Locator',
                                    id: 'export_locator',
                                    value: '491450435.52797.8',
                                    listeners:
                                    {
                                        blur: function () {
                                        },
                                        change: function (newValue, oldValue, eOpts) {
                                            checkData();
                                        }
                                    }
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: 'MobID',
                                    id: 'export_mob_id',
                                    value: '060a2b340101010101010f0013-000000-46bd19c5041c431f-b273bf151bb9-b410',
                                    listeners:
                                    {
                                        blur: function () {
                                        },
                                        change: function (newValue, oldValue, eOpts) {
                                            checkData();
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
                                        var title = Ext4.getCmp('export_title').value;
                                        var queue = Ext4.getCmp('export_queue').value;
                                        var locator = Ext4.getCmp('export_locator').value;
                                        var mobID = Ext4.getCmp('export_mob_id').value;
                                        retrieveMarkers(title, queue, locator, mobID);
                                    }
                                }
                            ]
                        }
                    ]
                })
            }
        });
    })

    function checkData()
    {
        var title = Ext4.getCmp('export_title').value;
        var queue = Ext4.getCmp('export_queue').value;
        var locator = Ext4.getCmp('export_locator').value;
        var mobID = Ext4.getCmp('export_mob_id').value;
        var btn = Ext4.getCmp('export_sheet_button');
        btn.setDisabled(title.length == 0 || queue.length == 0 || locator.length == 0 || mobID.length == 0);
    }
})(AV);

/*
 locator: "491450435.52797.8"
 mobID: "060a2b340101010101010f0013-000000-46bd19c5041c431f-b273bf151bb9-b410"
 queue: "INEWS:MDS.MX1.00"
 */