
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
 *         Parameters for the GetAttributes operation. Gets a set of attributes for a list of assets
 *         specified by InterplayURIs. If an Attributes element is included, the requested attributes will be returned.
 *         Otherwise, the default set of attributes is returned.
 *       
 * 
 * <p>Java class for GetAttributesInternalType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetAttributesInternalType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InterplayURIs" type="{http://avid.com/interplay/ws/assets/types}InterplayURIListType"/>
 *         &lt;element name="InterplaySourceURIs" type="{http://avid.com/interplay/ws/assets/types}AssetDescriptionListType"/>
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
@XmlType(name = "GetAttributesInternalType", propOrder = {
    "interplayURIs",
    "interplaySourceURIs",
    "extension",
    "any"
})
public class GetAttributesInternalType {

    @XmlElement(name = "InterplayURIs", required = true)
    protected InterplayURIListType interplayURIs;
    @XmlElement(name = "InterplaySourceURIs", required = true)
    protected AssetDescriptionListType interplaySourceURIs;
    @XmlElement(name = "Extension")
    protected ExtensionType extension;
    @XmlAnyElement(lax = true)
    protected List<Object> any;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the interplayURIs property.
     * 
     * @return
     *     possible object is
     *     {@link InterplayURIListType }
     *     
     */
    public InterplayURIListType getInterplayURIs() {
        return interplayURIs;
    }

    /**
     * Sets the value of the interplayURIs property.
     * 
     * @param value
     *     allowed object is
     *     {@link InterplayURIListType }
     *     
     */
    public void setInterplayURIs(InterplayURIListType value) {
        this.interplayURIs = value;
    }

    /**
     * Gets the value of the interplaySourceURIs property.
     * 
     * @return
     *     possible object is
     *     {@link AssetDescriptionListType }
     *     
     */
    public AssetDescriptionListType getInterplaySourceURIs() {
        return interplaySourceURIs;
    }

    /**
     * Sets the value of the interplaySourceURIs property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssetDescriptionListType }
     *     
     */
    public void setInterplaySourceURIs(AssetDescriptionListType value) {
        this.interplaySourceURIs = value;
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
