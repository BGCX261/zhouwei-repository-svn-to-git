package com.techstar.dmis.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

import org.apache.commons.lang.StringUtils;
import com.techstar.framework.dao.IBaseJdbcDao;

import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.framework.utils.BeanHelper;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.dmis.common.ZdhConstants;
import com.techstar.dmis.dao.*;
import com.techstar.dmis.dto.ZdhFaultlistDto;
import com.techstar.dmis.dto.ZdhMachineworklistDto;
import com.techstar.dmis.entity.ZdhFaultlist;
import com.techstar.dmis.entity.ZdhMachineworklist;
import com.techstar.dmis.service.IZdhFaultlistService;
import com.techstar.dmis.service.IZdhMachineworklistService;

import org.springframework.dao.DataAccessException;

//please add your business methods start
	// to do it
//add your business method end

/** 
 * 业务对象服务接口实现类

 * @author 
 * @date
 */
public class ZdhFaultlistServiceImpl implements IZdhFaultlistService {
   //注册DAO
   private IZdhFaultlistDao zdhFaultlistDao;
   private IBaseJdbcDao baseJdbcDao ;
   private IZdhMachineworklistService zdhMachineworklistService;
   private IZdhMachineworklistDao zdhMachineworklistDao;
   
  	//注册管理DAO
    	 private IStdZdhfaulttypeDao stdZdhfaulttypeDao;
	 public void setStdZdhfaulttypeDao
	    (IStdZdhfaulttypeDao stdZdhfaulttypeDao) {
		 this.stdZdhfaulttypeDao = stdZdhfaulttypeDao;
     }
		 private IEtsEquipmentDao etsEquipmentDao;
	 public void setEtsEquipmentDao
	    (IEtsEquipmentDao etsEquipmentDao) {
		 this.etsEquipmentDao = etsEquipmentDao;
     }
		 private IZdhAutoondutylogDao zdhAutoondutylogDao;
	 public void setZdhAutoondutylogDao
	    (IZdhAutoondutylogDao zdhAutoondutylogDao) {
		 this.zdhAutoondutylogDao = zdhAutoondutylogDao;
     }
	  	

	public ZdhFaultlistServiceImpl() {}
	
	public void addZdhFaultlist(ZdhFaultlistDto dto) {
	
    	if (StringUtils.isEmpty(dto.getFfaultno())){
		      if( StringUtils.isEmpty(dto.getFfaultno())){
		          dto.setFfaultno(new SequenceCreator().getUID());
		       }
		}
    	//新增时候,主对象不用管子对象的保存
		ZdhFaultlist zdhFaultlist = (ZdhFaultlist) BeanHelper.buildBean(ZdhFaultlist.class, dto);
		zdhFaultlistDao.saveOrUpdate(zdhFaultlist);		
	}
	
    //用于实现基本增加或修改操作

	public void saveOrUpdateZdhFaultlist(ZdhFaultlistDto dto) {
		if (StringUtils.isEmpty(dto.getFfaultno())){
		      if( StringUtils.isEmpty(dto.getFfaultno())){
		          dto.setFfaultno(new SequenceCreator().getUID());
		       }
		}
		//得到最新班志编号
		String onDutyNo = this.getOndutyno();
		//新增时设定班志编号[外键]
		
		if (dto.getZzdhfaultlist7() == null) {
			dto.setZzdhfaultlist7(new com.techstar.dmis.dto.ZdhAutoondutylogDto());
			dto.getZzdhfaultlist7().setOndutyno(onDutyNo);
		} else {
			if(StringUtils.isEmpty(dto.getZzdhfaultlist7().getOndutyno())){
				dto.getZzdhfaultlist7().setOndutyno(onDutyNo);
			}
		}

		
		
		ZdhFaultlist zdhFaultlist = (ZdhFaultlist) BeanHelper.mapBean(ZdhFaultlist.class, dto);
		zdhFaultlistDao.saveOrUpdate(zdhFaultlist);
		/**===============================================================================
		 * 为机房工作插入相关缺陷信息
		 */
		ZdhFaultlist zdhFaultlistT = zdhFaultlistDao.findByPk(dto.getFfaultno());
		String jobId = "";
		String hql = " FROM ZdhMachineworklist WHERE workingsources = '"+zdhFaultlistT.getFfaultno()+"' ";
		QueryListObj queryListObj = zdhMachineworklistDao.getQueryListByHql(hql);
		List listObj = queryListObj.getElemList();
		ZdhMachineworklist zdhMachineworklist = null;
		if(listObj.iterator().hasNext()){
			zdhMachineworklist = (ZdhMachineworklist)listObj.iterator().next();
		}
		if(zdhMachineworklist == null){
			zdhMachineworklist = new ZdhMachineworklist();
		}
		//
		StringBuffer content = new StringBuffer();
					 content.append(zdhFaultlistT.getFoccurredtime());
					 content.append(zdhFaultlistT.getFunitname());
					 content.append(zdhFaultlistT.getFequipclass());
					 content.append(zdhFaultlistT.getFfaultcontent());
		zdhMachineworklist.setJobcategory(ZdhConstants.ZDH_MACHINEWORK);
		zdhMachineworklist.setContent(content.toString());
		zdhMachineworklist.setWorkingsources(zdhFaultlistT.getFfaultno());
		if(dto.getRfilltime() != null){
			zdhMachineworklist.setFexcutestatus(ZdhConstants.ZDH_MACHINEWORKFIN);
		}
		if (StringUtils.isEmpty(zdhMachineworklist.getJobid())){
		      if( StringUtils.isEmpty(zdhMachineworklist.getJobid())){
		          zdhMachineworklist.setJobid(new SequenceCreator().getUID());
		      }
		      //插入机房工作的同时，写入外键信息
		      StringBuffer sql = new StringBuffer();
	   			 		   sql.append(" insert into DMIS_ZDH_MachineWorkList ");
	   			 		   sql.append(" (jobid,jobcategory,content,workingsources,fexcutestatus,version,ondutyno) ");
	   			 		   sql.append(" values ");
	   			 		   sql.append(" ( ");
	   			 		   sql.append(" '"+zdhMachineworklist.getJobid()+"',");
	   			 		   sql.append(" '"+zdhMachineworklist.getJobcategory()+"', ");
	   			 		   sql.append(" '"+zdhMachineworklist.getContent()+"', ");
	   			 		   sql.append(" '"+zdhMachineworklist.getWorkingsources()+"', ");
	   			 		   sql.append(" '"+zdhMachineworklist.getFexcutestatus()+"', ");
	   			 		   sql.append(" '"+zdhMachineworklist.getVersion()+"', ");
	   			 		   sql.append(" '"+onDutyNo+"' ");
	   			 		   sql.append(" )"); 		   
		      baseJdbcDao.executeSql(sql.toString());
		} else {
			StringBuffer sql = new StringBuffer();
			   			 sql.append(" update DMIS_ZDH_MachineWorkList ");
			   			 sql.append(" set ");
			   			 sql.append(" jobcategory = '"+zdhMachineworklist.getJobcategory()+"', ");
			   			 sql.append(" content = '"+zdhMachineworklist.getContent()+"', ");
			   			 sql.append(" workingsources = '"+zdhMachineworklist.getWorkingsources()+"', ");
			   			 sql.append(" fexcutestatus = '"+zdhMachineworklist.getFexcutestatus()+"' ");
			   			 sql.append(" where ");
			   			 sql.append(" jobid = '"+zdhMachineworklist.getJobid()+"' ");
			 baseJdbcDao.executeSql(sql.toString());
		}
		//zdhMachineworklistDao.saveOrUpdate(zdhMachineworklist);
		/**==================================================================================**/
		
	}
    //用于实现基本删除操作
	public void deleteZdhFaultlist(String zdhFaultlistId) {
		ZdhFaultlist zdhFaultlist = new ZdhFaultlist();
		zdhFaultlist.setFfaultno(zdhFaultlistId);
		zdhFaultlistDao.delete(zdhFaultlist);
	}
	
