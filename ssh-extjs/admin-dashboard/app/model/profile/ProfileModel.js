Ext.define('Admin.model.profile.ProfileModel', {
    extend: 'Admin.model.Base',
    fields: [
		{name:'assetsId'			,type: 'int'},
    	{name:'assetsNumber' ,type: 'string'},
    	{name:'assetsUsedTime'	,type: 'date'},
		{name:'assetsName'		,type: 'string'},
		{name:'assetsPrice'		,type: 'float'},
		{name:'assetsType'		,type: 'string'}
    ]
});