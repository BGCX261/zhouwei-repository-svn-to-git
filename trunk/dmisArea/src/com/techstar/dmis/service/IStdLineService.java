package com.techstar.dmis.service;

import java.util.List;
import java.util.Collection;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.dto.StdLineDto;



//please add your business methods start
	// to do it
//add your business method end
	
/** 
 * 业务对象服务接口类
 * @author 
 * @date
 */
public interface IStdLineService {

    public void addStdLine(StdLineDto dto);

	/**
	 * 进行增加或修改操作业务处理
	 * 
	 * @param dto
	 *StdLineDto 业务传输对象
	 * 
	 */
	public void saveOrUpdateStdLine(StdLineDto dto);
	public void saveOrUpdateStdLine(List dtos);

	/**
	 * 进行加载的业务操作
	 * @param stdLineId
	 *            Integer 主键值ֵ
	 */
	public StdLineDto loadStdLine(String stdLineId);

	/**
	 * 删除指定的业务
	 * @param stdLineId
	 *            Integer 主键值ֵ
	 */
	public void deleteStdLine(String stdLineId);
    /**
	* 删除指定的业务集合
	**/
	public void deleteStdLine(List dtos);
	
	/**
	 * 进行申请查询操作业务处理
	 */

	
	/**
	 * 进行申请查询操作业务处理(分页)
	 * 
	 * @return QueryListObj 封装了结果集及记录总数的对象
	 */
	 public QueryListObj listStdLine();
	 public QueryListObj listStdLineByHql(String hql);
	 public QueryListObj getStdLineByHql(String hql,int beginPage, int pageSize,String sql);

	//please add your business methods start
	// to do it
	//add your business method end

	
	

 

	//please add your business methods start
	// to do it
	//add your business method end
	
	
}
