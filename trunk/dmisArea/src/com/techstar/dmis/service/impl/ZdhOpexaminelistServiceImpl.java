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
import com.techstar.dmis.dao.*;
import com.techstar.dmis.dto.ZdhOpexaminelistDto;
import com.techstar.dmis.entity.ZdhOpexaminelist;
import com.techstar.dmis.service.IDdDoutageplanService;
import com.techstar.dmis.service.IZdhOpexaminelistService;
import com.techstar.dmis.util.DateUtil;

import org.springframework.dao.DataAccessException;

	//注册子表DAO
    import com.techstar.dmis.dto.ZdhAutoondutylogDto;
import com.techstar.dmis.entity.ZdhAutoondutylog;
	import com.techstar.dmis.dto.DdDoutageplanDto;
import com.techstar.dmis.entity.DdDoutageplan;
	
//please add your business methods start
	// to do it
//add your business method end

/** 
 * 业务对象服务接口实现类
 * @author 
 * @date
 */
public class ZdhOpexaminelistServiceImpl implements IZdhOpexaminelistService {
   //注册DAO
   private IZdhOpexaminelistDao zdhOpexaminelistDao;
   private IBaseJdbcDao baseJdbcDao ;
   private IDdDoutageplanService ddDoutageplanService; 
   
  	//注册管理DAO
    	 private IZdhAutoondutylogDao zdhAutoondutylogDao;
	 public void setZdhAutoondutylogDao
	    (IZdhAutoondutylogDao zdhAutoondutylogDao) {
		 this.zdhAutoondutylogDao = zdhAutoondutylogDao;
     }
		 private IDdDoutageplanDao ddDoutageplanDao;
	 public void setDdDoutageplanDao
	    (IDdDoutageplanDao ddDoutageplanDao) {
		 this.ddDoutageplanDao = ddDoutageplanDao;
     }
	  	

	public ZdhOpexaminelistServiceImpl() {}
	
	public void addZdhOpexaminelist(ZdhOpexaminelistDto dto) {
	
    	if (StringUtils.isEmpty(dto.getExaminationid())){
		      if( StringUtils.isEmpty(dto.getExaminationid())){
		          dto.setExaminationid(new SequenceCreator().getUID());
		       }
		}
    	//新增时候,主对象不用管子对象的保存
		ZdhOpexaminelist zdhOpexaminelist = (ZdhOpexaminelist) BeanHelper.buildBean(ZdhOpexaminelist.class, dto);
		zdhOpexaminelistDao.saveOrUpdate(zdhOpexaminelist);		
	}
	
    //用于实现基本增加或修改操作
	public void saveOrUpdateZdhOpexaminelist(ZdhOpexaminelistDto dto) {
		if (StringUtils.isEmpty(dto.getExaminationid())){
		      if( StringUtils.isEmpty(dto.getExaminationid())){
		          dto.setExaminationid(new SequenceCreator().getUID());
		       }
		}
		ZdhOpexaminelist zdhOpexaminelist = (ZdhOpexaminelist) BeanHelper.mapBean(ZdhOpexaminelist.class, dto);
		zdhOpexaminelistDao.saveOrUpdate(zdhOpexaminelist);
	}
    //用于实现基本删除操作
	public void deleteZdhOpexaminelist(String zdhOpexaminelistId) {
		ZdhOpexaminelist zdhOpexaminelist = new ZdhOpexaminelist();
		zdhOpexaminelist.setExaminationid(zdhOpexaminelistId);
		zdhOpexaminelistDao.delete(zdhOpexaminelist);
	}
	//用于实现基本删除集合操作
	public void deleteZdhOpexaminelist(List dtos){
		List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(ZdhOpexaminelist.class, dtos);
		zdhOpexaminelistDao.deleteAll(pos);
	}	
   //用于实现基本DTOLOAD操作
	public ZdhOpexaminelistDto loadZdhOpexaminelist(String examinationid) {
		ZdhOpexaminelist zdhOpexaminelist = (ZdhOpexaminelist) zdhOpexaminelistDao.findByPk(examinationid);
		ZdhOpexaminelistDto dto = (ZdhOpexaminelistDto) BeanHelper.mapBean(ZdhOpexaminelistDto.class, zdhOpexaminelist);
		return dto;
	}
   //用于实现列表操作
   public QueryListObj listZdhOpexaminelist() {
		QueryListObj obj = zdhOpexaminelistDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhOpexaminelistDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj listZdhOpexaminelistByHql(String hql) {
		QueryListObj obj = zdhOpexaminelistDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhOpexaminelistDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj getZdhOpexaminelistByHql(String hql, int beginPage, int pageSize, String sql) {
		QueryListObj obj = zdhOpexaminelistDao.getQueryListByHql(hql, beginPage, pageSize);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhOpexaminelistDto.class, obj
					.getElemList()); 
			obj.setElemList(dtos);
		}
		
		List sumList = zdhOpexaminelistDao.getObjPropertySums(sql);
		//System.out.println("sumList.size():"+sumList.size());
		obj.setPropertySum(sumList);
		return obj;
	}

	
  /**
    * @business method list
	 	* @完成情况核查
	 	* @开始情况核查
	     */

