<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ page import="org.apache.struts.util.MessageResources"%>
<%@ page import="java.util.*"%>
<%@ page import="org.apache.struts.Globals" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true"/>
<%
MessageResources messageResources =(MessageResources)request.getAttribute(Globals.MESSAGES_KEY);

String message=messageResources.getMessage(request.getLocale(),"CategoryEdit.save");
 %>
<html>
	<head>
		<title>${key.title}</title>
	</head>
	<body>

		<form id="CategoryVoForm"
			action="${ctx}/categoryAction.do?method=doSave&catid=${ currentEntity.catid}"
			method="post">
			<table width="500px" border="1" align="center">
				<input type="hidden" id="catid" name="catid"
					value="${ currentEntity.catid}">
				<tr>
					<td>
						<div align="center">
							<bean:message key="name" />
						</div>
					</td>
					<td>
						<input type="text" id="name" name="name"
							value="${ currentEntity.name}">
					</td>
				</tr>
				<tr>
					<td>
						<div align="center">
							<bean:message key="descn" />
						</div>
					</td>
					<td>
						<input type="text" id="descn" name="descn"
							value="${ currentEntity.descn}">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<div align="center">
							<input type="submit" name="save" value="<%=message %>">
						</div>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>