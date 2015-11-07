
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
 *         The details of a configured Interplay Engine, including the configured workgroup name, the
 *         Interplay Engine host name, and the Interplay Engine version, the Archive Engine host name, and the Archive
 *         Engine version.
 *       
 * 
 * <p>Java class for WorkGroupDetailsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WorkGroupDetailsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WorkgroupName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="InterplayEngineHost" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="InterplayEngineVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ArchiveEngineHost" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ArchiveEngineVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "WorkGroupDetailsType", namespace = "http://avid.com/interplay/ws/infrastructure/types", propOrder = {
    "workgroupName",
    "interplayEngineHost",
    "interplayEngineVersion",
    "archiveEngineHost",
    "archiveEngineVersion",
    "extension",
    "any"
})
public class WorkGroupDetailsType {

    @XmlElement(name = "WorkgroupName", required = true)
    protected String workgroupName;
    @XmlElement(name = "InterplayEngineHost", required = true)
    protected String interplayEngineHost;
    @XmlElement(name = "InterplayEngineVersion")
    protected String interplayEngineVersion;
    @XmlElement(name = "ArchiveEngineHost", required = true)
    protected String archiveEngineHost;
    @XmlElement(name = "ArchiveEngineVersion")
    protected String archiveEngineVersion;
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
     * Gets the value of the interplayEngineVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInterplayEngineVersion() {
        return interplayEngineVersion;
    }

    /**
     * Sets the value of the interplayEngineVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInterplayEngineVersion(String value) {
        this.interplayEngineVersion = value;
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
     * Gets the value of the archiveEngineVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArchiveEngineVersion() {
        return archiveEngineVersion;
    }

    /**
     * Sets the value of the archiveEngineVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArchiveEngineVersion(String value) {
        this.archiveEngineVersion = value;
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
