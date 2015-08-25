<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map"%>
<%@ include file="/common/init_tag.jsp"%>
<%@ page import="com.techstar.dmis.dto.DdRepairrisklistDto"%>
<%@ page
	import="com.techstar.dmis.helper.ddmoutageplan.DdmoutageplanHelper"%>
<%
			DdRepairrisklistDto ddRepairrisklistDto = (DdRepairrisklistDto) request
			.getAttribute("initRiskanalyseDto");
%>
<html>
	<head>
		<html:base />
		<title>月停电计划详情</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="../../themes/themes1/style.css" rel="stylesheet"
			type="text/css" />
		<%@ include file="/common/init_js.jsp"%>
		<%@ include file="/common/init_date.jsp"%>
		<script language="javascript" type="text/javascript"
			src="<%=request.getContextPath()%>/application/ddmoutageplan/DDMonthplan_Riskanalyse_detail.js"></script>
	</head>
	<body>
		<html:javascript formName="ddMoutageplanForm" />
		<logic:messagesPresent message="true">
			<html:messages id="message" message="true" header="messages.header"
				footer="messages.footer">
				<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
			</html:messages>
		</logic:messagesPresent>


		<jhop:ctrlgroup
			ctrlId="UIControlGroupXPanel8064a0350b8d487986ee604ce73f002f"
			title="电网风险提示">
		</jhop:ctrlgroup>

		<table class="detailmain" cellspacing="0" cellpadding="0">
			<tr id="UIControlGroupXPanel8064a0350b8d487986ee604ce73f002f">
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
									value="<%=DdmoutageplanHelper.pageDisposeNull(ddRepairrisklistDto
							.getFtransformer())%>"
									size="10" disabled="disabled" />
							</td>


							<td height="23" class="tab_0" width="20%">
								<bean:message key="object.ddRepairrisklistDto.fline" />
								<%--线路--%>
							</td>


							<td height="23" width="30%">
								<input id="ddRepairrisklistDto.fline"
									name="ddRepairrisklistDto.fline" type="text"
									value="<%=DdmoutageplanHelper.pageDisposeNull(ddRepairrisklistDto
							.getFline())%>"
									size="10" disabled="disabled" />
							</td>

						</tr>
						<tr>

							<td height="23" class="tab_0" width="20%">
								<bean:message key="object.ddMoutageplanDto.fworkcontent" />
								<%--工作内容--%>
								<span class="article_required">*</span>
							</td>


							<td height="23" width="30%" colspan="3">
								<textarea rows='3' cols='50' disabled="disabled">
									<%=DdmoutageplanHelper.pageDisposeNull(ddRepairrisklistDto
							.getFworkcontent())%>
								</textarea>
							</td>

						</tr>
						<tr>

							<td height="23" class="tab_0" width="20%">
								<bean:message
									key="define.uILabel_9a28e2a3-f11e-44ab-93db-3bb945b54534" />
								<%--开始时间--%>
								<span class="article_required">*</span>
							</td>


							<td height="23" width="30%">

								<input type="text"
									value="<%=DdmoutageplanHelper.pageDisposeNull(ddRepairrisklistDto
							.getFoutagestime())%>"
									size="10" disabled="disabled" />

							</td>


							<td height="23" class="tab_0" width="20%">
								<bean:message
									key="define.uILabel_7d9e40d8-8922-4790-822b-18fd05d454bd" />
								<%--结束时间--%>
								<span class="article_required">*</span>
							</td>


							<td height="23" width="30%">
								<input type="text"
									value="<%=DdmoutageplanHelper.pageDisposeNull(ddRepairrisklistDto
							.getFoutageetime())%>"
									size="10" disabled="disabled" />

							</td>

						</tr>
						<tr>

							<td height="23" class="tab_0" width="20%">
								<bean:message
									key="object.ddMoutageplanDto.fddrepairrisklist1.friskprompt" />
								<%--风险提示--%>
								<span class="article_required">*</span>
							</td>


							<td height="23" width="30%" colspan="3">
								<textarea rows='3' cols='50' disabled="disabled">
									<%=DdmoutageplanHelper.pageDisposeNull(ddRepairrisklistDto
							.getFriskprompt())%>
								</textarea>
							</td>

						</tr>
						<tr>

							<td height="23" class="tab_0" width="20%">
								<bean:message
									key="object.ddMoutageplanDto.fddrepairrisklist1.fforecast" />
								<%--天气预报--%>
								<span class="article_required">*</span>
							</td>


							<td height="23" width="30%" colspan="3">
								<textarea rows='3' cols='50' disabled="disabled">
									<%=DdmoutageplanHelper.pageDisposeNull(ddRepairrisklistDto
							.getFforecast())%>
								</textarea>
							</td>

						</tr>
						<tr>

							<td height="23" class="tab_0" width="20%">
								<bean:message
									key="object.ddMoutageplanDto.fddrepairrisklist1.friskunit" />
								<%--风险相关单位--%>
							</td>


							<td height="23" width="30%" colspan="3">
								<textarea rows='3' cols='50' disabled="disabled">
									<%=DdmoutageplanHelper.pageDisposeNull(ddRepairrisklistDto
							.getFriskunit())%>
									</textarea>
							</td>

						</tr>
						<tr>

							<td height="23" class="tab_0" width="20%">
								<bean:message
									key="object.ddMoutageplanDto.fddrepairrisklist1.fdangerreason" />
								<%--风险原因--%>
								<span class="article_required">*</span>
							</td>
							<td height="23" width="30%" colspan="3">
								<input type="text" size="10" disabled="disabled" 
								value="<%=DdmoutageplanHelper.pageDisposeNull(ddRepairrisklistDto.getFdangerreason())%>"	/>
							</td>
						</tr>

					</table>
				</td>
			</tr>
		</table>
	</body>
</html>
