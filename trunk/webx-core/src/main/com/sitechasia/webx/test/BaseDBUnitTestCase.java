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
package com.sitechasia.webx.test;

import javax.sql.DataSource;

import org.dbunit.DatabaseTestCase;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * 数据库测试基类
 *
 * @author Administrator
 * @author todd
 * @version 1.2 , 2008/5/7
 * @since JDK1.5
 */

public abstract class BaseDBUnitTestCase extends DatabaseTestCase {

	/**
	 * Spring Context
	 */
	protected static ApplicationContext applicationContext;

	static {
		applicationContext = new ClassPathXmlApplicationContext(new String[] {
				"classpath*:modules/spring.xml",
				"classpath*:modules/**/spring-conf/*.xml" });
	}

	public BaseDBUnitTestCase() {}

	/**
	 * 得到数据库连接
	 */
	protected IDatabaseConnection getConnection() throws Exception {
		DataSource ds = (DataSource) applicationContext
				.getBean(getDataSourceBeanName());
		return new DatabaseConnection(ds.getConnection());
	}

	/**
	 * Spring中连接池Bean名称
	 *
	 * @return 数据源的名称
	 */
	public String getDataSourceBeanName() {
		return "dataSource";
	}
}
