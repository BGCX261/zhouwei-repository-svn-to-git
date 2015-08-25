<%@ page contentType="text/html; charset=utf-8" language="java"  %>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link type="text/css" rel="StyleSheet" href="skins/winclassic.css" />
<link href="<%=request.getContextPath()%>/themes/themes1/style.css" rel="stylesheet" type="text/css" />

<style type="text/css">
<!--
.style1 {
	color: #000000;
	font-size: 18px;
}
-->
</style>
</head>
<body>
<table width="100%" height="100%">
<tr align="center" valign="middle"><td>
<table cellspacing="0" width="80%" >  
	<tr align="center">
	    <c:if test="${not empty msg}">
		    <td ><img border="0"src="<%=request.getContextPath()%>/themes/themes1/images/msginfo/notfound.jpg"></td>
		    <td align="center">
		  <span class="style1">
			<c:out value="${msg}"></c:out>
		  </span>
		  </td>
	</c:if>
		    <c:if test="${empty msg}">
			 <td ><img border="0"src="<%=request.getContextPath()%>/themes/themes1/msginfo/grid/error.jpg"></td>
		    <td align="center">
		  		<span class="style1">操作失败，请重新尝试！</span>
		  </td>
		</c:if>
		
	</tr>
</table>
</td>
</tr>
</body>
</html>
