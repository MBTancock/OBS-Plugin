package com.avid.central.obsplugin.datamodel;

import java.util.UUID;

/**
 * Created by Broadcast Media Solutions on 05/11/2015.
 */
public class ExportCuesheetData {
    private UUID id;
    private String queue;
    private String locator;
    private String storyAsNSML;
    private CuesheetResponse response;

    public ExportCuesheetData() {
        this.id = null;
        this.response = new CuesheetResponse();
    }

    public ExportCuesheetData(String queue, String locator, String storyAsNSML, CuesheetResponse response) {
        this.id = null;

        this.queue = queue;
        this.locator = locator;
        this.storyAsNSML = storyAsNSML;
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

    public String getQueue()
    {
        return this.queue;
    }

    public void setQueue(String queue)
    {
        this.queue = queue;
    }

    public String getLocator()
    {
        return this.locator;
    }

    public void setLocator(String locator)
    {
        this.locator = locator;
    }

    public String getStoryAsNSML()
    {
        return this.storyAsNSML;
    }

    public void setStoryAsNSML(String storyAsNSML)
    {
        this.storyAsNSML = storyAsNSML;
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
