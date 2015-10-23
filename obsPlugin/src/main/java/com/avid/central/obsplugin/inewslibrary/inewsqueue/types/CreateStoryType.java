
package com.avid.central.obsplugin.inewslibrary.inewsqueue.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *       Parameters for the CreateStory request.  NSML is the NSML for the new story and maintain edit lock specifies if 
 *       the new story will be locked and set as the current story.
 *       
 * 
 * <p>Java class for CreateStoryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreateStoryType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NSML" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MaintainLock" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateStoryType", propOrder = {
    "nsml",
    "maintainLock"
})
public class CreateStoryType {

    @XmlElement(name = "NSML", required = true)
    protected String nsml;
    @XmlElement(name = "MaintainLock")
    protected boolean maintainLock;

    /**
     * Gets the value of the nsml property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNSML() {
        return nsml;
    }

    /**
     * Sets the value of the nsml property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNSML(String value) {
        this.nsml = value;
    }

    /**
     * Gets the value of the maintainLock property.
     * 
     */
    public boolean isMaintainLock() {
        return maintainLock;
    }

    /**
     * Sets the value of the maintainLock property.
     * 
     */
    public void setMaintainLock(boolean value) {
        this.maintainLock = value;
    }

}
