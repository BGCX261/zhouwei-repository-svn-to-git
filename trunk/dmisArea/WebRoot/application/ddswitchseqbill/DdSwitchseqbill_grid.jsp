<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/common/init_js.jsp"%>
<%@ include file="/common/init_tag.jsp"%>
<%@ include file="/common/init_grid.jsp" %>
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
    <link rel="STYLESHEET" type="text/css" href="<%=request.getContextPath()%>/themes/themes1/style.css">
    <link rel="STYLESHEET" type="text/css" href="<%=request.getContextPath()%>/themes/themes1/default.css">
	<script type="text/javascript">
	   var param=window.dialogArguments;
	   
		function GetData(type){
			if(type != "cancel"){
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
<!-- 是 -->
<%
String flag= request.getParameter("flag");

request.setAttribute("extWheres","fistypicalbill='"+flag+"'");
%>

<div id='mygrid'></div>

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
      busName="DdSwitchseqbillDto"
      subName="128207453736767152"
      pageItems="30"
      listType="3"
      listKind="101"
      entityName="DdSwitchseqbill"
      isDisplaySet="1"
      isQuerySet="1"
      isPageSet="1"
      isOutputSet="1"
      queryPath="/ddSwitchseqbill.do?method=standGridQuery&extWheres=${extWheres}">
</jhop:grid>