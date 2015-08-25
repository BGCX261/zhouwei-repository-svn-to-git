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
	<script type="text/javascript" src="<%=request.getContextPath()%>/components/tag/grid/twoGridDemo.js"></script>
	
</head>
<body>
<br>

<br>
<div id='mygrid'></div>
<br>
<div id='standGridPage2'></div>
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
      pageId="standGridPage2"
      busName="DdCutofflistDto2"
      subName="128205728524174406"
      pageItems="100"
      listType="3"
      listKind="102"
      entityName="DdCutofflist"
      isDisplaySet="0"
      isQuerySet="0"
      isPageSet="0"
      isOutputSet="0"
      queryPath="/ddCutofflist.do?method=standGridQuery2">
</jhop:grid>