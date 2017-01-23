package kr.or.dgit.bigdata.project.hairshop.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import kr.or.dgit.bigdata.project.hairshop.dto.Biz;
import kr.or.dgit.bigdata.project.hairshop.service.BizService;

@SuppressWarnings("serial")
public class BizTableByYear extends ListTableSetting {
	public BizTableByYear() {}

	public void setTableWithData() {
		setColumDataIndex(2);
		setModel(new DefaultTableModel(getDatas(), getColumnData()));		
		tableSetAlignWidth();
	}
	
	private String[][] getDatas() {					
		HashMap<String, Object> searchMap = new HashMap<>();
		Set<Integer> temp = BizService.getInstance().selectBDateYear();
		Integer[] yList = temp.toArray(new Integer[temp.size()]);
		ArrayList<Object> list = new ArrayList<>();				
		for(int i = yList.length-1 ; i >= 0 ; i--){
			searchMap.put("year", yList[i]);
			List<Biz> bList = BizService.getInstance().selectBizWithYearMonth(searchMap);
			for(Biz b:bList){
				list.add(b.toBizArray());
			}
			if(!bList.isEmpty()){
				HashMap<String, Object> res = BizService.getInstance().selectBizWithYearMonthCalTotal(searchMap);
				String[] tList = BizTableByMonth.getcntSumIntValue(res);
				String[] sList = new String[]{"", yList[i]+"년 소계", "", "",tList[0] ,tList[1]};
				list.add(sList);
			}
		}
		if(!list.isEmpty()){
			String startDate = yList[0]+"-01-01";
			String endDate = (yList[yList.length-1])+"12-31";
			HashMap<String, Object> res = BizService.getInstance().selectBizWithDatesCalTotal(startDate, endDate);
			String[] tList = BizTableByMonth.getcntSumIntValue(res);
			String[] sList = new String[]{"", "", "", "","총 계 : " , tList[1]};
			list.add(sList);
		}
		return BizTableByMonth.setDatas(list);	
	}
}
