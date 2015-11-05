package com.avid.central.obsplugin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.UUID;

/**
 * Created by Broadcast Media Solutions on 03/10/2015.
 */
@XmlRootElement(name = "inewsrequest")
@XmlAccessorType(XmlAccessType.NONE)
public class InewsRequest {
    @XmlElement(required = true)
    private String queue;

    public String getQueue() {
        return this.queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }
}
