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

import java.sql.Blob;
import java.sql.Clob;
import java.sql.SQLException;

/**
 * 对Clob和Blob进行转换
 * Clob转换成String
 * Blob转换成byte数组或Byte数组
 *
 * @author Zal
 * @author todd
 * @version 1.2 , 2008/5/7
 * @since JDK1.5
 */
public class LobTypeConverter extends BaseSimpleTypeConverter{
	protected Object doConvertValue(Object value, Class toType, Object... params) {

		if ((value instanceof Clob && toType == String.class)
				|| (value instanceof Blob && (toType == byte[].class || toType == Byte[].class))) {
			return doConvert(value, toType);
		}

		return null;
	}

	private Object doConvert(Object value, Class toType) {

		if (value instanceof Clob) {
			Clob lob = (Clob)value;
			try {
				return lob.getSubString(1, (int)lob.length());
			} catch (SQLException e) {
				logger.debug("Can not convert Clob value: " + value
						+ " to String array", e);
			}
		} else {
			Blob lob = (Blob) value;
			byte[] lobValuePri = null;
			try {
				lobValuePri = lob.getBytes(1, (int) lob.length());

				if (toType == byte[].class) {
					return lobValuePri;
				} else {
					Byte[] lobValueObj = new Byte[lobValuePri.length];

					for (int i = 0; i < lobValuePri.length; i++) {
						lobValueObj[i] = lobValuePri[i];
					}
					return lobValueObj;
				}
			} catch (SQLException e) {
				logger.debug("Can not convert Blob value: " + value
						+ " to byte array", e);
			}
		}

		return null;
	}
}
