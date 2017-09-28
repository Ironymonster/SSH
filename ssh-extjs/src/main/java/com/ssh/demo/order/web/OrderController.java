package com.ssh.demo.order.web;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.demo.order.entity.Order;
import com.ssh.demo.order.service.IOrderService;
import com.ssh.demo.util.web.ExtjsAjaxResult;
import com.ssh.demo.util.web.ExtjsPageable;


@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	public IOrderService orderService;
	
	//返回所有的数据
	@RequestMapping("/findAll")
	public @ResponseBody List<Order> findAll(){
		return orderService.findAll();
	}
	
	//  显示数据    /order/findPage?page=0&size=25
	@RequestMapping("/findPage")
	public @ResponseBody Page<Order> findAll(ExtjsPageable pageable)
	{
		return orderService.findAll(pageable.getPageable());
	}
	
	//修改或更新数据
	@PostMapping("/saveOrUpdate")
	public  @ResponseBody ExtjsAjaxResult saveOrUpdate(Order order) {
		try {
			orderService.save(order);
			return new ExtjsAjaxResult(true ,"success! ");
		} catch (Exception e) {
			e.printStackTrace();
			return new ExtjsAjaxResult(false,"false! ");
		}
	}
	
	//删除数据
	@PostMapping("/delete")
	public @ResponseBody ExtjsAjaxResult delete(Long[] ids)
	{
		try {
					orderService.delete(ids);
					return new ExtjsAjaxResult(true,"success! ");
		} catch (Exception e) {
			e.printStackTrace();
			return new  ExtjsAjaxResult(false,"false! ");
		}	
	}
}
