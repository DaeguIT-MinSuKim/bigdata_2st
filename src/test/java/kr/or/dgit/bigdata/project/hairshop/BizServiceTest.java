package kr.or.dgit.bigdata.project.hairshop;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.bigdata.project.hairshop.dto.Biz;
import kr.or.dgit.bigdata.project.hairshop.service.BizService;

public class BizServiceTest {
	private static BizService bizService;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		bizService = BizService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		bizService = null;
	}

	/*@Test
	public void testSelectBizAndHairInfoEvent() {
		List<Biz> bList = BizService.getInstance().selectBizAndHairInfoEvent();
		Assert.assertNotNull(bList);
		
	}
	
	@Test
	public void testSelectBizAndHairInfoEventByDate() {
		GregorianCalendar cal1 = new GregorianCalendar(2001, 1, 1);
		GregorianCalendar cal2 = new GregorianCalendar(2001, 11, 30);
		
		Biz biz = new Biz();
		Date bDateStart =cal1.getTime();
		Date bDateEnd =cal2.getTime();
		biz.setbDateStart(bDateStart);
		biz.setbDateEnd(bDateEnd);
		
		List<Biz> bList = BizService.getInstance().selectBizAndHairInfoEventByDate(biz);
		Assert.assertNotNull(bList);
		for(Biz b:bList){
			System.out.println(b);
		}
		
	}
	
	@Test
	public void testSelectBizWithDates() {
		
		List<Biz> bList = BizService.getInstance().selectBizWithDates("2000-05-10","2000-05-11");
		Assert.assertNotNull(bList);
		for(Biz b:bList){
			System.out.println(b);
		}
	}*/
	@Test
	public void testSelectCountTotalEachHairBiz() {
		int hairType = BizService.getInstance().selectCountTotalEachHairBiz(1);
		Assert.assertNotNull(hairType);
		System.out.println(hairType);
		
	}
}
/*	@Test
>>>>>>> refs/remotes/origin/JCH3
	public void testSelectFromBizByCustomer() {
		List<Biz> bList = BizService.getInstance().selectFromBizByCustomer(1);
		Assert.assertNotNull(bList);
		for(Biz b:bList){
			System.out.println(b);
		}
	}
	@Test
	public void testSelectAllBiz() {
		List<Biz> bList = BizService.getInstance().selectAllBiz();
		Assert.assertNotNull(bList);
		for(Biz b:bList){
			System.out.println(b);
		}
	}*/
	/* 죽은 메소드
	@Test
	public void testSelectYearOrMonthFromBiz() {
		
		List<Biz> bList = BizService.getInstance().selectYearOrMonthFromBiz("2001-05-10","2001-05-16");
		Assert.assertNotNull(bList);
		for(Biz b:bList){
			System.out.println(b);
		}
	}
<<<<<<< HEAD
=======
		
	@Test
	public void testSelectCountTotalFrombiz() {
		List<Biz> bList = bizService.selectCountTotalFrombiz();
		Assert.assertNotNull(bList);
		
		System.out.println(bList.toString());
		
	}
	
>>>>>>> refs/remotes/origin/JCH3
	
	@Test
	public void testSelectYearOrMonthFromBizCalTotal() {
		HashMap<String, Object> searchMap = new HashMap<>();
		searchMap.put("startDate", "2001-05-01");
		searchMap.put("endDate", "2001-06-01");
		HashMap<String, Object> bList = BizService.getInstance().selectYearOrMonthFromBizCalTotal(searchMap);
		Assert.assertNotNull(bList);
		System.out.println(bList.get("cnt"));
		System.out.println(bList.get("sum"));
	}*/
	/*
	@Test
	public void testSelectCountTotalFrombiz() {
		List<Biz> bList = BizService.getInstance().selectCountTotalFrombiz();
		Assert.assertNotNull(bList);
		
	}
	
	@Test
	public void testSelectCountStyleForGraph() {
		List<Biz> bList = BizService.getInstance().selectCountStyleForGraph();
		Assert.assertNotNull(bList);
		
<<<<<<< HEAD
	}
	*/

	/*@Test
	public void testSelectCountTotalCustomer() {
		int tCus = BizService.getInstance().selectCountTotalCustomer();
		Assert.assertNotNull(tCus);
		System.out.println(tCus);
		
	}
	
	@Test
	public void testSelectCountTotalBiz() {
		int tBiz = BizService.getInstance().selectCountTotalBiz();
		Assert.assertNotNull(tBiz);
		System.out.println(tBiz);
		
	}
	
	@Test
	public void testSelectCountTotalPrice() {
		int tPrice = BizService.getInstance().selectCountTotalPrice();
		Assert.assertNotNull(tPrice);
		System.out.println(tPrice);
		
	}
	
	
	@Test
	public void testSelectCountTotalEachHairBiz() {
		int hairType = BizService.getInstance().selectCountTotalEachHairBiz(1);
		Assert.assertNotNull(hairType);
		System.out.println(hairType);
		
	}

	@Test
	public void testInsertBiz(){
		Biz biz = new Biz();
		Date bDate = new Date();
		biz.setbDate(bDate);
		biz.setbTime(new Time(bDate.getTime()));
		
		Customer bcNo = CustomerService.getInstance().searchCustomerByNo(1);
		HairEvent beNo = HairEventService.getInstance().selectEventByNo(new HairEvent(2));
		Hairinfo bhNo = HairinfoService.getInstance().selectHairInfoByNo(new Hairinfo(2));
		biz.setBhNo(bhNo);
		biz.setBcNo(bcNo);
		biz.setBeNo(beNo);		
		
		BizService.getInstance().insertBiz(biz);
		
	}
<<<<<<< HEAD
	/*
	@Test
	public void testSelectBDateYear() {
		Set<Integer> yList = BizService.getInstance().selectBDateYear();
		Assert.assertNotNull(yList);
		for(int i : yList){
			System.out.println(i);
		}
	}
	@Test
	public void testSelectBizWithYearMonth() {
		HashMap<String, Object> searchMap = new HashMap<>();
		searchMap.put("year", 2001);
		searchMap.put("month", 5);
		List<Biz> bList = BizService.getInstance().selectBizWithYearMonth(searchMap);
		Assert.assertNotNull(bList);
		for(Biz b : bList){
			System.out.println(b);
		}
	}*/

