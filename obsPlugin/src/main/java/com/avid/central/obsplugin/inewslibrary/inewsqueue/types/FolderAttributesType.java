
package com.avid.central.obsplugin.inewslibrary.inewsqueue.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *                 Contains all the attributes of the queue.
 *             
 * 
 * <p>Java class for FolderAttributesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FolderAttributesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FolderFullName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Inverted" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Locked" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="PurgeLocked" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Ordered" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="EditLocked" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="QueuePrintAuthorized" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ReadOnly" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Sequential" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="SkipOnBackup" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="SaveOriginalStory" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="SaveNoOtherVersionOfStory" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="BatchAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ResolvedWritePermission" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="General" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="CanUpdate" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Sorted" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="AutoRefresh" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="EasyLock" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="WireWatchAppends" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="EmbeddedFormAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ProductionLock" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Indexed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ShowsTextTimingClocks" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Monitored" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="CanOrder" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="CanEnterRemove" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="CanKillAll" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="CanModifyProperties" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="CanOverrideUserLock" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FolderAttributesType", namespace = "http://avid.com/inewsqueue/types", propOrder = {
    "folderFullName",
    "inverted",
    "locked",
    "purgeLocked",
    "ordered",
    "editLocked",
    "queuePrintAuthorized",
    "readOnly",
    "sequential",
    "skipOnBackup",
    "saveOriginalStory",
    "saveNoOtherVersionOfStory",
    "batchAllowed",
    "resolvedWritePermission",
    "general",
    "canUpdate",
    "sorted",
    "autoRefresh",
    "easyLock",
    "wireWatchAppends",
    "embeddedFormAllowed",
    "productionLock",
    "indexed",
    "showsTextTimingClocks",
    "monitored",
    "canOrder",
    "canEnterRemove",
    "canKillAll",
    "canModifyProperties",
    "canOverrideUserLock"
})
public class FolderAttributesType {

    @XmlElement(name = "FolderFullName", required = true)
    protected String folderFullName;
    @XmlElement(name = "Inverted")
    protected boolean inverted;
    @XmlElement(name = "Locked")
    protected boolean locked;
    @XmlElement(name = "PurgeLocked")
    protected boolean purgeLocked;
    @XmlElement(name = "Ordered")
    protected boolean ordered;
    @XmlElement(name = "EditLocked")
    protected boolean editLocked;
    @XmlElement(name = "QueuePrintAuthorized")
    protected boolean queuePrintAuthorized;
    @XmlElement(name = "ReadOnly")
    protected boolean readOnly;
    @XmlElement(name = "Sequential")
    protected boolean sequential;
    @XmlElement(name = "SkipOnBackup")
    protected boolean skipOnBackup;
    @XmlElement(name = "SaveOriginalStory")
    protected boolean saveOriginalStory;
    @XmlElement(name = "SaveNoOtherVersionOfStory")
    protected boolean saveNoOtherVersionOfStory;
    @XmlElement(name = "BatchAllowed")
    protected boolean batchAllowed;
    @XmlElement(name = "ResolvedWritePermission")
    protected boolean resolvedWritePermission;
    @XmlElement(name = "General")
    protected boolean general;
    @XmlElement(name = "CanUpdate")
    protected boolean canUpdate;
    @XmlElement(name = "Sorted")
    protected boolean sorted;
    @XmlElement(name = "AutoRefresh")
    protected boolean autoRefresh;
    @XmlElement(name = "EasyLock")
    protected boolean easyLock;
    @XmlElement(name = "WireWatchAppends")
    protected boolean wireWatchAppends;
    @XmlElement(name = "EmbeddedFormAllowed")
    protected boolean embeddedFormAllowed;
    @XmlElement(name = "ProductionLock")
    protected boolean productionLock;
    @XmlElement(name = "Indexed")
    protected boolean indexed;
    @XmlElement(name = "ShowsTextTimingClocks")
    protected boolean showsTextTimingClocks;
    @XmlElement(name = "Monitored")
    protected boolean monitored;
    @XmlElement(name = "CanOrder")
    protected boolean canOrder;
    @XmlElement(name = "CanEnterRemove")
    protected boolean canEnterRemove;
    @XmlElement(name = "CanKillAll")
    protected boolean canKillAll;
    @XmlElement(name = "CanModifyProperties")
    protected boolean canModifyProperties;
    @XmlElement(name = "CanOverrideUserLock")
    protected boolean canOverrideUserLock;

