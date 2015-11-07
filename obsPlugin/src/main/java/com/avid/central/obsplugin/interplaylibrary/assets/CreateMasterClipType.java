
package com.avid.central.obsplugin.interplaylibrary.assets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import org.w3c.dom.Element;


/**
 * 
 *         The parameters of the CreateMasterClip operation. DestinationFolderURI indicates where the new masterclip
 *         should be checked in. Other parameters include ClipName, Timebase (i.e., 25p, 30i, 30i_df, etc),
 *         StartTimecode, Duration or EndTimecode (choose one), whether or not there is a Video track, number of
 *         AudioTracks, an optional SourceID (if blank, one will be generated), and an optional set of Attributes to set.
 *       
 * 
 * <p>Java class for CreateMasterClipType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreateMasterClipType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DestinationFolderURI" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ClipID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ClipName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Timebase" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TapeName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="StartTimecode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Duration" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="EndTimecode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Video" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="AudioTracks" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="SourceID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SourceMobType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SourceMobOffset" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="BoxX" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="BoxY" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="BoxHeight" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="BoxWidth" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Attributes" type="{http://avid.com/interplay/ws/assets/types}AttributeListType" minOccurs="0"/>
 *         &lt;element name="Extension" type="{http://avid.com/interplay/ws/assets/types}ExtensionType" minOccurs="0"/>
 *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;anyAttribute processContents='lax'/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateMasterClipType", propOrder = {
    "destinationFolderURI",
    "clipID",
    "clipName",
    "timebase",
    "tapeName",
    "startTimecode",
    "duration",
    "endTimecode",
    "video",
    "audioTracks",
    "sourceID",
    "sourceMobType",
    "sourceMobOffset",
    "boxX",
    "boxY",
    "boxHeight",
    "boxWidth",
    "attributes",
    "extension",
    "any"
})
public class CreateMasterClipType {

    @XmlElement(name = "DestinationFolderURI", required = true)
    protected String destinationFolderURI;
    @XmlElement(name = "ClipID")
    protected String clipID;
    @XmlElement(name = "ClipName", required = true)
    protected String clipName;
    @XmlElement(name = "Timebase", required = true)
    protected String timebase;
    @XmlElement(name = "TapeName", required = true)
    protected String tapeName;
    @XmlElement(name = "StartTimecode", required = true)
    protected String startTimecode;
    @XmlElement(name = "Duration")
    protected Long duration;
    @XmlElement(name = "EndTimecode")
    protected String endTimecode;
    @XmlElement(name = "Video")
    protected boolean video;
    @XmlElement(name = "AudioTracks")
    protected int audioTracks;
    @XmlElement(name = "SourceID")
    protected String sourceID;
    @XmlElement(name = "SourceMobType")
    protected String sourceMobType;
    @XmlElement(name = "SourceMobOffset")
    protected Integer sourceMobOffset;
    @XmlElement(name = "BoxX")
    protected Integer boxX;
    @XmlElement(name = "BoxY")
    protected Integer boxY;
    @XmlElement(name = "BoxHeight")
    protected Integer boxHeight;
    @XmlElement(name = "BoxWidth")
    protected Integer boxWidth;
    @XmlElement(name = "Attributes")
    protected AttributeListType attributes;
    @XmlElement(name = "Extension")
    protected ExtensionType extension;
    @XmlAnyElement(lax = true)
    protected List<Object> any;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the destinationFolderURI property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestinationFolderURI() {
        return destinationFolderURI;
    }

    /**
     * Sets the value of the destinationFolderURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestinationFolderURI(String value) {
        this.destinationFolderURI = value;
    }

    /**
     * Gets the value of the clipID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClipID() {
        return clipID;
    }

    /**
     * Sets the value of the clipID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClipID(String value) {
        this.clipID = value;
    }

    /**
     * Gets the value of the clipName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClipName() {
        return clipName;
    }

    /**
     * Sets the value of the clipName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClipName(String value) {
        this.clipName = value;
    }

    /**
     * Gets the value of the timebase property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimebase() {
        return timebase;
    }

    /**
     * Sets the value of the timebase property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimebase(String value) {
        this.timebase = value;
    }

    /**
     * Gets the value of the tapeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTapeName() {
        return tapeName;
    }

    /**
     * Sets the value of the tapeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTapeName(String value) {
        this.tapeName = value;
    }

    /**
     * Gets the value of the startTimecode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartTimecode() {
        return startTimecode;
    }

    /**
     * Sets the value of the startTimecode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartTimecode(String value) {
        this.startTimecode = value;
    }

    /**
     * Gets the value of the duration property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDuration() {
        return duration;
    }

    /**
     * Sets the value of the duration property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDuration(Long value) {
        this.duration = value;
    }

    /**
     * Gets the value of the endTimecode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndTimecode() {
        return endTimecode;
    }

    /**
     * Sets the value of the endTimecode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndTimecode(String value) {
        this.endTimecode = value;
    }

    /**
     * Gets the value of the video property.
     * 
     */
    public boolean isVideo() {
        return video;
    }

    /**
     * Sets the value of the video property.
     * 
     */
    public void setVideo(boolean value) {
        this.video = value;
    }

    /**
     * Gets the value of the audioTracks property.
     * 
     */
    public int getAudioTracks() {
        return audioTracks;
    }

    /**
     * Sets the value of the audioTracks property.
     * 
     */
    public void setAudioTracks(int value) {
        this.audioTracks = value;
    }

    /**
     * Gets the value of the sourceID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceID() {
        return sourceID;
    }

    /**
     * Sets the value of the sourceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceID(String value) {
        this.sourceID = value;
    }

    /**
     * Gets the value of the sourceMobType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceMobType() {
        return sourceMobType;
    }

    /**
     * Sets the value of the sourceMobType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceMobType(String value) {
        this.sourceMobType = value;
    }

    /**
     * Gets the value of the sourceMobOffset property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSourceMobOffset() {
        return sourceMobOffset;
    }

    /**
     * Sets the value of the sourceMobOffset property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSourceMobOffset(Integer value) {
        this.sourceMobOffset = value;
    }

    /**
     * Gets the value of the boxX property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBoxX() {
        return boxX;
    }

    /**
     * Sets the value of the boxX property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBoxX(Integer value) {
        this.boxX = value;
    }

    /**
     * Gets the value of the boxY property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBoxY() {
        return boxY;
    }

    /**
     * Sets the value of the boxY property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBoxY(Integer value) {
        this.boxY = value;
    }

    /**
     * Gets the value of the boxHeight property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBoxHeight() {
        return boxHeight;
    }

    /**
     * Sets the value of the boxHeight property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBoxHeight(Integer value) {
        this.boxHeight = value;
    }

    /**
     * Gets the value of the boxWidth property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBoxWidth() {
        return boxWidth;
    }

    /**
     * Sets the value of the boxWidth property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBoxWidth(Integer value) {
        this.boxWidth = value;
    }

    /**
     * Gets the value of the attributes property.
     * 
     * @return
     *     possible object is
     *     {@link AttributeListType }
     *     
     */
    public AttributeListType getAttributes() {
        return attributes;
    }

    /**
     * Sets the value of the attributes property.
     * 
     * @param value
     *     allowed object is
     *     {@link AttributeListType }
     *     
     */
    public void setAttributes(AttributeListType value) {
        this.attributes = value;
    }

    /**
     * Gets the value of the extension property.
     * 
     * @return
     *     possible object is
     *     {@link ExtensionType }
     *     
     */
    public ExtensionType getExtension() {
        return extension;
    }

    /**
     * Sets the value of the extension property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtensionType }
     *     
     */
    public void setExtension(ExtensionType value) {
        this.extension = value;
    }

    /**
     * Gets the value of the any property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the any property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAny().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Element }
     * {@link Object }
     * 
     * 
     */
    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
    }

    /**
     * Gets a map that contains attributes that aren't bound to any typed property on this class.
     * 
     * <p>
     * the map is keyed by the name of the attribute and 
     * the value is the string value of the attribute.
     * 
     * the map returned by this method is live, and you can add new attribute
     * by updating the map directly. Because of this design, there's no setter.
     * 
     * 
     * @return
     *     always non-null
     */
    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

}
