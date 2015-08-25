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
package com.sitechasia.webx.core.utils.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 泛型操作的工具类,通过反射获得Class声明的范型Class.
 *
 * @author Administrator
 * @author todd
 * @version 1.2 , 2008/5/7
 * @since JDK1.5
 */
public final class GenericsUtils {

	private GenericsUtils(){}

	/**
	 * 返回表示此 Class 所申明的第一个泛型
	 *
	 * @param clazz
	 *            类
	 * @return 第一个泛型，如果不是泛型 返回Object.Class
	 *
	 * <pre>
	 *   public class TestGenericsBean&lt;T，T2&gt; {...}//带泛型定义的父类
	 *   public class TestActualGenericsBean extends TestGenericsBean&lt;TestBean,TestBean2&gt; {...}//定义了父类范型的子类
	 *   GenericsUtils.getGenericClass(TestActualGenericsBean.class);//将返回TestBean.Class
	 * </pre>
	 */
	public static Class getGenericClass(Class clazz) {
		return getGenericClass(clazz, 0);
	}

	/**
	 * 按序号返回表示此 Class 所申明的泛型
	 *
	 * @param clazz
	 *            类
	 * @param index
	 *            序号，从0开始
	 * @return 指定的泛型，如果不是泛型 返回Object.Class
	 * @throws IndexOutOfBoundsException
	 *
	 * <pre>
	 *   public class TestGenericsBean&lt;T，T2&gt; {...}//带泛型定义的父类
	 *   public class TestActualGenericsBean extends TestGenericsBean&lt;TestBean,TestBean2&gt; {...}//定义了父类范型的子类
	 *   GenericsUtils.getGenericClass(TestActualGenericsBean.class,0);//将返回TestBean.Class
	 *   GenericsUtils.getGenericClass(TestActualGenericsBean.class,1);//将返回TestBean2.Class
	 * </pre>
	 */
	public static Class getGenericClass(Class clazz, int index) throws IndexOutOfBoundsException {

		Type genType = clazz.getGenericSuperclass();
		while(!(genType instanceof ParameterizedType)) {
			if (clazz == Object.class) {
				return Object.class;
			}
			clazz = clazz.getSuperclass();
			genType = clazz.getGenericSuperclass();
		}

		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		if (index >= params.length || index < 0) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size of Parameterized Type: " + params.length);
		}
		return (Class) params[index];
	}
}
