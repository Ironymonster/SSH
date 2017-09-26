Ext.define('Admin.view.profile.ProfileForm', {
    extend: 'Ext.panel.Panel',
    xtype: 'profileform',
    requires: [
                'Ext.button.Button',
                'Ext.form.field.Text',
                'Ext.form.field.File',
                'Ext.form.field.HtmlEditor',
                'Ext.form.field.TextArea',
                'Ext.form.field.Time',
                'Ext.form.field.ComboBox',
                'Ext.form.field.Date',
                'Ext.form.field.Radio',
                'Ext.form.field.Hidden'],

    bodyPadding: 15,

    height: 340,

    layout: 'card',

    viewModel: {
        type: 'wizardform'
    },

    controller: 'wizardform',

    defaults : {
        /*
         * Seek out the first enabled, focusable, empty textfield when the form is focused
         */
        defaultFocus: 'textfield:not([value]):focusable:not([disabled])',

        defaultButton : 'nextbutton'
    },

    items: [
        {
            xtype:'form',
            defaultType:'textfield',
            defaults: {
                labelWidth: 90,
                labelAlign: 'right',
                labelSeparator: '',
                submitEmptyText: false,
                anchor: '100%'
            },
            items:[
                {
                    xtype: 'hidden',
                    fieldLabel: 'Id',
                    name:'id'
                },
                {
                    fieldLabel: 'profileName',
                    emptyText : 'Username must be unique.',
                    name:'profileName'
                },
                {
                    xtype: 'datefield',
                    format: 'Y/m/d H:i:s',
                    fieldLabel: 'createTime',
                    name:'createTime'
                },
                {
                    emptyText : 'ex: me@somewhere.com',
                    vtype: 'email'
                },
                {
                    emptyText : 'Enter a password',
                    inputType: 'password',
                    cls: 'profile-form-break'
                },
                {
                    emptyText : 'Passwords must match',
                    inputType: 'password'
                }
            ]
        },
        {
            xtype: 'form',
            defaultType: 'textfield',
            defaults: {
                labelWidth: 90,
                labelAlign: 'top',
                labelSeparator: '',
                submitEmptyText: false,
                anchor: '100%'
            },
            items:[
                {
                    emptyText : 'First Name'
                },
                {
                    emptyText : 'Last Name'
                },
                {
                    emptyText : 'Company'
                },
                {
                    xtype      : 'fieldcontainer',
                    cls: 'profile-form-break',
                    fieldLabel : 'MemberType',
                    defaultType: 'radiofield',
                    defaults: {
                        flex: 1
                    },
                    layout: 'hbox',
                    items: [
                        {
                            boxLabel  : 'Free',
                            name      : 'MemberType',
                            inputValue: 'Free'
                        }, {
                            boxLabel  : 'Personal',
                            name      : 'MemberType',
                            inputValue: 'Perosnal'
                        }, {
                            boxLabel  : 'Black',
                            name      : 'MemberType',
                            inputValue: 'Business'
                        }
                    ]
                }
            ]
        },
        {
            xtype: 'form',
            defaultType: 'textfield',
            defaults: {
                labelWidth: 90,
                labelAlign: 'top',
                labelSeparator: '',
                submitEmptyText: false,
                anchor: '100%'
            },
            items:[
                {
                    emptyText : 'Phone number'
                },
                {
                    emptyText : 'Address'
                },
                {
                    emptyText : 'City'
                },
                {
                    emptyText : 'Postal Code / Zip Code'
                }
            ]
        },
        {
            xtype: 'form',
            items:[
                {
                    html : '<h2>Thank You</h2><p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>'
                	emptyText : 'Postal Code / Zip Code'
                }
            ]
        }
    ],

    initComponent: function() {

        this.tbar = {
            reference: 'progress',
            defaultButtonUI: 'profile-' + this.colorScheme,
            cls: 'profileprogressbar',
            defaults: {
                disabled: true,
                iconAlign:'top'
            },
            layout: {
                pack: 'center'
            },
            items: [
                {
                    step: 0,
                    iconCls: 'fa fa-info',
                    pressed: true,
                    enableToggle: true,
                    text: 'Account'
                },
                {
                    step: 1,
                    iconCls: 'fa fa-user',
                    enableToggle: true,
                    text: 'Profile'
                },
                {
                    step: 2,
                    iconCls: 'fa fa-home',
                    enableToggle: true,
                    text: 'Address'
                },
                {
                    step: 3,
                    iconCls: 'fa fa-heart',
                    enableToggle: true,
                    text: 'Finish'
                }
            ]
        };

        this.bbar = {
            reference: 'navigation-toolbar',
            margin: 8,
            items: [
                '->',
                {
                    text: 'Previous',
                    ui: this.colorScheme,
                    formBind: true,
                    bind: {
                        disabled: '{atBeginning}'
                    },
                    listeners: {
                        click: 'onPreviousClick'
                    }
                },
                {
                    text: 'Next',
                    ui: this.colorScheme,
                    formBind: true,
                    reference : 'nextbutton',
                    bind: {
                        disabled: '{atEnd}'
                    },
                    listeners: {
                        click: 'onNextClick'
                    }
                }
            ]
        };

        this.callParent();
    }
});
