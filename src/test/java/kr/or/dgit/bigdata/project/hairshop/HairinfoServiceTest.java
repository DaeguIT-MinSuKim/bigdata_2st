package kr.or.dgit.bigdata.project.hairshop;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.bigdata.project.hairshop.dto.Hairinfo;
import kr.or.dgit.bigdata.project.hairshop.service.HairinfoService;

public class HairinfoServiceTest {
	private static HairinfoService hairinfoService;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		hairinfoService = HairinfoService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		hairinfoService = null;
	}

	@Test
	public void testselectEventAll() {
		List<Hairinfo> hList = hairinfoService.selectHairInfoAll();
		Assert.assertNotNull(hList);
		for(int i=0;i < hList.size();i++){
			System.out.println(hList.get(i).gethPriceForm());
		}
	}
	
	@Test
	public void testSelectHairInfoByName() {
		Hairinfo h = new Hairinfo();
		h.sethName("커트");
		
		List<Hairinfo> hList = hairinfoService.selectHairInfoByName(h);
		Assert.assertNotNull(hList);
		for(int i=0;i < hList.size();i++){
			System.out.println(hList.get(i).gethPriceForm());
		}
	}
<<<<<<< HEAD
}
=======
}
>>>>>>> refs/remotes/origin/hotfix_yujin
