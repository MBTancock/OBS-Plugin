/*
 * Copyright Broadcast Media Solutions
 */

var GENSET;

/**
 * Model for general settings
 * @class GENSET.model.ObsSettings
 * @extends Ext.data.Model
 */
Ext4.define("GENSET.model.ObsSettings", {
    extend: "Ext.data.Model",
    fields: [
        {name: "inws_ws_srvr", persist: false},
        {name: "inws_ws_srvr"},
        {name: "inws_ws_port"},
        {name: "inws_server"},
        {name: "inws_login"},
        {name: "inws_pwd"},
        {name: "iplay_ws_srvr"},
        {name: "iplay_ws_port"},
        {name: "iplay_workgroup"},
        {name: "iplay_login"},
        {name: "iplay_pwd"},
        {name: "onc_ftp_srvr"},
        {name: "onc_ftp_port"},
        {name: "onc_ftp_login"},
        {name: "onc_ftp_pwd"},
        {name: "onc_ftp_path"},
        {name: "mds_ftp_srvr"},
        {name: "mds_ftp_port"},
        {name: "mds_ftp_login"},
        {name: "mds_ftp_pwd"},
        {name: "mds_ftp_path"},
        {name: "obs_export_role"},
        {name: "obs_cuesheet_role"},
        {name: "obs_channel_id"},
        {name: "title_id"},
        {name: "date_id"},
        {name: "day_id"},
        {name: "viz_id"},
        {name: "cuesheet_id"},
        {name: "duration_field"},
        {name: "info_field"},
        {name: "modified_field"},
        {name: "music_field"},
        {name: "start_time_field"},
        {name: "story_id_field"},
        {name: "subject_field"},
        {name: "type_field"},
        {name: "update_field"},
        {name: "upmix_field"},
        {name: "video_id_field"},
        {name: "script_format_loc", persist: false,
            /*
             * data from server does not contain "script_format_loc",
             * data from form contains it and should define value of "script_format"
             * */
            convert: function (value, record) {
                var isEnabled = record.get("script_format_loc");
                if (!Ext.isDefined(isEnabled)) {
                    return record.get("script_format") ? "on" : "";
                }
                record.set("script_format", Boolean(value));
                return value;
            }
        },
        {name: "script_format"}

    ],
    validations: [
    ],

    proxy: {
        type: "rest",
        url: "/api/obsdetails",
        headers: {
            "Accept": "application/json"
        },
        writer: "json",
        listeners: {
            exception: function (proxy, response, operation) {
                var errorText = "";
                if (operation && operation.error) {
                    errorText = "Status: " +  operation.error.status+" " + operation.error.statusText;
                }
                if (response && response.responseText) {
                    errorText += response.responseText;
                }
                console.error("[General Settings] Model proxy " +  errorText);
                AV.Utilities.showInfoMessage(GENSET.msg("system.general.exception.text"),
                        GENSET.msg("system.general.exception.title"));
            }
        }
    }
});