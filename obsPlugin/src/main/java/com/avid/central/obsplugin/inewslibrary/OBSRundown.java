/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avid.central.obsplugin.inewslibrary;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 *
 * @author Administrator
 */
public class OBSRundown {
    public String ChannelID = "";
    public String Day = "";
    public String Date = "";
    public String Title = "";
    public int RundownStartTime = -1;
    public int RundownEndTime = -1;

    public DateTime GetFileDate() {
        try {
            DateTimeFormatter dtf = DateTimeFormat.forPattern("dd MMMM YYYY");
            DateTime dt = DateTime.parse(Date, dtf);
            return dt;
        } catch (Exception ex) {
            String s = ex.getMessage();
        }

        return new DateTime(0);
    }

    public String GetEndTime() {
        Duration dur = new Duration(RundownEndTime);
        return dur.toString();
    }

    public String GetStartTime() {
        Duration dur = new Duration(RundownStartTime);
        return dur.toString();
    }

    public String GetFileEndTime() {
        Duration dur = new Duration(RundownEndTime);
        return dur.toString("%1$02d%2$02d");
    }

    public String GetFileStartTime() {
        Duration dur = new Duration(RundownStartTime);
        return dur.toString("%1$02d%2$02d");
    }
}
