/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avid.central.obsplugin.inewslibrary;

import com.avid.central.obsplugin.inewslibrary.VizGraphic.mos;
import com.avid.central.obsplugin.inewslibrary.rundown.Rundown;
import com.avid.central.obsplugin.inewslibrary.rundown.Rundown.StorySession;
import com.avid.central.obsplugin.inewslibrary.rundown.Rundown.StorySession.Story;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;

import org.joda.time.format.DateTimeFormat;

/**
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
        exportRundown.setTitle(Rundown.Title);
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
            obsStory.setSubject(story.Subject);
            if (null == story.Type) {
                obsStory.setType("Filler");
            } else {
                obsStory.setType(story.Type);
            }

            obsStory.setModified(story.Modified);
            if (story.Update)
            {
                obsStory.setUpdated(true);
            }

            obsStory.setVideoID(story.VideoID);
            obsStory.setScriptInfo(story.ScriptInfo);

            if (isMds) {
                // data only exported for MDS
                obsStory.setComUpmix(story.Upmix);
                obsStory.setMusic(story.Music);

                // add the graphic objects
                if (null != story.Graphics) {
                    for (mos graphic : story.Graphics) {
                        Story.Graphic storyGraphic = new Story.Graphic();

                        storyGraphic.setGraphPage(graphic.objID);
                        storyGraphic.setGraphDuration(graphic.vizDur);
                        storyGraphic.setGraphOffsetIN(graphic.vizTCin);
                        storyGraphic.setGraphOffsetOUT(graphic.vizTCout);

                        obsStory.getGraphic().add(storyGraphic);
                    }
                }

                obsStory.setCuesheet(story.CueSheet);
            }

            // add the story
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
