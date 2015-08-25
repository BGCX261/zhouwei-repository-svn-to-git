package com.techstar.framework.ui.entity;

public class TreeTagProperty {

	
	private String jhoptree="";
	private String divid="";//divId 页面存放树的div的Id
	private String width = "";//树的宽；
	private String height = "";//树的高；
	private String treeid ="";//树的根节点的id;
	private String imgpath = "";//图片的路径


	private String leaftimg = "" ;//叶节点的图片；


	private String closeimg = "";//目录关上时的图片；


	private String openimg = "";//目录打开时的图片；


	private String treedisname ="";//对应的描述文件里树描述对象的名称
	private String nodedisname = "";//对应的描述文件里节点描述对象的名称


	private String dragFlag ="";//是否支持拖拽 true /false
	private String checkboxflag =""; //是否支持多选 0:不支持 1：不支持连带的多选 2：支持连带的多选

	private String userdate = "";//初始化时传入的值

    
	private String clickHandler = ""; //点击事件函数
	private String dropHandler = "";//拖拽事件函数
	
	private String queryPath ="";//生成树的web路径
	//divid, width, height, treeid, querypath,imgpath, leaftimg, closeimg, openimg, treedisname, nodedisname, DragFlag,checkboxflag,userdate,requestpath,onclick,ondrop,loadingimgpath
	private String loadingimgpath="";//动态加载时客户端等待的图片
	private String datasxml="";//xml数据
	public String getCheckboxflag() {
		return checkboxflag;
	}
	public void setCheckboxflag(String checkboxflag) {
		this.checkboxflag = checkboxflag;
	}
	public String getClickHandler() {
		return clickHandler;
	}
	public void setClickHandler(String clickHandler) {
		this.clickHandler = clickHandler;
	}
	public String getCloseimg() {
		return closeimg;
	}
	public void setCloseimg(String closeimg) {
		this.closeimg = closeimg;
	}
	public String getDivid() {
		return divid;
	}
	public void setDivid(String divid) {
		this.divid = divid;
	}
	public String getDragFlag() {
		return dragFlag;
	}
	public void setDragFlag(String dragFlag) {
		this.dragFlag = dragFlag;
	}
	public String getDropHandler() {
		return dropHandler;
	}
	public void setDropHandler(String dropHandler) {
		this.dropHandler = dropHandler;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	public String getJhoptree() {
		return jhoptree;
	}
	public void setJhoptree(String jhoptree) {
		this.jhoptree = jhoptree;
	}
	public String getLeaftimg() {
		return leaftimg;
	}
	public void setLeaftimg(String leaftimg) {
		this.leaftimg = leaftimg;
	}
	public String getLoadingimgpath() {
		return loadingimgpath;
	}
	public void setLoadingimgpath(String loadingimgpath) {
		this.loadingimgpath = loadingimgpath;
	}
	public String getNodedisname() {
		return nodedisname;
	}
	public void setNodedisname(String nodedisname) {
		this.nodedisname = nodedisname;
	}
	public String getOpenimg() {
		return openimg;
	}
	public void setOpenimg(String openimg) {
		this.openimg = openimg;
	}
	public String getQueryPath() {
		return queryPath;
	}
	public void setQueryPath(String queryPath) {
		this.queryPath = queryPath;
	}
	public String getTreedisname() {
		return treedisname;
	}
	public void setTreedisname(String treedisname) {
		this.treedisname = treedisname;
	}
	public String getTreeid() {
		return treeid;
	}
	public void setTreeid(String treeid) {
		this.treeid = treeid;
	}
	public String getUserdate() {
		return userdate;
	}
	public void setUserdate(String userdate) {
		this.userdate = userdate;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	
	public String getDatasxml() {
		return datasxml;
	}
	public void setDatasxml(String datasxml) {
		this.datasxml = datasxml;
	}

	
	
}
