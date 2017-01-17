package kr.or.dgit.bigdata.project.hairshop.test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.bigdata.project.hairshop.admin.setting.dao.ResetDB;
import kr.or.dgit.bigdata.project.hairshop.admin.setting.service.ExportSettingService;
import kr.or.dgit.bigdata.project.hairshop.admin.setting.service.ImportSettingService;
import kr.or.dgit.bigdata.project.hairshop.admin.setting.service.ServiceSetting;

public class adminTest extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminTest frame = new adminTest();
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
	public adminTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		btnNewButton = new JButton("초기화");
		btnNewButton.addActionListener(this);
		contentPane.add(btnNewButton, BorderLayout.WEST);
		
		btnNewButton_1 = new JButton("백업");
		btnNewButton_1.addActionListener(this);
		contentPane.add(btnNewButton_1, BorderLayout.CENTER);
		
		btnNewButton_2 = new JButton("New button");
		btnNewButton_2.addActionListener(this);
		contentPane.add(btnNewButton_2, BorderLayout.EAST);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton_2) {
			btnNewButton_2ActionPerformed(e);
		}
		if (e.getSource() == btnNewButton_1) {
			btnNewButton_1ActionPerformed(e);
		}
		if (e.getSource() == btnNewButton) {
			btnNewButtonActionPerformed(e);
		}
	}
	protected void btnNewButtonActionPerformed(ActionEvent e) {
		new ResetDB().createDB();
//		ServiceSetting create = new InitSettingService();
//		create.initSetting();
	}
	protected void btnNewButton_1ActionPerformed(ActionEvent e) {
		ServiceSetting create = new ExportSettingService();
		create.initSetting();
	}
	protected void btnNewButton_2ActionPerformed(ActionEvent e) {
		ServiceSetting create = new ImportSettingService();
		create.initSetting();
	}
}
