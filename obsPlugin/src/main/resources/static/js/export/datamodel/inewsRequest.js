(function (AV, ko) {
    var InewsRequest,

        /**
         * List of properties that should be persisted
         * @type {string[]}
         */
        persistentKeys = [
            "queue",
            "export"
        ];
    AV.ns("AV.obsPlugin.datamodel");

    /**
     * @name AV.obsPlugin.datamodel.InewsRequest
     * @class
     * @param {Object} data Hash of properties
     * @param {String} data.queue path of the queue to process
     * @param {Boolean} data.export true to export the data, false to create it
     * @constructor
     */
    InewsRequest = function (data) {
        this.queue = ko.observable("");
        this.export = ko.observable(false);

        if (data) {
            this.queue(data.queue);
            this.export(data.export);
        }
    };


    /**
     * Returns hash that contains only persistent properties
     * @return {Object}
     */
    InewsRequest.prototype.toJS = function () {
        var json = ko.toJS(this);

        return Object.keys(json).filter(function (i) {
            return persistentKeys.indexOf(i) !== -1;
        }).reduce(function (obj, k) {
            obj[k] = json[k];
            return obj;
        }, {});
    };

    InewsRequest.prototype.toJSON = function () {
        return this.toJS()
    }

    AV.obsPlugin.datamodel.InewsRequest = InewsRequest;

}(AV, AV.ko));