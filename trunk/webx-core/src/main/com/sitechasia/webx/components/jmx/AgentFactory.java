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

import java.lang.management.ManagementFactory;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;

import javax.management.MBeanServerFactory;

/**
 * 用于产生Agent的工厂类.
 * <p>通过调用工厂类的不同静态方法，可以产生所需要的Agent。
 * 工厂方法通过判断AgentType枚举类型来决定生成何种Agent，该工厂现支持两种AgentType，分别为Default和EmptyServer。
 * Default将采用默认的DefaultAgentImpl和一个已注册了多个默认JVM MXBean的MBServer来生成一个Agent对象。
 * EmptyServer将采用默认的DefaultAgentImpl和一个空的MBServer来生成一个Agent对象。
 * 对于一种AgentType类型，工厂将在第一次被调用时初始化一个对应于该类型的Agent对象，后续调用将永远返回该Agent对象。
 * 虽然工厂提供了返回多个Agent的能力，但是在非必要情况下建议只使用一个Agent进行操作。</p>
 *
 *
 * <pre>
 *	Agent agent = AgentFactory.getAgent() //获得一个Agent对象，Agent对象的所有设置将使用默认值<br/>
 *	agent.addCallback(回调对象); //回调对象可直接继承于{@link com.sitechasia.webx.components.jmx.util.AbstractProxyCallback}<br/>
 *  MBeanServer server = agent.getMBeanServer(); //获得已经设置了回调对象的Server<br/>
 *  <br/>
 *  //在这里生成一个您自己的MBean，假设您生成了一个HelloMBean， 对象为hello。<br/>
 *  //另，对于所有MBean中的参数和返回值，建议使用基本类型的包装类和String。<br/>
 *  <br/>
 *  //为MBean添加开关<br/>
 *  MBeanUtil mbeanHelper = new MBeanUtil(hello); //生成MBean帮助对象<br/>
 *  MBeanSwither helloMBeanSwither = new MBeanSwither(); //生成一个对你的MBean的开关<br/>
 *  helloMBeanSwither.setSwitcher(true); //将这个开关打开<br/>
 *  HelloMBean newHello = (HelloMBean)mbeanHelper.addCallback(helloMBeanSwither).getMBean(); //生成了一个添加了开关的新MBean<br/>
 *  <br/>
 *  ObjectName helloName = new ObjectName(您所指定的名称); //生成一个MBean的名称<br/>
 *  server.registerMBean(newHello, helloName)；//注册MBean，在执行server对象的方法时，您所设置的回调对象将会被执行。
 * </pre>
 *
 * @see Agent
 * @see AgentType
 * @author CE
 * @version 1.2 , 2008/5/12
 * @since JDK1.5
 */
public class AgentFactory {

	/**
	 * 用于保存已生成的Agent对象的Map，使用Hashtable以保证线程安全。
	 */
	private static Map<AgentType, Agent> agentMap = new Hashtable<AgentType, Agent>();

	/**
	 * 私有构造器防止对该工厂类的实例化
	 */
	private AgentFactory() {
	}

	/**
	 * 返回一个使用了使用了AgentType.Default进行构造的Agent对象
	 * 相当于调用getAgent(AgentType.Default, null)。
	 * @return Agent
	 */
	public static Agent getAgent() {
		return getAgent(AgentType.Default);
	}

	/**
	 * 返回一个使用了使用了用户输入AgentType类型进行构造的Agent对象
	 * 相当于调用getAgent(type, null)。
	 * @param type 所要生成的Agent对象的类型
	 * @return Agent
	 */
	public static Agent getAgent(AgentType type) {
		return getAgent(type, null);
	}

	/**
	 * 返回一个使用了使用了AgentType.Default和用户定义参数进行构造的Agent对象
	 * 相当于调用getAgent(AgentType.Default, property)。
	 * @param property 对所生成的Agent对象进行定制所需要的参数
	 *            对该Agent进行定制所需的参数.现有三个key，分别为<br/>
	 *            <li/>rmi.service.url 表示注册RMI Connector时的服务地址，其中可能会包括Stub的地址。
	 *            例如"service:jmx:rmi:///jndi/rmi://localhost:9999/server"表示将会把该RMI Connector的Stub注册到本地的rmiregistry中
	 *            <li/>html.service.port 表示注册HTML Adapter时提供服务所在的端口号
	 *            <li/>html.service.name 表示注册HTML Adapter时提供服务的MBean名称
	 * @return Agent
	 */
	public static Agent getAgent(Properties property) {
		return getAgent(AgentType.Default, property);
	}

	/**
	 * 该方法是用户有机会选择所生成的Agent对象的类型，并可以根据需要提供定制化参数以控制Agent对象的特性。
	 * @param type 所要生成的Agent对象的类型
	 * @param property 对所生成的Agent对象进行定制所需要的参数
	 *            对该Agent进行定制所需的参数.现有三个key，分别为<br/>
	 *            <li/>rmi.service.url 表示注册RMI Connector时的服务地址，其中可能会包括Stub的地址。
	 *            例如"service:jmx:rmi:///jndi/rmi://localhost:9999/server"表示将会把该RMI Connector的Stub注册到本地的rmiregistry中
	 *            <li/>html.service.port 表示注册HTML Adapter时提供服务所在的端口号
	 *            <li/>html.service.name 表示注册HTML Adapter时提供服务的MBean名称
	 * @return Agent 本Agent对象
	 */
	public static Agent getAgent(AgentType type, Properties property) {

		if (type == null)
			throw new JMXRuntimeException("Argument \"type\" can not be null!");

		//保证在多线程情况下Agent对象不会被多次实例化
		if (agentMap.get(type) == null) {
			synchronized (AgentFactory.class) {
				if (agentMap.get(type) == null) {
					agentMap.put(type, createAgent(type, property));
				}
			}
		}

		return agentMap.get(type);
	}

	/**
	 * 工厂私有的，用于创建Agent实例的方法.
	 * 该方法根据AgentType返回一个Agent对象。
	 * @param type 所要生成的Agent对象的类型
	 * @param property 对所生成的Agent对象进行定制所需要的参数
	 *            对该Agent进行定制所需的参数.现有三个key，分别为<br/>
	 *            <li/>rmi.service.url 表示注册RMI Connector时的服务地址，其中可能会包括Stub的地址。
	 *            例如"service:jmx:rmi:///jndi/rmi://localhost:9999/server"表示将会把该RMI Connector的Stub注册到本地的rmiregistry中
	 *            <li/>html.service.port 表示注册HTML Adapter时提供服务所在的端口号
	 *            <li/>html.service.name 表示注册HTML Adapter时提供服务的MBean名称
	 * @return Agent 本Agent对象
	 */
	private static Agent createAgent(AgentType type, Properties property) {

		Agent createdAgent = null;

		switch (type) {
		case Default:
			createdAgent = new DefaultAgentImpl(ManagementFactory
					.getPlatformMBeanServer(), property);
			break;

		case EmptyServer:
			createdAgent = new DefaultAgentImpl(MBeanServerFactory
					.newMBeanServer(), property);
			break;
		default:
			throw new JMXRuntimeException("Unsupported type value!");
		}

		return createdAgent;
	}
}
