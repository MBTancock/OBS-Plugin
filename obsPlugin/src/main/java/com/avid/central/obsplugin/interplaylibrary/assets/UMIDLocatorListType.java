
package com.avid.central.obsplugin.interplaylibrary.assets;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *         A list of UMID locators.
 *       
 * 
 * <p>Java class for UMIDLocatorListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UMIDLocatorListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Locator" type="{http://avid.com/interplay/ws/assets/types}UMIDLocatorType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UMIDLocatorListType", propOrder = {
    "locator"
})
public class UMIDLocatorListType {

    @XmlElement(name = "Locator")
    protected List<UMIDLocatorType> locator;

    /**
     * Gets the value of the locator property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the locator property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLocator().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UMIDLocatorType }
     * 
     * 
     */
    public List<UMIDLocatorType> getLocator() {
        if (locator == null) {
            locator = new ArrayList<UMIDLocatorType>();
        }
        return this.locator;
    }

}
