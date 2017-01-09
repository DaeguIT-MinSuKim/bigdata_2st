package kr.or.dgit.bigdata.project.hairshop.ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

public class CustomerHairInfo extends JPanel {
	private JTable table;
	private JTextField txtCno;
	private JTextField txtCname;
	private JTextField txtDob;
	private JTextField txtP1;
	private JTextField txtP2;
	private JTextField txtP3;

	/**
	 * Create the panel.
	 */
	public CustomerHairInfo() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel pnInfo = new JPanel();
		pnInfo.setBorder(new EmptyBorder(10, 10, 10, 10));
		add(pnInfo, BorderLayout.NORTH);
		pnInfo.setLayout(new GridLayout(4, 2, 5, 5));
		
		JLabel lblCno = new JLabel("고객번호");
		lblCno.setHorizontalAlignment(SwingConstants.CENTER);
		pnInfo.add(lblCno);
		
		txtCno = new JTextField();
		
		pnInfo.add(txtCno);
		txtCno.setColumns(10);
		
		JLabel lblCname = new JLabel("성명");
		lblCname.setHorizontalAlignment(SwingConstants.CENTER);
		pnInfo.add(lblCname);
		
		txtCname = new JTextField();
		
		pnInfo.add(txtCname);
		txtCname.setColumns(10);
		
		JLabel lblPhone = new JLabel("전화번호");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		pnInfo.add(lblPhone);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		pnInfo.add(panel);
		panel.setLayout(new GridLayout(0, 5, 0, 0));
		
		txtP1 = new JTextField();
		txtP1.setColumns(10);
		panel.add(txtP1);
		
		JLabel label = new JLabel("-");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label);
		
		txtP2 = new JTextField();
		txtP2.setColumns(10);
		panel.add(txtP2);
		
		JLabel label_1 = new JLabel("-");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label_1);
		
		txtP3 = new JTextField();
		txtP3.setColumns(10);
		panel.add(txtP3);
		
		JLabel lblDob = new JLabel("생년월일");
		lblDob.setHorizontalAlignment(SwingConstants.CENTER);
		pnInfo.add(lblDob);
		
		txtDob = new JTextField();
		
		pnInfo.add(txtDob);
		txtDob.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(table);

	}

}