	public void deleteZdhFaultlistObj(String zdhFaultlistId, int version){
		ZdhFaultlist zdhFaultlist = new ZdhFaultlist();
		zdhFaultlist.setFfaultno(zdhFaultlistId);
		zdhFaultlist.setVersion(version);
		zdhFaultlistDao.delete(zdhFaultlist);
	}
	
   //用于实现基本DTOLOAD操作
	public ZdhFaultlistDto loadZdhFaultlist(String ffaultno) {
		ZdhFaultlist zdhFaultlist = (ZdhFaultlist) zdhFaultlistDao.findByPk(ffaultno);
		ZdhFaultlistDto dto = (ZdhFaultlistDto) BeanHelper.mapBean(ZdhFaultlistDto.class, zdhFaultlist);
		return dto;
	}
//用于实现列表操作
   public QueryListObj listZdhFaultlist() {
		QueryListObj obj = zdhFaultlistDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhFaultlistDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj listZdhFaultlistByHql(String hql) {
		QueryListObj obj = zdhFaultlistDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhFaultlist.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj getZdhFaultlistByHql(String hql, int beginPage, int pageSize, String sql) {
		QueryListObj obj = zdhFaultlistDao.getQueryListByHql(hql, beginPage, pageSize);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhFaultlist.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		
		List sumList = zdhFaultlistDao.getObjPropertySums(sql);
		//System.out.println("sumList.size():"+sumList.size());
		obj.setPropertySum(sumList);
		return obj;
	}

	
  /**
    * @business method list
	 	* @缺陷设备信息
	     */

	//please add your business methods start
	// to do it
	//add your business method end
	
	public IZdhFaultlistDao getZdhFaultlistDao() {
		return zdhFaultlistDao;
	}

	public void setZdhFaultlistDao(IZdhFaultlistDao zdhFaultlistDao) {
		this.zdhFaultlistDao = zdhFaultlistDao;
	}
	
	public void setBaseJdbcDao(IBaseJdbcDao baseJdbcDao) {
		this.baseJdbcDao = baseJdbcDao;
	}
	
	public String getOndutyno(){
		//定义hql
		String hql = "select a.ondutyno from ZdhAutoondutylog a where a.successiontime = (select max(b.successiontime)  from ZdhAutoondutylog b)";
		QueryListObj obj = zdhFaultlistDao.getQueryListByHql(hql);
		if (obj == null) { 
			return "";
		}
		List list = obj.getElemList();
		if (list == null || list.size() < 1){
			return "";
		}
		//提取当前的班号
		String ondutyno = (String)list.iterator().next();	
		return ondutyno;
	}	
	
	public void saveOrUpdateZdhFaultlist(List dtos) {
		List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			ZdhFaultlistDto zdhFaultlistDto = (ZdhFaultlistDto)dtos.get(i);
			ZdhFaultlist zdhFaultlist = (ZdhFaultlist) BeanHelper.buildBean(ZdhFaultlist.class, zdhFaultlistDto);
		    pos.add(zdhFaultlist);
		}
		
		zdhFaultlistDao.saveOrUpdateAll(pos);	
	}


	public void setZdhMachineworklistService(
			IZdhMachineworklistService zdhMachineworklistService) {
		this.zdhMachineworklistService = zdhMachineworklistService;
	}


	public void setZdhMachineworklistDao(
			IZdhMachineworklistDao zdhMachineworklistDao) {
		this.zdhMachineworklistDao = zdhMachineworklistDao;
	}
	
		


	
}
