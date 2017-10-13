Ext.define('Admin.model.wizard.WizardModel', {
    extend: 'Admin.model.Base',
    fields: [
		{name:'userId'		,type: 'int'},
    	{name:'userName'    ,type: 'string'},
    	{name:'password'	,type: 'string'},
    	{name:'sex'			,type: 'string'},
    	{name:'mail'		,type: 'string'},
    	{name:'mobilePhone'	,type: 'string'},
    	{name:'idType'		,type: 'string'},
		{name:'idNumber'	,type: 'string'},
    	{name:'birthday'	,type: 'date'},
    	{name:'nativePlace'	,type: 'string'},
    	{name:'onDutDate'	,type: 'date'},
    	{name:'wechatNumber',type: 'string'},
    	{name:'home'		,type: 'string'},
		{name:'realName'	,type: 'string'},
		{name:'qq_number'	,type: 'string'},
		{name:'dept'		,type: 'string'}
    ]
});
/*

	private String userId;			//Id
	private String userName;		//昵称
	private String password;		//密码
	private String sex;				//性别
	private String mail;			//邮箱
	private String mobilePhone;		//电话号码
	private String idType;			//身份证类型
	private String idNumber;		//身份证号码
	private Date birthday;			//生日
	private String nativePlace;		//籍贯
	private Date onDutDate;			//入职时间
	private String wechatNumber;	//微信号码
	private String home;			//家庭住址
	private String realName;		//真实姓名
	private String qq_number;		//QQ号码
	private String dept;			//部门

