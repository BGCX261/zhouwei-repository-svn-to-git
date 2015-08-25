<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map"%>
<%@ page import="com.techstar.dmis.helper.BusinessDetailHelper"%>
<%@ page import="com.techstar.dmis.helper.dto.BusinessDetailDto"%>
<%@ page import="com.techstar.dmis.common.ZdhConstants"%>
<%@ page import="java.sql.Timestamp"%>
<%@ include file="/common/init_tag.jsp"%>
<%
	BusinessDetailDto bdt = BusinessDetailHelper.getBusDetailInfo(request);
	//用户登录名

	String loginName = bdt.getLoginName();
	//用户ID
	String userId = bdt.getUserId();
	//用户名称  
	String userName = bdt.getUserName();
	//当前时间  
	Timestamp currentTime = bdt.getCurrentTime();
	//用户部门ID
	String userDeptId = bdt.getUserDeptId();
	//用户部门CODE     
	String userDeptCode = bdt.getUserDeptCode();
	//用户部门名称
	String userDeptName = bdt.getUserDeptName();
	//数据所属单位ID
	String dataOwnerId = bdt.getDataOwnerId();
	//数据所属单位名称

	String dataOwnerName = bdt.getDataOwnerName();
%>
<%
	String status = (String) request.getAttribute("status");
	String fstatus = (String) request.getAttribute("fstatus");

	String readonly = "";
	if (!status.equalsIgnoreCase("") && status.equalsIgnoreCase("true")) {
		readonly = " readonly ";
	}
	String changeOnly = "";
	if (!fstatus.equalsIgnoreCase("")
	&& !fstatus.equalsIgnoreCase(ZdhConstants.ZDH_DRAFT)) {
		changeOnly = " readonly ";
	} else {
		changeOnly = readonly;
	}
	//out.println("##############"+readonly+"##########"+changeOnly);
