package com.techstar.dmis.service;

import java.util.List;
import java.util.Collection;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.dto.FsApprovebookDto;

	//注册子表DAO
    import com.techstar.dmis.dto.FsApprovebookdetailDto;
	import com.techstar.dmis.dto.FsAfrelDto;
	import com.techstar.dmis.dto.FsApproveeqprelDto;
	import com.techstar.dmis.dto.FsAllappendixDto;
	import com.techstar.dmis.dto.BhAsregulateDto;
	

//please add your business methods start
	// to do it
//add your business method end
	
/** 
 * 业务对象服务接口类
 * @author 
 * @date
 */
public interface IFsApprovebookService {

    public void addFsApprovebook(FsApprovebookDto dto);

	/**
	 * 进行增加或修改操作业务处理
	 * 
	 * @param dto
	 *FsApprovebookDto 业务传输对象
	 * 
	 */
	public void saveOrUpdateFsApprovebook(FsApprovebookDto dto);
	public void saveOrUpdateFsApprovebook(List dtos);

	/**
	 * 进行加载的业务操作
	 * @param fsApprovebookId
	 *            Integer 主键值ֵ
	 */
	public FsApprovebookDto loadFsApprovebook(String fsApprovebookId);

	/**
	 * 删除指定的业务
	 * @param fsApprovebookId
	 *            Integer 主键值ֵ
	 */
	public void deleteFsApprovebook(String fsApprovebookId);
    /**
	* 删除指定的业务集合
	**/
	public void deleteFsApprovebook(List dtos);
	
	/**
	 * 进行申请查询操作业务处理
	 */

	
	/**
	 * 进行申请查询操作业务处理(分页)
	 * 
	 * @return QueryListObj 封装了结果集及记录总数的对象
	 */
	 public QueryListObj listFsApprovebook();
	 public QueryListObj listFsApprovebookByHql(String hql);
	 public QueryListObj getFsApprovebookByHql(String hql,int beginPage, int pageSize,String sql);

	//please add your business methods start
	// to do it
	//add your business method end

	
	

 	//子表处理DAO
       public QueryListObj listFsApprovebookdetail();
   public void saveOrUpdateFsApprovebookdetail(FsApprovebookdetailDto dto);
   public void deleteFsApprovebookdetail(String fapprovexcuteno);
   public FsApprovebookdetailDto loadFsApprovebookdetail(String fapprovexcuteno);
   public QueryListObj listFsApprovebookdetailByHql(String hql);
   public void saveOrUpdateFsApprovebookdetail(List dtos);
   public void deleteFsApprovebookdetail(List dtos);
	
	   public QueryListObj listFsAfrel();
   public void saveOrUpdateFsAfrel(FsAfrelDto dto);
   public void deleteFsAfrel(String fapprovfixrelno);
   public FsAfrelDto loadFsAfrel(String fapprovfixrelno);
   public QueryListObj listFsAfrelByHql(String hql);
   public void saveOrUpdateFsAfrel(List dtos);
   public void deleteFsAfrel(List dtos);
	
	   public QueryListObj listFsApproveeqprel();
   public void saveOrUpdateFsApproveeqprel(FsApproveeqprelDto dto);
   public void deleteFsApproveeqprel(String fappeqprelid);
   public FsApproveeqprelDto loadFsApproveeqprel(String fappeqprelid);
   public QueryListObj listFsApproveeqprelByHql(String hql);
   public void saveOrUpdateFsApproveeqprel(List dtos);
   public void deleteFsApproveeqprel(List dtos);
	
	   public QueryListObj listFsAllappendix();
   public void saveOrUpdateFsAllappendix(FsAllappendixDto dto);
   public void deleteFsAllappendix(String f_id);
   public FsAllappendixDto loadFsAllappendix(String f_id);
   public QueryListObj listFsAllappendixByHql(String hql);
   public void saveOrUpdateFsAllappendix(List dtos);
   public void deleteFsAllappendix(List dtos);
	
	   public QueryListObj listBhAsregulate();
   public void saveOrUpdateBhAsregulate(BhAsregulateDto dto);
   public void deleteBhAsregulate(String asregulateid);
   public BhAsregulateDto loadBhAsregulate(String asregulateid);
   public QueryListObj listBhAsregulateByHql(String hql);
   public void saveOrUpdateBhAsregulate(List dtos);
   public void deleteBhAsregulate(List dtos);
	
	  

	//please add your business methods start
	// to do it
	//add your business method end
	
	
}
