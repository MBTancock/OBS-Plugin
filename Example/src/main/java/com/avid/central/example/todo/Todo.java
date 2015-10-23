package com.avid.central.example.todo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.UUID;

/**
 * Created by volodymyr.shugaiev on 7/20/2015.
 */
@XmlRootElement(name = "todo")
@XmlAccessorType(XmlAccessType.NONE)
public class Todo {
    @XmlElement
    private UUID id = null;
    @XmlElement(required = true)
    private String title;
    @XmlElement
    private Boolean done = false;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean isDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}
