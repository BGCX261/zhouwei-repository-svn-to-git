/**
 * 
 */
package com.techstar.framework.service.commonquery.impl;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.techstar.framework.dao.IBaseJdbcDao;
import com.techstar.framework.dao.ICommonQueryDao;
import com.techstar.framework.dao.model.CommonQueryObj;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.framework.service.commonquery.ICommonQueryService;
import com.techstar.framework.utils.BeanHelper;
import com.techstar.framework.utils.ExcelHelper;
import com.techstar.framework.utils.GridXMLHelper;
import com.techstar.framework.utils.ReflectObjectHelper;

/**
 * @author xcf Nov 30, 2006 10:47:37 PM
 * @author sbt 2006-12-26  
 * @author caojian 2006-12-18
 * 
 */
public class CommonQueryServiceImpl implements ICommonQueryService {
	private ICommonQueryDao commonQueryDao;

	private IBaseJdbcDao baseJdbcDao;

	public List getLogicElemList(CommonQueryObj queryobj) {
		QueryListObj listobj = commonQueryDao.getLogicElemList(queryobj);
        //获取记录信息
		List list = listobj.getElemList();
		if (list == null){
			return null;
		}
		for (int i = 0; i < list.size(); i++) {
			Map pomap = (Map)list.get(i);			
			list.set(i, pomap);			
		}		
		//获取记录条数
		Map countmap = new LinkedHashMap();
		countmap.put("total", Integer.valueOf("" + listobj.getCount()));
		list.add(countmap);
		return list;
	}

	public List getLogicElemDtoList(CommonQueryObj queryobj) {
		QueryListObj listobj = commonQueryDao.getLogicElemList(queryobj);
		String dtoName = ReflectObjectHelper.transferName(queryobj.getEntityName(), true);
		List list = listobj.getElemList();
		for (int i = 0; i < list.size(); i++) {
			Object poobj = list.get(i);
			Object dto = BeanHelper.buildBean(ReflectObjectHelper.getDtoClassByFullname(dtoName), poobj);
			list.set(i, dto);
		}
		return list;
	}
	/**
	 * 删除指定条件的记录
	 * @author sbt 2006-12-25 
	 */	
	public boolean delData(CommonQueryObj queryobj){		
		try{
			commonQueryDao.delData(queryobj);
		}catch(Exception e){			
			System.out.println("删除数据时出错:");
			e.printStackTrace();
            return false;
		}
		return true;
	}
    /**
     * 通用查询、删除的入口
     * @author sbt 2006-12-25 
     */
	public String query(Map constr,int GLQueryType) {
		String xmlStr = "";
		String otherParams = "";
		String delParams = "";
		boolean delsucceed;
		GridXMLHelper xmlhelper = new GridXMLHelper();
		try {
			//分析请求参数、进行查询或删除
			CommonQueryObj queryobj = xmlhelper.parseQueryCondition(constr,GLQueryType);
			if (queryobj == null) {
				return null;
			}
			//获取删除参数,以此判断是否进行删除操作
			delParams = queryobj.getDelParams();
			if (delParams != null){
			   //先进行删除
			   delsucceed = this.delData(queryobj);		
				if (delsucceed == false){
					System.out.println("删除失败!");
				}
			} 
			//进行查询
			otherParams = queryobj.getOParams();
			List list = this.getLogicElemList(queryobj);
            if (list == null){
            	return null;
            }
			//将查询结果解析成列表要求的xml格式的数据
			xmlStr = xmlhelper.buildupXMLData(list, otherParams);
			
		} catch (Exception e) {
			System.out.println("CommonQueryServiceImpl中的query方法发生异常:");
			e.printStackTrace();
		}
		return xmlStr;
	}
	/**
	 * 查询导出到excel的数据
	 * @param constr
	 */
	public String queryExcel(Map constr,int GLQueryType) {
		String excelStr = "";
		String otherParams = "";
		GridXMLHelper xmlhelper = new GridXMLHelper();
		ExcelHelper getExcelStr  = new ExcelHelper();   
		try {
			//分析请求参数
			CommonQueryObj queryobj = xmlhelper.parseQueryCondition(constr,GLQueryType);
			if (queryobj == null) {
				return "";
			}	
			
			otherParams = queryobj.getOParams();
			List list = this.getLogicElemList(queryobj);
            if (list == null){
            	return "";
            }
            //将查询出的数据整理成Excel数据源(字符串)，返回客户端                     
            excelStr = getExcelStr.genExcelStr(list,otherParams);
				
		} catch (Exception e) {
			System.out.println("CommonQueryServiceImpl中的queryExcel方法发生异常:");
			e.printStackTrace();
		}
		return excelStr;
	}
	

	public List getListBySql(String sql){
		return baseJdbcDao.queryForListBySql(sql);
	}
	/**
	 * 根据业务层传递的hql进行查询
	 * @param hql
	 * @return
	 */
	public List getQueryDataByHQL(String hql){
		return commonQueryDao.getQueryDataByHQL(hql);
	}
	public void setCommonQueryDao(ICommonQueryDao commonQueryDao) {
		this.commonQueryDao = commonQueryDao;
	}

	public void setBaseJdbcDao(IBaseJdbcDao baseJdbcDao) {
		this.baseJdbcDao = baseJdbcDao;
	}
}
