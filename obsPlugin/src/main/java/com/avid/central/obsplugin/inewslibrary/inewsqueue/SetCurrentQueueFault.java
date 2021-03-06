
package com.avid.central.obsplugin.inewslibrary.inewsqueue;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "SetCurrentQueueFaultType", targetNamespace = "http://avid.com/inewsqueue/types")
public class SetCurrentQueueFault
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private SetCurrentQueueFaultType faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public SetCurrentQueueFault(String message, SetCurrentQueueFaultType faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public SetCurrentQueueFault(String message, SetCurrentQueueFaultType faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: inewsqueue.SetCurrentQueueFaultType
     */
    public SetCurrentQueueFaultType getFaultInfo() {
        return faultInfo;
    }

}
