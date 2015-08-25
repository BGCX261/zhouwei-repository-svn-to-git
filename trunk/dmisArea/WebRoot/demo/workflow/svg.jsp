<?xml version="1.0"  encoding="UTF-8" standalone="no"?>

<%@ page contentType="image/svg+xml; charset=UTF-8" %>
<% 
String xmlStr = (String)request.getAttribute("xml");
out.println(xmlStr);
%>