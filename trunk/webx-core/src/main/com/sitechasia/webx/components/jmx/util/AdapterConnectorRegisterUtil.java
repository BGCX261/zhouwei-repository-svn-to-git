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

import javax.management.MBeanServer;

import com.sitechasia.webx.components.jmx.JMXRuntimeException;

/**
 * 向一个MBeanServer注册Adapter和Connector时所使用的辅助工具类.
 * 根据AdapterConnectorType枚举类型选择向MBeanServer对象注册具体的实现。
 *
 * @author CE
 * @version 1.2 , 2008/5/12
 * @since JDK1.5
 */
public class AdapterConnectorRegisterUtil {

	/**
	 * 用于保存需要向其注册的MBeanServer对象
	 */
	private MBeanServer server;

	/**
	 * @param server 需要被注册Adapter或Connector的MBeanServer对象
	 */
	public AdapterConnectorRegisterUtil(MBeanServer server) {
		this.server = server;
	}

	/**
	 * 用户获得type类型实例的方法
	 * @param type Adapter或Connector的类型
	 * @return AdapterConnectorRegister
	 */
	public AdapterConnectorRegister createRegister(AdapterConnectorType type) {

		AdapterConnectorRegister register = null;

		switch (type) {
		case SunHtmlAdapter:
			register = new SunHtmlAdapterRegister(server);
			break;

		case DefaultRMIConnector:
			register = new DefaultRMIConnectorRegister(server);
			break;

		default:
			throw new JMXRuntimeException("Unsupported AdapterConnectorType!");

		}

		return register;
	}
}
