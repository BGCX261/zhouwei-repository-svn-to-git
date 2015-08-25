/**
 * 持久化对象数据操纵接口类
 * @author 
 * @date
 */
package com.techstar.framework.ui.dao;

import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.framework.ui.entity.SysUiGrid;

public interface ISysUiGridDao {

	public void saveOrUpdate(SysUiGrid  sysUiGrid);

	public void delete(SysUiGrid  sysUiGrid);

	public SysUiGrid findByPk(Object id);

	public QueryListObj getQueryList();

	public QueryListObj getQueryListByHql(String hql);

	public QueryListObj getQueryListByHql(String hql, int beginPage, int pageSize);
}
