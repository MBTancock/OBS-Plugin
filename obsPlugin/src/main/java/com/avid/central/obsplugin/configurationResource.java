package com.avid.central.obsplugin;

import com.avid.central.obsplugin.Configuration.ExportConfiguration;
import com.avid.central.obsplugin.inewslibrary.iNEWS_Queue;
import com.avid.central.obsplugin.inewslibrary.iNEWS_System;
import org.apache.commons.net.ftp.FTPClient;

import javax.ws.rs.*;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

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
            _configuration = ExportConfiguration.Open();
        }
        catch (Exception ex)
        {
            // failed to open it so create a default version
            _configuration = new ExportConfiguration();
            _configuration.duration_field = "total-time";
            _configuration.info_field = "v-info";

            _configuration.rundown_field = "v-rundown";
            _configuration.runup_field = "v-runup";
            _configuration.start_time_field = "cume-time";
            _configuration.story_id_field = "v-storyid";
            _configuration.subject_field = "title";
            _configuration.type_field = "v-type";
            _configuration.upmix_field = "v-upmix";
            _configuration.video_id_field = "mos-title";

            _configuration.obs_export_role = "Exporters";

            _configuration.date_id = "Date";
            _configuration.day_id = "Day";
            _configuration.title_id = "Name";
            _configuration.obs_channel_id = "OBSChannelID";

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
            _configuration.inws_server = "inews";
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
    public ExportConfiguration get_configuration() {
        return _configuration;
    }

    @GET
    @Path("/inews")
    public String test_inews() {
        return test_inews_connection();
    }

    @GET
    @Path("/interplay")
    public String test_interplay() {
        return test_interplay_connection();
    }

    @GET
    @Path("/onc")
    public String test_onc() {
        return test_onc_connection();
    }

    @GET
    @Path("/mds")
    public String test_mds() {
        return test_mds_connection();
    }

    @POST
     public String post(ExportConfiguration config) {
        _configuration = config;
        try {
            _configuration.Save();
        }
        catch (Exception ex)
        {

        }
        return "OK";
    }

    String test_inews_connection()
    {
        String response = "Connection Failed";
        boolean connected = false;
        iNEWS_System inews = new iNEWS_System(_configuration.inws_ws_srvr, _configuration.inws_ws_port);

        try {
            // first connect to iNEWS
            inews.Connect(_configuration.inws_server, _configuration.inws_login, _configuration.inws_pwd);
            connected = true;

            // try and list the root folder
            List<String> listing = inews.ListFolder("");

            // folder listed ok, can we use the later GetQueueRecords command?
            iNEWS_Queue queue = new iNEWS_Queue(inews.getSessionID(), _configuration.inws_ws_srvr, _configuration.inws_ws_port);
            queue.CheckForGetRecords();
            response = "iNEWS Connection Successful";
         }
        catch (Exception ex) {
            response = ex.getMessage();
            if (response.toLowerCase().contains("getqueuerecords"))
            {
                response = "The iNEWS Connection succeeded but the web services version is inadequate.\r\n\r\nPlease ensure that iNEWS web services version 1.3 or later is installed.";
            }
        }

        finally
        {
        if (connected)
        {
        try
        {
        inews.Disconnect();
        }
        catch (Exception ex){}
        }
        }
        return response;
    }

    String test_interplay_connection()
    {
        return "OK";
    }

    String test_onc_connection()
    {
        String response = "Connection Failed";

        // check for valid configuration
        if (null == _configuration ||
                _configuration.onc_ftp_path.length() == 0 ||
                _configuration.onc_ftp_pwd.length() == 0 ||
                _configuration.onc_ftp_port == 0 ||
                _configuration.onc_ftp_login.length() == 0 ||
                _configuration.onc_ftp_srvr.length() == 0)
        {
            return "The ONC FTP settings are not valid\r\n\r\nPlease update the configuration.";
        }

        // now try ftp
        FTPClient ftp = null;
        try
        {
            ftp = new FTPClient();
            ftp.connect(_configuration.onc_ftp_srvr);
            ftp.login(_configuration.onc_ftp_login, _configuration.onc_ftp_pwd);
            StringBuilder fp = new StringBuilder();
            fp.append(_configuration.onc_ftp_path);
            fp.append("/ftp_test_file.xml");
            OutputStream fs = ftp.storeFileStream(fp.toString());
            fs.write("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><Rundown>This is my test data</Rundown>".getBytes());
            fs.flush();
            fs.close();
            ftp.deleteFile(fp.toString());
            response = "ONC FTP Connection Successful.";
            }
        catch (Exception ex)
        {
            response = ex.getMessage();
        }
        finally
        {
            if (null != ftp && ftp.isConnected())
            {
                try
                {
                    ftp.disconnect();
                }
                catch (Exception ex){}
            }
        }
        return response;
    }

    String test_mds_connection()
    {
        String response = "Connection Failed";

        // check for valid configuration
        if (null == _configuration ||
                _configuration.mds_ftp_path.length() == 0 ||
                _configuration.mds_ftp_pwd.length() == 0 ||
                _configuration.mds_ftp_port == 0 ||
                _configuration.mds_ftp_login.length() == 0 ||
                _configuration.mds_ftp_srvr.length() == 0)
        {
            return "The ONC FTP settings are not valid\r\n\r\nPlease update the configuration.";
        }

        // now try ftp
        FTPClient ftp = null;
        try
        {
            ftp = new FTPClient();
            ftp.connect(_configuration.mds_ftp_srvr);
            ftp.login(_configuration.mds_ftp_login, _configuration.mds_ftp_pwd);
            StringBuilder fp = new StringBuilder();
            fp.append(_configuration.mds_ftp_path);
            fp.append("/ftp_test_file.xml");
            OutputStream fs = ftp.storeFileStream(fp.toString());
            fs.write("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><Rundown>This is my test data</Rundown>".getBytes());
            fs.flush();
            fs.close();
            ftp.deleteFile(fp.toString());
            response = "MDS FTP Connection Successful.";
        }
        catch (Exception ex)
        {
            response = ex.getMessage();
        }
        finally
        {
            if (null != ftp && ftp.isConnected())
            {
                try
                {
                    ftp.disconnect();
                }
                catch (Exception ex){}
            }
        }
        return response;    }
}
