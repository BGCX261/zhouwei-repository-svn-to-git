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
package com.sitechasia.webx.components.jmx.util;

import com.sitechasia.webx.components.jmx.mbean.MBeanGeneric;

/**
 * 用于帮助用户对MBean进行操作的工具类
 *
 * @see MBeanSwither
 * @author CE
 * @version 1.2 , 2008/5/12
 * @since JDK1.5
 */
public class MBeanUtil {

	/**
	 * 保存一个MBean对象
	 */
	private MBeanGeneric obj;

	/**
	 * @param obj MBean对象
	 */
	public MBeanUtil(MBeanGeneric obj) {
		this.obj = obj;
	}

	/**
	 * 对MBean添加回调的方法.
	 * 默认提供的MBeanSwither为MBean提供了开关的功能，
	 * 用户可以实现适用于自己的开关，也可以实现其它的更丰富的功能操作。
	 * @param callback 回调对象
	 * @return Object 被添加了回调对象的MBean
	 */
	public MBeanUtil addCallback(ProxyCallback callback) {
		this.obj = (MBeanGeneric)callback.bind(obj);
		return this;
	}

	/**
	 * 获得这个辅助类所绑定的MBean
	 * @return 进行功能扩展后的MBean
	 */
	public Object getMBean() {
		return obj;
	}
}
