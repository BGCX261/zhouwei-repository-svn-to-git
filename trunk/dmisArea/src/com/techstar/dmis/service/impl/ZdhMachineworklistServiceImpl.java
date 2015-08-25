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
import com.techstar.dmis.dto.ZdhMachineworklistDto;
import com.techstar.dmis.entity.ZdhMachineworklist;
import com.techstar.dmis.service.IZdhMachineworklistService;
import org.springframework.dao.DataAccessException;

	//注册子表DAO
    import com.techstar.dmis.dto.ZdhAutoondutylogDto;
import com.techstar.dmis.entity.ZdhAutoondutylog;
	
//please add your business methods start
	// to do it
//add your business method end

/** 
 * 业务对象服务接口实现类
 * @author 
 * @date
 */
public class ZdhMachineworklistServiceImpl implements IZdhMachineworklistService {
   //注册DAO
   private IZdhMachineworklistDao zdhMachineworklistDao;
   private IBaseJdbcDao baseJdbcDao ;
   
  	//注册管理DAO
    	 private IZdhAutoondutylogDao zdhAutoondutylogDao;
	 public void setZdhAutoondutylogDao
	    (IZdhAutoondutylogDao zdhAutoondutylogDao) {
		 this.zdhAutoondutylogDao = zdhAutoondutylogDao;
     }
	  	

	public ZdhMachineworklistServiceImpl() {}
	
	public void addZdhMachineworklist(ZdhMachineworklistDto dto) {
	
    	if (StringUtils.isEmpty(dto.getJobid())){
		      if( StringUtils.isEmpty(dto.getJobid())){
		          dto.setJobid(new SequenceCreator().getUID());
		       }
		}
    	//新增时候,主对象不用管子对象的保存
		ZdhMachineworklist zdhMachineworklist = (ZdhMachineworklist) BeanHelper.buildBean(ZdhMachineworklist.class, dto);
		zdhMachineworklistDao.saveOrUpdate(zdhMachineworklist);		
	}
	
