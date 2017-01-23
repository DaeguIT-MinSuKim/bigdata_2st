package kr.or.dgit.bigdata.project.hairshop.main;

import java.awt.EventQueue;
import java.util.Properties;

import javax.swing.UIManager;

import org.apache.ibatis.exceptions.PersistenceException;

import com.jtattoo.plaf.mcwin.McWinLookAndFeel;

import kr.or.dgit.bigdata.project.hairshop.admin.setting.dao.ResetDB;
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
					UIManager.put("OptionPane.messageFont", f.getHanNa().deriveFont(16f));

					
					HairMain frame = new HairMain();
					frame.setBounds(100, 100, 1100, 700);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);					
	
				} catch (Exception e) {
					new ResetDB().createDB();
					StartProgram f = new StartProgram();					
					e.printStackTrace();
				}
				

			}
		});
		
	}	
}