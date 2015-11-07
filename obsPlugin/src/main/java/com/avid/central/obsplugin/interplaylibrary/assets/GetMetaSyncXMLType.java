
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
 *         Parameters for the GetMetaSyncXML operation. InterplayURI must reference a valid Avid asset.
 *         EnhancementType, EnhancementSubType, and TrackName all allow the returned data to be filtered
 *         on specific criteria.
 *       
 * 
 * <p>Java class for GetMetaSyncXMLType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetMetaSyncXMLType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InterplayURI" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="EnhancementType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EnhancementSubType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TrackName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "GetMetaSyncXMLType", propOrder = {
    "interplayURI",
    "enhancementType",
    "enhancementSubType",
    "trackName",
    "extension",
    "any"
})
public class GetMetaSyncXMLType {

    @XmlElement(name = "InterplayURI", required = true)
    protected String interplayURI;
    @XmlElement(name = "EnhancementType")
    protected String enhancementType;
    @XmlElement(name = "EnhancementSubType")
    protected String enhancementSubType;
    @XmlElement(name = "TrackName")
    protected String trackName;
    @XmlElement(name = "Extension")
    protected ExtensionType extension;
    @XmlAnyElement(lax = true)
    protected List<Object> any;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the interplayURI property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInterplayURI() {
        return interplayURI;
    }

    /**
     * Sets the value of the interplayURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInterplayURI(String value) {
        this.interplayURI = value;
    }

    /**
     * Gets the value of the enhancementType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnhancementType() {
        return enhancementType;
    }

    /**
     * Sets the value of the enhancementType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnhancementType(String value) {
        this.enhancementType = value;
    }

    /**
     * Gets the value of the enhancementSubType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnhancementSubType() {
        return enhancementSubType;
    }

    /**
     * Sets the value of the enhancementSubType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnhancementSubType(String value) {
        this.enhancementSubType = value;
    }

    /**
     * Gets the value of the trackName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrackName() {
        return trackName;
    }

    /**
     * Sets the value of the trackName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrackName(String value) {
        this.trackName = value;
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
