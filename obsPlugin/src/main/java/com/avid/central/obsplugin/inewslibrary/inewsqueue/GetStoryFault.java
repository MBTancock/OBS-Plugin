
package com.avid.central.obsplugin.inewslibrary.inewsqueue;

import javax.xml.ws.WebFault;
import com.avid.central.obsplugin.inewslibrary.inewsqueue.types.GetStoryFaultType;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "GetStoryFaultType", targetNamespace = "http://avid.com/inewsqueue/types")
public class GetStoryFault
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private GetStoryFaultType faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public GetStoryFault(String message, GetStoryFaultType faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public GetStoryFault(String message, GetStoryFaultType faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.avid.inewsqueue.types.GetStoryFaultType
     */
    public GetStoryFaultType getFaultInfo() {
        return faultInfo;
    }

}
