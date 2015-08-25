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

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 提供对MBeanServerProxy对象进行方法级回调的能力.
 * 用户可根据自己的业务需求编写适合自己需求的处理实现。
 *
 * @author CE
 * @version 1.2 , 2008/5/12
 * @since JDK1.5
 */
public interface ProxyCallback extends InvocationHandler {

	/**
	 * 用于将一个需要被包装的obj绑定至该Callback对象
	 * @param obj 需要被绑定的对象
	 * @return 被包装成proxy的新对象
	 */
	public Object bind(Object obj);

	/**
	 * MBeanServerProxy对象进行方法前回调时所调用的方法
	 * 返回值将决定是否继续执行后续操作
	 * @param method 所调用方法的标识
	 * @param args 所调用方法的参数
	 * @return Object 如果为null则执行真正的方法调用，如果不为null则终止操作并将其作为结果返回
	 */
	public Object beforeMethodCall(Method method, Object[] args);

	/**
	 * MBeanServerProxy对象进行方法后回调时所调用的方法
	 * 返回值将决定方法调用最终所返回的结果
	 * @param result 方法调用所产生的结果,供用户有机会对上次产生的结果进行处理
	 * @param method 被调用了的方法
	 * @return Object 如果为null则返回真正的方法调用结果，如果不为null则将该值作为最终结果。
	 */
	public Object afterMethodCall(Object result, Method method);
}
