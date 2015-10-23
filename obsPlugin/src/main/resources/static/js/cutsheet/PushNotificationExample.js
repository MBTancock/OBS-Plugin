/*
 * Copyright 2013 by Avid Technology, Inc.
 */

var AV = AV || {};
AV.PushNotificationsExample = AV.PushNotificationsExample || {};

(function(AV) {

    // css block id
    AV.PushNotificationsExample.CSS_ID = 'push-notifications-example';
    // server path prefix
    AV.PushNotificationsExample.ServerSideUrlPrefix = '/api/notification/';
    //  server processor id
    AV.PushNotificationsExample.ServerSideProcessorId = 'com.avid.central.notification.example';

    AV.PushNotificationsExample.showView = function() {
        var view = AV.ViewManager.createView({
            type: 'obs-push-notifications-example',
            closable: false
        });
        AV.ComplexLayout.openView(view, true);
    }

    AV.PushNotificationsExample.View = function() {
        return new AV.View({

            onInit: function() {

                // setting proper name
                this.name('Push Notifications Example');

                // creating main div-container
                this.dom().append('<div id="' + AV.PushNotificationsExample.CSS_ID + '" class="push-notifications-example" />');

            },
            onRender: function() {
                var view = this;

                new Ext.Panel({
                    renderTo: AV.PushNotificationsExample.CSS_ID,
                    defaults: {
                        xtype: 'box',
                        labelWidth: 60
                    },
                    items: [
                        // don't need currently
//                        {
//                            html:'Push Notifications Example',
//                            cls:'av-panel-title'
//                        },
                        {
                            xtype: 'fieldset',
                            columnWidth: 0.5,
                            title: 'Input',
                            autoHeight: true,
                            itemCls: 'av-input-fieldset-item',
                            cls: 'av-fieldset-input',
                            defaults: {
                                anchor: '-20',
                                xtype: 'textfield',
                                boxMinWidth: 155
                            },
                            items: [
                                {
                                    xtype: 'textarea',
                                    fieldLabel: 'Data',
                                    id: 'push-notifications-data',
                                    ctCls: 'av-data-textarea-wrap',
                                    cls: 'av-textarea-input',
                                    allowBlank: false,
                                    width: 150,
                                    listeners: {
                                        focus: function(){
                                            $('.av-invalid-field-'+this.id).remove();
                                            $('.av-push-notifications-tooltip').css('visibility','visible !important').show();
                                        }
                                    }
                                },
                                {
                                    xtype: 'radiogroup',
                                    fieldLabel: 'Options',
                                    cls: 'av-radiogroup',
                                    ctCls: 'av-radiogroup-wrap',
                                    defaults: {
                                        xtype: 'av.radio',
                                        ctCls: 'av-radio-item',
                                        name: 'push-notification-options'
                                    },
                                    items: [
                                        {
                                            boxLabel: 'to user',
                                            checked: true,
                                            id: 'push-notifications-user-single-radio',
                                            listeners: {
                                                render: function(comp) {
                                                    $(comp.ownerCt.el.dom).find('label.x-form-cb-label').after('<span id="push-notifications-user-id-wrap" />');
                                                    var toUserTextField = new Ext.form.TextField({
                                                        fieldLabel: '',
                                                        renderTo: 'push-notifications-user-id-wrap',
                                                        id: 'push-notifications-user-id',
                                                        value: (typeof AV.User !== 'undefined' && typeof AV.User.name !== 'undefined') ? AV.User.name.replace(/^\s+/, '').replace(/\s+$/, '') : undefined,
                                                        allowBlank: false,
                                                        listeners: {
                                                            focus: function(){
                                                                $('.av-invalid-field-'+this.id).remove();
                                                                $('.av-push-notifications-tooltip').css('visibility','visible !important');
                                                            }
                                                        }
                                                    });
                                                },
                                                check: function(comp, checkVal) {
                                                    if (checkVal === true) {
                                                        Ext.getCmp('push-notifications-user-id').setDisabled(false);
                                                        Ext.getCmp('push-notifications-browser-session-id').setDisabled(true);
                                                    }
                                                }
                                            }
                                        },
                                        {
                                            boxLabel: 'to browser session',
                                            id: 'push-notifications-browser-session-radio',
                                            listeners: {
                                                render: function(comp) {
                                                    $(comp.ownerCt.el.dom).find('label.x-form-cb-label').addClass('av-browser-session-label').after('<span id="push-notifications-browser-session-id-wrap" />');
                                                    var toBrowserSessionTextField = new Ext.form.TextField({
                                                        fieldLabel: '',
                                                        renderTo: 'push-notifications-browser-session-id-wrap',
                                                        id: 'push-notifications-browser-session-id',
                                                        value: (typeof $.cookie('JSESSIONID') !== null) ? $.cookie('JSESSIONID') : undefined,
                                                        allowBlank: false,
                                                        listeners: {
                                                            focus: function(){
                                                                $('.av-invalid-field-'+this.id).remove();
                                                                $('.av-push-notifications-tooltip').css('visibility','visible !important');
                                                            }
                                                        }
                                                    });
                                                },
                                                check: function(comp, checkVal) {
                                                    if (checkVal === true) {
                                                        Ext.getCmp('push-notifications-browser-session-id').setDisabled(false);
                                                        Ext.getCmp('push-notifications-user-id').setDisabled(true);
                                                    }
                                                }
                                            }
                                        },
                                        {
                                            boxLabel: 'to all subscribers',
                                            id: 'push-notifications-user-all-radio',
                                            listeners: {
                                                check: function(comp, checkVal) {
                                                    if (checkVal === true) {
                                                        Ext.getCmp('push-notifications-user-id').setDisabled(true);
                                                        Ext.getCmp('push-notifications-browser-session-id').setDisabled(true);
                                                    }
                                                }
                                            }
                                        }
                                    ]
                                },
                                {
                                    xtype: 'av.button',
                                    text: 'Send',
                                    boxMaxWidth: 75,
                                    cls: 'av-send-button',
                                    id: 'sendButton',
                                    listeners: {
                                        click: function() {
                                            // removing notifications from dom
                                            $('.av-push-notifications-tooltip').remove()

                                            var formElements = [Ext.getCmp('push-notifications-data'), Ext.getCmp('push-notifications-user-id'), Ext.getCmp('push-notifications-browser-session-id')];

                                            var data = {
                                                message: Ext.getCmp('push-notifications-data').getValue().replace(/^\s+/, '').replace(/\s+$/, ''),
                                                user: undefined,
                                                'browser session': undefined
                                            };

                                            // setting new trimmed value to textarea
                                            Ext.getCmp('push-notifications-data').setValue(data.message);

                                            // getting value of user param of data object
                                            if (Ext.getCmp('push-notifications-user-single-radio').checked === true) {
                                                data.user = Ext.getCmp('push-notifications-user-id').getValue().replace(/^\s+/, '').replace(/\s+$/, '');
                                            } else if (Ext.getCmp('push-notifications-user-all-radio').checked === true) {
                                                data.user = 'all';
                                            } else if (Ext.getCmp('push-notifications-browser-session-radio').checked === true) {
                                                // making sure user is undefined
                                                data.user = undefined;
                                                data['browser session'] = Ext.getCmp('push-notifications-browser-session-id').getValue().replace(/^\s+/, '').replace(/\s+$/, '');
                                            }

                                            var url = AV.PushNotificationsExample.ServerSideUrlPrefix + 'all';
                                            if (typeof data.user !== 'undefined' && data.user !== 'all') {
                                                url = AV.PushNotificationsExample.ServerSideUrlPrefix + 'user/' + data.user;
                                            }
                                            if (typeof data['browser session'] !== 'undefined' && data['browser session'] !== '') {
                                                url = AV.PushNotificationsExample.ServerSideUrlPrefix + 'session/' + data['browser session'];
                                            }

                                            // validation of the form
                                            var formValid = true;
                                            for (var i = 0; i < formElements.length; i++) {
                                                if (!formElements[i].isValid()) {
                                                    new Ext.ToolTip({
                                                        html: formElements[i].blankText,
                                                        // don't disappear automatically
                                                        dismissDelay: 0,
                                                        cls: ['av-push-notifications-tooltip', 'av-invalid-field-' + formElements[i].id]
                                                    }).showBy(formElements[i].id);
                                                    formValid = false;
                                                }
                                            }
                                            if (!formValid) {
                                                $('.av-push-notifications-tooltip').css('visibility', 'hidden !important');
                                                $('.av-push-notifications-tooltip:first').css('visibility', 'visible !important');
                                            }

                                            if (formValid) {

                                                Ext.Ajax.request({
                                                    // REST URL provided by server side
                                                    url: url,
                                                    // don't need callbacks because of
                                                    // defining one at the place, where
                                                    // we registered server side processor
                                                    success: Ext.emptyFn,
                                                    failure: Ext.emptyFn,
                                                    method: 'POST',
                                                    headers: {
                                                        'Accept': 'application/json;version="1.0"',
                                                        'Content-Type': 'application/json'
                                                    },
                                                    jsonData: {
                                                        message: data.message,
                                                        handlerId: AV.PushNotificationsExample.ServerSideProcessorId
                                                    }
                                                });
                                            }

                                        }
                                    }
                                }
                            ]
                        },
                        {
                            xtype: 'fieldset',
                            columnWidth: 0.5,
                            title: 'Output',
                            autoHeight: true,
                            cls: 'av-fieldset-output',
                            defaults: {
                                anchor: '-20',
                                xtype: 'textfield',
                                boxMinWidth: 155
                            },
                            items: [
                                {
                                    xtype: 'box',
                                    fieldLabel: 'Log',
                                    labelWidth: 50,
                                    ctCls: 'emulate-html-textarea',
                                    cls: 'emulated-textarea',
                                    id: 'push-notifications-log',
                                    humanReadableId: 'trigerredByViewEventData',
                                    height: 200
                                },
                                {
                                    xtype: 'av.button',
                                    text: 'Clear',
                                    boxMaxWidth: 75,
                                    cls: 'av-clear-button',
                                    handler: function() {
                                        Ext.getCmp('push-notifications-log').el.dom.innerHTML = '';
                                    }
                                }
                            ]
                        }
                    ],
                    listeners: {
                        afterrender: function() {
                            Ext.getCmp('push-notifications-browser-session-id').setDisabled(true);
                        }
                    }

                });

                // helper function for logging data
                var log = function(data) {
                    var d = new Date();
                    var hours = d.getHours();
                    if (hours < 10) {
                        hours = '0' + hours;
                    }
                    var minutes = d.getMinutes();
                    if (minutes < 10) {
                        minutes = '0' + minutes;
                    }
                    var seconds = d.getSeconds();
                    if (seconds < 10) {
                        seconds = '0' + seconds;
                    }

                    // preparing data for pushing to log
                    if (typeof data === 'object') {
                        data = JSON.stringify(data).replace(/:/g, ': ').replace(/,/g, ', ');
                    }
                    // if it's not object
                    else {
                        // html escape
                        var dummyDiv = document.createElement('div');
                        dummyDiv.appendChild(document.createTextNode(data));
                        data = dummyDiv.innerHTML;
                        data = '<pre>'+data+'</pre>';
                    }

                    var randomId = Ext.id();

                    Ext.getCmp('push-notifications-log').el.dom.innerHTML += '<div class="log-entry">' +
                            '<div>' + hours + ':' + minutes + ':' + seconds + '</div>' + '<div class="main-message" id="'+randomId+'">'+data+'</div>' + '<div></div>'
                            + '</div>';

                    // making revalidate for correction width of data column in log
                    view.onRevalidate();
                };


                // override name property and onMessageReceive method
                AV.ServerPush.registerProcessor(new AV.PushNotificationHandler({
                    // unique id of processor
                    name: AV.PushNotificationsExample.ServerSideProcessorId,
                    // callback - listening to data, which comes from server
                    onMessageReceive: function(msg) {
                        log(msg.message);
                    }
                }));


                this.dom().scroll(function(){
                    $('.av-push-notifications-tooltip').remove();
                });

            },

            onRevalidate: function() {

                // making view with resizable controls
                // TODO: rewrite with using percentage values in form
                var viewWidth = this.dom().width();
                if (viewWidth > 0) {
                    this.dom('.av-textarea-input').css('width', parseInt(viewWidth - 124) + 'px !important');
                    this.dom('#push-notifications-example').css('width', parseInt(viewWidth - 26) + 'px !important');
                    this.dom('#push-notifications-user-id, ' +
                            '.obs-push-notifications-example #push-notifications-browser-session-id').css('width', parseInt(viewWidth - 207) + 'px !important');
                    this.dom('.av-fieldset-input:first, .av-radio-item .x-form-check-wrap, .av-radiogroup-wrap, ' +
                            '.av-radiogroup, .av-radiogroup .x-column-inner').css('width', parseInt(viewWidth - 49) + 'px !important');
                    this.dom('.av-radiogroup .x-column').css('width', parseInt(viewWidth - 45) + 'px !important');
                    this.dom('.log-entry .main-message').css('width', parseInt(viewWidth - 180) + 'px !important');
                }

            },

            onFocusGained: function() {
                // making revalidate
                this.onRevalidate();
            },

            getMinWidth: function() {
                return 400;
            }
        });
    };

    AV.ViewManager.addViewFactory('obs-push-notifications-example', AV.PushNotificationsExample.View);
})(AV);