/**
 * Created by Broadcast Media Solutions on 05/11/2015.
 */

(function (AV) {
    var MarkerData;

    AV.ns("AV.obsPlugin.datamodel");

    MarkerData = function (data) {
        this.start = "";
        this.duration = "";
        this.comment = "";

        if (data) {
            this.start = data.start;
            this.duration = data.duration;
            this.comment = data.comment;
        }

    };


    function toJs()
    {
        return JSON.stringify(this);
    }

    AV.obsPlugin.datamodel.MarkerData = MarkerData;
}(AV));