package com.techstar.dmis.service;


import java.util.List;
import java.util.Collection;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.dto.DdCutoffsequenceDto;

//please add your business methods start
	// to do it
//add your business method end

/**
 * 业务对象服务接口类
 * @author
 * @date
 */
public interface IDdCutoffsequenceService {

    public void addDdCutoffsequence(DdCutoffsequenceDto dto);

	/**
	 * 进行增加或修改操作业务处理
	 *
	 * @param dto
	 *DdCutoffsequenceDto 业务传输对象
	 *
	 */
	public void saveOrUpdateDdCutoffsequence(DdCutoffsequenceDto dto);
	public void saveOrUpdateDdCutoffsequence(List dtos);

	/**
	 * 进行加载的业务操作
	 * @param ddCutoffsequenceId
	 *            Integer 主键值ֵ
	 */
	public DdCutoffsequenceDto loadDdCutoffsequence(String ddCutoffsequenceId);

	/**
	 * 删除指定的业务
	 * @param ddCutoffsequenceId
	 *            Integer 主键值ֵ
	 */
	public void deleteDdCutoffsequence(String ddCutoffsequenceId,String  version);
	
	
	public void deleteCutoffsequenceList(List list);
	
	

	/**
	 * 进行申请查询操作业务处理
	 */


	/**
	 * 进行申请查询操作业务处理(分页)
	 *
	 * @return QueryListObj 封装了结果集及记录总数的对象
	 */
public QueryListObj listDdCutoffsequence();
public QueryListObj listDdCutoffsequenceByHql(String hql);
public QueryListObj getDdCutoffsequenceByHql(String hql,int beginPage, int pageSize,String sql);


	//please add your business methods start
	// to do it
	//add your business method end




	//please add your business methods start
	// to do it
	//add your business method end


}
