package kr.or.dgit.bigdata.project.hairshop.ui.admin;

import java.awt.GridLayout;
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

public class ProgramSetting extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnInit;
	private JButton btnBackUp;
	private JButton btnImport;
	private AdminSettingPanel adminSettingPanel;
	private HairEvnetAdminPanel hairEvnetAdminPanel;
	private HairinfoAdminPanel hairinfoAdminPanel;

	public void setHairEvnetAdminPanel(HairEvnetAdminPanel hairEvnetAdminPanel) {
		this.hairEvnetAdminPanel = hairEvnetAdminPanel;
	}

	public void setHairinfoAdminPanel(HairinfoAdminPanel hairinfoAdminPanel) {
		this.hairinfoAdminPanel = hairinfoAdminPanel;
	}

	public void setAdminSettingPanel(AdminSettingPanel adminSettingPanel) {
		this.adminSettingPanel = adminSettingPanel;
	}

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
		contentPane.setLayout(new GridLayout(0, 3, 0, 0));
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
			btnImportActionPerformed(e);
		}
		if (e.getSource() == btnBackUp) {
			btnBackUpActionPerformed(e);
		}
		if (e.getSource() == btnInit) {
			btnInitActionPerformed(e);
		}
	}
	protected void btnInitActionPerformed(ActionEvent e) {		
		if(JOptionPane.showConfirmDialog(null, "정말 초기화 하시겠습니까?","초기화",JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
			new ResetDB().createDB();
			JOptionPane.showMessageDialog(null, "초기화에 성공하였습니다.");
			hairEvnetAdminPanel.setInitPanel();
			hairinfoAdminPanel.setInitPanel();
			adminSettingPanel.setinitPanel();
		}
	}
	protected void btnBackUpActionPerformed(ActionEvent e) {
		ServiceSetting create = new ExportSettingService();
		create.initSetting();
		
	}
	protected void btnImportActionPerformed(ActionEvent e) {
		ServiceSetting create = new ImportSettingService();
		create.initSetting();
		hairEvnetAdminPanel.setInitPanel();
		hairinfoAdminPanel.setInitPanel();
		adminSettingPanel.setinitPanel();
	}
	
}
