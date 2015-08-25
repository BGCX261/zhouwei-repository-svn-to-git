/**
 * 持久化对象数据操纵接口类
 * @author 
 * @date
 */
package com.techstar.dmis.dao;

import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.entity.RepTree2result;
import java.util.List;
import java.util.Collection;

public interface IRepTree2resultDao {

     public void merge(RepTree2result  repTree2result);
	/**
	 * 保存或修改实体
	 * 
	 * @param  repTree2result
	 */
	public void saveOrUpdate(RepTree2result  repTree2result);

	/**
	 * 删除实体
	 * 
	 * @param  repTree2result
	 */
	public void delete(RepTree2result  repTree2result);

	/**
	 * 根据主键查找实体
	 * 
	 * @param f_relationid
	 *             主键值ֵ
	 * @return  repTree2result 返回查找到的实体对象
	 */
	public RepTree2result findByPk(Object f_relationid);

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
