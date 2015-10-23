(function (AV, ko) {
    AV.ns("AV.todoExample");

    /**
     * Provides bindings implementation for view
     *
     * @constructor
     */
    var TodosViewModel = function () {
        var me = this,
            current = ko.observable(),
            previousState = [];

        me.items = ko.observableArray([]);

        initData();

        /**
         * Initially loads list of todos
         */
        function initData() {
            $.ajax("/api/todos/", {
                method: "GET",
                dataType: "json"
            })
                .done(function (res) {
                    var models = res.map(function (item) {
                        return new AV.todoExample.model.TodoItem(item);
                    });
                    ko.utils.arrayPushAll(me.items, models)
//                    me.items = ko.observableArray(models);
                    previousState = Array.apply(null, models);
                    console.log("Loaded", models);
                    subscribeStoring();
                })
        }

        /**
         * Subscribes handler to todos collection changes and saves changes to server
         */
        function subscribeStoring () {
            me.items.subscribe(function (state) {
                var added = [],
                    removed = [];

                added = state.filter(function(i) {
                    return previousState.indexOf(i) <0;
                });
                removed = previousState.filter(function(i) {
                    return state.indexOf(i) <0;
                });

                added.forEach(function (item) {
                    var id = item.id();
                    if (!id) {
                        $.ajax("/api/todos/", {
                            method: "POST",
                            contentType: "application/json",
                            data: ko.toJSON(item),
                            dataType: "json"
                        })
                            .done(function (res) {
                                ['done', 'title', 'id'].forEach(function (prop) {
                                    item[prop](res[prop]);
                                });
                                console.log("Result", item, res);
                            });
                    }
                });
                removed.forEach(function (item) {
                    var id = item.id();
                    if (id) {
                        $.ajax("/api/todos/" + id, {
                            method: "DELETE",
                            dataType: "json"
                        });
                    }
                 });

                previousState = Array.apply(null, state);
                console.log("ITEMS", added, removed);
            });
        }

        /**
         * Returns number of done items
         * @return {Number} Number of done items
         */
        me.doneCount = ko.computed(function () {
            return getDoneItems().length;
        });

        /**
         * Returns done items
         * @returns {AV.todoExample.model.TodoItem[]} array of done items
         */
        function getDoneItems () {
            return me.items().filter(function (item) {
                return item.done();
            });
        }

        /**
         * Returns number of not done items
         * @returns {Number} Number of remaining items
         */
        me.remainingCount = ko.computed(function () {
            return me.items().length - me.doneCount();
        });

        /**
         * Removes specific item
         * @param {AV.todoExample.model.TodoItem} item Item to remove
         */
        me.remove = function (item) {
            me.items.remove(item);
        };

        /**
         * Virtual property. True if there are no remaining items. If set to true marks all items as done
         */
        me.alldone = ko.computed({
            read: function () {
                return !me.remainingCount();
            },
            write: function (val) {
                me.items().forEach(function (item) {
                    item.done(val);
                });
            }
        });

        /**
         * Removes all items that are done
         */
        me.removeDone = function () {
            var done = getDoneItems();
            done.forEach(function (item) {
                me.items.remove(item);
            });

            initData();

            console.log("Remove done");
        }

        /**
         * Adds new item into collection
         * New item's title should be previously set into `current` property
         */
        function add () {
            var current = me.current().trim();

            if (current) {
                me.items.push(new AV.todoExample.model.TodoItem({
                    title: current,
                    checked: false
                }));
            }
            me.current('');
        };

        /**
         * Starts editing specific item
         * @param {AV.todoExample.model.TodoItem} item Edited item
         */
        function edit(item) {
            item.editing(true);
            console.log("EDIT", arguments);
        }

        /**
         * Finishes editing of specific item and persists data
         * @param {* AV.todoExample.model.TodoItem} item Edited item
         */
        function stopEditing (item) {
            var id = item.id();
            if (id) {
                $.ajax("/api/todos/" + id, {
                    method: "PUT",
                    contentType: "application/json",
                    dataType: "json",
                    data: ko.toJSON(item)
                });
            }
            item.editing(false);
            console.log("STOP EDITING", item, arguments);
        }

        me.stopEditing = stopEditing;
        me.add = add;
        me.current = current;
        me.edit = edit;
    };

    AV.todoExample.todosViewModel = new TodosViewModel();
}(window.AV, AV.ko));

