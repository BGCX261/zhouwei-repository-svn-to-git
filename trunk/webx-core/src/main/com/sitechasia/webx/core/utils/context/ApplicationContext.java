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
package com.sitechasia.webx.core.utils.context;

/**
 * 应用内公用的全局的Context
 *
 * @author Zal
 * @author todd
 * @version 1.2 , 2008/5/7
 * @since JDK1.5
 */
public final class ApplicationContext extends BaseContext {

	/**
	 * 生成一个ApplicationContext对象
	 */
	private static final ApplicationContext instance = new ApplicationContext();

	/**
	 * 私有的构造函数防止用户随意生成本对象
	 */
	private ApplicationContext() {}

	/**
	 * 返回一个全局唯一的ApplicationContext对象
	 * @return 全局唯一的ApplicationContext对象
	 */
	public static IContext getInstance() {
		return instance;
	}
}
