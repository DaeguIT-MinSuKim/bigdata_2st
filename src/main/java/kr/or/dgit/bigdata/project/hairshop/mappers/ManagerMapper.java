package kr.or.dgit.bigdata.project.hairshop.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import kr.or.dgit.bigdata.project.hairshop.dto.Manager;

public interface ManagerMapper {
	/*METHODS*/
	@Select("select mPassword from manager where mName = #{mName}")
	public Manager selectmPasswordByName(Manager manager);
	/* 관리자 메뉴 중 관리자 등록 및 수정을 할 떄 관리자 정보를 하나(mNo=1)로 두고 
	 * 등록시 mNo=1의 정보가 변경되도록, 삭제시 mNo의 정보가 ""로 초기화 되도록, 
	 * 수정시 수정되도록 update의 기능만 만들었습니다. by. 유진*/
	@Insert("update manager set mName=#{param1} , mPassword=#{param2} where mNo=1")
	public void updateManager(String mName, String mPassword);
}