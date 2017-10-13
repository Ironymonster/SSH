/**
	1.绑定到主视图
	2.通过bind属性绑定到具体的子视图
8*/
Ext.define('Admin.view.profile.ProfileViewModel', {
extend: 'Ext.app.ViewModel',
alias: 'viewmodel.profileViewModel',
stores: {
    profileLists: {
        type: 'profileStore',//Store reference ==Store的属性 alias: 'store.profileStore',		
        autoLoad: true //Auto load
    }
}
});