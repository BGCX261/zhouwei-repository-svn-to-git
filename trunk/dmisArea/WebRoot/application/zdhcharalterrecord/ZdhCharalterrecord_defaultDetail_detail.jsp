<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map"%>
<%@ page import="com.techstar.dmis.helper.BusinessDetailHelper"%>
<%@ page import="com.techstar.dmis.helper.dto.BusinessDetailDto"%>
<%@ page import="java.sql.Timestamp"%>
<%@ include file="/common/init_tag.jsp"%>
<%@ page import="org.apache.commons.lang.StringUtils"%>
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
	String taskExplan = (String) request.getAttribute("taskExplan");
	//out.println("#######################"+taskExplan);
%>
<html>
	<head>
		<html:base />
		<title>系统图修改记录详情</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="../../themes/themes1/style.css" rel="stylesheet"
			type="text/css" />
		<%@ include file="/common/init_js.jsp"%>
		<%@ include file="/common/init_date.jsp"%>
		<script language="javascript" type="text/javascript"
			src="<%=request.getContextPath()%>/application/zdhcharalterrecord/ZdhCharalterrecord_defaultDetail_detail.js"></script>
	</head>
	<body>
		<html:javascript formName="zdhCharalterrecordForm" />
		<logic:messagesPresent message="true">
			<html:messages id="message" message="true" header="messages.header"
				footer="messages.footer">
				<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
			</html:messages>
		</logic:messagesPresent>
		<form name="zdhCharalterrecordForm" action="" method="post"
			enctype="multipart/form-data">
			<%--hidden--%>

			<input type="hidden" name="zdhCharalterrecordDto.recordsno"
				value="<c:out value="${zdhCharalterrecordForm.zdhCharalterrecordDto.recordsno}"/>">
			<input type="hidden" name="zdhCharalterrecordDto.version"
				value="<c:out value="${zdhCharalterrecordForm.zdhCharalterrecordDto.version}"/>">

			<jhop:ctrlgroup
				ctrlId="UIControlGroupXPanel24322572093a4c868c9cc839d68d9eac"
				title="系统图修改任务信息">
			</jhop:ctrlgroup>

			<table class="detailmain" cellspacing="0" cellpadding="0">
				<tr id="UIControlGroupXPanel24322572093a4c868c9cc839d68d9eac">
					<td align="center">
						<table class="detail" width="100%" height="100%" cellspacing="0">
							<tr>
								<td height="23" class="tab_0" width="15%">
									<bean:message
										key="object.zdhCharalterrecordDto.mdiagram" />
									<%--停电附图--%>
								</td>
								<td height="23" width="85%" colspan="3">
									<jhop:upload name="mdiagram" multiValue="no"></jhop:upload>
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="15%">
									<bean:message
										key="object.zdhCharalterrecordDto.taskexplanation" />
									<%--工作任务说明--%>
								</td>
								<td height="23" width="85%" colspan="3">
									<textarea id='zdhCharalterrecordDto.taskexplanation'
										name='zdhCharalterrecordDto.taskexplanation' rows='3'
										cols='71'><c:out value="${zdhCharalterrecordForm.zdhCharalterrecordDto.taskexplanation}"/></textarea>
								</td>
							</tr>
							<%--填写人--%>
							<input type="hidden" name="zdhCharalterrecordDto.sys_fille"
				value="<c:out value="${zdhCharalterrecordForm.zdhCharalterrecordDto.sys_fille}"/>">
							<%--填写单位--%>
							<input type="hidden" name="zdhCharalterrecordDto.sys_filldept"
				value="<c:out value="${zdhCharalterrecordForm.zdhCharalterrecordDto.sys_filldept}"/>">
							<%--填写时间--%>
							<input type="hidden" name="zdhCharalterrecordDto.sys_filltime"
				value="<c:out value="${zdhCharalterrecordForm.zdhCharalterrecordDto.sys_filltime}"/>">
							<%--是否有效字段--%>
							<input type="hidden" name="zdhCharalterrecordDto.sys_isvalid"
				value="<c:out value="${zdhCharalterrecordForm.zdhCharalterrecordDto.sys_isvalid}"/>">
							<%--数据所属单位--%>
							<input type="hidden" name="zdhCharalterrecordDto.sys_dataowner"
				value="<c:out value="${zdhCharalterrecordForm.zdhCharalterrecordDto.sys_dataowner}"/>">
							<!--tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhCharalterrecordDto.sys_fille" />
									<%--填写人--%>
								</td>
								<td height="23" width="30%">
									<input id="zdhCharalterrecordDto.sys_fille"
										name="zdhCharalterrecordDto.sys_fille" type="text"
										value="${zdhCharalterrecordForm.zdhCharalterrecordDto.sys_fille}"
										size="10" readonly />
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhCharalterrecordDto.sys_filldept" />
									<%--填写单位--%>
								</td>
								<td height="23" width="30%">
									<input id="zdhCharalterrecordDto.sys_filldept"
										name="zdhCharalterrecordDto.sys_filldept" type="text"
										value="${zdhCharalterrecordForm.zdhCharalterrecordDto.sys_filldept}"
										size="10" readonly />
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhCharalterrecordDto.sys_filltime" />
									<%--填写时间--%>
								</td>
								<td height="23" width="30%">
									<input id="zdhCharalterrecordDto.sys_filltime"
										name="zdhCharalterrecordDto.sys_filltime" type="text"
										value="${zdhCharalterrecordForm.zdhCharalterrecordDto.sys_filltime}"
										size="20" readonly />
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhCharalterrecordDto.sys_isvalid" />
									<%--是否有效字段--%>
								</td>
								<td height="23" width="30%">
									<input id="zdhCharalterrecordDto.sys_isvalid"
										name="zdhCharalterrecordDto.sys_isvalid" type="text"
										value="${zdhCharalterrecordForm.zdhCharalterrecordDto.sys_isvalid}"
										size="10" />
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhCharalterrecordDto.sys_dataowner" />
									<%--数据所属单位--%>
								</td>
								<td height="23" width="30%" colspan="3">
									<input id="zdhCharalterrecordDto.sys_dataowner"
										name="zdhCharalterrecordDto.sys_dataowner" type="text"
										value="${zdhCharalterrecordForm.zdhCharalterrecordDto.sys_dataowner}"
										size="10" readonly />
								</td>
							</tr-->
						</table>
					</td>
				</tr>
			</table>
			<%
			if (!StringUtils.isEmpty(taskExplan)) {
			%>
			<jhop:ctrlgroup
				ctrlId="UIControlGroupXPanele20a6fa064964f9e95e195d738c784c9"
				title="系统图修改信息">
			</jhop:ctrlgroup>

			<table class="detailmain" cellspacing="0" cellpadding="0">
				<tr id="UIControlGroupXPanele20a6fa064964f9e95e195d738c784c9">
					<td align="center">
						<table class="detail" width="100%" height="100%" cellspacing="0">
							
							<tr>
								<td height="23" class="tab_0" width="15%">
									<bean:message key="object.zdhCharalterrecordDto.modexplanation" />
									<%--图形修改工作说明--%>
								</td>
								<td height="23" width="35%" colspan="3">
									<textarea id='zdhCharalterrecordDto.modexplanation'
										name='zdhCharalterrecordDto.modexplanation' rows='3' cols='71'><c:out value="${zdhCharalterrecordForm.zdhCharalterrecordDto.modexplanation}"/></textarea>
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="15%">
									<bean:message
										key="object.zdhCharalterrecordDto.linediagramamount" />
									<%--修改线路图数量--%>
								</td>
								<td height="23" width="35%">
									<input id="zdhCharalterrecordDto.linediagramamount"
										name="zdhCharalterrecordDto.linediagramamount" type="text"
										value="<c:out value="${zdhCharalterrecordForm.zdhCharalterrecordDto.linediagramamount}"/>"
										size="10" />
								</td>
								<td height="23" class="tab_0" width="15%">
									<bean:message
										key="object.zdhCharalterrecordDto.stationdiagramamount" />
									<%--修改厂站图数量--%>
								</td>
								<td height="23" width="35%">
									<input id="zdhCharalterrecordDto.stationdiagramamount"
										name="zdhCharalterrecordDto.stationdiagramamount" type="text"
										value="<c:out value="${zdhCharalterrecordForm.zdhCharalterrecordDto.stationdiagramamount}"/>"
										size="10" />
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="15%">
									<bean:message key="object.zdhCharalterrecordDto.newtrfnum" />
									<%--新发变压器数量--%>
								</td>
								<td height="23" width="35%">
									<input id="zdhCharalterrecordDto.newtrfnum"
										name="zdhCharalterrecordDto.newtrfnum" type="text"
										value="<c:out value="${zdhCharalterrecordForm.zdhCharalterrecordDto.newtrfnum}"/>"
										size="10" />
								</td>
								<td height="23" class="tab_0" width="15%">
									<bean:message key="object.zdhCharalterrecordDto.newbusnum" />
									<%--新增母线数量--%>
									<span class="article_required">*</span>
								</td>
								<td height="23" width="35%">
									<input id="zdhCharalterrecordDto.newbusnum"
										name="zdhCharalterrecordDto.newbusnum" type="text"
										value="<c:out value="${zdhCharalterrecordForm.zdhCharalterrecordDto.newbusnum}"/>"
										size="10" />
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="15%">
									<bean:message key="object.zdhCharalterrecordDto.newswitchnum" />
									<%--新增开关数量--%>
								</td>
								<td height="23" width="35%">
									<input id="zdhCharalterrecordDto.newswitchnum"
										name="zdhCharalterrecordDto.newswitchnum" type="text"
										value="<c:out value="${zdhCharalterrecordForm.zdhCharalterrecordDto.newswitchnum}"/>"
										size="10" />
								</td>
								<td height="23" class="tab_0" width="15%">
									<bean:message key="object.zdhCharalterrecordDto.newothersnum" />
									<%--新发其它数量--%>
								</td>
								<td height="23" width="35%">
									<input id="zdhCharalterrecordDto.newothersnum"
										name="zdhCharalterrecordDto.newothersnum" type="text"
										value="<c:out value="${zdhCharalterrecordForm.zdhCharalterrecordDto.newothersnum}"/>"
										size="10" />
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="15%">
									<bean:message key="object.zdhCharalterrecordDto.newplantnum" />
									<%--新发电厂数量--%>
								</td>
								<td height="23" width="35%">
									<input id="zdhCharalterrecordDto.newplantnum"
										name="zdhCharalterrecordDto.newplantnum" type="text"
										value="<c:out value="${zdhCharalterrecordForm.zdhCharalterrecordDto.newplantnum}"/>"
										size="10" />
								</td>
								<td height="23" class="tab_0" width="15%">
									<bean:message key="object.zdhCharalterrecordDto.newline" />
									<%--新投线路--%>
								</td>
								<td height="23" width="35%">
									<input id="zdhCharalterrecordDto.newline"
										name="zdhCharalterrecordDto.newline" type="text"
										value="<c:out value="${zdhCharalterrecordForm.zdhCharalterrecordDto.newline}"/>"
										size="10" />
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="15%">
									<bean:message key="object.zdhCharalterrecordDto.changtrmnum" />
									<%--变压器切改数量--%>
								</td>
								<td height="23" width="35%">
									<input id="zdhCharalterrecordDto.changtrmnum"
										name="zdhCharalterrecordDto.changtrmnum" type="text"
										value="<c:out value="${zdhCharalterrecordForm.zdhCharalterrecordDto.changtrmnum}"/>"
										size="10" />
								</td>
								<td height="23" class="tab_0" width="15%">
									<bean:message key="object.zdhCharalterrecordDto.changbusnum" />
									<%--母线切改数量--%>
								</td>
								<td height="23" width="35%">
									<input id="zdhCharalterrecordDto.changbusnum"
										name="zdhCharalterrecordDto.changbusnum" type="text"
										value="<c:out value="${zdhCharalterrecordForm.zdhCharalterrecordDto.changbusnum}"/>"
										size="10" />
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="15%">
									<bean:message key="object.zdhCharalterrecordDto.changlinenum" />
									<%--切改线路数量--%>
								</td>
								<td height="23" width="35%">
									<input id="zdhCharalterrecordDto.changlinenum"
										name="zdhCharalterrecordDto.changlinenum" type="text"
										value="<c:out value="${zdhCharalterrecordForm.zdhCharalterrecordDto.changlinenum}"/>"
										size="10" />
								</td>
								<td height="23" class="tab_0" width="15%">
									<bean:message key="object.zdhCharalterrecordDto.outtrfnum" />
									<%--变压器退运数量--%>
								</td>
								<td height="23" width="35%">
									<input id="zdhCharalterrecordDto.outtrfnum"
										name="zdhCharalterrecordDto.outtrfnum" type="text"
										value="<c:out value="${zdhCharalterrecordForm.zdhCharalterrecordDto.outtrfnum}"/>"
										size="10" />
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="15%">
									<bean:message key="object.zdhCharalterrecordDto.outbusnum" />
									<%--母线退运数量--%>
								</td>
								<td height="23" width="35%">
									<input id="zdhCharalterrecordDto.outbusnum"
										name="zdhCharalterrecordDto.outbusnum" type="text"
										value="<c:out value="${zdhCharalterrecordForm.zdhCharalterrecordDto.outbusnum}"/>"
										size="10" />
								</td>
								<td height="23" class="tab_0" width="15%">
									<bean:message key="object.zdhCharalterrecordDto.outswitchnum" />
									<%--开关退运数量--%>
								</td>
								<td height="23" width="35%">
									<input id="zdhCharalterrecordDto.outswitchnum"
										name="zdhCharalterrecordDto.outswitchnum" type="text"
										value="<c:out value="${zdhCharalterrecordForm.zdhCharalterrecordDto.outswitchnum}"/>"
										size="10" />
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="15%">
									<bean:message key="object.zdhCharalterrecordDto.outlinenum" />
									<%--退出线路数量--%>
								</td>
								<td height="23" width="35%">
									<input id="zdhCharalterrecordDto.outlinenum"
										name="zdhCharalterrecordDto.outlinenum" type="text"
										value="<c:out value="${zdhCharalterrecordForm.zdhCharalterrecordDto.outlinenum}"/>"
										size="10" />
								</td>
								<td height="23" class="tab_0" width="15%">
									<bean:message
										key="object.zdhCharalterrecordDto.outgeneratornum" />
									<%--发电机退出数量--%>
								</td>
								<td height="23" width="35%">
									<input id="zdhCharalterrecordDto.outgeneratornum"
										name="zdhCharalterrecordDto.outgeneratornum" type="text"
										value="<c:out value="${zdhCharalterrecordForm.zdhCharalterrecordDto.outgeneratornum}"/>"
										size="10" />
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="15%">
									<bean:message key="object.zdhCharalterrecordDto.systemchartno" />
									<%--系统图修改单正式编号--%>
								</td>
								<td height="23" width="35%">
									<input id="zdhCharalterrecordDto.systemchartno"
										name="zdhCharalterrecordDto.systemchartno" type="text"
										value="<c:out value="${zdhCharalterrecordForm.zdhCharalterrecordDto.systemchartno}"/>"
										 size="10" />
								</td>
								<td height="23" class="tab_0" width="15%">
									<bean:message key="object.zdhCharalterrecordDto.fstatus" />
									<%--执行状态--%>
								</td>
								<td height="23" width="35%">
									<input id="zdhCharalterrecordDto.fstatus"
										name="zdhCharalterrecordDto.fstatus" type="text"
										value="<c:out value="${zdhCharalterrecordForm.zdhCharalterrecordDto.fstatus}"/>"
										size="10" readonly />
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
	
	var id = document.getElementById('zdhCharalterrecordDto.recordsno').value;
	//进行初始化动作
    if (id == null || id == '' || id == 'undefined'){
		//初始化填单人
       document.getElementById('zdhCharalterrecordDto.sys_fille').value = '<%= userName %>';
       //初始化填写单位       
       document.getElementById('zdhCharalterrecordDto.sys_filldept').value = '<%= userDeptName %>';
       //初始化填写时间
       document.getElementById('zdhCharalterrecordDto.sys_filltime').value = '<%= currentTime %>';
       //数据所属单位
       document.getElementById('zdhCharalterrecordDto.sys_dataowner').value = '<%= dataOwnerName %>';
       //申请时间
       //document.getElementById('zdhCharalterrecordDto.applicantedtime').value = '<%= currentTime%>';	
	}
	
</script>
