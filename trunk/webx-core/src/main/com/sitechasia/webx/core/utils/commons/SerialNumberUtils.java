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
package com.sitechasia.webx.core.utils.commons;

/**
 *
 * 序列号工具类
 *
 * @author zane
 * @author todd
 * @version 1.2 , 2008/5/7
 * @since JDK1.5
 *
 */
public final class SerialNumberUtils {
	private SerialNumberUtils() {
	}

	/**
	 * 生成格式化序列号，位数不足时，以字符0作为前缀添加。
	 *
	 * @param number
	 *            原序列号
	 * @param scale
	 *            位数
	 * @return 按位数格式化的序号
	 * @since 1.0
	 *
	 * <pre>
	 *     buildSerial(89,5), 输出00089。
	 * </pre>
	 */
	public static String buildSerial(int number, int scale) {
		return buidSerial(number, scale, '0');
	}

	/**
	 * 生成格式化序列号，位数不足时，以字符prefix作为前缀添加。
	 *
	 * @param number
	 *            原序列号
	 * @param scale
	 *            位数
	 * @param prefix
	 *            填充前缀字符
	 * @return 按位数格式化的序号
	 * @since 1.0
	 *
	 * <pre>
	 *     buidSerial(89,5,'*'), 输出***89。
	 * </pre>
	 */
	public static String buidSerial(int number, int scale, char prefix) {
		// 格式化的位数小于等于0则抛出参数异常
		if (scale <= 0)
			throw new IllegalArgumentException("scale：" + scale);
		// 在序列前空出的位上添加prefix
		StringBuffer buf = new StringBuffer(scale);
		for (int i = 0; i < scale; i++)
			buf.append(prefix);
		// 添加序列号值
		buf.append(number);
		// 取后scale位作为序列号输出
		return buf.substring(buf.length() - scale).toString();
	}
}
