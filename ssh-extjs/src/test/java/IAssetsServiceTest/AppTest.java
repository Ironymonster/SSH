package IAssetsServiceTest;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;


import com.ssh.demo.staff.entity.Assets;
import com.ssh.demo.staff.entity.dto.AssetsQueryDTO;
import com.ssh.demo.staff.service.IAssetsService;
import com.ssh.demo.util.Type;

public class AppTest {
	
	@Test
	public  void initData() 
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml","applicationContext-jpa.xml");
		
		IAssetsService assetsService = (IAssetsService) context.getBean("assetsService");
		
		for (int i = 0; i < 100; i++) {
			Assets assets = new Assets();
			assets.setAssetsNumber("No."+i);
			assets.setAssetsUsedTime(new Date());
			if(i%2==0) {
				assets.setAssetsType(Type.交通工具);			
			}else if (i%3==0) {
				assets.setAssetsType(Type.办公用具);				
			}else if (i%5==0){
				assets.setAssetsType(Type.基本设备);
			}else {
				assets.setAssetsType(Type.电子产品);
			}
			assets.setAssetsPrice((Double)Math.random()*10000);
			assetsService.save(assets);
		}		
	}
	
	//@Test
	public  void testFindAllBySpecification() 
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml","applicationContext-jpa.xml");
		
		IAssetsService assetsService = (IAssetsService) context.getBean("assetsService");
						
		AssetsQueryDTO queryDto = new AssetsQueryDTO();
		queryDto.setAssetsNumber("2");
		queryDto.setAssetsUsedTime(null);
		queryDto.setAssetsPrice(0.0);
		
		int page= 0;
		int size = 30;

		Pageable pageable = new PageRequest(page, size, Direction.DESC,"id");
		Page<Assets> pages = assetsService.findAll(AssetsQueryDTO.getWhereClause(queryDto), pageable);
			
		System.out.println("Page Number:"+ pages.getNumber());
		System.out.println("Page Number Of Elements:"+ pages.getNumberOfElements());
		System.out.println("Page Size:"+ pages.getSize());
		System.out.println("Page Total Elements:"+ pages.getTotalElements());
		System.out.println("Page Total Pages:"+ pages.getTotalPages());
		System.out.println("Page Content result:");
		for (Assets o : pages.getContent()) {
			System.out.println(o);
		}
		System.out.println("Page Sort:	"+ pages.getSort());		
	}
}
