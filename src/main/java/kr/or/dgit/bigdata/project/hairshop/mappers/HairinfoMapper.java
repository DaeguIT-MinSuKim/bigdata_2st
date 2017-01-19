package kr.or.dgit.bigdata.project.hairshop.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.or.dgit.bigdata.project.hairshop.dto.Hairinfo;

public interface HairinfoMapper {
	/*METHODS*/
	@Select("select hNo, hName, hPrice from hairinfo")
	public List<Hairinfo> selectHairInfoAll();
	
	@Select("select hNo, hName, hPrice from hairinfo where hNo=#{hNo}")
	public Hairinfo selectHairInfoByNo(Hairinfo hairinfo);
	
	@Insert("insert into hairinfo(hName, hPrice) values(#{hName},#{hPrice})")
	public void insertHairInfo(Hairinfo hinfo);
	
	@Update("update hairinfo set hName=#{hName}, hPrice=#{hPrice} where hNo=#{hNo}")
	public void updateHairInfo(Hairinfo event);
	
	@Delete("delete from hairinfo where hNo=#{hNo}")
	public void deleteHairInfo(Hairinfo event);
	
	/* TEST 용 임시 메소드 */
	@Select("select hNo, hName, hPrice from hairinfo where hName=#{hName}")
	public Hairinfo selectHairInfoByName(Hairinfo hairinfo);
}