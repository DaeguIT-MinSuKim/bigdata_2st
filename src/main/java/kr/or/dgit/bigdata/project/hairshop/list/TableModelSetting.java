package kr.or.dgit.bigdata.project.hairshop.list;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

public class TableModelSetting extends JTable {
	int ColumDataIndex;
	
	protected void tableSetWidth(int... width) {//
		TableColumnModel model = getColumnModel();
		for (int i = 0; i < width.length; i++) {
			model.getColumn(i).setPreferredWidth(width[i]);
		}
	}
	protected void tableSetAlignWith() {//
		if (ColumDataIndex == 1) {
			tableCellAlignment(SwingConstants.CENTER, 0, 1, 2, 3, 4);
			tableSetWidth(60, 100, 200, 200, 200);
			
			ColumDataIndex =0;
		}else if (ColumDataIndex == 2) {
			
			
			ColumDataIndex =0;
		}else if (ColumDataIndex == 3) {
			TableForm.tableCellAlignment(SwingConstants.CENTER, 0,1,2,4);
			TableForm.tableCellAlignment(SwingConstants.RIGHT, 3,5);
			TableForm.tableSetWidth(100,300,200,400,200,400);			
			ColumDataIndex =0;
		}
		
	}
	
	protected void tableCellAlignment(int align, int... idx) {//
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);
		TableColumnModel model = getColumnModel();
		for (int i = 0; i < idx.length; i++) {
			model.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}
	private String[] getColumnData() {
		
		
		
		return new String[] { "고객 번호", "고객명", "생년월일", "가입일자", "전화번호" };
	}
	
	public int getColumDataIndex() {
		return ColumDataIndex;
	}
	public void setColumDataIndex(int columDataIndex) {
		ColumDataIndex = columDataIndex;
	}
	
}
