/**
 * Created by Broadcast Media Solutions on 05/11/2015.
 */
(function (AV) {
    var CuesheetRequest;

    AV.ns("AV.obsPlugin.datamodel");

    CuesheetRequest = function (data) {
        this.queue = "";
        this.story = "";

        if (data) {
            this.queue = data.queue;
            this.story = data.story;
        }

        this.toJs = function()
        {
            return JSON.stringify(this);
        }

    };

    AV.obsPlugin.datamodel.CuesheetRequest = CuesheetRequest;
}(AV));