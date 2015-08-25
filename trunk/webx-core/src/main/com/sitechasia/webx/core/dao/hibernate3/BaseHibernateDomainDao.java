/**
 * @{#} BaseHibernateDomainDao.java Create on 2008-5-9 下午03:21:31
 *
 * Copyright (c) 2006- by CE.
 */
package com.sitechasia.webx.core.dao.hibernate3;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.beanutils.PropertyUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.impl.CriteriaImpl;
import org.springframework.util.Assert;

import com.sitechasia.webx.core.cache.ICacheProvider;
import com.sitechasia.webx.core.dao.IDomainDao;
import com.sitechasia.webx.core.model.IDomainObject;
import com.sitechasia.webx.core.page.Pagination;
import com.sitechasia.webx.core.page.QueryResult;
import com.sitechasia.webx.core.utils.base.BeanUtils;
import com.sitechasia.webx.core.utils.base.GenericsUtils;

/**
 * 基于Hibernate技术的DomainDao基础实现类。<p>
 * 本类针对IDomainDao实现了基本方法，同时扩展了一些Hibernate特有的方法，例如基于Criteria和
 * DetachedCriteria的查询。
 *
 * @author MarkDong
 * @author todd
 * @version 1.5
 * @since 1.5
 */
public class BaseHibernateDomainDao<D extends IDomainObject> extends BaseHibernateDao implements IDomainDao<D> {
	//CacheProvider实例
	ICacheProvider webxCacheProvider = null; 

	
	/**
	 * DAO管理的Entity类型.
	 */
	protected Class<D> entityClass;

	public ICacheProvider getWebxCacheProvider() {
		return webxCacheProvider;
	}

	public void setWebxCacheProvider(ICacheProvider webxCacheProvider) {
		this.webxCacheProvider = webxCacheProvider;
	}

	/**
	 * 通知CacheProvider有实体对象发生变化
	 * 
	 * @param obj 变化的对象
	 */
	protected void notifyCacheProvider(D obj) {
		if(webxCacheProvider == null) return;
		long count = webxCacheProvider.onChange(entityClass, obj);
		logger.debug("实体类更新缓存，受影响的缓存个数：" + count);
	}
	
	/**
	 * 删除域对象。
	 *
	 * @param obj 待删除对象
	 */
	public void delete(D obj) {
		getHibernateTemplate().delete(obj);
		this.notifyCacheProvider(obj);
	}

	/**
	 * 根据主键删除域对象。
	 *
	 * @param id 主键
	 */
	public void deleteById(Serializable id) {
		D obj = this.get(id);
		delete(obj);
		this.notifyCacheProvider(obj);
	}

	/**
	 * 根据主键数组删除所有域对象
	 *
	 * @param ids 主键数组
	 */
	public void deleteByIds(Serializable[] ids) {
		for(Serializable id : ids) {
			deleteById(id);
		}
	}

	/**
	 * 获取全部对象。对于记录量大的表请谨慎使用。
	 *
	 * @param pageSize 页面记录数
	 * @param pageNum 页号，从1开始
	 * @return QueryResult 结果集对象QueryResult
	 * @see QueryResult
	 */
	public QueryResult<D> findAll(int pageSize, int pageNum) {
		long count = this.countAll();
		List<D> list = this.listAll(pageSize, pageNum);
		QueryResult<D> result = createResult(pageSize, pageNum, count, list);
		return result;
	}

