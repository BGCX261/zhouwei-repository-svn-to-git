

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
	<script  src="<%=request.getContextPath()%>/script/tag/tree/jhoptree.js"></script>
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
		    <a href="javascript:void(0)" onClick="alert(getSelectedItemId(jhoptree));">得到选择的Id</a>
            <br/>
            <div>
            <a  href="javascript:void(0)" onclick="alert(getItemText(jhoptree,getSelectedItemId(jhoptree)));">得到选择节点的名称/a></div>
            <div>
            <a  href="javascript:void(0)" onClick="refreshItem(jhoptree,getSelectedItemId(jhoptree))">刷新选择的节点</a></div>
            <div>
            <a  href="javascript:void(0)" onClick="alert(getUserDate(jhoptree,getSelectedItemId(jhoptree)))">得到选择节点的userdate</a></div>
            <div>
            <a  href="javascript:void(0)" onClick="alert(getAllCheckedBranches(jhoptree))">得到多选的ids</a></div>
            <div>
            <a  href="javascript:void(0)" onClick="alert(getParentId(jhoptree,getSelectedItemId(jhoptree)))">得到所选节点的父节点</a></div>
            
            
            
			</td>
			
		</tr>
		<tr>
			<td></td>
		</tr>
	</table>

<hr>

<div id="treeboxbox_tree" style="width:500;height:500"></div>

<% 
   String unitId = (String)request.getAttribute("unitId");
   String taskdef_id = (String)request.getAttribute("taskdef_id");
	 String processdef_id = (String)request.getAttribute("processdef_id");
		    
%>
	
	
	<script>
			
		   //creTree("treeboxbox_tree","100%","100%","zys",'/treefacade.do?method=getTreeNodes','/framework/themes/themes1/images/tree/','leaf.gif','books_close.gif','books_open.gif','tree1','proresource',true,true,"","<%=request.getContextPath()%>",oncl,changeParent,"<%=request.getContextPath()%>/themes/themes1/images/tree/loading.gif");
		  
		 function oncl(id){
		    //var url2="<%=request.getContextPath()%>/resourcetree.do?method=getUserList&sign=1&taskdef_id=<%=taskdef_id%>&processdef_id=<%=processdef_id%>&unit_id="+id;
			var url2="<%=request.getContextPath()%>/common/wfmanage/listUser.jsp?taskdef_id=<%=taskdef_id%>&processdef_id=<%=processdef_id%>&unit_id="+id;
			parent.rightFrame.location.href = url2;
		}
			
			function  changeParent(id,tid){
				alert("sourceId:"+id+"  targetId:"+tid);
				return true;
			}
		  
	</script>

<jhop:tree divid="treeboxbox_tree"
			jhoptree="jhoptree" 
			treeid="<%=unitId%>" 
			queryPath="/resourcetree.do?method=getOrgTree&taskdef_id=<%=taskdef_id%>&processdef_id=<%=processdef_id%>" 
			treedisname="listtree2" 
			checkboxflag="false"
			clickHandler = "oncl"
			dragFlag="true"
			dropHandler = "changeParent"
/>
</body>
</html>
