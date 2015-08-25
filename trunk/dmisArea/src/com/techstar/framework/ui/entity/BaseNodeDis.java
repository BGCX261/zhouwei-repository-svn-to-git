package com.techstar.framework.ui.entity;

public class BaseNodeDis {
	
	 protected String treeName = ""; //节点所在树的名称
	    
	 protected String dataSource="";//数据源的类型 "table"为普通sql "entity" 为业务对象

	 //	节点在xml里的名称
	 protected String nodeName="";

	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public String getTreeName() {
		return treeName;
	}

	public void setTreeName(String treeName) {
		this.treeName = treeName;
	}
}
