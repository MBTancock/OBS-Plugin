
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
 *         The response from the CreateUser operation. Errors contains a list of errors that occurred. If
 *         there are no errors, the Errors element is omitted entirely. Deleted Assets contains a list of the InterplayURIs
 *         representing the metadata objects deleted from the database. DeletedMedia contains a list of file paths and
 *         resolutions of media that was deleted. If the request was sent in "Simulation" mode, then the reports
 *         only indicate what would have been deleted.
 *       
 * 
 * <p>Java class for DeleteAssetsResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DeleteAssetsResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Errors" type="{http://avid.com/interplay/ws/assets/types}ErrorListType" minOccurs="0"/&gt;
 *         &lt;element name="DeletedAssets" type="{http://avid.com/interplay/ws/assets/types}InterplayURIListType" minOccurs="0"/&gt;
 *         &lt;element name="DeletedMedia" type="{http://avid.com/interplay/ws/assets/types}MediaDetailsListType" minOccurs="0"/&gt;
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
@XmlType(name = "DeleteAssetsResponseType", propOrder = {
    "errors",
    "deletedAssets",
    "deletedMedia",
    "extension",
    "any"
})
public class DeleteAssetsResponseType {

    @XmlElement(name = "Errors")
    protected ErrorListType errors;
    @XmlElement(name = "DeletedAssets")
    protected InterplayURIListType deletedAssets;
    @XmlElement(name = "DeletedMedia")
    protected MediaDetailsListType deletedMedia;
    @XmlElement(name = "Extension")
    protected ExtensionType extension;
    @XmlAnyElement(lax = true)
    protected List<Object> any;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the errors property.
     * 
     * @return
     *     possible object is
     *     {@link ErrorListType }
     *     
     */
    public ErrorListType getErrors() {
        return errors;
    }

    /**
     * Sets the value of the errors property.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorListType }
     *     
     */
    public void setErrors(ErrorListType value) {
        this.errors = value;
    }

    /**
     * Gets the value of the deletedAssets property.
     * 
     * @return
     *     possible object is
     *     {@link InterplayURIListType }
     *     
     */
    public InterplayURIListType getDeletedAssets() {
        return deletedAssets;
    }

    /**
     * Sets the value of the deletedAssets property.
     * 
     * @param value
     *     allowed object is
     *     {@link InterplayURIListType }
     *     
     */
    public void setDeletedAssets(InterplayURIListType value) {
        this.deletedAssets = value;
    }

    /**
     * Gets the value of the deletedMedia property.
     * 
     * @return
     *     possible object is
     *     {@link MediaDetailsListType }
     *     
     */
    public MediaDetailsListType getDeletedMedia() {
        return deletedMedia;
    }

    /**
     * Sets the value of the deletedMedia property.
     * 
     * @param value
     *     allowed object is
     *     {@link MediaDetailsListType }
     *     
     */
    public void setDeletedMedia(MediaDetailsListType value) {
        this.deletedMedia = value;
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
