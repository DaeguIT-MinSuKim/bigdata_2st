package kr.or.dgit.bigdata.project.hairshop.ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class HomePanel extends JPanel {
	public HomePanel() {
		setBackground(new Color(0, 255, 255));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 255));
		add(panel);
		panel.setLayout(new GridLayout(0, 4, 0, 0));
		
		JLabel label = new JLabel("");
		panel.add(label);
		
		JLabel label_2 = new JLabel("");
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("");
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("");
		panel.add(label_4);
		
		JLabel label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon("D:\\workspace\\workspace_mybatis\\bigdata_2st\\img\\btn1.png"));
		panel.add(label_10);
		
		JLabel label_1 = new JLabel("");
		panel.add(label_1);
		
		JLabel label_5 = new JLabel("");
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("");
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("");
		panel.add(label_7);
		
		JLabel label_8 = new JLabel("");
		panel.add(label_8);
		
		JLabel label_9 = new JLabel("");
		panel.add(label_9);
		
		JLabel label_11 = new JLabel("");
		panel.add(label_11);
	}
	
}
