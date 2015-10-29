(function (AV) {
    var InewsResponse;

    AV.ns("AV.obsPlugin.datamodel");

    InewsResponse = function (data) {
        this.id = null;
        this.filename = "";
        this.location = "";
        this.rundown = "";
        this.channelID = "";
        this.title = "";
        this.date = "";
        this.day = "";
        this.startTime = "";
        this.endTime = "";
        this.message = "";
        this.result = 0; // 0 = error, 1 = setup success, 2 = not authorized

        if (data) {
            if (data.id) {
                this.id = data.id;
            }
            this.filename = data.filename;
            this.location = data.location;
            this.rundown = data.rundown;
            this.channelID = data.channelID;
            this.title = data.title;
            this.date = data.date;
            this.day = data.day;
            this.startTime = data.startTime;
            this.endTime = data.endTime;
            this.message = data.message;
            this.result = data.result;
        }

        this.toHtml = function() {
            var html = new String("Exporting iNEWS rundown <b>");
            html = html.concat(this.rundown);
            html = html.concat("</b>OBSChannelID: <b>")
            html = html.concat(this.channelID);
            html = html.concat("</b><BR>Title: <b>")
            html = html.concat(this.title);
            html = html.concat("</b><BR>Date: <b>")
            html = html.concat(this.date);
            html = html.concat("</b><BR>Day: <b>")
            html = html.concat(this.day);
            html = html.concat("</b><BR>Start time: <b>")
            html = html.concat(this.startTime);
            html = html.concat("</b><BR>End time: <b>")
            html = html.concat(this.endTime);
            html = html.concat("</b><BR><BR>Warnings: <b>")
            html = html.concat(this.message == undefined ? "None" : this.message);
            html = html.concat("</b><BR><BR>Filename: <b>")
            html = html.concat(this.filename);
            html = html.concat("</b>");
            return html;
        }
    };


    function toJs()
    {
        return JSON.stringify(this);
    }

    AV.obsPlugin.datamodel.InewsResponse = InewsResponse;
}(AV));