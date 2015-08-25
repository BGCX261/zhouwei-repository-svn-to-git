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

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

/**
 * 从JDNI中获取数据源的实现
 *
 * @author Administrator
 * @version 1.2 , 2008/5/9
 * @since JDK1.5
 */
public class JNDIModeDomainAwareDataSource extends BaseDomainAwareDataSource {

	/**
	 * Spring中用JDNI查找数据源的辅助类
	 */
	private JndiDataSourceLookup jndiDataSourceLookup;

	/**
	 * 实现了基类的方法
	 */
	protected DataSource getDataSource(String jndiName) {
		return jndiDataSourceLookup.getDataSource(jndiName);
	}

	public JndiDataSourceLookup getJndiDataSourceLookup() {
		return jndiDataSourceLookup;
	}

	public void setJndiDataSourceLookup(JndiDataSourceLookup jndiDataSourceLookup) {
		this.jndiDataSourceLookup = jndiDataSourceLookup;
	}
}
