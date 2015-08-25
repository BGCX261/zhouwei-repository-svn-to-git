package com.techstar.dmis.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import org.apache.commons.lang.StringUtils;
import com.techstar.framework.dao.IBaseJdbcDao;

import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.framework.utils.BeanHelper;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.dmis.dao.*;
import com.techstar.dmis.dto.ZdhAutoondutylogDto;
import com.techstar.dmis.entity.ZdhAutoondutylog;
import com.techstar.dmis.service.IZdhAutoondutylogService;
import org.springframework.dao.DataAccessException;

	//注册子表DAO
    import com.techstar.dmis.dto.ZdhWorkbillDto;
import com.techstar.dmis.entity.ZdhWorkbill;
	import com.techstar.dmis.dto.ZdhMachineworklistDto;
import com.techstar.dmis.entity.ZdhMachineworklist;
	import com.techstar.dmis.dto.ZdhRmrecDto;
import com.techstar.dmis.entity.ZdhRmrec;
	import com.techstar.dmis.dto.ZdhRsrecordDto;
import com.techstar.dmis.entity.ZdhRsrecord;
	import com.techstar.dmis.dto.ZdhCharalterrecordDto;
import com.techstar.dmis.entity.ZdhCharalterrecord;
	import com.techstar.dmis.dto.ZdhFaultlistDto;
import com.techstar.dmis.entity.ZdhFaultlist;
	import com.techstar.dmis.dto.ZdhTransrecordDto;
import com.techstar.dmis.entity.ZdhTransrecord;
	import com.techstar.dmis.dto.ZdhOpexaminelistDto;
import com.techstar.dmis.entity.ZdhOpexaminelist;
	
//please add your business methods start
	// to do it
//add your business method end

/** 
 * 业务对象服务接口实现类
 * @author 
 * @date
 */
public class ZdhAutoondutylogServiceImpl implements IZdhAutoondutylogService {
   //注册DAO
   private IZdhAutoondutylogDao zdhAutoondutylogDao;
   private IBaseJdbcDao baseJdbcDao ;
   
  	//注册管理DAO
    	 private IZdhWorkbillDao zdhWorkbillDao;
	 public void setZdhWorkbillDao
	    (IZdhWorkbillDao zdhWorkbillDao) {
		 this.zdhWorkbillDao = zdhWorkbillDao;
     }
		 private IZdhMachineworklistDao zdhMachineworklistDao;
	 public void setZdhMachineworklistDao
	    (IZdhMachineworklistDao zdhMachineworklistDao) {
		 this.zdhMachineworklistDao = zdhMachineworklistDao;
     }
		 private IZdhRmrecDao zdhRmrecDao;
	 public void setZdhRmrecDao
	    (IZdhRmrecDao zdhRmrecDao) {
		 this.zdhRmrecDao = zdhRmrecDao;
     }
		 private IZdhRsrecordDao zdhRsrecordDao;
	 public void setZdhRsrecordDao
	    (IZdhRsrecordDao zdhRsrecordDao) {
		 this.zdhRsrecordDao = zdhRsrecordDao;
     }
		 private IZdhCharalterrecordDao zdhCharalterrecordDao;
	 public void setZdhCharalterrecordDao
	    (IZdhCharalterrecordDao zdhCharalterrecordDao) {
		 this.zdhCharalterrecordDao = zdhCharalterrecordDao;
     }
		 private IZdhFaultlistDao zdhFaultlistDao;
	 public void setZdhFaultlistDao
	    (IZdhFaultlistDao zdhFaultlistDao) {
		 this.zdhFaultlistDao = zdhFaultlistDao;
     }
		 private IZdhTransrecordDao zdhTransrecordDao;
	 public void setZdhTransrecordDao
	    (IZdhTransrecordDao zdhTransrecordDao) {
		 this.zdhTransrecordDao = zdhTransrecordDao;
     }
		 private IZdhOpexaminelistDao zdhOpexaminelistDao;
	 public void setZdhOpexaminelistDao
	    (IZdhOpexaminelistDao zdhOpexaminelistDao) {
		 this.zdhOpexaminelistDao = zdhOpexaminelistDao;
     }
	  	

	public ZdhAutoondutylogServiceImpl() {}
	
