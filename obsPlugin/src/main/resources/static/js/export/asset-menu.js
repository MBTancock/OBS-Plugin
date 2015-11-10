(function () {
  // Retrieve the Avid action registry so you can register your new menu item/action.
  var registry = AV.action.Registry.getGlobal();

    // Register your new action.
    registry.register({
        id: "com.avid.central.obsplugin.exportrundown",
        text: "Export Rundown",

        confirmDlog: undefined,

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
            return selection.firstItem().type == "folder" || selection.firstItem().type == "file" || selection.firstItem().type == "Queue";
        },

        // handle the menu click
        handler: function (selection) {
            try {
                // for each selected queue perform the export
                // there should only be one as the enable logic traps multiple selections
                selection.getItems().forEach(function (item) {

                    //var res = $(".cueSheet");
                    //
                    //if (res.length > 0)
                    //{
                    //    return;
                    //}
                    //var view = AV.ViewManager.createView({
                    //    type: "cueSheet",
                    //    name: "Cue Sheet Test",
                    //    closable: true
                    //});
                    //
                    //AV.ComplexLayout.openView(view);
                    //return;
                    var queueToExport = item.type == "folder" ? "ONC.RUNDOWNS.00.0000" : "MDS.MX1.00";
                    if (item.type == "Queue") {
                        // strip off leading "SERVER:"
                        queueToExport = item.id.substring(item.id.indexOf(":") + 1);

                        // strip off trailng "|Queue"
                        queueToExport = queueToExport.substr(0, queueToExport.lastIndexOf("|"));
                    }

                    // create an iNEWS request with the path to the queue
                    // it may seem excessive to use a model for a single string
                    // but the API doesn't seem to like POST with text
                    // maybe because of the in-built user session data
                    var inews = new AV.obsPlugin.datamodel.InewsRequest({
                        queue: queueToExport
                    })

                    //var wb = AV.messages.WaitBox.getDialog();
                    AV.messages.WaitBox.show({
                        title: "Preparing Rundown",
                        content: "Please wait while " + queueToExport + " is prepared",
                        isDelayed: true
                    });

                    // post the request to create the export data
                    $.ajax("/api/inews/", {
                        method: "POST",
                        contentType: "application/json",
                        data: inews.toJs(),
                        dataType: "json",
                    })
                        .done(function (res) {
                            // the request will return an InewsResponse item which will tell us whether the queue is exportable or not
                            // if it is exportable it will provide the details of the export
                            // if it cannot be exported there will be an error message explaining why

                            AV.messages.WaitBox.hide();
                            var response = new AV.obsPlugin.datamodel.InewsResponse(res);

                            switch (response.result)
                            {
                                case 1: // setup succeeded
                                        // show the export confirmation dialog
                                    var actions = [
                                        new Ext.Action({
                                            handler: function () {
                                                dlg.close();

                                                //var wb = AV.messages.WaitBox.getDialog();
                                                AV.messages.WaitBox.show({
                                                    title: "Exporting Rundown",
                                                    content: "Please wait while " + queueToExport + " is exported",
                                                    isDelayed: true
                                                });

                                                var path = "/api/inews/" + response.id;
                                                $.ajax(path, {
                                                    method: "GET",
                                                    dataType: "json",
                                                })
                                                    .done(function (res) {
                                                        AV.messages.WaitBox.hide();
                                                        var response = new AV.obsPlugin.datamodel.InewsResponse(res);

                                                        if (0 == response.result) {
                                                            // oh dear, we can't export it
                                                            AV.Utilities.showErrorMessage("The export failed for the following reason:\r\n\r\n" + res.message, "Export Failed");
                                                        }
                                                        else if (3 == response.result)
                                                        {
                                                            // configuration data has disappeared
                                                            AV.Utilities.showErrorMessage("The OBS Configuration could not be loaded.\r\n\r\nPlease check the OBS System Settings.", "OBS Export Not Configured");
                                                        }
                                                        else {
                                                            var html = new String("Filename: <b>");
                                                            html = html.concat(response.filename);
                                                            html = html.concat("</b><BR><BR>Location: <b>")
                                                            html = html.concat(response.location);
                                                            html = html.concat("</b>");
                                                            var moreActions = [
                                                                new Ext.Action({
                                                                    handler: function () {
                                                                        confirmDlog.close();
                                                                        confirmDlog = undefined;
                                                                    },
                                                                    text: "OK"
                                                                })
                                                                ];

                                                                confirmDlog = AV.DialogBox.createDialogBox({
                                                                height: 120,
                                                                width: 350,
                                                                title: response.rundown + " Export Complete",
                                                                maximizable: false,
                                                                modal: true,
                                                                footerActions: moreActions,
                                                                html: html,
                                                            });
                                                            confirmDlog.show();
                                                        }
                                                    })

                                            },
                                            text: "Export"
                                        }),

                                        new Ext.Action({
                                            handler: function () {
                                                dlg.close();
                                                var path = "/api/inews/" + response.id;
                                                $.ajax(path, {
                                                    method: "DELETE",
                                                    dataType: "json",
                                                })
                                                    .success(function (res) {
                                                        var rtn = res;
                                                    })
                                                    .error(function (res) {
                                                        var rtn = res;
                                                    })
                                            },
                                            text: "Cancel"
                                        })
                                    ];

                                    var dlg = AV.DialogBox.createDialogBox({
                                        height: 200,
                                        width: 400,
                                        title: "Confirm OBS XML Export",
                                        maximizable: false,
                                        modal: true,
                                        footerActions: actions,
                                        html: response.toHtml()
                                    });
                                    dlg.show();
                                    break;

                                case 2: // not authorized
                                    AV.Utilities.showErrorMessage("Sorry but you are not permitted to export rundowns", "Export Not Allowed");
                                    break;

                                case 3: // missing configuration
                                    AV.Utilities.showErrorMessage("The OBS Configuration could not be loaded.\r\n\r\nPlease check the OBS System Settings.", "OBS Export Not Configured");
                                    break;

                                default: // generic error
                                    AV.Utilities.showErrorMessage("The export failed for the following reason:\r\n\r\n" + res.message, "Export Failed");
                                    break;
                            }
                        })


                    console.log(item);
                });
            }
            catch (ex) {
                AV.messages.WaitBox.hide();
            }
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

