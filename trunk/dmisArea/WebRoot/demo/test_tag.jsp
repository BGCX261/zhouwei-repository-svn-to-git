<%@ page contentType="text/html; charset=GBK" language="java"%>
<%@ include file="../common/taglibs.jsp"%>
<%
java.sql.Timestamp now = new java.sql.Timestamp(System.currentTimeMillis());
request.setAttribute("nowstr" , now);
%>
<html>
  <head>  
	<title>测试标签</title>
  </head>  
  <body>
  	<br>
    jstl c:out ==> <c:out value="${nowstr}"/>      <br>
	jstl fmt:formatNumber ==> <fmt:formatNumber value="20.3336" pattern="00.0" /><br>
	<bean:define id="nowdate" name="nowstr" type="java.sql.Timestamp" scope="request" />	
	struts bean:write ==> <bean:write name="nowdate" format="yyyy年MM月dd日"/>
  </body>
</html>
