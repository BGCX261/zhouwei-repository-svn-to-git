package com.techstar.dmis.service;

import java.util.List;
import java.util.Collection;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.dto.StdManufacturerDto;

	//注册子表DAO
    import com.techstar.dmis.dto.EtsEquipmentDto;
	

//please add your business methods start
	// to do it
//add your business method end
	
/** 
 * 业务对象服务接口类
 * @author 
 * @date
 */
public interface IStdManufacturerService {

    public void addStdManufacturer(StdManufacturerDto dto);

	/**
	 * 进行增加或修改操作业务处理
	 * 
	 * @param dto
	 *StdManufacturerDto 业务传输对象
	 * 
	 */
	public void saveOrUpdateStdManufacturer(StdManufacturerDto dto);
	public void saveOrUpdateStdManufacturer(List dtos);

	/**
	 * 进行加载的业务操作
	 * @param stdManufacturerId
	 *            Integer 主键值ֵ
	 */
	public StdManufacturerDto loadStdManufacturer(String stdManufacturerId);

	/**
	 * 删除指定的业务
	 * @param stdManufacturerId
	 *            Integer 主键值ֵ
	 */
	public void deleteStdManufacturer(String stdManufacturerId);
    /**
	* 删除指定的业务集合
	**/
	public void deleteStdManufacturer(List dtos);
	
	/**
	 * 进行申请查询操作业务处理
	 */

	
	/**
	 * 进行申请查询操作业务处理(分页)
	 * 
	 * @return QueryListObj 封装了结果集及记录总数的对象
	 */
	 public QueryListObj listStdManufacturer();
	 public QueryListObj listStdManufacturerByHql(String hql);
	 public QueryListObj getStdManufacturerByHql(String hql,int beginPage, int pageSize,String sql);

	//please add your business methods start
	// to do it
	//add your business method end

	
	

 	//子表处理DAO
       public QueryListObj listEtsEquipment();
   public void saveOrUpdateEtsEquipment(EtsEquipmentDto dto);
   public void deleteEtsEquipment(String feqpid);
   public EtsEquipmentDto loadEtsEquipment(String feqpid);
   public QueryListObj listEtsEquipmentByHql(String hql);
   public void saveOrUpdateEtsEquipment(List dtos);
   public void deleteEtsEquipment(List dtos);
	
	  

	//please add your business methods start
	// to do it
	//add your business method end
	
	
}
