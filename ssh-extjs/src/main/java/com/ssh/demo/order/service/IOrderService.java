package com.ssh.demo.order.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import com.ssh.demo.order.entity.Order;


public interface IOrderService 
{
	public void save(Order entity);
	public void delete(Long[] ids);
	public void delete(Long id);
	
	public Order findOne(Long id);
	public List<Order> findAll();
	
	public	List<Order> findAll(Sort sort);
	public	Page<Order> findAll(Pageable pageable);
	
	public Page<Order> findByOrderNumberLikeAndPrice(String orderNumber,float price,Pageable pageable);
	
	public Page<Order> findByQuery(String orderNumber,float price,Pageable pageable);

	
	public Page<Order> findAll(Specification<Order> spec, Pageable pageable);
	
	
//	<S extends T> S save(S entity);
//	<S extends T> Iterable<S> save(Iterable<S> entities);
//	void delete(ID id);
//	void delete(T entity);
//	void delete(Iterable<? extends T> entities);
//	void deleteAll();
//	T findOne(ID id);
//	Iterable<T> findAll();
//	Iterable<T> findAll(Iterable<ID> ids);
//	boolean exists(ID id);
//	long count();
}
