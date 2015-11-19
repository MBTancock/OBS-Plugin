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
            minWidth: 400,
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
                                labelWidth: 160,
                                labelAlign: 'right'
                            },
                            items: [
                                {
                                    xtype: 'textfield',
                                    name: 'inws_ws_srvr',
                                    fieldLabel: GENSET.msg("obs.settings.inews.wshost"),
                                    allowBlank: false
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.inews.port"),
                                    name: 'inws_ws_port',
                                    inputType: 'numberfield',
                                    width: 200,
                                    allowBlank: false
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.inews.inws"),
                                    name: 'inws_server',
                                    allowBlank: false
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.inews.login"),
                                    name: 'inws_login',
                                    allowBlank: false
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.inews.password"),
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
                            defaults: {
                                labelWidth: 160,
                                labelAlign: 'right'
                            },
                            items: [
                                {
                                    xtype: 'textfield',
                                    name: 'iplay_ws_srvr',
                                    fieldLabel: GENSET.msg("obs.settings.interplay.wshost"),
                                    allowBlank: false
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.interplay.port"),
                                    name: 'iplay_ws_port',
                                    inputType: 'numberfield',
                                    width: 200,
                                    allowBlank: false
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.interplay.workgroup"),
                                    name: 'iplay_workgroup',
                                    allowBlank: false
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.interplay.login"),
                                    name: 'iplay_login',
                                    allowBlank: false
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.interplay.password"),
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
                            defaults: {
                                labelWidth: 160,
                                labelAlign: 'right'
                            },
                            items: [
                                {
                                    xtype: 'textfield',
                                    name: 'onc_ftp_srvr',
                                    fieldLabel: GENSET.msg("obs.settings.onc.ftphost"),
                                    allowBlank: false
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.onc.port"),
                                    name: 'onc_ftp_port',
                                    inputType: 'numberfield',
                                    width: 200,
                                    allowBlank: false
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.onc.path"),
                                    name: 'onc_ftp_path',
                                    allowBlank: false
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.onc.login"),
                                    name: 'onc_ftp_login',
                                    allowBlank: false
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.onc.password"),
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
                        },
                        {
                            xtype: 'fieldset',
                            title: GENSET.msg("obs.settings.mds.title"),
                            layout: 'column',
                            defaults: {
                                labelWidth: 160,
                                labelAlign: 'right'
                            },
                            items: [
                                {
                                    xtype: 'textfield',
                                    name: 'mds_ftp_srvr',
                                    fieldLabel: GENSET.msg("obs.settings.mds.ftphost"),
                                    allowBlank: false
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.mds.port"),
                                    name: 'mds_ftp_port',
                                    inputType: 'numberfield',
                                    width: 200,
                                    allowBlank: false
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.mds.path"),
                                    name: 'mds_ftp_path',
                                    allowBlank: false
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.mds.login"),
                                    name: 'mds_ftp_login',
                                    allowBlank: false
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.mds.password"),
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
                        },
                        {
                            xtype: 'fieldset',
                            title: GENSET.msg("obs.settings.authorisation.title"),
                            layout: 'column',
                            defaults: {
                                labelWidth: 160,
                                labelAlign: 'right'
                            },
                            items: [
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.authorisation.rundown"),
                                    name: 'obs_export_role',
                                    allowBlank: false
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.authorisation.cuesheet"),
                                    name: 'obs_cuesheet_role',
                                    allowBlank: false
                                }
                            ]
                        },
                        {
                            xtype: 'fieldset',
                            title: GENSET.msg("obs.settings.definitions.header"),
                            layout: 'column',
                            defaults: {
                                labelWidth: 160,
                                labelAlign: 'right'
                            },
                            items: [
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.definitions.id"),
                                    name: 'obs_channel_id',
                                    allowBlank: false
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.definitions.title"),
                                    name: 'title_id',
                                    allowBlank: false
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.definitions.date"),
                                    name: 'date_id',
                                    allowBlank: false
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.definitions.day"),
                                    name: 'day_id',
                                    allowBlank: false
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.definitions.viz"),
                                    name: 'viz_id',
                                    allowBlank: false
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.definitions.cuesheet"),
                                    name: 'cuesheet_id',
                                    allowBlank: false
                                }
                            ]
                        },
                        {
                            xtype: 'fieldset',
                            title: GENSET.msg("obs.settings.fields.title"),
                            layout: 'column',
                            defaults: {
                                labelWidth: 160,
                                labelAlign: 'right'
                            },
                            items: [
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.fields.duration"),
                                    name: 'duration_field',
                                    allowBlank: false
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.fields.info"),
                                    name: 'info_field',
                                    allowBlank: false
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.fields.modified"),
                                    name: 'modified_field',
                                    allowBlank: false
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.fields.music"),
                                    name: 'music_field',
                                    allowBlank: false
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.fields.starttime"),
                                    name: 'start_time_field',
                                    allowBlank: false
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.fields.storyid"),
                                    name: 'story_id_field',
                                    allowBlank: false
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.fields.subject"),
                                    name: 'subject_field',
                                    allowBlank: false
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.fields.type"),
                                    name: 'type_field',
                                    allowBlank: false
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.fields.update"),
                                    name: 'update_field',
                                    allowBlank: false
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.fields.upmix"),
                                    name: 'upmix_field',
                                    allowBlank: false
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: GENSET.msg("obs.settings.fields.videoid"),
                                    name: 'video_id_field',
                                    allowBlank: false
                                }
                            ]
                        },
                        {
                            xtype: 'fieldset',
                            title: GENSET.msg("obs.settings.formatting.title"),
                            layout: 'column',
                            defaults: {
                                labelWidth: 160,
                                labelAlign: 'right'
                            },
                            items: [
                                {
                                    xtype: 'checkbox',
                                    fieldLabel: GENSET.msg("obs.settings.formatting.retaintags"),
                                    id: 'script_format_id',
                                    name: 'script_format_loc',
                                    checked: true,
                                    uncheckedValue: "",
                                    cls: "settings-checkbox",
                                    height: 20
                                }
                            ]
                        }
                    ]
                }
            ]
        }
    ]
});