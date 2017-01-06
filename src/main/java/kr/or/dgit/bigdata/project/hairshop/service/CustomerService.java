package kr.or.dgit.bigdata.project.hairshop.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import kr.or.dgit.bigdata.project.hairshop.dto.Customer;
import kr.or.dgit.bigdata.project.hairshop.mapper.CustomerMapper;
import kr.or.dgit.bigdata.project.hairshop.util.MyBatisSqlSessionFactory;

public class CustomerService implements CustomerMapper{
	private static final CustomerService instance = new CustomerService();
	
	public static CustomerService getInstance() {
		return instance;
	}
	public CustomerService() {}
	
	private static final Logger logger = Logger.getLogger(CustomerService.class);

	@Override
	public void insertCustomer(Customer item) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
