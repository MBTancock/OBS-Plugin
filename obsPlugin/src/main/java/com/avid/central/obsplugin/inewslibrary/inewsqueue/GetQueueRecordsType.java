
package com.avid.central.obsplugin.inewslibrary.inewsqueue;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *       Parameters for the GetQueueRecords request.
 *       NumberOfRecordsToGet is the number of records to request from the queue. Maximum number per request is 200.
 *       Reset can be set to true to start over retrieving records from the beginning of the queue.
 *       
 * 
 * <p>Java class for GetQueueRecordsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetQueueRecordsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NumberOfRecordsToGet" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Reset" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetQueueRecordsType", namespace = "http://avid.com/inewsqueue/types", propOrder = {
    "numberOfRecordsToGet",
    "reset"
})
public class GetQueueRecordsType {

    @XmlElement(name = "NumberOfRecordsToGet")
    protected int numberOfRecordsToGet;
    @XmlElement(name = "Reset")
    protected boolean reset;

    /**
     * Gets the value of the numberOfRecordsToGet property.
     * 
     */
    public int getNumberOfRecordsToGet() {
        return numberOfRecordsToGet;
    }

    /**
     * Sets the value of the numberOfRecordsToGet property.
     * 
     */
    public void setNumberOfRecordsToGet(int value) {
        this.numberOfRecordsToGet = value;
    }

    /**
     * Gets the value of the reset property.
     * 
     */
    public boolean isReset() {
        return reset;
    }

    /**
     * Sets the value of the reset property.
     * 
     */
    public void setReset(boolean value) {
        this.reset = value;
    }

}
