package kr.or.dgit.bigdata.project.hairshop.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import kr.or.dgit.bigdata.project.hairshop.dto.Hairinfo;
import kr.or.dgit.bigdata.project.hairshop.mapper.HairinfoMapper;
import kr.or.dgit.bigdata.project.hairshop.util.MyBatisSqlSessionFactory;

public class HairinfoService {
	/**
	* Logger for this class
	*/
	private static final Logger logger = Logger.getLogger(HairinfoService.class);

	/*FIELDS*/
	private static final HairinfoService instance = new HairinfoService();
	/*GET*/
	public static HairinfoService getInstance() {
		return instance;
	}
	/*CONSTRUCTOR*/
	public HairinfoService() {
		// TODO Auto-generated constructor stub
	}
	/* METHODS */
	public List<Hairinfo> selectHairInfoAll(){
		if (logger.isDebugEnabled()) {
			logger.debug("selectHairInfoAll() - start");
		}

		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		HairinfoMapper hairinfoMapper = sqlSession.getMapper(HairinfoMapper.class);
		try{
			List<Hairinfo> hlist = hairinfoMapper.selectHairInfoAll();

			if (logger.isDebugEnabled()) {
				logger.debug("selectHairInfoAll() - end");
			}
			return hlist;
		}finally{
			sqlSession.close();
		}		
	}
	
	// 지금 단계에서는 필요하진 않지만 횩시 몰라서 추가했어요. 아직 테스트는 안해봤으니 이 기능들이 들어간다면 테스트 부터 하고 적용시켜야 할 것 같습니다. by 이유진
	public void insertHairInfo(Hairinfo hairinfo){
		if (logger.isDebugEnabled()) {
			logger.debug("insertHairInfo(hairinfo) - start");
		}
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		HairinfoMapper hairinfoMapper = sqlSession.getMapper(HairinfoMapper.class);
		try{
			hairinfoMapper.insertHairInfo(hairinfo);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}		

		if (logger.isDebugEnabled()) {
			logger.debug("insertHairInfo(hairinfo) - end");
		}
	}
	public void updateHairInfo(Hairinfo hairinfo){
		if (logger.isDebugEnabled()) {
			logger.debug("updateHairInfo(Hairinfo) - start");
		}
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		HairinfoMapper hairinfoMapper = sqlSession.getMapper(HairinfoMapper.class);
		try{
			hairinfoMapper.updateHairInfo(hairinfo);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}		

		if (logger.isDebugEnabled()) {
			logger.debug("updateHairInfo(Hairinfo) - end");
		}
	}
	public void deleteHairInfo(Hairinfo hairinfo){
		if (logger.isDebugEnabled()) {
			logger.debug("deleteEvent(Hairinfo) - start");
		}
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		HairinfoMapper hairinfoMapper = sqlSession.getMapper(HairinfoMapper.class);
		try{
			hairinfoMapper.deleteHairInfo(hairinfo);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}		

		if (logger.isDebugEnabled()) {
			logger.debug("deleteHairInfo(hairinfo) - end");
		}
	}	
}
