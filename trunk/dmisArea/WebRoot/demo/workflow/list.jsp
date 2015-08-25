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
    	function endTask(taskId){
    		window.location.href="<%=ctx%>/workflow.do?method=endTask&taskId="+taskId;
    	} 
    	function getGpd(taskId){
    		window.location.href="<%=ctx%>/demo/workflow/showSvg.jsp?taskId="+taskId;
    	}     	   	
    	function tasks(){
    		document.forms[0].action="<%=ctx%>/workflow.do?method=getTasks";
	 		document.forms[0].submit();
    	}    	
    </script>

</head>
<body> 
	<html:form method="POST" action="workflow">
		<html:select property="actor">
			<html:option value="fangshi">方式人员</html:option>
			<html:option value="baohu">保护人员</html:option>
			<html:option value="auditing">审核人员</html:option>
		</html:select><input type="button" value="查询待办任务列表" onClick="tasks();">	
		<table width="358" border="1" height="82">
			<tbody>
				<tr>
					<td>业务编号</td>
					<td>任务名称</td>
					<td>下达时间</td>
					<td></td>
				</tr>
				
				<logic:iterate id="objlist" name="objectlist" indexId="index">
				<tr>
					<td><bean:write name="objlist" property="businessId" filter="false" /></td>
					<td><bean:write name="objlist" property="taskName" filter="false" /></td>
					<td><bean:write name="objlist" property="createDate" filter="false" /></td>
					<td><bean:write name="objlist" property="actorId" filter="false" /></td>
					<td><bean:write name="objlist" property="actorName" filter="false" /></td>
					<td><bean:write name="objlist" property="taskId" filter="false" /><input type="button" value="流转" onClick="endTask('<bean:write name="objlist" property="taskId" filter="false" />');"></td>
					<td><input type="button" value="流转图形" onClick="getGpd('<bean:write name="objlist" property="taskId" filter="false" />');"></td>
				</tr>
				</logic:iterate>
			</tbody>
		</table>
	</html:form> 
	<input type="button" value="发起新工作" onClick="begin();">	
	
</body>
</html>