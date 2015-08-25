package com.techstar.dmis.service;


import java.util.List;
import java.util.Collection;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.dto.ZdhFaultlistDto;

//please add your business methods start
	// to do it
//add your business method end
	
/** 
 * 业务对象服务接口类
 * @author 
 * @date
 */
public interface IZdhFaultlistService {

    public void addZdhFaultlist(ZdhFaultlistDto dto);

	/**
	 * 进行增加或修改操作业务处理
	 * 
	 * @param dto
	 *ZdhFaultlistDto 业务传输对象
	 * 
	 */
	public void saveOrUpdateZdhFaultlist(ZdhFaultlistDto dto);
	public void saveOrUpdateZdhFaultlist(List dtos);

	/**
	 * 进行加载的业务操作
	 * @param zdhFaultlistId
	 *            Integer 主键值ֵ
	 */
	public ZdhFaultlistDto loadZdhFaultlist(String zdhFaultlistId);

	/**
	 * 删除指定的业务
	 * @param zdhFaultlistId
	 *            Integer 主键值ֵ
	 */
	public void deleteZdhFaultlist(String zdhFaultlistId);
	
	/**
	 * 删除指定的业务
	 * 
	 * @param zdhFaultlistId
	 * @param version
	 */
	public void deleteZdhFaultlistObj(String zdhFaultlistId, int version);
    
	/**
	 * 进行申请查询操作业务处理
	 */

	
	/**
	 * 进行申请查询操作业务处理(分页)
	 * 
	 * @return QueryListObj 封装了结果集及记录总数的对象
	 */
public QueryListObj listZdhFaultlist();
public QueryListObj listZdhFaultlistByHql(String hql);
public QueryListObj getZdhFaultlistByHql(String hql,int beginPage, int pageSize,String sql);


	//please add your business methods start
	// to do it
	//add your business method end

	
	

	//please add your business methods start
	// to do it
	//add your business method end
	
	
}
