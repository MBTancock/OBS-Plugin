
package com.avid.central.obsplugin.inewslibrary.inewsstory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *       Parameters for the LockStory request.  QueueFullName is the full path to the queue on the iNEWS server in which
 *       the story resides, QueueLocator is the reference to the story of interest within the queue. Section is optional.
 *       It is the section of the story to lock.  If the Section element is not specified the default behavior will
 *       be to lock all sections of the story.
 *       
 * 
 * <p>Java class for LockStoryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LockStoryType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="QueueFullName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="QueueLocator" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Section" type="{http://avid.com/inewsstory/types}SectionLockEnum" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LockStoryType", namespace = "http://avid.com/inewsstory/types", propOrder = {
    "queueFullName",
    "queueLocator",
    "section"
})
public class LockStoryType {

    @XmlElement(name = "QueueFullName", required = true)
    protected String queueFullName;
    @XmlElement(name = "QueueLocator", required = true)
    protected String queueLocator;
    @XmlElement(name = "Section")
    protected SectionLockEnum section;

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
     * Gets the value of the queueLocator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQueueLocator() {
        return queueLocator;
    }

    /**
     * Sets the value of the queueLocator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQueueLocator(String value) {
        this.queueLocator = value;
    }

    /**
     * Gets the value of the section property.
     * 
     * @return
     *     possible object is
     *     {@link SectionLockEnum }
     *     
     */
    public SectionLockEnum getSection() {
        return section;
    }

    /**
     * Sets the value of the section property.
     * 
     * @param value
     *     allowed object is
     *     {@link SectionLockEnum }
     *     
     */
    public void setSection(SectionLockEnum value) {
        this.section = value;
    }

}
