
package com.avid.central.obsplugin.interplaylibrary.infrastructure;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *         A list of FileLocationDetailsTypes.
 *       
 * 
 * <p>Java class for FileLocationListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FileLocationListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FileLocation" type="{http://avid.com/interplay/ws/assets/types}FileLocationType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FileLocationListType", propOrder = {
    "fileLocation"
})
public class FileLocationListType {

    @XmlElement(name = "FileLocation")
    protected List<FileLocationType> fileLocation;

    /**
     * Gets the value of the fileLocation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fileLocation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFileLocation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FileLocationType }
     * 
     * 
     */
    public List<FileLocationType> getFileLocation() {
        if (fileLocation == null) {
            fileLocation = new ArrayList<FileLocationType>();
        }
        return this.fileLocation;
    }

}
