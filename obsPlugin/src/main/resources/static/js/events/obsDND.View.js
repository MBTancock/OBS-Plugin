/*
 * Copyright 2013 by Avid Technology, Inc.
 */

(function(AV) {
    "use strict";

    var obsDNDView = function() {
        return new AV.View({

            onInit: function() {
                this.name("obsDNDView");
            },

            onRender: function() {
                var that = this;
                this.dragContainer = this.createDragContainer();
                this.displayContainer = this.createDisplayContainer();
                this.dom()[0].appendChild(this.dragContainer);
                this.dom()[0].appendChild(this.displayContainer);
                this.dragZone = new AV.obsDND.DragZone(this.dragContainer.firstChild, {
                    ddGroup: "AssetListDD", // queueGridDDGroup
                    callbackFn: function(data){that.dropCallback(data);}
                });
            },

            dropCallback: function(data){
                if(data && data.id){
                    this.display(data.id);
                }
            },

            createDragContainer: function(){
                var dragContainer = document.createElement('div');
                dragContainer.className = 'drag-container';
                dragContainer.innerHTML = '<div class="drag-el"><span>' + "obsDragAndDropView" + '</span></div>';
                return dragContainer;
            },

            createDisplayContainer: function(){
                var displayContainer = document.createElement('div');
                displayContainer.className = 'display-container';
                displayContainer.innerHTML = '<div class="default-msg"></div>';
                displayContainer.defaultMsg = true;

                AV.AssetDropTargetRegistry.register({
                        element: displayContainer,
                        onDrop: function (data) {
                            displayContainer.innerHTML = "Drop";
                        },
                        onDragOver: function() {
                            displayContainer.innerHTML = "DragOver";
                        },
                        onDragLeave: function() {
                            displayContainer.innerHTML = "DragLeave";
                        }}
                );

                return displayContainer;
            },

            display: function(keyboardShortcut){
                var activeKey = this.displayContainer.firstChild;
                if(this.displayContainer.defaultMsg){
                    this.displayContainer.innerHTML = '';
                    delete this.displayContainer.defaultMsg;
                }
                if(activeKey){
                    activeKey.className = '';
                }
                this.displayContainer.innerHTML = '<span class="active-key">' + keyboardShortcut + '</span>' + this.displayContainer.innerHTML;
            },

            onRevalidate: function(obj){
                this.dragContainer.style.height = obj.dimension.height - 2 + 'px';
                this.dragContainer.firstChild.style.top = (obj.dimension.height - this.dragContainer.firstChild.clientHeight)/2 + 'px';
                this.displayContainer.style.height = obj.dimension.height - 2 + 'px';
                this.displayContainer.style.width = obj.dimension.width - this.dragContainer.clientWidth - 9 + 'px';
            }



    });
    };


    AV.ViewManager.addViewFactory("obsPane", obsDNDView);
})(AV);
