<%@ page contentType="text/html; charset=utf-8" language="java" buffer="18kb"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*" %>
<%@ page import="com.techstar.dmis.dto.*" %>
<%@ include file="/common/init_tag.jsp" %>
<%@ include file="/common/init_js.jsp"%>
<%@ include file="/common/init_tag.jsp"%>
<%@ include file="/common/init_grid.jsp"%>
<%@ page import="java.util.ArrayList"%>
<%
    String edit= (String)request.getAttribute("edit");
    System.out.println("editffffff="+edit);
    ArrayList stamplist = (ArrayList)request.getAttribute("stamps");
    
%>
<html>
	<head>
		<html:base />
		<title>电子章显示</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="../../themes/themes1/style.css" rel="stylesheet"
			type="text/css" />
		<%@ include file="/common/init_js.jsp"%>
		<%@ include file="/common/init_date.jsp"%>
	</head>
	<body bgcolor="#ffffff">

		
					<table class="" align="center" width="100%" >
						<tr valign="middle">
							   <td>
							   
					 <%if(stamplist!=null&&stamplist.size()>0){%>
					 <c:forEach var="list" items="${stamps}" varStatus="status">
					        
			                 <label>
			                        <%if(!edit.equals("false")){%>
									<input type="checkbox" name="checkbox" value="checkbox" id="<c:out value="${list.id}"/>">
									<%} %>
								</label>
								<img src="<%=request.getContextPath()%>/application/dddoutageplan/stamp/<c:out value="${list.fstampname}"/>.jpg" alt="" height="40">
								&nbsp;&nbsp;
						</c:forEach>
						<%} %>
								
							</td>
						</tr>
					</table>
	


	</body>

</html>
