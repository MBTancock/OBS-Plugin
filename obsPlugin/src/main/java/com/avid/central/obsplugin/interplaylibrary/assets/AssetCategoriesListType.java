
package com.avid.central.obsplugin.interplaylibrary.assets;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *         A list of AssetCategories.
 *       
 * 
 * <p>Java class for AssetCategoriesListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AssetCategoriesListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AssetCategories" type="{http://avid.com/interplay/ws/assets/types}AssetCategoriesType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AssetCategoriesListType", propOrder = {
    "assetCategories"
})
public class AssetCategoriesListType {

    @XmlElement(name = "AssetCategories")
    protected List<AssetCategoriesType> assetCategories;

    /**
     * Gets the value of the assetCategories property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the assetCategories property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAssetCategories().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AssetCategoriesType }
     * 
     * 
     */
    public List<AssetCategoriesType> getAssetCategories() {
        if (assetCategories == null) {
            assetCategories = new ArrayList<AssetCategoriesType>();
        }
        return this.assetCategories;
    }

}
