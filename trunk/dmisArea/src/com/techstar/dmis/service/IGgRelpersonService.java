package com.techstar.dmis.service;

import java.util.List;
import java.util.Collection;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.dto.GgRelpersonDto;



//please add your business methods start
	// to do it
//add your business method end
	
/** 
 * 业务对象服务接口类
 * @author 
 * @date
 */
public interface IGgRelpersonService {

    public void addGgRelperson(GgRelpersonDto dto);

	/**
	 * 进行增加或修改操作业务处理
	 * 
	 * @param dto
	 *GgRelpersonDto 业务传输对象
	 * 
	 */
	public void saveOrUpdateGgRelperson(GgRelpersonDto dto);
	public void saveOrUpdateGgRelperson(List dtos);

	/**
	 * 进行加载的业务操作
	 * @param ggRelpersonId
	 *            Integer 主键值ֵ
	 */
	public GgRelpersonDto loadGgRelperson(String ggRelpersonId);

	/**
	 * 删除指定的业务
	 * @param ggRelpersonId
	 *            Integer 主键值ֵ
	 */
	public void deleteGgRelperson(String ggRelpersonId);
    /**
	* 删除指定的业务集合
	**/
	public void deleteGgRelperson(List dtos);
	
	/**
	 * 进行申请查询操作业务处理
	 */

	
	/**
	 * 进行申请查询操作业务处理(分页)
	 * 
	 * @return QueryListObj 封装了结果集及记录总数的对象
	 */
	 public QueryListObj listGgRelperson();
	 public QueryListObj listGgRelpersonByHql(String hql);
	 public QueryListObj getGgRelpersonByHql(String hql,int beginPage, int pageSize,String sql);

	//please add your business methods start
	// to do it
	//add your business method end

	
	

 

	//please add your business methods start
	// to do it
	//add your business method end
	
	
}
