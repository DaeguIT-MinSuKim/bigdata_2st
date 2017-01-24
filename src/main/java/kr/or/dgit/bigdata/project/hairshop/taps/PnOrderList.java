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
import java.awt.SystemColor;

public class PnOrderList extends JPanel {

	private HairOrderSearch pnOrderListMain;
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
		pnOrderListMain.setBackground(SystemColor.control);
		add(pnOrderListMain, BorderLayout.CENTER);
		
		pnOrderListBtns = new JPanel();
		pnOrderListBtns.setBounds(938, 0, 144, 622);
		pnOrderListBtns.setBorder(new EmptyBorder(10, 30, 10, 10));
		pnOrderListBtns.setBackground(new Color(230, 230, 250));
		add(pnOrderListBtns);
		
		btnToMain3 = new JButton("메인화면");
		btnToMain3.setBorderPainted(false);
		btnToMain3.setFocusPainted(false);
		btnToMain3.setContentAreaFilled(true);
		btnToMain3.setBounds(2, 468, 140, 156);
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
