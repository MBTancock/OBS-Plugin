package com.avid.central.obsplugin.datamodel;

import java.util.UUID;

/**
 * Created by Broadcast Media Solutions on 05/11/2015.
 */
public class ExportCuesheetData {
    private UUID id;
    private CuesheetResponse response;

    public ExportCuesheetData() {
        this.id = null;
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
