package com.avid.central.obsplugin.datamodel;

import org.joda.time.DateTime;

import java.util.UUID;

/**
 * Created by Broadcast Media Solutions on 05/11/2015.
 */
public class ExportCuesheetData {
    private UUID id;
    private DateTime date;
    private CuesheetResponse response;

    public ExportCuesheetData() {
        this.id = null;
        this.date = DateTime.now();
        this.response = new CuesheetResponse();
    }

    public ExportCuesheetData(CuesheetResponse response) {
        this.id = null;
        this.response = response;
    }

    public UUID getID()
    {
        return this.id;
    }

    public DateTime getDate()
    {
        return this.date;
    }

    public void setID(UUID id)
    {
        this.id = id;
        this.response.setID(id);
    }

    public CuesheetResponse getResponse()
    {
        return this.response;
    }

    public void setResponse(CuesheetResponse response)
    {
        this.response = response;
    }

}
