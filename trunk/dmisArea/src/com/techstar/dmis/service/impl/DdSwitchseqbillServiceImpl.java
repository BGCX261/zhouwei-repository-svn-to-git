package com.techstar.dmis.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import org.apache.commons.lang.StringUtils;
import com.techstar.framework.dao.IBaseJdbcDao;

import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.framework.utils.BeanHelper;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.dmis.common.DispatchConstants;
import com.techstar.dmis.dao.*;
import com.techstar.dmis.dto.DdSwitchseqbillDto;
import com.techstar.dmis.entity.DdSwitchseqbill;
import com.techstar.dmis.service.IDdSwitchseqbillService;
import com.techstar.dmis.service.workflow.IDdSwitchseqbillWFService;

import org.springframework.dao.DataAccessException;

	//注册子表DAO
    import com.techstar.dmis.dto.DdSeqbilldetailDto;
import com.techstar.dmis.entity.DdSeqbilldetail;
import com.techstar.dmis.helper.dto.WorkflowHandleDto;
	
//please add your business methods start
	// to do it
//add your business method end

/** 
 * 业务对象服务接口实现类
 * @author 
 * @date
 */
public class DdSwitchseqbillServiceImpl implements IDdSwitchseqbillService {
   //注册DAO
   private IDdSwitchseqbillDao ddSwitchseqbillDao;
   private IBaseJdbcDao baseJdbcDao ;
   private IDdSwitchseqbillWFService ddSwitchseqbillWFService;
   
  	//注册管理DAO
    	 private IDdSeqbilldetailDao ddSeqbilldetailDao;
	 public void setDdSeqbilldetailDao
	    (IDdSeqbilldetailDao ddSeqbilldetailDao) {
		 this.ddSeqbilldetailDao = ddSeqbilldetailDao;
     }
	  	

	public DdSwitchseqbillServiceImpl() {}
	
	public void addDdSwitchseqbill(DdSwitchseqbillDto dto) {
	
    	if (StringUtils.isEmpty(dto.getFcomputerno())){
		      if( StringUtils.isEmpty(dto.getFcomputerno())){
		          dto.setFcomputerno(new SequenceCreator().getUID());
		       }
		}
    	//新增时候,主对象不用管子对象的保存
		DdSwitchseqbill ddSwitchseqbill = (DdSwitchseqbill) BeanHelper.buildBean(DdSwitchseqbill.class, dto);
		ddSwitchseqbillDao.saveOrUpdate(ddSwitchseqbill);		
	}
	
