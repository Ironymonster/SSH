package com.ssh.demo.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.demo.order.dao.IOrderDao;
import com.ssh.demo.order.entity.Order;


@Service
@Transactional
public class OrderService implements IOrderService 
{
	@Autowired
	private IOrderDao orderDao;
	
	public void setOrderDao(IOrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Transactional(readOnly=true)
	public Order findOne(Long id) {
		return orderDao.findOne(id);
	}

	@Transactional(readOnly=true)
	public List<Order> findAll() {
		System.out.println("OrderService findAll method!");
		return (List<Order>) orderDao.findAll();
	}
	
	@Override
	public void save(Order entity) {
		orderDao.save(entity);
	}

	@Override
	public void delete(Long id) {
		orderDao.delete(id);
	}

	@Override
	public void delete(Long[] ids) 
	{
		for (Long id : ids) {
			orderDao.delete(id);
		}
	}
	
	@Override
	public List<Order> findAll(Sort sort) {
		return (List<Order>) orderDao.findAll(sort);
	}

	@Override
	public Page<Order> findAll(Pageable pageable) {
		return orderDao.findAll(pageable);
	}

	@Override
	public Page<Order> findByOrderNumberLikeAndPrice(String orderNumber, float price, Pageable pageable) {
	
		return orderDao.findByOrderNumberLikeAndPrice(orderNumber, price, pageable);
	}

	@Override
	public Page<Order> findByQuery(String orderNumber, float price, Pageable pageable) {
	
		return orderDao.findByQuery(orderNumber, price, pageable);
	}

	@Override
	public Page<Order> findAll(Specification<Order> spec, Pageable pageable) {
		
		return orderDao.findAll(spec, pageable);
	}

}
