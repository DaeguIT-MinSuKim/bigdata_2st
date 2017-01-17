package kr.or.dgit.bigdata.project.hairshop.admin.setting.service;

import kr.or.dgit.bigdata.project.hairshop.admin.setting.Config;

public abstract class ServiceSetting {
	
    protected static String getFilePath(String tableName, boolean isImport) {
        StringBuilder sb = new StringBuilder();
        sb.append(isImport ? Config.Import_path+"/" : Config.MYSQL_EXPORT_PATH).append(tableName).append(".txt");
        return sb.toString().replace("\\", "/");
    }   
	
	public abstract void initSetting();
}
