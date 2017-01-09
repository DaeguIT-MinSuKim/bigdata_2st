package kr.or.dgit.bigdata.project.hairshop.main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame {

	private JFrame frmDgitHairshopManagement;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frmDgitHairshopManagement.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDgitHairshopManagement = new JFrame();
		frmDgitHairshopManagement.getContentPane();
		Image mainImg = Toolkit.getDefaultToolkit().getImage("mainback.png");
		frmDgitHairshopManagement.setIconImage(mainImg);
		frmDgitHairshopManagement.setResizable(false);
		frmDgitHairshopManagement.setTitle("DGIT HairShop Management System");
		frmDgitHairshopManagement.setBounds(100, 100, 726, 511);
		frmDgitHairshopManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDgitHairshopManagement.getContentPane().setLayout(null);
			
		
		JLabel label_2 = new JLabel("");
		label_2.setBackground(new Color(0, 0, 0, 0));
		label_2.setBounds(388, 179, 128, 128);
		frmDgitHairshopManagement.getContentPane().add(label_2);
		
		
		
		JLabel label_1 = new JLabel("");
		label_1.setBackground(new Color(0, 0, 0, 0)); 
		label_1.setBounds(155, 179, 128, 128);
		label_1.setOpaque(true);
		label_1.setIcon(new ImageIcon(MainFrame.class.getResource("/kr/or/dgit/bigdata/project/hairshop/main/images/btn2.png")));
		frmDgitHairshopManagement.getContentPane().add(label_1);
	}
}
