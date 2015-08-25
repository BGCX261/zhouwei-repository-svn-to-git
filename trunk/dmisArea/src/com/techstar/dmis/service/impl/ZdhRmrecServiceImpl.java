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
import com.techstar.dmis.dto.ZdhRmrecDto;
import com.techstar.dmis.entity.ZdhRmrec;
import com.techstar.dmis.service.IZdhRmrecService;
import org.springframework.dao.DataAccessException;

//please add your business methods start
	// to do it
//add your business method end

/** 
 * 业务对象服务接口实现类
 * @author 
 * @date
 */
public class ZdhRmrecServiceImpl implements IZdhRmrecService {
   //注册DAO
   private IZdhRmrecDao zdhRmrecDao;
   private IBaseJdbcDao baseJdbcDao ;
   private IStdStationDao stdStationDao;
   
  	//注册管理DAO
    	 private IZdhAutoondutylogDao zdhAutoondutylogDao;
	 public void setZdhAutoondutylogDao
	    (IZdhAutoondutylogDao zdhAutoondutylogDao) {
		 this.zdhAutoondutylogDao = zdhAutoondutylogDao;
     }
		 private IZdhCharalterrecordDao zdhCharalterrecordDao;
	 public void setZdhCharalterrecordDao
	    (IZdhCharalterrecordDao zdhCharalterrecordDao) {
		 this.zdhCharalterrecordDao = zdhCharalterrecordDao;
     }
	  	

	public ZdhRmrecServiceImpl() {}
	
	public void addZdhRmrec(ZdhRmrecDto dto) {
	
    	if (StringUtils.isEmpty(dto.getRecordno())){
		      if( StringUtils.isEmpty(dto.getRecordno())){
		          dto.setRecordno(new SequenceCreator().getUID());
		       }
		}
    	//新增时候,主对象不用管子对象的保存
		ZdhRmrec zdhRmrec = (ZdhRmrec) BeanHelper.buildBean(ZdhRmrec.class, dto);
		zdhRmrecDao.saveOrUpdate(zdhRmrec);		
	}
	
    //用于实现基本增加或修改操作
	public void saveOrUpdateZdhRmrec(ZdhRmrecDto dto) {
		if (StringUtils.isEmpty(dto.getRecordno())){
		      if( StringUtils.isEmpty(dto.getRecordno())){
		          dto.setRecordno(new SequenceCreator().getUID());
		       }
		}
		ZdhRmrec zdhRmrec = (ZdhRmrec) BeanHelper.mapBean(ZdhRmrec.class, dto);
		zdhRmrecDao.saveOrUpdate(zdhRmrec);
	}
    //用于实现基本删除操作
	public void deleteZdhRmrec(String zdhRmrecId) {
		ZdhRmrec zdhRmrec = new ZdhRmrec();
		zdhRmrec.setRecordno(zdhRmrecId);
		zdhRmrecDao.delete(zdhRmrec);
	}
	
	public void deleteZdhRmrec(String zdhRmrecId,int version) {
		ZdhRmrec zdhRmrec = new ZdhRmrec();
		zdhRmrec.setRecordno(zdhRmrecId);
		zdhRmrec.setVersion(version);
		zdhRmrecDao.delete(zdhRmrec);
	}
   //用于实现基本DTOLOAD操作
	public ZdhRmrecDto loadZdhRmrec(String recordno) {
		ZdhRmrec zdhRmrec = (ZdhRmrec) zdhRmrecDao.findByPk(recordno);
		ZdhRmrecDto dto = (ZdhRmrecDto) BeanHelper.mapBean(ZdhRmrecDto.class, zdhRmrec);
		return dto;
	}
//用于实现列表操作
   public QueryListObj listZdhRmrec() {
		QueryListObj obj = zdhRmrecDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) this.mapBeans(ZdhRmrecDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj listZdhRmrecByHql(String hql) {
		QueryListObj obj = zdhRmrecDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhRmrec.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj getZdhRmrecByHql(String hql, int beginPage, int pageSize, String sql) {
		QueryListObj obj = zdhRmrecDao.getQueryListByHql(hql, beginPage, pageSize);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhRmrec.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		
		List sumList = zdhRmrecDao.getObjPropertySums(sql);
		//System.out.println("sumList.size():"+sumList.size());
		obj.setPropertySum(sumList);
		return obj;
	}
	
	/**
	 * 根椐ZdhRmrec对象外键系统图ID取数据集
	 * @param foreignId
	 * @return
	 */
	public ZdhRmrecDto getZdhRmrecByForeign(String foreignId){
		QueryListObj obj = zdhRmrecDao.getQueryList();
		if (obj.getElemList() != null) {
			List dataList = obj.getElemList();
			for(int i=0; i<dataList.size(); i++){
				ZdhRmrec zdhRmrec = (ZdhRmrec)dataList.get(i);
				if(zdhRmrec != null){
					if(zdhRmrec.getZzdhrmrec2() != null){
						if(foreignId.equalsIgnoreCase(zdhRmrec.getZzdhrmrec2().getRecordsno())){
							ZdhRmrecDto dto = (ZdhRmrecDto)BeanHelper.mapBean(ZdhRmrecDto.class, zdhRmrec);
							return dto;
						}
					}
				}
			}
		}
		return null;
	}
	
	
	

	
  /**
    * @business method list
	     */

	//please add your business methods start
	// to do it
	//add your business method end
	
	public IZdhRmrecDao getZdhRmrecDao() {
		return zdhRmrecDao;
	}

	public void setZdhRmrecDao(IZdhRmrecDao zdhRmrecDao) {
		this.zdhRmrecDao = zdhRmrecDao;
	}
	
	public void setBaseJdbcDao(IBaseJdbcDao baseJdbcDao) {
		this.baseJdbcDao = baseJdbcDao;
	}
	
	public void saveOrUpdateZdhRmrec(List dtos) {
		List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			ZdhRmrecDto zdhRmrecDto = (ZdhRmrecDto)dtos.get(i);
			ZdhRmrec zdhRmrec = (ZdhRmrec) BeanHelper.buildBean(ZdhRmrec.class, zdhRmrecDto);
		    pos.add(zdhRmrec);
		}
		
		zdhRmrecDao.saveOrUpdateAll(pos);	
	}
	
	public Collection mapBeans(Class className,Collection dataList){
		Collection results = new ArrayList();
		if ( dataList == null ) return null;
		for (Iterator iter = dataList.iterator(); iter.hasNext(); ) {
            Object oriObj = (Object) iter.next();
            results.add(BeanHelper.mapBean(className, oriObj));
        }
		return results;
	}


	public void setStdStationDao(IStdStationDao stdStationDao) {
		this.stdStationDao = stdStationDao;
	}
	
}
