package com.techstar.dmis.service;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Collection;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.dto.ZdhSequencetableDto;



//please add your business methods start
	// to do it
//add your business method end
	
/** 
 * 业务对象服务接口类
 * @author 
 * @date
 */
public interface IZdhSequencetableService {

    public void addZdhSequencetable(ZdhSequencetableDto dto);

	/**
	 * 进行增加或修改操作业务处理
	 * 
	 * @param dto
	 *ZdhSequencetableDto 业务传输对象
	 * 
	 */
	public void saveOrUpdateZdhSequencetable(ZdhSequencetableDto dto);
	public void saveOrUpdateZdhSequencetable(List dtos);

	/**
	 * 进行加载的业务操作
	 * @param zdhSequencetableId
	 *            Integer 主键值ֵ
	 */
	public ZdhSequencetableDto loadZdhSequencetable(String zdhSequencetableId);

	/**
	 * 删除指定的业务
	 * @param zdhSequencetableId
	 *            Integer 主键值ֵ
	 */
	public void deleteZdhSequencetable(String zdhSequencetableId);
    /**
	* 删除指定的业务集合
	**/
	public void deleteZdhSequencetable(List dtos);
	
	/**
	 * 进行申请查询操作业务处理
	 */

	
	/**
	 * 进行申请查询操作业务处理(分页)
	 * 
	 * @return QueryListObj 封装了结果集及记录总数的对象
	 */
	 public QueryListObj listZdhSequencetable();
	 public QueryListObj listZdhSequencetableByHql(String hql);
	 public QueryListObj getZdhSequencetableByHql(String hql,int beginPage, int pageSize,String sql);

	//please add your business methods start
	// to do it
	//add your business method end

	/*
	 * 删除重复记录
	 */
	 public void RepDelete( String strXmlPath)  ;
	

 

	//please add your business methods start
	// to do it
	//add your business method end
	
	
}
