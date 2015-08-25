<%@ page import="com.techstar.dmis.helper.BusinessDetailHelper"%>
<%@ page import="com.techstar.dmis.helper.dto.BusinessDetailDto"%>
<%@ page import="java.sql.Timestamp"%>

<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map"%>
<%@ include file="/common/init_tag.jsp"%>

<%
			BusinessDetailDto bdt = BusinessDetailHelper
			.getBusDetailInfo(request);

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



<html>
	<head>
		<html:base />
		<title>拉路序位详情</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="../../themes/themes1/style.css" rel="stylesheet"
			type="text/css" />
		<%@ include file="/common/init_js.jsp"%>
		<%@ include file="/common/init_date.jsp"%>
		<script language="javascript" type="text/javascript"
			src="<%=request.getContextPath()%>/application/ddcutoffsequence/detail.js"></script>
	</head>
	<body>
		<html:javascript formName="ddCutoffsequenceForm" />
		<logic:messagesPresent message="true">
			<html:messages id="message" message="true" header="messages.header"
				footer="messages.footer">
				<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
			</html:messages>
		</logic:messagesPresent>
		<form name="ddCutoffsequenceForm" action="" method="post">
			<%--hidden--%>

			<input type="hidden" name="ddCutoffsequenceDto.fid"
				value="${ddCutoffsequenceForm.ddCutoffsequenceDto.fid}">
			<input type="hidden" name="ddCutoffsequenceDto.version"
				value="${ddCutoffsequenceForm.ddCutoffsequenceDto.version}">

			<jhop:ctrlgroup
				ctrlId="UIControlGroupXPanel50a1bbfe66de4b9293b1a94a018a6b52"
				title="拉路序位">
			</jhop:ctrlgroup>

			<table class="detailmain" cellspacing="0" cellpadding="0">
				<tr id="UIControlGroupXPanel50a1bbfe66de4b9293b1a94a018a6b52">
					<td align="center">
						<table class="detail" width="100%" height="100%" cellspacing="0">
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddCutoffsequenceDto.fid" />
									<%--拉路限电序位编号--%>
								</td>
								<td height="23" width="30%">
									<input id="ddCutoffsequenceDto.fid"
										name="ddCutoffsequenceDto.fid" type="text"
										value="${ddCutoffsequenceForm.ddCutoffsequenceDto.fid}"
										size="10" />
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddCutoffsequenceDto.fannual" />
									<%--年度--%>
								</td>
								<td height="23" width="30%">
									<input id="ddCutoffsequenceDto.fannual"
										name="ddCutoffsequenceDto.fannual" type="text"
										value="${ddCutoffsequenceForm.ddCutoffsequenceDto.fannual}"
										size="10" />
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddCutoffsequenceDto.fdispatch" />
									<%--所属调度--%>
								</td>
								<td height="23" width="30%">
									<input id="ddCutoffsequenceDto.fdispatch"
										name="ddCutoffsequenceDto.fdispatch" type="text"
										value="${ddCutoffsequenceForm.ddCutoffsequenceDto.fdispatch}"
										size="10" />
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddCutoffsequenceDto.fstationname" />
									<%--站名--%>
								</td>
								<td height="23" width="30%">
									<input id="ddCutoffsequenceDto.fstationname"
										name="ddCutoffsequenceDto.fstationname" type="text"
										value="${ddCutoffsequenceForm.ddCutoffsequenceDto.fstationname}"
										size="10" />
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddCutoffsequenceDto.ftransformer" />
									<%--变压器--%>
								</td>
								<td height="23" width="30%">
									<input id="ddCutoffsequenceDto.ftransformer"
										name="ddCutoffsequenceDto.ftransformer" type="text"
										value="${ddCutoffsequenceForm.ddCutoffsequenceDto.ftransformer}"
										size="10" />
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddCutoffsequenceDto.fbusbar" />
									<%--母线--%>
								</td>
								<td height="23" width="30%">
									<input id="ddCutoffsequenceDto.fbusbar"
										name="ddCutoffsequenceDto.fbusbar" type="text"
										value="${ddCutoffsequenceForm.ddCutoffsequenceDto.fbusbar}"
										size="10" />
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddCutoffsequenceDto.fround" />
									<%--轮次--%>
								</td>
								<td height="23" width="30%">
									<input id="ddCutoffsequenceDto.fround"
										name="ddCutoffsequenceDto.fround" type="text"
										value="${ddCutoffsequenceForm.ddCutoffsequenceDto.fround}"
										size="10" />
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddCutoffsequenceDto.fswitchno" />
									<%--开关号--%>
								</td>
								<td height="23" width="30%">
									<input id="ddCutoffsequenceDto.fswitchno"
										name="ddCutoffsequenceDto.fswitchno" type="text"
										value="${ddCutoffsequenceForm.ddCutoffsequenceDto.fswitchno}"
										size="10" />
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddCutoffsequenceDto.flineclass" />
									<%--线路类型--%>
								</td>
								<td height="23" width="30%">
									<input id="ddCutoffsequenceDto.flineclass"
										name="ddCutoffsequenceDto.flineclass" type="text"
										value="${ddCutoffsequenceForm.ddCutoffsequenceDto.flineclass}"
										size="10" />
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddCutoffsequenceDto.fload" />
									<%--负荷--%>
								</td>
								<td height="23" width="30%">
									<input id="ddCutoffsequenceDto.fload"
										name="ddCutoffsequenceDto.fload" type="text"
										value="${ddCutoffsequenceForm.ddCutoffsequenceDto.fload}"
										size="10" />
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddCutoffsequenceDto.foutageareauser" />
									<%--停电范围及主要用户--%>
								</td>
								<td height="23" width="30%">
									<input id="ddCutoffsequenceDto.foutageareauser"
										name="ddCutoffsequenceDto.foutageareauser" type="text"
										value="${ddCutoffsequenceForm.ddCutoffsequenceDto.foutageareauser}"
										size="10" />
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message
										key="object.ddCutoffsequenceDto.fdubleoutagestation" />
									<%--双路不同时停电户(站名)--%>
								</td>
								<td height="23" width="30%">
									<input id="ddCutoffsequenceDto.fdubleoutagestation"
										name="ddCutoffsequenceDto.fdubleoutagestation" type="text"
										value="${ddCutoffsequenceForm.ddCutoffsequenceDto.fdubleoutagestation}"
										size="10" />
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddCutoffsequenceDto.fdubleoutageroad" />
									<%--双路不同时停电户(路名)--%>
								</td>
								<td height="23" width="30%">
									<input id="ddCutoffsequenceDto.fdubleoutageroad"
										name="ddCutoffsequenceDto.fdubleoutageroad" type="text"
										value="${ddCutoffsequenceForm.ddCutoffsequenceDto.fdubleoutageroad}"
										size="10" />
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddCutoffsequenceDto.fdubleoutageuser" />
									<%--双路不同时停电户(客户名)--%>
								</td>
								<td height="23" width="30%">
									<input id="ddCutoffsequenceDto.fdubleoutageuser"
										name="ddCutoffsequenceDto.fdubleoutageuser" type="text"
										value="${ddCutoffsequenceForm.ddCutoffsequenceDto.fdubleoutageuser}"
										size="10" />
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddCutoffsequenceDto.fstationid" />
									<%--站名ID--%>
								</td>
								<td height="23" width="30%">
									<input id="ddCutoffsequenceDto.fstationid"
										name="ddCutoffsequenceDto.fstationid" type="text"
										value="${ddCutoffsequenceForm.ddCutoffsequenceDto.fstationid}"
										size="10" />
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddCutoffsequenceDto.fno" />
									<%--序号--%>
									<span class="article_required">*</span>
								</td>
								<td height="23" width="30%">
									<input id="ddCutoffsequenceDto.fno"
										name="ddCutoffsequenceDto.fno" type="text"
										value="${ddCutoffsequenceForm.ddCutoffsequenceDto.fno}"
										size="10" />
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddCutoffsequenceDto.sys_fille" />
									<%--填写人--%>
								</td>
								<td height="23" width="30%">
									<input id="ddCutoffsequenceDto.sys_fille"
										name="ddCutoffsequenceDto.sys_fille" type="text"
										value="${ddCutoffsequenceForm.ddCutoffsequenceDto.sys_fille}"
										size="10" />
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddCutoffsequenceDto.sys_filldept" />
									<%--填写单位--%>
								</td>
								<td height="23" width="30%">
									<input id="ddCutoffsequenceDto.sys_filldept"
										name="ddCutoffsequenceDto.sys_filldept" type="text"
										value="${ddCutoffsequenceForm.ddCutoffsequenceDto.sys_filldept}"
										size="10" />
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddCutoffsequenceDto.sys_filltime" />
									<%--填写时间--%>
								</td>
								<td height="23" width="30%">
									<jhop:date name="ddCutoffsequenceDto.sys_filltime"
										genText="yes" dateFormat="yyyy-MM-dd hh:mm:ss"
										initValue="${ddCutoffsequenceForm.ddCutoffsequenceDto.sys_filltime}"></jhop:date>
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddCutoffsequenceDto.sys_isvalid" />
									<%--是否有效字段--%>
								</td>
								<td height="23" width="30%">
									<input id="ddCutoffsequenceDto.sys_isvalid"
										name="ddCutoffsequenceDto.sys_isvalid" type="text"
										value="${ddCutoffsequenceForm.ddCutoffsequenceDto.sys_isvalid}"
										size="10" />
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddCutoffsequenceDto.sys_dataowner" />
									<%--数据所属单位--%>
								</td>
								<td height="23" width="30%" colspan="3">
									<input id="ddCutoffsequenceDto.sys_dataowner"
										name="ddCutoffsequenceDto.sys_dataowner" type="text"
										value="${ddCutoffsequenceForm.ddCutoffsequenceDto.sys_dataowner}"
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
<script>

    var id = document.getElementById('ddCutoffsequenceDto.fid').value;

    //进行初始化动作

    if (id == '' || id == null){

       //初始化填单人

       document.getElementById('ddCutoffsequenceDto.sys_fille').value = '<%=userName%>';

       //初始化填写单位

       document.getElementById('ddCutoffsequenceDto.sys_filldept').value = '<%=userDeptName%>';

       //初始化填写时间

       document.getElementById('ddCutoffsequenceDto.sys_filltime').value = '<%=currentTime%>';

       //数据所属单位

       document.getElementById('ddCutoffsequenceDto.sys_dataowner').value = '<%=dataOwnerName%>';

    }



</script>
