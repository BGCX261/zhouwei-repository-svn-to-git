<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="../../../common/init_js.jsp"%>
<%@ include file="../../../common/init_tag.jsp"%>
<%@ include file="../../../common/init_grid.jsp" %>
<%@ page import="com.techstar.framework.ui.web.tag.engine.BaseGridObj"%>
<%@ page language="java" buffer="18kb"%>
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
	<script type="text/javascript" src="<%=request.getContextPath()%>/components/tag/grid/twoGridDemo.js"></script>
<script>
	function onSaveForm(contextPath){
		url = contextPath + "/ui.do?method=saveMainGrid";
		document.all.saleBillForm.action = url;
		document.all.saleBillForm.submit();
	}

//���������������������onResetForm������������������������������������������������
function onResetForm(contextPath){
	document.all.saleBillForm.reset();
}

</script>
</head>
<body>    
<div id="mygrid"></div>
<br>
<br>
  
</body>	
<%--处理消息--%>

<%
	/*
	if (message != null && !message.equals("") && !message.equals("null"))
	{
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
			pageId="page" 
			divHeight="200" 
			busName="SaleBillDto" 
			subName="subname2"
			pageItems="24"   
			listType="1" 
			listKind="108" 
			filterMode="0" 
			entityName="SaleBill"
			isTotalRow="0" 
			isOperater="1" 
			editType="cre_date#ro,custom_id#ro"
			columnMove="custom_id,custom_name" 
			colAlign="sale_mode#right"   
			listBox="cre_date#7^,custom_id#1^type=zzmm@@@parentId=,custom_name#2^src=SQDW,sale_mode#2^src=SQDW"  
			queryPath="/ui.do?method=mainGrid"> 
</jhop:grid>
