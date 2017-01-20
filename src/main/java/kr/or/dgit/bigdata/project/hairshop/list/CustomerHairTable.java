package kr.or.dgit.bigdata.project.hairshop.list;

import java.util.HashMap;
import java.util.List;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import kr.or.dgit.bigdata.project.hairshop.dto.Biz;
import kr.or.dgit.bigdata.project.hairshop.dto.Customer;
import kr.or.dgit.bigdata.project.hairshop.service.BizService;

@SuppressWarnings("serial")
public class CustomerHairTable extends ListTableSetting {	
	/* 헤어 검색이나 고객헤어정보 panel에서 table 사용 할 때 */
	public CustomerHairTable() {}
	
	public void setTableWithData(Customer customer) {
		setColumDataIndex(3);
		setModel(new DefaultTableModel(getDatas(customer), getColumnData()));
		tableSetAlignWidth();		
	}
	
	public void setTableWithData(String startDate, String endDate) {
		setColumDataIndex(3);
		setModel(new DefaultTableModel(getDatas(startDate, endDate), getColumnData()));
		tableSetAlignWidth();
	}

	private String[][] getDatas(String startDate, String endDate) {				
		List<Biz> list = BizService.getInstance().selectBizWithDates(startDate,endDate);
		String[][] Datas = new String[list.size()+1][];
		
		for(int i=0; i<list.size(); i++){
			Datas[i]=  list.get(i).toCSArray();
		}
		
		if(!list.isEmpty()){
			String[] tList = getcntSumIntValue(startDate, endDate);
			Datas[list.size()] = new String[]{"","","","","총 금액  : ",tList[1]};
		}
		
		return Datas;		
	}
	
	private String[][] getDatas(Customer customer) {				
		List<Biz> list = BizService.getInstance().selectFromBizByCustomer(customer.getcNo());
		String[][] Datas = new String[list.size()][];
		
		for(int i=0; i<list.size(); i++){
			Datas[i]=  list.get(i).toCSArray();
		}
		
		return Datas;		
	}
	
	public static String[] getcntSumIntValue(String startDate, String endDate) {
		HashMap<String,Object> calList = BizService.getInstance().selectBizWithDatesCalTotal(startDate, endDate);
		double dSum = (Double) calList.get("sum");
		int iSum = (int)(dSum);
		return new String[]{calList.get("cnt")+"건",String.format("%,d 원", iSum)};
	}
}
