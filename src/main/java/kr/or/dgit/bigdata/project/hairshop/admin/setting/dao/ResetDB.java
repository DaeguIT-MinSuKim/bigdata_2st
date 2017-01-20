package kr.or.dgit.bigdata.project.hairshop.admin.setting.dao;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;
import javax.swing.JPanel;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;


public class ResetDB extends JPanel {
	private Statement stmt;
	private static final ResetDB instance = new ResetDB();
	private static SqlSessionFactory sqlSessionForReset;
	private String q = "";

	public static ResetDB getInstance() {
		return instance;
	}

	public void createDB() {
		try {
			SqlSession sql = openSession();
			/* 주의 사항 - File을 불러올 때 UTF-8로 읽어 오기 때문에 쿼리문이 저장된 text 파일도 UTF-8형식이어야 한다. */
				File initSQL = new java.io.File(System.getProperty("user.dir")+ "\\Scripts\\Hairshop.txt") ;
				List<String> list = Files.readAllLines(initSQL.toPath(), StandardCharsets.UTF_8);
				for (String s : list) {
					q += s.replaceAll(".$?--.*", "").replaceAll("(?m)^.*--.*$(\r?\n|\r)?", "").replaceAll("\\s+",
							" ");
				}
				String[] query = q.split(";");
				stmt = sql.getConnection().createStatement();
				for (String s : query) {
					if (s.trim().startsWith("insert") || s.trim().startsWith("update")
							|| s.trim().startsWith("delete")) {
						stmt.executeUpdate(s);
					} else {
						stmt.execute(s);
					}
				}
				sql.commit();
				stmt.close();
				sql.close();			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static SqlSessionFactory getSqlSessionForReset() {
		// 초기화시 필요한 데이터베이스 root계정 정보
		String user = "root";
		String password = "rootroot";
		String databasenameURL = "jdbc:mysql://localhost:3306";
		String dbDriver = "com.mysql.jdbc.Driver";

		if (sqlSessionForReset == null) {
			DataSource dataSource = new PooledDataSource(dbDriver, databasenameURL, user, password);
			TransactionFactory transactionFactory = new JdbcTransactionFactory();
			Configuration configuration = new Configuration(
					new Environment("development", transactionFactory, dataSource));
			sqlSessionForReset = new SqlSessionFactoryBuilder().build(configuration);
		}
		return sqlSessionForReset;
	}
	public static SqlSession openSession() {
		return getSqlSessionForReset().openSession();
	}
}