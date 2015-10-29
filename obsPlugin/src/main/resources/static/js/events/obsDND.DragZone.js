AV = AV || {};
AV.obsDND = AV.obsDND || {};

(function() {
    AV.obsDND.DragZone = Ext.extend(Ext.dd.DragZone, {

        callbackFn: Ext.emptyFn,

        getDragData : function(e) {
            var target = Ext.get(e.target);
            if (target == null) return;
            var el = target.findParent(".drag-el") || target.dom;
            var div = document.createElement('div');
            div.className = 'av-asset-drag-and-drop-proxy';
            div.appendChild(el.cloneNode(true));
            this.repairXY = Ext.fly(el).getXY();
            return {
                callback: this.callbackFn,
                ddel: div
            };
        },

        getRepairXY: function() {
            return this.repairXY;
        }
    });
}());