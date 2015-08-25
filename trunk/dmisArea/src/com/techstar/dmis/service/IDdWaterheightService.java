package com.techstar.dmis.service;


import java.util.List;
import java.util.Collection;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.dto.DdWaterheightDto;

//please add your business methods start
	// to do it
//add your business method end
	
/** 
 * 业务对象服务接口类
 * @author 
 * @date
 */
public interface IDdWaterheightService {

    public void addDdWaterheight(DdWaterheightDto dto);

	/**
	 * 进行增加或修改操作业务处理
	 * 
	 * @param dto
	 *DdWaterheightDto 业务传输对象
	 * 
	 */
	public void saveOrUpdateDdWaterheight(DdWaterheightDto dto);
	public void saveOrUpdateDdWaterheight(List dtos);

	/**
	 * 进行加载的业务操作
	 * @param ddWaterheightId
	 *            Integer 主键值ֵ
	 */
	public DdWaterheightDto loadDdWaterheight(String ddWaterheightId);

	/**
	 * 删除指定的业务
	 * @param ddWaterheightId
	 *            Integer 主键值ֵ
	 */
	public void deleteDdWaterheight(String ddWaterheightId);
	
	/**
	 * 删除指定的业务

	 * @param ddWaterheightId
	 *            Integer 主键值ֵ

	 */
	public void deleteDdWaterheight(String ddWaterheightId,int version);
    
	/**
	 * 进行申请查询操作业务处理
	 */

	
	/**
	 * 进行申请查询操作业务处理(分页)
	 * 
	 * @return QueryListObj 封装了结果集及记录总数的对象
	 */
public QueryListObj listDdWaterheight();
public QueryListObj listDdWaterheightByHql(String hql);
public QueryListObj getDdWaterheightByHql(String hql,int beginPage, int pageSize,String sql);


	//please add your business methods start
	// to do it
	//add your business method end

	
	

	//please add your business methods start
	// to do it
	//add your business method end
	
	
}
