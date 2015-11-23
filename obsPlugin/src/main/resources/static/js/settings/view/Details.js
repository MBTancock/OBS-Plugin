/*
 * Copyright Broadcast Media Solutions
 */

var GENSET;

/**
 * View for General Settings Editor
 * @class GENSET.view.Details
 * @extends Ext.pane.Panel
 */
Ext4.define("GENSET.view.ObsDetails", {
    extend: "Ext.panel.Panel",
    alias: "widget.ObsSettingsdetails",
    layout: "fit",
    overflowX: "auto",
    items: [
        {
            xtype: "panel",
            minWidth: 700,
            overflowY: "auto",
            layout: {
                type: "vbox",
                align: "stretch"
            },
            items: [
                {
                    xtype: "form",
                    baseCls: "settings-details-view",
                    bwrapCssClass: "settings-details-bwrap",
                    itemId: "detailsForm",
                    trackResetOnLoad: true,
                    fieldDefaults: {
                        labelAlign: "right",
                        labelWidth: 160,
                        anchor: "100%"
                    },
                    items: [
                        {
                            xtype: 'fieldset',
                            title: GENSET.msg("obs.settings.inews.title"),
                            name: 'inews',
                            layout: 'column',
                            defaults: {
                                labelWidth: 80,
                                width: 200,
                                labelAlign: 'right'
                            },
                            items: [
                                {
                                    xtype: 'textfield',
                                    name: 'inws_ws_srvr',
                                    fieldLabel: GENSET.msg("obs.settings.wshost"),
                                    allowBlank: false,
                                    labelWidth: 120,
                                    tip: 'Hostname or IP Address of the web services server',
                                    listeners: {
                                        render: function (c) {
                                            Ext4.create('Ext.tip.ToolTip', {target: c.getEl(), html: c.tip});
                                        }
                                    }
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.port"),
                                    name: 'inws_ws_port',
                                    inputType: 'numberfield',
                                    labelWidth: 50,
                                    width: 90,
                                    allowBlank: false,
                                    tip: 'http port used by the web services server',
                                    listeners: {
                                        render: function (c) {
                                            Ext4.create('Ext.tip.ToolTip', {target: c.getEl(), html: c.tip});
                                        }
                                    }
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.inews.inws"),
                                    name: 'inws_server',
                                    allowBlank: false,
                                    labelWidth: 100,
                                    width: 200,
                                    tip: 'Hostname or IP Address of the iNEWS server',
                                    listeners: {
                                        render: function (c) {
                                            Ext4.create('Ext.tip.ToolTip', {target: c.getEl(), html: c.tip});
                                        }
                                    }
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.login"),
                                    name: 'inws_login',
                                    allowBlank: false,
                                    labelWidth: 70,
                                    width: 190,
                                    tip: 'Login name',
                                    listeners: {
                                        render: function (c) {
                                            Ext4.create('Ext.tip.ToolTip', {target: c.getEl(), html: c.tip});
                                        }
                                    }
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.password"),
                                    name: 'inws_pwd',
                                    inputType: 'password',
                                    labelWidth: 70,
                                    width: 190,
                                    allowBlank: false,
                                    tip: 'Password',
                                    listeners: {
                                        render: function (c) {
                                            Ext4.create('Ext.tip.ToolTip', {target: c.getEl(), html: c.tip});
                                        }
                                    }
                                },
                                {
                                    xtype: 'button',
                                    editable: false,
                                    text: 'Test',
                                    margin: '1 0 0 20',
                                    width: 70,
                                    tip: 'Tests the iNEWS connection, requires all the data to have been entered and saved',
                                    listeners: {
                                        render: function (c) {
                                            Ext4.create('Ext.tip.ToolTip', {target: c.getEl(), html: c.tip});
                                        }
                                    },
                                    handler: function () {
                                        AV.messages.WaitBox.show({
                                            title: "Checking iNEWS Connection",
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
                                            .fail(function (res) {
                                                AV.messages.WaitBox.hide();
                                                AV.Utilities.showErrorMessage("Problem performing test");
                                            })
                                    }

                                }
                            ]
                        },
                        {
                            xtype: 'fieldset',
                            title: GENSET.msg("obs.settings.interplay.title"),
                            layout: 'column',
                            margin: '10 0 0 0',
                            defaults: {
                                labelWidth: 80,
                                width: 200,
                                labelAlign: 'right'
                            },
                            items: [
                                {
                                    xtype: 'textfield',
                                    name: 'iplay_ws_srvr',
                                    fieldLabel: GENSET.msg("obs.settings.wshost"),
                                    allowBlank: false,
                                    labelWidth: 120,
                                    tip: 'Hostname or IP Address of the web services server',
                                    listeners: {
                                        render: function (c) {
                                            Ext4.create('Ext.tip.ToolTip', {target: c.getEl(), html: c.tip});
                                        }
                                    }
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.port"),
                                    name: 'iplay_ws_port',
                                    inputType: 'numberfield',
                                    labelWidth: 50,
                                    width: 90,
                                    allowBlank: false,
                                    tip: 'http port used by the web services server',
                                    listeners: {
                                        render: function (c) {
                                            Ext4.create('Ext.tip.ToolTip', {target: c.getEl(), html: c.tip});
                                        }
                                    }
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.interplay.workgroup"),
                                    name: 'iplay_workgroup',
                                    allowBlank: false,
                                    labelWidth: 120,
                                    tip: 'Interplay Web Services Workgroup name used identify the Interplay system',
                                    listeners: {
                                        render: function (c) {
                                            Ext4.create('Ext.tip.ToolTip', {target: c.getEl(), html: c.tip});
                                        }
                                    }
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.login"),
                                    name: 'iplay_login',
                                    allowBlank: false,
                                    labelWidth: 70,
                                    width: 190,
                                    tip: 'Login name',
                                    listeners: {
                                        render: function (c) {
                                            Ext4.create('Ext.tip.ToolTip', {target: c.getEl(), html: c.tip});
                                        }
                                    }
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.password"),
                                    name: 'iplay_pwd',
                                    inputType: 'password',
                                    labelWidth: 70,
                                    width: 190,
                                    allowBlank: false,
                                    tip: 'Password',
                                    listeners: {
                                        render: function (c) {
                                            Ext4.create('Ext.tip.ToolTip', {target: c.getEl(), html: c.tip});
                                        }
                                    }
                                },
                                {
                                    xtype: 'button',
                                    editable: false,
                                    text: 'Test',
                                    margin: '1 0 0 20',
                                    width: 70,
                                    tip: 'Tests the Interplay connection, requires all the data to have been entered and saved',
                                    listeners: {
                                        render: function (c) {
                                            Ext4.create('Ext.tip.ToolTip', {target: c.getEl(), html: c.tip});
                                        }
                                    },
                                    handler: function () {
                                        AV.messages.WaitBox.show({
                                            title: "Checking Interplay Connection",
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
                                            .fail(function (res) {
                                                AV.messages.WaitBox.hide();
                                                AV.Utilities.showErrorMessage("Problem performing test");
                                            })
                                    }

                                }
                            ]
                        },
                        {
                            xtype: 'fieldset',
                            title: GENSET.msg("obs.settings.onc.title"),
                            layout: 'column',
                            margin: '10 0 0 0',
                            defaults: {
                                labelWidth: 160,
                                labelAlign: 'right'
                            },
                            items: [
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.prefix"),
                                    name: 'onc_prefix',
                                    width: 240,
                                    allowBlank: false,
                                    tip: 'Initial characters of text to identify ONC rundowns, leave blank to export all rundowns other than those specifically identified as MDS',
                                    listeners: {
                                        render: function (c) {
                                            Ext4.create('Ext.tip.ToolTip', {target: c.getEl(), html: c.tip});
                                        }
                                    },
                                },
                                {
                                    xtype: 'checkbox',
                                    fieldLabel: GENSET.msg("obs.settings.checkfields"),
                                    id: 'onc_verify_fields_id',
                                    name: 'onc_verify_fields_local',
                                    checked: true,
                                    uncheckedValue: "",
                                    cls: "settings-checkbox",
                                    height: 20,
                                    tip: 'Checks that all mandatory fields are correctly populated',
                                    listeners: {
                                        render: function (c) {
                                            Ext4.create('Ext.tip.ToolTip', {
                                                target: c.getEl(),
                                                html: c.tip
                                            });
                                        }
                                    }
                                },
                                {
                                    xtype: 'checkbox',
                                    fieldLabel: GENSET.msg("obs.settings.checkgraphics"),
                                    id: 'onc_check_graphics_id',
                                    name: 'onc_check_graphics_local',
                                    checked: true,
                                    uncheckedValue: "",
                                    cls: "settings-checkbox",
                                    height: 20,
                                    tip: 'Checks for the presence of graphic elements',
                                    listeners: {
                                        render: function (c) {
                                            Ext4.create('Ext.tip.ToolTip', {
                                                target: c.getEl(),
                                                html: c.tip
                                            });
                                        }
                                    }
                                },
                                {
                                    xtype: 'checkbox',
                                    fieldLabel: GENSET.msg("obs.settings.retainformatting"),
                                    id: 'onc_include_tags_id',
                                    name: 'onc_include_tags_local',
                                    checked: true,
                                    uncheckedValue: "",
                                    cls: "settings-checkbox",
                                    height: 20,
                                    tip: 'Retains iNEWS story formatting tags',
                                    listeners: {
                                        render: function (c) {
                                            Ext4.create('Ext.tip.ToolTip', {
                                                target: c.getEl(),
                                                html: c.tip
                                            });
                                        }
                                    }
                                },
                                {
                                    xtype: 'fieldset',
                                    title: GENSET.msg("obs.settings.ftp"),
                                    layout: 'column',
                                    width: '100%',
                                    margin: '10 0 0 0',
                                    defaults: {
                                        labelWidth: 80,
                                        width: 200,
                                        labelAlign: 'right'
                                    },
                                    items: [
                                        {
                                            xtype: 'textfield',
                                            name: 'onc_ftp_srvr',
                                            fieldLabel: GENSET.msg("obs.settings.mds.ftphost"),
                                            allowBlank: false,
                                            tip: 'Hostname or IP Address of the FTP server',
                                            listeners: {
                                                render: function (c) {
                                                    Ext4.create('Ext.tip.ToolTip', {target: c.getEl(), html: c.tip});
                                                }
                                            }
                                        },
                                        {
                                            xtype: 'textfield',
                                            fieldLabel: GENSET.msg("obs.settings.port"),
                                            name: 'onc_ftp_port',
                                            inputType: 'numberfield',
                                            labelWidth: 50,
                                            width: 90,
                                            allowBlank: false,
                                            tip: 'The FTP port',
                                            listeners: {
                                                render: function (c) {
                                                    Ext4.create('Ext.tip.ToolTip', {target: c.getEl(), html: c.tip});
                                                }
                                            }
                                        },
                                        {
                                            xtype: 'textfield',
                                            fieldLabel: GENSET.msg("obs.settings.path"),
                                            name: 'onc_ftp_path',
                                            labelWidth: 50,
                                            width: 160,
                                            allowBlank: false,
                                            tip: 'The path to the FTP directory',
                                            listeners: {
                                                render: function (c) {
                                                    Ext4.create('Ext.tip.ToolTip', {target: c.getEl(), html: c.tip});
                                                }
                                            }
                                        },
                                        {
                                            xtype: 'textfield',
                                            fieldLabel: GENSET.msg("obs.settings.login"),
                                            name: 'onc_ftp_login',
                                            allowBlank: false,
                                            tip: 'Login name',
                                            listeners: {
                                                render: function (c) {
                                                    Ext4.create('Ext.tip.ToolTip', {target: c.getEl(), html: c.tip});
                                                }
                                            }
                                        },
                                        {
                                            xtype: 'textfield',
                                            fieldLabel: GENSET.msg("obs.settings.password"),
                                            name: 'onc_ftp_pwd',
                                            inputType: 'password',
                                            allowBlank: false,
                                            tip: 'Password',
                                            listeners: {
                                                render: function (c) {
                                                    Ext4.create('Ext.tip.ToolTip', {target: c.getEl(), html: c.tip});
                                                }
                                            }
                                        },
                                        {
                                            xtype: 'button',
                                            editable: false,
                                            name: 'onc_test',
                                            text: 'Test',
                                            margin: '1 0 0 20',
                                            width: 70,
                                            tip: 'Tests the ONC FTP connection, requires all the data to have been entered and saved',
                                            listeners: {
                                                render: function (c) {
                                                    Ext4.create('Ext.tip.ToolTip', {target: c.getEl(), html: c.tip});
                                                }
                                            },
                                            handler: function () {
                                                AV.messages.WaitBox.show({
                                                    title: "Checking ONC FTP Connection",
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
                                                    .fail(function (res) {
                                                        AV.messages.WaitBox.hide();
                                                        AV.Utilities.showErrorMessage("Problem performing test");
                                                    })
                                            }
                                        }
                                    ]
                                }

                            ]
                        },
                        {
                            xtype: 'fieldset',
                            title: GENSET.msg("obs.settings.mds.title"),
                            layout: 'column',
                            margin: '10 0 0 0',
                            defaults: {
                                labelWidth: 160,
                                labelAlign: 'right'
                            },
                            items: [
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.prefix"),
                                    name: 'mds_prefix',
                                    width: 240,
                                    allowBlank: false,
                                    tip: 'Initial characters of text to identify MDS rundowns',
                                    listeners: {
                                        render: function (c) {
                                            Ext4.create('Ext.tip.ToolTip', {target: c.getEl(), html: c.tip});
                                        }
                                    }
                                },
                                {
                                    xtype: 'checkbox',
                                    fieldLabel: GENSET.msg("obs.settings.checkfields"),
                                    id: 'mds_verify_fields_id',
                                    name: 'mds_verify_fields_local',
                                    checked: true,
                                    uncheckedValue: "",
                                    cls: "settings-checkbox",
                                    height: 20,
                                    tip: 'Checks that all mandatory fields are correctly populated',
                                    listeners: {
                                        render: function (c) {
                                            Ext4.create('Ext.tip.ToolTip', {
                                                target: c.getEl(),
                                                html: c.tip
                                            });
                                        }
                                    }
                                },
                                {
                                    xtype: 'checkbox',
                                    fieldLabel: GENSET.msg("obs.settings.checkgraphics"),
                                    id: 'mds_check_graphics_id',
                                    name: 'mds_check_graphics_local',
                                    checked: true,
                                    uncheckedValue: "",
                                    cls: "settings-checkbox",
                                    height: 20,
                                    tip: 'Checks for the presence of graphic elements',
                                    listeners: {
                                        render: function (c) {
                                            Ext4.create('Ext.tip.ToolTip', {
                                                target: c.getEl(),
                                                html: c.tip
                                            });
                                        }
                                    }
                                },
                                {
                                    xtype: 'checkbox',
                                    fieldLabel: GENSET.msg("obs.settings.retainformatting"),
                                    id: 'mds_include_tags_id',
                                    name: 'mds_include_tags_local',
                                    checked: true,
                                    uncheckedValue: "",
                                    cls: "settings-checkbox",
                                    height: 20,
                                    tip: 'Retains iNEWS story formatting tags',
                                    listeners: {
                                        render: function (c) {
                                            Ext4.create('Ext.tip.ToolTip', {
                                                target: c.getEl(),
                                                html: c.tip
                                            });
                                        }
                                    }
                                },
                                {
                                    xtype: 'fieldset',
                                    title: GENSET.msg("obs.settings.ftp"),
                                    layout: 'column',
                                    width: '100%',
                                    margin: '10 0 0 0',
                                    defaults: {
                                        labelWidth: 80,
                                        width: 200,
                                        labelAlign: 'right'
                                    },
                                    items: [
                                        {
                                            xtype: 'textfield',
                                            name: 'mds_ftp_srvr',
                                            fieldLabel: GENSET.msg("obs.settings.mds.ftphost"),
                                            allowBlank: false,
                                            tip: 'Hostname or IP Address of the FTP server',
                                            listeners: {
                                                render: function (c) {
                                                    Ext4.create('Ext.tip.ToolTip', {target: c.getEl(), html: c.tip});
                                                }
                                            }
                                        },
                                        {
                                            xtype: 'textfield',
                                            fieldLabel: GENSET.msg("obs.settings.port"),
                                            name: 'mds_ftp_port',
                                            inputType: 'numberfield',
                                            labelWidth: 50,
                                            width: 90,
                                            allowBlank: false,
                                            tip: 'The FTP port',
                                            listeners: {
                                                render: function (c) {
                                                    Ext4.create('Ext.tip.ToolTip', {target: c.getEl(), html: c.tip});
                                                }
                                            }
                                        },
                                        {
                                            xtype: 'textfield',
                                            fieldLabel: GENSET.msg("obs.settings.path"),
                                            name: 'mds_ftp_path',
                                            labelWidth: 50,
                                            width: 160,
                                            allowBlank: false,
                                            tip: 'The path to the FTP directory',
                                            listeners: {
                                                render: function (c) {
                                                    Ext4.create('Ext.tip.ToolTip', {target: c.getEl(), html: c.tip});
                                                }
                                            }
                                        },
                                        {
                                            xtype: 'textfield',
                                            fieldLabel: GENSET.msg("obs.settings.login"),
                                            name: 'mds_ftp_login',
                                            allowBlank: false,
                                            tip: 'Login name',
                                            listeners: {
                                                render: function (c) {
                                                    Ext4.create('Ext.tip.ToolTip', {target: c.getEl(), html: c.tip});
                                                }
                                            }
                                        },
                                        {
                                            xtype: 'textfield',
                                            fieldLabel: GENSET.msg("obs.settings.password"),
                                            name: 'mds_ftp_pwd',
                                            inputType: 'password',
                                            allowBlank: false,
                                            tip: 'Password',
                                            listeners: {
                                                render: function (c) {
                                                    Ext4.create('Ext.tip.ToolTip', {target: c.getEl(), html: c.tip});
                                                }
                                            }
                                        },
                                        {
                                            xtype: 'button',
                                            editable: false,
                                            name: 'mds_test',
                                            text: 'Test',
                                            margin: '1 0 0 20',
                                            width: 70,
                                            tip: 'Tests the MDS FTP connection, requires all the data to have been entered and saved',
                                            listeners: {
                                                render: function (c) {
                                                    Ext4.create('Ext.tip.ToolTip', {target: c.getEl(), html: c.tip});
                                                }
                                            },
                                            handler: function () {
                                                AV.messages.WaitBox.show({
                                                    title: "Checking MDS FTP Connection",
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
                                                    .fail(function (res) {
                                                        AV.messages.WaitBox.hide();
                                                        AV.Utilities.showErrorMessage("Problem performing test");
                                                    })
                                            }
                                        }
                                    ]
                                }

                            ]
                        },
                        {
                            xtype: 'fieldset',
                            title: GENSET.msg("obs.settings.authorisation.title"),
                            layout: 'column',
                            margin: '10 0 0 0',
                            defaults: {
                                labelWidth: 160,
                                labelAlign: 'right'
                            },
                            items: [
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.authorisation.rundown"),
                                    name: 'obs_export_role',
                                    allowBlank: false,
                                    tip: 'The MediaCentral|UX role which permits rundown exports',
                                    listeners: {
                                        render: function (c) {
                                            Ext4.create('Ext.tip.ToolTip', {target: c.getEl(), html: c.tip});
                                        }
                                    }
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.authorisation.cuesheet"),
                                    name: 'obs_cuesheet_role',
                                    allowBlank: false,
                                    tip: 'The MediaCentral|UX role which permits cue sheet publishing',
                                    listeners: {
                                        render: function (c) {
                                            Ext4.create('Ext.tip.ToolTip', {target: c.getEl(), html: c.tip});
                                        }
                                    }
                                }
                            ]
                        },
                        {
                            xtype: 'fieldset',
                            title: GENSET.msg("obs.settings.definitions.header"),
                            layout: 'column',
                            margin: '10 0 0 0',
                            defaults: {
                                labelWidth: 80,
                                width: 200,
                                labelAlign: 'right'
                            },
                            items: [
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.definitions.id"),
                                    name: 'obs_channel_id',
                                    allowBlank: false,
                                    tip: 'Info field value corresponding to the channel identifier',
                                    listeners: {
                                        render: function (c) {
                                            Ext4.create('Ext.tip.ToolTip', {target: c.getEl(), html: c.tip});
                                        }
                                    }
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.definitions.title"),
                                    name: 'title_id',
                                    allowBlank: false,
                                    tip: 'Info field value corresponding to the rundown title',
                                    listeners: {
                                        render: function (c) {
                                            Ext4.create('Ext.tip.ToolTip', {target: c.getEl(), html: c.tip});
                                        }
                                    }
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.definitions.date"),
                                    name: 'date_id',
                                    allowBlank: false,
                                    tip: 'Info field value corresponding to the rundown date',
                                    listeners: {
                                        render: function (c) {
                                            Ext4.create('Ext.tip.ToolTip', {target: c.getEl(), html: c.tip});
                                        }
                                    }
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.definitions.day"),
                                    name: 'day_id',
                                    allowBlank: false,
                                    tip: 'Info field value corresponding to the rundown day',
                                    listeners: {
                                        render: function (c) {
                                            Ext4.create('Ext.tip.ToolTip', {target: c.getEl(), html: c.tip});
                                        }
                                    }
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.definitions.viz"),
                                    name: 'viz_id',
                                    allowBlank: false,
                                    tip: 'Identifies a production cue as referring to a VizRT graphics element',
                                    listeners: {
                                        render: function (c) {
                                            Ext4.create('Ext.tip.ToolTip', {target: c.getEl(), html: c.tip});
                                        }
                                    }
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.definitions.cuesheet"),
                                    name: 'cuesheet_id',
                                    allowBlank: false,
                                    tip: 'Identifies the start of published cue sheet data in the iNEWS story body',
                                    listeners: {
                                        render: function (c) {
                                            Ext4.create('Ext.tip.ToolTip', {target: c.getEl(), html: c.tip});
                                        }
                                    }
                                }
                            ]
                        },
                        {
                            xtype: 'fieldset',
                            title: GENSET.msg("obs.settings.fields.title"),
                            layout: 'column',
                            margin: '10 0 0 0',
                            defaults: {
                                labelWidth: 80,
                                width: 200,
                                labelAlign: 'right'
                            },
                            items: [
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.fields.duration"),
                                    name: 'duration_field',
                                    allowBlank: false,
                                    tip: 'Identifies the form field containing an item\'s duration',
                                    listeners: {
                                        render: function (c) {
                                            Ext4.create('Ext.tip.ToolTip', {target: c.getEl(), html: c.tip});
                                        }
                                    }
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.fields.info"),
                                    name: 'info_field',
                                    allowBlank: false,
                                    tip: 'Identifies the form field containing an item\'s info',
                                    listeners: {
                                        render: function (c) {
                                            Ext4.create('Ext.tip.ToolTip', {target: c.getEl(), html: c.tip});
                                        }
                                    }
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.fields.modified"),
                                    name: 'modified_field',
                                    allowBlank: false,
                                    tip: 'Identifies the form field containing an item\'s modification time',
                                    listeners: {
                                        render: function (c) {
                                            Ext4.create('Ext.tip.ToolTip', {target: c.getEl(), html: c.tip});
                                        }
                                    }
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.fields.music"),
                                    name: 'music_field',
                                    allowBlank: false,
                                    tip: 'Identifies the form field containing an item\'s music details',
                                    listeners: {
                                        render: function (c) {
                                            Ext4.create('Ext.tip.ToolTip', {target: c.getEl(), html: c.tip});
                                        }
                                    }
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.fields.starttime"),
                                    name: 'start_time_field',
                                    allowBlank: false,
                                    tip: 'Identifies the form field containing an item\'s start time',
                                    listeners: {
                                        render: function (c) {
                                            Ext4.create('Ext.tip.ToolTip', {target: c.getEl(), html: c.tip});
                                        }
                                    }
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.fields.storyid"),
                                    name: 'story_id_field',
                                    allowBlank: false,
                                    tip: 'Identifies the form field containing an item\'s story ID',
                                    listeners: {
                                        render: function (c) {
                                            Ext4.create('Ext.tip.ToolTip', {target: c.getEl(), html: c.tip});
                                        }
                                    }
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.fields.subject"),
                                    name: 'subject_field',
                                    allowBlank: false,
                                    tip: 'Identifies the form field containing an item\'s subject',
                                    listeners: {
                                        render: function (c) {
                                            Ext4.create('Ext.tip.ToolTip', {target: c.getEl(), html: c.tip});
                                        }
                                    }
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.fields.type"),
                                    name: 'type_field',
                                    allowBlank: false,
                                    tip: 'Identifies the form field containing an item\'s type',
                                    listeners: {
                                        render: function (c) {
                                            Ext4.create('Ext.tip.ToolTip', {target: c.getEl(), html: c.tip});
                                        }
                                    }
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.fields.update"),
                                    name: 'update_field',
                                    allowBlank: false,
                                    tip: 'Identifies the form field which indicates whether an item has been updated',
                                    listeners: {
                                        render: function (c) {
                                            Ext4.create('Ext.tip.ToolTip', {target: c.getEl(), html: c.tip});
                                        }
                                    }
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.fields.upmix"),
                                    name: 'upmix_field',
                                    allowBlank: false,
                                    tip: 'Identifies the form field containing an item\'s upmix details',
                                    listeners: {
                                        render: function (c) {
                                            Ext4.create('Ext.tip.ToolTip', {target: c.getEl(), html: c.tip});
                                        }
                                    }
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.fields.videoid"),
                                    name: 'video_id_field',
                                    allowBlank: false,
                                    tip: 'Identifies the form field containing an item\'s video ID',
                                    listeners: {
                                        render: function (c) {
                                            Ext4.create('Ext.tip.ToolTip', {target: c.getEl(), html: c.tip});
                                        }
                                    }
                                }
                            ]
                        }
                    ]
                }
            ]
        }
    ]
});