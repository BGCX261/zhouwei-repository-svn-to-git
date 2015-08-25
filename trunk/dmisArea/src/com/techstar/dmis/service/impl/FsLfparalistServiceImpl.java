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
import com.techstar.dmis.dto.FsLfparalistDto;
import com.techstar.dmis.entity.FsLfparalist;
import com.techstar.dmis.service.IFsLfparalistService;
import org.springframework.dao.DataAccessException;

	//注册子表DAO
    import com.techstar.dmis.dto.FsLoaddatalistDto;
import com.techstar.dmis.entity.FsLoaddatalist;
	import com.techstar.dmis.dto.StdLfroundDto;
import com.techstar.dmis.entity.StdLfround;
	
//please add your business methods start
	// to do it
//add your business method end

/** 
 * 业务对象服务接口实现类
 * @author 
 * @date
 */
public class FsLfparalistServiceImpl implements IFsLfparalistService {
   //注册DAO
   private IFsLfparalistDao fsLfparalistDao;
   private IBaseJdbcDao baseJdbcDao ;
   
  	//注册管理DAO
    	 private IFsLoaddatalistDao fsLoaddatalistDao;
	 public void setFsLoaddatalistDao
	    (IFsLoaddatalistDao fsLoaddatalistDao) {
		 this.fsLoaddatalistDao = fsLoaddatalistDao;
     }
		 private IStdLfroundDao stdLfroundDao;
	 public void setStdLfroundDao
	    (IStdLfroundDao stdLfroundDao) {
		 this.stdLfroundDao = stdLfroundDao;
     }
	  	

	public FsLfparalistServiceImpl() {}
	
	public void addFsLfparalist(FsLfparalistDto dto) {
	
    	if (StringUtils.isEmpty(dto.getFlinesno())){
		      if( StringUtils.isEmpty(dto.getFlinesno())){
		          dto.setFlinesno(new SequenceCreator().getUID());
		       }
		}
    	//新增时候,主对象不用管子对象的保存
		FsLfparalist fsLfparalist = (FsLfparalist) BeanHelper.buildBean(FsLfparalist.class, dto);
		fsLfparalistDao.saveOrUpdate(fsLfparalist);		
	}
	
