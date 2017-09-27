Ext.define('Admin.view.profile.ProfileGridWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.profileGridWindow',
    autoShow: true,
    modal: true,

    layout: 'fit',

    width: 200,
    height: 200,

    afterRender: function () {
        var me = this;

        me.callParent(arguments);

        me.syncSize();
        Ext.on(me.resizeListeners = {
            resize: me.onViewportResize,
            scope: me,
            buffer: 50
        });
    },

    doDestroy: function () {
        Ext.un(this.resizeListeners);

        this.callParent();
    },

    onViewportResize: function () {
        this.syncSize();
    },

    syncSize: function () {
        var width = Ext.Element.getViewportWidth(),
            height = Ext.Element.getViewportHeight();

        // We use percentage sizes so we'll never overflow the screen (potentially
        // clipping buttons and locking the user in to the dialog).

        this.setSize(Math.floor(width * 0.5), Math.floor(height * 0.5));
        this.setXY([ Math.floor(width * 0.05), Math.floor(height * 0.05) ]);
    }
});
