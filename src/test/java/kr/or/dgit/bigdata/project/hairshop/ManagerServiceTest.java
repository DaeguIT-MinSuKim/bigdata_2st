package kr.or.dgit.bigdata.project.hairshop;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.bigdata.project.hairshop.dto.Manager;
import kr.or.dgit.bigdata.project.hairshop.service.ManagerService;

public class ManagerServiceTest {
	private static ManagerService managerService;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		managerService = ManagerService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		managerService = null;
	}
/*
	@Test
	public void testselectHairInfoByNo() {
		Manager manager =  new Manager();
		manager.setmName("bigdata");
		Manager temp = managerService.selectmPasswordByName(manager);
		Assert.assertNotNull(temp);
		System.out.println(temp);
	}
	*//*
	@Test
	public void testinsertManager(){
		Manager m = new Manager();
		m.setmName("hairshop");
		m.setmPassword("1234");
		managerService.insertManager(m);
		Manager temp = managerService.selectmPasswordByName(m);
		Assert.assertNotNull(temp);
		System.out.println(temp);
		
	}
	*/
	@Test
	public void testselectAllManager(){
		
		List<Manager> mList = managerService.selectAllManager();
		Assert.assertNotNull(mList);
		for(Manager m:mList){
			System.out.println(m);
		}		
	}
	@Test
	public void testupdateManager(){
		Manager m = new Manager();
		m.setmNo(2);
		m.setmName("hairshop");
		m.setmPassword("1234");
		managerService.updateManager(m);
		Manager temp = managerService.selectmPasswordByName(m);
		Assert.assertNotNull(temp);
		System.out.println(temp);
		
	}
	/*
	@Test
	public void testdeleteManager(){
		Manager m = new Manager();
		m.setmNo(3);
		managerService.deleteManager(m);		
	}
	*/
}