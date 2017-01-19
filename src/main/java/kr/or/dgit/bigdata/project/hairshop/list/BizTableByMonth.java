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
public class BizTableByMonth extends JTable {
	public BizTableByMonth() {}

	public void setTableWithData(int year) {
		setModel(new DefaultTableModel(getDatas(year), getColumnNames()));		
		setTableWidthAlignment();
	}
	
	private void setTableWidthAlignment() {
		TableForm.setTable(this);
		TableForm.tableCellAlignment(SwingConstants.CENTER, 0,1,2,3,4);
		TableForm.tableCellAlignment(SwingConstants.RIGHT, 5);
		TableForm.tableSetWidth(100,300,200,200,200,400);		
	}
	
	private String[][] getDatas(int year) {					
		HashMap<String, Object> searchMap = new HashMap<>();
		searchMap.put("year", year);
		ArrayList<Object> list = new ArrayList<>();//String[][]으로 변환하기 위한 전체 List를 저장할 ArrayList
		for(int i=1;i<=12;i++){
			searchMap.put("month", i);
			List<Biz> bList =BizService.getInstance().selectBizWithYearMonth(searchMap);
			for(Biz b:bList){
				list.add(b.toBizArray());
			}					
			if(!bList.isEmpty()){
				HashMap<String, Object> res = BizService.getInstance().selectBizWithYearMonthCalTotal(searchMap);
				String[] tList = getcntSumIntValue(res);				
				String[] sList = new String[]{"", i+"월 소계", "", "",tList[0] ,tList[1]};
				list.add(sList);
			}					
		}
		
		if(!list.isEmpty()){
			searchMap.remove("month");
			HashMap<String, Object> res = BizService.getInstance().selectBizWithYearMonthCalTotal(searchMap);
			String[] tList = getcntSumIntValue(res);	
			String[] sList = new String[]{"", "", "", "","총 계 : " , tList[1]};
			list.add(sList);
		}
		
		return setDatas(list);
	}

	public static String[] getcntSumIntValue(HashMap<String, Object> calList) {
		// DB에서 계산하여 넘어온 더블형의 값을 int로 변환
		double dSum = (Double) calList.get("sum");
		int iSum = (int)(dSum);
		return new String[]{calList.get("cnt")+"건",String.format("%,d 원", iSum)};
	}

	public static String[][] setDatas(ArrayList<Object> list) {
		/* 월별/년도별 보고서 출력시 전제 ArrayList를 String 이중배열로 전환하는 메소드 */
		String Datas[][] = new String[list.size()][];
		
		for(int i=0;i<list.size();i++){
			Datas[i] = (String[]) list.get(i);
		}		
		return Datas;
	}
	
	private String[] getColumnNames() {	
		return new String[]{"영업번호","영업일자","고객명","헤어명","이벤트명","금액"};
	}
}
