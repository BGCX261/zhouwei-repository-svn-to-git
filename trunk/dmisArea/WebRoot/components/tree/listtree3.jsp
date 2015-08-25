
<%@ page contentType="text/html; charset=utf-8" language="java"  %>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
   <link href="<%=request.getContextPath()%>/themes/themes1/style.css" rel="stylesheet" type="text/css" />
	<script  src="<%=request.getContextPath()%>/script/dhtmlXCommon.js"></script>
	<script  src="<%=request.getContextPath()%>/script/tag/tree/dhtmlXTree.js"></script>
	<script  src="<%=request.getContextPath()%>/script/tag/tree/dhtmlXTree_xw.js"></script>
	<script  src="<%=request.getContextPath()%>/script/tag/tree/dhtmlXTree_li.js"></script>	
	<script  src="<%=request.getContextPath()%>/script/tag/tree/jhoptree.js"></script>>
	<!--  script  src="<%=request.getContextPath()%>/script/tree/treeutil.js"></script>-->
<title>
</title>
</head>

<body>
	<table>
		<tr>
			<td>
				<div id="treeboxbox_tree" style="width:250; height:500;background-color:#f5f5f5;border :1px solid Silver;; overflow:auto;"/>
			</td>
			<td rowspan="2" style="padding-left:25" valign="top">
		    <a href="javascript:void(0)" onclick="alert(getSelectedItemId(jhoptree));">得到选择的Id</a>
            <br/>
            <div>
            <a  href="javascript:void(0)" onclick="alert(getItemText(jhoptree,getSelectedItemId(jhoptree)));">得到选择节点的名称/a></div>
            <div>
            <a  href="javascript:void(0)" onclick="refreshItem(jhoptree,getSelectedItemId(jhoptree))">刷新选择的节点</a></div>
            <div>
            <a  href="javascript:void(0)" onclick="alert(getUserDate(jhoptree,getSelectedItemId(jhoptree)))">得到选择节点的userdate</a></div>
            <div>
            <a  href="javascript:void(0)" onclick="alert(getAllCheckedBranches(jhoptree))">得到多选的ids</a></div>
            
            
            <div>
            <a  href="javascript:void(0)" onclick="alert(getParentId(jhoptree,getSelectedItemId(jhoptree)))">得到所选节点的父节点</a></div>
            
            
            
			</td>
			
		</tr>
		<tr>
			<td></td>
		</tr>
	</table>

<hr>

<div id="treeboxbox_tree" style="width:300;height:500"></div>

		
	
	
	<script>
			
		   //creTree("treeboxbox_tree","100%","100%","zys",'/treefacade.do?method=getTreeNodes','/framework/themes/themes1/images/tree/','leaf.gif','books_close.gif','books_open.gif','tree1','proresource',true,true,"","<%=request.getContextPath()%>",oncl,changeParent,"<%=request.getContextPath()%>/themes/themes1/images/tree/loading.gif");
		  
		  	function oncl(id){
				alert(id);
			}
			function  changeParent(id,tid){
				alert("sourceId:"+id+"       targetId:"+tid);
				return true;
			}
		  
	</script>
<% 
   String param ="ttttt";
   request.setAttribute("rr",param);
%>
<jhop:tree divid="treeboxbox_tree" 
			jhoptree="jhoptree"
			treeid="zsy" 
			queryPath="/listtree.do?method=getTreeNodes3" 
			treedisname="listtree3"   
			userdate="<%=param%>"
			checkboxflag="1"
			clickHandler = "oncl"
			dragFlag="true"
			dropHandler = "changeParent"
/>
</body>
</html>
