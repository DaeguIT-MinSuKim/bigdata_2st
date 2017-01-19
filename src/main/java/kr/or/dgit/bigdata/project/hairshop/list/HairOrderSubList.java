package kr.or.dgit.bigdata.project.hairshop.list;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

public class HairOrderSubList extends JTable {
	
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
