var storyTitle = undefined;
var queueFullPath = undefined;
var storyLocator = undefined;
var sequenceMobID = undefined;

function exportCuesheet(story) {

    try
    {
        if (undefined == story || !(story instanceof Storyline.StoryModel)) {
            // this shouldn't happen because the handler should have trapped it
            AV.Utilities.showErrorMessage("Failed to obtain the story reference");
            return;
        }

        if (story.isStoryBodyLocked())
        {
            AV.Utilities.showErrorMessage("Unable to publish the Cue Sheet because the story is locked", "Story Locked");
            return;
        }

        // get the title
        var title = story.getTitleValue();
        if (undefined == title)
        {
            AV.Utilities.showErrorMessage("Failed to retrieve the story title");
            return;
        }

        // get the queue path
        var queue = story.getQueueFullPath();
        if (undefined == queue)
        {
            AV.Utilities.showErrorMessage("Failed to retrieve the queue details");
            return;
        }

        var locator = story.getQueueLocator();
        if (undefined == locator)
        {
            AV.Utilities.showErrorMessage("Failed to retrieve the story locator");
            return;
        }

        // get the sequence MobID
        var mobID = story.getSequenceID();
        if (undefined == mobID)
        {
            AV.Utilities.showErrorMessage("The story does not appear to have an associated sequence");
            return;
        }

        retrieveMarkers(title, queue, locator, mobID);
    }
    catch (ex)
    {
        AV.Utilities.showErrorMessage("An error occurred: " + ex.message);
    }
}

function retrieveMarkers(title, queue, locator, mobID)
{
    this.storyTitle = title;
    this.queueFullPath = queue.substring(queue.indexOf(":") + 1);
    this.storyLocator = locator;
    this.sequenceMobID = mobID;

    try {
        AV.messages.WaitBox.show({
            title: "Retrieving Markers",
            content: "Please wait while the markers are retrieved",
            isDelayed: true
        });

        // request the marker data
        $.ajax("/api/cuesheet/" + this.sequenceMobID, {
                method: "GET",
                dataType: "json"
            })
            .done(function (res) {
                AV.messages.WaitBox.hide();

                if (res == undefined) {
                    AV.Utilities.showErrorMessage("There was a problem communicating with the server.");
                    return;
                }

                if (res.message != undefined)
                {
                    console.log(res.message);
                }

                switch (res.result)
                {
                    case 1: // success
                        showDialog(res);
                        break;

                    case 2: // not authorised
                        AV.Utilities.showErrorMessage("Sorry but you are not permitted to publish cue sheets", "Publish Not Allowed");
                        break;

                    case 3: // missing configuration
                        AV.Utilities.showErrorMessage("The OBS Configuration could not be loaded.\r\n\r\nPlease check the OBS System Settings.", "OBS Export Not Configured");
                        break;

                    case 4: // invalid configuration
                        AV.Utilities.showErrorMessage("The OBS Configuration is incomplete.\r\n\r\nPlease check the OBS System Settings.", "OBS Export Not Configured");
                        break;

                    default: // assume an error
                        AV.Utilities.showErrorMessage("There was a problem retrieving the markers: " + res.message);
                        break;
                }
                if (0 == res.result) {

                    return;
                }
            })
    }
    catch (ex) {
        AV.messages.WaitBox.hide();
        AV.Utilities.showErrorMessage("An error occurred: " + ex.message);
    }}

