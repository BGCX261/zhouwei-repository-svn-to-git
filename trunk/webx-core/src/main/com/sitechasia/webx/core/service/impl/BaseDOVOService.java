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
package com.sitechasia.webx.core.service.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.sitechasia.webx.core.model.IDomainObject;
import com.sitechasia.webx.core.model.IViewObject;
import com.sitechasia.webx.core.service.IValueObjectBaseService;
import com.sitechasia.webx.core.utils.populator.PopulatorFactory;

/**
 * 使用泛型的服务层基类
 * 子类只要在类定义时指定所管理Domain及View对象的Class,会自动实现View对象到Domain对象的转换, 即拥有对Domain对象的CRUD操作.以及批量删除添加及修改
 *
 * @author todd
 * @version 1.2 , 2008/5/6
 * @since JDK1.5
 * @param <D>
 * 			一个业务对象DO
 * @param <V>
 * 			一个业务对象VO
 */
public abstract class BaseDOVOService<D extends IDomainObject, V extends IViewObject> extends BaseDomainDaoService<D> implements IValueObjectBaseService<V> {

	/*
	 * （非 Javadoc）
	 *
	 * @see com.sitechasia.webx.core.service.IValueObjectBaseService#findBy(java.lang.String,
	 *      java.lang.Object)
	 */
	public List<V> findBy(String name, Object value) {
		List<D> doList = getDao().findBy(name, value);
		return getVOList(doList);
	}

	/*
	 * （非 Javadoc）
	 *
	 * @see com.sitechasia.webx.core.service.IValueObjectBaseService#findByLike(java.lang.String,
	 *      java.lang.String)
	 */
	public List<V> findByLike(String name, String value) {
		return getVOList(getDao().findByLike(name, value));
	}

	/*
	 * （非 Javadoc）
	 *
	 * @see com.sitechasia.webx.core.service.IValueObjectBaseService#findUniqueBy(java.lang.String,
	 *      java.lang.Object)
	 */
	public V findUniqueBy(String name, Object value) {
		return getVO(getDao().findUniqueBy(name, value));
	}

	/*
	 * （非 Javadoc）
	 *
	 * @see com.sitechasia.webx.core.service.IValueObjectBaseService#findById(java.io.Serializable)
	 */
	public V findById(Serializable id) {
		return getVO(getDao().findById(id));
	}

	/*
	 * （非 Javadoc）
	 *
	 * @see com.sitechasia.webx.core.service.IValueObjectBaseService#findAll()
	 */
	public List<V> findAll() {
		return getVOList(getDao().findAll());
	}

	/*
	 * （非 Javadoc）
	 *
	 * @see com.sitechasia.webx.core.service.IValueObjectBaseService#isNotUnique(java.lang.Object,
	 *      java.lang.String)
	 */
	public boolean isNotUnique(V entity, String names) {
		return getDao().isNotUnique(getDO(entity), names);
	}

	/*
	 * （非 Javadoc）
	 *
	 * @see com.sitechasia.webx.core.service.IValueObjectBaseService#doDelete(java.lang.Object)
	 */
	public void doDelete(V o) {
		getDao().doDelete(getDO(o));
	}

	/*
	 * （非 Javadoc）
	 *
	 * @see com.sitechasia.webx.core.service.IValueObjectBaseService#doDeleteById(java.io.Serializable)
	 */
	public void doDeleteById(Serializable id) {
		getDao().doDeleteById(id);
	}

	/**
	 * 删除多个对象
	 * @param ids
	 */
	public void doDeleteByIds(Serializable[] ids) {
		getDao().doDeleteByIds(ids);
	}

	/*
	 * （非 Javadoc）
	 *
	 * @see com.sitechasia.webx.core.service.IValueObjectBaseService#doSave(java.lang.Object)
	 */
	public void doSave(V o) {
		getDao().doSave(getDO(o));
	}

	/*
	 * （非 Javadoc）
	 *
	 * @see com.sitechasia.webx.core.service.IValueObjectBaseService#doSaveAll(java.util.Collection)
	 */
	public void doSaveAll(Collection<V> list) {
		List<V> voList = new ArrayList<V>();
		voList.addAll(list);
		getDao().doSaveAll(getDOList(voList));
	}

	/**
	 * vo-->do
	 *
	 * @param viewObject
	 * @return 返回domainObject
	 */
	protected D getDO(V viewObject) {
		return getDO(viewObject, null, null);
	}

	/**
	 * vo-->do
	 * @param viewObject
	 * @param propertiesMapping bean属性之间的对应关系
	 * @return 返回domainObject
	 */
	protected D getDO(V viewObject, Map<String, String> propertiesMapping) {
		return getDO(viewObject, propertiesMapping, null);
	}

	/**
	 * vo-->do
	 * @param viewObject
	 * @param ignoreProperties 目标bean需要忽略的属性
	 * @return 返回domainObject
	 */
	protected D getDO(V viewObject, String[] ignoreProperties) {
		return getDO(viewObject, null, ignoreProperties);
	}

