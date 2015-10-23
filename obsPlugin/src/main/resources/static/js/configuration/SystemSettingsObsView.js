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
                    var server = model.iplay_ws_srvr();
                    savesettings();
                    this.isFormDirty = false;
                    callback(true);
                } else {
                    // ensure that API will be notified of something went wrong
                    callback(false);
                }
            },

            // place your form reverting logic here
            revert: function (callback) {
                callback(setvalues());
                this.isFormDirty = false;
                this.setDirty(this.isFormDirty);
            }

        });

        function setupfields() {
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
                            fieldLabel: 'Name',
                            name: 'name_id',
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
                            name: 'duration_field',
                            fieldLabel: 'Duration',
                            allowBlank: false
                        },
                        {
                            xtype: 'textfield',
                            fieldLabel: 'VideoID',
                            name: 'video_id_field',
                            allowBlank: false
                        },
                        {
                            xtype: 'textfield',
                            fieldLabel: 'Coverage Start',
                            name: 'coverage_start_field',
                            allowBlank: false
                        },
                        {
                            xtype: 'textfield',
                            fieldLabel: 'Coverage End',
                            name: 'coverage_end_field',
                            allowBlank: false
                        }
                    ]
                }
            ]
        }

        function setupbindings() {
            // inews bindings
            $('input[name="inws_ws_srvr"]').attr('data-bind', 'textInput: inws_ws_srvr');
            $('input[name="inws_ws_port"]').attr('data-bind', 'value: inws_ws_port');
            $('input[name="inws_server"]').attr('data-bind', 'textInput: inws_server');
            $('input[name="inws_login"]').attr('data-bind', 'textInput: inws_login');
            $('input[name="inws_pwd"]').attr('data-bind', 'textInput: inws_pwd');
            
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

            // definitions binding
            $('input[name="obs_channel_id"]').attr('data-bind', 'value: obs_channel_id');
            $('input[name="name_id"]').attr('data-bind', 'value: name_id');
            $('input[name="date_id"]').attr('data-bind', 'value: date_id');
            $('input[name="day_id"]').attr('data-bind', 'value: day_id');

            // field identifier bindings
            $('input[name="duration_field"]').attr('data-bind', 'value: duration_field');
            $('input[name="video_id_field"]').attr('data-bind', 'value: video_id_field');
            $('input[name="coverage_start_field"]').attr('data-bind', 'value: coverage_start_field');
            $('input[name="coverage_end_field"]').attr('data-bind', 'value: coverage_end_field');

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

        })
                .fail(function(res){
                    AV.Utilities.showErrorMessage(res.responseText);
                    return false;
                })
        }

        function setvalues() {
            $.ajax("/api/obsdetails/", {
                method: "GET",
                dataType: "json"
            })
                .done(function (res) {
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

                    model.obs_channel_id(res.obs_channel_id);
                    model.name_id(res.name_id);
                    model.date_id(res.date_id);
                    model.day_id(res.day_id);

                    model.duration_field(res.duration_field);
                    model.video_id_field(res.video_id_field);
                    model.coverage_end_field(res.coverage_end_field);
                    model.coverage_start_field(res.coverage_start_field);
                    return true;
                }
            )
                .fail(function(res){
                    AV.Utilities.showErrorMessage("Problem reading settings");
                    return false;
                })
        }

    });
}(AV, AV.ko))
