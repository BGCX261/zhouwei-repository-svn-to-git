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

import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.OperationsException;

import com.sitechasia.webx.components.jmx.JMXRuntimeException;
import com.sun.jdmk.comm.HtmlAdaptorServer;

/**
 * 该实现将注册一个Sun在JMX工具包中所提供的一个HTML Adapter
 *
 * @author CE
 * @version 1.2 , 2008/5/12
 * @since JDK1.5
 */
public class SunHtmlAdapterRegister implements AdapterConnectorRegister {

	/**
	 * 默认要注册的HTML Adapter端口地址。
	 */
	public final static int DEFAULT_PORT = 9092;

	/**
	 * 默认的Adapter名称。
	 */
	public final static String DEFAULT_OBJECT_NAME = "DefaultDomain:type=adapter,name=sunHtmlAdapter,port=";

	/**
	 * 保存需要对其注册的MBeanServer
	 */
	private MBeanServer server;

	/**
	 * @param server 需要对其注册的MBeanServer
	 */
	public SunHtmlAdapterRegister(MBeanServer server) {
		this.server = server;
	}

	/**
	 * 使用默认的端口和ObjectName注册一个HtmlAdapter
	 * port的默认值为：9092
	 * ObjectName的moren值为"DefaultDomain:type=adapter,name=sunHtmlAdapter,port=9092"
	 */
	public void register() {
		register(DEFAULT_PORT, DEFAULT_OBJECT_NAME + DEFAULT_PORT);
	}

	/**
	 * 使用前端传过来的参数注册Adapter，不提供的参数使用默认值。
	 * @param properties
	 *            对该SunHtmlAdapterRegister进行定制所需的参数.现有两个key，分别为<br/>
	 *            <li/>html.service.port 表示注册HTML Adapter时提供服务所在的端口号
	 *            <li/>html.service.name 表示注册HTML Adapter时提供服务的MBean名称
	 */

	public void registerWithProperties(Properties properties) {
		String portStr = properties == null ? null : properties
				.getProperty("html.service.port");

		int portInt = portStr == null ? DEFAULT_PORT : Integer.parseInt(portStr);

		String objectName = properties == null ? null : properties
				.getProperty("html.service.name");
		if (objectName == null) {
			objectName = DEFAULT_OBJECT_NAME + portInt;
		}

		register(portInt, objectName);
	}

	/**
	 * 使用默认的端口注册一个HtmlAdapter port的默认值为：9092
	 *
	 * @param params
	 *            注册时所需要的参数，注册为MBean时的ObjectName的值，即该MBean的名字，长度必须为1
	 */
	public void register(String... params) {
		register(DEFAULT_PORT, params);
	}

	/**
	 * 使用默认的ObjectName注册一个HtmlAdapter.
	 * ObjectName的默认值为("DefaultDomain:type=adapter,name=sunHtmlAdapter,port=" + port)
	 * @param port 注册的端口，在该实现中表示该Html Adapter所提供服务的端口。
	 */
	public void register(int port) {
		register(port, DEFAULT_OBJECT_NAME + port);
	}

	/**
	 * 注册一个HtmlAdapter.
	 * ObjectName的默认值为("DefaultDomain:type=adapter,name=sunHtmlAdapter,port=" + port)
	 * @param port 注册的端口，在该实现中表示该Html Adapter所提供服务的端口。
	 * @param params 注册时所需要的参数，注册为MBean时的ObjectName的值，即该MBean的名字，长度必须为1
	 */
	public void register(int port, String... params) {

		//进行校验
		validate(port, params);

		HtmlAdaptorServer adapter = new HtmlAdaptorServer();

		try {

			ObjectName adapterName = new ObjectName(params[0]);

			adapter.setPort(port);

			server.registerMBean(adapter, adapterName);
		} catch (OperationsException e) {
			throw new JMXRuntimeException(
					"HTML Adapter Server Initialization Failed!", e);
		} catch (MBeanRegistrationException e) {
			throw new JMXRuntimeException(
					"HTML Adapter Server Initialization Failed!", e);
		}
		adapter.start();
	}

	/**
	 * 私有的校验方法
	 * @param port 端口值，必须在0到65536之间
	 * @param params ObjectName值，长度必须为1
	 */
	private void validate(int port, String... params) {

		if (port <= 0 && port >= 65536) {
			throw new JMXRuntimeException(
					"port value out of range, must between 0 and 65535");
		}

		if (params == null || params.length != 1) {
			throw new JMXRuntimeException("invalide params length!");
		}
	}

}
