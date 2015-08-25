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
 * 一个线程内所使用的Context，可以作为线程内数据通道使用
 *
 * @author Zal
 * @author todd
 * @version 1.2 , 2008/5/7
 * @since JDK1.5
 */
public final class DataChannelContext extends BaseContext {

	/**
	 * 用于在一个线程内保存Context实例的ThreadLocal对象
	 */
	private static final ThreadLocal<DataChannelContext> contextThreadLocal = new ThreadLocal<DataChannelContext>();

	/**
	 * 私有的构造函数防止外部随意生成本对象
	 */
	private DataChannelContext() {}

	/**
	 * 静态的工厂方法用于控制返回一个Context对象，
	 * 如果在一个线程内已有一个DataChannelContext对象则返回这个对象，
	 * 否则新生成一个对象放入这个线程内。
	 * @return 一个线程内的DataChannelContext对象
	 */
	public static IContext getInstance() {

		/**
		 * 从当前线程内获得该对象
		 */
		DataChannelContext context = contextThreadLocal.get();

		/**
		 * 如果不存在则创建一个新的对象
		 */
		if (context == null) {
			context = new DataChannelContext();
			contextThreadLocal.set(context);
		}

		return context;
	}
}