	//please add your business methods start
	// to do it
	//add your business method end
	
	//得到班号
	public String getOndutyno(){
		//定义hql，以“接班时间”最大的为查询条件
		String hql = "select a.ondutyno from ZdhAutoondutylog a where a.successiontime = (select max(b.successiontime)  from ZdhAutoondutylog b)";
		QueryListObj obj = zdhOpexaminelistDao.getQueryListByHql(hql) ;
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
//用于实现基本增加或修改操作/*
 * 用于从日计划中取出数据保存到日计划核查表中
 */
	public void saveDdDoutageplan() {
		String 	strHql =" from DdDoutageplan as dd where dd.fdispatchrange='市调' and to_char(dd.fapplystime,'YYYY-MM-DD')=to_char(sysdate,'YYYY-MM-DD') and  not exists ";
		strHql+="(select zdh.zzdhopexaminelist6 from ZdhOpexaminelist zdh )   ";

		QueryListObj queryList =ddDoutageplanService.listDdDoutageplanByHql(strHql);

		Iterator it=queryList.getElemList().iterator();
		
		String ondutyno=this.getOndutyno();
		while(it.hasNext())
		{
			DdDoutageplanDto ddoutageplan=(DdDoutageplanDto)it.next();		
			
			ZdhOpexaminelistDto dto = new ZdhOpexaminelistDto();	
			dto.setFapplystime(ddoutageplan.getFapplystime());
			dto.setFapplyetime(ddoutageplan.getFapplyetime());
			dto.setFworkcontent(ddoutageplan.getWorkcontent());
			dto.setExaminationid(new SequenceCreator().getUID());	
			dto.setZzdhopexaminelist6(ddoutageplan);
			dto.setZzdhopexaminelist5(new ZdhAutoondutylogDto());
			dto.getZzdhopexaminelist5().setOndutyno(ondutyno);
			ZdhOpexaminelist zdhOpexaminelist = (ZdhOpexaminelist) BeanHelper.mapBean(ZdhOpexaminelist.class, dto); 
			zdhOpexaminelistDao.saveOrUpdate(zdhOpexaminelist);					
		}

	}
	/*
	 * 从日计划表中找出市调当天的纪录
	 * @see com.techstar.dmis.service.IZdhOpexaminelistService#initDdDoutageplan(int, int, java.lang.String)
	 */
	public QueryListObj initDdDoutageplan(int beginPage,int pageSize,String sumSql) {
		String 	strHql =" from DdDoutageplan as dd where dd.fdispatchrange='市调' and to_char(dd.fapplystime,'YYYY-MM-DD')=to_char(sysdate,'YYYY-MM-DD') and  not exists ";
		strHql+="(select zdh.zzdhopexaminelist6 from ZdhOpexaminelist zdh )   ";
		
		QueryListObj queryList =ddDoutageplanService.getDdDoutageplanByHql(strHql, beginPage, pageSize, sumSql);
		return queryList;


	}
	public IZdhOpexaminelistDao getZdhOpexaminelistDao() {
		return zdhOpexaminelistDao;
	}

	public void setZdhOpexaminelistDao(IZdhOpexaminelistDao zdhOpexaminelistDao) {
		this.zdhOpexaminelistDao = zdhOpexaminelistDao;
	}
	
	public void setBaseJdbcDao(IBaseJdbcDao baseJdbcDao) {
		this.baseJdbcDao = baseJdbcDao;
	}
	
	public void saveOrUpdateZdhOpexaminelist(List dtos) {
		List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			ZdhOpexaminelistDto zdhOpexaminelistDto = (ZdhOpexaminelistDto)dtos.get(i);
			ZdhOpexaminelist zdhOpexaminelist = (ZdhOpexaminelist) BeanHelper.mapBean(ZdhOpexaminelist.class, zdhOpexaminelistDto);
		    pos.add(zdhOpexaminelist);
		}
		
		zdhOpexaminelistDao.saveOrUpdateAll(pos);	
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
			ZdhAutoondutylog zdhAutoondutylog = (ZdhAutoondutylog) BeanHelper.buildBean(ZdhAutoondutylog.class, zdhAutoondutylogDto);
		    pos.add(zdhAutoondutylog);
		}
		
