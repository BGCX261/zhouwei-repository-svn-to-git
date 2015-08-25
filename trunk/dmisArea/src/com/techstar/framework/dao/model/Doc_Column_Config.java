package com.techstar.framework.dao.model;

public class Doc_Column_Config {

	String colName; //列名            
    String visible;//是否显示
    String isQuery;//是否用于查询
	String colType;//数据类型
	String manLength;//数据类型的长度

    String displayName;//中文名称
    String displayFormat;//显示风格 
    
    String initdata;//初始值 
    
	String width;//显示列宽
	String isPrimary;//是否是主键	 
	
	
    String isComputerExp;//是否是计算列
	
	
	String displayValue;//显示值

	String realValue;//真实值
	       
    String queryColPath;//快捷查询路径

	public String getColName() {
		return colName;
	}

	public void setColName(String colName) {
		this.colName = colName;
	}

	public String getColType() {
		return colType;
	}

	public void setColType(String colType) {
		this.colType = colType;
	}

	public String getDisplayFormat() {
		return displayFormat;
	}

	public void setDisplayFormat(String displayFormat) {
		this.displayFormat = displayFormat;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayValue() {
		return displayValue;
	}

	public void setDisplayValue(String displayValue) {
		this.displayValue = displayValue;
	}

	public String getInitdata() {
		return initdata;
	}

	public void setInitdata(String initdata) {
		this.initdata = initdata;
	}

	public String getIsComputerExp() {
		return isComputerExp;
	}

	public void setIsComputerExp(String isComputerExp) {
		this.isComputerExp = isComputerExp;
	}

	public String getIsPrimary() {
		return isPrimary;
	}

	public void setIsPrimary(String isPrimary) {
		this.isPrimary = isPrimary;
	}

	public String getIsQuery() {
		return isQuery;
	}

	public void setIsQuery(String isQuery) {
		this.isQuery = isQuery;
	}

	public String getManLength() {
		return manLength;
	}

	public void setManLength(String manLength) {
		this.manLength = manLength;
	}

	public String getQueryColPath() {
		return queryColPath;
	}

	public void setQueryColPath(String queryColPath) {
		this.queryColPath = queryColPath;
	}

	public String getRealValue() {
		return realValue;
	}

	public void setRealValue(String realValue) {
		this.realValue = realValue;
	}

	public String getVisible() {
		return visible;
	}

	public void setVisible(String visible) {
		this.visible = visible;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}
    
    
	
}
