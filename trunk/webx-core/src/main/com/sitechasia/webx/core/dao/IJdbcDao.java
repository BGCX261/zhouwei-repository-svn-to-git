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

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.sitechasia.webx.core.support.Page;

/**
 * JDBC常用的CRUD操作接口
 *
 * @author todd
 * @version 1.2
 * @since JDK1.5
 */

public interface IJdbcDao extends IDao {
	/**
	 * 查询多行多列数据
	 *
	 * @param sql
	 *            执行的静态SQL
	 * @param parameter
	 * @return 对象List
	 */
	public List genericFindObject(String sql, final Object parameter);

	/**
	 * 查询多行多列数据
	 *
	 * @param psql
	 *            含有参数的SQL
	 * @param args
	 * @param parameter
	 * @return 对象List
	 */
	public List genericFindObject(String psql, Object[] args, final Object parameter);

	/**
	 * 分页查询多行多列数据，当pageNo <= 0或pageSize <= 0时返回所有符合条件的数据
	 *
	 * @param sql
	 *            执行的静态SQL
	 * @param parameter
	 * @param pageNo
	 * @param pageSize
	 * @return 返回所有符合条件的数据
	 */
	public Page pagedQueryObject(String sql, final Object parameter, int pageNo, int pageSize);

	/**
	 * 分页查询多行多列数据，当pageNo <= 0或pageSize <= 0时返回所有符合条件的数据
	 *
	 * @param psql
	 *            含有参数的SQL
	 * @param args
	 * @param parameter
	 * @param pageNo
	 * @param pageSize
	 * @return 返回所有符合条件的数据
	 */
	public Page pagedQueryObject(String psql, Object[] args, final Object parameter, int pageNo, int pageSize);

	/**
	 * 查询多行多列数据，返回元素类型为Map的List
	 *
	 * @param sql
	 *            执行的静态SQL
	 * @return 返回元素类型为Map的List
	 */
	public List genericFindMap(String sql);

	/**
	 * 查询多行多列数据，返回元素类型为Map的List
	 *
	 * @param psql
	 *            含有参数的SQL
	 * @param args
	 * @return 返回元素类型为Map的List
	 */
	public List genericFindMap(String psql, Object[] args);

	/**
	 * 分页查询多行多列数据，当pageNo <= 0或pageSize <= 0时返回所有符合条件的数据
	 *
	 * @param sql
	 *            执行的静态SQL
	 * @param pageNo
	 * @param pageSize
	 * @return 返回所有符合条件的数据
	 */
	public Page pagedQueryMap(String sql, int pageNo, int pageSize);

	/**
	 * 分页查询多行多列数据，当pageNo <= 0或pageSize <= 0时返回所有符合条件的数据
	 *
	 * @param psql
	 *            含有参数的SQL
	 * @param args
	 * @param pageNo
	 * @param pageSize
	 * @return 返回所有符合条件的数据
	 */
	public Page pagedQueryMap(String psql, Object[] args, int pageNo, int pageSize);

	/**
	 * 查询单行多列数据，返回一个对象；数据不存在时返回null
	 *
	 * @param sql
	 *            执行的静态SQL
	 * @param parameter
	 * @return 返回所有符合条件的数据
	 */
	public Object genericFindRowObject(String sql, final Object parameter);

	/**
	 * 查询单行多列，返回一个对象；数据不存在时返回null
	 *
	 * @param psql
	 *            含有参数的SQL
	 * @param args
	 * @param parameter
	 * @return 返回所有符合条件的数据
	 */
	public Object genericFindRowObject(String psql, Object[] args, final Object parameter);

	/**
	 * 查询单行多列，返回一个Map
	 *
	 * @param sql
	 *            执行的静态SQL
	 * @return 返回所有符合条件的数据
	 */
	public Map genericFindRowMap(String sql);

	/**
	 * 查询单行多列，返回一个Map
	 *
	 * @param psql
	 *            含有参数的SQL
	 * @param args
	 * @return 返回所有符合条件的数据
	 */
	public Map genericFindRowMap(String psql, Object[] args);

