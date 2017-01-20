package kr.or.dgit.bigdata.project.hairshop.taps;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.bigdata.project.hairshop.list.CustomerHairTable;
import kr.or.dgit.bigdata.project.hairshop.ui.HairOrderSearch;

public class PnOrderList extends JPanel {

	private HairOrderSearch pnOrderListMain;
	private CustomerHairTable hip;
	private JPanel pnOrderListBtns;
	private JButton btnToMain3;

	/**
	 * Create the panel.
	 */
	public PnOrderList() {
		setToolTipText("고객의 헤어주문내역이 나타납니다.");
		setLayout(null);
		pnOrderListMain = new HairOrderSearch();
		pnOrderListMain.setBounds(0, 0, 936, 622);
		pnOrderListMain.setBackground(new Color(255, 192, 203));
		add(pnOrderListMain, BorderLayout.CENTER);
		// 고객 헤어 정보를  보여줄 table을 담고있는 패널 ver.이유진
		JScrollPane scrollPane = new JScrollPane();			
		hip = new CustomerHairTable();
		scrollPane.setViewportView(hip);
		pnOrderListMain.add(scrollPane, BorderLayout.CENTER);
		
		pnOrderListBtns = new JPanel();
		pnOrderListBtns.setBounds(938, 0, 144, 622);
		pnOrderListBtns.setBorder(new EmptyBorder(10, 30, 10, 10));
		pnOrderListBtns.setBackground(new Color(230, 230, 250));
		add(pnOrderListBtns);
		
		btnToMain3 = new JButton("메인화면");
		btnToMain3.setFont(new Font("나눔고딕", Font.PLAIN, 16));
		btnToMain3.setBorderPainted(false);
		btnToMain3.setFocusPainted(false);
		btnToMain3.setContentAreaFilled(true);
		btnToMain3.setBounds(2, 0, 140, 156);
		pnOrderListBtns.setLayout(null);
		btnToMain3.setBackground(new Color(248, 248, 255));
		pnOrderListBtns.add(btnToMain3);	
	}

	public HairOrderSearch getPnOrderListMain() {
		return pnOrderListMain;
	}

	public void setPnOrderListMain(HairOrderSearch pnOrderListMain) {
		this.pnOrderListMain = pnOrderListMain;
	}

	public CustomerHairTable getHip() {
		return hip;
	}

	public void setHip(CustomerHairTable hip) {
		this.hip = hip;
	}

	public JPanel getPnOrderListBtns() {
		return pnOrderListBtns;
	}

	public void setPnOrderListBtns(JPanel pnOrderListBtns) {
		this.pnOrderListBtns = pnOrderListBtns;
	}

	public JButton getBtnToMain3() {
		return btnToMain3;
	}

	public void setBtnToMain3(JButton btnToMain3) {
		this.btnToMain3 = btnToMain3;
	}
	
	
}
