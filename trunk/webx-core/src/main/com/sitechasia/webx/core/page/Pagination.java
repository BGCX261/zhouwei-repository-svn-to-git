/**
 * @{#} Pagination.java Create on 2008-5-8 下午04:20:11
 *
 * Copyright (c) 2006- by CE.
 */
package com.sitechasia.webx.core.page;

import java.io.Serializable;

/**
 * 查询结果分页信息类。<p>
 *
 * @author MarkDong
 * @author todd
 * @version 1.5
 * @since 1.5
 * @see QueryResult
 */
public class Pagination implements Serializable {
	private static final long serialVersionUID = 4330426162530887803L;

	private long rowCount;		//记录总行数
	private long pageCount;	//记录总页数
	private long pageNum;		//当前页号，从1开始
	private long pageSize;		//每页记录数
	private long pageBeginIdx;	//当前页第一条记录的记录序号，对于第一页的第一条记录该值为1


	/**
	 * 得到总行数
	 *
	 * @return 总行数
	 */
	public long getRowCount() {
		return rowCount;
	}

	/**
	 * 得到总页数
	 *
	 * @return 总页数
	 */
	public long getPageCount() {
		return pageCount;
	}

	/**
	 * 得到当前的页号
	 *
	 * @return 页号
	 */
	public long getPageNum() {
		return pageNum;
	}

	/**
	 * 得到每页记录数
	 *
	 * @return 记录数
	 */
	public long getPageSize() {
		return pageSize;
	}

	/**
	 * 得到当前页开始记录数
	 *
	 * @return 开始记录数
	 */
	public long getPageBeginIdx() {
		return pageBeginIdx;
	}

	/**
	 * 设置当前页开始记录数
	 *
	 * @param pageBeginIdx 开始记录数
	 */
	public void setPageBeginIdx(long pageBeginIdx) {
		this.pageBeginIdx = pageBeginIdx;
	}

	/**
	 * 设置总行数
	 *
	 * @param rowCount 总行数
	 */
	public void setRowCount(long rowCount) {
		this.rowCount = rowCount;
	}

	/**
	 * 设置每页记录数
	 *
	 * @param rowCount 每页记录数
	 */
	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 设置当前的页号
	 *
	 * @param rowCount 页号
	 */
	public void setPageNum(long pageNum) {
		this.pageNum = pageNum;
	}

	/**
	 * 设置总页数
	 *
	 * @param rowCount 总页数
	 */
	public void setPageCount(long pageCount) {
		this.pageCount = pageCount;
	}


}
