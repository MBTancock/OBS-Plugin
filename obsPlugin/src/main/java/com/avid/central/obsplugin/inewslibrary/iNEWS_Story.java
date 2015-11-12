package com.avid.central.obsplugin.inewslibrary;

import com.avid.central.obsplugin.inewslibrary.inewsstory.*;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.handler.MessageContext;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;

/**
 * Created by Broadcast Media Solutions on 11/11/2015.
 */
public class iNEWS_Story {
    public String _sessionID;
    private final INEWSStoryPortType _port;

    public iNEWS_Story(String sessionID, String server, int port) {
        _sessionID = sessionID;

        WebServiceException e = null;
        URL url = null;
        try {
            url = new URL(String.format("http://%s:%d/inewswebservice/services/inewsstory?wsdl", server, port));
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
            _port = null;
            return;
        }

        INEWSStory service = new INEWSStory(url);
        _port = service.getINEWSStoryPort();

        // set the session ID
        SetSessionID();
    }

    // attempts to save the story, returns true if it succeeds, false if the story lock fails
    // all other issues throw an error
    public boolean SaveStory(String queue, String locator, String storyAsNSML) throws Exception
    {
        boolean result = false;
        boolean locked = false;

        try
        {
            LockStoryType lst = new LockStoryType();
            lst.setQueueFullName(queue);
            lst.setQueueLocator(locator);
            lst.setSection(SectionLockEnum.BODY);

            LockStoryResponseType lstr = _port.lockStory(lst);

            // if we get here the story is locked
            locked = true;

            SaveStoryType sst = new SaveStoryType();
            sst.setStoryNSML(storyAsNSML);
            SaveStoryResponseType sstr = _port.saveStory(sst);

            // if we get here save succeeded so set locked false, save story will have unlocked it
            locked = false;
            result = true;
        }
        catch (Exception ex)
        {
            // if the error is because the story is locked don't throw the exception
            // return false to indicate that story is locked
            if (!ex.getMessage().contains("locked"))
            {
                throw ex;
            }
        }
        finally
        {
            if (locked)
            {
                try {
                    UnlockStoryType ust = new UnlockStoryType();
                    _port.unlockStory(ust);
                }
                catch (Exception ex) {

                }
            }
        }
        return result;
    }

    private void SetSessionID() {
        ((BindingProvider) _port).getRequestContext().put(
                MessageContext.HTTP_REQUEST_HEADERS,
                Collections.singletonMap("Cookie", Collections.singletonList(_sessionID)
                )
        );
    }
}
