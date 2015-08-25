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
package com.sitechasia.webx.core.dao.hibernate3;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.impl.CriteriaImpl;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.util.Assert;
import com.sitechasia.webx.core.dao.IDomainObjectQueryCache;
import com.sitechasia.webx.core.dao.impl.DomainObjectQueryCache;
import com.sitechasia.webx.core.support.Page;
import com.sitechasia.webx.core.utils.base.BeanUtils;

/**
 * Hibernate Dao的基类. 继承于Spring的HibernateDaoSupport,提供分页函数和若干便捷查询方法.
 *
 * @author
 * @version 1.2
 * @since JDK1.5
 * @see org.springframework.orm.hibernate3.support.HibernateDaoSupport
 */

public abstract class BaseHibernateDao extends HibernateDaoSupport {

	/**
	 * 日志对象.
	 *
	 * 在子类中不必单独定义日志对象，直接使用这里生成的即可
	 * 如:logger.info("**********");
	 */
	protected final Logger logger = Logger.getLogger(getClass());
	private static final IDomainObjectQueryCache NO_CACHE = new DomainObjectQueryCache();
	private IDomainObjectQueryCache entityQueryCache = NO_CACHE;

	/**
	 * 去除hql的orderby 子句，用于pagedQuery.
	 *
	 * @param hql
	 * 			hql语句
	 * @return
	 * 			去除orderby后的hql字符串
	 */
	private static String removeOrders(String hql) {
		Assert.hasText(hql);
		Pattern p = Pattern.compile("ORDER\\s*by[\\w|\\W|\\s|\\S]*", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(hql);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			m.appendReplacement(sb, "");
		}
		m.appendTail(sb);
		return sb.toString();
	}

	/**
	 * 去除hql的from前的语句.
	 *
	 * @param hql
	 * 			hql语句
	 * @return
	 * 			去除后的hql字符串
	 */
	private static String removeSelect(String hql) {
		Assert.hasText(hql);
		int beginPos = hql.toLowerCase().indexOf("from");
		Assert.isTrue(beginPos >= 0, " hql : " + hql + " must has a keyword 'from'");
		return hql.substring(beginPos);
	}

	/**
	 * hql查询.
	 *
	 * @param hql
	 *            查寻条件
	 * @param values
	 *            可变参数 用户可以如下四种方式使用 dao.find(hql) dao.find(hql,arg0);
	 *            dao.find(hql,arg0,arg1); dao.find(hql,new
	 *            Object[arg0,arg1,arg2])
	 * @return 符合条件的实体List
	 */
	public List find(String hql, Object... values) {
		if (!entityQueryCache.isCached(hql, values)) {
			logger.debug("Not Using Cache for query: " + hql);
			if (values.length == 0)
				return getHibernateTemplate().find(hql);
			else
				return getHibernateTemplate().find(hql, values);
		} else {
			logger.debug("Using Cache for query: " + hql);
			List list = new ArrayList();
			if (values.length == 0) {
				for (Iterator it = getHibernateTemplate().iterate(hql); it.hasNext();) {
					list.add(it.next());
				}
			} else {
				for (Iterator it = getHibernateTemplate().iterate(hql, values); it.hasNext();) {
					list.add(it.next());
				}
			}
			return list;
		}
	}

	/**
	 * 根据属性名和属性值查询对象.
	 *
	 * @param entityClass
	 *            泛型T的类型
	 * @param name
	 *            查询条件属性名
	 * @param value
	 *            查询条件
	 *
	 * @return 符合条件的对象列表
	 *
	 *
	 */
	public List genericFindBy(Class entityClass, String name, Object value) {
		Assert.hasText(name);
		Criteria criteria = getEntityCriteria(entityClass);
		criteria.add(Restrictions.eq(name, value));
		return criteria.list();
	}

