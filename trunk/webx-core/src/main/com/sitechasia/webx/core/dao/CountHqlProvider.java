/**
 * Create time 2008-2-26 上午10:10:48
 */
package com.sitechasia.webx.core.dao;

/**
 * <p>Title: CountSqlProvider</p>
 * <p>Description: count SQL语句转换器</p>
 * <p>通过count SQL语句转换器，把一个查询转换为计算总条数的SQL语句</p>
 *
 * @author Steven
 * @version 1.0
 */
public interface CountHqlProvider {
	
	/**
	 * 把给定的查询语句转换成一个count查询语句
	 * @param sourceHql 给定的查询语句
	 * @return 针对给定的查询语句的count查询语句
	 */
	String buildCountHql(String sourceHql);

}
