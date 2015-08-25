<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true"/>
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
							<input type="submit" name="save" value="<bean:message key="CategoryEdit.save" />">
						</div>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>