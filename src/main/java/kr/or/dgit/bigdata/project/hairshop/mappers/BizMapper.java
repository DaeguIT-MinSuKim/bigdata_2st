package kr.or.dgit.bigdata.project.hairshop.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import kr.or.dgit.bigdata.project.hairshop.dto.Biz;

public interface BizMapper {
	@Select("select * from biz")
	public List<Biz> selectBizAndHairInfoEvent();
}
