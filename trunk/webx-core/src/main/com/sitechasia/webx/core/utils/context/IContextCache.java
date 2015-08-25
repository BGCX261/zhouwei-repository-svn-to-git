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
 * BaseContext中所使用的缓存
 *
 * @author Zal
 * @author todd
 * @version 1.2 , 2008/5/7
 * @since JDK1.5
 */
public interface IContextCache {

	/**
	 * 向缓存中存储一条书据
	 * @param key 所存储数据所使用的键
	 * @param value 所存数据的值
	 */
	public void set(String key, Object value);

	/**
	 * 从缓存中获得一条数据
	 * @param key 所要获得数据的键
	 * @return 获得的数据
	 */
	public Object get(String key);

	/**
	 * 从缓存中删除一条数据
	 * @param key 所要删除数据的键
	 * @return 所删除的数据
	 */
	public Object remove(String key);

	/**
	 * 清空缓存
	 */
	public void clear();

	/**
	 * 获得缓存内所有的键
	 * @return 所有键的数组
	 */
	public Set getKeys();
}
