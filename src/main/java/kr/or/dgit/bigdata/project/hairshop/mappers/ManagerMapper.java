package kr.or.dgit.bigdata.project.hairshop.mappers;

import org.apache.ibatis.annotations.Select;

import kr.or.dgit.bigdata.project.hairshop.dto.Manager;

public interface ManagerMapper {
	/*METHODS*/
	@Select("select mPassword from manager where mName = #{mName}")
	public Manager selectmPasswordByName(Manager manager);
}