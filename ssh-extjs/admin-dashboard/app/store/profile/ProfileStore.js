Ext.define('Admin.store.profile.ProfileStore', {
    extend: 'Ext.data.Store',
    alias: 'store.profileStore',			  //1.Store取别名（reference）
    model: 'Admin.model.profile.ProfileModel',//2.设置model的全路径
	proxy: {
		type: 'ajax',
		url: 'assets/findPage.json',	//后台ProfileController中的接口url地址
		reader: {
			type:'json',
			rootProperty: 'content',		//结果集名字的属性
			totalProperty: 'totalElements'	//一共多少条记录的属性
		},
		simpleSortMode: true	//简单排序模式
	},
	pageSize: 4,
	autoLoad: true,
	remoteSort: true,//全局排序
    sorters: {
        direction: 'DESC',
        property: 'assetsId'
    }
});

