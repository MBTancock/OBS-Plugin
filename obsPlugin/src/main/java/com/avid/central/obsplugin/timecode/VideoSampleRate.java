package com.avid.central.obsplugin.timecode;

/**
 * Created by Broadcast Media Solutions on 09/11/2015.
 */
public class VideoSampleRate {
    private final boolean _interlaced;
    private final int _sampleRateNumerator;
    private final int _sampleRateDenominator;

    public VideoSampleRate(boolean interlaced, int sampleRateNumerator, int sampleRateDenominator) {
        _interlaced = interlaced;
        _sampleRateDenominator = sampleRateDenominator;
        _sampleRateNumerator = sampleRateNumerator;
    }

    public VideoSampleRate(VideoSampleRate vf) {
        _interlaced = vf.GetInterlaced();
        _sampleRateDenominator = vf.GetSampleRateDenominator();
        _sampleRateNumerator = vf.GetSampleRateNumerator();
    }

    public boolean GetInterlaced() {
        return _interlaced;
    }

    public int GetSampleRateNumerator() {
        return _sampleRateNumerator;
    }

    public int GetSampleRateDenominator() {
        return _sampleRateDenominator;
    }

    public double GetSampleRate() {
        return (double) _sampleRateNumerator / (double) _sampleRateDenominator;
    }

    public double GetFrameRate() {
        return GetSampleRate() / (_interlaced ? 2.0 : 1.0);
    }

    public boolean Equals(Object obj) {
        if (obj.getClass() == VideoSampleRate.class) {
            VideoSampleRate vs = (VideoSampleRate) obj;
            return vs._interlaced == _interlaced &&
                    vs._sampleRateNumerator == _sampleRateNumerator &&
                    vs._sampleRateDenominator == _sampleRateDenominator;
        }
        return false;
    }

    public int CompareTo(Object obj) {
        if (obj.getClass() == VideoSampleRate.class) {
            VideoSampleRate f = (VideoSampleRate) obj;
            if (f.GetSampleRate() > GetSampleRate())
                return 1;
            else if (f.GetSampleRate() < GetSampleRate())
                return -1;
            else if (f.GetInterlaced() && !GetInterlaced())
                return 1;
            else if (!f.GetInterlaced() && GetInterlaced())
                return -1;
            else
                return 0;

        }

        return 0;
    }

    public String ToString() {
        return String.format("%2#.%2#", GetSampleRate());
    }
}