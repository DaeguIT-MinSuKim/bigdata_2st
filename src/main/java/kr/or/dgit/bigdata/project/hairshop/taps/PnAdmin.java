package kr.or.dgit.bigdata.project.hairshop.taps;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.bigdata.project.hairshop.ui.BizReportPanelBySearch;
import kr.or.dgit.bigdata.project.hairshop.ui.admin.AdminSettingPanel;
import kr.or.dgit.bigdata.project.hairshop.ui.admin.HairEvnetAdminPanel;
import kr.or.dgit.bigdata.project.hairshop.ui.admin.HairinfoAdminPanel;
import kr.or.dgit.bigdata.project.hairshop.ui.admin.ProgramSetting;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.BorderLayout;

public class PnAdmin extends JPanel implements ActionListener {
	/* main 화면 영업현황 tab 선택시 나타날 메인 화면 */
	private JPanel pnAdminMain;
	private JPanel pnAdminBtns;
	private JButton btnSetting;
	private JButton btnToLogout;
	private HairinfoAdminPanel hairinfoPanel;
	private HairEvnetAdminPanel hairEventPanel;
	private JTabbedPane tabbedPane;
	private AdminSettingPanel adminSettingPanel;

	public void setTabbedPane(JTabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;
	}

	/**
	 * Create the panel.
	 */
	public PnAdmin() {
		setToolTipText("헤어정보, 이벤트 등 프로그램을 관리하는 화면입니다.");
		setBounds(0, 0, 1080, 629);
		setLayout(new BorderLayout(0, 0));
		
		
		pnAdminMain = new JPanel();
		pnAdminMain.setBorder(new EmptyBorder(10, 10, 10, 10));
		pnAdminMain.setBackground(new Color(240, 240, 240));
		add(pnAdminMain, BorderLayout.CENTER);
		GridBagLayout gbl_pnAdminMain = new GridBagLayout();
		gbl_pnAdminMain.columnWidths = new int[]{0, 480, 480, 0};
		gbl_pnAdminMain.rowHeights = new int[]{0, 270, 330, 0};
		gbl_pnAdminMain.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnAdminMain.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnAdminMain.setLayout(gbl_pnAdminMain);
		
		hairinfoPanel = new HairinfoAdminPanel();
		GridBagConstraints gbc_hairinfoPanel = new GridBagConstraints();
		gbc_hairinfoPanel.fill = GridBagConstraints.BOTH;
		gbc_hairinfoPanel.insets = new Insets(0, 0, 5, 5);
		gbc_hairinfoPanel.gridx = 1;
		gbc_hairinfoPanel.gridy = 1;
		pnAdminMain.add(hairinfoPanel, gbc_hairinfoPanel);
		
		hairEventPanel = new HairEvnetAdminPanel();
		GridBagConstraints gbc_hairEventPanel = new GridBagConstraints();
		gbc_hairEventPanel.fill = GridBagConstraints.BOTH;
		gbc_hairEventPanel.insets = new Insets(0, 0, 5, 0);
		gbc_hairEventPanel.gridx = 2;
		gbc_hairEventPanel.gridy = 1;
		pnAdminMain.add(hairEventPanel, gbc_hairEventPanel);
		
		adminSettingPanel = new AdminSettingPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 2;
		pnAdminMain.add(adminSettingPanel, gbc_panel);
		
		pnAdminBtns = new JPanel();
		pnAdminBtns.setBorder(new EmptyBorder(0, 0, 0, 0));
		pnAdminBtns.setBackground(new Color(240, 240, 240));
		add(pnAdminBtns, BorderLayout.EAST);
		GridBagLayout gbl_pnAdminBtns = new GridBagLayout();
		gbl_pnAdminBtns.columnWidths = new int[]{124, 0};
		gbl_pnAdminBtns.rowHeights = new int[]{125, 125, 125, 125, 125, 0};
		gbl_pnAdminBtns.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_pnAdminBtns.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnAdminBtns.setLayout(gbl_pnAdminBtns);
		
		btnToLogout = new JButton("로그 아웃");
		btnToLogout.addActionListener(this);
		
		btnSetting = new JButton("프로그램세팅");
		btnSetting.addActionListener(this);
		btnSetting.setBorderPainted(false);
		btnSetting.setFocusPainted(false);
		btnSetting.setContentAreaFilled(true);
		btnSetting.setBackground(new Color(248, 248, 255));
		GridBagConstraints gbc_btnSetting = new GridBagConstraints();
		gbc_btnSetting.fill = GridBagConstraints.BOTH;
		gbc_btnSetting.insets = new Insets(0, 0, 5, 0);
		gbc_btnSetting.gridx = 0;
		gbc_btnSetting.gridy = 3;
		pnAdminBtns.add(btnSetting, gbc_btnSetting);
		btnToLogout.setBorderPainted(false);
		btnToLogout.setFocusPainted(false);
		btnToLogout.setContentAreaFilled(true);
		btnToLogout.setBackground(new Color(248, 248, 255));
		GridBagConstraints gbc_btnToLogout = new GridBagConstraints();
		gbc_btnToLogout.fill = GridBagConstraints.BOTH;
		gbc_btnToLogout.gridx = 0;
		gbc_btnToLogout.gridy = 4;
		pnAdminBtns.add(btnToLogout, gbc_btnToLogout);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnToLogout) {
			btnToLogoutActionPerformed(e);
		}
		if (e.getSource() == btnSetting) {
			btnSettingActionPerformed(e);
		}
	}
	protected void btnSettingActionPerformed(ActionEvent e) {
		setDefaultPanel();
		ProgramSetting pSetting = new ProgramSetting();
		pSetting.setAdminSettingPanel(adminSettingPanel);
		pSetting.setHairEvnetAdminPanel(hairEventPanel);
		pSetting.setHairinfoAdminPanel(hairinfoPanel);
		
	}
	protected void btnToLogoutActionPerformed(ActionEvent e) {
		if(JOptionPane.showConfirmDialog(null, "로그아웃하시겠습니까?", "로그아웃", JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
			tabbedPane.removeTabAt(6);
			tabbedPane.removeTabAt(5);
			tabbedPane.removeTabAt(4);
			tabbedPane.setSelectedIndex(0);
		}		
	}
	
	public void setDefaultPanel(){
		hairEventPanel.setInitPanel();
		hairinfoPanel.setInitPanel();
		adminSettingPanel.setinitPanel();
	}

	public JButton getBtnToLogout() {
		return btnToLogout;
	}

	public void setBtnToLogout(JButton btnToLogout) {
		this.btnToLogout = btnToLogout;
	}
	
}

