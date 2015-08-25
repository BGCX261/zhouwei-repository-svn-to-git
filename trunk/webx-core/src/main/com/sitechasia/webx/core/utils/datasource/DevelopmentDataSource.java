/*
 *
 * Copyright (c) 2006- CE, Inc.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * CE Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with CE.
 */
package com.sitechasia.webx.core.utils.datasource;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

/**
 * 开发阶段使用的带有监控信息的数据库源。
 *
 * @author MarkDong
 * @version 2.0
 * @since JDK1.5
 * @see DevelopmentConnection
 *
 */
public class DevelopmentDataSource extends MustangDataSource implements DataSource {
	/**
	 * 日志对象.
	 * 在子类中不必单独定义日志对象，直接使用这里生成的即可
	 */
	public final Logger logger = Logger.getLogger(getClass());

	// 用来存放数据库连接信息的集合,实现了外同步
	private Map<Connection,DevelopmentConnection> connections = new ConcurrentHashMap<Connection, DevelopmentConnection>();

	public DataSource getWrappedDataSource() {
		return wrappedDataSource;
	}

	public void setWrappedDataSource(DataSource wrappedDataSource) {
		this.wrappedDataSource = wrappedDataSource;
	}
	
	/**
	 *调用第三方DataSource（例如C3P0）的getConnection方法获得原始数据库连接
	 *
	 * @author todd
	 * @return Connection 数据库连接
	 */
	public Connection getConnection() throws SQLException {
		return getConnection(null, null);
	}

	/**
	 * 调用第三方DataSource（例如C3P0）的getConnection方法获得原始数据库连接
	 *
	 * @author todd
	 * @param username 用户名
	 * @param userpass 用户密码
	 * @return Connection 数据库连接
	 */
	public Connection getConnection(String username, String password)
			throws SQLException {
		Exception exception = new Exception();

		long creationTime = System.currentTimeMillis();
		StackTraceElement[] stackTraceElements = exception.getStackTrace();

		Connection conn = null;
		if (username != null && password != null) {
			conn = wrappedDataSource.getConnection(username, password);
		} else {
			conn = wrappedDataSource.getConnection();
		}
		DevelopmentConnection devConn = wrapConnection(conn,stackTraceElements,creationTime);

		logger.debug(System.currentTimeMillis() + "开始数据源: " + this.hashCode() + " 开始调用封装后的方法getConnection得到一个connection: " + devConn.hashCode());
		//printStack(conn,devConn.getStackTraceElenments());
		recordConnection(devConn);
		return devConn;
	}

	/**
	 * 封装原始的Conneciton,同时记录调用的信息
	 *　
	 * @author todd
	 * @param connection 原始的数据库连接
	 * @param stackTraceElements 调用堆栈信息
	 * @param creationTime 调用时间
	 * @return
	 */
	private DevelopmentConnection wrapConnection(Connection connection,StackTraceElement[] stackTraceElements,long creationTime){

		// 将数据库连接封装为DevelopmentConnection对象
		DevelopmentConnection devConn = new DevelopmentConnection();
		devConn.setWrappedConnection(connection);
		devConn.setWrappedDataSource(this);
		devConn.setCreationTime(creationTime);
		devConn.setStackTraceElenments(stackTraceElements);
		return devConn;
	}

	/**
	 * 通知关闭数据源,但并不作真正关闭
	 *
	 * @author todd
	 * @param connection  封装的数据库连接
	 */
	public void closeConnection(DevelopmentConnection connection) {
		logger.debug("通知关闭数据源: " + this.hashCode() + " ,从Map中移除一个connection: " + connection.hashCode());
		releaseConnection(connection);
	}

	/**
	 * 将当前的数据库连接记录到connections中
	 *　
	 * @author todd
	 * @param devConnection 封装的数据库连接
	 */
	private void recordConnection(DevelopmentConnection devConnection){
		//将数据库连接封装为DevelopmentConnection对象
		connections.put(devConnection.getWrappedConnection(), devConnection);
	}

	/**
	 * 当前的数据库连接从connections中删除
	 *
	 * @author todd
	 * @param connection  封装的数据库连接
	 */
	private void releaseConnection(DevelopmentConnection connection){
		connections.remove(connection.getWrappedConnection());
	}

	public List<DevelopmentConnection> getConnections() {
		List<DevelopmentConnection> conns = new ArrayList<DevelopmentConnection>();
		Set<Connection> keys = connections.keySet();
		for(Connection conn : keys) {
			DevelopmentConnection devConn = connections.get(conn);
			conns.add(devConn);
		}
		return conns;
	}


	// 以下为代理方法不要修改！！
	public int getLoginTimeout() throws SQLException {
		return wrappedDataSource.getLoginTimeout();
	}

	public PrintWriter getLogWriter() throws SQLException {
		return wrappedDataSource.getLogWriter();
	}

	public void setLoginTimeout(int seconds) throws SQLException {
		wrappedDataSource.setLoginTimeout(seconds);
	}

	public void setLogWriter(PrintWriter out) throws SQLException {
		wrappedDataSource.setLogWriter(out);
	}
}
