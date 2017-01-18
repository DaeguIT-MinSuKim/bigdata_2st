package kr.or.dgit.bigdata.project.hairshop.test;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
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

import kr.or.dgit.bigdata.project.hairshop.dto.Customer;
import kr.or.dgit.bigdata.project.hairshop.service.CustomerService;

public class CustomerSearch extends JPanel implements ActionListener {
	private JTable table;
	private JTextField txtSearch;
	private String cName;
	private int cNo;
	private String dob;
	private String doJoin;
	private String phone;
	private JTable tableForAll;
	private JScrollPane scrollPane;
	private JButton btnPrint;
	
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
				
				searchClick();				
				
			}

			
		});
		pnSearch.add(btnOk);
		
		JButton btnForall = new JButton("전체 회원");
		btnForall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchAll();
			}
			
		});
		pnSearch.add(btnForall);
		
		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setCellSelectionEnabled(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		tableForAll = new JTable();
		tableForAll.setCellSelectionEnabled(true);
		tableForAll.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPane.setViewportView(tableForAll);
		
		JPanel pnPrint = new JPanel();
		add(pnPrint, BorderLayout.SOUTH);
		
		btnPrint = new JButton("고객목록 인쇄");
		btnPrint.addActionListener(this);
		btnPrint.setEnabled(false);
		pnPrint.add(btnPrint);
		
		reloadDataForAll();
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
	
	public JTable getTableForAll() {
		return tableForAll;
	}

	public void setTableForAll(JTable tableForAll) {
		this.tableForAll = tableForAll;
	}

	protected void tableSetAlignWithForAll() {//
		tableCellAlignmentForAll(SwingConstants.CENTER, 0, 1, 2, 3, 4);
		tableSetWidthForAll(60, 100, 200, 200, 200);
	}
	
	protected void tableCellAlignmentForAll(int align, int... idx) {//
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);
		TableColumnModel model = tableForAll.getColumnModel();
		for (int i = 0; i < idx.length; i++) {
			model.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}
	protected void tableSetWidthForAll(int... width) {//
		TableColumnModel model = tableForAll.getColumnModel();
		for (int i = 0; i < width.length; i++) {
			model.getColumn(i).setPreferredWidth(width[i]);
		}
	}
	String[][] getRowDataForAll() { // 전체 표 읽어오기
		List<Customer> list = CustomerService.getInstance().selectByAll();
		String[][] rowDatas = new String[list.size()][];
		for (int i = 0; i < list.size(); i++) {
			rowDatas[i] = list.get(i).toArray();
		}

		return rowDatas;
	}
	private void reloadDataForAll() {
		DefaultTableModel model = new DefaultTableModel(getRowDataForAll(), getColumnData());
		tableForAll.setModel(model);
		tableSetAlignWithForAll();	
		btnPrint.setEnabled(true);
	}
	private void searchClick() {
		cName = txtSearch.getText();
		reloadData();
		scrollPane.setViewportView(table);
	}
	private void searchAll() {
		reloadDataForAll();
		scrollPane.setViewportView(tableForAll);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnPrint) {
			btnPrintActionPerformed(e);
		}
	}
	protected void btnPrintActionPerformed(ActionEvent e) {
		/* 실행시 패널에 있는 목록이 없어지는 문제 발생 */
		PrintFrame tpd1 = new PrintFrame((JTable) scrollPane.getViewport().getComponent(0), "고객 목록");
		tpd1.setVisible(true);
	}
}