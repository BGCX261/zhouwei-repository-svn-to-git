<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib uri="/WEB-INF/tlds/struts/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tlds/struts/struts-bean.tld" prefix="bean" %>

<tiles:importAttribute/>
<bean:define id="Up_leftFrame" name="up_leftFrame" type="String"/>
<bean:define id="Up_rightFrame" name="up_rightFrame" type="String"/>
<bean:define id="DownFrame" name="downFrame" type="String"/>
 
<bean:define id="DownScroll" name="downScroll" type="String"/>

<%
  String str = (String)request.getAttribute("wf_id");
 
%>

<frameset rows="*,120" cols="*" frameborder="no" border="0" framespacing="0">
  <frameset cols="*,450" frameborder="no" border="0" framespacing="0">
    <frame src="<%=request.getContextPath()%><%=Up_leftFrame%>&processdefId=<%=str%>" name="leftFrame" id="leftFrame" title="mainFrame" />
    <frame src="<%=request.getContextPath()%><%=Up_rightFrame%>&processdefId=<%=str%>"name="rightFrame" scrolling="No" noresize="noresize" id="rightFrame" title="rightFrame" />
  </frameset>
  <frame src="<%=request.getContextPath()%><%=DownFrame%>&processdefId=<%=str%>" name="downFrame" scrolling="No" noresize="noresize" id="downFrame" title="bottomFrame" />
</frameset>

