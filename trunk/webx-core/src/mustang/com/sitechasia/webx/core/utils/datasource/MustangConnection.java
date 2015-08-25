/** 
 * @{#} MustangLayer.java Create on 2008-7-11 下午03:18:25   
 *   
 * Copyright (c) 2006- by CE.   
 */   
package com.sitechasia.webx.core.utils.datasource;

import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.NClob;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.sql.Struct;
import java.util.Properties;

/**
 * 使用于JDK1.6版本的Connection抽象类
 * @author MarkDong
 * @version 1.0   
 * @see  
 */
public abstract class MustangConnection {
	protected Connection wrappedConnection;

	//Mustang新增方法
	public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
		return wrappedConnection.createArrayOf(typeName, elements);
	}

	public Blob createBlob() throws SQLException {
		return wrappedConnection.createBlob();
	}

	public Clob createClob() throws SQLException {
		return wrappedConnection.createClob();
	}

	public NClob createNClob() throws SQLException {
		return wrappedConnection.createNClob();
	}

	public SQLXML createSQLXML() throws SQLException {
		return wrappedConnection.createSQLXML();
	}

	public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
		return wrappedConnection.createStruct(typeName, attributes);
	}

	public Properties getClientInfo() throws SQLException {
		return wrappedConnection.getClientInfo();
	}

	public String getClientInfo(String name) throws SQLException {
		return wrappedConnection.getClientInfo(name);
	}

	public boolean isValid(int timeout) throws SQLException {
		return wrappedConnection.isValid(timeout);
	}

	public void setClientInfo(Properties properties) throws SQLClientInfoException {
		wrappedConnection.setClientInfo(properties);
	}

	public void setClientInfo(String name, String value) throws SQLClientInfoException {
		wrappedConnection.setClientInfo(name, value);
	}

	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return wrappedConnection.isWrapperFor(iface);
	}

	public <T> T unwrap(Class<T> iface) throws SQLException {
		return wrappedConnection.unwrap(iface);
	}
}
