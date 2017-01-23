package kr.or.dgit.bigdata.project.hairshop.admin.setting.service;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import kr.or.dgit.bigdata.project.hairshop.admin.setting.Config;
import kr.or.dgit.bigdata.project.hairshop.admin.setting.dao.DataBaseDao;
import kr.or.dgit.bigdata.project.hairshop.admin.setting.jdbc.DBCon;
import kr.or.dgit.bigdata.project.hairshop.admin.setting.jdbc.JdbcUtil;

public class ImportSettingService extends ServiceSetting{
	
	@Override
	public void initSetting() {
		/* select database where file will be imported */
		DataBaseDao dao = DataBaseDao.getInstance();
		dao.selectUseDatabase();
		/* Create jFileChooser with directories_only */	
		FileChooser jfc = new FileChooser();		
		jfc.setDialogTitle("파일이 저장된 폴더를 선택해 주세요.");

		if(jfc.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
			Config.Import_path = jfc.getSelectedFile().getPath();
			dao.setForeignKeyCheck(0);
			for(String tableName : Config.TABLE_NAME){	
				System.out.println(tableName);
				executeImportDate(getFilePath(tableName, true), tableName);
			}
			dao.setForeignKeyCheck(1);		

			JOptionPane.showMessageDialog(null, "복원에 성공하였습니다.");
		}
	}
	
	private void executeImportDate(String tablePath, String tableName) {
		String sql = String.format("LOAD DATA LOCAL INFILE '%s' INTO TABLE %s character set 'UTF8' fields TERMINATED by '|'",
				tablePath, tableName);
		Statement stmt = null;
		try {
			Connection con = DBCon.getConnection();
			stmt = con.createStatement();
			stmt.execute(sql);
			System.out.printf("Import Table(%s) %d Rows Success! %n",tableName, stmt.getUpdateCount());
		} catch (SQLException e) {
			if (e.getErrorCode() == 1062) {
				System.err.println("중복데이터 존재");
			}
		} finally {
			JdbcUtil.close(stmt);
		}
	}
}

