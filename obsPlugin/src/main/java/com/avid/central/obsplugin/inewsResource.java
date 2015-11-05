package com.avid.central.obsplugin;

import javax.ws.rs.*;

import com.avid.central.obsplugin.Configuration.ExportConfiguration;
import com.avid.central.obsplugin.inewslibrary.*;
import com.avid.central.services.authentication.um.UserInfo;
import org.apache.commons.net.ftp.FTPClient;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.UUID;


/**
 * Created by Broadcast Media Solutions on 02/10/2015.
 */

@Path("/inews")
@Consumes("application/json")
@Produces("application/json")

public class inewsResource {
    private ExportConfiguration _configuration;

    private Map<UUID, ExportStoryData> _exports = null;
    public inewsResource() {
        _configuration = null;
        try
        {
            _configuration = ExportConfiguration.Open();
        }
        catch (Exception ex) {
            // failed to open it
        }

        _exports =  new HashMap<UUID, ExportStoryData>();
    }

    // this will export the xml created by a prior call to the designated ftp location
    @GET
    @Path("/{id}")
    public InewsResponse get(@PathParam("id") UUID id) {

        InewsResponse response = new InewsResponse();
        response.setMessage("Export Failed");

        if (null == _configuration)
        {
            // see if we can load the settings
            try
            {
                _configuration = ExportConfiguration.Open();
            }
            catch (Exception ex) {
                response.setResult(3);
                response.setMessage("No configuration");
                return response;
            }
        }

        _configuration.ReloadIfChanged();

        try {
            // retrieve the export data from the map
            ExportStoryData exportData = _exports.get(id);

            FTPClient ftp = null;
            StringBuilder filePath = new StringBuilder();
            try {
                ftp = new FTPClient();
                if (exportData.getMdsMode()) {
                    ftp.connect(_configuration.mds_ftp_srvr);
                    ftp.login(_configuration.mds_ftp_login, _configuration.mds_ftp_pwd);
                    filePath.append(_configuration.mds_ftp_path);
                }
                else
                {
                    ftp.connect(_configuration.onc_ftp_srvr);
                    ftp.login(_configuration.onc_ftp_login, _configuration.onc_ftp_pwd);
                    filePath.append(_configuration.onc_ftp_path);
                }
                filePath.append("/");
                filePath.append(exportData.getResponse().getFileName());
                OutputStream os = ftp.storeFileStream(filePath.toString());
 

                // write the data
                os.write(exportData.getRundownAsXml().getBytes());
                os.close();
                if(!ftp.completePendingCommand())
                {
                    throw new Exception("Problem writing the XML output file");
                }

                    // create the result message
                filePath.setLength(0);
                if (exportData.getMdsMode()) {
                    filePath.append("ftp://");
                    filePath.append(_configuration.mds_ftp_srvr);
                    filePath.append("/");
                    filePath.append(_configuration.mds_ftp_path);
                }
                else {
                    filePath.append("ftp://");
                    filePath.append(_configuration.onc_ftp_srvr);
                    filePath.append("/");
                    filePath.append(_configuration.onc_ftp_path);
                }

                response.setRundown(exportData.getResponse().getRundown());
                response.setFileName(exportData.getResponse().getFileName());
                response.setLocation(filePath.toString());
                response.setResult(1);
            }
            catch (Exception ex)
            {
                response.setResult(0);
                response.setMessage(ex.getMessage());
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
        InewsResponse response = new InewsResponse();
        response.setMessage("Listing Failed");

        if (null == _configuration)
        {
            response.setResult(3);
            response.setMessage("No configuration");
            return response;
        }

        _configuration.ReloadIfChanged();

        Boolean connected = false;

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
