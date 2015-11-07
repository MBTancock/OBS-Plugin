
package com.avid.central.obsplugin.interplaylibrary.assets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.activation.DataHandler;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import org.w3c.dom.Element;


/**
 * 
 *         Parameters for the CreateSubclip operation. The MasterclipURI references the Masterclip that
 *         the subclip is based on. The SubclipPathURI is a path-based URI that represents where the subclip should be
 *         checked in. The Name represents the name of the subclip to check in. StartingOffset or StartingTimecode as well
 *         as Length are used determine the range of the Masterclip that the subclip covers. A Headframe and/or a set of
 *         Attributes can be optionally passed in. The Headframe must be a JPEG, GIF, PNG, or BMP image. It will be
 *         converted and resized to a 400x300 JPEG.
 *       
 * 
 * <p>Java class for CreateSubclipType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreateSubclipType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MasterclipURI" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SubclipPathURI" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="StartingOffset" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="StartingTimecode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Length" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Headframe" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="Attributes" type="{http://avid.com/interplay/ws/assets/types}AttributeListType" minOccurs="0"/>
 *         &lt;element name="Extension" type="{http://avid.com/interplay/ws/assets/types}ExtensionType" minOccurs="0"/>
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
@XmlType(name = "CreateSubclipType", propOrder = {
    "masterclipURI",
    "subclipPathURI",
    "name",
    "startingOffset",
    "startingTimecode",
    "length",
    "headframe",
    "attributes",
    "extension",
    "any"
})
public class CreateSubclipType {

    @XmlElement(name = "MasterclipURI", required = true)
    protected String masterclipURI;
    @XmlElement(name = "SubclipPathURI", required = true)
    protected String subclipPathURI;
    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "StartingOffset")
    protected Long startingOffset;
    @XmlElement(name = "StartingTimecode")
    protected String startingTimecode;
    @XmlElement(name = "Length")
    protected long length;
    @XmlElement(name = "Headframe")
    @XmlMimeType("application/octet-stream")
    protected DataHandler headframe;
    @XmlElement(name = "Attributes")
    protected AttributeListType attributes;
    @XmlElement(name = "Extension")
    protected ExtensionType extension;
    @XmlAnyElement(lax = true)
    protected List<Object> any;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the masterclipURI property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMasterclipURI() {
        return masterclipURI;
    }

    /**
     * Sets the value of the masterclipURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMasterclipURI(String value) {
        this.masterclipURI = value;
    }

    /**
     * Gets the value of the subclipPathURI property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubclipPathURI() {
        return subclipPathURI;
    }

    /**
     * Sets the value of the subclipPathURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubclipPathURI(String value) {
        this.subclipPathURI = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the startingOffset property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStartingOffset() {
        return startingOffset;
    }

    /**
     * Sets the value of the startingOffset property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStartingOffset(Long value) {
        this.startingOffset = value;
    }

    /**
     * Gets the value of the startingTimecode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartingTimecode() {
        return startingTimecode;
    }

    /**
     * Sets the value of the startingTimecode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartingTimecode(String value) {
        this.startingTimecode = value;
    }

    /**
     * Gets the value of the length property.
     * 
     */
    public long getLength() {
        return length;
    }

    /**
     * Sets the value of the length property.
     * 
     */
    public void setLength(long value) {
        this.length = value;
    }

    /**
     * Gets the value of the headframe property.
     * 
     * @return
     *     possible object is
     *     {@link DataHandler }
     *     
     */
    public DataHandler getHeadframe() {
        return headframe;
    }

    /**
     * Sets the value of the headframe property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataHandler }
     *     
     */
    public void setHeadframe(DataHandler value) {
        this.headframe = value;
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
