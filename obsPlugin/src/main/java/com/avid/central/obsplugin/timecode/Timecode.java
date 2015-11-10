package com.avid.central.obsplugin.timecode;

import org.joda.time.Period;

/**
 * Created by Broadcast Media Solutions on 09/11/2015.
 */
/// <summary>
/// A class to represent a Timecode value
/// </summary>
public class Timecode {
    /// <summary>
/// Constant string value representing invalid timecode.
/// </summary>
    public static String InvalidTimecodeString = "––:––:––:––";

    private VideoSampleRate _videoFormat = new VideoSampleRate(true, 60000, 1001);

    private int _frameCount;

    private boolean isInvalidTimecode = false;
    private DropFrame _isDropFrame = null;

    public boolean getIsInvalidTimecode() {
        return isInvalidTimecode;
    }

    public Timecode() {
    }

    public Timecode(VideoSampleRate vf) {
        _videoFormat = vf;
    }

    public Timecode(Timecode tc) {
        tc.copyTo(this);
    }

    public Timecode(String timecodeAddress, VideoSampleRate videoFormat) {
        _videoFormat = new VideoSampleRate(videoFormat);
        initializeTimecode(timecodeAddress, null);
    }

    public Timecode(String timecodeAddress, VideoSampleRate videoFormat, DropFrame isDropFrame) {
        _videoFormat = new VideoSampleRate(videoFormat);
        initializeTimecode(timecodeAddress, isDropFrame);
    }

    public Timecode(int timecodeVal, VideoSampleRate videoFormat) {
        _videoFormat = new VideoSampleRate(videoFormat);
        initializeTimecode(timecodeVal);
    }

    public Timecode(int timecodeVal, VideoSampleRate videoFormat, DropFrame isDropFrame) {
        _videoFormat = new VideoSampleRate(videoFormat);
        _isDropFrame = isDropFrame;
        initializeTimecode(timecodeVal);
    }

    /// <summary>
/// Provides the string representation of the timecode.  Acceptable formats are:
/// Drop Frame: xx:xx:xx,xx for first field and xx:xx:xx;xx for second
/// Non-Drop Frame: xx:xx:xx:xx.xx for first field and xx:xx:xx:xx for second
/// </summary>
/// <returns>A string representation of the current timecode value.</returns>
    public String toString() {
        return toString(_isDropFrame, true);
    }

    public String toString(DropFrame dropFrame, boolean wrap) {
        if (isInvalidTimecode)
            return InvalidTimecodeString;

        TimecodeData tc = getTimecodeFromTotalFrames(_frameCount, _videoFormat, null == dropFrame ? false : dropFrame.GetDropFrame(), wrap);
        tc.isNegative = _frameCount < 0;

        return tc.ToString(null == dropFrame || !dropFrame.GetDropFrame() ? ':' : ';');
    }

    /// <summary>
/// Sets the new timecode value to the new string that was passed in.  Also supports increment/decrement string inputs.
/// If values such as +x.xx, -x.xx, +xxx, -xxx are passed in, then these values are either added to or subtracted from the
/// existing timecode value.
/// </summary>
/// <param name="timecodeAddress">the string representation of the new timecode to be set</param>
/// <returns>A new timecode object representing the passed in timecode address.</returns>
    public Timecode setNewTimecode(String timecodeAddress) {

        String oldTimecode = this.toString();

        // If the passed in string is not valid, then return the existing timecode.
        if (null == timecodeAddress || 0 == timecodeAddress.length() || timecodeAddress.startsWith("+") || timecodeAddress.startsWith("-")) {
            return fromString("");
        }

        return fromString(timecodeAddress);
    }


    public boolean equals(Timecode tc) {
        if (tc == null)
            return false;

        return (this.getTotalFrames() == tc.getTotalFrames()) && (this.getIsInvalidTimecode() == tc.getIsInvalidTimecode());
    }

    public int compareTo(Timecode tc) {
        if (tc == null)
            return -1;

        if (this.getIsInvalidTimecode() != tc.getIsInvalidTimecode())
        {
            return this.getIsInvalidTimecode() ? 1 : -1;
        }

        return comparePeriods(this.asPeriod(), tc.asPeriod());
    }

