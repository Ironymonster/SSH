package debugpackage;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.demo.staff.entity.Assets;
import com.ssh.demo.staff.service.IAssetsService;
import com.ssh.demo.util.enums.Type;

@SuppressWarnings("deprecation")
@RunWith(MyJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"classpath*:spring/applicationContext-spring.xml",
		"classpath*:spring/applicationContext-springmvc.xml"})
@TransactionConfiguration(defaultRollback=false)
@Transactional

public class AppTest extends AbstractTransactionalJUnit4SpringContextTests{
	
	@Autowired
	private IAssetsService assetsService;
	
	@Test
	public  void initData() 
	{				
		for (int i = 0; i < 100; i++) {
			Assets assets1 = new Assets();
			assets1.setAssetsNumber("No."+i);
			assets1.setAssetsName("my assets" + i);
			assets1.setAssetsUsedTime(new Date());
			if(i%2==0) {
				assets1.setAssetsType(Type.eProduct);			
			}else if (i%3==0) {
				assets1.setAssetsType(Type.oAppliances);				
			}else if (i%5==0){
				assets1.setAssetsType(Type.bEquipment);
			}else {
				assets1.setAssetsType(Type.transportation);
			}
			assets1.setAssetsPrice((Double)Math.random()*10000);	
			
			assetsService.save(assets1);
		}		
	}

}