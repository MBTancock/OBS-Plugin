package com.avid.central.obsplugin.datamodel;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.UUID;

/**
 * Created by Broadcast Media Solutions on 05/11/2015.
 */
@XmlRootElement(name = "CuesheetResponse")
public class CuesheetResponse {
    @XmlElement
    private UUID id = null;
    @XmlElement(required = true)
    private List<MarkerData> markers;
    @XmlElement(required = true)
    private String message;
    @XmlElement(required = true)
    private int result; // 0 = generic error, 1 = success, 2 = not authorized, 3 = configuration missing, 4 = no MobID

    public UUID getID() {
        return this.id;
    }

    public void setID(UUID id) {
        this.id = id;
    }

    public List<MarkerData> getMarkers() {
        return this.markers;
    }

    public void setMarkers(List<MarkerData> markers) {
        this.markers = markers;
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
