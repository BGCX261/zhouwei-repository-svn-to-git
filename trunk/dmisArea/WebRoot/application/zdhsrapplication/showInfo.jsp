<%@ page language="java" pageEncoding="GBK"%>
<%@ include file="/common/init_js.jsp"%>
<%@ include file="/common/init_tag.jsp"%>
<%@ include file="/common/init_grid.jsp"%>
<%@ page contentType="application/msword;charset=GBK" language="java"%>
<%@ page language="java" buffer="18kb"%>
<%@ page import="java.io.*" %>
<%@ page import="com.techstar.dmis.dto.*" %>

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
				    ZdhSrapplicationDto zdhSrapplicationDto=(ZdhSrapplicationDto)request.getAttribute("zdhSrapplicationDto");
					OutputStream os =response.getOutputStream();
					
					if(zdhSrapplicationDto.getFannexexplanation()!=null&&zdhSrapplicationDto.getFannexexplanation().length>0)
						os.write(zdhSrapplicationDto.getFannexexplanation());  
					else
					{
					String message = "没有附件，请上传";
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
