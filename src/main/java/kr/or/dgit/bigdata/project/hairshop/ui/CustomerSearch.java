package kr.or.dgit.bigdata.project.hairshop.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import kr.or.dgit.bigdata.project.hairshop.dto.Customer;
import kr.or.dgit.bigdata.project.hairshop.main.HairMain;
import kr.or.dgit.bigdata.project.hairshop.service.CustomerService;
import javax.swing.ListSelectionModel;

public class CustomerSearch extends JPanel {
	private JTable table;
	private JTable tableAll;
	private JTextField txtSearch;
	private String cName;
	private int cNo;
	private String dob;
	private String doJoin;
	private String phone;
	
	/**
	 * Create the panel.
	 */
	public CustomerSearch() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel pnSearch = new JPanel();
		pnSearch.setBorder(new EmptyBorder(10, 10, 10, 10));
		add(pnSearch, BorderLayout.NORTH);
		
		JLabel lblSearch = new JLabel("검색 : ");
		pnSearch.add(lblSearch);
		
		txtSearch = new JTextField();
		pnSearch.add(txtSearch);
		txtSearch.setColumns(10);
		
		JButton btnOk = new JButton("확인");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cName = txtSearch.getText();
				reloadData();
				
				
			}
		});
		pnSearch.add(btnOk);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setCellSelectionEnabled(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"고객 번호", "고객명", "생년월일", "가입일자", "전화번호" 
				}
			));
		
		scrollPane.setViewportView(table);
		

	}

	private void reloadData() {
		DefaultTableModel model = new DefaultTableModel(getRowData(cName), getColumnData());
		table.setModel(model);
		tableSetAlignWith();		
	}

	String[][] getRowData(String cName) {
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

	String[] getColumnData() {

		return new String[] { "고객 번호", "고객명", "생년월일", "가입일자", "전화번호" };
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

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public int getcNo() {
		return cNo;
	}

	public void setcNo(int cNo) {
		this.cNo = cNo;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getDoJoin() {
		return doJoin;
	}

	public void setDoJoin(String doJoin) {
		this.doJoin = doJoin;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}		

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JTextField getTxtSearch() {
		return txtSearch;
	}

	public void setTxtSearch(JTextField txtSearch) {
		this.txtSearch = txtSearch;
	}
	
	
}
