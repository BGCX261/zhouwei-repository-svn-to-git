<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<head>
	<%@ include file="/commons/head.jsp"%>
	<title>${key.title}</title>
</head>
<html>
	<body>
		<form id="photoUploadForm" name="test" enctype="multipart/form-data"
			method="post" action="${ctx}/categoryAction.do?method=fileUpload">
			<table width="500px" border="1" align="center">
				<tr>
					<td align="left">
						<input name="photo" size="40" type="file" />
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<div align="center">
							<input type="submit" name="save" value="上传">
						</div>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>