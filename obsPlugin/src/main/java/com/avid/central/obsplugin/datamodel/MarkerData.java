package com.avid.central.obsplugin.datamodel;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by Broadcast Media Solutions on 10/11/2015.
 */
public class MarkerData {
    @XmlElement(required = true)
    public String Start;
    @XmlElement(required = true)
    public String Duration;
    @XmlElement(required = true)
    public String Comment;

    public String toString()
    {
        StringBuilder sb = new StringBuilder(Start);
        sb.append(",");
        sb.append(Duration);
        sb.append(",\"");
        sb.append(Comment);
        sb.append("\"");
        return sb.toString();
    }
}
