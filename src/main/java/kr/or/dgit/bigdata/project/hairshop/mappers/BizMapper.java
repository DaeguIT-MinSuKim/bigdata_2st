package kr.or.dgit.bigdata.project.hairshop.mappers;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Select;

import kr.or.dgit.bigdata.project.hairshop.dto.Biz;

public interface BizMapper {
	@Select("select b.bNo, b.bDate, h.hName, h.hPrice, e.eName, (h.hPrice*(1-e.eDiscount)) as resultPrice from hairshop.biz b left outer join hairshop.hairinfo h on b.hNo = h.hNo left outer join hairshop.event e on b.eNo = e.eNo order by bNo desc")
	public List<Biz> selectBizAndHairInfoEvent();
	
	@Select("select b.bNo, b.bDate, h.hName, h.hPrice, e.eName, (h.hPrice*(1-e.eDiscount)) as resultPrice from hairshop.biz b left outer join hairshop.hairinfo h on b.hNo = h.hNo left outer join hairshop.event e on b.eNo = e.eNo where b.bDate >= #{bDateStart} and b.bDate <=#{bDateEnd} order by bNo desc")
	public List<Biz> selectBizAndHairInfoEventByDate(Biz biz); // xml 처럼 &gt; 을 사용하지 않면 안되고 부등호를 그대로 입력해야 인식됨.
}
