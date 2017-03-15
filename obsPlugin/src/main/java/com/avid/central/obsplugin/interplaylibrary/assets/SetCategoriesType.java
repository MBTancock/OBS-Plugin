
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
 *         Parameters for the SetCategories operation. InterplayURI must represent a valid asset.
 *         CategoriesToAdd is a list of categories to set on the asset. CategoriesToRemove is a list of categories to unset
 *         on the asset.
 *       
 * 
 * <p>Java class for SetCategoriesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SetCategoriesType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="InterplayURI" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="CategoriesToAdd" type="{http://avid.com/interplay/ws/assets/types}CategoriesListType" minOccurs="0"/&gt;
 *         &lt;element name="CategoriesToRemove" type="{http://avid.com/interplay/ws/assets/types}CategoriesListType" minOccurs="0"/&gt;
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
@XmlType(name = "SetCategoriesType", propOrder = {
    "interplayURI",
    "categoriesToAdd",
    "categoriesToRemove",
    "extension",
    "any"
})
public class SetCategoriesType {

    @XmlElement(name = "InterplayURI", required = true)
    protected String interplayURI;
    @XmlElement(name = "CategoriesToAdd")
    protected CategoriesListType categoriesToAdd;
    @XmlElement(name = "CategoriesToRemove")
    protected CategoriesListType categoriesToRemove;
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
     * Gets the value of the categoriesToAdd property.
     * 
     * @return
     *     possible object is
     *     {@link CategoriesListType }
     *     
     */
    public CategoriesListType getCategoriesToAdd() {
        return categoriesToAdd;
    }

    /**
     * Sets the value of the categoriesToAdd property.
     * 
     * @param value
     *     allowed object is
     *     {@link CategoriesListType }
     *     
     */
    public void setCategoriesToAdd(CategoriesListType value) {
        this.categoriesToAdd = value;
    }

    /**
     * Gets the value of the categoriesToRemove property.
     * 
     * @return
     *     possible object is
     *     {@link CategoriesListType }
     *     
     */
    public CategoriesListType getCategoriesToRemove() {
        return categoriesToRemove;
    }

    /**
     * Sets the value of the categoriesToRemove property.
     * 
     * @param value
     *     allowed object is
     *     {@link CategoriesListType }
     *     
     */
    public void setCategoriesToRemove(CategoriesListType value) {
        this.categoriesToRemove = value;
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
