<%@ page language="java" pageEncoding="GBK"%>
<%@ include file="/common/init_js.jsp"%>
<%@ include file="/common/init_tag.jsp"%>
<%@ include file="/common/init_grid.jsp"%>
<%@ page language="java" buffer="18kb"%>
<%@ page import="java.io.*" %>
<%@ page import="com.techstar.dmis.dto.*" %>
<%
			System.out.println("@@@@@@@@@@@@$$$$$$$$$$%%%%%%%%%%%:"
			+ request.getParameter("mainid"));
	request.setAttribute("mainid", request.getParameter("mainid"));
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
 <td height="23" class="tab_0" width="20%">

				<% 
				    DdPremethodDto dto=(DdPremethodDto)request.getAttribute("ddPremethodDto");
					OutputStream os =response.getOutputStream();
					if(dto.getFpremethodcontent().length>0)
						os.write(dto.getFpremethodcontent());
					else
					{
					String message = "没有预案附件，请上传";
					os.write(message.getBytes());
				
					
					}
						os.flush();
						os.close();
						os=null;
						response.flushBuffer();
						out.clear();
						out = pageContext.pushBody();

						
				%>
			   </td>  

	</body>
</html>
<script>
   function afterLoadForUser(grid){}
</script>
