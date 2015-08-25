package com.techstar.framework.ui.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.framework.ui.dto.SysUiGridDto;
import com.techstar.framework.ui.entity.GridInfoObj;
	
/** 
 * 业务对象服务接口类
 * @author 
 * @date
 */
public interface ISysUiGridService {
	/**
	 * 进行增加或修改操作业务处理
	 * 
	 * @param dto
	 *SysUiGridDto 业务传输对象
	 * 
	 */
	public void saveOrUpdateSysUiGrid(SysUiGridDto dto);

	/**
	 * 进行加载的业务操作
	 * 
	 * @param sysUiGridId
	 *            Integer 主键值ֵ
	 * 
	 */
	public SysUiGridDto loadSysUiGrid(String sysUiGridId);

	/**
	 * 删除指定的业务
	 * 
	 * @param sysUiGridId
	 *            Integer 主键值ֵ
	 * 
	 */
	public void deleteSysUiGrid(String sysUiGridId);
    
	/**
	 * 进行申请查询操作业务处理
	 */

	public QueryListObj listSysUiGrid();
	/**
	 * 进行申请查询操作业务处理(分页)
	 * @return QueryListObj 封装了结果集及记录总数的对象
	 */
	public QueryListObj getQueryListByHql(String hql);
	
	/**
	 * 查询用户个性化信息
	 * @param userId    用户标识ID
	 * @param busName   业务ID
	 * @param subName   业务子ID
	 * @return
	 */
	public QueryListObj getQueryListByHql(String hql, int beginPage, int pageSize);
	//please add your business methods start
	// to do it
	//add your business method end
	
	/**
	 * 
	 */
	public QueryListObj getListByParam(String userId,String busName,String subName);
	
	/**
	 * 
	 * @param userId
	 * @param busName
	 * @param subName
	 * @param customXml
	 */
	public void updateCustomData(String userId,String busName,String subName,String customXml);
	
	/**
	 * 
	 * @param userId
	 * @param busName
	 * @param subName
	 * @param queryName
	 */
	public void deleteAdvanceQueryData(String userId,String busName,String subName,String queryName,String type);
	
	/**
	 * 
	 * @param userId
	 * @param busName
	 * @param subName
	 * @param advanceQuery
	 */
	public void updateAdvanceQueryData(String userId,String busName,String subName,String advanceQuery);
	
	/**
	 * 
	 * @param userId
	 * @param busName
	 * @param subName
	 * @param advanceQuery
	 * @param name
	 * @param queryStr
	 * @param type
	 */
	public void saveAdvanceQueryData(String userId,String busName,String subName,String advanceQuery, String name, String queryStr,String type, String queryType);

	/**
	 * 
	 * @param userId
	 * @param busName
	 * @param subName
	 * @return
	 */
	public String getAdvanceQueryXml(String userId,String busName,String subName,String type);
	
	/**
	 * 
	 * @param userId
	 * @param busName
	 * @param subName
	 * @param queryName
	 */
	public void updateDefaultQuery(String userId,String busName,String subName,String queryName, String type);
	
	/**
	 * 
	 * @param gridParam
	 * @param paramMap
	 * @param hqlStr
	 * @param userId
	 * @return
	 */
	public GridInfoObj getGridInfoObj(Map gridParam ,Map paramMap, String hqlStr,String userId);
	
	/**
	 * 获取基本GRID查询操作信息的信息
	 */
	public GridInfoObj getGenGridInfoObj(Map paramMap,String hqlStr);
	/**
	 * 
	 * @param dtoName
	 * @param params
	 * @param dtoList
	 * @param beginPage
	 * @param pageSize
	 * @param isFilter
	 * @param isHanldCol
	 * @return
	 */
	public String parseParamToGridStr(Map params,List dtoList,int beginPage,int pageSize,int totalCount,List sumInfo);
	
	/**
	 * 取对象列表的合计信息
	 * @param sql
	 * @return
	 */
	public List getObjPropertySums(String sql);

}
