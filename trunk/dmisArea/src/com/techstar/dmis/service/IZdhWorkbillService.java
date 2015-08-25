package com.techstar.dmis.service;


import java.util.List;
import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.dto.ZdhWorkbillDto;
import com.techstar.dmis.helper.dto.WorkflowHandleDto;

//please add your business methods start
	// to do it
//add your business method end
	
/** 
 * 业务对象服务接口类
 * @author 
 * @date
 */
public interface IZdhWorkbillService {

    public void addZdhWorkbill(ZdhWorkbillDto dto);

	/**
	 * 进行增加或修改操作业务处理
	 * 
	 * @param dto
	 *ZdhWorkbillDto 业务传输对象
	 * 
	 */
	public void saveOrUpdateZdhWorkbill(ZdhWorkbillDto dto);
	public void saveOrUpdateZdhWorkbill(List dtos);

	/**
	 * 进行加载的业务操作
	 * @param zdhWorkbillId
	 *            Integer 主键值ֵ
	 */
	public ZdhWorkbillDto loadZdhWorkbill(String zdhWorkbillId);

	/**
	 * 删除指定的业务
	 * @param zdhWorkbillId
	 *            Integer 主键值ֵ
	 */
	public void deleteZdhWorkbill(String zdhWorkbillId);
    
	/**
	 * 进行申请查询操作业务处理
	 */

	
	/**
	 * 进行申请查询操作业务处理(分页)
	 * 
	 * @return QueryListObj 封装了结果集及记录总数的对象
	 */
public QueryListObj listZdhWorkbill();
public QueryListObj listZdhWorkbillByHql(String hql);
public QueryListObj getZdhWorkbillByHql(String hql,int beginPage, int pageSize,String sql);


//启动
public void start(WorkflowHandleDto dto) throws DataAccessException;
//运维中心主任签发
public void zdhworkbillCenterApprove(WorkflowHandleDto dto) throws DataAccessException ;
//许可人签字

public void zdhworkbillPermit(WorkflowHandleDto dto) throws DataAccessException ;
//工作人签字

public void zdhworkbillWorkerSign(WorkflowHandleDto dto) throws DataAccessException ;
//工作票修改

public void zdhworkbillModify(WorkflowHandleDto dto) throws DataAccessException ;
/**
* 删除指定的业务集合

**/
public void deleteZdhWorkbill(List dtos);
public String getOndutyno();
	//please add your business methods start
	// to do it
	//add your business method end

	
	

	//please add your business methods start
	// to do it
	//add your business method end
	
	
}
