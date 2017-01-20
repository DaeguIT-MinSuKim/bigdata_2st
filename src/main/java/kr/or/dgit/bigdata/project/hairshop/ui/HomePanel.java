package kr.or.dgit.bigdata.project.hairshop.ui;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.AttributedCharacterIterator.Attribute;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import kr.or.dgit.bigdata.project.hairshop.main.HairMain;
import kr.or.dgit.bigdata.project.hairshop.ui.login.ManagerLogin;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HomePanel extends JLayeredPane {
	private JButton cSearch;
	private JButton cAdd;
	private JButton hOrder;
	private JButton btnMngLogin;
	private JButton btnLogout;
	
	ImageIcon icon;
	private JLabel cSearchlb1;
	private JLabel cSearchlb2;
	private JLabel cSearchlb3;
	private JLabel cSearchlb4;
	private JComponent cAddlb1;
	private JLabel cAddlb2;
	private JLabel cAddlb3;
	private JLabel cAddlb4;
	protected JComponent hOrderlb1;
	protected JComponent hOrderlb2;
	protected JComponent hOrderlb3;
	protected JComponent hOrderlb4;
	protected JComponent btnMngLoginlb1;
	protected JComponent btnMngLoginlb2;
	protected JComponent btnMngLoginlb3;
	protected JComponent btnMngLoginlb4;
	protected JComponent btnMngLoginlb5;

	
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
		
		// 고객검색 Btn 생성, 전경색 지정
		setcSearch(new JButton());
		cSearch.setLayout(new GridLayout(4, 1));
		cSearchlb1 = new JLabel("고");
		cSearchlb1.setForeground(new Color(255, 105, 180));
		cSearchlb2 = new JLabel("객");
		cSearchlb2.setForeground(new Color(255, 105, 180));
		cSearchlb3 = new JLabel("검");
		cSearchlb3.setForeground(new Color(255, 105, 180));
		cSearchlb4 = new JLabel("색");
		cSearchlb4.setForeground(new Color(255, 105, 180));
		
		
		// 고객추가 Btn
		cAdd = new JButton();
		cAdd.setLayout(new GridLayout(4, 1));
		cAddlb1 = new JLabel("고");
		cAddlb1.setForeground(new Color(255, 105, 180));
		cAddlb2 = new JLabel("객");
		cAddlb2.setForeground(new Color(255, 105, 180));
		cAddlb3 = new JLabel("추");
		cAddlb3.setForeground(new Color(255, 105, 180));
		cAddlb4 = new JLabel("가");
		cAddlb4.setForeground(new Color(255, 105, 180));

		


		

		
		// 헤어주문 Btn
		hOrder = new JButton();
		hOrder.setLayout(new GridLayout(4, 1));
		hOrderlb1 = new JLabel("헤");
		hOrderlb1.setForeground(new Color(255, 105, 180));
		hOrderlb2 = new JLabel("어");
		hOrderlb2.setForeground(new Color(255, 105, 180));
		hOrderlb3 = new JLabel("주");
		hOrderlb3.setForeground(new Color(255, 105, 180));
		hOrderlb4 = new JLabel("문");
		hOrderlb4.setForeground(new Color(255, 105, 180));


		
		
		// 관리자모드 Btn
		btnMngLogin = new JButton();
		btnMngLogin.setLayout(new GridLayout(5, 1));
		btnMngLoginlb1 = new JLabel("관");
		btnMngLoginlb1.setForeground(new Color(255, 105, 180));
		btnMngLoginlb2 = new JLabel("리");
		btnMngLoginlb2.setForeground(new Color(255, 105, 180));
		btnMngLoginlb3 = new JLabel("자");
		btnMngLoginlb3.setForeground(new Color(255, 105, 180));
		btnMngLoginlb4 = new JLabel("모");
		btnMngLoginlb4.setForeground(new Color(255, 105, 180));
		btnMngLoginlb5 = new JLabel("드");
		btnMngLoginlb5.setForeground(new Color(255, 105, 180));


	
		
				
				
		// 커스텀 폰트 적용
		try {
			InputStream isNanumBrush = HomePanel.class.getResourceAsStream("NanumBrush.ttf");
			Font nanumBrush = Font.createFont(Font.TRUETYPE_FONT, isNanumBrush);
			Font sizedNanumBrush32p = nanumBrush.deriveFont(0, 40f);
			Font sizedNanumBrush36p = nanumBrush.deriveFont(0, 36f);
			Font sizedNanumBrush36b = nanumBrush.deriveFont(1, 36f);
			Font sizedNanumBrush40b = nanumBrush.deriveFont(1, 40f);
			
			cSearchlb1.setFont(sizedNanumBrush36p);
			cSearch.add(cSearchlb1);
			cSearchlb2.setFont(sizedNanumBrush36p);
			cSearch.add(cSearchlb2);
			cSearchlb3.setFont(sizedNanumBrush36p);
			cSearch.add(cSearchlb3);
			cSearchlb4.setFont(sizedNanumBrush36p);
			cSearch.add(cSearchlb4);
			cSearch.setBorderPainted(false);
			cSearch.setFocusPainted(false);
			cSearch.setContentAreaFilled(false);
			cSearch.setBounds(30, 30, 70, 120);
			add(cSearch);
					
					
			cAddlb1.setFont(sizedNanumBrush36p);
			cAdd.add(cAddlb1);
			cAddlb2.setFont(sizedNanumBrush36p);
			cAdd.add(cAddlb2);
			cAddlb3.setFont(sizedNanumBrush36p);
			cAdd.add(cAddlb3);
			cAddlb4.setFont(sizedNanumBrush36p);
			cAdd.add(cAddlb4);
			cAdd.setBorderPainted(false);
			cAdd.setFocusPainted(false);
			cAdd.setContentAreaFilled(false);
			cAdd.setBounds(140, 30, 70, 120);
			add(cAdd);
					
					
			hOrderlb1.setFont(sizedNanumBrush36p);
			hOrder.add(hOrderlb1);
			hOrderlb2.setFont(sizedNanumBrush36p);
			hOrder.add(hOrderlb2);
			hOrderlb3.setFont(sizedNanumBrush36p);
			hOrder.add(hOrderlb3);
			hOrderlb4.setFont(sizedNanumBrush36p);
			hOrder.add(hOrderlb4);
			hOrder.setBorderPainted(false);
			hOrder.setFocusPainted(false);
			hOrder.setContentAreaFilled(false);
			hOrder.setBounds(250, 30, 70, 120);
			add(hOrder);
				
			
			btnMngLoginlb1.setFont(sizedNanumBrush32p);
			btnMngLogin.add(btnMngLoginlb1);
			btnMngLoginlb2.setFont(sizedNanumBrush32p);
			btnMngLogin.add(btnMngLoginlb2);
			btnMngLoginlb3.setFont(sizedNanumBrush32p);
			btnMngLogin.add(btnMngLoginlb3);
			btnMngLoginlb4.setFont(sizedNanumBrush32p);
			btnMngLogin.add(btnMngLoginlb4);
			btnMngLoginlb5.setFont(sizedNanumBrush32p);
			btnMngLogin.add(btnMngLoginlb5);
			btnMngLogin.setBorderPainted(false);
			btnMngLogin.setFocusPainted(false);
			btnMngLogin.setContentAreaFilled(false);
			btnMngLogin.setBounds(360, 30, 70, 160);
			add(btnMngLogin);
			
			
			
		// 고객검색 버튼 이벤트 리스너
			cSearch.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					cSearchlb1.setForeground(Color.MAGENTA);
					cSearchlb2.setForeground(Color.MAGENTA);
					cSearchlb3.setForeground(Color.MAGENTA);
					cSearchlb4.setForeground(Color.MAGENTA);
					cSearchlb1.setFont(sizedNanumBrush40b);
					cSearchlb2.setFont(sizedNanumBrush40b);
					cSearchlb3.setFont(sizedNanumBrush40b);
					cSearchlb4.setFont(sizedNanumBrush40b);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					cSearchlb1.setForeground(new Color(255, 105, 180));
					cSearchlb2.setForeground(new Color(255, 105, 180));
					cSearchlb3.setForeground(new Color(255, 105, 180));
					cSearchlb4.setForeground(new Color(255, 105, 180));
					cSearchlb1.setFont(sizedNanumBrush36p);
					cSearchlb2.setFont(sizedNanumBrush36p);
					cSearchlb3.setFont(sizedNanumBrush36p);
					cSearchlb4.setFont(sizedNanumBrush36p);

				}
				@Override
				public void mouseClicked(MouseEvent e) {
					
				}
			});
			
			
			
			hOrder.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					hOrderlb1.setForeground(Color.MAGENTA);
					hOrderlb2.setForeground(Color.MAGENTA);
					hOrderlb3.setForeground(Color.MAGENTA);
					hOrderlb4.setForeground(Color.MAGENTA);
					hOrderlb1.setFont(sizedNanumBrush40b);
					hOrderlb2.setFont(sizedNanumBrush40b);
					hOrderlb3.setFont(sizedNanumBrush40b);
					hOrderlb4.setFont(sizedNanumBrush40b);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					hOrderlb1.setForeground(new Color(255, 105, 180));
					hOrderlb2.setForeground(new Color(255, 105, 180));
					hOrderlb3.setForeground(new Color(255, 105, 180));
					hOrderlb4.setForeground(new Color(255, 105, 180));
					hOrderlb1.setFont(sizedNanumBrush36p);
					hOrderlb2.setFont(sizedNanumBrush36p);
					hOrderlb3.setFont(sizedNanumBrush36p);
					hOrderlb4.setFont(sizedNanumBrush36p);
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					
				}
			});
			
			
			cAdd.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					cAddlb1.setForeground(Color.MAGENTA);
					cAddlb2.setForeground(Color.MAGENTA);
					cAddlb3.setForeground(Color.MAGENTA);
					cAddlb4.setForeground(Color.MAGENTA);
					cAddlb1.setFont(sizedNanumBrush40b);
					cAddlb2.setFont(sizedNanumBrush40b);
					cAddlb3.setFont(sizedNanumBrush40b);
					cAddlb4.setFont(sizedNanumBrush40b);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					cAddlb1.setForeground(new Color(255, 105, 180));
					cAddlb2.setForeground(new Color(255, 105, 180));
					cAddlb3.setForeground(new Color(255, 105, 180));
					cAddlb4.setForeground(new Color(255, 105, 180));
					cAddlb1.setFont(sizedNanumBrush36p);
					cAddlb2.setFont(sizedNanumBrush36p);
					cAddlb3.setFont(sizedNanumBrush36p);
					cAddlb4.setFont(sizedNanumBrush36p);
					
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					
				}
			});
			
			
			btnMngLogin.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnMngLoginlb1.setForeground(Color.MAGENTA);
					btnMngLoginlb2.setForeground(Color.MAGENTA);
					btnMngLoginlb3.setForeground(Color.MAGENTA);
					btnMngLoginlb4.setForeground(Color.MAGENTA);
					btnMngLoginlb5.setForeground(Color.MAGENTA);
					btnMngLoginlb1.setFont(sizedNanumBrush36b);
					btnMngLoginlb2.setFont(sizedNanumBrush36b);
					btnMngLoginlb3.setFont(sizedNanumBrush36b);
					btnMngLoginlb4.setFont(sizedNanumBrush36b);
					btnMngLoginlb5.setFont(sizedNanumBrush36b);

				}
				@Override
				public void mouseExited(MouseEvent e) {
					btnMngLoginlb1.setForeground(new Color(255, 105, 180));
					btnMngLoginlb2.setForeground(new Color(255, 105, 180));
					btnMngLoginlb3.setForeground(new Color(255, 105, 180));
					btnMngLoginlb4.setForeground(new Color(255, 105, 180));
					btnMngLoginlb5.setForeground(new Color(255, 105, 180));
					btnMngLoginlb1.setFont(sizedNanumBrush32p);
					btnMngLoginlb2.setFont(sizedNanumBrush32p);
					btnMngLoginlb3.setFont(sizedNanumBrush32p);
					btnMngLoginlb4.setFont(sizedNanumBrush32p);
					btnMngLoginlb5.setFont(sizedNanumBrush32p);
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







	public JButton getcSearch() {return cSearch;}
	public void setcSearch(JButton cSearch) {this.cSearch = cSearch;}
	public JButton getcAdd() {return cAdd;}
	public void setcAdd(JButton cAdd) {	this.cAdd = cAdd;}
	public JButton gethOrder() {return hOrder;}
	public void sethOrder(JButton hOrder) {this.hOrder = hOrder;}

}
