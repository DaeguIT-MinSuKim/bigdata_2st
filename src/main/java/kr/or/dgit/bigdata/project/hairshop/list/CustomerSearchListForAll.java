package kr.or.dgit.bigdata.project.hairshop.list;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import kr.or.dgit.bigdata.project.hairshop.dto.Customer;
import kr.or.dgit.bigdata.project.hairshop.service.CustomerService;


public class CustomerSearchListForAll extends ListTableSetting {
	
	
	public void reloadDataForAll() {
		setColumDataIndex(1);
		DefaultTableModel model = new DefaultTableModel(getRowDataForAll(), getColumnData());
		setModel(model);
		tableSetAlignWidth();		
	}
	private String[][] getRowDataForAll() { // 전체 표 읽어오기
		List<Customer> list = CustomerService.getInstance().selectByAll();
		String[][] rowDatas = new String[list.size()][];
		for (int i = 0; i < list.size(); i++) {
			rowDatas[i] = list.get(i).toArray();
		}

		return rowDatas;
	}	
	
}
