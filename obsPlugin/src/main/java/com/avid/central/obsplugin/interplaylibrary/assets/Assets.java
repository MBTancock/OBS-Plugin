
package com.avid.central.obsplugin.interplaylibrary.assets;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * 
 *       The Assets service is a SOAP-based entry point into the Avid Interplay assets system.
 *     
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "Assets", targetNamespace = "http://avid.com/interplay/ws/assets", wsdlLocation = "http://lookup/services/Assets?wsdl")
public class Assets
    extends Service
{

    private final static URL ASSETS_WSDL_LOCATION;
    private final static WebServiceException ASSETS_EXCEPTION;
    private final static QName ASSETS_QNAME = new QName("http://avid.com/interplay/ws/assets", "Assets");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://lookup/services/Assets?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        ASSETS_WSDL_LOCATION = url;
        ASSETS_EXCEPTION = e;
    }

    public Assets() {
        super(__getWsdlLocation(), ASSETS_QNAME);
    }

    public Assets(WebServiceFeature... features) {
        super(__getWsdlLocation(), ASSETS_QNAME, features);
    }

    public Assets(URL wsdlLocation) {
        super(wsdlLocation, ASSETS_QNAME);
    }

    public Assets(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, ASSETS_QNAME, features);
    }

    public Assets(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Assets(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns AssetsPortType
     */
    @WebEndpoint(name = "AssetsPort")
    public AssetsPortType getAssetsPort() {
        return super.getPort(new QName("http://avid.com/interplay/ws/assets", "AssetsPort"), AssetsPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AssetsPortType
     */
    @WebEndpoint(name = "AssetsPort")
    public AssetsPortType getAssetsPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://avid.com/interplay/ws/assets", "AssetsPort"), AssetsPortType.class, features);
    }

    private static URL __getWsdlLocation() {
        if (ASSETS_EXCEPTION!= null) {
            throw ASSETS_EXCEPTION;
        }
        return ASSETS_WSDL_LOCATION;
    }

}
