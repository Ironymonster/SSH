/**
	1.绑定到主视图
	2.通过bind属性绑定到具体的子视图
8*/
Ext.define('Admin.view.assets.AssetsViewModel', {
extend: 'Ext.app.ViewModel',
alias: 'viewmodel.assetsViewModel',
stores: {
    assetsLists: {
        type: 'assetsStore',//Store reference ==Store的属性 alias: 'store.assetsStore',		
        autoLoad: true //Auto load
    }
}
});