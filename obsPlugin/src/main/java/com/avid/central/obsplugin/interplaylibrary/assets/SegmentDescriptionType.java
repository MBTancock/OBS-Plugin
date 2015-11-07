
package com.avid.central.obsplugin.interplaylibrary.assets;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *         Represents an SegmentDescription.
 *       
 * 
 * <p>Java class for SegmentDescriptionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SegmentDescriptionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AssetDescription" type="{http://avid.com/interplay/ws/assets/types}AssetDescriptionType"/>
 *         &lt;element name="SegmentMarkIn" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="SegmentDuration" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="SegmentTrack" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SegmentFileMOB" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SegmentStartOffset" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="CompositionPosition" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="CompositionTrack" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CompositionDuration" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SegmentDescriptionType", propOrder = {
    "assetDescription",
    "segmentMarkIn",
    "segmentDuration",
    "segmentTrack",
    "segmentFileMOB",
    "segmentStartOffset",
    "compositionPosition",
    "compositionTrack",
    "compositionDuration"
})
public class SegmentDescriptionType {

    @XmlElement(name = "AssetDescription", required = true)
    protected AssetDescriptionType assetDescription;
    @XmlElement(name = "SegmentMarkIn")
    protected long segmentMarkIn;
    @XmlElement(name = "SegmentDuration")
    protected long segmentDuration;
    @XmlElement(name = "SegmentTrack", required = true)
    protected String segmentTrack;
    @XmlElement(name = "SegmentFileMOB", required = true)
    protected String segmentFileMOB;
    @XmlElement(name = "SegmentStartOffset")
    protected long segmentStartOffset;
    @XmlElement(name = "CompositionPosition")
    protected long compositionPosition;
    @XmlElement(name = "CompositionTrack", required = true)
    protected String compositionTrack;
    @XmlElement(name = "CompositionDuration")
    protected long compositionDuration;

    /**
     * Gets the value of the assetDescription property.
     * 
     * @return
     *     possible object is
     *     {@link AssetDescriptionType }
     *     
     */
    public AssetDescriptionType getAssetDescription() {
        return assetDescription;
    }

    /**
     * Sets the value of the assetDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssetDescriptionType }
     *     
     */
    public void setAssetDescription(AssetDescriptionType value) {
        this.assetDescription = value;
    }

    /**
     * Gets the value of the segmentMarkIn property.
     * 
     */
    public long getSegmentMarkIn() {
        return segmentMarkIn;
    }

    /**
     * Sets the value of the segmentMarkIn property.
     * 
     */
    public void setSegmentMarkIn(long value) {
        this.segmentMarkIn = value;
    }

    /**
     * Gets the value of the segmentDuration property.
     * 
     */
    public long getSegmentDuration() {
        return segmentDuration;
    }

    /**
     * Sets the value of the segmentDuration property.
     * 
     */
    public void setSegmentDuration(long value) {
        this.segmentDuration = value;
    }

    /**
     * Gets the value of the segmentTrack property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSegmentTrack() {
        return segmentTrack;
    }

    /**
     * Sets the value of the segmentTrack property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSegmentTrack(String value) {
        this.segmentTrack = value;
    }

    /**
     * Gets the value of the segmentFileMOB property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSegmentFileMOB() {
        return segmentFileMOB;
    }

    /**
     * Sets the value of the segmentFileMOB property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSegmentFileMOB(String value) {
        this.segmentFileMOB = value;
    }

    /**
     * Gets the value of the segmentStartOffset property.
     * 
     */
    public long getSegmentStartOffset() {
        return segmentStartOffset;
    }

    /**
     * Sets the value of the segmentStartOffset property.
     * 
     */
    public void setSegmentStartOffset(long value) {
        this.segmentStartOffset = value;
    }

    /**
     * Gets the value of the compositionPosition property.
     * 
     */
    public long getCompositionPosition() {
        return compositionPosition;
    }

    /**
     * Sets the value of the compositionPosition property.
     * 
     */
    public void setCompositionPosition(long value) {
        this.compositionPosition = value;
    }

    /**
     * Gets the value of the compositionTrack property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompositionTrack() {
        return compositionTrack;
    }

    /**
     * Sets the value of the compositionTrack property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompositionTrack(String value) {
        this.compositionTrack = value;
    }

    /**
     * Gets the value of the compositionDuration property.
     * 
     */
    public long getCompositionDuration() {
        return compositionDuration;
    }

    /**
     * Sets the value of the compositionDuration property.
     * 
     */
    public void setCompositionDuration(long value) {
        this.compositionDuration = value;
    }

}
