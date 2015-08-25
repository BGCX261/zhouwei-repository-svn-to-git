/**
 * IDomainDao.java Create on 2008-5-7 下午03:14:56
 *
 * Copyright (c) 2006- by CE.
 */
package com.sitechasia.webx.core.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.sitechasia.webx.core.model.IDomainObject;
import com.sitechasia.webx.core.page.QueryResult;

/**
 * 域对象DAO层。
 * <p>
 * DAO层提供基本CRUD方法。本接口主要提供两类查询方法：一类是findXXX，此类查询接口返回QueryResult对象；
 * 另一类是listXXX，此类接口只返回List对象。listXXX方法减少了一次对查询条件的count操作，对于性能要求 非常高的场合适合使用。<br>
 * 所有查询方法均需要传入翻页信息，包括页面记录数(pageSize)、页号(pageNum)。只有这两个参数
 * 均不为零时分页查询才有效，否则返回符合查询条件的所有记录。
 *
 * @author MarkDong
 * @version 1.5
 * @since 1.5
 * @see QueryResult
 */
public interface IDomainDao<D extends IDomainObject> extends IDomainObjectDao<D>{
	/**
	 * 添加域对象。
	 *
	 * @param obj 域对象
	 */
	void save(D obj);

	/**
	 * 保存或添加域对象
	 *
	 * @author MarkDong
	 * @param obj 域对象
	 */
	void saveOrUpdate(D obj);

	/**
	 * 批量保存或添加域对象。
	 *
	 * @author MarkDong
	 * @param objs 域对象集合
	 */
	void saveOrUpdateAll(Collection<D> objs);

	/**
	 * 更新域对象
	 *
	 * @author MarkDOng
	 * @param obj 域对象
	 */
	void update(D obj);

	/**
	 * 删除域对象。
	 *
	 * @author MarkDong
	 * @param obj 待删除对象
	 */
	void delete(D obj);

	/**
	 * 根据主键删除域对象。
	 *
	 * @author MarkDong
	 * @param id 主键
	 */
	void deleteById(Serializable id);

	/**
	 * 根据主键数组删除所有域对象
	 *
	 * @author MarkDong
	 * @param ids 主键数组
	 */
	void deleteByIds(Serializable[] ids);

	/**
	 * 根据主键取得记录
	 *
	 * @author MarkDong
	 * @param id 主键
	 * @return 该主键对应的记录。如果不存在该主键，返回null
	 */
	D get(Serializable id);

	/**
	 * 根据主键取得记录
	 *
	 * @author MarkDong
	 * @param id 主键
	 * @return 该主键对应的记录代理类实例。如果开启了缓存,则先在缓存中查询.如果不存在该主键，抛出ObjectNotFoundException异常
	 */
	D load(Serializable id);

	/**
	 * 取得当前实体类的所有记录数
	 *
	 * @author MarkDong
	 * @return 所有记录数
	 */
	long countAll();

	/**
	 * 统计符合查询语句的记录数<p>
	 * 参数的传递采用可变参数args，参数类型必须和字段类型相匹配。 可用如下四种方法调用：
	 * <ul>
	 * <li>dao.countByQl(ql);
	 * <li> dao.countByQl(ql, arg0);
	 * <li> dao.countByQl(ql, arg0, arg1);
	 * <li> dao.countByQl(ql, new Object[]{arg0, arg1, arg2});
	 * </ul>
	 *
	 * @author MarkDong
	 * @param ql 查询语句
	 * @param args 参数列表
	 * @return 记录数
	 */
	long countByQl(String ql, Object... args);

	/**
	 * 根据字段名称及字段值的数组统计记录数
	 * @author MarkDong
	 * @param fields 字段名称数组
	 * @param values 字段值数组
	 * @return 记录数
	 */
	long countByFields(String[] fields, Object[] values);

	/**
	 * 根据字段名称及字段值统计记录数
	 *
	 * @author MarkDong
	 * @param field 字段名称
	 * @param value 字段值
	 * @return 记录数
	 */
	long countByField(String field, Object value);

	/**
	 * 根据字段名称及字段值做Like统计，只支持字符串型字段。
	 *
	 * @author MarkDong
	 * @param field 字段名
	 * @param value 字段值
	 * @return 记录数
	 */
	long countByFieldLike(String field, String value);

	/**
	 * 根据字段名及字段值数组做Like统计，只支持字符串型字段。
	 *
	 * @author MarkDong
	 * @param fields 字段名数组
	 * @param values 字段值数组
	 * @return 记录数
	 */
	long countByFieldsLike(String[] fields, String[] values);

