<%@ page language="java" pageEncoding="GBK"%>
<%
	String path = request.getContextPath();
%>
<html>
	<head>
		<title>toolbar</title>
		<link rel="STYLESHEET" type="text/css" href="<%=request.getContextPath()%>/css/dhtmlXGrid.css">
		<link rel="STYLESHEET" type="text/css" href="<%=request.getContextPath()%>/themes/themes1/style.css">
		<link rel="STYLESHEET" type="text/css" href="<%=request.getContextPath()%>/css/dhtmlXToolbar.css">
		<script language="JavaScript" src="<%=request.getContextPath()%>/script/toolbar/dhtmlXProtobar.js"></script>
		<script language="JavaScript" src="<%=request.getContextPath()%>/script/toolbar/dhtmlXToolbar.js"></script>
		<script language="JavaScript" src="<%=request.getContextPath()%>/script/toolbar/dhtmlXCommon.js"></script>

	</head>
	<body onload="doOnLoad()">
		<div id="toolbar_tech" style="width:100%; border :1px solid Silver;"></div>


		<script>

			function onButtonClick(itemId,itemValue)
			{
				if(itemId == "find")
				{
					alert("查找内容 ["+document.getElementById("inputText").value+"]");
				}
				else if(itemId == "new")
				{
					alert("新建记录");
				}
				else if(itemId == "copy")
				{
					alert("根据选中的记录,创建一条新记录");
				}
				else if(itemId == "save")
				{
					alert("在详情页中保存填写或修改的内容");
				}
				else if(itemId == "delete")
				{
					alert("删除选中的记录");
				}
				else if(itemId == "cannel")
				{
					alert("取消在详情页中填写的更改的内容");
				}
				else if(itemId == "lastRow")
				{
					alert("移动到上一行记录");
				}
				else if(itemId == "nextRow")
				{
					alert("移动到下一行记录");
				}
				else if(itemId == "0_select")
				{
					parent.location.href="init.jsp";
				}
                                else if(itemId == "1_select")
				{
					window.location.href="#";
				}
                                else if(itemId == "report")
				{
					alert("查看报表");
				}
				else
				{
					alert("Button "+itemId+" was pressed"+(itemValue?("\n selected value : "+itemValue):""));
				}
			};

			function doOnLoad()
			{
				aToolBar2=new dhtmlXToolbarObject("toolbar_tech",'100%',20,"");
				aToolBar2.setToolbarCSS("tools","toolbarName");
				aToolBar2.setOnClickHandler(onButtonClick);
				aToolBar2.loadXML("jhottoolbar.xml")
				aToolBar2.showBar();
			}

		</script>

	</body>
</html>
