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

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.util.Assert;
import com.sitechasia.webx.core.dao.IJdbcDao;
import com.sitechasia.webx.core.support.Page;

/**
 * JdbcTemplate Dao的基类. 继承于Spring的<code>JdbcDaoSupport</code>,提供分页函数和若干便捷查询、更新方法.
 * @author
 * @version 1.2
 * @since JDK1.5
 */
public abstract class BaseTemplateDao extends JdbcDaoSupport implements IJdbcDao {
	/**
	 * 日志对象.
	 *
	 * 在子类中不必单独定义日志对象，直接使用这里生成的即可
	 * 如:logger.info(".....");
	 */
	protected final Logger logger = Logger.getLogger(getClass());
	/*
	 * 分页对象
	 */
	private IPageSqlProvider pageSqlProvider;
	/*
	 * null替换字符
	 */
	private String nullEscapeStr;

	public String getNullEscapeStr() {
		return nullEscapeStr;
	}

	public void setNullEscapeStr(String nullEscapeStr) {
		this.nullEscapeStr = nullEscapeStr;
	}

	public IPageSqlProvider getPageSqlProvider() {
		return pageSqlProvider;
	}

	public void setPageSqlProvider(IPageSqlProvider pageSqlProvider) {
		this.pageSqlProvider = pageSqlProvider;
	}

	/**
	 * 查询多行多列数据
	 *
	 * @param sql
	 *            执行的静态SQL
	 * @param parameter
	 * 			  查询的对象
	 * @return 对象List
	 */
	public List genericFindObject(String sql, final Object parameter) {
		Assert.hasText(sql);
		return this.getJdbcTemplate().query(sql, new RowMapper() {
			public Object mapRow(ResultSet rs, int index) throws SQLException {
				return mappingRow(rs, index, parameter);
			}
		});
	}

	/**
	 * 查询多行多列数据
	 *
	 * @param psql
	 *            含有参数的SQL
	 * @param args
	 * 			  查询参数值
	 * @param parameter
	 * 			  查询的对象
	 * @return 对象List
	 */
	public List genericFindObject(String psql, Object[] args, final Object parameter) {
		Assert.hasText(psql);
		return this.getJdbcTemplate().query(psql, checkArgs(args), new RowMapper() {
			public Object mapRow(ResultSet rs, int index) throws SQLException {
				return mappingRow(rs, index, parameter);
			}
		});
	}

	/**
	 * 分页查询多行多列数据，当pageNo <= 0或pageSize <= 0时返回所有符合条件的数据
	 *
	 * @param sql
	 *            执行的静态SQL
	 * @param parameter
	 * 			  查询的对象
	 * @param pageNo
	 *			  第几页
	 * @param pageSize
	 *            每页有多少行数据
	 * @return 返回所有符合条件的数据
	 */
	public Page pagedQueryObject(String sql, final Object parameter, int pageNo, int pageSize) {
		Assert.hasText(sql);
		// 不提供pageSqlProvider时，通过游标方式分页
		if (this.getPageSqlProvider() == null)
			return this.getCurrentPage(genericFindObject(sql, parameter), pageNo, pageSize);
		long count = this.genericFindFieldLong(getCountQuerySql(sql));
		List data;
		if (pageNo <= 0 || pageSize <= 0) {
			// 查询所有
			data = genericFindObject(sql, parameter);
			return new Page(0, count, (int) count, data);
		} else {
			int start = Page.getStartOfPage(pageNo, pageSize);
			data = genericFindObject(getPageSqlProvider().getPageSql(sql, start, pageSize), parameter);
			return new Page(start, count, pageSize, data);
		}
	}

