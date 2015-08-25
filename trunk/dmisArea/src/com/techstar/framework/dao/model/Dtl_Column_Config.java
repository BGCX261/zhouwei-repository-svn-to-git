package com.techstar.framework.dao.model;

public class Dtl_Column_Config {
	String colName; //列名            
    String visible;//是否显示
    String isQuery;//是否用于查询
	String colType;//数据类型
	String manLength;//数据类型的长度

    String displayName;//中文名称
    String displayFormat;//显示风格  
    
	String width;//显示列宽
	String isPrimary;//是否是主键	 
	
	String initdata;//初始化值
    String isComputerExp;//是否是计算列	
	
	String displayValue;//显示值
	String realValue;//真实值
	
	String filterRule;//过滤规则	
	String timeLimit;//时间范围
	       
    String queryColPath;//快捷查询路径	   
    String link;//链接地址
    String linkParam;//链接参数
    String editType; //编辑风格
    String sortType; //排序类型
    String colAlign; //显示位置
    String isEdit;   //是否可编辑
    String isStartDate;//开始日期标志
    String isEndDate;//终止日期标志
    String dateGroupNo;//日期组号
    String listBox;  //下拉框类型
    String listBoxSrc;  //下拉框的数据源
    
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
	public String getFilterRule() {
		return filterRule;
	}
	public void setFilterRule(String filterRule) {
		this.filterRule = filterRule;
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
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getLinkParam() {
		return linkParam;
	}
	public void setLinkParam(String linkParam) {
		this.linkParam = linkParam;
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
	public String getTimeLimit() {
		return timeLimit;
	}
	public void setTimeLimit(String timeLimit) {
		this.timeLimit = timeLimit;
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
	public String getEditType() {
		return editType;
	}
	public void setEditType(String editType) {
		this.editType = editType;
	}
	public String getIsEdit() {
		return isEdit;
	}
	public void setIsEdit(String isEdit) {
		this.isEdit = isEdit;
	}
	public String getSortType() {
		return sortType;
	}
	public void setSortType(String sortType) {
		this.sortType = sortType;
	}
	
	public String getColAlign() {
		return colAlign;
	}
	public void setColAlign(String colAlign) {
		this.colAlign = colAlign;
	}
	public String getDateGroupNo() {
		return dateGroupNo;
	}
	public void setDateGroupNo(String dateGroupNo) {
		this.dateGroupNo = dateGroupNo;
	}
	public String getIsEndDate() {
		return isEndDate;
	}
	public void setIsEndDate(String isEndDate) {
		this.isEndDate = isEndDate;
	}
	public String getIsStartDate() {
		return isStartDate;
	}
	public void setIsStartDate(String isStartDate) {
		this.isStartDate = isStartDate;
	}
	public String getListBox() {
		return listBox;
	}
	public void setListBox(String listBox) {
		this.listBox = listBox;
	}
	public String getListBoxSrc() {
		return listBoxSrc;
	}
	public void setListBoxSrc(String listBoxSrc) {
		this.listBoxSrc = listBoxSrc;
	}
	
}
