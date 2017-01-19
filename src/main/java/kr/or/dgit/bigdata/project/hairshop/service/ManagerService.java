package kr.or.dgit.bigdata.project.hairshop.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import kr.or.dgit.bigdata.project.hairshop.dto.Hairinfo;
import kr.or.dgit.bigdata.project.hairshop.dto.Manager;
import kr.or.dgit.bigdata.project.hairshop.mappers.ManagerMapper;
import kr.or.dgit.bigdata.project.hairshop.util.MyBatisSqlSessionFactory;

public class ManagerService {
	/**
	* Logger for this class
	*/
	private static final Logger logger = Logger.getLogger(ManagerService.class);

	/*FIELDS*/
	private static final ManagerService instance = new ManagerService();
	/*GET*/
	public static ManagerService getInstance() {
		return instance;
	}
	/*CONSTRUCTOR*/
	public ManagerService() {
		// TODO Auto-generated constructor stub
	}
	/* METHODS */
	public Manager selectmPasswordByName(Manager manager){
		if (logger.isDebugEnabled()) {
			logger.debug("selectHairInfoByNo(Hairinfo) - start");
		}

		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		ManagerMapper managerMapper = sqlSession.getMapper(ManagerMapper.class);
		try{
			Manager temp = managerMapper.selectmPasswordByName(manager);
			if (logger.isDebugEnabled()) {
				logger.debug("selectHairInfoByNo(Hairinfo) - end");
			}
			return temp;
		}finally{
			sqlSession.close();
		}		
	}
	
	public void updateManager(String mName, String mPassword){
		if (logger.isDebugEnabled()) {
			logger.debug("updateManager(String, String) - start");
		}

		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		ManagerMapper managerMapper = sqlSession.getMapper(ManagerMapper.class);
		try{
			managerMapper.updateManager(mName, mPassword);
			sqlSession.commit();
			if (logger.isDebugEnabled()) {
				logger.debug("updateManager(String, String) - end");
			}
		}finally{
			sqlSession.close();
		}		
	}
}
