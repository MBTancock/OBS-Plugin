(function (AV, ko) {
    var TodoItem,

        /**
         * List of properties that should be persisted
         * @type {string[]}
         */
        persistentKeys = [
            "title",
            "id",
            "done"
        ];
    AV.ns("AV.todoExample.model");

    /**
     * @name AV.todoExample.model.TodoItem
     * @class
     * @param {Object} data Hash of properties
     * @param {String} data.id item id
     * @param {String} data.title item title
     * @param {Boolean} data.done done flag
     * @constructor
     */
    TodoItem = function (data) {
        this.title = ko.observable("");
        this.id = ko.observable(null);
        this.done = ko.observable(false);
        this.editing = ko.observable(false);

        if (data) {
            this.title(data.title);
            this.done(data.done);
            if (data.id) {
                this.id(data.id);
            }
        }
    };


    /**
     * Returns hash that contains only persistent properties
     * @return {Object}
     */
    TodoItem.prototype.toJS = function () {
        var json = ko.toJS(this);

        return Object.keys(json).filter(function (i) {
            return persistentKeys.indexOf(i) !== -1;
        }).reduce(function (obj, k) {
            obj[k] = json[k];
            return obj;
        }, {});
    };

    TodoItem.prototype.toJSON = function () {
        return this.toJS()
    }

    AV.todoExample.model.TodoItem = TodoItem;

}(AV, AV.ko));