	/**
	 * 分页查询多行多列数据，当pageNo <= 0或pageSize <= 0时返回所有符合条件的数据
	 *
	 * @param psql
	 *            含有参数的SQL
	 * @param args
	 * 			  查询参数值
	 * @param parameter
	 * 			  查询的对象
	 * @param pageNo
	 *			  第几页
	 * @param pageSize
	 *            每页有多少行数据
	 * @param pageSize
	 * @return 返回所有符合条件的数据
	 */
	public Page pagedQueryObject(String psql, Object[] args, final Object parameter, int pageNo, int pageSize) {
		Assert.hasText(psql);
		// 不提供pageSqlProvider时，通过游标方式分页
		if (this.getPageSqlProvider() == null)
			return this.getCurrentPage(genericFindObject(psql, args, parameter), pageNo, pageSize);
		long count = this.genericFindFieldLong(getCountQuerySql(psql), checkArgs(args));
		List data;
		if (pageNo <= 0 || pageSize <= 0) {
			// 查询所有
			data = genericFindObject(psql, args, parameter);
			return new Page(0, count, (int) count, data);
		} else {
			int start = Page.getStartOfPage(pageNo, pageSize);
			data = genericFindObject(getPageSqlProvider().getPageSql(psql, start, pageSize), args, parameter);
			return new Page(start, count, pageSize, data);
		}
	}

	/**
	 * 查询多行多列数据，返回元素类型为Map的List
	 *
	 * @param sql
	 *            执行的静态SQL
	 * @return 返回元素类型为Map的List
	 */
	public List genericFindMap(String sql) {
		Assert.hasText(sql);
		return this.getJdbcTemplate().queryForList(sql);
	}

	/**
	 * 查询多行多列数据，返回元素类型为Map的List
	 *
	 * @param psql
	 *            含有参数的SQL
	 * @param args
	 * @return 返回元素类型为Map的List
	 */
	public List genericFindMap(String psql, Object[] args) {
		Assert.hasText(psql);
		return this.getJdbcTemplate().queryForList(psql, checkArgs(args));
	}

	/**
	 * 分页查询多行多列数据，当pageNo <= 0或pageSize <= 0时返回所有符合条件的数据
	 *
	 * @param sql
	 *            执行的静态SQL
	 * @param pageNo
	 *			  第几页
	 * @param pageSize
	 *            每页有多少行数据
	 * @return 返回所有符合条件的数据
	 */
	public Page pagedQueryMap(String sql, int pageNo, int pageSize) {
		Assert.hasText(sql);
		// 不提供pageSqlProvider时，通过游标方式分页
		if (this.getPageSqlProvider() == null)
			return this.getCurrentPage(genericFindMap(sql), pageNo, pageSize);
		long count = this.genericFindFieldLong(getCountQuerySql(sql));
		List data;
		if (pageNo <= 0 || pageSize <= 0) {
			// 查询所有
			data = genericFindMap(sql);
			return new Page(0, count, (int) count, data);
		} else {
			int start = Page.getStartOfPage(pageNo, pageSize);
			data = genericFindMap(getPageSqlProvider().getPageSql(sql, start, pageSize));
			return new Page(start, count, pageSize, data);
		}
	}

	/**
	 * 分页查询多行多列数据，当pageNo <= 0或pageSize <= 0时返回所有符合条件的数据
	 *
	 * @param psql
	 *            含有参数的SQL
	 * @param args
	 * 			  查询参数值
	 * @param pageNo
	 *			  第几页
	 * @param pageSize
	 *            每页有多少行数据
	 * @return 返回所有符合条件的数据
	 */
	public Page pagedQueryMap(String psql, Object[] args, int pageNo, int pageSize) {
		Assert.hasText(psql);
		// 不提供pageSqlProvider时，通过游标方式分页
		if (this.getPageSqlProvider() == null)
			return this.getCurrentPage(genericFindMap(psql, args), pageNo, pageSize);
		long count = this.genericFindFieldLong(getCountQuerySql(psql), checkArgs(args));
		List data;
		if (pageNo <= 0 || pageSize <= 0) {
			// 查询所有
			data = genericFindMap(psql, args);
			return new Page(0, count, (int) count, data);
		} else {
			int start = Page.getStartOfPage(pageNo, pageSize);
			data = genericFindMap(getPageSqlProvider().getPageSql(psql, start, pageSize), args);
			return new Page(start, count, pageSize, data);
		}
	}

