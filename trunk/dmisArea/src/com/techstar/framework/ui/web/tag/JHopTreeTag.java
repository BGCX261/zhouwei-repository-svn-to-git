package com.techstar.framework.ui.web.tag;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import com.techstar.framework.ui.entity.TreeTagProperty;

public class JHopTreeTag extends BodyTagSupport{
	//treeutil = new treeutil('org','100%','100%','zys','"+contextPath+"/themes/themes1/images/tree/','leaf.gif','books_close.gif','books_open.gif','tree1','proresource',true,true)
	private String jhoptree;
	private String divid ;//divId 页面存放树的div的Id
	private String width = "100%";//树的宽；
	private String height = "100%";//树的高；
	private String treeid;//树的根节点的id;
	private String imgpath = "/themes/themes1/images/tree/";//图片的路径

	private String leaftimg = "leaf.gif" ;//叶节点的图片；

	private String closeimg = "books_close.gif";//目录关上时的图片；

	private String openimg = "books_open.gif";//目录打开时的图片；

	private String treedisname;//对应的描述文件里树描述对象的名称
	private String nodedisname;//对应的描述文件里节点描述对象的名称

	private String dragFlag = "false";//是否支持拖拽 true /false
	private String checkboxflag = "0"; //是否支持多选 0:不支持 1：支持连带的多选 2：支持连带的多选
	private String userdate = "";//初始化时传入的值
    
	private String clickHandler = ""; //点击事件函数
	private String dropHandler = "";//拖拽事件函数
	
	private String queryPath ="";//生成树的web路径
	//divid, width, height, treeid, querypath,imgpath, leaftimg, closeimg, openimg, treedisname, nodedisname, DragFlag,checkboxflag,userdate,requestpath,onclick,ondrop,loadingimgpath
	private String loadingimgpath="/themes/themes1/images/tree/loading.gif";
	private TreeTagProperty tagProperty;
	private String datasxml="";
	public String getCheckboxflag() {
		return checkboxflag;
	}

