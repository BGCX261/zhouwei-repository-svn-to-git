package com.techstar.dmis.service;

import java.util.List;
import java.util.Collection;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.dto.StdDispatchunitDto;



//please add your business methods start
	// to do it
//add your business method end
	
/** 
 * 业务对象服务接口类
 * @author 
 * @date
 */
public interface IStdDispatchunitService {

    public void addStdDispatchunit(StdDispatchunitDto dto);

	/**
	 * 进行增加或修改操作业务处理
	 * 
	 * @param dto
	 *StdDispatchunitDto 业务传输对象
	 * 
	 */
	public void saveOrUpdateStdDispatchunit(StdDispatchunitDto dto);
	public void saveOrUpdateStdDispatchunit(List dtos);

	/**
	 * 进行加载的业务操作
	 * @param stdDispatchunitId
	 *            Integer 主键值ֵ
	 */
	public StdDispatchunitDto loadStdDispatchunit(String stdDispatchunitId);

	/**
	 * 删除指定的业务
	 * @param stdDispatchunitId
	 *            Integer 主键值ֵ
	 */
	public void deleteStdDispatchunit(String stdDispatchunitId);
    /**
	* 删除指定的业务集合
	**/
	public void deleteStdDispatchunit(List dtos);
	
	/**
	 * 进行申请查询操作业务处理
	 */

	
	/**
	 * 进行申请查询操作业务处理(分页)
	 * 
	 * @return QueryListObj 封装了结果集及记录总数的对象
	 */
	 public QueryListObj listStdDispatchunit();
	 public QueryListObj listStdDispatchunitByHql(String hql);
	 public QueryListObj getStdDispatchunitByHql(String hql,int beginPage, int pageSize,String sql);
	 public String getDataOwner(String dataownerName);
	//please add your business methods start
	// to do it
	//add your business method end

	
	

 

	//please add your business methods start
	// to do it
	//add your business method end
	
	
}
