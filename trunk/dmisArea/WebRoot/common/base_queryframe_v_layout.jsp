<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib uri="/WEB-INF/tlds/struts/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tlds/struts/struts-bean.tld" prefix="bean" %>

<tiles:importAttribute/>
<bean:define id="LeftFrame" name="leftFrame" type="String"/>
<bean:define id="RightFrame" name="rightFrame" type="String"/>

<FRAMESET rows="*" cols="20%,*" framespacing="0" frameborder="no" border="0" id="msg_left_right">
	<FRAME name="leftFrame"	src="<%=request.getContextPath()%><%=LeftFrame%>" scrolling="auto" noresize >
	<FRAME name="rightFrame" src="<%=request.getContextPath()%><%=RightFrame%>" scrolling="auto" noresize >
	<NOFRAMES>
	</NOFRAMES>
</FRAMESET>

