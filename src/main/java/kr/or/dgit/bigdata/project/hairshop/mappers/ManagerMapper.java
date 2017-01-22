package kr.or.dgit.bigdata.project.hairshop.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.or.dgit.bigdata.project.hairshop.dto.Manager;

public interface ManagerMapper {
	/*METHODS*/
	@Select("select mNo, mName, mPassword from manager where mName = #{mName}")
	public Manager selectmPasswordByName(Manager manager);
	/* 관리자 메뉴 중 관리자 등록 및 수정을 할 떄 관리자 정보를 하나(mNo=1)로 두고 
	 * 등록시 mNo=1의 정보가 변경되도록, 삭제시 mNo의 정보가 ""로 초기화 되도록, 
	 * 수정시 수정되도록 update의 기능만 만들었습니다. by. 유진*/
	@Update("update manager set mName=#{mName} , mPassword=#{mPassword} where mNo=#{mNo}")
	public void updateManager(Manager manager);
	
	@Select("select * from manager")
	public List<Manager> selectAllManager();
	@Insert("insert into manager(mName, mPassword) values(#{mName},#{mPassword})" )
	public void insertManager(Manager manager);
	@Delete("delete from manager where mNo=#{mNo}")
	public void deleteManager(Manager manager);
	
}