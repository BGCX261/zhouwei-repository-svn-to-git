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
package com.sitechasia.webx.core.dao.jdbc.hsqldb;

import com.sitechasia.webx.core.dao.jdbc.IPageSqlProvider;

/**
 * Hsqldb分页
 * @author
 * @version 1.2
 * @since JDK1.5
 */

public class HsqldbPageSqlProvider implements IPageSqlProvider {

	/**
	 * 拼装分页hql语句
	 *
	 * @param oldSqlStr
	 * 			查询hql语句
     * @param firstResult
	 * 			第一条记录所在位置
	 * @param numOfRows
	 * 			最后一条记录的位置
	 * @return 返回分页Sql语句
	 */
	public String getPageSql(String oldSqlStr, int firstResult, int numOfRows) {
		if (firstResult >= 0 && numOfRows > 0) {
			// 查找oldSqlStr中的select的位置
			String temp = oldSqlStr.toUpperCase();
			int index = temp.indexOf("SELECT");

			StringBuffer replace = new StringBuffer();
			replace.append("SELECT LIMIT ").append(firstResult).append(" ").append(numOfRows);

			// 将oldSqlStr中的select(可能是Select等), 做替换
			StringBuffer sb = new StringBuffer(oldSqlStr);
			sb.replace(index, index + 6, replace.toString());
			return sb.toString();
		} else
			return oldSqlStr;
	}

}
