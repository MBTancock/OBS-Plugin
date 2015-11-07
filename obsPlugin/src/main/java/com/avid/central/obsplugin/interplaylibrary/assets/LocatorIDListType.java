
package com.avid.central.obsplugin.interplaylibrary.assets;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *         A list of locator IDs.
 *       
 * 
 * <p>Java class for LocatorIDListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LocatorIDListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LocatorID" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LocatorIDListType", propOrder = {
    "locatorID"
})
public class LocatorIDListType {

    @XmlElement(name = "LocatorID", nillable = true)
    protected List<Integer> locatorID;

    /**
     * Gets the value of the locatorID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the locatorID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLocatorID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getLocatorID() {
        if (locatorID == null) {
            locatorID = new ArrayList<Integer>();
        }
        return this.locatorID;
    }

}
