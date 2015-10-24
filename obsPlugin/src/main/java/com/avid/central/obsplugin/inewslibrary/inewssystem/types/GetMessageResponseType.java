
package com.avid.central.obsplugin.inewslibrary.inewssystem.types;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import org.w3c.dom.Element;


/**
 * 
 *       The response from a GetMessage request.  This is the next available message for the connected user.  Recipient is 
 *       the name of the user the message was sent to.  Sender is the name of the user the message was sent by.  SendDate 
 *       is the date and time the message was sent.  HasMoreMessages is a boolean which will be equal to true if there are 
 *       still pending messages for the connected user.
 *       See documentation for ExtensionType for description of Extension's usage.
 *       
 * 
 * <p>Java class for GetMessageResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetMessageResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MessageText" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Recipient" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Sender" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SendDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="HasMoreMessages" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
@XmlType(name = "GetMessageResponseType", propOrder = {
    "messageText",
    "recipient",
    "sender",
    "sendDate",
    "hasMoreMessages",
    "extension",
    "any"
})
public class GetMessageResponseType {

    @XmlElement(name = "MessageText", required = true)
    protected String messageText;
    @XmlElement(name = "Recipient", required = true)
    protected String recipient;
    @XmlElement(name = "Sender", required = true)
    protected String sender;
    @XmlElement(name = "SendDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar sendDate;
    @XmlElement(name = "HasMoreMessages")
    protected boolean hasMoreMessages;
    @XmlElement(name = "Extension")
    protected ExtensionType extension;
    @XmlAnyElement(lax = true)
    protected List<Object> any;

    /**
     * Gets the value of the messageText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageText() {
        return messageText;
    }

    /**
     * Sets the value of the messageText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageText(String value) {
        this.messageText = value;
    }

    /**
     * Gets the value of the recipient property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipient() {
        return recipient;
    }

    /**
     * Sets the value of the recipient property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipient(String value) {
        this.recipient = value;
    }

    /**
     * Gets the value of the sender property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSender() {
        return sender;
    }

    /**
     * Sets the value of the sender property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSender(String value) {
        this.sender = value;
    }

    /**
     * Gets the value of the sendDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSendDate() {
        return sendDate;
    }

    /**
     * Sets the value of the sendDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSendDate(XMLGregorianCalendar value) {
        this.sendDate = value;
    }

    /**
     * Gets the value of the hasMoreMessages property.
     * 
     */
    public boolean isHasMoreMessages() {
        return hasMoreMessages;
    }

    /**
     * Sets the value of the hasMoreMessages property.
     * 
     */
    public void setHasMoreMessages(boolean value) {
        this.hasMoreMessages = value;
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

}
