/*
 * Copyright Broadcast Media Solutions
 */

/**
 * Localization singleton
 * @class GENSET.Localization
 * @singleton
 * @extend SYSSET.Localization
 */
Ext4.define('GENSET.Localization', {
    extend: 'SYSSET.Localization',
    singleton: true,
    viewType: 'obs-general-settings'
});

GENSET.msg = GENSET.Localization.msg.bind(GENSET.Localization);