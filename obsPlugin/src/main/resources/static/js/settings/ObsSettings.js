/*
 * Copyright Broadcast Media Solutions
 */

(function() {
    AV.ViewManager.addViewFactory("obs-general-settings", function(options) {
        return new GENSET.view.ObsSettingsView(options);
    });
})();