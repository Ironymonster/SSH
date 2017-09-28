/**
*订单模块子视图
*/
Ext.define('Admin.view.profile.ProfileGrid', {    //1.修改文件路径
    extend: 'Ext.grid.Panel',         //2.继承的组件类型
		//3.重写继承组件的属性：
		  xtype: 'profileGrid',
		  bodyPadding: 15,
		  height: 340,
		  layout: 'card',
		  id:'profileGrid',
		title:'<b>资产列表</b>',
		bind:'{profileGrid}',
		
		columns: [			
		  {text: 'ID',sortable:true ,dataIndex:'id',hidden:true},
		  {text: '资产编号' ,sortable:true ,dataIndex:'orderNumber' ,width:100},
		  {text: '资产名称' ,sortable:true ,dataIndex:'orderName' ,width:100},
		  {text: '创建时间'  ,sortable:true ,dataIndex:'createTime'  ,width:125
		    ,renderer: Ext.util.Format.dateRenderer('Y/m/d H:i:s')},
		  {text: '资产类型',sortable:true ,dataIndex:'level'    ,width:125},
		  {text: '估计价值',sortable:true ,dataIndex:'price' ,flex:1}
		],
		bbar:Ext.create('Ext.PagingToolbar',{
		  bind:'{profileLists}',
		  displayInfo:true,
		  displayMsg:'第{0}-{1}条 共{2}条',
		  emptyMsg:"没有任何记录",
		  items:['-',{
		    //xtype:'button',
		    ////text:'add'
		    iconCls:'x-fa fa-plus',
		    handler:'profileGridOpenAddWindow'
		  },
		  '-',
		  {
		    iconCls:'x-fa fa-edit',
		    handler:'profileGridOpenEditWindow'
		  },
		  '-',
		  {
		    iconCls:'x-fa fa-trash',
		    handler:'profileGridOpenDeleteDate'
		  }]
		})
		});
