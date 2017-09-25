/**
*订单模块子视图
*/
EExt.define('Admin.view.order.OrderGrid', {
			extend:'Ext.grid.Panel',
			xtype:'orderGrid',
			id:'orderGrid',
			title:'<b>订单列表<b>',
			bind:'{orderLists}',
			selModel: Ext.create('Ext.selection.CheckboxModel'),
			columns:[
			{text:'ID', sortable:true, dataIndex:'id', hidden:true},
			{text:'订单编号', sortable:true, dataIndex:'orderNumber', width:120},
			{text:'创建时间', sortable:true, dataIndex:'createTime', width:125,
					renderer:Ext.util.Format.dateRenderer('Y/m/d H:i:s')},
			{text:'优先级', sortable:true, dataIndex:'level', width:125},
			{text:'价格', sortable:true, dataIndex:'price', flex:1}
					],

			bbar: Ext.create('Ext.PagingToolbar', {
					bind:'{orderLists}',
					displayInfo: true,
					displayMsg: 'Displaying topics {0} - {1} of {2}',
					emptyMsg: "No topics to display",
					items:['-',{
					//xtype:'button',
					////text:'add'
					iconCls:'x-fa fa-plus',
					listeners: {
		                click: 'orderGridOpenAddWindow'
		            }
				  },{
					iconCls:'x-fa fa-edit',
					handler:'orderGridOpenEditWindow'
				  },{
					iconCls:'x-fa fa-trash',
					handler:'orderGridOpenDeleteDate'
			  }]
		})
	});
