<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map"%>
<%@ page import="com.techstar.dmis.helper.BusinessDetailHelper"%>
<%@ page import="com.techstar.dmis.helper.dto.BusinessDetailDto"%>
<%@ page import="com.techstar.dmis.common.ZdhConstants"%>
<%@ page import="java.sql.Timestamp"%>
<%@ include file="/common/init_tag.jsp"%>

<html>
	<head>
		<html:base />
		<title>自动化设备缺陷详情</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="../../themes/themes1/style.css" rel="stylesheet"
			type="text/css" />
		<%@ include file="/common/init_js.jsp"%>
		<%@ include file="/common/init_date.jsp"%>
		<script language="javascript" type="text/javascript"
			src="<%=request.getContextPath()%>/application/zdhfaultlist/autoeqpfaultlist_defaultDetail_detail.js"></script>

	</head>
	<body>
		<html:javascript formName="zdhFaultlistForm" />
		<logic:messagesPresent message="true">
			<html:messages id="message" message="true" header="messages.header"
				footer="messages.footer">
				<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
			</html:messages>
		</logic:messagesPresent>
		<form name="zdhFaultlistForm" action="" method="post">
			<%--hidden--%>

			<input type="hidden" name="zdhFaultlistDto.ffaultno" value="<c:out value="${zdhFaultlistForm.zdhFaultlistDto.ffaultno}"/>">
			<input type="hidden" name="zdhFaultlistDto.version"
				value="<c:out value="${zdhFaultlistForm.zdhFaultlistDto.version}"/>">
			<input type="hidden" name="zdhFaultlistDto.zzdhfaultlist7.ondutyno"
				value="<c:out value="${zdhFaultlistForm.zdhFaultlistDto.zzdhfaultlist7.ondutyno}"/>">
			<jhop:ctrlgroup
				ctrlId="UIControlGroupXPanel6f66eca16f3a497997080bfff7d53664"
				title="自动化缺陷">
			</jhop:ctrlgroup>

			<table class="detailmain" cellspacing="0" cellpadding="0">
				<tr id="UIControlGroupXPanel6f66eca16f3a497997080bfff7d53664">
					<td align="center">
						<table class="detail" width="100%" height="100%" cellspacing="0">
							<!--tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhFaultlistDto.fsysclass" />
									<%--系统类型--%>
								</td>
								<td height="23" width="30%">
									<input id="zdhFaultlistDto.fsysclass"
										name="zdhFaultlistDto.fsysclass" type="text"
										value="${zdhFaultlistForm.zdhFaultlistDto.fsysclass}"
										size="10"  />
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhFaultlistDto.ffaultno" />
									<%--缺陷记录编号--%>
								</td>
								<td height="23" width="30%">
									<input id="zdhFaultlistDto.ffaultno"
										name="zdhFaultlistDto.ffaultno" type="text"
										value="${zdhFaultlistForm.zdhFaultlistDto.ffaultno}" size="10"
										 />
								</td>
							</tr-->
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhFaultlistDto.funitname" />
									<%--设备安装地点--%>
								</td>
								<td height="23" width="30%">
									<c:out value="${zdhFaultlistForm.zdhFaultlistDto.funitname}"/>
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhFaultlistDto.fsystemname" />
									<%--系统或设备名称--%>
								</td>
								<td height="23" width="30%">
									<c:out value="${zdhFaultlistForm.zdhFaultlistDto.fsystemname}"/>
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhFaultlistDto.ffaultcontent" />
									<%--缺陷内容--%>
								</td>
								<td height="23" width="30%" colspan="3">
									<c:out value="${zdhFaultlistForm.zdhFaultlistDto.ffaultcontent}"/>
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhFaultlistDto.foccurredtime" />
									<%--发现时间--%>
								</td>
								<td height="23" width="30%">
									<c:out value="${zdhFaultlistForm.zdhFaultlistDto.foccurredtime}"/>
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhFaultlistDto.ffaultgrade" />
									<%--性质--%>
								</td>
								<td height="23" width="30%">
									<c:out value="${zdhFaultlistForm.zdhFaultlistDto.ffaultgrade}"/>
								</td>
								
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhFaultlistDto.ffaulttypeid2" />
									<%--缺陷类型ID2--%>
								</td>
								<td height="23" width="30%">
									<c:out value="${zdhFaultlistForm.zdhFaultlistDto.ffaulttypeid2}"/>

								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhFaultlistDto.ffaulttypeid1" />
									<%--缺陷类型ID1--%>
								</td>
								<td height="23" width="30%">
									<c:out value="${zdhFaultlistForm.zdhFaultlistDto.ffaulttypeid1}"/>
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhFaultlistDto.freason" />
									<%--原因及处理情况--%>
								</td>
								<td height="23" width="30%" colspan="3">
									<c:out value="${zdhFaultlistForm.zdhFaultlistDto.freason}"/>
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message
										key="object.zdhFaultlistDto.zzdhfaultlist4.feqpid" />
									<%--设备ID--%>
								</td>
								<td height="23" width="30%">
									
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhFaultlistDto.sys_isvalid" />
									<%--是否有效字段--%>
								</td>
								<td height="23" width="30%">
									<c:out value="${zdhFaultlistForm.zdhFaultlistDto.sys_isvalid}"/>
								</td>
							</tr>
						
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhFaultlistDto.stationno" />
									<%--变电站编号--%>
									<span class="article_required">*</span>
								</td>
								<td height="23" width="30%">
									<c:out value="${zdhFaultlistForm.zdhFaultlistDto.stationno}"/>"
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhFaultlistDto.fsysclass" />
									<%--系统类型--%>
								</td>
								<td height="23" width="30%">
									<c:out value="${zdhFaultlistForm.zdhFaultlistDto.fsysclass}"/>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		
			<jhop:ctrlgroup
				ctrlId="UIControlGroupXPanel97c8c0c1d5e044e39691e9770c91ed4e"
				title="缺陷检修">
			</jhop:ctrlgroup>

			<table class="detailmain" cellspacing="0" cellpadding="0">
				<tr id="UIControlGroupXPanel97c8c0c1d5e044e39691e9770c91ed4e">
					<td align="center">
						<table class="detail" width="100%" height="100%" cellspacing="0">
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhFaultlistDto.frepairunit" />
									<%--检修单位--%>
								</td>
								<td height="23" width="30%">
									<c:out value="${zdhFaultlistForm.zdhFaultlistDto.frepairunit}"/>
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhFaultlistDto.feqpfaultpart" />
									<%--缺陷部位--%>
								</td>
								<td height="23" width="30%">
									<c:out value="${zdhFaultlistForm.zdhFaultlistDto.feqpfaultpart}"/>"
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhFaultlistDto.fstaticreason" />
									<%--缺陷原因--%>
								</td>
								<td height="23" width="30%" colspan="3">
									<c:out value="${zdhFaultlistForm.zdhFaultlistDto.fstaticreason}"/>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<jhop:ctrlgroup
				ctrlId="UIControlGroupXPanelbb62e1fe4ca4483e8fbccd9725824800"
				title="缺陷恢复">
			</jhop:ctrlgroup>

			<table class="detailmain" cellspacing="0" cellpadding="0">
				<tr id="UIControlGroupXPanelbb62e1fe4ca4483e8fbccd9725824800">
					<td align="center">
						<table class="detail" width="100%" height="100%" cellspacing="0">
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhFaultlistDto.frestoretime" />
									<%--消除时间--%>
								</td>
								<td height="23" width="30%">
									<c:out value="${zdhFaultlistForm.zdhFaultlistDto.frestoretime}"/>
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhFaultlistDto.fstatus" />
									<%--缺陷消除情况--%>
								<td height="23" width="30%">
									<c:out value="${zdhFaultlistForm.zdhFaultlistDto.fstatus}"/>
								</td>
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhFaultlistDto.fremarks" />
									<%--小结--%>
								</td>
								<td height="23" width="30%" colspan="3">
									<c:out value="${zdhFaultlistForm.zdhFaultlistDto.fremarks}"/>
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhFaultlistDto.rfilltime" />
									<%--恢复填写时间--%>
								</td>
								<td height="23" width="30%">
									<!--<input id="zdhFaultlistDto.rfilltime" name="zdhFaultlistDto.rfilltime" type="text" value="${zdhFaultlistForm.zdhFaultlistDto.rfilltime}" size="10" readonly="true" />
				 -->
									<c:out value="${zdhFaultlistForm.zdhFaultlistDto.rfilltime}"/>
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhFaultlistDto.rfiller" />
									<%--恢复人--%>
								<td height="23" width="30%">
									<c:out value="${zdhFaultlistForm.zdhFaultlistDto.rfiller}"/>
								</td>
								
							</tr>
						</table>
					</td>
				</tr>
			</table>
			
		</form>
	</body>
</html>


