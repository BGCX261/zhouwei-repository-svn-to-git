<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib uri="/WEB-INF/tlds/struts/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tlds/struts/struts-bean.tld" prefix="bean" %>

<%
  String node_id = (String)request.getAttribute("node_id");
  String wf_id = (String)request.getAttribute("wf_id");
  
  //String url =request.getContextPath()+""";
  //response.sendRedirect();

%>