package kr.or.dgit.bigdata.project.hairshop.list;

import java.awt.FlowLayout;
import java.util.Date;
import java.util.Properties;

import javax.swing.JPanel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class DatePanel extends JPanel {
	
	private JDatePickerImpl datePicker;
	public DatePanel() {		
		setLayout(new FlowLayout());

		Properties prop = new Properties();
		prop.setProperty("text.today", "오늘");
		prop.setProperty("text.month", "월");
		prop.setProperty("text.year", "년");
		
		UtilDateModel model = new UtilDateModel();
	    model.setSelected(true);
	    
	    JDatePanelImpl datePanel = new JDatePanelImpl(model, prop);
	    datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		add(datePicker);		
	}

	public JDatePickerImpl getDatePicker() {
		return datePicker;
	}

}