		zdhAutoondutylogDao.saveOrUpdateAll(pos);	
   
   }
   
   public void deleteZdhAutoondutylog(List dtos){
      List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(ZdhAutoondutylog.class, dtos);
		zdhAutoondutylogDao.deleteAll(pos);
   }
	
		

   public QueryListObj listDdDoutageplan() {
		QueryListObj obj = ddDoutageplanDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdDoutageplanDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
		
	
   public void saveOrUpdateDdDoutageplan(DdDoutageplanDto dto){
   
     if (StringUtils.isEmpty(dto.getFdayplanno())){
		      if( StringUtils.isEmpty(dto.getFdayplanno())){
		          dto.setFdayplanno(new SequenceCreator().getUID());
		       }
		}
		DdDoutageplan ddDoutageplan = (DdDoutageplan) BeanHelper.mapBean(DdDoutageplan.class, dto);
		ddDoutageplanDao.saveOrUpdate(ddDoutageplan);
   
   }
   public void deleteDdDoutageplan(String fdayplanno){
     
        DdDoutageplan ddDoutageplan = new DdDoutageplan();
		ddDoutageplan.setFdayplanno(fdayplanno);
		ddDoutageplanDao.delete(ddDoutageplan);
   
   }
   public DdDoutageplanDto loadDdDoutageplan(String fdayplanno){
        DdDoutageplan ddDoutageplan = (DdDoutageplan) ddDoutageplanDao.findByPk(fdayplanno);
		DdDoutageplanDto dto = (DdDoutageplanDto) BeanHelper.buildBean(DdDoutageplanDto.class, ddDoutageplan);
		return dto;
   }
   public QueryListObj listDdDoutageplanByHql(String hql){
      QueryListObj obj = ddDoutageplanDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdDoutageplanDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
   }
   public void saveOrUpdateDdDoutageplan(List dtos){
     
   List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			DdDoutageplanDto ddDoutageplanDto = (DdDoutageplanDto)dtos.get(i);
			DdDoutageplan ddDoutageplan = (DdDoutageplan) BeanHelper.buildBean(DdDoutageplan.class, ddDoutageplanDto);
		    pos.add(ddDoutageplan);
		}
		
		ddDoutageplanDao.saveOrUpdateAll(pos);	
   
   }
   
   public void deleteDdDoutageplan(List dtos){
      List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(DdDoutageplan.class, dtos);
		ddDoutageplanDao.deleteAll(pos);
   }


public void setDdDoutageplanService(IDdDoutageplanService ddDoutageplanService) {
	this.ddDoutageplanService = ddDoutageplanService;
}
	
	  	


	
}
