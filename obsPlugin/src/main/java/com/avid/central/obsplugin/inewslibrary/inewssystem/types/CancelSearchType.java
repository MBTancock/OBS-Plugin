
package com.avid.central.obsplugin.inewslibrary.inewssystem.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *       Parameters for CancelSearch request.  SearchID is the ID of the search which is to be canceled.
 *       
 * 
 * <p>Java class for CancelSearchType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CancelSearchType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SearchID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CancelSearchType", propOrder = {
    "searchID"
})
public class CancelSearchType {

    @XmlElement(name = "SearchID")
    protected long searchID;

    /**
     * Gets the value of the searchID property.
     * 
     */
    public long getSearchID() {
        return searchID;
    }

    /**
     * Sets the value of the searchID property.
     * 
     */
    public void setSearchID(long value) {
        this.searchID = value;
    }

}
