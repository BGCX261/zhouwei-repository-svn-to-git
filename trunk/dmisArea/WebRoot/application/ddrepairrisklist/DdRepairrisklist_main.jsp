<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/common/init_js.jsp"%>
<%@ include file="/common/init_tag.jsp"%>
<%@ include file="/common/init_grid.jsp"%>
<%@ page language="java" buffer="18kb"%>

<%
	String upload_message = (String) request
	.getAttribute("upload_message");
    String primaryId=(String)(request.getParameter("primaryId")==null||request.getParameter("primaryId").equals("null")?request.getAttribute("primaryId"):request.getParameter("primaryId"));
//System.out.println("QQQQQ:"+request.getParameter("primaryId"));
//System.out.println("WWWWWW:"+request.getAttribute("primaryId"));
%>

<%
	/*********************************************/
	//             通用查询列表模板                    //
	//         @author MaJian 2006-12-20         //
	/*********************************************/
%>
<html>
	<head>
		<title>gridtest</title>
		<link rel="STYLESHEET" type="text/css"
			href="<%=request.getContextPath()%>/themes/themes1/style.css">
		<link rel="STYLESHEET" type="text/css"
			href="<%=request.getContextPath()%>/themes/themes1/default.css">
	</head>

	<body>
		<table class="detailmain" cellspacing="0" cellpadding="0" id="table0">
			<iframe name="iGridUp" frameborder='0' height="220" width='100%'
				scrolling="no"
				src='<%=request.getContextPath()%>/application/ddrepairrisklist/DdRepairrisklist_Premethod.jsp?upload_message=<%=upload_message%>&primaryId=<%=primaryId%>'></iframe>
		</table>


	</body>


</html>
