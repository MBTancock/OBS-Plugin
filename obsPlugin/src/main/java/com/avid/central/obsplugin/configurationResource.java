package com.avid.central.obsplugin;

import com.avid.central.obsplugin.Configuration.ExportConfiguration;

import javax.ws.rs.*;

/**
 * Created by Administrator on 16/10/2015.
 */
@Path("/obsdetails")
@Consumes("application/json")
@Produces("application/json")

public class configurationResource {
    ExportConfiguration _configuration;

    public configurationResource()
    {
        // try and read the configuration from disk...
        try
        {
            _configuration = ExportConfiguration.Open("D:/obsconfig.xml");
        }
        catch (Exception ex)
        {
            // failed to open it so create a default version
            _configuration = new ExportConfiguration();
            _configuration.com_ar_field = "v-offtubear";
            _configuration.com_en_field = "v-offtubeen";
            _configuration.com_es_field = "v-offtubesp";
            _configuration.coverage_end_field = "v-covend";
            _configuration.coverage_start_field = "v-covstart";
            _configuration.duration_field = "total-time";
            _configuration.event_feed_field = "v-eventfeed";
            _configuration.info_field = "v-info";

            _configuration.rundown_field = "v-rundown";
            _configuration.runup_field = "v-runup";
            _configuration.start_time_field = "cume-time";
            _configuration.story_id_field = "v-storyid";
            _configuration.subject_field = "title";
            _configuration.type_field = "v-type";
            _configuration.upmix_field = "v-upmix";
            _configuration.video_id_field = "mos-title";

            _configuration.date_id = "Date";
            _configuration.day_id = "Day";
            _configuration.name_id = "Name";
            _configuration.obs_channel_id = "OBSChannelName";

            _configuration.onc_ftp_srvr = "wysdomserver";
            _configuration.onc_ftp_port = 21;
            _configuration.onc_ftp_login = "administrator";
            _configuration.onc_ftp_pwd = "is-admin";
            _configuration.onc_ftp_path = "nas";

            _configuration.mds_ftp_srvr = "wysdomserver";
            _configuration.mds_ftp_port = 21;
            _configuration.mds_ftp_login = "administrator";
            _configuration.mds_ftp_pwd = "is-admin";
            _configuration.mds_ftp_path = "nas";

            _configuration.inws_ws_srvr = "ftsserver";
            _configuration.inws_ws_port = 8080;
            _configuration.inws_server = "inews2";
            _configuration.inws_login = "avstar";
            _configuration.inws_pwd = "avstar";

            _configuration.iplay_ws_srvr = "ftsserver";
            _configuration.iplay_ws_port = 8080;
            _configuration.iplay_workgroup = "WYSDOM";
            _configuration.iplay_login = "avstar";
            _configuration.iplay_pwd = "avstar";
        }
    }
    @GET
    @Path("/")
    public ExportConfiguration get() {
        return _configuration;
    }

    @POST
     public String post(ExportConfiguration config) {
        _configuration = config;
        try {
            _configuration.Save("D:/obsconfig.xml");
        }
        catch (Exception ex)
        {

        }
        return "OK";
    }
}
