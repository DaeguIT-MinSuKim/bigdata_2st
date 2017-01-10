package kr.or.dgit.bigdata.project.hairshop.mappers;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import kr.or.dgit.bigdata.project.hairshop.dto.Biz;
import kr.or.dgit.bigdata.project.hairshop.dto.Hairinfo;

public interface BizMapper {
	@Select("select b.bNo, b.bDate, h.hName, h.hPrice, e.eName, (h.hPrice*(1-e.eDiscount)) as resultPrice from hairshop.biz b left outer join hairshop.hairinfo h on b.hNo = h.hNo left outer join hairshop.event e on b.eNo = e.eNo order by bNo desc")
	public List<Biz> selectBizAndHairInfoEvent();
	
	@Select("select b.bNo, b.bDate, h.hName, h.hPrice, e.eName, (h.hPrice*(1-e.eDiscount)) as resultPrice from hairshop.biz b left outer join hairshop.hairinfo h on b.hNo = h.hNo left outer join hairshop.event e on b.eNo = e.eNo where b.bDate >= #{bDateStart} and b.bDate <=#{bDateEnd} order by bNo desc")
	public List<Biz> selectBizAndHairInfoEventByDate(Biz biz); // xml 처럼 &gt; 을 사용하지 않면 안되고 부등호를 그대로 입력해야 인식됨.
	
	@Select("select b.bNo, b.bDate, c.cName, h.hName, e.eName, (h.hPrice*(1-e.eDiscount)) as resultPrice from hairshop.biz b left outer join hairshop.hairinfo h on b.hNo = h.hNo left outer join hairshop.customer c on b.cNo = c.cNo left outer join hairshop.event e on b.eNo = e.eNo where b.bDate >= #{param1} and b.bDate <#{param2} order by b.bNo desc")
	public List<Biz> selectYearOrMonthAllFromBiz(String startDate, String endDate);
	
	@Select("select (select count(*) from hairshop.customer tc where tc.cDel = false) as totalCustomer, count(b.bNo) as totalBiz, sum(h.hPrice*(1-e.eDiscount)) as totalMoney from hairshop.biz b left outer join hairshop.hairinfo h on b.hNo = h.hNo left outer join hairshop.customer c on b.cNo = c.cNo left outer join hairshop.event e on b.eNo = e.eNo")
	public List<Biz> selectCountTotalFrombiz();
	
	@Select("select h.hName as hairStyle, count(b.hNo) as sumOrder from hairshop.biz b, hairshop.hairInfo h where b.hNo = h.hNo group by b.hNo")
	public List<Biz> selectCountStyleForGraph();
	
	@Insert("insert into Biz values(#{bDate},#{bTime},#{bcNo},#{bhNo},#{beNo})")
	public int insertBiz(Biz biz);

	/* ver. 이유진 */
	public List<Biz> selectYearOrMonthFromBiz(String startDate, String endDate);
	
	@Select("select count(bNo) as cnt, sum(h.hPrice*(1-e.eDiscount)) as sum from hairshop.biz b left outer join hairshop.hairinfo h on b.hNo = h.hNo left outer join hairshop.event e  on e.eNo = b.eNo where b.bDate >= #{param1} and b.bDate < #{param2}")
	public HashMap<String, Integer> selectYearOrMonthFromBizCalTotal(String startDate, String endDate);
	
	public List<Biz> selectAllBiz();
}
                             