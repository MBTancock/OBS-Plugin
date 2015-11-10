package com.avid.central.obsplugin.timecode;

/**
 * Created by Broadcast Media Solutions on 09/11/2015.
 */
public class DropFrame {
    private final boolean _isDropFrame;

    public DropFrame(boolean isDropFrame)
    {
        _isDropFrame = isDropFrame;
    }

    public boolean GetDropFrame()
    {
        return _isDropFrame;
    }
}
