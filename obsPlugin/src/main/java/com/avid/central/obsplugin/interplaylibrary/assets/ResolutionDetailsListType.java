
package com.avid.central.obsplugin.interplaylibrary.assets;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *         A list of ResolutionDetailsTypes.
 *       
 * 
 * <p>Java class for ResolutionDetailsListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResolutionDetailsListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ResolutionDetails" type="{http://avid.com/interplay/ws/assets/types}ResolutionDetailsType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResolutionDetailsListType", propOrder = {
    "resolutionDetails"
})
public class ResolutionDetailsListType {

    @XmlElement(name = "ResolutionDetails")
    protected List<ResolutionDetailsType> resolutionDetails;

    /**
     * Gets the value of the resolutionDetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the resolutionDetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResolutionDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ResolutionDetailsType }
     * 
     * 
     */
    public List<ResolutionDetailsType> getResolutionDetails() {
        if (resolutionDetails == null) {
            resolutionDetails = new ArrayList<ResolutionDetailsType>();
        }
        return this.resolutionDetails;
    }

}
