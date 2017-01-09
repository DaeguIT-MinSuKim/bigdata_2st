package kr.or.dgit.bigdata.project.hairshop;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.bigdata.project.hairshop.dto.HairEvent;
import kr.or.dgit.bigdata.project.hairshop.dto.Hairinfo;
import kr.or.dgit.bigdata.project.hairshop.service.HairEventService;
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
}
