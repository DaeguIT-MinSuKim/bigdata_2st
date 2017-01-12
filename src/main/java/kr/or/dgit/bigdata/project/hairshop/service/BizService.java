package kr.or.dgit.bigdata.project.hairshop.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import kr.or.dgit.bigdata.project.hairshop.dto.Biz;
import kr.or.dgit.bigdata.project.hairshop.dto.Customer;
import kr.or.dgit.bigdata.project.hairshop.mappers.BizMapper;
import kr.or.dgit.bigdata.project.hairshop.util.MyBatisSqlSessionFactory;

public class BizService {
	/**
	* Logger for this class
	*/
	private static final Logger logger = Logger.getLogger(BizService.class);

	/*FIELDS*/
	private static final BizService instance = new BizService();

	private static final String String = null;
	/*GET*/
	public static BizService getInstance() {
		return instance;
	}
	/*CONSTRUCTOR*/
	public BizService() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Biz> selectBizAndHairInfoEvent() {
		if (logger.isDebugEnabled()) {
			logger.debug("selectBizAndHairInfoEvent() - start");
		}
		
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			BizMapper bizMapper = sqlSession.getMapper(BizMapper.class);
			return bizMapper.selectBizAndHairInfoEvent();
		} finally {
			sqlSession.close();
		}
		
	}
	
	public List<Biz> selectBizAndHairInfoEventByDate(Biz biz) {
		if (logger.isDebugEnabled()) {
			logger.debug("selectBizAndHairInfoEventByDate(Biz) - start");
		}
		
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			BizMapper bizMapper = sqlSession.getMapper(BizMapper.class);
			return bizMapper.selectBizAndHairInfoEventByDate(biz);
		} finally {
			sqlSession.close();
		}
		
	}
	
	public List<Biz> selectAllBiz() {
		if (logger.isDebugEnabled()) {
			logger.debug("selectAllBiz() - start");
		}
		
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			BizMapper bizMapper = sqlSession.getMapper(BizMapper.class);
			return bizMapper.selectAllBiz();
		} finally {
			sqlSession.close();
		}		
	}
	public List<Biz> selectFromBizByCustomer(int cNo) {
		if (logger.isDebugEnabled()) {
			logger.debug("selectFromBizByCustomer(int) - start");
		}
		
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			BizMapper bizMapper = sqlSession.getMapper(BizMapper.class);
			return bizMapper.selectFromBizByCustomer(cNo);
		} finally {
			sqlSession.close();
		}		
	}
	public List<Biz> selectYearOrMonthFromBiz(String startDate, String endDate) {
		if (logger.isDebugEnabled()) {
			logger.debug("selectYearOrMonthFromBiz() - start");
		}
		
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			BizMapper bizMapper = sqlSession.getMapper(BizMapper.class);
			return bizMapper.selectYearOrMonthFromBiz(startDate, endDate);
		} finally {
			sqlSession.close();
		}		
	}	
	
	public HashMap<String, Object> selectYearOrMonthFromBizCalTotal(String startDate, String endDate) {
		if (logger.isDebugEnabled()) {
			logger.debug("selectYearOrMonthFromBizCalTotal() - start");
		}
		
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			BizMapper bizMapper = sqlSession.getMapper(BizMapper.class);
			return bizMapper.selectYearOrMonthFromBizCalTotal(startDate, endDate);
		} finally {
			sqlSession.close();
		}		
	}
	
	public List<Biz> selectYearOrMonthAllFromBiz(String startDate, String endDate) {
		if (logger.isDebugEnabled()) {
			logger.debug("selectYearOrMonthAllFromBiz() - start");
		}
		
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			BizMapper bizMapper = sqlSession.getMapper(BizMapper.class);
			return bizMapper.selectYearOrMonthAllFromBiz(startDate, endDate);
		} finally {
			sqlSession.close();
		}
		
	}
	
	public List<Biz> selectCountTotalFrombiz() {
		if (logger.isDebugEnabled()) {
			logger.debug("selectCountTotalFrombiz() - start");
		}
		
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			BizMapper bizMapper = sqlSession.getMapper(BizMapper.class);
			return bizMapper.selectCountTotalFrombiz();
		} finally {
			sqlSession.close();
		}
		
	}
	
	public List<Biz> selectCountStyleForGraph() {
		if (logger.isDebugEnabled()) {
			logger.debug("selectCountStyleForGraph() - start");
		}
		
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			BizMapper bizMapper = sqlSession.getMapper(BizMapper.class);
			return bizMapper.selectCountStyleForGraph();
		} finally {
			sqlSession.close();
		}	
	}
	
	public void insertBiz(Biz biz){
		if (logger.isDebugEnabled()) {
			logger.debug("insertBiz(Biz) - start");
		}
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			BizMapper bizMapper = sqlSession.getMapper(BizMapper.class);
			bizMapper.insertBiz(biz);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}	
		if (logger.isDebugEnabled()) {
			logger.debug("insertBiz(Biz) - end");
		}
	}
}