    private int comparePeriods(Period period1, Period period2)
    {
        if (period1.getYears() != period2.getYears())
        {
            return Integer.compare(period1.getYears(), period2.getYears());
        }
        if (period1.getMonths() != period2.getMonths())
        {
            return Integer.compare(period1.getMonths(), period2.getMonths());
        }
        if (period1.getWeeks() != period2.getWeeks())
        {
            return Integer.compare(period1.getWeeks(), period2.getWeeks());
        }
        if (period1.getDays() != period2.getDays())
        {
            return Integer.compare(period1.getDays(), period2.getDays());
        }
        return 0;
    }

    protected Timecode fromString(String addr) {
        return new Timecode(addr, _videoFormat, _isDropFrame);
    }

    protected Timecode fromInteger(int addr) {
        return new Timecode(addr, _videoFormat, _isDropFrame);
    }


    public double getTotalMilliseconds()
    {
            return (1000.0 * (double)_frameCount / _videoFormat.GetFrameRate());
    }

    public Period asPeriod()
    {
        return new Period(getTotalMilliseconds());
    }

    /// <summary>
/// Sets the timecode from the number of frames
/// </summary>
/// <param name="numFields">The number of frames</param>
    protected void setTimecodeFromTotalFrames(int numFrames) {
        setTotalFrames(numFrames);
    }

    /// <summary>
/// Returns the video format of the timecode.  Can be
/// overridden in derived classes.
/// </summary>
    public VideoSampleRate getVideoFormat() {
        return _videoFormat;
    }

    /// <summary>
/// Returns the hours portion of the timecode value.  Can be
/// overridden in derived classes.
/// </summary>
    public TimecodeData getTimecode() {
        return getTimecodeFromTotalFrames(_frameCount, _videoFormat, getIsDropFrame(), true);
    }

    public int getTotalFrames() {
        return _frameCount;
    }

    public void setTotalFrames(int value) {
        isInvalidTimecode = false;
        _frameCount = value;
    }

    public int getTotalFields() {
        return getTotalFrames() * (_videoFormat.GetInterlaced() ? 2 : 1);
    }

    public void setTotalFields(int value) {
        setTotalFrames(value / (_videoFormat.GetInterlaced() ? 2 : 1));
    }

    /// <summary>
/// Returns a booleanean indicating whether timecode is presented as drop frame or not
/// </summary>
    public boolean getIsDropFrame() {
        if (null != _isDropFrame) {
            return _videoFormat.GetSampleRateDenominator() == 1001 && _isDropFrame.GetDropFrame();
        }
        return _videoFormat.GetSampleRateDenominator() == 1001;
    }

    public void setIsDropFrame(DropFrame value) {
        _isDropFrame = value;
    }


    /// <summary>
/// Helper function to initialize a timecode object from any of the available constructors
/// </summary>
/// <param name="timecodeAddress">The string representation of the timecode address</param>
/// control track.</param>
    protected void initializeTimecode(String timecodeAddress, DropFrame isDropFrame) {
        if (timecodeAddress == null || 0 == timecodeAddress.length()) {
            isInvalidTimecode = true;
            return;
        }

        if (null != isDropFrame) {
            _isDropFrame = isDropFrame;
        } else {
            if (timecodeAddress.contains(";") || timecodeAddress.contains(","))
                _isDropFrame = new DropFrame(true);
            else
                _isDropFrame = null;
        }

        TimecodeData tc = parseOctetsFromString(timecodeAddress);
        if (null == tc) {
            isInvalidTimecode = true;
            return;
        }

        isInvalidTimecode = false;


        tc = getTimecodeFromOctets(tc.hours, tc.minutes, tc.seconds, tc.frames, _videoFormat, getIsDropFrame());

        _frameCount = getTotalFramesFromTimecode(tc.hours, tc.minutes, tc.seconds, tc.frames, _videoFormat, getIsDropFrame());
    }

    protected void initializeTimecode(int timecodeValue) {
        _frameCount = timecodeValue;
    }

    /// <summary>
/// Increments the timecode by the number of hours, minutes, seconds, and frames provided
/// </summary>
/// <param name="hours">Number of hours to increment by</param>
/// <param name="minutes">Number of minutes to increment by</param>
/// <param name="seconds">Number of seconds to increment by</param>
/// <param name="frames">Number of frames to increment by</param>
/// <returns>Returns a new Timecode object representing the amount the timecode was incremented by.</returns>
    public Timecode increment(int hours, int minutes, int seconds, int frames) {
        int totalFrames = getTotalFramesFromTimecode(hours, minutes, seconds, frames, _videoFormat, getIsDropFrame());
        return increment(totalFrames);
    }

