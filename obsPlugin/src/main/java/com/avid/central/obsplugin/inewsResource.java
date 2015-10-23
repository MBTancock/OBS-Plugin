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
        _configuration = new ExportConfiguration();
//        _configuration.mdsMode = false;
//        _configuration.fields.ComArField = "v-offtubear";
//        _configuration.fields.ComEnField = "v-offtubeen";
//        _configuration.fields.ComEsField = "v-offtubesp";
//        _configuration.fields.CoverageEndField = "v-covend";
//        _configuration.fields.CoverageStartField = "v-covstart";
//        _configuration.fields.DurationField = "total-time";
//        _configuration.fields.EventFeedField = "v-eventfeed";
//        _configuration.fields.InfoField = "v-info";
//
//        _configuration.fields.RundownField = "v-rundown";
//        _configuration.fields.RunupField = "v-runup";
//        _configuration.fields.StartTimeField = "cume-time";
//        _configuration.fields.StoryIDField = "v-storyid";
//        _configuration.fields.SubjectField = "title";
//        _configuration.fields.TypeField = "v-type";
//        _configuration.fields.UpmixField = "v-upmix";
//        _configuration.fields.VideoIDField = "mos-title";
//
//        _configuration.definitions.DateID = "Date";
//        _configuration.definitions.DayID = "Day";
//        _configuration.definitions.NameID = "Name";
//        _configuration.definitions.ObsChannelID = "OBSChannelName";
//
//        _configuration.export.FTPServer = "wysdomserver";
//        _configuration.export.FTPPort = 21;
//        _configuration.export.FTPUser = "administrator";
//        _configuration.export.FTPPassword = "is-admin";
//        _configuration.export.FTPFolder = "nas";
//
//        _configuration.inews.iNEWSWebServicesServer = "ftsserver";
//        _configuration.inews.iNEWSWebServicesPort = 8080;
//        _configuration.inews.iNEWSServer = "inews";
//        _configuration.inews.iNEWSUser = "avstar";
//        _configuration.inews.iNEWSPassword = "avstar";
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
                _exportData = ex.ProcessRundown(listing, _configuration, true); //TODO mds mode

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
