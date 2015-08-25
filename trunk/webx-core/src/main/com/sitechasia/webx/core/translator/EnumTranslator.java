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

import java.util.List;

/**
 * 枚举转换器接口
 *
 * @author Steven
 * @author todd
 * @version 1.2 , 2008/5/6
 * @since JDK1.5
 */
public interface EnumTranslator extends Translator {

	/**
	 * 得到枚举值的数量
	 * @return 枚举值的数量
	 */
	int size();

	/**
	 * 得到枚举转换器的所有项
	 * @return　枚举项的List
	 */
	List<EnumTranslatorEntry> getItems();

}
