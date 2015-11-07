/**
 * Created by Broadcast Media Solutions on 29/10/2015.
 */
(function(AV) {
    AV.ViewManager.addViewFactory("cueSheet", function (options) {
        return new AV.View({

            onInit: function () {
                this.name("cueSheetView");
                this.dom().append('<div id="cuesheetpanel" class="cuesheet"></div>');
            },

            onRender: function () {
                Ext4.create('Ext.form.Panel', {
                    autoHeight: false,
                    autoScroll: true,
                    renderTo: Ext.get('cuesheetpanel'),
                    width: 500,
                    items: [
                        {
                            xtype: 'fieldset',
                            title: 'OBS Cue Sheet Export Test',
                            //layout: 'column',
                            defaults: {
                                anchor: '100%',
                                labelWidth: 160,
                                labelAlign: 'right'
                            },
                            items: [
                                {
                                    xtype: 'textareafield',
                                    fieldLabel: 'Paste Story Link Here',
                                    id: 'export_link_id',
                                    grow: 'true',
                                    listeners:
                                    {
                                        blur: function () {
                                        },
                                        change: function (newValue, oldValue, eOpts) {
                                            var btn = Ext4.getCmp('export_sheet_id');
                                            btn.setDisabled(oldValue.toString().length == 0);
                                        }
                                    }
                                },
                                {
                                    xtype: 'button',
                                    text: 'Export',
                                    name: 'export_sheet',
                                    id: 'export_sheet_id',
                                    width: '100',
                                    margin: '0 0 0 165',
                                    disabled: 'true',
                                    handler: function () {
                                        exportCueSheet();
                                    }
                                }
                            ]
                        }
                    ]
                })
                $('input[name="export_sheet"]').attr('disabled', 'true');
            }

        });
        function exportCueSheet() {
            var txt = Ext4.getCmp('export_link_id').value;
            // strip off initial identifier
            var urlText = txt;

            txt = txt.substring(txt.indexOf("%3A") + 3);
            var rundown = txt.substring(0, txt.indexOf("%3A"));
            txt = txt.substring(txt.indexOf("%3A") + 3);
            var story = txt.substring(0, txt.indexOf("%7C"));

            var cuesheet = new AV.obsPlugin.datamodel.CuesheetRequest();
            cuesheet.queue = rundown;
            cuesheet.story = story;

            //// see if we can get the story using the MediaCentral iNEWS api
            //// https://media-central/layout/inews-only-layout/#inews:INEWS%3AMDS.MX1.00%3A84955593.287885.11%7CStory
            //urlText = urlText.substring(urlText.indexOf("#inews:") + "#inews:".length);
            //var urlQueue = urlText.substring(0, urlText.lastIndexOf("%3A"));
            //var urlStory = urlText.substring(urlText.lastIndexOf("%3A") + "%3A".length);
            //urlStory = urlStory.substring(0, urlStory.indexOf("%7C"));
            //
            //var url = "/api/inews/queue/story/story/" + urlQueue + "%7CQueue/" + urlStory;
            //$.ajax(url, {
            //        method: "GET",
            //        dataType: "json",
            //    })
            //    .done(function (res) {
            //        var story = new Storyline.StoryModel();
            //        story.setStory(res);
            //        if (story != null) {
            //            AV.Utilities.showErrorMessage(story.getTitleValue() + "Sequence: " + story.getSequenceID());
            //        }
            //    })

            // post the request to create the export data
            $.ajax("/api/cuesheet/", {
                    method: "POST",
                    contentType: "application/json",
                    data: cuesheet.toJs(),
                    dataType: "json",
                })
                .done(function (res) {
                    var response = new AV.obsPlugin.datamodel.CuesheetResponse(res);
                    AV.Utilities.showInfoMessage(response.message);
                                })
        }
    })
})(AV);