/**
 * Created by Broadcast Media Solutions on 29/10/2015.
 */
(function(AV) {
    AV.ViewManager.addViewFactory("cueSheetTest", function (options) {
        return new AV.View({

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
                                        exportcueSheetTest();
                                    }
                                }
                            ]
                        }
                    ]
                })
            }

        });
        function exportcueSheetTest() {
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