	public void setCheckboxflag(String checkboxflag) {
		this.checkboxflag = checkboxflag;
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

	public String getLeaftimg() {
		return leaftimg;
	}

	public void setLeaftimg(String leaftimg) {
		this.leaftimg = leaftimg;
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
    
	
	public String getClickHandler() {
		return clickHandler;
	}

	public void setClickHandler(String clickHandler) {
		this.clickHandler = clickHandler;
	}

	public String getDropHandler() {
		return dropHandler;
	}

	public void setDropHandler(String dropHandler) {
		this.dropHandler = dropHandler;
	}

	public String getQueryPath() {
		return queryPath;
	}

	public void setQueryPath(String queryPath) {
		this.queryPath = queryPath;
	}


	public String getLoadingimgpath() {
		return loadingimgpath;
	}

	public void setLoadingimgpath(String loadingimgpath) {
		this.loadingimgpath = loadingimgpath;
	}
	
	/*
	 *  creTree('org','100%','100%','zys','/treefacade.do?method=getTreeNodes','/framework/themes/themes1/images/tree/','leaf.gif','books_close.gif','books_open.gif','tree1','proresource',true,true,"",oncl,changeParent,"<%=request.getContextPath()%>/themes/themes1/images/tree/loading.gif");
	 */
	
	private String getHtml(){
		String contextPath =((HttpServletRequest) pageContext.getRequest()).getContextPath();
		/**
		 *如果TreeTagProperty 不为空把标签里相应的属性替换为TreeTagProperty的属性
		 */
		if(tagProperty!=null){
			if(tagProperty.getJhoptree()!=null&&!tagProperty.getJhoptree().equals(""))
				jhoptree = tagProperty.getJhoptree();
			if(tagProperty.getDivid()!=null&&!tagProperty.getDivid().equals(""))
				divid = tagProperty.getDivid();
			if(tagProperty.getWidth()!=null&&!tagProperty.getWidth().equals(""))
				width = tagProperty.getWidth();
			if(tagProperty.getHeight()!=null&&!tagProperty.getHeight().equals(""))
				height = tagProperty.getHeight();
			if(tagProperty.getTreeid()!=null&&!tagProperty.getTreeid().equals(""))
				treeid = tagProperty.getTreeid();
			if(tagProperty.getImgpath()!=null&&!tagProperty.getImgpath().equals(""))
				imgpath = tagProperty.getImgpath();
			if(tagProperty.getLeaftimg()!=null&&!tagProperty.getLeaftimg().equals(""))
				leaftimg = tagProperty.getLeaftimg();
			if(tagProperty.getCloseimg()!=null&&!tagProperty.getCloseimg().equals(""))
				closeimg = tagProperty.getCloseimg();
			if(tagProperty.getOpenimg()!=null&&!tagProperty.getOpenimg().equals(""))
				openimg = tagProperty.getOpenimg();
			if(tagProperty.getTreedisname()!=null&&!tagProperty.getTreedisname().equals(""))
				treedisname = tagProperty.getTreedisname();
			if(tagProperty.getNodedisname()!=null&&!tagProperty.getNodedisname().equals(""))
				nodedisname = tagProperty.getNodedisname();
			if(tagProperty.getDragFlag()!=null&&!tagProperty.getDragFlag().equals(""))
				dragFlag = tagProperty.getDragFlag();
			if(tagProperty.getCheckboxflag()!=null&&!tagProperty.getCheckboxflag().equals(""))
				checkboxflag = tagProperty.getCheckboxflag();
			if(tagProperty.getUserdate()!=null&&!tagProperty.getUserdate().equals(""))
				userdate = tagProperty.getUserdate();
			if(tagProperty.getClickHandler()!=null&&!tagProperty.getClickHandler().equals(""))
				clickHandler = tagProperty.getClickHandler();
			if(tagProperty.getDropHandler()!=null&&!tagProperty.getDropHandler().equals(""))
				dropHandler = tagProperty.getDropHandler();
			if(tagProperty.getQueryPath()!=null&&!tagProperty.getQueryPath().equals(""))
				queryPath = tagProperty.getQueryPath();
			if(tagProperty.getLoadingimgpath()!=null&&!tagProperty.getLoadingimgpath().equals(""))
				loadingimgpath = tagProperty.getLoadingimgpath();
			if(tagProperty.getDatasxml()!=null&&!tagProperty.getDatasxml().equals(""))
				datasxml = tagProperty.getDatasxml();
			
			
		}
		//imgpath = contextPath+imgpath;
		String newImgpath=contextPath+imgpath;
		//loadingimgpath = contextPath+loadingimgpath;
		String newLoadingimgpath = contextPath+loadingimgpath;
		//queryPath = contextPath+queryPath;
		String newQueryPath =  contextPath+queryPath;
		String html = "";
		html +="<script>"+"\n";
		html += "var "+jhoptree+"=creTree('"+divid+"','"+width+"','"+height+"','"+treeid+"','"+newQueryPath+"','"+newImgpath+"','"+leaftimg+"','"+closeimg+"','"+openimg+"','"+treedisname+"','"+nodedisname+"',"+dragFlag+","+checkboxflag+",'"+userdate+"','"+clickHandler+"','"+dropHandler+"','"+newLoadingimgpath+"',\""+datasxml+"\");"+"\n";
		html +="</script>";
		System.out.println(html);
		return html;
	}
	
	public int doStartTag() throws JspException {
		try {
			pageContext.getOut().print(this.getHtml());
			
			
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
		//name = null;
		//dateFormat = null;
		//genText = null;
		
	    

	}

	public String getJhoptree() {
		return jhoptree;
	}

	public void setJhoptree(String jhoptree) {
		this.jhoptree = jhoptree;
	}

	public TreeTagProperty getTagProperty() {
		return tagProperty;
	}

	public void setTagProperty(TreeTagProperty tagProperty) {
		this.tagProperty = tagProperty;
	}

	public String getDatasxml() {
		return datasxml;
	}

	public void setDatasxml(String datasxml) {
		this.datasxml = datasxml;
	}





	
}
