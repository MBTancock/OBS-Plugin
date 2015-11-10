/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avid.central.obsplugin.datamodel;

import java.util.UUID;

/**
 *
 * @author Administrator
 */

public class ExportStoryData {
    private UUID id;
    private boolean mdsMode;
    private String rundownAsXml;
    private InewsResponse response;


    public ExportStoryData() {
        this.id = null;
        this.mdsMode = false;
        this.rundownAsXml = null;
        this.response = new InewsResponse();
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

    public boolean getMdsMode()
    {
        return this.mdsMode;
    }

    public void setMdsMode(boolean mdsMode)
    {
        this.mdsMode = mdsMode;
    }

    public String getRundownAsXml()
    {
        return this.rundownAsXml;
    }

    public void setRundownAsXml(String rundownAsXml)
    {
        this.rundownAsXml = rundownAsXml;
    }

    public InewsResponse getResponse()
    {
        return this.response;
    }

    public void setResponse(InewsResponse response)
    {
        this.response = response;
    }
}
