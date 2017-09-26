﻿/**
*订单模块子视图
*/
Ext.define('Admin.view.profile.ProfileGrid', {		//1.修改文件路径
      extend: 'Ext.grid.Panel',					//2.继承的组件类型
	//3.重写继承组件的属性：
	id:'profileGrid',
    xtype: 'profileGrid',
	title:'<b>订单列表</b>',
	bind:'{profileLists}',
	selModel: Ext.create('Ext.selection.CheckboxModel'),
	columns: [
		{text: 'ID'			  ,sortable:true ,dataIndex:'id',hidden:true},
        {text: '订单编号' ,sortable:true ,dataIndex:'profileNumber' ,width:120},
		{text: '创建时间'  ,sortable:true ,dataIndex:'createTime'  ,width:165
			,renderer: Ext.util.Format.dateRenderer('Y/m/d H:i:s')},
		{text: '优先级',sortable:true ,dataIndex:'level'    ,width:125},
		{text: '价格'		  ,sortable:true ,dataIndex:'price' ,flex:1}
	],	
	bbar: Ext.create('Ext.PagingToolbar', {
		bind:'{profileLists}',
		displayInfo: true,
		displayMsg: '第{0}-{1}条  共{2}条',
		emptyMsg: "没有任何记录",
		items:['-', {
			//xtype:'button',
			//text: 'Add',
			iconCls: 'x-fa fa-plus',
			listeners: {
                click: 'profileGridOpenAddWindow'
            }
			//handler: 'profileGridOpenAddWindow'
		}, {
			iconCls: 'x-fa fa-edit',
			handler: 'profileGridOpenEditWindow'
		}, {
			iconCls: 'x-fa fa-trash',
			handler: 'profileGridDeleteDate'
		}]
	})
});
