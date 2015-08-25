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
package com.sitechasia.webx.core.dao.jdbc;

/**
 * SQL分页接口
 * @author
 * @version 1.2
 * @since JDK1.5
 */
public interface IPageSqlProvider {
	/**
	 * 返回分页Sql语句
	 * @param oldSqlStr
	 * 			需要分页的sql语句
	 * @param firstResult
	 * 			第一条记录所在位置
	 * @param numOfRows
	 * 			最后一条记录的位置
	 * @return 返回分页Sql语句
	 */
	public String getPageSql(String oldSqlStr, int firstResult, int numOfRows);
}
