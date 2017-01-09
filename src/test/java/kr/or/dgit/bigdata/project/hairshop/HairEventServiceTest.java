package kr.or.dgit.bigdata.project.hairshop;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.bigdata.project.hairshop.dto.HairEvent;
import kr.or.dgit.bigdata.project.hairshop.service.HairEventService;

public class HairEventServiceTest {
	/*FIELDS*/
	private static HairEventService hairEventService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		hairEventService = HairEventService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		hairEventService = null;
	}

	/*METHODS TEST*/
	@Test
	public void testselectEventAll() {
		List<HairEvent> hList = hairEventService.selectEventAll();
		Assert.assertNotNull(hList);
		for(int i=0;i < hList.size();i++){
			System.out.println(hList.get(i).geteDiscountForm());
		}
	}
}
