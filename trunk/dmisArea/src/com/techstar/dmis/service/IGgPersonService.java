package com.techstar.dmis.service;

import java.util.List;
import java.util.Collection;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.dto.GgPersonDto;



//please add your business methods start
	// to do it
//add your business method end
	
/** 
 * 业务对象服务接口类
 * @author 
 * @date
 */
public interface IGgPersonService {

    public void addGgPerson(GgPersonDto dto);

	/**
	 * 进行增加或修改操作业务处理
	 * 
	 * @param dto
	 *GgPersonDto 业务传输对象
	 * 
	 */
	public void saveOrUpdateGgPerson(GgPersonDto dto);
	public void saveOrUpdateGgPerson(List dtos);

	/**
	 * 进行加载的业务操作
	 * @param ggPersonId
	 *            Integer 主键值ֵ
	 */
	public GgPersonDto loadGgPerson(String ggPersonId);

	/**
	 * 删除指定的业务
	 * @param ggPersonId
	 *            Integer 主键值ֵ
	 */
	public void deleteGgPerson(String ggPersonId);
    /**
	* 删除指定的业务集合
	**/
	public void deleteGgPerson(List dtos);
	
	/**
	 * 进行申请查询操作业务处理
	 */

	
	/**
	 * 进行申请查询操作业务处理(分页)
	 * 
	 * @return QueryListObj 封装了结果集及记录总数的对象
	 */
	 public QueryListObj listGgPerson();
	 public QueryListObj listGgPersonByHql(String hql);
	 public QueryListObj getGgPersonByHql(String hql,int beginPage, int pageSize,String sql);
	 public QueryListObj getGgPersonByHql(String hql);

	//please add your business methods start
	// to do it
	//add your business method end

	
	

 

	//please add your business methods start
	// to do it
	//add your business method end
	
	
}
