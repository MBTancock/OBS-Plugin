package com.avid.central.obsplugin;

import javax.ws.rs.*;

import com.avid.central.obsplugin.Configuration.ExportConfiguration;
import com.avid.central.obsplugin.inewslibrary.*;
import com.avid.central.services.authentication.um.UserInfo;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.UUID;


/**
 * Created by Administrator on 02/10/2015.
 */
@Path("/inews")
@Consumes("application/json")
@Produces("application/json")

public class inewsResource {
    private ExportConfiguration _configuration;

    private Map<UUID, ExportStoryData> _exports = null;
    public inewsResource() {
        try
        {
            _configuration = ExportConfiguration.Open();
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
            _configuration.title_id = "Name";
            _configuration.obs_channel_id = "OBSChannelID";

            _configuration.obs_export_role = "Exporters";

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

        _exports =  new HashMap<UUID, ExportStoryData>();
    }

    // this will export the xml created by a prior call to the designated ftp location
    @GET
    @Path("/{id}")
    public InewsResponse get(@PathParam("id") UUID id) {

        _configuration.ReloadIfChanged();
        InewsResponse response = new InewsResponse();
        response.setMessage("Export Failed");

        try {
            // retrieve the export data from the map
            ExportStoryData exportData = _exports.get(id);

            try {
                // create simple ftp client to export the data
                // build the url
                StringBuilder sb = new StringBuilder();
                sb.append("ftp://");
                if (exportData.getMdsMode())
                {
                    sb.append(_configuration.mds_ftp_login);
                    sb.append(":");
                    sb.append(_configuration.mds_ftp_pwd);
                    sb.append("@");
                    sb.append(_configuration.mds_ftp_srvr);
                    sb.append(":");
                    sb.append(_configuration.mds_ftp_port);
                    sb.append("/");
                    sb.append(_configuration.mds_ftp_path);
                }
                else {
                    sb.append(_configuration.onc_ftp_login);
                    sb.append(":");
                    sb.append(_configuration.onc_ftp_pwd);
                    sb.append("@");
                    sb.append(_configuration.onc_ftp_srvr);
                    sb.append(":");
                    sb.append(_configuration.onc_ftp_port);
                    sb.append("/");
                    sb.append(_configuration.onc_ftp_path);
                }
                sb.append("/");
                sb.append(exportData.getResponse().getFileName());
                URL url = new URL(sb.toString());

                // open the connection
                URLConnection urlc = url.openConnection();
                OutputStream os = urlc.getOutputStream();

                // write the data
                    os.write(exportData.getRundownAsXml().getBytes());
                os.flush();
                os.close();

                // create the result message
                sb.setLength(0);
                if (exportData.getMdsMode()) {
                    sb.append("ftp://");
                    sb.append(_configuration.mds_ftp_srvr);
                    sb.append("/");
                    sb.append(_configuration.mds_ftp_path);
                }
                else {
                    sb.append("ftp://");
                    sb.append(_configuration.onc_ftp_srvr);
                    sb.append("/");
                    sb.append(_configuration.onc_ftp_path);
                }

                response.setRundown(exportData.getResponse().getRundown());
                response.setFileName(exportData.getResponse().getFileName());
                response.setLocation(sb.toString());
                response.setResult(1);
            }
            catch (Exception ex)
            {
                response.setResult(0);
                response.setMessage(ex.getMessage());
            }

            // finished with this rundown
            _exports.remove(id);
        }
        catch (Exception ex)
        {

        }

        return response;
    }


    // this is called if the user decides not to export the data
    // deletes the export data from the map
    @DELETE
    @Path("/{id}")
    public String delete(@PathParam("id") UUID id) {
        String response = "";
        try {
            _exports.remove(id);
            response = "Deleted " + id.toString();
        }
        catch (Exception ex)
        {
            response = "Failed to delete " + id.toString() + ", " + ex.getMessage();
        }

        return response;
    }


    // this will create the xml data and return a response indicating success or failure (e.g. invalid data, not authorised)
    // also returns key parameters associated with the export data for display to the user
    @POST
    public InewsResponse post(UserInfo session, InewsRequest request) {
        _configuration.ReloadIfChanged();
        Boolean connected = false;
        InewsResponse response = new InewsResponse();
        response.setMessage("Listing Failed");

        // check that this user can export rundowns
        boolean authorised = false;
        for (String role : session.getUserSession().getRoles())
        {
            if (role.equalsIgnoreCase(_configuration.obs_export_role))
            {
                authorised = true;
                break;
            }
        }

        if (!authorised)
        {
            // sorry, not allowed!
            response.setResult(2);
            return response;
        }

        iNEWS_System inews = new iNEWS_System(_configuration.inws_ws_srvr, _configuration.inws_ws_port);

        try {

                // request to create the export xml data
                // first connect to iNEWS, throws exception if it fails
                inews.Connect(_configuration.inws_server, _configuration.inws_login, _configuration.inws_pwd);
                connected = true;

                // create a queue soap client
                iNEWS_Queue queue = new iNEWS_Queue(inews.getSessionID(), _configuration.inws_ws_srvr, _configuration.inws_ws_port);

                // list the queue, throws exception if there is a soap related error
                // listing could be empty if there was a problem listing the queue
                List<com.avid.central.obsplugin.inewslibrary.nsml.Nsml> listing = queue.GetRundown(request.getQueue(), true);

                if (null == listing || listing.isEmpty())
                {
                    response.setResult(0);
                    response.setMessage("Failed to locate any stories in the rundown.");
                }
                else {
                    ExportStories ex = new ExportStories();

                    // get the export data
                    ExportStoryData exportData = ex.ProcessRundown(listing, _configuration);

                    // create an ID for it and add it to the map
                    do {
                        exportData.setID(UUID.randomUUID());
                    } while (_exports.containsKey(exportData.getID()));

                    _exports.put(exportData.getID(), exportData);

                    // don't set a result, it has already been set in ProcessRundown()
                    response = exportData.getResponse();
                    response.setRundown(request.getQueue());
                }
        } catch (Exception ex) {
            response.setMessage(ex.getMessage());
            response.setResult(0);
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
