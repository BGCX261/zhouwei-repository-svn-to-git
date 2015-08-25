package com.techstar.dmis.service;

import java.util.List;
import java.util.Collection;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.dto.FsLoaddatalistDto;

	//注册子表DAO
    import com.techstar.dmis.dto.FsLfparalistDto;
	

//please add your business methods start
	// to do it
//add your business method end
	
/** 
 * 业务对象服务接口类
 * @author 
 * @date
 */
public interface IFsLoaddatalistService {

    public void addFsLoaddatalist(FsLoaddatalistDto dto);

	/**
	 * 进行增加或修改操作业务处理
	 * 
	 * @param dto
	 *FsLoaddatalistDto 业务传输对象
	 * 
	 */
	public void saveOrUpdateFsLoaddatalist(FsLoaddatalistDto dto);
	public void saveOrUpdateFsLoaddatalist(List dtos);

	/**
	 * 进行加载的业务操作
	 * @param fsLoaddatalistId
	 *            Integer 主键值ֵ
	 */
	public FsLoaddatalistDto loadFsLoaddatalist(String fsLoaddatalistId);

	/**
	 * 删除指定的业务
	 * @param fsLoaddatalistId
	 *            Integer 主键值ֵ
	 */
	public void deleteFsLoaddatalist(String fsLoaddatalistId);
    /**
	* 删除指定的业务集合
	**/
	public void deleteFsLoaddatalist(List dtos);
	
	/**
	 * 进行申请查询操作业务处理
	 */

	
	/**
	 * 进行申请查询操作业务处理(分页)
	 * 
	 * @return QueryListObj 封装了结果集及记录总数的对象
	 */
	 public QueryListObj listFsLoaddatalist();
	 public QueryListObj listFsLoaddatalistByHql(String hql);
	 public QueryListObj getFsLoaddatalistByHql(String hql,int beginPage, int pageSize,String sql);

	//please add your business methods start
	// to do it
	//add your business method end

	
	

 	//子表处理DAO
       public QueryListObj listFsLfparalist();
   public void saveOrUpdateFsLfparalist(FsLfparalistDto dto);
   public void deleteFsLfparalist(String flinesno);
   public FsLfparalistDto loadFsLfparalist(String flinesno);
   public QueryListObj listFsLfparalistByHql(String hql);
   public void saveOrUpdateFsLfparalist(List dtos);
   public void deleteFsLfparalist(List dtos);
	
	  

	//please add your business methods start
	// to do it
	//add your business method end
	
	
}
