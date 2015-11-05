package com.avid.central.obsplugin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.UUID;

/**
 * Created by Broadcast Media Solutions on 03/10/2015.
 */
@XmlRootElement(name = "inewsresponse")
@XmlAccessorType(XmlAccessType.NONE)
public class InewsResponse {
    @XmlElement
    private UUID id = null;
    @XmlElement(required = true)
    private String filename;
    @XmlElement(required = true)
    private String location;
    @XmlElement(required = true)
    private String rundown;
    @XmlElement(required = true)
    private String channelID;
    @XmlElement(required = true)
    private String title;
    @XmlElement(required = true)
    private String date;
    @XmlElement(required = true)
    private String day;
    @XmlElement(required = true)
    private String startTime;
    @XmlElement(required = true)
    private String endTime;
    @XmlElement(required = true)
    private String message;
    @XmlElement(required = true)
    private int result; // 0 = generic error, 1 = setup success, 2 = not authorized, 3 = configuration missing

    public UUID getID() {
        return this.id;
    }

    public void setID(UUID id) {
        this.id = id;
    }

    public String getFileName() {
        return this.filename;
    }

    public void setFileName(String filename) {
        this.filename = filename;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRundown() {
        return this.rundown;
    }

    public void setRundown(String rundown) {
        this.rundown = rundown;
    }

    public String getChannelID() {
        return this.channelID;
    }

    public void setChannelID(String channelID) {
        this.channelID = channelID;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay() {
        return this.day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getResult() {
        return this.result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
