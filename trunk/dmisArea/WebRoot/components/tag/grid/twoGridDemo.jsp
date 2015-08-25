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
<script>
		function rowChangedToChild(priColVal,gridKind,data){
			//alert(priColVal+"#####"+gridKind+"#"+data);		
			if(priColVal){
				if(priColVal.indexOf("^") != -1){
					var primId = priColVal.split("^")[1];
					var param  = "id^string^1^"+primId+"^^asc###";
					document.iGridDown.createGrid('','0','','1^100','',param,'','');
				}
			}
			
		}
	</script>
<body>    
<br>
<form name="rijihuaForm" action="" method="post">
<jhop:ctrlgroup ctrlId="table0" title="主表信息">
</jhop:ctrlgroup>
<table class="detailmain" cellspacing="0" cellpadding="0" id="table0">
<iframe name="iGridUp" frameborder='0' height="220" width='100%' scrolling="no" src='<%=request.getContextPath()%>/components/tag/grid/generalGridDemoNoPage.jsp'></iframe>
</table>

<jhop:ctrlgroup name="grid" ctrlId="table1" title="子表信息" isEdit="no">
	<!--<img name='save' src="<%=request.getContextPath()%>/themes/themes1/images/main/save.gif" onClick="savegrid();">
	<img name='del' src="<%=request.getContextPath()%>/themes/themes1/images/main/delete.gif" onClick="deletegrid();">
--></jhop:ctrlgroup>
<table class="detailmain" cellspacing="0" cellpadding="0" id="table1">
<iframe name="iGridDown" frameborder='0' height="220" width='100%' scrolling="no" src='<%=request.getContextPath()%>/components/tag/grid/updateGridDemo.jsp'></iframe>
</table>
</form>
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