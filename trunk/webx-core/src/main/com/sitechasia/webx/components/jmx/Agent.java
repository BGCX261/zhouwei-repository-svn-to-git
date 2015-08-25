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

import javax.management.MBeanServer;

import com.sitechasia.webx.components.jmx.util.ProxyCallback;

/**
 * 所有Agent均需继承于该接口.
 * JMX Agent是一个包含了MBServer、Service、Connector和Adapter
 * 的对象。所提供的具体形式将由不同的实现类负责。
 *
 * @author CE
 * @version 1.2 , 2008/5/12
 * @since JDK1.5
 */
public interface Agent {

	/**
	 * 获得Agent中所注册的MBServer.
	 * 通过本方法获得的将是一个Agent内所包含的MBServer，
	 * @return Agent中所包含的Server
	 */
	public MBeanServer getMBeanServer();

	/**
	 * 为这个Agent中的MBeanServer添加回调对象
	 * @param callback 用于回调所使用的对象
	 * @return 本Agent对象
	 */
	public Agent addCallback(ProxyCallback callback);

	/**
	 * 清楚所有已添加了的回调对象
	 * @return 本Agent对象
	 */
	public Agent removeCallbacks();
}