	/**
	 * 获取全部对象。对于记录量大的表请谨慎使用。
	 *
	 * @param pageSize 页面记录数
	 * @param pageNum 页号，从1开始
	 * @return 结果集
	 */
	List<D> listAll(int pageSize, int pageNum);

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
	 * @author MarkDong
	 * @param ql 查询语句
	 * @param pageSize 页面记录数
	 * @param pageNum 页号，从1开始
	 * @param args 查询参数列表
	 * @return 结果集
	 */
	List<D> listByQL(String ql, int pageSize, int pageNum, Object... args);

	/**
	 * 根据单字段获取对象。
	 * <p>
	 * 取得字段值等于指定值的对象列表。
	 *
	 * @author MarkDong
	 * @param field 字段名称
	 * @param value 指定值
	 * @param pageSize 页面记录数
	 * @param pageNum 页号，从1开始
	 * @return 结果集
	 */
	List<D> listByField(String field, Object value, int pageSize, int pageNum);

	/**
	 * 根据多字段获取对象。 取得所有字段值都等于指定值的对象列表。
	 *
	 * @author MarkDong
	 * @param fields 字段名称数组
	 * @param values 查询值数组。要跟字段名称顺序一致。
	 * @param pageSize 页面记录数
	 * @param pageNum 页号，从1开始
	 * @return 结果集
	 */
	List<D> listByFields(String[] fields, Object[] values, int pageSize,
			int pageNum);

	/**
	 * 以Like AnyWhere的方式对单一字段查询。只支持字符串型字段。
	 *
	 * @author MarkDong
	 * @param field 字段名称
	 * @param value 值
	 * @param pageSize 页面记录数
	 * @param pageNum 页号，从1开始
	 * @return 结果集
	 */
	List<D> listByFieldLike(String field, String value, int pageSize,
			int pageNum);

	/**
	 * 以Like AnyWhere的方式对字段组合查询。只支持字符串型字段。
	 *
	 * @author MarkDong
	 * @param fields 字段名称数组
	 * @param values 值数组
	 * @param pageSize 页面记录数
	 * @param pageNum 页号，从1开始
	 * @return 结果集
	 */
	List<D> listByFieldsLike(String[] fields, String[] values, int pageSize,
			int pageNum);

	/**
	 * 获取全部对象。对于记录量大的表请谨慎使用。
	 *
	 * @param pageSize 页面记录数
	 * @param pageNum 页号，从1开始
	 * @return 结果集
	 */
	QueryResult<D> findAll(int pageSize, int pageNum);

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
	 * @author MarkDong
	 * @param ql 查询语句
	 * @param pageSize 页面记录数
	 * @param pageNum 页号，从1开始
	 * @param args 查询参数列表
	 * @return 结果集
	 */
	QueryResult<D> findByQL(String ql, int pageSize, int pageNum, Object... args);

	/**
	 * 根据单字段获取对象。
	 * <p>
	 * 取得字段值等于指定值的对象列表。
	 *
	 * @author MarkDong
	 * @param field 字段名称
	 * @param value 指定值
	 * @param pageSize 页面记录数
	 * @param pageNum 页号，从1开始
	 * @return 结果集
	 */
	QueryResult<D> findByField(String field, Object value, int pageSize,
			int pageNum);

	/**
	 * 根据多字段获取对象。 取得所有字段值都等于指定值的对象列表。
	 *
	 * @author MarkDong
	 * @param fields 字段名称数组
	 * @param values 查询值数组。要跟字段名称顺序一致。
	 * @param pageSize 页面记录数
	 * @param pageNum 页号，从1开始
	 * @return 结果集
	 */
	QueryResult<D> findByFields(String[] fields, Object[] values, int pageSize,
			int pageNum);

	/**
	 * 以Like AnyWhere的方式对单一字段查询。只支持字符串型字段。
	 *
	 * @author MarkDong
	 * @param field 字段名称
	 * @param value 值
	 * @param pageSize 页面记录数
	 * @param pageNum 页号，从1开始
	 * @return 结果集
	 */
	QueryResult<D> findByFieldLike(String field, String value, int pageSize,
			int pageNum);

	/**
	 * 以Like AnyWhere的方式对字段组合查询。只支持字符串型字段。
	 *
	 * @author MarkDong
	 * @param fields 字段名称数组
	 * @param values 值数组
	 * @param pageSize 页面记录数
	 * @param pageNum 页号，从1开始
	 * @return 结果集
	 */
	QueryResult<D> findByFieldsLike(String[] fields, String[] values,
			int pageSize, int pageNum);

	/**
	 * 判断数据库中是否已经存在指定字段列表的值的记录。
	 *
	 * @author MarkDong
	 * @param obj 域对象
	 * @param fields 逗号分割的属性列表，例如"username, password"
	 * @return
	 */
	boolean isExist(D obj, String fields);
}
