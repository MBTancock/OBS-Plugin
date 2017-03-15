
package com.avid.central.obsplugin.interplaylibrary.infrastructure;

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
 *         The Workgroup contains a Workgroup Name, Interplay Engine Host, Archive Engine Host and Media
 *         Services Engine Host.
 *       
 * 
 * <p>Java class for WorkgroupType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WorkgroupType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="WorkgroupName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="InterplayEngineHost" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ArchiveEngineHost" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="MediaServicesEngineHost" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
@XmlType(name = "WorkgroupType", namespace = "http://avid.com/interplay/ws/infrastructure/types", propOrder = {
    "workgroupName",
    "interplayEngineHost",
    "archiveEngineHost",
    "mediaServicesEngineHost",
    "extension",
    "any"
})
public class WorkgroupType {

    @XmlElement(name = "WorkgroupName", required = true)
    protected String workgroupName;
    @XmlElement(name = "InterplayEngineHost", required = true)
    protected String interplayEngineHost;
    @XmlElement(name = "ArchiveEngineHost", required = true)
    protected String archiveEngineHost;
    @XmlElement(name = "MediaServicesEngineHost", required = true)
    protected String mediaServicesEngineHost;
    @XmlElement(name = "Extension")
    protected ExtensionType extension;
    @XmlAnyElement(lax = true)
    protected List<Object> any;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the workgroupName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkgroupName() {
        return workgroupName;
    }

    /**
     * Sets the value of the workgroupName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkgroupName(String value) {
        this.workgroupName = value;
    }

    /**
     * Gets the value of the interplayEngineHost property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInterplayEngineHost() {
        return interplayEngineHost;
    }

    /**
     * Sets the value of the interplayEngineHost property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInterplayEngineHost(String value) {
        this.interplayEngineHost = value;
    }

    /**
     * Gets the value of the archiveEngineHost property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArchiveEngineHost() {
        return archiveEngineHost;
    }

    /**
     * Sets the value of the archiveEngineHost property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArchiveEngineHost(String value) {
        this.archiveEngineHost = value;
    }

    /**
     * Gets the value of the mediaServicesEngineHost property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMediaServicesEngineHost() {
        return mediaServicesEngineHost;
    }

    /**
     * Sets the value of the mediaServicesEngineHost property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMediaServicesEngineHost(String value) {
        this.mediaServicesEngineHost = value;
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
