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
import com.techstar.dmis.dto.FsApprovebookDto;
import com.techstar.dmis.entity.FsApprovebook;
import com.techstar.dmis.service.IFsApprovebookService;
import org.springframework.dao.DataAccessException;

	//注册子表DAO
    import com.techstar.dmis.dto.FsApprovebookdetailDto;
import com.techstar.dmis.entity.FsApprovebookdetail;
	import com.techstar.dmis.dto.FsAfrelDto;
import com.techstar.dmis.entity.FsAfrel;
	import com.techstar.dmis.dto.FsApproveeqprelDto;
import com.techstar.dmis.entity.FsApproveeqprel;
	import com.techstar.dmis.dto.FsAllappendixDto;
import com.techstar.dmis.entity.FsAllappendix;
	import com.techstar.dmis.dto.BhAsregulateDto;
import com.techstar.dmis.entity.BhAsregulate;
	
//please add your business methods start
	// to do it
//add your business method end

/** 
 * 业务对象服务接口实现类
 * @author 
 * @date
 */
public class FsApprovebookServiceImpl implements IFsApprovebookService {
   //注册DAO
   private IFsApprovebookDao fsApprovebookDao;
   private IBaseJdbcDao baseJdbcDao ;
   
  	//注册管理DAO
    	 private IFsApprovebookdetailDao fsApprovebookdetailDao;
	 public void setFsApprovebookdetailDao
	    (IFsApprovebookdetailDao fsApprovebookdetailDao) {
		 this.fsApprovebookdetailDao = fsApprovebookdetailDao;
     }
		 private IFsAfrelDao fsAfrelDao;
	 public void setFsAfrelDao
	    (IFsAfrelDao fsAfrelDao) {
		 this.fsAfrelDao = fsAfrelDao;
     }
		 private IFsApproveeqprelDao fsApproveeqprelDao;
	 public void setFsApproveeqprelDao
	    (IFsApproveeqprelDao fsApproveeqprelDao) {
		 this.fsApproveeqprelDao = fsApproveeqprelDao;
     }
		 private IFsAllappendixDao fsAllappendixDao;
	 public void setFsAllappendixDao
	    (IFsAllappendixDao fsAllappendixDao) {
		 this.fsAllappendixDao = fsAllappendixDao;
     }
		 private IBhAsregulateDao bhAsregulateDao;
	 public void setBhAsregulateDao
	    (IBhAsregulateDao bhAsregulateDao) {
		 this.bhAsregulateDao = bhAsregulateDao;
     }
	  	

	public FsApprovebookServiceImpl() {}
	
	public void addFsApprovebook(FsApprovebookDto dto) {
	
    	if (StringUtils.isEmpty(dto.getFapprovcomputerno())){
		      if( StringUtils.isEmpty(dto.getFapprovcomputerno())){
		          dto.setFapprovcomputerno(new SequenceCreator().getUID());
		       }
		}
    	//新增时候,主对象不用管子对象的保存
		FsApprovebook fsApprovebook = (FsApprovebook) BeanHelper.buildBean(FsApprovebook.class, dto);
		fsApprovebookDao.saveOrUpdate(fsApprovebook);		
	}
	
