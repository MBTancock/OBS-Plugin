/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avid.central.obsplugin.inewslibrary;

import com.avid.central.obsplugin.Configuration.ExportConfiguration;
import com.avid.central.obsplugin.datamodel.ExportStoryData;
import com.avid.central.obsplugin.inewslibrary.VizGraphic.AttachmentContent;
import com.avid.central.obsplugin.inewslibrary.VizGraphic.mos;
import com.avid.central.obsplugin.inewslibrary.nsml.ApContent;
import com.avid.central.obsplugin.inewslibrary.nsml.AttachmentType;
import com.avid.central.obsplugin.inewslibrary.nsml.Nsml;
import com.avid.central.obsplugin.inewslibrary.nsml.Nsml.Aeset.Ae;
import com.avid.central.obsplugin.inewslibrary.nsml.Nsml.Body.P;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;

import com.avid.central.obsplugin.inewslibrary.story.Story;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

/**
 * @author Administrator
 */
public class ExportStories {

    /* ******************************************************* Rules for parsing rundown for a rundown export ********************************************************* */
    /* XML tag              iNews criteria                                                                      Can be empty    Action if Empty                         */
    /* OBSChannelID	        break story with "OBSChannelName" in info field, value is in Subject field  	No	        Warn user, don't export                 */
    /* Title	            break story with "Title" in Info field, data is in Subject field             	No          	Warn user, don't export                 */
    /* Date                 break story with "Date" in Info field, date is in Subject field                     Yes             Warn user, pre-fill with current date   */
    /* StartTime            the first break story in rundown with a value in Start time field format: HH:MM:SS	No              Warn user, don't export                 */
    /* EndTime              the last break story in rundown with a value in End time field format: HH:MM:SS	No              Warn user, don't export                 */
    /* **************************************************************************************************************************************************************** */

    /* ******************************************************* Rules for parsing stories for a rundown export ********************************************************* */
    /* XML tag              iNews criteria                                  Can be empty    Action if Empty                                                             */
    /* StartTime	    content of Start time field format: HH:MM:SS    Yes             Take start time from previous item and add previous item's duration to it   */
    /* Duration             content of Dur field format: HH:MM:SS           Yes             set value to 0                                                              */
    /* Type                 content of Type field                           Yes             set value to ""                                                             */
    /* Subject              content of Subject field                        No              Warn user, don't export                                                     */
    /* ScriptInfo           Story body, cleaned of all tags                 Yes             add empty StoryInfo tag <StoryInfo />                                       */
    /* **************************************************************************************************************************************************************** */
    // this is where the work of parsing and exporting the rundown is carried out
    // the rundown is the list of stories passed in as stories
    // from this identify significant parameters based on the rules defined above
    // returns the rundown as an XML string and the filename to be used in the fileName parameter
    private void RaiseError(String message) throws Exception
    {
        StringBuilder sb = new StringBuilder("The rundown is invalid: ");
        sb.append(message);
        throw new Exception(sb.toString());
    }

