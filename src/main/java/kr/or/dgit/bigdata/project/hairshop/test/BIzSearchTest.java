package kr.or.dgit.bigdata.project.hairshop.test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.lf5.util.DateFormatManager;

import kr.or.dgit.bigdata.project.hairshop.list.BiztList;

public class BIzSearchTest extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfStartDate;
	private JTextField tfEndDate;
	private JTable table;
	private JButton btnSearch;
	private JPanel panel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BIzSearchTest frame = new BIzSearchTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BIzSearchTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("기간 검색");
		panel.add(lblNewLabel);
		
		tfStartDate = new JTextField();
		panel.add(tfStartDate);
		tfStartDate.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("~");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);
		
		tfEndDate = new JTextField();
		panel.add(tfEndDate);
		tfEndDate.setColumns(10);
		
		btnSearch = new JButton("검색");
		btnSearch.addActionListener(this);
		panel.add(btnSearch);
		
		panel_1 = new HairInfoPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
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
		((BiztList)((HairInfoPanel)panel_1).getTable()).setTableWithData(startDate, endDate);
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
}
