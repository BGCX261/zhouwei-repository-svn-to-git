/**
 * @{#} CommonHibernateDao.java Create on 2008-5-22 下午01:32:00
 *
 * Copyright (c) 2006- by CE.
 */
package com.sitechasia.webx.core.dao.hibernate3;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.util.Assert;

import com.sitechasia.webx.core.page.Pagination;
import com.sitechasia.webx.core.page.QueryResult;

/**
 * 通用Hibernate检索DAO<p>
 * 应用Hibernate技术提供通用检索，此DAO只提供检索方法，并且对检索结果不试图造型为任何DomainObject，
 * 所返回的对象全部是根据hql语句的书写方式由hibernate进行造型的。
 *
 * @author MarkDong
 * @version 1.5
 * @see
 */
public class CommonHibernateDao extends HibernateDaoSupport {
	protected final Logger logger = Logger.getLogger(getClass());

	/**
	 * 根据HQL语句统计记录数
	 *
	 * @author MarkDong
	 * @param hql 查询语句
	 * @param args 查询参数
	 * @return 符合条件的记录数
	 */
	@SuppressWarnings("unchecked")
	public long countByHql(String hql, Object... args) {
		Assert.hasText(hql);

		String countQueryString = " SELECT count (*) "
				+ BaseHibernateDomainDao.removeSelect(BaseHibernateDomainDao
						.removeOrders(hql));
		List countlist = getHibernateTemplate().find(countQueryString, args);
		long count = (Long) countlist.get(0);
		return count;
	}

	/**
	 * 根据HQL语句查询List型的结果集
	 *
	 * @author MarkDong
	 * @param hql 查询语句
	 * @param pageSize 每页记录数
	 * @param pageNum 页面编号，从1开始
	 * @param args 查询参数
	 * @return 符合条件的记录列表
	 */
	@SuppressWarnings("unchecked")
	public List<Object> listByHql(String hql, int pageSize, int pageNum, Object... args) {
		Assert.hasText(hql);

		Query query = getSession().createQuery(hql);
		if(args!=null){
			for (int i = 0; i < args.length; i++) {
				query.setParameter(i, args[i]);
			}
		}

		List<Object> list = null;
		if (pageNum > 0 && pageSize > 0) {
			int startIndex =  getStartOfPage(pageNum, pageSize);
			query.setFirstResult(startIndex).setMaxResults(pageSize);
		}

		list = query.list();
		return list;
	}

	/**
	 * 根据HQL语句查询结果集，按QueryResult返回
	 *
	 * @author MarkDong
	 * @param hql 查询语句
	 * @param pageSize 每页记录数
	 * @param pageNum 页面编号，从1开始
	 * @param args 查询参数
	 * @return 符合条件的分页结果集
	 */
	public QueryResult<Object> findByHql(String hql, int pageSize, int pageNum,
			Object... args) {
		Assert.hasText(hql);

		long count = countByHql(hql,args);
		List<Object> list = listByHql(hql, pageSize, pageNum, args);
		QueryResult<Object> result = createResult(pageSize, pageNum, count, list);
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
	private QueryResult<Object> createResult(int pageSize, int pageNum, long count,List<Object> list) {
		QueryResult<Object> result = new QueryResult<Object>();
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
			page.setPageBeginIdx(0);
		}else{
			page.setPageBeginIdx((pageNum - 1) * pageSize + 1);
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

}
