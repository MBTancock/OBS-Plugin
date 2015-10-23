/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avid.central.obsplugin.inewslibrary;

import com.avid.central.obsplugin.inewslibrary.nsml.Nsml;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

/**
 *
 * @author Administrator
 */
public class iNEWS_Queue {

    public String _sessionID;
    private final com.avid.central.obsplugin.inewslibrary.inewsqueue.INEWSQueuePortType _port;

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
        
        com.avid.central.obsplugin.inewslibrary.inewsqueue.INEWSQueue service = new com.avid.central.obsplugin.inewslibrary.inewsqueue.INEWSQueue(url);
        _port = service.getINEWSQueuePort();
    }

    public List<com.avid.central.obsplugin.inewslibrary.nsml.Nsml> GetRundown(String path, boolean getBody) {
        List<com.avid.central.obsplugin.inewslibrary.nsml.Nsml> listing = null;

        // create the deserialization object
        JAXBContext jc;
        Unmarshaller unmarshaller;
        try {
            jc = JAXBContext.newInstance(Nsml.class);
            unmarshaller = jc.createUnmarshaller();
        } catch (JAXBException ex) {
            Logger.getLogger(iNEWS_Queue.class.getName()).log(Level.SEVERE, null, ex);
            return listing;
        }

        // set the session ID
        SetSessionID();

        // set the current queue
        com.avid.central.obsplugin.inewslibrary.inewsqueue.types.SetCurrentQueueType currentQueue = new com.avid.central.obsplugin.inewslibrary.inewsqueue.types.SetCurrentQueueType();
        currentQueue.setQueueFullName(path);
        try {
            com.avid.central.obsplugin.inewslibrary.inewsqueue.types.SetCurrentQueueResponseType queueResponse = _port.setCurrentQueue(currentQueue);
        } catch (com.avid.central.obsplugin.inewslibrary.inewsqueue.ConnectionFault | com.avid.central.obsplugin.inewslibrary.inewsqueue.SetCurrentQueueFault ex) {
            Logger.getLogger(iNEWS_Queue.class.getName()).log(Level.SEVERE, null, ex);
        }

        // get the stories in the queue
        listing = new ArrayList<com.avid.central.obsplugin.inewslibrary.nsml.Nsml>();
        while (true) {
            // get a batch of stories
            com.avid.central.obsplugin.inewslibrary.inewsqueue.types.GetStoriesType getStories = new com.avid.central.obsplugin.inewslibrary.inewsqueue.types.GetStoriesType();
            getStories.setNumberOfStoriesToGet(10);
            getStories.setIsStoryBodyIncluded(getBody);
            getStories.setNavigation(com.avid.central.obsplugin.inewslibrary.inewsqueue.types.GetStoriesNavigationEnum.NEXT);
            try {
                com.avid.central.obsplugin.inewslibrary.inewsqueue.types.GetStoriesResponseType stories = _port.getStories(getStories);

                // process this batch of stories
                for (com.avid.central.obsplugin.inewslibrary.inewsstory.types.StoryType story : stories.getStories()) {

                    String storyAsNsml = story.getStoryAsNSML();

                    StringReader reader = new StringReader(storyAsNsml);

                    com.avid.central.obsplugin.inewslibrary.nsml.Nsml nsml = (com.avid.central.obsplugin.inewslibrary.nsml.Nsml) unmarshaller.unmarshal(reader);

                    listing.add(nsml);
                }
            } catch (com.avid.central.obsplugin.inewslibrary.inewsqueue.ConnectionFault | com.avid.central.obsplugin.inewslibrary.inewsqueue.GetStoriesFault | JAXBException ex) {
                Logger.getLogger(iNEWS_Queue.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            // check for more stories
            try
            {
                com.avid.central.obsplugin.inewslibrary.inewsqueue.types.HasNextType hasNext = new com.avid.central.obsplugin.inewslibrary.inewsqueue.types.HasNextType();
                com.avid.central.obsplugin.inewslibrary.inewsqueue.types.HasNextResponseType hasNextResponse = _port.hasNext(hasNext);
            if (!hasNextResponse.isHasNext())
            {
                // no more stories
                break;
            }
            } catch (com.avid.central.obsplugin.inewslibrary.inewsqueue.ConnectionFault | com.avid.central.obsplugin.inewslibrary.inewsqueue.HasNextFault ex) {
                Logger.getLogger(iNEWS_Queue.class.getName()).log(Level.SEVERE, null, ex);
                return listing;
            }
        }

        return listing;
    }

    private void SetSessionID() {
        ((BindingProvider) _port).getRequestContext().put(
                MessageContext.HTTP_REQUEST_HEADERS,
                Collections.singletonMap("Cookie", Collections.singletonList(_sessionID)
                )
        );
    }
}
