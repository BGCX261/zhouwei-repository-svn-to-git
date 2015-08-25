/**
 * 
 */
/**
 * 
 */
package com.techstar.framework.service.commonquery;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.techstar.framework.dao.model.CommonQueryObj;

/**
 * @author xcf Nov 30, 2006 4:50:44 PM
 * @author caojian 2006-12-18
 * @author sbt 2007-1-2 
 */
public interface ICommonQueryService {
	/**
	 * 通用查询 返回的是map集合，map的组织方式是{属性名,属性值}
	 */
	public List getLogicElemList(CommonQueryObj queryobj);

	/**
	 * 通用查询 返回结果是对象dto集合
	 */
	public List getLogicElemDtoList(CommonQueryObj queryobj);

	/**
	 * 通用查询,返回列表要求的xml格式的字符串
	 * 
	 * @return
	 */
	public String query(Map constr,int GLQueryType);

	/**
	 * 通过sql语句查询数据库记录
	 * 
	 * @param sql
	 *            sql语句字符串
	 * @return List 结果List，形如[Map,Map...]
	 */
	public List getListBySql(String sql);
	/**
	 * 查询导出到excel中的数据
	 * @param constr
	 */
	public String queryExcel(Map constr,int GLQueryType);
	/**
	 * 根据业务层传递的hql进行查询
	 * @param hql
	 * @return
	 */
	public List getQueryDataByHQL(String hql);
}
