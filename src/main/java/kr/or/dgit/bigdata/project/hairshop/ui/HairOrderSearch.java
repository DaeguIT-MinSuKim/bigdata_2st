package kr.or.dgit.bigdata.project.hairshop.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import kr.or.dgit.bigdata.project.hairshop.dto.Customer;
import kr.or.dgit.bigdata.project.hairshop.list.CustomerHairTable;
import kr.or.dgit.bigdata.project.hairshop.list.HairOrderInfoList;

public class HairOrderSearch extends JPanel {
	private JTextField txtName;
	private JTextField txtNo;
	private JTextField txtD1;
	private JTextField txtD2;
	private JTextField txtD3;
	private HairOrderInfoList table;
	private String[] chi = { "영업번호", "영업일자", "헤어명", "단가", "이벤트명", "금액" };
	private JScrollPane scrollPaneInOrderLsit;

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
		scrollPaneInOrderLsit = new JScrollPane();
		add(scrollPaneInOrderLsit, BorderLayout.CENTER);
		table = new HairOrderInfoList();
		table.setEnabled(false);
		table.setCellSelectionEnabled(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(new Object[][] {}, chi));
		scrollPaneInOrderLsit.setViewportView(table);
		
	}

	public void setTxtInHairIfo(int cNo, String cName, String dob) {
		String[] dobArr = dob.split("-");

		txtNo.setText(cNo + "");
		txtName.setText(cName);
		txtD1.setText(dobArr[0]);
		txtD2.setText(dobArr[1]);
		txtD3.setText(dobArr[2]);
	}
	

	public void reloadData() {			
		table.reloadData(txtNo.getText(), chi);		
	}
}