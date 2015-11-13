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
                                        exportCuesheet(Ext4.getCmp('export_link_text').value);
                                    }
                                }
                            ]
                        }
                    ]
                })
            }
        });
    })
})(AV);