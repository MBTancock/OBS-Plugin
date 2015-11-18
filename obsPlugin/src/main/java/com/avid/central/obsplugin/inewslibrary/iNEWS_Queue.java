/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avid.central.obsplugin.inewslibrary;

import com.avid.central.obsplugin.inewslibrary.nsml.*;
import com.avid.central.obsplugin.inewslibrary.inewsqueue.*;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.ws.WebServiceException;

import com.avid.central.obsplugin.inewslibrary.story.Story;
import org.json.simple.parser.ContainerFactory;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Administrator
 */
public class iNEWS_Queue {

    public String _sessionID;
    private final INEWSQueuePortType _port;

     public iNEWS_Queue(String sessionID, String server, int port) {
        _sessionID = sessionID;
        
        WebServiceException e = null;
        URL url = null;
        try {
            url = new URL(String.format("http://%s:%d/inewswebservice/services/inewsqueue?wsdl", server, port));
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
            _port = null;
            return;
        }
        
        INEWSQueue service = new INEWSQueue(url);
        _port = service.getINEWSQueuePort();

         // set the session ID
         SetSessionID();
    }

    public boolean CheckForGetRecords()
    {
        GetQueueRecordsType getRecords = new GetQueueRecordsType();
        getRecords.setNumberOfRecordsToGet(10);
        getRecords.setReset(true);
        try
        {
            GetQueueRecordsResponseType response =  _port.getQueueRecords(getRecords);
        }
        catch (Exception ex)
        {
            return false;
        }
        return true;
    }

    private Unmarshaller CreateUnmarshaller() throws JAXBException
    {
        JAXBContext jc = JAXBContext.newInstance(Nsml.class);
        return jc.createUnmarshaller();
    }

    public List<Story> GetRundown(String path, boolean getBody) {
        List<Story> listing = null;

        // create the deserialization object
        Unmarshaller unmarshaller;
        try {
            unmarshaller = CreateUnmarshaller();
        } catch (JAXBException ex) {
            Logger.getLogger(iNEWS_Queue.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

        // set the current queue
        SetCurrentQueueType currentQueue = new SetCurrentQueueType();
        currentQueue.setQueueFullName(path);
        try {
            SetCurrentQueueResponseType queueResponse = _port.setCurrentQueue(currentQueue);
        } catch (ConnectionFault | SetCurrentQueueFault ex) {
            Logger.getLogger(iNEWS_Queue.class.getName()).log(Level.SEVERE, null, ex);
        }

        // get the stories in the queue
        listing = new ArrayList<Story>();
        while (true) {
            // get a batch of stories
            GetStoriesType getStories = new GetStoriesType();
            getStories.setNumberOfStoriesToGet(10);
            getStories.setIsStoryBodyIncluded(getBody);
            getStories.setNavigation(GetStoriesNavigationEnum.NEXT);
            try {
                GetStoriesResponseType stories = _port.getStories(getStories);

                // process this batch of stories
                for (StoryType story : stories.getStories()) {

                    String storyAsNsml = story.getStoryAsNSML();

                    StringReader reader = new StringReader(storyAsNsml);

                    Nsml nsml = (Nsml) unmarshaller.unmarshal(reader);

                    listing.add(new Story(nsml, storyAsNsml));
                }
            } catch (ConnectionFault | GetStoriesFault | JAXBException ex) {
                Logger.getLogger(iNEWS_Queue.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            // check for more stories
            try
            {
                HasNextType hasNext = new HasNextType();
                HasNextResponseType hasNextResponse = _port.hasNext(hasNext);
            if (!hasNextResponse.isHasNext())
            {
                // no more stories
                break;
            }
            } catch (Exception ex) {
                Logger.getLogger(iNEWS_Queue.class.getName()).log(Level.SEVERE, null, ex);
                return listing;
            }
        }

        return listing;
    }

    // retrieves a story as an NSML string
    public String GetStory(String queue, String locator, String subjectField)
    {
        String storyAsNSML = null;

        try
        {
            GetStoryType gst = new GetStoryType();
            gst.setQueueFullName(queue);
            gst.setQueueLocator(locator);

            GetStoryResponseType gstr = _port.getStory(gst);

            storyAsNSML = gstr.getStory().getStoryAsNSML();
        }
        catch (Exception ex)
        {
            storyAsNSML = null;
        }

        return storyAsNSML;
    }

    ContainerFactory containerFactory = new ContainerFactory(){
        public List creatArrayContainer() {
            return new LinkedList();
        }

        public Map createObjectContainer() {
            return new LinkedHashMap();
        }

    };

    // Decodes a story to NSML then looks for a reference to a MobID
    public String GetMobID(String storyAsNsml)
    {
        // create a json parser
        JSONParser parser = new JSONParser();

        // create the deserialization object
        Unmarshaller unmarshaller;
        try {
            unmarshaller = CreateUnmarshaller();
        } catch (JAXBException ex) {
            Logger.getLogger(iNEWS_Queue.class.getName()).log(Level.SEVERE, null, ex);
           return null;
        }

        try
        {
            StringReader reader = new StringReader(storyAsNsml);
            Nsml story = (Nsml) unmarshaller.unmarshal(reader);

            if (null != story.getAeset() && story.getAeset().getAe().size() > 0) {
                // look for an entry which includes a sequenceID
                for (Nsml.Aeset.Ae ae : story.getAeset().getAe()) {

                    for (Object ap : ae.getMcOrAp()) {
                        if (ap.getClass() != ApContent.class) {
                            continue;
                        }

                        if (null == ae.getHidden() || -1 == ae.getHidden().indexOf("sequenceID") )
                        {
                            continue;
                        }


                        // see if we can parse the ae hidden value for the sequence data
                        // we shouldn't have got this far if it doesn't include "sequenceID"
                        try {
                            Map json = (Map) parser.parse(ae.getHidden(), containerFactory);

                            if (json.containsKey("sequenceID"))
                            {
                                String mobID = (String)json.get("sequenceID");
                                if (null != mobID)
                                {
                                    // ok we found what we were looking for
                                    return mobID;
                                }
                            }
                        }
                        catch (Exception ex)
                        {
                            // we won't error here, just keep on looking...
                        }
                    }
                }
            }
        }
        catch (Exception ex)
        {
        }

        return null;
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

    private void SetSessionID() {
        ((BindingProvider) _port).getRequestContext().put(
                MessageContext.HTTP_REQUEST_HEADERS,
                Collections.singletonMap("Cookie", Collections.singletonList(_sessionID)
                )
        );
    }
}
