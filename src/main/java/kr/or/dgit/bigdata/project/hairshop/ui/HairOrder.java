package kr.or.dgit.bigdata.project.hairshop.ui;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.DefaultComboBoxModel;

public class HairOrder extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	/**
	 * Create the panel.
	 */
	public HairOrder() {
		setForeground(Color.BLUE);
		setBorder(new EmptyBorder(15, 10, 10, 10));
		setLayout(new GridLayout(0, 4, 10, 10));
		
		JLabel lblBNo = new JLabel("영업번호");
		lblBNo.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblBNo);
		
		textField = new JTextField();
		add(textField);
		textField.setColumns(10);
		
		JLabel lblGap1 = new JLabel("");
		add(lblGap1);
		
		JLabel lblGap2 = new JLabel("");
		add(lblGap2);
		
		JLabel lblBData = new JLabel("영업일자");
		lblBData.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblBData);
		
		textField_1 = new JTextField();
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblBTime = new JLabel("방문시간");
		lblBTime.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblBTime);
		
		textField_2 = new JTextField();
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblCName = new JLabel("고객명");
		lblCName.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblCName);
		
		textField_3 = new JTextField();
		add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblCNO = new JLabel("고객번호");
		lblCNO.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblCNO);
		
		textField_4 = new JTextField();
		add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblHName = new JLabel("헤어명");
		lblHName.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblHName);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"커트", "드라이", "샴푸", "펌", "매직", "트리트먼트", "앰플", "기타"}));
		add(comboBox);
		
		JLabel lblHNO = new JLabel("헤어번호");
		lblHNO.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblHNO);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblHPrice = new JLabel("단가");
		lblHPrice.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblHPrice);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblGap3 = new JLabel("");
		add(lblGap3);
		
		JLabel lblGap4 = new JLabel("");
		add(lblGap4);
		
		JLabel lblEName = new JLabel("이벤트명");
		lblEName.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblEName);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"기획", "생일", "일반", "조조"}));
		add(comboBox_1);
		
		JLabel lblEDiscount = new JLabel("할인율");
		lblEDiscount.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblEDiscount);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblENO = new JLabel("이벤트번호");
		lblENO.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblENO);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblTotalPrice = new JLabel("금액");
		lblTotalPrice.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblTotalPrice);
		
		textField_9 = new JTextField();
		textField_9.setEditable(false);
		add(textField_9);
		textField_9.setColumns(10);

	}

}