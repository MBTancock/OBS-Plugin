
package com.avid.central.obsplugin.inewslibrary.inewsqueue.types;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.avid.central.obsplugin.inewslibrary.inewsstory.types.StoryType;
import com.avid.central.obsplugin.inewslibrary.inewssystem.types.ExtensionType;
import org.w3c.dom.Element;


/**
 * 
 *       Response from the CreateStory request.  NewStory contains the information about the story that was created.  The 
 *       NSML returned may not be identical to the NSML provided as the server adds system information at the time of save.
 *         
 *       See documentation for ExtensionType in inewssystem.xsd for description of Extension's usage.
 *       
 * 
 * <p>Java class for CreateStoryResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreateStoryResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NewStory" type="{http://avid.com/inewsstory/types}StoryType"/>
 *         &lt;element name="Extension" type="{http://avid.com/inewssystem/types}ExtensionType" minOccurs="0"/>
 *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateStoryResponseType", propOrder = {
    "newStory",
    "extension",
    "any"
})
public class CreateStoryResponseType {

    @XmlElement(name = "NewStory", required = true)
    protected StoryType newStory;
    @XmlElement(name = "Extension")
    protected ExtensionType extension;
    @XmlAnyElement(lax = true)
    protected List<Object> any;

    /**
     * Gets the value of the newStory property.
     * 
     * @return
     *     possible object is
     *     {@link StoryType }
     *     
     */
    public StoryType getNewStory() {
        return newStory;
    }

    /**
     * Sets the value of the newStory property.
     * 
     * @param value
     *     allowed object is
     *     {@link StoryType }
     *     
     */
    public void setNewStory(StoryType value) {
        this.newStory = value;
    }

    /**
     * Gets the value of the extension property.
     * 
     * @return
     *     possible object is
     *     {@link ExtensionType }
     *     
     */
    public ExtensionType getExtension() {
        return extension;
    }

    /**
     * Sets the value of the extension property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtensionType }
     *     
     */
    public void setExtension(ExtensionType value) {
        this.extension = value;
    }

    /**
     * Gets the value of the any property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the any property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAny().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * {@link Element }
     * 
     * 
     */
    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
    }

}
