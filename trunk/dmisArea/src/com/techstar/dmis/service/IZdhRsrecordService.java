package com.techstar.dmis.service;


import java.util.List;
import java.util.Collection;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.dto.ZdhRsrecordDto;

//please add your business methods start
	// to do it
//add your business method end
	
/** 
 * 业务对象服务接口类
 * @author 
 * @date
 */
public interface IZdhRsrecordService {

    public void addZdhRsrecord(ZdhRsrecordDto dto);

	/**
	 * 进行增加或修改操作业务处理
	 * 
	 * @param dto
	 *ZdhRsrecordDto 业务传输对象
	 * 
	 */
	public void saveOrUpdateZdhRsrecord(ZdhRsrecordDto dto);
	public void saveOrUpdateZdhRsrecord(List dtos);

	/**
	 * 进行加载的业务操作
	 * @param zdhRsrecordId
	 *            Integer 主键值ֵ
	 */
	public ZdhRsrecordDto loadZdhRsrecord(String zdhRsrecordId);

	/**
	 * 删除指定的业务
	 * @param zdhRsrecordId
	 *            Integer 主键值ֵ
	 */
	public void deleteZdhRsrecord(String zdhRsrecordId);
    
	/**
	 * 进行申请查询操作业务处理
	 */

	
	/**
	 * 进行申请查询操作业务处理(分页)
	 * 
	 * @return QueryListObj 封装了结果集及记录总数的对象
	 */
public QueryListObj listZdhRsrecord();
public QueryListObj listZdhRsrecordByHql(String hql);
public QueryListObj getZdhRsrecordByHql(String hql,int beginPage, int pageSize,String sql);


	//please add your business methods start
	// to do it
	//add your business method end
public QueryListObj getCurrAccidentbrieByHql(String hql, int beginPage, int pageSize, String sql);
public void deleteZdhRsrecordObj(String zdhRsrecordId,int version);
	
	

	//please add your business methods start
	// to do it
	//add your business method end
	
	
}
