(function () {
  // Retrieve the Avid action registry so you can register your new menu item/action.
  var registry = AV.action.Registry.getGlobal();

    // Register your new action.
    registry.register({
        id: "com.avid.central.obsplugin.exportrundown",
        text: "Export Rundown",

        // This code is called when your menu item is initialized.
        init: function (config) {
            this.view = config.component;
            this.ui = config.ui;
            var localize = this.view.getLocalization();
            this.ui.setText(this.text);
        },

        // This is where you decide whether your menu item is enabled
        // or not, depending on the business logic of your plug-in.
        isEnabled: function (selection) {
            if (!selection.isSingle())
            {
                return false;
            }

            //var items = selection.getItems();
            //if (1 != items.length)
            //{
            //    return false;
            //}
            //
            return selection.firstItem().type == "folder" || selection.firstItem().type == "Queue";
        },

        // handle the menu click
        handler: function (selection) {
            // for each selected queue perform the export
            // there should only be one as the enable logic traps multiple selections
            selection.getItems().forEach(function(item) {

                var queueToExport = "ARCHIVE.SOCHI2014.ONC.RUNDOWNS.00.0000";
                if (item.type == "Queue")
                {
                    // strip off leading "SERVER:"
                    queueToExport = item.id.substring(item.id.indexOf(":") + 1);

                    // strip off trailng "|Queue"
                    queueToExport = queueToExport.substr(0, queueToExport.lastIndexOf("|"));
                }

                // create an iNEWS request with the path to the queue
                var inews = new AV.obsPlugin.datamodel.InewsRequest({
                    queue: queueToExport,
                    export: false
                })

                var wb = AV.DialogBox.createDialogBox({
                    height: 100,
                    width: 200,
                    title: "In Progress",
                    maximizable: false,
                    modal: false,
                    html: "Please wait while the rundown is processed"
                });
                wb.show();

                // post the request to create the export data
                $.ajax("/api/inews/", {
                    method: "POST",
                    contentType: "application/json",
                    data: JSON.stringify(inews),
                    dataType: "json",
                })
                    .done (function(res) {
                    // the request will return an InewsResponse item which will tell us whether the queue is exportable or not
                    // if it is exportable it will provide the file name of the export
                    // if it cannot be exported there will be an error message explaining why

                    wb.hide();

                    // show dialog based on result of the call
                    if (0 == res.result)
                    {
                        // oh dear, we can't export it
                        AV.Utilities.showErrorMessage("The export failed for the following reason:\r\n\r\n" + res.message, "Export Failed");
                    }
                    else {
                        // ok, we can export it, show the export confirmation dialog
                        var actions = [
                            new Ext.Action({
                                handler: function () {
                                    dlg.close();

                                    // create a new request to export the data
                                    inews.export = true;
                                    inews.queue = res.filename;

                                    $.ajax("/api/inews/", {
                                        method: "POST",
                                        contentType: "application/json",
                                        data: JSON.stringify(inews),
                                        dataType: "json",
                                    })
                                        .done (function(res)
                                        {
                                            if (0 == res.result)
                                            {
                                                // oh dear, we can't export it
                                                AV.Utilities.showErrorMessage("The export failed for the following reason:\r\n\r\n" + res.message, "Export Failed");
                                            }
                                            else
                                            {
                                                AV.Utilities.showInfoMessage(res.message, "Export Complete");
                                            }
                                        })

                                },
                                text: "Export"
                            }),

                            new Ext.Action({
                                handler: function () {
                                    dlg.close();
                                },
                                text: "Cancel"
                            })
                        ];


                        var dlg = AV.DialogBox.createDialogBox({
                            height: 100,
                            width: 300,
                            title: "Confirm Rundown Export",
                            maximizable: false,
                            modal: true,
                            footerActions: actions,
                            html: "Export <h1>" + queueToExport + "</h1> as " + res.filename + "?"
                        });
                        dlg.show();

                    }

                })



                //AV.Utilities.showInfoMessage(item.id, item.name);
//            MessageBox.alert(item.name);
//            alert(item.name);
                console.log(item);
            });
        }
    });

})();

// This function connects the action you defined in the registry (above) to the actual menu.
(function () {
    var binder = AV.action.Binder,
        filters = AV.action.DefaultFilters;

    // This puts your action into the pane menu and context menu of the Asset List Pane.
    binder.bind({
        places: [ binder.PLACE_VIEW_MENU, binder.PLACE_CONTEXT_MENU ],

        // This limits where your menu item is added.
        // In this case it is limited to the Assets List pane.
        // If you have your own pane, you would add it here.
        filter: filters.or(
            filters.viewType("av-asset-list")
        ),

        // This specifies the relative position of the new action within menu.
        defaults: {
            index: 1500
        },

        // This must the same action ID as defined above.
        model: [
            { type: "separator" },
            { actionId: "com.avid.central.obsplugin.exportrundown" },
            { type: "separator" }
        ]
    });
})();

