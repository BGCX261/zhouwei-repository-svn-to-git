<%@ page language="java" pageEncoding="GBK"%>

<%@ taglib uri="/WEB-INF/tlds/struts/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tlds/struts/struts-logic.tld" prefix="logic" %>
<html>
<%
String ctx = request.getContextPath();
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>申请信息</title>
    <script language="javascript">
    	function begin(){
    		window.location.href="<%=ctx%>/workflow.do?method=start";
    	}
    	function tasks(){
    		document.forms[0].action="<%=ctx%>/workflow.do?method=getTasks";
	 		document.forms[0].submit();
    	}    	
    </script>

</head>
<body> 
	<html:form method="POST" action="workflow">
		<input type="button" value="发起新工作" onClick="begin();">	
		<html:select property="actor">
			<html:option value="fangshi">方式人员</html:option>
			<html:option value="baohu">保护人员</html:option>
			<html:option value="auditing">审核人员</html:option>
		</html:select><input type="button" value="查询待办任务列表" onClick="tasks();">	
	</html:form> 
	
</body>
</html>