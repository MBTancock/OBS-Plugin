package com.avid.central.obsplugin;

import javax.xml.bind.annotation.XmlElement;
import java.util.UUID;

/**
 * Created by Broadcast Media Solutions on 05/11/2015.
 */
public class CuesheetResponse {
    @XmlElement
    private UUID id = null;
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
