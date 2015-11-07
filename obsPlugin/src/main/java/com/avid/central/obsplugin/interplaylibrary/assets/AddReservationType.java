
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
 *         Parameters for the AddReservation operation. Pass in one or more InterplayURIs representing
 *         folders and a time for the reservation to expire (in seconds). The new reservation will belong to the user whose
 *         credentials are passed in.
 *       
 * 
 * <p>Java class for AddReservationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AddReservationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FolderURIs" type="{http://avid.com/interplay/ws/assets/types}InterplayURIListType"/>
 *         &lt;element name="TimeToExpireInSeconds" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "AddReservationType", propOrder = {
    "folderURIs",
    "timeToExpireInSeconds",
    "extension",
    "any"
})
public class AddReservationType {

    @XmlElement(name = "FolderURIs", required = true)
    protected InterplayURIListType folderURIs;
    @XmlElement(name = "TimeToExpireInSeconds")
    protected int timeToExpireInSeconds;
    @XmlElement(name = "Extension")
    protected ExtensionType extension;
    @XmlAnyElement(lax = true)
    protected List<Object> any;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the folderURIs property.
     * 
     * @return
     *     possible object is
     *     {@link InterplayURIListType }
     *     
     */
    public InterplayURIListType getFolderURIs() {
        return folderURIs;
    }

    /**
     * Sets the value of the folderURIs property.
     * 
     * @param value
     *     allowed object is
     *     {@link InterplayURIListType }
     *     
     */
    public void setFolderURIs(InterplayURIListType value) {
        this.folderURIs = value;
    }

    /**
     * Gets the value of the timeToExpireInSeconds property.
     * 
     */
    public int getTimeToExpireInSeconds() {
        return timeToExpireInSeconds;
    }

    /**
     * Sets the value of the timeToExpireInSeconds property.
     * 
     */
    public void setTimeToExpireInSeconds(int value) {
        this.timeToExpireInSeconds = value;
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