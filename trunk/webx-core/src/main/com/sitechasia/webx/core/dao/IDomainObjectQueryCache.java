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
package com.sitechasia.webx.core.dao;

/**
 * 业务对象的缓存查询
 *
 * @author todd
 * @version 1.2 , 2008/5/6
 * @since JDK1.5
 */

public interface IDomainObjectQueryCache {
	/**
	 * 是否缓存查询
	 *
	 * @param hql
	 * 			查询hql语句
	 * @param values
	 * 			查询条件
	 * @return 1.true
	 * 			2.false
	 */
    boolean isCached(String hql, Object... values);

    /**
     * 是否缓存分页查询
     *
     * @param hql
	 * 			查询hql语句
     * @param pageNo
     * 			当前第几页
     * @param pageSize
     * 			每页有多少行数据
     * @param args
	 * 			查询条件
     * @return 1.true
	 * 			2.false
     */
    boolean isCached(String hql, int pageNo, int pageSize, Object... args);
}