	/**
	 * 查询单行多列数据，返回一个对象；数据不存在时返回null
	 *
	 * @param sql
	 *            执行的静态SQL
	 * @param parameter
	 * 			  查询的对象
	 * @return 返回所有符合条件的数据
	 */
	public Object genericFindRowObject(String sql, final Object parameter) {
		Assert.hasText(sql);
		List re = this.genericFindObject(sql, parameter);
		if (re != null && re.size() > 0) {
			return re.get(0);
		} else {
			return null;
		}
		// return this.getJdbcTemplate().queryForObject(sql, rowMapper);
	}

	/**
	 * 查询单行多列，返回一个对象；数据不存在时返回null
	 *
	 * @param psql
	 *            含有参数的SQL
	 * @param args
	 * 			  查询参数值
	 * @param parameter
	 * 			  查询的对象
	 * @return 返回所有符合条件的数据
	 */
	public Object genericFindRowObject(String psql, Object[] args, final Object parameter) {
		Assert.hasText(psql);
		List re = this.genericFindObject(psql, args, parameter);
		if (re != null && re.size() > 0) {
			return re.get(0);
		} else {
			return null;
		}
		// return this.getJdbcTemplate().queryForObject(psql,args, rowMapper);
	}

	/**
	 * 查询单行多列，返回一个Map
	 *
	 * @param sql
	 *            执行的静态SQL
	 * @return 返回所有符合条件的数据
	 */
	public Map genericFindRowMap(String sql) {
		Assert.hasText(sql);
		return this.getJdbcTemplate().queryForMap(sql);
	}

	/**
	 * 查询单行多列，返回一个Map
	 *
	 * @param psql
	 *            含有参数的SQL
	 * @param args
	 * @return 返回所有符合条件的数据
	 */
	public Map genericFindRowMap(String psql, Object[] args) {
		Assert.hasText(psql);
		return this.getJdbcTemplate().queryForMap(psql, checkArgs(args));
	}

	/**
	 * 查询多行单列数据
	 *
	 * @param sql
	 *            执行的静态SQL
	 * @param elementType
	 * 			  查询的对象
	 * @return 类型为elementType的对象List
	 */
	public List genericFindField(String sql, Class elementType) {
		Assert.hasText(sql);
		return this.getJdbcTemplate().queryForList(sql, elementType);
	}

	/**
	 * 查询多行单列数据
	 *
	 * @param psql
	 *            含有参数的SQL
	 * @param args
	 * 			  查询参数值
	 * @param elementType
	 * 			  查询的对象
	 * @return 类型为elementType的对象List
	 */
	public List genericFindField(String psql, Object[] args, Class elementType) {
		Assert.hasText(psql);
		return this.getJdbcTemplate().queryForList(psql, checkArgs(args), elementType);
	}

	/**
	 * 分页查询多行单列数据，当pageNo <= 0或pageSize <= 0时返回所有符合条件的数据
	 *
	 * @param sql
	 *            执行的静态SQL
	 * @param elementType
	 * 			  查询的对象
	 * @param pageNo
	 *			  第几页
	 * @param pageSize
	 *            每页有多少行数据
	 * @return 返回所有符合条件的数据
	 */
	public Page pagedQueryField(String sql, Class elementType, int pageNo, int pageSize) {
		Assert.hasText(sql);
		// 不提供pageSqlProvider时，通过游标方式分页
		if (this.getPageSqlProvider() == null)
			return this.getCurrentPage(genericFindField(sql, elementType), pageNo, pageSize);
		long count = this.genericFindFieldLong(getCountQuerySql(sql));
		List data;
		if (pageNo <= 0 || pageSize <= 0) {
			// 查询所有
			data = genericFindField(sql, elementType);
			return new Page(0, count, (int) count, data);
		} else {
			int start = Page.getStartOfPage(pageNo, pageSize);
			data = genericFindField(getPageSqlProvider().getPageSql(sql, start, pageSize), elementType);
			return new Page(start, count, pageSize, data);
		}
	}

