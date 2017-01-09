package kr.or.dgit.bigdata.project.hairshop.list;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

@SuppressWarnings("serial")
public abstract class AbstractList extends JTable {
	private JTable table;
	
	public AbstractList() {
	}

	public void tableCellAlignment(int align, int... idx) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);

		TableColumnModel model = table.getColumnModel();
		for (int i = 0; i < idx.length; i++) {
			model.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}

	public void tableSetWidth(int... width) {
		TableColumnModel cModel = table.getColumnModel();

		for (int i = 0; i < width.length; i++) {
			cModel.getColumn(i).setPreferredWidth(width[i]);
		}
	}
}
