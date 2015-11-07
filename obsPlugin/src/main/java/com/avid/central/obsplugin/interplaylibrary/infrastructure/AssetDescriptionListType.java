
package com.avid.central.obsplugin.interplaylibrary.infrastructure;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *         A list of AssetDescriptions.
 *       
 * 
 * <p>Java class for AssetDescriptionListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AssetDescriptionListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AssetDescription" type="{http://avid.com/interplay/ws/assets/types}AssetDescriptionType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AssetDescriptionListType", propOrder = {
    "assetDescription"
})
public class AssetDescriptionListType {

    @XmlElement(name = "AssetDescription")
    protected List<AssetDescriptionType> assetDescription;

    /**
     * Gets the value of the assetDescription property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the assetDescription property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAssetDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AssetDescriptionType }
     * 
     * 
     */
    public List<AssetDescriptionType> getAssetDescription() {
        if (assetDescription == null) {
            assetDescription = new ArrayList<AssetDescriptionType>();
        }
        return this.assetDescription;
    }

}
