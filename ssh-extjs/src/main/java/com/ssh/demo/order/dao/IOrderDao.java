package com.ssh.demo.order.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import com.ssh.demo.order.entity.Order;




@Component
public interface IOrderDao extends PagingAndSortingRepository<Order,Long> ,JpaSpecificationExecutor<Order>{

	public Page<Order> findByOrderNumberLikeAndPrice(String orderNumber,float price,Pageable pageable);
	
	@Query("from Order o where o.orderNumber like ?1 and o.price = ?2") 
	public Page<Order> findByQuery(String orderNumber,float price,Pageable pageable); 


	
//	JpaSpecificationExecutor<T>  的所有方法
//	T findOne(Specification<T> spec);
//	List<T> findAll(Specification<T> spec);
//	Page<T> findAll(Specification<T> spec, Pageable pageable);
//	List<T> findAll(Specification<T> spec, Sort sort);
//	long count(Specification<T> spec);
}
