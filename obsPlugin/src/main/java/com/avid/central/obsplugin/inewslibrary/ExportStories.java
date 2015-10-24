/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avid.central.obsplugin.inewslibrary;

import com.avid.central.obsplugin.Configuration.ExportConfiguration;
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

/**
 *
 * @author Administrator
 */
public class ExportStories {

    /* ******************************************************* Rules for parsing rundown for a rundown export ********************************************************* */
    /* XML tag              iNews criteria                                                                      Can be empty    Action if Empty                         */
    /* OBSChannelID	    break story with "OBSChannelName" in info field, value is in Subject field  	No	        Warn user, don't export                 */
    /* Name	            break story with "Name" in Info field, date is in Subject field             	No          	Warn user, don't export                 */
    /* Date                 break story with "Date" in Info field, date is in Subject field                     Yes             Warn user, pre-fill with current date   */
    /* StartTime            the first break story in rundown with a value in Start time field format: HH:MM:SS	No              Warn user, don't export                 */
    /* EndTime              the last break story in rundown with a value in Start time field format: HH:MM:SS	No              Warn user, don't export                 */
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
    public ExportStoryData ProcessRundown(List<Nsml> stories, ExportConfiguration config, boolean mdsMode) {
        ExportStoryData exportData = new ExportStoryData();

        // create a new OBS_Export
        ExportRundown _export = new ExportRundown();

        // Represents the starting time of an item, can be calculated from previous item start time or set explicitly by the user
        int currentStartTime = 0;

        // Flags the fact that the previous Story parsed was a break with a defined time
        boolean lastStoryWasBreak = false;

        // Flags the fact that we have now validated the header
        boolean headerValid = false;

        // do everything inside a try {} block
        // if we encounter any of the conditions listed above which preclude exporting the rundown
        // then we throw an exception which includes the reason why
        try {
            // go through stories and decide what to do with each
            for (Nsml story : stories) {
                // TODO
                List<OBSGraphic> vizGrapics = new ArrayList<OBSGraphic>();

                // is this a break story?
                if (story.getHead().getMeta().isBreak()) {
                    // yes it is
                    // need to get the content of the info Field
                    String info = GetFieldStringValue(story.getFields().getStringOrBooleanOrDate(), config.info_field);
                    if (null == info) {
                        throw new Exception("Invalid story, no info");
                    }

                    String subject = GetFieldStringValue(story.getFields().getStringOrBooleanOrDate(), config.subject_field);
                    if (null == subject) {
                        throw new Exception("Invalid story, no subject");
                    }

                    String startTime = GetFieldStringValue(story.getFields().getStringOrBooleanOrDate(), config.start_time_field);
                    if (null == startTime) {
                        throw new Exception("Invalid story, no start time");
                    }

                    // is it one of our "special" fields
                    if (info.equals(config.obs_channel_id)) {
                        if (subject.length() == 0) {
                            // the channelID is missing so abort the export
                            throw new Exception("Invalid story, empty channel ID field");
                        }

                        // this is the Story that contains the channel ID
                        _export.Rundown.ChannelID = subject;
                    } else if (info.equals(config.name_id)) {
                        if (subject.length() == 0) {
                            // the rundown name is missing so abort the export
                            throw new Exception("Invalid story, empty channel name field");
                        }

                        // this is the Story that contains the rundown name
                        _export.Rundown.ChannelName = subject;
                    } else if (info.equals(config.day_id)) {
                        // this is the Story that contains the rundown day
                        _export.Rundown.Day = subject;

                        if (subject.length() < 1) {
                            // log a warning here (no date specified)
                            // set date to today's date
                            _export.Rundown.Day = String.format("Day %1$02d", DateTime.now().dayOfMonth());
                            exportData.Warning = "Empty day field";
                        }
                    } else if (info.equals(config.date_id)) {
                        // this is the Story that contains the rundown date
                        _export.Rundown.Date = subject;

                        if (subject.length() < 1) {
                            // log a warning here (no date specified)
                            // set date to today's date
                            DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-mm-dd");
                            _export.Rundown.Date = _export.Rundown.Day = DateTime.now().toString(dtf);
                            exportData.Warning = "Empty date field";
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
                } else if (!story.getHead().getMeta().isFloat()) {
                    // this is not a floated Story so we must have passed the "header"
                    // if we haven't validated the "header" at this point then now is the time to do so!
                    if (!headerValid) {
                        if (-1 == _export.Rundown.RundownStartTime) {
                            // the start time has not been set so abort the export
                            throw new Exception("Invalid story, empty start time field");
                        }

                        headerValid = true;
                    }

                    // every time we encounter a non-break, non-floated Story reset the rundown end time to unspecified
                    // it should get set to the correct value by the final break Story
                    _export.Rundown.RundownEndTime = -1;

                    // get the subject
                    String subject = GetFieldStringValue(story.getFields().getStringOrBooleanOrDate(), config.subject_field);
                    if (null == subject) {
                        throw new Exception("Invalid story, no subject");
                    }

                    if (subject.length() == 0) {
                        throw new Exception("Invalid story, empty subject field");
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
                    if (mdsMode) {
                        if (null == storyID) {
                            throw new Exception("Invalid story, no story ID");
                        }
                        if (storyID.length() == 0) {
                            throw new Exception("Invalid story, empty story ID field");
                        }
                    }

                    // get the VideoID
                    String videoID = GetFieldStringValue(story.getFields().getStringOrBooleanOrDate(), config.video_id_field);
                    if (mdsMode) {
                        if (null == videoID) {
                            throw new Exception("Invalid story, no video ID");
                        }
                        if (videoID.length() == 0) {
                            throw new Exception("Invalid story, empty video ID field");
                        }
                    } else if (null == videoID || videoID.isEmpty()) {
                        videoID = "";
                    }

                    // get the Upmix
                    String upMix = GetFieldStringValue(story.getFields().getStringOrBooleanOrDate(), config.upmix_field);
                    if (mdsMode) {
                        if (null == upMix) {
                            throw new Exception("Invalid story, no upmix");
                        }
                        if (upMix.length() == 0) {
                            throw new Exception("Invalid story, empty upmix field");
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
                    if (mdsMode && null != story.getAeset() && story.getAeset().getAe().size() > 0) {
                        // is there one for VIZ?
                        for (Ae ae : story.getAeset().getAe()) {
                            //TODO
                                /*
                             if (ae..Contains(config.VizID))
                             {
                             // we have a VIZ cue, look for its attachment
                             if (null == st.Attachments || st.Attachments.Count <= 0) continue;
                             foreach (String at in st.Attachments)
                             {
                             if (ae.idref != at.id) continue;
                             // this is the attachment for this VIZ cue
                             // create a graphic element for it
                             String graphic = GetGraphicData(at.data);
                             if (null != graphic)
                             {
                             vizGrapics.Add(graphic);
                             }
                             }
                             }
                             */
                        }
                    }

                    if (0 == vizGrapics.size()) {
                        exportData.Warning = "No Viz Cue";
                    }

                    // Story looks OK so add it to the export
                    OBSStory obsStory = new OBSStory();
                    obsStory.Type = GetFieldStringValue(story.getFields().getStringOrBooleanOrDate(), config.type_field);
                    obsStory.StoryStartTime = currentStartTime;
                    obsStory.StoryDuration = GetFieldIntegerValue(story.getFields().getStringOrBooleanOrDate(), config.duration_field);
                    obsStory.VideoID = videoID;

                    if (mdsMode) {
                        obsStory.StoryID = storyID;
                        obsStory.Upmix = upMix == "1";
                        obsStory.Runout = rundown;
                        obsStory.Runup = runup;
                        obsStory.Graphics = vizGrapics;
                    }

                    // need to get the story body free of all formatting
                    String storyBody = GetStoryBody(story);

                    //TODO
//                        int cueSheetLocation = story.getBody()..IndexOf("[CUESHEET INFO]", StringComparison.Ordinal);
                    int cueSheetLocation = 0;
                    String scriptInfo = null;
                    String cueSheet = null;

                    // look for a Cue Sheet section
                    if (cueSheetLocation > 0) {
                        // there is a cue sheet so leave it out of the script info
                        //TODO
                            /*
                         scriptInfo = st.body.Substring(0, cueSheetLocation);

                         // but include it with the cue sheet
                         if (st.body.length() > cueSheetLocation + Properties.Resources.CueSheetIdentifier.length())
                         {
                         cueSheet = st.body.Substring(cueSheetLocation + Properties.Resources.CueSheetIdentifier.length());
                         }
                         */
                    } else {
                        // no cue sheet so use story body "as is"
                        //TODO
                        scriptInfo = storyBody;
                    }

                    obsStory.ScriptInfo = scriptInfo;
                    if (mdsMode) {
                        obsStory.CueSheet = cueSheet;
                    }

                    _export.Stories.add(obsStory);

                    lastStoryWasBreak = false;
                }

            }

            // check that we have an end time
            if (-1 == _export.Rundown.RundownEndTime) {
                // nope, reject this one
                throw new Exception("Invalid story : empty end time field");
            }

            // check for Channel ID
            if (_export.Rundown.ChannelID.length() == 0) {
                throw new Exception("Invalid story : empty channel ID field");
            }

            // check for Channel Name
            if (_export.Rundown.ChannelName.length() == 0) {
                throw new Exception("Invalid story : empty channel name field");
            }

            // check for Date
            if (_export.Rundown.Date.length() == 0) {
                // log a warning here (no date specified)
                // set date to today's date
                _export.Rundown.Date = DateTime.now().toString("mmddyy");
                exportData.Warning = "Empty date field";
            }

            // check for Day
            if (_export.Rundown.Day.length() == 0) {
                // log a warning here (no day specified)
                // set date to today's date
                _export.Rundown.Day = _export.Rundown.Day = String.format("Day%1$02d", DateTime.now().dayOfMonth().get());
                exportData.Warning = "Empty day field";
            }

            exportData.StoryAsXml = _export.GenerateXML(mdsMode);
            exportData.FileName = _export.GenerateFileName();
            exportData.Success = true;
        } catch (Exception ex) {
            exportData.Warning = ex.getMessage();
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
            javax.xml.bind.JAXBElement element = (JAXBElement)content;
             
            if (element.getValue().getClass() == com.avid.central.obsplugin.inewslibrary.nsml.TextContent.class)
            {
                com.avid.central.obsplugin.inewslibrary.nsml.TextContent tc = (com.avid.central.obsplugin.inewslibrary.nsml.TextContent)element.getValue();
            for (Serializable moreContent : tc.getContent()) {

                ParseContent(moreContent, sb);

            }}
        }
    }
}
