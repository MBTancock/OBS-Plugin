/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avid.central.obsplugin.datamodel;

import com.avid.central.obsplugin.Configuration.ExportConfiguration;
import com.avid.central.obsplugin.inewslibrary.nsml.Nsml;
import org.joda.time.DateTime;

import java.util.UUID;

/**
 *
 * @author Administrator
 */

public class ExportStoryData {
    private UUID id;
    private DateTime date;
    private boolean mdsMode;
    private String rundownAsXml;
    private InewsResponse response;
    private boolean oncValidateFields;
    private boolean oncCheckGraphics;
    private boolean oncRetainFormatting;
    private boolean mdsValidateFields;
    private boolean mdsCheckGraphics;
    private boolean mdsRetainFormatting;


    public ExportStoryData(ExportConfiguration config) {
        this.id = null;
        this.date = DateTime.now();
        this.mdsMode = false;
        this.rundownAsXml = null;
        this.response = new InewsResponse();

        oncValidateFields = config.onc_verify_fields;
        oncCheckGraphics = config.onc_check_graphics;
        oncRetainFormatting = config.onc_include_tags;
        mdsValidateFields = config.mds_verify_fields;
        mdsCheckGraphics = config.mds_check_graphics;
        mdsRetainFormatting = config.mds_include_tags;

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

    public DateTime getDate()
    {
        return this.date;
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

    public boolean getValidateFields()
    {
        return this.mdsMode ? mdsValidateFields : oncValidateFields;
    }

    public boolean getCheckGrahics()
    {
        return this.mdsMode ? mdsCheckGraphics : oncCheckGraphics;
    }

    public boolean getRetainFormatting()
    {
        return this.mdsMode ? mdsRetainFormatting : oncRetainFormatting;
    }
}
