package com.avid.central.obsplugin.interplaylibrary;

import com.avid.central.obsplugin.interplaylibrary.assets.*;
import com.avid.central.obsplugin.interplaylibrary.assets.UserCredentialsType;
import com.avid.central.obsplugin.interplaylibrary.infrastructure.*;

import javax.xml.ws.WebServiceException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Broadcast Media Solutions on 03/11/2015.
 */
public class interplay_assets {
    private final URL _assetsUrl;
    private final URL _infrastructureUrl;

    private final String _workgroup;
    private final String _user;
    private final String _pasword;

    private AssetsPortType _port;

    public interplay_assets(String server, int port, String workgroup, String user, String password) {
        // create the URLs we need
        URL url = null;
        try {
            url = new URL(String.format("http://%s:%d/services/Assets?wsdl", server, port));
        } catch (MalformedURLException ex) {
            url = null;
        }
        _assetsUrl = url;

        url = null;
        try {
            url = new URL(String.format("http://%s:%d/services/Infrastructure?wsdl", server, port));
        } catch (MalformedURLException ex) {
            url = null;
        }
        _infrastructureUrl = url;

        _workgroup = workgroup;
        _user = user;
        _pasword = password;
    }

    // tests the Interplay connection by attempting to list the top level folders
    public void testConnection() throws Exception {
        // make sure the assets URL is valid
        if (null == _assetsUrl || null == _infrastructureUrl) {
            throw new Exception("Problem accessing the web services server");
        }

        // first check we have a web services server and that the specified workgroup name exists
        Infrastructure infrastructure = new Infrastructure(_infrastructureUrl);
        InfrastructurePortType infrastructurePort = infrastructure.getInfrastructurePort();

        // get the configuration
        GetConfigurationInformationType gcit = new GetConfigurationInformationType();
        GetConfigurationInformationResponseType gcitr = infrastructurePort.getConfigurationInformation(gcit);
        if (null != gcitr.getErrors())
        {
            throw new Exception(gcitr.getErrors().getError().get(0).getMessage());
        }

        // is our workgroup defined?
        boolean workgroupDefined = false;
        for (WorkgroupType workgroup:gcitr.getResults().getWorkgroup()) {
            if (workgroup.getWorkgroupName().equals(_workgroup))
            {
                workgroupDefined = true;
                break;
            }
        }

        if (!workgroupDefined)
        {
            throw new Exception("The web services configuration does not include a workgroup named \"" + _workgroup + "\"");
        }

        Assets assets = new Assets(_assetsUrl);
        _port = assets.getAssetsPort();

        UserCredentialsType uct = new UserCredentialsType();
        uct.setUsername(_user);
        uct.setPassword(_pasword);
        GetChildrenType gft = new GetChildrenType();
        gft.setInterplayURI("interplay://" + _workgroup + "/");
        gft.setIncludeFolders(true);
        GetChildrenResponseType gftr = _port.getChildren(gft, uct);
        if (null != gftr.getErrors())
        {
            throw new Exception(gftr.getErrors().getError().get(0).getMessage());
        }
    }
}
