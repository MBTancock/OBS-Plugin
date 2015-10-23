(function ($, AV) {
    "use strict";

    var registry = AV.action.Registry.getGlobal(),
        viewType = "av-search",
        actionId = "com.nbc.mam.filter-folder",
        openFolder = {
            id: actionId,
            text: "Filter Folder",
            isVisible: function () {
                var mode = this.view.mode;
                return mode && mode.getId() === "Indexed";
            },
            isEnabled: function () {
                var mode = this.view.mode;
                return mode && mode.getId() === "Indexed";
            },
            init: function (conf)  {
                var view = conf.component;
                this.view = view;
            },
            handler: function() {
                var view = this.view,
                    searchParams;

                if (!view) {
                    return;
                }

                searchParams = this.view.searchManager.getSearchParams();

                searchParams = $.extend(searchParams, {
                    criteria: [{
                        entity: "custom",
                        uid: {
                            id: "absolutePath",
                            systemType: "file-system"
                        },
                        value: {
                            comparison: "contains",
                            value: "C:\\\\Program Files"
                        }
                    }]
                });

                //This is internal search view API so it is unsafe to use it
                view.searchManager.search({
                    append: false,
                    params: searchParams,
                    query: "DVD*"
                });
            }
        },
        filters = AV.action.DefaultFilters;

    //Register action globally
    registry.register(openFolder);


    //Binds action as a menu item
    AV.action.Binder.bind({
        places: [AV.action.Binder.PLACE_VIEW_MENU],

        filter: filters.or(
            filters.viewType(viewType)
        ),

        defaults: {
            index: 1000
        },

        model: [
            {
                actionId: actionId
            }
        ]
    });
}(jQuery, AV));
