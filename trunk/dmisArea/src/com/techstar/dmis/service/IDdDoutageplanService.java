package com.techstar.dmis.service;

import java.util.List;
import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.dto.DdDoutageplanDto;

	//注册子表DAO
import com.techstar.dmis.dto.DdAccidentbriefDto;
import com.techstar.dmis.dto.DdMoutageplanDto;
    import com.techstar.dmis.dto.DdRepairdetailDto;
	import com.techstar.dmis.dto.DdDayplandelaylistDto;
	import com.techstar.dmis.dto.DdDayplanexcutelistDto;
import com.techstar.dmis.dto.DdWoutageplanDto;
	import com.techstar.dmis.dto.DdfsModechangelistDto;
	import com.techstar.dmis.dto.DayplancoopraterelDto;
	import com.techstar.dmis.dto.DdDayplanfixvaluerelDto;
	import com.techstar.dmis.dto.ZdhOpexaminelistDto;
import com.techstar.dmis.dto.StdUnfinishreasonDto;
import com.techstar.dmis.helper.dto.WorkflowHandleDto;
	

//please add your business methods start
	// to do it
//add your business method end
	
/** 
 * 业务对象服务接口类
 * @author 
 * @date
 */
public interface IDdDoutageplanService {

    public void addDdDoutageplan(DdDoutageplanDto dto);

	/**
	 * 进行增加或修改操作业务处理
	 * 
	 * @param dto
	 *DdDoutageplanDto 业务传输对象
	 * 
	 */
	public void saveOrUpdateDdDoutageplan(DdDoutageplanDto dto);
	public void saveOrUpdateDdDoutageplan(List dtos);

	/**
	 * 进行加载的业务操作
	 * @param ddDoutageplanId
	 *            Integer 主键值ֵ
	 */
	public DdDoutageplanDto loadDdDoutageplan(String ddDoutageplanId);

	/**
	 * 删除指定的业务
	 * @param ddDoutageplanId
	 *            Integer 主键值ֵ
	 */
	public void deleteDdDoutageplan(String ddDoutageplanId);
    /**
	* 删除指定的业务集合
	**/
	public void deleteDdDoutageplan(List dtos);
	
	/**
	 * 进行申请查询操作业务处理
	 */

	public void deleteDdDoutageplan(DdDoutageplanDto dto);
	/**
	 * 进行申请查询操作业务处理(分页)
	 * 
	 * @return QueryListObj 封装了结果集及记录总数的对象
	 */
	 public QueryListObj listDdDoutageplan();
	 public QueryListObj listDdDoutageplanByHql(String hql);
	 public QueryListObj getDdDoutageplanByHql(String hql,int beginPage, int pageSize,String sql);
	 public void saveOrUpdateDdDoutageplan(DdDoutageplanDto daydto,DdWoutageplanDto monthedto,DdAccidentbriefDto ddacdto);
	 public void cancleDdDoutageplan(WorkflowHandleDto wdto,DdDoutageplanDto daydto,DdWoutageplanDto woutdto);
	 public void saveOrUpdateDdDoutageplan(List days,List wplans,List accidents);
	//please add your business methods start
	// to do it
	//add your business method end

	
	
   /*
 	//子表处理DAO
       public QueryListObj listDdRepairdetail();
   public void saveOrUpdateDdRepairdetail(DdRepairdetailDto dto);
   public void deleteDdRepairdetail(String fid);
   public DdRepairdetailDto loadDdRepairdetail(String fid);
   public QueryListObj listDdRepairdetailByHql(String hql);
   public void saveOrUpdateDdRepairdetail(List dtos);
   public void deleteDdRepairdetail(List dtos);
   */
   //得到最早的下令日期
   public QueryListObj getElearlydate(String hql);
   
	   public QueryListObj listDdDayplandelaylist();
   public void saveOrUpdateDdDayplandelaylist(DdDayplandelaylistDto dto);
   public void deleteDdDayplandelaylist(String fid);
   public DdDayplandelaylistDto loadDdDayplandelaylist(String fid);
   public QueryListObj listDdDayplandelaylistByHql(String hql);
   public void saveOrUpdateDdDayplandelaylist(List dtos);
   public void deleteDdDayplandelaylist(List dtos);
	