	/**
	 * 根据结果集创建Result对象
	 *
	 * @param pageSize 每页记录数
	 * @param pageNum 当前页号，从1开始
	 * @param count  记录总行数
	 * @param list 全部对象集合
	 * @return QueryResult 结果集对象QueryResult
	 * @see QueryResult
	 */
	private QueryResult<D> createResult(int pageSize, int pageNum, long count,List<D> list) {
		QueryResult<D> result = new QueryResult<D>();
		Pagination page = new Pagination();
		page.setRowCount(count);
		if(count < 1){
			page.setPageNum(0);
		}else{
			page.setPageNum(pageNum);
		}
		page.setPageSize(pageSize);
		if(pageSize < 1){
			//page.setPageCount(1);
		}else{
			page.setPageCount(count % pageSize == 0 ? count / pageSize : count / pageSize + 1);
		}
		if(count < 1){
			page.setPageBeginIdx((pageNum - 1) * pageSize + 1);
		}else{
			page.setPageBeginIdx(0);
		}
		if(pageSize >0 && pageNum>0) {
			result.setPaged(true);
		}
		else {
			result.setPaged(false);
		}
		result.setPagination(page);
		result.setResults(list);

		return result;
	}
	/**
	 * 获取任一页第一条数据在整个结果中的位置（每页数据容量使用指定）
	 *
	 * @param pageNo 页码，从1开始
	 * @param pageSize 页面数据容量
	 * @return 位置序号（从0开始）
	 */
	public int getStartOfPage(int pageNo, int pageSize) {
		return (pageNo - 1) * pageSize ;
	}
	/**
	 * 根据单字段获取对象。
	 * <p>
	 * 取得字段值等于指定值的对象列表。
	 *
	 * @param field 字段名称
	 * @param value 指定值
	 * @param pageSize 页面记录数
	 * @param pageNum 页号，从1开始
	 * @return QueryResult 结果集对象QueryResult
	 * @see QueryResult
	 */
	public QueryResult<D> findByField(String field, Object value, int pageSize,int pageNum) {
		return findByFields(new String[]{field}, new Object[]{value}, pageSize, pageNum);
	}

	/**
	 * 根据字段相等的值获取一个Criteria对象
	 *
	 * @param field 字段名称
	 * @param value 指定值
	 */
	private Criteria getCriteriaByFieldEquals(String[] fields, Object[] values) {
		Criteria criteria = getCriteriaByField(fields, values);
		for(int i = 0;i < fields.length;++i){
			criteria.add(Restrictions.eq(fields[i], values[i]));
		}
		return criteria;
	}

	/**
	 * 根据字段相匹配的值获取一个Criteria对象
	 *
	 * @param field 字段名称
	 * @param value 指定值
	 */
	private Criteria getCriteriaByFieldLike(String[] fields, String[] values) {
		Criteria criteria = getCriteriaByField(fields, values);
		for(int i = 0;i < fields.length;++i){
			criteria.add(Restrictions.like(fields[i], values[i],MatchMode.ANYWHERE));
		}
		return criteria;
	}

	private Criteria getCriteriaByField(String[] fields, Object[] values) {
		Assert.notEmpty(fields);
		Assert.notEmpty(values);

		Criteria criteria = this.getCriteria();
		return criteria;
	}

	/**
	 * 以Like AnyWhere的方式对单一字段查询。只支持字符串型字段。
	 *
	 * @param field 字段名称
	 * @param value 值
	 * @param pageSize 页面记录数
	 * @param pageNum 页号，从1开始
	 * @return QueryResult 结果集对象QueryResult
	 * @see QueryResult
	 */
	public QueryResult<D> findByFieldLike(String field, String value,int pageSize, int pageNum) {
		return findByFieldsLike(new String[]{field}, new String[]{value}, pageSize, pageNum);
	}

	/**
	 * 根据多字段获取对象。 取得所有字段值都等于指定值的对象列表。
	 *
	 * @param fields 字段名称数组
	 * @param values 查询值数组。要跟字段名称顺序一致。
	 * @param pageSize 页面记录数
	 * @param pageNum 页号，从1开始
	 * @return QueryResult 结果集对象QueryResult
	 * @see QueryResult
	 */
	public QueryResult<D> findByFields(String[] fields, Object[] values,int pageSize, int pageNum) {
		Criteria criteria = getCriteriaByFieldEquals(fields,values);
		return findByCriteria(criteria, pageSize, pageNum);
	}

