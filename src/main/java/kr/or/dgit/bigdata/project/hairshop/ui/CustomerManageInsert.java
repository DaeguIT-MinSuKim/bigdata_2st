package kr.or.dgit.bigdata.project.hairshop.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.GregorianCalendar;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import kr.or.dgit.bigdata.project.hairshop.dto.Customer;
import kr.or.dgit.bigdata.project.hairshop.service.CustomerService;

public class CustomerManageInsert extends JPanel {
	private JTextField txtCno;
	private JTextField txtCname;
	private JTextField txtP1;
	private JTextField txtP2;
	private JTextField txtP3;
	private JTable table;
	private JTextField txtD1;
	private JTextField txtD2;
	private JTextField txtD3;
	private JTextField txtDJ1;
	private JTextField txtDJ2;
	private JTextField txtDJ3;

	/**
	 * Create the panel.
	 */
	public CustomerManageInsert() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel pnInsert = new JPanel();
		pnInsert.setBorder(new EmptyBorder(10, 10, 10, 10));
		add(pnInsert, BorderLayout.NORTH);
		pnInsert.setLayout(new GridLayout(5, 2, 5, 5));
		
		JLabel lblCno = new JLabel("고객번호");
		lblCno.setHorizontalAlignment(SwingConstants.CENTER);
		pnInsert.add(lblCno);
		
		txtCno = new JTextField();
		txtCno.setEditable(false);
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
		
		JPanel pnDob = new JPanel();
		pnDob.setBorder(new EmptyBorder(0, 0, 0, 0));
		pnInsert.add(pnDob);
		pnDob.setLayout(new GridLayout(0, 5, 0, 0));
		
		txtD1 = new JTextField();
		txtD1.setColumns(10);
		pnDob.add(txtD1);
		
		JLabel label = new JLabel("-");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		pnDob.add(label);
		
		txtD2 = new JTextField();
		txtD2.setColumns(10);
		pnDob.add(txtD2);
		
		JLabel label_1 = new JLabel("-");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		pnDob.add(label_1);
		
		txtD3 = new JTextField();
		txtD3.setColumns(10);
		pnDob.add(txtD3);
		
		JLabel lblDojoin = new JLabel("가입일자");
		lblDojoin.setHorizontalAlignment(SwingConstants.CENTER);
		pnInsert.add(lblDojoin);
		
		JPanel pnDJ = new JPanel();
		pnDJ.setBorder(new EmptyBorder(0, 0, 0, 0));
		pnInsert.add(pnDJ);
		pnDJ.setLayout(new GridLayout(0, 5, 0, 0));
		
		txtDJ1 = new JTextField();
		txtDJ1.setColumns(10);
		pnDJ.add(txtDJ1);
		
		JLabel label_2 = new JLabel("-");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		pnDJ.add(label_2);
		
		txtDJ2 = new JTextField();
		txtDJ2.setColumns(10);
		pnDJ.add(txtDJ2);
		
		JLabel label_3 = new JLabel("-");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		pnDJ.add(label_3);
		
		txtDJ3 = new JTextField();
		txtDJ3.setColumns(10);
		pnDJ.add(txtDJ3);
		
		JPanel pnTable = new JPanel();
		add(pnTable, BorderLayout.CENTER);
		pnTable.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"고객 번호", "고객명", "생년월일", "가입일자", "전화번호"
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

	

	public JTextField getTxtD1() {
		return txtD1;
	}

	public void setTxtD1(JTextField txtD1) {
		this.txtD1 = txtD1;
	}

	public JTextField getTxtD2() {
		return txtD2;
	}

	public void setTxtD2(JTextField txtD2) {
		this.txtD2 = txtD2;
	}

	public JTextField getTxtD3() {
		return txtD3;
	}

	public void setTxtD3(JTextField txtD3) {
		this.txtD3 = txtD3;
	}

	public JTextField getTxtDJ1() {
		return txtDJ1;
	}

	public void setTxtDJ1(JTextField txtDJ1) {
		this.txtDJ1 = txtDJ1;
	}

	public JTextField getTxtDJ2() {
		return txtDJ2;
	}

	public void setTxtDJ2(JTextField txtDJ2) {
		this.txtDJ2 = txtDJ2;
	}

	public JTextField getTxtDJ3() {
		return txtDJ3;
	}

	public void setTxtDJ3(JTextField txtDJ3) {
		this.txtDJ3 = txtDJ3;
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
	
	public void insertNewCostomer(){
		
		int d1 = Integer.parseInt(txtD1.getText());
		int d2 = Integer.parseInt(txtD2.getText());
		int d3 = Integer.parseInt(txtD3.getText());
		
		int dj1 = Integer.parseInt(txtDJ1.getText());
		int dj2 = Integer.parseInt(txtDJ2.getText());
		int dj3 = Integer.parseInt(txtDJ3.getText());
		
		String phoneNumber =  txtP1.getText()+"-"+txtP2.getText()+"-"+txtP3.getText();
		
		GregorianCalendar cal1 = new GregorianCalendar(d1, d2, d3);
		GregorianCalendar cal2 = new GregorianCalendar(dj1, dj2, dj3);
		Customer insCtm = new Customer();
		insCtm.setcName(txtCname.getText());
		insCtm.setcDob(cal1.getTime());
		insCtm.setcDoJoin(cal2.getTime());
		insCtm.setcPhone(phoneNumber);
		insCtm.setcDel(false);
		

		CustomerService.getInstance().insertCustomer(insCtm);
		
		
	}
	

}
