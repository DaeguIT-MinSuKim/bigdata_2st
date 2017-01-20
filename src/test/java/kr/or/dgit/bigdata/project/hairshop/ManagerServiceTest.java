package kr.or.dgit.bigdata.project.hairshop;

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
	*/
	@Test
	public void testUpdateManager() {		
		managerService.updateManager("bigdata","rootroot");
		Manager manager = new Manager();
		manager.setmName("bigdata");
		Assert.assertNotNull(managerService.selectmPasswordByName(manager));
		
	}
}