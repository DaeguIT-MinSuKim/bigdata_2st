package kr.or.dgit.bigdata.project.hairshop.test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.bigdata.project.hairshop.list.BiztList;

public class BizMain extends JFrame implements ItemListener {

	private JPanel contentPane;
	private JTable table;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JRadioButton rbMonth;
	private JRadioButton rbYear;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JComboBox<String> comboBox;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BizMain frame = new BizMain();
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
	public BizMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {1, 1, 1, 1};
		gbl_panel.rowHeights = new int[] {30, 20, 20, 20, 20};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		lblNewLabel = new JLabel("영업 현황 보고서");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.weightx = 4.0;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridwidth = 4;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		lblNewLabel_1 = new JLabel("보고서 선택");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		rbMonth = new JRadioButton("월별");
		buttonGroup.add(rbMonth);
		rbMonth.addItemListener(this);
		GridBagConstraints gbc_rbMonth = new GridBagConstraints();
		gbc_rbMonth.insets = new Insets(0, 0, 5, 5);
		gbc_rbMonth.anchor = GridBagConstraints.NORTH;
		gbc_rbMonth.fill = GridBagConstraints.HORIZONTAL;
		gbc_rbMonth.gridx = 1;
		gbc_rbMonth.gridy = 2;
		panel.add(rbMonth, gbc_rbMonth);
		
		rbYear = new JRadioButton("연도별");
		rbYear.addItemListener(this);
		buttonGroup.add(rbYear);
		GridBagConstraints gbc_rbYear = new GridBagConstraints();
		gbc_rbYear.insets = new Insets(0, 0, 5, 5);
		gbc_rbYear.anchor = GridBagConstraints.NORTHWEST;
		gbc_rbYear.gridx = 2;
		gbc_rbYear.gridy = 2;
		panel.add(rbYear, gbc_rbYear);
		
		comboBox = new JComboBox<>();
		comboBox.setEnabled(false);
		comboBox.addItemListener(this);
		comboBox.addItem("년도선택");
		comboBox.addItem("2000");
		comboBox.addItem("2001");		
		comboBox.addItem("2002");
		GridBagConstraints gbc_comboBox = new GridBagConstraints();		
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 3;
		panel.add(comboBox, gbc_comboBox);		
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		table = new BiztList();
		scrollPane.setViewportView(table);
	}

	public void itemStateChanged(ItemEvent arg0) {
		if (arg0.getSource() == rbYear) {
			rbYearItemStateChanged(arg0);
		}
		if (arg0.getSource() == rbMonth) {
			rbMonthItemStateChanged(arg0);
		}
	}
	protected void rbMonthItemStateChanged(ItemEvent arg0) {
		comboBox.setEnabled(true);
		comboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(!comboBox.getSelectedItem().toString().equals("년도선택")){
					int year = Integer.parseInt(comboBox.getSelectedItem().toString());	
					((BiztList) table).setTableWithData(true, "month", year);
				}
			}
		});
		
		
	}
	protected void rbYearItemStateChanged(ItemEvent arg0) {
		comboBox.setEnabled(false);
		((BiztList) table).setTableWithData(true, "year", 0);
	}

}
