
package com.avid.central.obsplugin.inewslibrary.inewssystem;

import javax.xml.ws.WebFault;
import com.avid.central.obsplugin.inewslibrary.inewssystem.types.*;

/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "GetQueuesFormFaultType", targetNamespace = "http://avid.com/inewssystem/types")
public class GetQueuesFormFault
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private GetQueuesFormFaultType faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public GetQueuesFormFault(String message, GetQueuesFormFaultType faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public GetQueuesFormFault(String message, GetQueuesFormFaultType faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.avid.central.obsplugin.inewslibrary.inewssystem.types.GetQueuesFormFaultType
     */
    public GetQueuesFormFaultType getFaultInfo() {
        return faultInfo;
    }

}
