(function (ko, $) {
    AV.ViewManager.addViewFactory('todos-view-type', function() {
        var tmpl = "" +
            "<div class=\"todo-items\">\
                <input type='checkbox' data-bind=\"checked: alldone\" /><input id=\"new-todo\" data-bind=\"value: current, valueUpdate: 'afterkeydown', enterKey: add\" placeholder=\"What needs to be done?\" autofocus>\
                <ul data-bind=\"foreach: items\">\
                    <li class=\"todoItem\" data-bind=\"css: { done: done, editing: editing }\">\
                        <input type='checkbox' data-bind=\"checked: done\" /><label data-bind=\"text: title, event:{ dblclick: $root.edit}\"></label>\
                        <input class=\"renameField\" type='text' data-bind=\"value: title, valueUpdate: 'afterkeydown', enterKey: $root.stopEditing, event: { blur: $root.stopEditing }\">\
                        <button data-bind=\"click: $root.remove\" class=\"del\">X</button>\
                    </li>\
                </ul>\
                <div>\
                    <strong>Done:</strng><strong data-bind=\"text: doneCount\">0</strong>\
                    <button data-bind=\"click: $root.removeDone\">Romove done</button>\
                </div>\
                <pre data-bind=\"text: JSON.stringify(ko.toJS($data), null, 2)\"></pre>\
            </div>";

        return new AV.View({
            onInit: function() {
                var loc = this.getLocalization();
                this.name(loc('todos-view-type.name'));
                this.dom().text('View Name is: '+ this.name());
            },

            /**
             * Handles view rendering
             */
            onRender: function () {
                var todoContainer = $("<div></div>");
                this.dom().append(todoContainer);

                todoContainer.html(tmpl);
                ko.applyBindings(AV.todoExample.todosViewModel, todoContainer.children()[0]);
            }
        })
    });


}(AV.ko, jQuery));
