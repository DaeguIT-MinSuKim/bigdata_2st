package kr.or.dgit.bigdata.project.hairshop.list;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import kr.or.dgit.bigdata.project.hairshop.test.PrintFrame;

public class BizReportPanel extends JPanel implements ActionListener {
	private BizReportTable resTable;
	private JButton btnChart;
	private int year;
	private String title;
	private JButton btnPrint;

	public JButton getBtnPrint() {
		return btnPrint;
	}

	public JButton getBtnChart() {
		return btnChart;
	}

	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * Create the panel.
	 */
	public BizReportPanel() {}

	public BizReportPanel(String title) {
		this.title = title;
		setBorder(new TitledBorder(null, title+" 영업현황", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		resTable = new BizReportTable();
		scrollPane.setViewportView(resTable);
		
		if(!title.equals("월별")){
			resTable.setTableWithData("year");
		}
		JPanel btnPanel = new JPanel();
		
		btnChart = new JButton("차트로 보기");
		btnChart.addActionListener(this);
		btnPanel.add(btnChart);
		btnChart.setEnabled(false);
		
		btnPrint = new JButton("영업실적 출력");
		btnPrint.addActionListener(this);
		btnPrint.setEnabled(false);
		btnPanel.add(btnPrint);
		
		add(btnPanel, BorderLayout.SOUTH);
	}
	
	public void setResTable(int year){
		resTable.setTableWithData("month", year);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnPrint) {
			btnPrintActionPerformed(e);
		}
		if (e.getSource() == btnChart) {
			btnChartActionPerformed(e);
		}
	}
	protected void btnChartActionPerformed(ActionEvent e) {
		try {
			JFrame chart = null;
			if(title.equals("월별")){
				chart = new BizReportChartByMonth("월별 실적 현황", year);
			}else{
				chart = new BizReportChartByYear("년도별 실적 현황");
			}
			RefineryUtilities.centerFrameOnScreen(chart);
			chart.setVisible(true);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
	protected void btnPrintActionPerformed(ActionEvent e) {
		JFrame print = null;
		if(title.equals("월별")){
			print = new PrintFrame(resTable, "월별 실적 조회");
		}else{
			print = new PrintFrame(resTable, "년도별 실적 조회");
		}
	}
}