    /// <summary>
/// Decrements the timecode by the number of hours, minutes, seconds, and frames provided
/// </summary>
/// <param name="hours">Number of hours to decrement by</param>
/// <param name="minutes">Number of minutes to decrement by</param>
/// <param name="seconds">Number of seconds to decrement by</param>
/// <param name="frames">Number of frames to decrement by</param>
/// <returns>Returns a new Timecode object representing the amount the timecode was decremented by.</returns>
    protected Timecode decrement(int hours, int minutes, int seconds, int frames) {
        int totalFrames = getTotalFramesFromTimecode(hours, minutes, seconds, frames, _videoFormat, getIsDropFrame());
        return decrement(totalFrames);
    }


    /// <summary>
/// Increments the timecode value by the number of frames provided
/// </summary>
/// <param name="numFrames">The number of frames to increment by</param>
/// <returns>A new timecode object representing the incremented value.</returns>
    public Timecode increment(int numFrames) {
        Timecode tc = copy();
        tc.setTotalFrames(getTotalFrames() + numFrames);

        return tc;
    }

    /// <summary>
/// Decrements the timecode value by the number of frames provided
/// </summary>
/// <param name="numFrames">The number of frames to decrement by</param>
/// <returns>A new timecode object representing the decremented value.</returns>
    public Timecode decrement(int numFrames) {
        Timecode tc = copy();
        tc.setTotalFrames(getTotalFrames() - numFrames);

        return tc;
    }


    /// <summary>
/// Parses the input timecode string and returns the values in the form of hours, minutes, seconds, and frames
/// </summary>
/// <param name="tcStr">The timecode string</param>
/// <param name="hours">hours</param>
/// <param name="minutes">minutes</param>
/// <param name="seconds">seconds</param>
/// <param name="frames">frames</param>
/// <returns>Indicates whether or not the string is valid</returns>
    protected static TimecodeData parseOctetsFromString(String tcStr) {
        TimecodeData tc = new TimecodeData();

        if (null == tcStr || 0 == tcStr.length() || tcStr == InvalidTimecodeString)
            return null;

        char seps[] = {';',':',',','.'};

        if (tcStr.startsWith("-")) {
            tcStr = tcStr.substring(1);
            tc.isNegative = true;
        }

        // Sanity check the string
        if (indexOfAny(tcStr, seps) != -1) {
            String[] parts = tcStr.split("[;:'.]");

            boolean isFirst = true;
            for (String part : parts) {
                if (part.length() == 0)
                    return null;

                if (!isFirst && part.length() % 2 != 0)
                    return null;

                isFirst = false;
            }
        }

        // Remove all the separators
        int idx;
        StringBuilder sb = new StringBuilder(tcStr);
        while ((idx = indexOfAny(sb.toString(), seps)) != -1) {
            sb.deleteCharAt(idx);
        }

        tcStr = sb.toString();

        // Pad to 8 chars
        tcStr = String.format("%8s", tcStr).replace(' ', '0');


        // Break into 4 groups
        String hrStr = tcStr.substring(0, 2);
        String mnStr = tcStr.substring(2, 4);
        String scStr = tcStr.substring(4, 6);
        String frStr = tcStr.substring(6);

        // Parse each group
        try {
            tc.hours = Integer.parseInt(hrStr);
            tc.minutes = Integer.parseInt(mnStr);
            tc.seconds = Integer.parseInt(scStr);
            tc.frames = Integer.parseInt(frStr);
        } catch (NumberFormatException e) {
            return null;
        }

        return tc;
    }


    /// <summary>
/// Formats each field based on the frames per second
/// </summary>
/// <param name="hours"></param>
/// <param name="minutes"></param>
/// <param name="seconds"></param>
/// <param name="frames"></param>
    protected static TimecodeData getTimecodeFromOctets(int hours, int minutes, int seconds, int frames, VideoSampleRate vf, boolean dropFrame) {
        int framesPerSecond = (int) Math.round(vf.GetFrameRate());

        TimecodeData tc = new TimecodeData();

        if (frames >= framesPerSecond) {
            seconds += frames / framesPerSecond;
            frames = frames % framesPerSecond;
        }

        if (seconds >= 60) {
            minutes += seconds / 60;
            seconds = seconds % 60;
        }

        if (minutes >= 60) {
            hours += minutes / 60;
            minutes = minutes % 60;
        }

        if (hours >= 24) {
            hours %= 24;
        }

        // Drop-frame calculation
        if (vf.GetSampleRateDenominator() == 1001 && dropFrame) {
            if ((seconds == 0) && (minutes % 10) != 0) {
                if ((frames == 0) ||
                        (frames == 1)) {
                    frames = 2;
                }
            }
        }

        tc.hours = hours;
        tc.minutes = minutes;
        tc.seconds = seconds;
        tc.frames = frames;

        return tc;
    }


