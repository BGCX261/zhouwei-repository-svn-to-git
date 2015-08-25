<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="/common/init_tag.jsp"%>
<script language="javascript" type="text/javascript"
	src="<%=request.getContextPath()%>/script/public.js"></script>
<%@ page
	import="com.techstar.dmis.helper.ddmoutageplan.DdmoutageplanHelper"%>

<%
			String upload_message = (String) request.getParameter("upload_message");
%>


<html>
	<head>
		<title>预案</title>
		<link rel="STYLESHEET" type="text/css"
			href="<%=request.getContextPath()%>/themes/themes1/style.css">
		<link rel="STYLESHEET" type="text/css"
			href="<%=request.getContextPath()%>/themes/themes1/default.css">
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/application/ddmoutageplan/DDMonthplan.js"> </script>
		<%@ include file="/common/init_js.jsp"%>
		<%@ include file="/common/init_date.jsp"%>
	</head>

	<body>



		<html:form action="/ddPremethod" enctype="multipart/form-data">
			<table class="detailmain" cellspacing="0" cellpadding="0">

				<%=upload_message.equals("null") ? "" : (upload_message
					.equals("up_s") ? "上传成功" : "上传失败")%>

				<tr>
					<td height="23" class="tab_0" width="20%">
						<bean:message
							key="define.uILabel_1ec7c596-93c4-40cf-b1b9-b49a0de07142" />
						<%--风险预案--%>

					</td>
					<td height="23" width="30%">
						<jhop:upload name="fpremethodcontent" multiValue="no"></jhop:upload>
					</td>
			</table>
			<table>
				<td>
					<div align="right">
						<html:submit>确 定</html:submit>
						<input type="button" name="button" value="取 消"
							onClick="enterData('cannel')">
					</div>
				</td>
			</table>
			<html:hidden property="method" value="add" />
			<input type="hidden" name="primaryId"
				value="<%=request.getParameter("primaryId")%>">

		</html:form>

	</body>
</html>

<script>

		function enterData(type){
			if(type != "cannel"){	
			     //dealAlertMessage("保存预案已成功");				   
			     alert("保存预案已成功");
			     window.returnValue();
             }
		     else window.close();
	    }
			
		
		
</script>