    //用于实现基本增加或修改操作
	public void saveOrUpdateZdhMachineworklist(ZdhMachineworklistDto dto) {
		if (StringUtils.isEmpty(dto.getJobid())){
		      if( StringUtils.isEmpty(dto.getJobid())){
		          dto.setJobid(new SequenceCreator().getUID());
		       }
		}
		ZdhMachineworklist zdhMachineworklist = (ZdhMachineworklist) BeanHelper.mapBean(ZdhMachineworklist.class, dto);
		zdhMachineworklistDao.saveOrUpdate(zdhMachineworklist);
	}
    //用于实现基本删除操作
	public void deleteZdhMachineworklist(String zdhMachineworklistId) {
		ZdhMachineworklist zdhMachineworklist = new ZdhMachineworklist();
		zdhMachineworklist.setJobid(zdhMachineworklistId);
		zdhMachineworklistDao.delete(zdhMachineworklist);
	}
	//用于实现基本删除集合操作
	public void deleteZdhMachineworklist(List dtos){
		List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(ZdhMachineworklist.class, dtos);
		zdhMachineworklistDao.deleteAll(pos);
	}	
   //用于实现基本DTOLOAD操作
	public ZdhMachineworklistDto loadZdhMachineworklist(String jobid) {
		ZdhMachineworklist zdhMachineworklist = (ZdhMachineworklist) zdhMachineworklistDao.findByPk(jobid);
		ZdhMachineworklistDto dto = (ZdhMachineworklistDto) BeanHelper.mapBean(ZdhMachineworklistDto.class, zdhMachineworklist);
		return dto;
	}
   //用于实现列表操作
   public QueryListObj listZdhMachineworklist() {
		QueryListObj obj = zdhMachineworklistDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhMachineworklistDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj listZdhMachineworklistByHql(String hql) {
		QueryListObj obj = zdhMachineworklistDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhMachineworklistDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj getZdhMachineworklistByHql(String hql, int beginPage, int pageSize, String sql) {
		QueryListObj obj = zdhMachineworklistDao.getQueryListByHql(hql, beginPage, pageSize);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhMachineworklistDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		
		List sumList = zdhMachineworklistDao.getObjPropertySums(sql);
		//System.out.println("sumList.size():"+sumList.size());
		obj.setPropertySum(sumList);
		return obj;
	}

	
  /**
    * @business method list
	     */

	//please add your business methods start
	// to do it
	//add your business method end
	
	public IZdhMachineworklistDao getZdhMachineworklistDao() {
		return zdhMachineworklistDao;
	}

	public void setZdhMachineworklistDao(IZdhMachineworklistDao zdhMachineworklistDao) {
		this.zdhMachineworklistDao = zdhMachineworklistDao;
	}
	
	public void setBaseJdbcDao(IBaseJdbcDao baseJdbcDao) {
		this.baseJdbcDao = baseJdbcDao;
	}
	
	public void saveOrUpdateZdhMachineworklist(List dtos) {
		List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			ZdhMachineworklistDto zdhMachineworklistDto = (ZdhMachineworklistDto)dtos.get(i);
			ZdhMachineworklist zdhMachineworklist = (ZdhMachineworklist) BeanHelper.mapBean(ZdhMachineworklist.class, zdhMachineworklistDto);
		    pos.add(zdhMachineworklist);
		}
		
		zdhMachineworklistDao.saveOrUpdateAll(pos);	
	}
	
		
	
	 	//子表处理DAO
    	

   public QueryListObj listZdhAutoondutylog() {
		QueryListObj obj = zdhAutoondutylogDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhAutoondutylogDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
		
	
   public void saveOrUpdateZdhAutoondutylog(ZdhAutoondutylogDto dto){
   
     if (StringUtils.isEmpty(dto.getOndutyno())){
		      if( StringUtils.isEmpty(dto.getOndutyno())){
		          dto.setOndutyno(new SequenceCreator().getUID());
		       }
		}
		ZdhAutoondutylog zdhAutoondutylog = (ZdhAutoondutylog) BeanHelper.mapBean(ZdhAutoondutylog.class, dto);
		zdhAutoondutylogDao.saveOrUpdate(zdhAutoondutylog);
   
   }
   public void deleteZdhAutoondutylog(String ondutyno){
     
        ZdhAutoondutylog zdhAutoondutylog = new ZdhAutoondutylog();
		zdhAutoondutylog.setOndutyno(ondutyno);
		zdhAutoondutylogDao.delete(zdhAutoondutylog);
   
   }
   public ZdhAutoondutylogDto loadZdhAutoondutylog(String ondutyno){
        ZdhAutoondutylog zdhAutoondutylog = (ZdhAutoondutylog) zdhAutoondutylogDao.findByPk(ondutyno);
		ZdhAutoondutylogDto dto = (ZdhAutoondutylogDto) BeanHelper.buildBean(ZdhAutoondutylogDto.class, zdhAutoondutylog);
		return dto;
   }
   public QueryListObj listZdhAutoondutylogByHql(String hql){
      QueryListObj obj = zdhAutoondutylogDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhAutoondutylogDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
   }
   public void saveOrUpdateZdhAutoondutylog(List dtos){
     
   List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			ZdhAutoondutylogDto zdhAutoondutylogDto = (ZdhAutoondutylogDto)dtos.get(i);
			ZdhAutoondutylog zdhAutoondutylog = (ZdhAutoondutylog) BeanHelper.mapBean(ZdhAutoondutylog.class, zdhAutoondutylogDto);
		    pos.add(zdhAutoondutylog);
		}
		
		zdhAutoondutylogDao.saveOrUpdateAll(pos);	
   
   }
   
   public void deleteZdhAutoondutylog(List dtos){
      List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(ZdhAutoondutylog.class, dtos);
		zdhAutoondutylogDao.deleteAll(pos);
   }



public String getOndutyno(){
	//定义hql，以“接班时间”最大的为查询条件
	String hql = "select a.ondutyno from ZdhAutoondutylog a where a.successiontime = (select max(b.successiontime)  from ZdhAutoondutylog b)";
	QueryListObj obj = zdhMachineworklistDao.getQueryListByHql(hql);
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
	  	


	
}
