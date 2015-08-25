<%@ page language="java" pageEncoding="utf-8" buffer="18kb"%>
<%@ include file="/common/init_js.jsp"%>
<%@ include file="/common/init_tag.jsp"%>
<%@ include file="/common/init_grid.jsp" %>
<%@ page import="com.techstar.framework.ui.web.tag.engine.BaseGridObj"%>


<% 
	/*********************************************/
	//             通用查询列表模板                    //
	//         @author MaJian 2006-12-20         //
	/*********************************************/
%>
<html>
<head>
  <title>gridtest</title> 
    <meta name="KEYWORDS" content="dhtmlxgrid, dhtml grid, javascript grid, javascript, DHTML, grid, grid control, dynamical scrolling, xml, AJAX, API, cross-browser, checkbox, XHTML, compatible, gridview, navigation, script, javascript navigation, web-site, dynamic, javascript grid, dhtml grid, dynamic grid, item, row, cell, asp, .net, jsp, cold fusion, custom tag, loading, widget, checkbox, drag, drop, drag and drop, component, html, scand">
  <meta name="DESCRIPTION" content="Cross-browser DHTML grid with XML support and powerful API. This DHTML JavaScript grid can load its content dynamically from server using AJAX technology.">
  
    <link rel="STYLESHEET" type="text/css" href="<%=request.getContextPath()%>/themes/themes1/style.css">
    <link rel="STYLESHEET" type="text/css" href="<%=request.getContextPath()%>/themes/themes1/default.css">

	<script type="text/javascript">
	   var param=window.dialogArguments;
	   
		function GetData(type){
			if(type != "cannel"){
				var paramObj = new Object();
				
				var rows = mygrid.getSelectedId();
				var d = mygrid.getSelectedRowsData(3);
				var columnArra = d.split("@@@");
				var paramObj = new Object();
					paramObj.title 	= "gridSelect";
					paramObj.data	= columnArra;
				window.returnValue 	= paramObj;
			}
			window.close();
		}
	</script>
</head>
<body>

<table width="174" height="31">
<tbody><tr>
<td><input type="Button" class="inputbutton" name="btnOK" value="确定" onClick="GetData('ok');"></td>
<td><td><input type="Button" class="inputbutton" name="btnCancel" value="取消" onClick="GetData('cancel');"></td></tr>
</tbody></table><br>
<!-- 变电站属性 -->
<%
String issubStation= request.getParameter("issubstation");
out.println(issubStation);
request.setAttribute("extWheres","issubstation='"+issubStation+"'");
%>
<br>
<div id='mygrid'></div>
<br>
<div id='standGridPage'></div>
<!--<jhop:page currPage="1" pageSize="15" totalCount="30" urlStr="" ></jhop:page>--> 
</body>	
<%--处理消息--%>
<%
	/*
	if (message != null && !message.equals("") && !message.equals("null")){
%>
		<script language="javascript">
			dealMessage('<%=message%>');
		</script>
<% 
	 }
	 */
%>
</html>
<%-- 创建弹出窗口，并传递参数 --%>
<jhop:grid 	id="mygrid"
      pageId="standGridPage"
      busName="StdStationDto"
      subName="128199505277409084"
      pageItems="10"
      listType="3"
      listKind="101"
      entityName="StdStation"
      isDisplaySet="1"
      isQuerySet="1"
      isPageSet="1"
      isOutputSet="1"
      queryPath="/stdStation.do?method=standGridQuery&extWheres=${extWheres}">
</jhop:grid>