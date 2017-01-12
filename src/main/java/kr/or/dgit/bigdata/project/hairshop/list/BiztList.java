package kr.or.dgit.bigdata.project.hairshop.list;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kr.or.dgit.bigdata.project.hairshop.dto.Biz;
import kr.or.dgit.bigdata.project.hairshop.dto.Customer;
import kr.or.dgit.bigdata.project.hairshop.service.BizService;

@SuppressWarnings("serial")
public class BiztList extends JTable {	
	/* 헤어 검색이나 고객헤어정보 panel에서 table 사용 할 때 */
	public BiztList() {}
	
	public void setTableWithData(Customer customer) {
		setModel(new DefaultTableModel(getDatas(customer), getColumnNames()));
	}
	
	public void setTableWithData(String startDate, String endDate) {
		setModel(new DefaultTableModel(getDatas(startDate, endDate), getColumnNames()));
	}

	private String[][] getDatas(String startDate, String endDate) {				
		/* 보고서 출력이 아닌 기존 프로그램에서 영업관련 테이블이 필요한 경우 (isReport==false) */
		List<Biz> list = BizService.getInstance().selectYearOrMonthFromBiz(startDate, endDate);
		String[][] Datas = new String[list.size()+1][];
		for(int i=0; i<list.size(); i++){
			Datas[i]=  list.get(i).toArray(false);
		}
		String[] tList = ReportTable.getcntSumIntValue(startDate, endDate);
		Datas[list.size()] = new String[]{"","","","","총 금액  : ",tList[1]};
	
		return Datas;		
	}
	private String[][] getDatas(Customer customer) {				
		List<Biz> list = BizService.getInstance().selectFromBizByCustomer(customer.getcNo());
		String[][] Datas = new String[list.size()][];
		for(int i=0; i<list.size(); i++){
			Datas[i]=  list.get(i).toArray(false);
		}
			return Datas;		
	}
	private String[] getColumnNames() {
		return new String[]{"영업번호","영업일자","헤어명","단가","이벤트명","금액"};
	}
}
