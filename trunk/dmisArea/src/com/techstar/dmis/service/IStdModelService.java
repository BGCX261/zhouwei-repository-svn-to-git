package com.techstar.dmis.service;

import java.util.List;
import java.util.Collection;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.dto.StdModelDto;



//please add your business methods start
	// to do it
//add your business method end
	
/** 
 * 业务对象服务接口类
 * @author 
 * @date
 */
public interface IStdModelService {

    public void addStdModel(StdModelDto dto);

	/**
	 * 进行增加或修改操作业务处理
	 * 
	 * @param dto
	 *StdModelDto 业务传输对象
	 * 
	 */
	public void saveOrUpdateStdModel(StdModelDto dto);
	public void saveOrUpdateStdModel(List dtos);

	/**
	 * 进行加载的业务操作
	 * @param stdModelId
	 *            Integer 主键值ֵ
	 */
	public StdModelDto loadStdModel(String stdModelId);

	/**
	 * 删除指定的业务
	 * @param stdModelId
	 *            Integer 主键值ֵ
	 */
	public void deleteStdModel(String stdModelId);
    /**
	* 删除指定的业务集合
	**/
	public void deleteStdModel(List dtos);
	
	/**
	 * 进行申请查询操作业务处理
	 */

	
	/**
	 * 进行申请查询操作业务处理(分页)
	 * 
	 * @return QueryListObj 封装了结果集及记录总数的对象
	 */
	 public QueryListObj listStdModel();
	 public QueryListObj listStdModelByHql(String hql);
	 public QueryListObj getStdModelByHql(String hql,int beginPage, int pageSize,String sql);

	//please add your business methods start
	// to do it
	//add your business method end

	
	

 

	//please add your business methods start
	// to do it
	//add your business method end
	
	
}
