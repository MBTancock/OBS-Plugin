package com.avid.central.obsplugin;

import com.avid.central.obsplugin.Configuration.ExportConfiguration;
import com.avid.central.obsplugin.inewslibrary.ExportCuesheetData;
import com.avid.central.obsplugin.inewslibrary.iNEWS_Queue;
import com.avid.central.obsplugin.inewslibrary.iNEWS_System;
import com.avid.central.obsplugin.inewslibrary.nsml.Nsml;
import com.avid.central.services.authentication.um.UserInfo;

import javax.ws.rs.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Broadcast Media Solutions on 05/11/2015.
 */

@Path("/cuesheet")
@Consumes("application/json")
@Produces("application/json")

public class cuesheetResource {
    private ExportConfiguration _configuration;

    private Map<UUID, ExportCuesheetData> _exports = null;

    public cuesheetResource() {
        _configuration = null;
        try {
            _configuration = ExportConfiguration.Open();
        } catch (Exception ex) {
            // failed to open it
        }

        _exports = new HashMap<UUID, ExportCuesheetData>();
    }

    // this will export the xml created by a prior call to the designated ftp location
    @GET
    @Path("/{id}")
    public CuesheetResponse get(@PathParam("id") UUID id) {

        CuesheetResponse response = new CuesheetResponse();
        response.setMessage("Export Failed");

        if (null == _configuration) {
            // see if we can load the settings
            try {
                _configuration = ExportConfiguration.Open();
            } catch (Exception ex) {
                response.setResult(3);
                response.setMessage("No configuration");
                return response;
            }
        }

        _configuration.ReloadIfChanged();

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
        } catch (Exception ex) {
            response = "Failed to delete " + id.toString() + ", " + ex.getMessage();
        }

        return response;
    }

    @POST
    public CuesheetResponse post(UserInfo session, CuesheetRequest request) {
        CuesheetResponse response = new CuesheetResponse();
        response.setMessage("Cuesheet Export Failed");

        if (null == _configuration) {
            response.setResult(3);
            response.setMessage("No configuration");
            return response;
        }

        _configuration.ReloadIfChanged();

        Boolean connected = false;

        // check that this user can export cue sheets
        boolean authorised = false;
        for (String role : session.getUserSession().getRoles()) {
            if (role.equalsIgnoreCase(_configuration.obs_export_role)) {
                authorised = true;
                break;
            }
        }

        if (!authorised) {
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

            String storyAsNsml = queue.GetStory(request.getQueue(), request.getStory());
            String mobID = queue.GetMobID(storyAsNsml);
            response.setMessage(mobID);

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
