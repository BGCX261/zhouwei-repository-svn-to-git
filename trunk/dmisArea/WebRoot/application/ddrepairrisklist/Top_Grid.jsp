<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/common/init_js.jsp"%>
<%@ include file="/common/init_tag.jsp"%>
<%@ include file="/common/init_grid.jsp"%>
<%@ page language="java" buffer="18kb"%>
<%
String mainid=request.getParameter("mainid");
request.setAttribute("mainid", mainid);
String url="/ddPremethod.do?method=customGridQuery&mainid="+mainid;
%>
<html>
	<head>
		<title>gridtest</title>
		<link rel="STYLESHEET" type="text/css"
			href="<%=request.getContextPath()%>/themes/themes1/style.css">
		<link rel="STYLESHEET" type="text/css"
			href="<%=request.getContextPath()%>/themes/themes1/default.css">

	</head>

	<body>
		<div id='mygrid'></div>
		<div id='standGridPage'></div>

		<jhop:grid id="mygrid" pageId="standGridPage" busName="DdPremethodDto"
			subName="128209072064799557" pageItems="10" listType="1"
			isCheckBox="0" listKind="108" entityName="DdPremethod"
			queryPath="<%=url%>" divHeight="220">
		</jhop:grid>
	</body>
</html>
<script>
   function afterLoadForUser(grid){
                 grid.setRowHidden(0,true);
	             grid.showFilterRow = false;
   }
</script>
