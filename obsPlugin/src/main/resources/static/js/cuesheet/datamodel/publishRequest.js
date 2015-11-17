/**
 * Created by Broadcast Media Solutions on 05/11/2015.
 */
(function (AV) {
    var PublishRequest;

    AV.ns("AV.obsPlugin.datamodel");

    PublishRequest = function (id, queueFullPath, storyLocator) {
        this.id = null;
        this.queueFullPath = "";
        this.storyLocator = "";

        this.id = id;
        this.queueFullPath = queueFullPath;
        this.storyLocator = storyLocator;

        this.toJs = function () {
            return JSON.stringify(this);
        }
    };

    AV.obsPlugin.datamodel.PublishRequest = PublishRequest;
}(AV));