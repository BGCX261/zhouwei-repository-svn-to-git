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
   <%
      //按照工作时间倒序排序
      request.setAttribute("extOrder","worktime desc");
   %>
   
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
      busName="ZdhWorkbillDto"
      subName="128201239690379680"
      pageItems="30"
      listType="3"
      listKind="101"
      entityName="ZdhWorkbill"
      isDisplaySet="1"
      isQuerySet="1"
      isPageSet="1"
      isOutputSet="1"
      queryPath="/zdhWorkbill.do?method=standGridQuery&extOrder=${extOrder}">
</jhop:grid>
<script type="text/javascript">
    function afterLoadForUser(grid){
       //alert("zdhworkbill_defaultList_grid.jsp afterLoadForUser:"+grid);
       
    }
    function doOnRowDblClickedForUser(grid,rowid) {
       //alert('rowId:'+rowid);
    }
</script>
 
