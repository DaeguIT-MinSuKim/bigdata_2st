package kr.or.dgit.bigdata.project.hairshop.list;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kr.or.dgit.bigdata.project.hairshop.dto.Biz;
import kr.or.dgit.bigdata.project.hairshop.service.BizService;

@SuppressWarnings("serial")
public class BiztList extends JTable {
	Calendar cal = Calendar.getInstance();
	final int THISYEAR = cal.get(Calendar.YEAR);// 올해
	
	public BiztList() {}
	public BiztList(Boolean isReport) {	
		setTableWithData(isReport);		
	}

	public BiztList(Boolean isReport, String listBy, int year) {	
		setTableWithData(isReport, listBy, year);		
	}
	
	private void setTableWithData(Boolean isReport) {
		// 보고서에 구현할 테이블인지 여부만 확인(보고서가 아닌경우에만 호출)==보고서 외 영업테이블 사용시
		setModel(new DefaultTableModel(getDatas(isReport, null, 0), getColumnNames(isReport)));
	}
	private void setTableWithData(Boolean isReport, String listBy, int year) {
		setModel(new DefaultTableModel(getDatas(isReport, listBy, year), getColumnNames(isReport)));		
	}

	private String[][] getDatas(Boolean isReport, String listBy, int year) {		
		/* 월별/년도별 조회를 선택했을떄 월별인지 년도별인지를 구분하여 배열 return */
		if(isReport==true){	
			
			/* 월별 조회를 선택할 시  월별로 데이터 정렬하는 메소드  - 년도별과 깔끔하게 메소드 합칠 수 있는 방법 있으면 알려주세요! by. 이유진 */
			if(listBy.equals("month")){				
				ArrayList<Object> list = new ArrayList<>();//String[][]으로 변환하기 위한 전체 List를 저장할 ArrayList
				for(int i=1;i<=12;i++){
					String startDate = year+"-"+i+"-01";
					String endDate = year+"-"+(i+1)+"-01";
					
					List<Biz> bList =BizService.getInstance().selectYearOrMonthFromBiz(startDate, endDate);
					for(Biz b:bList){
						list.add(b.toArray(isReport));
						System.out.println(list.get(0).toString());
					}					
					if(!bList.isEmpty()){
						HashMap<String,Integer> calList = BizService.getInstance().selectYearOrMonthFromBizCalTotal(startDate, endDate);
						String[] sList = new String[]{"", i+"월 소계", "", "",calList.get("cnt")+"건" ,calList.get("sum")+"원"};
						list.add(sList);
					}					
				}				
				return setDatas(list);
				
			}else{
				/* 년도별 조회를 선택할 시 년도별로 데이터 정렬하는 메소드 */
				
				ArrayList<Object> list = new ArrayList<>();				
				for(int i = THISYEAR ; i > 1945 ; i--){
					String startDate = i+"-01-01";
					String endDate = (i+1)+"-01-01";
					List<Biz> bList = BizService.getInstance().selectYearOrMonthFromBiz(startDate, endDate);
					for(Biz b:bList){
						list.add(b.toArray(isReport));
					}
					if(!bList.isEmpty()){
						HashMap<String,Integer> calList = BizService.getInstance().selectYearOrMonthFromBizCalTotal(startDate, endDate);
						String[] sList = new String[]{"", i+"년 소계", "", "",calList.get("cnt")+"건" ,calList.get("sum")+"원"};
						list.add(sList);
					}
				}
				return setDatas(list);
			}
			
		}else{
			/* 보고서 출력이 아닌 기존 프로그램에서 영업관련 테이블이 필요한 경우 (isReport==false) */
			List<Biz> list = BizService.getInstance().selectAllBiz();
			String[][] Datas = new String[list.size()][];
			for(int i=0; i<list.size(); i++){
				Datas[i]=  list.get(i).toArray(false);
			}
			return Datas;
		}
	}

	private String[][] setDatas(ArrayList<Object> list) {
		/* 월별/년도별 보고서 출력시 전제 ArrayList를 String 이중배열로 전환하는 메소드 */
		String Datas[][] = new String[list.size()][];
		for(int i=0;i<list.size();i++){
			Datas[i] = (String[]) list.get(i);
		}
		return Datas;
	}
	
	private String[] getColumnNames(Boolean isReport) {
		if(isReport==true){
			return new String[]{"영업번호","영업일자","고객명","헤어명","이벤트명","금액"};
		}else{
			return new String[]{"영업번호","영업일자","헤어명","단가","이벤트명","금액"};
		}
	}

}
