package kr.or.dgit.bigdata.project.hairshop.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class HomePanel extends JPanel {
	private JButton btnManager;
	private JButton btnLogout;
	public HomePanel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		
		btnManager = new JButton("관리자 로그인");
		
		panel.add(btnManager);
		
		btnLogout = new JButton("관리자 로그아웃");
		btnLogout.setVisible(false);
		panel.add(btnLogout);
	}
	public JButton getBtnManager() {
		return btnManager;
	}
	public void setBtnManager(JButton btnManager) {
		this.btnManager = btnManager;
	}
	public JButton getBtnLogout() {
		return btnLogout;
	}
	public void setBtnLogout(JButton btnLogout) {
		this.btnLogout = btnLogout;
	}
	
}
