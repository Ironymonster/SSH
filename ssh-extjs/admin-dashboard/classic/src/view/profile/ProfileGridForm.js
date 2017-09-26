Ext.define('Admin.view.profile.ProfileGridForm', {
    extend: 'Ext.form.Panel',
    alias: 'widget.profileGridForm',
	//id:'profileGridForm',//Ext.getCmp('profileGridForm');
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
    //viewModel: {type: 'emailcompose'},
    //cls: 'email-compose',
	controller: 'profileViewController',
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
    items: [{
		xtype: 'hidden',
		fieldLabel: 'Id',
		//allowBlank: false,
		name:'id'
	},{
		xtype: 'textfield',
		fieldLabel: 'Profile Number',
		name:'profileNumber'
	},{
		xtype: 'datefield',
		format: 'Y/m/d H:i:s',
		fieldLabel: 'Create Time',
		name:'createTime'
	},{
		xtype: 'combobox',
		fieldLabel: 'Level',
		name:'level',
		store:  Ext.create('Ext.data.Store', {
			fields: ['value', 'name'],
			data : [
				{"value":"HIGH", 	"name":"高"},
				{"value":"MEDIUM",  "name":"中"},
				{"value":"LOW", 	"name":"低"}
			]
		}),
		queryMode: 	  'local',
		displayField: 'name',
		valueField:   'value'
		
		
	},{
		xtype: 'textfield',
		fieldLabel: 'Price',
		name:'price'
    }],
    bbar: {
        overflowHandler: 'menu',
        items: ['->',{
			xtype: 'button',
			//ui: 'soft-red',
			text: '提交',
			handler: 'profileGridFormSubmit'
		},{
			xtype: 'button',
			//ui: 'gray',
			text: '取消',
			handler: 'profileGridWindowClose'
		}]
    }
});
