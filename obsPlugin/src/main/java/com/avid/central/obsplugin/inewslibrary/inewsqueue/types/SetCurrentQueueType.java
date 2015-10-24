
package com.avid.central.obsplugin.inewslibrary.inewsqueue.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *       Parameters for the SetCurrentQueue request.  QueueFullName is the full path to the queue on the iNEWS server.
 *       
 * 
 * <p>Java class for SetCurrentQueueType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SetCurrentQueueType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="QueueFullName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SetCurrentQueueType", namespace = "http://avid.com/inewsqueue/types", propOrder = {
    "queueFullName"
})
public class SetCurrentQueueType {

    @XmlElement(name = "QueueFullName", required = true)
    protected String queueFullName;

    /**
     * Gets the value of the queueFullName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQueueFullName() {
        return queueFullName;
    }

    /**
     * Sets the value of the queueFullName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQueueFullName(String value) {
        this.queueFullName = value;
    }

}