	/**
	 * 以Like AnyWhere的方式对字段组合查询。只支持字符串型字段。
	 *
	 * @param fields 字段名称数组
	 * @param values 值数组
	 * @param pageSize 页面记录数
	 * @param pageNum 页号，从1开始
	 * @return QueryResult 结果集对象QueryResult
	 * @see QueryResult
	 */
	public QueryResult<D> findByFieldsLike(String[] fields, String[] values,int pageSize, int pageNum) {
		Criteria criteria = getCriteriaByFieldLike(fields,values);
		return findByCriteria(criteria, pageSize, pageNum);
	}

	/**
	 * 根据主键取得记录
	 *
	 * @param id 主键
	 * @return 该主键对应的记录。如果不存在该主键，返回null
	 */
	@SuppressWarnings("unchecked")
	public D get(Serializable id) {
		return (D)getHibernateTemplate().get(getEntityClass(),id);
	}

	/**
	 * 根据主键取得记录
	 *
	 * @author MarkDong
	 * @param id 主键
	 * @return 该主键对应的记录代理类实例。如果开启了缓存,则先在缓存中查询.如果不存在该主键，抛出ObjectNotFoundException异常
	 */
	@SuppressWarnings("unchecked")
	public D load(Serializable id){
		return (D)this.getHibernateTemplate().load(getEntityClass(),id);
	}

	/**
	 * 根据查询语句获取对象。
	 * <p>
	 * 此方法支持采用占位符形式的查询语句，对于查询语句建议使用占位符形式，可有效
	 * 避免SQL注入漏洞。参数的传递采用可变参数args，参数类型必须和字段类型相匹配。 可用如下四种方法调用：
	 * <ul>
	 * <li>dao.findByQl(ql, pageSize, pageNum);
	 * <li> dao.findByQl(ql, pageSize, pageNum, arg0);
	 * <li> dao.findByQl(ql, pageSize, pageNum, arg0, arg1);
	 * <li> dao.findByQl(ql, pageSize, pageNum, new Object[]{arg0, arg1, arg2});
	 * </ul>
	 *
	 * @param ql 查询语句
	 * @param pageSize 页面记录数
	 * @param pageNum 页号，从1开始
	 * @param args 查询参数列表
	 * @return QueryResult 结果集对象QueryResult
	 * @see QueryResult
	 */
	public QueryResult<D> findByQL(String ql, int pageSize, int pageNum,Object... args) {
		Assert.hasText(ql);

		long count = countByQl(ql,args);
		List<D> list = listByQL(ql,pageSize, pageNum,args);
		QueryResult<D> result = createResult(pageSize, pageNum, count, list);
		return result;
	}

