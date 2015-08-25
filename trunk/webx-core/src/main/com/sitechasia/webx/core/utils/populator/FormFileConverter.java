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

import java.io.IOException;
import java.io.InputStream;

import org.apache.struts.upload.FormFile;

/**
 * 将FormFile转换成InputStream
 *
 * @author Zal
 * @author todd
 * @version 1.2 , 2008/5/7
 * @since JDK1.5
 */
public class FormFileConverter extends BaseSimpleTypeConverter {

	protected Object doConvertValue(Object value, Class toType,
			Object... params) {
		if (value instanceof FormFile && toType == InputStream.class)
			return doConvert(value, toType);
		return null;
	}

	private Object doConvert(Object value, Class toType) {
		try {
			return ((FormFile) value).getInputStream();
		} catch (IOException e) {
			logger.debug("Can not convert FormFile value: " + value
					+ " to InputStream", e);
		}

		return null;
	}
}
