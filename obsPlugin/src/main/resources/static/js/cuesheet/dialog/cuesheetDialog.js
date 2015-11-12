/**
 * Created by Broadcast Media Solutions on 12/11/2015.
 */




window.AV = AV || {};

(function() {
    // let's load close icon before connection will be lost, so it will exist and will be shown to the user
    var closeBoxImage = new Image();
    closeBoxImage.src = "/com.avid.central.UICore/singleton/images/av-dialog-box/close_box.png";

    var localize = AV.Localization.getLocalization("UICore");
    var maximizableSpace = 20;

    var baseClass = "av-dialog";

    var styleMap = [
        {
            ext: "x-resizable-handle-west",
            avid: "av-resizable-handle-west"
        },
        {
            ext: "x-resizable-handle-east",
            avid: "av-resizable-handle-east"
        },
        {
            ext: "x-resizable-handle-north",
            avid: "av-resizable-handle-north"
        },
        {
            ext: "x-resizable-handle-south",
            avid: "av-resizable-handle-south"
        },
        {
            ext: "x-resizable-handle-southwest",
            avid: "av-resizable-handle-southwest"
        },
        {
            ext: "x-resizable-handle-southeast",
            avid: "av-resizable-handle-southeast"
        },
        {
            ext: "x-resizable-handle-northwest",
            avid: "av-resizable-handle-northwest"
        },
        {
            ext: "x-resizable-handle-northeast",
            avid: "av-resizable-handle-northeast"
        },
        {
            ext: "x-tool",
            avid: "av-tool"
        },
        {
            ext: "x-tool-close",
            avid: "av-tool-close"
        },
        {
            ext: "x-tool-maximize",
            avid: "av-tool-maximize"
        },
        {
            ext: "x-tool-restore",
            avid: "av-tool-restore"
        },
        {
            ext: "x-tool-minimize",
            avid: "av-tool-minimize"
        }
    ];

    function callHandler(dialog, config, name) {
        if (config && config.listeners && config.listeners[name]) {
            var func = config.listeners[name];
            if (typeof func === "function") {
                func(dialog);
            }
        }
    }

    function makeFocusInDialogCyclic(dialogBox) {
        var dlg = $(dialogBox.el.dom);

        // Make dialog itself focusable.
        dlg.attr("tabindex", "0");

        // Create input element that appears after dialog content,
        // is focusable and will pass focus back to dialog when it gets it.
        // <input> is used because it is focusable in Safari by default.
        var $input = $(document.createElement("input")).
        attr("tabindex", "0").
        css({
            "position": "absolute",
            "top": ("-" + screen.height) + "px" // ensure input is not within screen area.
        }).
        focus(function() {
            dlg.focus();
        });
        var jContentPane = dlg.find("." + baseClass + "-mc");
        jContentPane.append($input);
    }

    function boxHasFocusedInput(elements) {
        return Array.prototype.some.call(
            elements,
            function(el) {
                return el === document.activeElement;
            });
    }

    AV.DialogBox = AV.DialogBox || {};

    /**
     * Make focus in dialog cyclic
     * @param {Object} dialog Window
     */
    AV.DialogBox.makeFocusInDialogCyclic = function (dialog) {
        function makeCyclic() {
            makeFocusInDialogCyclic(dialog);
        }
        dialog.on("show", makeCyclic);
        dialog.un("hide", makeCyclic);
    };

    AV.DialogBox.createDialogBox = function(config) {
        var ynFooter = config.yesNo && config.yesNo === true;
        var notCentered = config.notCentered;
        var preventCls = config.preventCls;

        var dialogBox;


        var documentClickHandler = function(event) {
            "use strict";
            var box = dialogBox.getBox(),
                boxDom = $(dialogBox.body.dom);
            var xWithin = box.x <= event.pageX && event.pageX <= (box.x + box.width);
            var yWithin = box.y <= event.pageY && event.pageY <= (box.y + box.height);
            if (!xWithin || !yWithin) {
                var boxElements = boxDom.find("input, textarea").toArray(),
                    preventedEl = boxDom.find(preventCls).toArray(),
                    allEl = boxElements.concat(preventedEl);

                if (!boxHasFocusedInput(allEl)) {
                    if (ynFooter) {
                        callHandler(dialogBox, config, "yesButton");
                    }
                }
            }
        };

        var applyStyles = function(dialog) {
            var i;
            for (i in styleMap) {
                dialog.find("." + styleMap[i].ext).addClass(styleMap[i].avid);
            }
        };

        // class is in function definition to simplify implementation
        // via enclosure of configuration object

        var onBrowserWindowResize = function() {
            if (!notCentered) {
                w.center();
            }
        };

        var alignButtonsHorizontally = function (footer) {
            var buttons = footer.findByType("button");
            var maxWidth = -1;
            Ext.each(buttons, function(button) {
                if (button.getWidth() > maxWidth) {
                    maxWidth = button.getWidth();
                }
            });
            Ext.each(buttons, function(button) {
                button.setWidth(maxWidth);
            });
            footer.doLayout();
        };

        var DialogBox = Ext.extend(Ext.Window, {
            baseCls: baseClass,
            afterRender: function() {
                this.superclass().afterRender.call(this);
                this.el.select(".x-tool-close").addListener("mousedown", this.close, this);
            },

            constructor: function(config) {
                //Destroy dialog box when creating new one with the same id to prevent overlap
                var cmp = Ext.getCmp(config.id);
                if (cmp && cmp.getXType() === "av.dialogbox"){
                    cmp.destroy();
                }
                //Clear state if box with same "id" was created previously
                Ext.state.Manager.clear(config.id);
                DialogBox.superclass.constructor.call(this, config);
            },

            constrain : true,
            listeners:{
                move: function() {
                    if (Ext.isIE) {
                        var dom = $(this.el.dom),
                            resizable = $(".ext-ie .x-resizable-handle-south,.ext-ie .x-resizable-handle-north"),
                            iframe = $("iframe");
                        dom.find(".av-tool-close").hover(function() {
                            $(this).css({"cursor":"pointer"});
                        });
                        dom.find(".av-dialog-header-text").hover(function() {
                            $(this).css({"cursor":"move"});
                        });
                        dom.find(".x-form-field").hover(function() {
                            $(this).css({"cursor":"text"});
                        });
                        dom.find(".x-form-field.x-trigger-noedit").hover(function() {
                            $(this).css({"cursor":"pointer"});
                        });
                        dom.find(".av-dialog .av-dialog-bwrap").hover(function() {
                            $(this).css({"cursor":"default"});
                        });
                        dom.find(".checkbox-wrap input.x-form-checkbox").hover(function() {
                            $(this).css({"cursor":"default"});
                        });
                        /*for Add && remove column dialog*/
                        resizable.hover(function () {
                            $(this).css({"cursor":"url(/ExtJS/3.4.0/resources/images/avid/arrow_cursor_vert.cur), row-resize"});
                        });

                        resizable.hover(function() {
                            $(this).css({"cursor":"url(/ExtJS/3.4.0/resources/images/avid/arrow_cursor_horiz.cur), col-resize"});
                        });
                        /* Fix for cursor in iFrame */
                        iframe.contents().find(".x-form-field").hover(function() {
                            $(this).css({"cursor":"text"});
                        });
                        iframe.contents().find(".x-form-field.x-trigger-noedit").hover(function() {
                            $(this).css({"cursor":"pointer"});
                        });
                        iframe.contents().find(".checkbox-wrap input.x-form-checkbox").hover(function() {
                            $(this).css({"cursor":"default"});
                        });
                    }
                }
            },

            close: function() {
                DialogBox.superclass.close.call(this);
                    this.destroy();
            },


            // Override
            show : function (animateTarget, cb, scope) {
                Ext.EventManager.onWindowResize(onBrowserWindowResize, w);
                if (this.isDestroyed) {
                    console.warn("Cannot show dialog, because it was destroyed", this);
                    return;
                }
                DialogBox.superclass.show.call(this, animateTarget, cb, scope);
                if (!this.fShownBefore) {
                    //if (ynFooter) {
                    //    yesNoCancelFooter = addYesNoCancelFooter(this, config, yncFooter);
                    //    yesNoCancelFooter.getComponent("yesButton").btnEl.focus(20);
                    //    alignButtonsHorizontally(yesNoCancelFooter);
                    //}

                    makeFocusInDialogCyclic(this);

                    applyStyles($(this.el.dom));
                    this.fShownBefore = true;
                }

                $(document).trigger("avDialogShow");
                this.addHeaderTextShadow();
            },

            addHeaderTextShadow: function () {
                if (Ext.isIE && this.isVisible()) {
                    $(this.el.dom).find(".av-dialog-header").textShadow("0 0 1px #e9e9e9");
                    $(this.el.dom).find(".av-dialog-header span div:not(\".av-dialog-header-text\")").css({"opacity":"0"});
                }
            },

            removeHeaderTextShadow: function () {
                if (Ext.isIE && this.isVisible()){
                    $(this.el.dom).find(".av-dialog-header").removeTextShadow();
                }
            },

            hide: function () {
                Ext.EventManager.removeResizeListener(onBrowserWindowResize, w);
                this.unghost();
                DialogBox.superclass.hide.call(this);
                document.removeEventListener("click", documentClickHandler, true);
            },

            // Override
            beforeDestroy : function() {
                DialogBox.superclass.beforeDestroy.call(this);
                document.removeEventListener("click", documentClickHandler, true);
            },

            // Override
            onResize: function (adjWidth, adjHeight, rawWidth, rawHeight) {
                //if (yesNoCancelFooter) {
                //    adjHeight -= yesNoCancelFooter.getHeight();
                //    rawHeight -= yesNoCancelFooter.getHeight();
                //    yesNoCancelFooter.doLayout();
                //}
                DialogBox.superclass.onResize.call(this, adjWidth, adjHeight, rawWidth, rawHeight);
                this.removeHeaderTextShadow();
                this.addHeaderTextShadow();
            },


            maximize : function() {
                DialogBox.superclass.maximize.call(this);
                this.setPosition(maximizableSpace, maximizableSpace);
            },

            fitContainer : function() {
                var vs = this.container.getViewSize(false);
                this.setSize(vs.width - 2*maximizableSpace, vs.height - 2*maximizableSpace);
            },

        });
        Ext.reg("av.dialogbox", DialogBox);
        var w = new DialogBox(config);
        return w;

    };


})();