    protected static TimecodeData getTimecodeFromTotalFrames(int numFrames, VideoSampleRate vf, boolean dropFrame, boolean wrap) {

        int framesPerSecond = (int) Math.round(vf.GetFrameRate());

        if (numFrames < 0) {
            numFrames = Math.abs(numFrames);
            //numFrames = 0;
        }

        int val = numFrames;

        TimecodeData tc = new TimecodeData();

        int framesPer10min = 0;
        if (vf.GetSampleRateDenominator() == 1001 && framesPerSecond == 30 && dropFrame) {
            framesPer10min = 17982;
        } else if (vf.GetSampleRateDenominator() == 1001 && framesPerSecond == 60 && dropFrame) {
            framesPer10min = 35964;
        }
        //else if (m_framesPerSecond == FramesPerSecond.FramesPS_23_98)
        //{
        //    dropframe = true;
        //    framesPer10min = 14388;
        //}

        if (dropFrame) {
            int temp = val / framesPer10min;        // Number of frames per ten minute intervals
            tc.hours = temp / 6;
            tc.minutes = (temp % 6) * 10;
            val %= framesPer10min;                // Fraction into the number of frames per ten minute interval
            if (val > (framesPer10min % 10)) {
                val -= (framesPer10min % 10);
                tc.minutes += (val / (framesPer10min / 10));
                val %= (framesPer10min / 10);
                val += (framesPer10min % 10);
            } else {
                tc.minutes += (val / (framesPer10min / 10));
                val %= (framesPer10min / 10);
            }

            tc.seconds = (val / framesPerSecond);
            val %= framesPerSecond;
            tc.frames = val;
        } else {
            tc.frames = (val % framesPerSecond);
            val /= framesPerSecond;
            tc.seconds = (val % 60);
            val /= 60;
            tc.minutes = (val % 60);
            tc.hours = val / 60;
        }

        if (wrap)
            tc.hours %= 24;

        return tc;
    }

    /// <summary>
/// Tots up the hours, minutes and seconds and returns it as a frame count.
/// </summary>
/// <param name="hours">Hours in the timecode, can either be the member variable or not depending on the operation</param>
/// <param name="minutes">Minutes in the timecode, can be either the member variable or not depending on the operation</param>
/// <param name="seconds">Seconds in the timecode, can be either the member variable or not depending on the operation</param>
/// <param name="frames">Frames in the timecode, can be either the member variable or not depending ont he operation</param>
/// <param name="fps">The frames per second value</param>
/// <returns></returns>
    protected static int getTotalFramesFromTimecode(int hours, int minutes, int seconds, int frames, VideoSampleRate vf, boolean dropFrame) {

        int framesPerSecond = (int) Math.round(vf.GetFrameRate());

        int result = ((hours * 60 + minutes) * 60 + seconds) * framesPerSecond + frames;

        // Subtracting drop-frame value
        if (vf.GetSampleRateDenominator() == 1001 && framesPerSecond == 60 && dropFrame)
            result -= 4 * (hours * (60 - 6) + (minutes - minutes / 10));
        else if (vf.GetSampleRateDenominator() == 1001 && framesPerSecond == 30 && dropFrame)
            result -= 2 * (hours * (60 - 6) + (minutes - minutes / 10));

        return result;
    }

    protected Timecode copy() {
        Timecode tc = new Timecode();
        copyTo(tc);
        return tc;
    }

    protected void copyTo(Timecode tc) {
        tc._frameCount = _frameCount;
        tc._videoFormat = _videoFormat;
        tc.isInvalidTimecode = isInvalidTimecode;
        tc._isDropFrame = _isDropFrame;

    }

    private static int indexOfAny(String str, char[] searchChars) {
        if (isEmpty(str) || isEmpty(searchChars)) {
            return -1;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            for (int j = 0; j < searchChars.length; j++) {
                if (searchChars[j] == ch) {
                    return i;
                }
            }
        }
        return -1;
    }

    private static boolean isEmpty(char[] array) {
        if (array == null || array.length == 0) {
            return true;
        }
        return false;
    }


    private static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }


}

