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

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * 定义了基本类型的工具类，
 * 可以方便的判断一个Class对象是否属于基本类型或基本类型的数组。
 * 本工具类所包含的基本类型判断包括如下一些内容：
 * <br/>
 * <li>String</li>
 * <li>boolean</li>
 * <li>byte</li>
 * <li>short</li>
 * <li>int</li>
 * <li>long</li>
 * <li>float</li>
 * <li>double</li>
 * <li>char</li>
 * <li>Boolean</li>
 * <li>Byte</li>
 * <li>Short</li>
 * <li>Integer</li>
 * <li>Long</li>
 * <li>Float</li>
 * <li>Double</li>
 * <li>Character</li>
 * <li>BigInteger</li>
 * <li>BigDecimal</li>
 * @author Zal
 * @version 1.2 , 2008/5/7
 * @since JDK1.5
 */
public final class PrimitiveType {

	/**
	 * 私有的构造函数防止用户进行实例化。
	 */
	private PrimitiveType() {}

	/** 基本类型 */
	private static final Class[] PRI_TYPE = { String.class, boolean.class,
			byte.class, short.class, int.class, long.class, float.class,
			double.class, char.class, Boolean.class, Byte.class, Short.class,
			Integer.class, Long.class, Float.class, Double.class,
			Character.class, BigInteger.class, BigDecimal.class };

	/** 基本数组类型 */
	private static final Class[] PRI_ARRAY_TYPE = { String[].class,
			boolean[].class, byte[].class, short[].class, int[].class,
			long[].class, float[].class, double[].class, char[].class,
			Boolean[].class, Byte[].class, Short[].class, Integer[].class,
			Long[].class, Float[].class, Double[].class, Character[].class,
			BigInteger[].class, BigDecimal[].class };

	/**
	 * 基本类型默认值
	 */
	private static final Map<Class, Object> primitiveDefaults = new HashMap<Class, Object>(9);
	static {
        primitiveDefaults.put(boolean.class, false);
        primitiveDefaults.put(byte.class, (byte)0);
        primitiveDefaults.put(short.class, (short)0);
        primitiveDefaults.put(char.class, (char)0);
        primitiveDefaults.put(int.class, 0);
        primitiveDefaults.put(long.class, 0L);
        primitiveDefaults.put(float.class, 0.0f);
        primitiveDefaults.put(double.class, 0.0);
	}

	/**
	 * 判断是否为基本类型
	 * @param clasz 需要进行判断的Class对象
	 * @return 是否为基本类型
	 */
	public static boolean isPriType(Class clasz) {
		for (Class priType : PRI_TYPE) {
			if (clasz == priType)
				return true;
		}
		return false;
	}

	/**
	 * 判断是否为基本类型数组
	 * @param clasz 需要进行判断的Class对象
	 * @return 是否为基本类型数组
	 */
	public static boolean isPriArrayType(Class clasz) {
		for (Class priType : PRI_ARRAY_TYPE) {
			if (clasz == priType)
				return true;
		}
		return false;
	}

	/**
	 * 获得基本类型的默认值
	 * @param type 基本类型的Class
	 * @return 基本类型的默认值
	 */
	public static Object getPriDefaultValue(Class type) {
		return primitiveDefaults.get(type);
	}
}
