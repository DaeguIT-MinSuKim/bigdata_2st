package kr.or.dgit.bigdata.project.hairshop.ui;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

public class HomePanel extends JLayeredPane {
	private JButton cSearch;
	private JButton cAdd;
	private JButton hOrder;
	private JButton btnMngLogin;
	private JButton btnLogout;

	
	
	ImageIcon icon;

	
	
	public HomePanel() {
		setBackground(Color.WHITE);
		setBounds(0,0,1078, 628);
		setLayout(null);
		
		icon = new ImageIcon("img/Main.png");
		
		JPanel ip = new JPanel(){
			
			public void paintComponent(Graphics g){
				g.drawImage(icon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
				
		
		ip.setBounds(0, 0, 1078, 628);
		
		
		// 고객검색,추가, 헤어주문 버튼 인스턴스 생성
		cSearch = new JButton();
		cSearch.setFont(new Font("나눔스퀘어OTF ExtraBold", Font.PLAIN, 16));
		cAdd = new JButton();
		hOrder = new JButton();
		
		cSearch.setBounds(15, 30, 50, 120);
		cSearch.setText("고객검색");
		
		add(cSearch);
		
		
		
				
		btnMngLogin = new JButton("관리자모드");
		btnLogout = new JButton("관리자 로그아웃");
		btnLogout.setVisible(false);
		
		add(ip);
		ip.setLayout(null);
		add(btnMngLogin);
		add(btnLogout);
		
		setVisible(true);
	}
	
	
	
	
	
	
	
	public JButton getBtnManager() {
		return btnMngLogin;
	}
	public void setBtnManager(JButton btnManager) {
		this.btnMngLogin = btnManager;
	}
	public JButton getBtnLogout() {
		return btnLogout;
	}
	public void setBtnLogout(JButton btnLogout) {
		this.btnLogout = btnLogout;
	}
	
	
	
	
}
