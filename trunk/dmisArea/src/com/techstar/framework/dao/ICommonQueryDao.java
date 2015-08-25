/**
 *ͨ�ò�通用查询数据访问接口
 */
package com.techstar.framework.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.techstar.framework.dao.model.CommonQueryObj;
import com.techstar.framework.dao.model.QueryListObj;



/**
 * @author xcf  Nov 30, 2006 10:56:28 AM
 * @author sbt 2006-12-26 
 */
public interface ICommonQueryDao  {
	/**
	 * 分页查询
	 * @param queryobj 带有查询条件的对象
	 * @param QueryListObj 返回查询对象
	 * */
	public QueryListObj getLogicElemList(CommonQueryObj queryobj)  throws DataAccessException;
	public List getQueryDataByHQL(String hql);
	public void delData(CommonQueryObj queryobj) throws DataAccessException;
}
