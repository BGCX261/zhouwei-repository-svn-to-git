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
					alert("�������� ["+document.getElementById("inputText").value+"]");
				}
				else if(itemId == "new")
				{
					alert("�½���¼");
				}
				else if(itemId == "copy")
				{
					alert("����ѡ�еļ�¼,����һ���¼�¼");
				}
				else if(itemId == "save")
				{
					alert("������ҳ�б�����д���޸ĵ�����");
				}
				else if(itemId == "delete")
				{
					alert("ɾ��ѡ�еļ�¼");
				}
				else if(itemId == "cannel")
				{
					alert("ȡ��������ҳ����д�ĸ��ĵ�����");
				}
				else if(itemId == "lastRow")
				{
					alert("�ƶ�����һ�м�¼");
				}
				else if(itemId == "nextRow")
				{
					alert("�ƶ�����һ�м�¼");
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
					alert("�鿴����");
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
