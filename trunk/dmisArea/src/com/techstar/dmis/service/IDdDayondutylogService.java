package com.techstar.dmis.service;

import java.util.List;
import java.util.Collection;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.dto.DdDayondutylogDto;

	//注册子表DAO
    import com.techstar.dmis.dto.DdOperationnotebookDto;
	

//please add your business methods start
	// to do it
//add your business method end
	
/** 
 * 业务对象服务接口类
 * @author 
 * @date
 */
public interface IDdDayondutylogService {

    public void addDdDayondutylog(DdDayondutylogDto dto);

	/**
	 * 进行增加或修改操作业务处理
	 * 
	 * @param dto
	 *DdDayondutylogDto 业务传输对象
	 * 
	 */
	public void saveOrUpdateDdDayondutylog(DdDayondutylogDto dto);
	public void saveOrUpdateDdDayondutylog(List dtos);

	/**
	 * 进行加载的业务操作
	 * @param ddDayondutylogId
	 *            Integer 主键值ֵ
	 */
	public DdDayondutylogDto loadDdDayondutylog(String ddDayondutylogId);

	/**
	 * 删除指定的业务
	 * @param ddDayondutylogId
	 *            Integer 主键值ֵ
	 */
	public void deleteDdDayondutylog(String ddDayondutylogId);
    /**
	* 删除指定的业务集合
	**/
	public void deleteDdDayondutylog(List dtos);
	
	/**
	 * 进行申请查询操作业务处理
	 */

	
	/**
	 * 进行申请查询操作业务处理(分页)
	 * 
	 * @return QueryListObj 封装了结果集及记录总数的对象
	 */
	 public QueryListObj listDdDayondutylog();
	 public QueryListObj listDdDayondutylogByHql(String hql);
	 public QueryListObj getDdDayondutylogByHql(String hql,int beginPage, int pageSize,String sql);

	//please add your business methods start
	// to do it
	//add your business method end

	
	

 	//子表处理DAO
       public QueryListObj listDdOperationnotebook();
   public void saveOrUpdateDdOperationnotebook(DdOperationnotebookDto dto);
   public void deleteDdOperationnotebook(String fid);
   public DdOperationnotebookDto loadDdOperationnotebook(String fid);
   public QueryListObj listDdOperationnotebookByHql(String hql);
   public void saveOrUpdateDdOperationnotebook(List dtos);
   public void deleteDdOperationnotebook(List dtos);
	
	  

	//please add your business methods start
	// to do it
	//add your business method end
	
	
}
