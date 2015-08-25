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
		<title>拉路限电记录详情</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="../../themes/themes1/style.css" rel="stylesheet"
			type="text/css" />
		<%@ include file="/common/init_js.jsp"%>
		<%@ include file="/common/init_date.jsp"%>
		<script language="javascript" type="text/javascript"
			src="<%=request.getContextPath()%>/application/ddcutofflist/detail.js"></script>
	</head>
	<body>
		<html:javascript formName="ddCutofflistForm" />
		<logic:messagesPresent message="true">
			<html:messages id="message" message="true" header="messages.header"
				footer="messages.footer">
				<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
			</html:messages>
		</logic:messagesPresent>
		<form name="ddCutofflistForm" action="" method="post">
			<%--hidden--%>

			<input type="hidden" name="ddCutofflistDto.fid"
				value="${ddCutofflistForm.ddCutofflistDto.fid}">
			<input type="hidden" name="ddCutofflistDto.version"
				value="${ddCutofflistForm.ddCutofflistDto.version}">

			<jhop:ctrlgroup
				ctrlId="UIControlGroupXPanel0fc7abbf7adb4a0e80f790ecd8119c46"
				title="拉路限电记录">
			</jhop:ctrlgroup>

			<table class="detailmain" cellspacing="0" cellpadding="0">
				<tr id="UIControlGroupXPanel0fc7abbf7adb4a0e80f790ecd8119c46">
					<td align="center">
						<table class="detail" width="100%" height="100%" cellspacing="0">
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddCutofflistDto.fid" />
									<%--拉路限电记录ID--%>
								</td>
								<td height="23" width="30%">
									<input id="ddCutofflistDto.fid" name="ddCutofflistDto.fid"
										type="text" value="${ddCutofflistForm.ddCutofflistDto.fid}"
										size="10" />
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddCutofflistDto.fsuspdate" />
									<%--拉路日期--%>
								</td>
								<td height="23" width="30%">
									<jhop:date name="ddCutofflistDto.fsuspdate" genText="yes"
										dateFormat="yyyy-MM-dd"
										initValue="${ddCutofflistForm.ddCutofflistDto.fsuspdate}"></jhop:date>
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddCutofflistDto.fsusptime" />
									<%--拉路时间--%>
								</td>
								<td height="23" width="30%">
									<jhop:date name="ddCutofflistDto.fsusptime" genText="yes"
										dateFormat="yyyy-MM-dd hh:mm:ss"
										initValue="${ddCutofflistForm.ddCutofflistDto.fsusptime}"></jhop:date>
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddCutofflistDto.fgiveorderunit" />
									<%--下令单位--%>
								</td>
								<td height="23" width="30%">
									<input id="ddCutofflistDto.fgiveorderunit"
										name="ddCutofflistDto.fgiveorderunit" type="text"
										value="${ddCutofflistForm.ddCutofflistDto.fgiveorderunit}"
										size="10" />
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddCutofflistDto.fgiver" />
									<%--下令人姓名--%>
								</td>
								<td height="23" width="30%">
									<input id="ddCutofflistDto.fgiver"
										name="ddCutofflistDto.fgiver" type="text"
										value="${ddCutofflistForm.ddCutofflistDto.fgiver}" size="10" />
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddCutofflistDto.fgiveordertime" />
									<%--下令时间--%>
								</td>
								<td height="23" width="30%">
									<jhop:date name="ddCutofflistDto.fgiveordertime" genText="yes"
										dateFormat="yyyy-MM-dd"
										initValue="${ddCutofflistForm.ddCutofflistDto.fgiveordertime}"></jhop:date>
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddCutofflistDto.floadunit" />
									<%--接令单位--%>
								</td>
								<td height="23" width="30%">
									<input id="ddCutofflistDto.floadunit"
										name="ddCutofflistDto.floadunit" type="text"
										value="${ddCutofflistForm.ddCutofflistDto.floadunit}"
										size="10" />
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddCutofflistDto.faccepter" />
									<%--接令人--%>
								</td>
								<td height="23" width="30%">
									<input id="ddCutofflistDto.faccepter"
										name="ddCutofflistDto.faccepter" type="text"
										value="${ddCutofflistForm.ddCutofflistDto.faccepter}"
										size="10" />
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddCutofflistDto.fsummitter" />
									<%--交令人--%>
								</td>
								<td height="23" width="30%">
									<input id="ddCutofflistDto.fsummitter"
										name="ddCutofflistDto.fsummitter" type="text"
										value="${ddCutofflistForm.ddCutofflistDto.fsummitter}"
										size="10" />
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddCutofflistDto.fsummitordertime" />
									<%--交令时间--%>
								</td>
								<td height="23" width="30%">
									<jhop:date name="ddCutofflistDto.fsummitordertime"
										genText="yes" dateFormat="yyyy-MM-dd hh:mm:ss"
										initValue="${ddCutofflistForm.ddCutofflistDto.fsummitordertime}"></jhop:date>
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddCutofflistDto.fload" />
									<%--限电负荷( MW)--%>
								</td>
								<td height="23" width="30%">
									<input id="ddCutofflistDto.fload" name="ddCutofflistDto.fload"
										type="text" value="${ddCutofflistForm.ddCutofflistDto.fload}"
										size="10" />
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddCutofflistDto.fregionloadbefore" />
									<%--拉路前地区负荷(MW)--%>
								</td>
								<td height="23" width="30%">
									<input id="ddCutofflistDto.fregionloadbefore"
										name="ddCutofflistDto.fregionloadbefore" type="text"
										value="${ddCutofflistForm.ddCutofflistDto.fregionloadbefore}"
										size="10" />
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddCutofflistDto.fregionloadafter" />
									<%--拉路后地区负荷(MW)--%>
								</td>
								<td height="23" width="30%">
									<input id="ddCutofflistDto.fregionloadafter"
										name="ddCutofflistDto.fregionloadafter" type="text"
										value="${ddCutofflistForm.ddCutofflistDto.fregionloadafter}"
										size="10" />
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddCutofflistDto.frealload" />
									<%--实际拉路负荷--%>
								</td>
								<td height="23" width="30%">
									<input id="ddCutofflistDto.frealload"
										name="ddCutofflistDto.frealload" type="text"
										value="${ddCutofflistForm.ddCutofflistDto.frealload}"
										size="10" />
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddCutofflistDto.frealno" />
									<%--实际拉路数--%>
								</td>
								<td height="23" width="30%">
									<input id="ddCutofflistDto.frealno"
										name="ddCutofflistDto.frealno" type="text"
										value="${ddCutofflistForm.ddCutofflistDto.frealno}" size="10" />
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddCutofflistDto.frecoverytime" />
									<%--恢复时间--%>
								</td>
								<td height="23" width="30%">
									<jhop:date name="ddCutofflistDto.frecoverytime" genText="yes"
										dateFormat="yyyy-MM-dd hh:mm:ss"
										initValue="${ddCutofflistForm.ddCutofflistDto.frecoverytime}"></jhop:date>
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddCutofflistDto.frecoveryload" />
									<%--恢复负荷(MW)--%>
								</td>
								<td height="23" width="30%">
									<input id="ddCutofflistDto.frecoveryload"
										name="ddCutofflistDto.frecoveryload" type="text"
										value="${ddCutofflistForm.ddCutofflistDto.frecoveryload}"
										size="10" />
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddCutofflistDto.frecoverygiver" />
									<%--恢复下令人--%>
								</td>
								<td height="23" width="30%">
									<input id="ddCutofflistDto.frecoverygiver"
										name="ddCutofflistDto.frecoverygiver" type="text"
										value="${ddCutofflistForm.ddCutofflistDto.frecoverygiver}"
										size="10" />
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddCutofflistDto.fgiverecoverytime" />
									<%--恢复下令时间--%>
								</td>
								<td height="23" width="30%">
									<jhop:date name="ddCutofflistDto.fgiverecoverytime"
										genText="yes" dateFormat="yyyy-MM-dd hh:mm:ss"
										initValue="${ddCutofflistForm.ddCutofflistDto.fgiverecoverytime}"></jhop:date>
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddCutofflistDto.faccepterrecorery" />
									<%--恢复接令人--%>
								</td>
								<td height="23" width="30%">
									<input id="ddCutofflistDto.faccepterrecorery"
										name="ddCutofflistDto.faccepterrecorery" type="text"
										value="${ddCutofflistForm.ddCutofflistDto.faccepterrecorery}"
										size="10" />
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddCutofflistDto.fsummiterrecorery" />
									<%--恢复交令人--%>
								</td>
								<td height="23" width="30%">
									<input id="ddCutofflistDto.fsummiterrecorery"
										name="ddCutofflistDto.fsummiterrecorery" type="text"
										value="${ddCutofflistForm.ddCutofflistDto.fsummiterrecorery}"
										size="10" />
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddCutofflistDto.fsummiterecorerytime" />
									<%--恢复交令时间--%>
								</td>
								<td height="23" width="30%">
									<jhop:date name="ddCutofflistDto.fsummiterecorerytime"
										genText="yes" dateFormat="yyyy-MM-dd"
										initValue="${ddCutofflistForm.ddCutofflistDto.fsummiterecorerytime}"></jhop:date>
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddCutofflistDto.floadunitid" />
									<%--接令单位ID--%>
								</td>
								<td height="23" width="30%">
									<input id="ddCutofflistDto.floadunitid"
										name="ddCutofflistDto.floadunitid" type="text"
										value="${ddCutofflistForm.ddCutofflistDto.floadunitid}"
										size="10" />
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddCutofflistDto.ffatherid" />
									<%--父ID--%>
									<span class="article_required">*</span>
								</td>
								<td height="23" width="30%">
									<input id="ddCutofflistDto.ffatherid"
										name="ddCutofflistDto.ffatherid" type="text"
										value="${ddCutofflistForm.ddCutofflistDto.ffatherid}"
										size="10" />
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddCutofflistDto.sys_fille" />
									<%--填写人--%>
								</td>
								<td height="23" width="30%">
									<input id="ddCutofflistDto.sys_fille"
										name="ddCutofflistDto.sys_fille" type="text"
										value="${ddCutofflistForm.ddCutofflistDto.sys_fille}"
										size="10" />
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddCutofflistDto.sys_filldept" />
									<%--填写单位--%>
								</td>
								<td height="23" width="30%">
									<input id="ddCutofflistDto.sys_filldept"
										name="ddCutofflistDto.sys_filldept" type="text"
										value="${ddCutofflistForm.ddCutofflistDto.sys_filldept}"
										size="10" />
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddCutofflistDto.sys_filltime" />
									<%--填写时间--%>
								</td>
								<td height="23" width="30%">
									<jhop:date name="ddCutofflistDto.sys_filltime" genText="yes"
										dateFormat="yyyy-MM-dd hh:mm:ss"
										initValue="${ddCutofflistForm.ddCutofflistDto.sys_filltime}"></jhop:date>
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddCutofflistDto.sys_isvalid" />
									<%--是否有效字段--%>
								</td>
								<td height="23" width="30%">
									<input id="ddCutofflistDto.sys_isvalid"
										name="ddCutofflistDto.sys_isvalid" type="text"
										value="${ddCutofflistForm.ddCutofflistDto.sys_isvalid}"
										size="10" />
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddCutofflistDto.sys_dataowner" />
									<%--数据所属单位--%>
								</td>
								<td height="23" width="30%">
									<input id="ddCutofflistDto.sys_dataowner"
										name="ddCutofflistDto.sys_dataowner" type="text"
										value="${ddCutofflistForm.ddCutofflistDto.sys_dataowner}"
										size="10" />
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddCutofflistDto.fordertype" />
									<%--拉路性质--%>
								</td>
								<td height="23" width="30%">
									<input id="ddCutofflistDto.fordertype"
										name="ddCutofflistDto.fordertype" type="text"
										value="${ddCutofflistForm.ddCutofflistDto.fordertype}"
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

    var id = document.getElementById('ddCutofflistDto.fid').value;

    //进行初始化动作

    if (id == '' || id == null){

       //初始化填单人

       document.getElementById('ddCutofflistDto.sys_fille').value = '<%=userName%>';

       //初始化填写单位

       document.getElementById('ddCutofflistDto.sys_filldept').value = '<%=userDeptName%>';

       //初始化填写时间

       document.getElementById('ddCutofflistDto.sys_filltime').value = '<%=currentTime%>';

       //数据所属单位

       document.getElementById('ddCutofflistDto.sys_dataowner').value = '<%=dataOwnerName%>';

    }



</script>
