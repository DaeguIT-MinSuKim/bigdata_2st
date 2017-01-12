package kr.or.dgit.bigdata.project.hairshop.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class HairOrderSearch extends JPanel {
	private JTextField txtName;
	private JTextField txtNo;
	private JTable table;
	private JTextField txtD1;
	private JTextField txtD2;
	private JTextField txtD3;

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
		
		table = new JTable();
		scrollPane.setViewportView(table);

	}
	
	public void setTxtInHairIfo(int cNo, String cName, String dob){
		String[] dobArr =  dob.split("-");
		
		txtName.setText(cNo+"");
		txtNo.setText(cName);		
		txtD1.setText(dobArr[0]); 
		txtD2.setText(dobArr[1]);
		txtD3.setText(dobArr[2]);
		
	}

}
