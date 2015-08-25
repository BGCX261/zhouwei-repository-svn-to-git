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
  <script type="text/javascript" src="<%=request.getContextPath()%>/script/public.js"> </script>
</head>
<body>    
    
<%
	String parentid = (String)request.getParameter("parentid");
	request.setAttribute("parentid",parentid);
	System.out.println("parentid="+parentid);
 %>

<div id="mygrid"></div>
<%-- 创建弹出窗口，并传递参数 --%>
<jhop:grid 	id="mygrid"  
			divHeight="320" 
			busName="SaleDetail" 
			subName="subname2"
			pageItems="7"   
			listType="2" 
			listKind="104" 
			filterMode="0" 
			entityName="SaleDetail"
			isTotalRow="0" 
			isOperater="1" 
			listBox="begin_date#5^,end_date#5,custom_id#3^type=zzmm@@@parentId=,custom_name#2^src=SQDW" 
			colValByList="^^^^custom_id,custom_name^^^^^"
			editType="id^ed,print_no^ed,print_time^ed,goodsqty^ed,custom_id^ed,custom_name^ed,begin_date^ed,end_date^ed,salebilldto^ed,version^ed"
			queryPath="/ui.do?method=detailchildGrid&parentid=2"> 
</jhop:grid>
<table>
<td  colspan="4">
			  <div align="right">
						<input type="button"  name="button" value="  确 认  " onClick="enterData('enter')">
						<input type="button"  name="button" value="  取 消  " onClick="enterData('cannel')">
				</div>
</td>
</table>
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
<script>
      
 	  /**
		*  提交数据到父页面,快捷查询时使用
		*  返回数组类型
		*  格式: 英文列名#第一列值,第二列值,第三列值....
		*/
		function enterData(type){
		    
		    
			if(type != "cannel"){
			    var  datas = mygrid.getSelectedRowsData(3);
				var  colNamesArra = "pm^药 品###dw^中国医药###pg^20*3###cd^北 京";
				window.returnValue 	= datas;
			}
			window.close();
		}
</script>

</html>	