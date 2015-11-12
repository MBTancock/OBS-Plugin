
package com.avid.central.obsplugin.inewslibrary.inewssystem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *       Parameters for RetrieveSearchResults request.  SearchID is the ID of the search whose results are to be returned.
 *       ReturnFullStory indicates whether the complete stories including NSML should be retrieved from the database or 
 *       whether the results will contain just the queue names and queue locators.
 *       
 * 
 * <p>Java class for RetrieveSearchResultsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RetrieveSearchResultsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SearchID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ReturnFullStory" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetrieveSearchResultsType", propOrder = {
    "searchID",
    "returnFullStory"
})
public class RetrieveSearchResultsType {

    @XmlElement(name = "SearchID")
    protected long searchID;
    @XmlElement(name = "ReturnFullStory")
    protected boolean returnFullStory;

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

    /**
     * Gets the value of the returnFullStory property.
     * 
     */
    public boolean isReturnFullStory() {
        return returnFullStory;
    }

    /**
     * Sets the value of the returnFullStory property.
     * 
     */
    public void setReturnFullStory(boolean value) {
        this.returnFullStory = value;
    }

}
