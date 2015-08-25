package com.techstar.dmis.service;

import java.util.List;
import java.util.Collection;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.dto.DaymodeanalyseDto;



//please add your business methods start
	// to do it
//add your business method end
	
/** 
 * 业务对象服务接口类
 * @author 
 * @date
 */
public interface IDaymodeanalyseService {

    public void addDaymodeanalyse(DaymodeanalyseDto dto);

	/**
	 * 进行增加或修改操作业务处理
	 * 
	 * @param dto
	 *DaymodeanalyseDto 业务传输对象
	 * 
	 */
	public void saveOrUpdateDaymodeanalyse(DaymodeanalyseDto dto);
	public void saveOrUpdateDaymodeanalyse(List dtos);

	/**
	 * 进行加载的业务操作
	 * @param daymodeanalyseId
	 *            Integer 主键值ֵ
	 */
	public DaymodeanalyseDto loadDaymodeanalyse(String daymodeanalyseId);

	/**
	 * 删除指定的业务
	 * @param daymodeanalyseId
	 *            Integer 主键值ֵ
	 */
	public void deleteDaymodeanalyse(String daymodeanalyseId);
    /**
	* 删除指定的业务集合
	**/
	public void deleteDaymodeanalyse(List dtos);
	
	/**
	 * 进行申请查询操作业务处理
	 */

	
	/**
	 * 进行申请查询操作业务处理(分页)
	 * 
	 * @return QueryListObj 封装了结果集及记录总数的对象
	 */
	 public QueryListObj listDaymodeanalyse();
	 public QueryListObj listDaymodeanalyseByHql(String hql);
	 public QueryListObj getDaymodeanalyseByHql(String hql,int beginPage, int pageSize,String sql);

	//please add your business methods start
	// to do it
	//add your business method end

	
	

 

	//please add your business methods start
	// to do it
	//add your business method end
	
	
}
