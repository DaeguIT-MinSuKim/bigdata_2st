package kr.or.dgit.bigdata.project.hairshop.main;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrontScreen extends JFrame {
	public FrontScreen() {
		setTitle("DGIT 헤어샵");
		getContentPane().setBackground(new Color(255, 192, 203));
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 50, 180));
		
		JLabel lblBizmng = new JLabel();
		lblBizmng.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblBizmng.setText("영업관리");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblBizmng.setText("");
				
			}
		});
		lblBizmng.setForeground(Color.GRAY);
		lblBizmng.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblBizmng.setIcon(new ImageIcon("D:\\workspace\\workspace_mybatis\\bigdata_2st\\img\\Man-Suit-2.png"));
		getContentPane().add(lblBizmng);
		
		JLabel lblOrdermng = new JLabel();
		lblOrdermng.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblOrdermng.setText("주문관리");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblOrdermng.setText("");
			}
		});
		lblOrdermng.setForeground(Color.GRAY);
		lblOrdermng.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblOrdermng.setIcon(new ImageIcon("D:\\workspace\\workspace_mybatis\\bigdata_2st\\img\\Pen.png"));
		getContentPane().add(lblOrdermng);
		
		JLabel lblBizreport = new JLabel();
		lblBizreport.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblBizreport.setText("영업현황");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblBizreport.setText("");
			}
		});
		lblBizreport.setForeground(Color.GRAY);
		lblBizreport.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblBizreport.setIcon(new ImageIcon("D:\\workspace\\workspace_mybatis\\bigdata_2st\\img\\Calendar.png"));
		getContentPane().add(lblBizreport);
		
		JLabel lblSetting = new JLabel();
		lblSetting.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblSetting.setText("프로그램 관리");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblSetting.setText("");
			}
		});
		lblSetting.setIcon(new ImageIcon("D:\\workspace\\workspace_mybatis\\bigdata_2st\\img\\Thunderbolt-Display.png"));
		lblSetting.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblSetting.setForeground(Color.GRAY);
		getContentPane().add(lblSetting);
	}
	
	public static void main(String[] args) {
		FrontScreen f = new FrontScreen();
		f.setBounds(400, 100, 920, 520);
		f.setVisible(true);
	}

}
