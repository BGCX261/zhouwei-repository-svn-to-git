package com.techstar.framework.ui.web.facade;

import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.framework.ui.entity.GridInfoObj;
import com.techstar.framework.ui.service.ISysUiGridService;
import com.techstar.framework.ui.utils.grid.NullHanlder;

/**
 * 
 * @author majian
 */
public class SysUiGridFacade
{
	private ISysUiGridService sysUiGridService;

	public void setSysUiGridService(ISysUiGridService sysUiGridService) {
		this.sysUiGridService = sysUiGridService;
	}
	
	/**
	 * 得到用户对应业务模块的个性化数据
	 * 
	 * @param userId     用户ID
	 * @param busName    业务名称
	 * @param subName    子业务名称
	 * @param customXml  用户个性化XML数据
	 */
	public QueryListObj getListByParam(String userId,String busName,String subName){
		return sysUiGridService.getListByParam(userId, busName, subName);
	}
	
	/**
	 *  得到高级查询Xml字串
	 * 
	 * @param userId
	 * @param busName
	 * @param subName
	 * @return
	 */
	public String getAdvanceQueryXml(String userId,String busName,String subName, String type){
		return sysUiGridService.getAdvanceQueryXml(userId, busName, subName, type);
	}
	
	/**
	 * 更新用户<显示设置>页面中个性化设置参数
	 * 
	 * @param userId     用户ID
	 * @param busName    业务名称
	 * @param subName    子业务名称
	 * @param customXml  用户个性化XML数据
	 */
	public void updateCustomData(String userId,String busName,String subName,String customXml){
		sysUiGridService.updateCustomData(userId,busName,subName,customXml);
	}
	
	/**
	 * 
	 * @param userId
	 * @param busName
	 * @param subName
	 * @param queryName
	 */
	public void updateDefaultQuery(String userId,String busName,String subName,String queryName, String type){
		sysUiGridService.updateDefaultQuery(userId, busName, subName, queryName, type);
	}
	
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
	public void saveAdvanceQueryData(String userId,String busName,String subName,String advanceQuery,String name, String queryStr,String type, String queryType){
		sysUiGridService.saveAdvanceQueryData(userId, busName, subName, advanceQuery, name, queryStr, type, queryType);
	}
	
	public void deleteAdvanceQueryData(String userId,String busName,String subName,String queryName,String type){
		sysUiGridService.deleteAdvanceQueryData(userId, busName, subName, queryName, type);
	}
	
