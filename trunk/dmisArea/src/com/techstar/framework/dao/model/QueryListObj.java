package com.techstar.framework.dao.model;

import java.util.List;

public class QueryListObj {

	  private int count; //总行数
	  private java.util.List elemList;
	  private java.util.Map elemMap;
	  public static int PAGESIZE = 10;
	  private List propertySum; //对象属性统计信息

	  public QueryListObj() {
	  }
	  public int getCount() {
	    return count;
	  }
	  public void setCount(int count) {
	    this.count = count;
	  }
	  public java.util.List getElemList() {
	    return elemList;
	  }
	  public void setElemList(java.util.List elemList) {
	    this.elemList = elemList;
	  }
	public java.util.Map getElemMap() {
		return elemMap;
	}
	public void setElemMap(java.util.Map elemMap) {
		this.elemMap = elemMap;
	}
	public List getPropertySum() {
		return propertySum;
	}
	public void setPropertySum(List propertySum) {
		this.propertySum = propertySum;
	}

	  
	  
}
