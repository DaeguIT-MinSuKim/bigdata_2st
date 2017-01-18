package kr.or.dgit.bigdata.project.hairshop.mappers;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Select;

import kr.or.dgit.bigdata.project.hairshop.dto.Biz;

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
	
	/* ver. 이유진 */
	public List<Biz> selectBizWithDates(String startDate, String endDate);
	
	public HashMap<String, Object> selectBizWithDatesCalTotal(String startDate, String endDate);
	
	public HashMap<String, Object> selectBizWithYearMonthCalTotal(HashMap<String, Object> searchMap);
	
	public List<Biz> selectAllBiz();
	
	public List<Biz> selectFromBizByCustomer(int cNo);
	
	@Select("select year from view_biz")
	public Set<Integer> selectBDateYear();
	
	public List<Biz> selectBizWithYearMonth(HashMap<String, Object> searchMap);
	
	@Select("select (select count(*) from hairshop.customer tc where tc.cDel = false) as totalCustomer, count(b.bNo) as totalBiz, sum(h.hPrice*(1-e.eDiscount)) as totalMoney from hairshop.biz b left outer join hairshop.hairinfo h on b.hNo = h.hNo left outer join hairshop.customer c on b.cNo = c.cNo left outer join hairshop.event e on b.eNo = e.eNo")
	public List<Integer> selectCountTotalFrombizToInteger();
	
	@Select("select count(cName) from hairshop.customer tc where tc.cDel = false")
	public int selectCountTotalCustomer();
		
	@Select("select count(bNo) from hairshop.biz")
	public int selectCountTotalBiz();
	
	@Select("select sum(h.hPrice*(1-e.eDiscount)) from hairshop.biz b left outer join hairshop.hairinfo h on b.hNo = h.hNo left outer join hairshop.customer c on b.cNo = c.cNo left outer join hairshop.event e on b.eNo = e.eNo")
	public int selectCountTotalPrice();
	
	@Select("select count(hNo) from hairshop.biz where hNo=#{hNo}")
	public int selectCountTotalEachHairBiz(int hNo);
	
	/* test 중 */
	
	public void insertBiz(Biz biz);
	
	public HashMap<String, Object> selectBizWithHairInfo(HashMap<String, Object> searchMap);
}
      
