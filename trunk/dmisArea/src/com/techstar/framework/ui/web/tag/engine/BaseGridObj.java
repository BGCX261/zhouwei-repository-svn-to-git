package com.techstar.framework.ui.web.tag.engine;

public class BaseGridObj 
{
	/**
	 *  表格名称
	 */
	private String id;
	/**
	 *  分页Div名称
	 */
	private String pageId;
	/**
	 *  业务名称
	 */
	private String busName;
	/**
	 *  业务子名称
	 */
	private String subName;
	/**
	 * 	列表内容字串
	 */
	private StringBuffer htmlStr;
	/**
	 *  基础路径
	 */
	private String contextPath;
	/**
	 *  初始地址
	 */
	private String initUrl;
	/**
	 *  跳转地址
	 */
	private String actionUrl;
	/**
	 *  图片地址
	 */
	private String imgUrl;
	/**
	 * 	列表样式
	 */
	private String skin = "xp";
	/**
	 *  实体类名
	 */
	private String entityName;
	/**
	 *  导出xls文件时的请求路径及工作簿名称
	 */
	private String xls;
	/**
	 *	查询请求路径
	 */
	private String queryPath;
	/**
	 * 	保存请求路径
	 */
	private String savePath;
	/**
	 * 	删除请求路径
	 */
	private String delPath;
	/**
	 * 	列表类型
	 */
	private String listType;
	/**
	 * 	列表性质
	 */
	private String listKind;
	/**
	 * 	每页的记录数
	 */
	private String pageItems;
	/**
	 * 	过滤模式
	 */
	private String filterMode;
	/**
	 * 	右键菜单,按规定格式编写的xml字符串
	 */
	private String rightMenu;
	/**
	 * 	列表所在的DIV的高度
	 */
	private String divHeight;
	/**
	 *  列表所在的DIV的宽度
	 */
	private String divWidth = "100%";
	/**
	 * 	是否显示统计行
	 */
	private String isTotalRow;
	/**
	 * 	是否有过滤行
	 */
	private String isFilterRow;
	/**
	 * 	是否有辅助选择框
	 */
	private String isCheckBox;
	/**
	 *  是否有操作列
	 */
	private String isOperater;
	/**
	 * 	是否有行状态列
	 */
	private String isStatusCol;
	/**
	 * 	是否显示<显示设置>链接
	 */
	private String isDisplaySet;
	/**
	 * 	是否显示<查询设置>链接
	 */
	private String isQuerySet;
	/**
	 * 	是否显示<导出>链接
	 */
	private String isOutputSet;
	/**
	 *  是否显示<综合统计>链接
	 */
	private String isStatSet;
	/**
	 *  是否显示<分页>链接
	 */
	private String isPageSet;
	
	/**
	 * 	关联关系类名
	 */
	private String className;
	/**
	 * 	关联关系属性名
	 */
	private String refName;
	/**
	 * 	列名
	 */
	private String colName;
	/**
	 *  列中文名
	 */
	private String displayName;
	/**
	 * 	是否必填
	 */
	private String isNotNull;
	/**
	 * 	数据库中的数据类型
	 */
	private String colType;
	/**
	 * 	数据类型的长度


	 */
	private String dataTypeLen;
	/**
	 * 	是否是主键
	 */
	private String isPrimary;
	/**
	 * 	是否显示
	 */
	private String visible;
	/**
	 * 	显示列宽
	 */
	private String width;
	/**
	 *  初始化值
	 */
	private String initdata;
	/**
	 * 	是否可编辑
	 */
	private String isEdit;
	/**
	 * 	显示风格
	 */
	private String displayFormat;
	/**
	 * 	计算列表达式
	 */
	private String comrowerExp;
	/**
	 *	字体颜色
	 */
	private String textColor;
	/**
	 * 	链接地址
	 */
	private String link;
	/**
	 * 	显示值
	 */
	private String displayValue;
	/**
	 * 	真实值
	 */
	private String realValue;
	/**
	 * 	是否进行统计sum
	 */
	private String isTotal;
	/**
	 * 	快捷查询路径
	 */
	private String queryColPath;
	/**
	 * 	编辑风格
	 */
	private String editType;
	/**
	 * 	排序类型
	 */
	private String sortType;
	/**
	 * 	显示位置
	 */
	private String colAlign;
	/**
	 * 	源frame
	 */
	private String frameSelf;
	/**
	 * 	目标frame
	 */
	private String frameTarget;
	/**
	 * 	日期控件组中的位置标志
	 */
	private String dateFlag;
	/**
	 * 	日期组号
	 */
	private String dateGroupNo;
	/**
	 * 	下拉列表数据源
	 */
	private String listBox;
	/**
	 *  过滤规则
	 */
	private String filterRules;
	/**
	 *  列移动规则
	 */
	private String columnMove;
	/**
	 *  查询列参数
	 */
	private String selectColNames;
	/**
	 *  下拉菜单键值对应关系
	 */
    private String colValByList;
    /**
     *  是否折行处理
     */
    private String isMultiline;
    /**
     *  操作列弹出对话框信息
     */
    private String opColInfo;
    
