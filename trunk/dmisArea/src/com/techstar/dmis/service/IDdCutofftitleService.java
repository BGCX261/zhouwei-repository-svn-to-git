package com.techstar.dmis.service;

import java.util.List;
import java.util.Collection;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.dto.DdCutofftitleDto;

//注册子表DAO
import com.techstar.dmis.dto.DdCutoffsequenceDto;
import com.techstar.dmis.helper.dto.WorkflowHandleDto;

//please add your business methods start
// to do it
//add your business method end

/**
 * 业务对象服务接口类
 * 
 * @author
 * @date
 */
public interface IDdCutofftitleService {

	public void addDdCutofftitle(DdCutofftitleDto dto);

	/**
	 * 进行增加或修改操作业务处理
	 * 
	 * 
	 * @param dto
	 *            DdCutofftitleDto 业务传输对象
	 * 
	 */
	public void saveOrUpdateDdCutofftitle(DdCutofftitleDto dto);

	public void saveOrUpdateDdCutofftitle(List dtos);

	/**
	 * 进行加载的业务操作
	 * 
	 * @param ddCutofftitleId
	 *            Integer 主键值ֵ
	 * 
	 */
	public DdCutofftitleDto loadDdCutofftitle(String ddCutofftitleId);

	/**
	 * 删除指定的业务
	 * 
	 * @param ddCutofftitleId
	 *            Integer 主键值ֵ
	 * 
	 */
	public void deleteDdCutofftitle(String ddCutofftitleId);

	/**
	 * 删除指定的业务集合
	 * 
	 */
	public void deleteDdCutofftitle(List dtos);

	/**
	 * 进行申请查询操作业务处理
	 */

	/**
	 * 进行申请查询操作业务处理(分页)
	 * 
	 * @return QueryListObj 封装了结果集及记录总数的对象
	 * 
	 */
	public QueryListObj listDdCutofftitle();

	public QueryListObj listDdCutofftitleByHql(String hql);

	public QueryListObj getDdCutofftitleByHql(String hql, int beginPage,
			int pageSize, String sql);

	// please add your business methods start
	// to do it
	// add your business method end

	// 子表处理DAO
	public QueryListObj listDdCutoffsequence();

	public void saveOrUpdateDdCutoffsequence(DdCutoffsequenceDto dto);

	public void deleteDdCutoffsequence(String fid);

	public DdCutoffsequenceDto loadDdCutoffsequence(String fid);

	public QueryListObj listDdCutoffsequenceByHql(String hql);

	public void saveOrUpdateDdCutoffsequence(List dtos);

	public void deleteDdCutoffsequence(List dtos);
	
	
	
	public void start(WorkflowHandleDto dto);
	//调度处长审批拉路序位表
	public void headerApprove(WorkflowHandleDto dto);
	//拉路序位表发布
	public void release(WorkflowHandleDto dto) ;
	//拉路序位表修改
	public void modify(WorkflowHandleDto dto) ;
	//负荷专工审核
	public void specApprove(WorkflowHandleDto dto);

	// please add your business methods start
	// to do it
	// add your business method end

}
