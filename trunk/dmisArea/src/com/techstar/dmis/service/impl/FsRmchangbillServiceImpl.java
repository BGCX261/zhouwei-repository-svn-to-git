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
import com.techstar.dmis.dto.FsRmchangbillDto;
import com.techstar.dmis.entity.FsRmchangbill;
import com.techstar.dmis.service.IFsRmchangbillService;
import org.springframework.dao.DataAccessException;

	//注册子表DAO
    import com.techstar.dmis.dto.DdfsModechangelistDto;
import com.techstar.dmis.entity.DdfsModechangelist;
	
//please add your business methods start
	// to do it
//add your business method end

/** 
 * 业务对象服务接口实现类
 * @author 
 * @date
 */
public class FsRmchangbillServiceImpl implements IFsRmchangbillService {
   //注册DAO
   private IFsRmchangbillDao fsRmchangbillDao;
   private IBaseJdbcDao baseJdbcDao ;
   
  	//注册管理DAO
    	 private IDdfsModechangelistDao ddfsModechangelistDao;
	 public void setDdfsModechangelistDao
	    (IDdfsModechangelistDao ddfsModechangelistDao) {
		 this.ddfsModechangelistDao = ddfsModechangelistDao;
     }
	  	

	public FsRmchangbillServiceImpl() {}
	
	public void addFsRmchangbill(FsRmchangbillDto dto) {
	
    	if (StringUtils.isEmpty(dto.getFchangno())){
		      if( StringUtils.isEmpty(dto.getFchangno())){
		          dto.setFchangno(new SequenceCreator().getUID());
		       }
		}
    	//新增时候,主对象不用管子对象的保存
		FsRmchangbill fsRmchangbill = (FsRmchangbill) BeanHelper.buildBean(FsRmchangbill.class, dto);
		fsRmchangbillDao.saveOrUpdate(fsRmchangbill);		
	}
	
    //用于实现基本增加或修改操作
	public void saveOrUpdateFsRmchangbill(FsRmchangbillDto dto) {
		if (StringUtils.isEmpty(dto.getFchangno())){
		      if( StringUtils.isEmpty(dto.getFchangno())){
		          dto.setFchangno(new SequenceCreator().getUID());
		       }
		}
		FsRmchangbill fsRmchangbill = (FsRmchangbill) BeanHelper.buildBean(FsRmchangbill.class, dto);
		fsRmchangbillDao.saveOrUpdate(fsRmchangbill);
	}
    //用于实现基本删除操作
	public void deleteFsRmchangbill(String fsRmchangbillId) {
		FsRmchangbill fsRmchangbill = new FsRmchangbill();
		fsRmchangbill.setFchangno(fsRmchangbillId);
		fsRmchangbillDao.delete(fsRmchangbill);
	}
	//用于实现基本删除集合操作
	public void deleteFsRmchangbill(List dtos){
		List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(FsRmchangbill.class, dtos);
		fsRmchangbillDao.deleteAll(pos);
	}	
   //用于实现基本DTOLOAD操作
	public FsRmchangbillDto loadFsRmchangbill(String fchangno) {
		FsRmchangbill fsRmchangbill = (FsRmchangbill) fsRmchangbillDao.findByPk(fchangno);
		FsRmchangbillDto dto = (FsRmchangbillDto) BeanHelper.buildBean(FsRmchangbillDto.class, fsRmchangbill);
		return dto;
	}
   //用于实现列表操作
   public QueryListObj listFsRmchangbill() {
		QueryListObj obj = fsRmchangbillDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(FsRmchangbillDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj listFsRmchangbillByHql(String hql) {
		QueryListObj obj = fsRmchangbillDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(FsRmchangbillDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj getFsRmchangbillByHql(String hql, int beginPage, int pageSize, String sql) {
		QueryListObj obj = fsRmchangbillDao.getQueryListByHql(hql, beginPage, pageSize);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(FsRmchangbillDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		
		List sumList = fsRmchangbillDao.getObjPropertySums(sql);
		//System.out.println("sumList.size():"+sumList.size());
		obj.setPropertySum(sumList);
		return obj;
	}

	
  /**
    * @business method list
	 	* @拟定操作票
	 	* @电网实时方式分析单
	 	* @方式恢复
	 	* @执行完毕
	     */

	//please add your business methods start
	// to do it
	//add your business method end
	
	public IFsRmchangbillDao getFsRmchangbillDao() {
		return fsRmchangbillDao;
	}

	public void setFsRmchangbillDao(IFsRmchangbillDao fsRmchangbillDao) {
		this.fsRmchangbillDao = fsRmchangbillDao;
	}
	
	public void setBaseJdbcDao(IBaseJdbcDao baseJdbcDao) {
		this.baseJdbcDao = baseJdbcDao;
	}
	
	public void saveOrUpdateFsRmchangbill(List dtos) {
		List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			FsRmchangbillDto fsRmchangbillDto = (FsRmchangbillDto)dtos.get(i);
			FsRmchangbill fsRmchangbill = (FsRmchangbill) BeanHelper.buildBean(FsRmchangbill.class, fsRmchangbillDto);
		    pos.add(fsRmchangbill);
		}
		
		fsRmchangbillDao.saveOrUpdateAll(pos);	
	}
	
		
	
	 	//子表处理DAO
    	

   public QueryListObj listDdfsModechangelist() {
		QueryListObj obj = ddfsModechangelistDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdfsModechangelistDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
		
	
   public void saveOrUpdateDdfsModechangelist(DdfsModechangelistDto dto){
   
     if (StringUtils.isEmpty(dto.getFid())){
		      if( StringUtils.isEmpty(dto.getFid())){
		          dto.setFid(new SequenceCreator().getUID());
		       }
		}
		DdfsModechangelist ddfsModechangelist = (DdfsModechangelist) BeanHelper.buildBean(DdfsModechangelist.class, dto);
		ddfsModechangelistDao.saveOrUpdate(ddfsModechangelist);
   
   }
   public void deleteDdfsModechangelist(String fid){
     
        DdfsModechangelist ddfsModechangelist = new DdfsModechangelist();
		ddfsModechangelist.setFid(fid);
		ddfsModechangelistDao.delete(ddfsModechangelist);
   
   }
   public DdfsModechangelistDto loadDdfsModechangelist(String fid){
        DdfsModechangelist ddfsModechangelist = (DdfsModechangelist) ddfsModechangelistDao.findByPk(fid);
		DdfsModechangelistDto dto = (DdfsModechangelistDto) BeanHelper.buildBean(DdfsModechangelistDto.class, ddfsModechangelist);
		return dto;
   }
   public QueryListObj listDdfsModechangelistByHql(String hql){
      QueryListObj obj = ddfsModechangelistDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdfsModechangelistDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
   }
   public void saveOrUpdateDdfsModechangelist(List dtos){
     
   List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			DdfsModechangelistDto ddfsModechangelistDto = (DdfsModechangelistDto)dtos.get(i);
			DdfsModechangelist ddfsModechangelist = (DdfsModechangelist) BeanHelper.buildBean(DdfsModechangelist.class, ddfsModechangelistDto);
		    pos.add(ddfsModechangelist);
		}
		
		ddfsModechangelistDao.saveOrUpdateAll(pos);	
   
   }
   
   public void deleteDdfsModechangelist(List dtos){
      List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(DdfsModechangelist.class, dtos);
		ddfsModechangelistDao.deleteAll(pos);
   }
	
	  	


	
}