	   public QueryListObj listDdDayplanexcutelist();
   public void saveOrUpdateDdDayplanexcutelist(DdDayplanexcutelistDto dto);
   public void deleteDdDayplanexcutelist(String fid);
   public DdDayplanexcutelistDto loadDdDayplanexcutelist(String fid);
   public QueryListObj listDdDayplanexcutelistByHql(String hql);
   public void saveOrUpdateDdDayplanexcutelist(List dtos);
   public void deleteDdDayplanexcutelist(List dtos);
	
	   public QueryListObj listDdfsModechangelist();
   public void saveOrUpdateDdfsModechangelist(DdfsModechangelistDto dto);
   public void deleteDdfsModechangelist(String fid);
   public DdfsModechangelistDto loadDdfsModechangelist(String fid);
   public QueryListObj listDdfsModechangelistByHql(String hql);
   public void saveOrUpdateDdfsModechangelist(List dtos);
   public void deleteDdfsModechangelist(List dtos);
   
	/*public QueryListObj listDdfsModechangelistByHql(String hql);
	public void saveOrUpdateDdfsModechangelist(List dtos);
	public void deleteDdfsModechangelist(String ddmid,int version);
	public void deleteDdfsModechangelists(List dtos);*/
	
	   public QueryListObj listDayplancoopraterel();
   public void saveOrUpdateDayplancoopraterel(DayplancoopraterelDto dto);
   public void deleteDayplancoopraterel(String frelid);
   public DayplancoopraterelDto loadDayplancoopraterel(String frelid);
   public QueryListObj listDayplancoopraterelByHql(String hql);
   public void saveOrUpdateDayplancoopraterel(List dtos);
   public void deleteDayplancoopraterel(List dtos);
   public void joinDayplancoopraterel(String name,String date,String[] ids);
   public QueryListObj listDayplancoopraterelByGroupHql(String hql);
	/*
	   public QueryListObj listDdDayplanfixvaluerel();
   public void saveOrUpdateDdDayplanfixvaluerel(DdDayplanfixvaluerelDto dto);
   public void deleteDdDayplanfixvaluerel(String frelid);
   public DdDayplanfixvaluerelDto loadDdDayplanfixvaluerel(String frelid);
   public QueryListObj listDdDayplanfixvaluerelByHql(String hql);
   public void saveOrUpdateDdDayplanfixvaluerel(List dtos);
   public void deleteDdDayplanfixvaluerel(List dtos);
	*/
	   public QueryListObj listZdhOpexaminelist();
   public void saveOrUpdateZdhOpexaminelist(ZdhOpexaminelistDto dto);
   public void deleteZdhOpexaminelist(String examinationid);
   public ZdhOpexaminelistDto loadZdhOpexaminelist(String examinationid);
   public QueryListObj listZdhOpexaminelistByHql(String hql);
   public void saveOrUpdateZdhOpexaminelist(List dtos);
   public void deleteZdhOpexaminelist(List dtos);
   
   //启动
	public int start(WorkflowHandleDto dto) throws DataAccessException;
	//计划专工整理计划
	public int ddDayPlanSpecArrange(WorkflowHandleDto dto) throws DataAccessException ;
	//专工下发计划
	public int ddDayPlanSent(WorkflowHandleDto dto) throws DataAccessException ;
	//填写计划执行情况
	public int ddDayPlanFillExec(WorkflowHandleDto dto) throws DataAccessException ;	
	//处理日计划并通知客户
	public int ddDayPlanInfocustomer(WorkflowHandleDto dto) throws DataAccessException ;
	//客户中心进行日计划可否执行的批准操作
	public int ddDayPlanCustomerApprove(WorkflowHandleDto dto) throws DataAccessException ;
	//会签
	public int ddDayPlanCoursign(WorkflowHandleDto dto) throws DataAccessException ;
	//计划专工归档
	public int ddDayPlanSpecKeepon(WorkflowHandleDto dto) throws DataAccessException ;	

	
	  
 
	//please add your business methods start
	// to do it
	//add your business method end
	
	
}
