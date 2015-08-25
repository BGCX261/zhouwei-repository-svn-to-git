<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map"%>
<%@ include file="/common/init_tag.jsp"%>


<html>
	<head>
		<html:base />
		<title>设备重载记录详情</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="../../themes/themes1/style.css" rel="stylesheet"
			type="text/css" />
		<%@ include file="/common/init_js.jsp"%>
		<%@ include file="/common/init_date.jsp"%>
		<script language="javascript" type="text/javascript"
			src="<%=request.getContextPath()%>/application/ddhloadrecord/DDeqpoverload_defaultDetail_detail.js"></script>
		
	</head>
	<body>
		<html:javascript formName="ddHloadrecordForm" />
		<logic:messagesPresent message="true">
			<html:messages id="message" message="true" header="messages.header"
				footer="messages.footer">
				<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
			</html:messages>
		</logic:messagesPresent>
		<form name="ddHloadrecordForm" action="" method="post">
			<%--hidden--%>

			<input type="hidden" name="ddHloadrecordDto.fid"
				value="${ddHloadrecordForm.ddHloadrecordDto.fid}">
			<input type="hidden" name="ddHloadrecordDto.version"
				value="${ddHloadrecordForm.ddHloadrecordDto.version}">

			<jhop:ctrlgroup
				ctrlId="UIControlGroupXPanel608281cc399c42cd83d99a4928c81c9f"
				title="设备重载详情">
			</jhop:ctrlgroup>

			<table class="detailmain" cellspacing="0" cellpadding="0">
				<tr id="UIControlGroupXPanel608281cc399c42cd83d99a4928c81c9f">
					<td align="center">
						<table class="detail" width="100%" height="100%" cellspacing="0">

							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddHloadrecordDto.fstationname" />
									<%--重载设备厂站--%>
								</td>
								<td height="23" width="30%">
									<input id="ddHloadrecordDto.fstationname"
										name="ddHloadrecordDto.fstationname" type="text"
										value="${ddHloadrecordForm.ddHloadrecordDto.fstationname}"
										size="10" />
								</td>
								
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddHloadrecordDto.fdevclass" />
									<%--重载设备类型--%>
								</td>
								<td height="23" width="30%">
									<input id="ddHloadrecordDto.fdevclass"
										name="ddHloadrecordDto.fdevclass" type="text"
										value="${ddHloadrecordForm.ddHloadrecordDto.fdevclass}"
										size="10" />
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddHloadrecordDto.fdevname" />
									<%--重载设备名称--%>
								</td>
								<td height="23" width="30%">
									<input id="ddHloadrecordDto.fdevname"
										name="ddHloadrecordDto.fdevname" type="text"
										value="${ddHloadrecordForm.ddHloadrecordDto.fdevname}"
										size="10" />
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddHloadrecordDto.ffixcurrent" />
									<%--额定电流(A)--%>
								</td>
								<td height="23" width="30%">
									<input id="ddHloadrecordDto.ffixcurrent"
										name="ddHloadrecordDto.ffixcurrent" type="text"
										value="${ddHloadrecordForm.ddHloadrecordDto.ffixcurrent}"
										 size="10"  onBlur="calaRate();"/>
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddHloadrecordDto.fmaxloadcur" />
									<%--最大负荷电流(A)--%>
								</td>
								<td height="23" width="30%">
									<input id="ddHloadrecordDto.fmaxloadcur"
										name="ddHloadrecordDto.fmaxloadcur" type="text"
										value="${ddHloadrecordForm.ddHloadrecordDto.fmaxloadcur}"
										size="10" onBlur="calaRate();"/>
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddHloadrecordDto.fstarttime" />
									<%--开始时间--%>
								</td>
								<td height="23" width="30%">
									<jhop:date name="ddHloadrecordDto.fstarttime" genText="yes"
										dateFormat="yyyy-mm-dd"
										initValue="${ddHloadrecordForm.ddHloadrecordDto.fstarttime}"></jhop:date>
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddHloadrecordDto.fendtime" />
									<%--结束时间--%>
								</td>
								<td height="23" width="30%">
									<jhop:date name="ddHloadrecordDto.fendtime" genText="yes"
										dateFormat="yyyy-mm-dd"
										initValue="${ddHloadrecordForm.ddHloadrecordDto.fendtime}"></jhop:date>
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddHloadrecordDto.fkeeptime" />
									<%--持续时间(分钟)--%>
								</td>
								<td height="23" width="30%">
									<input id="ddHloadrecordDto.fkeeptime"
										name="ddHloadrecordDto.fkeeptime" type="text"
										value="${ddHloadrecordForm.ddHloadrecordDto.fkeeptime}"
										size="10" readonly="true" />
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddHloadrecordDto.fhighestloadrate" />
									<%--最高负载率(%)--%>
								</td>
								<td height="23" width="30%">
									<input id="ddHloadrecordDto.fhighestloadrate"
										name="ddHloadrecordDto.fhighestloadrate" type="text"
										value="${ddHloadrecordForm.ddHloadrecordDto.fhighestloadrate}"
										size="10" readonly="true" />
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddHloadrecordDto.ftemperature" />
									<%--温度(℃)--%>
								</td>
								<td height="23" width="30%">
									<input id="ddHloadrecordDto.ftemperature"
										name="ddHloadrecordDto.ftemperature" type="text"
										value="${ddHloadrecordForm.ddHloadrecordDto.ftemperature}"
										size="10" />
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddHloadrecordDto.fadopmeasure" />
									<%--采取措施--%>
								</td>
								<td height="23" width="30%">
									<jhop:select name="ddHloadrecordDto.fadopmeasure" hiddName=""
										type="fadopmeasure"
										initValue="${ddHloadrecordForm.ddHloadrecordDto.fadopmeasure}">
									</jhop:select>
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddHloadrecordDto.fiswritelog" />
									<%--是否写入日志--%>
								</td>
								<td height="23" width="30%">
									<jhop:select name="ddHloadrecordDto.fiswritelog" hiddName=""
										type="fiswritelog"
										initValue="${ddHloadrecordForm.ddHloadrecordDto.fiswritelog}">
									</jhop:select>
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddHloadrecordDto.fiswriteinwglog" />
									<%--是否写入班志--%>
								</td>
								<td height="23" width="30%">
									<jhop:select name="ddHloadrecordDto.fiswriteinwglog"
										hiddName="" type="fiswriteinwglog"
										initValue="${ddHloadrecordForm.ddHloadrecordDto.fiswriteinwglog}">
									</jhop:select>
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddHloadrecordDto.fremark" />
									<%--备注--%>
								</td>
								<td height="23" width="30%" colspan="3">
									<input id="ddHloadrecordDto.fremark"
										name="ddHloadrecordDto.fremark" type="text"
										value="${ddHloadrecordForm.ddHloadrecordDto.fremark}"
										size="10" />
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
