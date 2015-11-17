package com.avid.central.obsplugin.datamodel;

import javax.xml.bind.annotation.XmlElement;
import java.util.UUID;

/**
 * Created by Broadcast Media Solutions on 05/11/2015.
 */
public class PublishRequest {
    @XmlElement(required = true)
    private UUID id = null;
    @XmlElement(required = true)
    private String queueFullPath;
    @XmlElement(required = true)
    private String storyLocator;

    public UUID getID()
    {
        return id;
    }

    public String getQueueFullPath() {
        return this.queueFullPath;
    }

    public void setQueueFullPath(String queueFullPath) {
        this.queueFullPath = queueFullPath;
    }

    public String getStoryLocator() {
        return this.storyLocator;
    }

    public void setStoryLocator(String storyLocator) {
        this.storyLocator = storyLocator;
    }
}
