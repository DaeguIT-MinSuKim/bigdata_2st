package kr.or.dgit.bigdata.project.hairshop.test;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import kr.or.dgit.bigdata.project.hairshop.list.ReportTable;

public class BizReportPanel extends JPanel {
	private ReportTable resTable;

	/**
	 * Create the panel.
	 */
	public BizReportPanel() {}

	public BizReportPanel(String title) {
		setBorder(new TitledBorder(null, title+" 영업현황", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);
		
		resTable = new ReportTable();
		scrollPane.setViewportView(resTable);
		
		if(!title.equals("월별")){
			resTable.setTableWithData("year");
		}
	}
	
	public void setResTable(int year){
		resTable.setTableWithData("month", year);
	}

}