    //用于实现基本增加或修改操作
	public void saveOrUpdateDdSwitchseqbill(DdSwitchseqbillDto dto) {
		if (StringUtils.isEmpty(dto.getFcomputerno())){
		      if( StringUtils.isEmpty(dto.getFcomputerno())){
		          dto.setFcomputerno(new SequenceCreator().getUID());
		       }
		}
		DdSwitchseqbill ddSwitchseqbill = (DdSwitchseqbill) BeanHelper.mapBean(DdSwitchseqbill.class, dto);
		ddSwitchseqbillDao.saveOrUpdate(ddSwitchseqbill);
	}
    //用于实现基本删除操作
	public void deleteDdSwitchseqbill(String ddSwitchseqbillId) {
		DdSwitchseqbill ddSwitchseqbill = new DdSwitchseqbill();
		ddSwitchseqbill.setFcomputerno(ddSwitchseqbillId);
		ddSwitchseqbillDao.delete(ddSwitchseqbill);
	}
//	用于实现基本删除操作
	public void deleteDdSwitchseqbill(String ddSwitchseqbillId,int version) {
		DdSwitchseqbill ddSwitchseqbill = new DdSwitchseqbill();
		ddSwitchseqbill.setFcomputerno(ddSwitchseqbillId);
		ddSwitchseqbill.setVersion(version);
		ddSwitchseqbillDao.delete(ddSwitchseqbill);
	}
	//用于实现基本删除集合操作
	public void deleteDdSwitchseqbill(List dtos){
		List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(DdSwitchseqbill.class, dtos);
		ddSwitchseqbillDao.deleteAll(pos);
	}	
   //用于实现基本DTOLOAD操作
	public DdSwitchseqbillDto loadDdSwitchseqbill(String fcomputerno) {
		DdSwitchseqbill ddSwitchseqbill = (DdSwitchseqbill) ddSwitchseqbillDao.findByPk(fcomputerno);
		DdSwitchseqbillDto dto = (DdSwitchseqbillDto) BeanHelper.mapBean(DdSwitchseqbillDto.class, ddSwitchseqbill);
		return dto;
	}
   //用于实现列表操作
   public QueryListObj listDdSwitchseqbill() {
		QueryListObj obj = ddSwitchseqbillDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdSwitchseqbillDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj listDdSwitchseqbillByHql(String hql) {
		QueryListObj obj = ddSwitchseqbillDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdSwitchseqbillDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj getDdSwitchseqbillByHql(String hql, int beginPage, int pageSize, String sql) {
		QueryListObj obj = ddSwitchseqbillDao.getQueryListByHql(hql, beginPage, pageSize);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.mapBeans(DdSwitchseqbillDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		
		List sumList = ddSwitchseqbillDao.getObjPropertySums(sql);
		//System.out.println("sumList.size():"+sumList.size());
		obj.setPropertySum(sumList);
		return obj;
	}

	
  /**
    * @business method list
	 	* @合格情况核定
	 	* @盖执行章
	 	* @操作票终止
	 	* @从典型票输入
	     */

	//please add your business methods start
	// to do it
	//add your business method end
	
	public IDdSwitchseqbillDao getDdSwitchseqbillDao() {
		return ddSwitchseqbillDao;
	}

	public void setDdSwitchseqbillDao(IDdSwitchseqbillDao ddSwitchseqbillDao) {
		this.ddSwitchseqbillDao = ddSwitchseqbillDao;
	}
	
	public void setBaseJdbcDao(IBaseJdbcDao baseJdbcDao) {
		this.baseJdbcDao = baseJdbcDao;
	}
	
	public void saveOrUpdateDdSwitchseqbill(List dtos) {
		List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			DdSwitchseqbillDto ddSwitchseqbillDto = (DdSwitchseqbillDto)dtos.get(i);
			DdSwitchseqbill ddSwitchseqbill = (DdSwitchseqbill) BeanHelper.buildBean(DdSwitchseqbill.class, ddSwitchseqbillDto);
		    pos.add(ddSwitchseqbill);
		}
		
		ddSwitchseqbillDao.saveOrUpdateAll(pos);	
	}
	
		
	
	 	//子表处理DAO
    	

   public QueryListObj listDdSeqbilldetail() {
		QueryListObj obj = ddSeqbilldetailDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdSeqbilldetailDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
		
	
   public void saveOrUpdateDdSeqbilldetail(DdSeqbilldetailDto dto){
   
     if (StringUtils.isEmpty(dto.getFoperationstepno())){
		      if( StringUtils.isEmpty(dto.getFoperationstepno())){
		          dto.setFoperationstepno(new SequenceCreator().getUID());
		       }
		}
		DdSeqbilldetail ddSeqbilldetail = (DdSeqbilldetail) BeanHelper.mapBean(DdSeqbilldetail.class, dto);
		ddSeqbilldetailDao.saveOrUpdate(ddSeqbilldetail);
   
   }
   public void deleteDdSeqbilldetail(String foperationstepno){
     
        DdSeqbilldetail ddSeqbilldetail = new DdSeqbilldetail();
		ddSeqbilldetail.setFoperationstepno(foperationstepno);
		ddSeqbilldetailDao.delete(ddSeqbilldetail);
   
   }
   public void deleteDdSeqbilldetail(DdSeqbilldetailDto dto){
	     
       DdSeqbilldetail ddSeqbilldetail = new DdSeqbilldetail();
		ddSeqbilldetail.setFoperationstepno(dto.getFoperationstepno());
		ddSeqbilldetail.setVersion(dto.getVersion());
		ddSeqbilldetailDao.delete(ddSeqbilldetail);
  
  }
   public DdSeqbilldetailDto loadDdSeqbilldetail(String foperationstepno){
        DdSeqbilldetail ddSeqbilldetail = (DdSeqbilldetail) ddSeqbilldetailDao.findByPk(foperationstepno);
		DdSeqbilldetailDto dto = (DdSeqbilldetailDto) BeanHelper.mapBean(DdSeqbilldetailDto.class, ddSeqbilldetail);
		return dto;
   }
   public QueryListObj listDdSeqbilldetailByHql(String hql){
      QueryListObj obj = ddSeqbilldetailDao.getQueryListByHql(hql);
		if (obj.getElemList() != null&&obj.getElemList().size()!=0) {
			List dtos = (List) BeanHelper.mapBeans(DdSeqbilldetailDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
   }
   public void saveOrUpdateDdSeqbilldetail(List dtos){
     
   List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			DdSeqbilldetailDto ddSeqbilldetailDto = (DdSeqbilldetailDto)dtos.get(i);
			//加主键
			 if( StringUtils.isEmpty(ddSeqbilldetailDto.getFoperationstepno())){
				 ddSeqbilldetailDto.setFoperationstepno(new SequenceCreator().getUID());
		       }
			 /*
			 if(ddSeqbilldetailDto.getFserialno() ==0){
				 ddSeqbilldetailDto.setFserialno(this.getMaxSerialno(ddSeqbilldetailDto.getZddseqbilldetail1().getFcomputerno()));
		       }
		     */  
			 //计算步骤数
			 if (!StringUtils.isEmpty(ddSeqbilldetailDto.getFcontent())){
				 String fcontent = ddSeqbilldetailDto.getFcontent();
				 String[] fsteps = fcontent.split("、");
				 ddSeqbilldetailDto.setFstep(fsteps.length);
			 }
			 
			 
			DdSeqbilldetail ddSeqbilldetail = (DdSeqbilldetail) BeanHelper.mapBean(DdSeqbilldetail.class, ddSeqbilldetailDto);
			
			
		    pos.add(ddSeqbilldetail);
		}
		
		ddSeqbilldetailDao.saveOrUpdateAll(pos);	
   
   }
   
   public void deleteDdSeqbilldetail(List dtos){
      List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(DdSeqbilldetail.class, dtos);
		ddSeqbilldetailDao.deleteAll(pos);
   }
   /**
    * 获得操作票的执行步骤号
    * @return
    */
   public String getMaxfmanualno(){
	   String hql ="from DdSwitchseqbill order by fmanualno desc ";
		QueryListObj obj = this.listDdSwitchseqbillByHql(hql);
		if (obj == null) { 
			return "1";
		}
		List list = obj.getElemList();
		if (list == null || list.size() < 1){
			return "1";
		}
		else{
			DdSwitchseqbillDto dto = (DdSwitchseqbillDto) list.get(0);
			int fmanulno = Integer.parseInt(dto.getFmanualno()) +1;
			return String.valueOf(fmanulno);
		}
		
   }
   
   /**
    * 获得操作步骤的序号
    * @param fcomputerno
    * @return
    */
   public int getMaxSerialno(String fcomputerno){
	   String hql ="from DdSeqbilldetail where zddseqbilldetail1.fcomputerno='"+fcomputerno+"'"+" order by fserialno desc ";
		QueryListObj obj = this.listDdSeqbilldetailByHql(hql);
		if (obj == null) { 
			return 1;
		}
		List list = obj.getElemList();
		if (list == null || list.size() < 1){
			return 1;
		}
		else{
			DdSeqbilldetailDto dto = (DdSeqbilldetailDto) list.get(0);
			int fserialno = dto.getFserialno()+1;
			return fserialno;
		}
   }
   /**
    * 删除记录后对序号重新排序
    * @param fcomputerno
    * @param fserialno
    */
   public void setSerialnoafterdelete(String fcomputerno, int serialno){
	  
	   String hql ="update dmis_dd_seqbilldetail set version=version +1, fserialno = fserialno -1 where FComputerNo='"+fcomputerno+"'"
	   				+"and fserialno >"+String.valueOf(serialno);
	   this.baseJdbcDao.executeSql(hql);
	   
   }
   /**
    * 盖执行章的处理
    * @param fid
    */
   public void setexecutestatus(String fid){
	  try
	  {
	   String hql ="update dmis_dd_seqbilldetail set version=version +1, fstepstatus = '"+DispatchConstants.ddSeqbillDetailStepStatus_EXE+"' where FComputerNo='"+fid+"' "
	   		+" and (fstepstatus is null or fstepstatus = '')"
			+" and (fcontent is not null or fcontent <>'')";
	   System.out.println("*****************"+hql);
	   this.baseJdbcDao.executeSql(hql);
	  }
	  catch(Exception e){
		  
	  }
	 
	  
   }
   
   public void setcancelstatus(String fid){
	   try
	   {
	   String sql = "update dmis_dd_switchseqbill set version=version +1, fexcutestatus='"+DispatchConstants.ddSwitchSeqbill_CANCEL+"'"
		  +" where fcomputerno ='"+fid+"'";
		  System.out.println("*****************"+sql);
		  this.baseJdbcDao.executeSql(sql);
		}
	   catch(Exception e){
		   
	   }
   }
   /**
    * 
    * @param fid
    */
   public void setswitchbillexestutas(String fid){
	   try
	   {
	   String sql = "update dmis_dd_switchseqbill set version=version +1, fexcutestatus='"+DispatchConstants.ddSwitchSeqbill_EXE+"', fstatus='"+DispatchConstants.DdSwitchseqBill_WORKFLOW_CITY_STATUS_OVER+"'"
		  +" where fcomputerno ='"+fid+"'";
		  System.out.println("*****************"+sql);
		  this.baseJdbcDao.executeSql(sql);
		}
	   catch(Exception e){
		   
	   }
   }
   /**
    * 盖终止章
    * @param fid
    */
   public void setStopStatus(String fid){
	   try
		  {
		   String hql ="update dmis_dd_seqbilldetail set version=version +1, fstepstatus = '"+DispatchConstants.ddSeqbillDetailSetpstatus_STOP+"' where FComputerNo='"+fid+"' "
		   		+" and (fstepstatus is null or fstepstatus = '')"
				+" and (fcontent is not null or fcontent <>'')";
		   //System.out.println("*****************"+hql);
		   this.baseJdbcDao.executeSql(hql);
		   
		  }
		  catch(Exception e){
			  
		  }
		  //this.baseJdbcDao.executeSql("");
   }
   
   public void setswitchbillstopstatus(String fid){
	   try
		  {
		   String sql = "update dmis_dd_switchseqbill set version = version +1, fexcutestatus='"+DispatchConstants.ddSwitchSeqbill_EXE+"', fstatus='"+DispatchConstants.DdSwitchseqBill_WORKFLOW_CITY_STATUS_OVER+"' "
			  +" where fcomputerno ='"+fid+"'";
			  System.out.println("*****************"+sql);
			  this.baseJdbcDao.executeSql(sql);
		   
		  }
		  catch(Exception e){
			  
		  }
   }
   
   /**
    * 取得步骤号
    * @param fcomputerno
    */
   public void getSwitchbillsteps(String fcomputerno){
	   try
		  {
		   String sql ="update dmis_dd_switchseqbill set version=version +1, fstepcounts = (select count(*) from dmis_dd_seqbilldetail where FComputerNo='"+fcomputerno+"' "
		   		+" and (fstepstatus ='"+DispatchConstants.ddSeqbillDetailStepStatus_EXE+"'))"
		   		+" where FComputerNo='"+fcomputerno+"'";
				
		   System.out.println("*****************"+sql);
		   this.baseJdbcDao.executeSql(sql);
		   
		  }
		  catch(Exception e){
			  
		  }
		 
   }
   
   

public void deleteDdSeqbilldetail(String foperationstepno, int version) {
	DdSeqbilldetail ddSeqbilldetail = new DdSeqbilldetail();
	ddSeqbilldetail.setFoperationstepno(foperationstepno);
	ddSeqbilldetail.setVersion(version);
	ddSeqbilldetailDao.delete(ddSeqbilldetail);
	
}


public void setDdSwitchseqbillWFService(
		IDdSwitchseqbillWFService ddSwitchseqbillWFService) {
	this.ddSwitchseqbillWFService = ddSwitchseqbillWFService;
}
   
//启动
public void start(WorkflowHandleDto dto) throws DataAccessException{
	int val  = ddSwitchseqbillWFService.start(dto);
	if(val==1){
		DdSwitchseqbill ddswitch = ddSwitchseqbillDao.findByPk(dto.getBusId());
		ddswitch.setFexcutestatus(DispatchConstants.ddSeqbillDetailStepStatus_APPROVE);
		ddswitch.setFstatus(DispatchConstants.DdSwitchseqBill_WORKFLOW_CITY_STATUS_APPROVE);
		ddSwitchseqbillDao.saveOrUpdate(ddswitch);
	}
	
}
//审核
public void ddSwitchseqBillApprove(WorkflowHandleDto dto) throws DataAccessException{
	int val = ddSwitchseqbillWFService.ddSwitchseqBillApprove(dto);
	if(val==1){
		DdSwitchseqbill ddswitch = ddSwitchseqbillDao.findByPk(dto.getBusId());
		//通过
		if(DispatchConstants.DdSwitchseqBill_WORKFLOW_CITY_APPROVE_TRANSIT_YES_NUM.equals(dto.getTransitionFlag())){
			ddswitch.setFstatus(DispatchConstants.DdSwitchseqBill_WORKFLOW_CITY_STATUS_EXEC);
			ddswitch.setFexcutestatus(DispatchConstants.ddSeqbillDetailStepStatus_APPROVED);
		}else{
			ddswitch.setFstatus(DispatchConstants.DdSwitchseqBill_WORKFLOW_CITY_STATUS_MODIFY);
			ddswitch.setFexcutestatus(DispatchConstants.ddSeqbillDetailStepStatus_MODIFY);
		}
		ddSwitchseqbillDao.saveOrUpdate(ddswitch);
	}
}
//执行
public void ddSwitchseqBillExec(WorkflowHandleDto dto) throws DataAccessException{
	String flag = dto.getTransitionFlag();
	if(flag.equals(DispatchConstants.DdSwitchseqBill_WORKFLOW_CITY_EXEC_NO_NUM)){
		dto.setTransitionFlag("-1");
		
	}else{
		dto.setTransitionFlag("1");
	}
	int val = ddSwitchseqbillWFService.ddSwitchseqBillExec(dto);
	if(val==1&&flag.equals(DispatchConstants.DdSwitchseqBill_WORKFLOW_CITY_EXEC_NO_NUM)){
		DdSwitchseqbill ddswitch = ddSwitchseqbillDao.findByPk(dto.getBusId());
		ddswitch.setFexcutestatus(DispatchConstants.ddSeqbillDetailStepStatus_APPROVE);
		ddswitch.setFstatus(DispatchConstants.DdSwitchseqBill_WORKFLOW_CITY_STATUS_APPROVE);
		ddSwitchseqbillDao.saveOrUpdate(ddswitch);
	}else if(val==1&&flag.equals(DispatchConstants.DdSwitchseqBill_WORKFLOW_CITY_STOP_YES_NUM)){
		// 终止
		setStopStatus(dto.getBusId());
		setswitchbillstopstatus(dto.getBusId());

		//操作步骤数
		getSwitchbillsteps(dto.getBusId());
		
	}else if(val==1&&flag.equals(DispatchConstants.DdSwitchseqBill_WORKFLOW_CITY_EXEC_YES_NUM)){
		setexecutestatus(dto.getBusId());
		setswitchbillexestutas(dto.getBusId());
		//操作步骤数
		getSwitchbillsteps(dto.getBusId());
	}
}
//修改
public void ddSwitchseqBillModify(WorkflowHandleDto dto) throws DataAccessException{
	int val = ddSwitchseqbillWFService.ddSwitchseqBillModify(dto);
	if(val==1){
		DdSwitchseqbill ddswitch = ddSwitchseqbillDao.findByPk(dto.getBusId());
		ddswitch.setFexcutestatus(DispatchConstants.ddSeqbillDetailStepStatus_APPROVE);
		ddswitch.setFstatus(DispatchConstants.DdSwitchseqBill_WORKFLOW_CITY_STATUS_APPROVE);
		ddSwitchseqbillDao.saveOrUpdate(ddswitch);
	}
}
	  	


	
}
