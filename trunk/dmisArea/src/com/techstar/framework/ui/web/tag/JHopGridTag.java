package com.techstar.framework.ui.web.tag;

import java.io.File;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.lang.StringUtils;

import com.techstar.framework.ui.utils.grid.parseIndividuation;
import com.techstar.framework.ui.web.tag.engine.BaseGridObj;
import com.techstar.framework.ui.web.tag.engine.Column;
import com.techstar.framework.ui.web.tag.engine.ObjtoGridXmlHelper;
import com.techstar.framework.ui.web.tag.utils.GridConstant;

/**
 *  构造列表

 * 
 * @author majian
 */
public class JHopGridTag extends BodyTagSupport 
{
	/**
	 *  表格名称
	 */
	private String id;
	/**
	 *  分页DIV名
	 */
	private String pageId;
	/**
	 * 业务名称
	 */
	private String busName;
	/**
	 * 业务子名称
	 */
	private String subName;
	/**
	 * 操作列弹出对话框信息
	 */
	private String opColInfo;
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
     *  列表是否可编缉
     */
    private String updateable;
    /**
     *  设置外键
     */
    private String refColVal;

	private String lineFlag = "\n";
	private String opTitleRowImg    = "img:["+contextPath+GridConstant.GRID_IMAGE_PATH+"opButton.gif"+"]";
	private String titleRownoImg 	= "img:["+contextPath+GridConstant.GRID_IMAGE_PATH+"config.gif"+"]";
	private String titleSelectImg 	= "img:["+contextPath+GridConstant.GRID_IMAGE_PATH+"select.gif"+"]";
	private String titleUNSelectImg = "img:["+contextPath+GridConstant.GRID_IMAGE_PATH+"retract.gif"+"]";
	

	
	/**
	 * 列表需要的Javascript函数
	 * 
	 * @return
	 * @throws JspException
	 */
	public StringBuffer scriptStr() throws JspException
	{
		StringBuffer script = new StringBuffer();
					 script.append("<script>");
					 script.append("");
					 script.append("");
					 script.append("</script>");
		
		return script;
	}
	
	/**
	 *  层叠样式表信息

	 * 
	 * @return
	 * @throws JspException
	 */
	public StringBuffer styleStr() throws JspException
	{
		StringBuffer style = new StringBuffer();
					 style.append("");
					 style.append("");
					 style.append("");
					 
		return style;
	}
	
