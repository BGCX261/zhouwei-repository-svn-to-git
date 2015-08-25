package com.techstar.dmis.service.impl;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import org.apache.commons.lang.StringUtils;
import com.techstar.framework.dao.IBaseJdbcDao;

import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.framework.utils.BeanHelper;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.dmis.dao.*;
import com.techstar.dmis.dto.ZdhSequencetableDto;
import com.techstar.dmis.entity.ZdhSequencetable;
import com.techstar.dmis.service.IZdhSequencetableService;
import org.springframework.dao.DataAccessException;
import com.techstar.dmis.util.SqlXmlUtil;


//please add your business methods start
	// to do it
//add your business method end

/** 
 * 业务对象服务接口实现类
 * @author 
 * @date
 */
public class ZdhSequencetableServiceImpl implements IZdhSequencetableService {
   //注册DAO
   private IZdhSequencetableDao zdhSequencetableDao;
   private IBaseJdbcDao baseJdbcDao ;
   
  	

	public ZdhSequencetableServiceImpl() {}
	
	public void addZdhSequencetable(ZdhSequencetableDto dto) {
	
    	if (StringUtils.isEmpty(dto.getFsequenceno())){
		      if( StringUtils.isEmpty(dto.getFsequenceno())){
		          dto.setFsequenceno(new SequenceCreator().getUID());
		       }
		}
    	//新增时候,主对象不用管子对象的保存
		ZdhSequencetable zdhSequencetable = (ZdhSequencetable) BeanHelper.buildBean(ZdhSequencetable.class, dto);
		zdhSequencetableDao.saveOrUpdate(zdhSequencetable);		
	}
	
    //用于实现基本增加或修改操作
	public void saveOrUpdateZdhSequencetable(ZdhSequencetableDto dto) {
		if (StringUtils.isEmpty(dto.getFsequenceno())){
		      if( StringUtils.isEmpty(dto.getFsequenceno())){
		          dto.setFsequenceno(new SequenceCreator().getUID());
		       }
		}
		ZdhSequencetable zdhSequencetable = (ZdhSequencetable) BeanHelper.buildBean(ZdhSequencetable.class, dto);
		zdhSequencetableDao.saveOrUpdate(zdhSequencetable);
	}
    //用于实现基本删除操作
	public void deleteZdhSequencetable(String zdhSequencetableId) {
		ZdhSequencetable zdhSequencetable = new ZdhSequencetable();
		zdhSequencetable.setFsequenceno(zdhSequencetableId);
		zdhSequencetableDao.delete(zdhSequencetable);
	}
	//用于实现基本删除集合操作
	public void deleteZdhSequencetable(List dtos){
		List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(ZdhSequencetable.class, dtos);
		zdhSequencetableDao.deleteAll(pos);
	}	
   //用于实现基本DTOLOAD操作
	public ZdhSequencetableDto loadZdhSequencetable(String fsequenceno) {
		ZdhSequencetable zdhSequencetable = (ZdhSequencetable) zdhSequencetableDao.findByPk(fsequenceno);
		ZdhSequencetableDto dto = (ZdhSequencetableDto) BeanHelper.buildBean(ZdhSequencetableDto.class, zdhSequencetable);
		return dto;
	}
   //用于实现列表操作
   public QueryListObj listZdhSequencetable() {
		QueryListObj obj = zdhSequencetableDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhSequencetableDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj listZdhSequencetableByHql(String hql) {
		QueryListObj obj = zdhSequencetableDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhSequencetableDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj getZdhSequencetableByHql(String hql, int beginPage, int pageSize, String sql) {
		QueryListObj obj = zdhSequencetableDao.getQueryListByHql(hql, beginPage, pageSize);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhSequencetableDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		
		List sumList = zdhSequencetableDao.getObjPropertySums(sql);
		//System.out.println("sumList.size():"+sumList.size());
		obj.setPropertySum(sumList);
		return obj;
	}

	
  /**
    * @business method list
	 	* @excel导入
	     */

	//please add your business methods start
	// to do it
	//add your business method end
	
	public IZdhSequencetableDao getZdhSequencetableDao() {
		return zdhSequencetableDao;
	}

	public void setZdhSequencetableDao(IZdhSequencetableDao zdhSequencetableDao) {
		this.zdhSequencetableDao = zdhSequencetableDao;
	}
	
	public void setBaseJdbcDao(IBaseJdbcDao baseJdbcDao) {
		this.baseJdbcDao = baseJdbcDao;
	}
	
	public void saveOrUpdateZdhSequencetable(List dtos) {
		List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			ZdhSequencetableDto zdhSequencetableDto = (ZdhSequencetableDto)dtos.get(i);
			if (StringUtils.isEmpty(zdhSequencetableDto.getFsequenceno())){
			      if( StringUtils.isEmpty(zdhSequencetableDto.getFsequenceno())){
			    	  zdhSequencetableDto.setFsequenceno(new SequenceCreator().getUID());
			       }
			}
			ZdhSequencetable zdhSequencetable = (ZdhSequencetable) BeanHelper.buildBean(ZdhSequencetable.class, zdhSequencetableDto);
		    pos.add(zdhSequencetable);
		}
		
		zdhSequencetableDao.saveOrUpdateAll(pos);	
	}

	/*
	 * 删除重复记录
	 */
	public void RepDelete( String strXmlPath)  {
		String 	strHql="";
		SqlXmlUtil sqlXmlUtil;
		try {
			sqlXmlUtil = new SqlXmlUtil(strXmlPath);
			strHql=" delete from "+sqlXmlUtil.getTableName();
			strHql+=" where "+sqlXmlUtil.getPrimaryName()+" not in ( select min("+sqlXmlUtil.getPrimaryName()
				  +") from  "+sqlXmlUtil.getTableName();
			strHql+=" group by  ";
			String[] strPropertyName=sqlXmlUtil.getPropertyName();
			String strPropertyValue="";
			for(int i=0;i<strPropertyName.length;i++)
			{
				strPropertyValue+=strPropertyName[i]+",";
			}
			if(!StringUtils.isEmpty(strPropertyValue))
			{
				strPropertyValue=strPropertyValue.substring(0,strPropertyValue.lastIndexOf(","));
			}
			strHql+=strPropertyValue+")";
			this.baseJdbcDao.executeSql(strHql);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		

	}
		

	 	


	
}
