
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
 *         Parameters for the DeleteAssets operation. If DeleteMetadata is set to true, then the system will
 *         attempt to delete the metadata files from the Interplay Engine. If DeleteMedia is set to true, then the system will
 *         attempt to delete the media files from shared storage. If resolutions are specified, only the specified
 *         resolutions of the media files will be deleted; otherwise all resolutions are deleted. If Simulation is set to
 *         true, then nothing will actually be deleted, but a report will be returned indicating what would have been
 *         deleted.
 *       
 * 
 * <p>Java class for DeleteAssetsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DeleteAssetsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InterplayURIs" type="{http://avid.com/interplay/ws/assets/types}InterplayURIListType"/>
 *         &lt;element name="DeleteMetadata" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="DeleteMedia" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Resolutions" type="{http://avid.com/interplay/ws/assets/types}ResolutionListType" minOccurs="0"/>
 *         &lt;element name="Simulation" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
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
@XmlType(name = "DeleteAssetsType", propOrder = {
    "interplayURIs",
    "deleteMetadata",
    "deleteMedia",
    "resolutions",
    "simulation",
    "extension",
    "any"
})
public class DeleteAssetsType {

    @XmlElement(name = "InterplayURIs", required = true)
    protected InterplayURIListType interplayURIs;
    @XmlElement(name = "DeleteMetadata")
    protected Boolean deleteMetadata;
    @XmlElement(name = "DeleteMedia")
    protected boolean deleteMedia;
    @XmlElement(name = "Resolutions")
    protected ResolutionListType resolutions;
    @XmlElement(name = "Simulation")
    protected Boolean simulation;
    @XmlElement(name = "Extension")
    protected ExtensionType extension;
    @XmlAnyElement(lax = true)
    protected List<Object> any;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the interplayURIs property.
     * 
     * @return
     *     possible object is
     *     {@link InterplayURIListType }
     *     
     */
    public InterplayURIListType getInterplayURIs() {
        return interplayURIs;
    }

    /**
     * Sets the value of the interplayURIs property.
     * 
     * @param value
     *     allowed object is
     *     {@link InterplayURIListType }
     *     
     */
    public void setInterplayURIs(InterplayURIListType value) {
        this.interplayURIs = value;
    }

    /**
     * Gets the value of the deleteMetadata property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDeleteMetadata() {
        return deleteMetadata;
    }

    /**
     * Sets the value of the deleteMetadata property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDeleteMetadata(Boolean value) {
        this.deleteMetadata = value;
    }

    /**
     * Gets the value of the deleteMedia property.
     * 
     */
    public boolean isDeleteMedia() {
        return deleteMedia;
    }

    /**
     * Sets the value of the deleteMedia property.
     * 
     */
    public void setDeleteMedia(boolean value) {
        this.deleteMedia = value;
    }

    /**
     * Gets the value of the resolutions property.
     * 
     * @return
     *     possible object is
     *     {@link ResolutionListType }
     *     
     */
    public ResolutionListType getResolutions() {
        return resolutions;
    }

    /**
     * Sets the value of the resolutions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResolutionListType }
     *     
     */
    public void setResolutions(ResolutionListType value) {
        this.resolutions = value;
    }

    /**
     * Gets the value of the simulation property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSimulation() {
        return simulation;
    }

    /**
     * Sets the value of the simulation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSimulation(Boolean value) {
        this.simulation = value;
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
