package kr.or.dgit.bigdata.project.hairshop.list;

import java.awt.CardLayout;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import kr.or.dgit.bigdata.project.hairshop.dto.Customer;
import kr.or.dgit.bigdata.project.hairshop.service.CustomerService;

public class HairOrderSubList extends JTable {
	/*public void reloadData() {
		DefaultTableModel model = new DefaultTableModel(getRowData(tfCName.getText()), getColumnData());
		setModel(model);
		tableSetAlignWith();		
	}

	private String[][] getRowData(String cName) {
		Map<String, Object> map = new HashMap<>();
		map.put("cName", cName);
		List<Customer> list = CustomerService.getInstance().searchCustomerByName(map);
		
		if (list.size() == 0) {//리스트 읽어들인뒤 결과따라 좌측 패널 연동
			List<Customer> listByAll = CustomerService.getInstance().selectByAll();
			int newCno =listByAll.size()+1;
			pnAddInput.getTxtCno().setText(newCno+"");
			pnAddInput.getTxtCname().setText(tfCName.getText());
			CardLayout cl = (CardLayout)(pnCards.getLayout());
	        cl.show(pnCards, "name_30981526616213");
	        
		}else if (list.size() > 0){
	      
	        if (list.size() == 1) {
				tfCNo.setText(list.get(0).getcNo()+"");	
			}
		}
		String[][] rowDatas = new String[list.size()][];
		for (int i = 0; i < list.size(); i++) {
			rowDatas[i] = list.get(i).toArray();
		}
		
		return rowDatas;
	}
*/
	public String[] getColumnData() {

		return new String[] { "고객 번호", "고객명", "생년월일", "가입일자", "전화번호" };
	}
	
	protected void tableSetWidth(int... width) {//
		TableColumnModel model = getColumnModel();
		for (int i = 0; i < width.length; i++) {
			model.getColumn(i).setPreferredWidth(width[i]);
		}
	}
	public void tableSetAlignWith() {//
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2, 3, 4);
		tableSetWidth(60, 100, 200, 200, 200);
	}
	
	protected void tableCellAlignment(int align, int... idx) {//
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);
		TableColumnModel model = getColumnModel();
		for (int i = 0; i < idx.length; i++) {
			model.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}
}
