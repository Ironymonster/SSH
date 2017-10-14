package debugpackage;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	
	@Transactional
	@Rollback(true)
	@Test
	public void AssetsTest() {
			
		int page = 0;
		int size = 25;
		Pageable pageable = new PageRequest(page, size);			
		AssetsDTO assetsDTO = new AssetsDTO();
//			String assetsName = "my assets10";
//			String assetsNumber = "No.20";
		Double lowPrice = 5000.0;
		Double highPrice = 6000.0;
//			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");// HH:mm:ss
//			Date assetsUsedTime = df.parse("2017-10-09");			
//			Date beginDate;
//			beginDate = df.parse("2017-10-09 19:27:56");
//			Date endDate = df.parse("2017-10-09 19:27:57");
//			assetsDTO.setAssetsName(assetsName);
//			assetsDTO.setBeginDate(beginDate);
//			assetsDTO.setEndDate(endDate);
//			assetsDTO.setAssetsUsedTime(assetsUsedTime);
//			assetsDTO.setAssetsNumber(assetsNumber);
		assetsDTO.setLowPrice(lowPrice);
		assetsDTO.setHighPrice(highPrice);
		
		Page<AssetsDTO> pages = assetsService.findAll(AssetsDTO.getWhereClause(assetsDTO), pageable);
//			System.out.println("资产名称：" + assetsName);
//			System.out.println("资产编号：" + assetsNumber);
//			System.out.println("使用时间：" + assetsUsedTime);
		System.out.println("总记录数：" + pages.getTotalElements());
		
		
	}
}