
package com.avid.central.obsplugin.interplaylibrary.assets;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.w3c.dom.Element;


/**
 * 
 *         The details of a reservation: who made the reservation, when it expires, and what is the asset causing
 *         the reservation (i.e., the reserved folder in the heirarchy).
 *       
 * 
 * <p>Java class for ReservationDetailsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReservationDetailsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ReservedBy" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ExpirationDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ReservedAsset" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Extension" type="{http://avid.com/interplay/ws/assets/types}ExtensionType" minOccurs="0"/>
 *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReservationDetailsType", propOrder = {
    "reservedBy",
    "expirationDate",
    "reservedAsset",
    "extension",
    "any"
})
public class ReservationDetailsType {

    @XmlElement(name = "ReservedBy", required = true)
    protected String reservedBy;
    @XmlElement(name = "ExpirationDate", required = true)
    protected String expirationDate;
    @XmlElement(name = "ReservedAsset", required = true)
    protected String reservedAsset;
    @XmlElement(name = "Extension")
    protected ExtensionType extension;
    @XmlAnyElement(lax = true)
    protected List<Object> any;

    /**
     * Gets the value of the reservedBy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReservedBy() {
        return reservedBy;
    }

    /**
     * Sets the value of the reservedBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReservedBy(String value) {
        this.reservedBy = value;
    }

    /**
     * Gets the value of the expirationDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpirationDate() {
        return expirationDate;
    }

    /**
     * Sets the value of the expirationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpirationDate(String value) {
        this.expirationDate = value;
    }

    /**
     * Gets the value of the reservedAsset property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReservedAsset() {
        return reservedAsset;
    }

    /**
     * Sets the value of the reservedAsset property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReservedAsset(String value) {
        this.reservedAsset = value;
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

}
