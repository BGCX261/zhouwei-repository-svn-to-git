<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ page import="com.techstar.framework.service.security.SecurityContext" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>

<%
   String  name = (String)request.getParameter("username");
   //System.out.println("ffff"+name);
    //request.getSession().setAttribute("username","");
    request.getSession().setAttribute("username","caichaoyang");
   //System.out.println("gggggg"+SecurityContext.SECURITY_IMRP_MENU_KEY);
   response.sendRedirect(request.getContextPath()+"/login.do?username=caichaoyang");
   
   
 %>