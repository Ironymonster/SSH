Ext.define('Admin.model.profile.ProfileModel', {
    extend: 'Admin.model.Base',
    fields: [
		{name:'assetsId'		,type: 'int'},
    	{name:'assetsNumber'    ,type: 'string'},
    	{name:'assetsUsedTime'	,type: 'date'},
    	{name:'beginDate'		,type: 'date'},
    	{name:'endDate'			,type: 'date'},
		{name:'assetsName'		,type: 'string'},
		{name:'assetsPrice'		,type: 'float'},
		{name:'highPrice'		,type: 'float'},
		{name:'lowPrice'		,type: 'float'},
		{name:'assetsType'		,type: 'string'}
    ]
});
/*
public static Specification<User> getWhereClause(final UserQueryCondetion condetion){
		return new Specification<User>() {
			@Override
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> pList =  new ArrayList<Predicate>();
				if(condetion.getUserName()!=null && condetion.getUserName().trim().length()>0) {
					Predicate p1 = cb.like(root.get("userName").as(String.class) , "%"+condetion.getUserName()+"%");
					pList.add(p1);
				}
				if(condetion.getPassword()!=null && condetion.getPassword().trim().length()>0) {
					Predicate p2 = cb.like(root.get("password").as(String.class) , "%"+condetion.getPassword()+"%");
					pList.add(p2);
				}
				if(condetion.getStartTime()!=null && condetion.getEndTime()!=null) {
					Predicate p3 = cb.between(root.get("createTime").as(Date.class) , condetion.getStartTime(),condetion.getEndTime());
					pList.add(p3);
				}
				Predicate[] pArray = new Predicate[pList.size()];
				return cb.and(pList.toArray(pArray));
			}
		};
	}
}
	private Integer assetsId;
	private String assetsNumber; //资产编号
	private String assetsName;   //资产名称
	private AssetsType assetsType;//资产类型
	private Double assetsPrice;  //资产估价
	private String assetsState;  //资产状态
	private Date assetsUsedTime; //使用时间
	private UserInfornation user;//外键关联到用户
