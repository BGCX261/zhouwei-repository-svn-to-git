package com.techstar.dmis.service;


import java.util.List;
import java.util.Collection;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.dto.DdSasusprecordDto;

//please add your business methods start
	// to do it
//add your business method end
	
/** 
 * 业务对象服务接口类
 * @author 
 * @date
 */
public interface IDdSasusprecordService {

    public void addDdSasusprecord(DdSasusprecordDto dto);

	/**
	 * 进行增加或修改操作业务处理
	 * 
	 * @param dto
	 *DdSasusprecordDto 业务传输对象
	 * 
	 */
	public void saveOrUpdateDdSasusprecord(DdSasusprecordDto dto);
	public void saveOrUpdateDdSasusprecord(List dtos);

	/**
	 * 进行加载的业务操作
	 * @param ddSasusprecordId
	 *            Integer 主键值ֵ
	 */
	public DdSasusprecordDto loadDdSasusprecord(String ddSasusprecordId);

	/**
	 * 删除指定的业务
	 * @param ddSasusprecordId
	 *            Integer 主键值ֵ
	 */
	public void deleteDdSasusprecord(String ddSasusprecordId);
	/**
	 * 删除指定的业务

	 * @param ddSasusprecordId
	 *            Integer 主键值ֵ

	 */
	public void deleteDdSasusprecordobj(String ddSasusprecordId,int version);
    
	/**
	 * 进行申请查询操作业务处理
	 */

	
	/**
	 * 进行申请查询操作业务处理(分页)
	 * 
	 * @return QueryListObj 封装了结果集及记录总数的对象
	 */
public QueryListObj listDdSasusprecord();
public QueryListObj listDdSasusprecordByHql(String hql);
public QueryListObj getDdSasusprecordByHql(String hql,int beginPage, int pageSize,String sql);


	//please add your business methods start
	// to do it
	//add your business method end

	
	

	//please add your business methods start
	// to do it
	//add your business method end
	
	
}
