
package com.avid.central.obsplugin.inewslibrary.inewssystem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *       Parameters for the GetFolderChildren request.  FolderFullName is the fully qualified name (excluding server name) 
 *       of the Folder (not Queue) whose children you wish to retrieve.  Both empty value or . (dot) maybe used to retrieve
 *       the root folder.
 *       
 * 
 * <p>Java class for GetFolderChildrenType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetFolderChildrenType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FolderFullName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetFolderChildrenType", propOrder = {
    "folderFullName"
})
public class GetFolderChildrenType {

    @XmlElement(name = "FolderFullName", required = true)
    protected String folderFullName;

    /**
     * Gets the value of the folderFullName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFolderFullName() {
        return folderFullName;
    }

    /**
     * Sets the value of the folderFullName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFolderFullName(String value) {
        this.folderFullName = value;
    }

}
