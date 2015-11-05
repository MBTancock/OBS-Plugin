package com.avid.central.obsplugin;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by Broadcast Media Solutions on 05/11/2015.
 */
public class CuesheetRequest {
    @XmlElement(required = true)
    private String queue;
    @XmlElement(required = true)
    private String story;

    public String getQueue() {
        return this.queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    public String getStory() {
        return this.story;
    }

    public void setStory(String story) {
        this.story = story;
    }
}
