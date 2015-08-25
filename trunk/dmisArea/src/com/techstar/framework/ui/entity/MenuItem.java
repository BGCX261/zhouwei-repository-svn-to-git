package com.techstar.framework.ui.entity;

import java.util.List;

public class MenuItem {
	/**
	 * <MenuItem Text="DEMO" id="demo">
 		<MenuItem Text="UI控件" src="" id="demo0" href="/ui.do?method=initFrame" title="UI控件">
		</MenuItem>
		<MenuItem Text="工具栏+普通数据页" src="" id="demo1" href="/rijihua.do?method=initFrame1">
		</MenuItem>
 
	 	<MenuItem Text="工具栏+Tab页" src="" id="demo2" href="/rijihua.do?method=initFrame2">
		</MenuItem>
		<MenuItem Text="树+普通数据页" src="" id="demo3" href="/rijihua.do?method=initFrame3">
		</MenuItem> 
	</MenuItem>
	 */
	private String text="";//显示名称
	private String id="";//item id
	private String href="";//点击时候的联接
	private String title="";//鼠标悬停显示的信息
	private List children;//子菜单
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List getChildren() {
		return children;
	}
	public void setChildren(List children) {
		this.children = children;
	}
	
	

}
