AV.ViewManager.addViewFactory('VIEW_TYPE', function() {
    return new AV.View({
        onInit: function() {
            var loc = this.getLocalization();
            this.name(loc('VIEW_TYPE.name'));
            this.dom().text('View Name is: '+ this.name());
        }
    })
});