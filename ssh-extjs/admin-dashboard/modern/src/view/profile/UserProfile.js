Ext.define('Admin.view.profile.UserProfile',
        {extend:Admin.view.profile.UserProfileBase,
        xtype:'profile',
        cls:'userProfile-container',
        layout:'responsivecolumn',
        controller: 'profileViewController',
        viewModel : {type: 'profileViewModel'},
        items:[ {
                    xtype:'profilesocial',
                    userCls:'big-25 small-100 shadow'
                },
                {
                    xtype:'profileForm',
                    userCls:'big-100 small-100 shadow'}
                // {
                //     xtype:'wizardform',
                //     cls:'wizardtwo shadow',
                //     colorScheme:'soft-purple',
                //     userCls:'big-50 small-100'},
                // {
                //     xtype: 'profileGrid',
                //     cls: 'wizardthree shadow',
                //     colorScheme: 'soft-green',
                //     userCls: 'big-50 small-100'}
                ]});