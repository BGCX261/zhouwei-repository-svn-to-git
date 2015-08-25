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
import java.lang.reflect.Proxy;

import com.sitechasia.webx.components.jmx.JMXRuntimeException;

/**
 * 默认提供的用于回调的抽象类.
 * 建议用户实现自己的回调时继承该类并实现指定的方法以实现回调。
 *
 * @author CE
 * @version 1.2 , 2008/5/12
 * @since JDK1.5
 */
public abstract class AbstractProxyCallback implements ProxyCallback {

	/**
	 * 用于存储所绑定的对象
	 */
	private Object obj;

	/**
	 * 将要被包装的对象绑定至这个Callback对象
	 */
	public Object bind(Object obj) {

		if (obj.getClass().getInterfaces().length == 0) {
			throw new JMXRuntimeException("object must implement atleast one interface!");
		}

		this.obj = obj;

		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj
				.getClass().getInterfaces(), this);
	}

	/**
	 * 实现了InvocationHandler中的相同方法. 用于在方法执行过程中进行附加操作。
	 *
	 * @see InvocationHandler
	 */
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {

		Object finalResult = beforeMethodCall(method, args);

		if (finalResult == null) {

			finalResult = method.invoke(this.obj, args);

			Object afterResult = afterMethodCall(finalResult, method);

			if (afterResult != null) {
				finalResult = afterResult;
			}
		}

		return finalResult;
	}

	/**
	 * 受保护的方法，为继承该类的其它类提供一个获得原始对象的机会。
	 * @return 原始的未被包装的对象
	 */
	protected Object getOriginalObject() {
		return this.obj;
	}

	/**
	 * 需要由用户实现的回调前方法
	 */
	public abstract Object beforeMethodCall(Method method, Object[] args);

	/**
	 * 需要由用户实现的回调后方法
	 */
	public abstract Object afterMethodCall(Object result, Method method);
}
