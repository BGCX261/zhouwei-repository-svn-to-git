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
package com.sitechasia.webx.components.jmx.mbean;

import java.util.Properties;

import com.sitechasia.webx.components.jmx.JMXRuntimeException;

/**
 * 用于包装一个Properties对象的MBean.
 * 通过这个MBean可以远程调整真正Properties对象的属性。
 * 该接口所提供的方法为真实Properties对象方法的一个子集，
 * 可以满足绝大多数的需要。
 *
 * @see java.util.Properties
 * @author CE
 * @version 1.2 , 2008/5/12
 * @since JDK1.5
 */
public abstract class PropertiesWrapper implements PropertiesWrapperMBean {

	/**
	 * 被包装的Properties对象
	 */
	private Properties properties;

	/**
	 * 唯一的构造方法
	 * @param properties
	 */
	public PropertiesWrapper(Properties properties) {
		if (properties == null) {
			throw new JMXRuntimeException("properties can not be null value");
		}

		this.properties = properties;
	}

	/**
	 * 请参见Properties中的相同方法
	 */
	public String getProperty(String key) {
		return properties.getProperty(key);
	}

	/**
	 * 请参见Properties中的相同方法
	 */
	public String getProperty(String key, String defaultValue) {
		return properties.getProperty(key, defaultValue);
	}

	/**
	 * 请参见Properties中的相同方法
	 */
	public String setProperty(String key, String value) {
		return (String) properties.setProperty(key, value);
	}

	/**
	 * 请参见Properties中的相同方法
	 */
	public void clear() {
		properties.clear();
	}

	/**
	 * 请参见Properties中的相同方法
	 */
	public Boolean contains(String value) {
		return properties.contains(value);
	}

	/**
	 * 请参见Properties中的相同方法
	 */
	public Boolean containsKey(String key) {
		return properties.containsKey(key);
	}

	/**
	 * 请参见Properties中的相同方法
	 */
	public Boolean containsValue(String value) {
		return properties.containsValue(value);
	}

	/**
	 * 请参见Properties中的相同方法
	 */
	public Boolean isEmpty() {
		return properties.isEmpty();
	}

	/**
	 * 请参见Properties中的相同方法
	 */
	public Integer size() {
		return properties.size();
	}

	/**
	 * 请参见Properties中的相同方法
	 */
	public String remove(String key) {
		return (String) properties.remove(key);
	}

	/**
	 * 请参见Properties中的相同方法
	 */
	public String retrieveContents() {
		return properties.toString();
	}

	/**
	 * 获得这个对象中被包装的Properties对象
	 * @return 被包装的Properties对象
	 */
	public Properties getProperties() {
		return properties;
	}

	/**
	 * 用于存储被包装Properties对象的抽象方法.
	 * 用户需要自行实现以便对Properties进行持久化。
	 */
	public abstract Boolean save();
}
