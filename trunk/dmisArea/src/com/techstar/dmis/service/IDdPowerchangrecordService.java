package com.techstar.dmis.service;


import java.util.List;
import java.util.Collection;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.dto.DdPowerchangrecordDto;

//please add your business methods start
	// to do it
//add your business method end
	
/** 
 * 业务对象服务接口类
 * @author 
 * @date
 */
public interface IDdPowerchangrecordService {

    public void addDdPowerchangrecord(DdPowerchangrecordDto dto);

	/**
	 * 进行增加或修改操作业务处理
	 * 
	 * @param dto
	 *DdPowerchangrecordDto 业务传输对象
	 * 
	 */
	public void saveOrUpdateDdPowerchangrecord(DdPowerchangrecordDto dto);
	public void saveOrUpdateDdPowerchangrecord(List dtos);

	/**
	 * 进行加载的业务操作
	 * @param ddPowerchangrecordId
	 *            Integer 主键值ֵ
	 */
	public DdPowerchangrecordDto loadDdPowerchangrecord(String ddPowerchangrecordId);

	/**
	 * 删除指定的业务
	 * @param ddPowerchangrecordId
	 *            Integer 主键值ֵ
	 */
	public void deleteDdPowerchangrecord(String ddPowerchangrecordId);
	/**
	 * 删除指定的业务

	 * @param ddPowerchangrecordId
	 *            Integer 主键值ֵ

	 */
	public void deleteDdPowerchangrecord(String ddPowerchangrecordId,int version);
	/**
	 * 进行申请查询操作业务处理
	 */

	
	/**
	 * 进行申请查询操作业务处理(分页)
	 * 
	 * @return QueryListObj 封装了结果集及记录总数的对象
	 */
public QueryListObj listDdPowerchangrecord();
public QueryListObj listDdPowerchangrecordByHql(String hql);
public QueryListObj getDdPowerchangrecordByHql(String hql,int beginPage, int pageSize,String sql);


	//please add your business methods start
	// to do it
	//add your business method end

	
	

	//please add your business methods start
	// to do it
	//add your business method end
	
	
}
