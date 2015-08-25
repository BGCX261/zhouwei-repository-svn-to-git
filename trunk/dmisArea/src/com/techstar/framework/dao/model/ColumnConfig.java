package com.techstar.framework.dao.model;

public class ColumnConfig {

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
	String isWrap;//是否折行
	
    String isComputerExp;//是否是计算列
	String link;//链接地址         
	String linkParam;//链接参数
	
	String displayValue;//显示值
	String realValue;//真实值
	
	String filterRule;//过滤规则
	String timeLimit;//时间范围
    String isTotal;//是否进行统计(sum)        
    String queryColPath;//快捷查询路径
    String isStartDate;//开始日期标志
    String isEndDate;//终止日期标志
    String dateGroupNo;    //日期组号
    String listBox;       //下拉框类型
    String listBoxSrc;    //下拉框的数据源
    String editType;      //编辑风格
    String sortType;      //排序规则
    String colAlign;      //显示位置
	String validateFunc;  //有效性检查的函数
	String validateMsg;	  //提示信息
    String frameSelf;     //源frameName
    String fsTdClassSf;   //源class属性值
    String fsTrStyleSf;   //源style属性值
	String frameTarget;   //目标frameName
	String fsTdClassTg;   //目标class属性值
	String fsTrStyleTg;   //目标style属性值
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
	public String getIsTotal() {
		return isTotal;
	}
	public void setIsTotal(String isTotal) {
		this.isTotal = isTotal;
	}
	public String getIsWrap() {
		return isWrap;
	}
	public void setIsWrap(String isWrap) {
		this.isWrap = isWrap;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
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
	public String getInitdata() {
		return initdata;
	}
	public void setInitdata(String initdata) {
		this.initdata = initdata;
	}
	public String getLinkParam() {
		return linkParam;
	}
	public void setLinkParam(String linkParam) {
		this.linkParam = linkParam;
	}
	
	
	public String getDisplayValue() {
		return displayValue;
	}
	public void setDisplayValue(String displayValue) {
		this.displayValue = displayValue;
	}
	public String getRealValue() {
		return realValue;
	}
	public void setRealValue(String realValue) {
		this.realValue = realValue;
	}
	public String getFilterRule() {
		return filterRule;
	}
	public void setFilterRule(String filterRule) {
		this.filterRule = filterRule;
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
	public String getColAlign() {
		return colAlign;
	}
	public void setColAlign(String colAlign) {
		this.colAlign = colAlign;
	}
	public String getEditType() {
		return editType;
	}
	public void setEditType(String editType) {
		this.editType = editType;
	}
	public String getFrameSelf() {
		return frameSelf;
	}
	public void setFrameSelf(String frameSelf) {
		this.frameSelf = frameSelf;
	}
	public String getFrameTarget() {
		return frameTarget;
	}
	public void setFrameTarget(String frameTarget) {
		this.frameTarget = frameTarget;
	}
	public String getFsTdClassSf() {
		return fsTdClassSf;
	}
	public void setFsTdClassSf(String fsTdClassSf) {
		this.fsTdClassSf = fsTdClassSf;
	}
	public String getFsTdClassTg() {
		return fsTdClassTg;
	}
	public void setFsTdClassTg(String fsTdClassTg) {
		this.fsTdClassTg = fsTdClassTg;
	}
	public String getFsTrStyleSf() {
		return fsTrStyleSf;
	}
	public void setFsTrStyleSf(String fsTrStyleSf) {
		this.fsTrStyleSf = fsTrStyleSf;
	}
	public String getFsTrStyleTg() {
		return fsTrStyleTg;
	}
	public void setFsTrStyleTg(String fsTrStyleTg) {
		this.fsTrStyleTg = fsTrStyleTg;
	}
	public String getSortType() {
		return sortType;
	}
	public void setSortType(String sortType) {
		this.sortType = sortType;
	}
	public String getValidateFunc() {
		return validateFunc;
	}
	public void setValidateFunc(String validateFunc) {
		this.validateFunc = validateFunc;
	}
	public String getValidateMsg() {
		return validateMsg;
	}
	public void setValidateMsg(String validateMsg) {
		this.validateMsg = validateMsg;
	}
    
    
}
