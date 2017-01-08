package kr.or.dgit.bigdata.project.hairshop.main;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class FrontScreen extends JFrame {
	public FrontScreen() {
		setTitle("DGIT 헤어샵");
		getContentPane().setBackground(new Color(255, 192, 203));
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 50, 180));
		
		JLabel lblBizmng = new JLabel("영업관리");
		lblBizmng.setForeground(Color.GRAY);
		lblBizmng.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblBizmng.setIcon(new ImageIcon("C:\\workspace\\workspace_java\\bigdata_2st\\img\\Man-Suit-2.png"));
		getContentPane().add(lblBizmng);
		
		JLabel lblOrdermng = new JLabel("주문관리");
		lblOrdermng.setForeground(Color.GRAY);
		lblOrdermng.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblOrdermng.setIcon(new ImageIcon("C:\\workspace\\workspace_java\\bigdata_2st\\img\\Pen.png"));
		getContentPane().add(lblOrdermng);
		
		JLabel lblBizreport = new JLabel("영업현황");
		lblBizreport.setForeground(Color.GRAY);
		lblBizreport.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblBizreport.setIcon(new ImageIcon("C:\\workspace\\workspace_java\\bigdata_2st\\img\\Calendar.png"));
		getContentPane().add(lblBizreport);
		
		JLabel lblSetting = new JLabel("프로그램 관리");
		lblSetting.setIcon(new ImageIcon("C:\\workspace\\workspace_java\\bigdata_2st\\img\\Thunderbolt-Display.png"));
		lblSetting.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblSetting.setForeground(Color.GRAY);
		getContentPane().add(lblSetting);
	}

}