    //用于实现基本增加或修改操作
	public void saveOrUpdateFsApprovebook(FsApprovebookDto dto) {
		if (StringUtils.isEmpty(dto.getFapprovcomputerno())){
		      if( StringUtils.isEmpty(dto.getFapprovcomputerno())){
		          dto.setFapprovcomputerno(new SequenceCreator().getUID());
		       }
		}
		FsApprovebook fsApprovebook = (FsApprovebook) BeanHelper.buildBean(FsApprovebook.class, dto);
		fsApprovebookDao.saveOrUpdate(fsApprovebook);
	}
    //用于实现基本删除操作
	public void deleteFsApprovebook(String fsApprovebookId) {
		FsApprovebook fsApprovebook = new FsApprovebook();
		fsApprovebook.setFapprovcomputerno(fsApprovebookId);
		fsApprovebookDao.delete(fsApprovebook);
	}
	//用于实现基本删除集合操作
	public void deleteFsApprovebook(List dtos){
		List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(FsApprovebook.class, dtos);
		fsApprovebookDao.deleteAll(pos);
	}	
   //用于实现基本DTOLOAD操作
	public FsApprovebookDto loadFsApprovebook(String fapprovcomputerno) {
		FsApprovebook fsApprovebook = (FsApprovebook) fsApprovebookDao.findByPk(fapprovcomputerno);
		FsApprovebookDto dto = (FsApprovebookDto) BeanHelper.buildBean(FsApprovebookDto.class, fsApprovebook);
		return dto;
	}
   //用于实现列表操作
   public QueryListObj listFsApprovebook() {
		QueryListObj obj = fsApprovebookDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(FsApprovebookDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj listFsApprovebookByHql(String hql) {
		QueryListObj obj = fsApprovebookDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(FsApprovebookDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj getFsApprovebookByHql(String hql, int beginPage, int pageSize, String sql) {
		QueryListObj obj = fsApprovebookDao.getQueryListByHql(hql, beginPage, pageSize);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(FsApprovebookDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		
		List sumList = fsApprovebookDao.getObjPropertySums(sql);
		//System.out.println("sumList.size():"+sumList.size());
		obj.setPropertySum(sumList);
		return obj;
	}

	
  /**
    * @business method list
	 	* @拟定操作票
	 	* @自投规程导入
	 	* @发电批准书发布
	 	* @定值单导入
	 	* @发电批准书执行
	 	* @发电批准书上报
	 	* @设备参数上报
	 	* @批准书归档
	 	* @电网实时方式分析单
	 	* @编制系统图改图任务单
	     */

	//please add your business methods start
	// to do it
	//add your business method end
	
	public IFsApprovebookDao getFsApprovebookDao() {
		return fsApprovebookDao;
	}

	public void setFsApprovebookDao(IFsApprovebookDao fsApprovebookDao) {
		this.fsApprovebookDao = fsApprovebookDao;
	}
	
	public void setBaseJdbcDao(IBaseJdbcDao baseJdbcDao) {
		this.baseJdbcDao = baseJdbcDao;
	}
	
	public void saveOrUpdateFsApprovebook(List dtos) {
		List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			FsApprovebookDto fsApprovebookDto = (FsApprovebookDto)dtos.get(i);
			FsApprovebook fsApprovebook = (FsApprovebook) BeanHelper.buildBean(FsApprovebook.class, fsApprovebookDto);
		    pos.add(fsApprovebook);
		}
		
		fsApprovebookDao.saveOrUpdateAll(pos);	
	}
	
		
	
	 	//子表处理DAO
    	

   public QueryListObj listFsApprovebookdetail() {
		QueryListObj obj = fsApprovebookdetailDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(FsApprovebookdetailDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
		
	
   public void saveOrUpdateFsApprovebookdetail(FsApprovebookdetailDto dto){
   
     if (StringUtils.isEmpty(dto.getFapprovexcuteno())){
		      if( StringUtils.isEmpty(dto.getFapprovexcuteno())){
		          dto.setFapprovexcuteno(new SequenceCreator().getUID());
		       }
		}
		FsApprovebookdetail fsApprovebookdetail = (FsApprovebookdetail) BeanHelper.buildBean(FsApprovebookdetail.class, dto);
		fsApprovebookdetailDao.saveOrUpdate(fsApprovebookdetail);
   
   }
   public void deleteFsApprovebookdetail(String fapprovexcuteno){
     
        FsApprovebookdetail fsApprovebookdetail = new FsApprovebookdetail();
		fsApprovebookdetail.setFapprovexcuteno(fapprovexcuteno);
		fsApprovebookdetailDao.delete(fsApprovebookdetail);
   
   }
   public FsApprovebookdetailDto loadFsApprovebookdetail(String fapprovexcuteno){
        FsApprovebookdetail fsApprovebookdetail = (FsApprovebookdetail) fsApprovebookdetailDao.findByPk(fapprovexcuteno);
		FsApprovebookdetailDto dto = (FsApprovebookdetailDto) BeanHelper.buildBean(FsApprovebookdetailDto.class, fsApprovebookdetail);
		return dto;
   }
   public QueryListObj listFsApprovebookdetailByHql(String hql){
      QueryListObj obj = fsApprovebookdetailDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(FsApprovebookdetailDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
   }
   public void saveOrUpdateFsApprovebookdetail(List dtos){
     
   List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			FsApprovebookdetailDto fsApprovebookdetailDto = (FsApprovebookdetailDto)dtos.get(i);
			FsApprovebookdetail fsApprovebookdetail = (FsApprovebookdetail) BeanHelper.buildBean(FsApprovebookdetail.class, fsApprovebookdetailDto);
		    pos.add(fsApprovebookdetail);
		}
		
		fsApprovebookdetailDao.saveOrUpdateAll(pos);	
   
   }
   
   public void deleteFsApprovebookdetail(List dtos){
      List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(FsApprovebookdetail.class, dtos);
		fsApprovebookdetailDao.deleteAll(pos);
   }
	
		

   public QueryListObj listFsAfrel() {
		QueryListObj obj = fsAfrelDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(FsAfrelDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
		
	
   public void saveOrUpdateFsAfrel(FsAfrelDto dto){
   
     if (StringUtils.isEmpty(dto.getFapprovfixrelno())){
		      if( StringUtils.isEmpty(dto.getFapprovfixrelno())){
		          dto.setFapprovfixrelno(new SequenceCreator().getUID());
		       }
		}
		FsAfrel fsAfrel = (FsAfrel) BeanHelper.buildBean(FsAfrel.class, dto);
		fsAfrelDao.saveOrUpdate(fsAfrel);
   
   }
   public void deleteFsAfrel(String fapprovfixrelno){
     
        FsAfrel fsAfrel = new FsAfrel();
		fsAfrel.setFapprovfixrelno(fapprovfixrelno);
		fsAfrelDao.delete(fsAfrel);
   
   }
   public FsAfrelDto loadFsAfrel(String fapprovfixrelno){
        FsAfrel fsAfrel = (FsAfrel) fsAfrelDao.findByPk(fapprovfixrelno);
		FsAfrelDto dto = (FsAfrelDto) BeanHelper.buildBean(FsAfrelDto.class, fsAfrel);
		return dto;
   }
   public QueryListObj listFsAfrelByHql(String hql){
      QueryListObj obj = fsAfrelDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(FsAfrelDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
   }
   public void saveOrUpdateFsAfrel(List dtos){
     
   List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			FsAfrelDto fsAfrelDto = (FsAfrelDto)dtos.get(i);
			FsAfrel fsAfrel = (FsAfrel) BeanHelper.buildBean(FsAfrel.class, fsAfrelDto);
		    pos.add(fsAfrel);
		}
		
		fsAfrelDao.saveOrUpdateAll(pos);	
   
   }
   
   public void deleteFsAfrel(List dtos){
      List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(FsAfrel.class, dtos);
		fsAfrelDao.deleteAll(pos);
   }
	
		

   public QueryListObj listFsApproveeqprel() {
		QueryListObj obj = fsApproveeqprelDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(FsApproveeqprelDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
		
	
   public void saveOrUpdateFsApproveeqprel(FsApproveeqprelDto dto){
   
     if (StringUtils.isEmpty(dto.getFappeqprelid())){
		      if( StringUtils.isEmpty(dto.getFappeqprelid())){
		          dto.setFappeqprelid(new SequenceCreator().getUID());
		       }
		}
		FsApproveeqprel fsApproveeqprel = (FsApproveeqprel) BeanHelper.buildBean(FsApproveeqprel.class, dto);
		fsApproveeqprelDao.saveOrUpdate(fsApproveeqprel);
   
   }
   public void deleteFsApproveeqprel(String fappeqprelid){
     
        FsApproveeqprel fsApproveeqprel = new FsApproveeqprel();
		fsApproveeqprel.setFappeqprelid(fappeqprelid);
		fsApproveeqprelDao.delete(fsApproveeqprel);
   
   }
   public FsApproveeqprelDto loadFsApproveeqprel(String fappeqprelid){
        FsApproveeqprel fsApproveeqprel = (FsApproveeqprel) fsApproveeqprelDao.findByPk(fappeqprelid);
		FsApproveeqprelDto dto = (FsApproveeqprelDto) BeanHelper.buildBean(FsApproveeqprelDto.class, fsApproveeqprel);
		return dto;
   }
   public QueryListObj listFsApproveeqprelByHql(String hql){
      QueryListObj obj = fsApproveeqprelDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(FsApproveeqprelDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
   }
   public void saveOrUpdateFsApproveeqprel(List dtos){
     
   List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			FsApproveeqprelDto fsApproveeqprelDto = (FsApproveeqprelDto)dtos.get(i);
			FsApproveeqprel fsApproveeqprel = (FsApproveeqprel) BeanHelper.buildBean(FsApproveeqprel.class, fsApproveeqprelDto);
		    pos.add(fsApproveeqprel);
		}
		
		fsApproveeqprelDao.saveOrUpdateAll(pos);	
   
   }
   
   public void deleteFsApproveeqprel(List dtos){
      List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(FsApproveeqprel.class, dtos);
		fsApproveeqprelDao.deleteAll(pos);
   }
	
		

   public QueryListObj listFsAllappendix() {
		QueryListObj obj = fsAllappendixDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(FsAllappendixDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
		
	
   public void saveOrUpdateFsAllappendix(FsAllappendixDto dto){
   
     if (StringUtils.isEmpty(dto.getF_id())){
		      if( StringUtils.isEmpty(dto.getF_id())){
		          dto.setF_id(new SequenceCreator().getUID());
		       }
		}
		FsAllappendix fsAllappendix = (FsAllappendix) BeanHelper.buildBean(FsAllappendix.class, dto);
		fsAllappendixDao.saveOrUpdate(fsAllappendix);
   
   }
   public void deleteFsAllappendix(String f_id){
     
        FsAllappendix fsAllappendix = new FsAllappendix();
		fsAllappendix.setF_id(f_id);
		fsAllappendixDao.delete(fsAllappendix);
   
   }
   public FsAllappendixDto loadFsAllappendix(String f_id){
        FsAllappendix fsAllappendix = (FsAllappendix) fsAllappendixDao.findByPk(f_id);
		FsAllappendixDto dto = (FsAllappendixDto) BeanHelper.buildBean(FsAllappendixDto.class, fsAllappendix);
		return dto;
   }
   public QueryListObj listFsAllappendixByHql(String hql){
      QueryListObj obj = fsAllappendixDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(FsAllappendixDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
   }
   public void saveOrUpdateFsAllappendix(List dtos){
     
   List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			FsAllappendixDto fsAllappendixDto = (FsAllappendixDto)dtos.get(i);
			FsAllappendix fsAllappendix = (FsAllappendix) BeanHelper.buildBean(FsAllappendix.class, fsAllappendixDto);
		    pos.add(fsAllappendix);
		}
		
		fsAllappendixDao.saveOrUpdateAll(pos);	
   
   }
   
   public void deleteFsAllappendix(List dtos){
      List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(FsAllappendix.class, dtos);
		fsAllappendixDao.deleteAll(pos);
   }
	
		

   public QueryListObj listBhAsregulate() {
		QueryListObj obj = bhAsregulateDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(BhAsregulateDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
		
	
   public void saveOrUpdateBhAsregulate(BhAsregulateDto dto){
   
     if (StringUtils.isEmpty(dto.getAsregulateid())){
		      if( StringUtils.isEmpty(dto.getAsregulateid())){
		          dto.setAsregulateid(new SequenceCreator().getUID());
		       }
		}
		BhAsregulate bhAsregulate = (BhAsregulate) BeanHelper.buildBean(BhAsregulate.class, dto);
		bhAsregulateDao.saveOrUpdate(bhAsregulate);
   
   }
   public void deleteBhAsregulate(String asregulateid){
     
        BhAsregulate bhAsregulate = new BhAsregulate();
		bhAsregulate.setAsregulateid(asregulateid);
		bhAsregulateDao.delete(bhAsregulate);
   
   }
   public BhAsregulateDto loadBhAsregulate(String asregulateid){
        BhAsregulate bhAsregulate = (BhAsregulate) bhAsregulateDao.findByPk(asregulateid);
		BhAsregulateDto dto = (BhAsregulateDto) BeanHelper.buildBean(BhAsregulateDto.class, bhAsregulate);
		return dto;
   }
   public QueryListObj listBhAsregulateByHql(String hql){
      QueryListObj obj = bhAsregulateDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(BhAsregulateDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
   }
   public void saveOrUpdateBhAsregulate(List dtos){
     
   List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			BhAsregulateDto bhAsregulateDto = (BhAsregulateDto)dtos.get(i);
			BhAsregulate bhAsregulate = (BhAsregulate) BeanHelper.buildBean(BhAsregulate.class, bhAsregulateDto);
		    pos.add(bhAsregulate);
		}
		
		bhAsregulateDao.saveOrUpdateAll(pos);	
   
   }
   
   public void deleteBhAsregulate(List dtos){
      List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(BhAsregulate.class, dtos);
		bhAsregulateDao.deleteAll(pos);
   }
	
	  	


	
}
