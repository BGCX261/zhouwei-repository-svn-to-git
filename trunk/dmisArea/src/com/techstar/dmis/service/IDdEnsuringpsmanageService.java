package com.techstar.dmis.service;


import java.util.List;

import org.springframework.dao.DataAccessException;

import com.techstar.dmis.dto.DdEnsuringpsmanageDto;
import com.techstar.dmis.dto.HandleHistoryDto;
import com.techstar.dmis.helper.dto.WorkflowHandleDto;
import com.techstar.framework.dao.model.QueryListObj;

//please add your business methods start
	// to do it
//add your business method end
	
/** 
 * 业务对象服务接口类
 * @author 
 * @date
 */
public interface IDdEnsuringpsmanageService {

    public void addDdEnsuringpsmanage(DdEnsuringpsmanageDto dto);

    
    
	/**
	 * 进行增加或修改操作业务处理
	 * 
	 * @param dto
	 *DdEnsuringpsmanageDto 业务传输对象
	 * 
	 */
	public void saveOrUpdateDdEnsuringpsmanage(DdEnsuringpsmanageDto dto);
	
	public void saveOrUpdateDdEnsuringpsmanage(List dtos);
	
	

	/**
	 * 进行加载的业务操作
	 * @param ddEnsuringpsmanageId
	 *            Integer 主键值ֵ
	 */
	public DdEnsuringpsmanageDto loadDdEnsuringpsmanage(String ddEnsuringpsmanageId);

	/**
	 * 删除指定的业务
	 * @param ddEnsuringpsmanageId
	 *            Integer 主键值ֵ
	 */
	public void deleteDdEnsuringpsmanage(String ddEnsuringpsmanageId,int version);
    
	/**
	 * 进行申请查询操作业务处理
	 */

	
	/**
	 * 进行申请查询操作业务处理(分页)
	 * 
	 * @return QueryListObj 封装了结果集及记录总数的对象
	 */
	public QueryListObj listDdEnsuringpsmanage();
	public QueryListObj listDdEnsuringpsmanageByHql(String hql);
	public QueryListObj getDdEnsuringpsmanageByHql(String hql,int beginPage, int pageSize,String sql);

	
	public void start(WorkflowHandleDto dto)throws DataAccessException ;

	/**
	* 会签
	* roleId 角色ID
	* handleFlag 是否通过 1:通过 -1:不通过
	*/
	public void countersign(WorkflowHandleDto dto) throws DataAccessException ;

	/**
	 * 重新填写
	 * @param taskInstanceId
	 * @param taskId
	 * @param preUserId
	 * @param curUserIds
	 * @throws DataAccessException
	 */
	public void modify(WorkflowHandleDto dto) throws DataAccessException ;
	
	/**
	* 审批完毕
	* @param taskInstanceId
	* @throws DataAccessException
	*/
	public void approve(WorkflowHandleDto dto) throws DataAccessException ;

	/**
	* 下发完毕
	* @param taskInstanceId
	* @throws DataAccessException
	*/
	public void sent(WorkflowHandleDto dto) throws DataAccessException ;

	/**
	* 审批撤回
	* @param taskInstanceId
	* @throws DataAccessException
	*/
	public void appReback(WorkflowHandleDto dto) throws DataAccessException ;

	/**
	* 执行完毕
	* @param taskInstanceId
	* @throws DataAccessException
	*/
	public void execute(WorkflowHandleDto dto) throws DataAccessException ;

	/**
	* 归档完毕
	* @param taskInstanceId
	* @throws DataAccessException
	*/
	public void keepon(WorkflowHandleDto dto) throws DataAccessException ;	
	
	//please add your business methods start
	// to do it
	//add your business method end

	
	
}
