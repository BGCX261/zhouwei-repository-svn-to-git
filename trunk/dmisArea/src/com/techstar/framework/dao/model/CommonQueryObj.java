/**
 * 
 */
package com.techstar.framework.dao.model;

import java.util.List;

/**
 * @author xcf  Nov 30, 2006 12:00:06 PM
 * @author sbt 2006-12-11
 */
public class CommonQueryObj {
	private String entityName;//对象名
	private String alias;   //对象别名
	private int pageNum;   //开始页
	private int pageSize;  //每页显示行数
//	private String orderType; //排序方式,如ASC , DESC
	private String[] orderAttr;//排序列，带有排序方式 如orderAttr[]{"domain.name ASC","domain.sex DESC"}
	private List detailPairs; //封装了查询条件的对象
	private List detailPairsDel; //封装了删除条件的对象
	private String delParams; //客户端请求的删除参数
	private String oParams;//列表的综合属性    private String selectcolnames;//select后的列名
    private String selectcolTypes;//select后的列类型    private String extHQL;//外部的hql
	private String extWheres;//业务层传递的查询条件
	private String refInfo;//对应的关联关系类名及关联关系属性名信息
	
	public String[] getOrderAttr() {
		return orderAttr;
	}
	public void setOrderAttr(String[] orderAttr) {
		this.orderAttr = orderAttr;
	}
	/*public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}*/
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getEntityName() {
		return entityName;
	}
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	public List getDetailPairs() {
		return detailPairs;
	}
	public void setDetailPairs(List detailPairs) {
		this.detailPairs = detailPairs;
	}
	public String getOParams() {
		return oParams;
	}
	public void setOParams(String params) {
		oParams = params;
	}
	public String getSelectcolnames() {
		return selectcolnames;
	}
	public void setSelectcolnames(String selectcolnames) {
		this.selectcolnames = selectcolnames;
	}
	public String getSelectcolTypes() {
		return selectcolTypes;
	}
	public void setSelectcolTypes(String selectcolTypes) {
		this.selectcolTypes = selectcolTypes;
	}
	public List getDetailPairsDel() {
		return detailPairsDel;
	}
	public void setDetailPairsDel(List detailPairsDel) {
		this.detailPairsDel = detailPairsDel;
	}
	public String getDelParams() {
		return delParams;
	}
	public void setDelParams(String delParams) {
		this.delParams = delParams;
	}
	public String getExtWheres() {
		return extWheres;
	}
	public void setExtWheres(String extWheres) {
		this.extWheres = extWheres;
	}
	public String getExtHQL() {
		return extHQL;
	}
	public void setExtHQL(String extHQL) {
		this.extHQL = extHQL;
	}
	public String getRefInfo() {
		return refInfo;
	}
	public void setRefInfo(String refInfo) {
		this.refInfo = refInfo;
	}
	
	
}
