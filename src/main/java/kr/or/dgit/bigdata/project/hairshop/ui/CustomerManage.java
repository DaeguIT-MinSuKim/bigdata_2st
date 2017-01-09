package kr.or.dgit.bigdata.project.hairshop.ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CustomerManage extends JPanel {
	private JTable table;
	private JTextField txtCno;
	private JTextField txtCname;
	private JTextField txtDob;
	private JTextField txtDojoin;
	private JTextField txtPhone;

	/**
	 * Create the panel.
	 */
	public CustomerManage() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel pnInsert = new JPanel();
		add(pnInsert, BorderLayout.NORTH);
		pnInsert.setLayout(new GridLayout(5, 2, 0, 0));
		
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
		
		txtPhone = new JTextField();
		pnInsert.add(txtPhone);
		txtPhone.setColumns(10);
		
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
		add(pnTable, BorderLayout.CENTER);
		pnTable.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		pnTable.add(table, BorderLayout.CENTER);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));

	}

}
