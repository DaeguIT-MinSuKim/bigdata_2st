package kr.or.dgit.bigdata.project.hairshop.list;

import java.util.List;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import kr.or.dgit.bigdata.project.hairshop.dto.Customer;
import kr.or.dgit.bigdata.project.hairshop.service.CustomerService;


public class CustomerSearchListForAll extends JTable {
	
	
	public void reloadDataForAll() {
		DefaultTableModel model = new DefaultTableModel(getRowDataForAll(), getColumnData());
		setModel(model);
		tableSetAlignWithForAll();		
	}
	protected void tableSetAlignWithForAll() {//
		tableCellAlignmentForAll(SwingConstants.CENTER, 0, 1, 2, 3, 4);
		tableSetWidthForAll(60, 100, 200, 200, 200);
	}
	
	protected void tableCellAlignmentForAll(int align, int... idx) {//
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);
		TableColumnModel model = getColumnModel();
		for (int i = 0; i < idx.length; i++) {
			model.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}
	protected void tableSetWidthForAll(int... width) {//
		TableColumnModel model = getColumnModel();
		for (int i = 0; i < width.length; i++) {
			model.getColumn(i).setPreferredWidth(width[i]);
		}
	}
	private String[][] getRowDataForAll() { // 전체 표 읽어오기
		List<Customer> list = CustomerService.getInstance().selectByAll();
		String[][] rowDatas = new String[list.size()][];
		for (int i = 0; i < list.size(); i++) {
			rowDatas[i] = list.get(i).toArray();
		}

		return rowDatas;
	}
	private String[] getColumnData() {

		return new String[] { "고객 번호", "고객명", "생년월일", "가입일자", "전화번호" };
	}
	
	
}
