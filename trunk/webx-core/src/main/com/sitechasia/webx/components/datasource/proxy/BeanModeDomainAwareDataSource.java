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

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * 用于从Spring Bean中获取数据源的实现
 *
 * @author Administrator
 * @version 1.2 , 2008/5/9
 * @since JDK1.5
 */
public class BeanModeDomainAwareDataSource extends BaseDomainAwareDataSource implements BeanFactoryAware {

	private BeanFactory factory;

	public void setBeanFactory(BeanFactory factory) throws BeansException {
		this.factory = factory;
	}

	/**
	 * 实现了基类的方法
	 */
	protected DataSource getDataSource(String beanName) {
		return (DataSource)factory.getBean(beanName);
	}
}
