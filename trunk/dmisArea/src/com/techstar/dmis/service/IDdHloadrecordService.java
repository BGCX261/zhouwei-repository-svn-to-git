package com.techstar.dmis.service;


import java.util.List;
import java.util.Collection;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.dto.DdHloadrecordDto;

//please add your business methods start
	// to do it
//add your business method end
	
/** 
 * 业务对象服务接口类
 * @author 
 * @date
 */
public interface IDdHloadrecordService {

    public void addDdHloadrecord(DdHloadrecordDto dto);

	/**
	 * 进行增加或修改操作业务处理
	 * 
	 * @param dto
	 *DdHloadrecordDto 业务传输对象
	 * 
	 */
	public void saveOrUpdateDdHloadrecord(DdHloadrecordDto dto);
	public void saveOrUpdateDdHloadrecord(List dtos);

	/**
	 * 进行加载的业务操作
	 * @param ddHloadrecordId
	 *            Integer 主键值ֵ
	 */
	public DdHloadrecordDto loadDdHloadrecord(String ddHloadrecordId);

	/**
	 * 删除指定的业务
	 * @param ddHloadrecordId
	 *            string 主键值ֵ
	 */
	public void deleteDdHloadrecord(String ddHloadrecordId);
	/**
	 * 删除指定的业务

	 * @param ddHloadrecordId string 主键值
	 * @param version integer 数据库版本号  主键值ֵ

	 */
	public void deleteDdHloadrecordobj(String ddHloadrecordId,int version);
    
	/**
	 * 进行申请查询操作业务处理
	 */

	
	/**
	 * 进行申请查询操作业务处理(分页)
	 * 
	 * @return QueryListObj 封装了结果集及记录总数的对象
	 */
public QueryListObj listDdHloadrecord();
public QueryListObj listDdHloadrecordByHql(String hql);
public QueryListObj getDdHloadrecordByHql(String hql,int beginPage, int pageSize,String sql);


	//please add your business methods start
	// to do it
	//add your business method end

	
	

	//please add your business methods start
	// to do it
	//add your business method end
	
	
}