	/**
	 *  包含以下相关链接
	 *  1. 显示设置
	 *  2. 高级查询
	 *  3. 保存查询
	 *  4. 导出
	 *  5. 综合统计
	 * @return
	 * @throws JspException
	 */
	public StringBuffer functionKey() throws JspException
	{
		StringBuffer keyStr = new StringBuffer();
		if(!StringUtils.isEmpty(this.isStatSet) ||
				 !StringUtils.isEmpty(this.isQuerySet) || 
				 	!StringUtils.isEmpty(this.isOutputSet) ||
				 		!StringUtils.isEmpty(this.isStatSet)){
					 keyStr.append("<table align='left' width='100%'>"+lineFlag);
					 keyStr.append("	<tr>"+lineFlag);
					 keyStr.append("		<td>"+lineFlag);
					 keyStr.append("			<table align='left' border='0' cellpadding='0' cellspacing='0'>"+lineFlag);
					 keyStr.append("				<tr>"+lineFlag);
					 keyStr.append("					<td width='11'>&nbsp;</td>"+lineFlag);
					 if(!StringUtils.isEmpty(this.isDisplaySet)){
						 keyStr.append("					<td width='17' class='img1'>&nbsp;</td>"+lineFlag);
						 keyStr.append("					<td width='59'>"+lineFlag);
						 keyStr.append("						<span class='hand' onClick=showWindowDisplay('/components/tag/grid/common/displaysetup.jsp')>显示设置</span>"+lineFlag);
						 keyStr.append("					</td>"+lineFlag);
					 }
					 if(!StringUtils.isEmpty(this.isQuerySet)){
						 keyStr.append("					<td width='18' class='img2'>&nbsp;</td>"+lineFlag);
						 keyStr.append("					<td width='65'>"+lineFlag);
						 keyStr.append("						<span class='hand' onClick=showWindowSearch('/components/tag/grid/common/searchsetup.jsp')>高级查询</span>"+lineFlag);
						 keyStr.append("					</td>"+lineFlag);
						 keyStr.append("					<td width='19' class='img3'>&nbsp;</td>"+lineFlag);
						 keyStr.append("					<td width='65'>"+lineFlag);
						 keyStr.append("						<span class='hand' onClick=showWindowSaveSearch('/components/tag/grid/common/searchsave.jsp')>保存查询</span>"+lineFlag);
						 keyStr.append("					</td>"+lineFlag);
					 }
					 if(!StringUtils.isEmpty(this.isOutputSet)){
						 keyStr.append("					<td width='18' class='img4'>&nbsp;</td>"+lineFlag);
						 keyStr.append("					<td width='35'>"+lineFlag);
						 keyStr.append("						<span class='hand' onClick=showWinForExp('/components/tag/grid/common/exportExcel.jsp')>导出</span>"+lineFlag);
						 keyStr.append("					</td>"+lineFlag);
					 }
					 if(!StringUtils.isEmpty(this.isStatSet)){
						 keyStr.append("					<td width='19' class='img4'>&nbsp;</td>"+lineFlag);
						 keyStr.append("					<td width='65'>"+lineFlag);
						 keyStr.append("						<span class='hand' onclick=showWinForExp('/components/tag/grid/common/exportExcel.jsp')>综合统计</span>"+lineFlag);
						 keyStr.append("					</td>"+lineFlag);
					 } 
					 keyStr.append("				</tr>"+lineFlag);
					 keyStr.append("			</table>"+lineFlag);
					 keyStr.append("		</td>"+lineFlag);
					 keyStr.append("	</tr>"+lineFlag);
					 keyStr.append("</table>"+lineFlag);
					 keyStr.append("<br>");
					 keyStr.append("<br>");
		}

		return keyStr;
	}
	
