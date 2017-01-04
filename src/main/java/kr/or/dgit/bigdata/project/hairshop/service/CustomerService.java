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
	
	public void insertItem(Customer item) {
		// TODO Auto-generated method stub
		
	}

	public void deleteItem(Customer idx) {
		// TODO Auto-generated method stub
		
	}

	public void updateItem(Customer item) {
		// TODO Auto-generated method stub
		
	}

	public Customer selectByNo(int idx) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Customer> selectByName(Customer customer) {
		//이름으로 검색하는 메소드 추가했어요. - ver.유진
		if (logger.isDebugEnabled()) {
			logger.debug("selectByName(Customer) - start");
		}
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
		try{
			return customerMapper.selectByName(customer);			
		}finally{
			sqlSession.close();
		}
	}
	
	public List<Customer> selectByAll() {
		logger.debug("selectByAll()");
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		CustomerMapper customerMapper =sqlSession.getMapper(CustomerMapper.class);
		try {
			return customerMapper.selectByAll();
		} finally {
			sqlSession.close();
		}
	}
	

}
