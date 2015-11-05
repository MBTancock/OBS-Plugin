/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avid.central.obsplugin.inewslibrary;

import com.avid.central.obsplugin.Configuration.ExportConfiguration;
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
    public ExportStoryData ProcessRundown(List<Nsml> stories, ExportConfiguration config) {
        ExportStoryData exportData = new ExportStoryData();

        // create a new OBS_Export
        ExportRundown _export = new ExportRundown();

        // Represents the starting time of an item, can be calculated from previous item start time or set explicitly by the user
        int currentStartTime = 0;

        // Flags the fact that the previous Story parsed was a break with a defined time
        boolean lastStoryWasBreak = false;

        // Flags the fact that we have now validated the header
        boolean headerValid = false;

        String cutsheetInfo = "[CUESHEET INFO]";

        // do everything inside a try {} block
        // if we encounter any of the conditions listed above which preclude exporting the rundown
        // then we throw an exception which includes the reason why
        try {
            // go through stories and decide what to do with each
            for (Nsml story : stories) {
                // TODO
                List<mos> vizGrapics = new ArrayList<mos>();

                // is this a break story?
                if (story.getHead().getMeta().isBreak()) {
                    // yes it is
                    // need to get the content of the info Field
                    String info = GetFieldStringValue(story.getFields().getStringOrBooleanOrDate(), config.info_field);
                    if (null == info) {
                        throw new Exception("The rundown is invalid: the designated info field was not found");
                    }

                    String subject = GetFieldStringValue(story.getFields().getStringOrBooleanOrDate(), config.subject_field);
                    if (null == subject) {
                        throw new Exception("The rundown is invalid: the designated subject field was not found");
                    }

                    String startTime = GetFieldStringValue(story.getFields().getStringOrBooleanOrDate(), config.start_time_field);
                    if (null == startTime) {
                        throw new Exception("The rundown is invalid: the designated start time field was not found");
                    }

                    // is it one of our "special" fields
                    if (info.equals(config.obs_channel_id)) {
                        if (subject.length() == 0) {
                            // the channelID is missing so abort the export
                            throw new Exception("The rundown is invalid: the rundown Channel ID is missing");
                        }

                        // this is the Story that contains the channel ID
                        _export.Rundown.ChannelID = subject;

                        // determine the mode
                        exportData.setMdsMode(subject.toUpperCase().startsWith("MX"));

                    } else if (info.equals(config.title_id)) {
                        if (subject.length() == 0) {
                            // the rundown name is missing so abort the export
                            throw new Exception("The rundown is invalid: the rundown Channel Name is missing");
                        }

                        // this is the Story that contains the rundown name
                        _export.Rundown.Title = subject;
                    } else if (info.equals(config.day_id)) {
                        // this is the Story that contains the rundown day
                        _export.Rundown.Day = subject;

                        if (subject.length() < 1) {
                            // log a warning here (no date specified)
                            // set date to today's date
                            _export.Rundown.Day = String.format("Day %1$02d", DateTime.now().dayOfMonth());
                            exportData.getResponse().setMessage("The day information was missing from the rundown");
                        }
                    } else if (info.equals(config.date_id)) {
                        // this is the Story that contains the rundown date
                        _export.Rundown.Date = subject;

                        if (subject.length() < 1) {
                            // log a warning here (no date specified)
                            // set date to today's date
                            DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-mm-dd");
                            _export.Rundown.Date = _export.Rundown.Day = DateTime.now().toString(dtf);
                            exportData.getResponse().setMessage("The date information was missing from the rundown");
                        }
                    }

                    // do we have start time data?
                    if (startTime.length() > 0) {
                        // update the running start time
                        if (startTime.charAt(0) == '@') {
                            // we have an absolute start time
                            currentStartTime = Integer.parseInt(startTime.substring(1));
                        } else {
                            // start time is relative to start of show
                            currentStartTime = Integer.parseInt(startTime.substring(1)) + _export.Rundown.RundownStartTime;
                        }

                        // have we set the rundown start time yet?
                        if (-1 == _export.Rundown.RundownStartTime) {
                            _export.Rundown.RundownStartTime = currentStartTime;
                        } else {
                            // just update the end time
                            _export.Rundown.RundownEndTime = currentStartTime;
                        }

                        lastStoryWasBreak = true;
                    }
                } else {
                    if (!story.getHead().getMeta().isFloat()) {
                        // this is not a floated Story so we must have passed the "header"
                        // if we haven't validated the "header" at this point then now is the time to do so!
                        if (!headerValid) {
                            if (-1 == _export.Rundown.RundownStartTime) {
                                // the start time has not been set so abort the export
                                throw new Exception("The rundown is invalid: the rundown start time is missing");
                            }

                            headerValid = true;
                        }

                        // every time we encounter a non-break, non-floated Story reset the rundown end time to unspecified
                        // it should get set to the correct value by the final break Story
                        _export.Rundown.RundownEndTime = -1;

                        // get the subject
                        String subject = GetFieldStringValue(story.getFields().getStringOrBooleanOrDate(), config.subject_field);
                        if (null == subject) {
                            throw new Exception("The rundown is invalid: the designated subject field was not found");
                        }

                        if (subject.length() == 0) {
                            throw new Exception("The rundown is invalid: at least one story is missing its Subject details");
                        }

                        // check for an update and retrieve modification time
                        String updatedTimestamp = null;
                        int update = GetFieldIntegerValue(story.getFields().getStringOrBooleanOrDate(), config.update_field);
                        DateTime modificationTime = GetFieldDateValue(story.getFields().getStringOrBooleanOrDate(), config.modified_field);
                        if (null != modificationTime) {
                            DateTimeFormatter fmt = ISODateTimeFormat.dateHourMinuteSecond();
                            updatedTimestamp = modificationTime.toString(fmt);
                        }

                        // get the start time
                        String startTime = GetFieldStringValue(story.getFields().getStringOrBooleanOrDate(), config.start_time_field);

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

                        // get the StoryID
                        String storyID = GetFieldStringValue(story.getFields().getStringOrBooleanOrDate(), config.story_id_field);
                        if (exportData.getMdsMode()) {
                            if (null == storyID) {
                                throw new Exception("The rundown is invalid: the designated StoryID field was not found");
                            }
                            if (storyID.length() == 0) {
                                throw new Exception("The rundown is invalid: at least one story is missing its StoryID details");
                            }
                        }

                        // get the VideoID
                        String videoID = GetFieldStringValue(story.getFields().getStringOrBooleanOrDate(), config.video_id_field);
                        if (exportData.getMdsMode()) {
                            if (null == videoID) {
                                throw new Exception("The rundown is invalid: the designated VideoID field was not found");
                            }
                            if (videoID.length() == 0) {
                                throw new Exception("The rundown is invalid: at least one story is missing its VideoID details");
                            }
                        } else if (null == videoID || videoID.isEmpty()) {
                            videoID = "";
                        }

                        // get the Upmix
                        String upMix = GetFieldStringValue(story.getFields().getStringOrBooleanOrDate(), config.upmix_field);
                        if (exportData.getMdsMode()) {
                            if (null == upMix) {
                                throw new Exception("The rundown is invalid: the designated upmix field was not found");
                            }
                            if (upMix.length() == 0) {
                                throw new Exception("The rundown is invalid: at least one story is missing its upmix details");
                            }
                        }

                        // get the Music
                        String music = GetFieldStringValue(story.getFields().getStringOrBooleanOrDate(), config.music_field);
                        if (exportData.getMdsMode()) {
                            if (null == music || music.length() == 0) {
                                exportData.getResponse().setMessage("At least one story is missing its music element");
                            }
                        }

                        // get Runup
                        String runup = GetFieldStringValue(story.getFields().getStringOrBooleanOrDate(), config.runup_field);
                        if (null == runup || runup.isEmpty()) {
                            runup = "0";
                        }

                        // get Rundown
                        String rundown = GetFieldStringValue(story.getFields().getStringOrBooleanOrDate(), config.rundown_field);
                        if (null == rundown || rundown.isEmpty()) {
                            rundown = "0";
                        }

                        // get VIZ production cue
                        // are there any anchored elements?
                        if (exportData.getMdsMode()) {
                            if (null != story.getAeset() && story.getAeset().getAe().size() > 0) {
                                // is there one for VIZ?
                                for (Ae ae : story.getAeset().getAe()) {

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

                                                    for (AttachmentType at : story.getAesetAtts().getAttachment()) {
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
                                                                    String s = ex.getMessage();
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
                        obsStory.Type = GetFieldStringValue(story.getFields().getStringOrBooleanOrDate(), config.type_field);
                        obsStory.StoryStartTime = currentStartTime;
                        obsStory.StoryDuration = GetFieldIntegerValue(story.getFields().getStringOrBooleanOrDate(), config.duration_field);
                        obsStory.VideoID = videoID;

                        if (exportData.getMdsMode()) {
                            obsStory.StoryID = storyID;
                            obsStory.Upmix = upMix == "1";
                            obsStory.Runout = rundown;
                            obsStory.Runup = runup;
                            obsStory.Music = music;
                            obsStory.Graphics = vizGrapics;
                        } else {
                            if (null != updatedTimestamp) {
                                obsStory.Modified = updatedTimestamp;
                                obsStory.Update = true;
                            }
                        }

                        // need to get the story body free of all formatting
                        String storyBody = GetStoryBody(story);

                        int cueSheetLocation = storyBody.indexOf(cutsheetInfo);
                        String scriptInfo = null;
                        String cueSheet = null;

                        // look for a Cue Sheet section
                        if (cueSheetLocation >= 0) {
                            scriptInfo = storyBody.substring(0, cueSheetLocation);

                            if (exportData.getMdsMode() && storyBody.length() > (cueSheetLocation + cutsheetInfo.length())) {
                                cueSheet = storyBody.substring(cueSheetLocation + cutsheetInfo.length());
                            }
                        } else {
                            scriptInfo = storyBody;
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
                // nope, reject this one
                throw new Exception("The rundown is invalid: the rundown end time is missing");
            }

            // check for Channel ID
            if (_export.Rundown.ChannelID.length() == 0) {
                throw new Exception("The rundown is invalid: the rundown Channel ID is missing");
            }

            // check for Channel Name
            if (_export.Rundown.Title.length() == 0) {
                throw new Exception("The rundown is invalid: the rundown Title is missing");
            }

            // check for Date
            if (_export.Rundown.Date.length() == 0) {
                // log a warning here (no date specified)
                // set date to today's date
                _export.Rundown.Date = DateTime.now().toString("dd MMM yyyy");
                exportData.getResponse().setMessage("The date information was missing from the rundown");
            } else {
                exportData.getResponse().setDate(_export.Rundown.Date);
            }

            // check for Day
            if (_export.Rundown.Day.length() == 0) {
                // log a warning here (no day specified)
                // set date to today's date
                _export.Rundown.Day = String.format("Day%1$02d", DateTime.now().dayOfMonth().get());
                exportData.getResponse().setMessage("The day information was missing from the rundown");
            } else {
                exportData.getResponse().setDay(_export.Rundown.Day);
            }

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
                    return stringField.getValue();
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
                    return (int) durationField.getValue().intValue();
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
