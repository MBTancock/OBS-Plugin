
package com.avid.central.obsplugin.inewslibrary.inewssystem;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "GetFolderChildrenFaultType", targetNamespace = "http://avid.com/inewssystem/types")
public class GetFolderChildrenFault
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private GetFolderChildrenFaultType faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public GetFolderChildrenFault(String message, GetFolderChildrenFaultType faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public GetFolderChildrenFault(String message, GetFolderChildrenFaultType faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: inewssystem.GetFolderChildrenFaultType
     */
    public GetFolderChildrenFaultType getFaultInfo() {
        return faultInfo;
    }

}