	/**
	 * 分页查询多行单列数据，当pageNo <= 0或pageSize <= 0时返回所有符合条件的数据
	 *
	 * @param psql
	 *            含有参数的SQL
	 * @param args
	 * 			  查询参数值
	 * @param elementType
	 * 			  查询的对象
	 * @param pageNo
	 *			  第几页
	 * @param pageSize
	 *            每页有多少行数据
	 * @return 返回所有符合条件的数据
	 *
	 */
	public Page pagedQueryField(String psql, Object[] args, Class elementType, int pageNo, int pageSize) {
		Assert.hasText(psql);
		// 不提供pageSqlProvider时，通过游标方式分页
		if (this.getPageSqlProvider() == null)
			return this.getCurrentPage(genericFindField(psql, args, elementType), pageNo, pageSize);
		long count = this.genericFindFieldLong(getCountQuerySql(psql), checkArgs(args));
		List data;
		if (pageNo <= 0 || pageSize <= 0) {
			// 查询所有
			data = genericFindField(psql, args, elementType);
			return new Page(0, count, (int) count, data);
		} else {
			int start = Page.getStartOfPage(pageNo, pageSize);
			data = genericFindField(getPageSqlProvider().getPageSql(psql, start, pageSize), args, elementType);
			return new Page(start, count, pageSize, data);
		}
	}

	/**
	 * 查询单行单列
	 *
	 * @param sql
	 *            执行的静态SQL
	 * @return 返回所有符合条件的数据
	 */
	public Integer genericFindFieldInt(String sql) {
		Assert.hasText(sql);
		return new Integer(this.getJdbcTemplate().queryForInt(sql));
	}

	/**
	 * 查询单行单列
	 *
	 * @param psql
	 *            含有参数的SQL
	 * @param args
	 * @return 返回所有符合条件的数据
	 */
	public Integer genericFindFieldInt(String psql, Object[] args) {
		Assert.hasText(psql);
		return new Integer(this.getJdbcTemplate().queryForInt(psql, checkArgs(args)));
	}

	/**
	 * 查询单行单列
	 *
	 * @param sql
	 *            执行的静态SQL
	 * @return 返回所有符合条件的数据
	 */
	public Long genericFindFieldLong(String sql) {
		Assert.hasText(sql);
		return new Long(this.getJdbcTemplate().queryForLong(sql));
	}

	/**
	 * 查询单行单列
	 *
	 * @param psql
	 *            含有参数的SQL
	 * @param args
	 * @return 返回所有符合条件的数据
	 */
	public Long genericFindFieldLong(String psql, Object[] args) {
		Assert.hasText(psql);
		return new Long(this.getJdbcTemplate().queryForLong(psql, checkArgs(args)));
	}

	/**
	 * 查询单行单列
	 *
	 * @param sql
	 *            执行的静态SQL
	 * @param requiredType
	 * @return requiredType类型对象
	 */
	public Object genericFindFieldObject(String sql, Class requiredType) {
		Assert.hasText(sql);
		List re = this.genericFindField(sql, requiredType);
		if (re != null && re.size() > 0) {
			return re.get(0);
		} else {
			return null;
		}
	}

	/**
	 * 查询单行单列
	 *
	 * @param psql
	 *            执行的静态SQL
	 * @param args
	 * @param requiredType
	 * @return requiredType类型对象
	 */
	public Object genericFindFieldObject(String psql, Object[] args, Class requiredType) {
		Assert.hasText(psql);
		List re = this.genericFindField(psql, args, requiredType);
		if (re != null && re.size() > 0) {
			return re.get(0);
		} else {
			return null;
		}
	}

	// Update
	/**
	 * 更新
	 *
	 * @param sql
	 *            执行的静态SQL
	 * @return 影响的行记录数
	 */
	public int genericUpdate(String sql) {
		Assert.hasText(sql);
		return this.getJdbcTemplate().update(sql);
	}

	/**
	 * 参数化sql更新
	 *
	 * @param psql
	 *            含有参数的SQL
	 * @param args
	 * @return 影响的行记录数
	 */
	public int genericUpdate(String psql, Object[] args) {
		Assert.hasText(psql);
		return this.getJdbcTemplate().update(psql, checkArgs(args));
	}

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
	public int genericUpdate(String psql, Object[] args, int[] argTypes) {
		Assert.hasText(psql);
		return this.getJdbcTemplate().update(psql, checkArgs(args), argTypes);
	}

