package kr.or.dgit.bigdata.project.hairshop.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.apache.log4j.lf5.util.DateFormatManager;

import kr.or.dgit.bigdata.project.hairshop.list.BiztList;

public class BIzSearchTest extends JPanel implements ActionListener {
	/* FIELDS */
	private JTextField tfStartDate;
	private JTextField tfEndDate;
	private JButton btnSearch;
	private HairInfoPanel resPanel;
	private JComboBox<Integer> comboBox;
	private JButton btnOk;
	/* GET/SET */
	public void setResPanel(HairInfoPanel resPanel) {
		this.resPanel = resPanel;
	}

	/* CONSTURUCTOR */
	public BIzSearchTest() {
		JLabel lblNewLabel = new JLabel("기간 검색");
		add(lblNewLabel);
		
		tfStartDate = new JTextField();
		add(tfStartDate);
		tfStartDate.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("~");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel_1);
		
		tfEndDate = new JTextField();
		add(tfEndDate);
		tfEndDate.setColumns(10);
		
		btnSearch = new JButton("검색");
		btnSearch.addActionListener(this);
		add(btnSearch);
		
		setTextFields();
	}

	private void setTextFields() {
		Calendar cal = Calendar.getInstance();
		DateFormatManager dfm = new DateFormatManager("yyyy-MM-dd");
		String textToday = dfm.format(cal.getTime());
		tfStartDate.setText(textToday);
		tfEndDate.setText(textToday);		
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnOk) {
			btnOkActionPerformed(arg0);
		}
		if (arg0.getSource() == btnSearch) {
			btnSearchActionPerformed(arg0);
		}
	}
	protected void btnSearchActionPerformed(ActionEvent arg0) {
		String startDate = tfStartDate.getText().trim();
		String endDate = tfEndDate.getText().trim();
		if(startDate==""||endDate==""||!isVailable(startDate,endDate)){
			JOptionPane.showMessageDialog(null, "검색범위가 불명확합니다.", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}		
		((BiztList)resPanel.getTable()).setTableWithData(startDate, endDate);
	}

	private boolean isVailable(String startDate, String endDate) {
		int iStartDate = convertToInteger(startDate);
		int iEndDate = convertToInteger(endDate);
		if(iStartDate>iEndDate){
			return false;
		}else{
			return true;
		}		
	}

	private int convertToInteger(String date) {
		if(date==""){
			return -1;
		}
		
		String[] list = date.split("-");
		String convertDate = "";
		for(int i=0;i<list.length;i++){
			convertDate+= list[i];
		}
		return Integer.parseInt(convertDate);
	}
	protected void btnOkActionPerformed(ActionEvent arg0){
		
	};
}
