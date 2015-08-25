package com.techstar.dmis.service;


import java.util.List;
import java.util.Collection;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.dto.DdClassondutylogDto;
import com.techstar.dmis.dto.DdOperationnotebookDto;

//please add your business methods start
	// to do it
//add your business method end
	
/** 
 * 业务对象服务接口类
 * @author 
 * @date
 */
public interface IDdClassondutylogService {

    public void addDdClassondutylog(DdClassondutylogDto dto);

	/**
	 * 进行增加或修改操作业务处理
	 * 
	 * @param dto
	 *DdClassondutylogDto 业务传输对象
	 * 
	 */
	public void saveOrUpdateDdClassondutylog(DdClassondutylogDto dto);
	public void saveOrUpdateDdClassondutylog(List dtos);

	/**
	 * 进行加载的业务操作
	 * @param ddClassondutylogId
	 *            Integer 主键值ֵ
	 */
	public DdClassondutylogDto loadDdClassondutylog(String ddClassondutylogId);

	/**
	 * 删除指定的业务
	 * @param ddClassondutylogId
	 *            Integer 主键值ֵ
	 */
	public void deleteDdClassondutylog(String ddClassondutylogId);
	/**
	 * 删除指定的业务

	 * @param ddClassondutylogId
	 *            Integer 主键值
	 *  @param version Integer  主键值         ֵ

	 */
	public void deleteDdClassondutylog(String ddClassondutylogId,int version);
	/**
	 * 进行申请查询操作业务处理
	 */

	
	/**
	 * 进行申请查询操作业务处理(分页)
	 * 
	 * @return QueryListObj 封装了结果集及记录总数的对象
	 */
public QueryListObj listDdClassondutylog();
public QueryListObj listDdClassondutylogByHql(String hql);
public QueryListObj getDdClassondutylogByHql(String hql,int beginPage, int pageSize,String sql);


/**运行纪事处理**/

public QueryListObj listDdOperationnotebook();
public void saveOrUpdateDdSeqbilldetail(DdOperationnotebookDto dto);
public void deleteDdOperationnotebook(String fid,int version);
public void deleteDdOperationnotebook(DdOperationnotebookDto dto);
public DdOperationnotebookDto loadDdOperationnotebook(String fid);
public QueryListObj listDdOperationnotebookByHql(String hql);
public void saveOrUpdateDdOperationnotebook(List dtos);
public void deleteDdOperationnotebook(List dtos);

public QueryListObj getDdOperationnotebookByHql(String hql, int beginPage, int pageSize, String sql);





/**
 * 取最新的班志
 * @return DdClassondutylogDto
 */
public DdClassondutylogDto getLogNo();

	//please add your business methods start
	// to do it
	//add your business method end

	
	

	//please add your business methods start
	// to do it
	//add your business method end
	
	
}
