/**
 * Created by Broadcast Media Solutions on 05/11/2015.
 */

(function (AV) {
    var CuesheetResponse;


    AV.ns("AV.obsPlugin.datamodel");

    CuesheetResponse = function (data) {
        this.id = null;
        this.markers = [];
        this.message = "";
        this.result = 0; // 0 = error, 1 = success, 2 = not authorized, 3 = missing configuration, 4 = no MobID

        if (data) {
            if (data.id) {
                this.id = data.id;
            }
            if (data.markers)
            {
                this.markers = data.markers;
            }
            this.message = data.message;
            this.result = data.result;
        }

    };


    function toJs()
    {
        return JSON.stringify(this);
    }

    AV.obsPlugin.datamodel.CuesheetResponse = CuesheetResponse;
}(AV));