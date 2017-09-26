Ext.define('Admin.view.profile.ProfileOne', {
    extend: 'Ext.panel.Panel',
    alias: 'widget.formsprofiledone',
    requires: [
        'Ext.form.field.Radio'
    ],

    cls: 'profileone shadow',

    plugins: {
        responsive: true
    },

    responsiveConfig: {
        'width >= 1000': {
            layout: {
                type: 'box',
                align: 'stretch',
                vertical: false
            }
        },

        'width < 1000': {
            layout: {
                type: 'box',
                align: 'stretch',
                vertical: true
            }
        }
    },

    items: [
        {
            xtype: 'specialoffer',
            plugins: {
                responsive: true
            },
            height: 338,

            responsiveConfig: {
                'width < 1000': {
                    flex: null
                },

                'width >= 1000': {
                    flex: 1
                }
            }
        },
        {
            xtype: 'profileform',
            cls: 'profileone',
            colorScheme: 'blue',
            flex: 1
        }
    ]
});
