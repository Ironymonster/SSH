package IAssetServiceTest;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;


import com.ssh.demo.staff.entity.Asset;
import com.ssh.demo.staff.entity.dto.AssetQueryDTO;
import com.ssh.demo.staff.service.IAssetService;
import com.ssh.demo.util.Type;

public class AppTest {
	
	@Before
	public  void initData() 
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml","applicationContext-jpa.xml");
		
		IAssetService assetService = (IAssetService) context.getBean("assetService");
		
		for (int i = 0; i < 100; i++) {
			Asset asset = new Asset();
			asset.setAssetNumber("No."+i);
			asset.setAssetsUsedTime(new Date());
			if(i%2==0) {
				asset.setAssetsType(Type.交通工具);			
			}else if (i%3==0) {
				asset.setAssetsType(Type.办公用具);				
			}else if (i%5==0){
				asset.setAssetsType(Type.基本设备);
			}else {
				asset.setAssetsType(Type.电子产品);
			}
			asset.setAssetsPrice((Double)Math.random()*10000);
			assetService.save(asset);
		}		
	}
	
	@Test
	public  void testFindAllBySpecification() 
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml","applicationContext-jpa.xml");
		
		IAssetService assetService = (IAssetService) context.getBean("assetService");
		
		
		
		AssetQueryDTO queryDto = new AssetQueryDTO();
		queryDto.setAssetsNumber("2");
		queryDto.setAssetsUsedTime(null);
		queryDto.setAssetsPrice(0.0);
		
		int page= 0;
		int size = 30;

		Pageable pageable = new PageRequest(page, size, Direction.DESC,"id");
		Page<Asset> pages = assetService.findAll(AssetQueryDTO.getWhereClause(queryDto), pageable);
		
		
		
		System.out.println("Page Number:"+ pages.getNumber());
		System.out.println("Page Number Of Elements:"+ pages.getNumberOfElements());
		System.out.println("Page Size:"+ pages.getSize());
		System.out.println("Page Total Elements:"+ pages.getTotalElements());
		System.out.println("Page Total Pages:"+ pages.getTotalPages());
		System.out.println("Page Content result:");
		for (Asset o : pages.getContent()) {
			System.out.println(o);
		}
		System.out.println("Page Sort:	"+ pages.getSort());		
	}
}
