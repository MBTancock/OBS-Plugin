
package com.avid.central.obsplugin.inewslibrary.rundown;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="OBSChannelId" type="{}Nvarchar16"/>
 *         &lt;element name="Title" type="{}Nvarchar16"/>
 *         &lt;element name="Day" type="{}Nvarchar6"/>
 *         &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="RundownStartTime" type="{}TimeType" minOccurs="0"/>
 *         &lt;element name="RundownEndTime" type="{}TimeType" minOccurs="0"/>
 *         &lt;element name="StorySession">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Story" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="StartTime" type="{}TimeType"/>
 *                             &lt;element name="Duration" type="{}TimeType"/>
 *                             &lt;element name="Subject" type="{}Nvarchar255"/>
 *                             &lt;element name="Type" type="{}Nvarchar32"/>
 *                             &lt;element name="VideoID" type="{}Nvarchar32"/>
 *                             &lt;element name="Update" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                             &lt;element name="Modified" type="{}TimeType"/>
 *                             &lt;element name="Graphic" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="GraphPage" type="{}Nvarchar32" minOccurs="0"/>
 *                                       &lt;element name="GraphOffset_IN" type="{}TimeType" minOccurs="0"/>
 *                                       &lt;element name="GraphOffset_OUT" type="{}TimeType" minOccurs="0"/>
 *                                       &lt;element name="GraphDuration" type="{}TimeType" minOccurs="0"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="music" type="{}Nvarchar6"/>
 *                             &lt;element name="com-upmix" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                             &lt;element name="cuesheet" type="{}Nvarchar255" minOccurs="0"/>
 *                             &lt;element name="ScriptInfo" type="{}Nvarchar255"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "Rundown")
public class Rundown {

    @XmlElement(name = "OBSChannelId", required = true)
    protected String obsChannelId;
    @XmlElement(name = "Title", required = true)
    protected String title;
    @XmlElement(name = "Day", required = true)
    protected String day;
    @XmlElement(name = "Date", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar date;
    @XmlElement(name = "RundownStartTime")
    protected String rundownStartTime;
    @XmlElement(name = "RundownEndTime")
    protected String rundownEndTime;
    @XmlElement(name = "StorySession", required = true)
    protected Rundown.StorySession storySession;

    /**
     * Gets the value of the obsChannelId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOBSChannelId() {
        return obsChannelId;
    }

    /**
     * Sets the value of the obsChannelId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOBSChannelId(String value) {
        this.obsChannelId = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the day property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDay() {
        return day;
    }

    /**
     * Sets the value of the day property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDay(String value) {
        this.day = value;
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

    /**
     * Gets the value of the rundownStartTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRundownStartTime() {
        return rundownStartTime;
    }

    /**
     * Sets the value of the rundownStartTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRundownStartTime(String value) {
        this.rundownStartTime = value;
    }

    /**
     * Gets the value of the rundownEndTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRundownEndTime() {
        return rundownEndTime;
    }

    /**
     * Sets the value of the rundownEndTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRundownEndTime(String value) {
        this.rundownEndTime = value;
    }

    /**
     * Gets the value of the storySession property.
     * 
     * @return
     *     possible object is
     *     {@link Rundown.StorySession }
     *     
     */
    public Rundown.StorySession getStorySession() {
        return storySession;
    }

    /**
     * Sets the value of the storySession property.
     * 
     * @param value
     *     allowed object is
     *     {@link Rundown.StorySession }
     *     
     */
    public void setStorySession(Rundown.StorySession value) {
        this.storySession = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Story" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="StartTime" type="{}TimeType"/>
     *                   &lt;element name="Duration" type="{}TimeType"/>
     *                   &lt;element name="Subject" type="{}Nvarchar255"/>
     *                   &lt;element name="Type" type="{}Nvarchar32"/>
     *                   &lt;element name="VideoID" type="{}Nvarchar32"/>
     *                   &lt;element name="Update" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *                   &lt;element name="Modified" type="{}TimeType"/>
     *                   &lt;element name="Graphic" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="GraphPage" type="{}Nvarchar32" minOccurs="0"/>
     *                             &lt;element name="GraphOffset_IN" type="{}TimeType" minOccurs="0"/>
     *                             &lt;element name="GraphOffset_OUT" type="{}TimeType" minOccurs="0"/>
     *                             &lt;element name="GraphDuration" type="{}TimeType" minOccurs="0"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="music" type="{}Nvarchar6"/>
     *                   &lt;element name="com-upmix" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *                   &lt;element name="cuesheet" type="{}Nvarchar255" minOccurs="0"/>
     *                   &lt;element name="ScriptInfo" type="{}Nvarchar255"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "story"
    })
    public static class StorySession {

