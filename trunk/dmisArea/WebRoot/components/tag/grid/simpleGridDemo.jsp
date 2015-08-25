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
	
</head>
<body>
<div id='mygrid'></div>
<div id='page'></div>
<table>
			<tr>
				<td align="right">
					<div align="right">
						<input type="button" class="inputbutton" name="button" value="  确 认  " onClick="enterData('enter')">
						<input type="button" class="inputbutton" name="button" value="  取 消  " onClick="enterData('cannel')">
					</div>
				</td>
			</tr>
		 </table>
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
<jhop:grid 	id="myGrid" 
			pageId="page" 
			divHeight="380" 
			busName="SaleBillDto" 
			subName="general"
			pageItems="15"   
			listType="3" 
			listKind="101" 
			filterMode="2" 
			entityName="SaleBill"
			isFilterRow="1" 
			isTotalRow="1" 
			isOperater="1" 
			editType="cre_date#ro,custom_id#ro"
			columnMove="custom_id,custom_name" 
			isTotal="total"
			opColInfo="sale_doc^点击浏览^1^http://www.sina.com.cn/" 
			colAlign="sale_mode#right,sale_doc#center"  
			listBox="cre_date#7^,custom_id#1^type=zzmm@@@parentId=,custom_name#2^src=SQDW,sale_mode#2^src=SQDW"  
			isPageSet="1" 
			queryPath="/ui.do?method=query"> 
</jhop:grid>
<script>
	  // var colNameStr   = document.all.
	   //colNamesArra 	= colNameStr.split(",");
	  // colIsPriArra 	= isPrimaryStr.split(",");
	 /**
		*  提交数据到父页面,快捷查询时使用

		*  返回数组类型
		*  格式: 英文列名#第一列值,第二列值,第三列值....
		*/
		function enterData(type){
			if(type != "cannel"){
				var paramObj = new Object();
				
				var rows = myGrid.getSelectedId();
				var d = myGrid.getSelectedRowsData(3);
				var columnArra = d.split("@@@");
				var paramObj = new Object();
					paramObj.title 	= "gridSelect";
					paramObj.data	= columnArra;
				window.returnValue 	= paramObj;
			}
			window.close();
		}
</script>