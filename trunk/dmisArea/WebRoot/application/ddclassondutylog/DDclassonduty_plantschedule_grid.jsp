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
<!-- 接收班志ID -->
<%
String CurGroupLogNO= request.getParameter("fid");
request.setAttribute("extWheres","t.zddhpoweroperaterrd5.fid='"+CurGroupLogNO+"'");
%>
<br>
<div id='mygrid'></div>
<br>
<div id='standGridPage5'></div>
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
      pageId="standGridPage5"
      busName="DdClassondutylogDto5"
      subName="128199702862009804"
      pageItems="10"
      listType="3"
      listKind="101"
      entityName="DdHpoweroperaterrd"
      isDisplaySet="0"
      isQuerySet="0"
      isPageSet="0"
      isOutputSet="0"
      queryPath="/ddClassondutylog.do?method=standGridQuery5&extWheres=${extWheres}">
</jhop:grid>