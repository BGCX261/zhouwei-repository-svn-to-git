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

import java.util.Properties;

/**
 * 对于MBeanServer注册一个Adapter或Connector.
 * 具体注册的是何种Adapter或Connector将有具体的实现类决定。
 *
 * @author CE
 * @version 1.2 , 2008/5/12
 * @since JDK1.5
 */
public interface AdapterConnectorRegister {

	/**
	 * 使用参数来设置注册的特性.
	 * 具体的Key和Vlue值由具体的实现进行定义。
	 * @param properties 对注册进行定制的参数。
	 */
	public void registerWithProperties(Properties properties);

	/**
	 * 根据所提供的port和参数注册一个Adapter或Connector.
	 * 参数的意义和规则由实现类决定。
	 * @param port 服务端口
	 * @param params 注册参数
	 */
	public void register(int port, String... params);

	/**
	 * 根据所提port和默认参数注册一个Adapter或Connector.
	 * 参数的意义和规则由实现类决定。
	 * @param port 服务端口
	 */
	public void register(int port);

	/**
	 * 根据默认port和所提供的参数注册一个Adapter或Connector.
	 * 参数的意义和规则由实现类决定。
	 * @param params 注册参数
	 */
	public void register(String... params);

	/**
	 * 根据默认port和默认参数注册一个Adapter或Connector.
	 * 参数的意义和规则由实现类决定。
	 */
	public void register();
}
