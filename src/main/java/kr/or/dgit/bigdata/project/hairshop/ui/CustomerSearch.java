package kr.or.dgit.bigdata.project.hairshop.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.bigdata.project.hairshop.list.CustomerSearchListForAll;
import kr.or.dgit.bigdata.project.hairshop.list.CustomerSearchListForOne;

public class CustomerSearch extends JPanel {
	private CustomerSearchListForOne table;
	private JTextField txtSearch;
	private String cName;
	private int cNo;
	private String dob;
	private String doJoin;
	private String phone;
	private CustomerSearchListForAll tableForAll;
	private JScrollPane scrollPane;
	
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
		
		table = new CustomerSearchListForOne();
		table.setCellSelectionEnabled(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		tableForAll = new CustomerSearchListForAll();
		tableForAll.setCellSelectionEnabled(true);
		tableForAll.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableForAll.reloadDataForAll();
		scrollPane.setViewportView(tableForAll);
		

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

	public CustomerSearchListForOne getTable() {
		return table;
	}

	public void setTable(CustomerSearchListForOne table) {
		this.table = table;
	}

	public JTextField getTxtSearch() {
		return txtSearch;
	}

	public void setTxtSearch(JTextField txtSearch) {
		this.txtSearch = txtSearch;
	}	
	
	public CustomerSearchListForAll getTableForAll() {
		return tableForAll;
	}

	public void setTableForAll(CustomerSearchListForAll tableForAll) {
		this.tableForAll = tableForAll;
	}
	
	private void searchClick() {
		cName = txtSearch.getText();
		table.reloadData(cName);
		scrollPane.setViewportView(table);
	}
	private void searchAll() {
		tableForAll.reloadDataForAll();
		scrollPane.setViewportView(tableForAll);
	}
	
}