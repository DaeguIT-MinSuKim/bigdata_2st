package kr.or.dgit.bigdata.project.hairshop.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import kr.or.dgit.bigdata.project.hairshop.dto.HairEvent;
import kr.or.dgit.bigdata.project.hairshop.mappers.HairEventMapper;
import kr.or.dgit.bigdata.project.hairshop.util.MyBatisSqlSessionFactory;

public class HairEventService {
	/**
	* Logger for this class
	*/
	private static final Logger logger = Logger.getLogger(HairEventService.class);

	/*FIELDS*/
	private static final HairEventService instance = new HairEventService();
	/*GET*/
	public static HairEventService getInstance() {
		return instance;
	}
	/*CONSTRUCTOR*/
	public HairEventService() {
		// TODO Auto-generated constructor stub
	}
	/* METHODS */
	public List<HairEvent> selectEventAll(){
		if (logger.isDebugEnabled()) {
			logger.debug("selectEventAll() - start");
		}

		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		HairEventMapper hairEventMapper = sqlSession.getMapper(HairEventMapper.class);
		try{
			List<HairEvent> elist = hairEventMapper.selectEventAll();

			if (logger.isDebugEnabled()) {
				logger.debug("selectEventAll() - end");
			}
			return elist;
		}finally{
			sqlSession.close();
		}		
	}
	public HairEvent selectEventByNo(HairEvent hairEvent){
		if (logger.isDebugEnabled()) {
			logger.debug("selectEventByNo(HairEvent) - start");
		}

		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		HairEventMapper hairEventMapper = sqlSession.getMapper(HairEventMapper.class);
		try{
			HairEvent temp = hairEventMapper.selectEventByNo(hairEvent);

			if (logger.isDebugEnabled()) {
				logger.debug("selectEventByNo(HairEvent) - end");
			}
			return temp;
		}finally{
			sqlSession.close();
		}		
	}
	
	public void insertEvent(HairEvent hairEvent){
		if (logger.isDebugEnabled()) {
			logger.debug("insertEvent(HairEvent) - start");
		}
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		HairEventMapper hairEventMapper = sqlSession.getMapper(HairEventMapper.class);
		try{
			hairEventMapper.insertEvent(hairEvent);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}		

		if (logger.isDebugEnabled()) {
			logger.debug("insertEvent(HairEvent) - end");
		}
	}
	public void updateEvent(HairEvent hairEvent){
		if (logger.isDebugEnabled()) {
			logger.debug("updateEvent(HairEvent) - start");
		}
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		HairEventMapper hairEventMapper = sqlSession.getMapper(HairEventMapper.class);
		try{
			hairEventMapper.updateEvent(hairEvent);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}		

		if (logger.isDebugEnabled()) {
			logger.debug("updateEvent(HairEvent) - end");
		}
	}
	public void deleteEvent(HairEvent hairEvent){
		if (logger.isDebugEnabled()) {
			logger.debug("deleteEvent(HairEvent) - start");
		}
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		HairEventMapper hairEventMapper = sqlSession.getMapper(HairEventMapper.class);
		try{
			hairEventMapper.deleteEvent(hairEvent);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}		

		if (logger.isDebugEnabled()) {
			logger.debug("deleteEvent(HairEvent) - end");
		}
	}
	
	/* Test 용 임시 메소드 */
	public HairEvent selectEventByName(HairEvent hairEvent){
		if (logger.isDebugEnabled()) {
			logger.debug("selectEventByName(HairEvent) - start");
		}

		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		HairEventMapper hairEventMapper = sqlSession.getMapper(HairEventMapper.class);
		try{
			HairEvent temp = hairEventMapper.selectEventByName(hairEvent);

			if (logger.isDebugEnabled()) {
				logger.debug("selectEventByName(HairEvent) - end");
			}
			return temp;
		}finally{
			sqlSession.close();
		}		
	}
}

