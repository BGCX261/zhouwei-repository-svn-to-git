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
import com.techstar.dmis.dto.FsLoaddatalistDto;
import com.techstar.dmis.entity.FsLoaddatalist;
import com.techstar.dmis.service.IFsLoaddatalistService;
import org.springframework.dao.DataAccessException;

	//注册子表DAO
    import com.techstar.dmis.dto.FsLfparalistDto;
import com.techstar.dmis.entity.FsLfparalist;
	
//please add your business methods start
	// to do it
//add your business method end

/** 
 * 业务对象服务接口实现类
 * @author 
 * @date
 */
public class FsLoaddatalistServiceImpl implements IFsLoaddatalistService {
   //注册DAO
   private IFsLoaddatalistDao fsLoaddatalistDao;
   private IBaseJdbcDao baseJdbcDao ;
   
  	//注册管理DAO
    	 private IFsLfparalistDao fsLfparalistDao;
	 public void setFsLfparalistDao
	    (IFsLfparalistDao fsLfparalistDao) {
		 this.fsLfparalistDao = fsLfparalistDao;
     }
	  	

	public FsLoaddatalistServiceImpl() {}
	
	public void addFsLoaddatalist(FsLoaddatalistDto dto) {
	
    	if (StringUtils.isEmpty(dto.getFloaddatano())){
		      if( StringUtils.isEmpty(dto.getFloaddatano())){
		          dto.setFloaddatano(new SequenceCreator().getUID());
		       }
		}
    	//新增时候,主对象不用管子对象的保存
		FsLoaddatalist fsLoaddatalist = (FsLoaddatalist) BeanHelper.buildBean(FsLoaddatalist.class, dto);
		fsLoaddatalistDao.saveOrUpdate(fsLoaddatalist);		
	}
	
    //用于实现基本增加或修改操作
	public void saveOrUpdateFsLoaddatalist(FsLoaddatalistDto dto) {
		if (StringUtils.isEmpty(dto.getFloaddatano())){
		      if( StringUtils.isEmpty(dto.getFloaddatano())){
		          dto.setFloaddatano(new SequenceCreator().getUID());
		       }
		}
		FsLoaddatalist fsLoaddatalist = (FsLoaddatalist) BeanHelper.buildBean(FsLoaddatalist.class, dto);
		fsLoaddatalistDao.saveOrUpdate(fsLoaddatalist);
	}
    //用于实现基本删除操作
	public void deleteFsLoaddatalist(String fsLoaddatalistId) {
		FsLoaddatalist fsLoaddatalist = new FsLoaddatalist();
		fsLoaddatalist.setFloaddatano(fsLoaddatalistId);
		fsLoaddatalistDao.delete(fsLoaddatalist);
	}
	//用于实现基本删除集合操作
	public void deleteFsLoaddatalist(List dtos){
		List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(FsLoaddatalist.class, dtos);
		fsLoaddatalistDao.deleteAll(pos);
	}	
   //用于实现基本DTOLOAD操作
	public FsLoaddatalistDto loadFsLoaddatalist(String floaddatano) {
		FsLoaddatalist fsLoaddatalist = (FsLoaddatalist) fsLoaddatalistDao.findByPk(floaddatano);
		FsLoaddatalistDto dto = (FsLoaddatalistDto) BeanHelper.buildBean(FsLoaddatalistDto.class, fsLoaddatalist);
		return dto;
	}
   //用于实现列表操作
   public QueryListObj listFsLoaddatalist() {
		QueryListObj obj = fsLoaddatalistDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(FsLoaddatalistDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj listFsLoaddatalistByHql(String hql) {
		QueryListObj obj = fsLoaddatalistDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(FsLoaddatalistDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj getFsLoaddatalistByHql(String hql, int beginPage, int pageSize, String sql) {
		QueryListObj obj = fsLoaddatalistDao.getQueryListByHql(hql, beginPage, pageSize);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(FsLoaddatalistDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		
		List sumList = fsLoaddatalistDao.getObjPropertySums(sql);
		//System.out.println("sumList.size():"+sumList.size());
		obj.setPropertySum(sumList);
		return obj;
	}

	
  /**
    * @business method list
	 	* @低周负荷数据采集
	     */

	//please add your business methods start
	// to do it
	//add your business method end
	
	public IFsLoaddatalistDao getFsLoaddatalistDao() {
		return fsLoaddatalistDao;
	}

	public void setFsLoaddatalistDao(IFsLoaddatalistDao fsLoaddatalistDao) {
		this.fsLoaddatalistDao = fsLoaddatalistDao;
	}
	
	public void setBaseJdbcDao(IBaseJdbcDao baseJdbcDao) {
		this.baseJdbcDao = baseJdbcDao;
	}
	
	public void saveOrUpdateFsLoaddatalist(List dtos) {
		List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			FsLoaddatalistDto fsLoaddatalistDto = (FsLoaddatalistDto)dtos.get(i);
			FsLoaddatalist fsLoaddatalist = (FsLoaddatalist) BeanHelper.buildBean(FsLoaddatalist.class, fsLoaddatalistDto);
		    pos.add(fsLoaddatalist);
		}
		
		fsLoaddatalistDao.saveOrUpdateAll(pos);	
	}
	
		
	
	 	//子表处理DAO
    	

   public QueryListObj listFsLfparalist() {
		QueryListObj obj = fsLfparalistDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(FsLfparalistDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
		
	
   public void saveOrUpdateFsLfparalist(FsLfparalistDto dto){
   
     if (StringUtils.isEmpty(dto.getFlinesno())){
		      if( StringUtils.isEmpty(dto.getFlinesno())){
		          dto.setFlinesno(new SequenceCreator().getUID());
		       }
		}
		FsLfparalist fsLfparalist = (FsLfparalist) BeanHelper.buildBean(FsLfparalist.class, dto);
		fsLfparalistDao.saveOrUpdate(fsLfparalist);
   
   }
   public void deleteFsLfparalist(String flinesno){
     
        FsLfparalist fsLfparalist = new FsLfparalist();
		fsLfparalist.setFlinesno(flinesno);
		fsLfparalistDao.delete(fsLfparalist);
   
   }
   public FsLfparalistDto loadFsLfparalist(String flinesno){
        FsLfparalist fsLfparalist = (FsLfparalist) fsLfparalistDao.findByPk(flinesno);
		FsLfparalistDto dto = (FsLfparalistDto) BeanHelper.buildBean(FsLfparalistDto.class, fsLfparalist);
		return dto;
   }
   public QueryListObj listFsLfparalistByHql(String hql){
      QueryListObj obj = fsLfparalistDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(FsLfparalistDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
   }
   public void saveOrUpdateFsLfparalist(List dtos){
     
   List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			FsLfparalistDto fsLfparalistDto = (FsLfparalistDto)dtos.get(i);
			FsLfparalist fsLfparalist = (FsLfparalist) BeanHelper.buildBean(FsLfparalist.class, fsLfparalistDto);
		    pos.add(fsLfparalist);
		}
		
		fsLfparalistDao.saveOrUpdateAll(pos);	
   
   }
   
   public void deleteFsLfparalist(List dtos){
      List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(FsLfparalist.class, dtos);
		fsLfparalistDao.deleteAll(pos);
   }
	
	  	


	
}
