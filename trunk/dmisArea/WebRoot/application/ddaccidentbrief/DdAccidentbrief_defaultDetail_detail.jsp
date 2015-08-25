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
		<title>故障简报详情</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="../../themes/themes1/style.css" rel="stylesheet"
			type="text/css" />
		<%@ include file="/common/init_js.jsp"%>
		<%@ include file="/common/init_date.jsp"%>
		<script language="javascript" type="text/javascript"
			src="<%=request.getContextPath()%>/application/ddaccidentbrief/DdAccidentbrief_defaultDetail_detail.js"></script>
	</head>
	<body>
		<html:javascript formName="ddAccidentbriefForm" />
		<logic:messagesPresent message="true">
			<html:messages id="message" message="true" header="messages.header"
				footer="messages.footer">
				<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
			</html:messages>
		</logic:messagesPresent>
		<form name="ddAccidentbriefForm" action="" method="post">
			<%--hidden--%>

			<input type="hidden" name="ddAccidentbriefDto.faccidentid"
				value="${ddAccidentbriefForm.ddAccidentbriefDto.faccidentid}">
			<input type="hidden" name="ddAccidentbriefDto.version"
				value="${ddAccidentbriefForm.ddAccidentbriefDto.version}">
			<input type="hidden" name="ddAccidentbriefDto.freporter"
				value="${ddAccidentbriefForm.ddAccidentbriefDto.freporter}">
			<input type="hidden" name="ddAccidentbriefDto.ftopdispreporttime"
				value="${ddAccidentbriefForm.ddAccidentbriefDto.ftopdispreporttime}">
			<input type="hidden" name="ddAccidentbriefDto.ffailurecauseid"
				value="${ddAccidentbriefForm.ddAccidentbriefDto.ffailurecauseid}">
			<input type="hidden" name="ddAccidentbriefDto.fimpact"
				value="${ddAccidentbriefForm.ddAccidentbriefDto.fimpact}">
			<input type="hidden" name="ddAccidentbriefDto.fexcutestatus"
				value="${ddAccidentbriefForm.ddAccidentbriefDto.fexcutestatus}">				
			<input type="hidden" name="ddAccidentbriefDto.sys_fille"
				value="${ddAccidentbriefForm.ddAccidentbriefDto.sys_fille}">
				
			<input type="hidden" name="ddAccidentbriefDto.sys_filldept"
				value="${ddAccidentbriefForm.ddAccidentbriefDto.sys_filldept}">
				
			<input type="hidden" name="ddAccidentbriefDto.sys_filltime"
				value="${ddAccidentbriefForm.ddAccidentbriefDto.sys_filltime}">
				
			<input type="hidden" name="ddAccidentbriefDto.sys_isvalid"
				value="${ddAccidentbriefForm.ddAccidentbriefDto.sys_isvalid}">
				
			<input type="hidden" name="ddAccidentbriefDto.sys_dataowner"
				value="${ddAccidentbriefForm.ddAccidentbriefDto.sys_dataowner}">
				
			<input type="hidden" name="ddAccidentbriefDto.freportdate"
				value="${ddAccidentbriefForm.ddAccidentbriefDto.freportdate}">
				
			<input type="hidden" name="ddAccidentbriefDto.ffaultequipmemtid"
				value="${ddAccidentbriefForm.ddAccidentbriefDto.ffaultequipmemtid}">
				
			<input type="hidden" name="ddAccidentbriefDto.flineid"
				value="${ddAccidentbriefForm.ddAccidentbriefDto.flineid}">
				
			<input type="hidden" name="ddAccidentbriefDto.fstationid"
				value="${ddAccidentbriefForm.ddAccidentbriefDto.fstationid}">
				
			<input type="hidden" name="ddAccidentbriefDto.accidentno"
				value="${ddAccidentbriefForm.ddAccidentbriefDto.accidentno}">   
				
			<input type="hidden" name="ddAccidentbriefDto.fexcutestatus"
				value="${ddAccidentbriefForm.ddAccidentbriefDto.fexcutestatus}"> 
				
			



			<jhop:ctrlgroup
				ctrlId="UIControlGroupXPanelddc2a5910f6b4e52a4a42832e56923ad"
				title="故障简报">
			</jhop:ctrlgroup>

			<table class="detailmain" cellspacing="0" cellpadding="0">
				<tr id="UIControlGroupXPanelddc2a5910f6b4e52a4a42832e56923ad">
					<td align="center">
						<table class="detail" width="100%" height="100%" cellspacing="0">
							<tr>

								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddAccidentbriefDto.fdispatcher" />
									<%--值班调度员--%>
								</td>


								<td height="23" width="30%">
									<input id="ddAccidentbriefDto.fdispatcher"
										name="ddAccidentbriefDto.fdispatcher" type="text"
										value="${ddAccidentbriefForm.ddAccidentbriefDto.fdispatcher}"
										size="10" />
								</td>


								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddAccidentbriefDto.fweather" />
									<%--天气--%>
								</td>


								<td height="23" width="30%">
									<input id="ddAccidentbriefDto.fweather"
										name="ddAccidentbriefDto.fweather" type="text"
										value="${ddAccidentbriefForm.ddAccidentbriefDto.fweather}"
										size="10" />
								</td>

							</tr>
							<tr>

								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddAccidentbriefDto.faccidentname" />
									<%--事故名称--%>
								</td>


								<td height="23" width="30%" colspan="3">
									<textarea id='ddAccidentbriefDto.faccidentname'
										name='ddAccidentbriefDto.faccidentname' rows='3' cols='50'>${ddAccidentbriefForm.ddAccidentbriefDto.faccidentname}</textarea>
								</td>

							</tr>
							<tr>

								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddAccidentbriefDto.faccidenttime" />
									<%--故障发生时间--%>
								</td>


								<td height="23" width="30%">
									<jhop:date name="ddAccidentbriefDto.faccidenttime"
										genText="yes" dateFormat="yyyy-mm-dd hh:mm:ss"
										initValue="${ddAccidentbriefForm.ddAccidentbriefDto.faccidenttime}"></jhop:date>
								</td>


								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddAccidentbriefDto.fvoltage" />
									<%--故障电压等级--%>
								</td>


								<td height="23" width="30%">
									<jhop:select name="ddAccidentbriefDto.fvoltage" hiddName=""
										type="StdVoltage"
										initValue="${ddAccidentbriefForm.ddAccidentbriefDto.fvoltage}">
									</jhop:select>
								</td>

							</tr>

							<tr>

								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddAccidentbriefDto.freportedpeople" />
									<%--上报人--%>
								</td>


								<td height="23" width="30%">
									<input id="ddAccidentbriefDto.freportedpeople"
										name="ddAccidentbriefDto.freportedpeople" type="text"
										value="${ddAccidentbriefForm.ddAccidentbriefDto.freportedpeople}"
										size="10" />
								</td>


								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddAccidentbriefDto.freportleadership" />
									<%--汇报领导--%>
								</td>


								<td height="23" width="30%">
									<input id="ddAccidentbriefDto.freportleadership"
										name="ddAccidentbriefDto.freportleadership" type="text"
										value="${ddAccidentbriefForm.ddAccidentbriefDto.freportleadership}"
										size="10" />
								</td>

							</tr>
							<tr>

								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddAccidentbriefDto.fnotifiedunit" />
									<%--通知有关单位--%>
								</td>


								<td height="23" width="30%">
									<input id="ddAccidentbriefDto.fnotifiedunit"
										name="ddAccidentbriefDto.fnotifiedunit" type="text"
										value="${ddAccidentbriefForm.ddAccidentbriefDto.fnotifiedunit}"
										size="10" />
								</td>


								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddAccidentbriefDto.fnotifyoffice" />
									<%--通知本单位处室人员--%>
								</td>


								<td height="23" width="30%">
									<input id="ddAccidentbriefDto.fnotifyoffice"
										name="ddAccidentbriefDto.fnotifyoffice" type="text"
										value="${ddAccidentbriefForm.ddAccidentbriefDto.fnotifyoffice}"
										size="10" />
								</td>

							</tr>

							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddAccidentbriefDto.fstationname" />
									<%--变电站名称--%>
								</td>


								<td height="23" width="30%">
									<input id="ddAccidentbriefDto.fstationname"
										name="ddAccidentbriefDto.fstationname" type="text"
										value="${ddAccidentbriefForm.ddAccidentbriefDto.fstationname}"
										size="10" />
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddAccidentbriefDto.fline" />
									<%--线路名称--%>
								</td>


								<td height="23" width="30%">
									<input id="ddAccidentbriefDto.fline"
										name="ddAccidentbriefDto.fline" type="text"
										value="${ddAccidentbriefForm.ddAccidentbriefDto.flineid}"
										size="10" />
								</td>
							</tr>
							<tr>

								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddAccidentbriefDto.ffaultequipmemt" />
									<%--故障设备--%>
								</td>


								<td height="23" width="30%">
									<input id="ddAccidentbriefDto.ffaultequipmemt"
										name="ddAccidentbriefDto.ffaultequipmemt" type="text"
										value="${ddAccidentbriefForm.ddAccidentbriefDto.ffaultequipmemt}"
										size="10" />
								</td>


								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddAccidentbriefDto.fdispatchno" />
									<%--设备调度号--%>
								</td>


								<td height="23" width="30%">
									<input id="ddAccidentbriefDto.fdispatchno"
										name="ddAccidentbriefDto.fdispatchno" type="text"
										value="${ddAccidentbriefForm.ddAccidentbriefDto.fdispatchno}"
										size="10" />
								</td>

							</tr>

							<tr>

								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddAccidentbriefDto.fremark" />
									<%--备注--%>
								</td>


								<td height="23" width="30%" colspan="3">
									<textarea id='ddAccidentbriefDto.fremark'
										name='ddAccidentbriefDto.fremark' rows='3' cols='50'>${ddAccidentbriefForm.ddAccidentbriefDto.fremark}</textarea>
								</td>

							</tr>
						</table>
					</td>
				</tr>
			</table>
			<jhop:ctrlgroup
				ctrlId="UIControlGroupXPanelf988325bb6ad4477a0dcb451bce44471"
				title="故障处理结果及分析">
			</jhop:ctrlgroup>

			<table class="detailmain" cellspacing="0" cellpadding="0">
				<tr id="UIControlGroupXPanelf988325bb6ad4477a0dcb451bce44471">
					<td align="center">
						<table class="detail" width="100%" height="100%" cellspacing="0">
							<tr>

								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddAccidentbriefDto.frecoverytime" />
									<%--故障恢复时间--%>
								</td>


								<td height="23" width="30%">
									<jhop:date name="ddAccidentbriefDto.frecoverytime"
										genText="yes" dateFormat="yyyy-mm-dd hh:mm:ss"
										initValue="${ddAccidentbriefForm.ddAccidentbriefDto.frecoverytime}"></jhop:date>
								</td>


								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddAccidentbriefDto.flesspower" />
									<%--少送电度--%>
								</td>


								<td height="23" width="30%">
									<input id="ddAccidentbriefDto.flesspower"
										name="ddAccidentbriefDto.flesspower" type="text"
										value="${ddAccidentbriefForm.ddAccidentbriefDto.flesspower}"
										size="10" />
								</td>

							</tr>
							<tr>

								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddAccidentbriefDto.fovercurrenttime" />
									<%--过流次数--%>
								</td>


								<td height="23" width="30%">
									<input id="ddAccidentbriefDto.fovercurrenttime"
										name="ddAccidentbriefDto.fovercurrenttime" type="text"
										value="${ddAccidentbriefForm.ddAccidentbriefDto.fovercurrenttime}"
										size="10" />
								</td>


								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddAccidentbriefDto.fiftimes" />
									<%--速断次数--%>
								</td>


								<td height="23" width="30%">
									<input id="ddAccidentbriefDto.fiftimes"
										name="ddAccidentbriefDto.fiftimes" type="text"
										value="${ddAccidentbriefForm.ddAccidentbriefDto.fiftimes}"
										size="10" />
								</td>

							</tr>
							<tr>

								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddAccidentbriefDto.fothertimes" />
									<%--其他次数--%>
								</td>


								<td height="23" width="30%">
									<input id="ddAccidentbriefDto.fothertimes"
										name="ddAccidentbriefDto.fothertimes" type="text"
										value="${ddAccidentbriefForm.ddAccidentbriefDto.fothertimes}"
										size="10" />
								</td>


								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddAccidentbriefDto.fcontrol" />
									<%--试发情况--%>
								</td>


								<td height="23" width="30%">
									<jhop:select name="ddAccidentbriefDto.fcontrol" hiddName="" type="StdDdaccidenttry" initValue="${ddAccidentbriefForm.ddAccidentbriefDto.fcontrol}"> </jhop:select>
								</td>

							</tr>
							<tr>

								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddAccidentbriefDto.fgrounding" />
									<%--接地情况--%>
								</td>


								<td height="23" width="30%" colspan="3">
									<input id="ddAccidentbriefDto.fgrounding"
										name="ddAccidentbriefDto.fgrounding" type="text"
										value="${ddAccidentbriefForm.ddAccidentbriefDto.fgrounding}"
										size="10" />
								</td>

							</tr>
							<tr>

								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddAccidentbriefDto.freporthandle" />
									<%--现场报告及处理情况--%>
								</td>


								<td height="23" width="30%" colspan="3">
									<textarea id='ddAccidentbriefDto.freporthandle'
										name='ddAccidentbriefDto.freporthandle' rows='3' cols='50'>${ddAccidentbriefForm.ddAccidentbriefDto.freporthandle}</textarea>
								</td>

							</tr>
							<tr>

								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddAccidentbriefDto.accidentreason" />
									<%--故障原因--%>
								</td>


								<td height="23" width="30%">
									<input type="text" name="ddAccidentbriefDto.accidentreason"
										value="${ddAccidentbriefForm.ddAccidentbriefDto.accidentreason}" />
									<input type="hidden"
										name="ddAccidentbriefDto.zddaccidentbrief1.std_reasonid" />
									<img id="img1"
										src="<%=request.getContextPath()%>/themes/themes1/images/main/find.gif"
										onClick="setStdDdaccidentreasonSelect('ddAccidentbriefDto.accidentreason','ddAccidentbriefDto.zddaccidentbrief1.std_reasonid','0');">

								</td>


								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddAccidentbriefDto.fwhethercompleted" />
									<%--故障简报是否填完--%>
								</td>


								<td height="23" width="30%">
									<jhop:select name="ddAccidentbriefDto.fwhethercompleted"
										hiddName="" type="StdIsornot"
										initValue="${ddAccidentbriefForm.ddAccidentbriefDto.fwhethercompleted}">
									</jhop:select>
								</td>

							</tr>

						</table>
					</td>
				</tr>
			</table>
			<jhop:ctrlgroup
				ctrlId="UIControlGroupXPaneld61facb869a14623bccdcc04bf5fdd3e"
				title="核查信息">
			</jhop:ctrlgroup>

			<table class="detailmain" cellspacing="0" cellpadding="0">
				<tr id="UIControlGroupXPaneld61facb869a14623bccdcc04bf5fdd3e">
					<td align="center">
						<table class="detail" width="100%" height="100%" cellspacing="0">
							<tr>

								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddAccidentbriefDto.checkinfo" />
									<%--检查情况--%>
								</td>


								<td height="23" width="30%">
									<input id="ddAccidentbriefDto.checkinfo"
										name="ddAccidentbriefDto.checkinfo" type="text"
										value="${ddAccidentbriefForm.ddAccidentbriefDto.checkinfo}"
										size="10" />
								</td>


								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddAccidentbriefDto.checktime" />
									<%--合格检查时间--%>
								</td>


								<td height="23" width="30%">
									<jhop:date name="ddAccidentbriefDto.checktime" genText="yes"
										dateFormat="yyyy-mm-dd hh:mm:ss"
										initValue="${ddAccidentbriefForm.ddAccidentbriefDto.checktime}"></jhop:date>
								</td>

							</tr>
							<tr>

								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddAccidentbriefDto.unsatisfyreason" />
									<%--不合格原因--%>
								</td>


								<td height="23" width="30%">
									<input id="ddAccidentbriefDto.unsatisfyreason"
										name="ddAccidentbriefDto.unsatisfyreason" type="text"
										value="${ddAccidentbriefForm.ddAccidentbriefDto.unsatisfyreason}"
										size="10" />
								</td>


								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddAccidentbriefDto.checker" />
									<%--合格情况检查人--%>
								</td>


								<td height="23" width="30%">
									<input id="ddAccidentbriefDto.checker"
										name="ddAccidentbriefDto.checker" type="text"
										value="${ddAccidentbriefForm.ddAccidentbriefDto.checker}"
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

    var id = document.getElementById('ddAccidentbriefDto.faccidentid').value;

    //进行初始化动作


    if (id == '' || id == null){

       //初始化填单人

       document.getElementById('ddAccidentbriefDto.sys_fille').value = '<%=userName%>';

       //初始化填写单位


       document.getElementById('ddAccidentbriefDto.sys_filldept').value = '<%=userDeptName%>';

       //初始化填写时间


       document.getElementById('ddAccidentbriefDto.sys_filltime').value = '<%=currentTime%>';

       //数据所属单位


       document.getElementById('ddAccidentbriefDto.sys_dataowner').value = '<%=dataOwnerName%>';

    }



</script>