        @XmlElement(name = "Story", required = true)
        protected List<Rundown.StorySession.Story> story;

        /**
         * Gets the value of the story property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the story property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getStory().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Rundown.StorySession.Story }
         * 
         * 
         */
        public List<Rundown.StorySession.Story> getStory() {
            if (story == null) {
                story = new ArrayList<Rundown.StorySession.Story>();
            }
            return this.story;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="StartTime" type="{}TimeType"/>
         *         &lt;element name="Duration" type="{}TimeType"/>
         *         &lt;element name="Subject" type="{}Nvarchar255"/>
         *         &lt;element name="Type" type="{}Nvarchar32"/>
         *         &lt;element name="VideoID" type="{}Nvarchar32"/>
         *         &lt;element name="Update" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
         *         &lt;element name="Modified" type="{}TimeType"/>
         *         &lt;element name="Graphic" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="GraphPage" type="{}Nvarchar32" minOccurs="0"/>
         *                   &lt;element name="GraphOffset_IN" type="{}TimeType" minOccurs="0"/>
         *                   &lt;element name="GraphOffset_OUT" type="{}TimeType" minOccurs="0"/>
         *                   &lt;element name="GraphDuration" type="{}TimeType" minOccurs="0"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="music" type="{}Nvarchar6"/>
         *         &lt;element name="com-upmix" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
         *         &lt;element name="cuesheet" type="{}Nvarchar255" minOccurs="0"/>
         *         &lt;element name="ScriptInfo" type="{}Nvarchar255"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "startTime",
            "duration",
            "subject",
            "type",
            "videoID",
            "updated",
            "modified",
            "graphic",
            "music",
            "comUpmix",
            "cuesheet",
            "scriptInfo"
        })
        public static class Story {

            @XmlElement(name = "StartTime", required = true)
            protected String startTime;
            @XmlElement(name = "Duration", required = true)
            protected String duration;
            @XmlElement(name = "Subject", required = true)
            protected String subject;
            @XmlElement(name = "Type", required = true)
            protected String type;
            @XmlElement(name = "VideoID", required = true)
            protected String videoID;
            @XmlElement(name = "Update")
            protected boolean updated;
            @XmlElement(name = "Modified", required = true)
            protected String modified;
            @XmlElement(name = "Graphic")
            protected List<Rundown.StorySession.Story.Graphic> graphic;
            @XmlElement(required = true)
            protected String music;
            @XmlElement(name = "com-upmix")
            protected boolean comUpmix;
            protected String cuesheet;
            @XmlElement(name = "ScriptInfo", required = true)
            protected String scriptInfo;

            /**
             * Gets the value of the startTime property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getStartTime() {
                return startTime;
            }

            /**
             * Sets the value of the startTime property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setStartTime(String value) {
                this.startTime = value;
            }

            /**
             * Gets the value of the duration property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDuration() {
                return duration;
            }

            /**
             * Sets the value of the duration property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDuration(String value) {
                this.duration = value;
            }

            /**
             * Gets the value of the subject property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSubject() {
                return subject;
            }

            /**
             * Sets the value of the subject property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSubject(String value) {
                this.subject = value;
            }

            /**
             * Gets the value of the type property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getType() {
                return type;
            }

            /**
             * Sets the value of the type property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setType(String value) {
                this.type = value;
            }

            /**
             * Gets the value of the videoID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getVideoID() {
                return videoID;
            }

            /**
             * Sets the value of the videoID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setVideoID(String value) {
                this.videoID = value;
            }

            /**
             * Gets the value of the updated property.
             * 
             */
            public boolean isUpdated() {
                return updated;
            }

