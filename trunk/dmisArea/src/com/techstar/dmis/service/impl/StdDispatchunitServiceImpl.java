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
import com.techstar.dmis.dto.StdDispatchunitDto;
import com.techstar.dmis.entity.StdDispatchunit;
import com.techstar.dmis.service.IStdDispatchunitService;
import org.springframework.dao.DataAccessException;


//please add your business methods start
	// to do it
//add your business method end

/** 
 * 业务对象服务接口实现类
 * @author 
 * @date
 */
public class StdDispatchunitServiceImpl implements IStdDispatchunitService {
   //注册DAO
   private IStdDispatchunitDao stdDispatchunitDao;
   private IBaseJdbcDao baseJdbcDao ;
   
  	

	public StdDispatchunitServiceImpl() {}
	
	public void addStdDispatchunit(StdDispatchunitDto dto) {
	
    	if (StringUtils.isEmpty(dto.getId())){
		      if( StringUtils.isEmpty(dto.getId())){
		          dto.setId(new SequenceCreator().getUID());
		       }
		}
    	//新增时候,主对象不用管子对象的保存
		StdDispatchunit stdDispatchunit = (StdDispatchunit) BeanHelper.buildBean(StdDispatchunit.class, dto);
		stdDispatchunitDao.saveOrUpdate(stdDispatchunit);		
	}
	
    //用于实现基本增加或修改操作
	public void saveOrUpdateStdDispatchunit(StdDispatchunitDto dto) {
		if (StringUtils.isEmpty(dto.getId())){
		      if( StringUtils.isEmpty(dto.getId())){
		          dto.setId(new SequenceCreator().getUID());
		       }
		}
		StdDispatchunit stdDispatchunit = (StdDispatchunit) BeanHelper.buildBean(StdDispatchunit.class, dto);
		stdDispatchunitDao.saveOrUpdate(stdDispatchunit);
	}
    //用于实现基本删除操作
	public void deleteStdDispatchunit(String stdDispatchunitId) {
		StdDispatchunit stdDispatchunit = new StdDispatchunit();
		stdDispatchunit.setId(stdDispatchunitId);
		stdDispatchunitDao.delete(stdDispatchunit);
	}
	//用于实现基本删除集合操作
	public void deleteStdDispatchunit(List dtos){
		List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(StdDispatchunit.class, dtos);
		stdDispatchunitDao.deleteAll(pos);
	}	
   //用于实现基本DTOLOAD操作
	public StdDispatchunitDto loadStdDispatchunit(String id) {
		StdDispatchunit stdDispatchunit = (StdDispatchunit) stdDispatchunitDao.findByPk(id);
		StdDispatchunitDto dto = (StdDispatchunitDto) BeanHelper.buildBean(StdDispatchunitDto.class, stdDispatchunit);
		return dto;
	}
   //用于实现列表操作
   public QueryListObj listStdDispatchunit() {
		QueryListObj obj = stdDispatchunitDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(StdDispatchunitDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj listStdDispatchunitByHql(String hql) {
		QueryListObj obj = stdDispatchunitDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(StdDispatchunitDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj getStdDispatchunitByHql(String hql, int beginPage, int pageSize, String sql) {
		QueryListObj obj = stdDispatchunitDao.getQueryListByHql(hql, beginPage, pageSize);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(StdDispatchunitDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		
		List sumList = stdDispatchunitDao.getObjPropertySums(sql);
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
	
	public IStdDispatchunitDao getStdDispatchunitDao() {
		return stdDispatchunitDao;
	}

	public void setStdDispatchunitDao(IStdDispatchunitDao stdDispatchunitDao) {
		this.stdDispatchunitDao = stdDispatchunitDao;
	}
	
	public void setBaseJdbcDao(IBaseJdbcDao baseJdbcDao) {
		this.baseJdbcDao = baseJdbcDao;
	}
	
	public void saveOrUpdateStdDispatchunit(List dtos) {
		List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			StdDispatchunitDto stdDispatchunitDto = (StdDispatchunitDto)dtos.get(i);
			StdDispatchunit stdDispatchunit = (StdDispatchunit) BeanHelper.buildBean(StdDispatchunit.class, stdDispatchunitDto);
		    pos.add(stdDispatchunit);
		}
		
		stdDispatchunitDao.saveOrUpdateAll(pos);	
	}
	/**
     * 根据数据所属单位名称获取数据所属单位的缩写
     * 即在表DMIS_ZD_STD_DISPATCHUNIT中,根据UNITNAME的值获取ESHIRTNAME的值
     * @param dataownerName
     * @return
     */
	 public String getDataOwner(String dataownerName){
         String hql = "select a.eshirtname from StdDispatchunit a where trim(a.unitname) = '"+dataownerName.trim()+"'";
         QueryListObj obj = stdDispatchunitDao.getQueryListByHql(hql);
         if (obj == null) { 
             return "";
         }
         List list = obj.getElemList();
         if (list == null || list.size() < 1){
            return "";
         }
         //提取当前的数据所属单位的英文简称(BD、DD... ...)

         String eshirtname = (String)list.iterator().next();
         System.out.println("当前的数据所属单位的英文简称:"+eshirtname);
         return eshirtname;

}


	
		
	
	 	


	
}
