Ext.define('Admin.view.forms.WizardFormModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.wizardFormModel',
    data: {
        atBeginning: true,
        atEnd: false
    },
    stores: {
    profileLists: {
        type: 'wizardStore',//Store reference ==Store的属性 alias: 'store.profileStore',		
        autoLoad: true //Auto load
    }
}
});
