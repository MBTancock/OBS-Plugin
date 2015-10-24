/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avid.central.obsplugin.inewslibrary;

import com.avid.central.obsplugin.inewslibrary.rundown.Rundown;
import com.avid.central.obsplugin.inewslibrary.rundown.Rundown.StorySession;
import com.avid.central.obsplugin.inewslibrary.rundown.Rundown.StorySession.Story;
import com.avid.central.obsplugin.inewslibrary.rundown.StoryType;
import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.joda.time.format.DateTimeFormat;

/**
 *
 * @author Administrator
 */
public class ExportRundown {

    public OBSRundown Rundown;
    public List<OBSStory> Stories;

    public ExportRundown() {
        Rundown = new OBSRundown();
        Stories = new ArrayList<OBSStory>();
    }

        // generates a file name according to the defineed rules
    // <OBS ONC Channel Name*>_<YYYYMMDD>_<StartTime>_<EndTime>.xml
    public String GenerateFileName() {
        String fileName = Rundown.ChannelID;
        fileName += "_";
        fileName += Rundown.GetFileDate().toString(DateTimeFormat.forPattern("yyyyMMdd"));
        fileName += "_";
        fileName += Rundown.GetFileStartTime();
        fileName += "_";
        fileName += Rundown.GetFileEndTime();
        fileName += ".xml";

        return fileName;
    }

    // creates the output XML but does not export it
    public String GenerateXML(boolean isMds) throws JAXBException, DatatypeConfigurationException {
        Rundown exportRundown = new Rundown();

        exportRundown.setOBSChannelId(Rundown.ChannelID);
        exportRundown.setDay(Rundown.Day);
        exportRundown.setDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(Rundown.GetFileDate().toGregorianCalendar()));
        exportRundown.getDate().setTimezone(DatatypeConstants.FIELD_UNDEFINED);
        exportRundown.setRundownStartTime(Rundown.GetStartTime());
        exportRundown.setRundownEndTime(Rundown.GetEndTime());

        // create the StorySession which will hold the stories
        StorySession session = new StorySession();
        exportRundown.setStorySession(session);

        // get the story list        
        List<Story> stories = session.getStory();

        for (OBSStory story : Stories) {
            Story obsStory = new Story();
            obsStory.setStartTime(story.GetStartTime());
            obsStory.setDuration(story.GetDuration());

            switch (story.Type.toUpperCase()) {
                case "ATMOSPHERE":
                    obsStory.setType(StoryType.ATMOSPHERE);
                    break;

                case "BEAUTY":
                    obsStory.setType(StoryType.BEAUTY);
                    break;

                case "CLOSE":
                    obsStory.setType(StoryType.CLOSE);
                    break;

                case "COMING UP":
                    obsStory.setType(StoryType.COMING_UP);
                    break;

                case "FEATURE":
                    obsStory.setType(StoryType.FEATURE);
                    break;

                case "GRAPHIC":
                    obsStory.setType(StoryType.GRAPHIC);
                    break;

                case "HIGHLIGHTS":
                    obsStory.setType(StoryType.HIGHLIGHTS);
                    break;

                case "HISTORICAL":
                    obsStory.setType(StoryType.HISTORICAL);
                    break;

                case "INTERVIEW":
                    obsStory.setType(StoryType.INTERVIEW);
                    break;

                case "INTERVIEWS":
                    obsStory.setType(StoryType.INTERVIEWS);
                    break;

                case "INTRO":
                    obsStory.setType(StoryType.INTRO);
                    break;

                case "IOD":
                    obsStory.setType(StoryType.IOD);
                    break;

                case "LIVE":
                    obsStory.setType(StoryType.LIVE);
                    break;

                case "MONTAGE":
                    obsStory.setType(StoryType.MONTAGE);
                    break;

                case "OPENING":
                    obsStory.setType(StoryType.OPENING);
                    break;

                case "PROMOS":
                    obsStory.setType(StoryType.PROMOS);
                    break;

                case "REPLAY":
                    obsStory.setType(StoryType.REPLAY);
                    break;

                case "SPORT":
                    obsStory.setType(StoryType.SPORT);
                    break;

                case "STF":
                    obsStory.setType(StoryType.STF);
                    break;

                case "TIMESHIFT":
                    obsStory.setType(StoryType.TIMESHIFT);
                    break;

                case "VARIOUS":
                    obsStory.setType(StoryType.VARIOUS);
                    break;

                case "TRANSITION":
                    obsStory.setType(StoryType.TRANSITION);
                    break;

                case "REVIEW":
                    obsStory.setType(StoryType.REVIEW);
                    break;

                case "HISTORIC":
                    obsStory.setType(StoryType.HISTORIC);
                    break;

                case "TORCH":
                    obsStory.setType(StoryType.TORCH);
                    break;

                case "CEREMONY":
                    obsStory.setType(StoryType.CEREMONY);
                    break;

                case "MEDALS":
                    obsStory.setType(StoryType.MEDALS);
                    break;

                case "PROFILE":
                    obsStory.setType(StoryType.PROFILE);
                    break;

                default:
                    obsStory.setType(StoryType.FILLER);
                    break;
            }

            obsStory.setVideoID(story.VideoID);
            obsStory.setStoryID(story.StoryID);
            obsStory.setScriptInfo(story.ScriptInfo);

            if (isMds) {
                // data only exported for MDS
                obsStory.setComUpmix(story.Upmix);
                obsStory.setCuesheet(story.CueSheet);
                obsStory.setRunout(story.Runout);
                obsStory.setRunup(story.Runup);

                        //TODO
                        /*
                 obsStory. = new List<RundownStoryGraphic>();
                 if (null != story.Graphics)
                 {
                 foreach (var graphic in story.Graphics)
                 {
                 var rsg = new RundownStoryGraphic
                 {
                 GraphTemplate = graphic.Template,
                 GraphDuration = graphic.Duration,
                 GraphOffset_IN = graphic.OffsetIn,
                 GraphOffset_OUT = graphic.OffsetOut
                 };

                 obsStory.Graphic.Add(rsg);
                 }
                 }
                 */
            }

            // TODO Add the story
            stories.add(obsStory);
        }

        // serialise the rundown
        // create the serialization object
        JAXBContext jc;
        Marshaller marshaller;
        StringWriter sw = new StringWriter();

        jc = JAXBContext.newInstance(com.avid.central.obsplugin.inewslibrary.rundown.Rundown.class);
        marshaller = jc.createMarshaller();

        marshaller.marshal(exportRundown, sw);

        return sw.toString();
    }
}
/*
 <?xml version="1.0" encoding="utf-8"?>
 <Rundown>
 <OBSChannelId>ONC</OBSChannelId>
 <Name>ONC Program 29th July 2011</Name>
 <Date>2011-07-29</Date>
 <StartTime>16:30:00</StartTime>
 <EndTime>17:00:00</EndTime>
 <StorySession>
 <Story>
 <StartTime>16:30:00</StartTime>
 <Duration>00:00:20</Duration>
 <Type>Titles</Type>
 <Subject>Intro animation</Subject>
 <ScriptInfo />
 </Story>
 <Story>
 <StartTime>16:59:22</StartTime>
 <Duration>00:00:38</Duration>
 <Type>Beauty</Type>
 <Subject>Beauty shot</Subject>
 <ScriptInfo> The International Olympic Committee has two new faces on board... </ScriptInfo>
 </Story>
 </StorySession>
 </Rundown>
 */
