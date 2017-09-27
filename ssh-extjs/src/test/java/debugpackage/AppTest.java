package debugpackage;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ssh.demo.staff.entity.Assets;
import com.ssh.demo.staff.service.IAssetsService;
import com.ssh.demo.util.Type;

@RunWith(MyJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"classpath*:spring/applicationContext-spring.xml",
		"classpath*:spring/applicationContext-springmvc.xml"})
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
				assets.setAssetsType(Type.eProduct);			
			}else if (i%3==0) {
				assets.setAssetsType(Type.oAppliances);				
			}else if (i%5==0){
				assets.setAssetsType(Type.bEquipment);
			}else {
				assets.setAssetsType(Type.transportation);
			}
			assets.setAssetsPrice((Double)Math.random()*10000);			
			assetsService.save(assets);
		}		
	}

}