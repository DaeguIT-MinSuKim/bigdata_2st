package kr.or.dgit.bigdata.project.hairshop.list;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import kr.or.dgit.bigdata.project.hairshop.test.PrintFrame;

import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class BizReportPanelBySearch extends JPanel implements ActionListener {
	/* FIELDS */
	private JButton btnSearch;
	private DatePanel startDatePicker;
	private DatePanel endDatePicker;
	private JPanel srcPanel;
	private JScrollPane scrollPane;
	private JPanel btnPanel;
	private JButton btnPrint;
	private CustomerHairTable resTable;
	private String startDate;
	private String endDate;

	/* CONSTURUCTOR */
	public BizReportPanelBySearch() {
		setLayout(new BorderLayout(0, 0));
		
		srcPanel = new JPanel();
		add(srcPanel, BorderLayout.NORTH);
		JLabel lblTitle = new JLabel("기간 검색");
		srcPanel.add(lblTitle);
		
		startDatePicker = new DatePanel();
		startDatePicker.getDatePicker().addActionListener(this);
		srcPanel.add(startDatePicker);
		
		JLabel lbltemp = new JLabel("~");
		srcPanel.add(lbltemp);
		lbltemp.setHorizontalAlignment(SwingConstants.CENTER);
		
		endDatePicker = new DatePanel();
		endDatePicker.getDatePicker().addActionListener(this);
		srcPanel.add(endDatePicker);
		
		btnSearch = new JButton("검색");
		srcPanel.add(btnSearch);
		btnSearch.addActionListener(this);
		
		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		resTable = new CustomerHairTable();
		scrollPane.setViewportView(resTable);
		
		btnPanel = new JPanel();
		add(btnPanel, BorderLayout.SOUTH);
		
		btnPrint = new JButton("인쇄하기");
		btnPrint.addActionListener(this);
		btnPanel.add(btnPrint);
	}
	/* EVENT */
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == endDatePicker.getDatePicker()) {
			endDatePickerDatePickerActionPerformed(arg0);
		}
		if (arg0.getSource() == startDatePicker.getDatePicker()) {
			startDatePickerDatePickerActionPerformed(arg0);
		}
		if (arg0.getSource() == btnPrint) {
			btnPrintActionPerformed(arg0);
		}
		if (arg0.getSource() == btnSearch) {
			btnSearchActionPerformed(arg0);
		}
	}	
	protected void btnSearchActionPerformed(ActionEvent arg0) {
		/* 검색 버튼 클릭 시 각 datePicker의 값을 추출해 온 후 검색 가능한 범위인지를 우선 확인하고 유효한 범위일 경우 날짜 범위에 맞춰 검색하도록 하는 멤소드 */
		searchDate();	
		btnPrint.setEnabled(true);
	}	
	protected void btnPrintActionPerformed(ActionEvent arg0) {
		CustomerHairTable prnTable = new CustomerHairTable();
		prnTable.setTableWithData(startDate, endDate);
		new PrintFrame(prnTable, startDate+"~"+endDate+" 영업 실적");
	}
	protected void startDatePickerDatePickerActionPerformed(ActionEvent arg0) {
		btnPrint.setEnabled(false);
		startDate = "";
	}
	protected void endDatePickerDatePickerActionPerformed(ActionEvent arg0) {
		btnPrint.setEnabled(false);
		endDate="";
	}
	
	public void searchDate() {
		Calendar startCal = (Calendar) startDatePicker.getDatePicker().getJFormattedTextField().getValue();
		Calendar endCal = (Calendar) endDatePicker.getDatePicker().getJFormattedTextField().getValue();
		
		if(startCal==null || endCal==null || startCal.getTimeInMillis()>endCal.getTimeInMillis()){
			JOptionPane.showMessageDialog(null, "검색범위가 불명확합니다.", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}	
		
		resTable.setTableWithData(startDate, endDate);		
	}
}