	/**
	 * 判断数据库中是否已经存在指定字段列表的值的记录。
	 *
	 * @param obj 域对象
	 * @param fields 逗号分割的属性列表，例如"username, password"
	 * @return boolean true:存在 false:不存在
	 */
	public boolean isExist(D obj, String fields) {
		Assert.hasText(fields);
		Criteria criteria = getCriteria().setProjection(Projections.rowCount());
		String[] nameList = fields.split(",");
		try {
			for (String name : nameList) {
				criteria.add(Restrictions.eq(name, PropertyUtils.getProperty(obj, name)));
			}

			String idPropertyName = getSessionFactory().getClassMetadata(obj.getClass()).getIdentifierPropertyName();
			if (idPropertyName != null) {
				// 通过反射取得obj的主键值
				Object id = PropertyUtils.getProperty(obj, idPropertyName);
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
		return ((Integer) criteria.uniqueResult()).intValue() > 0;
	}



	/**
	 * 获取全部对象。对于记录量大的表请谨慎使用。
	 *
	 * @param pageSize 页面记录数
	 * @param pageNum 页号，从1开始
	 * @return 结果集
	 */
	@SuppressWarnings("unchecked")
	public List<D> listAll(int pageSize, int pageNum) {
		return listByCriteria(getCriteria(),pageSize,pageNum);
	}

	/**
	 * 根据单字段获取对象。
	 * <p>
	 * 取得字段值等于指定值的对象列表。
	 *
	 * @param field 字段名称
	 * @param value 指定值
	 * @param pageSize 页面记录数
	 * @param pageNum 页号，从1开始
	 * @return 结果集
	 */
	public List<D> listByField(String field, Object value, int pageSize,int pageNum) {
		return listByFields(new String[]{field}, new Object[]{value}, pageSize, pageNum);
	}

	/**
	 * 以Like AnyWhere的方式对单一字段查询。只支持字符串型字段。
	 *
	 * @author MarkDong
	 * @param field 字段名称
	 * @param value 值
	 * @param pageSize 页面记录数
	 * @param pageNum 页号，从1开始
	 * @return 结果集
	 */
	public List<D> listByFieldLike(String field, String value, int pageSize,int pageNum) {
		return listByFieldsLike(new String[]{field}, new String[]{value}, pageSize, pageNum);
	}

	/**
	 * 根据多字段获取对象。 取得所有字段值都等于指定值的对象列表。
	 *
	 * @param fields 字段名称数组
	 * @param values 查询值数组。要跟字段名称顺序一致。
	 * @param pageSize 页面记录数
	 * @param pageNum 页号，从1开始
	 * @return 结果集
	 */
	public List<D> listByFields(String[] fields, Object[] values, int pageSize,int pageNum) {
		Criteria criteria = getCriteriaByFieldEquals(fields,values);
		return listByCriteria(criteria, pageSize, pageNum);
	}

	/**
	 * 以Like AnyWhere的方式对字段组合查询。只支持字符串型字段。
	 *
	 * @param fields 字段名称数组
	 * @param values 值数组
	 * @param pageSize 页面记录数
	 * @param pageNum 页号，从1开始
	 * @return 结果集
	 */
	public List<D> listByFieldsLike(String[] fields, String[] values,int pageSize, int pageNum) {
		Criteria criteria = getCriteriaByFieldLike(fields,values);
		return listByCriteria(criteria, pageSize, pageNum);
	}

	/**
	 * 根据查询语句获取对象。
	 * <p>
	 * 参数的传递采用可变参数args，参数类型必须和字段类型相匹配。 可用如下四种方法调用：
	 * <ul>
	 * <li>dao.listByQl(ql, pageSize, pageNum);
	 * <li> dao.listByQl(ql, pageSize, pageNum, arg0);
	 * <li> dao.listByQl(ql, pageSize, pageNum, arg0, arg1);
	 * <li> dao.listByQl(ql, pageSize, pageNum, new Object[]{arg0, arg1, arg2});
	 * </ul>
	 *
	 * @param ql 查询语句
	 * @param pageSize 页面记录数
	 * @param pageNum 页号，从1开始
	 * @param args 查询参数列表
	 * @return 结果集
	 */
	@SuppressWarnings("unchecked")
	public List<D> listByQL(String hql, int pageSize, int pageNum, Object... args) {
		Assert.hasText(hql);
		Query query = getSession().createQuery(hql);
		if(args!=null){
			for (int i = 0; i < args.length; i++) {
				query.setParameter(i, args[i]);
			}
		}

		List list;
		if (pageNum > 0 && pageSize > 0) {
			int startIndex =  getStartOfPage(pageNum, pageSize);
			query.setFirstResult(startIndex).setMaxResults(pageSize);
		}

		//hibernate2以前需要用iterate()进行查询
//		if (!entityQueryCache.isCached(hql, pageNum, pageSize, args)) {
//			logger.debug("Not Using Cache for query: " + hql);
//			list = query.list();
//		} else {
//			logger.debug("Using Cache for query: " + hql);
//			list = new ArrayList();
//			for (Iterator it = query.iterate(); it.hasNext();) {
//				list.add(it.next());
//			}
//		}

//		if (!entityQueryCache.isCached(hql, pageNum, pageSize, args)) {
//			logger.debug("Not Using Cache for query: " + hql);
//			list = query.list();
//		} else {
			logger.debug("Using Cache for query: " + hql);
			list = query.setCacheable(true).list();
//	}

		return list;
	}

	/**
	 * 添加域对象。
	 *
	 * @param obj 域对象
	 */
	public void save(D obj) {
		getHibernateTemplate().save(obj);
		this.notifyCacheProvider(obj);
	}

	/**
	 * 保存或添加域对象
	 *
	 * @param obj 域对象
	 */
	public void saveOrUpdate(D obj) {
		getHibernateTemplate().saveOrUpdate(obj);
		this.notifyCacheProvider(obj);
	}

	/**
	 * 批量保存或添加域对象。
	 *
	 * @param objs 域对象集合
	 */
	public void saveOrUpdateAll(Collection<D> objs) {
		getHibernateTemplate().saveOrUpdateAll(objs);
		for(D obj : objs) {
			this.notifyCacheProvider(obj);
		}
	}

	/**
	 * 更新域对象
	 *
	 * @param obj 域对象
	 */
	public void update(D obj) {
		getHibernateTemplate().update(obj);
		this.notifyCacheProvider(obj);
	}

	/**
	 * 取得当前实体类的所有记录数
	 *
	 * @return 所有记录数
	 */
	public long countAll() {
		return countByCriteria(getCriteria());
	}

	/**
	 * 根据字段名称及字段值统计记录数
	 *
	 * @param field 字段名称
	 * @param value 字段值
	 * @return 记录数
	 */
	public long countByField(String field, Object value) {
		return countByFields(new String[]{field},new Object[]{value});
	}

	/**
	 * 根据字段名称及字段值做Like统计，只支持字符串型字段。
	 *
	 * @param field 字段名
	 * @param value 字段值
	 * @return 记录数
	 */
	public long countByFieldLike(String field, String value) {
		return countByFieldsLike(new String[]{field},new String[]{value});
	}

	/**
	 * 根据字段名称及字段值的数组统计记录数
	 * @param fields 字段名称数组
	 *
	 * @param values 字段值数组
	 * @return 记录数
	 */
	public long countByFields(String[] fields, Object[] values) {
		Criteria criteria = getCriteriaByFieldEquals(fields,values);
		return countByCriteria(criteria);
	}

	/**
	 * 根据字段名及字段值数组做Like统计，只支持字符串型字段。
	 *
	 * @param fields 字段名数组
	 * @param values 字段值数组
	 * @return 记录数
	 */
	public long countByFieldsLike(String[] fields, String[] values) {
		Criteria criteria = getCriteriaByFieldLike(fields,values);
		return countByCriteria(criteria);
	}

	/**
	 * 统计符合查询语句的记录数<p>
	 * 参数的传递采用可变参数args，参数类型必须和字段类型相匹配。 可用如下四种方法调用：
	 * <ul>
	 * <li>dao.countByQl(ql);
	 * <li> dao.countByQl(ql, arg0);
	 * <li> dao.countByQl(ql, arg0, arg1);
	 * <li> dao.countByQl(ql, new Object[]{arg0, arg1, arg2});
	 * </ul>
	 *
	 * @param ql 查询语句
	 * @param args 参数列表
	 * @return 记录数
	 */
	public long countByQl(String ql, Object... args) {
		String countQueryString = " SELECT count (*) " + removeSelect(removeOrders(ql));
		List countlist = getHibernateTemplate().find(countQueryString, args);
		long count = (Long) countlist.get(0);
		return count;
	}



	/**
	 * 取得Hibernate Criteria。Criteria只能在Session内使用，Session关闭后失效，请谨慎使用。<p>
	 * 本方法为Hibernate特有方法。
	 *
	 * @return Criteria
	 */
	public Criteria getCriteria() {
		return getSession().createCriteria(this.getEntityClass());
	}

	/**
	 * 根据Criteria统计结果集<p>
	 * 本方法为Hibernate特有方法。
	 *
	 * @param criteria Criteria对象
	 * @return 结果集个数
	 */
	@SuppressWarnings("unchecked")
	public long countByCriteria(Criteria criteria) {
		Assert.notNull(criteria);
		CriteriaImpl impl = (CriteriaImpl) criteria;

		// 先把Projection和OrderBy条件取出来,清空两者来执行Count操作
		Projection projection = impl.getProjection();
		List<CriteriaImpl.OrderEntry> orderEntries;
		try {
			orderEntries = (List) BeanUtils.getPrivateProperty(impl,
					"orderEntries");
			BeanUtils.setPrivateProperty(impl, "orderEntries", new ArrayList());
		} catch (Exception e) {
			throw new InternalError(" Runtime Exception impossibility throw ");
		}

		// 执行查询
		long totalCount = (Integer) criteria.setProjection(
				Projections.rowCount()).uniqueResult();

		// 将之前的Projection和OrderBy条件重新设回去
		criteria.setProjection(projection);
		if (projection == null) {
			criteria.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
		}
		try {
			BeanUtils.setPrivateProperty(impl, "orderEntries", orderEntries);
		} catch (Exception e) {
			throw new InternalError(" Runtime Exception impossibility throw ");
		}

		return totalCount;
	}

	/**
	 * 根据Criteria查询结果<p>
	 * 本方法为Hibernate特有方法。
	 *
	 * @param criteria Criteria对象
	 * @param pageSize 页面记录数
	 * @param pageNum 页号，从1开始
	 * @return 结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<D> listByCriteria(Criteria criteria, int pageSize, int pageNum) {
		Assert.notNull(criteria);

		if(pageSize > 0 && pageNum >0) {
			int startIndex = getStartOfPage(pageNum, pageSize);
			criteria.setFirstResult(startIndex);
			criteria.setMaxResults(pageSize);
		}

		List<D> list = criteria.list();
		return list;
	}

	/**
	 * 根据Criteria查询结果。<p>
	 * 本方法为Hibernate特有方法。
	 *
	 * @param criteria Criteria对象
	 * @param pageSize 页面记录数
	 * @param pageNum 页号，从1开始
	 * @return 查询结果
	 */
	public QueryResult<D> findByCriteria(Criteria criteria, int pageSize, int pageNum) {
		Assert.notNull(criteria);

		long count = this.countByCriteria(criteria);
		List<D> list = listByCriteria(criteria,pageSize, pageNum);
		QueryResult<D> result = createResult(pageSize, pageNum, count, list);
		return result;
	}

	/**
	 * 取得Hibernate DetachedCriteria<p>
	 * 本方法为Hibernate特有方法。
	 *
	 * @author MarkDong
	 * @return DetachedCriteria
	 */
	public DetachedCriteria getDetachedCriteria() {
		return DetachedCriteria.forClass(getEntityClass());
	}

	/**
	 * 根据DetachedCriteria统计结果集大小<p>
	 * 本方法为Hibernate特有方法。
	 *
	 * @author MarkDong
	 * @param dc DetachedCriteria对象
	 * @return 结果集大小
	 */
	public long countByDetachedCriteria(DetachedCriteria dc) {
		Assert.notNull(dc);

		return countByCriteria(dc.getExecutableCriteria(getSession()));
	}

	/**
	 * 根据DetachedCriteria查询结果<p>
	 * 本方法为Hibernate特有方法。
	 *
	 * @author MarkDong
	 * @param dc DetachedCriteria对象
	 * @param pageSize 页面记录数
	 * @param pageNum 页号，从1开始
	 * @return 结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<D> listByDetachedCriteria(DetachedCriteria dc, int pageSize, int pageNum) {
		Assert.notNull(dc);

		return listByCriteria(dc.getExecutableCriteria(getSession()), pageSize, pageNum);

	}

	/**
	 * 根据DetachedCriteria查询结果。<p>
	 * 本方法为Hibernate特有方法。
	 * @author MarkDong
	 * @param dc DetachedCriteria对象
	 * @param pageSize 页面记录数
	 * @param pageNum 页号，从1开始
	 * @return 查询结果
	 */
	public QueryResult<D> findByDetachedCriteria(DetachedCriteria dc, int pageSize, int pageNum) {
		Assert.notNull(dc);

		return findByCriteria(dc.getExecutableCriteria(getSession()),pageSize,pageNum);
	}

	/**
	 * 去除hql的orderby 子句，用于pagedQuery.
	 *
	 * @param hql
	 * 			hql语句
	 * @return
	 * 			去除orderby后的hql字符串
	 */
	 static String removeOrders(String hql) {
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
	 static String removeSelect(String hql) {
		Assert.hasText(hql);
		int beginPos = hql.toLowerCase().indexOf("from");
		Assert.isTrue(beginPos >= 0, " hql : " + hql + " must has a keyword 'from'");
		return hql.substring(beginPos);
	}

	public Class<D> getEntityClass() {
		return entityClass;
	}

	@SuppressWarnings("unchecked")
	public BaseHibernateDomainDao() {
		entityClass = GenericsUtils.getGenericClass(getClass());
	}

	//以下为实现的原有的IDomainObjectDao接口的方法
	/**
	 * {@link com.sitechasia.webx.core.dao.IDomainObjectDao#doDelete(com.sitechasia.webx.core.model.IDomainObject)
	 *
	 */
	public void doDelete(D o) {
		this.delete(o);

	}
	/**
	 * {@link com.sitechasia.webx.core.dao.IDomainObjectDao#doDeleteById(java.io.Serializable)
	 *
	 */
	public void doDeleteById(Serializable id) {
		this.deleteById(id);

	}
	/**
	 * {@link com.sitechasia.webx.core.dao.IDomainObjectDao#doDeleteByIds(java.io.Serializable[])
	 *
	 */
	public void doDeleteByIds(Serializable[] ids) {
		this.deleteByIds(ids);
	}

	/**
	 * {@link com.sitechasia.webx.core.dao.IDomainObjectDao#doSave(com.sitechasia.webx.core.model.IDomainObject)
	 *
	 */
	public void doSave(D o) {
		this.saveOrUpdate(o);
	}
	/**
	 * {@link com.sitechasia.webx.core.dao.IDomainObjectDao#doSaveAll()
	 *
	 */
	public void doSaveAll(Collection<D> list) {
		this.saveOrUpdateAll(list);
	}
	/**
	 * {@link com.sitechasia.webx.core.dao.IDomainObjectDao#findAll()
	 *
	 */
	public List<D> findAll() {
		return this.listAll(0,0);
	}
	/**
	 * {@link com.sitechasia.webx.core.dao.IDomainObjectDao#findBy()
	 *
	 */
	public List<D> findBy(String name, Object value) {
		return this.listByField(name, value, 0, 0);
	}
	/**
	 * {@link com.sitechasia.webx.core.dao.IDomainObjectDao#findById()
	 *
	 */
	public D findById(Serializable id) {
		return this.get(id);
	}
	/**
	 * {@link com.sitechasia.webx.core.dao.IDomainObjectDao#findByLike()
	 *
	 */
	public List<D> findByLike(String name, String value) {
		return this.listByFieldLike(name, value, 0, 0);
	}
	/**
	 * {@link com.sitechasia.webx.core.dao.IDomainObjectDao#findUniqueBy()
	 *
	 */
	@SuppressWarnings("unchecked")
	public D findUniqueBy(String name, Object value) {
		Assert.hasText(name);
		Criteria criteria = this.getCriteria();
		criteria.add(Restrictions.eq(name, value));
		return (D)criteria.uniqueResult();
	}
	/**
	 * {@link com.sitechasia.webx.core.dao.IDomainObjectDao#isNotUnique()
	 *
	 */
	public boolean isNotUnique(D domainObject, String names) {
		return this.isExist(domainObject, names);
	}


	/**
	 * merge操作
	 * 
	 * @param entity 需要merge(合并)操作的DO
	 * @return 返回更新后的持久化对象实例DO
	 */
	public D merge(D entity)  {
		return (D) getHibernateTemplate().merge(entity);
	}
}
