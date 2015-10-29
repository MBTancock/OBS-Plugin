(function (AV, ko) {
    var ExportConfiguration,

        /**
         * List of properties that should be persisted
         * @type {string[]}
         */
        persistentKeys = [
            "inws_ws_srvr",
            "inws_ws_port",
            "inws_server",
            "inws_login",
            "inws_pwd",
            "iplay_ws_srvr",
            "iplay_ws_port",
            "iplay_workgroup",
            "iplay_login",
            "iplay_pwd",
            "onc_ftp_srvr",
            "onc_ftp_port",
            "onc_ftp_login",
            "onc_ftp_pwd",
            "onc_ftp_path",
            "mds_ftp_srvr",
            "mds_ftp_port",
            "mds_ftp_login",
            "mds_ftp_pwd",
            "mds_ftp_path",
            "obs_export_role",
            "obs_channel_id",
            "title_id",
            "date_id",
            "day_id",
            "viz_id",
            "duration_field",
            "info_field",
            "modified_field",
            "rundown_field",
            "runup_field",
            "start_time_field",
            "story_id_field",
            "subject_field",
            "type_field",
            "update_field",
            "upmix_field",
            "video_id_field"
        ];
        
        AV.ns("AV.obsPlugin.datamodel");

    /**
     * @name AV.obsPlugin.datamodel.ExportData
     * @class
     * @param {Object} data Hash of properties
     * @param {String} data.interplayWebServicesServerName
     * @param {String} data.interplayWebServicesPort
     * @constructor
     */
        ExportConfiguration = function (data) {
                this.inws_ws_srvr = ko.observable("");
                this.inws_ws_port = ko.observable(8080);
                this.inws_server = ko.observable("");
                this.inws_login = ko.observable("");
                this.inws_pwd = ko.observable("");
                this.iplay_ws_srvr = ko.observable("");
                this.iplay_ws_port = ko.observable(8080);
                this.iplay_workgroup = ko.observable("");
                this.iplay_login = ko.observable("");
                this.iplay_pwd = ko.observable("");
                this.onc_ftp_srvr = ko.observable("");
                this.onc_ftp_port = ko.observable(21);
                this.onc_ftp_login = ko.observable("");
                this.onc_ftp_pwd = ko.observable("");
                this.onc_ftp_path = ko.observable("");
                this.mds_ftp_srvr = ko.observable("");
                this.mds_ftp_port = ko.observable(21);
                this.mds_ftp_login = ko.observable("");
                this.mds_ftp_pwd = ko.observable("");
                this.mds_ftp_path = ko.observable("");
                this.obs_export_role = ko.observable("");
                this.obs_channel_id = ko.observable("");
                this.title_id = ko.observable("");
                this.date_id = ko.observable("");
                this.day_id = ko.observable("");
                this.viz_id = ko.observable("");
                this.duration_field = ko.observable("");
                this.info_field = ko.observable("");
                this.modified_field = ko.observable("");
                this.rundown_field = ko.observable("");
                this.runup_field = ko.observable("");
                this.start_time_field = ko.observable("");
                this.story_id_field = ko.observable("");
                this.subject_field = ko.observable("");
                this.type_field = ko.observable("");
                this.update_field = ko.observable("");
                this.upmix_field = ko.observable("");
                this.video_id_field = ko.observable("");
            if (data) {
                this.inws_ws_srvr(data.inws_ws_srvr);
                this.inws_ws_port(data.inws_ws_port);
                this.inws_server(data.inws_server);
                this.inws_login(data.inws_login);
                this.inws_pwd(data.inws_pwd);
                this.iplay_ws_srvr(data.iplay_ws_srvr);
                this.iplay_ws_port(data.iplay_ws_port);
                this.iplay_workgroup(data.iplay_workgroup);
                this.iplay_login(data.iplay_login);
                this.iplay_pwd(data.iplay_pwd);
                this.onc_ftp_srvr(data.onc_ftp_srvr);
                this.onc_ftp_port(data.onc_ftp_port);
                this.onc_ftp_login(data.onc_ftp_login);
                this.onc_ftp_pwd(data.onc_ftp_pwd);
                this.onc_ftp_path(data.onc_ftp_path);
                this.mds_ftp_srvr(data.mds_ftp_srvr);
                this.mds_ftp_port(data.mds_ftp_port);
                this.mds_ftp_login(data.mds_ftp_login);
                this.mds_ftp_pwd(data.mds_ftp_pwd);
                this.mds_ftp_path(data.mds_ftp_path);
                this.obs_export_role(data.obs_export_role);
                this.obs_channel_id(data.obs_channel_id);
                this.title_id(data.title_id);
                this.date_id(data.date_id);
                this.day_id(data.day_id);
                this.viz_id(data.viz_id);
                this.update_field = data.update_field;
                this.modified_field = data.modified_field;
                this.start_time_field(data.start_time_field);
                this.duration_field(data.duration_field);
                this.type_field(data.type_field);
                this.subject_field(data.subject_field);
                this.info_field(data.info_field);
                this.video_id_field(data.video_id_field);
                this.story_id_field(data.story_id_field);
                this.upmix_field(data.upmix_field);
                this.runup_field(data.runup_field);
                this.rundown_field(data.rundown_field);
            }
        };


    /**
     * Returns hash that contains only persistent properties
     * @return {Object}
     */
        ExportConfiguration.prototype.toJS = function () {
            var json = ko.toJS(this);

                return Object.keys(json).filter(function (i) {
                return persistentKeys.indexOf(i) !== -1;
            }).reduce(function (obj, k) {
                obj[k] = json[k];
                return obj;
            }, {});
        };

        ExportConfiguration.prototype.toJSON = function () {
            return this.toJS();
        };

    AV.obsPlugin.datamodel.ExportConfiguration = ExportConfiguration;

}(AV, AV.ko));