Ext.define('Admin.store.wizard.WizardStore', {
    extend: 'Ext.data.Store',
    alias: 'store.wizardStore',			  //1.Store取别名（reference）
    model: 'Admin.model.wizard.WizardModel',//2.设置model的全路径
    proxy: {
		type: 'ajax',
		url: 'userInfornation/findPage.json',	//后台ProfileController中的接口url地址
		reader: {
			type:'json',
			rootProperty: 'content',		//结果集名字的属性
			totalProperty: 'totalElements'	//一共多少条记录的属性
		},
	}
});

