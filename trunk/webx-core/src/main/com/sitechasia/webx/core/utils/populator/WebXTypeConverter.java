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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 实现了ITypeConverter接口的类型转换器， 本实现自己并不对类型进行任何转换，而是调用其它的向它注册了的类型转换器进行转换。
 * 本实现可以作为总类型转换器来控制调用其它的类型转换器。
 *
 * @author Zal
 * @author todd
 * @version 1.2 , 2008/5/7
 * @since JDK1.5
 */
public class WebXTypeConverter extends BaseSimpleTypeConverter {

	/**
	 * 用于存储其它类型转换器的List
	 */
	private List<ITypeConverter> converters = new ArrayList<ITypeConverter>();

	/**
	 * 用于记录类型转换时所使用的转换器
	 */
	private Map<String, ITypeConverter> recorder = new HashMap<String, ITypeConverter>();

	/**
	 * 调用其它的已经注册的类型转换器进行类型转换。
	 */
	protected Object doConvertValue(Object value, Class toType, Object... params) {

		if (converters == null) {
			return null;
		}

		/**
		 * 如果都是数组类型，则构造数组
		 */
		Object result = null;
		if (value != null && value.getClass().isArray() && toType.isArray()) {
			Class componentType = toType.getComponentType();

			result = Array.newInstance(componentType, Array
					.getLength(value));

			for (int i = 0; i < Array.getLength(value); i++) {
				Array.set(result, i, convertValue(Array.get(value, i),
						componentType, params));
			}
			return result;
		}

		String valueType = value == null ? "null" : value.getClass().getName();
		String recordKey = valueType + " --> "	+ toType.getName();
		if (recorder.containsKey(recordKey)) {
			return recorder.get(recordKey).convertValue(value, toType, params);
		}

		/**
		 * 循环调用在这个转换器重所注册的其它转换器进行类型转换
		 */
		for (ITypeConverter tempConverter : converters) {
			try {
				synchronized (recorder) {
					if (recorder.containsKey(recordKey)) {
						return recorder.get(recordKey).convertValue(value, toType, params);
					}

					result = tempConverter.convertValue(value, toType, params);

					if (result != null) {
						recorder.put(recordKey, tempConverter);
						return result;
					}
				}
			} catch (RuntimeException re) {
				logger.debug("Can not conver Value: " + value + " to Class: "
						+ toType + " in Converter: " + tempConverter, re);
			}
		}
		return null;
	}

	/**
	 * 获得用于存储类型转换器的List
	 *
	 * @return 用于存储类型转换器的List
	 */
	public List<ITypeConverter> getConverters() {
		return converters;
	}

	/**
	 * 设置一个用于存储类型转换器的list
	 *
	 * @param converters 用于存储类型转换器的list
	 */
	public void setConverters(List<ITypeConverter> converters) {
		this.converters = converters;
	}
}