    /**
     * Gets the value of the folderFullName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFolderFullName() {
        return folderFullName;
    }

    /**
     * Sets the value of the folderFullName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFolderFullName(String value) {
        this.folderFullName = value;
    }

    /**
     * Gets the value of the inverted property.
     * 
     */
    public boolean isInverted() {
        return inverted;
    }

    /**
     * Sets the value of the inverted property.
     * 
     */
    public void setInverted(boolean value) {
        this.inverted = value;
    }

    /**
     * Gets the value of the locked property.
     * 
     */
    public boolean isLocked() {
        return locked;
    }

    /**
     * Sets the value of the locked property.
     * 
     */
    public void setLocked(boolean value) {
        this.locked = value;
    }

    /**
     * Gets the value of the purgeLocked property.
     * 
     */
    public boolean isPurgeLocked() {
        return purgeLocked;
    }

    /**
     * Sets the value of the purgeLocked property.
     * 
     */
    public void setPurgeLocked(boolean value) {
        this.purgeLocked = value;
    }

    /**
     * Gets the value of the ordered property.
     * 
     */
    public boolean isOrdered() {
        return ordered;
    }

    /**
     * Sets the value of the ordered property.
     * 
     */
    public void setOrdered(boolean value) {
        this.ordered = value;
    }

    /**
     * Gets the value of the editLocked property.
     * 
     */
    public boolean isEditLocked() {
        return editLocked;
    }

    /**
     * Sets the value of the editLocked property.
     * 
     */
    public void setEditLocked(boolean value) {
        this.editLocked = value;
    }

    /**
     * Gets the value of the queuePrintAuthorized property.
     * 
     */
    public boolean isQueuePrintAuthorized() {
        return queuePrintAuthorized;
    }

    /**
     * Sets the value of the queuePrintAuthorized property.
     * 
     */
    public void setQueuePrintAuthorized(boolean value) {
        this.queuePrintAuthorized = value;
    }

    /**
     * Gets the value of the readOnly property.
     * 
     */
    public boolean isReadOnly() {
        return readOnly;
    }

    /**
     * Sets the value of the readOnly property.
     * 
     */
    public void setReadOnly(boolean value) {
        this.readOnly = value;
    }

    /**
     * Gets the value of the sequential property.
     * 
     */
    public boolean isSequential() {
        return sequential;
    }

    /**
     * Sets the value of the sequential property.
     * 
     */
    public void setSequential(boolean value) {
        this.sequential = value;
    }

    /**
     * Gets the value of the skipOnBackup property.
     * 
     */
    public boolean isSkipOnBackup() {
        return skipOnBackup;
    }

    /**
     * Sets the value of the skipOnBackup property.
     * 
     */
    public void setSkipOnBackup(boolean value) {
        this.skipOnBackup = value;
    }

    /**
     * Gets the value of the saveOriginalStory property.
     * 
     */
    public boolean isSaveOriginalStory() {
        return saveOriginalStory;
    }

    /**
     * Sets the value of the saveOriginalStory property.
     * 
     */
    public void setSaveOriginalStory(boolean value) {
        this.saveOriginalStory = value;
    }

    /**
     * Gets the value of the saveNoOtherVersionOfStory property.
     * 
     */
    public boolean isSaveNoOtherVersionOfStory() {
        return saveNoOtherVersionOfStory;
    }

    /**
     * Sets the value of the saveNoOtherVersionOfStory property.
     * 
     */
    public void setSaveNoOtherVersionOfStory(boolean value) {
        this.saveNoOtherVersionOfStory = value;
    }

    /**
     * Gets the value of the batchAllowed property.
     * 
     */
    public boolean isBatchAllowed() {
        return batchAllowed;
    }

    /**
     * Sets the value of the batchAllowed property.
     * 
     */
    public void setBatchAllowed(boolean value) {
        this.batchAllowed = value;
    }

    /**
     * Gets the value of the resolvedWritePermission property.
     * 
     */
    public boolean isResolvedWritePermission() {
        return resolvedWritePermission;
    }

    /**
     * Sets the value of the resolvedWritePermission property.
     * 
     */
    public void setResolvedWritePermission(boolean value) {
        this.resolvedWritePermission = value;
    }

    /**
     * Gets the value of the general property.
     * 
     */
    public boolean isGeneral() {
        return general;
    }

    /**
     * Sets the value of the general property.
     * 
     */
    public void setGeneral(boolean value) {
        this.general = value;
    }

    /**
     * Gets the value of the canUpdate property.
     * 
     */
    public boolean isCanUpdate() {
        return canUpdate;
    }

