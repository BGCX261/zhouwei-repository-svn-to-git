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
 * 自定义的注释类,用来读取Scpoe范围内的对象
 *
 * @author todd
 * @version 1.2 , 2008/5/9
 * @since JDK1.5
 */

@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Documented
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Read {

	/**
	 * add by WangYonghui 传进来的参数是否进行trim操作,默认是ture,即进行trim操作.
	 * @return
	 */
	public boolean trimed() default true;

	/**
	 * 将从哪些范围内读取对象，一般是从request里面 也支持session，application范围
	 * @return scope
	 */
	public Scope scope() default Scope.FORM;

	/**
	 * 将使用什么样的键值读取对象，对于field，就是他名字 对于method的parameter，需要指明
	 * @return the key itself
	 */
	public String key() default "";

	/**
	 * 说明这个对象从那种ioc容器获得 Spring的是：Spring：beanId HiveMind的是：HiveMind：beanId
	 * （不传bean的接口） Pico的占卜支持
	 *
	 * @return 提供设置缺省值
	 */
	public String object() default "";

	/**
	 * 提供设置缺省值
	 * @return 提供设置缺省值
	 */
	public String defaultValue() default "WEBX_CORE_ANNOTATION_READ_DEFAULTVALUE_DEFAULT";

	/**
	 * 为所标定的参数指定所使用的Converter
	 * @return 提供所使用的Converter
	 */
	public String converter() default "WEBX_CORE_ANNOTATION_READ_CONVERTER_DEFAULT";
}
