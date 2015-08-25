package com.techstar.framework.ui.web.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;

import org.apache.commons.lang.StringUtils;
import org.apache.taglibs.standard.tag.el.core.ExpressionUtil;

import com.techstar.framework.ui.web.tag.utils.GridConstant;

import java.util.*;

/**
 * 下拉列表控件
 */
public class JHopSelectTag extends JHopBaseTag 
{
	/**
	 * 文本框的id
	 */
	private String name;
	
	/**
	 * 类型
	 */
	private String type;
	
	/**
	 * 
	 */
	private String hiddName;
	
	/**
	 * 父ID(级联菜单使用)
	 */
	private String parentId;
	
	/**
	 *  Select框的初始值

	 */
	private String initValue;
	
	/**
	 * 
	 */
	private String iframePath;

	/**
	 * 图像文件路径
	 */
	private String imageSrc;

	/**
	 * 下拉列表数据源

	 */
	private Map dataMap;
	
	/**
	 * 是否为多选下拉框
	 */
	private String checkBox;
	
	/**
	 * 是否有回调函数
	 */
	private String func;
	
	/**
	 * 子类框名
	 */
	private String clearObj;

	/**
	 * @return the imageSrc
	 */
	public String getImageSrc() 
	{
		return imageSrc;
	}

	/**
	 * @param imageSrc
	 *            the imageSrc to set
	 */
	public void setImageSrc(String imageSrc) 
	{
		this.imageSrc = imageSrc;
	}

	/**
	 * @return the inputId
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param inputId
	 *            the inputId to set
	 */
	public void setName(String inputId) 
	{
		this.name = inputId;
	}
	
	/**
	 * @param parentId
	 *            the inputId to set
	 */
	public String getParentId() 
	{
		return parentId;
	}
	
	/**
	 * @param parentId
	 *            the inputId to set
	 */
	public void setParentId(String parentId) 
	{
		this.parentId = parentId;
	}

	/**
	 * @param type
	 *            the inputId to set
	 */
	public String getType() 
	{
		return type;
	}

	/**
	 * @param type
	 *            the inputId to set
	 */
	public void setType(String type) 
	{
		this.type = type;
	}
	
	/**
	 * @param iframePath
	 *            the inputId to set
	 */
	public String getIframePath() 
	{
		return iframePath;
	}

	/**
	 * @param iframepath
	 *            the inputId to set
	 */
	public void setIframePath(String iframePath) 
	{
		this.iframePath = iframePath;
	}
	
	public String getInitValue() 
	{
		return initValue;
	}

	public void setInitValue(String initValue) 
	{
		if (null != initValue && initValue.indexOf("<c:out") >= 0

	              && initValue.indexOf("${") >= 0) {

	           String value_ = initValue.substring(initValue.indexOf("${"), initValue

	                  .indexOf("}") + 1);

	           try {

	              initValue = (String) ExpressionUtil.evalNotNull("out", "value",

	                     value_, String.class, this, pageContext);

	           } catch (JspException jex) {

	              initValue = initValue;

	           }

	       } else {

	           initValue = initValue;

	       }

		this.initValue = initValue;
	}

	public String getStyle() 
	{
		StringBuffer 	strbuffer = new StringBuffer("");
						strbuffer.append("");
		return strbuffer.toString();
	}
	public String getScript() 
	{        
		StringBuffer 	strbuffer = new StringBuffer("");
						strbuffer.append("");
		return strbuffer.toString();
	}

	/**
	 * 生成带层下拉列表
	 */
	private String getDivHtml() 
	{
		String textValue = "";
		String initStr   = "";
		this.contextPath =  ((HttpServletRequest)pageContext.getRequest()).getContextPath();
		//imageSrc 	 = contextPath+"/themes/themes1/images/main/listbox.jpg";
		imageSrc 	 = contextPath+GridConstant.PAGE_IMAGE_PATH+"find.gif";
		if(this.parentId == null)
		{
			this.parentId = "";
		}
		if(!StringUtils.isEmpty(this.initValue)){
			if(this.initValue.indexOf("@@@") != -1){
				String[] initArray =  this.initValue.split("@@@");
				if(initArray.length == 2){
					textValue = initArray[0];
					initStr	  = initArray[1];
				}
			} else {
				textValue = this.initValue;
				initStr   = "";
			}
		}
		String divId = "Div" + this.name;
		StringBuffer 	strBuffer = new StringBuffer("");
						//strBuffer.append(this.getStyle());
						//strBuffer.append(this.getScript());
						strBuffer.append("	<input name='"+this.name+"'  type=\"text\" class=\"input1\" align=\"baseline\" height=\"19\" value='"+textValue+"' >");
						strBuffer.append(" 	<img src=\""+imageSrc+"\" border=\"0\" align=\"baseline\" onClick=\"displaySysSelect('"+type+"','"+this.parentId+"','"+this.name+"','"+this.name+"','"+this.hiddName+"','"+initStr+"','"+this.checkBox+"','"+this.func+"','"+this.clearObj+"')\"/>");		
		return strBuffer.toString();
	}

	public int doStartTag() throws JspException {
		try {
			pageContext.getOut().print(this.getDivHtml());
		} catch (Exception e) {
		}

		return (SKIP_BODY);
	}

	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub

		return (EVAL_PAGE);
	}

	public void release() {
		// TODO Auto-generated method stub
		super.release();
		name = null;
		imageSrc = null;
	}

	public String getHiddName() {
		return hiddName;
	}

	public void setHiddName(String hiddName) {
		this.hiddName = hiddName;
	}

	public String getCheckBox() {
		return checkBox;
	}

	public void setCheckBox(String checkBox) {
		this.checkBox = checkBox;
	}

	public String getClearObj() {
		return clearObj;
	}

	public void setClearObj(String clearObj) {
		this.clearObj = clearObj;
	}

	public String getFunc() {
		return func;
	}

	public void setFunc(String func) {
		this.func = func;
	}

}
