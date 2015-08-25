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
package com.sitechasia.webx.components.jmx;

import java.util.Properties;

import javax.management.MBeanServer;

import com.sitechasia.webx.components.jmx.util.AdapterConnectorRegisterUtil;
import com.sitechasia.webx.components.jmx.util.AdapterConnectorType;
import com.sitechasia.webx.components.jmx.util.ProxyCallback;

/**
 * 默认采用的Agent接口的实现类. 他提供了一个MBServer对象， 一个JDK 1.5中自带的RMI Connector
 * 和一个默认注册于9092端口的Sun扩展包中所带的Html Adapter。 也可以向其MBServer中添加方法回调对象。
 * 用户如果需要其他功能，可以继承该类并进行扩展，也可以独立实现一个新的Agent。
 *
 * @see Agent
 * @see com.sitechasia.webx.components.jmx.util.ProxyCallback
 * @see com.sitechasia.webx.components.jmx.util.AdapterConnectorRegisterUtil
 *
 * @author CE
 * @version 1.2 , 2008/5/12
 * @since JDK1.5
 */
public class DefaultAgentImpl implements Agent {

	private MBeanServer server;

	private MBeanServer proxy;

	/**
	 * 受保护的构造器意味着包外对该类的调用只能通过继承来实现.
	 *
	 * @param server
	 *            一个提供给该Agent使用的MBServer
	 * @param property
	 *            对该Agent进行定制所需的参数.现有三个key，分别为<br/>
	 *            <li/>rmi.service.url 表示注册RMI Connector时的服务地址，其中可能会包括Stub的地址
	 *            <li/>html.service.port 表示注册HTML Adapter时提供服务所在的端口号
	 *            <li/>html.service.name 表示注册HTML Adapter时提供服务的MBean名称
	 */
	protected DefaultAgentImpl(MBeanServer server, Properties property) {

		this.proxy = this.server = server;

		// 向Server注册RMI Connector和Html Adapter。
		AdapterConnectorRegisterUtil register = new AdapterConnectorRegisterUtil(
				getMBeanServer());

		// 向Agent注册一个JDK1.5自带的RMI Connector
		register.createRegister(AdapterConnectorType.DefaultRMIConnector).registerWithProperties(property);

		// 向Agent注册一个Sun扩展包所提供的HTML Adapter
		register.createRegister(AdapterConnectorType.SunHtmlAdapter).registerWithProperties(property);
	}

	/**
	 * 获得Agent中所注册的MBServer.
	 * @return 当前Agent中所使用的MBeanServer
	 */
	public MBeanServer getMBeanServer() {
		return proxy;
	}

	/**
	 * 向MBeanServer中添加回调对象
	 *
	 * @param callback
	 *            回调时所使用的对象，建议直接继承于默认提供的{@link com.sitechasia.webx.components.jmx.util.AbstractProxyCallback}
	 * @return 当前Agent对象
	 */
	public Agent addCallback(ProxyCallback callback) {

		if (callback != null) {
			this.proxy = (MBeanServer) callback.bind(this.proxy);
		}

		return this;
	}

	/**
	 * 删除所有已添加的回调对象
	 */
	public Agent removeCallbacks() {
		this.proxy = this.server;
		return this;
	}
}
