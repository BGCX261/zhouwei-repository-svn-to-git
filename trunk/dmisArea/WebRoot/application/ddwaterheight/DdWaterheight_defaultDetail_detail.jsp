<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map"%>
<%@ include file="/common/init_tag.jsp"%>
<html>
	<head>
		<html:base />
		<title>水电运行(水位)记录详情</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="../../themes/themes1/style.css" rel="stylesheet"
			type="text/css" />
		<%@ include file="/common/init_js.jsp"%>
		<%@ include file="/common/init_date.jsp"%>
		<script language="javascript" type="text/javascript"
			src="<%=request.getContextPath()%>/application/ddwaterheight/DdWaterheight_defaultDetail_detail.js"></script>
	</head>
	<body>
		<html:javascript formName="ddWaterheightForm" />
		<logic:messagesPresent message="true">
			<html:messages id="message" message="true" header="messages.header"
				footer="messages.footer">
				<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
			</html:messages>
		</logic:messagesPresent>
		<form name="ddWaterheightForm" action="" method="post">
			<%--hidden--%>

			<input type="hidden" name="ddWaterheightDto.fid"
				value="${ddWaterheightForm.ddWaterheightDto.fid}">
			<input type="hidden" name="ddWaterheightDto.version"
				value="${ddWaterheightForm.ddWaterheightDto.version}">

			<input type="hidden" name="ddWaterheightDto.sys_fille" 
				value="${ddWaterheightForm.ddWaterheightDto.sys_fille}">	
				
			<input type="hidden" name="ddWaterheightDto.sys_filldept" 
				value="${ddWaterheightForm.ddWaterheightDto.sys_filldept}">
			<input type="hidden" name="ddWaterheightDto.sys_filltime" 
				value="${ddWaterheightForm.ddWaterheightDto.sys_filltime}">
				
			<input type="hidden" name="ddWaterheightDto.sys_isvalid" 
				value="${ddWaterheightForm.ddWaterheightDto.sys_isvalid}">
			<input type="hidden"	name="ddWaterheightDto.sys_dataowner" 
				value="${ddWaterheightForm.ddWaterheightDto.sys_dataowner}">
			<input type="hidden"	name="ddWaterheightDto.zddwaterheight3.fid" 
				value="${ddWaterheightForm.ddWaterheightDto.zddwaterheight3.fid}">
			<input type="hidden"	name="ddWaterheightDto.flogdate" 
				value="${ddWaterheightForm.ddWaterheightDto.flogdate}">
				
				


			<jhop:ctrlgroup
				ctrlId="UIControlGroupXPanelf65d2beb61af4b03934a653fb471585d"
				title="电厂水位纪录">
			</jhop:ctrlgroup>

			<table class="detailmain" cellspacing="0" cellpadding="0">
				<tr id="UIControlGroupXPanelf65d2beb61af4b03934a653fb471585d">
					<td align="center">
						<table class="detail" width="100%" height="100%" cellspacing="0">
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddWaterheightDto.fwaterlevel" />
									<%--水位(米)--%>
								</td>
								<td height="23" width="30%">
									<input id="ddWaterheightDto.fwaterlevel"
										name="ddWaterheightDto.fwaterlevel" type="text"
										value="${ddWaterheightForm.ddWaterheightDto.fwaterlevel}"
										size="10" />
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddWaterheightDto.fwaterleveltime" />
									<%--时间--%>
								</td>
								<td height="23" width="30%">
									<jhop:select name="ddWaterheightDto.fwaterleveltime"
										hiddName="" type="StdDdwatercheck"
										initValue="${ddWaterheightForm.ddWaterheightDto.fwaterleveltime}">
									</jhop:select>
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
								
									<bean:message key="object.ddWaterheightDto.fpowerplant" />
									<%--电厂名--%>

								</td>
								
								<td height="23" width="30%" colspan="3">
									<input type="text" name="ddWaterheightDto.fpowerplant"
										value="${ddWaterheightForm.ddWaterheightDto.fpowerplant}" />
									<input type="hidden"
										name="ddWaterheightDto.zddwaterheight2.stationno" />
									<img id="img1"
										src="<%=request.getContextPath()%>/themes/themes1/images/main/find.gif"
										onClick="setStdStationSelect('ddWaterheightDto.fpowerplant','ddWaterheightDto.zddwaterheight2.stationno','0');">
								</td>
							</tr>
							
							<tr>
								<td height="23" class="tab_0" width="20%">
									&nbsp;
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
