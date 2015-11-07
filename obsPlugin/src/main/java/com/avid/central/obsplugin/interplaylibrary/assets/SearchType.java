
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
 *         Parameters for the Search operation. Searches can be done from a specified root folder against
 *         specified conditions on attributes. The optional ReturnAttributes allows the caller to specifically indicate
 *         what attributes should be returned for each asset.
 *       
 * 
 * <p>Java class for SearchType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SearchType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InterplayPathURI" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SearchGroup" type="{http://avid.com/interplay/ws/assets/types}SearchGroupType"/>
 *         &lt;element name="ReturnAttributes" type="{http://avid.com/interplay/ws/assets/types}AttributeListType" minOccurs="0"/>
 *         &lt;element name="MaxResults" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
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
@XmlType(name = "SearchType", propOrder = {
    "interplayPathURI",
    "searchGroup",
    "returnAttributes",
    "maxResults",
    "extension",
    "any"
})
public class SearchType {

    @XmlElement(name = "InterplayPathURI", required = true)
    protected String interplayPathURI;
    @XmlElement(name = "SearchGroup", required = true)
    protected SearchGroupType searchGroup;
    @XmlElement(name = "ReturnAttributes")
    protected AttributeListType returnAttributes;
    @XmlElement(name = "MaxResults")
    protected Integer maxResults;
    @XmlElement(name = "Extension")
    protected ExtensionType extension;
    @XmlAnyElement(lax = true)
    protected List<Object> any;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the interplayPathURI property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInterplayPathURI() {
        return interplayPathURI;
    }

    /**
     * Sets the value of the interplayPathURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInterplayPathURI(String value) {
        this.interplayPathURI = value;
    }

    /**
     * Gets the value of the searchGroup property.
     * 
     * @return
     *     possible object is
     *     {@link SearchGroupType }
     *     
     */
    public SearchGroupType getSearchGroup() {
        return searchGroup;
    }

    /**
     * Sets the value of the searchGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link SearchGroupType }
     *     
     */
    public void setSearchGroup(SearchGroupType value) {
        this.searchGroup = value;
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
     * Gets the value of the maxResults property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxResults() {
        return maxResults;
    }

    /**
     * Sets the value of the maxResults property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxResults(Integer value) {
        this.maxResults = value;
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
