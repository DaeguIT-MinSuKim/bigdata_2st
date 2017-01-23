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
	private JButton btnHairinfo;
	private JButton btnHairEvent;
	private JButton btnSetting;
	private JButton btnToLogout;
	private HairinfoAdminPanel hairinfoPanel;
	private HairEvnetAdminPanel hairEventPanel;
	private JTabbedPane tabbedPane;
	private AdminSettingPanel adminSettingPanel;
	private JButton btnAdminSetting;

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
		gbl_pnAdminMain.columnWidths = new int[]{30, 428, 428, 0};
		gbl_pnAdminMain.rowHeights = new int[]{30, 271, 271, 0};
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
		hairinfoPanel.setVisible(false);
		
		hairEventPanel = new HairEvnetAdminPanel();
		GridBagConstraints gbc_hairEventPanel = new GridBagConstraints();
		gbc_hairEventPanel.fill = GridBagConstraints.BOTH;
		gbc_hairEventPanel.insets = new Insets(0, 0, 5, 0);
		gbc_hairEventPanel.gridx = 2;
		gbc_hairEventPanel.gridy = 1;
		pnAdminMain.add(hairEventPanel, gbc_hairEventPanel);
		hairEventPanel.setVisible(false);
		
		adminSettingPanel = new AdminSettingPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 2;
		pnAdminMain.add(adminSettingPanel, gbc_panel);
		adminSettingPanel.setVisible(false);
		
		pnAdminBtns = new JPanel();
		pnAdminBtns.setBorder(new EmptyBorder(0, 0, 0, 0));
		pnAdminBtns.setBackground(new Color(230,230,250));
		add(pnAdminBtns, BorderLayout.EAST);
		
		btnHairinfo = new JButton("헤어정보관리");
		btnHairinfo.addActionListener(this);
		pnAdminBtns.setLayout(new GridLayout(0, 1, 0, 0));
		btnHairinfo.setBorderPainted(false);
		btnHairinfo.setFocusPainted(false);
		btnHairinfo.setContentAreaFilled(true);
		btnHairinfo.setBackground(new Color(248, 248, 255));
		pnAdminBtns.add(btnHairinfo);
		
		btnHairEvent = new JButton("이벤트 관리");
		btnHairEvent.addActionListener(this);
		btnHairEvent.setBorderPainted(false);
		btnHairEvent.setFocusPainted(false);
		btnHairEvent.setContentAreaFilled(true);
		btnHairEvent.setBackground(new Color(248, 248, 255));
		pnAdminBtns.add(btnHairEvent);
		
		btnAdminSetting = new JButton("관리자 계정 관리");
		btnAdminSetting.addActionListener(this);
		btnAdminSetting.setBorderPainted(false);
		btnAdminSetting.setFocusPainted(false);
		btnAdminSetting.setContentAreaFilled(true);
		btnAdminSetting.setBackground(new Color(248, 248, 255));
		pnAdminBtns.add(btnAdminSetting);
		
		btnSetting = new JButton("프로그램세팅");
		btnSetting.addActionListener(this);
		btnSetting.setBorderPainted(false);
		btnSetting.setFocusPainted(false);
		btnSetting.setContentAreaFilled(true);
		btnSetting.setBackground(new Color(248, 248, 255));
		pnAdminBtns.add(btnSetting);
		
		btnToLogout = new JButton("로그 아웃");
		btnToLogout.addActionListener(this);
		btnToLogout.setBorderPainted(false);
		btnToLogout.setFocusPainted(false);
		btnToLogout.setContentAreaFilled(true);
		btnToLogout.setBackground(new Color(248, 248, 255));
		pnAdminBtns.add(btnToLogout);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdminSetting) {
			btnAdminSettingActionPerformed(e);
		}
		if (e.getSource() == btnToLogout) {
			btnToLogoutActionPerformed(e);
		}
		if (e.getSource() == btnSetting) {
			btnSettingActionPerformed(e);
		}
		if (e.getSource() == btnHairEvent) {
			btnHairEventActionPerformed(e);
		}
		if (e.getSource() == btnHairinfo) {
			btnHairinfoActionPerformed(e);
		}
	}
	protected void btnHairinfoActionPerformed(ActionEvent e) {
		hairEventPanel.setVisible(false);
		adminSettingPanel.setVisible(false);
		hairinfoPanel.setInitPanel();
		hairinfoPanel.setVisible(true);		
	}
	protected void btnHairEventActionPerformed(ActionEvent e) {
		hairEventPanel.setInitPanel();
		hairEventPanel.setVisible(true);
		hairinfoPanel.setVisible(false);
		adminSettingPanel.setVisible(false);
	}
	protected void btnSettingActionPerformed(ActionEvent e) {
		hairEventPanel.setVisible(false);
		hairinfoPanel.setVisible(false);
		adminSettingPanel.setVisible(false);
		new ProgramSetting();
	}
	protected void btnToLogoutActionPerformed(ActionEvent e) {
		if(JOptionPane.showConfirmDialog(null, "로그아웃하시겠습니까?", "로그아웃", JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
			tabbedPane.removeTabAt(6);
			tabbedPane.removeTabAt(5);
			tabbedPane.removeTabAt(4);
			tabbedPane.setSelectedIndex(0);
		}		
	}
	protected void btnAdminSettingActionPerformed(ActionEvent e) {
		adminSettingPanel.setinitPanel();
		hairEventPanel.setVisible(false);
		hairinfoPanel.setVisible(false);
		adminSettingPanel.setVisible(true);
	}
	
	public void setDefaultPanel(){
		hairEventPanel.setVisible(false);
		hairinfoPanel.setVisible(false);
		adminSettingPanel.setVisible(false);
	}
}