	/**
	 * 根据属性名和属性值以Like AnyWhere方式查询对象.
	 *
	 * @param entityClass
	 *            泛型T的类型
	 * @param name
	 *            查询条件属性名
	 * @param value
	 *            查询条件
	 * @return 符合条件的对象列表
	 */
	public List genericFindByLike(Class entityClass, String name, String value) {
		Assert.hasText(name);
		Criteria criteria = getEntityCriteria(entityClass);
		criteria.add(Restrictions.like(name, value, MatchMode.ANYWHERE));
		return criteria.list();
	}

	/**
	 * 根据属性名和属性值查询对象.
	 *
	 * @param entityClass
	 *            泛型T的类型
	 * @param name
	 *            查询条件属性名
	 * @param value
	 *            查询条件
	 * @return 符合条件的唯一对象
	 */
	public Object genericFindUniqueBy(Class entityClass, String name, Object value) {
		Assert.hasText(name);
		Criteria criteria = getEntityCriteria(entityClass);
		criteria.add(Restrictions.eq(name, value));
		return criteria.uniqueResult();
	}

	/**
	 * 根据ID获取对象.
	 *
	 * @param entityClass
	 *            泛型T的类型
	 * @param id
	 *            指定的ID
	 *
	 * @return 指定的对象
	 */
	public Object genericGet(Class entityClass, Serializable id) {
		return getHibernateTemplate().get(entityClass, id);
	}

	/**
	 * 获取全部对象.
	 *
	 * @param entityClass
	 *            泛型T的类型
	 *
	 * @return 全部对象的List
	 */
	public List genericGetAll(Class entityClass) {
		return getHibernateTemplate().loadAll(entityClass);
	}

	/**
	 * 删除对象.
	 *
	 *
	 * @param clazz
	 *            泛型T的类型
	 * @param o
	 *            要删除的对象
	 */
	public void genericRemove(Class clazz, Object o) {
		getHibernateTemplate().delete(o);
	}

	/**
	 * 根据ID删除对象.
	 *
	 * @param entityClass
	 *            泛型T的类型
	 * @param id
	 *            要删除的对象的ID
	 */
	public void genericRemoveById(Class entityClass, Serializable id) {
		genericRemove(entityClass, genericGet(entityClass, id));
	}

	/**
	 * 保存对象.
	 *
	 * @param clazz
	 *            泛型T的类型
	 * @param o
	 *            要保存的对象
	 */
	protected void genericSave(Class clazz, Object o) {
		getHibernateTemplate().saveOrUpdate(o);
	}

	/**
	 * 保存一些列对象.
	 *
	 * @param clazz
	 *            类型
	 * @param list
	 *            要保存的对象List
	 */
	protected void genericSaveAll(Class clazz, Collection list) {
		getHibernateTemplate().saveOrUpdateAll(list);
	}

	/**
	 * 取得实体的查询对象.
	 *
	 * @param entityClass
	 *            类型
	 *
	 * @return 实体的查询对象
	 */
	protected Criteria getEntityCriteria(Class entityClass) {
		return getSession().createCriteria(entityClass);
	}

	/**
	 * 判断对象某些属性的值在数据库中不存在重复.
	 *
	 * @param entityClass
	 *            类型
	 * @param entity
	 *            指定的实体
	 *
	 * @param names
	 *            在POJO里不能重复的属性列表,以逗号分割 如"name,loginid,password"
	 * @return 包含重复的内容返回true，否则返回false
	 */
	public boolean isGenericNotUnique(Class entityClass, Object entity, String names) {
		Assert.hasText(names);
		Criteria criteria = getEntityCriteria(entityClass).setProjection(Projections.rowCount());
		String[] nameList = names.split(",");
		try {
			// 循环加入
			for (String name : nameList) {
				criteria.add(Restrictions.eq(name, PropertyUtils.getProperty(entity, name)));
			}
			// 以下代码为了如果是update的情况,排除entity自身.
			// 通过Hibernate的MetaData接口取得主键名
			String idPropertyName = getSessionFactory().getClassMetadata(entity.getClass()).getIdentifierPropertyName();
			if (idPropertyName != null) {
				// 通过反射取得entity的主键值
				Object id = PropertyUtils.getProperty(entity, idPropertyName);
				// 如果id!=null,说明对象已存在,该操作为update,加入排除自身的判断
				if (id != null)
					criteria.add(Restrictions.not(Restrictions.eq(idPropertyName, id)));
			}
		} catch (IllegalAccessException e) {
			logger.error("Error when reflection on entity", e);
			return false;
		} catch (InvocationTargetException e) {
			logger.error("Error when reflection on entity", e);
			return false;
		} catch (NoSuchMethodException e) {
			logger.error("Error when reflection on entity", e);
			return false;
		}
		return (Integer) criteria.uniqueResult() > 0;
	}

