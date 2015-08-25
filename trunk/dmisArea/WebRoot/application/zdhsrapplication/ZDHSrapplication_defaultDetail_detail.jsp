<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map"%>
<%@ page import="com.techstar.dmis.helper.BusinessDetailHelper" %>
<%@ page import="com.techstar.dmis.helper.dto.BusinessDetailDto" %>
<%@ page import="com.techstar.dmis.helper.ResourceHelp" %>
<%@ page import="com.techstar.dmis.common.ZdhConstants" %>
<%@ page import="com.techstar.dmis.web.form.ZdhSrapplicationForm" %>
<%@ page import="com.techstar.dmis.dto.ZdhSrapplicationDto" %>
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
			src="<%=request.getContextPath()%>/application/zdhsrapplication/ZDHSrapplication_defaultDetail_detail.js">
		</script>		
		<script language="javascript" type="text/javascript"
			src="<%=request.getContextPath()%>/script/eqpEquipmentApi.js">
		</script>
	</head>
	<body>
	    <% 
	    
	    ZdhSrapplicationForm zdhSrapplicationForm = (ZdhSrapplicationForm) request.getAttribute("zdhSrapplicationForm");
		
		ZdhSrapplicationDto  zdhSrapplicationDto = (ZdhSrapplicationDto)zdhSrapplicationForm.getZdhSrapplicationDto();
		
		String tFapplicationstarttime="";
		String tFapplicationendime="";
		String tFapprovalstarttime="";
		String tFapprovalendtime="";		
		String tFrealstarttime="";
		String tFrealendtime="";
		String    sFattribute="";
		String    sFisstop="";
		
	    if(zdhSrapplicationDto.getFapplicationno()!=null&&zdhSrapplicationDto.getFapplicationno().trim().length()>0){
	    
	    if(zdhSrapplicationDto.getFapplicationstarttime()!=null)
	    	tFapplicationstarttime=zdhSrapplicationDto.getFapplicationstarttime().toString();
	    	
	    	if(zdhSrapplicationDto.getFapplicationendime()!=null)
	    	tFapplicationendime=zdhSrapplicationDto.getFapplicationendime().toString();
	    	
	    	
	    	if(zdhSrapplicationDto.getFapprovalstarttime()!=null)
	    	tFapprovalstarttime=zdhSrapplicationDto.getFapprovalstarttime().toString();
	    	
	    	if(zdhSrapplicationDto.getFapprovalendtime()!=null)
	    	tFapprovalendtime=zdhSrapplicationDto.getFapprovalendtime().toString();	  
	    		
	    	if(zdhSrapplicationDto.getFrealstarttime()!=null)
	    	tFrealstarttime=zdhSrapplicationDto.getFrealstarttime().toString();
	    	
	    	if(zdhSrapplicationDto.getFrealendtime()!=null)
	    	tFrealendtime=zdhSrapplicationDto.getFrealendtime().toString();
	    	
	    	sFattribute=zdhSrapplicationDto.getFattribute();
	    	
	    	sFisstop=zdhSrapplicationDto.getFisstop();
	    	
	    }
	    
		    BusinessDetailDto bdt = BusinessDetailHelper.getBusDetailInfo(request);
		    //正式编号
		    //String sFapplicationono=BusinessDetailHelper.genBusinessNumber("DAY_PLAN");
		   
		    //用户登录名

		    String loginName = bdt.getLoginName();  			
		    //用户ID
			String userId = bdt.getUserId();  		
			//用户名称	
			String userName = bdt.getUserName();	
			
			//当前时间
			Timestamp currentTime = bdt.getCurrentTime();	
			String strCurrentTime=currentTime.toString();
			strCurrentTime=strCurrentTime.substring(0,16);
			Date currentDate = bdt.getCurrentDate();
			//用户部门ID
			String userDeptId = bdt.getUserDeptId();	
			
			//用户部门CODE		
			String userDeptCode = bdt.getUserDeptCode();
		    //用户部门名称
			String userDeptName = bdt.getUserDeptName();
			//数据所属单位ID
			//String dataOwnerId = BusinessDetailHelper.getDataOwner();		
			//数据所属单位名称
			String dataOwnerName = bdt.getDataOwnerName();
			//String dataOwnerName = BusinessDetailHelper.getDataOwner();
			//业务状态
			String fexcutestatus = ZdhConstants.ZdhSrappl_BUSINESS_CITY_NEW;			
			//流转状态

	        String fstatus = ZdhConstants.ZdhSrappl_WORKFLOW_CITY_STATUS_NEW;	        
	        //停役性质(默认为检修)
	        String fattribute = ZdhConstants.ZdhSrappl_WORKFLOW_CITY_IsWorkType_CHECK;
	        //String fattribute = ZdhConstants.ZdhSrappl_WORKFLOW_CITY_IsWorkType_REBACK;
	        //数据所属单位(测试使用)
	        //dataOwnerName = ZdhConstants.ZdhSrappl_WORKFLOW_CITY_IsDpt_BDGS;  //变电公司
	        //dataOwnerName = ZdhConstants.ZdhSrappl_WORKFLOW_CITY_IsDpt_QD;//"区调"
	        
	        //dataOwnerName = ZdhConstants.ZdhSrappl_WORKFLOW_CITY_IsDpt_ZDHYXC;//"自动化运行处"
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
				value="<c:out value="${zdhSrapplicationForm.zdhSrapplicationDto.fapplicationno}"/>">
			<input type="hidden" name="zdhSrapplicationDto.version"
				value="<c:out value="${zdhSrapplicationForm.zdhSrapplicationDto.version}"/>">

            <% 
            		
            		boolean  applay_flag = ResourceHelp.isHaveRes(ZdhConstants.ZDHSRAPPLICATION_APPROVE);
            		boolean  applay_edit_flag = ResourceHelp.isHaveRes(ZdhConstants.ZDHSRAPPLICATION_APPROVE_EDIT);
            		//可看的权限

					String applayReadonly=" readonly ";
					if(applay_edit_flag)
						applayReadonly=" ";
					else
						applayReadonly=" readonly ";
            		if(applay_flag){
            %>
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
										value="<c:out value="${zdhSrapplicationForm.zdhSrapplicationDto.fstationname}"/>"
										size="10" <%=applayReadonly %> ondblclick="OpenEquipment()"/>
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhSrapplicationDto.feqpclassname" />
									<%--停复役设备名称--%>
								</td>
								<td height="23" width="30%">
									<input id="zdhSrapplicationDto.feqpclassname"
										name="zdhSrapplicationDto.feqpclassname" type="text"
										value="<c:out value="${zdhSrapplicationForm.zdhSrapplicationDto.feqpclassname}"/>"
										size="10" <%=applayReadonly %> />
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
										cols='78' type="_moz" <%=applayReadonly %> ><c:out value="${zdhSrapplicationForm.zdhSrapplicationDto.fmaintenancerange}"/></textarea>
								</td>
							</tr>

							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message
										key="object.zdhSrapplicationDto.fapplicationstarttime" />
									<%--申请停役开始时间--%>
								</td>
								<td height="23" width="30%">
								<%
									if(applay_edit_flag){
								 %>
									<jhop:dateselect
										name="zdhSrapplicationDto.fapplicationstarttime"
										showSecond="true" 
										endName="zdhSrapplicationDto.fapplicationendime"
										initValue="<%=tFapplicationstarttime%>"
										dateFormat="yyyy-mm-dd hh:mm" group="start"></jhop:dateselect>
									<%
										}
										else
										{									
									 %>
									 <input
										name="zdhSrapplicationDto.fapplicationstarttime_1" type="text"
										value="<c:out value="${zdhSrapplicationForm.zdhSrapplicationDto.fapplicationstarttime}"/>"
										readonly />
										<input
										name="zdhSrapplicationDto.fapplicationstarttime" type="hidden"
										value="<c:out value="${zdhSrapplicationForm.zdhSrapplicationDto.fapplicationstarttime}"/>"
										readonly />
										<%
										}
										 %>
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message
										key="object.zdhSrapplicationDto.fapplicationendime" />
									<%--申请停役结束时间--%>
								</td>
								<td height="23" width="30%">
								<%
									if(applay_edit_flag){
								 %>
									<jhop:dateselect name="zdhSrapplicationDto.fapplicationendime"
										showSecond="true" 
										startName="zdhSrapplicationDto.fapplicationstarttime"
										initValue="<%=tFapplicationendime %>"
										dateFormat="yyyy-mm-dd hh:mm" group="end"></jhop:dateselect>
								<%
								}
								else
								{		
								%>
								<input name="zdhSrapplicationDto.fapplicationendime_1"			type="text"							
										value="<c:out value="${zdhSrapplicationForm.zdhSrapplicationDto.fapplicationendime}"/>"
										readonly />
								<input name="zdhSrapplicationDto.fapplicationendime"			type="hidden"							
										value="<c:out value="${zdhSrapplicationForm.zdhSrapplicationDto.fapplicationendime}"/>"
										readonly />
								<%
								}
								 %>
								</td>
							</tr>

							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhSrapplicationDto.fattribute" />
									<%--停役性质--%>
								</td>
								<td height="23" width="30%">
								<%
									if(applay_edit_flag){
								 %>
									<jhop:select name="zdhSrapplicationDto.fattribute" hiddName=""
										type="fattribute"
										initValue="<%=sFattribute %>">
									</jhop:select>
									<%
									}
									else
									{
									 %>
									 <input name="zdhSrapplicationDto.fattribute" 
										value="<c:out value="${zdhSrapplicationForm.zdhSrapplicationDto.fattribute}"/>" readonly />
										<%
										}
										 %>
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhSrapplicationDto.fisstop" />
									<%--是否停通道--%>
								</td>
								<td height="23" width="30%">
								<%
									if(applay_edit_flag){
								 %>
									<jhop:select name="zdhSrapplicationDto.fisstop" hiddName=""
										type="fisstop"
										initValue="<%=sFisstop %>">
									</jhop:select>
									<%
									}
									else
									{
									 %>
									 	<input name="zdhSrapplicationDto.fisstop" value="<c:out value="${zdhSrapplicationForm.zdhSrapplicationDto.fisstop}"/>" readonly />
									 <%
									 }
									  %>
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message
										key="object.zdhSrapplicationDto.fannexexplanation" />
									<%--附件--%>
								</td>
								<td height="23" width="30%" colspan="3">
								<%
									if(applay_edit_flag){
								 %>
									<jhop:upload name="fannexexplanation" multiValue="no"></jhop:upload>
									<%
									}
									 %>
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
										type="_moz" <%=applayReadonly %>><c:out value="${zdhSrapplicationForm.zdhSrapplicationDto.fremarks}"/></textarea>
								</td>
							</tr>

							<!--  
							<tr>

								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhSrapplicationDto.flocalopinion" />
									<%--属地公司领导意见--%>
								</td>


								<td height="23" width="30%">
									<input id="zdhSrapplicationDto.flocalopinion"
										name="zdhSrapplicationDto.flocalopinion" type="text"
										value="<c:out value="${zdhSrapplicationForm.zdhSrapplicationDto.flocalopinion}"/>"
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
										value="<c:out value="${zdhSrapplicationForm.zdhSrapplicationDto.fcenteropinion2}"/>"
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
										value="<c:out value="${zdhSrapplicationForm.zdhSrapplicationDto.flocalopinion2}"/>"
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
										value="<c:out value="${zdhSrapplicationForm.zdhSrapplicationDto.fcenteropinion1}"/>"
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
										value="<c:out value="${zdhSrapplicationForm.zdhSrapplicationDto.fcenteropinion3}"/>"
										size="10" 
										readonly="true" />
								</td>

							</tr>
							
							    -->
						</table>
				<tr>
					<td height="23" class="tab_0" width="20%">
						&nbsp;
					</td>
				</tr>
				<%
				}else
				{
				 %>
				 <input id="zdhSrapplicationDto.fstationname"
										name="zdhSrapplicationDto.fstationname" type="hidden"
										value="<c:out value="${zdhSrapplicationForm.zdhSrapplicationDto.fstationname}"/>"
										 />
				 <input id="zdhSrapplicationDto.feqpclassname"
										name="zdhSrapplicationDto.feqpclassname" type="hidden"
										value="<c:out value="${zdhSrapplicationForm.zdhSrapplicationDto.feqpclassname}"/>"
										 />
				<input id="zdhSrapplicationDto.fmaintenancerange"
										name="zdhSrapplicationDto.fmaintenancerange" type="hidden"
										value="<c:out value="${zdhSrapplicationForm.zdhSrapplicationDto.fmaintenancerange}"/>"
										/>
			   <input	name="zdhSrapplicationDto.fapplicationstarttime" type="hidden"
			   				value="<c:out value="${zdhSrapplicationForm.zdhSrapplicationDto.fapplicationstarttime}"/>"/>
			   <input name="zdhSrapplicationDto.fapplicationendime"			type="hidden"							
										value="<c:out value="${zdhSrapplicationForm.zdhSrapplicationDto.fapplicationendime}"/>"/>
			    <input name="zdhSrapplicationDto.fattribute"  type="hidden"
										value="<c:out value="${zdhSrapplicationForm.zdhSrapplicationDto.fattribute}" />"/>
				<input name="zdhSrapplicationDto.fisstop" type="hidden" value="<c:out value="${zdhSrapplicationForm.zdhSrapplicationDto.fisstop}" />"/>
<% 				
			}
			boolean  confirm_flag = ResourceHelp.isHaveRes(ZdhConstants.ZDHSRAPPLICATION_CONFIRM);
            boolean  confirm_edit_flag = ResourceHelp.isHaveRes(ZdhConstants.ZDHSRAPPLICATION_CONFIRM_EDIT);
            		//可看的权限

			String confirmReadonly=" readonly";
			if(confirm_edit_flag)
				confirmReadonly=" ";
			else
				confirmReadonly=" readonly";
            		if(confirm_flag){ 
 %>
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
									<%
										if(confirm_edit_flag){
									 %>
										<jhop:dateselect name="zdhSrapplicationDto.fapprovalstarttime"
											endName="zdhSrapplicationDto.fapprovalendtime"
											initValue="<%=tFapprovalstarttime %>"
											showSecond="true" 
											dateFormat="yyyy-mm-dd hh:mm" group="start"></jhop:dateselect>
										<%
											}else{	
										 %>
										 <input name="zdhSrapplicationDto.fapprovalstarttime" type="hidden"
											value="<c:out value="${zdhSrapplicationForm.zdhSrapplicationDto.fapprovalstarttime}"/>"
											 />
											<input name="zdhSrapplicationDto.fapprovalstarttime_1" type="text"
											value="<c:out value="${zdhSrapplicationForm.zdhSrapplicationDto.fapprovalstarttime}"/>"
											readonly />
										<%
											}
										 %>
									</td>
									<td height="23" class="tab_0" width="20%">
										<bean:message
											key="object.zdhSrapplicationDto.fapprovalendtime" />
										<%--结束时间--%>
									</td>
									<td height="23" width="30%">
									<%
										if(confirm_edit_flag){
									 %>
										<jhop:dateselect name="zdhSrapplicationDto.fapprovalendtime"
											startName="zdhSrapplicationDto.fapprovalstarttime"
											showSecond="true" 
											initValue="<%=tFapprovalendtime %>"
											dateFormat="yyyy-mm-dd hh:mm" group="end"></jhop:dateselect>
									<%
										}
										else
										{
									 %>
									 <input name="zdhSrapplicationDto.fapprovalendtime_1" type="text"
											value="<c:out value="${zdhSrapplicationForm.zdhSrapplicationDto.fapprovalendtime}"/>"
											readonly />
									 <input name="zdhSrapplicationDto.fapprovalendtime" type="hidden"
											value="<c:out value="${zdhSrapplicationForm.zdhSrapplicationDto.fapprovalendtime}"/>"
											readonly />
									<%
									}
									 %>
									</td>
								</tr>

							
							</table>
					<tr>
						<td height="23" class="tab_0" width="20%">
							&nbsp;
						</td>
					</tr>
<%
}else{
%>
 <input name="zdhSrapplicationDto.fapprovalstarttime" type="hidden"
											value="<c:out value="${zdhSrapplicationForm.zdhSrapplicationDto.fapprovalstarttime}" />"/>
 <input name="zdhSrapplicationDto.fapprovalendtime" type="hidden"
											value="<c:out value="${zdhSrapplicationForm.zdhSrapplicationDto.fapprovalendtime}" />"/>
<% 
}

			boolean  order_flag = ResourceHelp.isHaveRes(ZdhConstants.ZDHSRAPPLICATION_ORDER);
            boolean  order_edit_flag = ResourceHelp.isHaveRes(ZdhConstants.ZDHSRAPPLICATION_ORDER_EDIT);
            		//可看的权限

			String orderReadonly=" readonly ";
			if(order_edit_flag)
				orderReadonly="";
			else
				orderReadonly=" readonly ";
            		if(order_flag){ 					
%>
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
										<%
										if(order_edit_flag){
										 %>
											<jhop:dateselect name="zdhSrapplicationDto.frealstarttime"
												endName="zdhSrapplicationDto.frealendtime"
												showSecond="true" 
												initValue="<%=tFrealstarttime %>"
												dateFormat="yyyy-mm-dd hh:mm" group="start"></jhop:dateselect>
										<%
										}
										else
										{
										 %>
										 <input name="zdhSrapplicationDto.frealstarttime_1" type="text"
												value="<c:out value="${zdhSrapplicationForm.zdhSrapplicationDto.frealstarttime}"/>"
												readonly />
										<input name="zdhSrapplicationDto.frealstarttime" type="hidden"
												value="<c:out value="${zdhSrapplicationForm.zdhSrapplicationDto.frealstarttime}"/>"
												readonly />
										<%
												}
										 %>
										</td>
										<td height="23" class="tab_0" width="20%">
											<bean:message key="object.zdhSrapplicationDto.frealendtime" />
											<%--实际停役结束时间--%>
										</td>
										<td height="23" width="30%" >
										<%
										if(order_edit_flag){
										 %>
											<jhop:dateselect name="zdhSrapplicationDto.frealendtime"
												startName="zdhSrapplicationDto.frealstarttime"
												showSecond="true" 
												initValue="<%=tFrealendtime %>"
												dateFormat="yyyy-mm-dd hh:mm" group="end"></jhop:dateselect>
										<%
										}
										else
										{
										 %>
										 <input name="zdhSrapplicationDto.frealendtime_1" type="text"
												value="<c:out value="${zdhSrapplicationForm.zdhSrapplicationDto.frealendtime}"/>" readonly />
												
										<input name="zdhSrapplicationDto.frealendtime" type="hidden"
												value="<c:out value="${zdhSrapplicationForm.zdhSrapplicationDto.frealendtime}"/>"
												readonly />
										<%
										}
										 %>
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
												value="<c:out value="${zdhSrapplicationForm.zdhSrapplicationDto.fkeeptime}"/>"
												size="10" <%=orderReadonly %>/>
										</td>
										<td height="23" class="tab_0" width="20%">
											<bean:message key="object.zdhSrapplicationDto.fexcutestatus" />
											<%--执行状态--%>
										</td>
										<td height="23" width="30%">
										
										 <input name="zdhSrapplicationDto.fexcutestatus"
												value="<c:out value="${zdhSrapplicationForm.zdhSrapplicationDto.fexcutestatus}"/>"  />
										
										</td>
									</tr>

								</table>
						<tr>
							<td height="10" class="tab_0" width="20%">
							</td>
						</tr>
						</table>
						<%
						}else{
						 %>
						  <input name="zdhSrapplicationDto.frealstarttime" type="hidden"
												value="<c:out value="${zdhSrapplicationForm.zdhSrapplicationDto.frealstarttime}"/>"/>
						 <input name="zdhSrapplicationDto.frealendtime" type="hidden"
												value="<c:out value="${zdhSrapplicationForm.zdhSrapplicationDto.frealendtime}"/>"/>
			 			 <input name="zdhSrapplicationDto.fexcutestatus" type="hidden"
												value="<c:out value="${zdhSrapplicationForm.zdhSrapplicationDto.fexcutestatus}"/>"/>
						 <%
						 }
						  %>
						
										<input id="zdhSrapplicationDto.fstationid"        name="zdhSrapplicationDto.fstationid"     type="hidden" value="<c:out value="${zdhSrapplicationForm.zdhSrapplicationDto.fstationid}"/>"  />
										<input id="zdhSrapplicationDto.feqpclasstype"     name="zdhSrapplicationDto.feqpclasstype"     type="hidden" value="<c:out value="${zdhSrapplicationForm.zdhSrapplicationDto.feqpclasstype}"/>"  />
										<input id="zdhSrapplicationDto.fapplicationtype"  name="zdhSrapplicationDto.fapplicationtype"     type="hidden" value="<c:out value="${zdhSrapplicationForm.zdhSrapplicationDto.fapplicationtype}"/>"  />
										<input id="zdhSrapplicationDto.fapplicationono"   name="zdhSrapplicationDto.fapplicationono"     type="hidden" value="<c:out value="${zdhSrapplicationForm.zdhSrapplicationDto.fapplicationono}"/>"  />
										<input id="zdhSrapplicationDto.fstatus"           name="zdhSrapplicationDto.fstatus"     type="hidden" value="<c:out value="${zdhSrapplicationForm.zdhSrapplicationDto.fstatus}"/>"  />
										<input id="zdhSrapplicationDto.sys_isvalid"   name="zdhSrapplicationDto.sys_isvalid"     type="hidden" value="<c:out value="${zdhSrapplicationForm.zdhSrapplicationDto.sys_isvalid}"/>"  />
							            <input id="zdhSrapplicationDto.sys_filltime"  name="zdhSrapplicationDto.sys_filltime" 	 type="hidden" value="<c:out value="${zdhSrapplicationForm.zdhSrapplicationDto.sys_filltime}"/>"  />
  				 				        <input id="zdhSrapplicationDto.sys_filldept"  name="zdhSrapplicationDto.sys_filldept" 	 type="hidden" value="<c:out value="${zdhSrapplicationForm.zdhSrapplicationDto.sys_filldept}"/>"  />
							            <input id="zdhSrapplicationDto.sys_dataowner" name="zdhSrapplicationDto.sys_dataowner" 	 type="hidden" value="<c:out value="${zdhSrapplicationForm.zdhSrapplicationDto.sys_dataowner}"/>"  />
  				 				        <input id="zdhSrapplicationDto.sys_fille"     name="zdhSrapplicationDto.sys_fille" 	     type="hidden" value="<c:out value="${zdhSrapplicationForm.zdhSrapplicationDto.sys_fille}"/>"  />
  				 				        <input id="zdhSrapplicationDto.feqpcontent"     name="zdhSrapplicationDto.feqpcontent" 	 type="hidden" value="<c:out value="${zdhSrapplicationForm.zdhSrapplicationDto.feqpcontent}"/>"  />
  				 				        
							<%--属地公司领导意见--%>
							<input id="zdhSrapplicationDto.flocalopinion"
										name="zdhSrapplicationDto.flocalopinion" type="hidden"
										value="<c:out value="${zdhSrapplicationForm.zdhSrapplicationDto.flocalopinion}"/>"
										 />
							<%--中心自动化处意见--%>
							<input id="zdhSrapplicationDto.fcenteropinion2"
										name="zdhSrapplicationDto.fcenteropinion2" type="hidden"
										value="<c:out value="${zdhSrapplicationForm.zdhSrapplicationDto.fcenteropinion2}"/>"
										 />
							<%--属地调度意见--%>
							<input id="zdhSrapplicationDto.flocalopinion2"
										name="zdhSrapplicationDto.flocalopinion2" type="hidden"
										value="<c:out value="${zdhSrapplicationForm.zdhSrapplicationDto.flocalopinion2}"/>"
										 />
							<%--中心主管主任意见--%>
							<input id="zdhSrapplicationDto.fcenteropinion1"
										name="zdhSrapplicationDto.fcenteropinion1" type="hidden"
										value="<c:out value="${zdhSrapplicationForm.zdhSrapplicationDto.fcenteropinion1}"/>"
										 />
							<%--运维中心意见--%>
							<input id="zdhSrapplicationDto.fcenteropinion3"
										name="zdhSrapplicationDto.fcenteropinion3" type="hidden"
										value="<c:out value="${zdhSrapplicationForm.zdhSrapplicationDto.fcenteropinion3}"/>"
										 />				
										
					</table>	
					</table>
					
					
		</form>
	</body>
	<%
	if(applay_flag){
	 %>
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
	    	//流转状态

	       //document.getElementById('zdhSrapplicationDto.fstatus').value = '<%= fstatus %>';    
	     document.getElementById('zdhSrapplicationDto.fstatus').value = "1";

	       //停役性质
	       document.getElementById('zdhSrapplicationDto.fattribute').value = '<%= fattribute %>'
	       <%
	       if(applay_edit_flag){
	       %>
	       //申请停役开始时间

	       document.getElementById('zdhSrapplicationDto.fapplicationstarttime_1').value = '<%= strCurrentTime %>';
	       //申请停役结束时间
	       document.getElementById('zdhSrapplicationDto.fapplicationendime_1').value = '<%= strCurrentTime %>';
	       <%
	       }else if(applay_flag){
	       %>
	       	       //申请停役开始时间

	       document.getElementById('zdhSrapplicationDto.fapplicationstarttime_1').value = '<%= strCurrentTime %>';
	       //申请停役结束时间
	       document.getElementById('zdhSrapplicationDto.fapplicationendime_1').value = '<%= strCurrentTime %>';
	         document.getElementById('zdhSrapplicationDto.fapplicationstarttime').value = '<%= currentTime %>';
	       //申请停役结束时间
	       document.getElementById('zdhSrapplicationDto.fapplicationendime').value = '<%= currentTime %>';
	       <%
	       }
	       if(confirm_edit_flag){
	       %>
	       //批准开始时间

		   document.getElementById('zdhSrapplicationDto.fapprovalstarttime_1').value = '<%= strCurrentTime %>';
		   //批准停役结束时间	
		   document.getElementById('zdhSrapplicationDto.fapprovalendtime_1').value = '<%= strCurrentTime %>';	
		   <%
		   }else if(confirm_flag){
		   %>
		   //批准开始时间

		   document.getElementById('zdhSrapplicationDto.fapprovalstarttime_1').value = '<%= strCurrentTime %>';
		   //批准停役结束时间	
		   document.getElementById('zdhSrapplicationDto.fapprovalendtime_1').value = '<%= strCurrentTime %>';
		       //批准开始时间

		   document.getElementById('zdhSrapplicationDto.fapprovalstarttime').value = '<%= currentTime %>';
		   //批准停役结束时间	
		   document.getElementById('zdhSrapplicationDto.fapprovalendtime').value = '<%= currentTime %>';
		   <%
		   }
		   if(order_edit_flag){
		   %>
	       //实际停役开始时间

	       document.getElementById('zdhSrapplicationDto.frealstarttime_1').value = '<%= strCurrentTime %>';
		   document.getElementById('zdhSrapplicationDto.frealendtime_1').value = '<%= strCurrentTime %>';
		   //业务状态

	       //document.getElementById('zdhSrapplicationDto.fexcutestatus').value = '<%= fexcutestatus %>';	
		   <%
			}else if(order_flag){		   
		   %>						
		   	 document.getElementById('zdhSrapplicationDto.frealstarttime_1').value = '<%= strCurrentTime %>';
		     document.getElementById('zdhSrapplicationDto.frealendtime_1').value = '<%= strCurrentTime %>';	
		     document.getElementById('zdhSrapplicationDto.frealstarttime').value = '<%= currentTime %>';
		     document.getElementById('zdhSrapplicationDto.frealendtime').value = '<%= currentTime %>';
		     document.getElementById('zdhSrapplicationDto.fexcutestatus').value = '<%= fexcutestatus %>';		
		     <%
		     }		     
		     %>	
	    }
	    
	</script>
	<%
	}
	 %>
	 
	<script type="text/javascript">
	   /**
	    * 选择设备信息
	    */
	   function OpenEquipment() {   
         var vArguments = new Object();
         vArguments.title = "设备信息";
	     vArguments.viewId = "default";
	     vArguments.showButton = true;
	     vArguments.readOnly = false;
	     vArguments.returnedFields = "FMEMO,FEQPID,FSTORELOCATION,FDEVCLASSNAME,FLEAVEFACNO,FMADECOUNTRY";
	     vArguments.multiSelect = true;
	     var url = encodeURI("http://122.122.109.142:8081/eqpbay/eqpEquipment.do?method=eqpEquipmentframe");
	     //var url = encodeURI("http://200.200.200.195:8989/eqp/eqpEquipment.do?method=eqpEquipmentframe");
         var sReturn = OpenEquipmentModal(vArguments,url);
         if (sReturn == "" || sReturn == null || sReturn == "null" || typeof(sReturn) == 'undefined'){
            return;
         }
         var xdoc = createDom();
	     xdoc.loadXML(sReturn);	
	     //获得根路径
	     var eqps = xdoc.getElementsByTagName("dataset");
	     for(var i=0;i<eqps.childNodes.length; i++){
	        var  eqp = eqps.childNodes[i]; 
	        var  id = eqp.getElementsByTagName("FEQPID")[0].firstChild;
	        alert(id);
	     }     
	     
       }
	</script>
</html>
