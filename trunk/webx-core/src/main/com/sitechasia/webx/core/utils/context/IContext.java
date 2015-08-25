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

import java.util.Set;

/**
 * 各种Context的总接口
 *
 * @author zal
 * @author todd
 * @version 1.2 , 2008/5/7
 * @since JDK1.5
 */
public interface IContext {

	/**
	 * 向Context中存储一个值
	 * @param key 存储时所使用的键
	 * @param value 存储的值
	 */
	public void setAttribute(String key, Object value);

	/**
	 * 从Context中获取一个所存储的值
	 * @param key 用于获得存储值的键
	 * @return 获得的所存储的值
	 */
	public Object getAttribute(String key);

	/**
	 * 从Context中删除一个所存储的值
	 * @param key 需要被删除值的键
	 * @return 所删除的值
	 */
	public Object removeAttribute(String key);

	/**
	 * 清空Context中所存储的所有的值
	 */
	public void clearAttributes();

	/**
	 * 获得Context中所存储的所有的键的数组
	 * @return Context中所存储的所有的键
	 */
	public Set getAttributeNames();
}
