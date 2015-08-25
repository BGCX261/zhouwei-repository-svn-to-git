<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map"%>
<%@ page import="com.techstar.dmis.helper.BusinessDetailHelper" %>
<%@ page import="com.techstar.dmis.helper.dto.BusinessDetailDto" %>
<%@ page import="java.sql.Timestamp" %>
<%@ page import="java.sql.Date" %>
<%@ include file="/common/init_tag.jsp"%>
<html>
	<head>
		<html:base />
		<title>停复役申请详情</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="../../themes/themes1/style.css" rel="stylesheet"
			type="text/css" />
		<%@ include file="/common/init_js.jsp"%>
		<%@ include file="/common/init_date.jsp"%>
		<script language="javascript" type="text/javascript"
			src="<%=request.getContextPath()%>/application/zdhsrapplication/ZDHSrapplication_defaultDetail_detail.js"></script>
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
		%>
		<html:javascript formName="zdhSrapplicationForm" />
		<logic:messagesPresent message="true">
			<html:messages id="message" message="true" header="messages.header"
				footer="messages.footer">
				<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
			</html:messages>
		</logic:messagesPresent>
		<form name="zdhSrapplicationForm" action="" method="post"
			enctype="multipart/form-data">
			<%--hidden--%>

			<input type="hidden" name="zdhSrapplicationDto.fapplicationno"
				value="${zdhSrapplicationForm.zdhSrapplicationDto.fapplicationno}">
			<input type="hidden" name="zdhSrapplicationDto.version"
				value="${zdhSrapplicationForm.zdhSrapplicationDto.version}">

			<jhop:ctrlgroup
				ctrlId="UIControlGroupXPanel20f861cbecbe49beb83430dc83fc315d"
				title="申请">
			</jhop:ctrlgroup>

			<table class="detailmain" cellspacing="0" cellpadding="0">
				<tr id="UIControlGroupXPanel20f861cbecbe49beb83430dc83fc315d">
					<td align="center">
						<table class="detail" width="100%" height="100%" cellspacing="0">
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhSrapplicationDto.fstationname" />
									<%--设备所属厂站名称--%>
								</td>
								<td height="23" width="30%">
									<input id="zdhSrapplicationDto.fstationname"
										name="zdhSrapplicationDto.fstationname" type="text"
										value="${zdhSrapplicationForm.zdhSrapplicationDto.fstationname}"
										size="10" />
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhSrapplicationDto.feqpclassname" />
									<%--停复役设备名称--%>
								</td>
								<td height="23" width="30%">
									<input id="zdhSrapplicationDto.feqpclassname"
										name="zdhSrapplicationDto.feqpclassname" type="text"
										value="${zdhSrapplicationForm.zdhSrapplicationDto.feqpclassname}"
										size="10" />
								</td>
							</tr>

							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message
										key="object.zdhSrapplicationDto.fmaintenancerange" />
									<%--停役检修内容及影响范围--%>
								</td>
								<td height="23" width="30%" colspan="3">
									<textarea id="zdhSrapplicationDto.fmaintenancerange"
										name="zdhSrapplicationDto.fmaintenancerange" rows='1'
										cols='78' type="_moz">${zdhSrapplicationForm.zdhSrapplicationDto.fmaintenancerange}</textarea>
								</td>
							</tr>

							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message
										key="object.zdhSrapplicationDto.fapplicationstarttime" />
									<%--申请停役开始时间--%>
								</td>
								<td height="23" width="30%">
									<jhop:dateselect
										name="zdhSrapplicationDto.fapplicationstarttime"
										endName="zdhSrapplicationDto.fapplicationendime"
										initValue="${zdhSrapplicationForm.zdhSrapplicationDto.fapplicationstarttime}"
										dateFormat="yyyy-mm-dd hh:mm:ss" group="start"></jhop:dateselect>
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message
										key="object.zdhSrapplicationDto.fapplicationendime" />
									<%--申请停役结束时间--%>
								</td>
								<td height="23" width="30%">
									<jhop:dateselect name="zdhSrapplicationDto.fapplicationendime"
										startName="zdhSrapplicationDto.fapplicationstarttime"
										initValue="${zdhSrapplicationForm.zdhSrapplicationDto.fapplicationendime}"
										dateFormat="yyyy-mm-dd hh:mm:ss" group="end"></jhop:dateselect>
								</td>
							</tr>

							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhSrapplicationDto.fattribute" />
									<%--停役性质--%>
								</td>
								<td height="23" width="30%">
									<jhop:select name="zdhSrapplicationDto.fattribute" hiddName=""
										type="fattribute"
										initValue="${zdhSrapplicationForm.zdhSrapplicationDto.fattribute}">
									</jhop:select>
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhSrapplicationDto.fisstop" />
									<%--是否停通道--%>
								</td>
								<td height="23" width="30%">
									<jhop:select name="zdhSrapplicationDto.fisstop" hiddName=""
										type="fisstop"
										initValue="${zdhSrapplicationForm.zdhSrapplicationDto.fisstop}">
									</jhop:select>
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhSrapplicationDto.fremarks" />
									<%--备注--%>
								</td>
								<td height="23" width="30%" colspan="3">
									<textarea id="zdhSrapplicationDto.fremarks"
										name="zdhSrapplicationDto.fremarks" rows='2' cols='78'
										type="_moz">${zdhSrapplicationForm.zdhSrapplicationDto.fremarks}</textarea>
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message
										key="object.zdhSrapplicationDto.fannexexplanation" />
									<%--附件--%>
								</td>
								<td height="23" width="30%" colspan="3">
									<jhop:upload name="fannexexplanation" multiValue="no"></jhop:upload>
								</td>
							</tr>
						</table>
				<tr>
					<td height="23" class="tab_0" width="20%">
						&nbsp;
					</td>
				</tr>

				<jhop:ctrlgroup
					ctrlId="UIControlGroupXPanel13605e22c891419c8e35693eb47f6491"
					title="批准信息">
				</jhop:ctrlgroup>
				<table class="detailmain" cellspacing="0" cellpadding="0">
					<tr id="UIControlGroupXPanel13605e22c891419c8e35693eb47f6491">
						<td align="center">
							<table class="detail" width="100%" height="100%" cellspacing="0">
								<tr>
									<td height="23" class="tab_0" width="20%">
										<bean:message
											key="object.zdhSrapplicationDto.fapprovalstarttime" />
										<%--开始时间--%>
									</td>
									<td height="23" width="30%">
										<jhop:dateselect name="zdhSrapplicationDto.fapprovalstarttime"
											endName="zdhSrapplicationDto.fapprovalendtime"
											initValue="${zdhSrapplicationForm.zdhSrapplicationDto.fapprovalstarttime}"
											dateFormat="yyyy-mm-dd hh:mm:ss" group="start"></jhop:dateselect>
									</td>
									<td height="23" class="tab_0" width="20%">
										<bean:message
											key="object.zdhSrapplicationDto.fapprovalendtime" />
										<%--结束时间--%>
									</td>
									<td height="23" width="30%">
										<jhop:dateselect name="zdhSrapplicationDto.fapprovalendtime"
											startName="zdhSrapplicationDto.fapprovalstarttime"
											initValue="${zdhSrapplicationForm.zdhSrapplicationDto.fapprovalendtime}"
											dateFormat="yyyy-mm-dd hh:mm:ss" group="end"></jhop:dateselect>
									</td>
								</tr>

								</td>
								</tr>
							</table>
					<tr>
						<td height="23" class="tab_0" width="20%">
							&nbsp;
						</td>
					</tr>
					<jhop:ctrlgroup
						ctrlId="UIControlGroupXPanel4660f9c6c08145a0aee3b931267bacaa"
						title="执行信息">
					</jhop:ctrlgroup>
					<table class="detailmain" cellspacing="0" cellpadding="0">
						<tr id="UIControlGroupXPanel4660f9c6c08145a0aee3b931267bacaa">
							<td align="center">
								<table class="detail" width="100%" height="100%" cellspacing="0">
									<tr>
										<td height="23" class="tab_0" width="20%">
											<bean:message key="object.zdhSrapplicationDto.frealstarttime" />
											<%--实际停役开始时间--%>
										</td>
										<td height="23" width="30%">
											<jhop:dateselect name="zdhSrapplicationDto.frealstarttime"
												endName="zdhSrapplicationDto.frealendtime"
												initValue="${zdhSrapplicationForm.zdhSrapplicationDto.frealstarttime}"
												dateFormat="yyyy-mm-dd hh:mm:ss" group="start"></jhop:dateselect>
										</td>
										<td height="23" class="tab_0" width="20%">
											<bean:message key="object.zdhSrapplicationDto.frealendtime" />
											<%--实际停役结束时间--%>
										</td>
										<td height="23" width="30%">
											<jhop:dateselect name="zdhSrapplicationDto.frealendtime"
												startName="zdhSrapplicationDto.frealstarttime"
												initValue="${zdhSrapplicationForm.zdhSrapplicationDto.frealendtime}"
												dateFormat="yyyy-mm-dd hh:mm:ss" group="end"></jhop:dateselect>
										</td>
									</tr>
									<tr>
										<td height="23" class="tab_0" width="20%">
											<bean:message key="object.zdhSrapplicationDto.fkeeptime" />
											<%--停役时长(分钟)--%>
										</td>
										<td height="23" width="30%">
											<input id="zdhSrapplicationDto.fkeeptime"
												name="zdhSrapplicationDto.fkeeptime" type="text"
												value="${zdhSrapplicationForm.zdhSrapplicationDto.fkeeptime}"
												size="10" />
										</td>
										<td height="23" class="tab_0" width="20%">
											<bean:message key="object.zdhSrapplicationDto.fexcutestatus" />
											<%--执行状态--%>
										</td>
										<td height="23" width="30%">
											<jhop:select name="zdhSrapplicationDto.fexcutestatus"
												hiddName="" type="fexcutestatus"
												initValue="${zdhSrapplicationForm.zdhSrapplicationDto.fexcutestatus}">
											</jhop:select>
										</td>
									</tr>

									</td>
									</tr>
								</table>
						<tr>
							<td height="10" class="tab_0" width="20%">
							</td>
						</tr>
						<jhop:ctrlgroup
							ctrlId="UIControlGroupXPanel363b0e49de74475e82cc530ffd954d7e"
							title="不可见信息">
						</jhop:ctrlgroup>
						<table class="detailmain" cellspacing="0" cellpadding="0">
							<tr id="UIControlGroupXPanel363b0e49de74475e82cc530ffd954d7e">
								<td align="center">
									<table class="detail" width="100%" height="100%"
										cellspacing="0">
										<tr>

											<td height="23" class="tab_0" width="20%">
												<bean:message key="object.zdhSrapplicationDto.fstationid" />
												<%--厂站编号--%>
											</td>


											<td height="23" width="30%" colspan="3">
												<input id="zdhSrapplicationDto.fstationid"
													name="zdhSrapplicationDto.fstationid" type="text"
													value="${zdhSrapplicationForm.zdhSrapplicationDto.fstationid}"
													size="10" 
													readonly="true" />
											</td>

										</tr>
										<tr>

											<td height="23" class="tab_0" width="20%">
												<bean:message key="object.zdhSrapplicationDto.feqpclasstype" />
												<%--设备类型--%>
											</td>

											<td height="23" width="30%">
												<input id="zdhSrapplicationDto.feqpclasstype"
													name="zdhSrapplicationDto.feqpclasstype" type="text"
													value="${zdhSrapplicationForm.zdhSrapplicationDto.feqpclasstype}"
													size="10" 
													readonly="true"  />
											</td>


											<td height="23" class="tab_0" width="20%">
												<bean:message
													key="object.zdhSrapplicationDto.fapplicationtype" />
												<%--申请单类型--%>
											</td>


											<td height="23" width="30%">
												<input id="zdhSrapplicationDto.fapplicationtype"
													name="zdhSrapplicationDto.fapplicationtype" type="text"
													value="${zdhSrapplicationForm.zdhSrapplicationDto.fapplicationtype}"
													size="10" 
													readonly="true" />
											</td>

										</tr>
										<tr>

											<td height="23" class="tab_0" width="20%">
												<bean:message
													key="object.zdhSrapplicationDto.fapplicationono" />
												<%--申请单正式编号--%>
												<span class="article_required">*</span>
											</td>


											<td height="23" width="30%">
												<input id="zdhSrapplicationDto.fapplicationono"
													name="zdhSrapplicationDto.fapplicationono" type="text"
													value="${zdhSrapplicationForm.zdhSrapplicationDto.fapplicationono}"
													size="10" 
													readonly="true" />
											</td>


											<td height="23" class="tab_0" width="20%">
												<bean:message key="object.zdhSrapplicationDto.sys_fille" />
												<%--填写人--%>
											</td>


											<td height="23" width="30%">
												<input id="zdhSrapplicationDto.sys_fille"
													name="zdhSrapplicationDto.sys_fille" type="text"
													value="${zdhSrapplicationForm.zdhSrapplicationDto.sys_fille}"
													size="10" 
													readonly="true" />
											</td>

										</tr>
										<tr>

											<td height="23" class="tab_0" width="20%">
												<bean:message key="object.zdhSrapplicationDto.sys_filldept" />
												<%--填写单位--%>
											</td>


											<td height="23" width="30%">
												<input id="zdhSrapplicationDto.sys_filldept"
													name="zdhSrapplicationDto.sys_filldept" type="text"
													value="${zdhSrapplicationForm.zdhSrapplicationDto.sys_filldept}"
													size="10" 
													readonly="true" />
											</td>


											<td height="23" class="tab_0" width="20%">
												<bean:message key="object.zdhSrapplicationDto.sys_filltime" />
												<%--填写时间--%>
											</td>


											<td height="23" width="30%">
											    <input id="zdhSrapplicationDto.sys_filltime"
													name="zdhSrapplicationDto.sys_filltime" type="text"
													value="${zdhSrapplicationForm.zdhSrapplicationDto.sys_filltime}"
													size="10" 
													readonly="true" />												
											</td>

										</tr>
										<tr>

											<td height="23" class="tab_0" width="20%">
												<bean:message key="object.zdhSrapplicationDto.sys_dataowner" />
												<%--数据所属单位--%>
											</td>


											<td height="23" width="30%">
												<input id="zdhSrapplicationDto.sys_dataowner"
													name="zdhSrapplicationDto.sys_dataowner" type="text"
													value="${zdhSrapplicationForm.zdhSrapplicationDto.sys_dataowner}"
													size="10" 
													readonly="true" />
											</td>


											<td height="23" class="tab_0" width="20%">
												<bean:message key="object.zdhSrapplicationDto.fstatus" />
												<%--流转状态--%>
											</td>


											<td height="23" width="30%">
												<input id="zdhSrapplicationDto.fstatus"
													name="zdhSrapplicationDto.fstatus" type="text"
													value="${zdhSrapplicationForm.zdhSrapplicationDto.fstatus}"
													size="10" 
													readonly="true" />
											</td>

										</tr>
										<tr>

											<td height="23" class="tab_0" width="20%">
												<bean:message key="object.zdhSrapplicationDto.flocalopinion" />
												<%--属地公司领导意见--%>
											</td>


											<td height="23" width="30%">
												<input id="zdhSrapplicationDto.flocalopinion"
													name="zdhSrapplicationDto.flocalopinion" type="text"
													value="${zdhSrapplicationForm.zdhSrapplicationDto.flocalopinion}"
													size="10" 
													readonly="true" />
											</td>


											<td height="23" class="tab_0" width="20%">
												<bean:message
													key="object.zdhSrapplicationDto.fcenteropinion2" />
												<%--中心自动化处意见--%>
											</td>


											<td height="23" width="30%">
												<input id="zdhSrapplicationDto.fcenteropinion2"
													name="zdhSrapplicationDto.fcenteropinion2" type="text"
													value="${zdhSrapplicationForm.zdhSrapplicationDto.fcenteropinion2}"
													size="10" 
													readonly="true" />
											</td>

										</tr>
										<tr>

											<td height="23" class="tab_0" width="20%">
												<bean:message
													key="object.zdhSrapplicationDto.flocalopinion2" />
												<%--属地调度意见--%>
											</td>


											<td height="23" width="30%">
												<input id="zdhSrapplicationDto.flocalopinion2"
													name="zdhSrapplicationDto.flocalopinion2" type="text"
													value="${zdhSrapplicationForm.zdhSrapplicationDto.flocalopinion2}"
													size="10" 
													readonly="true" />
											</td>


											<td height="23" class="tab_0" width="20%">
												<bean:message
													key="object.zdhSrapplicationDto.fcenteropinion1" />
												<%--中心主管主任意见--%>
											</td>


											<td height="23" width="30%">
												<input id="zdhSrapplicationDto.fcenteropinion1"
													name="zdhSrapplicationDto.fcenteropinion1" type="text"
													value="${zdhSrapplicationForm.zdhSrapplicationDto.fcenteropinion1}"
													size="10" 
													readonly="true" />
											</td>

										</tr>
										<tr>

											<td height="23" class="tab_0" width="20%">
												<bean:message
													key="object.zdhSrapplicationDto.fcenteropinion3" />
												<%--运维中心意见--%>
											</td>


											<td height="23" width="30%" colspan="3">
												<input id="zdhSrapplicationDto.fcenteropinion3"
													name="zdhSrapplicationDto.fcenteropinion3" type="text"
													value="${zdhSrapplicationForm.zdhSrapplicationDto.fcenteropinion3}"
													size="10" 
													readonly="true" />
											</td>

										</tr>
										<tr>

											<td height="23" class="tab_0" width="20%">
												&nbsp;
											</td>

										</tr>





										</tr>

									</table>
								</td>
							</tr>
						</table>
		</form>
	</body>
	<script>
	    var id = document.getElementById('zdhSrapplicationDto.fapplicationno').value;
	    
	    //进行初始化动作
	    if (id == '' || id == null){
	       //初始化填单人
	       document.getElementById('zdhSrapplicationDto.sys_fille').value = '<%= userName %>';
	       //初始化填写单位       
	       document.getElementById('zdhSrapplicationDto.sys_filldept').value = '<%= userDeptName %>';
	       //初始化填写时间
	       document.getElementById('zdhSrapplicationDto.sys_filltime').value = '<%= currentTime %>';
	       //数据所属单位
	       document.getElementById('zdhSrapplicationDto.sys_dataowner').value = '<%= dataOwnerName %>';       
	       //执行状态
	       document.getElementById('zdhSrapplicationDto.fexcutestatus').value = '未执行';
	       
	       //申请停役开始时间
	       document.getElementById('zdhSrapplicationDto.fapplicationstarttime').value = '<%= currentTime %>';
	       //申请停役结束时间
	       document.getElementById('zdhSrapplicationDto.fapplicationendime').value = '<%= currentTime %>';
	       //批准开始时间
		   document.getElementById('zdhSrapplicationDto.fapprovalstarttime').value = '<%= currentTime %>';	
	       //实际停役开始时间
	       document.getElementById('zdhSrapplicationDto.frealstarttime').value = '<%= currentTime %>';
		   							
		   					
	    }
	    
	</script>
</html>
