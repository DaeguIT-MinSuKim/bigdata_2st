package kr.or.dgit.bigdata.project.hairshop.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import kr.or.dgit.bigdata.project.hairshop.dto.Biz;
import kr.or.dgit.bigdata.project.hairshop.dto.Customer;
import kr.or.dgit.bigdata.project.hairshop.list.BiztList;
import kr.or.dgit.bigdata.project.hairshop.service.BizService;
import kr.or.dgit.bigdata.project.hairshop.service.CustomerService;

public class HairOrderSearch extends JPanel {
	private JTextField txtName;
	private JTextField txtNo;
	private JTextField txtD1;
	private JTextField txtD2;
	private JTextField txtD3;
	private JTable table;
	private String[] chi = { "영업번호", "영업일자", "헤어명", "단가", "이벤트명","금액" };
	/**
	 * Create the panel.
	 */
	public HairOrderSearch() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel pnCustomerInfo = new JPanel();
		add(pnCustomerInfo, BorderLayout.NORTH);
		pnCustomerInfo.setLayout(new GridLayout(3, 2, 0, 0));
		
		JLabel lblNo = new JLabel("고객번호");
		pnCustomerInfo.add(lblNo);
		
		txtNo = new JTextField();
		txtNo.setEditable(false);
		pnCustomerInfo.add(txtNo);
		txtNo.setColumns(10);
		
		JLabel lblName = new JLabel("이름");
		pnCustomerInfo.add(lblName);
		
		txtName = new JTextField();
		txtName.setEditable(false);
		pnCustomerInfo.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblDob = new JLabel("생년월일");
		pnCustomerInfo.add(lblDob);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		pnCustomerInfo.add(panel);
		panel.setLayout(new GridLayout(0, 5, 0, 0));
		
		txtD1 = new JTextField();
		txtD1.setEditable(false);
		txtD1.setColumns(10);
		panel.add(txtD1);
		
		JLabel label = new JLabel("-");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label);
		
		txtD2 = new JTextField();
		txtD2.setEditable(false);
		txtD2.setColumns(10);
		panel.add(txtD2);
		
		JLabel label_1 = new JLabel("-");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label_1);
		
		txtD3 = new JTextField();
		txtD3.setEditable(false);
		txtD3.setColumns(10);
		panel.add(txtD3);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new BiztList();
		table = new JTable();
		table.setCellSelectionEnabled(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				chi
			));
		
		scrollPane.setViewportView(table);

	}
	public void reloadData() {
		DefaultTableModel model = new DefaultTableModel(getRowData(Integer.parseInt(txtNo.getText())), getColumnData());
		table.setModel(model);
		tableSetAlignWith();		
	}
	String[][] getRowData(int cNo) {
		
		List<Biz> list = BizService.getInstance().selectFromBizByCustomer(1);

		String[][] rowDatas = new String[list.size()][];
		for (int i = 0; i < list.size(); i++) {
			rowDatas[i] = list.get(i).toArray(false);
		}

		return rowDatas;
	}
	String[] getColumnData() {

		return chi;
	}
	protected void tableSetWidth(int... width) {//
		TableColumnModel model = table.getColumnModel();
		for (int i = 0; i < width.length; i++) {
			model.getColumn(i).setPreferredWidth(width[i]);
		}
	}
	protected void tableSetAlignWith() {//
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2, 3, 4);
		tableSetWidth(60, 100, 200, 200, 200);
	}
	
	protected void tableCellAlignment(int align, int... idx) {//
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);
		TableColumnModel model = table.getColumnModel();
		for (int i = 0; i < idx.length; i++) {
			model.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}
	
	public void setTxtInHairIfo(int cNo, String cName, String dob){
		String[] dobArr =  dob.split("-");
		
		txtNo.setText(cNo+"");
		txtName.setText(cName);		
		txtD1.setText(dobArr[0]); 
		txtD2.setText(dobArr[1]);
		txtD3.setText(dobArr[2]);
		
	}

}
