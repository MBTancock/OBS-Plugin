package com.avid.central.obsplugin.inewslibrary.story;

import com.avid.central.obsplugin.inewslibrary.nsml.Nsml;

/**
 * Created by Broadcast Media Solutions on 18/11/2015.
 */
public class Story {
    public Nsml Story;
    public String StoryAsNSML;

    public Story(Nsml story, String storyAsNSML)
    {
        this.Story = story;
        this.StoryAsNSML = storyAsNSML;
    }
}
