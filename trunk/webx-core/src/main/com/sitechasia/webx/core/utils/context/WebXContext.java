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
 * 为方便使用而设置的WebX中获得Context的工具类
 *
 * @author Zal
 * @version 1.2 , 2008/5/8
 * @since JDK1.5
 */
public final class WebXContext {

	/**
	 * 获得一个数据通道Context
	 * @return 数据通道Context
	 */
	public static IContext getDataChannelContext() {
		return DataChannelContext.getInstance();
	}

	/**
	 * 获得一个用户数据Context
	 * @return 用户数据Context
	 */
	public static IContext getUserDataContext() {
		return UserDataContext.getInstance();
	}

	/**
	 * 获得一个应用Context
	 * @return 应用Context
	 */
	public static IContext getApplicationContext() {
		return ApplicationContext.getInstance();
	}
}
