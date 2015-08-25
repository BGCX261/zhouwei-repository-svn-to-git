/*
 * Copyright (c) 2006- CE, Inc.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * CE Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with CE.
 */
package com.sitechasia.webx.core.service.impl;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.sitechasia.webx.core.dao.IDomainObjectDao;
import com.sitechasia.webx.core.model.IDomainObject;
import com.sitechasia.webx.core.utils.base.BeanUtils;
import com.sitechasia.webx.core.utils.base.GenericsUtils;

/**
 * 服务层操作一个业务对象的基类,实现了对IDomainObjectDao的注入
 *
 * @author todd
 * @version 1.2 , 2008/5/6
 * @since JDK1.5
 * @param <D>
 * 			一个业务对象DO
 */
public abstract class BaseDomainDaoService<D extends IDomainObject> extends BaseService {

	/*
	 * (non-JavaDoc)
	 * @see com.sitechasia.webx.core.dao.IDomainObjectDao<com.sitechasia.webx.core.model.IDomainObject
	 */
	private IDomainObjectDao<D> dao;

	/**
	 * 包可见的构造函数，保证用户不会直接继承于本类
	 */
	BaseDomainDaoService(){}

	/**
	 * 注入dao的实现
	 * @param dao
	 */
	public void setDao(IDomainObjectDao<D> dao) {
		if (dao != null) {
			this.dao = dao;
		}
	}

	/**
	 * @return 返回dao
	 */
	protected final IDomainObjectDao<D> getDao() {

		if(dao != null) {
			return this.dao;//如果dao已经被赋值,则返回
		}

		//得到当前类的第一个泛型
		Class targetC = GenericsUtils.getGenericClass(this.getClass());
		if(targetC == Object.class) {
			return this.dao;
		}

		//获得当前类的各个属性描述
		PropertyDescriptor[] thisDescriptors;
		try {
			thisDescriptors = Introspector.getBeanInfo(this.getClass()).getPropertyDescriptors();
		} catch (IntrospectionException e) {
			logger.info("Can not get bean info", e);
			return this.dao;
		}

		//循环当前实例的每个成员变量,找到与c相等的成员变量,并对dao赋值
		for(PropertyDescriptor thisDescriptor : thisDescriptors){
			String propertyName = thisDescriptor.getName();//得到属性名称

			//得到与这个属性名称对应的对象以及它对应的第一个泛型
			Object o = null;
			try{
				o = BeanUtils.getPrivateProperty(this,propertyName);
			}catch(Exception e)	{ continue; }//如果属性不存在,则继续循环剩余的成员变量


			//对dao进行赋值,得到o实现的接口与targetC进行比对,比对的过程详见方法useObject()
			if (useObject(o, targetC)) {
				dao = (IDomainObjectDao<D>) o;
				break;// dao已经被赋值,则退出for循环
			}
		}

		return this.dao;
	}

	/**
	 * 利用反射对参数化类型和当前类的泛型进行比较
	 *
	 * @param obj
	 * 			实现的接口
	 * @param targetC
	 * 			一个类的泛型
	 * @return 1.true
	 * 			2.false
	 */
	private boolean useObject(Object obj, Class targetC) {
		//只对IValueObjectBaseService类型的对象进行判断
		if (obj instanceof IDomainObjectDao) {
			Class[] clazz=(obj.getClass()).getInterfaces();
			for (Class interClazz : clazz) {
				Type[] genType = interClazz.getGenericInterfaces();
				for (Type interGenType : genType) {
					if (interGenType instanceof ParameterizedType
							&& ((ParameterizedType) interGenType)
									.getActualTypeArguments()[0] == targetC) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
