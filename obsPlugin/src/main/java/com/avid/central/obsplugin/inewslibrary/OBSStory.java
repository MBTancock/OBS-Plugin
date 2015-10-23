/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avid.central.obsplugin.inewslibrary;

import java.util.List;
/**
 *
 * @author Administrator
 */
public class OBSStory
    {
        public int StoryStartTime = 0;
        public int StoryDuration = 0;
        public String Type = "";
        public String Title = "";
        public String VideoID;
        public String StoryID;
        public String EventFeed;
        public boolean Upmix;
        public String ComEn;
        public String ComEs;
        public String ComAr;
        public String Runup;
        public String Runout;
        public String CoverageStartTime;
        public String CoverageEndTime;

        public String ScriptInfo = "";
        public String CueSheet = "";

        public List<OBSGraphic> Graphics;

        public String GetDuration()
        {
            Duration dur = new Duration(StoryDuration);
            return dur.toString();
        }

        public String GetStartTime()
        {
            Duration startTime = new Duration(StoryStartTime);
            return startTime.toString();
        }
    }
