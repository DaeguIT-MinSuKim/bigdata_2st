package kr.or.dgit.bigdata.project.hairshop.list;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import kr.or.dgit.bigdata.project.hairshop.dto.Biz;
import kr.or.dgit.bigdata.project.hairshop.service.BizService;

public class HairOrderInfoList extends ListTableSetting {
	
	public void reloadData(String txtNo,String[] chi) {
		DefaultTableModel model = new DefaultTableModel(getRowData(Integer.parseInt(txtNo)), chi);
		setModel(model);
		tableSetAlignWidth();		
	}
	String[][] getRowData(int cNo) {
		
		List<Biz> list = BizService.getInstance().selectFromBizByCustomer(cNo);

		String[][] rowDatas = new String[list.size()][];
		for (int i = 0; i < list.size(); i++) {
			rowDatas[i] = list.get(i).toArray(false);
		}
		return rowDatas;
	}
	public void reloadData(String[] chi) {
		DefaultTableModel model = new DefaultTableModel(null, chi);
		setModel(model);
		tableSetAlignWidth();		
	}
	
}
