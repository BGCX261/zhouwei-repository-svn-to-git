/**
 * @{#} BaseJdbcDomainDao.java Create on 2008-6-5 下午04:50:30
 *
 * Copyright (c) 2006- by CE.
 */
package com.sitechasia.webx.core.dao.jdbc;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.sitechasia.webx.core.dao.IDomainDao;
import com.sitechasia.webx.core.model.IDomainObject;
import com.sitechasia.webx.core.page.Pagination;
import com.sitechasia.webx.core.page.QueryResult;
import com.sitechasia.webx.core.utils.base.GenericsUtils;

/**
 * 基于纯JDBC的DomainDao基础实现类
 * <p>
 * 该方法利用反射机制及命名规约将结果集转换为域对象。由于利用了反射机制，所以从效率上讲还是不如纯
 * JDBC的实现。从针对域对象的持久化技术上讲，也肯定不如Hibernate更方便灵活。这一实现方式只是纯
 * JDBC实现和Hibernate实现的一个折中，请酌情使用。
 *
 * @author sunzhengying
 * @version 1.5
 * @see IDomainDao, BaseHibernateDomainDao
 */
public class BaseJdbcDomainDao<D extends IDomainObject> extends JdbcDaoSupport
		implements IDomainDao<D> {
	/**
	 * 用于得到实体对象的类信息成员信息
	 */
	ObjectMapper objectMapper;

	/**
	 * 用于记录日志
	 */
	protected final Logger logger = Logger.getLogger(getClass());

	/**
	 * 得到分页的sql语句
	 */
	IPageSqlProvider pageSqlProvider;// 在Spring.xml文件内注入

	/**
	 * 是否缓存实体对象
	 */
	boolean cached = false;

	/**
	 * id与实体对象的Map
	 */
	Map<Serializable, D> keyEntityMap = new HashMap<Serializable, D>();

	public BaseJdbcDomainDao() {
		try {
			objectMapper = new ObjectMapper(GenericsUtils.getGenericClass(this
					.getClass()));
		} catch (Exception e) {
			logger.info(e.getMessage());
			throw new RuntimeException(e);
		}
	}

	/**
	 * 返回表中所有记录的总数
	 *
	 * @author Sunzhenying
	 * @return 所有记录数
	 * @see com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#countAll()
	 */
	public long countAll() {
		String selectAll = getCountAll();
		long count = this.getJdbcTemplate().queryForLong(selectAll);
		return count;
	}

	/**
	 *
	 * 方法说明：得到一个表所有记录个数的查询语句
	 *
	 * @author Sunzhenying
	 * @return 返回一个select语句
	 * @see #countByField(String field, Object value)
	 */
	private String getCountAll() {
		String selectAll = "select count(*) from "
				+ objectMapper.getTableName();
		return selectAll;
	}

	/**
	 *
	 * 方法说明：得到一个表的所有记录的查询语句
	 *
	 * @author Sunzhenying
	 * @return 返回select查询语句
	 * @see #getCountByField(String field)
	 */
	private String getSelectAll() {
		String selectAll = "select * from " + objectMapper.getTableName();
		return selectAll;
	}

	/**
	 * 根据字段名称及字段值统计记录数,即,从数据库中得到满足字段field和值value条件的记录总数
	 *
	 * @author Sunzhenying
	 * @param field
	 *            字段名称
	 * @param value
	 *            字段值
	 * @return 记录数
	 * @see com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#countByField(String
	 *      field, Object value)
	 */
	public long countByField(String field, Object value) {
		String selectByField = getCountByField(field);
		long count = this.getJdbcTemplate().queryForLong(selectByField,
				new Object[] { value });
		return count;
	}

	/**
	 *
	 * 方法说明：根据字段field得到select查询语句
	 *
	 * @author Sunzhenying
	 * @param field
	 * @return 返回select查询语句
	 * @see #getCountAll()
	 */
	private String getCountByField(String field) {
		String selectByField = "select count(*) from "
				+ objectMapper.getTableName() + " where " + field + " = ?";
		return selectByField;
	}

	/**
	 *
	 * 方法说明：根据field得到一个select查询语句
	 *
	 * @author Sunzhenying
	 * @param field
	 * @return 返回一个select查询语句
	 * @see #getSelectAll()
	 */
	private String getSelectByField(String field) {
		String selectByField = "select * from " + objectMapper.getTableName()
				+ " where " + field + " = ?";
		return selectByField;
	}

	/**
	 * 根据字段field和其值value得到满足条件的记录总数，只支持字符串型字段。
	 *
	 * @author Sunzhenying
	 * @param field
	 *            字段名
	 * @param value
	 *            字段值
	 * @return 记录数
	 * @see com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#countByFieldLike(String
	 *      field, String value)
	 */
	public long countByFieldLike(String field, String value) {
		String selectByFieldLike = getCountByFieldLike(field);
		value = "%" + value + "%";
		long count = this.getJdbcTemplate().queryForLong(selectByFieldLike,
				new Object[] { value });
		return count;
	}

	/**
	 *
	 * 方法说明：得到一个表的select查询语句
	 *
	 * @author Sunzhenying
	 * @param field
	 * @return 返回一个select查询语句
	 * @see #getCountByField(String field)
	 */
	private String getCountByFieldLike(String field) {
		String selectByFieldLike = "select count(*) from "
				+ objectMapper.getTableName() + " where " + field + " like ?";
		return selectByFieldLike;
	}

	/**
	 *
	 * 方法说明：得到从一个列构造的select查询语句
	 *
	 * @author Sunzhenying
	 * @param field
	 * @return 返回一个select查询语句
	 * @see #getSelectByField(String field)
	 */
	private String getSelectByFieldLike(String field) {
		String selectByFieldLike = "select * from "
				+ objectMapper.getTableName() + " where " + field + " like ?";
		return selectByFieldLike;
	}

	/**
	 * 根据字段数组fields和其值values，得到满足条件的记录总数
	 */
	/**
	 * 根据字段名称及字段值的数组统计记录数,即:根据字段数组fields和其值values，得到满足条件的记录总数
	 *
	 * @author Sunzhenying
	 * @param fields
	 *            字段名称数组
	 * @param values
	 *            字段值数组
	 * @return 记录数
	 * @see com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#countByFields(String[]
	 *      fields, Object[] values)
	 */
	public long countByFields(String[] fields, Object[] values) {
		String selectSql = getCountByFields(fields);
		return getJdbcTemplate().queryForLong(selectSql, values);
	}

	/**
	 *
	 * 方法说明：根据几个列构造select查询语句
	 *
	 * @author Sunzhenying
	 * @param fields
	 * @return 返回一个select查询语句
	 * @see #getCountByField(String field)
	 */
	private String getCountByFields(String[] fields) {
		String countByFields = "select count(*) from "
				+ objectMapper.getTableName() + " where ";
		for (int i = 0; i < fields.length; i++) {
			if (i == (fields.length - 1)) {
				countByFields = countByFields + fields[i] + "=? ";
			} else {
				countByFields = countByFields + fields[i] + "=? and ";
			}
		}
		return countByFields;
	}

	/**
	 *
	 * 方法说明：根据字段数组fields得到一个查询语句
	 *
	 * @author Sunzhenying
	 * @param fields
	 * @return 返回一个select语句
	 * @see #getSelectByField(String field)
	 */
	private String getSelectByFields(String[] fields) {
		String countByFields = "select * from " + objectMapper.getTableName()
				+ " where ";
		for (int i = 0; i < fields.length; i++) {
			if (i == (fields.length - 1)) {
				countByFields = countByFields + fields[i] + "=? ";
			} else {
				countByFields = countByFields + fields[i] + "=? and ";
			}
		}
		return countByFields;
	}

	/**
	 * 根据字段名及字段值数组做Like统计，只支持字符串型字段。
	 *
	 * @author Sunzhenying
	 * @param fields
	 *            字段名数组
	 * @param values
	 *            字段值数组
	 * @return 记录数
	 * @see com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#countByFieldsLike(String[]
	 *      fields, String[] values)
	 */
	public long countByFieldsLike(String[] fields, String[] values) {
		String selectSql = getCountByFieldsLike(fields);
		String[] newValues = new String[values.length];
		for(int i=0; i<values.length; i++) {
			String value = "%" + values[i] + "%";
			newValues[i] = value;
		}
		// values数组的每个元素都要加入一个%
		return getJdbcTemplate().queryForLong(selectSql, newValues);
	}

	/**
	 *
	 * 方法说明：根据几个字段构造一个select查询语句
	 *
	 * @author Sunzhenying
	 * @param fields
	 * @return 返回一个select查询语句
	 * @see #getSelectByFieldLike(String field)
	 */
	private String getCountByFieldsLike(String[] fields) {
		String countByFieldsLike = "select count(*) from "
				+ objectMapper.getTableName() + " where ";
		for (int i = 0; i < fields.length; i++) {
			if (i == (fields.length - 1)) {
				countByFieldsLike = countByFieldsLike + fields[i] + " like ? ";
			} else {
				countByFieldsLike = countByFieldsLike + fields[i]
						+ " like ? and ";
			}
		}
		return countByFieldsLike;
	}

	/**
	 *
	 * 方法说明：根据几个字段构造一个select查询语句
	 *
	 * @author Sunzhenying
	 * @param fields
	 * @return 返回一个查询语句
	 * @see #getSelectByFieldLike(String field)
	 */
	private String getSelectByFieldsLike(String[] fields) {
		String countByFieldsLike = "select * from "
				+ objectMapper.getTableName() + " where ";
		for (int i = 0; i < fields.length; i++) {
			if (i == (fields.length - 1)) {
				countByFieldsLike = countByFieldsLike + fields[i] + " like ? ";
			} else {
				countByFieldsLike = countByFieldsLike + fields[i]
						+ " like ? and ";
			}
		}
		return countByFieldsLike;
	}

	/**
	 * 统计符合查询语句的记录数
	 * <p>
	 * 根据给定的查询语句ql和对应的值args得到数据库中满足条件的记录总数 参数的传递采用可变参数args，参数类型必须和字段类型相匹配。
	 * 可用如下四种方法调用：
	 * <ul>
	 * <li>dao.countByQl(ql);
	 * <li> dao.countByQl(ql, arg0);
	 * <li> dao.countByQl(ql, arg0, arg1);
	 * <li> dao.countByQl(ql, new Object[]{arg0, arg1, arg2});
	 * </ul>
	 *
	 * @author Sunzhenying
	 * @param ql
	 *            查询语句
	 * @param args
	 *            参数列表
	 * @return 记录数
	 * @see com.sitechasia.webx.core.dao.hibernate3.countByQl(String ql,
	 *      Object... args)
	 */
	public long countByQl(String ql, Object... args) {
		return getJdbcTemplate().queryForLong(ql, args);
	}

	/**
	 * 删除域对象。从数据库删除一个对象obj
	 *
	 * @author Sunzhenying
	 * @param obj
	 *            待删除对象
	 * @see com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#delete(IDomainObject
	 *      obj)
	 */
	public void delete(IDomainObject obj) {
		checkClass(obj);
		if (obj == null) {
			return;
		}
		Method getIdMethod=objectMapper.getGetIdMethod();
		Serializable id=(Serializable)objectMapper.executeGetMethod(obj,getIdMethod);
		deleteById(id);
	}

	/**
	 * 根据主键删除域对象,从数据库删除一个主键为id的数据库记录
	 *
	 * @author Sunzhenying
	 * @param id
	 *            主键
	 * @see com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#deleteById(Serializable
	 *      id)
	 */
	public void deleteById(Serializable id) {
		if (id == null) {
			logger.info("Serializable id must not be null");
			throw new InvalidDataAccessApiUsageException(
					"Serializable id must not be null");
		}
		getJdbcTemplate().update(
				"delete from " + objectMapper.getTableName() + " where id= ?",
				new Object[] { id });
		keyEntityMap.remove(id);
	}

	/**
	 * 根据主键数组删除所有域对象,从数据库删除一组记录，他们的主键是ids
	 *
	 * @author Sunzhenying
	 * @param ids
	 *            主键数组
	 * @see com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#deleteByIds(Serializable[]
	 *      ids)
	 */
	public void deleteByIds(Serializable[] ids) {
		String deleteSql = getDeleteSqlByIds(ids);
		getJdbcTemplate().update(deleteSql, ids);
		for(int i=0;i<ids.length;i++){
			keyEntityMap.remove(ids[i]);
		}
	}

	/**
	 *
	 * 方法说明：根据几个主键的值构造一个delete删除语句
	 *
	 * @author Sunzhenying
	 * @param ids
	 * @return 返回一个delete删除语句
	 * @see #deleteByIds(Serializable[] ids)
	 */
	private String getDeleteSqlByIds(Serializable[] ids) {
		String deleteSqlByIds = "delete from " + objectMapper.getTableName()
				+ " where id=";
		for (int i = 0; i < ids.length; i++) {
			if (i == 0) {
				deleteSqlByIds = deleteSqlByIds + "  ? ";
			} else if (i == ids.length - 1) {
				deleteSqlByIds = deleteSqlByIds + " or id= ? ";
			} else {
				deleteSqlByIds = deleteSqlByIds + " or id= ? or ";
			}
		}
		return deleteSqlByIds;
	}

	/**
	 * 获取全部对象。对于记录量大的表请谨慎使用。
	 *
	 * @param pageSize
	 *            页面记录数
	 * @param pageNum
	 *            页号，从1开始
	 * @return 结果集
	 * @see com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#findAll(int
	 *      pageSize, int pageNum)
	 */
	public QueryResult<D> findAll(int pageSize, int pageNum) {
		long totalCount = countAll();

		String selectSql = getSelectAll();

		selectSql = pageSqlProvider.getPageSql(selectSql, (pageNum - 1)
				* pageSize, pageSize);// 得到sql语句
		List<D> list = getQueryList(selectSql);

		return consturctQueryResult(list, totalCount, pageSize, pageNum);
	}

	/**
	 * 根据selectSql得到从数据库的查询结果
	 *
	 * @param selectSql
	 * @return 返回一个List<D>对象
	 * @see #getQueryList(String selectSql, Object[] values)
	 */
	@SuppressWarnings("unchecked")
	private List<D> getQueryList(String selectSql) {
		if (selectSql == null)
			return null;
		List<D> queryList = (List<D>) this.getJdbcTemplate().execute(selectSql,
				new PreparedStatementCallback() {
					public Object doInPreparedStatement(
							PreparedStatement preparedstatement)
							throws SQLException, DataAccessException {
						ResultSet rs = null;
						rs = preparedstatement.executeQuery();
						List<D> list = null;
						try {
							list = (List<D>) BaseJdbcDomainDao.this
									.getObjectMapper().parseResultSet(rs);
						} catch (Exception e) {
							logger.info(e.getMessage());
							throw new RuntimeException(e);
						}

						return list;
					}
				});
		return queryList;
	}

	/**
	 * 根据selectSql,values得到从数据库的查询结果
	 *
	 * @param selectSql
	 * @return 结果集的每个元素转化为一个实体对象
	 * @see #getQueryList(String selectSql)
	 */
	@SuppressWarnings("unchecked")
	private List<D> getQueryList(String selectSql, Object[] values) {
		if (selectSql == null)
			return null;
		Object o = getJdbcTemplate().query(selectSql, values,
				new ResultSetExtractor() {
					public Object extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						List<D> list = null;
						try {
							list = (List<D>) BaseJdbcDomainDao.this
									.getObjectMapper().parseResultSet(rs);
						} catch (Exception e) {
							logger.info(e.getMessage());
							throw new RuntimeException(e);
						}

						return list;
					}
				});
		return (List<D>) o;
	}

	/**
	 * 根据selectSql,value得到从数据库的查询结果
	 *
	 * @param selectSql
	 * @return 结果集的每个元素转化为一个实体对象
	 * @see #getQueryList(String selectSql, Object[] values)
	 */
	private List<D> getQueryList(String selectSql, Object value) {
		if (selectSql == null)
			return null;
		return getQueryList(selectSql, new Object[] { value });
	}

	/**
	 * 构造一个QueryResult
	 *
	 * @param list
	 * @param totalCount
	 * @param pageSize
	 * @param pageNum
	 * @return 返回一个QueryResult的实力
	 * @see #com.sitechasia.webx.core.page.QueryResult
	 */
	private QueryResult<D> consturctQueryResult(List<D> list, long totalCount,
			int pageSize, int pageNum) {
		QueryResult<D> queryResult = new QueryResult<D>();
		queryResult.setPaged(true);
		Pagination pagination = new Pagination();
		pagination.setRowCount(totalCount);
		pagination.setPageCount(totalCount / pageSize + 1);
		pagination.setPageNum(pageNum);
		pagination.setPageSize(pageSize);
		pagination.setPageBeginIdx((pageNum - 1) * pageSize);// 当前页第一条记录的偏移量
		queryResult.setPagination(pagination);
		queryResult.setResults(list);
		return queryResult;
	}

	/**
	 * 根据单字段获取对象。
	 * <p>
	 * 取得字段值等于指定值的对象列表。
	 *
	 * @author Sunzhenying
	 * @param field
	 *            字段名称
	 * @param value
	 *            指定值
	 * @param pageSize
	 *            页面记录数
	 * @param pageNum
	 *            页号，从1开始
	 * @return 结果集
	 * @see com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#findByField(String
	 *      field, Object value, int pageSize,int pageNum)
	 */
	public QueryResult<D> findByField(String field, Object value, int pageSize,
			int pageNum) {
		long totalCount = countByField(field, value);
		List<D> list = listByField(field, value, pageSize, pageNum);
		return consturctQueryResult(list, totalCount, pageSize, pageNum);
	}

	/**
	 * 以Like AnyWhere的方式对单一字段查询。只支持字符串型字段。
	 *
	 * @author Sunzhenying
	 * @param field
	 *            字段名称
	 * @param value
	 *            值
	 * @param pageSize
	 *            页面记录数
	 * @param pageNum
	 *            页号，从1开始
	 * @return 结果集
	 * @see com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#findByFieldLike(String
	 *      field, String value,int pageSize, int pageNum)
	 */
	public QueryResult<D> findByFieldLike(String field, String value,
			int pageSize, int pageNum) {
		long totalCount = countByFieldLike(field, (String) value);
		List<D> list = listByFieldLike(field, (String) value, pageSize, pageNum);
		return consturctQueryResult(list, totalCount, pageSize, pageNum);
	}

	/**
	 * 根据多字段获取对象。 取得所有字段值都等于指定值的对象列表。
	 *
	 * @author Sunzhenying
	 * @param fields
	 *            字段名称数组
	 * @param values
	 *            查询值数组。要跟字段名称顺序一致。
	 * @param pageSize
	 *            页面记录数
	 * @param pageNum
	 *            页号，从1开始
	 * @return 结果集
	 * @see com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#(String[]
	 *      fields, Object[] values,int pageSize, int pageNum)
	 */
	public QueryResult<D> findByFields(String[] fields, Object[] values,
			int pageSize, int pageNum) {
		long totalCount = countByFields(fields, values);
		List<D> list = listByFields(fields, values, pageSize, pageNum);
		return consturctQueryResult(list, totalCount, pageSize, pageNum);
	}

	/**
	 * 以Like AnyWhere的方式对字段组合查询。只支持字符串型字段。
	 *
	 * @author Sunzhenying
	 * @param fields
	 *            字段名称数组
	 * @param values
	 *            值数组
	 * @param pageSize
	 *            页面记录数
	 * @param pageNum
	 *            页号，从1开始
	 * @return 结果集
	 * @see com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#findByFieldsLike(String[]
	 *      fields, String[] values,int pageSize, int pageNum)
	 */
	public QueryResult<D> findByFieldsLike(String[] fields, String[] values,
			int pageSize, int pageNum) {
		if (values == null)
			return null;
		long totalCount = countByFieldsLike(fields, values);
		List<D> list = listByFieldsLike(fields, values, pageSize, pageNum);
		return consturctQueryResult(list, totalCount, pageSize, pageNum);
	}

	/**
	 * 根据主键的值查询实体对象
	 *
	 * @author Sunzhenying
	 * @param id
	 *            主键
	 * @return 该主键对应的记录。如果不存在该主键，返回null
	 * @see com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#findById(Serializable
	 *      id)
	 */
	public D get(Serializable id) {
		String sql = getSelectByField("id");
		return findById(sql, id);
	}

	/**
	 * 根据主键取得记录
	 *
	 * @author Sunzhenying
	 * @param id
	 *            主键
	 * @return 该主键对应的记录代理类实例。如果开启了缓存,则先在缓存中查询.如果不存在该主键，抛出ObjectNotFoundException异常
	 */
	public D load(Serializable id) {
		D d;
		if (cached) {
			d = keyEntityMap.get(id);
			if (d == null) {
				d=get(id);
				if(d==null){
					logger.info("该对象不存在");
					throw new RuntimeException("该对象不存在");
				}else{
					return d;
				}
			} else {
				return d;
			}
		} else {
			d=get(id);
			if(d==null){
				logger.info("该对象不存在");
				throw new RuntimeException("该对象不存在");
			}else{
				return d;
			}
		}
	}

	/**
	 * 根据主键取得记录
	 *
	 * @author Sunzhenying
	 * @param id
	 *            主键
	 * @return 该主键对应的记录。如果不存在该主键，返回null
	 * @see #findById(Serializable id)
	 */
	private D findById(String sql, Serializable id) {
		String selectSql = getSelectByField("id");
		List<D> list = getQueryList(selectSql, id);
		if ((list != null) && (list.size() > 0)) {
			D d = (D) list.get(0);
			keyEntityMap.put(id, d);
			return d;
		} else {
			return null;
		}
	}

	/**
	 * 根据查询语句获取对象。
	 * <p>
	 * 此方法支持采用占位符形式的查询语句，对于查询语句建议使用占位符形式，可有效
	 * 避免SQL注入漏洞。参数的传递采用可变参数args，参数类型必须和字段类型相匹配。 可用如下四种方法调用：
	 * <ul>
	 * <li>dao.findByQl(ql, pageSize, pageNum);
	 * <li> dao.findByQl(ql, pageSize, pageNum, arg0);
	 * <li> dao.findByQl(ql, pageSize, pageNum, arg0, arg1);
	 * <li> dao.findByQl(ql, pageSize, pageNum, new Object[]{arg0, arg1, arg2});
	 * </ul>
	 *
	 * @author Sunzhenying
	 * @param ql
	 *            查询语句
	 * @param pageSize
	 *            页面记录数
	 * @param pageNum
	 *            页号，从1开始
	 * @param args
	 *            查询参数列表
	 * @return 结果集
	 * @see com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#findByQL(String
	 *      ql, int pageSize, int pageNum,Object... args)
	 */
	public QueryResult<D> findByQL(String ql, int pageSize, int pageNum,
			Object... args) {
		String selectSql = pageSqlProvider.getPageSql(ql, (pageNum - 1)
				* pageSize, pageSize);// 得到sql语句
		List<D> list = getQueryList(selectSql, args);
		String temp = ql.toLowerCase();
		String selectCount = "select count(*) from "
				+ temp.substring(temp.indexOf("from") + 4);
		long totalCount = getJdbcTemplate().queryForLong(selectCount, args);
		return consturctQueryResult(list, totalCount, pageSize, pageNum);
	}

	/**
	 * 判断数据库中是否已经存在指定字段列表的值的记录。
	 *
	 * @author Sunzhenying
	 * @param obj
	 *            域对象
	 * @param fields
	 *            逗号分割的属性列表，例如"username, password"
	 * @return
	 * @see com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#isExist(IDomainObject
	 *      obj, String fields)
	 */
	public boolean isExist(IDomainObject obj, String fields) {
		String[] nameList = fields.split(",");
		for(String name:nameList){
			try {
				List list = this.listByField(name,PropertyUtils.getProperty(obj, name),0,0);
				if(list!=null&&list.size()>0){
					return true;
				}
			} catch (IllegalAccessException e) {
				logger.error("Error when reflection on entity", e);
				return false;
			} catch (InvocationTargetException e) {
				logger.error("Error when reflection on entity", e);
				return false;
			} catch (NoSuchMethodException e) {
				logger.error("Error when reflection on entity", e);
				return false;
			}
		}

		return false;
	}

	/**
	 * 从数据库得到某页的所有记录。对于记录量大的表请谨慎使用。
	 *
	 * @param pageSize
	 *            页面记录数
	 * @param pageNum
	 *            页号，从1开始
	 * @return 结果集
	 * @see com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#listAll(int
	 *      pageSize, int pageNum)
	 */
	public List<D> listAll(int pageSize, int pageNum) {// 做一个返回List<D>的方法
		String selectSql = getSelectAll();
		selectSql = pageSqlProvider.getPageSql(selectSql, (pageNum - 1)
				* pageSize, pageSize);// 得到sql语句
		return getQueryList(selectSql);
	}

	/**
	 * 根据单字段获取对象。
	 * <p>
	 * 取得字段值等于指定值的对象列表。
	 *
	 * @author Sunzhenying
	 * @param field
	 *            字段名称
	 * @param value
	 *            指定值
	 * @param pageSize
	 *            页面记录数
	 * @param pageNum
	 *            页号，从1开始
	 * @return 结果集
	 * @see com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#listByField(String
	 *      field, Object value, int pageSize,int pageNum)
	 */
	public List<D> listByField(String field, Object value, int pageSize,
			int pageNum) {
		String sqlSelect = "select * from " + objectMapper.getTableName()
				+ " where " + field + "=?";
		sqlSelect = pageSqlProvider.getPageSql(sqlSelect, (pageNum - 1)
				* pageSize, pageSize);// 得到sql语句
		List<D> list = (List<D>) getQueryList(sqlSelect, value);
		return list;
	}

	/**
	 * 以Like AnyWhere的方式对单一字段查询。只支持字符串型字段。
	 *
	 * @author Sunzhenying
	 * @param field
	 *            字段名称
	 * @param value
	 *            值
	 * @param pageSize
	 *            页面记录数
	 * @param pageNum
	 *            页号，从1开始
	 * @return 结果集
	 * @see com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#listByFieldLike(String
	 *      field, String value, int pageSize,int pageNum)
	 */
	public List<D> listByFieldLike(String field, String value, int pageSize,
			int pageNum) {
		String selectSql = getSelectByFieldLike(field);
		selectSql = pageSqlProvider.getPageSql(selectSql, (pageNum - 1)
				* pageSize, pageSize);// 得到sql语句
		value = "%" + value + "%";
		List<D> list = (List<D>) getQueryList(selectSql, value);
		return list;
	}

	/**
	 * 根据多字段获取对象。 取得所有字段值都等于指定值的对象列表。
	 *
	 * @author Sunzhenying
	 * @param fields
	 *            字段名称数组
	 * @param values
	 *            查询值数组。要跟字段名称顺序一致。
	 * @param pageSize
	 *            页面记录数
	 * @param pageNum
	 *            页号，从1开始
	 * @return 结果集
	 * @see com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#listByFields(String[]
	 *      fields, Object[] values, int pageSize,int pageNum)
	 */
	public List<D> listByFields(String[] fields, Object[] values, int pageSize,
			int pageNum) {
		String selectSql = getSelectByFields(fields);
		selectSql = pageSqlProvider.getPageSql(selectSql, (pageNum - 1)
				* pageSize, pageSize);// 得到sql语句

		List<D> list = (List<D>) getQueryList(selectSql, values);
		return list;
	}

	/**
	 * 以Like AnyWhere的方式对字段组合查询。只支持字符串型字段。
	 *
	 * @author Sunzhenying
	 * @param fields
	 *            字段名称数组
	 * @param values
	 *            值数组
	 * @param pageSize
	 *            页面记录数
	 * @param pageNum
	 *            页号，从1开始
	 * @return 结果集
	 * @see com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#listByFieldsLike(String[]
	 *      fields, String[] values,int pageSize, int pageNum)
	 */
	public List<D> listByFieldsLike(String[] fields, String[] values,
			int pageSize, int pageNum) {
		String[] newValues = new String[values.length];
		for (int i = 0; i < values.length; i++) {
			newValues[i] = "%" + values[i] + "%";
		}
		String selectSql = getSelectByFieldsLike(fields);
		selectSql = pageSqlProvider.getPageSql(selectSql, (pageNum - 1)
				* pageSize, pageSize);// 得到sql语句
		List<D> list = (List<D>) getQueryList(selectSql, newValues);
		return list;
	}

	/**
	 * 根据查询语句获取对象。
	 * <p>
	 * 参数的传递采用可变参数args，参数类型必须和字段类型相匹配。 可用如下四种方法调用：
	 * <ul>
	 * <li>dao.listByQl(ql, pageSize, pageNum);
	 * <li> dao.listByQl(ql, pageSize, pageNum, arg0);
	 * <li> dao.listByQl(ql, pageSize, pageNum, arg0, arg1);
	 * <li> dao.listByQl(ql, pageSize, pageNum, new Object[]{arg0, arg1, arg2});
	 * </ul>
	 *
	 * @author Sunzhenying
	 * @param ql
	 *            查询语句
	 * @param pageSize
	 *            页面记录数
	 * @param pageNum
	 *            页号，从1开始
	 * @param args
	 *            查询参数列表
	 * @return 结果集
	 * @see com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#listByQL(String
	 *      ql, int pageSize, int pageNum,Object... args)
	 */
	public List<D> listByQL(String ql, int pageSize, int pageNum,
			Object... args) {
		String selectSql = pageSqlProvider.getPageSql(ql, (pageNum - 1)
				* pageSize, pageSize);// 得到sql语句
		List<D> list = (List<D>) getQueryList(selectSql, args);
		return list;
	}

	/**
	 * 添加域对象。将一个实体对象obj保存到数据库
	 *
	 * @param obj
	 *            域对象
	 * @see com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#save(IDomainObject
	 *      obj)
	 */
	public void save(IDomainObject obj) {
		checkClass(obj);
		String insertSql = this.getObjectMapper().getInsertSql();
		Method[] ms = getObjectMapper().getGetMethods();
		Object[] os = new Object[ms.length];
		for (int i = 0; i < ms.length; i++) {
			os[i] = getObjectMapper().executeGetMethod(obj, ms[i]);
		}
		// 根据insertSql和os[]执行插入语句
		getJdbcTemplate().update(insertSql, os);
	}

	/**
	 * 将一个对象obj保存到数据库，如果已经存在，就执行更新操作
	 *
	 * @author Sunzhenying
	 * @param obj
	 *            域对象
	 * @see com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#saveOrUpdate(IDomainObject
	 *      obj)
	 */
	public void saveOrUpdate(IDomainObject obj) {
		checkClass(obj);
		Serializable id = getId(obj);
		IDomainObject domainObject = get(id);
		if (domainObject == null) {
			save(obj);
		} else {
			update(obj);
		}
	}

	/**
	 * 批量保存或添加域对象。将一个集合objs的每个元素保存到数据库
	 *
	 * @author Sunzhenying
	 * @param objs
	 *            域对象集合
	 * @see com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#saveOrUpdateAll(Collection<D>
	 *      objs)
	 */
	public void saveOrUpdateAll(Collection<D> objs) {
		if (objs.isEmpty())
			return;
		Iterator<D> iterator = objs.iterator();
		while (iterator.hasNext()) {
			saveOrUpdate((D) iterator.next());
		}
	}

	/**
	 * 将一个实体对象obj保存到数据库
	 *
	 * @author Sunzhenying
	 * @param obj
	 *            域对象
	 * @see com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#update(IDomainObject
	 *      obj)
	 */
	public void update(IDomainObject obj) {
		checkClass(obj);
		Serializable id = getId(obj);// 得到实体对象的主健
		String updateSql = objectMapper.getUpdateSql();
		Method[] ms = getObjectMapper().getGetMethods();
		Object[] os = new Object[ms.length];
		int j = 0;
		for (int i = 0; i < ms.length; i++) {
			if (ms[i].getName().equalsIgnoreCase("getId")) {
				j = j - 1;
			} else {
				os[j] = getObjectMapper().executeGetMethod(obj, ms[i]);
			}
			j = j + 1;
		}
		os[ms.length - 1] = id;
		getJdbcTemplate().update(updateSql, os);
	}

	/**
	 * 得到IDomainObject实体对象的id值
	 *
	 * @param obj
	 * @return 返回域对象的id值
	 * @see #com.sitechasia.webx.core.dao.jdbc.ObjectMapper#getGetIdMethod()
	 */
	private Serializable getId(IDomainObject obj) {
		Method getIdMethod = objectMapper.getGetIdMethod();
		Serializable id;
		try {
			id = (Serializable) getIdMethod.invoke(obj, new Object[] {});
		} catch (Exception e) {
			logger.info(e.getMessage());
			throw new RuntimeException(e);
		}
		return id;
	}

	/**
	 * 检查实体对象是否是所要操作的类型，如果不是，就抛出例外
	 *
	 * @param obj
	 * @see com.sitechasia.webx.core.utils.base.GenericsUtils#getGenericClass(Class
	 *      clazz)
	 */
	private void checkClass(IDomainObject obj) {
		if (obj.getClass() != GenericsUtils.getGenericClass(this.getClass())) {
			logger.info("所删除对象的类型不是："
					+ GenericsUtils.getGenericClass(this.getClass()) + "的类型");
			throw new RuntimeException("所删除对象的类型不是："
					+ GenericsUtils.getGenericClass(this.getClass()) + "的类型");
		}
	}

	public IPageSqlProvider getPageSqlProvider() {
		return pageSqlProvider;
	}

	public void setPageSqlProvider(IPageSqlProvider pageSqlProvider) {
		this.pageSqlProvider = pageSqlProvider;
	}

	public ObjectMapper getObjectMapper() {
		return objectMapper;
	}

	public void setObjectMapper(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	public boolean isCached() {
		return cached;
	}

	public void setCached(boolean cached) {
		this.cached = cached;
	}

//	以下为实现的原有的IDomainObjectDao接口的方法
	/**
	 * {@link com.sitechasia.webx.core.dao.IDomainObjectDao#doDelete(com.sitechasia.webx.core.model.IDomainObject)
	 *
	 */
	public void doDelete(D o) {
		this.delete(o);

	}
	/**
	 * {@link com.sitechasia.webx.core.dao.IDomainObjectDao#doDeleteById(java.io.Serializable)
	 *
	 */
	public void doDeleteById(Serializable id) {
		this.deleteById(id);

	}
	/**
	 * {@link com.sitechasia.webx.core.dao.IDomainObjectDao#doDeleteByIds(java.io.Serializable[])
	 *
	 */
	public void doDeleteByIds(Serializable[] ids) {
		this.deleteByIds(ids);
	}

	/**
	 * {@link com.sitechasia.webx.core.dao.IDomainObjectDao#doSave(com.sitechasia.webx.core.model.IDomainObject)
	 *
	 */
	public void doSave(D o) {
		this.saveOrUpdate(o);
	}
	/**
	 * {@link com.sitechasia.webx.core.dao.IDomainObjectDao#doSaveAll()
	 *
	 */
	public void doSaveAll(Collection<D> list) {
		this.saveOrUpdateAll(list);
	}
	/**
	 * {@link com.sitechasia.webx.core.dao.IDomainObjectDao#findAll()
	 *
	 */
	public List<D> findAll() {
		return this.listAll(0,0);
	}
	/**
	 * {@link com.sitechasia.webx.core.dao.IDomainObjectDao#findBy()
	 *
	 */
	public List<D> findBy(String name, Object value) {
		return this.listByField(name, value, 0, 0);
	}
	/**
	 * {@link com.sitechasia.webx.core.dao.IDomainObjectDao#findById()
	 *
	 */
	public D findById(Serializable id) {
		return this.get(id);
	}
	/**
	 * {@link com.sitechasia.webx.core.dao.IDomainObjectDao#findByLike()
	 *
	 */
	public List<D> findByLike(String name, String value) {
		return this.listByFieldLike(name, value, 0, 0);
	}
	/**
	 * {@link com.sitechasia.webx.core.dao.IDomainObjectDao#findUniqueBy()
	 *
	 */
	@SuppressWarnings("unchecked")
	public D findUniqueBy(String name, Object value) {
		return this.listByField(name, value, 0, 0).get(0);
	}
	/**
	 * {@link com.sitechasia.webx.core.dao.IDomainObjectDao#isNotUnique()
	 *
	 */
	public boolean isNotUnique(D domainObject, String names) {
		return this.isExist(domainObject, names);
	}

}
