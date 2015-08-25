<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map"%>
<%@ page import="com.techstar.dmis.helper.BusinessDetailHelper"%>
<%@ page import="com.techstar.dmis.helper.dto.BusinessDetailDto"%>
<%@ page import="java.sql.Timestamp"%>
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
<%
	String ondutyno = (String) request.getAttribute("ondutyno");
	String currno = (String) request.getAttribute("currno");
	String readonly = "";
	if (!currno.equalsIgnoreCase("")
			&& !currno.equalsIgnoreCase(ondutyno)) {
		readonly = " readonly ";
	}
	//out.println("############"+ondutyno+"################"+currno);
	//out.println("#############"+readonly);
%>
<html>
	<head>
		<html:base />
		<title>遥测数据修改记录详情</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="../../themes/themes1/style.css" rel="stylesheet"
			type="text/css" />
		<%@ include file="/common/init_js.jsp"%>
		<%@ include file="/common/init_date.jsp"%>
		<script language="javascript" type="text/javascript"
			src="<%=request.getContextPath()%>/application/zdhrmrec/ZdhRmrec_defaultDetail_detail.js"></script>
	</head>
	<body>
		<html:javascript formName="zdhRmrecForm" />
		<logic:messagesPresent message="true">
			<html:messages id="message" message="true" header="messages.header"
				footer="messages.footer">
				<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
			</html:messages>
		</logic:messagesPresent>
		<form name="zdhRmrecForm" action="" method="post">
			<%--hidden--%>

			<input type="hidden" name="zdhRmrecDto.recordno"
				value="<c:out value="${zdhRmrecForm.zdhRmrecDto.recordno}"/>">
			<input type="hidden" name="zdhRmrecDto.version"
				value="<c:out value="${zdhRmrecForm.zdhRmrecDto.version}"/>">
			<input type="hidden" name="zdhRmrecDto.zzdhrmrec2.recordsno"
				value="<c:out value="${zdhRmrecForm.zdhRmrecDto.zzdhrmrec2.recordsno}"/>">

			<jhop:ctrlgroup
				ctrlId="UIControlGroupXPanele8817206c6254d00bd7afa004c4290a7"
				title="遥测数据修改记录">
			</jhop:ctrlgroup>

			<table class="detailmain" cellspacing="0" cellpadding="0">
				<tr id="UIControlGroupXPanele8817206c6254d00bd7afa004c4290a7">
					<td align="center">
						<table class="detail" width="100%" height="100%" cellspacing="0">
							<tr>

								<td height="23" class="tab_0" width="15%">
									<bean:message key="object.zdhRmrecDto.fstationname" />
									<%--变电站名称--%>
								</td>


								<td height="23" width="35%">
									<input type="text" name="zdhRmrecDto.fstationname"
										value="<c:out value="${zdhRmrecForm.zdhRmrecDto.fstationname}"/>"
										<%=readonly%> />
									<!--input type="hidden" name="zdhRmrecDto.zzdhrmrec4.fstationid"/-->
									<%
									if (readonly.equalsIgnoreCase("")) {
									%>
									<img id="img1"
										src="<%=request.getContextPath()%>/themes/themes1/images/main/find.gif"
										onClick="setStdStationSelect('zdhRmrecDto.fstationname','zdhRmrecDto.zzdhrmrec4.stationno','0');">
									<%
									}
									%>
								</td>


								<td height="23" class="tab_0" width="15%">
									<bean:message key="object.zdhRmrecDto.switchno" />
									<%--开关号--%>
								</td>


								<td height="23" width="35%">
									<input id="zdhRmrecDto.switchno" name="zdhRmrecDto.switchno"
										type="text"
										value="<c:out value="${zdhRmrecForm.zdhRmrecDto.switchno}"/>"
										size="10" <%=readonly%> />
								</td>

							</tr>
							<tr>

								<td height="23" class="tab_0" width="15%">
									<bean:message key="object.zdhRmrecDto.changeexplanationo" />
									<%--数据变化说明--%>
								</td>


								<td height="23" width="35%" colspan="3">
									<textarea id='zdhRmrecDto.changeexplanationo'name='zdhRmrecDto.changeexplanationo' rows='3' cols='71'<%=readonly%>><c:out value="${zdhRmrecForm.zdhRmrecDto.changeexplanationo}" />
									</textarea>
								</td>

							</tr>
							<tr>

								<td height="23" class="tab_0" width="15%">
									<bean:message key="object.zdhRmrecDto.modificationdatano" />
									<%--修改遥测数据量--%>
								</td>


								<td height="23" width="35%">
									<input id="zdhRmrecDto.modificationdatano"
										name="zdhRmrecDto.modificationdatano" type="text"
										value="<c:out value="${zdhRmrecForm.zdhRmrecDto.modificationdatano}"/>"
										size="10" <%=readonly%> />
								</td>


								<td height="23" class="tab_0" width="15%">
									<bean:message key="object.zdhRmrecDto.modificationreason" />
									<%--修改原因--%>
								</td>


								<td height="23" width="35%">
									<input id="zdhRmrecDto.modificationreason"
										name="zdhRmrecDto.modificationreason" type="text"
										value="<c:out value="${zdhRmrecForm.zdhRmrecDto.modificationreason}"/>"
										size="10" <%=readonly%> />
								</td>

							</tr>
							<tr>

								<td height="23" class="tab_0" width="15%">
									<bean:message key="object.zdhRmrecDto.modificationdate" />
									<%--数据修改日期--%>
								</td>


								<td height="23" width="35%" colspan="3">
									<%
									if (readonly.equalsIgnoreCase("")) {
									%>
									<jhop:date name="zdhRmrecDto.modificationdate" genText="yes"
										dateFormat="yyyy-mm-dd"
										initValue="${zdhRmrecForm.zdhRmrecDto.modificationdate}"></jhop:date>
									<%
									} else {
									%>
									<input id="zdhRmrecDto.modificationdate"
										name="zdhRmrecDto.modificationdate" type="text"
										value="<c:out value="${zdhRmrecForm.zdhRmrecDto.modificationdate}"/>"
										size="10" readonly />
									<%
									}
									%>
								</td>

							</tr>
							<tr>

								<td height="23" class="tab_0" width="15%">
									<bean:message key="object.zdhRmrecDto.remarks" />
									<%--备注--%>
								</td>


								<td height="23" width="35%" colspan="3">
									<textarea id='zdhRmrecDto.remarks' name='zdhRmrecDto.remarks'rows='3' cols='71' <%=readonly%>><c:out value="${zdhRmrecForm.zdhRmrecDto.remarks}" />
									</textarea>
								</td>

							</tr>
							<!--tr>
								<td height="23" class="tab_0" width="15%">
									<bean:message key="object.zdhRmrecDto.zzdhrmrec1.ondutyno" />
									<%--交接班记录编号--%>
								</td>
								<td height="23" width="35%">
									<input id="zdhRmrecDto.zzdhrmrec1.ondutyno"
										name="zdhRmrecDto.zzdhrmrec1.ondutyno" type="text"
										value="<c:out value="${zdhRmrecForm.zdhRmrecDto.zzdhrmrec1.ondutyno}"/>"
										size="10" readonly />
								</td>
								<td height="23" class="tab_0" width="15%">
									<bean:message key="object.zdhRmrecDto.sys_isvalid" />
									<%--是否有效字段--%>
								</td>
								<td height="23" width="35%">
									<input id="zdhRmrecDto.sys_isvalid"
										name="zdhRmrecDto.sys_isvalid" type="text"
										value="<c:out value="${zdhRmrecForm.zdhRmrecDto.sys_isvalid}"/>"
										size="10" <%=readonly%> />
								</td>
							</tr-->
							<%--交接班记录编号--%>
							<input type="hidden" id="zdhRmrecDto.zzdhrmrec1.ondutyno"
								name="zdhRmrecDto.zzdhrmrec1.ondutyno"
								value="<c:out value="${zdhRmrecForm.zdhRmrecDto.zzdhrmrec1.ondutyno}"/>">
							<%--填写人--%>
							<input type="hidden" id="zdhRmrecDto.sys_fille"
								name="zdhRmrecDto.sys_fille"
								value="<c:out value="${zdhRmrecForm.zdhRmrecDto.sys_fille}"/>">
							<%--填写单位--%>
							<input type="hidden" id="zdhRmrecDto.sys_filldept"
								name="zdhRmrecDto.sys_filldept"
								value="<c:out value="${zdhRmrecForm.zdhRmrecDto.sys_filldept}"/>">
							<%--填写时间--%>
							<input type="hidden" id="zdhRmrecDto.sys_filltime"
								name="zdhRmrecDto.sys_filltime"
								value="<c:out value="${zdhRmrecForm.zdhRmrecDto.sys_filltime}"/>">
							<%--是否有效字段--%>
							<input type="hidden" id="zdhRmrecDto.sys_isvalid" name="zdhRmrecDto.sys_isvalid"
				value="${zdhRmrecForm.zdhRmrecDto.sys_isvalid}">
							<%--数据所属单位--%>
							<input type="hidden" id="zdhRmrecDto.sys_dataowner"
								name="zdhRmrecDto.sys_dataowner"
								value="<c:out value="${zdhRmrecForm.zdhRmrecDto.sys_dataowner}"/>">
							<!--tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhRmrecDto.sys_filldept"/><%--填写单位--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="zdhRmrecDto.sys_filldept" name="zdhRmrecDto.sys_filldept" type="text" value="${zdhRmrecForm.zdhRmrecDto.sys_filldept}" size="10"  readonly/>
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhRmrecDto.sys_filltime"/><%--填写时间--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="zdhRmrecDto.sys_filltime" name="zdhRmrecDto.sys_filltime" type="text" value="${zdhRmrecForm.zdhRmrecDto.sys_filltime}" size="20"  readonly/>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  		<td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhRmrecDto.sys_fille"/><%--填写人--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="zdhRmrecDto.sys_fille" name="zdhRmrecDto.sys_fille" type="text" value="${zdhRmrecForm.zdhRmrecDto.sys_fille}" size="10"  readonly />
			   </td>	   
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhRmrecDto.sys_dataowner"/><%--数据所属单位--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="zdhRmrecDto.sys_dataowner" name="zdhRmrecDto.sys_dataowner" type="text" value="${zdhRmrecForm.zdhRmrecDto.sys_dataowner}" size="10"  readonly/>
			   </td>
			  			  
	    		    </tr-->

						</table>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>

<script>
	var id = document.getElementById('zdhRmrecDto.recordno').value;
	//进行初始化动作
    if (id == null || id == '' || id == 'undefined'){
		//初始化填单人
       document.getElementById('zdhRmrecDto.sys_fille').value = '<%= userName %>';
       //初始化填写单位       
       document.getElementById('zdhRmrecDto.sys_filldept').value = '<%= userDeptName %>';
       //初始化填写时间
       document.getElementById('zdhRmrecDto.sys_filltime').value = '<%= currentTime %>';
       //数据所属单位
       document.getElementById('zdhRmrecDto.sys_dataowner').value = '<%= dataOwnerName %>';
       //申请时间							
       //document.getElementById('zdhRmrecDto.applicantedtime').value = '<%= currentTime%>';	
	}
</script>
