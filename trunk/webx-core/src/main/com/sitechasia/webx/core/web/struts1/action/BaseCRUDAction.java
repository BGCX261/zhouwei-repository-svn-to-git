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
package com.sitechasia.webx.core.web.struts1.action;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import com.sitechasia.webx.core.annotation.Out;
import com.sitechasia.webx.core.annotation.Read;
import com.sitechasia.webx.core.model.IValueObject;
import com.sitechasia.webx.core.service.IValueObjectBaseService;
import com.sitechasia.webx.core.utils.base.BeanUtils;
import com.sitechasia.webx.core.utils.base.GenericsUtils;

/**
 * 负责管理单个对象CRUD操作的Struts Action基类.
 *
 * <p/> 子类以以下方式声明,并实现将拥有默认的CRUD函数
 *
 * 此类仅演示一种封装的方式，大家可按自己的项目习惯进行重新封装。 比如主键类型可能不是Integer等. <p/> 目前封装了： <p/>
 * 1.findAll、doEdit、doSiew、doSave、doDeleteById 五种action的流程封装；<br/>
 *
 * @author Zal
 * @author todd
 * @version 1.2 , 2008/5/7
 * @since JDK1.5
 * @param <V>
 */
public abstract class BaseCRUDAction<V extends IValueObject, Id extends Serializable> extends BaseStrutsAction {
	/**
	 * Action所管理的Entity类型.
	 */
	private Class<V> entityClass;
	private IValueObjectBaseService<V> service;

	/**
	 * 设置一个用于执行CRUD的Service
	 * @param service
	 */
	public void setService(IValueObjectBaseService<V> service) {
		if (service != null) {
			this.service = service;
		}
	}

	/**
	 * 获取一个执行CRUD的Service，如果以前没有设置过Service，
	 * 该方法会在本对象的属性中自动搜索合适的Service进行设置
	 * @return 设置好的Service
	 */
	protected final IValueObjectBaseService<V> getService() {

		//如果service已经被赋值,则返回
		if(service != null) {
			return this.service;
		}

		//得到当前实例的第一个泛型
		Class targetC = GenericsUtils.getGenericClass(this.getClass());
		if (targetC == Object.class) {
			return this.service;
		}

		//获得当前类的各个属性描述
		PropertyDescriptor[] thisDescriptors;
		try {
			thisDescriptors = Introspector.getBeanInfo(this.getClass()).getPropertyDescriptors();
		} catch (IntrospectionException e) {
			logger.info("Can not get bean info", e);
			return this.service;
		}

		//循环当前实例的每个成员变量,并找到这个成员变量的接口,如果这个接口的第一个泛型与targetC相等,则对service赋值
		for(PropertyDescriptor thisDescriptor : thisDescriptors){
			String propertyName = thisDescriptor.getName();//得到属性名称

			//得到与这个属性名称对应对象实现的接口,以及这个接口对应的第一个泛型
			Object obj = null;
			try{
				obj = BeanUtils.getPrivateProperty(this,propertyName);
			}catch(Exception e)	{ continue; }//如果属性不存在,则继续循环剩余的成员变量

			//对Service进行付值
			if (useObject(obj, targetC)) {
				this.service = (IValueObjectBaseService<V>)obj;
				break;
			}
		}
		return this.service;
	}

	/**
	 * 判断是否使用所传入的对象设置Service
	 * @param obj 属性对象
	 * @param targetC 所使用的范型信息
	 * @return 是否使用该对象设置Service
	 */
	private boolean useObject(Object obj, Class targetC) {

		//只对IValueObjectBaseService类型的对象进行判断
		if (obj instanceof IValueObjectBaseService) {
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

	/**
	 * 取得entityClass.
	 *
	 * JDK1.4不支持泛型的子类可以抛开Class<V> entityClass,重载此函数达到相同效果。
	 *
	 * @return 实体对象的类型
	 */
	protected Class<V> getEntityClass() {
		return entityClass;
	}

	/**
	 * 构造函数.
	 *
	 * 通过对V的反射获得entity class
	 */
	public BaseCRUDAction() {
		entityClass = GenericsUtils.getGenericClass(getClass());
	}

	/**
	 * 列出所有对象.
	 *
	 * @return 列出所有对象
	 */
	@Out(key = "all")
	public List<V> findAll() {
		return getService().findAll();
	}

	/**
	 * 显示Form.
	 *
	 * @param id
	 *
	 * @return 显示Form
	 */
	@Out(key = "currentEntity")
	public V doEdit(@Read(key = "id")
	@Out(key = "id")
	Id id) {
		return getService().findById(id);
	}

	/**
	 * 查看业务对象（不能修改）.
	 *
	 * @param id
	 *
	 * @return 查看业务对象
	 */
	@Out(key = "currentEntity")
	public V doView(@Read(key = "id")
	@Out(key = "id")
	Id id) {
		return getService().findById(id);
	}

	/**
	 * 保存对象.
	 *
	 * @param o
	 *
	 */
	public void doSave(@Read
	@Out(key = "currentEntity")
	V o) {
		getService().doSave(o);
	}

	/**
	 * 删除单个对象.
	 *
	 * @param id
	 *
	 */
	public void doDeleteById(@Read(key = "id")
	@Out(key = "id")
	Id id) {
		getService().doDeleteById(id);
	}

	/**
	 * 删除多个对象.
	 *
	 * @param ids
	 *
	 */
	public void doDeleteByIds(@Read(key = "id")
	@Out(key = "ids")
	Id[] ids) {
		getService().doDeleteByIds(ids);
	}
}
