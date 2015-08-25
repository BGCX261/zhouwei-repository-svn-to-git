package com.techstar.dmis.service;


import java.util.List;
import java.util.Collection;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.dto.EtsEquipmentDto;

//please add your business methods start
	// to do it
//add your business method end
	
/** 
 * 业务对象服务接口类
 * @author 
 * @date
 */
public interface IEtsEquipmentService {

    public void addEtsEquipment(EtsEquipmentDto dto);

	/**
	 * 进行增加或修改操作业务处理
	 * 
	 * @param dto
	 *EtsEquipmentDto 业务传输对象
	 * 
	 */
	public void saveOrUpdateEtsEquipment(EtsEquipmentDto dto);
	public void saveOrUpdateEtsEquipment(List dtos);

	/**
	 * 进行加载的业务操作
	 * @param etsEquipmentId
	 *            Integer 主键值ֵ
	 */
	public EtsEquipmentDto loadEtsEquipment(String etsEquipmentId);

	/**
	 * 删除指定的业务
	 * @param etsEquipmentId
	 *            Integer 主键值ֵ
	 */
	public void deleteEtsEquipment(String etsEquipmentId);
    
	/**
	 * 进行申请查询操作业务处理
	 */

	
	/**
	 * 进行申请查询操作业务处理(分页)
	 * 
	 * @return QueryListObj 封装了结果集及记录总数的对象
	 */
public QueryListObj listEtsEquipment();
public QueryListObj listEtsEquipmentByHql(String hql);
public QueryListObj getEtsEquipmentByHql(String hql,int beginPage, int pageSize,String sql);


	//please add your business methods start
	// to do it
	//add your business method end

	
	

	//please add your business methods start
	// to do it
	//add your business method end
	
	
}
