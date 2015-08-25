<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map"%>
<%@ page import="com.techstar.dmis.helper.BusinessDetailHelper"%>
<%@ page import="com.techstar.dmis.helper.dto.BusinessDetailDto"%>
<%@ page import="com.techstar.dmis.common.ZdhConstants"%>
<%@ page import="java.sql.Timestamp"%>
<jsp:directive.page import="java.text.SimpleDateFormat" />
<%@ include file="/common/init_tag.jsp"%>
<html>
	<head>
		<html:base />
		<title>传动记录详情</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="../../themes/themes1/style.css" rel="stylesheet"
			type="text/css" />
		<%@ include file="/common/init_js.jsp"%>
		<%@ include file="/common/init_date.jsp"%>
		<script language="javascript" type="text/javascript"
			src="<%=request.getContextPath()%>/application/zdhtransrecord/zdhtransrec_defaultDetail_detail.js"></script>
	</head>
	<body>
		<%
			BusinessDetailDto bdt = BusinessDetailHelper.getBusDetailInfo(request);
			//用户登陆名

			String loginName = bdt.getLoginName();
			String userId = bdt.getUserId();
			String userName = bdt.getUserName();
			Timestamp currentTime = bdt.getCurrentTime();
			String userDeptId = bdt.getUserDeptId();
			String userDeptCode = bdt.getUserDeptCode();
			String userDeptName = bdt.getUserDeptName();
			String dataOwnerId = bdt.getDataOwnerId();
			String dataOwnerName = bdt.getDataOwnerName();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
			String strtest = sdf.format(currentTime);
		%>
		<%
			//班号
			String ondutyno = (String) request.getAttribute("ondutyno");
			String currno = (String) request.getAttribute("currno");
			String fexStatus=(String)request.getAttribute("fexStatus");
			//盖章后的记录不能修改，只能修改当前日志下的纪录


			String readonly = "";
			if (currno != null && !currno.equalsIgnoreCase("")
					&& !currno.equalsIgnoreCase(ondutyno)) {
				readonly = " readonly ";
			}
			if(fexStatus!=null&&fexStatus.equals(ZdhConstants.ZdhTransrecord_DATA_APP))
			{
				readonly = " readonly ";
			}

		%>
		<html:javascript formName="zdhTransrecordForm" />
		<logic:messagesPresent message="true">
			<html:messages id="message" message="true" header="messages.header"
				footer="messages.footer">
				<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
			</html:messages>
		</logic:messagesPresent>
		<form name="zdhTransrecordForm" action="" method="post"
			enctype="multipart/form-data">
			<%--hidden--%>

			<input type="hidden" name="zdhTransrecordDto.transrecordid"
				value="<c:out value="${zdhTransrecordForm.zdhTransrecordDto.transrecordid}"/>">
			<input type="hidden" name="zdhTransrecordDto.version"
				value="<c:out value="${zdhTransrecordForm.zdhTransrecordDto.version}"/>">

			<jhop:ctrlgroup
				ctrlId="UIControlGroupXPanel8b3f1ce63abd427083da3a8fcf86fec6"
				title="传动记录信息">
			</jhop:ctrlgroup>

			<table class="detailmain" cellspacing="0" cellpadding="0">
				<tr id="UIControlGroupXPanel8b3f1ce63abd427083da3a8fcf86fec6">
					<td align="center">
						<table class="detail" width="100%" height="100%" cellspacing="0">
							<tr>

								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhTransrecordDto.fstationname" />
									<%--厂站--%>
									<span class="article_required">*</span>
								</td>


								<td height="23" width="30%">
									<input type="text" name="zdhTransrecordDto.fstationname"
										value="<c:out value="${zdhTransrecordForm.zdhTransrecordDto.fstationname}"/>"
										<%=readonly%> />
									<input type="hidden"
										name="zdhTransrecordDto.zzdhtransrecord1.id" />
									<%
									if (readonly.equalsIgnoreCase("")) {
									%>
									<img id="img1"
										src="<%=request.getContextPath()%>/themes/themes1/images/main/find.gif"
										onClick="setStdStationSelect('zdhTransrecordDto.fstationname','zdhTransrecordDto.zzdhtransrecord1.id','0');">
									<%
									}
									%>
								</td>


								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhTransrecordDto.tasksource" />
									<%--任务来源--%>
								</td>
								
								<td height="23" width="30%">
									<%
									if (readonly.equalsIgnoreCase("")) {
									
									%>
									<jhop:select name="zdhTransrecordDto.tasksource" hiddName=""
										type="tasksource"
										initValue="${zdhTransrecordForm.zdhTransrecordDto.tasksource}">
									</jhop:select>
									<%
									} else {
									%>
									<input type="text" name="zdhTransrecordDto.tasksource"
										value="<c:out value="${zdhTransrecordForm.zdhTransrecordDto.tasksource}"/>"
										readonly />
									<%
									}
									%>
								</td>

							</tr>
							<tr>

								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhTransrecordDto.transpeople" />
									<%--传动人--%>
								</td>


								<td height="23" width="30%">
									<input id="zdhTransrecordDto.transpeople"
										name="zdhTransrecordDto.transpeople" type="text"
										value="<c:out value="${zdhTransrecordForm.zdhTransrecordDto.transpeople}"/>"
										size="10" <%=readonly%> />
								</td>


								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhTransrecordDto.transdate" />
									<%--传动日期--%>
								</td>
								
								<td height="23" width="30%">
									<%
									if (readonly.equalsIgnoreCase("")) {
									%>
									<jhop:date name="zdhTransrecordDto.transdate" genText="yes"
										dateFormat="yyyy-mm-dd"
										initValue="${zdhTransrecordForm.zdhTransrecordDto.transdate}"></jhop:date>
									<%
									} else {
									%>
									<input type="text" name="zdhTransrecordDto.transdate"
										value="<c:out value="${zdhTransrecordForm.zdhTransrecordDto.transdate}"/>"
										readonly />
									<%
									}
									%>
								</td>

							</tr>
							<tr>

								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhTransrecordDto.transunit" />
									<%--传动单位--%>
								</td>


								<td height="23" width="30%">
									<input id="zdhTransrecordDto.transunit"
										name="zdhTransrecordDto.transunit" type="text"
										value="<c:out value="${zdhTransrecordForm.zdhTransrecordDto.transunit}"/>"
										size="10" <%=readonly%> />
								</td>


								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhTransrecordDto.transrecordno" />
									<%--传动记录正式编号--%>
								</td>


								<td height="23" width="30%">
									<input id="zdhTransrecordDto.transrecordno"
										name="zdhTransrecordDto.transrecordno" type="text"
										value="<c:out value="${zdhTransrecordForm.zdhTransrecordDto.transrecordno}"/>"
										size="10" readonly="true" />
								</td>

							</tr>
							<tr>

								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhTransrecordDto.explanation" />
									<%--传动内容说明--%>
								</td>


								<td height="23" width="30%" colspan="3">
									<textarea id='zdhTransrecordDto.explanation'
										name='zdhTransrecordDto.explanation' rows='3' cols='50'
										<%=readonly%>><c:out value="${zdhTransrecordForm.zdhTransrecordDto.explanation}"/></textarea>
								</td>

							</tr>
							<tr>

								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhTransrecordDto.annexsequence" />
									<%--序位表附件--%>
								</td>


								<td height="23" width="30%" colspan="3">
									<%
									if (readonly.equalsIgnoreCase("")) {
									%>
									<jhop:upload name="annexsequence" multiValue="no"></jhop:upload>
									<%
									}
									%>
								</td>

							</tr>
							<%--填写人--%>
							<input name="zdhTransrecordDto.sys_fille" type="hidden"
								value="<c:out value="${zdhTransrecordForm.zdhTransrecordDto.sys_fille}"/>" />
							<%--填写单位--%>
							<input name="zdhTransrecordDto.sys_filldept" type="hidden"
								value="<c:out value="${zdhTransrecordForm.zdhTransrecordDto.sys_filldept}"/>" />
							<%--填写时间--%>
							<input name="zdhTransrecordDto.sys_filltime" type="hidden"
								value="<c:out value="${zdhTransrecordForm.zdhTransrecordDto.sys_filltime}"/>" />
							<%--是否有效字段--%>
							<input name="zdhTransrecordDto.sys_isvalid" type="hidden"
								value="<c:out value="${zdhTransrecordForm.zdhTransrecordDto.sys_isvalid}"/>" />
							<%--数据所属单位--%>
							<input name="zdhTransrecordDto.sys_dataowner" type="hidden"
								value="<c:out value="${zdhTransrecordForm.zdhTransrecordDto.sys_dataowner}"/>" />
							<%--任务来源编号--%>
							<input name="zdhTransrecordDto.sourcetaskno" type="hidden"
								value="<c:out value="${zdhTransrecordForm.zdhTransrecordDto.sourcetaskno}"/>" />
							<%--交接班记录编号--%>
							<input name="zdhTransrecordDto.zzdhtransrecord3.ondutyno"
								type="hidden"
								value="<c:out value="${zdhTransrecordForm.zdhTransrecordDto.zzdhtransrecord3.ondutyno}"/>" />
							<!--  
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhTransrecordDto.sys_fille"/><%--填写人--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="zdhTransrecordDto.sys_fille" name="zdhTransrecordDto.sys_fille" type="text" value="<c:out value="${zdhTransrecordForm.zdhTransrecordDto.sys_fille}"/>" size="10"  readonly="true"/>
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhTransrecordDto.sys_filldept"/><%--填写单位--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="zdhTransrecordDto.sys_filldept" name="zdhTransrecordDto.sys_filldept" type="text" value="<c:out value="${zdhTransrecordForm.zdhTransrecordDto.sys_filldept}"/>" size="10" readonly="true" />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhTransrecordDto.sys_filltime"/><%--填写时间--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
			  	<input id="zdhTransrecordDto.sys_filltime" name="zdhTransrecordDto.sys_filltime" type="text" value="<c:out value="${zdhTransrecordForm.zdhTransrecordDto.sys_filltime}"/>" size="10" readonly="true" />

			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhTransrecordDto.sys_isvalid"/><%--是否有效字段--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="zdhTransrecordDto.sys_isvalid" name="zdhTransrecordDto.sys_isvalid" type="text" value="<c:out value="${zdhTransrecordForm.zdhTransrecordDto.sys_isvalid}"/>" size="10" readonly="true" />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhTransrecordDto.sys_dataowner"/><%--数据所属单位--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="zdhTransrecordDto.sys_dataowner" name="zdhTransrecordDto.sys_dataowner" type="text" value="<c:out value="${zdhTransrecordForm.zdhTransrecordDto.sys_dataowner}"/>" size="10" readonly="true" />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhTransrecordDto.sourcetaskno"/><%--任务来源编号--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="zdhTransrecordDto.sourcetaskno" name="zdhTransrecordDto.sourcetaskno" type="text" value="<c:out value="${zdhTransrecordForm.zdhTransrecordDto.sourcetaskno}"/>" size="10" readonly="true" />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhTransrecordDto.zzdhtransrecord3.ondutyno"/><%--交接班记录编号--%></td>
			  			  
	    		
			  			   <td height="23" width="30%"  colspan="3"  >
				 <input id="zdhTransrecordDto.zzdhtransrecord3.ondutyno" name="zdhTransrecordDto.zzdhtransrecord3.ondutyno" type="text" value="<c:out value="${zdhTransrecordForm.zdhTransrecordDto.zzdhtransrecord3.ondutyno}"/>" size="10" readonly />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 &nbsp;</td>
			  			  
	    		    </tr>
		
            		
	 	   -->



						</table>
					</td>
				</tr>
			</table>
		</form>
		<script>

    var id = document.getElementById('zdhTransrecordDto.transrecordid').value; 

    

    //进行初始化动作




    if (id == '' || id == null){

       //初始化填单人

       document.getElementById('zdhTransrecordDto.sys_fille').value = '<%=userName%>';

       //初始化填写单位       

       document.getElementById('zdhTransrecordDto.sys_filldept').value = '<%=userDeptName%>';

       //初始化填写时间




       document.getElementById('zdhTransrecordDto.sys_filltime').value = '<%=currentTime%>';

       //数据所属单位




       document.getElementById('zdhTransrecordDto.sys_dataowner').value = '<%=dataOwnerName%>';

		//传动时间
		document.getElementById('zdhTransrecordDto.transdate').value= '<%=strtest%>';
    }

    

</script>
	</body>
</html>
