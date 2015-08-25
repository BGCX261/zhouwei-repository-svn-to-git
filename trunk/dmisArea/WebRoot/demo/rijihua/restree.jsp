<%@ page contentType="text/html; charset=utf-8" language="java"  %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<%=request.getContextPath()%>/themes/themes1/style.css" rel="stylesheet" type="text/css" />
<script  src="<%=request.getContextPath()%>/script/dhtmlXCommon.js"></script>
<script  src="<%=request.getContextPath()%>/script/tree/dhtmlXTree.js"></script>
<script  src="<%=request.getContextPath()%>/script/tree/dhtmlXTree_xw.js"></script>
<script  src="<%=request.getContextPath()%>/script/tree/dhtmlXTree_li.js"></script>	
<script  src="<%=request.getContextPath()%>/script/tree/treeutil.js"></script>
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
		<tr>
			<td width="33%" align="right" height="10" class="tab_0">
				<input type="button" class="inputbutton" value="确 定" onClick="getSelectedId();"/>&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    </td>
		</tr>	
	</table>
<script>				
	//调用方式
	treeutil = new treeutil("org","100%","100%","zys","<%=request.getContextPath()%>/themes/themes1/images/tree/","leaf.gif","books_close.gif","books_open.gif","tree1","proresource",true,true);
	
	//设置点击事件必须在createTree前很重要
	treeutil.setOnClickHandler(oncl);
	function oncl(id){
		//alert(id);
	}
	//设置拖拽事件
	treeutil.setDropHandler(changeParent);
	function  changeParent(id,tid){
		//alert("sourceId:"+id+"       targetId:"+tid);
		return true;
	}
	//点击事件必须在createTree前很重要
	treeutil.createTree('<%=request.getContextPath()%>');
			
	function getSelectedId(){
		var ids = treeutil.getAllCheckedBranches();
		window.returnValue = ids;
		window.close();
	}
</script>
</body>
</html>
