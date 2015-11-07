
package com.avid.central.obsplugin.interplaylibrary.assets;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *         A list of ShotlistElementListTypes.
 *       
 * 
 * <p>Java class for ShotlistElementListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ShotlistElementListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ShotlistElement" type="{http://avid.com/interplay/ws/assets/types}ShotlistElementType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ShotlistElementListType", propOrder = {
    "shotlistElement"
})
public class ShotlistElementListType {

    @XmlElement(name = "ShotlistElement", required = true)
    protected List<ShotlistElementType> shotlistElement;

    /**
     * Gets the value of the shotlistElement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the shotlistElement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getShotlistElement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ShotlistElementType }
     * 
     * 
     */
    public List<ShotlistElementType> getShotlistElement() {
        if (shotlistElement == null) {
            shotlistElement = new ArrayList<ShotlistElementType>();
        }
        return this.shotlistElement;
    }

}
