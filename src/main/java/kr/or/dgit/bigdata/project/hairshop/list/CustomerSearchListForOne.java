package kr.or.dgit.bigdata.project.hairshop.list;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.table.DefaultTableModel;

import kr.or.dgit.bigdata.project.hairshop.dto.Customer;
import kr.or.dgit.bigdata.project.hairshop.service.CustomerService;


public class CustomerSearchListForOne extends ListTableSetting {
	public CustomerSearchListForOne() {
		setToolTipText("원하는 회원 정보에 커서를 두고 우클릭을 하면 기능이 나타납니다.");
		setEnabled(false);
	}
	
	public void reloadData(String cName) {
		setColumDataIndex(1);
		DefaultTableModel model = new DefaultTableModel(getRowData(cName), getColumnData());
		setModel(model);
		tableSetAlignWidth();	
	}
	private String[][] getRowData(String cName) {
		Map<String, Object> map = new HashMap<>();
		map.put("cName", cName);
		List<Customer> list = CustomerService.getInstance().searchCustomerByName(map);
		System.out.println("[getRowData]size:" + list.size());

		String[][] rowDatas = new String[list.size()][];
		for (int i = 0; i < list.size(); i++) {
			rowDatas[i] = list.get(i).toArray();
		}

		return rowDatas;
	}

	
}
