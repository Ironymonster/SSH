package com.ssh.demo.order.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ssh.demo.util.enums.Level;

/**
 * Entity层：
 * 		声明领域模型对象的字段。
 * 		私有的属性、公共的getter和setter
 * @author Sailer Wen
 *
 */
@Entity
@Table(name="t_order")
public class Order 
{
	private Long id;
	private String orderNumber;
	private Date createTime;
	private Level level;
	private Float price;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss",timezone = "GMT+8")
	public Date getCreateTime() {
		return createTime;
	}	
	
	@Enumerated(EnumType.STRING)
	public Level getLevel() {
		return level;
	}
	public Float getPrice() {
		return price;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public void setLevel(Level level) {
		this.level = level;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", orderNumber=" + orderNumber + ", createTime=" + createTime + ", level=" + level
				+ ", price=" + price + "]";
	}

	
}
