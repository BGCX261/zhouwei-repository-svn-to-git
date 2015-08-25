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
package com.sitechasia.webx.components.datasource.proxy;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Map;

import javax.sql.DataSource;

import com.sitechasia.webx.components.datasource.context.Domain2DS;
import com.sitechasia.webx.components.datasource.context.DomainContextHolder;
import com.sitechasia.webx.components.datasource.context.InTableDomain2DS;

/**
 * 多数据源的基类，所有其它的实现都应继承该基类。
 * 本实现使用单SessionFactory。
 *
 * @author Administrator
 * @version 1.2 , 2008/5/9
 * @since JDK1.5
 */
public abstract class BaseDomainAwareDataSource implements IDomainAwareDataSource {

	/**
	 * 域名和数据源名称进行转换的属性
	 */
	private Domain2DS domain2ds;

	/**
	 * 以域名为Key对各个数据源进行存储的缓存
	 */
	private Map<String, DataSource> cache = new Hashtable<String, DataSource>();

	/**
	 * 当未能成功获取数据源时所使用的默认数据源
	 */
	private DataSource defaultDataSource;

	/**
	 * 从缓存中获取对应的数据源，如果未能取到则使用默认的数据源
	 * @return 从缓存中获取到的数据源
	 */
	private DataSource getCachedDataSource() {

		String domain = DomainContextHolder.getMyDomain();
		try {
			if (domain == null || domain2ds == null) {
				return defaultDataSource;
			} else if (!cache.containsKey(domain)) {
				synchronized (this) {
					if (!cache.containsKey(domain)) {

						if (domain2ds instanceof InTableDomain2DS) {
							if (((InTableDomain2DS)

domain2ds).isSelfCall()) {
								return defaultDataSource;
							}
						}

						DataSource tempDS = null;
						String dataSourceName = domain2ds.toDS

(domain);

						if (dataSourceName != null) {
							tempDS = getDataSource

(dataSourceName);
						}

						if (tempDS == null) {
							return defaultDataSource;
						} else {
							cache.put(domain, tempDS);
						}
					}
				}
			}
		} catch (Exception e) {
			return defaultDataSource;
		}

		return cache.get(domain);
	}

	/**
	 * 需要被子类所实现的用于根据不同的名称获得数据源的方法
	 * @param name 数据源的名字
	 * @return 根据名字所获得的数据源
	 */
	protected abstract DataSource getDataSource(String name);

	/**
	 * 真实数据源方法的代理，详细请参见JDK文档
	 */
	public Connection getConnection() throws SQLException {
		return getCachedDataSource().getConnection();
	}

	/**
	 * 真实数据源方法的代理，详细请参见JDK文档
	 */
	public Connection getConnection(String username, String password)
			throws SQLException {
		return getCachedDataSource().getConnection(username, password);
	}

	/**
	 * 真实数据源方法的代理，详细请参见JDK文档
	 */
	public int getLoginTimeout() throws SQLException {
		return getCachedDataSource().getLoginTimeout();
	}

	/**
	 * 真实数据源方法的代理，详细请参见JDK文档
	 */
	public PrintWriter getLogWriter() throws SQLException {
		return getCachedDataSource().getLogWriter();
	}

	/**
	 * 真实数据源方法的代理，详细请参见JDK文档
	 */
	public void setLoginTimeout(int seconds) throws SQLException {
		getCachedDataSource().setLoginTimeout(seconds);
	}

	/**
	 * 真实数据源方法的代理，详细请参见JDK文档
	 */
	public void setLogWriter(PrintWriter out) throws SQLException {
		getCachedDataSource().setLogWriter(out);
	}

	public Domain2DS getDomain2ds() {
		return domain2ds;
	}

	public void setDomain2ds(Domain2DS domain2ds) {
		this.domain2ds = domain2ds;
	}

	public DataSource getDefaultDataSource() {
		return defaultDataSource;
	}

	public void setDefaultDataSource(DataSource defaultDataSource) {
		this.defaultDataSource = defaultDataSource;
	}

	/* JDK1.6新增的方法，为了和JDK1.6兼容，新增两个方法
	 * 简单抛出UnsupportedOperationException;
	 */

	/*
	 * 简单抛出UnsupportedOperationException;
	 */
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		throw new UnsupportedOperationException("unsuppoted!");
	}

	/*
	 * 简单抛出UnsupportedOperationException;
	 */
	public <T> T unwrap(Class<T> iface) throws SQLException {
		throw new UnsupportedOperationException("unsuppoted!");
	}


}
