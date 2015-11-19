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

    private void SetSessionID() {
        ((BindingProvider) _port).getRequestContext().put(
                MessageContext.HTTP_REQUEST_HEADERS,
                Collections.singletonMap("Cookie", Collections.singletonList(_sessionID)
                )
        );
    }
}
