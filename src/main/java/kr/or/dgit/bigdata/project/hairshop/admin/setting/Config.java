package kr.or.dgit.bigdata.project.hairshop.admin.setting;

public class Config {
	public static final String USER   = "root";
	public static final String PWD    = "rootroot";
	public static final String URL    = "jdbc:mysql://localhost:3306/";
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	
	public static final String DB_NAME = "hairshop";

	public static final String[] TABLE_NAME = {"biz","customer", "event", "hairinfo"};
	
	public static String Export_path = "";
	public static String Import_path = "";
	public static final String MYSQL_EXPORT_PATH = "C:\\ProgramData\\MySQL\\MySQL Server 5.6\\Uploads\\";
	
}
