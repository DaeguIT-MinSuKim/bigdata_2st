package kr.or.dgit.bigdata.project.hairshop.admin.setting.service;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import javafx.scene.shape.CircleBuilder;
import kr.or.dgit.bigdata.project.hairshop.admin.setting.Config;
import kr.or.dgit.bigdata.project.hairshop.admin.setting.dao.DataBaseDao;
import kr.or.dgit.bigdata.project.hairshop.admin.setting.jdbc.DBCon;
import kr.or.dgit.bigdata.project.hairshop.admin.setting.jdbc.JdbcUtil;

public class ExportSettingService extends ServiceSetting{
	
	@Override
	public void initSetting() {
		/* export할 database 선택 */
		DataBaseDao dao = DataBaseDao.getInstance();
		dao.selectUseDatabase();
		
		/* file chooser 이용해 백업할 경로 설정 */
		JFileChooser jfc = new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		jfc.setMultiSelectionEnabled(false);
		jfc.setFileFilter(new FileNameExtensionFilter("txt Files", "txt"));
		jfc.setCurrentDirectory(new File("C:/Users/LYJ/Desktop"));
		jfc.setDialogTitle("파일을 저장할 폴더를 선택해 주세요.");
		//저장할 폴더를 선택했을  때 수행할 메소드들
		if(jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
			Config.Export_path = jfc.getSelectedFile().getPath();			
			for(String tableName : Config.TABLE_NAME){	
				checkBackupDir(tableName);
				executeExportData(getFilePath(tableName, false), tableName);
			}			
			copyFile();
		}				
	}
	
	private void copyFile() {
		File srcDir = new File(Config.MYSQL_EXPORT_PATH);
		File destDir = null;		
		for(File file : srcDir.listFiles()){
			System.out.println(file.getName());
			destDir = new File(Config.Export_path+"/"+file.getName());
			System.out.println(destDir.getPath());
			boolean isSave = file.renameTo(destDir);
			System.out.println(isSave);
			if(isSave){
				file.delete();
			}
		}
	}

	private void checkBackupDir(String tableName) {
		//저장하려는 폴더에 이전에 백업된 파일이 존재하는 경우 그것을 지우게 만드는 메소드
		File backupDir = new File(Config.Export_path+"/"+tableName+".txt");
		File dfBackupDir = new File(Config.MYSQL_EXPORT_PATH+"/"+tableName+".txt");
		if(dfBackupDir.exists()&&dfBackupDir.isFile()){
			dfBackupDir.delete();
		}
		if (backupDir.exists()&&backupDir.isFile()){
			backupDir.delete();
			System.out.printf("%s Delete Success! %n",backupDir.getName());					
		}
		/* 백업시 mysql폴더에서 지정한 폴더로 파일이 이동하지 않는 문제가 발생해 주석처리 했습니다. */
		/*else{
			backupDir.mkdir();
			System.out.printf("%s make dir Success! %n",Config.Export_path);
		}*/				
	}

	public void executeExportData(String tablePath, String tableName) {
		/* DB에 존재하는 table들을 table명으로 txt파일 생성하여 file화 하는 작업 */
		String sql = String.format("select * into outfile '%s' "
				+ "character set 'UTF8' " + "fields TERMINATED by '|' "
				+ "LINES TERMINATED by '\n' from %s", 
				tablePath,	tableName);		
		Statement stmt = null;
		try {
			Connection con = DBCon.getConnection();
			stmt = con.createStatement();
			stmt.executeQuery(sql);
			System.out.printf("Export Table(%s) %d Rows Success! %n",tableName, stmt.getUpdateCount());
		} catch (SQLException e) {
			System.out.printf("error %d : %s %n", e.getErrorCode(), e.getMessage());
		} finally {
			JdbcUtil.close(stmt);
		}
	}
}