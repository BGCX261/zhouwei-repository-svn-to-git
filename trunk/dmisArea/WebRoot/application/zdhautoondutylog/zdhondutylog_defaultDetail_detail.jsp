<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map"%>
<%@ page import="com.techstar.dmis.helper.BusinessDetailHelper"%>
<%@ page import="com.techstar.dmis.helper.dto.BusinessDetailDto"%>
<%@ page import="java.sql.Timestamp"%>
<%@ page import="java.sql.Date"%>
<%@ include file="/common/init_tag.jsp"%>
<html>
	<head>
		<html:base />
		<title>自动化值班日志详情</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="../../themes/themes1/style.css" rel="stylesheet"
			type="text/css" />
		<%@ include file="/common/init_js.jsp"%>
		<%@ include file="/common/init_date.jsp"%>
		<script language="javascript" type="text/javascript"
			src="<%=request.getContextPath()%>/application/zdhautoondutylog/zdhondutylog_defaultDetail_detail.js"></script>
	</head>
	<body>
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
		%>
		<html:javascript formName="zdhAutoondutylogForm" />
		<logic:messagesPresent message="true">
			<html:messages id="message" message="true" header="messages.header"
				footer="messages.footer">
				<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
			</html:messages>
		</logic:messagesPresent>
		<form name="zdhAutoondutylogForm" action="" method="post">
			<%--hidden--%>

			<input type="hidden" name="zdhAutoondutylogDto.ondutyno"
				value="${zdhAutoondutylogForm.zdhAutoondutylogDto.ondutyno}">
			<input type="hidden" name="zdhAutoondutylogDto.version"
				value="${zdhAutoondutylogForm.zdhAutoondutylogDto.version}">

			<jhop:ctrlgroup
				ctrlId="UIControlGroupXPanelc4c887ce07514ba2a30af528aef6b9de"
				title="交接班信息">
			</jhop:ctrlgroup>

			<table class="detailmain" cellspacing="0" cellpadding="0">
				<tr id="UIControlGroupXPanelc4c887ce07514ba2a30af528aef6b9de">
					<td align="center">
						<table class="detail" width="100%" height="100%" cellspacing="0">
							<tr>

								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhAutoondutylogDto.attendant2" />
									<%--值班人--%>
								</td>


								<td height="23" width="30%">
									<input type="text" name="zdhAutoondutylogDto.attendant2"
										value="${zdhAutoondutylogForm.zdhAutoondutylogDto.attendant2}" />
									<img id="img1"
										src="<%=request.getContextPath()%>/themes/themes1/images/main/find.gif"
										onClick="setGgPersonSelect('zdhAutoondutylogDto.attendant2','','0');">

								</td>


								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhAutoondutylogDto.successor2" />
									<%--接班人--%>
								</td>


								<td height="23" width="30%">
									<input type="text" name="zdhAutoondutylogDto.successor2"
										value="${zdhAutoondutylogForm.zdhAutoondutylogDto.successor2}" />
									<img id="img1"
										src="<%=request.getContextPath()%>/themes/themes1/images/main/find.gif"
										onClick="setGgPersonSelect('zdhAutoondutylogDto.successor2','','0');">

								</td>

							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhAutoondutylogDto.successiontime" />
									<%--接班时间--%>
								</td>
								<td height="23" width="30%">
									<input id="zdhAutoondutylogDto.successiontime"
										name="zdhAutoondutylogDto.successiontime" type="text"
										value="${zdhAutoondutylogForm.zdhAutoondutylogDto.successiontime}"
										size="20" readonly/>
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhAutoondutylogDto.handovertime" />
									<%--交班时间--%>
								</td>
								<td height="23" width="30%">
									<input id="zdhAutoondutylogDto.handovertime"
										name="zdhAutoondutylogDto.handovertime" type="text"
										value="${zdhAutoondutylogForm.zdhAutoondutylogDto.handovertime}"
										size="20" readonly/>
								</td>
							</tr>
							<tr>

								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhAutoondutylogDto.upstemperature" />
									<%--UPS电源室温度--%>
								</td>


								<td height="23" width="30%">
									<input id="zdhAutoondutylogDto.upstemperature"
										name="zdhAutoondutylogDto.upstemperature" type="text"
										value="${zdhAutoondutylogForm.zdhAutoondutylogDto.upstemperature}"
										size="10" />
								</td>


								<td height="23" class="tab_0" width="20%">
									<bean:message
										key="object.zdhAutoondutylogDto.machinehalltemperature" />
									<%--机房温度--%>
								</td>


								<td height="23" width="30%">
									<input id="zdhAutoondutylogDto.machinehalltemperature"
										name="zdhAutoondutylogDto.machinehalltemperature" type="text"
										value="${zdhAutoondutylogForm.zdhAutoondutylogDto.machinehalltemperature}"
										size="10" />
								</td>

							</tr>
							<tr>

								<td height="23" class="tab_0" width="20%">
									<bean:message
										key="object.zdhAutoondutylogDto.machinehallhealth" />
									<%--机房卫生--%>
								</td>
								<td height="23" width="30%">
									<input id="zdhAutoondutylogDto.machinehallhealth"
										name="zdhAutoondutylogDto.machinehallhealth" type="text"
										value="${zdhAutoondutylogForm.zdhAutoondutylogDto.machinehallhealth}"
										size="10" />
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message
										key="object.zdhAutoondutylogDto.morningreportsystem" />
									<%--早汇报系统是否正常--%>
								</td>
								<td height="23" width="30%">
									<input id="zdhAutoondutylogDto.morningreportsystem"
										name="zdhAutoondutylogDto.morningreportsystem" type="text"
										value="${zdhAutoondutylogForm.zdhAutoondutylogDto.morningreportsystem}"
										size="10" />
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message
										key="object.zdhAutoondutylogDto.logdate" />
									<%--日志日期--%>
								</td>
								<td height="23" width="30%" colspan="3">
									<input id="zdhAutoondutylogDto.logdate"
										name="zdhAutoondutylogDto.logdate" type="text"
										value="${zdhAutoondutylogForm.zdhAutoondutylogDto.logdate}"
										size="20"  readonly/>
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhAutoondutylogDto.remarks" />
									<%--备注--%>
								</td>
								<td height="23" width="30%" colspan="3">
									<textarea id='zdhAutoondutylogDto.remarks'
										name='zdhAutoondutylogDto.remarks' rows='3' cols='50'>${zdhAutoondutylogForm.zdhAutoondutylogDto.remarks}</textarea>
								</td>
							</tr>
							<!--tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhAutoondutylogDto.sys_fille" />
									<%--填写人--%>
								</td>
								<td height="23" width="30%">
									<input id="zdhAutoondutylogDto.sys_fille"
										name="zdhAutoondutylogDto.sys_fille" type="text"
										value="${zdhAutoondutylogForm.zdhAutoondutylogDto.sys_fille}"
										size="10" readonly="true" />
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhAutoondutylogDto.sys_filldept" />
									<%--填写单位--%>
								</td>
								<td height="23" width="30%">
									<input id="zdhAutoondutylogDto.sys_filldept"
										name="zdhAutoondutylogDto.sys_filldept" type="text"
										value="${zdhAutoondutylogForm.zdhAutoondutylogDto.sys_filldept}"
										size="10" readonly="true" />
								</td>
							</tr-->
							<!--tr>

								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhAutoondutylogDto.sys_filltime" />
									<%--填写时间--%>
								</td>


								<td height="23" width="30%">
									<input id="zdhAutoondutylogDto.sys_filltime"
										name="zdhAutoondutylogDto.sys_filltime" type="text"
										value="${zdhAutoondutylogForm.zdhAutoondutylogDto.sys_filltime}"
										size="10" readonly="true" />

								</td>


								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhAutoondutylogDto.sys_isvalid" />
									<%--是否有效字段--%>
								</td>


								<td height="23" width="30%">
									<input id="zdhAutoondutylogDto.sys_isvalid"
										name="zdhAutoondutylogDto.sys_isvalid" type="text"
										value="${zdhAutoondutylogForm.zdhAutoondutylogDto.sys_isvalid}"
										size="10" readonly="true" />
								</td>

							</tr-->
							<!--tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhAutoondutylogDto.sys_dataowner" />
									<%--数据所属单位--%>
								</td>


								<td height="23" width="30%" colspan="3">
									<input id="zdhAutoondutylogDto.sys_dataowner"
										name="zdhAutoondutylogDto.sys_dataowner" type="text"
										value="${zdhAutoondutylogForm.zdhAutoondutylogDto.sys_dataowner}"
										size="10" readonly="true" />
								</td>

							</tr-->							
		   				 	<input id="zdhAutoondutylogDto.sys_filltime" name="zdhAutoondutylogDto.sys_filltime" 	 type="hidden" value="${zdhAutoondutylogForm.zdhAutoondutylogDto.sys_filltime}"  />
		   				 	<input id="zdhAutoondutylogDto.sys_filldept" name="zdhAutoondutylogDto.sys_filldept" 	 type="hidden" value="${zdhAutoondutylogForm.zdhAutoondutylogDto.sys_filldept}"  />
		   				 	<input id="zdhAutoondutylogDto.sys_isvalid" name="zdhAutoondutylogDto.sys_isvalid" 		 type="hidden" value="${zdhAutoondutylogForm.zdhAutoondutylogDto.sys_isvalid}"  />
		   				 	<input id="zdhAutoondutylogDto.sys_dataowner" name="zdhAutoondutylogDto.sys_dataowner" 	 type="hidden" value="${zdhAutoondutylogForm.zdhAutoondutylogDto.sys_dataowner}"  />
		   				 	<input id="zdhAutoondutylogDto.sys_fille" name="zdhAutoondutylogDto.sys_fille" 			 type="hidden" value="${zdhAutoondutylogForm.zdhAutoondutylogDto.sys_fille}"  />
						</table>
					</td>
				</tr>
			</table>
		</form>
	</body>
	<script type="text/javascript">
   var id = document.getElementById('zdhAutoondutylogDto.ondutyno').value;
   
   //进行初始化动作
   if (id == '' || id == null){     
      //初始化填单人
       document.getElementById('zdhAutoondutylogDto.sys_fille').value = '<%=userName%>';
       //初始化填写单位       
       document.getElementById('zdhAutoondutylogDto.sys_filldept').value = '<%=userDeptName%>';
       //初始化填写时间
       document.getElementById('zdhAutoondutylogDto.sys_filltime').value = '<%=currentTime%>';
       //数据所属单位
       document.getElementById('zdhAutoondutylogDto.sys_dataowner').value = '<%=dataOwnerName%>';      
       //接班时间
       document.getElementById('zdhAutoondutylogDto.successiontime').value = '<%=currentTime%>';
       //交班时间
       document.getElementById('zdhAutoondutylogDto.handovertime').value = '<%=currentTime%>';
   }   
</script>
</html>
