/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avid.central.obsplugin.inewslibrary;

/**
 *
 * @author Administrator
 */
public class ExportStoryData {
    public String StoryAsXml;
    public String FileName;
    public String Warning;
    public boolean Success;

    public ExportStoryData() {
        this.StoryAsXml = null;
        this.FileName = null;
        this.Warning = null;
        this.Success = false;
    }
}
