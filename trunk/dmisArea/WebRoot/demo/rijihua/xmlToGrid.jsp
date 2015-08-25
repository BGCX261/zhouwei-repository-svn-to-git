<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
  String xmlData = (String)request.getAttribute("xml");  
%>
<html>
<head>
   <title>xml直接生成报表实例</title>
   <meta name="KEYWORDS" content="dhtmlxgrid, dhtml grid, javascript grid, javascript, DHTML, grid, grid control, dynamical scrolling, xml, AJAX, API, cross-browser, checkbox, XHTML, compatible, gridview, navigation, script, javascript navigation, web-site, dynamic, javascript grid, dhtml grid, dynamic grid, item, row, cell, asp, .net, jsp, cold fusion, custom tag, loading, widget, checkbox, drag, drop, drag and drop, component, html, scand">
   <meta name="DESCRIPTION" content="Cross-browser DHTML grid with XML support and powerful API. This DHTML JavaScript grid can load its content dynamically from server using AJAX technology.">
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
   <%@ include file="/common/init_js.jsp" %>
   <%@ include file="/common/init_date.jsp" %>
	<link href="demo.css" rel="stylesheet" type="text/css">
	<link rel="STYLESHEET" type="text/css" href="<%=request.getContextPath()%>/themes/themes1/style.css">
	<link rel="STYLESHEET" type="text/css" href="<%=request.getContextPath()%>/themes/themes1/default.css">
	<script type="text/javascript" src="<%=request.getContextPath()%>/script/public.js"> </script>
	<script  language="jscript.encode" src="<%=request.getContextPath()%>/script/dhtmlXCommon.js"></script>
	<script>_css_prefix="../../themes/themes1/"; _js_prefix="../../script/calendar/"; </script>
	<script  language="jscript.encode" src="<%=request.getContextPath()%>/script/grid/dhtmlXGrid.js"></script>
	<script  language="jscript.encode" src="<%=request.getContextPath()%>/script/grid/dhtmlXGridCell.js"></script>
	<script  language="jscript.encode" src="<%=request.getContextPath()%>/script/grid/dhtmlXGrid_excell_link.js"></script>
	<script  language="jscript.encode" src="<%=request.getContextPath()%>/script/grid/dhtmlxgrid_splt.js"></script>	
	<script  language="jscript.encode" src="<%=request.getContextPath()%>/script/grid/dhtmlXGrid_excell_calck.js"></script>
	<script  language="jscript.encode" src="<%=request.getContextPath()%>/script/grid/dhtmlXGrid_excell_acheck.js"></script>
	<script  language="jscript.encode" src="<%=request.getContextPath()%>/script/grid/dhtmlXGrid_excell_calendar.js"></script>
	<script  language="jscript.encode" src="<%=request.getContextPath()%>/script/grid/dhtmlXGrid_excell_clist.js"></script>
</head>
<body>
   <table>
		<tr>
			<td >			    
				<div id="gridbox" class="gridbox_xp" width="100%" height="600" style="background-color:white;"></div>
			</td>
		</tr>
		
	</table>
</body>
<script>
    var mygrid;
    mygrid = new dhtmlXGridObject('gridbox');
	mygrid.setImagePath("<%=request.getContextPath()%>/themes/themes1/images/grid/");
    //设置多选,如果当前页面设置了鼠标移动导航，则会自动屏蔽多选功能
    mygrid.setMultiselect ("true");

   
    //设置隔行显示，并对选中行进行高亮显示
    mygrid.enableAlterCss("even","uneven");

   	mygrid.setSkin("xp");
    /*
    mygrid.setOnRowSelectHandler(doOnRowSelected);
    mygrid.setOnEditCellHandler(doOnCellEdit);
    mygrid.setOnEnterPressedHandler(doOnEnter);
    mygrid.setOnCheckHandler(doOnCheck);
    mygrid.setOnBeforeRowDeletedHandler(doBeforeRowDeleted);
    */
	mygrid.loadXMLString('<%=xmlData%>');	    
</script>
</html>