    /**
     * Sets the value of the canUpdate property.
     * 
     */
    public void setCanUpdate(boolean value) {
        this.canUpdate = value;
    }

    /**
     * Gets the value of the sorted property.
     * 
     */
    public boolean isSorted() {
        return sorted;
    }

    /**
     * Sets the value of the sorted property.
     * 
     */
    public void setSorted(boolean value) {
        this.sorted = value;
    }

    /**
     * Gets the value of the autoRefresh property.
     * 
     */
    public boolean isAutoRefresh() {
        return autoRefresh;
    }

    /**
     * Sets the value of the autoRefresh property.
     * 
     */
    public void setAutoRefresh(boolean value) {
        this.autoRefresh = value;
    }

    /**
     * Gets the value of the easyLock property.
     * 
     */
    public boolean isEasyLock() {
        return easyLock;
    }

    /**
     * Sets the value of the easyLock property.
     * 
     */
    public void setEasyLock(boolean value) {
        this.easyLock = value;
    }

    /**
     * Gets the value of the wireWatchAppends property.
     * 
     */
    public boolean isWireWatchAppends() {
        return wireWatchAppends;
    }

    /**
     * Sets the value of the wireWatchAppends property.
     * 
     */
    public void setWireWatchAppends(boolean value) {
        this.wireWatchAppends = value;
    }

    /**
     * Gets the value of the embeddedFormAllowed property.
     * 
     */
    public boolean isEmbeddedFormAllowed() {
        return embeddedFormAllowed;
    }

    /**
     * Sets the value of the embeddedFormAllowed property.
     * 
     */
    public void setEmbeddedFormAllowed(boolean value) {
        this.embeddedFormAllowed = value;
    }

    /**
     * Gets the value of the productionLock property.
     * 
     */
    public boolean isProductionLock() {
        return productionLock;
    }

    /**
     * Sets the value of the productionLock property.
     * 
     */
    public void setProductionLock(boolean value) {
        this.productionLock = value;
    }

    /**
     * Gets the value of the indexed property.
     * 
     */
    public boolean isIndexed() {
        return indexed;
    }

    /**
     * Sets the value of the indexed property.
     * 
     */
    public void setIndexed(boolean value) {
        this.indexed = value;
    }

    /**
     * Gets the value of the showsTextTimingClocks property.
     * 
     */
    public boolean isShowsTextTimingClocks() {
        return showsTextTimingClocks;
    }

    /**
     * Sets the value of the showsTextTimingClocks property.
     * 
     */
    public void setShowsTextTimingClocks(boolean value) {
        this.showsTextTimingClocks = value;
    }

    /**
     * Gets the value of the monitored property.
     * 
     */
    public boolean isMonitored() {
        return monitored;
    }

    /**
     * Sets the value of the monitored property.
     * 
     */
    public void setMonitored(boolean value) {
        this.monitored = value;
    }

    /**
     * Gets the value of the canOrder property.
     * 
     */
    public boolean isCanOrder() {
        return canOrder;
    }

    /**
     * Sets the value of the canOrder property.
     * 
     */
    public void setCanOrder(boolean value) {
        this.canOrder = value;
    }

    /**
     * Gets the value of the canEnterRemove property.
     * 
     */
    public boolean isCanEnterRemove() {
        return canEnterRemove;
    }

    /**
     * Sets the value of the canEnterRemove property.
     * 
     */
    public void setCanEnterRemove(boolean value) {
        this.canEnterRemove = value;
    }

    /**
     * Gets the value of the canKillAll property.
     * 
     */
    public boolean isCanKillAll() {
        return canKillAll;
    }

    /**
     * Sets the value of the canKillAll property.
     * 
     */
    public void setCanKillAll(boolean value) {
        this.canKillAll = value;
    }

    /**
     * Gets the value of the canModifyProperties property.
     * 
     */
    public boolean isCanModifyProperties() {
        return canModifyProperties;
    }

    /**
     * Sets the value of the canModifyProperties property.
     * 
     */
    public void setCanModifyProperties(boolean value) {
        this.canModifyProperties = value;
    }

    /**
     * Gets the value of the canOverrideUserLock property.
     * 
     */
    public boolean isCanOverrideUserLock() {
        return canOverrideUserLock;
    }

    /**
     * Sets the value of the canOverrideUserLock property.
     * 
     */
    public void setCanOverrideUserLock(boolean value) {
        this.canOverrideUserLock = value;
    }

}
