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
		<title>gridtest</title>
		<link rel="STYLESHEET" type="text/css"
			href="<%=request.getContextPath()%>/themes/themes1/style.css">
		<link rel="STYLESHEET" type="text/css"
			href="<%=request.getContextPath()%>/themes/themes1/default.css">
	</head>
	<body>
		
		<div id='mygrid'></div>
				<!--<jhop:page currPage="1" pageSize="15" totalCount="30" urlStr="" ></jhop:page>-->
	</body>

</html>
<%-- 创建弹出窗口，并传递参数 --%>
<jhop:grid id="mygrid"  busName="DdDoutageplanDtocoppreate_grid"
	subName="128197051371530608" pageItems="20" listType="3" listKind="101" isCheckBox="1" 
	entityName="DdDoutageplan" isDisplaySet="0" isQuerySet="0"
	isPageSet="0" isOutputSet="0" 
	queryPath="/ddDoutageplan.do?method=dispatchedDayPlanGridQuery">
</jhop:grid>



<form name="dispatchform" method="post" action="">
 <input type="hidden" id="name" name="name" value="">
 <input type="hidden" id="date" name="date" value="">
 <input type="hidden" id="ids" name="ids" value="">
</form>


</html>
