package com.ssh.demo.staff.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ssh.demo.util.Type;

@Entity
@Table(name="t_assets")
public class Assets {

	private Integer assetsId;
	private String assetsNumber;
	private String assetsName;
	private Type assetsType;
	private Double assetsPrice;
	private String assetsState;
	private Date assetsUsedTime;
	private UserInfornation user;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getAssetsId() {
		return assetsId;
	}
	public String getAssetsName() {
		return assetsName;
	}
	public Type getAssetsType() {
		return assetsType;
	}
	public Double getAssetsPrice() {
		return assetsPrice;
	}
	public String getAssetsState() {
		return assetsState;
	}
	@ManyToOne
	public UserInfornation getUser() {
		return user;
	}	
	
	public String getAssetsNumber() {
		return assetsNumber;
	}
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss",timezone = "GMT+8")
	public Date getAssetsUsedTime() {
		return assetsUsedTime;
	}
	
	public void setAssetsId(Integer assetsId) {
		this.assetsId = assetsId;
	}
	public void setAssetsName(String assetsName) {
		this.assetsName = assetsName;
	}
	public void setAssetsType(Type assetsType) {
		this.assetsType = assetsType;
	}
	public void setAssetsPrice(Double assetsPrice) {
		this.assetsPrice = assetsPrice;
	}
	public void setAssetsState(String assetsState) {
		this.assetsState = assetsState;
	}
	public void setUser(UserInfornation user) {
		this.user = user;
	}			
	public void setAssetsNumber(String assetsNumber) {
		this.assetsNumber = assetsNumber;
	}
	public void setAssetsUsedTime(Date assetsUsedTime) {
		this.assetsUsedTime = assetsUsedTime;
	}
	@Override
	public String toString() {
		return "Asset [assetsId=" + assetsId + ", assetsNumber=" + assetsNumber + ", assetsName=" + assetsName
				+ ", assetsType=" + assetsType + ", assetsPrice=" + assetsPrice + ", assetsState=" + assetsState
				+ ", assetsUsedTime=" + assetsUsedTime + ", user=" + user + "]";
	}
	
	
}