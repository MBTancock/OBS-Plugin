(function () {

    AV.ViewManager.addViewFactory("VIEW_TYPE", function () {

        return new AV.BasicSettingsView({

            dataHandler:{
                request:function (cfg) {
                    var request = Ext.applyIf(cfg, {
                        url:"/api/VIEW_TYPE/usersettings",
                        headers:{ accept:'application/json' },
                        failure:function (response) {
                            AV.Utilities.showErrorMessageForXHR(response);
                        }
                    });
                    Ext.Ajax.request(request);
                },

                loadData:function (callback) {
                    this.request({
                        method:"GET",
                        success:function (response) {
                            callback(Ext.decode(response.responseText));
                        }
                    });
                },

                postData:function (data) {
                    if(!data.enabled) { data.enabled = "off" }
                    this.request({
                        method:"POST",
                        jsonData:data
                    });
                }
            },

            createSettingsForm:function () {
                var loc = this.getLocalization();

                var form = new AV.Ext.FormPanel({
                    title:loc('VIEW_TYPE.title'),

                    headerCfg:{
                        cls:'settings-x-grid3-header',
                        autoScroll:false
                    },

                    baseCls:'settings-details-view',
                    bwrapCssClass:'settings-details-bwrap',

                    height:'100%',
                    frame:false,

                    items:[
                        {
                            xtype:'fieldset',
                            cls:'settings-fieldset',

                            title:loc("VIEW_TYPE.subsection.title"),

                            autoHeight:true,

                            items:[

                                {  xtype:"label", text:"A label for a lang description. A label for a lang description. A label for a lang description." },

                                createCheckBox(),
                                createTextField(),
                                passwordField(),
                                createComboBox()
                            ]
                        }
                    ]
                });

                // Needed by base class.
                this.form = form;

                return form;
            }

        })

    });

    function createComboBox() {
        return {
            xtype:'av.combobox',
            fieldLabel:"Combobox",

            itemId:"comboboxId",

            // Autoload store
            triggerAction:'all',
            editable:false,

            // store mapping
            valueField:'id',
            displayField:'name',

            // default values.
            hiddenName:'combobox',
            //hiddenValue:"first",
            //value:"Default Value",

            mode:'local',
            store:{
                xtype:"arraystore",
                fields:[ 'id', 'name'],
                data:[
                    [ "first", "Default Value" ],
                    [ "second", "Other Value" ]
                ]
            }
        };
    }

    function createTextField() {
        return {
            xtype:"av.textfield",

            itemId:"textfieldId",

            // data property name
            name:"textfield",
            mandatory:true,
            allowBlank:false,
            fieldLabel:"TextField"
        }
    }

    function passwordField() {
        return {
            xtype:"av.textfield",
            inputType:'password',

            itemId:"passwordId",

            name:"password",

            mandatory:true,
            allowBlank:false,
            fieldLabel:"Password"
        }
    }

    function createCheckBox() {
        return {
            xtype:'av.checkbox',
            hideLabel:true,
            checked:true,
            boxLabel:"Enabled",
            name:"enabled",
            hiddenName:"enabled",

            listeners:{
                check:function (el, checked) {
                    var form = this.findParentByType("av.form").getForm();
                    form.findField('textfieldId').setDisabled(!checked);
                    form.findField('comboboxId').setDisabled(!checked);
                    form.findField('passwordId').setDisabled(!checked);
                }
            }
        };
    }
})();