package debugpackage;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ssh.demo.staff.entity.Assets;
import com.ssh.demo.staff.entity.UserInfornation;
import com.ssh.demo.staff.service.IAssetsService;
import com.ssh.demo.util.enums.Type;



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

		Assets assets1 = new Assets();
		assets1.setAssetsName("phone");
		
		Assets assets2 = new Assets();
		assets2.setAssetsName("computer");
		
		UserInfornation u1 = new UserInfornation();
		u1.setUserName("LiSA");
		
		assetsService.save(assets1);
		assetsService.save(assets2);
		
		
		
				
//		for (int i = 0; i < 100; i++) {
//			Assets assets1 = new Assets();
//			assets1.setAssetsNumber("No."+i);
//			assets1.setAssetsName("my assets" + i);
//			assets1.setAssetsUsedTime(new Date());
//			if(i%2==0) {
//				assets1.setAssetsType(Type.eProduct);			
//			}else if (i%3==0) {
//				assets1.setAssetsType(Type.oAppliances);				
//			}else if (i%5==0){
//				assets1.setAssetsType(Type.bEquipment);
//			}else {
//				assets1.setAssetsType(Type.transportation);
//			}
//			assets1.setAssetsPrice((Double)Math.random()*10000);	
//			
//			assetsService.save(assets1);
//		}		
	}

}