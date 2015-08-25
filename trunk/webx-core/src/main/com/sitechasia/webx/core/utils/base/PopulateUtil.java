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
package com.sitechasia.webx.core.utils.base;

import java.util.Map;

import com.sitechasia.webx.core.utils.populator.PopulatorFactory;

/**
 * 注值器工具类
 *
 * @author Administrator
 * @author todd
 * @version 1.2 , 2008/5/7
 * @since JDK1.5
 */

public final class PopulateUtil {

	private PopulateUtil() {}

	/**
	 * 将source与target中的属性对拷
	 *
	 * @param source 源对象
	 * @param target 目标对象
	 * @return 注值是否成功
	 */
	public static boolean populate(Object source, Object target) {
		return populate(source, target, null, null);
	}

	/**
	 * 将source与target中的属性对拷，可以指定映射关系。
	 * @param source 源对象
	 * @param target 目标对象
	 * @param propertiesMapping 映射关系
	 * @return 注值是否成功
	 */
	public static boolean populate(Object source, Object target,
			Map<String, String> propertiesMapping) {
		return populate(source, target, propertiesMapping, null);
	}

	/**
	 * 将source与target中的属性对拷，可以指定忽略列表。
	 * @param source 源对象
	 * @param target 目标对象
	 * @param ignoreProperties 忽略列表
	 * @return 注值是否成功
	 */
	public static boolean populate(Object source, Object target,
			String[] ignoreProperties) {
		return populate(source, target, null, ignoreProperties);
	}

	/**
	 * 将source与target中的属性对拷，可以指定映射关系和忽略列表。
	 * @param source 源对象
	 * @param target 目标对象
	 * @param propertiesMapping 映射关系
	 * @param ignoreProperties 忽略列表
	 * @return  注值是否成功
	 */
	public static boolean populate(Object source, Object target,
			Map<String, String> propertiesMapping, String[] ignoreProperties) {
		return PopulatorFactory.getDefaultPopulator().populate(source, target, propertiesMapping, ignoreProperties);
	}
}
