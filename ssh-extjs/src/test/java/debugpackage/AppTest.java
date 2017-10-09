package debugpackage;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import com.ssh.demo.staff.entity.Assets;
import com.ssh.demo.staff.service.IAssetsService;
import com.ssh.demo.util.enums.AssetsType;

@RunWith(MyJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"classpath*:spring/applicationContext-spring.xml",
		"classpath*:spring/applicationContext-springmvc.xml"})

public class AppTest {
	
	@Autowired
	private IAssetsService assetsService;
	
	@Test
	public  void initData() 
	{				
		for (int i = 0; i < 100; i++) {
			Assets assets = new Assets();
			assets.setAssetsNumber("No."+i);
			assets.setAssetsName("my assets" + i);
			assets.setAssetsUsedTime(new Date());
			if(i%2==0) {
				assets.setAssetsType(AssetsType.eProduct);			
			}else if (i%3==0) {
				assets.setAssetsType(AssetsType.oAppliances);				
			}else if (i%5==0){
				assets.setAssetsType(AssetsType.bEquipment);
			}else {
				assets.setAssetsType(AssetsType.transportation);
			}
			assets.setAssetsPrice((Double)Math.random()*10000);				
			assetsService.save(assets);
		}		
	}
}