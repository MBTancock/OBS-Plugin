package com.avid.central.obsplugin;

import com.avid.central.obsplugin.Configuration.ExportConfiguration;
import com.avid.central.obsplugin.datamodel.CuesheetRequest;
import com.avid.central.obsplugin.datamodel.CuesheetResponse;
import com.avid.central.obsplugin.datamodel.ExportCuesheetData;
import com.avid.central.obsplugin.datamodel.MarkerData;
import com.avid.central.obsplugin.inewslibrary.iNEWS_Queue;
import com.avid.central.obsplugin.inewslibrary.iNEWS_System;
import com.avid.central.obsplugin.interplaylibrary.assets.*;
import com.avid.central.obsplugin.interplaylibrary.interplay_assets;
import com.avid.central.obsplugin.timecode.Timecode;
import com.avid.central.obsplugin.timecode.VideoSampleRate;
import com.avid.central.services.authentication.um.UserInfo;

import javax.ws.rs.*;
import java.util.*;

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

            if (null == mobID)
            {
                // flag the fact we failed to locate the MobID
                response.setResult(4);
                return response;
            }

            // ok, now we have the MobID we can ask for the markers
            interplay_assets assets = new interplay_assets(_configuration.iplay_ws_srvr, _configuration.iplay_ws_port, _configuration.iplay_workgroup, _configuration.iplay_login, _configuration.iplay_pwd);

            // first we need some details of the sequence, start frame, end frame and the frame rate
            Map<String, String> returnAttributes = assets.GetSequenceDetails(mobID);

            // check we have the attributes we need
            double frameRate = 0;
            String start;
            String end;
            if (returnAttributes.containsKey("FPS"))
            {
                try
                {
                    frameRate = Double.parseDouble(returnAttributes.get("FPS"));
                }
                catch (Exception ex)
                {
                    throw new Exception("Failed to obtain the sequence frame rate");
                }
            }
            else
            {
                throw new Exception("Failed to obtain the sequence frame rate");
            }

            if (returnAttributes.containsKey("Start"))
            {
                start = returnAttributes.get("Start");
            }
            else
            {
                throw new Exception("Failed to obtain the sequence start timecode");
            }

            if (returnAttributes.containsKey("End"))
            {
                end = returnAttributes.get("End");
            }
            else
            {
                throw new Exception("Failed to obtain the sequence end timecode");
            }


            // now get the markers
            response.setMarkers(new ArrayList<MarkerData>());

            List<UMIDLocatorType> markers = assets.GetMarkers(mobID);

            // process the markers into the desired reporting format
            if (markers != null)
            {
                // need to sort the list
                Collections.sort(markers, new Comparator<UMIDLocatorType>(){
                    @Override
                    public int compare(final UMIDLocatorType lhs,UMIDLocatorType rhs) {
                        return Long.compare(lhs.getFrameNumber(), rhs.getFrameNumber());
                    }
                });

                // need a timecode calculator
                int numerator = 50;
                int denominator = 1;
                if (frameRate == 29.97)
                {
                    numerator = 60000;
                    denominator = 1001;
                }

                VideoSampleRate sampleRate = new VideoSampleRate(true, numerator, denominator);

                Timecode tc = new Timecode(start, sampleRate);
                long startFrameNumber = tc.getTotalFrames();
                tc = tc.setNewTimecode(end);
                long endFrameNumber = tc.getTotalFrames();

                for (int i = 0; i < markers.size(); i++)
                {
                    MarkerData markerData = new MarkerData();

                    // first get the corrected timecode (Interplay WS Error if > 1 hour durn)
                    UMIDLocatorType marker = markers.get(i);
                    long markerStart = marker.getFrameNumber() + startFrameNumber;
                    tc.setTotalFrames((int)markerStart);
                    markerData.Start = tc.toString();

                    long nextStart;
                    if (i < (markers.size() - 1))
                    {
                        nextStart = markers.get(i + 1).getFrameNumber();
                    }
                    else
                    {
                        nextStart = endFrameNumber;
                    }

                    tc.setTotalFrames((int)(nextStart - markerStart));
                    markerData.Duration = tc.toString();

                    markerData.Comment = marker.getComment();
                    response.getMarkers().add(markerData);
                }
            }

            response.setResult(1);

        } catch (Exception ex) {
            response.setMessage(ex.getMessage());
            response.setMarkers(null);
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
