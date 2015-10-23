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
public class Duration {
    
    public int Hours;
    public int Minutes;
    public int Seconds;
    
    public final int SecondsInTwentyFourHours = 24*60*60;

    public Duration(int totalSeconds)
    {
        // handle only a 24 hour duration
        totalSeconds %= SecondsInTwentyFourHours;
        
        Hours = totalSeconds / 3600;
        totalSeconds %= 3600;
        
        Minutes = totalSeconds / 60;
        
        Seconds = totalSeconds % 60;
    }
    
    @Override
    public String toString()
    {
        return String.format("%1$02d:%2$02d:%3$02d:00", Hours, Minutes, Seconds);
    }
    
    public String toString(String format)
    {
        return String.format(format, Hours, Minutes, Seconds);
    }
}
