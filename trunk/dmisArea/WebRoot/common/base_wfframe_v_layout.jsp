<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib uri="/WEB-INF/tlds/struts/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tlds/struts/struts-bean.tld" prefix="bean" %>

<tiles:importAttribute/>
<bean:define id="LeftFrame" name="leftFrame" type="String"/>
<bean:define id="RightFrame" name="rightFrame" type="String"/>

<%
  String str = (String)request.getAttribute("wf_id");
%>

<FRAMESET rows="*" cols="300,*" framespacing="0" frameborder="no" border="0" id="msg_left_right">
	<FRAME name="leftFrame"	src="<%=request.getContextPath()%><%=LeftFrame%>&processdefId=<%=str%>" scrolling="auto" noresize >
	<FRAME name="rightFrame" src="<%=request.getContextPath()%><%=RightFrame%>&processdefId=<%=str%>" scrolling="auto" noresize >
	<NOFRAMES>
	</NOFRAMES>
</FRAMESET>

