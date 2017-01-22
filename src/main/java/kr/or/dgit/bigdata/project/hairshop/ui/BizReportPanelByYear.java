package kr.or.dgit.bigdata.project.hairshop.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import org.jfree.chart.BizReportChartByYear;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import kr.or.dgit.bigdata.project.hairshop.list.BizTableByYear;
import kr.or.dgit.bigdata.project.hairshop.util.PrintFrame;

public class BizReportPanelByYear extends JPanel implements ActionListener {
	private BizTableByYear resTable;
	private JButton btnChart;
	private JButton btnPrint;

	/**
	 * Create the panel.
	 */
	public BizReportPanelByYear() {
		setBorder(new TitledBorder(null, "년도별 영업현황", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		resTable = new BizTableByYear();
		scrollPane.setViewportView(resTable);
		
		resTable.setTableWithData();
		
		JPanel btnPanel = new JPanel();	
		btnChart = new JButton("차트로 보기");
		btnChart.addActionListener(this);
		btnPanel.add(btnChart);
		
		btnPrint = new JButton("영업실적 출력");
		btnPrint.addActionListener(this);
		btnPanel.add(btnPrint);
		
		add(btnPanel, BorderLayout.SOUTH);
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
			JFrame chart = new BizReportChartByYear("년도별 실적 현황");
			RefineryUtilities.centerFrameOnScreen(chart);
			chart.setVisible(true);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
	
	protected void btnPrintActionPerformed(ActionEvent e) {
		BizTableByYear prnTable = new BizTableByYear();
		prnTable.setTableWithData();
		new PrintFrame(prnTable, "년도별 실적 조회");
	}
}