	/**
	 * 查询多行单列数据
	 *
	 * @param sql
	 *            执行的静态SQL
	 * @param elementType
	 * @return 类型为elementType的对象List
	 */
	public List genericFindField(String sql, Class elementType);

	/**
	 * 查询多行单列数据
	 *
	 * @param psql
	 *            含有参数的SQL
	 * @param args
	 * @param elementType
	 * @return 类型为elementType的对象List
	 */
	public List genericFindField(String psql, Object[] args, Class elementType);

	/**
	 * 分页查询多行单列数据，当pageNo <= 0或pageSize <= 0时返回所有符合条件的数据
	 *
	 * @param sql
	 *            执行的静态SQL
	 * @param elementType
	 * @param pageNo
	 * @param pageSize
	 * @return 返回所有符合条件的数据
	 */
	public Page pagedQueryField(String sql, Class elementType, int pageNo, int pageSize);

	/**
	 * 分页查询多行单列数据，当pageNo <= 0或pageSize <= 0时返回所有符合条件的数据
	 *
	 * @param psql
	 *            含有参数的SQL
	 * @param args
	 * @param elementType
	 * @param pageNo
	 * @param pageSize
	 * @return 返回所有符合条件的数据
	 *
	 */
	public Page pagedQueryField(String psql, Object[] args, Class elementType, int pageNo, int pageSize);

	/**
	 * 查询单行单列
	 *
	 * @param sql
	 *            执行的静态SQL
	 * @return 返回所有符合条件的数据
	 */
	public Integer genericFindFieldInt(String sql);

	/**
	 * 查询单行单列
	 *
	 * @param psql
	 *            含有参数的SQL
	 * @param args
	 * @return 返回所有符合条件的数据
	 */
	public Integer genericFindFieldInt(String psql, Object[] args);

	/**
	 * 查询单行单列
	 *
	 * @param sql
	 *            执行的静态SQL
	 * @return 返回所有符合条件的数据
	 */
	public Long genericFindFieldLong(String sql);

	/**
	 * 查询单行单列
	 *
	 * @param psql
	 *            含有参数的SQL
	 * @param args
	 * @return 返回所有符合条件的数据
	 */
	public Long genericFindFieldLong(String psql, Object[] args);

	/**
	 * 查询单行单列
	 *
	 * @param sql
	 *            执行的静态SQL
	 * @param requiredType
	 * @return requiredType类型对象
	 */
	public Object genericFindFieldObject(String sql, Class requiredType);

	/**
	 * 查询单行单列
	 *
	 * @param psql
	 *            执行的静态SQL
	 * @param args
	 * @param requiredType
	 * @return requiredType类型对象
	 */
	public Object genericFindFieldObject(String psql, Object[] args, Class requiredType);

	// Update
	/**
	 * 更新
	 *
	 * @param sql
	 *            执行的静态SQL
	 * @return 影响的行记录数
	 */
	public int genericUpdate(String sql);

	/**
	 * 参数化sql更新
	 *
	 * @param psql
	 *            含有参数的SQL
	 * @param args
	 * @return 影响的行记录数
	 */
	public int genericUpdate(String psql, Object[] args);

	/**
	 * 参数化sql更新
	 *
	 * @param psql
	 *            含有参数的SQL
	 * @param args
	 *            参数值
	 * @param argTypes
	 *            参数类型
	 * @return 影响的行记录数
	 */
	public int genericUpdate(String psql, Object[] args, int[] argTypes);

	/**
	 * 批量更新
	 *
	 * @param sql
	 *            执行的静态SQL
	 * @return 影响的行记录数
	 */
	public int[] genericBatchUpdate(String[] sql);

	/**
	 * 参数化sql批量更新
	 *
	 * @param psql
	 *            含有参数的SQL
	 * @param args
	 * @return 影响的行记录数
	 */
	public int[] genericBatchUpdate(String psql, final List<Object[]> args);

	/**
	 * 执行单条SQL语句, 典型的是Create table,drop table等DDL语句.
	 *
	 * @param sql
	 *            执行的静态SQL
	 * @throws DataAccessException
	 *             如果失败，抛出DataException异常
	 */
	public void execute(final String sql);
}
