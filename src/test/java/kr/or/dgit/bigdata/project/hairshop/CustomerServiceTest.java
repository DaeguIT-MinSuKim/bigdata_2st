package kr.or.dgit.bigdata.project.hairshop;

import java.util.GregorianCalendar;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.bigdata.project.hairshop.dto.Customer;
import kr.or.dgit.bigdata.project.hairshop.service.CustomerService;

public class CustomerServiceTest {
	private static CustomerService customerService;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		customerService = CustomerService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/*@Test
	public void testInsertCustomer() {
		GregorianCalendar cal1 = new GregorianCalendar(1983, 11, 10);
		GregorianCalendar cal2 = new GregorianCalendar(2017, 1, 6);
		Customer insCtm = new Customer();
		insCtm.setcName("노창균");
		insCtm.setcDob(cal1.getTime());
		insCtm.setcDoJoin(cal2.getTime());
		insCtm.setcPhone("010-654-6547");
		insCtm.setcDel(false);
		

		int res = customerService.insertCustomer(insCtm);
		Assert.assertEquals(1, res);
	}
	@Test
	public void testUdateCustomer() {
		GregorianCalendar cal1 = new GregorianCalendar(1995, 11, 10);
		GregorianCalendar cal2 = new GregorianCalendar(2017, 1, 6);
		Customer insCtm = new Customer();
		insCtm.setcNo(5);
		insCtm.setcName("이유진");
		insCtm.setcDob(cal1.getTime());
		insCtm.setcDoJoin(cal2.getTime());
		insCtm.setcPhone("010-654-6547");
		insCtm.setcDel(false);		

		int res = customerService.updateCustomer(insCtm);
		Assert.assertEquals(1, res);
	}
	@Test
	public void testDelectCustomer() {
		
		int delCustomer =  customerService.deleteCustomer(6);
		Assert.assertSame(1, delCustomer);
	
	}*/
	
	
}
