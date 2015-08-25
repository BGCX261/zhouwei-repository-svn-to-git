package com.techstar.dmis.service;

import java.util.List;
import java.util.Collection;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.dto.DdAccidentbriefDto;

//注册子表DAO
import com.techstar.dmis.dto.BhActionrecordDto;
import com.techstar.dmis.dto.DdAccidentbriefprocessDto;
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
public interface IDdAccidentbriefService {

	public void addDdAccidentbrief(DdAccidentbriefDto dto);

	/**
	 * 进行增加或修改操作业务处理
	 * 
	 * 
	 * @param dto
	 *            DdAccidentbriefDto 业务传输对象
	 * 
	 */
	public void saveOrUpdateDdAccidentbrief(DdAccidentbriefDto dto);

	public void saveOrUpdateDdAccidentbrief(List dtos);

	/**
	 * 进行加载的业务操作
	 * 
	 * @param ddAccidentbriefId
	 *            Integer 主键值ֵ
	 * 
	 */
	public DdAccidentbriefDto loadDdAccidentbrief(String ddAccidentbriefId);

	/**
	 * 删除指定的业务
	 * 
	 * @param ddAccidentbriefId
	 *            Integer 主键值ֵ
	 * 
	 */
	public void deleteDdAccidentbrief(String ddAccidentbriefId, String version);

	/**
	 * 删除指定的业务集合
	 * 
	 */
	public void deleteDdAccidentbrief(List dtos);

	/**
	 * 进行申请查询操作业务处理
	 */

	/**
	 * 进行申请查询操作业务处理(分页)
	 * 
	 * @return QueryListObj 封装了结果集及记录总数的对象
	 * 
	 */
	 public QueryListObj getAccidentList();
	public QueryListObj listDdAccidentbrief();

	public QueryListObj listDdAccidentbriefByHql(String hql);

	public QueryListObj getDdAccidentbriefByHql(String hql, int beginPage,
			int pageSize, String sql);

	// please add your business methods start
	// to do it
	// add your business method end

	// 子表处理DAO
	public QueryListObj listBhActionrecord();

	public void saveOrUpdateBhActionrecord(BhActionrecordDto dto);

	public void deleteBhActionrecord(String protectionrecordid);

	public BhActionrecordDto loadBhActionrecord(String protectionrecordid);

	public QueryListObj listBhActionrecordByHql(String hql);

	public void saveOrUpdateBhActionrecord(List dtos);

	public void deleteBhActionrecord(List dtos);

	public QueryListObj listDdAccidentbriefprocess();

	public void saveOrUpdateDdAccidentbriefprocess(DdAccidentbriefprocessDto dto);

	public void deleteDdAccidentbriefprocess(String fstepid);

	public DdAccidentbriefprocessDto loadDdAccidentbriefprocess(String fstepid);

	public QueryListObj listDdAccidentbriefprocessByHql(String hql);

	public void saveOrUpdateDdAccidentbriefprocess(List dtos);

	public void deleteDdAccidentbriefprocess(List dtos);

	public void start(WorkflowHandleDto dto);
	
	public void approve(WorkflowHandleDto dto);
	
	public void modify(WorkflowHandleDto dto);
	
	public void execute(WorkflowHandleDto dto);
	
	
	
	


	// please add your business methods start
	// to do it
	// add your business method end

}
