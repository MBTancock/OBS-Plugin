
package com.avid.central.obsplugin.interplaylibrary.infrastructure;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *         A list of FileLocationDetailsType
 *       
 * 
 * <p>Java class for FileLocationDetailsListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FileLocationDetailsListType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="FileLocationDetails" type="{http://avid.com/interplay/ws/assets/types}FileLocationDetailsType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FileLocationDetailsListType", propOrder = {
    "fileLocationDetails"
})
public class FileLocationDetailsListType {

    @XmlElement(name = "FileLocationDetails")
    protected List<FileLocationDetailsType> fileLocationDetails;

    /**
     * Gets the value of the fileLocationDetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fileLocationDetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFileLocationDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FileLocationDetailsType }
     * 
     * 
     */
    public List<FileLocationDetailsType> getFileLocationDetails() {
        if (fileLocationDetails == null) {
            fileLocationDetails = new ArrayList<FileLocationDetailsType>();
        }
        return this.fileLocationDetails;
    }

}
