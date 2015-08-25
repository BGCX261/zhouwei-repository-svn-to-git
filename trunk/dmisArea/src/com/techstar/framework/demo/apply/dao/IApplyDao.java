/**
 * Oct 25, 2006
 * @author xcf
 */
package com.techstar.framework.demo.apply.dao;

import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.framework.demo.entity.Apply;

public interface IApplyDao {
	/**
	 * 保存或修改实体
	 * 
	 * @param apply
	 */
	public void saveOrUpdate(Apply apply);

	/**
	 * 删除实体
	 * 
	 * @param apply
	 */
	public void delete(Apply apply);

	/**
	 * 根据主键查找实体
	 * 
	 * @param pk
	 *            主键值
	 * @return Apply 返回查找到的实体对象
	 */
	public Apply findByPk(Object pk);

	/**
	 * 得到实体的所有记录(不分页)
	 * 
	 * @param entityName
	 *            
	 * @return QueryListObj 封装了结果集及记录总数的对象
	 */
	public QueryListObj getQueryList();

	/**
	 * 得到实体的所有记录(分页)
	 * 
	 * @param entityName 
	 *            
	 * @param beginPage
	 *            起始页
	 * @param pageSize
	 *            每页显示记录数
	 * @return QueryListObj 封装了结果集及记录总数的对象
	 */
	public QueryListObj getQueryList( int beginPage,
			int pageSize);
}
