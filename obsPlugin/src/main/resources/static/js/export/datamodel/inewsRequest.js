    (function (AV) {
        var InewsRequest;

            AV.ns("AV.obsPlugin.datamodel");

        InewsRequest = function (data) {
            this.queue = "";

            if (data) {
                this.queue = data.queue;
            }

            this.toJs = function()
            {
                return JSON.stringify(this);
            }

        };

        AV.obsPlugin.datamodel.InewsRequest = InewsRequest;
    }(AV));