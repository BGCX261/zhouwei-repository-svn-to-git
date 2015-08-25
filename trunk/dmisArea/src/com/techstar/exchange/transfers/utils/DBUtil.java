package com.techstar.exchange.transfers.utils;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Properties;
import java.util.Collections;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.sql.DataSource;

public class DBUtil {

	private static final String JDBC_DATA_SOURCE = "java:comp/env/jdbc/DataSource";

	/**
	 * enableLocalDebug: 是否在本地调试。<br>
	 * 值为true时如果查找数据源失败则使用DriverManager与数据库建立连接； 如果为false则只查找数据源建立数据库连接。
	 * 默认为false。<br>
	 * 可通过系统属性jdbc.enable_local_debug=true设置enableLocalDebug为true，启用本地调试：<br>
	 * 增加JVM parameter： -Djdbc.enable_local_debug=true
	 */
	private static boolean enableLocalDebug = true;

//	static {
//		enableLocalDebug = Boolean.getBoolean("jdbc.enable_local_debug");
//	}

	private static Context ctx = null;

	private static javax.sql.DataSource ds = null;

	private static void initDataSource() throws Exception {
		// Put connection properties in to a hashtable.

		if (ctx == null) {
			ctx = new InitialContext();
		}
		if (ds == null) {
			ds = (javax.sql.DataSource) ctx.lookup(JDBC_DATA_SOURCE);
		}
	}

	/**
	 * 查找应用服务器数据源，从数据源中获得数据库连接。<br>
	 * <br>
	 * 在本地调试时如果查找数据源失败并且enableLocalDebug==true
	 * 则根据系统属性使用java.sql.DriverManager建立连接。<br>
	 * 本地调试时可配置的系统属性如下：<br>
	 * <p>
	 * #jdbc驱动程序名 <br>
	 * jdbc.driver=<i>oracle.jdbc.driver.OracleDriver</i> <br>
	 * <br>
	 * #数据库连接串<br>
	 * jdbc.url=<i>jdbc:oracle:thin:@10.1.1.1:1521:ocrl</i> <br>
	 * <br>
	 * #数据库用户名<br>
	 * jdbc.username=<i>scott</i> <br>
	 * <br>
	 * #数据库用户密码<br>
	 * jdbc.password=<i>tiger</i> <br>
	 * </p>
	 * 可通过JVM参数设置上述系统属性：<br>
	 * -Djdbc.driver=oracle.jdbc.driver.OracleDriver
	 * -Djdbc.url=jdbc:oracle:thin:@10.1.1.1:1521:ocrl -Djdbc.username=scott
	 * -Djdbc.password=tiger
	 * 
	 * @return Connection
	 * @throws NamingException
	 *             如果数据源查找失败
	 * @throws SQLException
	 *             如果建立数据库连接失败
	 */
	public static Connection getConnection() throws SQLException {
		try {
			initDataSource();
			return ds.getConnection();
		} catch (SQLException sqle) {
			throw sqle;
		} catch (Exception ne) {
			if (enableLocalDebug) {
				return getTestConn();
			} else {
				throw new RuntimeException(ne.toString());
			}
		}
	}

	// 通过DriverManager建立本地测试连接
	private static Connection getTestConn() {
		try {
			String driver = MessageConfig.getValue("db.driverClassName");
			String url = MessageConfig.getValue("db.url");
			String username = MessageConfig.getValue("db.username");
			String password = MessageConfig.getValue("db.password");

			Class.forName(driver).newInstance();
			return java.sql.DriverManager
					.getConnection(url, username, password);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex.getMessage());
		}
	}

	/**
	 * 将查询结果封装成List。<br>
	 * List中元素类型为封装一行数据的Map，Map key为字段名（大写），value为相应字段值
	 * 
	 * @param rs
	 *            ResultSet
	 * @return List
	 * @throws java.sql.SQLException
	 */
	public static List resultSetToList(ResultSet rs)
			throws java.sql.SQLException {
		if (rs == null)
			return Collections.EMPTY_LIST;

		ResultSetMetaData md = rs.getMetaData();
		int columnCount = md.getColumnCount();

		List list = new ArrayList();
		Map rowData;
		while (rs.next()) {
			rowData = new HashMap(columnCount);
			for (int i = 1; i <= columnCount; i++) {
				rowData.put(md.getColumnName(i), rs.getObject(i));
			}
			list.add(rowData);
		}
		return list;
	}

	/**
	 * 关闭ResultSet、Statement和Connection
	 * 
	 * @param rs
	 *            ResultSet to be closed
	 * @param stmt
	 *            Statement or PreparedStatement to be closed
	 * @param conn
	 *            Connection to be closed
	 */
	public static void close(ResultSet rs, Statement stmt, Connection conn) {
		if (rs != null)
			try {
				rs.close();
			} catch (java.sql.SQLException ex) {
				ex.printStackTrace();
			}
		if (stmt != null)
			try {
				stmt.close();
			} catch (java.sql.SQLException ex) {
				ex.printStackTrace();
			}
		if (conn != null)
			try {
				conn.close();
			} catch (java.sql.SQLException ex) {
				ex.printStackTrace();
			}
	}

}