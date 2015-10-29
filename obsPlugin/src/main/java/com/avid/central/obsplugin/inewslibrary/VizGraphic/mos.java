package com.avid.central.obsplugin.inewslibrary.VizGraphic;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Administrator on 28/10/2015.
 */
public class mos {
    @XmlElement(required = true)
    public String mosID;
    @XmlElement(required = true)
    public String objID;
    @XmlElement(required = true)
    public String mosAbstract;
    @XmlElement(required = true)
    public String vizDur;
    @XmlElement(required = true)
    public String vizTC;
    @XmlElement(required = false)
    public String vizTCin;
    @XmlElement(required = false)
    public String vizTCout;
    @XmlElement(required = true)
    public String itemID;
}
