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
	String url  = "/zdhRmrec.do?method=standGridQuery&extOrder=modificationdate desc";
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
<div id='standGridPage'></div>
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
	 String contextpath = request.getContextPath();
	 String mainId = "";
	 String isCopy = "";
	 String listBox = "opButton#8^"+"/zdhCharalterrecord.do?method=initDetail&mainId=" + mainId + "&isCopy=true"+"@@@750@@@260@@@系统图详情@@@auto@@@单击浏览@@@opButton@@@1";
%>
</html>

<%-- 创建弹出窗口，并传递参数 opColInfo="opButton^系统图^1^${charrecord}"--%>
<jhop:grid 	id="mygrid"
      pageId="standGridPage"
      busName="ZdhRmrecDto"
      subName="128201295357084376"
      pageItems="10"
      listType="3"
      listKind="101"
      isOperater="1"  
      entityName="ZdhRmrec"      
      listBox="<%=listBox%>"
      isDisplaySet="1"
      isQuerySet="1"
      isPageSet="1"
      isOutputSet="1"
      queryPath="<%=url%>">
</jhop:grid>