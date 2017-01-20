package kr.or.dgit.bigdata.project.hairshop.main;

import java.awt.EventQueue;
import java.util.Properties;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.jtattoo.plaf.mcwin.McWinLookAndFeel;

public class StartMain{

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Properties props = new Properties();
					props.put("logoString", "DGIT HAIR");
					McWinLookAndFeel.setCurrentTheme(props);//팝업 메뉴 등장하는 jtattoo 로고 변환
					UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
					HairMain frame = new HairMain();
					SwingUtilities.updateComponentTreeUI(frame.getBtnAdd());
					frame.setBounds(100, 100, 1100, 700);
					frame.setVisible(true);
		
				} catch (Exception e) {
					StartMain f = new StartMain();
					
					
					e.printStackTrace();
				}
				

			}
		});
		
	}
	
	
	
}