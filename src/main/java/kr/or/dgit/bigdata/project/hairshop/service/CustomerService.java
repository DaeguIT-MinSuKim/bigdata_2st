package kr.or.dgit.bigdata.project.hairshop.service;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import kr.or.dgit.bigdata.project.hairshop.dto.Customer;
import kr.or.dgit.bigdata.project.hairshop.mappers.CustomerMapper;
import kr.or.dgit.bigdata.project.hairshop.util.MyBatisSqlSessionFactory;


public class CustomerService{
	private static final CustomerService instance = new CustomerService();
	
	public static CustomerService getInstance() {
		return instance;
	}
	public CustomerService() {}
	
	private static final Logger logger = Logger.getLogger(CustomerService.class);

	public int insertCustomer(Customer customer) {
		if (logger.isDebugEnabled()) {
			logger.debug("insertCustomer(Customer) - start");
		}
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();

		try {
			CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
			int res = customerMapper.insertCustomer(customer);
			sqlSession.commit();
			return res;
		} finally {
			sqlSession.close();
		}
		
	}
	
	public int updateCustomer(Customer customer) {
		if (logger.isDebugEnabled()) {
			logger.debug("updateCustomer(Customer) - start");
		}
		
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
			int res = customerMapper.updateCustomer(customer);
			sqlSession.commit();
			return res;
		} finally {
			sqlSession.close();
		}
		
	}
	
	public int deleteCustomer(int id) {
		if (logger.isDebugEnabled()) {
			logger.debug("deleteCustomer(Customer) - start");
		}
		
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
			int res = customerMapper.deleteCustomer(id);
			sqlSession.commit();
			return res;
		} finally {
			sqlSession.close();
		}
		
	}
	public List<Customer> searchCustomerByName(Map<String, Object> map) {
		if (logger.isDebugEnabled()) {
			logger.debug("searchCustomerByName(Map<String, Object>) - start");
		}
		
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
			return customerMapper.searchCustomerByName(map);
		} finally {
			sqlSession.close();
		}
		
	}
	
	

}
