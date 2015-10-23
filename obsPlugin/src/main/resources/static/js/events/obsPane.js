(function (AV) {
    AV.ViewManager.addViewFactory('obsPane', function () {
        var myView =  new AV.View({

            onInit: function () {
                var loc = this.getLocalization();
                this.name("My OBS Pane");
                this.dom().append('<div id="ext4panel" class="ext4"></div>');
                this.bindGlobal(
                {
                    myEvent: function (event, data) {
                        triggerred(event.type, data)
                    }

                });
            },

            onRender: function () {
                Ext4.create('Ext.form.Panel', {
                    autoHeight: false,
                    autoScroll: true,
                    renderTo: Ext4.get('ext4panel'),
                    width: 450,
                    items: [
                        {
                            xtype: 'fieldset',
                            title: 'Fieldset with styled elements',
                            defaults: {
                                anchor: '100%',
                                labelWidth: 160,
                                labelAlign: 'left'
                            },
                            items: [
                                {
                                    xtype: 'button',
                                    editable: false,
                                    text: 'Fire Event',
                                    margin: '5 0 5 0',
                                    handler: function () {
                                        trigger();
                                    }
                                }
                            ]
                        }
                    ]
                });

                Ext4.create('Ext.tip.ToolTip', {
                    target: 'tooltipText-bodyEl',
                    //html: 'Example text for ExtJS 4 tooltip without auto hide',
                    html: 'The minimum value for this field is 10',
                    anchor: 'top',
                    autoHide: false
                });
            },

            onDestroy: function () {
                // Do you have to cleanup something?
            }
        })
        function trigger() {
            var myObject = {
                base: {
                    systemType: 'myType',
                    systemID: 'myID',
                    type: 'Type',
                    id: '1234'
                },
                globalID: "myType:myID:Type:1234"
            };

            try {
                var dataObject = AV.commonObject.create(myObject);
                myView.triggerGlobal("myEvent", dataObject);
            }
            catch (Exception)
            {
                AV.Utilities.showErrorMessage(Exception.message);
            }
        }

        function triggerred(event, data) {
            AV.Utilities.showErrorMessage("Received event type " + event + ", data: " + data.globalID);
        }

        return myView;
    });
}(AV))