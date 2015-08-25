package com.techstar.dmis.service;

import java.util.List;
import java.util.Collection;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.dto.FsLfparalistDto;

	//注册子表DAO
    import com.techstar.dmis.dto.FsLoaddatalistDto;
	import com.techstar.dmis.dto.StdLfroundDto;
	

//please add your business methods start
	// to do it
//add your business method end
	
/** 
 * 业务对象服务接口类
 * @author 
 * @date
 */
public interface IFsLfparalistService {

    public void addFsLfparalist(FsLfparalistDto dto);

	/**
	 * 进行增加或修改操作业务处理
	 * 
	 * @param dto
	 *FsLfparalistDto 业务传输对象
	 * 
	 */
	public void saveOrUpdateFsLfparalist(FsLfparalistDto dto);
	public void saveOrUpdateFsLfparalist(List dtos);

	/**
	 * 进行加载的业务操作
	 * @param fsLfparalistId
	 *            Integer 主键值ֵ
	 */
	public FsLfparalistDto loadFsLfparalist(String fsLfparalistId);

	/**
	 * 删除指定的业务
	 * @param fsLfparalistId
	 *            Integer 主键值ֵ
	 */
	public void deleteFsLfparalist(String fsLfparalistId);
    /**
	* 删除指定的业务集合
	**/
	public void deleteFsLfparalist(List dtos);
	
	/**
	 * 进行申请查询操作业务处理
	 */

	
	/**
	 * 进行申请查询操作业务处理(分页)
	 * 
	 * @return QueryListObj 封装了结果集及记录总数的对象
	 */
	 public QueryListObj listFsLfparalist();
	 public QueryListObj listFsLfparalistByHql(String hql);
	 public QueryListObj getFsLfparalistByHql(String hql,int beginPage, int pageSize,String sql);

	//please add your business methods start
	// to do it
	//add your business method end

	
	

 	//子表处理DAO
       public QueryListObj listFsLoaddatalist();
   public void saveOrUpdateFsLoaddatalist(FsLoaddatalistDto dto);
   public void deleteFsLoaddatalist(String floaddatano);
   public FsLoaddatalistDto loadFsLoaddatalist(String floaddatano);
   public QueryListObj listFsLoaddatalistByHql(String hql);
   public void saveOrUpdateFsLoaddatalist(List dtos);
   public void deleteFsLoaddatalist(List dtos);
	
	   public QueryListObj listStdLfround();
   public void saveOrUpdateStdLfround(StdLfroundDto dto);
   public void deleteStdLfround(String id);
   public StdLfroundDto loadStdLfround(String id);
   public QueryListObj listStdLfroundByHql(String hql);
   public void saveOrUpdateStdLfround(List dtos);
   public void deleteStdLfround(List dtos);
	
	  

	//please add your business methods start
	// to do it
	//add your business method end
	
	
}
