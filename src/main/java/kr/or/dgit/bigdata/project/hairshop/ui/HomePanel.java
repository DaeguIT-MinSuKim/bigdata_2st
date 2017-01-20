package kr.or.dgit.bigdata.project.hairshop.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import kr.or.dgit.bigdata.project.hairshop.ui.login.ManagerLogin;

public class HomePanel extends JLayeredPane {
	private JButton[] btns = {new JButton(), new JButton(), new JButton(), new JButton()};
	private JButton btnLogout;
	ImageIcon icon;
	
	private JLabel[] cSearchlb = {new JLabel("고"), new JLabel("객"), new JLabel("정"), new JLabel("보")};
	private JLabel[] cAddlb = {new JLabel("고"), new JLabel("객"), new JLabel("추"), new JLabel("가")};
	private JLabel[] hOrderlb = {new JLabel("헤"), new JLabel("어"), new JLabel("주"), new JLabel("문")};
	private JLabel[] btnMngLoginlb = {new JLabel("관"), new JLabel("리"), new JLabel("자"), new JLabel("모"), new JLabel("드")};
	
	public HomePanel() { // 0120 중복코드 for문으로 전환처리
		setBackground(Color.WHITE);
		setBounds(0,0,1078, 628);
		setLayout(null);

		// 배경 이미지
		icon = new ImageIcon("img/Main.png");
		JPanel ip = new JPanel(){
			public void paintComponent(Graphics g){
				g.drawImage(icon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		ip.setBounds(0, 0, 1078, 628);
		
		// Btn 생성
		for(int i=0;i<btns.length;i++){
			if(i<=2){
				btns[i].setLayout(new GridLayout(4, 1));
			}else{
				btns[i].setLayout(new GridLayout(5, 1));
			}
		}

		// 전경색 설정
		for(int i=0;i<4;i++){
			cSearchlb[i].setForeground(new Color(255, 105, 180));
			cAddlb[i].setForeground(new Color(255, 105, 180));
			hOrderlb[i].setForeground(new Color(255, 105, 180));
		}
		for(int y=0;y<5;y++){
			btnMngLoginlb[y].setForeground(new Color(255, 105, 180));
		}
				
		
		

		try {
			// 커스텀 폰트 생성
			InputStream isNanumBrush = HomePanel.class.getResourceAsStream("NanumBrush.ttf");
			Font nanumBrush = Font.createFont(Font.TRUETYPE_FONT, isNanumBrush);
			Font sizedNanumBrush32p = nanumBrush.deriveFont(0, 32f);
			Font sizedNanumBrush36p = nanumBrush.deriveFont(0, 36f);
			Font sizedNanumBrush36b = nanumBrush.deriveFont(1, 36f);
			Font sizedNanumBrush40b = nanumBrush.deriveFont(1, 40f);
			
			
			// 폰트 설정
			for(int i=0;i<4;i++){
				cSearchlb[i].setFont(sizedNanumBrush36p);
				btns[0].add(cSearchlb[i]);
				cAddlb[i].setFont(sizedNanumBrush36p);
				btns[1].add(cAddlb[i]);
				hOrderlb[i].setFont(sizedNanumBrush36p);
				btns[2].add(hOrderlb[i]);
			}
			for(int y=0;y<5;y++){
				btnMngLoginlb[y].setFont(sizedNanumBrush32p);
				btns[3].add(btnMngLoginlb[y]);
			}

			// 버튼 투명처리
			for(int i=0;i<btns.length;i++){
				btns[i].setBorderPainted(false);
				btns[i].setFocusPainted(false);
				btns[i].setContentAreaFilled(false);
				if(i<=2){
					btns[i].setBounds(i*110+30, 30, 70, 120);
				}else{
					btns[i].setBounds(i*110+30, 30, 90, 120);
				}
				add(btns[i]);
			}


			
			
			// 버튼 이벤트 리스너
			btns[0].addMouseListener(new MouseAdapter() { // 고객검색
				@Override
				public void mouseEntered(MouseEvent e) {
					for(int i = 0; i<4 ; i++){
						cSearchlb[i].setForeground(Color.MAGENTA);
						cSearchlb[i].setFont(sizedNanumBrush40b);
					}
				}
				@Override
				public void mouseExited(MouseEvent e) {
					for(int i = 0; i<4 ; i++){
						cSearchlb[i].setForeground(new Color(255, 105, 180));
						cSearchlb[i].setFont(sizedNanumBrush36p);
					}
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					
				}
			});
			
			btns[1].addMouseListener(new MouseAdapter() { // 고객추가
				@Override
				public void mouseEntered(MouseEvent e) {
					for(int i = 0; i<4 ; i++){
						cAddlb[i].setForeground(Color.MAGENTA);
						cAddlb[i].setFont(sizedNanumBrush40b);
					}
				}
				@Override
				public void mouseExited(MouseEvent e) {
					for(int i = 0; i<4; i++){
						cAddlb[i].setForeground(new Color(255, 105, 180));
						cAddlb[i].setFont(sizedNanumBrush36p);
					}
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					
				}
			});
			
			btns[2].addMouseListener(new MouseAdapter() { //헤어주문
				@Override
				public void mouseEntered(MouseEvent e) {
					for(int i = 0; i<4 ; i++){
						hOrderlb[i].setForeground(Color.MAGENTA);
						hOrderlb[i].setFont(sizedNanumBrush40b);
					}
				}
				@Override
				public void mouseExited(MouseEvent e) {
					for(int i = 0; i<4 ; i++){
						hOrderlb[i].setForeground(new Color(255, 105, 180));
						hOrderlb[i].setFont(sizedNanumBrush36p);
					}
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					
				}
			});
			
			btns[3].addMouseListener(new MouseAdapter() { //관리자모드
				@Override
				public void mouseEntered(MouseEvent e) {
					for(int i = 0; i<5; i++){
						btnMngLoginlb[i].setForeground(Color.MAGENTA);
						btnMngLoginlb[i].setFont(sizedNanumBrush36b);
					}
				}
				@Override
				public void mouseExited(MouseEvent e) {
					for(int i = 0; i<5; i++){
						btnMngLoginlb[i].setForeground(new Color(255, 105, 180));
						btnMngLoginlb[i].setFont(sizedNanumBrush32p);
					}
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						ManagerLogin frame = new ManagerLogin();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});
			
		} catch (FontFormatException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
				
		btnLogout = new JButton("관리자 로그아웃");
		btnLogout.setVisible(false);
		
		add(ip);
		ip.setLayout(null);
		add(btnLogout);
		
		setVisible(true);
	}
		
	// getter&setter

	public JButton getBtnLogout() {return btnLogout;}
	public void setBtnLogout(JButton btnLogout) {this.btnLogout = btnLogout;}
	public JButton getcSearch() {return btns[0];}
	public void setcSearch(JButton cSearch) {this.btns[0] = cSearch;}
	public JButton getcAdd() {return btns[1];}
	public void setcAdd(JButton cAdd) {	this.btns[1] = cAdd;}
	public JButton gethOrder() {return btns[2];}
	public void sethOrder(JButton hOrder) {this.btns[2] = hOrder;}
	public JButton getBtnManager() {return btns[3];}
	public void setBtnManager(JButton btnManager) {this.btns[3] = btnManager;}

}
