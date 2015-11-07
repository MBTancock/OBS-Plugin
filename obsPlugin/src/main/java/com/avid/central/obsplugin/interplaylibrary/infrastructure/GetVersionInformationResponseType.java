
package com.avid.central.obsplugin.interplaylibrary.infrastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import org.w3c.dom.Element;


/**
 * 
 *         The response from the GetVersionInformation operation. Errors contains a list of errors that
 *         occurred. If there are no errors, the Errors element is omitted entirely. If the operation is successful, the
 *         version of Interplay Web Services will be returned along with one or more versions of configured Interplay
 *         Engines and Archive Engines.
 *       
 * 
 * <p>Java class for GetVersionInformationResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetVersionInformationResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Errors" type="{http://avid.com/interplay/ws/assets/types}ErrorListType" minOccurs="0"/>
 *         &lt;element name="InterplayWebServicesVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Workgroups" type="{http://avid.com/interplay/ws/infrastructure/types}WorkGroupDetailsListType" minOccurs="0"/>
 *         &lt;element name="Extension" type="{http://avid.com/interplay/ws/assets/types}ExtensionType" minOccurs="0"/>
 *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;anyAttribute processContents='lax'/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetVersionInformationResponseType", namespace = "http://avid.com/interplay/ws/infrastructure/types", propOrder = {
    "errors",
    "interplayWebServicesVersion",
    "workgroups",
    "extension",
    "any"
})
public class GetVersionInformationResponseType {

    @XmlElement(name = "Errors")
    protected ErrorListType errors;
    @XmlElement(name = "InterplayWebServicesVersion")
    protected String interplayWebServicesVersion;
    @XmlElement(name = "Workgroups")
    protected WorkGroupDetailsListType workgroups;
    @XmlElement(name = "Extension")
    protected ExtensionType extension;
    @XmlAnyElement(lax = true)
    protected List<Object> any;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the errors property.
     * 
     * @return
     *     possible object is
     *     {@link ErrorListType }
     *     
     */
    public ErrorListType getErrors() {
        return errors;
    }

    /**
     * Sets the value of the errors property.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorListType }
     *     
     */
    public void setErrors(ErrorListType value) {
        this.errors = value;
    }

    /**
     * Gets the value of the interplayWebServicesVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInterplayWebServicesVersion() {
        return interplayWebServicesVersion;
    }

    /**
     * Sets the value of the interplayWebServicesVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInterplayWebServicesVersion(String value) {
        this.interplayWebServicesVersion = value;
    }

    /**
     * Gets the value of the workgroups property.
     * 
     * @return
     *     possible object is
     *     {@link WorkGroupDetailsListType }
     *     
     */
    public WorkGroupDetailsListType getWorkgroups() {
        return workgroups;
    }

    /**
     * Sets the value of the workgroups property.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkGroupDetailsListType }
     *     
     */
    public void setWorkgroups(WorkGroupDetailsListType value) {
        this.workgroups = value;
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
     * {@link Object }
     * {@link Element }
     * 
     * 
     */
    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
    }

    /**
     * Gets a map that contains attributes that aren't bound to any typed property on this class.
     * 
     * <p>
     * the map is keyed by the name of the attribute and 
     * the value is the string value of the attribute.
     * 
     * the map returned by this method is live, and you can add new attribute
     * by updating the map directly. Because of this design, there's no setter.
     * 
     * 
     * @return
     *     always non-null
     */
    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

}
