
package com.avid.central.obsplugin.inewslibrary.inewssystem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *       Parameters for GetQueuesForm request.  QueueFullName is the full path to the queue on the iNEWS server.  FormType 
 *       is the type of form that you wish to retrieve; either Queue or Story.
 *       
 * 
 * <p>Java class for GetQueuesFormType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetQueuesFormType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="QueueFullName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FormType" type="{http://avid.com/inewssystem/types}FormTypeType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetQueuesFormType", propOrder = {
    "queueFullName",
    "formType"
})
public class GetQueuesFormType {

    @XmlElement(name = "QueueFullName", required = true)
    protected String queueFullName;
    @XmlElement(name = "FormType", required = true)
    protected FormTypeType formType;

    /**
     * Gets the value of the queueFullName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQueueFullName() {
        return queueFullName;
    }

    /**
     * Sets the value of the queueFullName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQueueFullName(String value) {
        this.queueFullName = value;
    }

    /**
     * Gets the value of the formType property.
     * 
     * @return
     *     possible object is
     *     {@link FormTypeType }
     *     
     */
    public FormTypeType getFormType() {
        return formType;
    }

    /**
     * Sets the value of the formType property.
     * 
     * @param value
     *     allowed object is
     *     {@link FormTypeType }
     *     
     */
    public void setFormType(FormTypeType value) {
        this.formType = value;
    }

}
