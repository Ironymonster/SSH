package com.ssh.demo.staff.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="t_user")
public class UserInfornation {

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
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public String getUserId() {
		return userId;
	}
	public String getPassword() {
		return password;
	}
	public String getUserName() {
		return userName;
	}
	public String getSex() {
		return sex;
	}
	public String getMail() {
		return mail;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public String getIdType() {
		return idType;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public Date getBirthday() {
		return birthday;
	}
	public String getNativePlace() {
		return nativePlace;
	}
	public Date getOnDutDate() {
		return onDutDate;
	}
	public String getWechatNumber() {
		return wechatNumber;
	}
	public String getHome() {
		return home;
	}	
	
	public String getRealName() {
		return realName;
	}
	public String getQq_number() {
		return qq_number;
	}
	public String getDept() {
		return dept;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}
	public void setOnDutDate(Date onDutDate) {
		this.onDutDate = onDutDate;
	}
	public void setWechatNumber(String wechatNumber) {
		this.wechatNumber = wechatNumber;
	}
	public void setHome(String home) {
		this.home = home;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public void setQq_number(String qq_number) {
		this.qq_number = qq_number;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
}
