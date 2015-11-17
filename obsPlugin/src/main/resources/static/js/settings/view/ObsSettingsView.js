/*
 * Copyright Broadcast Media Solutions
 */

Ext.ns("GENSET.view");

/**
 * AV.View that holds General settings form
 *
 * @class GENSET.view.ObsSettingsView
 * @extends AV.View
 */
GENSET.view.ObsSettingsView = AV.BasicSettingsView.extend({

    /**
     * Constructs view
     * @param {Object} options Constructor options
     * @param {String} options.instanceId ID of settings instance associated with this view
     */
    constructor: function (options) {
        this.instanceId = options.instanceId;
        this.settingsInstance = options.settings;
        var impl = this;
        GENSET.view.ObsSettingsView.superclass.constructor.apply(this, [impl]);
    },

    getDefaultHelpSite: function () {
        return AV.Settings.getDefaultHelpSite();
    },

    /**
     * Allows AV.BasicSettingsView to use default save and Revert buttons
     */
    hideButtons: false,

    /**
     * Gets element to be placed into the SettingsViewContainer as form
     * Implements method from AV.BasicSettingsView
     * @param {HTMLElement} parentEl
     * @param {Function} [renderCallback]
     */
    createFormEl: function (parentEl, renderCallback) {
        var self = this;
        this.panel = Ext4.create("GENSET.view.ObsDetails", {
            renderTo: parentEl,
            listeners: {
                render: function () {
                    self.getController();
                }
            }
        });
    },

    /**
     * Cleanup rendered view
     */
    destroy: function () {
        this.panel && this.panel.destroy();
        GENSET.view.ObsSettingsView.superclass.destroy.apply(this, arguments);
    },

    /**
     * Creates and initializes controller
     */
    getController: function () {
        if (!GENSET.controller.ObsSettings.instance) {
            Ext4.Loader.setPath('GENSET', '');
            GENSET.controller.ObsSettings.instance = SYSSET.app.getController('GENSET.controller.ObsSettings');
        }
        GENSET.controller.ObsSettings.instance.setPaneView(this);
        GENSET.controller.ObsSettings.instance.instanceId = this.instanceId;
        return GENSET.controller.ObsSettings.instance;
    },

    /**
     * Implements method from {@link AV.BasicSettingsView}
     * @param {Function} callback
     */
    save: function (callback) {
        GENSET.controller.ObsSettings.instance.onApply(null, null, null, callback);
    },

    /**
     * Implements method from {@link AV.BasicSettingsView}
     * @param {Function} callback
     */
    revert: function (callback) {
        GENSET.controller.ObsSettings.instance.onRevert(null, callback);
    }
});