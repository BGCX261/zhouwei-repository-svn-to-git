package com.techstar.framework.ui.entity;

import java.util.Map;

public class GridInfoObj {

	private String hqlSql;
	private String sumSql;
	private int beginPage;
	private int pageSize;
	private Map gridPersonalInfo;
	
	
	public Map getGridPersonalInfo() {
		return gridPersonalInfo;
	}
	public void setGridPersonalInfo(Map gridPersonalInfo) {
		this.gridPersonalInfo = gridPersonalInfo;
	}
	public int getBeginPage() {
		return beginPage;
	}
	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}
	public String getHqlSql() {
		return hqlSql;
	}
	public void setHqlSql(String hqlSql) {
		this.hqlSql = hqlSql;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getSumSql() {
		return sumSql;
	}
	public void setSumSql(String sumSql) {
		this.sumSql = sumSql;
	}
	
	
}
