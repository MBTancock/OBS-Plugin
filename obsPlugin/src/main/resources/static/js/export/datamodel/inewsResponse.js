(function (AV, ko) {
    var InewsResponse,

        /**
         * List of properties that should be persisted
         * @type {string[]}
         */
        persistentKeys = [
            "filename",
            "message",
            "result"
        ];
    AV.ns("AV.obsPlugin.datamodel");

    /**
     * @name AV.obsPlugin.datamodel.InewsResponse
     * @class
     * @param {Object} data Hash of properties
     * @param {String} data.filename filename of the exported xml
     * @param {String} data.message error or warning message
     * @param {int} data.result result of the call
     * @constructor
     */
    InewsResponse = function (data) {
        this.filename = ko.observable("");
        this.message = ko.observable("");
        this.result = ko.observable(0);

        if (data) {
            this.filename(data.filename);
            this.message(data.message);
            this.result(data.result);
        }
    };


    /**
     * Returns hash that contains only persistent properties
     * @return {Object}
     */
    InewsResponse.prototype.toJS = function () {
        var json = ko.toJS(this);

        return Object.keys(json).filter(function (i) {
            return persistentKeys.indexOf(i) !== -1;
        }).reduce(function (obj, k) {
            obj[k] = json[k];
            return obj;
        }, {});
    };

    InewsResponse.prototype.toJSON = function () {
        return this.toJS()
    }

    AV.obsPlugin.datamodel.InewsResponse = InewsResponse;

}(AV, AV.ko));