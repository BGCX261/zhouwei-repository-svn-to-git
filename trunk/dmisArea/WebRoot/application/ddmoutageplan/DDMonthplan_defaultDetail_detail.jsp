<%@ page contentType="text/html; charset=utf-8" language="java"  buffer="18kb"%>
<%@ page import="com.techstar.dmis.web.form.DdMoutageplanForm"%>
<%@ page import="com.techstar.dmis.dto.DdMoutageplanDto"%>
<%@ page import="com.techstar.dmis.helper.ResourceHelp"%>
<%@ page import="com.techstar.dmis.common.DispatchResConstants"%>
<%@ page import="java.sql.Timestamp"%>


<%@ page import="java.util.Map"%>

<%@ include file="/common/init_tag.jsp"%>



<html>
	<head>
		<html:base />
		<title>月停电计划详情</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="../../themes/themes1/style.css" rel="stylesheet"
			type="text/css" />
		<%@ include file="/common/init_js.jsp"%>
		<%@ include file="/common/init_date.jsp"%>
		<script language="javascript" type="text/javascript"
			src="<%=request.getContextPath()%>/application/ddmoutageplan/DDMonthplan_defaultDetail_detail.js"></script>
	</head>
	<body>
		<html:javascript formName="ddMoutageplanForm" />
		<logic:messagesPresent message="true">
			<html:messages id="message" message="true" header="messages.header"
				footer="messages.footer">
				<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
			</html:messages>
		</logic:messagesPresent>
		<form name="ddMoutageplanForm" action="" method="post">
			<%--hidden--%>

			<input type="hidden" name="ddMoutageplanDto.fmonthplanno"
				value="<c:out value="${ddMoutageplanForm.ddMoutageplanDto.fmonthplanno}"/>">
			<input type="hidden" name="ddMoutageplanDto.version"
				value="<c:out value="${ddMoutageplanForm.ddMoutageplanDto.version}"/>">
			<input type="hidden" name="ddMoutageplanDto.ismerge"
				value="<c:out value="${ddMoutageplanForm.ddMoutageplanDto.ismerge}"/>">
			<input type="hidden" name="ddMoutageplanDto.fstatus"
				value="<c:out value="${ddMoutageplanForm.ddMoutageplanDto.fstatus}"/>">
			<input type="hidden" name="ddMoutageplanDto.fplansourcetype"
				value="<c:out value="${ddMoutageplanForm.ddMoutageplanDto.fplansourcetype}"/>">
			<input type="hidden" name="ddMoutageplanDto.fplansourceno"
				value="<c:out value="${ddMoutageplanForm.ddMoutageplanDto.fplansourceno}"/>">
			<input type="hidden" name="ddMoutageplanDto.flinenameid"
				value="<c:out value="${ddMoutageplanForm.ddMoutageplanDto.flinenameid}"/>">
			<input type="hidden" name="ddMoutageplanDto.fapplyunitid"
				value="<c:out value="${ddMoutageplanForm.ddMoutageplanDto.fapplyunitid}"/>">
			<input type="hidden" name="ddMoutageplanDto.fapplicantid"
				value="<c:out value="${ddMoutageplanForm.ddMoutageplanDto.fapplicantid}"/>">
			<input type="hidden" name="ddMoutageplanDto.ffillunitid"
				value="<c:out value="${ddMoutageplanForm.ddMoutageplanDto.ffillunitid}"/>">
			<input type="hidden" name="ddMoutageplanDto.ffillerid"
				value="<c:out value="${ddMoutageplanForm.ddMoutageplanDto.ffillerid}"/>">
			<input type="hidden" name="ddMoutageplanDto.fmergeid"
				value="<c:out value="${ddMoutageplanForm.ddMoutageplanDto.fmergeid}"/>">
			<input type="hidden" name="ddMoutageplanDto.isreplace"
				value="<c:out value="${ddMoutageplanForm.ddMoutageplanDto.isreplace}"/>">
			<input type="hidden" name="ddMoutageplanDto.feqpcontent"
				value="<c:out value="${ddMoutageplanForm.ddMoutageplanDto.feqpcontent}"/>">
			<input type="hidden" name="ddMoutageplanDto.sys_isvalid"
				value="<c:out value="${ddMoutageplanForm.ddMoutageplanDto.sys_isvalid}"/>">
			<input type="hidden" name="ddMoutageplanDto.funfinishreasonid"
				value="<c:out value="${ddMoutageplanForm.ddMoutageplanDto.funfinishreasonid}"/>">

			<input type="hidden" name="ddMoutageplanDto.fmonthplanno"
				value="<c:out value="${ddMoutageplanForm.ddMoutageplanDto.fmonthplanno}"/>">

			<input type="hidden" name="ddMoutageplanDto.ffillunit"
				value="<c:out value="${ddMoutageplanForm.ddMoutageplanDto.ffillunit}"/>">

			<input type="hidden" name="ddMoutageplanDto.fstationid"
				value="<c:out value="${ddMoutageplanForm.ddMoutageplanDto.fstationid}"/>">

			<input type="hidden" name="ddMoutageplanDto.sys_filldept"
				value="<c:out value="${ddMoutageplanForm.ddMoutageplanDto.sys_filldept}"/>">

			<input type="hidden" name="ddMoutageplanDto.sys_filltime"
				value="<c:out value="${ddMoutageplanForm.ddMoutageplanDto.sys_filltime}"/>">

			<input type="hidden" name="ddMoutageplanDto.sys_fille"
				value="<c:out value="${ddMoutageplanForm.ddMoutageplanDto.sys_fille}"/>">

			<input type="hidden" name="ddMoutageplanDto.sys_dataowner"
				value="<c:out value="${ddMoutageplanForm.ddMoutageplanDto.sys_dataowner}"/>">

            <%
            
            		DdMoutageplanForm  form  =(DdMoutageplanForm)request.getAttribute("ddMoutageplanForm");
            		DdMoutageplanDto dto =form.getDdMoutageplanDto();
            		Timestamp  fstarttime = null;
            		Timestamp  fendtime =null;
            		Timestamp  fapplytime =null; 
            		String fvoltage =null;
            		String monthplantype =null;
            		String fdispatchrange =null;
            		if(dto!=null){
            			fstarttime = dto.getFstarttime();
            			fendtime =dto.getFendtime();
            			fapplytime =dto.getFapplytime();
            			fvoltage =dto.getFvoltage();
            			monthplantype =dto.getMonthplantype();
            			
            		}
            		
            
             %>
            <%
            		boolean  approveflag = ResourceHelp.isHaveRes(DispatchResConstants.DDMOUTAGEPLAN_APPROVE);
            		if(approveflag){
            		   boolean  approveeditflag = ResourceHelp.isHaveRes(DispatchResConstants.DDMOUTAGEPLAN_APPROVE_EDIT);
            			
             %>
			<jhop:ctrlgroup
				ctrlId="UIControlGroupXPanel6347ed8da9c44c9fb0a6a3eed851fe5d"
				title="月计划申请">
			</jhop:ctrlgroup>
              <%if(approveeditflag){ %>
						<table class="detailmain" cellspacing="0" cellpadding="0">
							<tr id="UIControlGroupXPanel6347ed8da9c44c9fb0a6a3eed851fe5d">
								<td align="center">
									<table class="detail" width="100%" height="100%" cellspacing="0">
			
										<tr>
											<td height="23" class="tab_0" width="20%">
												<bean:message key="object.ddMoutageplanDto.fstationname" />
												<%--变电站--%>
											</td>
											<td height="23" width="30%">
												<input id="ddMoutageplanDto.fstationname"
													name="ddMoutageplanDto.fstationname" type="text"
													value="<c:out value="${ddMoutageplanForm.ddMoutageplanDto.fstationname}"/>"
													size="10" />
												<img name=''
													src="<%=request.getContextPath()%>/themes/themes1/images/main/find.gif"
													onClick="setStdStationSelect();">
											</td>
											<td height="23" class="tab_0" width="20%">
												<bean:message key="object.ddMoutageplanDto.flinename" />
												<%--线路名--%>
											</td>
											<td height="23" width="30%">
			
												<input id="ddMoutageplanDto.flinename"
													name="ddMoutageplanDto.flinename" type="text"
													value="<c:out value="${ddMoutageplanForm.ddMoutageplanDto.flinename}"/>"
													size="10" />
												<img name=''
													src="<%=request.getContextPath()%>/themes/themes1/images/main/find.gif"
													onClick="setStdLineSelect();">
											</td>
										</tr>
										<tr>
											<td height="23" class="tab_0" width="20%">
												<bean:message key="object.ddMoutageplanDto.fvoltage" />
												<%--电压等级--%>
											</td>
											<td height="23" width="30%">
											<%if(fvoltage==null){ %>
												<jhop:select name="ddMoutageplanDto.fvoltage" hiddName=""
													type="fvoltage"
													initValue="">
												</jhop:select>
												<%}else{ %>
												<jhop:select name="ddMoutageplanDto.fvoltage" hiddName=""
													type="fvoltage"
													initValue="<%=fvoltage %>">
													
												</jhop:select>
												<%} %>
											</td>
											<td height="23" class="tab_0" width="20%">
												<bean:message key="object.ddMoutageplanDto.monthplantype" />
												<%--计划性质--%>
											</td>
											<td height="23" width="30%">
											<%if(monthplantype==null){ %>
												<jhop:select name="ddMoutageplanDto.monthplantype" hiddName=""
													type="monthplantype"
													initValue="">
												</jhop:select>
												<%}else{ %>
												<jhop:select name="ddMoutageplanDto.monthplantype" hiddName=""
													type="monthplantype"
													initValue="<%=monthplantype %>">
												</jhop:select>
												<%} %>
											</td>
										</tr>
										<tr>
											<td height="23" class="tab_0" width="20%">
												<bean:message key="object.ddMoutageplanDto.fstarttime" />
												<%--预计工作起始时间--%>
												<span class="article_required">*</span>
											</td>
											<td height="23" width="30%">
											   <%if(fstarttime==null) {%>
												<jhop:dateselect name="ddMoutageplanDto.fstarttime"
													endName="ddMoutageplanDto.fendtime" showSecond="true"
													initValue=""
													dateFormat="yyyy-mm-dd hh:mm" group="start"></jhop:dateselect>
												<%}else{ %>
													<jhop:dateselect name="ddMoutageplanDto.fstarttime"
													endName="ddMoutageplanDto.fendtime" showSecond="true"
													initValue="<%=fstarttime.toString() %>"
													dateFormat="yyyy-mm-dd hh:mm" group="start"></jhop:dateselect>
												<%} %>
											</td>
											<td height="23" class="tab_0" width="20%">
												<bean:message key="object.ddMoutageplanDto.fendtime" />
												<%--预计工作结束时间--%>
												<span class="article_required">*</span>
											</td>
											<td height="23" width="30%">
											<%if(fendtime==null){ %>
												<jhop:dateselect name="ddMoutageplanDto.fendtime"
													startName="ddMoutageplanDto.fstarttime" showSecond="true"
													initValue=""
													dateFormat="yyyy-mm-dd hh:mm" group="end"></jhop:dateselect>
											<%}else{ %>
												<jhop:dateselect name="ddMoutageplanDto.fendtime"
													startName="ddMoutageplanDto.fstarttime" showSecond="true"
													initValue="<%=fendtime.toString() %>"
													dateFormat="yyyy-mm-dd hh:mm" group="end"></jhop:dateselect>
											<%} %>
											</td>
										</tr>
										<tr>
											<td height="23" class="tab_0" width="20%">
												<bean:message key="object.ddMoutageplanDto.foutagearea" />
												<%--停电范围--%>
												<span class="article_required">*</span>
											</td>
											<td height="23" width="30%" colspan="3">
												<textarea id='ddMoutageplanDto.foutagearea'
													name='ddMoutageplanDto.foutagearea' rows='3' cols='50'
													type="_moz">
													<c:out
														value="${ddMoutageplanForm.ddMoutageplanDto.foutagearea}" />
												</textarea>
											</td>
										</tr>
										<tr>
											<td height="23" class="tab_0" width="20%">
												<bean:message key="object.ddMoutageplanDto.fworkcontent" />
												<%--工作内容--%>
												<span class="article_required">*</span>
											</td>
											<td height="23" width="30%" colspan="3">
												<textarea id='ddMoutageplanDto.fworkcontent'
													name='ddMoutageplanDto.fworkcontent' rows='3' cols='50'
													readonly='true' type="_moz">
													<c:out
														value="${ddMoutageplanForm.ddMoutageplanDto.fworkcontent}" />
												</textarea>
											</td>
											<td height="23" width="30%" colspan="3">
											</td>
										</tr>
										<tr>
											<td height="23" class="tab_0" width="20%">
												<bean:message key="object.ddMoutageplanDto.fdispatchrange" />
												<%--调度范围--%>
											</td>
											<td height="23" width="30%">
			
												<input id="ddMoutageplanDto.fdispatchrange"
													name="ddMoutageplanDto.fdispatchrange" type="text"
													value="<c:out value="${ddMoutageplanForm.ddMoutageplanDto.fdispatchrange}"/>"
													size="10" />
												<img name=''
													src="<%=request.getContextPath()%>/themes/themes1/images/main/find.gif"
													onClick="showDispathUnit();">
											</td>
											<td height="23" class="tab_0" width="20%">
												<bean:message key="object.ddMoutageplanDto.fapplyunit" />
												<%--申请单位--%>
												<span class="article_required">*</span>
											</td>
											<td height="23" width="30%">
												<input id="ddMoutageplanDto.fapplyunit"
													name="ddMoutageplanDto.fapplyunit" type="text"
													value="<c:out value="${ddMoutageplanForm.ddMoutageplanDto.fapplyunit}"/>"
													size="10" />
											</td>
										</tr>
										<tr>
			
											<td height="23" class="tab_0" width="20%">
												<bean:message key="object.ddMoutageplanDto.fapplicant" />
												<%--申请人--%>
												<span class="article_required">*</span>
											</td>
											<td height="23" width="30%">
												<input id="ddMoutageplanDto.fapplicant"
													name="ddMoutageplanDto.fapplicant" type="text"
													value="<c:out value="${ddMoutageplanForm.ddMoutageplanDto.fapplicant}"/>"
													size="10" />
											</td>
											<td height="23" class="tab_0" width="20%">
												<bean:message key="object.ddMoutageplanDto.fapplytime" />
												<%--申请时间--%>
											</td>
											<td height="23" width="30%">
											    <%if(fapplytime==null){ %>
												<jhop:date name="ddMoutageplanDto.fapplytime" genText="yes"
													dateFormat="yyyy-mm-dd hh:mm" showSecond="true"
													initValue=""></jhop:date>
												<%}else{ %>
												<jhop:date name="ddMoutageplanDto.fapplytime" genText="yes"
													dateFormat="yyyy-mm-dd hh:mm" showSecond="true"
													initValue="<%=fapplytime.toString() %>"></jhop:date>
												<%} %>
											</td>
			
										</tr>
			
									</table>
								</td>
							</tr>
						</table>
				<%}else{ %>
				<table class="detailmain" cellspacing="0" cellpadding="0">
							<tr id="UIControlGroupXPanel6347ed8da9c44c9fb0a6a3eed851fe5d">
								<td align="center">
									<table class="detail" width="100%" height="100%" cellspacing="0">
			
										<tr>
											<td height="23" class="tab_0" width="20%">
												<bean:message key="object.ddMoutageplanDto.fstationname" />
												<%--变电站--%>
											</td>
											<td height="23" width="30%">
												<input id="ddMoutageplanDto.fstationname"  onFocus="this.blur()"
													name="ddMoutageplanDto.fstationname" type="text"
													value="<c:out value="${ddMoutageplanForm.ddMoutageplanDto.fstationname}"/>"
													size="10" />
												
											</td>
											<td height="23" class="tab_0" width="20%">
												<bean:message key="object.ddMoutageplanDto.flinename" />
												<%--线路名--%>
											</td>
											<td height="23" width="30%">
			
												<input id="ddMoutageplanDto.flinename" onFocus="this.blur()"
													name="ddMoutageplanDto.flinename" type="text"
													value="<c:out value="${ddMoutageplanForm.ddMoutageplanDto.flinename}"/>"
													size="10" />
												
											</td>
										</tr>
										<tr>
											<td height="23" class="tab_0" width="20%">
												<bean:message key="object.ddMoutageplanDto.fvoltage" />
												<%--电压等级--%>
											</td>
											<td height="23" width="30%">
												
												<input id="ddMoutageplanDto.fvoltage" onFocus="this.blur()"
													name="ddMoutageplanDto.fvoltage" type="text"
													value="<c:out value="${ddMoutageplanForm.ddMoutageplanDto.fvoltage}"/>"
													size="10" />
											</td>
											<td height="23" class="tab_0" width="20%">
												<bean:message key="object.ddMoutageplanDto.monthplantype" />
												<%--计划性质--%>
											</td>
											<td height="23" width="30%">
											
												<input id="ddMoutageplanDto.monthplantype" onFocus="this.blur()"
													name="ddMoutageplanDto.monthplantype" type="text"
													value="<c:out value="${ddMoutageplanForm.ddMoutageplanDto.monthplantype}"/>"
													size="10" />
											</td>
										</tr>
										<tr>
											<td height="23" class="tab_0" width="20%">
												<bean:message key="object.ddMoutageplanDto.fstarttime" />
												<%--预计工作起始时间--%>
												<span class="article_required">*</span>
											</td>
											<td height="23" width="30%">
								
												<input id="ddMoutageplanDto.fstarttime" onFocus="this.blur()"
													name="ddMoutageplanDto.fstarttime" type="text"
													value="<c:out value="${ddMoutageplanForm.ddMoutageplanDto.fstarttime}"/>"
													size="10" />
											</td>
											<td height="23" class="tab_0" width="20%">
												<bean:message key="object.ddMoutageplanDto.fendtime" />
												<%--预计工作结束时间--%>
												<span class="article_required">*</span>
											</td>
											<td height="23" width="30%">
								
											
											<input id="ddMoutageplanDto.fendtime" onFocus="this.blur()"
													name="ddMoutageplanDto.fendtime" type="text"
													value="<c:out value="${ddMoutageplanForm.ddMoutageplanDto.fendtime}"/>"
													size="10" />
											</td>
										</tr>
										<tr>
											<td height="23" class="tab_0" width="20%">
												<bean:message key="object.ddMoutageplanDto.foutagearea" />
												<%--停电范围--%>
												<span class="article_required">*</span>
											</td>
											<td height="23" width="30%" colspan="3">
												<textarea id='ddMoutageplanDto.foutagearea' onFocus="this.blur()"
													name='ddMoutageplanDto.foutagearea' rows='3' cols='50'
													type="_moz">
													<c:out
														value="${ddMoutageplanForm.ddMoutageplanDto.foutagearea}" />
												</textarea>
											</td>
										</tr>
										<tr>
											<td height="23" class="tab_0" width="20%">
												<bean:message key="object.ddMoutageplanDto.fworkcontent" />
												<%--工作内容--%>
												<span class="article_required">*</span>
											</td>
											<td height="23" width="30%" colspan="3">
												<textarea id='ddMoutageplanDto.fworkcontent' 
													name='ddMoutageplanDto.fworkcontent' rows='3' cols='50'
													readonly='true' type="_moz">
													<c:out
														value="${ddMoutageplanForm.ddMoutageplanDto.fworkcontent}" />
												</textarea>
											</td>
											<td height="23" width="30%" colspan="3">
											</td>
										</tr>
										<tr>
											<td height="23" class="tab_0" width="20%">
												<bean:message key="object.ddMoutageplanDto.fdispatchrange" />
												<%--调度范围--%>
											</td>
											<td height="23" width="30%">
			
												<input id="ddMoutageplanDto.fdispatchrange" onFocus="this.blur()"
													name="ddMoutageplanDto.fdispatchrange" type="text"
													value="<c:out value="${ddMoutageplanForm.ddMoutageplanDto.fdispatchrange}"/>"
													size="10" />
											
											</td>
											<td height="23" class="tab_0" width="20%">
												<bean:message key="object.ddMoutageplanDto.fapplyunit" />
												<%--申请单位--%>
												<span class="article_required">*</span>
											</td>
											<td height="23" width="30%">
												<input id="ddMoutageplanDto.fapplyunit" onFocus="this.blur()"
													name="ddMoutageplanDto.fapplyunit" type="text"
													value="<c:out value="${ddMoutageplanForm.ddMoutageplanDto.fapplyunit}"/>"
													size="10" />
											</td>
										</tr>
										<tr>
			
											<td height="23" class="tab_0" width="20%">
												<bean:message key="object.ddMoutageplanDto.fapplicant" />
												<%--申请人--%>
												<span class="article_required">*</span>
											</td>
											<td height="23" width="30%">
												<input id="ddMoutageplanDto.fapplicant" onFocus="this.blur()"
													name="ddMoutageplanDto.fapplicant" type="text"
													value="<c:out value="${ddMoutageplanForm.ddMoutageplanDto.fapplicant}"/>"
													size="10" />
											</td>
											<td height="23" class="tab_0" width="20%">
												<bean:message key="object.ddMoutageplanDto.fapplytime" />
												<%--申请时间--%>
											</td>
											<td height="23" width="30%">
												
												<input id="ddMoutageplanDto.fapplytime" onFocus="this.blur()"
													name="ddMoutageplanDto.fapplytime" type="text"
													value="<c:out value="${ddMoutageplanForm.ddMoutageplanDto.fapplytime}"/>"
													size="10" />
											</td>
			
										</tr>
			
									</table>
								</td>
							</tr>
						</table>
			<%
			
			         }
			   }
			
			
			%>
			
			
			<%
					boolean exeflag = ResourceHelp.isHaveRes(DispatchResConstants.DDMOUTAGEPLAN_EXE);
					if(exeflag){
			
			 %>
			<jhop:ctrlgroup
				ctrlId="UIControlGroupXPanel1e5f0edf543640af882ffb6e269055e6"
				title="月计划执行">
			</jhop:ctrlgroup>
            
			<table class="detailmain" cellspacing="0" cellpadding="0">
				<tr id="UIControlGroupXPanel1e5f0edf543640af882ffb6e269055e6">
					<td align="center">
						<table class="detail" width="100%" height="100%" cellspacing="0">
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddMoutageplanDto.fexcutestatus" />
									<%--执行情况--%>
								</td>
								<td height="23" width="30%">
									<input id="ddMoutageplanDto.fexcutestatus" onFocus="this.blur()" 
										name="ddMoutageplanDto.fexcutestatus" type="text"
										value="<c:out value="${ddMoutageplanForm.ddMoutageplanDto.fexcutestatus}"/>"
										size="10" />
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddMoutageplanDto.funfinishreason" />
									<%--未完成原因--%>
								</td>
								<td height="23" width="30%">
									<input id="ddMoutageplanDto.funfinishreason"  onFocus="this.blur()" 
										name="ddMoutageplanDto.funfinishreason" type="text"
										value="<c:out value="${ddMoutageplanForm.ddMoutageplanDto.funfinishreason}"/>"
										size="10" readonly="true" />
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		<%} %>
		</form>
	</body>
</html>