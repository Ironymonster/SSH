package com.ssh.demo.order.entity.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.ssh.demo.order.entity.Order;


/**
 * 封装前端提交查询条件字段
 * 提供查询条件组装的静态方法
 */
public class OrderQueryDTO 
{
	private String orderNumber;
	private Date createTime;
	private Float price;

	public String getOrderNumber() {
		return orderNumber;
	}
	public Date getCreateTime() {
		return createTime;
	}

	public Float getPrice() {
		return price;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public void setPrice(Float price) {
		this.price = price;
	}
	
	 /**
     * 动态生成where语句
     * @param searchArticle
     * @return
     */
    @SuppressWarnings("unused")
	public static Specification<Order> getWhereClause(OrderQueryDTO orderQueryDTO)
    {
		return new Specification<Order>() {
			public Predicate toPredicate(Root<Order> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				 //1.声明Predicate集合
				 List<Predicate> predicate = new ArrayList<>();
				 //2.根据orderQueryDTO查询条件动态添加Predicate
				 if(orderQueryDTO.getOrderNumber()!=null) {
					 predicate.add(cb.like(root.get("orderNumber").as(String.class),"%"+ orderQueryDTO.getOrderNumber()+"%"));
				 }
				 if(orderQueryDTO.getCreateTime()!=null) {
					 predicate.add(cb.greaterThanOrEqualTo(root.get("createTime").as(Date.class), orderQueryDTO.getCreateTime()));
				 }
				 
				 if(orderQueryDTO.getPrice()!=null) {
					 predicate.add(cb.equal(root.get("price").as(Float.class),orderQueryDTO.getPrice()));
				 }

				 //3.根据Predicate集合生成并返回and 连接的 where条件
	             return cb.and(predicate.toArray(new Predicate[predicate.size()]));
			
			}
		};
      
    }
    
//    private Specification<Order> getWhereClause(final OrderQueryDTO orderQueryDTO)
//    {
//		return new Specification<Order>() {
//			public Predicate toPredicate(Root<Order> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
//				 //1.声明Predicate集合
//				 List<Predicate> predicate = new ArrayList<>();
//				 //2.根据orderQueryDTO查询条件动态添加Predicate
//				
//					 Predicate p1 =  cb.like(root.get("orderNumber").as(String.class), orderQueryDTO.getOrderNumber());
//					 
//					 Predicate p2 =  cb.like(root.get("orderNumber").as(String.class), orderQueryDTO.getOrderNumber());
//					 
//					 Predicate p3 =  cb.like(root.get("orderNumber").as(String.class), orderQueryDTO.getOrderNumber());
//			
//				 
//					 cb.and(cb.or(p1,p2),p3);
//			
//			}
//		};
//      
//    }
	

	
}
