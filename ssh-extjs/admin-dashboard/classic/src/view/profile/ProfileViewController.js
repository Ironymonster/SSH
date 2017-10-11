Ext.define('Admin.view.profile.ProfileViewController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.profileViewController',

    profileGridOpenAddWindow: function(btn) {
			Ext.widget('profileGridWindow',{
				title:'新建资产',
				items: [Ext.apply({xtype: 'profileGridForm'})]
			});
    },

	profileGridOpenEditWindow: function(btn) {
		var grid = btn.up('gridpanel');//获取Grid视图
		var selModel = grid.getSelectionModel();//获取Grid的SelectionModel
        if (selModel.hasSelection()) {//判断是否选中记录
           var record = selModel.getSelection()[0];//获取选中的第一条记录
           //创建修改window和form
		   var profileGridWindow = Ext.widget('profileGridWindow',{
				title:'修改资产',
				items: [{xtype: 'profileGridForm'}]
			});
		   //让form加载选中记录
           profileGridWindow.down("form").getForm().loadRecord(record);
        }else{
        	Ext.Msg.alert('提示',"请选择一行数据进行编辑!");
        }
    },

    profileGridOpenDeleteDate: function(btn) {
		var grid = btn.up('gridpanel');
		var selModel = grid.getSelectionModel();
        if (selModel.hasSelection()) {
            Ext.Msg.confirm("警告", "确定要删除吗？", function (button) {
                if (button == "yes") {
                    var selected = selModel.getSelection();
                    var selectIds = []; //要删除的id
                    Ext.each(selected, function (record) {
                        selectIds.push(record.data.assetsId);
                    })
                  	Ext.Ajax.request({
						url : 'assets/delete',
						method : 'post',
						params : {
							assetsIds:selectIds
						},
						success: function(response, options) {
			                var json = Ext.util.JSON.decode(response.responseText);
				            if(json.success){
				            	Ext.Msg.alert('操作成功', json.msg);
				                grid.getStore().reload();
					        }else{
					        	Ext.Msg.alert('操作失败', json.msg);
					        }
			            }
					});

                }
            });
		}
    },

	profileGridFormSubmit: function(btn) {

		var profileGridForm = btn.up('form').getForm();
		var win = btn.up('window');
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
    assetsPanelSearch:function(btn){
		var searchField = this.lookupReference('assetsSearchField').getValue();
		var searchText = this.lookupReference('assetsSearchText').getValue();
		var store = Ext.getCmp('profileGrid').getStore();//对应grid的id属性
		//1.清空所有QueryDTO中的查询条件
		Ext.apply(store.proxy.extraParams, {
			assetsName:'',
			assetsType:'',
			assetsNumber:''
			//assetsUsedTime:''
		});
		//2.按照所选字段进行查询参数（条件）的扩展
		if(searchField=='assetsNumber'){
			Ext.apply(store.proxy.extraParams, {
				assetsNumber:searchText,
			});
		}
		if(searchField=='assetsName'){
			Ext.apply(store.proxy.extraParams, {
				assetsName:searchText
			});
		}
		if(searchField=='assetsType'){
			Ext.apply(store.proxy.extraParams, {
				assetsType:searchText
			});
		}
		store.load();
	},

	showAssetsSearchWindow:function(btn){
		Ext.widget('profileSearchWindow').show();//autoShow
		},

	assetsSearchFormSubmit:function(btn){
		var store = Ext.getCmp('profileGrid').getStore();
		//1.清空所有查询条件
		Ext.apply(store.proxy.extraParams, {
			assetsNumber:'',
			assetsName:'',
			// assetsType:'',
			// lowPrice:'',
			// highPrice:'',
			//beginDate:'',
			//endDate:''
		});
		//2.按照所选字段进行查询参数（条件）的扩展
		Ext.apply(store.proxy.extraParams, {
			assetsNumber:this.lookupReference('profileSearchForm-assetsNumber').getValue(),
			assetsName:this.lookupReference('profileSearchForm-assetsName').getValue(),
			// assetsType:this.lookupReference('profileSearchForm-assetsType').getValue(),
			// lowPrice:this.lookupReference('profileSearchForm-lowPrice').getValue(),
			// highPrice:this.lookupReference('profileSearchForm-highPrice').getValue(),
			//beginDate:Ext.util.Format.date(this.lookupReference('profileSearchForm-beginDate').getValue(), 'Y/m/d H:i:s'),
			//endDate:Ext.util.Format.date(this.lookupReference('profileSearchForm-endDate').getValue(), 'Y/m/d H:i:s')
		});
		store.load();
		btn.up('window').hide();
	},

	profileGridWindowClose: function(btn) {
		var win = btn.up('window');
		if(win){
			win.close();
		}
    }
});
