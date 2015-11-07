
package com.avid.central.obsplugin.interplaylibrary.assets;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *         A RestrictionDetailsType contains an Interplay URI and a list of RestrictionType objects.
 *       
 * 
 * <p>Java class for RestrictionDetailsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RestrictionDetailsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InterplayURI" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Restrictions" type="{http://avid.com/interplay/ws/assets/types}RestrictionListType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RestrictionDetailsType", propOrder = {
    "interplayURI",
    "restrictions"
})
public class RestrictionDetailsType {

    @XmlElement(name = "InterplayURI", required = true)
    protected String interplayURI;
    @XmlElement(name = "Restrictions", required = true)
    protected RestrictionListType restrictions;

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
     * Gets the value of the restrictions property.
     * 
     * @return
     *     possible object is
     *     {@link RestrictionListType }
     *     
     */
    public RestrictionListType getRestrictions() {
        return restrictions;
    }

    /**
     * Sets the value of the restrictions property.
     * 
     * @param value
     *     allowed object is
     *     {@link RestrictionListType }
     *     
     */
    public void setRestrictions(RestrictionListType value) {
        this.restrictions = value;
    }

}