	/**
	 * 定义隐藏域字段

	 * Tag外的控件可获取参数

	 * 
	 * @return
	 * @throws JspException
	 */
	public StringBuffer hiddenFieldStr() throws JspException
	{
		StringBuffer hiddenStr = new StringBuffer();
					 hiddenStr.append("<form>");
					 hiddenStr.append("		<input type='hidden' name='domainName' 	 	value=''/>"+lineFlag);
					 hiddenStr.append("		<input type='hidden' name='queryPath' 	 	value=''/>"+lineFlag);
					 hiddenStr.append("		<input type='hidden' name='colName' 	 	value=''/>"+lineFlag);
					 hiddenStr.append("		<input type='hidden' name='displayName' 	value=''/>"+lineFlag);
					 hiddenStr.append("		<input type='hidden' name='displayFormat' 	value=''/>"+lineFlag);
					 hiddenStr.append("		<input type='hidden' name='isPrimary' 	 	value=''/>"+lineFlag);
					 hiddenStr.append("		<input type='hidden' name='colType' 	 	value=''/>"+lineFlag);
					 hiddenStr.append("		<input type='hidden' name='editType' 	 	value=''/>"+lineFlag);
					 hiddenStr.append("		<input type='hidden' name='editType' 	 	value=''/>"+lineFlag);
					 hiddenStr.append("		<input type='hidden' name='colSortStr' 	 	value=''/>"+lineFlag);
					 hiddenStr.append("		<input type='hidden' name='visible' 	 	value=''/>"+lineFlag);
					 hiddenStr.append("		<input type='hidden' name='sortType' 	 	value=''/>"+lineFlag);
					 hiddenStr.append("		<input type='hidden' name='width' 	 		value=''/>"+lineFlag);
					 hiddenStr.append("		<input type='hidden' name='colAlign' 	 	value=''/>"+lineFlag);
					 hiddenStr.append("		<input type='hidden' name='isTotal' 	 	value=''/>"+lineFlag);
					 hiddenStr.append("		<input type='hidden' name='colNamesTypes' 	value=''/>"+lineFlag);
					 hiddenStr.append("		<input type='hidden' name='listBox' 	 	value=''/>"+lineFlag);
					 hiddenStr.append("		<input type='hidden' name='listBoxSrc' 	 	value=''/>"+lineFlag);
					 hiddenStr.append("		<input type='hidden' name='pageDefault'		value=''/>"+lineFlag);
					 hiddenStr.append("		<input type='hidden' name='busName'			value=''/>"+lineFlag);
					 hiddenStr.append("		<input type='hidden' name='subName'			value=''/>"+lineFlag);
					 hiddenStr.append("		<input type='hidden' name='userSign'		value=''/>"+lineFlag);
					 hiddenStr.append("		<input type='hidden' name='xls'             value=''/>"+lineFlag);
					 hiddenStr.append("		<input type='hidden' name='selectColName'  value=''/>"+lineFlag);
					 hiddenStr.append("		<input type='hidden' name='otherparams'     value=''/>"+lineFlag);
					 
					 hiddenStr.append("		<input type='hidden' name='totalCount' 	 	value=''/>"+lineFlag);
					 hiddenStr.append("		<input type='hidden' name='currPage' 	 	value=''/>"+lineFlag);
					 hiddenStr.append("		<input type='hidden' name='filterStr' 	 	value=''/>"+lineFlag);
					 hiddenStr.append("		<input type='hidden' name='childStr' 	 	value=''/>"+lineFlag);
					 hiddenStr.append("		<input type='hidden' name='foldMode'		value=''/>"+lineFlag);
					 hiddenStr.append("		<input type='hidden' name='multipMode'		value=''/>"+lineFlag);
					 hiddenStr.append("		<input type='hidden' name='changeColor'		value=''/>"+lineFlag);
					 hiddenStr.append("		<input type='hidden' name='selectMode'		value=''/>"+lineFlag);
					 hiddenStr.append("		<input type='hidden' name='lockColumn'		value=''/>"+lineFlag);
					 hiddenStr.append("		<input type='hidden' name='pageSelect'		value=''/>"+lineFlag);
					 hiddenStr.append("		<input type='hidden' name='wheres'		    value=''/>"+lineFlag);
					 hiddenStr.append("</form>");
		return hiddenStr;
	}
	
