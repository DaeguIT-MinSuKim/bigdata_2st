package kr.or.dgit.bigdata.project.hairshop.taps;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.bigdata.project.hairshop.ui.HairOrder;

public class PnHairOder extends JPanel {

	private HairOrder pnHairOderMain;
	private JPanel pnHairOderBtns;
	private JButton btnOrder;
	private JButton btnHairInfo;
	private JButton btnToMain2;

	/**
	 * Create the panel.
	 */
	public PnHairOder() {
		setLayout(null);
		pnHairOderMain = new HairOrder();
		pnHairOderMain.setBounds(0, 0, 936, 622);
		pnHairOderMain.getTfTotal().setEditable(false);
		pnHairOderMain.getTfEDiscount().setEditable(false);
		pnHairOderMain.getTfENo().setEditable(false);
		pnHairOderMain.getTfHNo().setEditable(false);
		pnHairOderMain.getTfHPrice().setEditable(false);
		pnHairOderMain.setBackground(SystemColor.menu);
		add(pnHairOderMain);
		
		pnHairOderBtns = new JPanel();
		pnHairOderBtns.setBounds(938, 0, 144, 622);
		pnHairOderBtns.setBorder(new EmptyBorder(10, 30, 10, 10));
		pnHairOderBtns.setBackground(new Color(230, 230, 250));
		add(pnHairOderBtns);
		
		btnOrder = new JButton("주문");
		btnOrder.setBounds(2, 0, 140, 156);
		btnOrder.setBorderPainted(false);
		btnOrder.setFocusPainted(false);
		btnOrder.setContentAreaFilled(true);
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnOrderActionPerformed(arg0);//
			}
		});
		pnHairOderBtns.setLayout(null);
		btnOrder.setBackground(new Color(248, 248, 255));
		pnHairOderBtns.add(btnOrder);
		
		btnHairInfo = new JButton("헤어정보");
		btnHairInfo.setBounds(2, 156, 140, 156);
		btnHairInfo.setBorderPainted(false);
		btnHairInfo.setFocusPainted(false);
		btnHairInfo.setContentAreaFilled(true);
		btnHairInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnHairInfoActionPerformed(e);//
			}
		});
		btnHairInfo.setToolTipText("해당 고객의 헤어 스타일 내역으로 이동합니다.");
		btnHairInfo.setBackground(new Color(248, 248, 255));
		pnHairOderBtns.add(btnHairInfo);
		
		btnToMain2 = new JButton("메인화면");
		btnToMain2.setBounds(2, 312, 140, 156);
		btnToMain2.setBorderPainted(false);
		btnToMain2.setFocusPainted(false);
		btnToMain2.setContentAreaFilled(true);
		btnToMain2.setBackground(new Color(248, 248, 255));
		btnToMain2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnToMainActionPerformed(e);//
			}
		});
		pnHairOderBtns.add(btnToMain2);
	}

	public HairOrder getPnHairOderMain() {
		return pnHairOderMain;
	}

	public void setPnHairOderMain(HairOrder pnHairOderMain) {
		this.pnHairOderMain = pnHairOderMain;
	}

	public JPanel getPnHairOderBtns() {
		return pnHairOderBtns;
	}

	public void setPnHairOderBtns(JPanel pnHairOderBtns) {
		this.pnHairOderBtns = pnHairOderBtns;
	}

	public JButton getBtnOrder() {
		return btnOrder;
	}

	public void setBtnOrder(JButton btnOrder) {
		this.btnOrder = btnOrder;
	}

	public JButton getBtnHairInfo() {
		return btnHairInfo;
	}

	public void setBtnHairInfo(JButton btnHairInfo) {
		this.btnHairInfo = btnHairInfo;
	}

	public JButton getBtnToMain2() {
		return btnToMain2;
	}

	public void setBtnToMain2(JButton btnToMain2) {
		this.btnToMain2 = btnToMain2;
	}
	

}
