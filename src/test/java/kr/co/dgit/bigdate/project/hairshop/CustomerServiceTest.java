package kr.co.dgit.bigdate.project.hairshop;

import java.util.List;

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
		customerService = null;
	}
	
	@Test
	public void testselectByAll() {
		List<Customer> list = customerService.selectByAll();
		Assert.assertNotNull(list);
	}
	@Test
	public void testselectByName() {
		Customer customer = new Customer("이유진");
		customer.setcPhone("010-111-1111");
		List<Customer> list = customerService.selectByName(customer);
		Assert.assertNotNull(list);
	}
}
