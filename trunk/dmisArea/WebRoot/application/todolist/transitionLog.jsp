
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>svg test</title>
</head>
<body>


<EMBED name=test pluginspage=http://www.adobe.com/svg/viewer/install/ 
src="<%=request.getContextPath()%>/todolist.do?method=transitionLog&taskInstanceId=<%=request.getParameter("taskInstanceId")%>" 
width=100% height=100% type=image/svg+xml> 
</body>
</html>