	/**
	 *  解析列表需要的相关参数
	 *  
	 * 
	 * @throws JspException
	 */
	public void initParam() throws JspException,Exception
	{
		String updateable = (String)((HttpServletRequest) pageContext.getRequest()).getAttribute("updateable");
		//是否可编辑
		if(StringUtils.isEmpty(updateable)){
			this.updateable = "-1";
		}else if(updateable.equalsIgnoreCase("false")){
			this.updateable = "0";
		}else if(updateable.equalsIgnoreCase("true")){
			this.updateable = "1";
		}
		
		//得到基本列表对象BaseGridObj
		BaseGridObj gridObj = (BaseGridObj)((HttpServletRequest) pageContext.getRequest()).getAttribute("gridObj");
		if(gridObj != null){
			if(!StringUtils.isEmpty(gridObj.getActionUrl())){
				this.setActionUrl(gridObj.getActionUrl());
			}
			if(!StringUtils.isEmpty(gridObj.getBusName())){
				this.setBusName(gridObj.getBusName());
			}
			if(!StringUtils.isEmpty(gridObj.getClassName())){
				this.setClassName(gridObj.getClassName());
			}
			if(!StringUtils.isEmpty(gridObj.getColAlign())){
				this.setColAlign(gridObj.getColAlign());
			}
			if(!StringUtils.isEmpty(gridObj.getColName())){
				this.setColName(gridObj.getColName());
			}	
			if(!StringUtils.isEmpty(gridObj.getColType())){
				this.setColType(gridObj.getColType());
			}
			if(!StringUtils.isEmpty(gridObj.getColumnMove())){
				this.setColumnMove(gridObj.getColumnMove());
			}			
			if(!StringUtils.isEmpty(gridObj.getColValByList())){
				this.setColValByList(gridObj.getColValByList());
			}
			if(!StringUtils.isEmpty(gridObj.getComrowerExp())){
				this.setComrowerExp(gridObj.getComrowerExp());
			}	
			if(!StringUtils.isEmpty(gridObj.getDataTypeLen())){
				this.setDataTypeLen(gridObj.getDataTypeLen());
			}
			if(!StringUtils.isEmpty(gridObj.getDateFlag())){
				this.setDateFlag(gridObj.getDateFlag());
			}	
			if(!StringUtils.isEmpty(gridObj.getDateGroupNo())){
				this.setDateGroupNo(gridObj.getDateGroupNo());
			}
			if(!StringUtils.isEmpty(gridObj.getDelPath())){
				this.setDelPath(gridObj.getDelPath());
			}
			if(!StringUtils.isEmpty(gridObj.getDisplayFormat())){
				this.setDisplayFormat(gridObj.getDisplayFormat());
			}
			if(!StringUtils.isEmpty(gridObj.getDisplayName())){
				this.setDisplayName(gridObj.getDisplayName());
			}
			if(!StringUtils.isEmpty(gridObj.getDisplayValue())){
				this.setDisplayValue(gridObj.getDisplayValue());
			}
			if(!StringUtils.isEmpty(gridObj.getDivHeight())){
				this.setDivHeight(gridObj.getDivHeight());
			}
			if(!StringUtils.isEmpty(gridObj.getDivWidth())){
				this.setDivWidth(gridObj.getDivWidth());
			}
			if(!StringUtils.isEmpty(gridObj.getEditType())){
				this.setEditType(gridObj.getEditType());
			}
			if(!StringUtils.isEmpty(gridObj.getEntityName())){
				this.setEntityName(gridObj.getEntityName());
			}
			if(!StringUtils.isEmpty(gridObj.getFilterMode())){
				this.setFilterMode(gridObj.getFilterMode());
			}
			if(!StringUtils.isEmpty(gridObj.getFilterRules())){
				this.setFilterRules(gridObj.getFilterRules());
			}
			if(!StringUtils.isEmpty(gridObj.getFrameSelf())){
				this.setFrameSelf(gridObj.getFrameSelf());
			}
			if(!StringUtils.isEmpty(gridObj.getFrameTarget())){
				this.setFrameTarget(gridObj.getFrameTarget());
			}
			if(!StringUtils.isEmpty(gridObj.getId())){
				this.setId(gridObj.getId());
			}
			if(!StringUtils.isEmpty(gridObj.getImgUrl())){
				this.setImgUrl(gridObj.getImgUrl());
			}
			if(!StringUtils.isEmpty(gridObj.getInitdata())){
				this.setInitdata(gridObj.getInitdata());
			}
			if(!StringUtils.isEmpty(gridObj.getInitUrl())){
				this.setInitUrl(gridObj.getInitUrl());
			}
			if(!StringUtils.isEmpty(gridObj.getIsCheckBox())){
				this.setIsCheckBox(gridObj.getIsCheckBox());
			}
			if(!StringUtils.isEmpty(gridObj.getIsDisplaySet())){
				this.setIsDisplaySet(gridObj.getIsDisplaySet());
			}
			if(!StringUtils.isEmpty(gridObj.getIsEdit())){
				this.setIsEdit(gridObj.getIsEdit());
			}
			if(!StringUtils.isEmpty(gridObj.getIsFilterRow())){
				this.setIsFilterRow(gridObj.getIsFilterRow());
			}
			if(!StringUtils.isEmpty(gridObj.getIsMultiline())){
				this.setIsMultiline(gridObj.getIsMultiline());
			}
			if(!StringUtils.isEmpty(gridObj.getIsNotNull())){
				this.setIsNotNull(gridObj.getIsNotNull());
			}
			if(!StringUtils.isEmpty(gridObj.getIsOperater())){
				this.setIsOperater(gridObj.getIsOperater());
			}
			if(!StringUtils.isEmpty(gridObj.getIsOutputSet())){
				this.setIsOutputSet(gridObj.getIsOutputSet());
			}
			if(!StringUtils.isEmpty(gridObj.getIsPageSet())){
				this.setIsPageSet(gridObj.getIsPageSet());
			}
			if(!StringUtils.isEmpty(gridObj.getIsPrimary())){
				this.setIsPrimary(gridObj.getIsPrimary());
			}
			if(!StringUtils.isEmpty(gridObj.getIsQuerySet())){
				this.setIsQuerySet(gridObj.getIsQuerySet());
			}
			if(!StringUtils.isEmpty(gridObj.getIsStatSet())){
				this.setIsStatSet(gridObj.getIsStatSet());
			}
			if(!StringUtils.isEmpty(gridObj.getIsStatusCol())){
				this.setIsStatusCol(gridObj.getIsStatusCol());
			}
			if(!StringUtils.isEmpty(gridObj.getIsTotal())){
				this.setIsTotal(gridObj.getIsTotal());
			}
			if(!StringUtils.isEmpty(gridObj.getIsTotalRow())){
				this.setIsTotalRow(gridObj.getIsTotalRow());
			}
			if(!StringUtils.isEmpty(gridObj.getLink())){
				this.setLink(gridObj.getLink());
			}
			if(!StringUtils.isEmpty(gridObj.getListBox())){
				this.setListBox(gridObj.getListBox());
			}
			if(!StringUtils.isEmpty(gridObj.getListKind())){
				this.setListKind(gridObj.getListKind());
			}
			if(!StringUtils.isEmpty(gridObj.getListType())){
				this.setListType(gridObj.getListType());
			}
			if(!StringUtils.isEmpty(gridObj.getPageItems())){
				this.setPageItems(gridObj.getPageItems());
			}
			if(!StringUtils.isEmpty(gridObj.getQueryColPath())){
				this.setQueryColPath(gridObj.getQueryColPath());
			}
			if(!StringUtils.isEmpty(gridObj.getQueryPath())){
				this.setQueryPath(gridObj.getQueryPath());
			}
			if(!StringUtils.isEmpty(gridObj.getRealValue())){
				this.setRealValue(gridObj.getRealValue());
			}
			if(!StringUtils.isEmpty(gridObj.getRefName())){
				this.setRefName(gridObj.getRefName());
			}
			if(!StringUtils.isEmpty(gridObj.getRightMenu())){
				this.setRightMenu(gridObj.getRightMenu());
			}
			if(!StringUtils.isEmpty(gridObj.getSavePath())){
				this.setSavePath(gridObj.getSavePath());
			}
			if(!StringUtils.isEmpty(gridObj.getSelectColNames())){
				this.setSelectColNames(gridObj.getSelectColNames());
			}
			if(!StringUtils.isEmpty(gridObj.getSkin())){
				this.setSkin(gridObj.getSkin());
			}
			if(!StringUtils.isEmpty(gridObj.getSortType())){
				this.setSortType(gridObj.getSortType());
			}
			if(!StringUtils.isEmpty(gridObj.getTextColor())){
				this.setSubName(gridObj.getSubName());
			}
			if(!StringUtils.isEmpty(gridObj.getTextColor())){
				this.setTextColor(gridObj.getTextColor());
			}
			if(!StringUtils.isEmpty(gridObj.getVisible())){
				this.setVisible(gridObj.getVisible());
			}
			if(!StringUtils.isEmpty(gridObj.getWidth())){
				this.setWidth(gridObj.getWidth());
			}
			if(!StringUtils.isEmpty(gridObj.getXls())){
				this.setXls(gridObj.getXls());
			}
			if(!StringUtils.isEmpty(gridObj.getRefColVal())){
				this.setRefColVal(gridObj.getRefColVal());
			}
		}
		
		//表格图片路径
		if(StringUtils.isEmpty(this.imgUrl)){
			this.imgUrl = contextPath+GridConstant.GRID_IMAGE_PATH;
		}	
		//过滤模式
		if(StringUtils.isEmpty(this.filterMode)){
			this.filterMode = "0";
		}
		//表格高度
		if(StringUtils.isEmpty(this.divHeight)){
			this.divHeight = "400";
		}
		//表格宽度
		if(StringUtils.isEmpty(this.divWidth)){
			this.divWidth = "100%";
		}
		//是否有统计行
		if(StringUtils.isEmpty(this.isTotalRow)){
			this.isTotalRow = "0";
		}
		//是否有过滤行
		if(StringUtils.isEmpty(this.isFilterRow)){
			this.isFilterRow = "0";
		}
		//是否有多选列
		if(StringUtils.isEmpty(this.isCheckBox)){
			this.isCheckBox = "1";
		}
		//是否有操作列
		if(StringUtils.isEmpty(this.isOperater)){
			this.isOperater = "0";
		}
		//是否有状态列
		if(StringUtils.isEmpty(this.isStatusCol)){
			this.isStatusCol = "1";
		}
		//初始化每页显示条数
		if(StringUtils.isEmpty(this.pageItems)){
			this.pageItems = "15";
		}
		
		if(StringUtils.isEmpty(this.listKind)){
			this.listKind = "101";
		}
		if(StringUtils.isEmpty(this.listType)){
			this.listType = "3";
		}
		
		/**
		 101  不可编辑 、可过滤查询、有统计行的列表[属于普通列表,该列表的行号列用于跳转]
	     102  可编辑 、可过滤查询、有统计行的列表[备用]
	     103  不可编辑 、可过滤查询、无统计行的简单列表[快捷查询时使用]
	     104  可编辑 、不可过滤查询、有统计行的列表[主子表结构中的子表]
	     105  可编辑 、不可过滤查询、无统计行的列表[主子表结构中的子表]
	     106  不可编辑 、不可过滤查询、无统计行的列表[用于下拉列表框]
	     107  不可编辑、可过滤、无统计行的主表子卡片的主表
		 108  不可编辑、可过滤、无统计行的双表联动中的主表
		*/
		if(!StringUtils.isEmpty(this.listKind) && this.listKind.equalsIgnoreCase("101")){
			this.isFilterRow = "1";
			this.isTotalRow  = "1";
			//this.isCheckBox  = "1";
			//this.isOperater  = "1";
			this.isStatusCol = "1";
			this.filterMode  = "2";
		} else if(!StringUtils.isEmpty(this.listKind) && this.listKind.equalsIgnoreCase("102")){
			this.isFilterRow = "1";
			this.isTotalRow  = "1";
			//this.isCheckBox  = "1";
			//this.isOperater  = "1";
			this.isStatusCol = "1";
			this.filterMode  = "2";
		} else if(!StringUtils.isEmpty(this.listKind) && this.listKind.equalsIgnoreCase("103")){
			this.isFilterRow = "1";
			this.isTotalRow  = "0";
			//this.isCheckBox  = "1";
			//this.isOperater  = "1";
			this.isStatusCol = "1";
			this.filterMode  = "2";
		} else if(!StringUtils.isEmpty(this.listKind) && this.listKind.equalsIgnoreCase("104")){
			this.isFilterRow = "0";
			this.isTotalRow  = "1";
			//this.isCheckBox  = "1";
			//this.isOperater  = "1";
			this.isStatusCol = "1";
			this.filterMode  = "0";
		} else if(!StringUtils.isEmpty(this.listKind) && this.listKind.equalsIgnoreCase("105")){
			this.isFilterRow = "0";
			this.isTotalRow  = "0";
			//this.isCheckBox  = "1";
			//this.isOperater  = "1";
			this.isStatusCol = "1";
			this.filterMode  = "0";
		} else if(!StringUtils.isEmpty(this.listKind) && this.listKind.equalsIgnoreCase("106")){
			this.isFilterRow = "0";
			this.isTotalRow  = "0";
			//this.isCheckBox  = "1";
			//this.isOperater  = "1";
			this.isStatusCol = "1";
			this.filterMode  = "0";
		} else if(!StringUtils.isEmpty(this.listKind) && this.listKind.equalsIgnoreCase("107")){
			this.isFilterRow = "1";
			this.isTotalRow  = "0";
			//this.isCheckBox  = "1";
			//this.isOperater  = "1";
			this.isStatusCol = "1";
			this.filterMode  = "2";
		} else if(!StringUtils.isEmpty(this.listKind) && this.listKind.equalsIgnoreCase("108")){
			this.isFilterRow = "1";
			this.isTotalRow  = "0";
			//this.isCheckBox  = "1";
			//this.isOperater  = "1";
			this.isStatusCol = "1";
			this.filterMode  = "2";
		}
		
		//替换字符
		if(!StringUtils.isEmpty(this.listBox)){
			this.listBox = this.listBox.replace('&', '!');
		}
	}
	
