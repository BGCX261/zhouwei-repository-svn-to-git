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

import java.io.IOException;
import java.util.Properties;

import javax.management.MBeanServer;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;

import com.sitechasia.webx.components.jmx.JMXRuntimeException;

/**
 * 该实现将注册一个JDK 1.5自带的RMI Connector
 *
 * @author CE
 * @version 1.2 , 2008/5/12
 * @since JDK1.5
 */
public class DefaultRMIConnectorRegister implements AdapterConnectorRegister {

	/**
	 * 默认的Service URL的地址
	 */
	public final static String DEFAULT_SERVICE_URL = "service:jmx:rmi:///";

	/**
	 * 保存需要对其注册的MBeanServer
	 */
	private MBeanServer server;

	/**
	 * @param server 需要对其注册的MBeanServer
	 */
	public DefaultRMIConnectorRegister(MBeanServer server) {
		this.server = server;
	}

	/**
	 * 使用前端传过来的参数注册Adapter，不提供的参数使用默认值。
	 * @param properties
	 *            对该DefaultRMIConnectorRegister进行定制所需的参数.现有一个key，为<br/>
	 *            <li/>rmi.service.url 表示注册RMI Connector时的服务地址，其中可能会包括Stub的地址
	 */
	public void registerWithProperties(Properties properties) {
		String rmiServiceUrl = properties == null ? null : properties
				.getProperty("rmi.service.url");
		if (rmiServiceUrl == null) {
			rmiServiceUrl = DEFAULT_SERVICE_URL;
		}

		register(0, rmiServiceUrl);
	}

	/**
	 * 对JMXServiceURL值使用默认的"service:jmx:rmi:///"，注册一个RMI Connector
	 */
	public void register() {
		register(DEFAULT_SERVICE_URL);
	}

	/**
	 * 使用提供的JMXServiceURL值注册一个RMI Connector.
	 * 提供的params参数的长度必须为1，否则抛出一个JMXRuntimeException
	 * @param params 注册时所需要的参数，此处为JMXServiceURL值
	 */
	public void register(String... params) {
		register(-1, params);
	}

	/**
	 * 该Adapter不支持port的设置，调用本方法将抛出一个JMXRuntimeException
	 * @param port 注册的端口，在该实现中不起作用
	 */
	public void register(int port) {
		throw new JMXRuntimeException("Unsupported operation");
	}

	/**
	 * 使用提供的JMXServiceURL值和port值注册一个RMI Connector.
	 * 提供的params参数的长度必须为1，否则抛出一个JMXRuntimeException。
	 * @param port 注册的端口，在该实现中不起作用
	 * @param params 注册时所需要的参数，此处为JMXServiceURL值
	 */
	public void register(int port, String... params) {

		//进行校验
		validate(port, params);

		try {
			JMXServiceURL serviceURL = new JMXServiceURL(params[0]);

			JMXConnectorServer cs = JMXConnectorServerFactory
					.newJMXConnectorServer(serviceURL, null, server);

			cs.start();
		} catch (IOException e) {
			throw new JMXRuntimeException("RMI Server Initialization Failed!",
					e);
		}
	}

	/**
	 * 私有的校验方法
	 * @param port 端口值，在本实现中不进行校验
	 * @param params 所提供的JMXServiceURL值，长度必须为1
	 */
	private void validate(int port, String... params) {
		if (params == null || params.length != 1)
			throw new JMXRuntimeException("invalide params length!");
	}
}
