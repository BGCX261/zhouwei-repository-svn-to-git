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
<title>������Ϣ</title>
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
		<input type="button" value="�����¹���" onClick="begin();">	
		<html:select property="actor">
			<html:option value="fangshi">��ʽ��Ա</html:option>
			<html:option value="baohu">������Ա</html:option>
			<html:option value="auditing">�����Ա</html:option>
		</html:select><input type="button" value="��ѯ���������б�" onClick="tasks();">	
	</html:form> 
	
</body>
</html>