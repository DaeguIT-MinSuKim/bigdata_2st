package kr.or.dgit.bigdata.project.hairshop.test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.apache.log4j.lf5.util.DateFormatManager;

import kr.or.dgit.bigdata.project.hairshop.dto.Customer;
import kr.or.dgit.bigdata.project.hairshop.list.BiztList;
import javax.swing.border.TitledBorder;

public class CustomerHairinfo extends JPanel {
	private HairInfoPanel hairInfoPanel;
	private JLabel lblNo;
	private JLabel lblName;
	private JLabel lblDob;

	public void setHairInfoPanel(HairInfoPanel hairInfoPanel) {
		this.hairInfoPanel = hairInfoPanel;
	}

	/**
	 * Create the panel.
	 */
	public CustomerHairinfo() {
		setBorder(new TitledBorder(new EmptyBorder(30, 30, 30, 30), "", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {0, 0};
		gbl_panel.rowHeights = new int[]{15, 15, 15, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("고객번호 : ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		lblNo = new JLabel("");
		lblNo.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblNo = new GridBagConstraints();
		gbc_lblNo.fill = GridBagConstraints.BOTH;
		gbc_lblNo.insets = new Insets(0, 0, 5, 0);
		gbc_lblNo.gridx = 1;
		gbc_lblNo.gridy = 0;
		add(lblNo, gbc_lblNo);
		
		JLabel lblNewLabel_1 = new JLabel("고 객 명 : ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		lblName = new JLabel("");
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.fill = GridBagConstraints.BOTH;
		gbc_lblName.insets = new Insets(0, 0, 5, 0);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 1;
		add(lblName, gbc_lblName);
		
		JLabel lblNewLabel_2 = new JLabel("생년월일 : ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		lblDob = new JLabel("");
		lblDob.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblDob = new GridBagConstraints();
		gbc_lblDob.fill = GridBagConstraints.BOTH;
		gbc_lblDob.gridx = 1;
		gbc_lblDob.gridy = 2;
		add(lblDob, gbc_lblDob);
	}

	public void setTextFields(Customer customer) {
		lblNo.setText(customer.getcNo()+"");
		lblName.setText(customer.getcName());
		DateFormatManager dfm = new DateFormatManager("yyyy-MM-dd");
		lblDob.setText(dfm.format(customer.getcDob()));
		
		hairInfoPanel.getTable().setTableWithData(customer);
		revalidate();
	}

}
