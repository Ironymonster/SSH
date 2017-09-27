package IAssetsServiceTest;

import java.util.Date;
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
			assets.setAssetsName("my assets" + i);
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
	
}
