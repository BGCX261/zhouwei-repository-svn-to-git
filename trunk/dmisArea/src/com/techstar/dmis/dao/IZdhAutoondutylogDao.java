/**
 * 持久化对象数据操纵接口类
 * @author 
 * @date
 */
package com.techstar.dmis.dao;

import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.entity.ZdhAutoondutylog;
import java.util.List;
import java.util.Collection;

public interface IZdhAutoondutylogDao {

     public void merge(ZdhAutoondutylog  zdhAutoondutylog);
	/**
	 * 保存或修改实体
	 * 
	 * @param  zdhAutoondutylog
	 */
	public void saveOrUpdate(ZdhAutoondutylog  zdhAutoondutylog);

	/**
	 * 删除实体
	 * 
	 * @param  zdhAutoondutylog
	 */
	public void delete(ZdhAutoondutylog  zdhAutoondutylog);

	/**
	 * 根据主键查找实体
	 * 
	 * @param ondutyno
	 *             主键值ֵ
	 * @return  zdhAutoondutylog 返回查找到的实体对象
	 */
	public ZdhAutoondutylog findByPk(Object ondutyno);

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
	/**
	 * 执行交接班操作,调用存储过程
	 * @param ondutyno
	 * @return
	 */
	public String carryOn(String ondutyno);
}
