package kr.or.dgit.bigdata.project.hairshop.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import org.jfree.chart.BizReportChartByMonth;
import org.jfree.ui.RefineryUtilities;

import kr.or.dgit.bigdata.project.hairshop.list.BizTableByMonth;
import kr.or.dgit.bigdata.project.hairshop.service.BizService;
import kr.or.dgit.bigdata.project.hairshop.util.PrintFrame;

import javax.swing.JLabel;

public class BizReportPanelByMonth extends JPanel implements ActionListener, ItemListener {
	/* FIELDS*/
	private JPanel srcPanel;
	private JLabel lblYear;
	private JComboBox<Integer> cmbYear;
	private BizTableByMonth resTable;
	private JButton btnSearch;
	private JButton btnChart;
	private JButton btnPrint;	
	private int year=-1;

	/**
	 * Create the panel.
	 */
	public BizReportPanelByMonth() {
		setBorder(new TitledBorder(null, "월별 실적 조회", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		setLayout(new BorderLayout(0, 0));
		
		srcPanel = new JPanel();
		add(srcPanel, BorderLayout.NORTH);
		
		lblYear = new JLabel("년도 : ");
		srcPanel.add(lblYear);
		
		cmbYear = new JComboBox<>();
		cmbYear.setMaximumRowCount(90);
		srcPanel.add(cmbYear);		
		cmbYear.addItemListener(this);
		
		btnSearch = new JButton("검색");
		btnSearch.addActionListener(this);
		srcPanel.add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		resTable = new BizTableByMonth();
		scrollPane.setViewportView(resTable);
		
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
		setcmbYear();
	}
	
	private void setcmbYear() {		
		try{
			List<Integer> temp = BizService.getInstance().selectBDateYear();
			Integer[] yList = temp.toArray(new Integer[temp.size()]);
			if(yList.length==0){
				cmbYear.setEnabled(false);
				btnSearch.setEnabled(false);
				return;
			}
			cmbYear.setModel(new DefaultComboBoxModel<>(yList));
		}catch(Exception e){
			cmbYear.setEnabled(false);
			btnSearch.setEnabled(false);
		}
	}
	
	public void setResTable(int year){
		resTable.setTableWithData(year);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnPrint) {
			btnPrintActionPerformed(e);
		}
		if (e.getSource() == btnChart) {
			btnChartActionPerformed(e);
		}
		if(e.getSource() == btnSearch){
			btnSearchActionPerformed(e);
		}
	}
	
	protected void btnChartActionPerformed(ActionEvent e) {
		try {
			if(year != -1){
				JFrame chart = new BizReportChartByMonth(year+"년도 월별 실적", year);
				RefineryUtilities.centerFrameOnScreen(chart);
				chart.setVisible(true);
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}		
	}
	
	protected void btnPrintActionPerformed(ActionEvent e) {
		if(year!= -1){
			JTable newTable = new JTable();//
			newTable.setModel(resTable.getModel());	
			new PrintFrame(newTable, year+"년도 월별 실적");
		}
	}
	
	protected void btnSearchActionPerformed(ActionEvent e) {
		year = (int) cmbYear.getSelectedItem();
		setResTable(year);		
		setBorder(new TitledBorder(null, year+"년도 월별 실적", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		btnChart.setEnabled(true);
		btnPrint.setEnabled(true);
		revalidate();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cmbYear) {
			cmbYearItemStateChanged(e);
		}
		
	}

	private void cmbYearItemStateChanged(ItemEvent e) {
		btnChart.setEnabled(false);		
		btnPrint.setEnabled(false);
		year = -1;
	}
}
