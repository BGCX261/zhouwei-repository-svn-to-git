package com.techstar.dmis.service;

import java.util.List;
import java.util.Collection;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.dto.FsRmchangbillDto;

	//注册子表DAO
    import com.techstar.dmis.dto.DdfsModechangelistDto;
	

//please add your business methods start
	// to do it
//add your business method end
	
/** 
 * 业务对象服务接口类
 * @author 
 * @date
 */
public interface IFsRmchangbillService {

    public void addFsRmchangbill(FsRmchangbillDto dto);

	/**
	 * 进行增加或修改操作业务处理
	 * 
	 * @param dto
	 *FsRmchangbillDto 业务传输对象
	 * 
	 */
	public void saveOrUpdateFsRmchangbill(FsRmchangbillDto dto);
	public void saveOrUpdateFsRmchangbill(List dtos);

	/**
	 * 进行加载的业务操作
	 * @param fsRmchangbillId
	 *            Integer 主键值ֵ
	 */
	public FsRmchangbillDto loadFsRmchangbill(String fsRmchangbillId);

	/**
	 * 删除指定的业务
	 * @param fsRmchangbillId
	 *            Integer 主键值ֵ
	 */
	public void deleteFsRmchangbill(String fsRmchangbillId);
    /**
	* 删除指定的业务集合
	**/
	public void deleteFsRmchangbill(List dtos);
	
	/**
	 * 进行申请查询操作业务处理
	 */

	
	/**
	 * 进行申请查询操作业务处理(分页)
	 * 
	 * @return QueryListObj 封装了结果集及记录总数的对象
	 */
	 public QueryListObj listFsRmchangbill();
	 public QueryListObj listFsRmchangbillByHql(String hql);
	 public QueryListObj getFsRmchangbillByHql(String hql,int beginPage, int pageSize,String sql);

	//please add your business methods start
	// to do it
	//add your business method end

	
	

 	//子表处理DAO
       public QueryListObj listDdfsModechangelist();
   public void saveOrUpdateDdfsModechangelist(DdfsModechangelistDto dto);
   public void deleteDdfsModechangelist(String fid);
   public DdfsModechangelistDto loadDdfsModechangelist(String fid);
   public QueryListObj listDdfsModechangelistByHql(String hql);
   public void saveOrUpdateDdfsModechangelist(List dtos);
   public void deleteDdfsModechangelist(List dtos);
	
	  

	//please add your business methods start
	// to do it
	//add your business method end
	
	
}
