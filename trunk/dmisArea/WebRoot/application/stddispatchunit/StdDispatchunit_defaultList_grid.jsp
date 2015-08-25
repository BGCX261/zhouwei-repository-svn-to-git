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
      busName="StdDispatchunitDto"
      subName="128239349637052260"
      pageItems="30"
      listType="3"
      listKind="101"
      entityName="StdDispatchunit"
      isDisplaySet="0"
      isCheckBox="0"
      queryPath="/stdDispatchunit.do?method=standGridQuery">
</jhop:grid>