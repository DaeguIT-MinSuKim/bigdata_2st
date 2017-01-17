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
	@Test
	public void testselectEventByNo() {
		HairEvent h = new HairEvent(2);
		HairEvent temp = hairEventService.selectEventByNo(h);
		Assert.assertNotNull(temp);
		System.out.println(temp);
	}
	
	/*
	@Test
	public void testInsertEvent(){
		HairEvent h = new HairEvent("방문", 0.1);
		hairEventService.insertEvent(h);
		HairEvent res = hairEventService.selectEventByName(h);
		Assert.assertNotNull(res);
		System.out.println(res);

	}
	*/
	/*
	@Test
	public void testUpdateEvent(){
		HairEvent h = hairEventService.selectEventByNo(new HairEvent(5));
		h.seteName("마일리지");
		h.seteDiscount(0.5);
		hairEventService.updateEvent(h);
		HairEvent res = hairEventService.selectEventByNo(new HairEvent(5));
		Assert.assertNotNull(res);
		System.out.println(res);
	}*/
	/*
	@Test
	public void testDeleteEvent(){
		HairEvent h = hairEventService.selectEventByNo(new HairEvent(5));
		hairEventService.deleteEvent(h);
		HairEvent res = hairEventService.selectEventByNo(new HairEvent(5));
		Assert.assertNull(res);
	}*/
	
	/* Test 용 임시 메소드 */
	@Test
	public void testSelectEventByName(){
		HairEvent temp = hairEventService.selectEventByNo(new HairEvent(2));
		HairEvent res = hairEventService.selectEventByName(temp);
		Assert.assertNotNull(res);
		System.out.println(res);
	}
}