	/**
	 * 批量更新
	 *
	 * @param sql
	 *            执行的静态SQL
	 * @return 影响的行记录数
	 */
	public int[] genericBatchUpdate(String[] sql) {
		return this.getJdbcTemplate().batchUpdate(sql);
	}

	/**
	 * 参数化sql批量更新
	 *
	 * @param psql
	 *            含有参数的SQL
	 * @param args
	 * @return 影响的行记录数
	 */
	public int[] genericBatchUpdate(String psql, final List<Object[]> args) {
		Assert.hasText(psql);
		return this.getJdbcTemplate().batchUpdate(psql, new BatchPreparedStatementSetter() {
			public int getBatchSize() {
				return args.size();
			}

			public void setValues(PreparedStatement ps, int index) throws SQLException {
				Object[] objs = checkArgs(args.get(index));
				for (int i = 0; i < objs.length; i++) {
					ps.setObject(i + 1, objs[i]);
				}
			}
		});
	}

	/**
	 * 执行单条SQL语句, 典型的是Create table,drop table等DDL语句.
	 *
	 * @param sql
	 *            执行的静态SQL
	 * @throws DataAccessException
	 *             如果失败，抛出DataException异常
	 */
	public void execute(final String sql) {
		Assert.hasText(sql);
		this.getJdbcTemplate().execute(sql);
	}

	/**
	 * 将数据库记录map为对象
	 *
	 * @param rs
	 * @param index
	 * @param parameter
	 *            传入参数， 如"前缀"、"后缀"等
	 * @return 返回所有符合条件的数据
	 * @throws SQLException
	 */
	protected abstract Object mappingRow(ResultSet rs, int index, Object parameter) throws SQLException;

	/**
	 * 去除sql的orderby 子句，用于pagedQuery.
	 */
	private String removeOrders(String sql) {
		Assert.hasText(sql);
		Pattern p = Pattern.compile("ORDER\\s*by[\\w|\\W|\\s|\\S]*", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(sql);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			m.appendReplacement(sb, "");
		}
		m.appendTail(sb);
		return sb.toString();
	}

	/**
	 * 去除sql的select 子句，不考虑union的情况，用于pagedQuery.
	 *
	 * @param sql
	 * @return String
	 */
	private String removeSelect(String sql) {
		Assert.hasText(sql);
		int beginPos = sql.toUpperCase().indexOf("FROM");
		Assert.isTrue(beginPos != -1, " sql : " + sql + " must has a keyword 'from'");
		return sql.substring(beginPos);
	}

	/**
	 * 得到计算count的sql语句(不考虑union的情况)
	 *
	 * @param sql
	 * @return String
	 */
	private String getCountQuerySql(String sql) {
		return " SELECT count(*) " + removeSelect(removeOrders(sql));
	}

	/**
	 * 检查参数化sql的参数值，如果设定了nullEscapeStr，则用nullEscapeStr替换其中的null值
	 *
	 * @param args
	 * @return 返回所有符合条件的数据
	 */
	private Object[] checkArgs(Object[] args) {
		// return args;
		if (nullEscapeStr != null) {
			if (args == null || args.length < 1) {
				Object[] re = {};
				return re;
			} else {
				Object[] re = new Object[args.length];
				for (int i = 0; i < args.length; i++) {
					re[i] = (args[i] == null) ? nullEscapeStr : args[i];
				}
				return re;
			}
		} else {
			return args;
		}
	}

	/**
	 * 游标方式得到分页对象
	 *
	 * @param all
	 * 			  一个结果集
	 * @param pageNo
	 *			  第几页
	 * @param pageSize
	 *            每页有多少行数据
	 * @return 游标方式得到分页对象
	 */
	@SuppressWarnings("unchecked")
	private Page getCurrentPage(List all, int pageNo, int pageSize) {
		List data = new ArrayList();
		int start = 0;
		if (pageNo <= 0 || pageSize <= 0) {
			start = 0;
			data = all;
		} else {
			start = Page.getStartOfPage(pageNo, pageSize);
			int end = (start + pageSize) > all.size() ? all.size() : (start + pageSize);
			for (int i = start; i < end; i++) {
				data.add(all.get(i));
			}
		}
		return new Page(start, all.size(), pageSize, data);
	}
}
