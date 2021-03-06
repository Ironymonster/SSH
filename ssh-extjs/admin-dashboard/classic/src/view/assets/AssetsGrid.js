Ext.define('Admin.view.assets.AssetsGrid', {    //1.修改文件路径
    extend: 'Ext.grid.Panel',         //2.继承的组件类型
		//3.重写继承组件的属性：
		id:'assetsGrid',
		xtype: 'assetsGrid',
		title:'<b>资产列表</b>',
		bind:'{assetsLists}',
		selModel: Ext.create('Ext.selection.CheckboxModel'),
		columns: [
		  {text: 'AssetsID',sortable:true ,dataIndex:'assetsId',hidden:true},
		  {text: '资产编号' ,sortable:true ,dataIndex:'assetsNumber' ,width:100},
		  {text: '资产名称' ,sortable:true ,dataIndex:'assetsName' ,width:150},
		  {text: '创建时间'  ,sortable:true ,dataIndex:'assetsUsedTime'  ,width:170
		    ,renderer: Ext.util.Format.dateRenderer('Y/m/d H:i:s')},
		   {text: '资产类型',sortable:true ,dataIndex:'assetsType'    ,width:150},
		   {text: '估计价值',sortable:true ,dataIndex:'assetsPrice' ,flex:1}
		],
		dockedItems: [{
            xtype: 'toolbar',
            dock: 'top',
            items:[
            {
    			xtype	 : 'combobox',
    			reference: 'assetsSearchField', //查询条件下拉列表
    			store: Ext.create('Ext.data.Store', {
    			    fields: ['value', 'name'],
    			    data : [//查询条件字段名和展示名
    			    	{"value":'assetsNumber', "name":'资产编号'},
    			        {"value":'assetsName', "name":'资产名称'}
    			        //{"value":'assetsPrice',"name":'估计价值'}
    			        //{"value":'assetsType',"name":'资产类型'}
    			        //{"value":'assetsUsedTime',"name":'创建时间'},
    			        // {"value":'uer',"name":'持有人'}
    			    ]
    			}),
    		     mode : 'local',
    			editable : false,
    			allowBlank : false,
    			queryMode: 'local',
    			valueField: 'value',
             displayField: 'name',
             value : 'assetsNumber'//默认显示data属性中的 用户名
    		},{
    			xtype	 : 'textfield',
    			reference: 'assetsSearchText'//查询值文本框
    		},
    		{
            	text: '查询',
				listeners: {
					click: 'assetsPanelSearch'//快捷查询按钮
				}
            },{
            	text: '高级查询',
				listeners: {
					click: 'showAssetsSearchWindow'//高级查询按钮
				}
 			}]
		}],
		bbar:Ext.create('Ext.PagingToolbar',{
		  bind:'{assetsLists}',
		  displayInfo:true,
		  displayMsg:'第{0}-{1}条 共{2}条',
		  emptyMsg:"没有任何记录",
		  items:['-',{
		    iconCls:'x-fa fa-plus',
		    handler:'assetsGridOpenAddWindow'
		  },
		  '-',
		  {
		    iconCls:'x-fa fa-edit',
		    handler:'assetsGridOpenEditWindow'
		  },
		  '-',
		  {
		    iconCls:'x-fa fa-trash',
		    handler:'assetsGridOpenDeleteDate'
		  }]
		})
});