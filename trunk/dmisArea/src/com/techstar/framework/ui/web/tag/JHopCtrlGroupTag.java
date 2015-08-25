/**
 *  这个类是处理表格折叠的
 */
package com.techstar.framework.ui.web.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;

import org.apache.commons.lang.StringUtils;

import com.techstar.framework.ui.web.tag.utils.GridConstant;

/**
 * @author Administrator
 * 
 */
public class JHopCtrlGroupTag extends JHopBaseTag {
	/**
	 * 表格的标题头名称
	 */
	private String title;

	/**
	 * 控制的div区域Id
	 */
	private String ctrlId;

	/**
	 * 初始展开状态 ０--为展开 １－－－折叠 初始为０
	 */
	private String status = "0";

	/**
	 * javascript片段
	 */
	private String scriptStr;

	/**
	 * 是否生成按钮
	 */
	private String isEdit;

	/**
	 * 所执行动作的名字
	 * 
	 */
	private String name;

	/**
	 * @return the isEdit
	 */
	public String getIsEdit() {
		return isEdit;
	}

	/**
	 * @param isEdit
	 *            the isEdit to set
	 */
	public void setIsEdit(String isEdit) {
		this.isEdit = isEdit;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the scriptStr
	 */
	public String getScriptStr() {

		return scriptStr;

	}

	/**
	 * @param scriptStr
	 *            the scriptStr to set
	 */
	public void setScriptStr(String scriptStr) {
		this.scriptStr = scriptStr;
	}

	/**
	 * @return the ctrlId
	 */
	public String getCtrlId() {
		return ctrlId;
	}

	/**
	 * @param ctrlId
	 *            the ctrlId to set
	 */
	public void setCtrlId(String ctrlId) {
		this.ctrlId = ctrlId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 标题头的显示
	 */
	public String getHead() {
		StringBuffer buffer = new StringBuffer("");
		String bodyStr = getBodyContent().getString(); // 获得标签体内容
		
		 
		if(bodyStr==null) bodyStr="";
		if (this.isEdit != null && this.isEdit.equalsIgnoreCase("yes")) {
			
			String saveImg = contextPath + GridConstant.PAGE_IMAGE_PATH+"save.gif";
			String delImg = contextPath
					+ GridConstant.PAGE_IMAGE_PATH+"delete.gif";
//			String styleStr = "<style>               			";
//			styleStr += "#save															 ";
//			styleStr += "{	 cursor:pointer	;													 ";
//			styleStr += "	position: absolute; 												 ";
//			styleStr += "	right:60px; 												 ";
//			styleStr += "	border-style:none;	 											 ";
//			styleStr += "   margin-top:1px;         }																	 ";
//
//			styleStr += "#del														 ";
//			styleStr += "{	 cursor:pointer	;															 ";
//			styleStr += "	position: absolute; 												 ";
//			styleStr += "	right:37px; 												 ";
//			styleStr += "	border-style:none;											 ";
//			styleStr += "     margin-top:1px; 	                                  }																	 ";
//			styleStr += "</style>";
			
			String styleStr = "<style>               			";
			styleStr += ".imgCtrl															 ";
			styleStr += "{	 cursor:pointer	;													 ";
			styleStr += "	 											 ";
			styleStr += "	margin-top:2px;												 ";
			styleStr += "	margin-left:1px;												 ";
			styleStr += "	margin-right:1px;												 ";
			styleStr += "	margin-bottom:auto;												 ";
			styleStr += "	border-style:none;	 											 ";
			styleStr += "    }  ";
			styleStr += "</style>";
			
			String styleTh="border-style:none;";
			
			buffer.append("<div>");
			
			buffer
					.append("<table class='detailmain'  cellspacing='0' cellpadding='0' >");
			buffer.append(" <tr id='wo'>");
			buffer
					.append("<th colspan=\"3\" class=\"pt\" align=\"left\"  style=\"height:20;border-style:none;\">");
			buffer.append("<a>");
			buffer
					.append(" <img  border='0px' style='cursor:pointer' src='"
							+ contextPath
							+ GridConstant.PAGE_IMAGE_PATH+"zd_gray2.gif'  onclick=\"popDiv("
							+ this.getCtrlId() + " ,this)\">");
			buffer.append("</a>");
			
			buffer.append("&nbsp;" + this.getTitle());
			buffer.append(styleStr);
			//buffer.append(styleStr);
//			buffer.append("<img id='save' border='0px'  src='" + saveImg
//					+ "' onclick=\"save" + this.name + "();\" " + "   />");
//
//			buffer.append("&nbsp;");
//			buffer.append("&nbsp;");
//			buffer.append("&nbsp;");
//			
//			buffer.append("<img id='del' border='0px'  src='" + delImg
//					+ "' onclick=\" delete" + this.name + "();\" " + "   />");
			
			buffer.append("</th>");
			String [] img=bodyStr.split("<img");
			for(int i=1; i<img.length;i++){
		    	String classStr="class='imgCtrl'";
		    	
		    	String imgStr="<img "+classStr+img[i];
//		    	System.out.println(imgStr);
		    	buffer
				.append("<th    class=\"pt\"   style=\" height:20px;width:20px; border-style:none;\" >");
				buffer.append("<a>");
				buffer.append(imgStr);
				buffer.append("</a>");
				buffer.append("</th>");
		    }
			
			buffer
			.append("<th    class=\"pt\"   style=\" height:20px;width:10px; border-style:none;\" >");
			buffer.append("<a>");
			buffer.append("</a>");
			buffer.append("</th>");
			
		    buffer.append("</tr>");
			buffer.append("</table>");
			buffer.append("</div>");

		} else {
			buffer.append("<div>");
			buffer
					.append("<table  class='detailmain'  cellspacing='0' cellpadding='0'>");
			buffer.append(" <tr>");
			buffer
					.append("<th colspan=\"3\" class=\"pt\" align=\"left\" height=\"20\">");
			buffer.append("<a>");
			buffer.append("");
			buffer
					.append("<img   border='0px' style='cursor:pointer' src='"
							+ contextPath
							+ GridConstant.PAGE_IMAGE_PATH+"zd_gray2.gif'  onclick=\"popDiv("
							+ this.getCtrlId() + " ,this)\">");
			buffer.append("</a>");
			buffer.append("&nbsp;" + this.getTitle());
			//buffer.append(bodyStr);
			buffer.append("</th>");
			buffer.append("</tr>");
			buffer.append("</table>");
			buffer.append("</div>");
		}
		 
		return buffer.toString();
	}

	/**
	 * 输出html代码
	 */
	public String getDivHtml() {
		StringBuffer htmlStr = new StringBuffer("");
		htmlStr.append(getHead());
		return htmlStr.toString();
	}

	public int doStartTag() throws JspException {
		
		return (EVAL_BODY_BUFFERED);
	}

	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		try {
			contextPath = ((HttpServletRequest) pageContext.getRequest())
			.getContextPath();
			 pageContext.getOut().print(this.getDivHtml());	
		} catch (Exception e) {
		}

		return (EVAL_PAGE);
	}
}
