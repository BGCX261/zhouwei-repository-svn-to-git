/**
 * 这是一个日期选择时间段的标签库.当选择开始日期的时候,结束日期不能选择它前面的日期,当选择结束日期的
 * 时候,开始日期不能选择它后面的日期.
 */
package com.techstar.framework.ui.web.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import org.apache.taglibs.standard.tag.el.core.ExpressionUtil;

import com.techstar.framework.ui.web.tag.utils.GridConstant;
/**
 * @author Administrator
 * 
 */
public class JHopDateSelectTag extends JHopBaseTag {

	/**
	 * 
	 * 标识文本框的名字
	 */
	private String name;
	/**
	 * 开始文本框的名字
	 */
	private String startName;

	/**
	 * 结束文本框的名字
	 */
	private String endName;

	/**
	 * 日期时间的格式
	 * 
	 * 
	 */
	private String dateFormat;

	/**
	 * 日期在文本框显示的初始值
	 * 
	 * 
	 */
	private String initValue;
	private String group;

	/**
	 * @return the group
	 */
	public String getGroup() {
		return group;
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
	 * @param group
	 *            the group to set
	 */
	public void setGroup(String group) {
		this.group = group;
	}

	/**
	 * @return the dateFormat
	 */
	public String getDateFormat() {
		return dateFormat;
	}

	/**
	 * @param dateFormat
	 *            the dateFormat to set
	 */
	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	/**
	 * @return the endName
	 */
	public String getEndName() {
		return endName;
	}

	/**
	 * @param endName
	 *            the endName to set
	 */
	public void setEndName(String endName) {
		this.endName = endName;
	}

	/**
	 * @return the startName
	 */
	public String getStartName() {
		return startName;
	}

	/**
	 * @param startName
	 *            the startName to set
	 */
	public void setStartName(String startName) {
		this.startName = startName;
	}
	/**
	 * 
	 */
	private boolean showSecond;
	/**
	 * @return the showSecond
	 */
	public boolean isShowSecond() {
		return showSecond;
	}

	/**
	 * @param showSecond the showSecond to set
	 */
	public void setShowSecond(boolean showSecond) {
		this.showSecond = showSecond;
	}

	/**
	 * 获得开始日期事件发生源的id
	 */
	private String getEventStartStrId() {
		String textId = "";
		if (this.group.equals("start")) {
			this.startName = this.name;
			textId = "event" + this.startName;
		}
		if (this.group.equalsIgnoreCase("end")) {
			textId = "event" + this.startName;

		}
		return textId;
	}

	/**
	 * 获得结束事件发生源的id
	 */
	private String getEventEndStrId() {
		String textId = "";
		if (this.group.equals("start")) {
			textId = "event" + this.endName;
		}
		if (this.group.equalsIgnoreCase("end")) {
			this.endName = this.name;
			textId = "event" + this.endName;
		}
		return textId;
	}
	/**
	 * @param eventId
	 *            the eventId to set
	 */

	public String getInitValue() {
		return initValue;
	}

	public void setInitValue(String string) {
		if (null != string && string.indexOf("<c:out") >= 0
				&& string.indexOf("${") >= 0) {
			String value_ = string.substring(string.indexOf("${"), string
					.indexOf("}") + 1);
			try {
				initValue = (String) ExpressionUtil.evalNotNull("out", "value",
						value_, String.class, this, pageContext);
			} catch (JspException jex) {
				initValue = string;
			}
		} else {
			initValue = string;
		}
	}

	/**
	 * 生成HTML文件
	 */
	public String getDivHtml() {
		if (this.initValue == null)
			this.initValue = "";
		StringBuffer htmlStr = new StringBuffer("");
		String strValue="";
		if(showSecond)
		{
			htmlStr.append("<script> function eventChangeValue(Id,Id1){"
					+" var v=document.getElementById(Id);var v1=document.getElementById(Id1);"
					+" changeValue=v1.value;if(v1.value!=null)	{	" 
					+"changeValue=changeValue+':01.0';}v.value=changeValue;}</script>");
			strValue=this.initValue;
			if(strValue!=null&&strValue.trim().length()>0)
			{
				strValue=strValue.substring(0,16);
			}
		}
		if (this.group.equalsIgnoreCase("start")) {

			if(showSecond)
			{
				htmlStr.append("<input type='text'" + " name='" + this.name + "_1' "
						+ " id='" + this.getEventStartStrId() + "_1' value='"
						+ strValue + "'");
				htmlStr.append(" size=\"20\"   onpropertychange=\"eventChangeValue('" + this.getEventStartStrId() + "','" + this.getEventStartStrId() + "_1')\"/>");
				htmlStr.append("<input type='hidden'" + " name='" + this.name + "' "
						+ " id='" + this.getEventStartStrId() + "' value='"
						+ this.initValue + "'");
				htmlStr.append(" size=\"20\"   />");
				htmlStr.append("&nbsp;");
				
				htmlStr.append("<img src='" + contextPath
						+ GridConstant.PAGE_IMAGE_PATH+"data.gif'");
				htmlStr.append(" name=\"ss\" "
						+ "' border=\"0\" style=\"cursor:hand\" ");
				htmlStr.append("  onclick=\"return showBeginCalendar('"
						+ this.getEventStartStrId() + "_1','"
						+ this.getEventEndStrId() + "_1', " + "'" + this.dateFormat
						+ "'" + ");\" ");
				htmlStr.append("/>");
			}
			else
			{
				htmlStr.append("<input type='text'" + " name='" + this.name + "' "
						+ " id='" + this.getEventStartStrId() + "' value='"
						+ this.initValue + "'");
				htmlStr.append(" size=\"20\"   />");
				htmlStr.append("&nbsp;");
				htmlStr.append("<img src='" + contextPath
						+ GridConstant.PAGE_IMAGE_PATH+"data.gif'");
				htmlStr.append(" name=\"ss\" "
						+ "' border=\"0\" style=\"cursor:hand\" ");
				htmlStr.append("  onclick=\"return showBeginCalendar('"
						+ this.getEventStartStrId() + "','"
						+ this.getEventEndStrId() + "', " + "'" + this.dateFormat
						+ "'" + ");\" ");
				htmlStr.append("/>");
			}


		}
		if (this.group.equalsIgnoreCase("end")) {
			if(showSecond)
			{
				htmlStr.append("<input type='text'" + " name='" + this.name + "_1'"
						+ " id='" + this.getEventEndStrId() + "_1' value='"
						+ strValue + "'");
				htmlStr.append(" size=\"20\"  onpropertychange=\"eventChangeValue('" + this.getEventEndStrId() + "','" + this.getEventEndStrId() + "_1')\"/>");
				htmlStr.append("<input type='hidden'" + " name='" + this.name + "'"
						+ " id='" + this.getEventEndStrId() + "' value='"
						+ this.initValue + "'");
				htmlStr.append(" size=\"20\"   />");
				htmlStr.append("&nbsp;");
				htmlStr.append("<img src='" + contextPath
						+ GridConstant.PAGE_IMAGE_PATH+"data.gif'");
				htmlStr.append(" name=\"ss\" "
						+ "' border=\"0\" style=\"cursor:hand\"");
				htmlStr.append(" onclick=\"return showEndCalendar('"
						+ this.getEventStartStrId() + "_1','"
						+ this.getEventEndStrId() + "_1', " + "'" + this.dateFormat
						+ "'" + ");\"");
				htmlStr.append("/>");
			}
			else 
			{
				htmlStr.append("<input type='text'" + " name='" + this.name + "'"
						+ " id='" + this.getEventEndStrId() + "' value='"
						+ this.initValue + "'");
				htmlStr.append(" size=\"20\"   />");
				htmlStr.append("&nbsp;");
				htmlStr.append("<img src='" + contextPath
						+ GridConstant.PAGE_IMAGE_PATH+"data.gif'");
				htmlStr.append(" name=\"ss\" "
						+ "' border=\"0\" style=\"cursor:hand\"");
				htmlStr.append(" onclick=\"return showEndCalendar('"
						+ this.getEventStartStrId() + "','"
						+ this.getEventEndStrId() + "', " + "'" + this.dateFormat
						+ "'" + ");\"");
				htmlStr.append("/>");
			}


		}
		return htmlStr.toString();
	}

	public int doStartTag() throws JspException {
		try {
			contextPath = ((HttpServletRequest) pageContext.getRequest())
					.getContextPath();
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
		startName = null;
		dateFormat = null;
		endName = null;
	}

}