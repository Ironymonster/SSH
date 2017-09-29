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
    items: [
    {
		xtype: 'hidden',
		fieldLabel: 'AssetsId',
		//allowBlank: false,
		name:'assetsId'
	},
	{
		xtype: 'textfield',
		fieldLabel: '资产编号',
		name:'assetsNumber'
	},
//	{
//		xtype: 'textfield',
//		fieldLabel: '资产名称',
//		name:'assetsName'
//	},{
//		xtype: 'datefield',
//		format: 'Y/m/d H:i:s',
//		fieldLabel: '开始使用时间',
//		name:'assetsUsedTime'
//	},{
//		xtype: 'combobox',
//		fieldLabel: '资产类型',
//		name:'assetsType',
//		store:  Ext.create('Ext.data.Store', {
//			fields: ['value', 'name'],
//			data : [
//				{"value":"eProduct", 	    "name":"电子产品"},
//				{"value":"oAppliances",     "name":"办公用具"},
//				{"value":"bEquipment", 	    "name":"基本设备"},
//				{"value":"transportation", 	"name":"交通工具"}
//			]
//		}),
//		queryMode: 	  'local',
//		displayField: 'name',
//		valueField:   'value'
//	},{
//		xtype: 'textfield',
//		fieldLabel: '资产估价',
//		name:'assetsPrice'
//    },
//    {
//		xtype: 'textfield',
//		fieldLabel: '拥有资产者',
//		name:'user'
//    }
	],
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