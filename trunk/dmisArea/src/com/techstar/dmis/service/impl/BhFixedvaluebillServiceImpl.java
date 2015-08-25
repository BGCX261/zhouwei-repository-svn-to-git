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
import com.techstar.dmis.dto.BhFixedvaluebillDto;
import com.techstar.dmis.entity.BhFixedvaluebill;
import com.techstar.dmis.service.IBhFixedvaluebillService;
import org.springframework.dao.DataAccessException;

	//注册子表DAO
    import com.techstar.dmis.dto.BhFixedvaluebilldetailDto;
import com.techstar.dmis.entity.BhFixedvaluebilldetail;
	
//please add your business methods start
	// to do it
//add your business method end

/** 
 * 业务对象服务接口实现类
 * @author 
 * @date
 */
public class BhFixedvaluebillServiceImpl implements IBhFixedvaluebillService {
   //注册DAO
   private IBhFixedvaluebillDao bhFixedvaluebillDao;
   private IBaseJdbcDao baseJdbcDao ;
   
  	//注册管理DAO
    	 private IBhFixedvaluebilldetailDao bhFixedvaluebilldetailDao;
	 public void setBhFixedvaluebilldetailDao
	    (IBhFixedvaluebilldetailDao bhFixedvaluebilldetailDao) {
		 this.bhFixedvaluebilldetailDao = bhFixedvaluebilldetailDao;
     }
	  	

	public BhFixedvaluebillServiceImpl() {}
	
	public void addBhFixedvaluebill(BhFixedvaluebillDto dto) {
	
    	if (StringUtils.isEmpty(dto.getFixvaluebillno())){
		      if( StringUtils.isEmpty(dto.getFixvaluebillno())){
		          dto.setFixvaluebillno(new SequenceCreator().getUID());
		       }
		}
    	//新增时候,主对象不用管子对象的保存
		BhFixedvaluebill bhFixedvaluebill = (BhFixedvaluebill) BeanHelper.buildBean(BhFixedvaluebill.class, dto);
		bhFixedvaluebillDao.saveOrUpdate(bhFixedvaluebill);		
	}
	