	/**
	 * 使用指定查询对象进行分页查询.
	 *
	 * @param criteria
	 *            实体的查询对象
	 * @param pageNo
	 *            页号,从1开始.
	 * @param pageSize
	 *            每页中的记录数
	 * @return 当前页的分页对象
	 */
	public Page pagedQuery(Criteria criteria, int pageNo, int pageSize) {
		CriteriaImpl impl = (CriteriaImpl) criteria;
		// 先把Projection和OrderBy条件取出来,清空两者来执行Count操作
		Projection projection = impl.getProjection();
		List<CriteriaImpl.OrderEntry> orderEntries;
		try {
			orderEntries = (List) BeanUtils.getPrivateProperty(impl, "orderEntries");
			BeanUtils.setPrivateProperty(impl, "orderEntries", new ArrayList());
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new InternalError(" Runtime Exception impossibility throw ");
		}
		// 执行查询
		long totalCount = ((Number) criteria.setProjection(Projections.rowCount()).uniqueResult()).longValue();
		// 将之前的Projection和OrderBy条件重新设回去
		criteria.setProjection(projection);
		if (projection == null) {
			criteria.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
		}
		try {
			BeanUtils.setPrivateProperty(impl, "orderEntries", orderEntries);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new InternalError(" Runtime Exception impossibility throw ");
		}
		// 返回分页对象
		if (totalCount < 1)
			return new Page();
		int startIndex = Page.getStartOfPage(pageNo, pageSize);
		List list = criteria.setFirstResult(startIndex).setMaxResults(pageSize).list();
		return new Page(startIndex, totalCount, pageSize, list);
	}

	/**
	 * 使用HQL进行分页查询.
	 *
	 * @param hql
	 *            查询条件
	 * @param pageNo
	 *            页号,从1开始.
	 * @param pageSize
	 *            每页中的记录数
	 * @param args
	 *            HQL的参数
	 * @return 当前页的分页对象
	 */
	public Page pagedQuery(String hql, int pageNo, int pageSize, Object... args) {
		Assert.hasText(hql);
		// 创建查询
		Query query = getSession().createQuery(hql);
		//根据华南提出的bug做出修正，做是否为null的判断
		if(args!=null){
			for (int i = 0; i < args.length; i++) {
				query.setParameter(i, args[i]);
			}
		}
		String countQueryString = " SELECT count (*) " + removeSelect(removeOrders(hql));
		List countlist = getHibernateTemplate().find(countQueryString, args);
		long totalCount = (Long) countlist.get(0);
		// 返回分页对象
		if (totalCount < 1)
			return new Page();
		int startIndex = Page.getStartOfPage(pageNo, pageSize);
		List list;
		if (!entityQueryCache.isCached(hql, pageNo, pageSize, args)) {
			logger.debug("Not Using Cache for query: " + hql);
			list = query.setFirstResult(startIndex).setMaxResults(pageSize).list();
		} else {
			logger.debug("Using Cache for query: " + hql);
			list = new ArrayList();
			for (Iterator it = query.setFirstResult(startIndex).setMaxResults(pageSize).iterate(); it.hasNext();) {
				list.add(it.next());
			}
		}
		return new Page(startIndex, totalCount, pageSize, list);
	}

	public void setEntityQueryCache(IDomainObjectQueryCache entityQueryCache) {
		this.entityQueryCache = entityQueryCache;
	}

}
