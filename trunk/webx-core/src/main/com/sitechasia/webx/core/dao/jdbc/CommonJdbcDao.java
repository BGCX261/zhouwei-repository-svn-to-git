/** 
 * @{#} CommonJdbcDao.java Create on 2008-5-23 下午01:28:23   
 *   
 * Copyright (c) 2006- by CE.   
 */
package com.sitechasia.webx.core.dao.jdbc;

import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.util.Assert;

/**
 * 通用JDBC DAO接口
 * <p>
 * 由于各种数据库的分页语句都有所不同，所以这个DAO的方法中不再提供分页参数。
 * @author MarkDong
 * @version 1.5
 * @see CommonHibernateDao
 */
public class CommonJdbcDao extends JdbcDaoSupport {

	/**
	 * 执行一条SQL语句。例如：insert, update or delete
	 * 
	 * @param sql SQL语句
	 * @return 受影响的行数
	 */
	public int update(String sql) {
		return this.getJdbcTemplate().update(sql);
	}

	/**
	 * 执行一条SQL语句，通常用它来执行DDL statement，即数据库管理SQL语句。 例如建表，建索引等。
	 * 
	 * @param sql SQL语句
	 */
	public void execute(String sql) {
		this.getJdbcTemplate().execute(sql);
	}
	
	/**
	 * 批量执行SQL语句
	 * 
	 * @param sqls sql语句数组
	 * @return 按sql语句顺序返回的顺序结果
	 */
	public int[] batchUpdate(String[] sqls) {
		return this.getJdbcTemplate().batchUpdate(sqls);
	}
	
	/**
	 * 根据SQL语句进行查询 
	 * 
	 * @param sql sql语句
	 * @param args 查询参数
	 * @return 结果列表，每个节点是个Map，其中按字段名作为key值，字段值作为value。
	 */
	@SuppressWarnings("unchecked")
	public List listBySql(String sql, Object... args) {
		return this.getJdbcTemplate().queryForList(sql, args);
	}
	
	public Integer queryForInt(String sql) {
		Assert.hasText(sql);
		return new Integer(this.getJdbcTemplate().queryForInt(sql));
	}
	
	public Integer queryForInt(String sql, Object[] args) {
		Assert.hasText(sql);
		return new Integer(this.getJdbcTemplate().queryForInt(sql, args));
	}
	
	public Long queryForLong(String sql) {
		Assert.hasText(sql);
		return new Long(this.getJdbcTemplate().queryForLong(sql));
	}
	
	public Long queryForLong(String sql, Object[] args) {
		Assert.hasText(sql);
		return new Long(this.getJdbcTemplate().queryForLong(sql, args));
	}
}
