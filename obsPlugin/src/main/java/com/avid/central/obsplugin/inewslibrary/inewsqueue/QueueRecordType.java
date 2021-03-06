
package com.avid.central.obsplugin.inewslibrary.inewsqueue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import org.w3c.dom.Element;


/**
 * 
 *           A queue record.  Primarily used for comparison purposes to tell whether a story requires an update
 *           because it has been modified by another client.  The MTime and StoryID should be compared to the
 *           stories current MTime and StoryID.  If either has changed, the story should be refreshed.
 *       
 * 
 * <p>Java class for QueueRecordType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="QueueRecordType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="QueueLocator" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="StoryID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="MTime" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Extension" type="{http://avid.com/inewssystem/types}ExtensionType" minOccurs="0"/>
 *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;anyAttribute processContents='lax'/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QueueRecordType", namespace = "http://avid.com/inewsqueue/types", propOrder = {
    "queueLocator",
    "storyID",
    "mTime",
    "extension",
    "any"
})
public class QueueRecordType {

    @XmlElement(name = "QueueLocator", required = true)
    protected String queueLocator;
    @XmlElement(name = "StoryID")
    protected long storyID;
    @XmlElement(name = "MTime")
    protected long mTime;
    @XmlElement(name = "Extension")
    protected ExtensionType extension;
    @XmlAnyElement(lax = true)
    protected List<Object> any;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

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

    /**
     * Gets the value of the storyID property.
     * 
     */
    public long getStoryID() {
        return storyID;
    }

    /**
     * Sets the value of the storyID property.
     * 
     */
    public void setStoryID(long value) {
        this.storyID = value;
    }

    /**
     * Gets the value of the mTime property.
     * 
     */
    public long getMTime() {
        return mTime;
    }

    /**
     * Sets the value of the mTime property.
     * 
     */
    public void setMTime(long value) {
        this.mTime = value;
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
     * {@link Element }
     * {@link Object }
     * 
     * 
     */
    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
    }

    /**
     * Gets a map that contains attributes that aren't bound to any typed property on this class.
     * 
     * <p>
     * the map is keyed by the name of the attribute and 
     * the value is the string value of the attribute.
     * 
     * the map returned by this method is live, and you can add new attribute
     * by updating the map directly. Because of this design, there's no setter.
     * 
     * 
     * @return
     *     always non-null
     */
    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

}
