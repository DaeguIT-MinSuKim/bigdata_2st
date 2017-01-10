package kr.or.dgit.bigdata.project.hairshop;

import java.sql.Time;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.bigdata.project.hairshop.dto.Biz;
import kr.or.dgit.bigdata.project.hairshop.dto.Customer;
import kr.or.dgit.bigdata.project.hairshop.dto.HairEvent;
import kr.or.dgit.bigdata.project.hairshop.dto.Hairinfo;
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

	@Test
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
	}
	
	
	@Test
	public void testSelectYearOrMonthAllFromBiz() {
		List<Biz> bList = BizService.getInstance().selectYearOrMonthAllFromBiz();
		Assert.assertNotNull(bList);
		
	}
	
	@Test
	public void testSelectCountTotalFrombiz() {
		List<Biz> bList = BizService.getInstance().selectCountTotalFrombiz();
		Assert.assertNotNull(bList);
		
	}
	
	@Test
	public void testSelectCountStyleForGraph() {
		List<Biz> bList = BizService.getInstance().selectCountStyleForGraph();
		Assert.assertNotNull(bList);
		
	}
	public void testInsertBiz() {
		
		GregorianCalendar cal2 = new GregorianCalendar(2017, 1, 6);
		Time t = new Time(9, 9, 9);
				
		Biz biz = new Biz();
		
		biz.setbDate(cal2.getTime());
		biz.setbTime(t);
		Customer c = new Customer();
		c.setcNo(3);
		Hairinfo hi = new Hairinfo();
		hi.sethNo(3);
		HairEvent he = new HairEvent();
		he.seteNo(3);
		
		biz.setcNo(c);
		System.out.println(biz.getcNo());
		biz.sethNO(hi);		
		biz.seteNo(he);
		
/*
		int res = bizService.insertBiz(biz);
		Assert.assertEquals(1, res);*/
	}
	
}