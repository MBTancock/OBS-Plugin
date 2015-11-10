package com.avid.central.obsplugin.interplaylibrary;

import com.avid.central.obsplugin.interplaylibrary.assets.*;
import com.avid.central.obsplugin.interplaylibrary.assets.AssetDescriptionType;
import com.avid.central.obsplugin.interplaylibrary.assets.AttributeListType;
import com.avid.central.obsplugin.interplaylibrary.assets.AttributeType;
import com.avid.central.obsplugin.interplaylibrary.assets.InterplayURIListType;
import com.avid.central.obsplugin.interplaylibrary.assets.ObjectFactory;
import com.avid.central.obsplugin.interplaylibrary.assets.UserCredentialsType;
import com.avid.central.obsplugin.interplaylibrary.infrastructure.*;

import javax.xml.ws.WebServiceException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Broadcast Media Solutions on 03/11/2015.
 */
public class interplay_assets {
    private final URL _assetsUrl;
    private final URL _infrastructureUrl;

    private final String _workgroup;
    private final UserCredentialsType _userCredentials;

    private Assets _assets;
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
        _userCredentials = new UserCredentialsType();
        _userCredentials.setUsername(user);
        _userCredentials.setPassword(password);

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

        GetChildrenType gft = new GetChildrenType();
        gft.setInterplayURI("interplay://" + _workgroup + "/");
        gft.setIncludeFolders(true);
        GetChildrenResponseType gftr = _port.getChildren(gft, _userCredentials);
        if (null != gftr.getErrors())
        {
            throw new Exception(gftr.getErrors().getError().get(0).getMessage());
        }
    }

    public Map<String, String> GetSequenceDetails(String MobID) throws Exception
    {
        if (null == _assetsUrl) {
            throw new Exception("Problem accessing the web services server");
        }

        if (null == _assets)
        {
            _assets = new Assets(_assetsUrl);
        }

        if (null == _port) {
            _port = _assets.getAssetsPort();
        }

        GetAttributesType gat = new GetAttributesType();
        InterplayURIListType uri = new InterplayURIListType();
        uri.getInterplayURI().add("interplay://" + _workgroup + "?mobid=" + MobID);
        gat.setInterplayURIs(uri);

        AttributeListType attributes = new AttributeListType();
        AttributeType at = new AttributeType();
        at.setGroup("SYSTEM");
        at.setName("FPS");
        attributes.getAttribute().add(at);
        at = new AttributeType();
        at.setGroup("SYSTEM");
        at.setName("Start");
        attributes.getAttribute().add(at);
        at = new AttributeType();
        at.setGroup("SYSTEM");
        at.setName("End");
        attributes.getAttribute().add(at);

        gat.setAttributes(attributes);

        GetAttributesResponseType gatr = _port.getAttributes(gat, _userCredentials);
        if (null != gatr.getErrors())
        {
            throw new Exception(gatr.getErrors().getError().get(0).getMessage());
        }

        Map<String, String> returnAttributes = new HashMap<String, String>();
        for (AssetDescriptionType adt :gatr.getResults().getAssetDescription()) {

            for (AttributeType attr : adt.getAttributes().getAttribute()) {
                switch (attr.getName())
                {
                    case "FPS":
                    case "Start":
                    case "End":
                        returnAttributes.put(attr.getName(), attr.getValue());
                        break;

                    default:
                        break;
                }
            }
        }

        return returnAttributes;
    }

    public List<UMIDLocatorType> GetMarkers(String MobID) throws Exception
    {
        if (null == _assetsUrl) {
            throw new Exception("Problem accessing the web services server");
        }

        if (null == _assets)
        {
            _assets = new Assets(_assetsUrl);
        }

        if (null == _port) {
            _port = _assets.getAssetsPort();
        }

        GetLocatorsType glt = new GetLocatorsType();
        glt.setInterplayURI("interplay://" + _workgroup + "?mobid=" + MobID);
        GetUMIDLocatorsResponseType gltr = _port.getUMIDLocators(glt, _userCredentials);
        if (null != gltr.getErrors())
        {
            throw new Exception(gltr.getErrors().getError().get(0).getMessage());
        }

        List<UMIDLocatorType> markers = gltr.getResults().getLocator();
        return markers;
    }
}
