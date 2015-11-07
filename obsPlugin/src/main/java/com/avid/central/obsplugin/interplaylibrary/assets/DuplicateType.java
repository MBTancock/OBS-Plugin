
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
 *         Parameters for the Duplicate operation. InterplayAssetURI must reference the asset that you
 *         wish to duplicate. InterplayFolderURI references the folder to create the duplicate in.
 *       
 * 
 * <p>Java class for DuplicateType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DuplicateType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InterplayAssetURI" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="InterplayFolderURI" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "DuplicateType", propOrder = {
    "interplayAssetURI",
    "interplayFolderURI",
    "attributes",
    "extension",
    "any"
})
public class DuplicateType {

    @XmlElement(name = "InterplayAssetURI", required = true)
    protected String interplayAssetURI;
    @XmlElement(name = "InterplayFolderURI", required = true)
    protected String interplayFolderURI;
    @XmlElement(name = "Attributes")
    protected AttributeListType attributes;
    @XmlElement(name = "Extension")
    protected ExtensionType extension;
    @XmlAnyElement(lax = true)
    protected List<Object> any;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the interplayAssetURI property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInterplayAssetURI() {
        return interplayAssetURI;
    }

    /**
     * Sets the value of the interplayAssetURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInterplayAssetURI(String value) {
        this.interplayAssetURI = value;
    }

    /**
     * Gets the value of the interplayFolderURI property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInterplayFolderURI() {
        return interplayFolderURI;
    }

    /**
     * Sets the value of the interplayFolderURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInterplayFolderURI(String value) {
        this.interplayFolderURI = value;
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
