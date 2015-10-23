
package com.avid.central.obsplugin.inewslibrary.inewsstory.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *       Parameters for the SaveStory request.  NSML is the NSML that will be persisted for the active story.
 *       
 * 
 * <p>Java class for SaveStoryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SaveStoryType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="StoryNSML" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SaveStoryType", propOrder = {
    "storyNSML"
})
public class SaveStoryType {

    @XmlElement(name = "StoryNSML", required = true)
    protected String storyNSML;

    /**
     * Gets the value of the storyNSML property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStoryNSML() {
        return storyNSML;
    }

    /**
     * Sets the value of the storyNSML property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStoryNSML(String value) {
        this.storyNSML = value;
    }

}
