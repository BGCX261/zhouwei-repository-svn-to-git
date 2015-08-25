//Source file: C:\\test\\com\\techstar\\framework\\utils\\ConfigurationHelper.java

package com.techstar.framework.utils;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.ConfigurationFactory;


/**
 * 此类为工具类，主要为读取配置文件的信息
 * Sep 11, 2006
 * @author xcf
 */
public class ConfigurationHelper {

	/**
	 * @roseuid 44EA60F200B6
	 */
	public ConfigurationHelper(String xmlFilePath) {

		ConfigurationFactory factory = new ConfigurationFactory();
		factory.setConfigurationFileName( xmlFilePath);
		System.out.println("================>config:"+xmlFilePath);
		try {
			config = factory.getConfiguration();
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static Configuration config = null;


	/**
	 *  得到配置文件中日志备份的路径
	 * 
	 * @return String
	 * @roseuid 44E136F3009F
	 */
	public static String getBackupLogFilePath() {
		return config.getString("backupLogFilePath");
	}

	/**
	 *  得到邮件地址ַ
	 * 
	 * @return String
	 * @roseuid 44E919D70116
	 */
	public static String getMailHost() {
		return config.getString("mailHost");
	}

	/**
	 *得到邮件帐户
	 * 
	 * @return String
	 * @roseuid 44E919E70396
	 */
	public static String getMailUser() {
		return config.getString("mailUser");
	}

	/**
	 * 得到邮件密码
	 * 
	 * @return String
	 * @roseuid 44E919F7024D
	 */
	public static String getMailPwd() {
		return config.getString("mailPwd");
	}

	/**
	 *得到邮件附件根路径
	 */
	public static String getMailUploadFilePath() {
		return config.getString("mailUploadFilePath");
	}

	/**
	 * 应用系统标识
	 */
	public static String getSystemId() {
		return config.getString("SYSTEMID");
	}

	/**
	 * 得到权限webservice发布地址
	 * 
	 * @param systemName -
	 *            系统名称
	 * @return String
	 * @roseuid 44E929A90279
	 */
	public static String getWSAddress(String systemName) {
		if (wsAddressMap == null) {
			wsAddressMap = new HashMap();
			List names = config.getList("wSAddresses.wSAddress.name");
			List addresses = config.getList("wSAddresses.wSAddress.address");
			for (int i = 0; i < names.size(); i++) {
				wsAddressMap.put(names.get(i), addresses.get(i));
			}
		}

		if (wsAddressMap.containsKey(systemName)) {
			return (String) wsAddressMap.get(systemName);
		} else {
			return "";
		}

	}

	/**
	 * 获取命名JDBC SQL
	 * 
	 * @param queryName
	 *            -命名的sql名称
	 * @return JDBC SQL
	 */
	public static String getNamedSqlQuery(String queryName) {
		if (namedSqlQueriesMap == null) {
			namedSqlQueriesMap = new HashMap();			
			List names = config.getList("namedSqlQueries.sqlQuery.name");
			List addresses = config
					.getList("namedSqlQueries.sqlQuery.sqlString");
			for (int i = 0; i < names.size(); i++) {
				namedSqlQueriesMap.put(names.get(i), addresses.get(i));
			}
		}

		if (namedSqlQueriesMap.containsKey(queryName)) {
			String sql = (String)namedSqlQueriesMap.get(queryName);
			System.out.println("namedSql:"+  sql );
			return sql;
		} else {
			return null;
		}
	}
	
	/**
	 * 得到dto对象的包结构
	 * */
	public static String getDtoPackage(){
		return config.getString("dtoPackage");
	}
	
	/**
	 * 得到数据库类型
	 * */
	public static String getDbType(){
		return config.getString("dbType");
	}
	/**
	 * 得到pojo的包结构
	 * */
	public static String getPoPackage(){
		return config.getString("poPackage");
	}
	private static Map wsAddressMap = null;

	private static Map namedSqlQueriesMap = null;

	/**
	 * 得到所有树的[配置文件
	 * @return
	 */
	public static File[] getTreeDisFile(){
		String path = config.getString("treeDisFile");
		//System.out.println(path);
	    File[] files = FileHelper.getfiles(path);
		return files;
	}
	
	/**
	 * 得到所有列表的[配置文件
	 * @return
	 */
	public static File[] getGridDisFile(){
		String path = config.getString("gridDisFile");
		//System.out.println(path);
	    File[] files = FileHelper.getfiles(path);
		return files;
	}
	
	/**
	 * 得到列表中高级查询方式定义
	 * @return
	 */
	public static String getAdvanceQueryCon(){
		String controlStr = config.getString("advanceQuery");
		return controlStr;
	}

}
