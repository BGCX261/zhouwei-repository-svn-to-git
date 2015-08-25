package com.techstar.dmis.service;

import java.util.List;
import java.util.Collection;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.dto.BhAsregulateDto;

	//注册子表DAO
    import com.techstar.dmis.dto.BhAsregulatedetailDto;
	import com.techstar.dmis.dto.StdStationDto;
	

//please add your business methods start
	// to do it
//add your business method end
	
/** 
 * 业务对象服务接口类
 * @author 
 * @date
 */
public interface IBhAsregulateService {

    public void addBhAsregulate(BhAsregulateDto dto);

	/**
	 * 进行增加或修改操作业务处理
	 * 
	 * @param dto
	 *BhAsregulateDto 业务传输对象
	 * 
	 */
	public void saveOrUpdateBhAsregulate(BhAsregulateDto dto);
	public void saveOrUpdateBhAsregulate(List dtos);

	/**
	 * 进行加载的业务操作
	 * @param bhAsregulateId
	 *            Integer 主键值ֵ
	 */
	public BhAsregulateDto loadBhAsregulate(String bhAsregulateId);

	/**
	 * 删除指定的业务
	 * @param bhAsregulateId
	 *            Integer 主键值ֵ
	 */
	public void deleteBhAsregulate(String bhAsregulateId);
    /**
	* 删除指定的业务集合
	**/
	public void deleteBhAsregulate(List dtos);
	
	/**
	 * 进行申请查询操作业务处理
	 */

	
	/**
	 * 进行申请查询操作业务处理(分页)
	 * 
	 * @return QueryListObj 封装了结果集及记录总数的对象
	 */
	 public QueryListObj listBhAsregulate();
	 public QueryListObj listBhAsregulateByHql(String hql);
	 public QueryListObj getBhAsregulateByHql(String hql,int beginPage, int pageSize,String sql);

	//please add your business methods start
	// to do it
	//add your business method end

	
	

 	//子表处理DAO
       public QueryListObj listBhAsregulatedetail();
   public void saveOrUpdateBhAsregulatedetail(BhAsregulatedetailDto dto);
   public void deleteBhAsregulatedetail(String asregulatedetailid);
   public BhAsregulatedetailDto loadBhAsregulatedetail(String asregulatedetailid);
   public QueryListObj listBhAsregulatedetailByHql(String hql);
   public void saveOrUpdateBhAsregulatedetail(List dtos);
   public void deleteBhAsregulatedetail(List dtos);
	
	   public QueryListObj listStdStation();
   public void saveOrUpdateStdStation(StdStationDto dto);
   public void deleteStdStation(String id);
   public StdStationDto loadStdStation(String id);
   public QueryListObj listStdStationByHql(String hql);
   public void saveOrUpdateStdStation(List dtos);
   public void deleteStdStation(List dtos);
	
	  

	//please add your business methods start
	// to do it
	//add your business method end
	
	
}
