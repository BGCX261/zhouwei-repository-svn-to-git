<%@ page language="java" pageEncoding="utf-8" buffer="18kb"%>
<%@ include file="/common/init_js.jsp"%>
<%@ include file="/common/init_tag.jsp"%>
<%@ include file="/common/init_grid.jsp" %>

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
<br>

<br>
<div id='mygrid'></div>
<br>
<div id='standGridPage'></div>
<table>
			<td>
				<div align="right">
					<input type="button" name="button" value="  确 认  "
						onClick="GetData('enter')">
					<input type="button" name="button" value="  取 消  "
						onClick="GetData('cancel')">
				</div>
			</td>
		</table>
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
      busName="StdLineDto"
      subName="128209072067612057"
      pageItems="10"
      listType="3"
      listKind="101"
      entityName="StdLine"
      isDisplaySet="0"
      isQuerySet="0"
      isPageSet="0"
      isOutputSet="0"
      isCheckBox="0"
      queryPath="/stdLine.do?method=standGridQuery">
</jhop:grid>