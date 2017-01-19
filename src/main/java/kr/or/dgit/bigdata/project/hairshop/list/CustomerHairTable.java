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
public class CustomerHairTable extends JTable {	
	/* 헤어 검색이나 고객헤어정보 panel에서 table 사용 할 때 */
	public CustomerHairTable() {}
	
	public void setTableWithData(Customer customer) {
		setModel(new DefaultTableModel(getDatas(customer), getColumnNames()));
		setTableWidthAlignment();		
	}
	
	public void setTableWithData(String startDate, String endDate) {
		setModel(new DefaultTableModel(getDatas(startDate, endDate), getColumnNames()));
		setTableWidthAlignment();	
	}
	
	private void setTableWidthAlignment() {
		TableForm.setTable(this);
		TableForm.tableCellAlignment(SwingConstants.CENTER, 0,1,2,4);
		TableForm.tableCellAlignment(SwingConstants.RIGHT, 3,5);
		TableForm.tableSetWidth(100,300,200,400,200,400);		
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
	
	private String[] getColumnNames() {
		return new String[]{"영업번호","영업일자","헤어명","단가","이벤트명","금액"};
	}
	
	public static String[] getcntSumIntValue(String startDate, String endDate) {
		HashMap<String,Object> calList = BizService.getInstance().selectBizWithDatesCalTotal(startDate, endDate);
		double dSum = (Double) calList.get("sum");
		int iSum = (int)(dSum);
		return new String[]{calList.get("cnt")+"건",String.format("%,d 원", iSum)};
	}
}