	/**
	 * 更新用户<高级查询>页面中个性化设置参数
	 * 
	 * @param userId        用户ID
	 * @param busName       业务名称
	 * @param subName       子业务名称
	 * @param advanceQuery  高级查询XML数据
	 */
	public void updateAdvanceQueryData(String userId,String busName,String subName,String advanceQuery){
		sysUiGridService.updateAdvanceQueryData(userId, busName, subName, advanceQuery);
	}

	

	
	public GridInfoObj getGridInfo(HttpServletRequest request,String hqlStr,String userId){
		
		Map gridParam   = new LinkedHashMap();
		
		gridParam.put("domainName", NullHanlder.NullToString(request.getParameter("domainName")));
		gridParam.put("editType", NullHanlder.NullToString(request.getParameter("editType")));
		gridParam.put("colAlign", NullHanlder.NullToString(request.getParameter("colAlign")));
		gridParam.put("sortType", NullHanlder.NullToString(request.getParameter("sortType")));
		gridParam.put("textColor", NullHanlder.NullToString(request.getParameter("textColor")));
		gridParam.put("displayFormat", NullHanlder.NullToString(request.getParameter("displayFormat")));
		gridParam.put("listBox", NullHanlder.NullToString(request.getParameter("listBox")));
		gridParam.put("filterRules", NullHanlder.NullToString(request.getParameter("filterRules")));
		gridParam.put("isTotal", NullHanlder.NullToString(request.getParameter("isTotal")));
		gridParam.put("columnMove", NullHanlder.NullToString(request.getParameter("columnMove")));
		gridParam.put("wheres",NullHanlder.NullToString(request.getParameter("wheres")));
		gridParam.put("pageStr",NullHanlder.NullToString(request.getParameter("pageStr")));
		gridParam.put("busName",NullHanlder.NullToString(request.getParameter("busName")));
		gridParam.put("subName",NullHanlder.NullToString(request.getParameter("subName")));
		gridParam.put("isFilter",NullHanlder.NullToString(request.getParameter("isFilter")));
		gridParam.put("isOperater",NullHanlder.NullToString(request.getParameter("isOperater")));
		gridParam.put("keyFilter", NullHanlder.NullToString(request.getParameter("filterParams")));
		gridParam.put("keySortOnlyCol", NullHanlder.NullToString(request.getParameter("sortOnlyCol")));
		gridParam.put("gridSign", NullHanlder.NullToString(request.getParameter("gridSign")));
		gridParam.put("titleRownoImg", NullHanlder.NullToString(request.getParameter("titleRownoImg")));
		
		Map paramMap = new LinkedHashMap();
		
		paramMap.put("KEY_COLNAMES", NullHanlder.NullToString(request.getParameter("selectColNames")));
		paramMap.put("KEY_FILTER", NullHanlder.NullToString(request.getParameter("filterParams")));
		paramMap.put("KEY_SORTONLYCOL", NullHanlder.NullToString(request.getParameter("sortOnlyCol")));
//		paramMap.put(key_wheres, (sysUiGridFacade.returnQueryParamEnd(request.getParameter("wheres"), "user1", "busname1", "subname1") == null)? "":sysUiGridFacade.returnQueryParamEnd(request.getParameter("wheres"), "", "", ""));
//		paramMap.put(key_pageStr, (sysUiGridFacade.returnPageStr(request.getParameter("pageStr"),"user1","busname1","subname1") == null)?"":(sysUiGridFacade.returnPageStr(request.getParameter("pageStr"),"user1","busname1","subname1")));
		paramMap.put("KEY_DOMAINNAME", NullHanlder.NullToString(request.getParameter("domainName")));
		paramMap.put("KEY_OPARAMS", NullHanlder.NullToString(request.getParameter("otherparams")));
		paramMap.put("KEY_QUERYTYPE", NullHanlder.NullToString(request.getParameter("queryType")));
		paramMap.put("KEY_EXTWHERES", NullHanlder.NullToString(request.getParameter("extWheres")));
		paramMap.put("KEY_EXTORDER", NullHanlder.NullToString(request.getParameter("extOrder")));
		
		GridInfoObj gridInfo = new GridInfoObj();
		if(!StringUtils.isEmpty(request.getParameter("gridSign"))){
			gridInfo = this.sysUiGridService.getGridInfoObj(gridParam, paramMap, hqlStr, userId);
		}
		return gridInfo;
	}
	
	public GridInfoObj getGenGridInfo(HttpServletRequest request,String hqlStr){
		Map paramMap 	= new LinkedHashMap();
		paramMap.put("KEY_COLNAMES", NullHanlder.NullToString(request.getParameter("KEY_COLNAMES")));
		paramMap.put("KEY_FILTER", NullHanlder.NullToString(request.getParameter("KEY_FILTER")));
		paramMap.put("KEY_SORTONLYCOL", NullHanlder.NullToString(request.getParameter("KEY_SORTONLYCOL")));
		paramMap.put("KEY_WHERE", NullHanlder.NullToString(request.getParameter("KEY_WHERE")));
		paramMap.put("KEY_PAGE", NullHanlder.NullToString(request.getParameter("KEY_PAGE")));
		paramMap.put("KEY_DOMAINNAME", NullHanlder.NullToString(request.getParameter("KEY_DOMAINNAME")));
		paramMap.put("KEY_OPARAMS", NullHanlder.NullToString(request.getParameter("KEY_OPARAMS")));
		paramMap.put("KEY_QUERYTYPE", NullHanlder.NullToString(request.getParameter("KEY_QUERYTYPE")));
		paramMap.put("KEY_EXTWHERES", NullHanlder.NullToString(request.getParameter("KEY_EXTWHERES")));
		paramMap.put("KEY_EXTORDER", NullHanlder.NullToString(request.getParameter("KEY_EXTORDER")));
		return this.sysUiGridService.getGenGridInfoObj(paramMap, hqlStr);
	}
		
	public String parseParamToGridStr(HttpServletRequest request,Map params,List dtoList,int beginPage,int pageSize,int totalCount,List sumInfo)	throws Exception{
		String xmlInfo = "";
		if(!StringUtils.isEmpty(request.getParameter("gridSign"))){
			xmlInfo = this.sysUiGridService.parseParamToGridStr(params, dtoList, beginPage, pageSize, totalCount, sumInfo);
		}
		return xmlInfo;	
	}
	
	public static void main(String[] args){
		SysUiGridFacade t = new SysUiGridFacade();
		
	}
}
