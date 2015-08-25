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
package com.sitechasia.webx.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义的注释类,用来输出对象到Scpoe范围内
 *
 * @author todd
 * @version 1.2 , 2008/5/9
 * @since JDK1.5
 */

@Target({ ElementType.FIELD, ElementType.PARAMETER ,ElementType.METHOD})
@Documented
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Out {

	/**
	 * 将要把结果输出到哪个范围，有4个，缺省的是Request
	 *
	 * @return scope
	 */
	public Scope scope() default Scope.REQUEST;

	/**
	 * 如果从输出的值中得不到输出的名字，需要这里给出
	 * 一个，Field不需要，方法返回值和方法参数都需要
	 *
	 * @return 缺省的是方法的名字
	 */
	public String key() default "";
}