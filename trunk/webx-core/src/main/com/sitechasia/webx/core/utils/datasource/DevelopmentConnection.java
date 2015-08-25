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

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLWarning;

import java.sql.Savepoint;
import java.sql.Statement;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * 开发阶段使用的带有监控信息的数据库连接。
 *
 * @author MarkDong
 * @version 2.0
 * @since JDK1.5
 * @see DevelopmentDataSource
 */
public class DevelopmentConnection extends MustangConnection implements Connection {
	/**
	 * 日志对象.
	 * 在子类中不必单独定义日志对象，直接使用这里生成的即可
	 */
	protected final Logger logger = Logger.getLogger(getClass());

	//封装后的DataSource
	private DevelopmentDataSource wrappedDataSource;

	// 当前连接时间
	private long creationTime;

	//当前调用者的堆栈信息
	private StackTraceElement[] stackTraceElenments;


	/**
	 * 关闭当前数据库连接
	 */
	public void close() throws SQLException {
		// 调用封装后的数据源closeConnection方法通知关闭数据源
		wrappedDataSource.closeConnection(this);
		// 调用内部connection的close方法释放连接
		logger.debug("数据源: " + this.wrappedDataSource.hashCode() + " ,关闭当前的数据库连接connection: " + this.hashCode());
		wrappedConnection.close();

	}

	public Connection getWrappedConnection() {
		return wrappedConnection;
	}

	public void setWrappedConnection(Connection wrappedConnection) {
		this.wrappedConnection = wrappedConnection;
	}
	public DevelopmentDataSource getWrappedDataSource() {
		return wrappedDataSource;
	}

	public void setWrappedDataSource(DevelopmentDataSource wrappedDataSource) {
		this.wrappedDataSource = wrappedDataSource;
	}

	public long getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(long creationTime) {
		this.creationTime = creationTime;
	}

	public StackTraceElement[] getStackTraceElenments() {
		return stackTraceElenments;
	}

	public void setStackTraceElenments(StackTraceElement[] stackTraceElenments) {
		this.stackTraceElenments = stackTraceElenments;
	}

	// 以下均为代理方法，不要修改！！
	public void clearWarnings() throws SQLException {
		wrappedConnection.clearWarnings();
	}

	public void commit() throws SQLException {
		wrappedConnection.commit();
	}

	public Statement createStatement() throws SQLException {
		return wrappedConnection.createStatement();
	}

	public Statement createStatement(int resultSetType,
			int resultSetConcurrency, int resultSetHoldability)
			throws SQLException {
		return wrappedConnection.createStatement(resultSetType,
				resultSetConcurrency, resultSetHoldability);
	}

	public Statement createStatement(int resultSetType, int resultSetConcurrency)
			throws SQLException {
		return wrappedConnection.createStatement(resultSetType,
				resultSetConcurrency);
	}

	public boolean getAutoCommit() throws SQLException {
		return wrappedConnection.getAutoCommit();
	}

	public String getCatalog() throws SQLException {
		return wrappedConnection.getCatalog();
	}

	public int getHoldability() throws SQLException {
		return wrappedConnection.getHoldability();
	}

	public DatabaseMetaData getMetaData() throws SQLException {
		return wrappedConnection.getMetaData();
	}

	public int getTransactionIsolation() throws SQLException {
		return wrappedConnection.getTransactionIsolation();
	}

	public Map<String, Class<?>> getTypeMap() throws SQLException {
		return wrappedConnection.getTypeMap();
	}

	public SQLWarning getWarnings() throws SQLException {
		return wrappedConnection.getWarnings();
	}

	public boolean isClosed() throws SQLException {
		return wrappedConnection.isClosed();
	}

	public boolean isReadOnly() throws SQLException {
		return wrappedConnection.isReadOnly();
	}

	public String nativeSQL(String sql) throws SQLException {
		return wrappedConnection.nativeSQL(sql);
	}

	public CallableStatement prepareCall(String sql, int resultSetType,
			int resultSetConcurrency, int resultSetHoldability)
			throws SQLException {
		return wrappedConnection.prepareCall(sql, resultSetType,
				resultSetConcurrency, resultSetHoldability);
	}

	public CallableStatement prepareCall(String sql, int resultSetType,
			int resultSetConcurrency) throws SQLException {
		return wrappedConnection.prepareCall(sql, resultSetType,
				resultSetConcurrency);
	}

	public CallableStatement prepareCall(String sql) throws SQLException {
		return wrappedConnection.prepareCall(sql);
	}

	public PreparedStatement prepareStatement(String sql, int resultSetType,
			int resultSetConcurrency, int resultSetHoldability)
			throws SQLException {
		return wrappedConnection.prepareStatement(sql, resultSetType,
				resultSetConcurrency, resultSetHoldability);
	}

	public PreparedStatement prepareStatement(String sql, int resultSetType,
			int resultSetConcurrency) throws SQLException {
		return wrappedConnection.prepareStatement(sql, resultSetType,
				resultSetConcurrency);
	}

	public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys)
			throws SQLException {
		return wrappedConnection.prepareStatement(sql, autoGeneratedKeys);
	}

	public PreparedStatement prepareStatement(String sql, int[] columnIndexes)
			throws SQLException {
		return wrappedConnection.prepareStatement(sql, columnIndexes);
	}

	public PreparedStatement prepareStatement(String sql, String[] columnNames)
			throws SQLException {
		return wrappedConnection.prepareStatement(sql, columnNames);
	}

	public PreparedStatement prepareStatement(String sql) throws SQLException {
		return wrappedConnection.prepareStatement(sql);
	}

	public void releaseSavepoint(Savepoint savepoint) throws SQLException {
		wrappedConnection.releaseSavepoint(savepoint);
	}

	public void rollback() throws SQLException {
		wrappedConnection.rollback();
	}

	public void rollback(Savepoint savepoint) throws SQLException {
		wrappedConnection.rollback(savepoint);
	}

	public void setAutoCommit(boolean autoCommit) throws SQLException {
		wrappedConnection.setAutoCommit(autoCommit);
	}

	public void setCatalog(String catalog) throws SQLException {
		wrappedConnection.setCatalog(catalog);
	}

	public void setHoldability(int holdability) throws SQLException {
		wrappedConnection.setHoldability(holdability);
	}

	public void setReadOnly(boolean readOnly) throws SQLException {
		wrappedConnection.setReadOnly(readOnly);
	}

	public Savepoint setSavepoint() throws SQLException {
		return wrappedConnection.setSavepoint();
	}

	public Savepoint setSavepoint(String name) throws SQLException {
		return wrappedConnection.setSavepoint(name);
	}

	public void setTransactionIsolation(int level) throws SQLException {
		wrappedConnection.setTransactionIsolation(level);
	}

	public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
		wrappedConnection.setTypeMap(map);
	}
}
