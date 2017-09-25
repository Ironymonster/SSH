package IOrderSeviceTest;

import java.util.Date;

import org.hibernate.criterion.MatchMode;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;

import com.ssh.demo.order.entity.Order;
import com.ssh.demo.order.entity.dto.OrderQueryDTO;
import com.ssh.demo.order.service.IOrderService;
import com.ssh.demo.util.Level;


/**
 * Unit test for simple App.
 */
public class AppTest {
	
	@Before
	public  void initData() 
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml","applicationContext-jpa.xml");
		
		IOrderService orderService = (IOrderService) context.getBean("orderService");
		
		for (int i = 0; i < 100; i++) {
			Order order = new Order();
			order.setOrderNumber("No."+i);
			order.setCreateTime(new Date());
			if(i%2==0) {
				order.setLevel(Level.HIGH);				
			}else if (i%3==0) {
				order.setLevel(Level.LOW);				
			}else {
				order.setLevel(Level.MEDIUM);
			}
			order.setPrice((float)Math.random()*10000);
			orderService.save(order);
		}		
	}
	
	
	//@Test
	public  void testFindAll() 
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml","applicationContext-jpa.xml");
		
		IOrderService orderService = (IOrderService) context.getBean("orderService");
		
		int page= 0;
		int size = 30;
		
//		Sort sort = new Sort(Direction.DESC,"id");
//		Pageable pageable = new PageRequest(page, size,sort);
		
		Pageable pageable = new PageRequest(page, size, Direction.DESC,"id");
		Page<Order> pages = orderService.findAll(pageable);
		
		System.out.println("Page Number:"+ pages.getNumber());
		System.out.println("Page Number Of Elements:"+ pages.getNumberOfElements());
		System.out.println("Page Size:"+ pages.getSize());
		System.out.println("Page Total Elements:"+ pages.getTotalElements());
		System.out.println("Page Total Pages:"+ pages.getTotalPages());
		System.out.println("Page Content result:");
		for (Order o : pages.getContent()) {
			System.out.println(o);
		}
		System.out.println("Page Sort:	"+ pages.getSort());
	
		
	}
	
	
	//@Test
	public  void testFindByQuery1() 
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml","applicationContext-jpa.xml");
		
		IOrderService orderService = (IOrderService) context.getBean("orderService");
		
		int page= 0;
		int size = 30;
		
//		Sort sort = new Sort(Direction.DESC,"id");
//		Pageable pageable = new PageRequest(page, size,sort);
		
		Pageable pageable = new PageRequest(page, size, Direction.DESC,"id");
		Page<Order> pages = orderService.findByQuery("%1%",0,pageable);
		
		System.out.println("Page Number:"+ pages.getNumber());
		System.out.println("Page Number Of Elements:"+ pages.getNumberOfElements());
		System.out.println("Page Size:"+ pages.getSize());
		System.out.println("Page Total Elements:"+ pages.getTotalElements());
		System.out.println("Page Total Pages:"+ pages.getTotalPages());
		System.out.println("Page Content result:");
		for (Order o : pages.getContent()) {
			System.out.println(o);
		}
		System.out.println("Page Sort:	"+ pages.getSort());
	
		
	}
	
	//@Test
	public  void testFindByOrderNumberLikeAndPrice() 
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml","applicationContext-jpa.xml");
		
		IOrderService orderService = (IOrderService) context.getBean("orderService");
		
		int page= 0;
		int size = 30;
		
//		Sort sort = new Sort(Direction.DESC,"id");
//		Pageable pageable = new PageRequest(page, size,sort);
		
		Pageable pageable = new PageRequest(page, size, Direction.DESC,"id");
		Page<Order> pages = orderService.findByOrderNumberLikeAndPrice("%1%",0,pageable);
		
		System.out.println("Page Number:"+ pages.getNumber());
		System.out.println("Page Number Of Elements:"+ pages.getNumberOfElements());
		System.out.println("Page Size:"+ pages.getSize());
		System.out.println("Page Total Elements:"+ pages.getTotalElements());
		System.out.println("Page Total Pages:"+ pages.getTotalPages());
		System.out.println("Page Content result:");
		for (Order o : pages.getContent()) {
			System.out.println(o);
		}
		System.out.println("Page Sort:	"+ pages.getSort());
	
		
	}
	
	@Test
	public  void testFindAllBySpecification() 
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml","applicationContext-jpa.xml");
		
		IOrderService orderService = (IOrderService) context.getBean("orderService");
		
		
		
		OrderQueryDTO queryDto = new OrderQueryDTO();
		queryDto.setOrderNumber("2");
		queryDto.setCreateTime(null);
		queryDto.setPrice(0f);
		
		int page= 0;
		int size = 30;

		Pageable pageable = new PageRequest(page, size, Direction.DESC,"id");
		Page<Order> pages = orderService.findAll(OrderQueryDTO.getWhereClause(queryDto), pageable);
		
		
		
		System.out.println("Page Number:"+ pages.getNumber());
		System.out.println("Page Number Of Elements:"+ pages.getNumberOfElements());
		System.out.println("Page Size:"+ pages.getSize());
		System.out.println("Page Total Elements:"+ pages.getTotalElements());
		System.out.println("Page Total Pages:"+ pages.getTotalPages());
		System.out.println("Page Content result:");
		for (Order o : pages.getContent()) {
			System.out.println(o);
		}
		System.out.println("Page Sort:	"+ pages.getSort());		
	}
}