            /**
             * Sets the value of the updated property.
             * 
             */
            public void setUpdated(boolean value) {
                this.updated = value;
            }

            /**
             * Gets the value of the modified property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getModified() {
                return modified;
            }

            /**
             * Sets the value of the modified property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setModified(String value) {
                this.modified = value;
            }

            /**
             * Gets the value of the graphic property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the graphic property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getGraphic().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Rundown.StorySession.Story.Graphic }
             * 
             * 
             */
            public List<Rundown.StorySession.Story.Graphic> getGraphic() {
                if (graphic == null) {
                    graphic = new ArrayList<Rundown.StorySession.Story.Graphic>();
                }
                return this.graphic;
            }

            /**
             * Gets the value of the music property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMusic() {
                return music;
            }

            /**
             * Sets the value of the music property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMusic(String value) {
                this.music = value;
            }

            /**
             * Gets the value of the comUpmix property.
             * 
             */
            public boolean isComUpmix() {
                return comUpmix;
            }

            /**
             * Sets the value of the comUpmix property.
             * 
             */
            public void setComUpmix(boolean value) {
                this.comUpmix = value;
            }

            /**
             * Gets the value of the cuesheet property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCuesheet() {
                return cuesheet;
            }

            /**
             * Sets the value of the cuesheet property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCuesheet(String value) {
                this.cuesheet = value;
            }

            /**
             * Gets the value of the scriptInfo property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getScriptInfo() {
                return scriptInfo;
            }

            /**
             * Sets the value of the scriptInfo property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setScriptInfo(String value) {
                this.scriptInfo = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="GraphPage" type="{}Nvarchar32" minOccurs="0"/>
             *         &lt;element name="GraphOffset_IN" type="{}TimeType" minOccurs="0"/>
             *         &lt;element name="GraphOffset_OUT" type="{}TimeType" minOccurs="0"/>
             *         &lt;element name="GraphDuration" type="{}TimeType" minOccurs="0"/>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "graphPage",
                "graphOffsetIN",
                "graphOffsetOUT",
                "graphDuration"
            })
            public static class Graphic {

                @XmlElement(name = "GraphPage")
                protected String graphPage;
                @XmlElement(name = "GraphOffset_IN")
                protected String graphOffsetIN;
                @XmlElement(name = "GraphOffset_OUT")
                protected String graphOffsetOUT;
                @XmlElement(name = "GraphDuration")
                protected String graphDuration;

                /**
                 * Gets the value of the graphPage property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getGraphPage() {
                    return graphPage;
                }

                /**
                 * Sets the value of the graphPage property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setGraphPage(String value) {
                    this.graphPage = value;
                }

                /**
                 * Gets the value of the graphOffsetIN property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getGraphOffsetIN() {
                    return graphOffsetIN;
                }

                /**
                 * Sets the value of the graphOffsetIN property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setGraphOffsetIN(String value) {
                    this.graphOffsetIN = value;
                }

                /**
                 * Gets the value of the graphOffsetOUT property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getGraphOffsetOUT() {
                    return graphOffsetOUT;
                }

                /**
                 * Sets the value of the graphOffsetOUT property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setGraphOffsetOUT(String value) {
                    this.graphOffsetOUT = value;
                }

                /**
                 * Gets the value of the graphDuration property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getGraphDuration() {
                    return graphDuration;
                }

                /**
                 * Sets the value of the graphDuration property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setGraphDuration(String value) {
                    this.graphDuration = value;
                }

            }

        }

    }

}
