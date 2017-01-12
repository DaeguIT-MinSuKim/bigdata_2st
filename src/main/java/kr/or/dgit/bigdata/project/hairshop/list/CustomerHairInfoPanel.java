package kr.or.dgit.bigdata.project.hairshop.list;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public class CustomerHairInfoPanel extends JPanel {

	private CustomerHairTable table;

	public CustomerHairTable getTable() {
		return table;
	}


	/**
	 * Create the panel.
	 */
	public CustomerHairInfoPanel() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uD5E4\uC5B4 \uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);
		
		table = new CustomerHairTable();
		scrollPane.setViewportView(table);
	}
	
	

}
