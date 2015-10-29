package com.avid.central.obsplugin.inewslibrary.VizGraphic;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringReader;

/**
 * Created by Administrator on 28/10/2015.
 */
@XmlRootElement(name = "AttachmentContent")
public class AttachmentContent {
    @XmlElement(required = true)
    public mos mos;

    public static AttachmentContent Parse(String graphicData) throws Exception
    {
        // create the deserialization object
        JAXBContext jc;
        Unmarshaller unmarshaller;
        jc = JAXBContext.newInstance(AttachmentContent.class);
        unmarshaller = jc.createUnmarshaller();

        StringReader reader = new StringReader(graphicData);
        Object o = unmarshaller.unmarshal(reader);
        AttachmentContent vizGraphic = (AttachmentContent)o;

        if (vizGraphic.mos.vizTCin == null)
        {
            vizGraphic.mos.vizTCin = vizGraphic.mos.vizTC;
        }
        return vizGraphic;
    }
}