    //用于实现基本增加或修改操作
	public void saveOrUpdateBhFixedvaluebill(BhFixedvaluebillDto dto) {
		if (StringUtils.isEmpty(dto.getFixvaluebillno())){
		      if( StringUtils.isEmpty(dto.getFixvaluebillno())){
		          dto.setFixvaluebillno(new SequenceCreator().getUID());
		       }
		}
		BhFixedvaluebill bhFixedvaluebill = (BhFixedvaluebill) BeanHelper.buildBean(BhFixedvaluebill.class, dto);
		bhFixedvaluebillDao.saveOrUpdate(bhFixedvaluebill);
	}
    //用于实现基本删除操作
	public void deleteBhFixedvaluebill(String bhFixedvaluebillId) {
		BhFixedvaluebill bhFixedvaluebill = new BhFixedvaluebill();
		bhFixedvaluebill.setFixvaluebillno(bhFixedvaluebillId);
		bhFixedvaluebillDao.delete(bhFixedvaluebill);
	}
	//用于实现基本删除集合操作
	public void deleteBhFixedvaluebill(List dtos){
		List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(BhFixedvaluebill.class, dtos);
		bhFixedvaluebillDao.deleteAll(pos);
	}	
   //用于实现基本DTOLOAD操作
	public BhFixedvaluebillDto loadBhFixedvaluebill(String fixvaluebillno) {
		BhFixedvaluebill bhFixedvaluebill = (BhFixedvaluebill) bhFixedvaluebillDao.findByPk(fixvaluebillno);
		BhFixedvaluebillDto dto = (BhFixedvaluebillDto) BeanHelper.buildBean(BhFixedvaluebillDto.class, bhFixedvaluebill);
		return dto;
	}
   //用于实现列表操作
   public QueryListObj listBhFixedvaluebill() {
		QueryListObj obj = bhFixedvaluebillDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(BhFixedvaluebillDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj listBhFixedvaluebillByHql(String hql) {
		QueryListObj obj = bhFixedvaluebillDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(BhFixedvaluebillDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj getBhFixedvaluebillByHql(String hql, int beginPage, int pageSize, String sql) {
		QueryListObj obj = bhFixedvaluebillDao.getQueryListByHql(hql, beginPage, pageSize);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(BhFixedvaluebillDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		
		List sumList = bhFixedvaluebillDao.getObjPropertySums(sql);
		//System.out.println("sumList.size():"+sumList.size());
		obj.setPropertySum(sumList);
		return obj;
	}

	
  /**
    * @business method list
	 	* @从设备台帐取值
	 	* @归档并作废旧定值
	     */

	//please add your business methods start
	// to do it
	//add your business method end
	
	public IBhFixedvaluebillDao getBhFixedvaluebillDao() {
		return bhFixedvaluebillDao;
	}

	public void setBhFixedvaluebillDao(IBhFixedvaluebillDao bhFixedvaluebillDao) {
		this.bhFixedvaluebillDao = bhFixedvaluebillDao;
	}
	
	public void setBaseJdbcDao(IBaseJdbcDao baseJdbcDao) {
		this.baseJdbcDao = baseJdbcDao;
	}
	
	public void saveOrUpdateBhFixedvaluebill(List dtos) {
		List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			BhFixedvaluebillDto bhFixedvaluebillDto = (BhFixedvaluebillDto)dtos.get(i);
			BhFixedvaluebill bhFixedvaluebill = (BhFixedvaluebill) BeanHelper.buildBean(BhFixedvaluebill.class, bhFixedvaluebillDto);
		    pos.add(bhFixedvaluebill);
		}
		
		bhFixedvaluebillDao.saveOrUpdateAll(pos);	
	}
	
		
	
	 	//子表处理DAO
    	

   public QueryListObj listBhFixedvaluebilldetail() {
		QueryListObj obj = bhFixedvaluebilldetailDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(BhFixedvaluebilldetailDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
		
	
   public void saveOrUpdateBhFixedvaluebilldetail(BhFixedvaluebilldetailDto dto){
   
     if (StringUtils.isEmpty(dto.getSerialno())){
		      if( StringUtils.isEmpty(dto.getSerialno())){
		          dto.setSerialno(new SequenceCreator().getUID());
		       }
		}
		BhFixedvaluebilldetail bhFixedvaluebilldetail = (BhFixedvaluebilldetail) BeanHelper.buildBean(BhFixedvaluebilldetail.class, dto);
		bhFixedvaluebilldetailDao.saveOrUpdate(bhFixedvaluebilldetail);
   
   }
   public void deleteBhFixedvaluebilldetail(String serialno){
     
        BhFixedvaluebilldetail bhFixedvaluebilldetail = new BhFixedvaluebilldetail();
		bhFixedvaluebilldetail.setSerialno(serialno);
		bhFixedvaluebilldetailDao.delete(bhFixedvaluebilldetail);
   
   }
   public BhFixedvaluebilldetailDto loadBhFixedvaluebilldetail(String serialno){
        BhFixedvaluebilldetail bhFixedvaluebilldetail = (BhFixedvaluebilldetail) bhFixedvaluebilldetailDao.findByPk(serialno);
		BhFixedvaluebilldetailDto dto = (BhFixedvaluebilldetailDto) BeanHelper.buildBean(BhFixedvaluebilldetailDto.class, bhFixedvaluebilldetail);
		return dto;
   }
   public QueryListObj listBhFixedvaluebilldetailByHql(String hql){
      QueryListObj obj = bhFixedvaluebilldetailDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(BhFixedvaluebilldetailDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
   }
   public void saveOrUpdateBhFixedvaluebilldetail(List dtos){
     
   List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			BhFixedvaluebilldetailDto bhFixedvaluebilldetailDto = (BhFixedvaluebilldetailDto)dtos.get(i);
			BhFixedvaluebilldetail bhFixedvaluebilldetail = (BhFixedvaluebilldetail) BeanHelper.buildBean(BhFixedvaluebilldetail.class, bhFixedvaluebilldetailDto);
		    pos.add(bhFixedvaluebilldetail);
		}
		
		bhFixedvaluebilldetailDao.saveOrUpdateAll(pos);	
   
   }
   
   public void deleteBhFixedvaluebilldetail(List dtos){
      List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(BhFixedvaluebilldetail.class, dtos);
		bhFixedvaluebilldetailDao.deleteAll(pos);
   }
	
	  	


	
}
