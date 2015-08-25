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
package com.sitechasia.webx.core.model;

/**
 * 对VO对象进行验证接口。
 *
 * @author todd
 * @version 1.2 , 2008/5/6
 * @since JDK1.5
 */

public interface IValueObjectValidator {

	/**
	 * 是否对当前展示对象进行验证
	 *
	 * @return 1.true
	 *          2.false
	 */
	public boolean validate();
}
