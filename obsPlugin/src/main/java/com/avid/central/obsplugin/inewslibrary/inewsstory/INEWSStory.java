
package com.avid.central.obsplugin.inewslibrary.inewsstory;

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
 *             The INEWSStory is the service that is used to perform operations against a particular iNEWS Story.  The
 *             requests in this service cannot be invoked before a connection to the iNEWS server has been established
 *             through the System Service's Connect request.
 *     
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "INEWSStory", targetNamespace = "http://avid.com/inewsstory", wsdlLocation = "http://ftsserver:8080/inewswebservice/services/inewsstory?wsdl")
public class INEWSStory
    extends Service
{

    private final static URL INEWSSTORY_WSDL_LOCATION;
    private final static WebServiceException INEWSSTORY_EXCEPTION;
    private final static QName INEWSSTORY_QNAME = new QName("http://avid.com/inewsstory", "INEWSStory");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://ftsserver:8080/inewswebservice/services/inewsstory?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        INEWSSTORY_WSDL_LOCATION = url;
        INEWSSTORY_EXCEPTION = e;
    }

    public INEWSStory() {
        super(__getWsdlLocation(), INEWSSTORY_QNAME);
    }

    public INEWSStory(WebServiceFeature... features) {
        super(__getWsdlLocation(), INEWSSTORY_QNAME, features);
    }

    public INEWSStory(URL wsdlLocation) {
        super(wsdlLocation, INEWSSTORY_QNAME);
    }

    public INEWSStory(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, INEWSSTORY_QNAME, features);
    }

    public INEWSStory(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public INEWSStory(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns INEWSStoryPortType
     */
    @WebEndpoint(name = "INEWSStoryPort")
    public INEWSStoryPortType getINEWSStoryPort() {
        return super.getPort(new QName("http://avid.com/inewsstory", "INEWSStoryPort"), INEWSStoryPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns INEWSStoryPortType
     */
    @WebEndpoint(name = "INEWSStoryPort")
    public INEWSStoryPortType getINEWSStoryPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://avid.com/inewsstory", "INEWSStoryPort"), INEWSStoryPortType.class, features);
    }

    private static URL __getWsdlLocation() {
        if (INEWSSTORY_EXCEPTION!= null) {
            throw INEWSSTORY_EXCEPTION;
        }
        return INEWSSTORY_WSDL_LOCATION;
    }

}
