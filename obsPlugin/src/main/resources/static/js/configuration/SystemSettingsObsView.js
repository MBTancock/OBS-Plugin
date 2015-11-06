/*
 * Copyright Broadcast Media Solutions
 */

(function (AV, ko) {

    AV.ViewManager.addViewFactory("system-settings-obs-view", function (options) {
        return new AV.BasicSettingsView({
            var: model = new AV.obsPlugin.datamodel.ExportConfiguration,

            init: function () {
                AV.BasicSettingsView.prototype.init.apply(this, arguments);
                // optional handling of the resize event
                this.bind(AV.Settings.FORM_RESIZE_EVENT, this.onResize.bind(this));
            },

            onResize: function (event, width, height) {
                // do whatever needed
            },

            // create your main element and append it to DOM here
            createFormEl: function (parentEl) {

                    panel = Ext4.create('Ext.form.Panel', {
                    renderTo: parentEl,
                    listeners: {
                        dirtychange: this.onDirtyChange.bind(this)
                    },
                    items: setupfields()
                });


                setupbindings();
                setvalues();
            },

            render: function() {

            },

            onDirtyChange: function (form, isFormDirty) {
                // sets dirty flag on view and changes disabled state of the Apply and Revert buttons
                this.setDirty(isFormDirty);
            },

            // set to true to not to render default Apply and Revert buttons, default value is false
            hideButtons: false,

            // place your data saving logic her
            save: function (callback) {
                if (panel.isValid()) {
                    savesettings();
                    this.setDirty(false);
                    callback(true);
                } else {
                    // ensure that API will be notified of something went wrong
                    callback(false);
                }
            },

            // place your form reverting logic here
            revert: function (callback) {
                callback(setvalues());
                this.setDirty(false);
            }

        });

        function setupfields() {
            var formatStore = ({
                type : 'array',
                fields : ['name'],
                data : [
                    ['Omit Tags'],
                    ['Include Tags']
                ]
            });

            return [
                {
                    xtype: 'fieldset',
                    title: 'iNEWS',
                    name: 'inews',
                    layout: 'column',
                    defaults: {
                        labelWidth: 160,
                        labelAlign: 'right'
                    },
                    items: [
                        {
                            xtype: 'textfield',
                            name: 'inws_ws_srvr',
                            fieldLabel: 'Web Services Host',
                            allowBlank: false
                        },
                        {
                            xtype: 'textfield',
                            fieldLabel: 'Port',
                            name: 'inws_ws_port',
                            inputType: 'numberfield',
                            width: 200,
                            allowBlank: false
                        },
                        {
                            xtype: 'textfield',
                            fieldLabel: 'iNEWS Server',
                            name: 'inws_server',
                            allowBlank: false
                        },
                        {
                            xtype: 'textfield',
                            fieldLabel: 'Login',
                            name: 'inws_login',
                            allowBlank: false
                        },
                        {
                            xtype: 'textfield',
                            fieldLabel: 'Password',
                            name: 'inws_pwd',
                            inputType: 'password',
                            allowBlank: false
                        },
                        {
                            xtype: 'button',
                            editable: false,
                            text: 'Test Connection',
                            margin: '10 0 0 45',
                            handler: function () {
                                test_inews();
                            }
                        }
                    ]
                },
                {
                    xtype: 'fieldset',
                    title: 'Interplay',
                    layout: 'column',
                    defaults: {
                        labelWidth: 160,
                        labelAlign: 'right'
                    },
                    items: [
                        {
                            xtype: 'textfield',
                            name: 'iplay_ws_srvr',
                            fieldLabel: 'Web Services Host',
                            allowBlank: false
                        },
                        {
                            xtype: 'textfield',
                            fieldLabel: 'Port',
                            name: 'iplay_ws_port',
                            inputType: 'numberfield',
                            width: 200,
                            allowBlank: false
                        },
                        {
                            xtype: 'textfield',
                            fieldLabel: 'Workgroup Name',
                            name: 'iplay_workgroup',
                            allowBlank: false
                        },
                        {
                            xtype: 'textfield',
                            fieldLabel: 'Login',
                            name: 'iplay_login',
                            allowBlank: false
                        },
                        {
                            xtype: 'textfield',
                            fieldLabel: 'Password',
                            name: 'iplay_pwd',
                            inputType: 'password',
                            allowBlank: false
                        },
                        {
                            xtype: 'button',
                            editable: false,
                            text: 'Test Connection',
                            margin: '10 0 0 45',
                            handler: function () {
                                test_interplay();
                            }
                        }
                    ]
                },
                {
                    xtype: 'fieldset',
                    title: 'ONC FTP Server',
                    layout: 'column',
                    defaults: {
                        labelWidth: 160,
                        labelAlign: 'right'
                    },
                    items: [
                        {
                            xtype: 'textfield',
                            name: 'onc_ftp_srvr',
                            fieldLabel: 'FTP Host',
                            allowBlank: false
                        },
                        {
                            xtype: 'textfield',
                            fieldLabel: 'Port',
                            name: 'onc_ftp_port',
                            inputType: 'numberfield',
                            width: 200,
                            allowBlank: false
                        },
                        {
                            xtype: 'textfield',
                            fieldLabel: 'Path',
                            name: 'onc_ftp_path',
                            allowBlank: false
                        },
                        {
                            xtype: 'textfield',
                            fieldLabel: 'Login',
                            name: 'onc_ftp_login',
                            allowBlank: false
                        },
                        {
                            xtype: 'textfield',
                            fieldLabel: 'Password',
                            name: 'onc_ftp_pwd',
                            inputType: 'password',
                            allowBlank: false
                        },
                        {
                            xtype: 'button',
                            editable: false,
                            text: 'Test Connection',
                            margin: '10 0 0 45',
                            handler: function () {
                                test_onc_ftp();
                            }
                        }
                    ]
                },
                {
                    xtype: 'fieldset',
                    title: 'MDS FTP Server',
                    layout: 'column',
                    defaults: {
                        labelWidth: 160,
                        labelAlign: 'right'
                    },
                    items: [
                        {
                            xtype: 'textfield',
                            name: 'mds_ftp_srvr',
                            fieldLabel: 'FTP Host',
                            allowBlank: false
                        },
                        {
                            xtype: 'textfield',
                            fieldLabel: 'Port',
                            name: 'mds_ftp_port',
                            inputType: 'numberfield',
                            width: 200,
                            allowBlank: false
                        },
                        {
                            xtype: 'textfield',
                            fieldLabel: 'Path',
                            name: 'mds_ftp_path',
                            allowBlank: false
                        },
                        {
                            xtype: 'textfield',
                            fieldLabel: 'Login',
                            name: 'mds_ftp_login',
                            allowBlank: false
                        },
                        {
                            xtype: 'textfield',
                            fieldLabel: 'Password',
                            name: 'mds_ftp_pwd',
                            inputType: 'password',
                            allowBlank: false
                        },
                        {
                            xtype: 'button',
                            editable: false,
                            name: 'mds_test',
                            text: 'Test Connection',
                            margin: '10 0 0 45',
                            handler: function () {
                                test_mds_ftp();
                            }
                        }
                    ]
                },
                {
                    xtype: 'fieldset',
                    title: 'Export Authorisation',
                    layout: 'column',
                    defaults: {
                        labelWidth: 160,
                        labelAlign: 'right'
                    },
                    items: [
                        {
                            xtype: 'textfield',
                            fieldLabel: 'Rundown Exporters Role',
                            name: 'obs_export_role',
                            allowBlank: false
                        },
                        {
                            xtype: 'textfield',
                            fieldLabel: 'Cue SheetExporters Role',
                            name: 'obs_cuesheet_role',
                            allowBlank: false
                        }
                    ]
                },
                {
                    xtype: 'fieldset',
                    title: 'Field Definitions',
                    layout: 'column',
                    defaults: {
                        labelWidth: 160,
                        labelAlign: 'right'
                    },
                    items: [
                        {
                            xtype: 'textfield',
                            fieldLabel: 'ObsChannelID',
                            name: 'obs_channel_id',
                            allowBlank: false
                        },
                        {
                            xtype: 'textfield',
                            fieldLabel: 'Title',
                            name: 'title_id',
                            allowBlank: false
                        },
                        {
                            xtype: 'textfield',
                            fieldLabel: 'Date',
                            name: 'date_id',
                            allowBlank: false
                        },
                        {
                            xtype: 'textfield',
                            fieldLabel: 'Day',
                            name: 'day_id',
                            allowBlank: false
                        },
                        {
                            xtype: 'textfield',
                            fieldLabel: 'Viz Graphic',
                            name: 'viz_id',
                            allowBlank: false
                        },
                        {
                            xtype: 'textfield',
                            fieldLabel: 'Cue Sheet',
                            name: 'cuesheet_id',
                            allowBlank: false
                        }
                    ]
                },
                {
                    xtype: 'fieldset',
                    title: 'Field Identifiers',
                    layout: 'column',
                    defaults: {
                        labelWidth: 160,
                        labelAlign: 'right'
                    },
                    items: [
                        {
                            xtype: 'textfield',
                            fieldLabel: 'Duration',
                            name: 'duration_field',
                            allowBlank: false
                        },
                        {
                            xtype: 'textfield',
                            fieldLabel: 'Info',
                            name: 'info_field',
                            allowBlank: false
                        },
                        {
                            xtype: 'textfield',
                            fieldLabel: 'Modified',
                            name: 'modified_field',
                            allowBlank: false
                        },
                        {
                            xtype: 'textfield',
                            fieldLabel: 'Music',
                            name: 'music_field',
                            allowBlank: false
                        },
                        {
                            xtype: 'textfield',
                            fieldLabel: 'Start Time',
                            name: 'start_time_field',
                            allowBlank: false
                        },
                        {
                            xtype: 'textfield',
                            fieldLabel: 'Story ID',
                            name: 'story_id_field',
                            allowBlank: false
                        },
                        {
                            xtype: 'textfield',
                            fieldLabel: 'Subject',
                            name: 'subject_field',
                            allowBlank: false
                        },
                        {
                            xtype: 'textfield',
                            fieldLabel: 'Type',
                            name: 'type_field',
                            allowBlank: false
                        },
                        {
                            xtype: 'textfield',
                            fieldLabel: 'Update',
                            name: 'update_field',
                            allowBlank: false
                        },
                        {
                            xtype: 'textfield',
                            fieldLabel: 'Upmix',
                            name: 'upmix_field',
                            allowBlank: false
                        },
                        {
                            xtype: 'textfield',
                            fieldLabel: 'Video ID',
                            name: 'video_id_field',
                            allowBlank: false
                        }
                    ]
                },
                {
                    xtype: 'fieldset',
                    title: 'Script Formatting',
                    layout: 'column',
                    defaults: {
                        labelWidth: 160,
                        labelAlign: 'right'
                    },
                    items: [
                        {
                            xtype: 'checkbox',
                            fieldLabel: 'Retain Formatting Tags',
                            id: 'script_format_id',
                            checkboxName: 'script_format'
                        }
                    ]
                }
            ]
        }

        function setupbindings() {
            // inews bindings
            $('input[name="inws_ws_srvr"]').attr('data-bind', 'textInput: inws_ws_srvr');
            $('input[name="inws_ws_port"]').attr('data-bind', 'value: inws_ws_port');
            $('input[name="inws_server"]').attr('data-bind', 'value: inws_server');
            $('input[name="inws_login"]').attr('data-bind', 'value: inws_login');
            $('input[name="inws_pwd"]').attr('data-bind', 'value: inws_pwd');
            
            // interplay bindings
            $('input[name="iplay_ws_srvr"]').attr('data-bind', 'value: iplay_ws_srvr');
            $('input[name="iplay_ws_port"]').attr('data-bind', 'value: iplay_ws_port');
            $('input[name="iplay_workgroup"]').attr('data-bind', 'value: iplay_workgroup');
            $('input[name="iplay_login"]').attr('data-bind', 'value: iplay_login');
            $('input[name="iplay_pwd"]').attr('data-bind', 'value: iplay_pwd');
            
            // onc ftp bindings
            $('input[name="onc_ftp_srvr"]').attr('data-bind', 'value: onc_ftp_srvr');
            $('input[name="onc_ftp_port"]').attr('data-bind', 'value: onc_ftp_port');
            $('input[name="onc_ftp_login"]').attr('data-bind', 'value: onc_ftp_login');
            $('input[name="onc_ftp_pwd"]').attr('data-bind', 'value: onc_ftp_pwd');
            $('input[name="onc_ftp_path"]').attr('data-bind', 'value: onc_ftp_path');

            // mds ftp bindings
            $('input[name="mds_ftp_srvr"]').attr('data-bind', 'value: mds_ftp_srvr');
            $('input[name="mds_ftp_port"]').attr('data-bind', 'value: mds_ftp_port');
            $('input[name="mds_ftp_login"]').attr('data-bind', 'value: mds_ftp_login');
            $('input[name="mds_ftp_pwd"]').attr('data-bind', 'value: mds_ftp_pwd');
            $('input[name="mds_ftp_path"]').attr('data-bind', 'value: mds_ftp_path');

            // authorisation binding
            $('input[name="obs_export_role"]').attr('data-bind', 'value: obs_export_role');
            $('input[name="obs_cuesheet_role"]').attr('data-bind', 'value: obs_cuesheet_role');

            // definitions binding
            $('input[name="obs_channel_id"]').attr('data-bind', 'value: obs_channel_id');
            $('input[name="title_id"]').attr('data-bind', 'value: title_id');
            $('input[name="date_id"]').attr('data-bind', 'value: date_id');
            $('input[name="day_id"]').attr('data-bind', 'value: day_id');
            $('input[name="viz_id"]').attr('data-bind', 'value: viz_id');
            $('input[name="cuesheet_id"]').attr('data-bind', 'value: cuesheet_id');

            // field identifier bindings
            $('input[name="duration_field"]').attr('data-bind', 'value: duration_field');
            $('input[name="info_field"]').attr('data-bind', 'value: info_field');
            $('input[name="modified_field"]').attr('data-bind', 'value: modified_field');
            $('input[name="music_field"]').attr('data-bind', 'value: music_field');
            $('input[name="start_time_field"]').attr('data-bind', 'value: start_time_field');
            $('input[name="story_id_field"]').attr('data-bind', 'value: story_id_field');
            $('input[name="subject_field"]').attr('data-bind', 'value: subject_field');
            $('input[name="type_field"]').attr('data-bind', 'value: type_field');
            $('input[name="update_field"]').attr('data-bind', 'value: update_field');
            $('input[name="upmix_field"]').attr('data-bind', 'value: upmix_field');
            $('input[name="video_id_field"]').attr('data-bind', 'value: video_id_field');

            //$('input[name="script_format_id-inputEl"]').attr('data-bind', 'checked: script_format');

            var i = $('#script_format_id-inputEl');
            i.attr('type', 'checkbox');
            i.attr('data-bind', 'checked: script_format');

            //var btn = Ext4.getCmp('script_format_id-inputEl');
            //var el = btn.getEl();
            //el.set({"data-bind": 'checked: script_format'});

                 try {
                    var elem = panel.getEl();
                    ko.cleanNode(elem.dom);
                    ko.applyBindings(model, elem.dom);
                    isbound = true;
                }
                catch (msg) {
                    AV.Utilities.showErrorMessage(msg.message);
                }
        }

        function savesettings() {
            $.ajax("/api/obsdetails/", {
                method: "POST",
                contentType: "application/json",
                data: ko.toJSON(model),
                dataType: "text"
            })
                .done (function(res)
            {
                if (null != res.responseText && res.responseText.indexOf("Error") >= 0)
                {
                    // save settings failed
                    AV.Utilities.showErrorMessage(res.responseText);
                }
        })
                .fail(function(res){
                    if (null != res.responseText) {
                        AV.Utilities.showErrorMessage(res.responseText);
                    }
                    return false;
                })
        }

        function setvalues() {
            $.ajax("/api/obsdetails/", {
                method: "GET",
                dataType: "json"
            })
                .done(function (res) {
                    if (res == undefined)
                    {
                        AV.Utilities.showErrorMessage("Problem reading settings");
                    }
                    else {
                        model.inws_ws_srvr(res.inws_ws_srvr);
                        model.inws_ws_port(res.inws_ws_port);
                        model.inws_server(res.inws_server);
                        model.inws_login(res.inws_login);
                        model.inws_pwd(res.inws_pwd);

                        model.iplay_ws_srvr(res.iplay_ws_srvr);
                        model.iplay_ws_port(res.iplay_ws_port);
                        model.iplay_workgroup(res.iplay_workgroup);
                        model.iplay_login(res.iplay_login);
                        model.iplay_pwd(res.iplay_pwd);

                        model.onc_ftp_srvr(res.onc_ftp_srvr);
                        model.onc_ftp_port(res.onc_ftp_port);
                        model.onc_ftp_login(res.onc_ftp_login);
                        model.onc_ftp_pwd(res.onc_ftp_pwd);
                        model.onc_ftp_path(res.onc_ftp_path);

                        model.mds_ftp_srvr(res.mds_ftp_srvr);
                        model.mds_ftp_port(res.mds_ftp_port);
                        model.mds_ftp_login(res.mds_ftp_login);
                        model.mds_ftp_pwd(res.mds_ftp_pwd);
                        model.mds_ftp_path(res.mds_ftp_path);

                        model.obs_export_role(res.obs_export_role);
                        model.obs_cuesheet_role(res.obs_cuesheet_role);

                        model.obs_channel_id(res.obs_channel_id);
                        model.title_id(res.title_id);
                        model.date_id(res.date_id);
                        model.day_id(res.day_id);
                        model.viz_id(res.viz_id);
                        model.cuesheet_id(res.cuesheet_id);

                        model.duration_field(res.duration_field);
                        model.info_field(res.info_field);
                        model.modified_field(res.modified_field);
                        model.music_field(res.music_field);
                        model.start_time_field(res.start_time_field);
                        model.story_id_field(res.story_id_field);
                        model.subject_field(res.subject_field);
                        model.type_field(res.type_field);
                        model.update_field(res.update_field);
                        model.upmix_field(res.upmix_field);
                        model.video_id_field(res.video_id_field);

                        model.script_format(res.script_format);
                    }
                    return true;
                }
            )
                .fail(function(res){
                    AV.Utilities.showErrorMessage("Problem reading settings");
                    return false;
                })
        }

        function test_inews()
        {
             AV.messages.WaitBox.show({title: "Checking iNEWS Connection",
                content: "Please wait while the iNEWS connection is checked",
                isDelayed: true
            });

            $.ajax("/api/obsdetails/inews/", {
                method: "GET",
                dataType: "text"
            })
                .done(function (res) {
                    AV.messages.WaitBox.hide();
                    AV.Utilities.showInfoMessage(res, "Test Result");
                })
                .fail(function(res){
                    AV.messages.WaitBox.hide();
                    AV.Utilities.showErrorMessage("Problem performing test");
                    return false;
                })


        }

        function test_interplay()
        {
            AV.messages.WaitBox.show({title: "Checking Interplay Connection",
                content: "Please wait while the Interplay connection is checked",
                isDelayed: true
            });

            $.ajax("/api/obsdetails/interplay/", {
                method: "GET",
                dataType: "text"
            })
                .done(function (res) {
                    AV.messages.WaitBox.hide();
                    AV.Utilities.showInfoMessage(res, "Test Result");
                })
                .fail(function(res){
                    AV.messages.WaitBox.hide();
                    AV.Utilities.showErrorMessage("Problem performing test");
                    return false;
                })
        }

        function test_onc_ftp()
        {
            AV.messages.WaitBox.show({title: "Checking ONC FTP Connection",
                content: "Please wait while the ONC FTP Connection is checked",
                isDelayed: true
            });

            $.ajax("/api/obsdetails/onc/", {
                method: "GET",
                dataType: "text"
            })
                .done(function (res) {
                    AV.messages.WaitBox.hide();
                    AV.Utilities.showInfoMessage(res, "Test Result");
                })
                .fail(function(res){
                    AV.messages.WaitBox.hide();
                    AV.Utilities.showErrorMessage("Problem performing test");
                    return false;
                })

        }

        function test_mds_ftp()
        {
            AV.messages.WaitBox.show({title: "Checking MDS FTP Connection",
                content: "Please wait while the MDS FTP Connection is checked",
                isDelayed: true
            });

            $.ajax("/api/obsdetails/mds/", {
                method: "GET",
                dataType: "text"
            })
                .done(function (res) {
                    AV.messages.WaitBox.hide();
                    AV.Utilities.showInfoMessage(res, "Test Result");
                })
                .fail(function(res){
                    AV.messages.WaitBox.hide();
                    AV.Utilities.showErrorMessage("Problem performing test");
                    return false;
                })
        }

    });
}(AV, AV.ko))
