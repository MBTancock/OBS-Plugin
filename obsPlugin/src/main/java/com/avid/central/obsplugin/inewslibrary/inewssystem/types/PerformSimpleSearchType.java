
package com.avid.central.obsplugin.inewslibrary.inewssystem.types;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *       Parameters for PerformSimpleSearch request:  
 *         SearchType is the type of search to be performed.  See documentation for SearchTypeType for details.  
 *         SearchPath is the full path to the directory on the iNEWS server that will be the root node of the search.
 *         SearchWords are the words that the search will look for in the stories. The total size of all words' lengths + 
 *             number of words cannot exceed 1024.
 *         SearchOperator whether the SearchWords will be ANDed or ORed.
 *         NumberOfParagraphs is the number of paragraphs to scan in the stories when performing a "SOME" search.
 *         HitLimit is the maximum number of results to be returned for the search.
 *       
 * 
 * <p>Java class for PerformSimpleSearchType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PerformSimpleSearchType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SearchType" type="{http://avid.com/inewssystem/types}SearchTypeType"/>
 *         &lt;element name="SearchPath" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SearchWords" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *         &lt;element name="SearchOperator" type="{http://avid.com/inewssystem/types}SearchOperatorType"/>
 *         &lt;element name="NumberOfParagraphs" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="HitLimit" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PerformSimpleSearchType", propOrder = {
    "searchType",
    "searchPath",
    "searchWords",
    "searchOperator",
    "numberOfParagraphs",
    "hitLimit"
})
public class PerformSimpleSearchType {

    @XmlElement(name = "SearchType", required = true)
    protected SearchTypeType searchType;
    @XmlElement(name = "SearchPath", required = true)
    protected String searchPath;
    @XmlElement(name = "SearchWords", required = true)
    protected List<String> searchWords;
    @XmlElement(name = "SearchOperator", required = true)
    protected SearchOperatorType searchOperator;
    @XmlElement(name = "NumberOfParagraphs")
    protected short numberOfParagraphs;
    @XmlElement(name = "HitLimit")
    protected short hitLimit;

    /**
     * Gets the value of the searchType property.
     * 
     * @return
     *     possible object is
     *     {@link SearchTypeType }
     *     
     */
    public SearchTypeType getSearchType() {
        return searchType;
    }

    /**
     * Sets the value of the searchType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SearchTypeType }
     *     
     */
    public void setSearchType(SearchTypeType value) {
        this.searchType = value;
    }

    /**
     * Gets the value of the searchPath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSearchPath() {
        return searchPath;
    }

    /**
     * Sets the value of the searchPath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSearchPath(String value) {
        this.searchPath = value;
    }

    /**
     * Gets the value of the searchWords property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the searchWords property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSearchWords().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSearchWords() {
        if (searchWords == null) {
            searchWords = new ArrayList<String>();
        }
        return this.searchWords;
    }

    /**
     * Gets the value of the searchOperator property.
     * 
     * @return
     *     possible object is
     *     {@link SearchOperatorType }
     *     
     */
    public SearchOperatorType getSearchOperator() {
        return searchOperator;
    }

    /**
     * Sets the value of the searchOperator property.
     * 
     * @param value
     *     allowed object is
     *     {@link SearchOperatorType }
     *     
     */
    public void setSearchOperator(SearchOperatorType value) {
        this.searchOperator = value;
    }

    /**
     * Gets the value of the numberOfParagraphs property.
     * 
     */
    public short getNumberOfParagraphs() {
        return numberOfParagraphs;
    }

    /**
     * Sets the value of the numberOfParagraphs property.
     * 
     */
    public void setNumberOfParagraphs(short value) {
        this.numberOfParagraphs = value;
    }

    /**
     * Gets the value of the hitLimit property.
     * 
     */
    public short getHitLimit() {
        return hitLimit;
    }

    /**
     * Sets the value of the hitLimit property.
     * 
     */
    public void setHitLimit(short value) {
        this.hitLimit = value;
    }

}
