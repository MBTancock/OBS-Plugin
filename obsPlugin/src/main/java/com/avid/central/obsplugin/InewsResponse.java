package com.avid.central.obsplugin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.UUID;

/**
 * Created by Administrator on 03/10/2015.
 */
@XmlRootElement(name = "inewsresponse")
@XmlAccessorType(XmlAccessType.NONE)
public class InewsResponse {
    @XmlElement(required = true)
    private String filename;
    @XmlElement(required = true)
    private String message;
    @XmlElement(required = true)
    private int result;

    public String getFileName() {
        return this.filename;
    }

    public void setFileName(String filename) {
        this.filename = filename;
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
