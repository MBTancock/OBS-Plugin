
package com.avid.central.obsplugin.interplaylibrary.infrastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import org.w3c.dom.Element;


/**
 * <p>Java class for SearchGroupType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SearchGroupType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AttributeCondition" type="{http://avid.com/interplay/ws/assets/types}AttributeConditionType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="CategoryCondition" type="{http://avid.com/interplay/ws/assets/types}CategoryConditionType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="FileInUseCondition" type="{http://avid.com/interplay/ws/assets/types}FileInUseConditionType" minOccurs="0"/&gt;
 *         &lt;element name="ResolutionCondition" type="{http://avid.com/interplay/ws/assets/types}ResolutionConditionType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="SearchGroup" type="{http://avid.com/interplay/ws/assets/types}SearchGroupType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="Extension" type="{http://avid.com/interplay/ws/assets/types}ExtensionType" minOccurs="0"/&gt;
 *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Operator" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="Negated" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;anyAttribute processContents='lax'/&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchGroupType", propOrder = {
    "attributeCondition",
    "categoryCondition",
    "fileInUseCondition",
    "resolutionCondition",
    "searchGroup",
    "extension",
    "any"
})
public class SearchGroupType {

    @XmlElement(name = "AttributeCondition")
    protected List<AttributeConditionType> attributeCondition;
    @XmlElement(name = "CategoryCondition")
    protected List<CategoryConditionType> categoryCondition;
    @XmlElement(name = "FileInUseCondition")
    protected FileInUseConditionType fileInUseCondition;
    @XmlElement(name = "ResolutionCondition")
    protected List<ResolutionConditionType> resolutionCondition;
    @XmlElement(name = "SearchGroup")
    protected List<SearchGroupType> searchGroup;
    @XmlElement(name = "Extension")
    protected ExtensionType extension;
    @XmlAnyElement(lax = true)
    protected List<Object> any;
    @XmlAttribute(name = "Operator", required = true)
    protected String operator;
    @XmlAttribute(name = "Negated")
    protected Boolean negated;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the attributeCondition property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attributeCondition property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttributeCondition().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AttributeConditionType }
     * 
     * 
     */
    public List<AttributeConditionType> getAttributeCondition() {
        if (attributeCondition == null) {
            attributeCondition = new ArrayList<AttributeConditionType>();
        }
        return this.attributeCondition;
    }

    /**
     * Gets the value of the categoryCondition property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the categoryCondition property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCategoryCondition().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CategoryConditionType }
     * 
     * 
     */
    public List<CategoryConditionType> getCategoryCondition() {
        if (categoryCondition == null) {
            categoryCondition = new ArrayList<CategoryConditionType>();
        }
        return this.categoryCondition;
    }

    /**
     * Gets the value of the fileInUseCondition property.
     * 
     * @return
     *     possible object is
     *     {@link FileInUseConditionType }
     *     
     */
    public FileInUseConditionType getFileInUseCondition() {
        return fileInUseCondition;
    }

    /**
     * Sets the value of the fileInUseCondition property.
     * 
     * @param value
     *     allowed object is
     *     {@link FileInUseConditionType }
     *     
     */
    public void setFileInUseCondition(FileInUseConditionType value) {
        this.fileInUseCondition = value;
    }

    /**
     * Gets the value of the resolutionCondition property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the resolutionCondition property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResolutionCondition().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ResolutionConditionType }
     * 
     * 
     */
    public List<ResolutionConditionType> getResolutionCondition() {
        if (resolutionCondition == null) {
            resolutionCondition = new ArrayList<ResolutionConditionType>();
        }
        return this.resolutionCondition;
    }

    /**
     * Gets the value of the searchGroup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the searchGroup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSearchGroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SearchGroupType }
     * 
     * 
     */
    public List<SearchGroupType> getSearchGroup() {
        if (searchGroup == null) {
            searchGroup = new ArrayList<SearchGroupType>();
        }
        return this.searchGroup;
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
     * Gets the value of the operator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperator() {
        return operator;
    }

    /**
     * Sets the value of the operator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperator(String value) {
        this.operator = value;
    }

    /**
     * Gets the value of the negated property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNegated() {
        return negated;
    }

    /**
     * Sets the value of the negated property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNegated(Boolean value) {
        this.negated = value;
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
