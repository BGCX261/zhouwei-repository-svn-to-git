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
package com.sitechasia.webx.core.support;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.sitechasia.webx.core.exception.BaseUnCheckedException;

/**
 * 分页对象. 包含当前页数据及分页信息.
 *
 * @author todd
 * @version 1.2 , 2008/5/6
 * @since JDK1.5
 */
public class Page implements Serializable {

	private static final long serialVersionUID = 2728437513842150372L;

	/**
	 * 每页数据容量的默认：20
	 */
	private static final int DEFAULT_PAGE_SIZE = 20;

	/**
	 * 每页数据容量
	 */
	private int pageSize;

	/**
	 * 当前页第一条数据在List中的位置,默认0
	 */
	private int start;

	/**
	 * 当前页中存放的记录
	 */
	private List data;

	/**
	 * 总记录数
	 */
	private long totalCount;

	/**
	 * 构造方法，只构造空值
	 */
	public Page() {
		this(0, 0, DEFAULT_PAGE_SIZE, new ArrayList());
	}

	/**
	 * 默认构造方法
	 *
	 * @param start 本页数据在数据库中的起始位置
	 * @param totalSize 数据库中总记录条数
	 * @param pageSize 本页容量
	 * @param data 本页包含的数据
	 */
	public Page(int start, long totalSize, int pageSize, List data) {
		if (pageSize <= 0 || start < 0 || totalSize < 0) {
			throw new BaseUnCheckedException("Illegal Arguments to Initiate Page Object");
		}
		this.pageSize = pageSize;
		this.start = start;
		this.totalCount = totalSize;
		this.data = data;
	}

	/**
	 * 取数据库中包含的总记录数
	 * @return 总记录数
	 */
	public long getTotalCount() {
		return this.totalCount;
	}

	/**
	 * 取总页数
	 * @return 总页数
	 */
	public long getTotalPageCount() {
		return totalCount % pageSize == 0 ?
				totalCount / pageSize :
				totalCount / pageSize + 1;
	}

	/**
	 * 取每页数据容量
	 * @return 每页数据容量
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 设置当前页中的纪录
	 */
	public void setResult(List data) {
		this.data = data;
	}

	/**
	 * 获取当前页中的记录
	 * @return 当前页中的记录
	 */
	public List getResult() {
		return data;
	}

	/**
	 * 取当前页码,页码默认1
	 * @return 当前页码
	 */
	public int getCurrentPageNo() {
		return start / pageSize + 1;
	}

	/**
	 * 是否有下页
	 * @return 有下页返回true，否则返回false
	 */
	public boolean hasNextPage() {
		return this.getCurrentPageNo() < this.getTotalPageCount();
	}

	/**
	 * 是否有上页
	 * @return 有上页返回true，否则返回false
	 */
	public boolean hasPreviousPage() {
		return this.getCurrentPageNo() > 1;
	}

	/**
	 * 数据是否为空
	 * @return 为空返回true, 否则返回false
	 */
	public boolean isEmpty() {
		return data == null || data.isEmpty();
	}

	/**
	 * 获取本页第一条数据在整个结果中的位置
	 * @return 位置序号（从0开始）
	 */
	public int getStartIndex() {
		return (getCurrentPageNo() - 1) * pageSize;
	}

	/**
	 * 获取本页最后一条数据在整个结果中的位置
	 * @return 位置序号（从0开始）
	 */
	public int getEndIndex() {
		int endIndex = getCurrentPageNo() * pageSize - 1;
		return endIndex >= totalCount ? (int)totalCount - 1 : endIndex;
	}

	/**
	 * 获取任一页第一条数据在整个结果中的位置（每页数据容量使用默认）
	 * @param pageNo 页码，从1开始
	 * @return 位置序号（从0开始）
	 */
	protected static int getStartOfPage(int pageNo) {
		return getStartOfPage(pageNo, DEFAULT_PAGE_SIZE);
	}

	/**
	 * 获取任一页第一条数据在整个结果中的位置（每页数据容量使用指定）
	 * @param pageNo 页码，从1开始
	 * @param pageSize 页面数据容量
	 * @return 位置序号（从0开始）
	 */
	public static int getStartOfPage(int pageNo, int pageSize) {
		return (pageNo - 1) * pageSize;
	}
}
