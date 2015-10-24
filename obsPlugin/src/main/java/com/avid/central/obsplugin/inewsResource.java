package com.avid.central.obsplugin;

import javax.ws.rs.*;

import com.avid.central.obsplugin.Configuration.ExportConfiguration;
import com.avid.central.obsplugin.inewslibrary.*;
import com.avid.central.services.authentication.um.UserInfo;

import java.io.OutputStream;
import java.util.List;
import java.net.URL;
import java.net.URLConnection;


/**
 * Created by Administrator on 02/10/2015.
 */
@Path("/inews")
@Consumes("application/json")
@Produces("application/json")

public class inewsResource {
    ExportStoryData _exportData;
    ExportConfiguration _configuration;

    public inewsResource() {
        _exportData = null;
        try
        {
            _configuration = ExportConfiguration.Open("D:/obsconfig.xml");
        }
        catch (Exception ex) {
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
    @Path("/{id}")
    public InewsResponse get(@PathParam("id") String id) {
        InewsResponse response = new InewsResponse();
        response.setMessage("Listing Failed");
        return response;
    }

    @POST
    public InewsResponse post(UserInfo session, InewsRequest request) {
        Boolean connected = false;
        InewsResponse response = new InewsResponse();
        response.setMessage("Listing Failed");

        iNEWS_System inews = new iNEWS_System(_configuration.inws_ws_srvr, _configuration.inws_ws_port);

        try {
            if (request.getExport()) {
                // request to export the previously formatted xml

                try {
                    // create simple ftp client to export the data
                    // build the url
                    StringBuilder sb = new StringBuilder();
                    sb.append("ftp://");
                    sb.append(_configuration.onc_ftp_login);
                    sb.append(":");
                    sb.append(_configuration.onc_ftp_pwd);
                    sb.append("@");
                    sb.append(_configuration.onc_ftp_srvr);
                    sb.append(":");
                    sb.append(_configuration.onc_ftp_port);
                    sb.append("/");
                    sb.append(_configuration.onc_ftp_path);
                    sb.append("/");
                    sb.append(request.getQueue());
                    URL url = new URL(sb.toString());

                    // open the connection
                    URLConnection urlc = url.openConnection();
                    OutputStream os = urlc.getOutputStream();

                    // write the data
                    os.write(_exportData.StoryAsXml.getBytes());
                    os.flush();
                    os.close();

                    if (null != _exportData.Warning)
                    {
                        response.setMessage("Export succeeded but " + _exportData.Warning);
                    }
                    else
                    {
                        response.setMessage("Export succeeded");
                    }
//                    response.setMessage(new File(".").getAbsolutePath());
                    response.setResult(1);
                }
                catch (Exception ex)
                {
                    response.setResult(0);
                    response.setMessage(ex.getMessage());
                }

            } else {
                // request to create the export xml data
                // first connect to iNEWS
                _exportData = null;
                inews.Connect(_configuration.inws_server, _configuration.inws_login, _configuration.inws_pwd);
                connected = true;

                iNEWS_Queue queue = new iNEWS_Queue(inews.getSessionID(), _configuration.inws_ws_srvr, _configuration.inws_ws_port);
                List<com.avid.central.obsplugin.inewslibrary.nsml.Nsml> listing = queue.GetRundown(request.getQueue(), true);

                ExportStories ex = new ExportStories();
                _exportData = ex.ProcessRundown(listing, _configuration, false); //TODO mds mode

                response.setFileName(_exportData.FileName);
                response.setResult(1);
            }
        } catch (Exception ex) {
            response.setMessage(ex.getMessage());
            return response;
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
}
