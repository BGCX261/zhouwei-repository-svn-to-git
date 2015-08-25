/**
 * 持久化对象数据操纵接口类
 * @author 
 * @date
 */
package com.techstar.griddemo.dao;

import java.util.Collection;
import java.util.List;

import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.griddemo.entity.SaleDetail;

public interface ISaleDetailDao {
	/**
	 * 保存或修改实体
	 * 
	 * @param  saleDetail
	 */
	public void saveOrUpdate(SaleDetail  saleDetail);
	
	public void saveOrUpdateAll(Collection objs);

	/**
	 * 删除实体
	 * 
	 * @param  saleDetail
	 */
	public void delete(SaleDetail  saleDetail);

	/**
	 * 根据主键查找实体
	 * 
	 * @param id
	 *             主键值ֵ
	 * @return  saleDetail 返回查找到的实体对象
	 */
	public SaleDetail findByPk(Object id);

	/**
	 * 得到实体的所有记录(不分页)
	 * 
	 * @param queryName
	 * @return QueryListObj  封装了结果集及记录总数的对象
	 */
	public QueryListObj getQueryList();

	public QueryListObj getQueryListByHql(String hql);
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
	public QueryListObj getQueryListByHql(String hql,int beginPage,int pageSize);
	
	public List getObjPropertySums(String sql);
}
