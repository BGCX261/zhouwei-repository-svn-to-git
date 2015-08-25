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
	
	
</head>
<body>
<br>
		<%
			String url="/zdhReception.do?method=standGridQuery";
			String listBox="opButton_1#8^/zdhReception.do?method=showImg&type=1@@@600@@@500@@@显示图片@@@auto@@@显示图片@@@opButton_1@@@1,opButton_2#8^/zdhReception.do?method=showImg&type=2@@@600@@@500@@@显示图片@@@auto@@@显示图片@@@opButton_2@@@1,opButton_3#8^/zdhReception.do?method=showImg&type=3@@@600@@@500@@@显示图片@@@auto@@@显示图片@@@opButton_3@@@1,opButton_4#8^/zdhReception.do?method=showImg&type=4@@@600@@@500@@@显示图片@@@auto@@@显示图片@@@opButton_4@@@1";
		
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
      busName="ZdhReceptionDto"
      subName="128201374653775408"
      pageItems="30"
      listType="3"
      listKind="101"
      entityName="ZdhReception"
      listBox="<%=listBox %>"
      isDisplaySet="1"
      isQuerySet="1"
      isPageSet="1"
      isOutputSet="1"
      queryPath="<%=url %>">
</jhop:grid>