package debugpackage;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.demo.staff.entity.Assets;
import com.ssh.demo.staff.entity.dto.AssetsDTO;
import com.ssh.demo.staff.service.IAssetsService;
import com.ssh.demo.util.enums.AssetsType;
import com.sun.org.apache.xpath.internal.functions.FuncFalse;

@RunWith(MyJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"classpath*:applicationContext.xml",
		"classpath*:applicationContext-jpa.xml"})
@Transactional
//@TransactionConfiguration(transactionManager="transactionManager",defaultRollback=false)
public class AppTest {
	
	@Autowired
	private IAssetsService assetsService;
	

//	@Test
//	public void roleTest() {
//		int page = 0;
//		int size = 25;
//		Pageable pageable = new PageRequest(page, size);
//		Page<AssetsDTO> pages = assetsService.findAll(pageable);
//		
//		System.out.println("当前页码：" + pages.getNumber());
//		System.out.println("当前页面的记录数：" + pages.getNumberOfElements());
//		System.out.println("总页数：" + pages.getTotalPages());
//		System.out.println("总记录数：" + pages.getTotalElements());
//		System.out.println("每页记录数：" + pages.getSize());		
//	}
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@Rollback(true)
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