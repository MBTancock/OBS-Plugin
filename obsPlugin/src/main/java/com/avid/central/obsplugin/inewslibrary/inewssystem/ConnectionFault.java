
package com.avid.central.obsplugin.inewslibrary.inewssystem;

import javax.xml.ws.WebFault;
import com.avid.central.obsplugin.inewslibrary.inewssystem.types.ConnectionFaultType;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "ConnectionFaultType", targetNamespace = "http://avid.com/inewssystem/types")
public class ConnectionFault
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private ConnectionFaultType faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public ConnectionFault(String message, ConnectionFaultType faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public ConnectionFault(String message, ConnectionFaultType faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: package com.avid.central.obsplugin.inewslibrary.inewssystem.types.ConnectionFaultType
     */
    public ConnectionFaultType getFaultInfo() {
        return faultInfo;
    }

}
