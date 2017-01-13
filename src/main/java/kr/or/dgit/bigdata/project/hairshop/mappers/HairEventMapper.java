package kr.or.dgit.bigdata.project.hairshop.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.or.dgit.bigdata.project.hairshop.dto.HairEvent;

public interface HairEventMapper {
	/*METHODS*/
	@Select("select * from event")
	public List<HairEvent> selectEventAll();
	
	@Select("select * from event where eNo=#{eNo}")
	public HairEvent selectEventByNo(HairEvent hairEvent);
	
	@Insert("insert into event(eName, eDiscount) values(#{eName},#{eDiscount}")
	public void insertEvent(HairEvent event);
	
	@Update("update event set(eName=#{eName}, eDiscount=#{eDiscount}) where eNo=#{eNo}")
	public void updateEvent(HairEvent event);
	
	@Delete("delete from event where eNo=#{eNo}")
	public void deleteEvent(HairEvent event);
}