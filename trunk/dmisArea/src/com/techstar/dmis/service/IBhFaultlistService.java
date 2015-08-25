package com.techstar.dmis.service;

import java.util.List;
import java.util.Collection;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.dto.BhFaultlistDto;



//please add your business methods start
	// to do it
//add your business method end
	
/** 
 * 业务对象服务接口类
 * @author 
 * @date
 */
public interface IBhFaultlistService {

    public void addBhFaultlist(BhFaultlistDto dto);

	/**
	 * 进行增加或修改操作业务处理
	 * 
	 * @param dto
	 *BhFaultlistDto 业务传输对象
	 * 
	 */
	public void saveOrUpdateBhFaultlist(BhFaultlistDto dto);
	public void saveOrUpdateBhFaultlist(List dtos);

	/**
	 * 进行加载的业务操作
	 * @param bhFaultlistId
	 *            Integer 主键值ֵ
	 */
	public BhFaultlistDto loadBhFaultlist(String bhFaultlistId);

	/**
	 * 删除指定的业务
	 * @param bhFaultlistId
	 *            Integer 主键值ֵ
	 */
	public void deleteBhFaultlist(String bhFaultlistId);
    /**
	* 删除指定的业务集合
	**/
	public void deleteBhFaultlist(List dtos);
	
	/**
	 * 进行申请查询操作业务处理
	 */

	
	/**
	 * 进行申请查询操作业务处理(分页)
	 * 
	 * @return QueryListObj 封装了结果集及记录总数的对象
	 */
	 public QueryListObj listBhFaultlist();
	 public QueryListObj listBhFaultlistByHql(String hql);
	 public QueryListObj getBhFaultlistByHql(String hql,int beginPage, int pageSize,String sql);

	//please add your business methods start
	// to do it
	//add your business method end

	
	

 

	//please add your business methods start
	// to do it
	//add your business method end
	
	
}
