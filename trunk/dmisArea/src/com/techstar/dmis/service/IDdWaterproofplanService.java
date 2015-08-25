package com.techstar.dmis.service;


import java.util.List;
import java.util.Collection;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.dto.DdWaterproofplanDto;

//please add your business methods start
	// to do it
//add your business method end
	
/** 
 * 业务对象服务接口类
 * @author 
 * @date
 */
public interface IDdWaterproofplanService {

    public void addDdWaterproofplan(DdWaterproofplanDto dto);

	/**
	 * 进行增加或修改操作业务处理
	 * 
	 * @param dto
	 *DdWaterproofplanDto 业务传输对象
	 * 
	 */
	public void saveOrUpdateDdWaterproofplan(DdWaterproofplanDto dto);
	public void saveOrUpdateDdWaterproofplan(List dtos);

	/**
	 * 进行加载的业务操作
	 * @param ddWaterproofplanId
	 *            Integer 主键值ֵ
	 */
	public DdWaterproofplanDto loadDdWaterproofplan(String ddWaterproofplanId);

	/**
	 * 删除指定的业务
	 * @param ddWaterproofplanId
	 *            Integer 主键值ֵ
	 */
	public void deleteDdWaterproofplan(String ddWaterproofplanId);
	/**
	 * 删除指定的业务

	 * @param ddWaterproofplanId
	 *            Integer 主键值ֵ

	 */
	public void deleteDdWaterproofplan(String ddWaterproofplanId,int version);
    
	/**
	 * 进行申请查询操作业务处理
	 */

	
	/**
	 * 进行申请查询操作业务处理(分页)
	 * 
	 * @return QueryListObj 封装了结果集及记录总数的对象
	 */
public QueryListObj listDdWaterproofplan();
public QueryListObj listDdWaterproofplanByHql(String hql);
public QueryListObj getDdWaterproofplanByHql(String hql,int beginPage, int pageSize,String sql);


	//please add your business methods start
	// to do it
	//add your business method end

	
	

	//please add your business methods start
	// to do it
	//add your business method end
	
	
}