    /**
     *  设置外键
     */
    private String refColVal;
    
    public String getRefColVal() {
		return refColVal;
	}
	public void setRefColVal(String refColVal) {
		this.refColVal = refColVal;
	}
	/**
	 * 定义参数对应的Set方法和Get方法
	 */
	public String getActionUrl() {
		return actionUrl;
	}
	public void setActionUrl(String actionUrl) {
		this.actionUrl = actionUrl;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getColAlign() {
		return colAlign;
	}
	public void setColAlign(String colAlign) {
		this.colAlign = colAlign;
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
	public String getComrowerExp() {
		return comrowerExp;
	}
	public void setComrowerExp(String comrowerExp) {
		this.comrowerExp = comrowerExp;
	}
	public String getContextPath() {
		return contextPath;
	}
	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}
	public String getDataTypeLen() {
		return dataTypeLen;
	}
	public void setDataTypeLen(String dataTypeLen) {
		this.dataTypeLen = dataTypeLen;
	}
	public String getDateFlag() {
		return dateFlag;
	}
	public void setDateFlag(String dateFlag) {
		this.dateFlag = dateFlag;
	}
	public String getDateGroupNo() {
		return dateGroupNo;
	}
	public void setDateGroupNo(String dateGroupNo) {
		this.dateGroupNo = dateGroupNo;
	}
	public String getDelPath() {
		return delPath;
	}
	public void setDelPath(String delPath) {
		this.delPath = delPath;
	}
	public String getDisplayFormat() {
		return displayFormat;
	}
	public void setDisplayFormat(String displayFormat) {
		this.displayFormat = displayFormat;
	}
	public String getDisplayValue() {
		return displayValue;
	}
	public void setDisplayValue(String displayValue) {
		this.displayValue = displayValue;
	}
	public String getDivHeight() {
		return divHeight;
	}
	public void setDivHeight(String divHeight) {
		this.divHeight = divHeight;
	}
	public String getEditType() {
		return editType;
	}
	public void setEditType(String editType) {
		this.editType = editType;
	}
	public String getFilterMode() {
		return filterMode;
	}
	public void setFilterMode(String filterMode) {
		this.filterMode = filterMode;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getInitdata() {
		return initdata;
	}
	public void setInitdata(String initdata) {
		this.initdata = initdata;
	}
	public String getInitUrl() {
		return initUrl;
	}
	public void setInitUrl(String initUrl) {
		this.initUrl = initUrl;
	}
	public String getIsCheckBox() {
		return isCheckBox;
	}
	public void setIsCheckBox(String isCheckBox) {
		this.isCheckBox = isCheckBox;
	}
	public String getIsDisplaySet() {
		return isDisplaySet;
	}
	public void setIsDisplaySet(String isDisplaySet) {
		this.isDisplaySet = isDisplaySet;
	}
	public String getIsEdit() {
		return isEdit;
	}
	public void setIsEdit(String isEdit) {
		this.isEdit = isEdit;
	}
	public String getIsFilterRow() {
		return isFilterRow;
	}
	public void setIsFilterRow(String isFilterRow) {
		this.isFilterRow = isFilterRow;
	}
	public String getIsNotNull() {
		return isNotNull;
	}
	public void setIsNotNull(String isNotNull) {
		this.isNotNull = isNotNull;
	}
	public String getIsOperater() {
		return isOperater;
	}
	public void setIsOperater(String isOperater) {
		this.isOperater = isOperater;
	}
	public String getIsOutputSet() {
		return isOutputSet;
	}
	public void setIsOutputSet(String isOutputSet) {
		this.isOutputSet = isOutputSet;
	}
	public String getIsPageSet() {
		return isPageSet;
	}
	public void setIsPageSet(String isPageSet) {
		this.isPageSet = isPageSet;
	}
	public String getIsPrimary() {
		return isPrimary;
	}
	public void setIsPrimary(String isPrimary) {
		this.isPrimary = isPrimary;
	}
	public String getIsQuerySet() {
		return isQuerySet;
	}
	public void setIsQuerySet(String isQuerySet) {
		this.isQuerySet = isQuerySet;
	}
	public String getIsStatusCol() {
		return isStatusCol;
	}
	public void setIsStatusCol(String isStatusCol) {
		this.isStatusCol = isStatusCol;
	}
	public String getIsTotal() {
		return isTotal;
	}
	public void setIsTotal(String isTotal) {
		this.isTotal = isTotal;
	}
	public String getIsTotalRow() {
		return isTotalRow;
	}
	public void setIsTotalRow(String isTotalRow) {
		this.isTotalRow = isTotalRow;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getListBox() {
		return listBox;
	}
	public void setListBox(String listBox) {
		this.listBox = listBox;
	}
	public String getListKind() {
		return listKind;
	}
	public void setListKind(String listKind) {
		this.listKind = listKind;
	}
	public String getListType() {
		return listType;
	}
	public void setListType(String listType) {
		this.listType = listType;
	}
	public String getPageItems() {
		return pageItems;
	}
	public void setPageItems(String pageItems) {
		this.pageItems = pageItems;
	}
	public String getQueryColPath() {
		return queryColPath;
	}
	public void setQueryColPath(String queryColPath) {
		this.queryColPath = queryColPath;
	}
	public String getQueryPath() {
		return queryPath;
	}
	public void setQueryPath(String queryPath) {
		this.queryPath = queryPath;
	}
	public String getRealValue() {
		return realValue;
	}
	public void setRealValue(String realValue) {
		this.realValue = realValue;
	}
	public String getRefName() {
		return refName;
	}
	public void setRefName(String refName) {
		this.refName = refName;
	}
	public String getRightMenu() {
		return rightMenu;
	}
	public void setRightMenu(String rightMenu) {
		this.rightMenu = rightMenu;
	}
	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	public String getSortType() {
		return sortType;
	}
	public void setSortType(String sortType) {
		this.sortType = sortType;
	}
	public String getTextColor() {
		return textColor;
	}
	public void setTextColor(String textColor) {
		this.textColor = textColor;
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
	public String getXls() {
		return xls;
	}
	public void setXls(String xls) {
		this.xls = xls;
	}

	public String getSkin() {
		return skin;
	}

	public void setSkin(String skin) {
		this.skin = skin;
	}

	public String getDivWidth() {
		return divWidth;
	}

	public void setDivWidth(String divWidth) {
		this.divWidth = divWidth;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getIsStatSet() {
		return isStatSet;
	}

	public void setIsStatSet(String isStatSet) {
		this.isStatSet = isStatSet;
	}

	public String getColumnMove() {
		return columnMove;
	}

	public void setColumnMove(String columnMove) {
		this.columnMove = columnMove;
	}

	public String getFilterRules() {
		return filterRules;
	}

	public void setFilterRules(String filterRules) {
		this.filterRules = filterRules;
	}

	public String getSelectColNames() {
		return selectColNames;
	}

	public void setSelectColNames(String selectColNames) {
		this.selectColNames = selectColNames;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public String getColValByList() {
		return colValByList;
	}

	public void setColValByList(String colValByList) {
		this.colValByList = colValByList;
	}

	public String getIsMultiline() {
		return isMultiline;
	}

	public void setIsMultiline(String isMultiline) {
		this.isMultiline = isMultiline;
	}
	public String getPageId() {
		return pageId;
	}
	public void setPageId(String pageId) {
		this.pageId = pageId;
	}
	public String getOpColInfo() {
		return opColInfo;
	}
	public void setOpColInfo(String opColInfo) {
		this.opColInfo = opColInfo;
	}
}
