<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib uri="/WEB-INF/tlds/struts/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tlds/struts/struts-bean.tld" prefix="bean" %>

<tiles:importAttribute/>
<bean:define id="UpFrame" name="upFrame" type="String"/>
<bean:define id="DownFrame" name="downFrame" type="String"/>
 
<bean:define id="DownScroll" name="downScroll" type="String"/>

<%
  String str = (String)request.getAttribute("wf_id");
 
%>

<FRAMESET rows="300,*" cols="*" framespacing="0" frameborder="no" border="0" id="msg_up_down">
	<FRAME name="upFrame"	src="<%=request.getContextPath()%><%=UpFrame%>&processdefId=<%=str%>" scrolling="no" noresize >
	<FRAME name="downFrame" src="<%=request.getContextPath()%><%=DownFrame%>" scrolling="<%=DownScroll%>" noresize >
	<NOFRAMES>
	</NOFRAMES>
</FRAMESET>