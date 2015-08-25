 /**
 * 这是一个标签类的公共基类
 */
package com.techstar.framework.ui.web.tag;

import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.JspException;

/**
 * @author Administrator
 * 
 */
public class JHopBaseTag extends BodyTagSupport {
	// 一些公共的属性方法
	/**
	 * 项目完整路径
	 */
	protected String contextPath;

	/**
	 * title属性,组件中的文本提示信息
	 */
	protected String title;

	/**
	 * 设定的快捷键
	 */
	protected String accesskey = null;

	/**
	 * Tab 键的顺序值
	 */
	protected String tabindex = null;

	/**
	 *  html元素的style属性
	 */
	protected String style = null;

	/**
	 * html元素的css相关的class属性
	 */
	protected String styleClass = null;

	/**
	 * <text>高属性
	 */
	protected String height;

	/**
	 * <text>宽属性
	 */
	protected String width;

	/**
	 * 指定分配css style的html元素的id属性.
	 */
	protected String styleId = null;

	/**
	 * 补充字串,这个字符串是对未设置标签属性的补充,它一定要符合html的规范.
	 */
	protected String addStr = null;

	/**
	 * @return the accesskey
	 */
	public String getAccesskey() {
		return accesskey;
	}

	/**
	 * @param accesskey the accesskey to set
	 */
	public void setAccesskey(String accesskey) {
		this.accesskey = accesskey;
	}

	/**
	 * @return the addStr
	 */
	public String getAddStr() {
		return addStr;
	}

	/**
	 * @param addStr the addStr to set
	 */
	public void setAddStr(String addStr) {
		this.addStr = addStr;
	}

	/**
	 * @return the contextPath
	 */
	public String getContextPath() {
		return contextPath;
	}

	/**
	 * @param contextPath the contextPath to set
	 */
	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

	/**
	 * @return the style
	 */
	public String getStyle() {
		return style;
	}

	/**
	 * @param style the style to set
	 */
	public void setStyle(String style) {
		this.style = style;
	}

	/**
	 * @return the styleClass
	 */
	public String getStyleClass() {
		return styleClass;
	}

	/**
	 * @param styleClass the styleClass to set
	 */
	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}

	/**
	 * @return the styleId
	 */
	public String getStyleId() {
		return styleId;
	}

	/**
	 * @param styleId the styleId to set
	 */
	public void setStyleId(String styleId) {
		this.styleId = styleId;
	}

	/**
	 * @return the tabindex
	 */
	public String getTabindex() {
		return tabindex;
	}

	/**
	 * @param tabindex the tabindex to set
	 */
	public void setTabindex(String tabindex) {
		this.tabindex = tabindex;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the height
	 */
	public String getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(String height) {
		this.height = height;
	}

	/**
	 * @return the width
	 */
	public String getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(String width) {
		this.width = width;
	}

	public void release() {
		super.release();
		accesskey = null;
		tabindex = null;
		title = null;
		addStr = null;
	}

	/**
	 * 
	 * 给定一个名字和值,形成 name="value"的格式
	 * 
	 * @param handlers
	 *            The StringBuffer that output will be appended to.
	 */
	protected void prepareAttribute(StringBuffer handlers, String name,
			Object value) {
		if (value != null) {
			handlers.append(" ");
			handlers.append(name);
			handlers.append("=\"");
			handlers.append(value);
			handlers.append("\"");
		}
	}

	/**
	 * 处理包含在html标记中的样式表属性
	 * @return The prepared String for inclusion in the HTML tag.
	 * @throws JspException if invalid attributes are specified
	 */
	protected String prepareStyles() throws JspException {
		StringBuffer styles = new StringBuffer();
		prepareAttribute(styles, "id", getStyleId());
		prepareAttribute(styles, "style", getStyle());
		prepareAttribute(styles, "class", getStyleClass());
		prepareAttribute(styles, "title", getTitle());
		return styles.toString();
	}

	/**
	 * 其附加的字符串属性
	 * */
	protected void prepareOtherAttributes(StringBuffer handlers) {
		handlers.append(addStr);
	}
}
