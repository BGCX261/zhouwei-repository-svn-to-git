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

import java.util.Map;

/**
 * 内存中的Domain和数据源名称转换的Bean
 *
 * @author Administrator
 * @version 1.2 , 2008/5/9
 * @since JDK1.5
 */
public class InMemoryDomain2DS implements Domain2DS {

	/**
	 * 用于存储Domain和数据源名称的Map
	 */
	private Map<String, String> domain2dsMapping;

	public Map<String, String> getDomain2dsMapping() {
		return domain2dsMapping;
	}

	public void setDomain2dsMapping(Map<String, String> domain2dsMapping) {
		this.domain2dsMapping = domain2dsMapping;
	}

	/**
	 * 实现了Domain2DS接口中的相同方法
	 * 用于返回一个数据源名称
	 */
	public String toDS(String domain) {
		return domain2dsMapping.get(domain);
	}
}
