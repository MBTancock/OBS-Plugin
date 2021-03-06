
package com.avid.central.obsplugin.inewslibrary.rundown;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.avid.central.obsplugin.inewslibrary.rundown package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.avid.central.obsplugin.inewslibrary.rundown
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Rundown }
     * 
     */
    public Rundown createRundown() {
        return new Rundown();
    }

    /**
     * Create an instance of {@link Rundown.StorySession }
     * 
     */
    public Rundown.StorySession createRundownStorySession() {
        return new Rundown.StorySession();
    }

    /**
     * Create an instance of {@link Rundown.StorySession.Story }
     * 
     */
    public Rundown.StorySession.Story createRundownStorySessionStory() {
        return new Rundown.StorySession.Story();
    }

    /**
     * Create an instance of {@link Rundown.StorySession.Story.Graphic }
     * 
     */
    public Rundown.StorySession.Story.Graphic createRundownStorySessionStoryGraphic() {
        return new Rundown.StorySession.Story.Graphic();
    }

}
