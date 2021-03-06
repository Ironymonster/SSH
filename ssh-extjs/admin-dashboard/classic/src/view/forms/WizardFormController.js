/**
 * @class Admin.view.forms.WizardFormController
 */
Ext.define('Admin.view.forms.WizardFormController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.wizardFormController',


    init: function(view) {
        var tb = this.lookupReference('navigation-toolbar'),
            buttons = tb.items.items,
            ui = view.colorScheme;

        //Apply styling buttons
        if (ui) {
            buttons[1].setUI(ui);
            buttons[2].setUI(ui);
            buttons[3].setUI(ui);
        }
    },

    onNextClick: function(button) {
        //This is where you can handle any logic prior to moving to the next card
        var panel = button.up('panel');

        panel.getViewModel().set('atBeginning', false);

        this.navigate(button, panel, 'next');
    },

    onPreviousClick: function(button) {
        var panel = button.up('panel');

        panel.getViewModel().set('atEnd', false);

        this.navigate(button, panel, 'prev');
    },

    saveClick: function(btn) {
        var profileGridForm = btn.up('form').getForm();
            //var win = btn.up('window');
            //this.lookupReference('profileGrid').store.reload();  //lookupReference配合reference属性
            profileGridForm.submit( {
                //waitTitle : '请稍后...',
                //waitMsg : '正在保存订单信息,请稍后...',
                url : 'assets/saveOrUpdate',
                method : 'post',
                success : function(form, action) {
                    Ext.Msg.alert("提示",action.result.msg);
                    win.close();
                    Ext.getCmp("profileGrid").store.reload();
                },
                failure : function(form, action) {
                    Ext.Msg.alert("提示",action.result.msg);

                }
            });
    },

    navigate: function(button, panel, direction) {
        var layout = panel.getLayout(),
            progress = this.lookupReference('progress'),
            model = panel.getViewModel(),
            progressItems = progress.items.items,
            item, i, activeItem, activeIndex;

        layout[direction]();

        activeItem = layout.getActiveItem();
        activeIndex = panel.items.indexOf(activeItem);

        for (i = 0; i < progressItems.length; i++) {
            item = progressItems[i];

            if (activeIndex === item.step) {
                item.setPressed(true);
            }
            else {
                item.setPressed(false);
            }
            if (Ext.isIE8) {
                item.btnIconEl.syncRepaint();
            }
        }

        activeItem.focus();

        // beginning disables previous
        if (activeIndex === 0) {
            model.set('atBeginning', true);
        }

        // wizard is 4 steps. Disable next at end.
        if (activeIndex === 3) {
            model.set('atEnd', true);
        }
    }
});
