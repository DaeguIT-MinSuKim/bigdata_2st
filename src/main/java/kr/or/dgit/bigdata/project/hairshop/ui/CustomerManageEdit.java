package kr.or.dgit.bigdata.project.hairshop.ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class CustomerManageEdit extends JPanel {
	private JTextField txtCno;
	private JTextField txtCname;
	private JTextField txtDob;
	private JTextField txtDojoin;
	private JTextField txtP1;
	private JTextField txtP2;
	private JTextField txtP3;
	private JTable table;

	/**
	 * Create the panel.
	 */
	
	
	
	
	public CustomerManageEdit() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel pnInsert = new JPanel();
		pnInsert.setBorder(new EmptyBorder(10, 10, 10, 10));
		add(pnInsert, BorderLayout.CENTER);
		pnInsert.setLayout(new GridLayout(5, 2, 5, 5));
		
		JLabel lblCno = new JLabel("고객번호");
		lblCno.setHorizontalAlignment(SwingConstants.CENTER);
		pnInsert.add(lblCno);
		
		txtCno = new JTextField();
		pnInsert.add(txtCno);
		txtCno.setColumns(10);
		
		JLabel lblCname = new JLabel("성명");
		lblCname.setHorizontalAlignment(SwingConstants.CENTER);
		pnInsert.add(lblCname);
		
		txtCname = new JTextField();
		pnInsert.add(txtCname);
		txtCname.setColumns(10);
		
		JLabel lblPhone = new JLabel("전화번호");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		pnInsert.add(lblPhone);
		
		JPanel pnPhone = new JPanel();
		pnPhone.setBorder(new EmptyBorder(0, 0, 0, 0));
		pnInsert.add(pnPhone);
		pnPhone.setLayout(new GridLayout(0, 5, 0, 0));
		
		txtP1 = new JTextField();
		pnPhone.add(txtP1);
		txtP1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("-");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pnPhone.add(lblNewLabel);
		
		txtP2 = new JTextField();
		txtP2.setColumns(10);
		pnPhone.add(txtP2);
		
		JLabel lblNewLabel_1 = new JLabel("-");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		pnPhone.add(lblNewLabel_1);
		
		txtP3 = new JTextField();
		pnPhone.add(txtP3);
		txtP3.setColumns(10);
		
		JLabel lblDob = new JLabel("생년월일");
		lblDob.setHorizontalAlignment(SwingConstants.CENTER);
		pnInsert.add(lblDob);
		
		txtDob = new JTextField();
		pnInsert.add(txtDob);
		txtDob.setColumns(10);
		
		JLabel lblDojoin = new JLabel("가입일자");
		lblDojoin.setHorizontalAlignment(SwingConstants.CENTER);
		pnInsert.add(lblDojoin);
		
		txtDojoin = new JTextField();
		pnInsert.add(txtDojoin);
		txtDojoin.setColumns(10);
		
		JPanel pnTable = new JPanel();
		add(pnTable, BorderLayout.SOUTH);
		pnTable.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		pnTable.add(table, BorderLayout.NORTH);

	}

	public JTextField getTxtCno() {
		return txtCno;
	}

	public void setTxtCno(JTextField txtCno) {
		this.txtCno = txtCno;
	}

	public JTextField getTxtCname() {
		return txtCname;
	}

	public void setTxtCname(JTextField txtCname) {
		this.txtCname = txtCname;
	}

	public JTextField getTxtDob() {
		return txtDob;
	}

	public void setTxtDob(JTextField txtDob) {
		this.txtDob = txtDob;
	}

	public JTextField getTxtDojoin() {
		return txtDojoin;
	}

	public void setTxtDojoin(JTextField txtDojoin) {
		this.txtDojoin = txtDojoin;
	}

	public JTextField getTxtP1() {
		return txtP1;
	}

	public void setTxtP1(JTextField txtP1) {
		this.txtP1 = txtP1;
	}

	public JTextField getTxtP2() {
		return txtP2;
	}

	public void setTxtP2(JTextField txtP2) {
		this.txtP2 = txtP2;
	}

	public JTextField getTxtP3() {
		return txtP3;
	}

	public void setTxtP3(JTextField txtP3) {
		this.txtP3 = txtP3;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
	

}
