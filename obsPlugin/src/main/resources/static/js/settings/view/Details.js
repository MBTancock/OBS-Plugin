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
                                    tip: GENSET.msg("obs.settings.tips.wshost"),
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
                                    tip: GENSET.msg("obs.settings.tips.wsport"),
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
                                    tip: GENSET.msg("obs.settings.tips.inws"),
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
                                    tip: GENSET.msg("obs.settings.tips.login"),
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
                                    tip: GENSET.msg("obs.settings.tips.pwd"),
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
                                    tip: GENSET.msg("obs.settings.tips.testinws"),
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
                                    tip: GENSET.msg("obs.settings.tips.wshost"),
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
                                    tip: GENSET.msg("obs.settings.tips.wsport"),
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
                                    tip: GENSET.msg("obs.settings.tips.wkgrp"),
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
                                    tip: GENSET.msg("obs.settings.tips.login"),
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
                                    tip: GENSET.msg("obs.settings.tips.pwd"),
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
                                    tip: GENSET.msg("obs.settings.tips.testiplay"),
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
                                    tip: GENSET.msg("obs.settings.tips.mdsid"),
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
                                    tip: GENSET.msg("obs.settings.tips.checkfields"),
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
                                    tip: GENSET.msg("obs.settings.tips.checkgraphics"),
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
                                    tip: GENSET.msg("obs.settings.tips.retaintags"),
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
                                            tip: GENSET.msg("obs.settings.tips.ftphost"),
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
                                            tip: GENSET.msg("obs.settings.tips.ftpport"),
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
                                            tip: GENSET.msg("obs.settings.tips.ftppath"),
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
                                            tip: GENSET.msg("obs.settings.tips.login"),
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
                                            tip: GENSET.msg("obs.settings.tips.pwd"),
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
                                            tip: GENSET.msg("obs.settings.tips.testmds"),
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
                                    tip: GENSET.msg("obs.settings.tips.oncid"),
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
                                    tip: GENSET.msg("obs.settings.tips.checkfields"),
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
                                    tip: GENSET.msg("obs.settings.tips.checkgraphics"),
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
                                    tip: GENSET.msg("obs.settings.tips.retaintags"),
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
                                            tip: GENSET.msg("obs.settings.tips.ftphost"),
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
                                            tip: GENSET.msg("obs.settings.tips.ftpport"),
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
                                            tip: GENSET.msg("obs.settings.tips.ftppath"),
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
                                            tip: GENSET.msg("obs.settings.tips.login"),
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
                                            tip: GENSET.msg("obs.settings.tips.pwd"),
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
                                            tip: GENSET.msg("obs.settings.tips.testonc"),
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
                                    tip: GENSET.msg("obs.settings.tips.exportrole"),
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
                                    tip: GENSET.msg("obs.settings.tips.cuesheetrole"),
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
                                    tip: GENSET.msg("obs.settings.tips.channelid"),
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
                                    tip: GENSET.msg("obs.settings.tips.titleid"),
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
                                    tip: GENSET.msg("obs.settings.tips.dateid"),
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
                                    tip: GENSET.msg("obs.settings.tips.dayid"),
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
                                    tip: GENSET.msg("obs.settings.tips.vizid"),
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
                                    tip: GENSET.msg("obs.settings.tips.cuesheetid"),
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
                                    tip: GENSET.msg("obs.settings.tips.durnfield"),
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
                                    tip: GENSET.msg("obs.settings.tips.infofield"),
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
                                    tip: GENSET.msg("obs.settings.tips.modfield"),
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
                                    tip: GENSET.msg("obs.settings.tips.musicfield"),
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
                                    tip: GENSET.msg("obs.settings.tips.startfield"),
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
                                    tip: GENSET.msg("obs.settings.tips.subjectfield"),
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
                                    tip: GENSET.msg("obs.settings.tips.typefield"),
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
                                    tip: GENSET.msg("obs.settings.tips.updatefield"),
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
                                    tip: GENSET.msg("obs.settings.tips.upmixfield"),
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
                                    tip: GENSET.msg("obs.settings.tips.videoidfield"),
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