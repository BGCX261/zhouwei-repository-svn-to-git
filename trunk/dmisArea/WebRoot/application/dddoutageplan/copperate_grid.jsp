<%@ page language="java" pageEncoding="utf-8" buffer="18kb"%>
<%@ include file="/common/init_js.jsp"%>
<%@ include file="/common/init_tag.jsp"%>
<%@ include file="/common/init_grid.jsp"%>

<%
	/*********************************************/
	//             通用查询列表模板                    //
	//         @author MaJian 2006-12-20         //
	/*********************************************/
%>
<html>
	<head>
		<title></title>
		<link rel="STYLESHEET" type="text/css"
			href="<%=request.getContextPath()%>/themes/themes1/style.css">
		<link rel="STYLESHEET" type="text/css"
			href="<%=request.getContextPath()%>/themes/themes1/default.css">
	</head>
	<body>
		<div id='mygrid'></div>
		<br>
		<div id='standGridPage'></div>




		<jhop:grid id="mygrid" pageId="standGridPage"
			busName="DdDoutageplanDto4" subName="128190324748579096"
			pageItems="30" listType="1" listKind="108" entityName="Dayplancoopraterel"
			isDisplaySet="0" isQuerySet="0" isPageSet="1" isOutputSet="0" 
			isCheckBox="0"
			queryPath="/ddDoutageplan.do?method=coopratereGridQuery">
		</jhop:grid>

		
	</body>
	
</html>

