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
public class BizTableByYear extends JTable {
	public BizTableByYear() {}

	public void setTableWithData() {
		setModel(new DefaultTableModel(getDatas(), getColumnNames()));		
		setTableWidthAlignment();
	}
	private void setTableWidthAlignment() {
		TableForm.setTable(this);
		TableForm.tableCellAlignment(SwingConstants.CENTER, 0,1,2,3,4);
		TableForm.tableCellAlignment(SwingConstants.RIGHT, 5);
		TableForm.tableSetWidth(100,300,200,200,200,400);		
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
			String endDate = (yList[yList.length-1]+1)+"01-01";
			HashMap<String, Object> res = BizService.getInstance().selectBizWithDatesCalTotal(startDate, endDate);
			String[] tList = BizTableByMonth.getcntSumIntValue(res);
			String[] sList = new String[]{"", "", "", "","총 계 : " , tList[1]};
			list.add(sList);
		}
		return BizTableByMonth.setDatas(list);	
	}
	
	private String[] getColumnNames() {	
		return new String[]{"영업번호","영업일자","고객명","헤어명","이벤트명","금액"};
	}
}
