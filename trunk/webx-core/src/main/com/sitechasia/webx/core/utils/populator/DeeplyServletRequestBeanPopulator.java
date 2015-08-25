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

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;

/**
 * ServletRequest 到Bean的深注值实现.
 * request的parameter name 可以为a.b.c这样的形式,表示这个值是
 * target.a.b.c的值.也可在propertiesMapping的value中指定上述格式的属性名.
 *
 * @author Steven
 * @author todd
 * @version 1.2 , 2008/5/7
 * @since JDK1.5
 */
public class DeeplyServletRequestBeanPopulator extends BasePopulator {

	/* (non-Javadoc)
	 * @see com.sitechasia.webx.core.utils.populator.BaseSimplePopulator#doPopulate(java.lang.Object, java.lang.Object, java.util.Map, java.lang.String[])
	 */
	@Override
	protected boolean doPopulate(Object source, Object target,
			Map<String, String> propertiesMapping, String[] ignoreProperties, Object... params) {
		/**
		 * 首先过滤掉一些常见的不支持的类型
		 */
		if (target instanceof Collection || target instanceof ServletRequest
				|| target instanceof ResultSet
				|| !(source instanceof ServletRequest)) {
			return false;
		}

		Map requstMap = ((ServletRequest) source).getParameterMap();

		/**
		 * 如果目标类型就是一个Map，则直接返回所转换的Map
		 */
		if (target instanceof Map) {
			((Map) target).putAll(requstMap);
			return true;
		}

		String[] names = (String[]) requstMap.keySet().toArray(new String[0]);
		for (int i = 0; i < names.length; i++) {
			String temName = names[i];

			/**
			 * 过滤掉ignoreProperties中所指定的不需要注值的属性
			 */
			if (!doProcess(temName, ignoreProperties)) {
				continue;
			}

			String proName = names[i];

			//因为不能按目标属性名检索，只能按request参数名检索,所以需要颠倒Map
			Map<String,String> pm = this.reversalMap(propertiesMapping);

			//如果指定了对应关系,取对应关系中的名字为属性名
			if (pm != null && pm.containsKey(names[i])) {
				proName = pm.get(names[i]);
			}

			set(proName, requstMap.get(names[i]), target);

		}

		return false;
	}

	private void set(String name, Object value, Object target) {
		if (value == null) {
			return;
		}
		try {
			if (name.indexOf(".") != -1) {
				String propertyName = name.substring(0, name.indexOf("."));
				String tempName = name.substring(name.indexOf(".") + 1);
				Object o = null;

				o = getPropertyValue(target, propertyName, true);
				if (o == null) {
					info("get type[" + target.getClass().getName()
							+ "] instance value of property[" + propertyName
							+ "] is null and create failed.");
					return;
				}
				set(tempName, value, o);
			} else {

				PropertyDescriptor pd = getPropertyDescriptor(
						target.getClass(), name);
				// 检查PropertyDescriptor
				if (pd == null) {
					info("no PropertyDescriptor in["
							+ target.getClass().getName() + "] for name["
							+ name + "]");
					return;
				}

				Method writer = pd.getWriteMethod();
				// 检查write method
				if (writer == null) {
					this.info("no write method in["
							+ target.getClass().getName() + "] for property["
							+ name + "]");
					return;
				}

				// 转换及注值
				Class targetType = pd.getPropertyType();

				String[] temValue = (String[]) value;

				Object temTargetValue = null;

				if (temValue.length == 0) {
					temTargetValue = null;
				}
				// 类型不是数组，取下标0的
				else if (temValue.length >= 1 && !targetType.isArray()) {
					if (temValue[0] != null && !temValue[0].trim().equals("")) {
						temTargetValue = temValue[0];
					}
				} else {
					temTargetValue = temValue;
				}

				if (temTargetValue != null) {
					Object convertedValue = getConverter().convertValue(
							temTargetValue, targetType);
					writer.invoke(target, new Object[] { convertedValue });
				}
			}
		} catch (IllegalArgumentException e) {
			logger.info("populate value failed for IllegalArgumentException.",
					e);
			return ;
		} catch (IllegalAccessException e) {
			logger.info("populate value failed for IllegalAccessException.", e);
			return ;
		} catch (InvocationTargetException e) {
			logger.info("populate value failed for InvocationTargetException.",
					e);
			return ;
		} catch (InstantiationException e) {
			logger.info("populate value failed for InstantiationException.", e);
			return ;
		} catch (Exception e){
			logger.info("populate value failed for Exception.", e);
			return ;
		}
	}

	/**
	 * 根据对象和属性名取属性值,如果属性值为null,且createFlag为true,就创建这个属性值并
	 * 赋值给对象(指执行set)。返回值为属性值。
	 * @param obj
	 * @param propertyName
	 * @param createFlag
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws InstantiationException
	 */
	private Object getPropertyValue(Object obj, String propertyName,
			boolean createFlag) throws IllegalArgumentException,
			IllegalAccessException, InvocationTargetException,
			InstantiationException {

		PropertyDescriptor pd = getPropertyDescriptor(obj.getClass(),
				propertyName);
		if (pd == null) {
			throw new IllegalArgumentException("no PropertyDescriptor in["
					+ obj.getClass().getName() + "] for name[" + propertyName
					+ "]");
		}
		Method reader = pd.getReadMethod();
		if (reader == null) {
			throw new IllegalAccessException("no read method in["
					+ obj.getClass().getName() + "] for property["
					+ propertyName + "]");
		}

		Object value = null;

		value = reader.invoke(obj, null);

		if (value == null && createFlag) {
			debug("property["+ propertyName + "] value is null, and will be create and set..." );
			value = pd.getPropertyType().newInstance();
			Method setter = pd.getWriteMethod();

			if (setter == null) {
				throw new IllegalAccessException("no write method in["
						+ obj.getClass().getName() + "] for property["
						+ propertyName + "]");
			}

			setter.invoke(obj, new Object[] { value });
		}

		return value;
	}

	private PropertyDescriptor getPropertyDescriptor(Class clazz, String propertyName){
		PropertyDescriptor[] targetDescriptors = null;
		try {
			targetDescriptors = Introspector.getBeanInfo(clazz)
						.getPropertyDescriptors();
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}
		for(int i=0;i<targetDescriptors.length;i++){
			if(targetDescriptors[i].getName().equals(propertyName)){
				return targetDescriptors[i];
			}
		}
		return null;
	}

	private void info(Object message){
		if(logger.isInfoEnabled()){
			logger.info(message);
		}
	}

	private void debug(Object message){
		if(logger.isDebugEnabled()){
			logger.debug(message);
		}
	}

	/**
	 * 颠倒Map的key和value.如果source的value为null,将被忽略
	 * @param source
	 * @return
	 */
	private Map reversalMap(Map source) {

		if(source==null || source.isEmpty()){
			return null;
		}

		Map target = new HashMap();
		Object[] keys = source.keySet().toArray();
		for (int i = 0; i < keys.length; i++) {
			Object value = source.get(keys[i]);
			if (value != null) {
				target.put(value, keys[i]);
			}
		}

		return target;
	}



}
