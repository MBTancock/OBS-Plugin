/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avid.central.obsplugin.inewslibrary;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.handler.MessageContext;

/**
 *
 * @author Administrator
 */
public class iNEWS_System {

    private String _sessionID;
    private final URL _url;
    private final WebServiceException _e;

    private com.avid.central.obsplugin.inewslibrary.inewssystem.INEWSSystemPortType _port;

    public iNEWS_System(String server, int port) {
        WebServiceException e = null;
        URL url = null;
        try {
            url = new URL(String.format("http://%s:%d/inewswebservice/services/inewssystem?wsdl", server, port));
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }

        _e = e;
        _url = url;
    }

    public String getSessionID() {
        return _sessionID;
    }

    public com.avid.central.obsplugin.inewslibrary.inewssystem.types.ConnectResponseType Connect(String host, String user, String password) throws Exception {
        com.avid.central.obsplugin.inewslibrary.inewssystem.types.ConnectType connection = new com.avid.central.obsplugin.inewslibrary.inewssystem.types.ConnectType();

        connection.setServername(host);
        connection.setUsername(user);
        connection.setPassword(password);

        com.avid.central.obsplugin.inewslibrary.inewssystem.INEWSSystem service = new com.avid.central.obsplugin.inewslibrary.inewssystem.INEWSSystem(_url);

        _port = service.getINEWSSystemPort();

        com.avid.central.obsplugin.inewslibrary.inewssystem.types.ConnectResponseType response = _port.connect(connection);

        Map<String, List<String>> map;
        map = (Map<String, List<String>>) ((BindingProvider) _port).getResponseContext().get(MessageContext.HTTP_RESPONSE_HEADERS);
        List<String> cookies = map.get("Set-Cookie");
        if (cookies != null) {
            _sessionID = cookies.get(0);
        }

        return response;
    }

    public void Disconnect() throws Exception {
        SetSessionID();

        com.avid.central.obsplugin.inewslibrary.inewssystem.types.DisconnectType disconnect = new com.avid.central.obsplugin.inewslibrary.inewssystem.types.DisconnectType();
        com.avid.central.obsplugin.inewslibrary.inewssystem.types.DisconnectResponseType response = _port.disconnect(disconnect);
    }

    public String GetSessionID() {
        return _sessionID;
    }

    public List<String> ListFolder(String folderName) {
        List<String> listing = null;
        SetSessionID();

        com.avid.central.obsplugin.inewslibrary.inewssystem.types.GetFolderChildrenType getFolders = new com.avid.central.obsplugin.inewslibrary.inewssystem.types.GetFolderChildrenType();
        getFolders.setFolderFullName(folderName);

        try {
            com.avid.central.obsplugin.inewslibrary.inewssystem.types.GetFolderChildrenResponseType folders = _port.getFolderChildren(getFolders);

            listing = new ArrayList<String>();
            for (com.avid.central.obsplugin.inewslibrary.inewssystem.types.DirectoryType dir : folders.getChildren()) {
                listing.add(dir.getFullName());
            }
        } catch (com.avid.central.obsplugin.inewslibrary.inewssystem.GetFolderChildrenFault | com.avid.central.obsplugin.inewslibrary.inewssystem.ConnectionFault ex) {
            Logger.getLogger(iNEWS_System.class.getName()).log(Level.SEVERE, null, ex);
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
