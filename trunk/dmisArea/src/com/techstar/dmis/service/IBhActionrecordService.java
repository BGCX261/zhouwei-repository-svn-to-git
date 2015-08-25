package com.techstar.dmis.service;

import java.util.List;
import java.util.Collection;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.dto.BhActionrecordDto;

	//注册子表DAO
    import com.techstar.dmis.dto.StdBhtresponseDto;
	import com.techstar.dmis.dto.StdPreasontypeDto;
	import com.techstar.dmis.dto.StdBheqpfaultDto;
	import com.techstar.dmis.dto.DdAccidentbriefDto;
	

//please add your business methods start
	// to do it
//add your business method end
	
/** 
 * 业务对象服务接口类
 * @author 
 * @date
 */
public interface IBhActionrecordService {

    public void addBhActionrecord(BhActionrecordDto dto);

	/**
	 * 进行增加或修改操作业务处理
	 * 
	 * @param dto
	 *BhActionrecordDto 业务传输对象
	 * 
	 */
	public void saveOrUpdateBhActionrecord(BhActionrecordDto dto);
	public void saveOrUpdateBhActionrecord(List dtos);

	/**
	 * 进行加载的业务操作
	 * @param bhActionrecordId
	 *            Integer 主键值ֵ
	 */
	public BhActionrecordDto loadBhActionrecord(String bhActionrecordId);

	/**
	 * 删除指定的业务
	 * @param bhActionrecordId
	 *            Integer 主键值ֵ
	 */
	public void deleteBhActionrecord(String bhActionrecordId);
    /**
	* 删除指定的业务集合
	**/
	public void deleteBhActionrecord(List dtos);
	
	/**
	 * 进行申请查询操作业务处理
	 */

	
	/**
	 * 进行申请查询操作业务处理(分页)
	 * 
	 * @return QueryListObj 封装了结果集及记录总数的对象
	 */
	 public QueryListObj listBhActionrecord();
	 public QueryListObj listBhActionrecordByHql(String hql);
	 public QueryListObj getBhActionrecordByHql(String hql,int beginPage, int pageSize,String sql);

	//please add your business methods start
	// to do it
	//add your business method end

	
	

 	//子表处理DAO
       public QueryListObj listStdBhtresponse();
   public void saveOrUpdateStdBhtresponse(StdBhtresponseDto dto);
   public void deleteStdBhtresponse(String id);
   public StdBhtresponseDto loadStdBhtresponse(String id);
   public QueryListObj listStdBhtresponseByHql(String hql);
   public void saveOrUpdateStdBhtresponse(List dtos);
   public void deleteStdBhtresponse(List dtos);
	
	   public QueryListObj listStdPreasontype();
   public void saveOrUpdateStdPreasontype(StdPreasontypeDto dto);
   public void deleteStdPreasontype(String id);
   public StdPreasontypeDto loadStdPreasontype(String id);
   public QueryListObj listStdPreasontypeByHql(String hql);
   public void saveOrUpdateStdPreasontype(List dtos);
   public void deleteStdPreasontype(List dtos);
	
	   public QueryListObj listStdBheqpfault();
   public void saveOrUpdateStdBheqpfault(StdBheqpfaultDto dto);
   public void deleteStdBheqpfault(String id);
   public StdBheqpfaultDto loadStdBheqpfault(String id);
   public QueryListObj listStdBheqpfaultByHql(String hql);
   public void saveOrUpdateStdBheqpfault(List dtos);
   public void deleteStdBheqpfault(List dtos);
	
	   public QueryListObj listDdAccidentbrief();
   public void saveOrUpdateDdAccidentbrief(DdAccidentbriefDto dto);
   public void deleteDdAccidentbrief(String faccidentid);
   public DdAccidentbriefDto loadDdAccidentbrief(String faccidentid);
   public QueryListObj listDdAccidentbriefByHql(String hql);
   public void saveOrUpdateDdAccidentbrief(List dtos);
   public void deleteDdAccidentbrief(List dtos);
	
	  

	//please add your business methods start
	// to do it
	//add your business method end
	
	
}
