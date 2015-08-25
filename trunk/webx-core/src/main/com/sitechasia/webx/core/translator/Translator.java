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
package com.sitechasia.webx.core.translator;

/**
 * 转换器接口.
 *
 * @author Steven
 * @author todd
 * @version 1.2 , 2008/5/6
 * @since JDK1.5
 */
public interface Translator {

	/**
	 * @return 获取这个转换器的名字
	 */
	String getName();

	/**
	 * 转换指定对象
	 * @param obj 指定的对象
	 * @return 转换后的对象
	 */
	Object translate(Object obj);

	/**
	 * 转换指定对象为字符串
	 * @param obj 指定的对象
	 * @return 转换后的字符串
	 */
	String translateAsString(Object obj);

}
