
package com.avid.central.obsplugin.inewslibrary.inewssystem.types;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.avid.central.obsplugin.inewslibrary.inewsstory.types.StoryType;
import org.w3c.dom.Element;


/**
 * 
 *       SearchComplete indicates whether the search res
 *       See documentation for ExtensionType for description of Extension's usage.
 *       
 * 
 * <p>Java class for RetrieveSearchResultsResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RetrieveSearchResultsResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SearchStatus" type="{http://avid.com/inewssystem/types}SearchStatusType"/>
 *         &lt;element name="Stories" type="{http://avid.com/inewsstory/types}StoryType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Extension" type="{http://avid.com/inewssystem/types}ExtensionType" minOccurs="0"/>
 *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetrieveSearchResultsResponseType", propOrder = {
    "searchStatus",
    "stories",
    "extension",
    "any"
})
public class RetrieveSearchResultsResponseType {

    @XmlElement(name = "SearchStatus", required = true)
    protected SearchStatusType searchStatus;
    @XmlElement(name = "Stories")
    protected List<StoryType> stories;
    @XmlElement(name = "Extension")
    protected ExtensionType extension;
    @XmlAnyElement(lax = true)
    protected List<Object> any;

    /**
     * Gets the value of the searchStatus property.
     * 
     * @return
     *     possible object is
     *     {@link SearchStatusType }
     *     
     */
    public SearchStatusType getSearchStatus() {
        return searchStatus;
    }

    /**
     * Sets the value of the searchStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link SearchStatusType }
     *     
     */
    public void setSearchStatus(SearchStatusType value) {
        this.searchStatus = value;
    }

    /**
     * Gets the value of the stories property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the stories property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStories().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StoryType }
     * 
     * 
     */
    public List<StoryType> getStories() {
        if (stories == null) {
            stories = new ArrayList<StoryType>();
        }
        return this.stories;
    }

    /**
     * Gets the value of the extension property.
     * 
     * @return
     *     possible object is
     *     {@link ExtensionType }
     *     
     */
    public ExtensionType getExtension() {
        return extension;
    }

    /**
     * Sets the value of the extension property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtensionType }
     *     
     */
    public void setExtension(ExtensionType value) {
        this.extension = value;
    }

    /**
     * Gets the value of the any property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the any property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAny().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Element }
     * {@link Object }
     * 
     * 
     */
    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
    }

}
