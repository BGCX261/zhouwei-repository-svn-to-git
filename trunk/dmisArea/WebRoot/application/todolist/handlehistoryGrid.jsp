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
</head>
<body>
<br>
<% 
	//接收对象参数	
	String busId = request.getParameter("busId");
	String queryPath = "/todolist.do?method=handleHistoryGrid&busId="+busId;
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
      busName="HandleHistoryDto"
      subName="128201230267799676"
      divHeight="160"
      pageItems="10"
      listType="3"
      listKind="106"
      entityName=""
      isCheckBox="0"
      isFilterRow="0"
      isDisplaySet="0"
      isQuerySet="0"
      isPageSet="0"
      isOutputSet="0"
      isTotalRow="0"
      queryPath="<%=queryPath%>">
</jhop:grid>