	public void addZdhAutoondutylog(ZdhAutoondutylogDto dto) {
	
    	if (StringUtils.isEmpty(dto.getOndutyno())){
		      if( StringUtils.isEmpty(dto.getOndutyno())){
		          dto.setOndutyno(new SequenceCreator().getUID());
		       }
		}
    	//新增时候,主对象不用管子对象的保存
		ZdhAutoondutylog zdhAutoondutylog = (ZdhAutoondutylog) BeanHelper.buildBean(ZdhAutoondutylog.class, dto);
		zdhAutoondutylogDao.saveOrUpdate(zdhAutoondutylog);		
	}
	
    //用于实现基本增加或修改操作
	public void saveOrUpdateZdhAutoondutylog(ZdhAutoondutylogDto dto) {
		if (StringUtils.isEmpty(dto.getOndutyno())){
		      if( StringUtils.isEmpty(dto.getOndutyno())){
		          dto.setOndutyno(new SequenceCreator().getUID());
		       }
		}
		ZdhAutoondutylog zdhAutoondutylog = (ZdhAutoondutylog) BeanHelper.buildBean(ZdhAutoondutylog.class, dto);
		zdhAutoondutylogDao.saveOrUpdate(zdhAutoondutylog);
	}
    //用于实现基本删除操作
	public void deleteZdhAutoondutylog(String zdhAutoondutylogId) {
		ZdhAutoondutylog zdhAutoondutylog = new ZdhAutoondutylog();
		zdhAutoondutylog.setOndutyno(zdhAutoondutylogId);
		zdhAutoondutylogDao.delete(zdhAutoondutylog);
	}
	//用于实现基本删除集合操作
	public void deleteZdhAutoondutylog(List dtos){
		List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(ZdhAutoondutylog.class, dtos);
		zdhAutoondutylogDao.deleteAll(pos);
	}	
   //用于实现基本DTOLOAD操作
	public ZdhAutoondutylogDto loadZdhAutoondutylog(String ondutyno) {
		ZdhAutoondutylog zdhAutoondutylog = (ZdhAutoondutylog) zdhAutoondutylogDao.findByPk(ondutyno);
		ZdhAutoondutylogDto dto = (ZdhAutoondutylogDto) BeanHelper.buildBean(ZdhAutoondutylogDto.class, zdhAutoondutylog);
		return dto;
	}
   //用于实现列表操作
   public QueryListObj listZdhAutoondutylog() {
		QueryListObj obj = zdhAutoondutylogDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhAutoondutylogDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj listZdhAutoondutylogByHql(String hql) {
		QueryListObj obj = zdhAutoondutylogDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhAutoondutylogDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj getZdhAutoondutylogByHql(String hql, int beginPage, int pageSize, String sql) {
		QueryListObj obj = zdhAutoondutylogDao.getQueryListByHql(hql, beginPage, pageSize);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhAutoondutylogDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		
		List sumList = zdhAutoondutylogDao.getObjPropertySums(sql);
		//System.out.println("sumList.size():"+sumList.size());
		obj.setPropertySum(sumList);
		return obj;
	}

	
  /**
    * @business method list
	 	* @交接班
	     */

	//please add your business methods start
	// to do it
	//add your business method end
	
	public IZdhAutoondutylogDao getZdhAutoondutylogDao() {
		return zdhAutoondutylogDao;
	}

	public void setZdhAutoondutylogDao(IZdhAutoondutylogDao zdhAutoondutylogDao) {
		this.zdhAutoondutylogDao = zdhAutoondutylogDao;
	}
	
	public void setBaseJdbcDao(IBaseJdbcDao baseJdbcDao) {
		this.baseJdbcDao = baseJdbcDao;
	}
	
	public void saveOrUpdateZdhAutoondutylog(List dtos) {
		List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			ZdhAutoondutylogDto zdhAutoondutylogDto = (ZdhAutoondutylogDto)dtos.get(i);
			ZdhAutoondutylog zdhAutoondutylog = (ZdhAutoondutylog) BeanHelper.buildBean(ZdhAutoondutylog.class, zdhAutoondutylogDto);
		    pos.add(zdhAutoondutylog);
		}
		
		zdhAutoondutylogDao.saveOrUpdateAll(pos);	
	}
	
		
	
	 	//子表处理DAO
    	

   public QueryListObj listZdhWorkbill() {
		QueryListObj obj = zdhWorkbillDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhWorkbillDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
		
	
   public void saveOrUpdateZdhWorkbill(ZdhWorkbillDto dto){
   
     if (StringUtils.isEmpty(dto.getWorkbillid())){
		      if( StringUtils.isEmpty(dto.getWorkbillid())){
		          dto.setWorkbillid(new SequenceCreator().getUID());
		       }
		}
		ZdhWorkbill zdhWorkbill = (ZdhWorkbill) BeanHelper.buildBean(ZdhWorkbill.class, dto);
		zdhWorkbillDao.saveOrUpdate(zdhWorkbill);
   
   }
   public void deleteZdhWorkbill(String workbillid){
     
        ZdhWorkbill zdhWorkbill = new ZdhWorkbill();
		zdhWorkbill.setWorkbillid(workbillid);
		zdhWorkbillDao.delete(zdhWorkbill);
   
   }
   public ZdhWorkbillDto loadZdhWorkbill(String workbillid){
        ZdhWorkbill zdhWorkbill = (ZdhWorkbill) zdhWorkbillDao.findByPk(workbillid);
		ZdhWorkbillDto dto = (ZdhWorkbillDto) BeanHelper.buildBean(ZdhWorkbillDto.class, zdhWorkbill);
		return dto;
   }
   public QueryListObj listZdhWorkbillByHql(String hql){
      QueryListObj obj = zdhWorkbillDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhWorkbillDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
   }
   public void saveOrUpdateZdhWorkbill(List dtos){
     
   List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			ZdhWorkbillDto zdhWorkbillDto = (ZdhWorkbillDto)dtos.get(i);
			ZdhWorkbill zdhWorkbill = (ZdhWorkbill) BeanHelper.buildBean(ZdhWorkbill.class, zdhWorkbillDto);
		    pos.add(zdhWorkbill);
		}
		
		zdhWorkbillDao.saveOrUpdateAll(pos);	
   
   }
   
   public void deleteZdhWorkbill(List dtos){
      List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(ZdhWorkbill.class, dtos);
		zdhWorkbillDao.deleteAll(pos);
   }
	
		

   public QueryListObj listZdhMachineworklist() {
		QueryListObj obj = zdhMachineworklistDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhMachineworklistDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
		
	
   public void saveOrUpdateZdhMachineworklist(ZdhMachineworklistDto dto){
   
     if (StringUtils.isEmpty(dto.getJobid())){
		      if( StringUtils.isEmpty(dto.getJobid())){
		          dto.setJobid(new SequenceCreator().getUID());
		       }
		}
		ZdhMachineworklist zdhMachineworklist = (ZdhMachineworklist) BeanHelper.buildBean(ZdhMachineworklist.class, dto);
		zdhMachineworklistDao.saveOrUpdate(zdhMachineworklist);
   
   }
   public void deleteZdhMachineworklist(String jobid){
     
        ZdhMachineworklist zdhMachineworklist = new ZdhMachineworklist();
		zdhMachineworklist.setJobid(jobid);
		zdhMachineworklistDao.delete(zdhMachineworklist);
   
   }
   public ZdhMachineworklistDto loadZdhMachineworklist(String jobid){
        ZdhMachineworklist zdhMachineworklist = (ZdhMachineworklist) zdhMachineworklistDao.findByPk(jobid);
		ZdhMachineworklistDto dto = (ZdhMachineworklistDto) BeanHelper.buildBean(ZdhMachineworklistDto.class, zdhMachineworklist);
		return dto;
   }
   public QueryListObj listZdhMachineworklistByHql(String hql){
      QueryListObj obj = zdhMachineworklistDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhMachineworklistDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
   }
   public void saveOrUpdateZdhMachineworklist(List dtos){
     
   List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			ZdhMachineworklistDto zdhMachineworklistDto = (ZdhMachineworklistDto)dtos.get(i);
			ZdhMachineworklist zdhMachineworklist = (ZdhMachineworklist) BeanHelper.buildBean(ZdhMachineworklist.class, zdhMachineworklistDto);
		    pos.add(zdhMachineworklist);
		}
		
		zdhMachineworklistDao.saveOrUpdateAll(pos);	
   
   }
   
   public void deleteZdhMachineworklist(List dtos){
      List pos = new ArrayList();
		pos = (List)BeanHelper.mapBeans(ZdhMachineworklist.class, dtos);
		zdhMachineworklistDao.deleteAll(pos);
   }
	
		

   public QueryListObj listZdhRmrec() {
		QueryListObj obj = zdhRmrecDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhRmrecDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
		
	
   public void saveOrUpdateZdhRmrec(ZdhRmrecDto dto){
   
     if (StringUtils.isEmpty(dto.getRecordno())){
		      if( StringUtils.isEmpty(dto.getRecordno())){
		          dto.setRecordno(new SequenceCreator().getUID());
		       }
		}
		ZdhRmrec zdhRmrec = (ZdhRmrec) BeanHelper.buildBean(ZdhRmrec.class, dto);
		zdhRmrecDao.saveOrUpdate(zdhRmrec);
   
   }
   public void deleteZdhRmrec(String recordno){
     
        ZdhRmrec zdhRmrec = new ZdhRmrec();
		zdhRmrec.setRecordno(recordno);
		zdhRmrecDao.delete(zdhRmrec);
   
   }
   public ZdhRmrecDto loadZdhRmrec(String recordno){
        ZdhRmrec zdhRmrec = (ZdhRmrec) zdhRmrecDao.findByPk(recordno);
		ZdhRmrecDto dto = (ZdhRmrecDto) BeanHelper.buildBean(ZdhRmrecDto.class, zdhRmrec);
		return dto;
   }
   public QueryListObj listZdhRmrecByHql(String hql){
      QueryListObj obj = zdhRmrecDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhRmrecDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
   }
   public void saveOrUpdateZdhRmrec(List dtos){
     
   List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			ZdhRmrecDto zdhRmrecDto = (ZdhRmrecDto)dtos.get(i);
			ZdhRmrec zdhRmrec = (ZdhRmrec) BeanHelper.buildBean(ZdhRmrec.class, zdhRmrecDto);
		    pos.add(zdhRmrec);
		}
		
		zdhRmrecDao.saveOrUpdateAll(pos);	
   
   }
   
   public void deleteZdhRmrec(List dtos){
      List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(ZdhRmrec.class, dtos);
		zdhRmrecDao.deleteAll(pos);
   }
	
		

   public QueryListObj listZdhRsrecord() {
		QueryListObj obj = zdhRsrecordDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhRsrecordDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
		
	
   public void saveOrUpdateZdhRsrecord(ZdhRsrecordDto dto){
   
     if (StringUtils.isEmpty(dto.getRecordid())){
		      if( StringUtils.isEmpty(dto.getRecordid())){
		          dto.setRecordid(new SequenceCreator().getUID());
		       }
		}
		ZdhRsrecord zdhRsrecord = (ZdhRsrecord) BeanHelper.buildBean(ZdhRsrecord.class, dto);
		zdhRsrecordDao.saveOrUpdate(zdhRsrecord);
   
   }
   public void deleteZdhRsrecord(String recordid){
     
        ZdhRsrecord zdhRsrecord = new ZdhRsrecord();
		zdhRsrecord.setRecordid(recordid);
		zdhRsrecordDao.delete(zdhRsrecord);
   
   }
   public ZdhRsrecordDto loadZdhRsrecord(String recordid){
        ZdhRsrecord zdhRsrecord = (ZdhRsrecord) zdhRsrecordDao.findByPk(recordid);
		ZdhRsrecordDto dto = (ZdhRsrecordDto) BeanHelper.buildBean(ZdhRsrecordDto.class, zdhRsrecord);
		return dto;
   }
   public QueryListObj listZdhRsrecordByHql(String hql){
      QueryListObj obj = zdhRsrecordDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhRsrecordDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
   }
   public void saveOrUpdateZdhRsrecord(List dtos){
     
   List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			ZdhRsrecordDto zdhRsrecordDto = (ZdhRsrecordDto)dtos.get(i);
			ZdhRsrecord zdhRsrecord = (ZdhRsrecord) BeanHelper.buildBean(ZdhRsrecord.class, zdhRsrecordDto);
		    pos.add(zdhRsrecord);
		}
		
		zdhRsrecordDao.saveOrUpdateAll(pos);	
   
   }
   
   public void deleteZdhRsrecord(List dtos){
      List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(ZdhRsrecord.class, dtos);
		zdhRsrecordDao.deleteAll(pos);
   }
	
		

   public QueryListObj listZdhCharalterrecord() {
		QueryListObj obj = zdhCharalterrecordDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhCharalterrecordDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
		
	
   public void saveOrUpdateZdhCharalterrecord(ZdhCharalterrecordDto dto){
   
     if (StringUtils.isEmpty(dto.getRecordsno())){
		      if( StringUtils.isEmpty(dto.getRecordsno())){
		          dto.setRecordsno(new SequenceCreator().getUID());
		       }
		}
		ZdhCharalterrecord zdhCharalterrecord = (ZdhCharalterrecord) BeanHelper.buildBean(ZdhCharalterrecord.class, dto);
		zdhCharalterrecordDao.saveOrUpdate(zdhCharalterrecord);
   
   }
   public void deleteZdhCharalterrecord(String recordsno){
     
        ZdhCharalterrecord zdhCharalterrecord = new ZdhCharalterrecord();
		zdhCharalterrecord.setRecordsno(recordsno);
		zdhCharalterrecordDao.delete(zdhCharalterrecord);
   
   }
   public ZdhCharalterrecordDto loadZdhCharalterrecord(String recordsno){
        ZdhCharalterrecord zdhCharalterrecord = (ZdhCharalterrecord) zdhCharalterrecordDao.findByPk(recordsno);
		ZdhCharalterrecordDto dto = (ZdhCharalterrecordDto) BeanHelper.buildBean(ZdhCharalterrecordDto.class, zdhCharalterrecord);
		return dto;
   }
   public QueryListObj listZdhCharalterrecordByHql(String hql){
      QueryListObj obj = zdhCharalterrecordDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhCharalterrecordDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
   }
   public void saveOrUpdateZdhCharalterrecord(List dtos){
     
   List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			ZdhCharalterrecordDto zdhCharalterrecordDto = (ZdhCharalterrecordDto)dtos.get(i);
			ZdhCharalterrecord zdhCharalterrecord = (ZdhCharalterrecord) BeanHelper.buildBean(ZdhCharalterrecord.class, zdhCharalterrecordDto);
		    pos.add(zdhCharalterrecord);
		}
		
		zdhCharalterrecordDao.saveOrUpdateAll(pos);	
   
   }
   
   public void deleteZdhCharalterrecord(List dtos){
      List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(ZdhCharalterrecord.class, dtos);
		zdhCharalterrecordDao.deleteAll(pos);
   }
	
		

   public QueryListObj listZdhFaultlist() {
		QueryListObj obj = zdhFaultlistDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhFaultlistDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
		
	
   public void saveOrUpdateZdhFaultlist(ZdhFaultlistDto dto){
   
     if (StringUtils.isEmpty(dto.getFfaultno())){
		      if( StringUtils.isEmpty(dto.getFfaultno())){
		          dto.setFfaultno(new SequenceCreator().getUID());
		       }
		}
		ZdhFaultlist zdhFaultlist = (ZdhFaultlist) BeanHelper.buildBean(ZdhFaultlist.class, dto);
		zdhFaultlistDao.saveOrUpdate(zdhFaultlist);
   
   }
   public void deleteZdhFaultlist(String ffaultno){
     
        ZdhFaultlist zdhFaultlist = new ZdhFaultlist();
		zdhFaultlist.setFfaultno(ffaultno);
		zdhFaultlistDao.delete(zdhFaultlist);
   
   }
   public ZdhFaultlistDto loadZdhFaultlist(String ffaultno){
        ZdhFaultlist zdhFaultlist = (ZdhFaultlist) zdhFaultlistDao.findByPk(ffaultno);
		ZdhFaultlistDto dto = (ZdhFaultlistDto) BeanHelper.buildBean(ZdhFaultlistDto.class, zdhFaultlist);
		return dto;
   }
   public QueryListObj listZdhFaultlistByHql(String hql){
      QueryListObj obj = zdhFaultlistDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhFaultlistDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
   }
   public void saveOrUpdateZdhFaultlist(List dtos){
     
   List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			ZdhFaultlistDto zdhFaultlistDto = (ZdhFaultlistDto)dtos.get(i);
			ZdhFaultlist zdhFaultlist = (ZdhFaultlist) BeanHelper.buildBean(ZdhFaultlist.class, zdhFaultlistDto);
		    pos.add(zdhFaultlist);
		}
		
		zdhFaultlistDao.saveOrUpdateAll(pos);	
   
   }
   
   public void deleteZdhFaultlist(List dtos){
      List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(ZdhFaultlist.class, dtos);
		zdhFaultlistDao.deleteAll(pos);
   }
	
		

   public QueryListObj listZdhTransrecord() {
		QueryListObj obj = zdhTransrecordDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhTransrecordDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
		
	
   public void saveOrUpdateZdhTransrecord(ZdhTransrecordDto dto){
   
     if (StringUtils.isEmpty(dto.getTransrecordid())){
		      if( StringUtils.isEmpty(dto.getTransrecordid())){
		          dto.setTransrecordid(new SequenceCreator().getUID());
		       }
		}
		ZdhTransrecord zdhTransrecord = (ZdhTransrecord) BeanHelper.buildBean(ZdhTransrecord.class, dto);
		zdhTransrecordDao.saveOrUpdate(zdhTransrecord);
   
   }
   public void deleteZdhTransrecord(String transrecordid){
     
        ZdhTransrecord zdhTransrecord = new ZdhTransrecord();
		zdhTransrecord.setTransrecordid(transrecordid);
		zdhTransrecordDao.delete(zdhTransrecord);
   
   }
   public ZdhTransrecordDto loadZdhTransrecord(String transrecordid){
        ZdhTransrecord zdhTransrecord = (ZdhTransrecord) zdhTransrecordDao.findByPk(transrecordid);
		ZdhTransrecordDto dto = (ZdhTransrecordDto) BeanHelper.buildBean(ZdhTransrecordDto.class, zdhTransrecord);
		return dto;
   }
   public QueryListObj listZdhTransrecordByHql(String hql){
      QueryListObj obj = zdhTransrecordDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhTransrecordDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
   }
   public void saveOrUpdateZdhTransrecord(List dtos){
     
   List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			ZdhTransrecordDto zdhTransrecordDto = (ZdhTransrecordDto)dtos.get(i);
			ZdhTransrecord zdhTransrecord = (ZdhTransrecord) BeanHelper.buildBean(ZdhTransrecord.class, zdhTransrecordDto);
		    pos.add(zdhTransrecord);
		}
		
		zdhTransrecordDao.saveOrUpdateAll(pos);	
   
   }
   
   public void deleteZdhTransrecord(List dtos){
      List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(ZdhTransrecord.class, dtos);
		zdhTransrecordDao.deleteAll(pos);
   }
	
		

   public QueryListObj listZdhOpexaminelist() {
		QueryListObj obj = zdhOpexaminelistDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhOpexaminelistDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
		
	
   public void saveOrUpdateZdhOpexaminelist(ZdhOpexaminelistDto dto){
   
     if (StringUtils.isEmpty(dto.getExaminationid())){
		      if( StringUtils.isEmpty(dto.getExaminationid())){
		          dto.setExaminationid(new SequenceCreator().getUID());
		       }
		}
		ZdhOpexaminelist zdhOpexaminelist = (ZdhOpexaminelist) BeanHelper.buildBean(ZdhOpexaminelist.class, dto);
		zdhOpexaminelistDao.saveOrUpdate(zdhOpexaminelist);
   
   }
   public void deleteZdhOpexaminelist(String examinationid){
     
        ZdhOpexaminelist zdhOpexaminelist = new ZdhOpexaminelist();
		zdhOpexaminelist.setExaminationid(examinationid);
		zdhOpexaminelistDao.delete(zdhOpexaminelist);
   
   }
   public ZdhOpexaminelistDto loadZdhOpexaminelist(String examinationid){
        ZdhOpexaminelist zdhOpexaminelist = (ZdhOpexaminelist) zdhOpexaminelistDao.findByPk(examinationid);
		ZdhOpexaminelistDto dto = (ZdhOpexaminelistDto) BeanHelper.buildBean(ZdhOpexaminelistDto.class, zdhOpexaminelist);
		return dto;
   }
   public QueryListObj listZdhOpexaminelistByHql(String hql){
      QueryListObj obj = zdhOpexaminelistDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhOpexaminelistDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
   }
   public void saveOrUpdateZdhOpexaminelist(List dtos){
     
   List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			ZdhOpexaminelistDto zdhOpexaminelistDto = (ZdhOpexaminelistDto)dtos.get(i);
			ZdhOpexaminelist zdhOpexaminelist = (ZdhOpexaminelist) BeanHelper.buildBean(ZdhOpexaminelist.class, zdhOpexaminelistDto);
		    pos.add(zdhOpexaminelist);
		}
		
		zdhOpexaminelistDao.saveOrUpdateAll(pos);	
   
   }
   
   public void deleteZdhOpexaminelist(List dtos){
      List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(ZdhOpexaminelist.class, dtos);
		zdhOpexaminelistDao.deleteAll(pos);
   }
   /**
    * 交接班操作
    * @param ondutyno  班号
    * @return
    * @author sbt 2007-4-17 
    */
   public String carryOn(String ondutyno){	   
	   return zdhAutoondutylogDao.carryOn(ondutyno);
   }	
}
