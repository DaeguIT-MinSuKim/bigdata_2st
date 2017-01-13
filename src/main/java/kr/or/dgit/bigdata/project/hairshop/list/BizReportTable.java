package kr.or.dgit.bigdata.project.hairshop.list;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import kr.or.dgit.bigdata.project.hairshop.dto.Biz;
import kr.or.dgit.bigdata.project.hairshop.service.BizService;

@SuppressWarnings("serial")
public class BizReportTable extends JTable {
	public BizReportTable() {}

	public void setTableWithData(String listBy) {
		setModel(new DefaultTableModel(getDatas(listBy, 0), getColumnNames()));		
		setTableWidthAlignment();
	}

	public void setTableWithData(String listBy, int year) {
		setModel(new DefaultTableModel(getDatas(listBy, year), getColumnNames()));		
		setTableWidthAlignment();
	}
	private void setTableWidthAlignment() {
		TableForm.setTable(this);
		TableForm.tableCellAlignment(SwingConstants.CENTER, 0,1,2,3,4);
		TableForm.tableCellAlignment(SwingConstants.RIGHT, 5);
		TableForm.tableSetWidth(100,300,200,200,200,400);		
	}
	private String[][] getDatas(String listBy, int year) {				
		/* 월별 조회를 선택할 시  월별로 데이터 정렬하는 메소드  - 년도별과 깔끔하게 메소드 합칠 수 있는 방법 있으면 알려주세요! by. 이유진 */
		if(listBy.equals("month")){				
			ArrayList<Object> list = new ArrayList<>();//String[][]으로 변환하기 위한 전체 List를 저장할 ArrayList
			for(int i=1;i<=12;i++){
				String startDate = year+"-"+i+"-01";
				String endDate = year+"-"+(i+1)+"-01";
				
				List<Biz> bList =BizService.getInstance().selectYearOrMonthFromBiz(startDate, endDate);
				for(Biz b:bList){
					list.add(b.toArray(true));
					System.out.println(list.get(0).toString());
				}					
				if(!bList.isEmpty()){
					String[] tList = getcntSumIntValue(startDate, endDate);					
					String[] sList = new String[]{"", i+"월 소계", "", "",tList[0] ,tList[1]};
					list.add(sList);
				}					
			}
			if(!list.isEmpty()){
				String[] tList = getcntSumIntValue(year+"-01-01", (year+1)+"01-01");	
				String[] sList = new String[]{"", "", "", "","총 계 : " , tList[1]};
				list.add(sList);
			}
			return setDatas(list);
			
		}else{
			/* 년도별 조회를 선택할 시 년도별로 데이터 정렬하는 메소드 */
			List<Integer> yList = BizService.getInstance().selectBDateYear();
			ArrayList<Object> list = new ArrayList<>();				
			for(int i = yList.size() ; i > 0 ; i--){
				String startDate = yList.get(i-1)+"-01-01";
				String endDate = (yList.get(i-1)+1)+"-01-01";
				List<Biz> bList = BizService.getInstance().selectYearOrMonthFromBiz(startDate, endDate);
				for(Biz b:bList){
					list.add(b.toArray(true));
				}
				if(!bList.isEmpty()){
					String[] tList = getcntSumIntValue(startDate, endDate);
					String[] sList = new String[]{"", i+"년 소계", "", "",tList[0] ,tList[1]};
					list.add(sList);
				}
			}
			if(!list.isEmpty()){
				String[] tList = getcntSumIntValue(yList.get(0)+"-01-01", yList.get(yList.size()-1)+"01-01");
				String[] sList = new String[]{"", "", "", "","총 계 : " , tList[1]};
				list.add(sList);
			}
			return setDatas(list);
		}
	}

	public static String[] getcntSumIntValue(String startDate, String endDate) {
		// DB에서 계산하여 넘어온 더블형의 값을 int로 변환
		HashMap<String,Object> calList = BizService.getInstance().selectYearOrMonthFromBizCalTotal(startDate,endDate);
		double dSum = (Double) calList.get("sum");
		int iSum = (int)(dSum);
		return new String[]{calList.get("cnt")+"건",String.format("%,d 원", iSum)};
	}

	private String[][] setDatas(ArrayList<Object> list) {
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
