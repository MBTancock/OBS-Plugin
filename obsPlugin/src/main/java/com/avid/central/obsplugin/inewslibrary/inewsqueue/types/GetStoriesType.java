
package com.avid.central.obsplugin.inewslibrary.inewsqueue.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 	   The parameters for a GetStories request.  NumberOfStoriesToGet is an integer number indication the number of 
 * 	   iNEWS stories to retrieve. IsStoryBodyIncluded is a boolean indicating whether the returned stories are to 
 * 	   include the story body or not.  Navigation indicates which direction to traverse the Queue: NEXT, PREV or SAME.  
 * 	   Same is to return the same stories the previous request fetched.
 * 	   
 * 
 * <p>Java class for GetStoriesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetStoriesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NumberOfStoriesToGet" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="IsStoryBodyIncluded" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Navigation" type="{http://avid.com/inewsqueue/types}GetStoriesNavigationEnum"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetStoriesType", namespace = "http://avid.com/inewsqueue/types", propOrder = {
    "numberOfStoriesToGet",
    "isStoryBodyIncluded",
    "navigation"
})
public class GetStoriesType {

    @XmlElement(name = "NumberOfStoriesToGet")
    protected int numberOfStoriesToGet;
    @XmlElement(name = "IsStoryBodyIncluded")
    protected boolean isStoryBodyIncluded;
    @XmlElement(name = "Navigation", required = true)
    protected GetStoriesNavigationEnum navigation;

    /**
     * Gets the value of the numberOfStoriesToGet property.
     * 
     */
    public int getNumberOfStoriesToGet() {
        return numberOfStoriesToGet;
    }

    /**
     * Sets the value of the numberOfStoriesToGet property.
     * 
     */
    public void setNumberOfStoriesToGet(int value) {
        this.numberOfStoriesToGet = value;
    }

    /**
     * Gets the value of the isStoryBodyIncluded property.
     * 
     */
    public boolean isIsStoryBodyIncluded() {
        return isStoryBodyIncluded;
    }

    /**
     * Sets the value of the isStoryBodyIncluded property.
     * 
     */
    public void setIsStoryBodyIncluded(boolean value) {
        this.isStoryBodyIncluded = value;
    }

    /**
     * Gets the value of the navigation property.
     * 
     * @return
     *     possible object is
     *     {@link GetStoriesNavigationEnum }
     *     
     */
    public GetStoriesNavigationEnum getNavigation() {
        return navigation;
    }

    /**
     * Sets the value of the navigation property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetStoriesNavigationEnum }
     *     
     */
    public void setNavigation(GetStoriesNavigationEnum value) {
        this.navigation = value;
    }

}
