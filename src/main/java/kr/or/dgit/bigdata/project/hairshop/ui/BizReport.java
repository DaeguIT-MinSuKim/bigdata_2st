package kr.or.dgit.bigdata.project.hairshop.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.bigdata.project.hairshop.list.BizReportPanelByMonth;
import kr.or.dgit.bigdata.project.hairshop.list.BizReportPanelBySearch;
import kr.or.dgit.bigdata.project.hairshop.list.BizReportPanelByYear;

public class BizReport extends JPanel implements ActionListener {
	/* main 화면 영업현황 tab 선택시 나타날 메인 화면 */
	private JPanel pnBizListMain;
	private JPanel pnBizListBtns;
	private JButton btnDate;
	private JButton btnMonth;
	private JButton btnYear;
	private JButton btnToMain4;
	private BizReportPanelBySearch pSearchDate;

	/**
	 * Create the panel.
	 */
	public BizReport() {
		setToolTipText("날짜, 월별 ,연도별 영업현황이 나타납니다.");
		setLayout(null);
		setBounds(0, 0, 1080, 629);
		
		
		pnBizListMain = new JPanel();
		pnBizListMain.setBounds(0, 0, 936, 622);
		pnBizListMain.setBackground(new Color(240, 240, 240));
		add(pnBizListMain);
		pnBizListMain.setLayout(new BorderLayout(0, 0));
		
		pnBizListBtns = new JPanel();
		pnBizListBtns.setBounds(938, 0, 144, 622);
		pnBizListBtns.setBorder(new EmptyBorder(10, 30, 10, 10));
		pnBizListBtns.setBackground(new Color(230,230,250));
		add(pnBizListBtns);
		
		btnDate = new JButton("기간별");
		btnDate.setBounds(2, 0, 140, 156);
		btnDate.setBorderPainted(false);
		btnDate.setFocusPainted(false);
		btnDate.setContentAreaFilled(true);
		btnDate.addActionListener(this);
		pnBizListBtns.setLayout(null);
		btnDate.setBackground(new Color(248, 248, 255));
		pnBizListBtns.add(btnDate);
		
		btnMonth = new JButton("월별");
		btnMonth.setBounds(2, 156, 140, 156);
		btnMonth.setBorderPainted(false);
		btnMonth.setFocusPainted(false);
		btnMonth.setContentAreaFilled(true);
		btnMonth.addActionListener(this);
		btnMonth.setBackground(new Color(248, 248, 255));
		pnBizListBtns.add(btnMonth);
		
		btnYear = new JButton("연도별");
		btnYear.setBounds(2, 312, 140, 156);
		btnYear.setBorderPainted(false);
		btnYear.setFocusPainted(false);
		btnYear.setContentAreaFilled(true);
		btnYear.addActionListener(this);
		btnYear.setBackground(new Color(248, 248, 255));
		pnBizListBtns.add(btnYear);
		
		btnToMain4 = new JButton("메인화면");
		btnToMain4.setBounds(2, 468, 140, 156);
		btnToMain4.setBorderPainted(false);
		btnToMain4.setFocusPainted(false);
		btnToMain4.setContentAreaFilled(true);
		btnToMain4.addActionListener(this);
		btnToMain4.setBackground(new Color(248, 248, 255));
		pnBizListBtns.add(btnToMain4);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnToMain4) {
			btnToMain4ActionPerformed(e);
		}
		if (e.getSource() == btnYear) {
			btnYearActionPerformed(e);
		}
		if (e.getSource() == btnMonth) {
			btnMonthActionPerformed(e);
		}
		if (e.getSource() == btnDate) {
			btnDateActionPerformed(e);
		}
	}
	protected void btnDateActionPerformed(ActionEvent e) {
		setDefaultPnBizListMain();		
	}
	
	public void setDefaultPnBizListMain() {
		pnBizListMain.removeAll();	
		pSearchDate = new BizReportPanelBySearch();
		pSearchDate.searchDate();
		pnBizListMain.add(pSearchDate, BorderLayout.CENTER);		
		revalidate();
		repaint();		
	}

	protected void btnMonthActionPerformed(ActionEvent e) {
		/* 월별로 검색할 떄 띄울 패널 향후 combo박스에 영업DB내에 있는 영업일자 년도를 검색해서 넣을 메소드 만들 예정 -by.이유진 */
		pnBizListMain.removeAll();
		BizReportPanelByMonth monthlyPanel = new BizReportPanelByMonth(); 
		pnBizListMain.add(monthlyPanel, BorderLayout.CENTER);
		revalidate();
		repaint();
	}

	protected void btnYearActionPerformed(ActionEvent e) {
		pnBizListMain.removeAll();
		BizReportPanelByYear brp = new BizReportPanelByYear();
		pnBizListMain.add(brp, BorderLayout.CENTER);
		revalidate();
		repaint();
	}
	protected void btnToMain4ActionPerformed(ActionEvent e) {
		/* main 화면으로 돌아가는 메소드. 향후 추가 예정 */
	}
}

