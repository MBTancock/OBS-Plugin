package com.avid.central.obsplugin;

import com.avid.central.obsplugin.Configuration.ExportConfiguration;
import com.avid.central.obsplugin.datamodel.CuesheetRequest;
import com.avid.central.obsplugin.datamodel.CuesheetResponse;
import com.avid.central.obsplugin.datamodel.ExportCuesheetData;
import com.avid.central.obsplugin.datamodel.MarkerData;
import com.avid.central.obsplugin.inewslibrary.StoryData;
import com.avid.central.obsplugin.inewslibrary.iNEWS_Queue;
import com.avid.central.obsplugin.inewslibrary.iNEWS_Story;
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

    // this will write the cue sheet data retrieved in a previous call to the story
    @GET
    @Path("/{id}")
    public CuesheetResponse get(@PathParam("id") UUID id) {

        CuesheetResponse response = new CuesheetResponse();
        response.setMessage("Publish Failed");

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
        Boolean connected = false;

        try {
            // retrieve the export data from the map
            ExportCuesheetData exportData = _exports.get(id);
            if (null == exportData) {
                throw new Exception("Failed to locate the marker data");
            }
            iNEWS_System inews = new iNEWS_System(_configuration.inws_ws_srvr, _configuration.inws_ws_port);

            try {

                // request to create the export xml data
                // first connect to iNEWS, throws exception if it fails
                inews.Connect(_configuration.inws_server, _configuration.inws_login, _configuration.inws_pwd);
                connected = true;

                // now create a replacement story containing the cue sheet
                String replacementNSML = AddMarkers(exportData);
                if (null == replacementNSML)
                {
                    throw new Exception ("There was a problem publishing the cue sheet");
                }

                // create a story soap client
                iNEWS_Story story = new iNEWS_Story(inews.getSessionID(), _configuration.inws_ws_srvr, _configuration.inws_ws_port);

                response.setResult(story.SaveStory(exportData.getQueue(), exportData.getLocator(), replacementNSML) ? 1 : 4);
                response.setMessage(1 == response.getResult() ? "Publish Succeeded" : "Story Locked");
            } catch (Exception ex) {
                response.setMessage(ex.getMessage());
                response.setMarkers(null);
                response.setResult(0);
                return response;
            } finally {
                if (connected) {
                    try {
                        inews.Disconnect();
                    } catch (Exception ex) {
                    }
                }
            }
        } catch (Exception ex) {
            response.setMessage(ex.getMessage());
            response.setMarkers(null);
            response.setResult(0);
        }

        // remove any export data
        try
        {
            if (null != _exports.get(id)) {
                _exports.remove(id);
            }
        }

        catch (Exception ex){}
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
            if (role.equalsIgnoreCase(_configuration.obs_cuesheet_role)) {
                authorised = true;
                break;
            }
        }

        if (!authorised) {
            // sorry, not allowed!
            response.setMessage("User not authorised");
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

            StoryData storyData = queue.GetStory(request.getQueue(), request.getStory(), _configuration.subject_field);
            response.setTitle(storyData.Title);
            String mobID = queue.GetMobID(storyData.StoryAsNSML);

            if (null == mobID) {
                // flag the fact we failed to locate the MobID
                response.setMessage("Failed to determine MobID");
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
            if (returnAttributes.containsKey("FPS")) {
                try {
                    frameRate = Double.parseDouble(returnAttributes.get("FPS"));
                } catch (Exception ex) {
                    throw new Exception("Failed to obtain the sequence frame rate");
                }
            } else {
                throw new Exception("Failed to obtain the sequence frame rate");
            }

            if (returnAttributes.containsKey("Start")) {
                start = returnAttributes.get("Start");
            } else {
                throw new Exception("Failed to obtain the sequence start timecode");
            }

            if (returnAttributes.containsKey("End")) {
                end = returnAttributes.get("End");
            } else {
                throw new Exception("Failed to obtain the sequence end timecode");
            }


            // now get the markers
            response.setMarkers(new ArrayList<MarkerData>());

            List<UMIDLocatorType> markers = assets.GetMarkers(mobID);

            // process the markers into the desired reporting format
            if (markers != null) {
                // need to sort the list
                Collections.sort(markers, new Comparator<UMIDLocatorType>() {
                    @Override
                    public int compare(final UMIDLocatorType lhs, UMIDLocatorType rhs) {
                        return Long.compare(lhs.getFrameNumber(), rhs.getFrameNumber());
                    }
                });

                // need a timecode calculator
                int numerator = 50;
                int denominator = 1;
                if (frameRate == 29.97) {
                    numerator = 60000;
                    denominator = 1001;
                }

                VideoSampleRate sampleRate = new VideoSampleRate(true, numerator, denominator);

                Timecode tc = new Timecode(start, sampleRate);
                long startFrameNumber = tc.getTotalFrames();
                tc = tc.setNewTimecode(end);
                long endFrameNumber = tc.getTotalFrames();

                for (int i = 0; i < markers.size(); i++) {
                    MarkerData markerData = new MarkerData();

                    // first get the corrected timecode (Interplay WS Error if > 1 hour durn)
                    UMIDLocatorType marker = markers.get(i);
                    long markerStart = marker.getFrameNumber() + startFrameNumber;
                    tc.setTotalFrames((int) markerStart);
                    markerData.Start = tc.toString();

                    long nextStart;
                    if (i < (markers.size() - 1)) {
                        nextStart = markers.get(i + 1).getFrameNumber();
                    } else {
                        nextStart = endFrameNumber;
                    }

                    tc.setTotalFrames((int) (nextStart - markerStart));
                    markerData.Duration = tc.toString();

                    markerData.Comment = marker.getComment();
                    response.getMarkers().add(markerData);
                }
            }

            // get the export data
            ExportCuesheetData exportData = new ExportCuesheetData(request.getQueue(), request.getStory(), storyData.StoryAsNSML, response);

            // create an ID for it and add it to the map
            do {
                exportData.setID(UUID.randomUUID());
            } while (_exports.containsKey(exportData.getID()));

            _exports.put(exportData.getID(), exportData);
            response.setMessage("Marker data retrieved");
            response.setResult(1);

        } catch (Exception ex) {
            response.setMessage(ex.getMessage());
            response.setMarkers(null);
            response.setResult(0);
            return response;
        } finally {
            if (connected) {
                try {
                    inews.Disconnect();
                } catch (Exception ex) {
                }
            }
        }

        return response;
    }

    private String AddMarkers(ExportCuesheetData exportData)
    {
        if (null == exportData || null == exportData.getResponse() || null == exportData.getResponse().getMarkers() || exportData.getResponse().getMarkers().size() < 1)
        {
            return null;
        }

        // first see if we already have locator data
        int cuesheet, bodyClose;

        String BodyCloseTag = "</body>";
        String EmptyParagraph = "<p family=\"0\" font=\"\" pitch=\"0\"/>";
        String LocateParagraph = "<p family=\"0\" font=\"\" pitch=\"0\"";
        String OpenParagraph = "<p family=\"0\" font=\"\" pitch=\"0\">";
        String CloseParagraph = "</p>";
        String TabbedParagraph = "</p><p family=\"0\" font=\"\" pitch=\"0\"><tab /><tab /><tab />";

        StringBuilder replacementNSML = null;
        cuesheet = exportData.getStoryAsNSML().indexOf(_configuration.cuesheet_id);
        bodyClose = exportData.getStoryAsNSML().indexOf(BodyCloseTag);

        String StoryFoot;

        if (bodyClose < 1)
        {
            // something very wrong
            return null;
        }

        // take a copy of the end of the document
        StoryFoot = exportData.getStoryAsNSML().substring(bodyClose);

        if (cuesheet > 0)
        {
            // we have an existing cue sheet section so remove it now
            replacementNSML = new StringBuilder(exportData.getStoryAsNSML().substring(0, cuesheet));
        }
        else
        {
            // no existing locators so simply remove the existing story end
            replacementNSML = new StringBuilder(exportData.getStoryAsNSML().substring(0, bodyClose));

        }

        // remove empty paragraphs from end of story body
        while (replacementNSML.lastIndexOf(LocateParagraph) >= replacementNSML.length() - EmptyParagraph.length())
        {
            replacementNSML = replacementNSML.delete(replacementNSML.lastIndexOf(EmptyParagraph), replacementNSML.length());
        }

        // add one paragraph as a spacer
        replacementNSML.append(EmptyParagraph);

        // Put back the locators header
        replacementNSML.append(OpenParagraph);
        replacementNSML.append(_configuration.cuesheet_id);
        replacementNSML.append(CloseParagraph);

        // and a paragraph
        replacementNSML.append(EmptyParagraph);

        // the new cue sheet details
        for (MarkerData marker : exportData.getResponse().getMarkers())
        {
            // open paragraph
            replacementNSML.append(OpenParagraph);

            // write the marker
            replacementNSML.append(marker.Start);
            replacementNSML.append(",");
            replacementNSML.append(marker.Duration);
            replacementNSML.append(",");

            // look for escape characters in the comment and encode them
            marker.Comment = marker.Comment.replace("&", "&amp;");
            marker.Comment = marker.Comment.replace("<", "&lt;");
            marker.Comment = marker.Comment.replace(">", "&gt;");
            // first get any line breaks
            String[] markerLines = marker.Comment.split("['\n']");

            for (int i = 0; i < markerLines.length; i++ )
            {
                // write the text
                replacementNSML.append(markerLines[i]);

                // and a new paragraph
                if (i < (markerLines.length - 1))
                {
                    replacementNSML.append(TabbedParagraph);
                }
            }

            // close the (final) paragraph
            replacementNSML.append(CloseParagraph);
        }

        // finally the original footer
        replacementNSML.append(StoryFoot);
        return replacementNSML.toString();
    }

}