    //用于实现基本增加或修改操作
	public void saveOrUpdateFsLfparalist(FsLfparalistDto dto) {
		if (StringUtils.isEmpty(dto.getFlinesno())){
		      if( StringUtils.isEmpty(dto.getFlinesno())){
		          dto.setFlinesno(new SequenceCreator().getUID());
		       }
		}
		FsLfparalist fsLfparalist = (FsLfparalist) BeanHelper.buildBean(FsLfparalist.class, dto);
		fsLfparalistDao.saveOrUpdate(fsLfparalist);
	}
    //用于实现基本删除操作
	public void deleteFsLfparalist(String fsLfparalistId) {
		FsLfparalist fsLfparalist = new FsLfparalist();
		fsLfparalist.setFlinesno(fsLfparalistId);
		fsLfparalistDao.delete(fsLfparalist);
	}
	//用于实现基本删除集合操作
	public void deleteFsLfparalist(List dtos){
		List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(FsLfparalist.class, dtos);
		fsLfparalistDao.deleteAll(pos);
	}	
   //用于实现基本DTOLOAD操作
	public FsLfparalistDto loadFsLfparalist(String flinesno) {
		FsLfparalist fsLfparalist = (FsLfparalist) fsLfparalistDao.findByPk(flinesno);
		FsLfparalistDto dto = (FsLfparalistDto) BeanHelper.buildBean(FsLfparalistDto.class, fsLfparalist);
		return dto;
	}
   //用于实现列表操作
   public QueryListObj listFsLfparalist() {
		QueryListObj obj = fsLfparalistDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(FsLfparalistDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj listFsLfparalistByHql(String hql) {
		QueryListObj obj = fsLfparalistDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(FsLfparalistDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj getFsLfparalistByHql(String hql, int beginPage, int pageSize, String sql) {
		QueryListObj obj = fsLfparalistDao.getQueryListByHql(hql, beginPage, pageSize);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(FsLfparalistDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		
		List sumList = fsLfparalistDao.getObjPropertySums(sql);
		//System.out.println("sumList.size():"+sumList.size());
		obj.setPropertySum(sumList);
		return obj;
	}

	
  /**
    * @business method list
	 	* @设定低周线路采集点
	     */

	//please add your business methods start
	// to do it
	//add your business method end
	
	public IFsLfparalistDao getFsLfparalistDao() {
		return fsLfparalistDao;
	}

	public void setFsLfparalistDao(IFsLfparalistDao fsLfparalistDao) {
		this.fsLfparalistDao = fsLfparalistDao;
	}
	
	public void setBaseJdbcDao(IBaseJdbcDao baseJdbcDao) {
		this.baseJdbcDao = baseJdbcDao;
	}
	
	public void saveOrUpdateFsLfparalist(List dtos) {
		List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			FsLfparalistDto fsLfparalistDto = (FsLfparalistDto)dtos.get(i);
			FsLfparalist fsLfparalist = (FsLfparalist) BeanHelper.buildBean(FsLfparalist.class, fsLfparalistDto);
		    pos.add(fsLfparalist);
		}
		
		fsLfparalistDao.saveOrUpdateAll(pos);	
	}
	
		
	
	 	//子表处理DAO
    	

   public QueryListObj listFsLoaddatalist() {
		QueryListObj obj = fsLoaddatalistDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(FsLoaddatalistDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
		
	
   public void saveOrUpdateFsLoaddatalist(FsLoaddatalistDto dto){
   
     if (StringUtils.isEmpty(dto.getFloaddatano())){
		      if( StringUtils.isEmpty(dto.getFloaddatano())){
		          dto.setFloaddatano(new SequenceCreator().getUID());
		       }
		}
		FsLoaddatalist fsLoaddatalist = (FsLoaddatalist) BeanHelper.buildBean(FsLoaddatalist.class, dto);
		fsLoaddatalistDao.saveOrUpdate(fsLoaddatalist);
   
   }
   public void deleteFsLoaddatalist(String floaddatano){
     
        FsLoaddatalist fsLoaddatalist = new FsLoaddatalist();
		fsLoaddatalist.setFloaddatano(floaddatano);
		fsLoaddatalistDao.delete(fsLoaddatalist);
   
   }
   public FsLoaddatalistDto loadFsLoaddatalist(String floaddatano){
        FsLoaddatalist fsLoaddatalist = (FsLoaddatalist) fsLoaddatalistDao.findByPk(floaddatano);
		FsLoaddatalistDto dto = (FsLoaddatalistDto) BeanHelper.buildBean(FsLoaddatalistDto.class, fsLoaddatalist);
		return dto;
   }
   public QueryListObj listFsLoaddatalistByHql(String hql){
      QueryListObj obj = fsLoaddatalistDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(FsLoaddatalistDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
   }
   public void saveOrUpdateFsLoaddatalist(List dtos){
     
   List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			FsLoaddatalistDto fsLoaddatalistDto = (FsLoaddatalistDto)dtos.get(i);
			FsLoaddatalist fsLoaddatalist = (FsLoaddatalist) BeanHelper.buildBean(FsLoaddatalist.class, fsLoaddatalistDto);
		    pos.add(fsLoaddatalist);
		}
		
		fsLoaddatalistDao.saveOrUpdateAll(pos);	
   
   }
   
   public void deleteFsLoaddatalist(List dtos){
      List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(FsLoaddatalist.class, dtos);
		fsLoaddatalistDao.deleteAll(pos);
   }
	
		

   public QueryListObj listStdLfround() {
		QueryListObj obj = stdLfroundDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(StdLfroundDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
		
	
   public void saveOrUpdateStdLfround(StdLfroundDto dto){
   
     if (StringUtils.isEmpty(dto.getId())){
		      if( StringUtils.isEmpty(dto.getId())){
		          dto.setId(new SequenceCreator().getUID());
		       }
		}
		StdLfround stdLfround = (StdLfround) BeanHelper.buildBean(StdLfround.class, dto);
		stdLfroundDao.saveOrUpdate(stdLfround);
   
   }
   public void deleteStdLfround(String id){
     
        StdLfround stdLfround = new StdLfround();
		stdLfround.setId(id);
		stdLfroundDao.delete(stdLfround);
   
   }
   public StdLfroundDto loadStdLfround(String id){
        StdLfround stdLfround = (StdLfround) stdLfroundDao.findByPk(id);
		StdLfroundDto dto = (StdLfroundDto) BeanHelper.buildBean(StdLfroundDto.class, stdLfround);
		return dto;
   }
   public QueryListObj listStdLfroundByHql(String hql){
      QueryListObj obj = stdLfroundDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(StdLfroundDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
   }
   public void saveOrUpdateStdLfround(List dtos){
     
   List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			StdLfroundDto stdLfroundDto = (StdLfroundDto)dtos.get(i);
			StdLfround stdLfround = (StdLfround) BeanHelper.buildBean(StdLfround.class, stdLfroundDto);
		    pos.add(stdLfround);
		}
		
		stdLfroundDao.saveOrUpdateAll(pos);	
   
   }
   
   public void deleteStdLfround(List dtos){
      List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(StdLfround.class, dtos);
		stdLfroundDao.deleteAll(pos);
   }
	
	  	


	
}
