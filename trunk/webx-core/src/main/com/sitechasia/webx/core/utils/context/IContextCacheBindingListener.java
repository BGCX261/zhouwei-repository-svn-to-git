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
 * 用于对ContextCache做CallBack的接口
 * 实现了该接口的Cache，Context基类会自动将Context本身设置回Cache中供使用
 *
 * @author Zal
 * @version 1.2 , 2008/5/8
 * @since JDK1.5
 */
public interface IContextCacheBindingListener {

	/**
	 * ContextCache被绑定前所调用的方法
	 * @param context 调用方需要设置的Context
	 */
	public void beforeBind(IContext context);

	/**
	 * ContextCache被绑定后所调用的方法
	 * @param context 调用方需要设置的Context
	 */
	public void afterBind(IContext context);

	/**
	 * ContextCache被解除绑定前所调用的方法
	 * @param context 调用方需要设置的Context
	 */
	public void beforeUnBind(IContext context);

	/**
	 * ContextCache被解除绑定后所调用的方法
	 * @param context 调用方需要设置的Context
	 */
	public void afterUnBind(IContext context);
}
