package com.techstar.dmis.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import org.apache.commons.lang.StringUtils;
import com.techstar.framework.dao.IBaseJdbcDao;

import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.framework.utils.BeanHelper;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.dmis.common.DispatchConstants;
import com.techstar.dmis.common.ZdhConstants;
import com.techstar.dmis.dao.*;
import com.techstar.dmis.dto.ZdhCharalterrecordDto;
import com.techstar.dmis.dto.ZdhRmrecDto;
import com.techstar.dmis.entity.DdEnsuringpsmanage;
import com.techstar.dmis.entity.ZdhCharalterrecord;
import com.techstar.dmis.entity.ZdhRmrec;
import com.techstar.dmis.helper.dto.WorkflowHandleDto;
import com.techstar.dmis.service.IZdhCharalterrecordService;
import org.springframework.dao.DataAccessException;

import com.techstar.dmis.service.workflow.IZdhCharalterrecordWFService;

//please add your business methods start
	// to do it
//add your business method end

/** 
 * 业务对象服务接口实现类
 * @author 
 * @date
 */
public class ZdhCharalterrecordServiceImpl implements IZdhCharalterrecordService {
   //注册DAO
   private IZdhCharalterrecordDao zdhCharalterrecordDao;
   private IBaseJdbcDao baseJdbcDao ;
   // 注册工作流
   private IZdhCharalterrecordWFService zdhCharalterrecordWFService;
   
  	//注册管理DAO
    	 private IZdhRmrecDao zdhRmrecDao;
	 public void setZdhRmrecDao
	    (IZdhRmrecDao zdhRmrecDao) {
		 this.zdhRmrecDao = zdhRmrecDao;
     }
		 private IFsApprovebookDao fsApprovebookDao;
	 public void setFsApprovebookDao
	    (IFsApprovebookDao fsApprovebookDao) {
		 this.fsApprovebookDao = fsApprovebookDao;
     }
		 private IZdhAutoondutylogDao zdhAutoondutylogDao;
		private Object ZdhRmrec;
	 public void setZdhAutoondutylogDao
	    (IZdhAutoondutylogDao zdhAutoondutylogDao) {
		 this.zdhAutoondutylogDao = zdhAutoondutylogDao;
     }
	  	

	public ZdhCharalterrecordServiceImpl() {}
	
	public void addZdhCharalterrecord(ZdhCharalterrecordDto dto) {
	
    	if (StringUtils.isEmpty(dto.getRecordsno())){
		      if( StringUtils.isEmpty(dto.getRecordsno())){
		          dto.setRecordsno(new SequenceCreator().getUID());
		       }
		}
    	//新增时候,主对象不用管子对象的保存
		ZdhCharalterrecord zdhCharalterrecord = (ZdhCharalterrecord) BeanHelper.buildBean(ZdhCharalterrecord.class, dto);
		zdhCharalterrecordDao.saveOrUpdate(zdhCharalterrecord);		
	}
	