function showDialog(res)
{
    Ext4.define('markerData', {
        extend: 'Ext4.data.Model',
        fields: [
            'start',
            'duration',
            'comment'
        ]
    });

    var markersStore = Ext4.create('Ext4.data.ArrayStore', {
        id: 'marker-store',
        model: markerData
    });

    win = Ext4.create('Ext4.window.Window', {
        closeAction: 'close',
        id: 'myWin',
        title: this.storyTitle,
        height: 280,
        width: 410,
        maxWidth: 410,
        minWidth: 410,
        constrain: true,
        buttonAlign: 'center',
        closable: false,
        resizable: true,
        layout: 'fit',
        items: [
            {
                xtype: 'grid',
                store: markersStore,
                id: 'export_markers_id',
                stateful: true,
                stateId: 'stateGrid',
                columns: [
                    {
                        text: 'Start',
                        width: 80,
                        sortable: false,
                        dataIndex: 'start',
                        height: 24,
                        align: 'center'
                    },
                    {
                        text: 'Durn.',
                        width: 80,
                        sortable: false,
                        dataIndex: 'duration',
                        height: 24,
                        align: 'center'
                    },
                    {
                        text: 'Comment',
                        flex: 1,
                        sortable: false,
                        dataIndex: 'comment',
                        height: 24
                    }
                ],
                height: 206,
                width: 380,
                margin: '0 0 10 10'
            }
        ],
        dockedItems: [
            {
                xtype: 'toolbar',
                flex: 1,
                dock: 'bottom',
                ui: 'footer',
                layout: {
                    pack: 'end',
                    type: 'hbox'
                },
                items: [
                    {
                        xtype: 'button',
                        text: 'Cancel',
                        id: 'cancel',
                        margin: '0 0 10 10',
                        handler: function () {
                            deleteSheet(res.id);
                            win.destroy();
                        }
                    },
                    {
                        xtype: 'button',
                        text: 'Publish',
                        id: 'export_cue_sheet_id',
                        margin: '0 15 20 10',
                        handler: function () {
                            publishSheet(res.id);
                            win.destroy();
                        }
                    }
                ]
            }
        ]
    });

    markersStore.loadData([], false);
    for (var i = 0; i < res.markers.length; i++) {
        var marker = res.markers[i];
        var a = marker['Start'];
        var b = marker['Duration'];
        var c = Ext4.String.htmlEncode(marker['Comment']);
        markersStore.add({start: a, duration: b, comment: c});
    }

    var btn = Ext4.getCmp('export_cue_sheet_id');
    btn.setDisabled(res.markers.length == 0);

    win.show();}
// deletes the publish record, called if the user cancelled
function deleteSheet(id)
{
    try {
        var path = "/api/cuesheet/" + id;
        $.ajax(path, {
                method: "DELETE",
                dataType: "text",
            })
            .done(function (res) {
                if (res != undefined)
                {
                    console.log(res);
                }
            });
    }
    catch (ex){}
}

// publishes the cuesheet to the story
function publishSheet(id)
{
    try {
        //AV.messages.WaitBox.show({
        //    title: "Publishing Cue Sheet",
        //    content: "Please wait while cue sheet is published to the story",
        //    isDelayed: true
        //});

        var publishRequest = new AV.obsPlugin.datamodel.PublishRequest(id, this.queueFullPath, this.storyLocator);
        var path = "/api/cuesheet/";
        $.ajax(path, {
                method: "POST",
                contentType: "application/json",
                data: publishRequest.toJs(),
                dataType: "json"
            })
            .done(function (res) {
                AV.messages.WaitBox.hide();

                if (res == undefined)
                {
                    AV.Utilities.showErrorMessage("There was a problem communicating with the server.");
                    return;
                }

                if (res.message != undefined)
                {
                    console.log(res.message);
                }

                switch (res.result)
                {
                    case 1: // success
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
                            height: 60,
                            width: 200,
                            title: "Publish Complete",
                            maximizable: false,
                            modal: true,
                            footerActions: moreActions,
                            html: "Cue Sheet published successfully."
                        });
                        confirmDlog.show();
                        break;

                    case 3: // missing configuration
                        AV.Utilities.showErrorMessage("The OBS Configuration could not be loaded.\r\n\r\nPlease check the OBS System Settings.", "OBS Export Not Configured");
                        break;

                    case 4: // invalid configuration
                        AV.Utilities.showErrorMessage("The OBS Configuration is incomplete.\r\n\r\nPlease check the OBS System Settings.", "OBS Export Not Configured");
                        break;

                    case 5: // locked
                        AV.Utilities.showErrorMessage("Failed to publish the Cue Sheet because the story is locked", "Story Locked");
                        break;

                    default: // assume error
                        AV.Utilities.showErrorMessage("There was a problem publishing the cue sheet: " + res.message);
                        break;
                }

            });
    }
    catch (ex) {
        AV.messages.WaitBox.hide();
        AV.Utilities.showErrorMessage("An error occurred: " + ex.message);
    }
}