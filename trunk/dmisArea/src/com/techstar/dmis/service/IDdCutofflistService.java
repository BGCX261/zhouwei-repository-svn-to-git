package com.techstar.dmis.service;

import java.util.List;
import java.util.Collection;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.dto.DdCutofflistDto;

	//注册子表DAO
    import com.techstar.dmis.dto.DdCutoffdetaillistDto;
	

//please add your business methods start
	// to do it
//add your business method end
	
/** 
 * 业务对象服务接口类
 * @author 
 * @date
 */
public interface IDdCutofflistService {

    public void addDdCutofflist(DdCutofflistDto dto);

	/**
	 * 进行增加或修改操作业务处理
	 * 
	 * @param dto
	 *DdCutofflistDto 业务传输对象
	 * 
	 */
	public void saveOrUpdateDdCutofflist(DdCutofflistDto dto);
	public void saveOrUpdateDdCutofflist(List dtos);

	/**
	 * 进行加载的业务操作
	 * @param ddCutofflistId
	 *            Integer 主键值ֵ
	 */
	public DdCutofflistDto loadDdCutofflist(String ddCutofflistId);

	/**
	 * 删除指定的业务
	 * @param ddCutofflistId
	 *            Integer 主键值ֵ
	 */
	public void deleteDdCutofflist(String ddCutofflistId);
    /**
	* 删除指定的业务集合
	**/
	public void deleteDdCutofflist(List dtos);
	
	/**
	 * 进行申请查询操作业务处理
	 */

	
	/**
	 * 进行申请查询操作业务处理(分页)
	 * 
	 * @return QueryListObj 封装了结果集及记录总数的对象
	 */
	 public QueryListObj listDdCutofflist();
	 public QueryListObj listDdCutofflistByHql(String hql);
	 public QueryListObj getDdCutofflistByHql(String hql,int beginPage, int pageSize,String sql);

	//please add your business methods start
	// to do it
	//add your business method end

	
	

 	//子表处理DAO
       public QueryListObj listDdCutoffdetaillist();
   public void saveOrUpdateDdCutoffdetaillist(DdCutoffdetaillistDto dto);
   public void deleteDdCutoffdetaillist(String fdetailid);
   public DdCutoffdetaillistDto loadDdCutoffdetaillist(String fdetailid);
   public QueryListObj listDdCutoffdetaillistByHql(String hql);
   public void saveOrUpdateDdCutoffdetaillist(List dtos);
   public void deleteDdCutoffdetaillist(List dtos);
	
	  

	//please add your business methods start
	// to do it
	//add your business method end
	
	
}
