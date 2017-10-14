Ext.define('Admin.view.profile.ProfileForm', {
    extend: 'Ext.form.Panel',
    xtype: 'profileForm',
    controller: 'profileViewController',

    title: "个人信息",
    width: 620,
    bodyPadding: '5 5 0',
    frame: true,

    layout: {
        type:'hbox',
        align:'stretch'
    },

    defaults: {
        border: false,
        xtype: 'panel',
        flex: 1,
        layout: 'anchor'
    },

    renderTo: Ext.getBody(),
    bodyPadding: 5,
    defaultType: 'textfield',
     items: [{
        items: [{
            xtype: 'textfield',
            fieldLabel: 'First Name',
            anchor: '-5',
            name: 'first'
        }, {
            xtype:'textfield',
            fieldLabel: 'Company',
            anchor: '-5',
            name: 'company'
        }]
    }, {
        items: [{
            xtype: 'textfield',
            fieldLabel: 'Last Name',
            anchor: '100%',
            name: 'last'
        },{
            xtype: 'textfield',
            fieldLabel: 'Email',
            anchor: '100%',
            name: 'email',
            vtype: 'email'
        }]
    }],

    buttons: ['->', {
        text: 'Save'
    }, {
        text: 'Cancel'
    }]
});

