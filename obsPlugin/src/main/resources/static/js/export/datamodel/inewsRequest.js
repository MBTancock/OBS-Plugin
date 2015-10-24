    (function (AV) {
        var InewsRequest;

            AV.ns("AV.obsPlugin.datamodel");

        InewsRequest = function (data) {
            this.queue = "";
            this.export = false;

            if (data) {
                this.queue = data.queue;
                this.export = data.export;
            }
        };

        function toJs()
        {
            return JSON.stringify(this);
        }

        AV.obsPlugin.datamodel.InewsRequest = InewsRequest;
    }(AV));