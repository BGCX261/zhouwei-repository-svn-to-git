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
package com.sitechasia.webx.core.utils.populator;

/**
 * 类型转换器所需要实现的总接口。
 * TypeConverter中有唯一的一个方法。
 * 实现类请特别注意方法所需要返回的值。
 *
 * @author Zal
 * @author todd
 * @version 1.2 , 2008/5/7
 * @since JDK1.5
 */
public interface ITypeConverter {

	/**
	 * @param value 需要被转换的值
	 * @param toType 需要被转换成的类型
	 * @param params 转值时需要提供的可选参数
	 * @return 经转换过的类型，如果实现类没有能力进行所指定的类型转换，应返回null
	 */
	public Object convertValue(Object value, Class toType, Object... params);
}
