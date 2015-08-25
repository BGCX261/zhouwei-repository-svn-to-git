
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
	<!-- <script  src="<%=request.getContextPath()%>/script/tree/treeutil.js"></script> -->
<title>
</title>
</head>

<body>
	<table  width="100%" height="100%" align="left" >
		<tr>
			<td width="33%" align="left">
				<div  align="left" id="org" style="width:100%; height:100%"/>
			
		  </td>

		</tr>
	</table>


<script>
			
		   //creTree('org','100%','100%','zys',"/framework/treefacade.do?method=getTreeNodes",'/framework/themes/themes1/images/tree/','leaf.gif','books_close.gif','books_open.gif','tree1','proresource',true,true,"",oncl,changeParent,"<%=request.getContextPath()%>/themes/themes1/images/tree/loading.gif");
		
		  	 var clic=function(id){
				alert(id);
			}
			function  changeParent(id,tid){
				alert("sourceId:"+id+"       targetId:"+tid);
				return true;
			}
		  
			
			/*
			//调用方式
			treeutil = new treeutil("org","100%","100%","zys","<%=request.getContextPath()%>/themes/themes1/images/tree/","leaf.gif","books_close.gif","books_open.gif","tree1","proresource",true,true);
			
			//设置点击事件必须在createTree前很重要
			treeutil.setOnClickHandler(oncl);
			
			//设置拖拽事件
			treeutil.setDropHandler(changeParent);
			
			//点击事件必须在createTree前很重要
			treeutil.createTree('<%=request.getContextPath()%>');
			
			function oncl(id){
				alert(id);
			}
			function  changeParent(id,tid){
				alert("sourceId:"+id+"       targetId:"+tid);
				return true;
			}*/
			
</script>
<!-- 标签一定在回调函数的下边要不找不到回调函数-->
<jhop:tree divid="org" 
			treeid="zys" 
			queryPath="/tree1.do?method=getTreeNodes" 
			treedisname="tree1" 
			nodedisname="proresource" 
			checkboxflag="2"
			clickHandler = "clic"
			dragFlag="true"
			dropHandler = "changeParent"
/>
</body>
</html>
