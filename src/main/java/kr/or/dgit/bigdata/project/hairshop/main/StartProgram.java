package kr.or.dgit.bigdata.project.hairshop.main;

import java.awt.EventQueue;
import java.util.Properties;

import javax.swing.UIManager;

import com.jtattoo.plaf.mcwin.McWinLookAndFeel;

import kr.or.dgit.bigdata.project.hairshop.fonts.Fonts;

public class StartProgram{

	
	HairMain frame = new HairMain();

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
					Fonts f = new Fonts();


					
					UIManager.put("TableHeader.font", f.getDoHyeon().deriveFont(15f)); // 테이블 셀이름 글꼴
					UIManager.put("Table.font", f.getJua().deriveFont(0, 14f)); // 테이블 결과 셀 글꼴
					
					UIManager.put("TextField.font", f.getJua().deriveFont(14f)); // JTextField, 글자 입력칸 글꼴
					UIManager.put("Label.font", f.getDoHyeon().deriveFont(14f)); //JLabel, 글자 입력칸 라벨
					UIManager.put("ComboBox.font", f.getJua().deriveFont(14f)); // JComboBox
					UIManager.put("Button.font", f.getDoHyeon().deriveFont(16f)); // JButton 글꼴
					UIManager.put("InternalFrame.titleFont", f.getYeonSung().deriveFont(20f)); // 타이틀 폰트
					UIManager.put("ToolTip.font", f.getDoHyeon().deriveFont(12f)); // 마우스 툴팁폰트
					UIManager.put("FileChooser.listFont", f.getHanNa());
					UIManager.put("List.font", f.getHanNa().deriveFont(14f)); 
					UIManager.put("DatePicker.font", f.getHanNa().deriveFont(14f)); 
					UIManager.put("TextArea.font", f.getDoHyeon().deriveFont(14f));

					UIManager.put("TextArea.font", f.getNanumGothic());
					UIManager.put("OptionPane.font", f.getHanNa());
					UIManager.put("OptionPane.messageFont", f.getHanNa());

					
					HairMain frame = new HairMain();
					frame.setBounds(100, 100, 1100, 700);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
		
				} catch (Exception e) {
					StartProgram f = new StartProgram();
					
					
					e.printStackTrace();
				}
				

			}
		});
		
	}
	

	

	
	//UIManager.put("EditorPane.font", f.getHanNa());
	//UIManager.put("ToolBar.font", f.getHanNa());
	//UIManager.put("Tree.font", f.getHanNa());
	//UIManager.put("CheckBoxMenuItem.font", f.getHanNa());

	//UIManager.put("Slider.font", f.getHanNa());
	
	//UIManager.put("Menu.acceleratorFont", f.getHanNa());
	//UIManager.put("MenuBar.font", f.getHanNa());
	//UIManager.put("PopupMenu.font", f.getHanNa());
	//UIManager.put("MenuItem.font", f.getJua().deriveFont(16f));
	//UIManager.put("MenuItem.acceleratorFont", f.getHanNa());
	//UIManager.put("TextPane.font", f.getHanNa().deriveFont(40f));
	//UIManager.put("ProgressBar.font", f.getHanNa());
	//UIManager.put("CheckBox.font", f.getHanNa());
	// UIManager.put("CheckBoxMenuItem.acceleratorFont", f.getHanNa());
	//UIManager.put("FormattedTextField.font", f.getHanNa().deriveFont(40f));		
	
	//UIManager.put("RadioButton.font", f.getDoHyeon());
	//UIManager.put("RadioButtonMenuItem.font", f.getHanNa());
	//UIManager.put("RadioButtonMenuItem.acceleratorFont", f.getDoHyeon());
	//UIManager.put("ToggleButton.font", f.getHanNa());					
//	UIManager.put("TabbedPane.font", f.getDoHyeon());
//	UIManager.put("Panel.font", f.getHanNa()); //JPanel
//	UIManager.put("Viewport.font", f.getDoHyeon());
	//UIManager.put("ScrollPane.font", f.getHanNa());
	//UIManager.put("Spinner.font", f.getHanNa());
	
	
}