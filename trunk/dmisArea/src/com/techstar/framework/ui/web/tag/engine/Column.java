package com.techstar.framework.ui.web.tag.engine;

public class Column {

	String colName;  		//列名
	String viewName; 		//显示名
	String colType;			//数据类型
	String dataTypeLen;		//数据长度
	String isPrimary;       //是否是主键
	String visible;			//是否显示
	String width;			//显示列宽
	String isEdit;			//是否可编辑
	String textColor;		//字体颜色
	
	String propertyName;	//类的属性名	
	String className;		//类名，如果是个类的话
	String refName;			//类的属性名，用到该类的属性名
	
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
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
	public String getDataTypeLen() {
		return dataTypeLen;
	}
	public void setDataTypeLen(String dataTypeLen) {
		this.dataTypeLen = dataTypeLen;
	}
	public String getIsEdit() {
		return isEdit;
	}
	public void setIsEdit(String isEdit) {
		this.isEdit = isEdit;
	}
	public String getIsPrimary() {
		return isPrimary;
	}
	public void setIsPrimary(String isPrimary) {
		this.isPrimary = isPrimary;
	}
	public String getRefName() {
		return refName;
	}
	public void setRefName(String refName) {
		this.refName = refName;
	}
	public String getTextColor() {
		return textColor;
	}
	public void setTextColor(String textColor) {
		this.textColor = textColor;
	}
	public String getViewName() {
		return viewName;
	}
	public void setViewName(String viewName) {
		this.viewName = viewName;
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
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	
	
	
}
