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
package com.sitechasia.webx.components.datasource.context;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sitechasia.webx.components.datasource.context.model.Domain2d;

/**
 * 使用Hibernate的Domain和数据源名称转换的Bean
 * 需要数据库中有对应的表
 *
 * @author Administrator
 * @version 1.2 , 2008/5/9
 * @since JDK1.5
 */
public class InTableDomain2DS extends HibernateDaoSupport implements Domain2DS{

	private boolean selfCall;

	public synchronized String toDS(String domain){
		selfCall = true;
		Domain2d d2d = (Domain2d)getHibernateTemplate().load(Domain2d.class, domain);
		selfCall = false;
		return d2d.getDs();
	}

	public synchronized boolean isSelfCall() {
		return selfCall;
	}
}
