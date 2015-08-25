package com.techstar.dmis.service;

import java.util.List;
import java.util.Collection;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.dto.DdWoutageplanDto;

	//注册子表DAO
    import com.techstar.dmis.dto.DdRepairdetailDto;
	import com.techstar.dmis.dto.DdMoutageplanDto;
	

//please add your business methods start
	// to do it
//add your business method end
	
/** 
 * 业务对象服务接口类
 * @author 
 * @date
 */
public interface IDdWoutageplanService {

    public void addDdWoutageplan(DdWoutageplanDto dto);

	/**
	 * 进行增加或修改操作业务处理
	 * 
	 * @param dto
	 *DdWoutageplanDto 业务传输对象
	 * 
	 */
	public void saveOrUpdateDdWoutageplan(DdWoutageplanDto dto);
	public void saveOrUpdateDdWoutageplan(List dtos);

	/**
	 * 进行加载的业务操作
	 * @param ddWoutageplanId
	 *            Integer 主键值ֵ
	 */
	public DdWoutageplanDto loadDdWoutageplan(String ddWoutageplanId);

	/**
	 * 删除指定的业务
	 * @param ddWoutageplanId
	 *            Integer 主键值ֵ
	 */
	public void deleteDdWoutageplan(String ddWoutageplanId);
    /**
	* 删除指定的业务集合
	**/
	public void deleteDdWoutageplan(List dtos);
	
	/**
	 * 进行申请查询操作业务处理
	 */

	
	/**
	 * 进行申请查询操作业务处理(分页)
	 * 
	 * @return QueryListObj 封装了结果集及记录总数的对象
	 */
	 public QueryListObj listDdWoutageplan();
	 public QueryListObj listDdWoutageplanByHql(String hql);
	 public QueryListObj getDdWoutageplanByHql(String hql,int beginPage, int pageSize,String sql);

	//please add your business methods start
	// to do it
	//add your business method end

	
	

 	//子表处理DAO
       public QueryListObj listDdRepairdetail();
   public void saveOrUpdateDdRepairdetail(DdRepairdetailDto dto);
   public void deleteDdRepairdetail(String fid);
   public DdRepairdetailDto loadDdRepairdetail(String fid);
   public QueryListObj listDdRepairdetailByHql(String hql);
   public void saveOrUpdateDdRepairdetail(List dtos);
   public void deleteDdRepairdetail(List dtos);
	
	   public QueryListObj listDdMoutageplan();
   public void saveOrUpdateDdMoutageplan(DdMoutageplanDto dto);
   public void deleteDdMoutageplan(String fmonthplanno);
   public DdMoutageplanDto loadDdMoutageplan(String fmonthplanno);
   public QueryListObj listDdMoutageplanByHql(String hql);
   public void saveOrUpdateDdMoutageplan(List dtos);
   public void deleteDdMoutageplan(List dtos);
	
	  

	//please add your business methods start
	// to do it
	//add your business method end
	
	
}
