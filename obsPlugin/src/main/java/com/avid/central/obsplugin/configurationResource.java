package com.avid.central.obsplugin;

import com.avid.central.obsplugin.Configuration.ExportConfiguration;
import com.avid.central.obsplugin.inewslibrary.iNEWS_Queue;
import com.avid.central.obsplugin.inewslibrary.iNEWS_System;
import com.avid.central.obsplugin.interplaylibrary.interplay_assets;
import org.apache.commons.net.ftp.FTPClient;

import javax.ws.rs.*;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

/**
 * Created by Broadcast Media Solutions on 16/10/2015.
 */
@Path("/obsdetails")
@Consumes("application/json")
@Produces("application/json")

public class configurationResource {
    public configurationResource()
    {
    }

    @GET
    @Path("/")
    public ExportConfiguration get_configuration() {
        ExportConfiguration config = null;

        try
        {
            config = ExportConfiguration.Open();
        }
        catch (Exception ex){}
        return config;
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
     public ExportConfiguration post(ExportConfiguration config) {
        try {
            config.Save();
        }
        catch (Exception ex)
        {
            return null;
        }
        return config;
    }

    @PUT
    public ExportConfiguration put(ExportConfiguration config) {
        try {
            config.Save();
        }
        catch (Exception ex)
        {
            return null;
        }
        return config;
    }

    private ExportConfiguration GetConfiguration() throws Exception
    {
        ExportConfiguration config = null;
        try
        {
            config = ExportConfiguration.Open();
        }
        catch (Exception ex)
        {
            String errorMsg = ex.getMessage();
            if (null == errorMsg)
            {
                errorMsg = null != ex.getCause() ? ex.getCause().getMessage() : "";
            }
            throw new Exception("Error reading configuration settings: " + errorMsg);
        }
        return config;
    }

    String test_inews_connection()
    {
        // first get the configuration
        ExportConfiguration config = null;
        try
        {
            config = GetConfiguration();
        }
        catch (Exception ex)
        {
            return ex.getMessage();
        }

        String response = "Connection Failed";
        boolean connected = false;
        iNEWS_System inews = null;

        try {
            // then connect to iNEWS
            inews = new iNEWS_System(config.inws_ws_srvr, config.inws_ws_port);
            inews.Connect(config.inws_server, config.inws_login, config.inws_pwd);
            connected = true;

            // try and list the root folder
            List<String> listing = inews.ListFolder("");

            // folder listed ok, can we use the later GetQueueRecords command?
            iNEWS_Queue queue = new iNEWS_Queue(inews.getSessionID(), config.inws_ws_srvr, config.inws_ws_port);
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
        // first get the configuration
        ExportConfiguration config = null;
        try
        {
            config = GetConfiguration();
        }
        catch (Exception ex)
        {
            return ex.getMessage();
        }

        interplay_assets assets = new interplay_assets(config.iplay_ws_srvr, config.iplay_ws_port, config.iplay_workgroup, config.iplay_login, config.iplay_pwd);
        try
        {
            assets.testConnection();
        }
        catch (Exception ex)
        {
            return "Interplay connection failed: " + ex.getMessage();
        }

        return "Interplay connection successful";
    }

    String test_onc_connection()
    {
        String response = "Connection Failed";

        // first get the configuration
        ExportConfiguration config = null;
        try
        {
            config = GetConfiguration();
        }
        catch (Exception ex)
        {
            return ex.getMessage();
        }

        // check for valid configuration
        if (config.onc_ftp_path.length() == 0 ||
                config.onc_ftp_pwd.length() == 0 ||
                config.onc_ftp_port == 0 ||
                config.onc_ftp_login.length() == 0 ||
                config.onc_ftp_srvr.length() == 0)
        {
            return "The ONC FTP settings are not valid\r\n\r\nPlease update the configuration.";
        }

        // now try ftp
        FTPClient ftp = null;
        try
        {
            ftp = new FTPClient();
            ftp.connect(config.onc_ftp_srvr);
            ftp.login(config.onc_ftp_login, config.onc_ftp_pwd);
            StringBuilder fp = new StringBuilder();
            fp.append(config.onc_ftp_path);
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

        // first get the configuration
        ExportConfiguration config = null;
        try
        {
            config = GetConfiguration();
        }
        catch (Exception ex)
        {
            return ex.getMessage();
        }

        // check for valid configuration
        if (config.mds_ftp_path.length() == 0 ||
                config.mds_ftp_pwd.length() == 0 ||
                config.mds_ftp_port == 0 ||
                config.mds_ftp_login.length() == 0 ||
                config.mds_ftp_srvr.length() == 0)
        {
            return "The ONC FTP settings are not valid\r\n\r\nPlease update the configuration.";
        }

        // now try ftp
        FTPClient ftp = null;
        try
        {
            ftp = new FTPClient();
            ftp.connect(config.mds_ftp_srvr);
            ftp.login(config.mds_ftp_login, config.mds_ftp_pwd);
            StringBuilder fp = new StringBuilder();
            fp.append(config.mds_ftp_path);
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
