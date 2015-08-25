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

/**
 * 用于包装一个Properties对象的MBean接口.
 * 通过这个MBean可以远程调整真正Properties对象的属性。
 * 该接口所提供的方法为真实Properties对象方法的一个子集，
 * 可以满足绝大多数的需要。
 *
 * @see java.util.Properties
 * @author CE
 * @version 1.2 , 2008/5/12
 * @since JDK1.5
 */
public interface PropertiesWrapperMBean extends MBeanGeneric {

	/**
	 * 请参见Properties中的相同方法
	 */
	public String getProperty(String key);

	/**
	 * 请参见Properties中的相同方法
	 */
	public String getProperty(String key, String defaultValue);

	/**
	 * 请参见Properties中的相同方法
	 */
	public String setProperty(String key, String value);

	/**
	 * 请参见Properties中的相同方法
	 */
	public void clear();

	/**
	 * 请参见Properties中的相同方法
	 */
	public Boolean contains(String value);

	/**
	 * 请参见Properties中的相同方法
	 */
	public Boolean containsKey(String key);

	/**
	 * 请参见Properties中的相同方法
	 */
	public Boolean containsValue(String value);

	/**
	 * 请参见Properties中的相同方法
	 */
	public Boolean isEmpty();

	/**
	 * 请参见Properties中的相同方法
	 */
	public Integer size();

	/**
	 * 请参见Properties中的相同方法
	 */
	public String remove(String key);

	/**
	 * 请参见Properties中的相同方法
	 */
	public String retrieveContents();

	/**
	 * 用于存储Properties对象的方法。
	 */
	public Boolean save();

}
