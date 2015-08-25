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

import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

/**
 * Dao测试基类
 *
 * @author Administrator
 * @author todd
 * @version 1.2 , 2008/5/7
 * @since JDK1.5
 */
public abstract class BaseDaoTestCase extends
		AbstractTransactionalDataSourceSpringContextTests {

	/**
	 * Spring的配置路径
	 */
	protected String[] getConfigLocations() {
		setAutowireMode(AUTOWIRE_BY_NAME);
		return new String[] {"classpath*:modules/spring.xml","classpath*:modules/**/spring-conf/*.xml"};
	}

	public BaseDaoTestCase() {

	}
}
