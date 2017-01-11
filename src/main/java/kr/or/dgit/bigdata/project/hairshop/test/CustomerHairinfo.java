package kr.or.dgit.bigdata.project.hairshop.test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.apache.log4j.lf5.util.DateFormatManager;

import kr.or.dgit.bigdata.project.hairshop.dto.Customer;
import kr.or.dgit.bigdata.project.hairshop.list.BiztList;

public class CustomerHairinfo extends JPanel {
	private JTextField tfNo;
	private JTextField tfName;
	private JTextField tfDob;
	private HairInfoPanel hairInfoPanel;
	private Customer customer;

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setHairInfoPanel(HairInfoPanel hairInfoPanel) {
		this.hairInfoPanel = hairInfoPanel;
	}

	/**
	 * Create the panel.
	 */
	public CustomerHairinfo() {
		setBorder(new EmptyBorder(20, 20, 20, 20));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 2, 20, 0));
		
		JLabel lblNewLabel = new JLabel("고객번호 : ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblNewLabel);
		
		tfNo = new JTextField();
		panel.add(tfNo);
		tfNo.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("고 객 명 : ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblNewLabel_1);
		
		tfName = new JTextField();
		panel.add(tfName);
		tfName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("생년월일 : ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblNewLabel_2);
		
		tfDob = new JTextField();
		panel.add(tfDob);
		tfDob.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
	}

	public void setTextFields(Customer customer) {
		tfNo.setText(customer.getcNo()+"");
		tfName.setText(customer.getcName());
		DateFormatManager dfm = new DateFormatManager("yyyy-MM-dd");
		tfDob.setText(dfm.format(customer.getcDob()));
		
		((BiztList)hairInfoPanel.getTable()).setTableWithData(customer);
		revalidate();
	}

}
