
package com.avid.central.obsplugin.interplaylibrary.assets;

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
 *         Parameters for the CreateShotlist operation. The DestinationFolderURI indicates where the shotlist should
 *         be checked in. StartTimecode indicates starting timecode of the shotlist. ShotlistElements is a list
 *         of ShotListElementTypes making up the shotlist. Attributes and Locators optionally set additional metadata
 *         on the shotlist.
 *       
 * 
 * <p>Java class for CreateShotlistType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreateShotlistType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DestinationFolderURI" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ShotlistName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="StartTimecode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ShotlistMobID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ShotlistElements" type="{http://avid.com/interplay/ws/assets/types}ShotlistElementListType"/&gt;
 *         &lt;element name="Attributes" type="{http://avid.com/interplay/ws/assets/types}AttributeListType" minOccurs="0"/&gt;
 *         &lt;element name="Locators" type="{http://avid.com/interplay/ws/assets/types}UMIDLocatorListType" minOccurs="0"/&gt;
 *         &lt;element name="Extension" type="{http://avid.com/interplay/ws/assets/types}ExtensionType" minOccurs="0"/&gt;
 *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;anyAttribute processContents='lax'/&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateShotlistType", propOrder = {
    "destinationFolderURI",
    "shotlistName",
    "startTimecode",
    "shotlistMobID",
    "shotlistElements",
    "attributes",
    "locators",
    "extension",
    "any"
})
public class CreateShotlistType {

    @XmlElement(name = "DestinationFolderURI", required = true)
    protected String destinationFolderURI;
    @XmlElement(name = "ShotlistName", required = true)
    protected String shotlistName;
    @XmlElement(name = "StartTimecode", required = true)
    protected String startTimecode;
    @XmlElement(name = "ShotlistMobID")
    protected String shotlistMobID;
    @XmlElement(name = "ShotlistElements", required = true)
    protected ShotlistElementListType shotlistElements;
    @XmlElement(name = "Attributes")
    protected AttributeListType attributes;
    @XmlElement(name = "Locators")
    protected UMIDLocatorListType locators;
    @XmlElement(name = "Extension")
    protected ExtensionType extension;
    @XmlAnyElement(lax = true)
    protected List<Object> any;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the destinationFolderURI property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestinationFolderURI() {
        return destinationFolderURI;
    }

    /**
     * Sets the value of the destinationFolderURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestinationFolderURI(String value) {
        this.destinationFolderURI = value;
    }

    /**
     * Gets the value of the shotlistName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShotlistName() {
        return shotlistName;
    }

    /**
     * Sets the value of the shotlistName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShotlistName(String value) {
        this.shotlistName = value;
    }

    /**
     * Gets the value of the startTimecode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartTimecode() {
        return startTimecode;
    }

    /**
     * Sets the value of the startTimecode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartTimecode(String value) {
        this.startTimecode = value;
    }

    /**
     * Gets the value of the shotlistMobID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShotlistMobID() {
        return shotlistMobID;
    }

    /**
     * Sets the value of the shotlistMobID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShotlistMobID(String value) {
        this.shotlistMobID = value;
    }

    /**
     * Gets the value of the shotlistElements property.
     * 
     * @return
     *     possible object is
     *     {@link ShotlistElementListType }
     *     
     */
    public ShotlistElementListType getShotlistElements() {
        return shotlistElements;
    }

    /**
     * Sets the value of the shotlistElements property.
     * 
     * @param value
     *     allowed object is
     *     {@link ShotlistElementListType }
     *     
     */
    public void setShotlistElements(ShotlistElementListType value) {
        this.shotlistElements = value;
    }

    /**
     * Gets the value of the attributes property.
     * 
     * @return
     *     possible object is
     *     {@link AttributeListType }
     *     
     */
    public AttributeListType getAttributes() {
        return attributes;
    }

    /**
     * Sets the value of the attributes property.
     * 
     * @param value
     *     allowed object is
     *     {@link AttributeListType }
     *     
     */
    public void setAttributes(AttributeListType value) {
        this.attributes = value;
    }

    /**
     * Gets the value of the locators property.
     * 
     * @return
     *     possible object is
     *     {@link UMIDLocatorListType }
     *     
     */
    public UMIDLocatorListType getLocators() {
        return locators;
    }

    /**
     * Sets the value of the locators property.
     * 
     * @param value
     *     allowed object is
     *     {@link UMIDLocatorListType }
     *     
     */
    public void setLocators(UMIDLocatorListType value) {
        this.locators = value;
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
