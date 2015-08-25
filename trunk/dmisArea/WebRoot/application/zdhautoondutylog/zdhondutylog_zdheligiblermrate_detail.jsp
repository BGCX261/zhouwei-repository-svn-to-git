<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map"%>
<%@ page import="com.techstar.dmis.helper.BusinessDetailHelper"%>
<%@ page import="com.techstar.dmis.helper.dto.BusinessDetailDto"%>
<%@ page import="java.sql.Timestamp"%>
<%@ page import="org.apache.commons.lang.StringUtils"%>
<%@ page import="java.sql.Date"%>
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
<%
	//String ondutyno = (String) request.getAttribute("ondutyno");
	//String currno = (String) request.getAttribute("currno");
	String readonly = "";
	//if (!currno.equalsIgnoreCase("")
	//		&& !currno.equalsIgnoreCase(ondutyno)) {
		readonly = " readonly ";
	//}
%>
<html>
	<head>
		<html:base />
		<title>遥测合格率详情</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="../../themes/themes1/style.css" rel="stylesheet"
			type="text/css" />
		<%@ include file="/common/init_js.jsp"%>
		<%@ include file="/common/init_date.jsp"%>
		<script language="javascript" type="text/javascript"
			src="<%=request.getContextPath()%>/application/zdheligiblermrate/zdhrmeliglerate_defaultDetail_detail.js"></script>
	</head>
	<body>
		<html:javascript formName="zdhEligiblermrateForm" />
		<logic:messagesPresent message="true">
			<html:messages id="message" message="true" header="messages.header"
				footer="messages.footer">
				<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
			</html:messages>
		</logic:messagesPresent>
		<form name="zdhEligiblermrateForm" action="" method="post">
			<%--hidden--%>

			<input type="hidden" name="zdhEligiblermrateDto.fid"
				value="<c:out value="${zdhEligiblermrateForm.zdhEligiblermrateDto.fid}"/>"/>
			<input type="hidden" name="zdhEligiblermrateDto.version"
				value="<c:out value="${zdhEligiblermrateForm.zdhEligiblermrateDto.version}"/>"/>

			<jhop:ctrlgroup
				ctrlId="UIControlGroupXPanel56e1a0be949a4280be900ec8da8ce098"
				title="遥测数据合格率">
			</jhop:ctrlgroup>

			<table class="detailmain" cellspacing="0" cellpadding="0">
				<tr id="UIControlGroupXPanel56e1a0be949a4280be900ec8da8ce098">
					<td align="center">
						<table class="detail" width="100%" height="100%" cellspacing="0">
							<tr>

								<td height="23" class="tab_0" width="15%">
									<bean:message key="object.zdhEligiblermrateDto.reportsdate" />
									<%--报表日期--%>
								</td>


								<td height="23" width="35%">

									<input id="zdhEligiblermrateDto.reportsdate"
										name="zdhEligiblermrateDto.reportsdate" type="text"
										value="<c:out value="${zdhEligiblermrateForm.zdhEligiblermrateDto.reportsdate}"/>"
										size="10" onblur="getData();" readonly />

								</td>


								<td height="23" class="tab_0" width="15%">
									<bean:message
										key="object.zdhEligiblermrateDto.remotemeasureamount" />
									<%--遥测数据总数--%>
									<span class="article_required">*</span>
								</td>


								<td height="23" width="35%">
									<input id="zdhEligiblermrateDto.remotemeasureamount"
										name="zdhEligiblermrateDto.remotemeasureamount" type="text"
										value="<c:out value="${zdhEligiblermrateForm.zdhEligiblermrateDto.remotemeasureamount}"/>"
										size="10" onblur="getData();" <%=readonly%> />
								</td>

							</tr>
							<tr>

								<td height="23" class="tab_0" width="15%">
									<bean:message
										key="object.zdhEligiblermrateDto.failuredatanoamount" />
									<%--不合格数据个数--%>
									<span class="article_required">*</span>
								</td>


								<td height="23" width="35%">
									<input id="zdhEligiblermrateDto.failuredatanoamount"
										name="zdhEligiblermrateDto.failuredatanoamount" type="text"
										value="<c:out value="${zdhEligiblermrateForm.zdhEligiblermrateDto.failuredatanoamount}"/>"
										size="10" onblur="getData();" <%=readonly%> />
								</td>


								<td height="23" class="tab_0" width="15%">
									<bean:message key="object.zdhEligiblermrateDto.eligiblerate" />
									<%--遥测数据合格率(%)--%>
									<span class="article_required">*</span>
								</td>


								<td height="23" width="35%">
									<input id="zdhEligiblermrateDto.eligiblerate"
										name="zdhEligiblermrateDto.eligiblerate" type="text"
										value="<c:out value="${zdhEligiblermrateForm.zdhEligiblermrateDto.eligiblerate}"/>"
										size="10" <%=readonly%> />
								</td>

							</tr>
							<tr>

								<td height="23" class="tab_0" width="15%">
									<bean:message key="object.zdhEligiblermrateDto.remarks" />
									<%--备注--%>
									<span class="article_required">*</span>
								</td>


								<td height="23" width="35%" colspan="3">
									<textarea id='zdhEligiblermrateDto.remarks'
										name='zdhEligiblermrateDto.remarks' rows='3' cols='71'
										<%=readonly%>><c:out value="${zdhEligiblermrateForm.zdhEligiblermrateDto.remarks}"/></textarea>
								</td>

							</tr>
							<%--填写人--%>
							<input type="hidden" name="zdhEligiblermrateDto.sys_fille"
								value="<c:out value="${zdhEligiblermrateForm.zdhEligiblermrateDto.sys_fille}"/>">
							<%--填写单位--%>
							<input type="hidden" name="zdhEligiblermrateDto.sys_filldept"
								value="<c:out value="${zdhEligiblermrateForm.zdhEligiblermrateDto.sys_filldept}"/>">
							<%--填写时间--%>
							<input type="hidden" name="zdhEligiblermrateDto.sys_filltime"
								value="<c:out value="${zdhEligiblermrateForm.zdhEligiblermrateDto.sys_filltime}"/>">
							<%--是否有效字段--%>
							<input type="hidden" name="zdhEligiblermrateDto.sys_isvalid"
				value="<c:out value="${zdhEligiblermrateForm.zdhEligiblermrateDto.sys_isvalid}"/>">
							<%--数据所属单位--%>
							<input type="hidden" name="zdhEligiblermrateDto.sys_dataowner"
								value="<c:out value="${zdhEligiblermrateForm.zdhEligiblermrateDto.sys_dataowner}"/>">
							<%--交接班记录编号--%>
							<input type="hidden" name="zdhEligiblermrateDto.zzdheligiblermrate1.ondutyno"
								value="<c:out value="${zdhEligiblermrateForm.zdhEligiblermrateDto.zzdheligiblermrate1.ondutyno}"/>">
						
						</table>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
<script>
	var id = document.getElementById('zdhEligiblermrateDto.fid').value;
	//进行初始化动作

    if (id == null || id == '' || id == 'undefined'){
		//初始化填单人
       document.getElementById('zdhEligiblermrateDto.sys_fille').value = '<%= userName %>';
       //初始化填写单位       
       document.getElementById('zdhEligiblermrateDto.sys_filldept').value = '<%= userDeptName %>';
       //初始化填写时间

       document.getElementById('zdhEligiblermrateDto.sys_filltime').value = '<%= currentTime %>';
       //数据所属单位

       document.getElementById('zdhEligiblermrateDto.sys_dataowner').value = '<%= dataOwnerName %>';
       //申请时间							
       //document.getElementById('zdhEligiblermrateDto.applicantedtime').value = '<%= currentTime%>';	
	}
</script>
