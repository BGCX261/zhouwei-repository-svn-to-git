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

import java.util.Map;

import org.apache.log4j.Logger;

/**
 * 对象之间注值器的。
 *
 * @author Zal
 * @author todd
 * @version 1.2 , 2008/5/7
 * @since JDK1.5
 */
public abstract class BaseSimplePopulator implements IPopulator {

	/**
	 * 用于记录日志的Logger
	 */
	protected final Logger logger = Logger.getLogger(this.getClass());

	/*
	 * (non-javadoc)
	 * @see IPopulator#populate
	 */
	public boolean populate(Object source, Object target,
			Map<String, String> propertiesMapping, String[] ignoreProperties, Object... params) {

		if (source == null || target == null
				|| source.getClass() == Object.class
				|| target.getClass() == Object.class
				|| PrimitiveType.isPriType(source.getClass())
				|| PrimitiveType.isPriType(target.getClass())
				|| PrimitiveType.isPriArrayType(source.getClass())
				|| PrimitiveType.isPriArrayType(target.getClass())) {
			return false;
		}

		return doPopulate(source, target, propertiesMapping, ignoreProperties);
	}

	/**
	 * 子类所需要实现的抽象方法
	 * 将source对象中的值注入到target对象中。
	 * @param source 注值时的源对象
	 * @param target 注值时的目标对象
	 * @param propertiesMapping 注值时可以指定源对象中属性和目标对象中属性的对应关系，Map中的Key为目标对象属性的名称，String类型；Value为源对象属性的名称，String类型。
	 * @param ignoreProperties 目标对象中需要被忽略的属性名称的String数组。
	 * @return 是否成功的进行了注值，如果一个实现没有能力对指定的对象进行注值，也应返回false
	 */
	protected abstract boolean doPopulate(Object source, Object target,
			Map<String, String> propertiesMapping, String[] ignoreProperties, Object... params);
}
