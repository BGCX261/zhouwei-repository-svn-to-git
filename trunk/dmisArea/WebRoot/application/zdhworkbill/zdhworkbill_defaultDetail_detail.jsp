<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map"%>
<%@ page import="com.techstar.dmis.helper.BusinessDetailHelper"%>
<%@ page import="com.techstar.dmis.helper.dto.BusinessDetailDto"%>
<%@ page import="com.techstar.dmis.common.ZdhConstants"%>
<%@ page import="java.sql.Timestamp"%>
<%@ page import="java.sql.Date"%>
<%@ include file="/common/init_tag.jsp"%>
<html>
	<head>
		<html:base />
		<title>工作票详情</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="../../themes/themes1/style.css" rel="stylesheet"
			type="text/css" />
		<%@ include file="/common/init_js.jsp"%>
		<%@ include file="/common/init_date.jsp"%>
		<script language="javascript" type="text/javascript"
			src="<%=request.getContextPath()%>/application/zdhworkbill/zdhworkbill_defaultDetail_detail.js"></script>
	</head>
	<body>

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
			Date currentDate = bdt.getCurrentDate();
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

			//初始业务状态
			String fexcutestatus = ZdhConstants.ZdhWorkbill_BUSINESS_CITY_NEW;
			//流转状态
			String fstatus = ZdhConstants.ZdhWorkbill_WORKFLOW_CITY_STATUS_NEW;
		%>
		<html:javascript formName="zdhWorkbillForm" />
		<logic:messagesPresent message="true">
			<html:messages id="message" message="true" header="messages.header"
				footer="messages.footer">
				<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
			</html:messages>
		</logic:messagesPresent>
		<form name="zdhWorkbillForm" action="" method="post"
			enctype="multipart/form-data">
			<%--hidden--%>

			<input type="hidden" name="zdhWorkbillDto.workbillid"
				value="<c:out value="${zdhWorkbillForm.zdhWorkbillDto.workbillid}"/>">
			<input type="hidden" name="zdhWorkbillDto.version"
				value="<c:out value="${zdhWorkbillForm.zdhWorkbillDto.version}"/>">

			<jhop:ctrlgroup
				ctrlId="UIControlGroupXPanele8b788390e454d699821499625e5ba8b"
				title="工作票申请">
			</jhop:ctrlgroup>

			<table class="detailmain" cellspacing="0" cellpadding="0">
				<tr id="UIControlGroupXPanele8b788390e454d699821499625e5ba8b">
					<td align="center">
						<table class="detail" width="100%" height="100%" cellspacing="0">
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhWorkbillDto.applicationunit" />
									<%--申请单位--%>
								</td>
								<td height="23" width="30%">
									<input id="zdhWorkbillDto.applicationunit"
										name="zdhWorkbillDto.applicationunit" type="text"
										value="<c:out value="${zdhWorkbillForm.zdhWorkbillDto.applicationunit}"/>"
										size="10" />
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhWorkbillDto.applicantedtime" />
									<%--申请时间--%>
								</td>
								<td height="23" width="30%">
									<jhop:date name="zdhWorkbillDto.applicantedtime" genText="yes"
										showSecond="true"  
										dateFormat="yyyy-mm-dd hh:mm"
										initValue="${zdhWorkbillForm.zdhWorkbillDto.applicantedtime}"></jhop:date>
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhWorkbillDto.applicants" />
									<%--申请人--%>
								</td>
								<td height="23" width="30%">
									<input id="zdhWorkbillDto.applicants"
										name="zdhWorkbillDto.applicants" type="text"
										value="<c:out value="${zdhWorkbillForm.zdhWorkbillDto.applicants}"/>" size="10" />
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhWorkbillDto.applicantsnum" />
									<%--申请人数--%>
								</td>
								<td height="23" width="30%">
									<input id="zdhWorkbillDto.applicantsnum"
										name="zdhWorkbillDto.applicantsnum" type="text"
										value="<c:out value="${zdhWorkbillForm.zdhWorkbillDto.applicantsnum}"/>"
										size="10" />
								</td>
								
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhWorkbillDto.worktime" />
									<%--工作时间--%>
								</td>
								<td height="23" width="30%">
									<jhop:date name="zdhWorkbillDto.worktime" genText="yes"
										dateFormat="yyyy-mm-dd"
										initValue="${zdhWorkbillForm.zdhWorkbillDto.worktime}"></jhop:date>
								</td>
							</tr>
							<!--tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhWorkbillDto.workingbilltype" />
									<%--工作票类型--%>
								</td>
								<td height="23" width="30%" >
									<input id="zdhWorkbillDto.workingbilltype"
										name="zdhWorkbillDto.workingbilltype" type="text"
										value="${zdhWorkbillForm.zdhWorkbillDto.workingbilltype}"
										size="10" />
								</td>
							</tr-->
							<!--tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhWorkbillDto.sys_fille" />
									<%--填写人--%>
								</td>
								<td height="23" width="30%">
									<input id="zdhWorkbillDto.sys_fille"
										name="zdhWorkbillDto.sys_fille" type="text"
										value="${zdhWorkbillForm.zdhWorkbillDto.sys_fille}" size="10"
										readonly />
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhWorkbillDto.sys_filldept" />
									<%--填写单位--%>
								</td>
								<td height="23" width="30%">
									<input id="zdhWorkbillDto.sys_filldept"
										name="zdhWorkbillDto.sys_filldept" type="text"
										value="${zdhWorkbillForm.zdhWorkbillDto.sys_filldept}"
										size="10" readonly />
								</td>
							</tr-->
							<!--tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhWorkbillDto.sys_filltime" />
									<%--填写时间--%>
								</td>
								<td height="23" width="30%">
									<input id="zdhWorkbillDto.sys_filltime"
										name="zdhWorkbillDto.sys_filltime" type="text"
										value="${zdhWorkbillForm.zdhWorkbillDto.sys_filltime}"
										size="10" readonly />

								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhWorkbillDto.sys_isvalid" />
									<%--是否有效字段--%>
								</td>
								<td height="23" width="30%">
									<input id="zdhWorkbillDto.sys_isvalid"
										name="zdhWorkbillDto.sys_isvalid" type="text"
										value="${zdhWorkbillForm.zdhWorkbillDto.sys_isvalid}"
										size="10" readonly />
								</td>
							</tr-->
							
								<!--td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhWorkbillDto.sys_dataowner" />
									<%--数据所属单位--%>
								</td>
								<td height="23" width="30%">
									<input id="zdhWorkbillDto.sys_dataowner"
										name="zdhWorkbillDto.sys_dataowner" type="text"
										value="${zdhWorkbillForm.zdhWorkbillDto.sys_dataowner}"
										size="10" readonly />
								</td-->
							<!--tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhWorkbillDto.fstatus" />
									<%--流转状态--%>
								</td>
								<td height="23" width="30%">
									<input id="zdhWorkbillDto.fstatus"
										name="zdhWorkbillDto.fstatus" type="text"
										value="${zdhWorkbillForm.zdhWorkbillDto.fstatus}" size="10"
										readonly />
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message
										key="object.zdhWorkbillDto.zzdhworkbill2.ondutyno" />
									<%--交接班记录编号--%>
								</td>
								<td height="23" width="30%">
									<input id="zdhWorkbillDto.zzdhworkbill2.ondutyno"
										name="zdhWorkbillDto.zzdhworkbill2.ondutyno" type="text"
										value="${zdhWorkbillForm.zdhWorkbillDto.zzdhworkbill2.ondutyno}"
										size="10" readonly />
								</td>
							</tr-->
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhWorkbillDto.workcontent" />
									<%--工作内容--%>
								</td>
								<td height="23" width="30%" colspan="3">
									<textarea id='zdhWorkbillDto.workcontent'
										name='zdhWorkbillDto.workcontent' rows='3' cols='50'
										type="_moz"><c:out value="${zdhWorkbillForm.zdhWorkbillDto.workcontent}"/></textarea>
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhWorkbillDto.relativesystem" />
									<%--相关系统--%>
								</td>
								<td height="23" width="30%">
									<input id="zdhWorkbillDto.relativesystem"
										name="zdhWorkbillDto.relativesystem" type="text"
										value="<c:out value="${zdhWorkbillForm.zdhWorkbillDto.relativesystem}"/>"
										size="10" />
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhWorkbillDto.relativeequipment" />
									<%--相关设备--%>
								</td>
								<td height="23" width="30%">
									<input id="zdhWorkbillDto.relativeequipment"
										name="zdhWorkbillDto.relativeequipment" type="text"
										value="<c:out value="${zdhWorkbillForm.zdhWorkbillDto.relativeequipment}"/>"
										size="10" />
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhWorkbillDto.dangerouspoint" />
									<%--危险点分析及措施--%>
								</td>
								<td height="23" width="30%" colspan="3">
									<textarea id='zdhWorkbillDto.dangerouspoint'
										name='zdhWorkbillDto.dangerouspoint' rows='3' cols='50'
										type="_moz"><c:out value="${zdhWorkbillForm.zdhWorkbillDto.dangerouspoint}"/></textarea>
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhWorkbillDto.safetyremarks" />
									<%--注意事项及安全措施--%>
								</td>
								<td height="23" width="30%" colspan="3">
									<textarea id='zdhWorkbillDto.safetyremarks'
										name='zdhWorkbillDto.safetyremarks' rows='3' cols='50'
										type="_moz"><c:out value="${zdhWorkbillForm.zdhWorkbillDto.safetyremarks}"/></textarea>
								</td>
							</tr>
							
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhWorkbillDto.workingbillno" />
									<%--机房工作票编号--%>
									<span class="article_required">*</span>
								</td>
								<td height="23" width="30%" colspan="3">
									<input id="zdhWorkbillDto.workingbillno"
										name="zdhWorkbillDto.workingbillno" type="text"
										value="<c:out value="${zdhWorkbillForm.zdhWorkbillDto.workingbillno}"/>"
										size="10" />
								</td>
							</tr>
							<tr>
								
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhWorkbillDto.workingcharge" />
									<%--工作负责人--%>
								</td>
								<td height="23" width="30%">
									<input id="zdhWorkbillDto.workingcharge"
										name="zdhWorkbillDto.workingcharge" type="text"
										value="<c:out value="${zdhWorkbillForm.zdhWorkbillDto.workingcharge}"/>"
										size="10" />
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhWorkbillDto.remarks" />
									<%--备注--%>
								</td>
								<td height="23" width="30%" colspan="3">
									<textarea id="zdhWorkbillDto.remarks"
										name="zdhWorkbillDto.remarks" rows='3' cols='65' type="_moz"><c:out value="${zdhWorkbillForm.zdhWorkbillDto.remarks}"/></textarea>
								</td>
							</tr>
							<!--tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhWorkbillDto.fstatus" />
									<%--流转状态--%>
								</td>
								<td height="23" width="30%">
									<input id="zdhWorkbillDto.fstatus"
										name="zdhWorkbillDto.fstatus" type="text"
										value="${zdhWorkbillForm.zdhWorkbillDto.fstatus}" size="10"
										readonly />
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message
										key="object.zdhWorkbillDto.zzdhworkbill2.ondutyno" />
									<%--交接班记录编号--%>
								</td>
								<td height="23" width="30%">
									<input id="zdhWorkbillDto.zzdhworkbill2.ondutyno"
										name="zdhWorkbillDto.zzdhworkbill2.ondutyno" type="text"
										value="${zdhWorkbillForm.zdhWorkbillDto.zzdhworkbill2.ondutyno}"
										size="10" readonly />
								</td>
							</tr-->
							<!-- 工作票类型 -->
							<input id="zdhWorkbillDto.workingbilltype" name="zdhWorkbillDto.workingbilltype" type="hidden" value="<c:out value="${zdhWorkbillForm.zdhWorkbillDto.workingbilltype}"/>"  />
							<!-- 流转状态 -->
							<input id="zdhWorkbillDto.fstatus" name="zdhWorkbillDto.fstatus" type="hidden" value="<c:out value="${zdhWorkbillForm.zdhWorkbillDto.fstatus}"/>"  />
							<!-- 交接班记录编号 -->
							<input id="zdhWorkbillDto.zzdhworkbill2.ondutyno" name="zdhWorkbillDto.zzdhworkbill2.ondutyno" type="hidden" value="<c:out value="${zdhWorkbillForm.zdhWorkbillDto.zzdhworkbill2.ondutyno}"/>"  />
						</table>
					</td>
				</tr>
			</table>
			<jhop:ctrlgroup
				ctrlId="UIControlGroupXPanelfac0e56e3cfc4191afa7a54b2d1e9a75"
				title="工作票执行">

			</jhop:ctrlgroup>

			<table class="detailmain" cellspacing="0" cellpadding="0">
				<tr id="UIControlGroupXPanelfac0e56e3cfc4191afa7a54b2d1e9a75">
					<td align="center">
						<table class="detail" width="100%" height="100%" cellspacing="0">
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhWorkbillDto.workbegintime" />
									<%--工作实际完成时间--%>
								</td>
								<td height="23" width="30%">
									<jhop:date name="zdhWorkbillDto.workbegintime" genText="yes"
										showSecond="true"  
										dateFormat="yyyy-mm-dd hh:mm"
										initValue="${zdhWorkbillForm.zdhWorkbillDto.workbegintime}"></jhop:date>
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhWorkbillDto.fexcutestatus" />
									<%--工作票状态--%> 
								</td>
								<td height="23" width="30%" >
									<input id="zdhWorkbillDto.fexcutestatus"
										name="zdhWorkbillDto.fexcutestatus" type="text"
										value="<c:out value="${zdhWorkbillForm.zdhWorkbillDto.fexcutestatus}"/>"
										size="10" readonly />
								</td>
							</tr>
							<!--tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhWorkbillDto.fapprover" />
									<%--审核人--%>
								</td>
								<td height="23" width="30%">
									<input id="zdhWorkbillDto.fapprover"
										name="zdhWorkbillDto.fapprover" type="text"
										value="${zdhWorkbillForm.zdhWorkbillDto.fapprover}" size="10"
										readonly="true" />
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhWorkbillDto.fallower" />
									<%--许可人--%>
								</td>
								<td height="23" width="30%">
									<input id="zdhWorkbillDto.fallower"
										name="zdhWorkbillDto.fallower" type="text"
										value="${zdhWorkbillForm.zdhWorkbillDto.fallower}" size="10"
										readonly="true" />
								</td>
							</tr-->
							<input id="zdhWorkbillDto.fapprover"    name="zdhWorkbillDto.fapprover" 	 type="hidden" value="<c:out value="${zdhWorkbillForm.zdhWorkbillDto.fapprover}"/>"  />
							<input id="zdhWorkbillDto.fallower" name="zdhWorkbillDto.fallower"     type="hidden" value="<c:out value="${zdhWorkbillForm.zdhWorkbillDto.fallower}"/>"  />
						</table>
					</td>
				</tr>
			</table>
			<jhop:ctrlgroup
				ctrlId="UIControlGroupXPanelcb7b015745144e5e89348466b4acb361"
				title="工作票核查">
			</jhop:ctrlgroup>

			<table class="detailmain" cellspacing="0" cellpadding="0">
				<tr id="UIControlGroupXPanelcb7b015745144e5e89348466b4acb361">
					<td align="center">
						<table class="detail" width="100%" height="100%" cellspacing="0">
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhWorkbillDto.ispassed" />
									<%--是否合格--%>
								</td>
								<td height="23" width="80%" colspan="3">
									<jhop:select name="zdhWorkbillDto.ispassed" hiddName=""
										type="ispassed"
										initValue="${zdhWorkbillForm.zdhWorkbillDto.ispassed}">
									</jhop:select>
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhWorkbillDto.reason" />
									<%--不合格原因--%>
								</td>
								<td height="23" width="80%" colspan="3">
									<textarea id='zdhWorkbillDto.reason'
										name='zdhWorkbillDto.reason' rows='3' cols='50' type="_moz"><c:out value="${zdhWorkbillForm.zdhWorkbillDto.reason}"/></textarea>
								</td>
							</tr>

							<!--tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhWorkbillDto.passchecker" />
									<%--合格情况核查人--%>
								</td>
								<td height="23" width="30%">
									<input id="zdhWorkbillDto.passchecker"
										name="zdhWorkbillDto.passchecker" type="text"
										value="${zdhWorkbillForm.zdhWorkbillDto.passchecker}"
										size="10" readonly="true" />
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhWorkbillDto.passchecktime" />
									<%--合格核查时间--%>
								</td>
								<td height="23" width="30%">
									<jhop:date name="zdhWorkbillDto.passchecktime" genText="yes"
										dateFormat="yyyy-mm-dd hh:mm:ss"
										initValue="${zdhWorkbillForm.zdhWorkbillDto.passchecktime}"></jhop:date>
								</td>
								
							</tr-->
							<input id="zdhWorkbillDto.passchecker"    name="zdhWorkbillDto.passchecker" 	  	 type="hidden" value="<c:out value="${zdhWorkbillForm.zdhWorkbillDto.passchecker}"/>"  />
							<input id="zdhWorkbillDto.passchecktime" name="zdhWorkbillDto.passchecktime"     type="hidden" value="<c:out value="${zdhWorkbillForm.zdhWorkbillDto.passchecktime}"/>"  />
						</table>
					</td>
				</tr>
			</table>
			<input id="zdhWorkbillDto.sys_fille"    name="zdhWorkbillDto.sys_fille" 	  	 type="hidden" value="<c:out value="${zdhWorkbillForm.zdhWorkbillDto.sys_fille}"/>"  />
			<input id="zdhWorkbillDto.sys_filldept" name="zdhWorkbillDto.sys_filldept"     type="hidden" value="<c:out value="${zdhWorkbillForm.zdhWorkbillDto.sys_filldept}"/>"  />
			<input id="zdhWorkbillDto.sys_filltime" name="zdhWorkbillDto.sys_filltime"  	 type="hidden" value="<c:out value="${zdhWorkbillForm.zdhWorkbillDto.sys_filltime}"/>"  />
		   	<input id="zdhWorkbillDto.sys_isvalid" name="zdhWorkbillDto.sys_isvalid"    	 type="hidden" value="<c:out value="${zdhWorkbillForm.zdhWorkbillDto.sys_isvalid}"/>"  />
			<input id="zdhWorkbillDto.sys_dataowner" name="zdhWorkbillDto.sys_dataowner" 	 type="hidden" value="<c:out value="${zdhWorkbillForm.zdhWorkbillDto.sys_dataowner}"/>"  />
		</form>
		<script>
    var id = document.getElementById('zdhWorkbillDto.workbillid').value;
    
    //进行初始化动作
    if (id == '' || id == null){
       //初始化填单人
       document.getElementById('zdhWorkbillDto.sys_fille').value = '<%= userName %>';
       //初始化填写单位       
       document.getElementById('zdhWorkbillDto.sys_filldept').value = '<%= userDeptName %>';
       //初始化填写时间
       document.getElementById('zdhWorkbillDto.sys_filltime').value = '<%= currentTime %>';
       //数据所属单位
       document.getElementById('zdhWorkbillDto.sys_dataowner').value = '<%= dataOwnerName %>';
       //申请时间
       document.getElementById('zdhWorkbillDto.applicantedtime').value = '<%= currentTime%>';
       //工作时间
       document.getElementById('zdhWorkbillDto.worktime').value = '<%= currentDate%>';
       //初始化填单人
       document.getElementById('zdhWorkbillDto.applicants').value = '<%= userName %>';
       //初始化填写单位       
       document.getElementById('zdhWorkbillDto.applicationunit').value = '<%= userDeptName %>';
       //执行状态
       document.getElementById('zdhWorkbillDto.fexcutestatus').value = '<%= fexcutestatus %>';
       //流转状态
       document.getElementById('zdhWorkbillDto.fstatus').value = '<%= fstatus %>';
    }
    
</script>
	</body>
</html>
