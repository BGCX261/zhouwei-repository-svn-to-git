/**
 * 持久化对象数据操纵接口类
 * @author 
 * @date
 */
package com.techstar.dmis.dao;

import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.entity.StdCutoffpercent;
import java.util.List;
import java.util.Collection;

public interface IStdCutoffpercentDao {

     public void merge(StdCutoffpercent  stdCutoffpercent);
	/**
	 * 保存或修改实体
	 * 
	 * @param  stdCutoffpercent
	 */
	public void saveOrUpdate(StdCutoffpercent  stdCutoffpercent);

	/**
	 * 删除实体
	 * 
	 * @param  stdCutoffpercent
	 */
	public void delete(StdCutoffpercent  stdCutoffpercent);

	/**
	 * 根据主键查找实体
	 * 
	 * @param id
	 *             主键值ֵ
	 * @return  stdCutoffpercent 返回查找到的实体对象
	 */
	public StdCutoffpercent findByPk(Object id);

	/**
	 * 得到实体的所有记录(不分页)
	 * 
	 * @param queryName
	 * @return QueryListObj  封装了结果集及记录总数的对象
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
	
	public QueryListObj getQueryList(int beginPage,
			int pageSize);
	
	
	public QueryListObj getQueryListByHql(String hql);

	/**
	 * 得到实体的所有记录(分页)
	 * @param entityName 
	 * @param beginPage 起始页	 * @param pageSize 每页显示记录数     * @return QueryListObj 封装了结果集及记录总数的对象	 */
	public QueryListObj getQueryListByHql(String hql,int beginPage,int pageSize);
	public void saveOrUpdateAll(Collection objs);
	public List getObjPropertySums(String sql);
	
	/**
	 * 删除所有
	 * @param pos
	 */
	public void deleteAll(List pos);
}
