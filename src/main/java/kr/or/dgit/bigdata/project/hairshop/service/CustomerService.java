package kr.or.dgit.bigdata.project.hairshop.service;

import org.apache.log4j.Logger;

import kr.or.dgit.bigdata.project.hairshop.mapper.CustomerMapper;

public class CustomerService implements CustomerMapper{
	private static final CustomerService instance = new CustomerService();
	
	public static CustomerService getInstance() {
		return instance;
	}
	public CustomerService() {}
	
	private static final Logger logger = Logger.getLogger(CustomerService.class);
	
	

}
