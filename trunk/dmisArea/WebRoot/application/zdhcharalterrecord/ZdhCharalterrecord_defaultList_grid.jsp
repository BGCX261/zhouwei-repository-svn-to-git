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
<% 
	//以时间倒排序//
	String url = "/zdhCharalterrecord.do?method=standGridQuery&extOrder=sys_filltime desc";
	String listBox = "mdiagram#8^"+"/zdhCharalterrecord.do?method=showImg"+"@@@1000@@@1000@@@停电图详情@@@auto@@@浏览图片@@@mdiagram@@@1";
%>
<html>
<head>
  <title>gridtest</title> 
    <link rel="STYLESHEET" type="text/css" href="<%=request.getContextPath()%>/themes/themes1/style.css">
    <link rel="STYLESHEET" type="text/css" href="<%=request.getContextPath()%>/themes/themes1/default.css">	
</head>
<body>
<br>
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
      busName="ZdhCharalterrecordDto"
      subName="128206480239350418"
      pageItems="10"
      listType="3"
      listKind="101"
      entityName="ZdhCharalterrecord"
      listBox="<%=listBox%>" 
      isDisplaySet="1"
      isQuerySet="1"
      isPageSet="1"
      isOutputSet="1"
      queryPath="<%=url%>">
</jhop:grid>