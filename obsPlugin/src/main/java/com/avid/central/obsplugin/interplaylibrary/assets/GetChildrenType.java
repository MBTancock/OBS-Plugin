
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
 *         Parameters for the GetChildren operation. Gets the child nodes located under the location
 *         pointed to by InterplayURI. IncludeFolders, IncludeFiles, and IncludeMOBs allow the results to be filtered by
 *         the type of node. If not passed in, they each default to true. The optional NameFilter allows the results to be
 *         filtered based on name and a regular expression. The optional ReturnAttributes allows the caller to
 *         specifically indicate what attributes should be returned for each asset.
 *       
 * 
 * <p>Java class for GetChildrenType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetChildrenType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InterplayURI" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="IncludeFolders" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IncludeFiles" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IncludeMOBs" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="NameFilter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReturnAttributes" type="{http://avid.com/interplay/ws/assets/types}AttributeListType" minOccurs="0"/>
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
@XmlType(name = "GetChildrenType", propOrder = {
    "interplayURI",
    "includeFolders",
    "includeFiles",
    "includeMOBs",
    "nameFilter",
    "returnAttributes",
    "extension",
    "any"
})
public class GetChildrenType {

    @XmlElement(name = "InterplayURI", required = true)
    protected String interplayURI;
    @XmlElement(name = "IncludeFolders")
    protected Boolean includeFolders;
    @XmlElement(name = "IncludeFiles")
    protected Boolean includeFiles;
    @XmlElement(name = "IncludeMOBs")
    protected Boolean includeMOBs;
    @XmlElement(name = "NameFilter")
    protected String nameFilter;
    @XmlElement(name = "ReturnAttributes")
    protected AttributeListType returnAttributes;
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
     * Gets the value of the includeFolders property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeFolders() {
        return includeFolders;
    }

    /**
     * Sets the value of the includeFolders property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeFolders(Boolean value) {
        this.includeFolders = value;
    }

    /**
     * Gets the value of the includeFiles property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeFiles() {
        return includeFiles;
    }

    /**
     * Sets the value of the includeFiles property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeFiles(Boolean value) {
        this.includeFiles = value;
    }

    /**
     * Gets the value of the includeMOBs property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeMOBs() {
        return includeMOBs;
    }

    /**
     * Sets the value of the includeMOBs property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeMOBs(Boolean value) {
        this.includeMOBs = value;
    }

    /**
     * Gets the value of the nameFilter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameFilter() {
        return nameFilter;
    }

    /**
     * Sets the value of the nameFilter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameFilter(String value) {
        this.nameFilter = value;
    }

    /**
     * Gets the value of the returnAttributes property.
     * 
     * @return
     *     possible object is
     *     {@link AttributeListType }
     *     
     */
    public AttributeListType getReturnAttributes() {
        return returnAttributes;
    }

    /**
     * Sets the value of the returnAttributes property.
     * 
     * @param value
     *     allowed object is
     *     {@link AttributeListType }
     *     
     */
    public void setReturnAttributes(AttributeListType value) {
        this.returnAttributes = value;
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
