/**
 * Created by Broadcast Media Solutions on 05/11/2015.
 */

(function (AV) {
    var CuesheetResponse;

    AV.ns("AV.obsPlugin.datamodel");

    CuesheetResponse = function (data) {
        this.id = null;
        this.message = "";
        this.queue = "";
        this.story = "";
        this.result = 0; // 0 = error, 1 = setup success, 2 = not authorized, 3 = missing configuration

        if (data) {
            if (data.id) {
                this.id = data.id;
            }
            this.queue = data.queue;
            this.story = data.story;
            this.message = data.message;
            this.result = data.result;
        }

        this.toHtml = function() {
            var html = new String("Exporting Cuesheet <b>");
            html = html.concat(this.rundown);
            html = html.concat("</b>><BR><BR>Story: <b>")
            html = html.concat(this.story);
            html = html.concat("</b><BR><BR>Warnings: <b>")
            html = html.concat(this.message == undefined ? "None" : this.message);
            html = html.concat("</b>");
            return html;
        }
    };


    function toJs()
    {
        return JSON.stringify(this);
    }

    AV.obsPlugin.datamodel.CuesheetResponse = CuesheetResponse;
}(AV));