/** 
 * @{#} MustangDataSource.java Create on 2008-7-11 下午04:34:01   
 *   
 * Copyright (c) 2006- by CE.   
 */   
package com.sitechasia.webx.core.utils.datasource;

import java.sql.SQLException;

import javax.sql.DataSource;

/**
 * 适用于JDK1.6版本的抽象类
 * @author MarkDong
 * @version 1.0   
 * @see  
 */
public class MustangDataSource {
	protected DataSource wrappedDataSource;

	public boolean isWrapperFor(Class<?> arg0) throws SQLException {
		return wrappedDataSource.isWrapperFor(arg0);
	}

	public <T> T unwrap(Class<T> arg0) throws SQLException {
		return wrappedDataSource.unwrap(arg0);
	}
}
