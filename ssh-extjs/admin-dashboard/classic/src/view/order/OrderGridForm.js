Ext.define('Admin.view.order.OrderGridForm', {
    extend: 'Ext.form.Panel',
    alias: 'widget.orderGridForm',
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
        'Ext.form.field.Hidden'
    ],

    // viewModel: {
    //     type: 'emailcompose'
    // },

    controller: 'orderViewController',

    //cls: 'email-compose',

    layout: {
        type:'vbox',
        align:'stretch'
    },

    bodyPadding: 10,
    scrollable: true,

    defaults: {
        labelWidth: 60,
        labelSeparator: ''
    },

    // private Long id;
    // private String orderNumber;
    // private Date createTime;
    // private Level level;
    // private Float price;

    items: [
        {
            xtype: 'hidden',
            fieldLabel: 'Id',
            name:'id'
        },
        {
            xtype: 'textfield',
            fieldLabel: 'orderNumber',
            name:'orderNumber'
        },
        {
            xtype: 'datefield',
            format: 'Y/m/d H:i:s',
            fieldLabel: 'createTime',
            name:'createTime'
        },
        {
            xtype: 'combobox',
            fieldLabel: 'Level',
            name:'level',
            store: Ext.create('Ext.data.Store', {
            fields: ['value', 'name'],
            data : [
                {"value":"HIGH",    "name":"高"},
                {"value":"MEDIUM",  "name":"中"},
                {"value":"LOW",     "name":"低"}
            ]
        }),
        queryMode:    'local',
        displayField: 'name',
        valueField:   'value'
        },
         {
            xtype: 'textfield',
            fieldLabel: 'price',
            name:'price'
        }],
    bbar: {
        overflowHandler: 'menu',
        items: ['->',
        	 {
            xtype: 'button',
            //ui: 'soft-green',
            text: 'Save',
            handler: 'orderGridFormSubmit'
        },
            {
                xtype: 'button',
                //ui: 'soft-red',
                text: 'Cancel',
                handler: 'orderGridWindowClose'
            }]           
    }
});
