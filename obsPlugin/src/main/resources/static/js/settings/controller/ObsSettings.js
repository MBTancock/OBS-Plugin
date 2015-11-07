/*
 * Copyright Broadcast Media Solutions
 */

/**
 * Controller for ObsSettings settings
 * @class GENSET.controller.GeneralSettings
 * @extend Ext.app.Controller
 * @author oleksii.koliada Adapted for AV.BasicSettingsView
 */
Ext4.define('GENSET.controller.ObsSettings', {
    extend: 'Ext.app.Controller',
    views: [
        'ObsDetails'
    ],
    models: [
        'ObsSettings'
    ],
    /**
     * Components references
     */
    refs: [{
        ref: 'generalForm',
        selector: 'ObsSettingsdetails form'
	}, {
		ref: 'saveButton',
		selector: 'ObsSettingsdetails button[action="save"]'
	}, {
		ref: 'revertButton',
		selector: 'ObsSettingsdetails button[action="revert"]'
	}],

    /**
     * Init controller
     * @param {Ext.app.Application} app Application for controller
     */
    init: function (app) {
        //this.instanceId = instanceId;
        this.settingsInstances = Ext4.StoreManager.get("SettingsInstances");
        this.control({
            'ObsSettingsdetails button[action=save]': {
                click: this.onApply.bind(this)
            },
            'ObsSettingsdetails button[action=revert]': {
                click: this.onRevert
            },
            'ObsSettingsdetails form': {
                dirtychange: this.onDirtyChanges,
                afterrender: this.initForm.bind(this)
            },
            'ObsSettingsdetails form checkbox[name=sessionTimeoutIsEnabledLoc]': {
                change: this.onIsEnabledChange
            }
        });
        this.settingsInstances.on('update', this.onSettingsUpdate.bind(this));
        this.callParent(arguments);
    },

    onIsEnabledChange: function (field, newValue) {
        field.up('form').down('[name=sessionTimeoutIntervalInMinutes]').setDisabled(!newValue);
    },

    /**
     * Sets pane view
     * @param {AV.View} paneView Corresponding pane view
     */
    setPaneView: function (paneView) {
        this.paneView = paneView;
        this.paneView.bindGlobal('SYSSET.settings.saved', this.onSettingsSaved.bind(this));
        this.paneView.bind(AV.Settings.FORM_RESIZE_EVENT, this.onResize.bind(this));
    },

    /**
     * Handles updates in settings tree via global Events
     * @param {Event} e Event
     * @param {SYSSET.model.SettingsInstance} settingsInstance Updated instance
     */
    onSettingsSaved: function (e, settingsInstance) {
    },

    /**
     * Handles update of settings in settings tree via events from store
     * @param {SYSSET.store.SettingsInstances} store Store of setting instances
     * @param {SYSSET.model.SettingsInstance} record
     */
    onSettingsUpdate: function (store, record, operation) {
        console.log(record);
    },

    /**
     * Handles apply button
     * @param {Ext.button.Button} button
     * @param {Ext.EventObject} ev
     * @param {Boolean} invisible True to not to apply model to the form
     * @param {Function} callback Success callback
     */
    onApply: function (button, ev, invisible, callback) {
        var formPanel = this.getGeneralForm(),
                formData = formPanel.getValues(),
                me = this,
                instance = formPanel.getRecord(),
                errors;

        invisible = Ext.isDefined(invisible) ? invisible : false;
        instance.set(formData);
        errors = instance.validate();
        formPanel.getForm().clearInvalid();
        formPanel.getForm().markInvalid(errors);
        if (errors.length === 0) {
            instance.save({
                success: function (model) {
                    if (!invisible) {
                        me.setModel(model);
                    }
                    if (Ext4.isFunction(callback)) {
                        callback(true);
                    }
                },
                failure: function (instance, operation) {
                    console.error("[General Settings] Data saving has failed");
                    if (Ext4.isFunction(callback)) {
                        callback(false);
                    }
                }
            });
        } else {
            instance.reject(formData);
            this.paneView.setDirty(true);
            callback(false);
        }
    },


    /**
     * Handles revert button
     */
    onRevert: function (button, callback) {
        var formPanel = this.getGeneralForm();

        GENSET.model.ObsSettings.load(null, {
            scope: this,
            success: function (model) {
                this.setModel(model);
                if (Ext4.isFunction(callback)) {
                    callback(true);
                }
            },
            failure: function () {
                console.error("[General Settings] Form revert has failed");
                if (Ext4.isFunction(callback)) {
                    callback(false);
                }
            }
        });
        formPanel.getForm().clearInvalid();
    },

    /**
     * Handles FORM_RESIZE_EVENT
     * @param {jQuery.Event} ev
     * @param {Number} width
     * @param {Number} height
     */
    onResize: function (ev, width, height) {
        this.getGeneralForm().ownerCt.ownerCt.setSize(width, height);
    },

    /**
     * Handles changes in form and switches state of buttons
     * @param {Ext.form.Basic} form Basic form where dirty state was changed
     * @param {Boolean} isFormDirty Is the form is dirty
     */
    onDirtyChanges: function (form, isFormDirty) {
        this.paneView.setDirty(isFormDirty);
    },

    /**
     * Handles form render and loads data to form
     */
    initForm: function (form) {
        new SYSSET.validation.ValidationManager(this.getGeneralForm());
        GENSET.model.ObsSettings.load(null, {
            scope: this,
            success: this.setModel.bind(this)
        });

    },

    /**
     * Shows details of model in the edit form and grid
     * @param {GENSET.model.ObsSettings} model general settings model
     */
    setModel: function (model) {
        var form = this.getGeneralForm();
        if (form && form.rendered) {
            this.getGeneralForm().loadRecord(model);
            this.paneView.setDirty(false);
        }
    }
});