/**
 * Created by Broadcast Media Solutions on 05/11/2015.
 */
(function (AV) {
    var CuesheetRequest;

    AV.ns("AV.obsPlugin.datamodel");

    CuesheetRequest = function (queue, story) {
        this.queue = "";
        this.story = "";

        this.queue = queue;
        this.story = story;

        this.toJs = function () {
            return JSON.stringify(this);
        }
    };

    AV.obsPlugin.datamodel.CuesheetRequest = CuesheetRequest;
}(AV));