	/**
	 * vo-->do
	 * @param viewObject
	 * @param propertiesMapping bean属性之间的对应关系[key-目标属性名,value-源属性名]
	 * @param ignoreProperties 目标bean需要忽略的属性
	 * @return 返回domainObject
	 */
	protected D getDO(V viewObject, Map<String, String> propertiesMapping, String[] ignoreProperties) {
		if (viewObject == null) {
			return null;
		}
		Class<D> doClass = (Class<D>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		D domainObject = null;
		try {
			domainObject = doClass.newInstance();
		} catch (Exception e) {
			logger.warn("Populate failed from viewObject to domainObject == ", e);
			// throw new RuntimeException(e);
		}

		PopulatorFactory.getDefaultPopulator().populate(viewObject, domainObject, propertiesMapping, ignoreProperties);
		return domainObject;
	}

	/**
	 * voList-->doList
	 * @param voList
	 * @return 返回doList
	 */
	protected List<D> getDOList(List<V> voList) {
		return getDOList(voList, null, null);
	}

	/**
	 * voList-->doList
	 * @param voList
	 * @param ignoreProperties 目标bean需要忽略的属性
	 * @return 返回doList
	 */
	protected List<D> getDOList(List<V> voList, String[] ignoreProperties) {
		return getDOList(voList, null, ignoreProperties);
	}

	/**
	 * voList-->doList
	 * @param voList
	 * @param propertiesMapping bean属性之间的对应关系
	 * @return 返回doList
	 */
	protected List<D> getDOList(List<V> voList, Map<String, String> propertiesMapping) {
		return getDOList(voList, propertiesMapping, null);
	}

	/**
	 *
	 * @param voList
	 * @param propertiesMapping bean属性之间的对应关系
	 * @param ignoreProperties 目标bean需要忽略的属性
	 * @return 返回doList
	 */
	protected List<D> getDOList(List<V> voList, Map<String, String> propertiesMapping, String[] ignoreProperties) {
		List<D> doList = null;
		if (voList != null) {
			doList = new ArrayList<D>();
			for (V vo : voList) {
				doList.add(getDO(vo, propertiesMapping, ignoreProperties));
			}
		}
		return doList;
	}

	/**
	 * do-->vo
	 *
	 * @param domainObject
	 * @return 返回vo
	 */
	protected V getVO(D domainObject) {
		return getVO(domainObject, null, null);
	}

	/**
	 * do-->vo
	 * @param domainObject
	 * @param ignoreProperties 目标bean需要忽略的属性
	 * @return 返回vo
	 */
	protected V getVO(D domainObject, String[] ignoreProperties) {
		return getVO(domainObject, null, ignoreProperties);
	}

	/**
	 * do-->vo
	 * @param domainObject
	 * @param propertiesMapping bean属性之间的对应关系
	 * @return 返回vo
	 */
	protected V getVO(D domainObject, Map<String, String> propertiesMapping) {
		return getVO(domainObject, propertiesMapping, null);
	}

	/**
	 * do-->vo
	 * @param domainObject
	 * @param propertiesMapping bean属性之间的对应关系
	 * @param ignoreProperties 目标bean需要忽略的属性
	 * @return 返回vo
	 */
	protected V getVO(D domainObject, Map<String, String> propertiesMapping, String[] ignoreProperties) {
		if (domainObject == null) {
			return null;
		}
		Class<V> voClass = (Class<V>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
		V vo = null;
		try {
			vo = voClass.newInstance();
		} catch (Exception e) {
			logger.warn("Populate failed from domainObject to viewObject == ", e);
			// throw new RuntimeException(e);
		}
		PopulatorFactory.getDefaultPopulator().populate(domainObject, vo, propertiesMapping, ignoreProperties);
		return vo;
	}

	/**
	 * doList-->voList
	 *
	 * @param doList
	 * @return 返回voList
	 */
	protected List<V> getVOList(List<D> doList) {
		return getVOList(doList, null, null);
	}

	/**
	 * doList-->voList
	 * @param doList
	 * @param ignoreProperties 目标bean需要忽略的属性
	 * @return 返回voList
	 */
	protected List<V> getVOList(List<D> doList, String[] ignoreProperties) {
		return getVOList(doList, null, ignoreProperties);
	}

	/**
	 * doList-->voList
	 * @param doList
	 * @param propertiesMapping bean属性之间的对应关系
	 * @return 返回voList
	 */
	protected List<V> getVOList(List<D> doList, Map<String, String> propertiesMapping) {
		return getVOList(doList, propertiesMapping, null);
	}

	/**
	 * doList-->voList
	 * @param doList
	 * @param propertiesMapping  bean属性之间的对应关系
	 * @param ignoreProperties 目标bean需要忽略的属性
	 * @return 返回voList
	 */
	protected List<V> getVOList(List<D> doList, Map<String, String> propertiesMapping, String[] ignoreProperties) {
		List<V> voList = null;
		if (doList != null) {
			voList = new ArrayList<V>();
			for (D domainObject : doList) {
				voList.add(getVO(domainObject, propertiesMapping, ignoreProperties));
			}
		}
		return voList;
	}
}
