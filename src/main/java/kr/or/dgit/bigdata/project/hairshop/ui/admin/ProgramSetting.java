package kr.or.dgit.bigdata.project.hairshop.ui.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.bigdata.project.hairshop.admin.setting.dao.ResetDB;
import kr.or.dgit.bigdata.project.hairshop.admin.setting.service.ExportSettingService;
import kr.or.dgit.bigdata.project.hairshop.admin.setting.service.ImportSettingService;
import kr.or.dgit.bigdata.project.hairshop.admin.setting.service.ServiceSetting;
import java.awt.FlowLayout;

public class ProgramSetting extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnInit;
	private JButton btnBackUp;
	private JButton btnImport;

	/**
	 * Create the frame.
	 */
	public ProgramSetting() {
		setTitle("프로그램 세팅");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 100);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnInit = new JButton("초기화");
		btnInit.addActionListener(this);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		contentPane.add(btnInit);
		
		btnBackUp = new JButton("백업");
		btnBackUp.addActionListener(this);
		contentPane.add(btnBackUp);
		
		btnImport = new JButton("복원");
		btnImport.addActionListener(this);
		contentPane.add(btnImport);
		
		setVisible(true);
		setLocationRelativeTo(null);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnImport) {
			btnNewButton_2ActionPerformed(e);
		}
		if (e.getSource() == btnBackUp) {
			btnNewButton_1ActionPerformed(e);
		}
		if (e.getSource() == btnInit) {
			btnNewButtonActionPerformed(e);
		}
	}
	protected void btnNewButtonActionPerformed(ActionEvent e) {
		new ResetDB().createDB();
		JOptionPane.showMessageDialog(null, "초기화에 성공하였습니다.");
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