	/**
	 * 初始化构造列表
	 * 运用列表对应set方法赋属性值
	 * 
	 * @return
	 * @throws JspException
	 */
	public StringBuffer createGridStr() throws JspException
	{
		StringBuffer gridStr = new StringBuffer();
					 gridStr.append("<script>"+lineFlag);
					gridStr.append("var "+id+";"+lineFlag);
					gridStr.append("function createGrid(entityName,queryType,sortOnlyCol,pageStr,otherparams,wheres,filterParams,selectColNames,operPath){"+lineFlag);
					gridStr.append("		var url = \""+contextPath+queryPath+"\";"+lineFlag);
					gridStr.append("		if(operPath){");
					gridStr.append("			url = \""+contextPath+"\"+operPath;"+lineFlag);
					gridStr.append("		}");
					//gridStr.append("		alert(url);");
					gridStr.append("		otherparams = 'listType^"+this.listType+"@@@listKind^"+this.listKind+"@@@isOperater^"+this.isOperater+"@@@isTotalRow^"+this.isTotalRow+"@@@';"+lineFlag);//"+this.isTotal+"
					gridStr.append("		if(pageStr == null || pageStr=='undefined' || pageStr=='null' || pageStr==''){"+lineFlag);
					gridStr.append("			pageStr='1^"+this.pageItems+"';"+lineFlag);
					gridStr.append("		}"+lineFlag);
					gridStr.append("		var pars ='domainName="+entityName+"';"+lineFlag); 
					gridStr.append("			pars+='&queryType='+queryType;"+lineFlag);
					gridStr.append("			pars+='&pageStr='+pageStr;"+lineFlag);
					gridStr.append("			pars+='&sortOnlyCol='+sortOnlyCol;"+lineFlag);
					gridStr.append("			pars+='&otherparams='+otherparams;"+lineFlag);
					gridStr.append("			pars+='&wheres='+wheres;"+lineFlag);
					gridStr.append("			pars+='&filterParams='+filterParams;"+lineFlag);
					gridStr.append("			pars+='&selectColNames="+selectColNames+"';"+lineFlag);
					gridStr.append("			pars+='&editType="+editType+"';"+lineFlag);
					gridStr.append("			pars+='&colAlign="+colAlign+"';"+lineFlag);  
					gridStr.append("			pars+='&sortType="+sortType+"';"+lineFlag);
					gridStr.append("			pars+='&textColor="+textColor+"';"+lineFlag);
					gridStr.append("			pars+='&displayFormat="+displayFormat+"';"+lineFlag);
					gridStr.append("			pars+='&filterRules="+this.filterRules+"';"+lineFlag);
					gridStr.append("			pars+='&isTotal="+this.isTotal+"';"+lineFlag);
					gridStr.append("			pars+='&columnMove="+this.columnMove+"';"+lineFlag);
					gridStr.append("			pars+='&listBox="+this.listBox+"';"+lineFlag);
					gridStr.append("			pars+='&busName="+this.busName+"';"+lineFlag);
					gridStr.append("			pars+='&subName="+this.subName+"';"+lineFlag);
					gridStr.append("			pars+='&isFilter="+this.isFilterRow+"';"+lineFlag);
					gridStr.append("			pars+='&isOperater="+this.isOperater+"';"+lineFlag);
					gridStr.append("			pars+='&className="+this.className+"';"+lineFlag);
					gridStr.append("			pars+='&refName="+this.refName+"';"+lineFlag);
					gridStr.append("			pars+='&gridSign=1';"+lineFlag);
					gridStr.append("			pars+='&titleRownoImg="+this.opTitleRowImg+"';"+lineFlag);
					gridStr.append("		var myAjax = new Ajax.Request(encodeURI(url),{method: 'post', parameters: pars,  onComplete: function(originalRequest){ "+id+" = callBackGrid(originalRequest,'"+this.id+"','"+this.pageId+"','"+this.contextPath+"','"+this.imgUrl+"','"+this.pageItems+"','"+this.titleSelectImg+"','"+this.titleUNSelectImg+"','"+GridConstant.PAGE_IMAGE_PATH+"','"+this.isPageSet+"','"+this.isCheckBox+"','"+this.isMultiline+"','"+this.colValByList+"','"+this.titleRownoImg+"','"+this.skin+"','"+this.selectColNames+"','"+this.filterMode+"','"+this.listType+"','"+this.entityName+"','"+this.isTotalRow+"','"+this.isOperater+"','"+this.listKind+"','"+this.isOperater+"','"+this.isStatusCol+"','"+this.opColInfo+"','"+this.busName+"','"+this.subName+"','"+this.isQuerySet+"','"+this.updateable+"','"+this.refColVal+"');}, onLoading: loadContent('"+id+"','"+this.contextPath+GridConstant.PAGE_IMAGE_PATH+"') });"+lineFlag);
					gridStr.append("}");
					gridStr.append("createGrid('','0','','1^"+this.pageItems+"','','','','');"+lineFlag);
					gridStr.append("</script>"+lineFlag);
				    
					 
					 
		return gridStr;
	}
	
