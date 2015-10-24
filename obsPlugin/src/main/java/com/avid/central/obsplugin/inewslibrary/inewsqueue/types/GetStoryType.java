
package com.avid.central.obsplugin.inewslibrary.inewsqueue.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *       Parameters for the GetStory request.  QueueFullName is the full path to the queue on the iNEWS server in which the story resides, QueueLocator is the reference to the
 *       story of interest within the queue.
 *       
 * 
 * <p>Java class for GetStoryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetStoryType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="QueueFullName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="QueueLocator" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetStoryType", namespace = "http://avid.com/inewsqueue/types", propOrder = {
    "queueFullName",
    "queueLocator"
})
public class GetStoryType {

    @XmlElement(name = "QueueFullName", required = true)
    protected String queueFullName;
    @XmlElement(name = "QueueLocator", required = true)
    protected String queueLocator;

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

    /**
     * Gets the value of the queueLocator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQueueLocator() {
        return queueLocator;
    }

    /**
     * Sets the value of the queueLocator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQueueLocator(String value) {
        this.queueLocator = value;
    }

}
