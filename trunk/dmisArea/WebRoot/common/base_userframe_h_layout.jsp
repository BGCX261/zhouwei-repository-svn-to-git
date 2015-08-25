<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib uri="/WEB-INF/tlds/struts/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tlds/struts/struts-bean.tld" prefix="bean" %>

<tiles:importAttribute/>
<bean:define id="UpFrame" name="upFrame" type="String"/>
<bean:define id="DownFrame" name="downFrame" type="String"/>
 
<bean:define id="DownScroll" name="downScroll" type="String"/>

<%
  String tasktype = (String)request.getAttribute("tasktype");
  
  if (tasktype==null){tasktype="0";}
  String node_id = (String)request.getAttribute("node_id");
  String processdefId = (String)request.getAttribute("processdefId");
  String receiver = (String)request.getAttribute("receiver");
  
   
  String str="&tasktype="+tasktype+"&node_id="+node_id+"&processdefId="+processdefId+"&receiver="+receiver;
  String str2="&taskdef_id="+node_id+"&processdef_id="+processdefId+"&tasktype="+tasktype;
 
 
 
%>

<FRAMESET rows="250,*" cols="*" framespacing="0" frameborder="no" border="0" id="msg_up_down">
	<FRAME name="upFrame"	src="<%=request.getContextPath()%><%=UpFrame%><%=str%>&type=12" scrolling="no" noresize >
	<FRAME name="downFrame" src="<%=request.getContextPath()%><%=DownFrame%><%=str2%>" scrolling="<%=DownScroll%>" noresize >
	<NOFRAMES>
	</NOFRAMES>
</FRAMESET>