    public ExportStoryData ProcessRundown(List<Story> stories, ExportConfiguration config) {
        ExportStoryData exportData = new ExportStoryData(config);

        // create a new OBS_Export
        ExportRundown _export = new ExportRundown();

        // Represents the starting time of an item, can be calculated from previous item start time or set explicitly by the user
        int currentStartTime = 0;

        // Flags the fact that the previous Story parsed was a break with a defined time
        boolean lastStoryWasBreak = false;

        // Flags the fact that we have now validated the header
        boolean headerValid = false;

        // identifiers used in exporting cue sheets
        String CueSheetLocation = "<p family=\"0\" font=\"\" pitch=\"0\">" + config.cuesheet_id + "</p>";
        String BodyStart = "<body";
        String BodyEnd = "</body>";

        // do everything inside a try {} block
        // if we encounter any of the conditions listed above which preclude exporting the rundown
        // then we throw an exception which includes the reason why
        try {
            // go through stories and decide what to do with each
            for (Story story : stories) {
                List<mos> vizGrapics = new ArrayList<mos>();

                // is this a break story?
                if (story.Story.getHead().getMeta().isBreak()) {
                    // yes it is
                    // need to get the content of the info Field
                    String info = GetFieldStringValue(story.Story.getFields().getStringOrBooleanOrDate(), config.info_field);
                    if (null == info) {
                        RaiseError(String.format("field \"%s\" was not found", config.info_field));
                    }

                    String subject = GetFieldStringValue(story.Story.getFields().getStringOrBooleanOrDate(), config.subject_field);
                    if (null == subject) {
                        RaiseError(String.format("field \"%s\" was not found", config.subject_field));
                    }

                    // is it one of our "special" fields
                    if (info.equalsIgnoreCase(config.obs_channel_id)) {
                        if (subject.length() == 0) {
                            // the channelID is missing so abort the export
                            RaiseError(String.format("the rundown %s was not found", config.obs_channel_id));
                        }

                        // this is the Story that contains the channel ID
                        _export.Rundown.ChannelID = subject;

                        // determine the mode, first test for MDS
                        if (subject.toUpperCase().startsWith(config.mds_prefix.toUpperCase())) {
                            exportData.setMdsMode(true);
                        } else if (!subject.toUpperCase().startsWith(config.onc_prefix.toUpperCase()) && config.onc_prefix.length() > 0) {
                            RaiseError(String.format("the %s was not identified as an ONC or MDS rundown", config.obs_channel_id));
                        }

                    } else if (info.equalsIgnoreCase(config.title_id)) {
                        if (subject.length() == 0 && exportData.getValidateFields()) {
                            // the rundown name is missing so abort the export
                            RaiseError(String.format("the rundown %s was not found", config.title_id));
                        }

                        // this is the Story that contains the rundown name
                        _export.Rundown.Title = subject;
                    } else if (info.equalsIgnoreCase(config.day_id)) {
                        // this is the Story that contains the rundown day
                        if (subject.length() > 0) {
                            _export.Rundown.Day = subject;
                        }

                    } else if (info.equalsIgnoreCase(config.date_id)) {
                        // this is the Story that contains the rundown date
                        if (subject.length() > 0) {
                            _export.Rundown.Date = subject;
                        }
                    }

                    String startTime = GetFieldStringValue(story.Story.getFields().getStringOrBooleanOrDate(), config.start_time_field);
                    if (null == startTime && exportData.getValidateFields()) {
                        RaiseError(String.format("field \"%s\" was not found", config.start_time_field));
                    }

                    // check for start and end time data
                    if (subject.equalsIgnoreCase(config.start_id) && startTime.length() > 0) {
                        if (startTime.charAt(0) == '@') {
                            // we have an absolute start time
                            currentStartTime = Integer.parseInt(startTime.substring(1));
                            _export.Rundown.RundownStartTime = currentStartTime;
                        } else {
                            // start time is relative to start of show
                            currentStartTime = Integer.parseInt(startTime.substring(1)) + _export.Rundown.RundownStartTime;
                            _export.Rundown.RundownStartTime = currentStartTime;
                        }
                    } else if (subject.equalsIgnoreCase(config.end_id) && startTime.length() > 0) {
                        if (startTime.charAt(0) == '@') {
                            // we have an absolute end time
                            _export.Rundown.RundownEndTime = Integer.parseInt(startTime.substring(1));
                        } else {
                            // start time is relative to start of show
                            _export.Rundown.RundownEndTime = Integer.parseInt(startTime.substring(1)) + _export.Rundown.RundownStartTime;
                        }

                        lastStoryWasBreak = true;
                    }
                } else {
                    if (!story.Story.getHead().getMeta().isFloat()) {
                        // this is not a floated Story so we must have passed the "header"
                        // if we haven't validated the "header" at this point then now is the time to do so!
                        if (!headerValid) {
                            if (-1 == _export.Rundown.RundownStartTime && exportData.getValidateFields()) {
                                // the start time has not been set so abort the export
                                RaiseError("the rundown start time is missing");
                            }

                            headerValid = true;
                        }

                        // every time we encounter a non-break, non-floated Story reset the rundown end time to unspecified
                        // it should get set to the correct value by the final break Story
                        _export.Rundown.RundownEndTime = -1;

                        // get the subject
                        String subject = GetFieldStringValue(story.Story.getFields().getStringOrBooleanOrDate(), config.subject_field);
                        if (null == subject) {
                            RaiseError(String.format("field \"%s\" was not found", config.subject_field));
                        }

                        if (subject.length() == 0 && exportData.getValidateFields()) {
                            RaiseError("at least one story is missing its Subject details");
                        }

                        // check for an update and retrieve modification time
                        String updatedTimestamp = null;
                        int update = GetFieldIntegerValue(story.Story.getFields().getStringOrBooleanOrDate(), config.update_field);
                        DateTime modificationTime = GetFieldDateValue(story.Story.getFields().getStringOrBooleanOrDate(), config.modified_field);
                        if (null != modificationTime) {
                            DateTimeFormatter fmt = ISODateTimeFormat.dateHourMinuteSecond();
                            updatedTimestamp = modificationTime.toString(fmt);
                        }

                        // get the start time
                        String startTime = GetFieldStringValue(story.Story.getFields().getStringOrBooleanOrDate(), config.start_time_field);

                        // do we have start time data?
                        if (startTime != null && !startTime.isEmpty()) {
                            // update the running start time
                            if (startTime.charAt(0) == '@') {
                                // we have an absolute start time
                                currentStartTime = Integer.parseInt(startTime.substring(1));
                            } else {
                                // start time is relative to start of show
                                currentStartTime = Integer.parseInt(startTime.substring(1)) + _export.Rundown.RundownStartTime;
                            }
                        } else {
                            // no start time specified so we need to get it from the previous item
                            // if there are not yet any stories in the list then just use the start time we are carrying forward
                            if (_export.Stories.size() > 0 && !lastStoryWasBreak) {
                                // there is at least one Story
                                currentStartTime += _export.Stories.get(_export.Stories.size() - 1).StoryDuration;
                            }
                        }

                        // get the VideoID
                        String videoID = GetFieldStringValue(story.Story.getFields().getStringOrBooleanOrDate(), config.video_id_field);
                        if (exportData.getMdsMode()) {
                            if (null == videoID) {
                                RaiseError(String.format("field \"%s\" was not found", config.video_id_field));
                            }
                            if (videoID.length() == 0 && exportData.getValidateFields()) {
                                RaiseError("at least one story is missing its VideoID details");
                            }
                        } else if (null == videoID || videoID.isEmpty()) {
                            videoID = "";
                        }

                        // get the Type
                        String type = GetFieldStringValue(story.Story.getFields().getStringOrBooleanOrDate(), config.type_field);
                        if (exportData.getMdsMode()) {
                            if (null == type) {
                                RaiseError(String.format("field \"%s\" was not found", config.type_field));
                            }
                            if (type.length() == 0 && exportData.getValidateFields()) {
                                RaiseError("at least one story is missing its type details");
                            }
                        }

                        // get the Upmix
                        String upMix = GetFieldStringValue(story.Story.getFields().getStringOrBooleanOrDate(), config.upmix_field);
                        if (exportData.getMdsMode()) {
                            if (null == upMix) {
                                RaiseError(String.format("field \"%s\" was not found", config.upmix_field));
                            }
                            if (upMix.length() == 0 && exportData.getValidateFields()) {
                                RaiseError("at least one story is missing its upmix details");
                            }
                        }

                        // get the Music
                        String music = GetFieldStringValue(story.Story.getFields().getStringOrBooleanOrDate(), config.music_field);
                        if (exportData.getMdsMode()) {
                            if (null == music || music.length() == 0) {
                                exportData.getResponse().setMessage("At least one story is missing its music element");
                            }
                        }

                        if (!exportData.getMdsMode() && exportData.getValidateFields()) {
                            // get the Endorsement details
                            String endorseBy = GetFieldStringValue(story.Story.getFields().getStringOrBooleanOrDate(), config.endorse_field);
                            if (null == endorseBy) {
                                RaiseError(String.format("field \"%s\" was not found", config.endorse_field));
                            }
                            if (endorseBy.length() == 0) {
                                exportData.getResponse().setMessage("At least one story has not been approved");
//                                RaiseError("at least one story has not been approved");
                            }

                            // get the Export Approval flags
                            int approved = GetFieldIntegerValue(story.Story.getFields().getStringOrBooleanOrDate(), config.export_field);
                            if (approved == 0) {
                                RaiseError("at least one story is not ready for export");
                            }
                        }

                        // get VIZ production cue
                        // are there any anchored elements?
                        if (exportData.getCheckGrahics()) {
                            if (null != story.Story.getAeset() && story.Story.getAeset().getAe().size() > 0) {
                                // is there one for VIZ?
                                for (Ae ae : story.Story.getAeset().getAe()) {

                                    for (Object ap : ae.getMcOrAp()) {
                                        if (ap.getClass() != Nsml.Aeset.Ae.Mc.class) {
                                            continue;
                                        }

                                        Nsml.Aeset.Ae.Mc mc = (Nsml.Aeset.Ae.Mc) ap;
                                        for (Object content : mc.getAp()) {
                                            if (content.getClass() != ApContent.class) {
                                                continue;
                                            }

                                            ApContent apContent = (ApContent) content;
                                            for (Object data : apContent.getContent()) {
                                                if (data.getClass() == String.class) {
                                                    String graphic = (String) data;
                                                    if (!graphic.contains(config.viz_id)) {
                                                        continue;
                                                    }

                                                    for (AttachmentType at : story.Story.getAesetAtts().getAttachment()) {
                                                        if (mc.getIdref().equals(at.getId())) {
                                                            // found it!
                                                            String graphicData = at.getValue();
                                                            if (graphicData != null) {
                                                                try {
                                                                    AttachmentContent ac = AttachmentContent.Parse(graphicData);
                                                                    if (ac != null) {
                                                                        vizGrapics.add(ac.mos);
                                                                    }
                                                                } catch (Exception ex) {
                                                                }

                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                            if (0 == vizGrapics.size()) {
                                exportData.getResponse().setMessage("At least one story is missing its graphic element");
                            }
                        }

                        // Story looks OK so add it to the export
                        OBSStory obsStory = new OBSStory();

                        obsStory.Subject = subject;
                        obsStory.Type = type;
                        obsStory.StoryStartTime = currentStartTime;
                        obsStory.StoryDuration = GetFieldIntegerValue(story.Story.getFields().getStringOrBooleanOrDate(), config.duration_field);
                        obsStory.VideoID = videoID;

                        if (exportData.getMdsMode()) {
                            obsStory.Upmix = upMix.equals("1") || upMix.equals("true");
                            obsStory.Music = music;
                            obsStory.Graphics = vizGrapics;
                        } else {
                            if (null != updatedTimestamp) {
                                obsStory.Modified = updatedTimestamp;
                                obsStory.Update = update == 1;
                            }
                        }

                        // the story body as NSML
                        String formattedBody;

                        // unformatted version of the story body
                        String unformattedBody;

                        // the contents of the script info tag
                        String scriptInfo = null;

                        // the contents of the cue sheet tag
                        String cueSheet = null;

                        int cueSheetLocation = -1;

                        // get the story body free of all formatting
                        unformattedBody = GetStoryBody(story.Story);

                        // look for escape characters in the value and encode them
                        unformattedBody = unformattedBody.replace("&", "&amp;");
                        unformattedBody = unformattedBody.replace("\"", "&quot;");
                        unformattedBody = unformattedBody.replace("<", "&lt;");
                        unformattedBody = unformattedBody.replace(">", "&gt;");
                        unformattedBody = unformattedBody.replace("'", "&apos;");

                        // now look for a cue sheet
                        cueSheetLocation = unformattedBody.indexOf(config.cuesheet_id);

                        if (cueSheetLocation >= 0) {
                            // there is a cue sheet so extract it from the unformatted body if MDS mode
                            if (exportData.getMdsMode() && unformattedBody.length() > (cueSheetLocation + config.cuesheet_id.length())) {
                                cueSheet = unformattedBody.substring(cueSheetLocation + config.cuesheet_id.length());
                            }

                            // crop the cue sheet from the unformatted body
                            unformattedBody = unformattedBody.substring(0, cueSheetLocation);
                        }

                        // we now have the unformatted body free of cue sheet data together with the cue sheet if it exists

                        // are we exporting the story in its formatted version?
                        if (exportData.getRetainFormatting()) {
                            formattedBody = "";

                            // get the formatted story body
                            // first get offsets to body tags
                            int storyStart = story.StoryAsNSML.indexOf(BodyStart);
                            int storyEnd = story.StoryAsNSML.indexOf(BodyEnd);

                            // check for non-empty body
                            if (-1 != storyEnd) {
                                // make sure we extract the end tag
                                storyEnd += BodyEnd.length();
                                formattedBody = story.StoryAsNSML.substring(storyStart, storyEnd);
                                // now we have the formatted story body

                                // if the story is not empty and has a cue sheet section we need to remove it
                                cueSheetLocation = formattedBody.indexOf(CueSheetLocation);

                                if (cueSheetLocation >= 0 && unformattedBody.length() > 0) {
                                    // there is a cue sheet and the story isn't empty so we need to remove the cue sheet from the formatted body
                                    String script = formattedBody.substring(0, cueSheetLocation);
                                    // add back the body end tag
                                    script += BodyEnd;
                                    scriptInfo = "<![CDATA[\n" + script + "]]>";

                                } else if (unformattedBody.length() > 0) {
                                    scriptInfo = "<![CDATA[\n" + formattedBody + "]]>";
                                }

                            }

                        } else {
                            // simply export the unformatted body
                            scriptInfo = unformattedBody;
                        }

                        obsStory.ScriptInfo = scriptInfo;
                        if (exportData.getMdsMode() && null != cueSheet) {
                            obsStory.CueSheet = cueSheet;
                        }

                        _export.Stories.add(obsStory);

                        lastStoryWasBreak = false;
                    }
                }
            }

            // check that we have an end time
            if (-1 == _export.Rundown.RundownEndTime) {
                if (exportData.getValidateFields()) {
                    // nope, reject this one
                    RaiseError("the rundown end time is missing");
                } else {
                    _export.Rundown.RundownEndTime = _export.Rundown.RundownStartTime;
                }
            }

            // check for Channel ID
            if (_export.Rundown.ChannelID.length() == 0 && exportData.getValidateFields()) {
                RaiseError(String.format("the rundown %s is missing", config.obs_channel_id));
            }

            // check for Channel Name
            if (_export.Rundown.Title.length() == 0 && exportData.getValidateFields()) {
                RaiseError(String.format("the rundown %s is missing", config.title_id));
            }

            // check for Date
            if (_export.Rundown.Date.length() == 0) {
                // log a warning here (no date specified)
                // set date to today's date
                DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-mm-dd");
                _export.Rundown.Date = DateTime.now().toString(dtf);
                if (null == exportData.getResponse().getMessage()) {
                    exportData.getResponse().setMessage("The date information was missing from the rundown");
                }
            }
            exportData.getResponse().setDate(_export.Rundown.Date);

            // check for Day
            if (_export.Rundown.Day.length() == 0) {
                // log a warning here (no day specified)
                // set date to today's date
                _export.Rundown.Day = String.format("%02d", DateTime.now().dayOfMonth().get());
                if (null == exportData.getResponse().getMessage()) {
                    exportData.getResponse().setMessage("The day information was missing from the rundown");
                }
            }
            exportData.getResponse().setDay(_export.Rundown.Day);

            exportData.setRundownAsXml(_export.GenerateXML(exportData.getMdsMode()));

            exportData.getResponse().setChannelID(_export.Rundown.ChannelID);
            exportData.getResponse().setStartTime(_export.Rundown.GetStartTime());
            exportData.getResponse().setEndTime(_export.Rundown.GetEndTime());
            exportData.getResponse().setTitle(_export.Rundown.Title);

            exportData.getResponse().setFileName(_export.GenerateFileName());
            exportData.getResponse().setResult(1);
        } catch (Exception ex) {
            exportData.getResponse().setMessage(ex.getMessage());
        }

        return exportData;
    }

    public String GetFieldStringValue(List<Object> fields, String id) {
        for (Object field : fields) {
            if (field instanceof Nsml.Fields.String) {
                Nsml.Fields.String stringField = (Nsml.Fields.String) field;

                if (id.equals(stringField.getId())) {
                    String value = stringField.getValue();

                    // look for escape characters in the value and encode them
                    value = value.replace("&", "&amp;");
                    value = value.replace("\"", "&quot;");
                    value = value.replace("<", "&lt;");
                    value = value.replace(">", "&gt;");
                    value = value.replace("'", "&apos;");

                    return value;
                }
            } else if (field instanceof Nsml.Fields.Boolean) {
                Nsml.Fields.Boolean booleanField = (Nsml.Fields.Boolean) field;

                if (id.equals(booleanField.getId())) {
                    return String.valueOf(booleanField.isValue());
                }
            } else if (field instanceof Nsml.Fields.Date) {
                Nsml.Fields.Date dateField = (Nsml.Fields.Date) field;

                if (id.equals(dateField.getId())) {
                    return dateField.toString();
                }
            } else if (field instanceof Nsml.Fields.Duration) {
                Nsml.Fields.Duration durationField = (Nsml.Fields.Duration) field;

                if (id.equals(durationField.getId())) {
                    return durationField.toString();
                }
            }
        }

        return null;
    }

    public int GetFieldIntegerValue(List<Object> fields, String id) {
        for (Object field : fields) {
            if (field instanceof Nsml.Fields.String) {
                Nsml.Fields.String stringField = (Nsml.Fields.String) field;

                if (id.equals(stringField.getId())) {
                    return Integer.parseInt(stringField.getValue());
                }
            } else if (field instanceof Nsml.Fields.Boolean) {
                Nsml.Fields.Boolean booleanField = (Nsml.Fields.Boolean) field;

                if (id.equals(booleanField.getId())) {
                    return booleanField.isValue() ? 1 : 0;
                }
            } else if (field instanceof Nsml.Fields.Date) {
                Nsml.Fields.Date dateField = (Nsml.Fields.Date) field;

                if (id.equals(dateField.getId())) {
                    return 0;
                }
            } else if (field instanceof Nsml.Fields.Duration) {
                Nsml.Fields.Duration durationField = (Nsml.Fields.Duration) field;

                if (id.equals(durationField.getId())) {
                    return durationField.getValue().intValue();
                }
            }
        }

        return 0;
    }

    public DateTime GetFieldDateValue(List<Object> fields, String id) {
        for (Object field : fields) {
            if (field instanceof Nsml.Fields.Date) {
                Nsml.Fields.Date dateField = (Nsml.Fields.Date) field;

                if (id.equals(dateField.getId())) {
                    return new DateTime(dateField.getValue().longValue() * 1000L);
                }
            }
        }

        return null;
    }

    private String GetStoryBody(Nsml story) {
        StringBuilder sb = new StringBuilder();

        for (P para : story.getBody().getP()) {
            if (null == para) {
                continue;
            }
            for (Serializable content : para.getContent()) {

                ParseContent(content, sb);

            }
        }
        return sb.toString();
    }

    private void ParseContent(Serializable content, StringBuilder sb) {
        if (content.getClass() == String.class) {
            if (sb.length() > 0) {
                sb.append("\r\n");
            }
            sb.append(content);
        } else if (content.getClass() == JAXBElement.class) {
            javax.xml.bind.JAXBElement element = (JAXBElement) content;

            if (element.getValue().getClass() == com.avid.central.obsplugin.inewslibrary.nsml.TextContent.class) {
                com.avid.central.obsplugin.inewslibrary.nsml.TextContent tc = (com.avid.central.obsplugin.inewslibrary.nsml.TextContent) element.getValue();
                for (Serializable moreContent : tc.getContent()) {

                    ParseContent(moreContent, sb);

                }
            }
        }
    }
}
