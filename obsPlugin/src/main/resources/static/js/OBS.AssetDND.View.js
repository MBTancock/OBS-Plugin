/*
 * Copyright 2013 by Avid Technology, Inc.
 */

(function() {
    "use strict";

    AV.AssetDND.View = function() {
        return new AV.View({

            onInit: function() {
                this.name("CutSheet Export");
            },

            onRender: function() {
                var localizeUI = this.getLocalization(),
                        that = this;
                this.displayContainer = this.createDisplayContainer();
                this.dragContainer = this.createDragContainer();
                this.dom()[0].appendChild(this.dragContainer);
                this.dom()[0].appendChild(this.displayContainer);
                this.dragZone = new AV.AssetDND.DragZone(this.dragContainer.firstChild, {
                    ddGroup: "AssetListDD",
                    callbackFn: function(data){that.dropCallback(data);}
                });
            },

            dropCallback: function(data){
                if(data && data.id){
                    this.display(data.id);
                }
            },

            createDragContainer: function(){
                var localizeUI = this.getLocalization();
                var dragContainer = document.createElement('div');
                dragContainer.className = 'drag-container';
                dragContainer.innerHTML = '<div class="drag-el"><span>' + localizeUI("assetDragAndDropView.dragMsg") + '</span></div>';
                return dragContainer;
            },

            createDisplayContainer: function(){
                var localizeUI = this.getLocalization();
                var displayContainer = document.createElement('div');
                displayContainer.className = 'display-container';
                displayContainer.innerHTML = '<div class="default-msg"><span>' + "Drop Rundown Here" + '</span></div>';
                displayContainer.defaultMsg = true;

                AV.AssetDropTargetRegistry.register({
                            element: displayContainer,
                            onDrop: function (data) {
                                if (arguments.length > 0)
                                {
                                    displayContainer.innerHTML = '<div class="default-msg"><span>' + getDetail(arguments[0]) + '</span></div>';
                                }
                            },
                            onDragOver: function() {
                                displayContainer.innerHTML = '<div class="default-msg"><span>' + "Dragging" + '</span></div>';
                            },
                            onDragLeave: function() {
                                displayContainer.innerHTML = '<div class="default-msg"><span>' + "Drop Rundown Here" + '</span></div>';
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
/*
                this.dragContainer.style.height = obj.dimension.height - 2 + 'px';
                this.dragContainer.firstChild.style.top = (obj.dimension.height - this.dragContainer.firstChild.clientHeight)/2 + 'px';
*/
                this.displayContainer.style.height = obj.dimension.height - 2 + 'px';
                this.displayContainer.style.width = obj.dimension.width - 9 + 'px';
                //this.displayContainer.style.width = obj.dimension.width - this.dragContainer.clientWidth - 9 + 'px';
            }

        });
        function getDetail(detail)
        {
            var len = detail.length;
            if (len < 3)
            {
                return "Failed to read object";
            }

            var item = detail[2];
            return item.nodes[0].id;
        }
    };
    AV.ViewManager.addViewFactory("obs-assets-drag-and-drop", AV.AssetDND.View);
})();
