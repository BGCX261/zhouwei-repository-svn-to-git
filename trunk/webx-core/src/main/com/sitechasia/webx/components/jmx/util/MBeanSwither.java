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

import java.lang.reflect.Method;

import com.sitechasia.webx.components.jmx.JMXRuntimeException;

/**
 * 用于控制过滤MBean所使用的开关.
 * 通过控制本开关可以控制对应MBean的开启和关闭
 * 本对象应妥善保存以避免失去对MBean的开关控制。
 *
 * @see MBeanUtil
 * @author CE
 * @version 1.2 , 2008/5/12
 * @since JDK1.5
 */
public final class MBeanSwither extends AbstractProxyCallback {

	/**
	 * 用于控制MBean开启和关闭的开关.
	 * true为开启，false为关闭
	 */
	private boolean switcher;

	/**
	 * 过滤方法.
	 * 根据switcher来判断是否执行被调用的方法。
	 * 用户不需要直接调用本功能。
	 */
	public Object beforeMethodCall(Method method, Object[] args) {
		if (method.getName().equals("getMBeanInfo") && args.length == 0) {
			return null;
		}

		if (!switcher) {
			throw new JMXRuntimeException("MBean Switched Off, Operation Canceled!");
		}

		return null;
	}

	/**
	 * 回调后方法.
	 * 不做任何操作，用户不需要调用此功能。
	 */
	public Object afterMethodCall(Object result, Method method) {
		return null;
	}

	/**
	 * 设置MBean的开关
	 * @param switcher true为打开，false为关闭。
	 */
	public void setSwitcher(boolean switcher) {
		this.switcher = switcher;
	}

	/**
	 * 返回MBean当前的状态
	 * @return boolean true为打开，false为关闭。
	 */
	public boolean getSwitcher() {
		return this.switcher;
	}
}
