package com.avid.central.obsplugin.timecode;

/**
 * Created by Broadcast Media Solutions on 09/11/2015.
 */
public class TimecodeData {
    public int hours = 0;
    public int minutes = 0;
    public int seconds = 0;
    public int frames = 0;
    public boolean isNegative = false;

    public String ToString(char finalSeparator)
    {
        StringBuilder sb = new StringBuilder();

        if (isNegative)
        {
            sb.append('-');
        }

        sb.append(String.format("%02d:%02d:%02d%s%02d", hours, minutes, seconds, finalSeparator, frames));
        return sb.toString();
    }
;
}
