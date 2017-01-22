package kr.or.dgit.bigdata.project.hairshop.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

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
	
	public void updateManager(Manager manager){
		if (logger.isDebugEnabled()) {
			logger.debug("updateManager(Manager) - start");
		}

		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		ManagerMapper managerMapper = sqlSession.getMapper(ManagerMapper.class);
		try{
			managerMapper.updateManager(manager);
			sqlSession.commit();
			if (logger.isDebugEnabled()) {
				logger.debug("updateManager(Manager) - end");
			}
		}finally{
			sqlSession.close();
		}		
	}
	
	public void insertManager(Manager manager){
		if (logger.isDebugEnabled()) {
			logger.debug("insertManager() - start");
		}

		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		ManagerMapper managerMapper = sqlSession.getMapper(ManagerMapper.class);
		try{
			managerMapper.insertManager(manager);
			sqlSession.commit();
			if (logger.isDebugEnabled()) {
				logger.debug("insertManager() - end");
			}
		}finally{
			sqlSession.close();
		}		
	}
	
	public void deleteManager(Manager manager){
		if (logger.isDebugEnabled()) {
			logger.debug("deleteManager(Manager) - start");
		}

		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		ManagerMapper managerMapper = sqlSession.getMapper(ManagerMapper.class);
		try{
			managerMapper.deleteManager(manager);
			sqlSession.commit();
			if (logger.isDebugEnabled()) {
				logger.debug("deleteManager(Manager) - end");
			}
		}finally{
			sqlSession.close();
		}		
	}
	public List<Manager> selectAllManager(){
		if (logger.isDebugEnabled()) {
			logger.debug("selectAllManager() - start");
		}

		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		ManagerMapper managerMapper = sqlSession.getMapper(ManagerMapper.class);
		try{
			List<Manager> temp = managerMapper.selectAllManager();
			if (logger.isDebugEnabled()) {
				logger.debug("selectAllManager() - end");
			}
			return temp;
		}finally{
			sqlSession.close();
		}		
	}
}
