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
	public void testselectHairInfoByNo() {
		Hairinfo h =  new Hairinfo(2);
		Hairinfo temp = hairinfoService.selectHairInfoByNo(h);
		Assert.assertNotNull(temp);
		System.out.println(temp);
	}
	/*
	@Test
	public void testInsertHairInfo(){
		Hairinfo hairinfo = new Hairinfo("물결펌", 15000);
		hairinfoService.insertHairInfo(hairinfo);
		Hairinfo res = hairinfoService.selectHairInfoByName(hairinfo);
		Assert.assertNotNull(res);
		System.out.println(res);
	}*/
	/*
	@Test
	public void testUpdateHairInfo(){
		Hairinfo hairinfo = hairinfoService.selectHairInfoByNo(new Hairinfo(9));
		hairinfo.sethName("단발");
		hairinfoService.updateHairInfo(hairinfo);
		Hairinfo res = hairinfoService.selectHairInfoByNo(new Hairinfo(9));
		Assert.assertNotNull(res);
		System.out.println(res);		
	}
	*//*
	@Test
	public void testDeleteHairInfo(){
		Hairinfo hairinfo = hairinfoService.selectHairInfoByNo(new Hairinfo(9));
		hairinfoService.deleteHairInfo(hairinfo);
		Hairinfo res = hairinfoService.selectHairInfoByNo(new Hairinfo(9));
		Assert.assertNull(res);
	}
	*/
	
	/* Test용 임시 메소드 */
	@Test
	public void testSelectHairInfoByName(){
		Hairinfo temp = hairinfoService.selectHairInfoByNo(new Hairinfo(2));
		Hairinfo res = hairinfoService.selectHairInfoByName(temp);
		Assert.assertNotNull(res);
		System.out.println(res);
	}
	
	
}