    //用于实现基本增加或修改操作
	public void saveOrUpdateZdhCharalterrecord(ZdhCharalterrecordDto dto) {
		if (StringUtils.isEmpty(dto.getRecordsno())){
		      if( StringUtils.isEmpty(dto.getRecordsno())){
		          dto.setRecordsno(new SequenceCreator().getUID());
		       }
		}
		ZdhCharalterrecord zdhCharalterrecord = (ZdhCharalterrecord) BeanHelper.buildBean(ZdhCharalterrecord.class, dto);
		zdhCharalterrecordDao.saveOrUpdate(zdhCharalterrecord);
	}
    //用于实现基本删除操作
	public void deleteZdhCharalterrecord(String zdhCharalterrecordId) {
		ZdhCharalterrecord zdhCharalterrecord = new ZdhCharalterrecord();
		zdhCharalterrecord.setRecordsno(zdhCharalterrecordId);
		zdhCharalterrecordDao.delete(zdhCharalterrecord);
	}
   //用于实现基本DTOLOAD操作
	public ZdhCharalterrecordDto loadZdhCharalterrecord(String recordsno) {
		ZdhCharalterrecord zdhCharalterrecord = (ZdhCharalterrecord) zdhCharalterrecordDao.findByPk(recordsno);
		ZdhCharalterrecordDto dto = (ZdhCharalterrecordDto) BeanHelper.buildBean(ZdhCharalterrecordDto.class, zdhCharalterrecord);
		return dto;
	}
//用于实现列表操作
   public QueryListObj listZdhCharalterrecord() {
		QueryListObj obj = zdhCharalterrecordDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhCharalterrecordDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj listZdhCharalterrecordByHql(String hql) {
		QueryListObj obj = zdhCharalterrecordDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhCharalterrecord.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj getZdhCharalterrecordByHql(String hql, int beginPage, int pageSize, String sql) {
		QueryListObj obj = zdhCharalterrecordDao.getQueryListByHql(hql, beginPage, pageSize);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhCharalterrecord.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		
		List sumList = zdhCharalterrecordDao.getObjPropertySums(sql);
		//System.out.println("sumList.size():"+sumList.size());
		obj.setPropertySum(sumList);
		return obj;
	}
	
	public void deleteZdhCharalterrecord(String zdhCharalterrecordId,int version) {
		ZdhCharalterrecord zdhCharalterrecord = new ZdhCharalterrecord();
		zdhCharalterrecord.setRecordsno(zdhCharalterrecordId);
		zdhCharalterrecord.setVersion(version);
		zdhCharalterrecordDao.delete(zdhCharalterrecord);
	}

	
  /**
    * @business method list
	 	* @遥测数据修改
	 	* @关联批准书查询		
	     */

	//please add your business methods start
	// to do it
	//add your business method end
	
	
	
	public void saveOrUpdateZdhCharalterrecord(List dtos) {
		List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			ZdhCharalterrecordDto zdhCharalterrecordDto = (ZdhCharalterrecordDto)dtos.get(i);
			ZdhCharalterrecord zdhCharalterrecord = (ZdhCharalterrecord) BeanHelper.buildBean(ZdhCharalterrecord.class, zdhCharalterrecordDto);
		    pos.add(zdhCharalterrecord);
		}
		zdhCharalterrecordDao.saveOrUpdateAll(pos);	
	}
	
		
	/**
	 * 根椐外键取数据集
	 * @param foreignId
	 * @return
	 */
	public ZdhCharalterrecordDto getZdhCharRecordByForeign(String foreignId){
		QueryListObj obj = zdhCharalterrecordDao.getQueryList();
		if (obj.getElemList() != null) {
			List dataList = obj.getElemList();
			for(int i=0; i<dataList.size(); i++){
				ZdhCharalterrecord zdhCharalterrecord = (ZdhCharalterrecord)dataList.get(i);
				if(zdhCharalterrecord != null){
					if(zdhCharalterrecord.getFzdhrmrec2() != null){
						Collection coll = zdhCharalterrecord.getFzdhrmrec2();
						Iterator it = coll.iterator();
						for(;it.hasNext();){
							ZdhRmrec zdhRmrec = (ZdhRmrec)it.next();
							if(zdhRmrec != null){
								if(foreignId.equalsIgnoreCase(zdhRmrec.getRecordno())){
									ZdhCharalterrecordDto dto = (ZdhCharalterrecordDto)BeanHelper.mapBean(ZdhCharalterrecordDto.class, zdhCharalterrecord);
									return dto;
								}
							}
						}
					}
				}
			}
		}
		return null;
	}

	
	/**
	    * @business method list
		 	* @遥测数据修改
		 	* @工作流－调度审核
		 	* @工作流－图形专工和数据专工会签
		 	* @关联批准书查询
		 	* @工作流－运维中心任务分配
		 	* @系统图同步
		 	* @工作流－调度室领导签字
		 	* @工作流－盖执行章
		     */
		
		//please add your business methods start
		// to do it
		//add your business method end
	
	/**======================================工作流服务==========================================**/
//	启动
	public void start(WorkflowHandleDto dto) throws DataAccessException {
		int ireturn = zdhCharalterrecordWFService.start(dto);
		
		ZdhCharalterrecord zdhCharalterrecord = zdhCharalterrecordDao.findByPk(dto.getBusId());
		zdhCharalterrecord.setFstatus(ZdhConstants.ZdhCharalterrecord_WORKFLOW_CITY_STATUS_SIGN);
		zdhCharalterrecord.setFexcutestatus(ZdhConstants.ZDH_DISPOSE);
		zdhCharalterrecordDao.saveOrUpdate(zdhCharalterrecord);		
	}
	
//	调度室领导签字
	public void zdhCharalterrecordSign(WorkflowHandleDto dto) throws DataAccessException {
		int ireturn = zdhCharalterrecordWFService.zdhCharalterrecordSign(dto);
		
		ZdhCharalterrecord zdhCharalterrecord = zdhCharalterrecordDao.findByPk(dto.getBusId());
		zdhCharalterrecord.setFstatus(ZdhConstants.ZdhCharalterrecord_WORKFLOW_CITY_STATUS_ASSIGN);
		zdhCharalterrecord.setFexcutestatus(ZdhConstants.ZDH_DISPOSE);
		zdhCharalterrecordDao.saveOrUpdate(zdhCharalterrecord);
	}
	
//	运维中心任务分配
	public void zdhCharalterrecordAssign(WorkflowHandleDto dto) throws DataAccessException {
		int ireturn = zdhCharalterrecordWFService.ZdhCharalterrecordAssign(dto);
	
		ZdhCharalterrecord zdhCharalterrecord = zdhCharalterrecordDao.findByPk(dto.getBusId());
		zdhCharalterrecord.setFstatus(ZdhConstants.ZdhCharalterrecord_WORKFLOW_CITY_STATUS_COURSIGN);
		zdhCharalterrecord.setFexcutestatus(ZdhConstants.ZDH_DISPOSE);
		zdhCharalterrecordDao.saveOrUpdate(zdhCharalterrecord);
	}
	
//	图形和数据会签处理
	public void zdhCharalterrecordCoursign(WorkflowHandleDto dto) throws DataAccessException {
		int ireturn = zdhCharalterrecordWFService.zdhCharalterrecordCoursign(dto);
		
		if(ireturn==1){
			ZdhCharalterrecord zdhCharalterrecord = zdhCharalterrecordDao.findByPk(dto.getBusId());
			zdhCharalterrecord.setFstatus(ZdhConstants.ZdhCharalterrecord_WORKFLOW_CITY_STATUS_APPROVE);
			zdhCharalterrecord.setFexcutestatus(ZdhConstants.ZDH_DISPOSE);
			zdhCharalterrecordDao.saveOrUpdate(zdhCharalterrecord);
		}
	}
	
//	调度审核
	public void zdhCharalterrecordApprove(WorkflowHandleDto dto) throws DataAccessException {
		int ireturn =  zdhCharalterrecordWFService.zdhCharalterrecordApprove(dto);
		ZdhCharalterrecord zdhCharalterrecord = zdhCharalterrecordDao.findByPk(dto.getBusId());
		if(dto.getTransitionFlag().equalsIgnoreCase("1") || dto.getTransitionFlag().equalsIgnoreCase("")){
			zdhCharalterrecord.setFstatus(ZdhConstants.ZdhCharalterrecord_WORKFLOW_CITY_STATUS_EXEC);
			zdhCharalterrecord.setFexcutestatus(ZdhConstants.ZDH_DISPOSE);
		} else if(dto.getTransitionFlag().equalsIgnoreCase("-1")){
			zdhCharalterrecord.setFstatus(ZdhConstants.ZdhCharalterrecord_WORKFLOW_CITY_STATUS_ASSIGN);
			zdhCharalterrecord.setFexcutestatus(ZdhConstants.ZDH_DISPOSE);
		}
		zdhCharalterrecordDao.saveOrUpdate(zdhCharalterrecord);
		
	}

//	盖执行章
	public void zdhCharalterrecordExec(WorkflowHandleDto dto) throws DataAccessException {
		int ireturn =  zdhCharalterrecordWFService.zdhCharalterrecordExec(dto);
		
		ZdhCharalterrecord zdhCharalterrecord = zdhCharalterrecordDao.findByPk(dto.getBusId());
		zdhCharalterrecord.setFstatus(ZdhConstants.ZdhCharalterrecord_WORKFLOW_CITY_STATUS_OVER);
		zdhCharalterrecord.setFexcutestatus(ZdhConstants.ZDH_EXECUTED);
		zdhCharalterrecordDao.saveOrUpdate(zdhCharalterrecord);
	}

	/**=======================================================================================**/
	
	
	public IZdhCharalterrecordDao getZdhCharalterrecordDao() {
		return zdhCharalterrecordDao;
	}

	public void setZdhCharalterrecordDao(IZdhCharalterrecordDao zdhCharalterrecordDao) {
		this.zdhCharalterrecordDao = zdhCharalterrecordDao;
	}
	
	public void setBaseJdbcDao(IBaseJdbcDao baseJdbcDao) {
		this.baseJdbcDao = baseJdbcDao;
	}
	//	注册工作流服务
	public IZdhCharalterrecordWFService getZdhCharalterrecordWFService(){
		return zdhCharalterrecordWFService;
	}
	public void setZdhCharalterrecordWFService(IZdhCharalterrecordWFService zdhCharalterrecordWFService){
		this.zdhCharalterrecordWFService=zdhCharalterrecordWFService;
	}
}
