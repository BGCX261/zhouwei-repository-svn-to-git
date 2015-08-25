<%@ page language="java" pageEncoding="GBK"%>
<%@ page import="java.util.*" %>

<%@ include file="../../common/taglibs.jsp"%>

<c:if test="${dicsList != null}">
	<c:set var="dicsList" value="${dicsList}" scope="request"/>
</c:if>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>字典性能测试</title>


</head>
<body> 
	<table border=1 cellPadding=0 cellSpacing=0 width="80%" align="center">	 
       <c:forEach var="dicLists" items="${dicsList}" varStatus="status">
             <jsp:useBean id="status" type="javax.servlet.jsp.jstl.core.LoopTagStatus" />
             <select name="${dicname}"+"<%=status.getCount()%>">
                <c:forEach var="dicDto" items="${dicLists}"> 
                  <option value=<c:out value='${dicDto.id}' /> ><c:out value='${dicDto.companyName}' /></option> 
                  <!-- <option value="aa">aaa</option> -->
                </c:forEach>                
              </select>
            
        </c:forEach>
	</table>
</body>
</html>