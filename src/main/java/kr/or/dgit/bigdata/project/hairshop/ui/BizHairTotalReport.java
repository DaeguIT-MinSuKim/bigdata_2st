package kr.or.dgit.bigdata.project.hairshop.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.SwingConstants;

import org.junit.Assert;

import kr.or.dgit.bigdata.project.hairshop.dto.Biz;
import kr.or.dgit.bigdata.project.hairshop.service.BizService;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BizHairTotalReport extends JPanel {
	private JTextField tfTotalCusCnt;
	private JTextField tfTotalBizCnt;
	private JTextField tfTotalBizPrice;

	
	public JTextField getTfTotalCusCnt() {
		return tfTotalCusCnt;
	}

	public JTextField getTfTotalBizCnt() {
		return tfTotalBizCnt;
	}

	public JTextField getTfTotalBizPrice() {
		return tfTotalBizPrice;
	}


	public void setTfTotalCusCnt(JTextField tfTotalCusCnt) {
		//tfTotalCusCnt.setText(toString());
		this.tfTotalCusCnt = tfTotalCusCnt;
	}
	
	public void setTfTotalBizCnt(JTextField tfTotalBizCnt) {
		this.tfTotalBizCnt = tfTotalBizCnt;
	}
	
	public void setTfTotalBizPrice(JTextField tfTotalBizPrice) {
		this.tfTotalBizPrice = tfTotalBizPrice;
	}

	
	

	public BizHairTotalReport() {
		setLayout(null);
		
		JLabel label = new JLabel("헤어 현황");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("굴림", Font.BOLD, 16));
		label.setBounds(12, 10, 87, 15);
		add(label);
		
		JLabel label_1 = new JLabel("총고객수 :");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(118, 52, 69, 15);
		add(label_1);
		
		JLabel label_2 = new JLabel("총영업수 :");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(118, 90, 69, 15);
		add(label_2);
		
		JLabel label_3 = new JLabel("총 금 액 :");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(118, 127, 69, 15);
		add(label_3);
		
		tfTotalCusCnt = new JTextField();
		tfTotalCusCnt.setBounds(199, 49, 116, 21);
		add(tfTotalCusCnt);
		tfTotalCusCnt.setColumns(10);
		
		tfTotalBizCnt = new JTextField();
		tfTotalBizCnt.setColumns(10);
		tfTotalBizCnt.setBounds(199, 87, 116, 21);
		add(tfTotalBizCnt);
		
		tfTotalBizPrice = new JTextField();
		tfTotalBizPrice.setColumns(10);
		tfTotalBizPrice.setBounds(199, 124, 116, 21);
		add(tfTotalBizPrice);
		
		reloadData();				
	}

	public void reloadData() {//초기화 수행위해 메소드로 분리
		try {
			int tBiz = BizService.getInstance().selectCountTotalBiz();
			int tPrice = BizService.getInstance().selectCountTotalPrice();
			int tCus = BizService.getInstance().selectCountTotalCustomer();
			tfTotalCusCnt.setText(String.valueOf(tCus));
			tfTotalBizCnt.setText(String.valueOf(tBiz));
			tfTotalBizPrice.setText(String.valueOf(tPrice));
		} catch (Exception e) {
			tfTotalCusCnt.setText("null");
			tfTotalBizCnt.setText("null");
			tfTotalBizPrice.setText("null");
		}
	}
}