%>
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
										size="10" <%=changeOnly%> />
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhFaultlistDto.ffaultno" />
									<%--缺陷记录编号--%>
								</td>
								<td height="23" width="30%">
									<input id="zdhFaultlistDto.ffaultno"
										name="zdhFaultlistDto.ffaultno" type="text"
										value="${zdhFaultlistForm.zdhFaultlistDto.ffaultno}" size="10"
										<%=changeOnly%> />
								</td>
							</tr-->
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhFaultlistDto.funitname" />
									<%--设备安装地点--%>
								</td>
								<td height="23" width="30%">
									<input id="zdhFaultlistDto.funitname"
										name="zdhFaultlistDto.funitname" type="text"
										value="<c:out value="${zdhFaultlistForm.zdhFaultlistDto.funitname}"/>"
										size="10" <%=changeOnly%> />
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhFaultlistDto.fsystemname" />
									<%--系统或设备名称--%>
								</td>
								<td height="23" width="30%">
									<input id="zdhFaultlistDto.fsystemname"
										name="zdhFaultlistDto.fsystemname" type="text"
										value="<c:out value="${zdhFaultlistForm.zdhFaultlistDto.fsystemname}"/>"
										size="10" <%=changeOnly%> />
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhFaultlistDto.ffaultcontent" />
									<%--缺陷内容--%>
								</td>
								<td height="23" width="30%" colspan="3">
									<textarea id='zdhFaultlistDto.ffaultcontent'
										name='zdhFaultlistDto.ffaultcontent' rows='3' cols='71'
										<%=changeOnly%>><c:out value="${zdhFaultlistForm.zdhFaultlistDto.ffaultcontent}"/></textarea>
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhFaultlistDto.foccurredtime" />
									<%--发现时间--%>
								</td>
								<td height="23" width="30%">
									<%
									if (changeOnly.equalsIgnoreCase("")) {
									%>
									<jhop:date name="zdhFaultlistDto.foccurredtime" genText="yes"
										dateFormat="yyyy-mm-dd hh:mm" showSecond="true" 
										initValue="${zdhFaultlistForm.zdhFaultlistDto.foccurredtime}"></jhop:date>
									<%
									} else {
									%>
									<input id="zdhFaultlistDto.foccurredtime"
										name="zdhFaultlistDto.foccurredtime" type="text"
										value="<c:out value="${zdhFaultlistForm.zdhFaultlistDto.foccurredtime}"/>"
										size="20" readonly />
									<%
									}
									%>
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhFaultlistDto.ffaultgrade" />
									<%--性质--%>
								</td>
								<td height="23" width="30%">
									<%
									if (changeOnly.equalsIgnoreCase("")) {
									%>
									<jhop:select name="zdhFaultlistDto.ffaultgrade" hiddName=""
										type="ffaultgrade"
										initValue="${zdhFaultlistForm.zdhFaultlistDto.ffaultgrade}">
									</jhop:select>
									<%
									} else {
									%>
									<input id="zdhFaultlistDto.ffaultgrade"
										name="zdhFaultlistDto.ffaultgrade" type="text"
										value="<c:out value="${zdhFaultlistForm.zdhFaultlistDto.ffaultgrade}"/>"
										size="10" readonly />
									<%
									}
									%>
								</td>
								
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhFaultlistDto.ffaulttypeid2" />
									<%--缺陷类型ID2--%>
								</td>
								<td height="23" width="30%">
									<%
									if (changeOnly.equalsIgnoreCase("")) {
									%>
									<jhop:select name="zdhFaultlistDto.ffaulttypeid2" hiddName=""
										type="ffaulttypeid2"
										initValue="${zdhFaultlistForm.zdhFaultlistDto.ffaulttypeid2}">
									</jhop:select>
									<%
									} else {
									%>
									<input id="zdhFaultlistDto.ffaulttypeid2"
										name="zdhFaultlistDto.ffaulttypeid2" type="text"
										value="<c:out value="${zdhFaultlistForm.zdhFaultlistDto.ffaulttypeid2}"/>"
										size="20" readonly />
									<%
									}
									%>

								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhFaultlistDto.ffaulttypeid1" />
									<%--缺陷类型ID1--%>
								</td>
								<td height="23" width="30%">
									<%
									if (changeOnly.equalsIgnoreCase("")) {
									%>
									<jhop:select name="zdhFaultlistDto.ffaulttypeid1" hiddName=""
										type="ffaulttypeid1"
										initValue="${zdhFaultlistForm.zdhFaultlistDto.ffaulttypeid1}">
									</jhop:select>
									<%
									} else {
									%>
									<input id="zdhFaultlistDto.ffaulttypeid1"
										name="zdhFaultlistDto.ffaulttypeid1" type="text"
										value="<c:out value="${zdhFaultlistForm.zdhFaultlistDto.ffaulttypeid1}"/>"
										size="10" readonly />
									<%
									}
									%>
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhFaultlistDto.freason" />
									<%--原因及处理情况--%>
								</td>
								<td height="23" width="30%" colspan="3">
									<textarea id='zdhFaultlistDto.freason'
										name='zdhFaultlistDto.freason' rows='3' cols='71'
										<%=changeOnly%>><c:out value="${zdhFaultlistForm.zdhFaultlistDto.freason}"/></textarea>
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
									<input id="zdhFaultlistDto.sys_isvalid"
										name="zdhFaultlistDto.sys_isvalid" type="text"
										value="<c:out value="${zdhFaultlistForm.zdhFaultlistDto.sys_isvalid}"/>"
										size="10" <%=changeOnly%> />
								</td>
							</tr>
							<%--填写人--%>
							<input type="hidden" name="zdhFaultlistDto.sys_fille"
				value="<c:out value="${zdhFaultlistForm.zdhFaultlistDto.sys_fille}"/>">
							<%--填写单位--%>
							<input type="hidden" name="zdhFaultlistDto.sys_filldept"
				value="<c:out value="${zdhFaultlistForm.zdhFaultlistDto.sys_filldept}"/>">
							<%--填写时间--%>
							<input type="hidden" name="zdhFaultlistDto.sys_filltime"
				value="<c:out value="${zdhFaultlistForm.zdhFaultlistDto.sys_filltime}"/>">
							<%--是否有效字段--%>
							<!--input type="hidden" name="zdhFaultlistDto.sys_isvalid"
				value="${zdhFaultlistForm.zdhFaultlistDto.sys_isvalid}"-->
							<%--数据所属单位--%>
							<input type="hidden" name="zdhFaultlistDto.sys_dataowner"
				value="<c:out value="${zdhFaultlistForm.zdhFaultlistDto.sys_dataowner}"/>">
							<!--tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhFaultlistDto.sys_filldept" />
									<%--填写单位--%>
								</td>
								<td height="23" width="30%">
									<input id="zdhFaultlistDto.sys_filldept"
										name="zdhFaultlistDto.sys_filldept" type="text"
										value="${zdhFaultlistForm.zdhFaultlistDto.sys_filldept}"
										size="10" readonly />
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhFaultlistDto.sys_filltime" />
									<%--填写时间--%>
								</td>
								<td height="23" width="30%">
									<input id="zdhFaultlistDto.sys_filltime"
										name="zdhFaultlistDto.sys_filltime" type="text"
										value="${zdhFaultlistForm.zdhFaultlistDto.sys_filltime}"
										size="20" readonly />
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhFaultlistDto.sys_fille" />
									<%--填写人--%>
								</td>
								<td height="23" width="30%">
									<input id="zdhFaultlistDto.sys_fille"
										name="zdhFaultlistDto.sys_fille" type="text"
										value="${zdhFaultlistForm.zdhFaultlistDto.sys_fille}"
										size="10" readonly />
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhFaultlistDto.sys_dataowner" />
									<%--数据所属单位--%>
								</td>
								<td height="23" width="30%">
									<input id="zdhFaultlistDto.sys_dataowner"
										name="zdhFaultlistDto.sys_dataowner" type="text"
										value="${zdhFaultlistForm.zdhFaultlistDto.sys_dataowner}"
										size="10" readonly />
								</td>
							</tr-->
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhFaultlistDto.stationno" />
									<%--变电站编号--%>
									<span class="article_required">*</span>
								</td>
								<td height="23" width="30%">
									<input id="zdhFaultlistDto.stationno"
										name="zdhFaultlistDto.stationno" type="text"
										value="<c:out value="${zdhFaultlistForm.zdhFaultlistDto.stationno}"/>"
										size="10" <%=changeOnly%> />
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhFaultlistDto.fsysclass" />
									<%--系统类型--%>
								</td>
								<td height="23" width="30%">
									<input id="zdhFaultlistDto.fsysclass"
										name="zdhFaultlistDto.fsysclass" type="text"
										value="<c:out value="${zdhFaultlistForm.zdhFaultlistDto.fsysclass}"/>"
										size="10" <%=changeOnly%> />
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<%
					if (!fstatus.equalsIgnoreCase("")
					&& !fstatus.equalsIgnoreCase(ZdhConstants.ZDH_DRAFT)) {
			%>
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
									<input id="zdhFaultlistDto.frepairunit"
										name="zdhFaultlistDto.frepairunit" type="text"
										value="<c:out value="${zdhFaultlistForm.zdhFaultlistDto.frepairunit}"/>"
										size="10" <%=readonly%> />
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhFaultlistDto.feqpfaultpart" />
									<%--缺陷部位--%>
								</td>
								<td height="23" width="30%">
									<input id="zdhFaultlistDto.feqpfaultpart"
										name="zdhFaultlistDto.feqpfaultpart" type="text"
										value="<c:out value="${zdhFaultlistForm.zdhFaultlistDto.feqpfaultpart}"/>"
										size="10" <%=readonly%> />
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhFaultlistDto.fstaticreason" />
									<%--缺陷原因--%>
								</td>
								<td height="23" width="30%" colspan="3">
									<input id="zdhFaultlistDto.fstaticreason"
										name="zdhFaultlistDto.fstaticreason" type="text"
										value="<c:out value="${zdhFaultlistForm.zdhFaultlistDto.fstaticreason}"/>"
										size="10" <%=readonly%> />
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
									<%
									if (readonly.equalsIgnoreCase("")) {
									%>
									<!--<jhop:dateselect name="zdhFaultlistDto.frestoretime" startName="zdhFaultlistDto.foccurredtime" initValue="${zdhFaultlistForm.zdhFaultlistDto.frestoretime}" dateFormat="yyyy-mm-dd hh:mm:ss" group="end" ></jhop:dateselect>-->
									<jhop:date name="zdhFaultlistDto.frestoretime" genText="yes" showSecond="true" 
										dateFormat="yyyy-mm-dd hh:mm"
										initValue="${zdhFaultlistForm.zdhFaultlistDto.frestoretime}"></jhop:date>
									<%
									} else {
									%>
									<input id="zdhFaultlistDto.frestoretime"
										name="zdhFaultlistDto.frestoretime" type="text"
										value="<c:out value="${zdhFaultlistForm.zdhFaultlistDto.frestoretime}"/>"
										size="20" readonly />
									<%
									}
									%>
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhFaultlistDto.fstatus" />
									<%--缺陷消除情况--%>
								<td height="23" width="30%">
									<input id="zdhFaultlistDto.fstatus"
										name="zdhFaultlistDto.fstatus" type="text"
										value="<c:out value="${zdhFaultlistForm.zdhFaultlistDto.fstatus}"/>" size="10"
										readonly />
								</td>
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhFaultlistDto.fremarks" />
									<%--小结--%>
								</td>
								<td height="23" width="30%" colspan="3">
									<textarea id='zdhFaultlistDto.fremarks'
										name='zdhFaultlistDto.fremarks' rows='3' cols='71'
										<%=readonly%>><c:out value="${zdhFaultlistForm.zdhFaultlistDto.fremarks}"/></textarea>
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
									<%
									if (readonly.equalsIgnoreCase("")) {
									%>
									<jhop:date name="zdhFaultlistDto.rfilltime" genText="yes"
										dateFormat="yyyy-mm-dd hh:mm" showSecond="true" 
										initValue="${zdhFaultlistForm.zdhFaultlistDto.rfilltime}"></jhop:date>
									<%
									} else {
									%>
									<input id="zdhFaultlistDto.rfilltime"
										name="zdhFaultlistDto.rfilltime" type="text"
										value="<c:out value="${zdhFaultlistForm.zdhFaultlistDto.rfilltime}"/>"
										size="20" readonly />
									<%
									}
									%>
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhFaultlistDto.rfiller" />
									<%--恢复人--%>
								<td height="23" width="30%">
									<input id="zdhFaultlistDto.rfiller"
										name="zdhFaultlistDto.rfiller" type="text"
										value="<c:out value="${zdhFaultlistForm.zdhFaultlistDto.rfiller}"/>" size="10"
										readonly="true" <%=readonly%> />
								</td>
								
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<%
			}
			%>
		</form>
	</body>
</html>

<script>
	var id = document.getElementById('zdhFaultlistDto.ffaultno').value;
	//进行初始化动作

    if (id == null || id == '' || id == 'undefined'){
		//初始化填单人		
       //document.getElementById('zdhFaultlistDto.sys_fille').value = '<%= userName %>';
       //初始化填写单位       
       document.getElementById('zdhFaultlistDto.sys_filldept').value = '<%= userDeptName %>';
       //初始化填写时间
       document.getElementById('zdhFaultlistDto.sys_filltime').value = '<%= currentTime %>';
       //数据所属单位
       document.getElementById('zdhFaultlistDto.sys_dataowner').value = '<%= dataOwnerName %>';
       	
	}
</script>
