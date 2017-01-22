package kr.or.dgit.bigdata.project.hairshop.list;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

public class ListTableSetting extends JTable {
	int ColumDataIndex;
	
	protected void tableSetWidth(int... width) {//
		TableColumnModel model = getColumnModel();
		for (int i = 0; i < width.length; i++) {
			model.getColumn(i).setPreferredWidth(width[i]);
		}
	}
	public void tableSetAlignWidth() {//
		if (ColumDataIndex == 1) {
			tableCellAlignment(SwingConstants.CENTER, 0, 1, 2, 3, 4);
			tableSetWidth(60, 100, 200, 200, 200);
			
		}else if (ColumDataIndex == 2) {
			tableCellAlignment(SwingConstants.CENTER, 0,1,2,3,4);
			tableCellAlignment(SwingConstants.RIGHT, 5);
			tableSetWidth(100,300,200,200,200,400);
			
		}else if (ColumDataIndex == 3) {
			tableCellAlignment(SwingConstants.CENTER, 0,1,2,4);
			tableCellAlignment(SwingConstants.RIGHT, 3,5);
			tableSetWidth(100,300,200,400,200,400);			
			
		}else if (ColumDataIndex == 4) {
			tableCellAlignment(SwingConstants.CENTER, 0,1);
			tableCellAlignment(SwingConstants.RIGHT, 2);
			tableSetWidth(100,300,400);			
			
		}else if (ColumDataIndex == 5) {
			tableCellAlignment(SwingConstants.CENTER, 0,1,2);
			tableSetWidth(100,100,100);			
			
		}else if (ColumDataIndex == 6) {
			tableCellAlignment(SwingConstants.CENTER, 0,1);
			tableSetWidth(100,300);			
			
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
	public String[] getColumnData() {
		String[] strArr = null;
		if (ColumDataIndex == 1) {
			strArr = new String[]{ "고객 번호", "고객명", "생년월일", "가입일자", "전화번호" };
			
		}else if (ColumDataIndex == 2) {
			strArr = new String[]{"영업번호","영업일자","고객명","헤어명","이벤트명","금액"};
			
		}else if (ColumDataIndex == 3) {
			strArr =new String[]{"영업번호","영업일자","헤어명","단가","이벤트명","금액"};		
			
		}else if (ColumDataIndex == 4){
			strArr =new String[]{"헤어번호","헤어명","단가"};
		}else if (ColumDataIndex == 5){
			strArr =new String[]{"이벤트번호","이벤트명","할인율"};
		}else if (ColumDataIndex == 6){
			strArr =new String[]{"No","ID"};
		}
		
		return strArr;
	}
	// get set
	public int getColumDataIndex() {
		return ColumDataIndex;
	}
	public void setColumDataIndex(int columDataIndex) {
		ColumDataIndex = columDataIndex;
	}
	
}
