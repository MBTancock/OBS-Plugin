
package com.avid.central.obsplugin.interplaylibrary.assets;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *         The NewMasterClipURLType is returned by the CreateMasterclip operation. It contains the new masterclip's
 *         Mob ID and Source ID.
 *       
 * 
 * <p>Java class for NewMasterClipURLType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NewMasterClipURLType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InterplayURI" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SourceID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NewMasterClipURLType", propOrder = {
    "interplayURI",
    "sourceID"
})
public class NewMasterClipURLType {

    @XmlElement(name = "InterplayURI", required = true)
    protected String interplayURI;
    @XmlElement(name = "SourceID", required = true)
    protected String sourceID;

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
     * Gets the value of the sourceID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceID() {
        return sourceID;
    }

    /**
     * Sets the value of the sourceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceID(String value) {
        this.sourceID = value;
    }

}
