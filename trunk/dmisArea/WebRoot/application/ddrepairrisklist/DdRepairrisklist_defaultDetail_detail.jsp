<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map"%>
<%@ include file="/common/init_tag.jsp"%>
<html>
	<head>
		<html:base />
		<title>电网风险提示详情</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="../../themes/themes1/style.css" rel="stylesheet"
			type="text/css" />
		<%@ include file="/common/init_js.jsp"%>
		<%@ include file="/common/init_date.jsp"%>
		<script language="javascript" type="text/javascript"
			src="<%=request.getContextPath()%>/application/ddrepairrisklist/DdRepairrisklist_defaultDetail_detail.js"></script>
	</head>
	<body>
		<html:javascript formName="ddRepairrisklistForm" />
		<logic:messagesPresent message="true">
			<html:messages id="message" message="true" header="messages.header"
				footer="messages.footer">
				<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
			</html:messages>
		</logic:messagesPresent>
		<form name="ddRepairrisklistForm" action="" method="post">
			<%--hidden--%>

			<input type="hidden" name="ddRepairrisklistDto.fid"
				value="${ddRepairrisklistForm.ddRepairrisklistDto.fid}">
			<input type="hidden" name="ddRepairrisklistDto.version"
				value="${ddRepairrisklistForm.ddRepairrisklistDto.version}">
			<input type="hidden" name="ddRepairrisklistDto.fexcutestatus"
				value="${ddRepairrisklistForm.ddRepairrisklistDto.fexcutestatus}">	
			<input type="hidden" name="ddRepairrisklistDto.sys_fille"
				value="${ddRepairrisklistForm.ddRepairrisklistDto.sys_fille}">	
			<input type="hidden" name="ddRepairrisklistDto.sys_filldept"
				value="${ddRepairrisklistForm.ddRepairrisklistDto.sys_filldept}">	
			<input type="hidden" name="ddRepairrisklistDto.sys_filltime"
				value="${ddRepairrisklistForm.ddRepairrisklistDto.sys_filltime}">			
			<input type="hidden" name="ddRepairrisklistDto.sys_isvalid"
				value="${ddRepairrisklistForm.ddRepairrisklistDto.sys_isvalid}">	
			<input type="hidden" name="ddRepairrisklistDto.sys_dataowner"
				value="${ddRepairrisklistForm.ddRepairrisklistDto.sys_dataowner}">	
			<input type="hidden" name="ddRepairrisklistDto.sys_filltime"
				value="${ddRepairrisklistForm.ddRepairrisklistDto.sys_filltime}">					

			<jhop:ctrlgroup
				ctrlId="UIControlGroupXPanelef162212fbee4916bccf5c40ee69efc3"
				title="电网风险提示">
			</jhop:ctrlgroup>

			<table class="detailmain" cellspacing="0" cellpadding="0">
				<tr id="UIControlGroupXPanelef162212fbee4916bccf5c40ee69efc3">
					<td align="center">
						<table class="detail" width="100%" height="100%" cellspacing="0">
							<tr>

								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddRepairrisklistDto.ftransformer" />
									<%--变压器--%>
								</td>


								<td height="23" width="30%">
									<input id="ddRepairrisklistDto.ftransformer"
										name="ddRepairrisklistDto.ftransformer" type="text"
										value="${ddRepairrisklistForm.ddRepairrisklistDto.ftransformer}"
										size="10" />
								</td>


								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddRepairrisklistDto.fline" />
									<%--线路--%>
								</td>


								<td height="23" width="30%">
									<input id="ddRepairrisklistDto.fline"
										name="ddRepairrisklistDto.fline" type="text"
										value="${ddRepairrisklistForm.ddRepairrisklistDto.fline}"
										size="10" />
								</td>

							</tr>
							<tr>

								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddRepairrisklistDto.fworkcontent" />
									<%--工作内容--%>
								</td>


								<td height="23" width="30%" colspan="3">
									<textarea id='ddRepairrisklistDto.fworkcontent'
										name='ddRepairrisklistDto.fworkcontent' rows='3' cols='50'>${ddRepairrisklistForm.ddRepairrisklistDto.fworkcontent}</textarea>
								</td>

							</tr>
							<tr>

								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddRepairrisklistDto.foutagestime" />
									<%--检修开始时间--%>
									<span class="article_required">*</span>
								</td>


								<td height="23" width="30%">
									<jhop:dateselect name="ddRepairrisklistDto.foutagestime"
										endName="ddRepairrisklistDto.foutageetime"
										initValue="${ddRepairrisklistForm.ddRepairrisklistDto.foutagestime}"
										dateFormat="yyyy-mm-dd hh:mm:ss" group="start"></jhop:dateselect>
								</td>


								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddRepairrisklistDto.foutageetime" />
									<%--检修结束时间--%>
									<span class="article_required">*</span>
								</td>


								<td height="23" width="30%">
									<jhop:dateselect name="ddRepairrisklistDto.foutageetime"
										startName="ddRepairrisklistDto.foutagestime"
										initValue="${ddRepairrisklistForm.ddRepairrisklistDto.foutageetime}"
										dateFormat="yyyy-mm-dd hh:mm:ss" group="end"></jhop:dateselect>
								</td>

							</tr>
							<tr>

								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddRepairrisklistDto.friskprompt" />
									<%--风险提示--%>
								</td>


								<td height="23" width="30%" colspan="3">
									<textarea id='ddRepairrisklistDto.friskprompt'
										name='ddRepairrisklistDto.friskprompt' rows='3' cols='50'>${ddRepairrisklistForm.ddRepairrisklistDto.friskprompt}</textarea>
								</td>

							</tr>
							<tr>

								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddRepairrisklistDto.fforecast" />
									<%--天气预报--%>
								</td>


								<td height="23" width="30%" colspan="3">
									<textarea id='ddRepairrisklistDto.fforecast'
										name='ddRepairrisklistDto.fforecast' rows='3' cols='50'>${ddRepairrisklistForm.ddRepairrisklistDto.fforecast}</textarea>
								</td>

							</tr>
							<tr>

								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddRepairrisklistDto.friskunit" />
									<%--风险相关单位--%>
								</td>


								<td height="23" width="30%" colspan="3">
									<textarea id='ddRepairrisklistDto.friskunit'
										name='ddRepairrisklistDto.friskunit' rows='3' cols='50'>${ddRepairrisklistForm.ddRepairrisklistDto.friskunit}</textarea>
								</td>

							</tr>
							<tr>

								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddRepairrisklistDto.fdangerreason" />
									<%--风险原因--%>
								</td>


								<td height="23" width="30%" colspan="3">
									<jhop:select name="ddRepairrisklistDto.fdangerreason"
										hiddName="" type="StdRiskreason"
										initValue="${ddRepairrisklistForm.ddRepairrisklistDto.fdangerreason}">
									</jhop:select>
								</td>

							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
