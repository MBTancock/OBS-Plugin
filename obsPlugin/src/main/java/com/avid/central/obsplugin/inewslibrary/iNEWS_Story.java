package com.avid.central.obsplugin.inewslibrary;

import com.avid.central.obsplugin.inewslibrary.inewsstory.*;
import com.avid.central.obsplugin.inewslibrary.inewsstory.types.LockStoryResponseType;
import com.avid.central.obsplugin.inewslibrary.inewsstory.types.LockStoryType;
import com.avid.central.obsplugin.inewslibrary.inewsstory.types.SectionLockEnum;
import com.avid.central.obsplugin.inewslibrary.inewsstory.types.UnlockStoryType;

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

    public void SaveStory(String queue, String locator, String storyAsNSML) throws Exception
    {
        boolean locked = false;

        try
        {
            LockStoryType lst = new LockStoryType();
            lst.setQueueFullName(queue);
            lst.setQueueLocator(locator);
            lst.setSection(SectionLockEnum.BODY);

            LockStoryResponseType lstr = _port.lockStory(lst);

            // if save story then set locked false
        }
        catch (Exception ex)
        {

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
    }

    private void SetSessionID() {
        ((BindingProvider) _port).getRequestContext().put(
                MessageContext.HTTP_REQUEST_HEADERS,
                Collections.singletonMap("Cookie", Collections.singletonList(_sessionID)
                )
        );
    }
}
