/**
 * @{#} QueryResult.java Create on 2008-5-8 下午04:22:34
 *
 * Copyright (c) 2006- by CE.
 */
package com.sitechasia.webx.core.page;

import java.io.Serializable;
import java.util.List;

/**
 * 查询结果类。<br>
 *
 * @author MarkDong
 * @author todd
 * @version 1.5
 * @since 1.5
 * @see Pagination
 */
public class QueryResult<D> implements Serializable {
	private static final long serialVersionUID = 4447210777590540134L;

	private boolean isPaged;			//是否是分页结果集
	private Pagination pagination;		//分页信息，isPaged=true时有效
	private List<D> results;			//当前页的结果集

	/**
	 * 是否分页结果集
	 *
	 * @return true:是  false:不是
	 */
	public boolean isPaged() {
		return isPaged;
	}

	/**
	 * 得到分页信息
	 *
	 * @return 分页信息类
	 */
	public Pagination getPagination() {
		return pagination;
	}

	/**
	 * 得到当前页的结果集
	 *　
	 * @return 结果集
	 */
	public List<D> getResults() {
		return results;
	}

	/**
	 * 设置是否分页
	 *　
	 * @param isPaged 是否分页boolean值
	 */
	public void setPaged(boolean isPaged) {
		this.isPaged = isPaged;
	}

	/**
	 * 设置分页信息
	 *　
	 * @param pagination 分页信息
	 */
	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	/**
	 * 设置结果集
	 *
	 * @param results 结果集
	 */
	public void setResults(List<D> results) {
		this.results = results;
	}


}
