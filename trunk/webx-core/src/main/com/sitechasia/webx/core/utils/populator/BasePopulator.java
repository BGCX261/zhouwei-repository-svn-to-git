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
 * 为方便注值器的实现而提供的一个通用基类
 * @author Zal
 * @author todd
 * @version 1.2 , 2008/5/7
 * @since JDK1.5
 */
public abstract class BasePopulator extends BaseSimplePopulator {

	/**
	 * 用于保存一个类型转换器
	 */
	private ITypeConverter converter;

	/**
	 * 获得类型转换器
	 * @return 类型转换器
	 */
	public ITypeConverter getConverter() {
		return converter;
	}

	/**
	 * 设置类型转换器
	 * @param converter 类型转换器
	 */
	public void setConverter(ITypeConverter converter) {
		this.converter = converter;
	}

	/**
	 * 判断一个property是否在ignoreProperties中
	 * @param targetName 目标的名称
	 * @param ignoreProperties 忽略列表
	 * @return 是否需要继续处理
	 */
	protected boolean doProcess(String targetName, String[] ignoreProperties) {
		if (ignoreProperties != null) {
			for (String ignoreProperty : ignoreProperties) {
				if (ignoreProperty.equals(targetName)) {
					return false;
				}
			}
		}
		return true;
	}
}
