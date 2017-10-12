Ext.define('Admin.view.forms.WizardForm',
        {
            extend:'Ext.panel.Panel',
            xtype:'wizardform',
            requires: [
                'Ext.button.Button',
                'Ext.form.field.Text',
                'Ext.form.field.File',
                'Ext.form.field.HtmlEditor',
                'Ext.form.field.TextArea',
                'Ext.form.field.Time',
                'Ext.form.field.ComboBox',
                'Ext.form.field.Date',
                'Ext.form.field.Radio',
                'Ext.form.field.Hidden'],

            bodyPadding:15,
            height:340,
            layout:'card',
            viewModel:{type:'wizardform'},
            controller:'wizardform',
            defaults:{
                defaultFocus:'textfield:not([value]):focusable:not([disabled])',
                defaultButton:'nextbutton'},
                items:[
                {
                    xtype:'form',
                    defaultType:'textfield',
                    defaults:{
                    labelWidth:90,
                    labelAlign:'left',
                    labelSeparator:'',
                    submitEmptyText:false,
                    anchor:'90%'},

                items:[
                {
                    fieldLabel: '手机号码  ',
                    emptyText : 'Username must be unique.',
                    name:'staffNumber'
                },

                {
                    fieldLabel: '邮箱',
                    emptyText:'ex: me@somewhere.com',
                    vtype:'email',
                    name:'mail'
                },
                {
                    fieldLabel: '更改密码   ',
                    emptyText:'Enter a password',
                    inputType:'password',
                    cls:'wizard-form-break'},
                {
                    fieldLabel: '再输入一次',
                    emptyText:'Passwords must match',
                    inputType:'password'}]},
                {
                    xtype:'form',
                    defaultType:'textfield',
                    defaults:{
                        labelWidth:90,
                        labelAlign:'left',
                        labelSeparator:'',
                        submitEmptyText:false,
                        anchor:'90%'},
                items:[
                {
                    fieldLabel: '名字',
                    emptyText:'Name',
                    name :'staffName'},
                {
                    xtype: 'datefield',
                    format: 'Y/m/d H:i:s',
                    fieldLabel: '生日',
                    name:'createTime'
                },
                {
                    xtype: 'datefield',
                    format: 'Y/m/d H:i:s',
                    fieldLabel: '入职时间',
                    name:'createTime'
                },
                {
                    xtype:'fieldcontainer',
                    cls:'wizard-form-break',
                    fieldLabel:'性别',
                    defaultType:'radiofield',
                    defaults:{flex:1},
                    layout:'hbox',

                items:[
                {
                    boxLabel:'男',
                    name:'SexType',
                    inputValue:'Free'
                },
                {
                    boxLabel:'女',
                    name:'SexType',
                    inputValue:'Perosnal'
                },
            ]}]},
                {
                    xtype:'form',
                    defaultType:'textfield',
                    defaults:{labelWidth:90,
                    labelAlign:'left',
                    labelSeparator:'',
                    submitEmptyText:false,
                    anchor:'90%'},

            items:[

                {
                    fieldLabel:'家庭住址',
                    emptyText:'Address'
                },
                {
                    fieldLabel:'籍贯',
                    emptyText:'City'
                },
                {
                    xtype: 'combobox',
                    fieldLabel: '身份证类型',
                    name:'idType',
                    store:  Ext.create('Ext.data.Store', {
                        fields: ['value', 'name'],
                        data : [
                            {"value":"HIGH",    "name":"大陆"},
                            {"value":"MEDIUM",  "name":"港澳"},
                            {"value":"LOW",     "name":"国外"}
                                ]
                    }),
                    queryMode:    'local',
                    displayField: 'name',
                    valueField:   'value'
                },
                {
                    fieldLabel: '身份证号码',
                }
                ]},
                 {
                    xtype:'form',
                    defaultType:'textareafield',
                    defaults:{
                    labelWidth:90,
                    height:'80%',
                    labelAlign:'top',
                    labelSeparator:'',
                    anchor:'90%'},

                    items:[{

                        fieldLabel:'ABout me',

                    }]
                 }],
                    initComponent:function() {
                    this.tbar = {
                            reference:'progress',
                            defaultButtonUI:'wizard-' + this.colorScheme,
                            cls:'wizardprogressbar',
                            defaults:{disabled:true, iconAlign:'top'},
                            layout:{pack:'center'},
                            items:[
                                {
                                    step:0, iconCls:'fa fa-info',
                                    pressed:true, enableToggle:true,
                                    text:'Account'
                                },
                                {
                                    step:1, iconCls:'fa fa-user',
                                    enableToggle:true, text:'Profile'
                                },
                                {
                                    step:2, iconCls:'fa fa-home',
                                    enableToggle:true, text:'Address'
                                },
                                {
                                    step:3, iconCls:'fa fa-heart',
                                    enableToggle:true, text:'Message'
                                }
                            ]};
                    this.bbar =
                        {
                            reference:'navigation-toolbar',
                            margin:8,
                            items:['->',
                                    {
                                        text:'Previous',
                                        ui:this.colorScheme,
                                        formBind:true,
                                        bind:{
                                            disabled:'{atBeginning}'},
                                        listeners:{click:'onPreviousClick'}
                                    },
                                    '|',
                                    {
                                        text:'Next',
                                        ui:this.colorScheme,
                                        formBind:true,
                                        reference:'nextbutton',
                                        bind:{
                                            disabled:'{atEnd}'},
                                    listeners:{click:'onNextClick'}
                                    },
                                    '|',
                                    {
                                    xtype: 'button',
                                    ui:this.colorScheme,
                                    text: '提交',
                                    handler: 'saveClick'
                                    }
                                    ]};
                                this.callParent();
                            },

                  });