	/**
	 * 加载列表所需的DIV载体
	 * 
	 * @return
	 * @throws JspException
	 */
	public StringBuffer divStr() throws JspException
	{
		StringBuffer divStr = new StringBuffer();
					divStr.append("<script>");
					divStr.append("		var gridTag = new gridTagHelper('"+this.id+"','"+this.divWidth+"','"+this.divHeight+"','"+this.isDisplaySet+"','"+this.isQuerySet+"','"+this.isOutputSet+"','"+this.isStatSet+"','"+GridConstant.GRID_OTHER_PATH+"','"+GridConstant.PAGE_IMAGE_PATH+"');"+lineFlag);
					divStr.append("		gridTag.getHtmlStr();"+lineFlag);
					divStr.append("</script>");
		return divStr;
	}
	
	
	public int doAfterBody() throws JspException {
		
		htmlStr.append(bodyContent.getString());
        return 0;
    }
	
	/**
	 * 定义初始功能
	 */
	public int doStartTag() throws JspException 
	{
		htmlStr 		= new StringBuffer();
		contextPath 	= ((HttpServletRequest) pageContext.getRequest()).getContextPath();
		try 
		{
			this.opTitleRowImg      = "img:["+contextPath+GridConstant.GRID_IMAGE_PATH+"opButton.gif"+"]";
			this.titleRownoImg 		= "img:["+contextPath+GridConstant.GRID_IMAGE_PATH+"config.gif"+"]";
			this.titleSelectImg 	= "img:["+contextPath+GridConstant.GRID_IMAGE_PATH+"select.gif"+"]";
			this.titleUNSelectImg 	= "img:["+contextPath+GridConstant.GRID_IMAGE_PATH+"retract.gif"+"]";
			
			this.initParam();
			htmlStr.append(hiddenFieldStr().toString());
			//htmlStr.append(functionKey().toString());
			htmlStr.append(divStr().toString());
		} catch (Exception e) {
		}
		return (SKIP_BODY);
	}

	/**
	 * 
	 */
	public int doEndTag() throws JspException 
	{
		try 
		{
			htmlStr.append(styleStr().toString());
			htmlStr.append(createGridStr().toString());
			htmlStr.append(scriptStr().toString());
			pageContext.getOut().print(htmlStr.toString());

		} catch (Exception e) {
		}
		// TODO Auto-generated method stub
		return (EVAL_PAGE);
	}

	public void release() 
	{
		// TODO Auto-generated method stub
		super.release();
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

	public String getUpdateable() {
		return updateable;
	}

	public void setUpdateable(String updateable) {
		this.updateable = updateable;
	}

	public String getRefColVal() {
		return refColVal;
	}

	public void setRefColVal(String refColVal) {
		this.refColVal = refColVal;
	}
}
