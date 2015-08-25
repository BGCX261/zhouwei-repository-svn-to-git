<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map"%>
<%@ page import="com.techstar.dmis.helper.BusinessDetailHelper"%>
<%@ page import="com.techstar.dmis.helper.dto.BusinessDetailDto"%>
<%@ page import="java.sql.Timestamp"%>
<%@ page import="java.sql.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>

<%@ include file="/common/init_tag.jsp"%>
<html>
	<head>
		<html:base />
		<title>基改建工程自动化设备验收投运详情</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
		<%@ include file="/common/init_js.jsp"%>
		<%@ include file="/common/init_date.jsp"%>
		<script language="javascript" type="text/javascript"
			src="<%=request.getContextPath()%>/application/zdhreception/zdhprojectreception_defaultDetail_detail.js"></script>
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
			//工程验收资料录入
			String project_data = (String) request.getAttribute("project_data");
			//System.out.println("project_data=" + project_data);
			//批准信息
			//实际投运信息
		%>
		<html:javascript formName="zdhReceptionForm" />
		<logic:messagesPresent message="true">
			<html:messages id="message" message="true" header="messages.header"
				footer="messages.footer">
				<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
			</html:messages>
		</logic:messagesPresent>
		<form name="zdhReceptionForm" action="" method="post"
			enctype="multipart/form-data">
			<%--hidden--%>
			<input type="hidden" name="project_data" value="<%=project_data%>">
			<input type="hidden" name="zdhReceptionDto.fapplicationid"
				value="<c:out value="${zdhReceptionForm.zdhReceptionDto.fapplicationid}"/>">
			<input type="hidden" name="zdhReceptionDto.version"
				value="<c:out value="${zdhReceptionForm.zdhReceptionDto.version}"/>">

			<jhop:ctrlgroup
				ctrlId="UIControlGroupXPanel98d83d4de81d4e3e8f09f7381d3a9e6e"
				title="基改建工程自动化设备验收申请">
			</jhop:ctrlgroup>

			<table class="detailmain" cellspacing="0" cellpadding="0">
				<tr id="UIControlGroupXPanel98d83d4de81d4e3e8f09f7381d3a9e6e">
					<td align="center">
						<table class="detail" width="100%" height="100%" cellspacing="0">
							<tr>

								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhReceptionDto.fstationname" />
									<%--变电站名称--%>
								</td>


								<td height="23" width="30%">
									<input id="zdhReceptionDto.fstationname"
										name="zdhReceptionDto.fstationname" type="text"
										value="<c:out value="${zdhReceptionForm.zdhReceptionDto.fstationname}"/>"
										size="10" />
								</td>


								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhReceptionDto.fsystemtype" />
									<%--系统类型--%>
								</td>


								<td height="23" width="30%">
								<%
								String strFsystemtype=""; 
								 %>
								
									<jhop:select name="zdhReceptionDto.fsystemtype" hiddName=""
										type="StdZdhautosystype"
										initValue="${zdhReceptionForm.zdhReceptionDto.fsystemtype}">
									</jhop:select>
								</td>

							</tr>
							<tr>

								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhReceptionDto.fsystemname" />
									<%--系统名称--%>
								</td>


								<td height="23" width="30%">
									<input id="zdhReceptionDto.fsystemname"
										name="zdhReceptionDto.fsystemname" type="text"
										value="<c:out value="${zdhReceptionForm.zdhReceptionDto.fsystemname}"/>"
										size="10" />
								</td>


								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhReceptionDto.freceptiondate" />
									<%--验收日期--%>
								</td>


								<td height="23" width="30%">
								
									<jhop:date name="zdhReceptionDto.freceptiondate" genText="yes"
										dateFormat="yyyy-mm-dd"
										initValue="${zdhReceptionForm.zdhReceptionDto.freceptiondate}"></jhop:date>
								</td>

							</tr>
							<tr>

								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhReceptionDto.fremark" />
									<%--备注--%>
								</td>


								<td height="23" width="30%" colspan="3">
									<textarea id='zdhReceptionDto.fremark'
										name='zdhReceptionDto.fremark' rows='3' cols='78'><c:out value="${zdhReceptionForm.zdhReceptionDto.fremark}"/></textarea>
								</td>

							</tr>
							<!-- 隐藏字段 -->
							<input name="zdhReceptionDto.freceptionno" type="hidden"
								value="<c:out value="${zdhReceptionForm.zdhReceptionDto.freceptionno}"/>" />
							<input name="zdhReceptionDto.fapplyrundate" type="hidden"
								value="<c:out value="${zdhReceptionForm.zdhReceptionDto.fapplyrundate}"/>" />
							<input name='zdhReceptionDto.feqpremark' type="hidden"
								value="<c:out value="${zdhReceptionForm.zdhReceptionDto.feqpremark}"/>" />
							<input name='runeqpcontent' type="hidden"
								value="<c:out value="${zdhReceptionForm.runeqpcontent}"/>" />
							<input name="zdhReceptionDto.fapproverundate" type="hidden"
								value="<c:out value="${zdhReceptionForm.zdhReceptionDto.fapproverundate}"/>" />
							<input name='zdhReceptionDto.localapprover1' type="hidden"
								value="<c:out value="${zdhReceptionForm.zdhReceptionDto.localapprover1}"/>" />

							<input name='zdhReceptionDto.centeropinion2' type="hidden"
								value="<c:out value="${zdhReceptionForm.zdhReceptionDto.centeropinion2}"/>" />

							<input name='zdhReceptionDto.centeropinion1' type="hidden"
								value="<c:out value="${zdhReceptionForm.zdhReceptionDto.centeropinion1}"/>" />
							<input name="zdhReceptionDto.frundate" type="hidden"
								value="<c:out value="${zdhReceptionForm.zdhReceptionDto.frundate}"/>" />

							
							<input name="zdhReceptionDto.fexcutestatus" type="hidden"
								value="<c:out value="${zdhReceptionForm.zdhReceptionDto.fexcutestatus}"/>" />
							<input name="zdhReceptionDto.fstatus" type="hidden"
								value="<c:out value="${zdhReceptionForm.zdhReceptionDto.fstatus}"/>" />
							<%--填写人--%>
							<input name="zdhReceptionDto.sys_fille" type="hidden"
								value="<c:out value="${zdhReceptionForm.zdhReceptionDto.sys_fille}"/>" />
							<%--填写单位--%>
							<input name="zdhReceptionDto.sys_filldept" type="hidden"
								value="<c:out value="${zdhReceptionForm.zdhReceptionDto.sys_filldept}"/>" />
							<%--填写时间--%>
							<input name="zdhReceptionDto.sys_filltime" type="hidden"
								value="<c:out value="${zdhReceptionForm.zdhReceptionDto.sys_filltime}"/>" />
							<%--是否有效字段--%>
							<input name="zdhReceptionDto.sys_isvalid" type="hidden"
								value="<c:out value="${zdhReceptionForm.zdhReceptionDto.sys_isvalid}"/>" />
							<%--数据所属单位--%>
							<input name="zdhReceptionDto.sys_dataowner" type="hidden"
								value="<c:out value="${zdhReceptionForm.zdhReceptionDto.sys_dataowner}"/>" />
							<%--变电站ID--%>
							<input name="zdhReceptionDto.fstationid" type="hidden"
								value="<c:out value="${zdhReceptionForm.zdhReceptionDto.fstationid}"/>" />
							<!--  
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhReceptionDto.sys_fille"/><%--填写人--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="zdhReceptionDto.sys_fille" name="zdhReceptionDto.sys_fille" type="text" value="<c:out value="${zdhReceptionForm.zdhReceptionDto.sys_fille}"/>" size="10" readonly="true" />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhReceptionDto.sys_filldept"/><%--填写单位--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="zdhReceptionDto.sys_filldept" name="zdhReceptionDto.sys_filldept" type="text" value="<c:out value="${zdhReceptionForm.zdhReceptionDto.sys_filldept}"/>" size="10" readonly="true" />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhReceptionDto.sys_filltime"/><%--填写时间--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
			  	<input id="zdhReceptionDto.sys_filltime" name="zdhReceptionDto.sys_filltime" type="text" value="<c:out value="${zdhReceptionForm.zdhReceptionDto.sys_filltime}"/>" size="10" readonly="true" />

			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhReceptionDto.sys_isvalid"/><%--是否有效字段--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="zdhReceptionDto.sys_isvalid" name="zdhReceptionDto.sys_isvalid" type="text" value="<c:out value="${zdhReceptionForm.zdhReceptionDto.sys_isvalid}"/>" size="10"  readonly="true"/>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhReceptionDto.sys_dataowner"/><%--数据所属单位--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="zdhReceptionDto.sys_dataowner" name="zdhReceptionDto.sys_dataowner" type="text" value="<c:out value="${zdhReceptionForm.zdhReceptionDto.sys_dataowner}"/>" size="10" readonly="true" />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhReceptionDto.fstationid"/><%--变电站ID--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="zdhReceptionDto.fstationid" name="zdhReceptionDto.fstationid" type="text" value="<c:out value="${zdhReceptionForm.zdhReceptionDto.fstationid}"/>" size="10"  />
			   </td>
			  			  
	    		    </tr>

		-->





						</table>
					</td>
				</tr>
			</table>
			<%
			if (project_data.equals("1")) {
			%>
			<jhop:ctrlgroup
				ctrlId="UIControlGroupXPaneld939039bd40d4963a3dfa23472269835"
				title="工程验收资料">
			</jhop:ctrlgroup>

			<table class="detailmain" cellspacing="0" cellpadding="0">
				<tr id="UIControlGroupXPaneld939039bd40d4963a3dfa23472269835">
					<td align="center">
						<table class="detail" width="100%" height="100%" cellspacing="0">
							<tr>

								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhReceptionDto.freceptiongraph" />
									<%--竣工图--%>
								</td>


								<td height="23" width="30%">
									<jhop:upload name="freceptiongraph" multiValue="no"></jhop:upload>
								</td>


								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhReceptionDto.freceptionreport" />
									<%--验收报告--%>
								</td>


								<td height="23" width="30%">
									<jhop:upload name="freceptionreport" multiValue="no"></jhop:upload>
								</td>

							</tr>
							<tr>

								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhReceptionDto.fsequence" />
									<%--序位表--%>
								</td>


								<td height="23" width="30%">
									<jhop:upload name="fsequence" multiValue="no"></jhop:upload>
								</td>


								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhReceptionDto.ftranrec" />
									<%--传动记录--%>
								</td>


								<td height="23" width="30%">
									<jhop:upload name="ftranrec" multiValue="no"></jhop:upload>
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
		<script>
	
    var id = document.getElementById('zdhReceptionDto.fapplicationid').value;
    
    //进行初始化动作



    if (id == '' || id == null){
       //初始化填单人
       document.getElementById('zdhReceptionDto.sys_fille').value = '<%=userName%>';
       //初始化填写单位       
       document.getElementById('zdhReceptionDto.sys_filldept').value = '<%=userDeptName%>';
       //初始化填写时间



       document.getElementById('zdhReceptionDto.sys_filltime').value = '<%=currentTime%>';
       //数据所属单位



       document.getElementById('zdhReceptionDto.sys_dataowner').value = '<%=dataOwnerName%>';

      document.getElementById('zdhReceptionDto.freceptiondate').value = '<%=currentDate%>';

    }
    
</script>
	</body>
</html>
