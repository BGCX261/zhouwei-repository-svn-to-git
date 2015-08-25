package com.techstar.dmis.service;

import java.util.List;
import java.util.Collection;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.dto.DdSwitchseqbillDto;

	//注册子表DAO
import com.techstar.dmis.dto.DdSeqbilldetailDto;
import com.techstar.dmis.helper.dto.WorkflowHandleDto;
	

//please add your business methods start
	// to do it
//add your business method end
	
/** 
 * 业务对象服务接口类
 * @author 
 * @date
 */
public interface IDdSwitchseqbillService {

    public void addDdSwitchseqbill(DdSwitchseqbillDto dto);

	/**
	 * 进行增加或修改操作业务处理
	 * 
	 * @param dto
	 *DdSwitchseqbillDto 业务传输对象
	 * 
	 */
	public void saveOrUpdateDdSwitchseqbill(DdSwitchseqbillDto dto);
	public void saveOrUpdateDdSwitchseqbill(List dtos);

	/**
	 * 进行加载的业务操作
	 * @param ddSwitchseqbillId
	 *            Integer 主键值ֵ
	 */
	public DdSwitchseqbillDto loadDdSwitchseqbill(String ddSwitchseqbillId);

	/**
	 * 删除指定的业务
	 * @param ddSwitchseqbillId
	 *            Integer 主键值ֵ
	 */
	public void deleteDdSwitchseqbill(String ddSwitchseqbillId);
	/**
	 * 删除指定的业务

	 * @param ddSwitchseqbillId
	 *            Integer 主键值ֵ

	 */
	public void deleteDdSwitchseqbill(String ddSwitchseqbillId,int version);
    /**
	* 删除指定的业务集合
	**/
	public void deleteDdSwitchseqbill(List dtos);
	
	/**
	 * 进行申请查询操作业务处理
	 */

	
	/**
	 * 进行申请查询操作业务处理(分页)
	 * 
	 * @return QueryListObj 封装了结果集及记录总数的对象
	 */
	 public QueryListObj listDdSwitchseqbill();
	 public QueryListObj listDdSwitchseqbillByHql(String hql);
	 public QueryListObj getDdSwitchseqbillByHql(String hql,int beginPage, int pageSize,String sql);

	//please add your business methods start
	// to do it
	//add your business method end

	/**
	 * 执行章
	 */
	 public void setexecutestatus(String fid);
	/**
	 * 作废
	 * @param fid
	 */
	 public void setcancelstatus(String fid);
	 
	  public void setswitchbillexestutas(String fid);

	 /**
	  * 终止章
	  * @param fid
	  */
	 public void setStopStatus(String fid);
	 public void setswitchbillstopstatus(String fid);

 	//子表处理DAO
       public QueryListObj listDdSeqbilldetail();
   public void saveOrUpdateDdSeqbilldetail(DdSeqbilldetailDto dto);
   public void deleteDdSeqbilldetail(String foperationstepno);
   public void deleteDdSeqbilldetail(String foperationstepno,int version);
   public void deleteDdSeqbilldetail(DdSeqbilldetailDto dto);
   public DdSeqbilldetailDto loadDdSeqbilldetail(String foperationstepno);
   public QueryListObj listDdSeqbilldetailByHql(String hql);
   public void saveOrUpdateDdSeqbilldetail(List dtos);
   public void deleteDdSeqbilldetail(List dtos);
   public String getMaxfmanualno();
   public int getMaxSerialno(String fcomputerno);
   public void setSerialnoafterdelete(String fcomputerno, int serialno);
   public void getSwitchbillsteps(String fcomputerno);
 	  

   
   public void start(WorkflowHandleDto dto);
   public void ddSwitchseqBillApprove(WorkflowHandleDto dto);
   public void ddSwitchseqBillExec(WorkflowHandleDto dto);
   public void ddSwitchseqBillModify(WorkflowHandleDto dto);
	//please add your business methods start
	// to do it
	//add your business method end
	
	
}
