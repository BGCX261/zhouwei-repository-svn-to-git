<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map"%>
<%@ page import="com.techstar.dmis.helper.BusinessDetailHelper"%>
<%@ page import="com.techstar.dmis.helper.dto.BusinessDetailDto"%>
<%@ page import="java.sql.Timestamp"%>
<%@ page import="java.sql.Date"%>
<%@ page import="com.techstar.dmis.util.DateUtil"%>
<%@ include file="/common/init_tag.jsp"%>
<html>
	<head>
		<html:base />
		<title>日计划核查表详情</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="../../themes/themes1/style.css" rel="stylesheet"
			type="text/css" />
		<%@ include file="/common/init_js.jsp"%>
		<%@ include file="/common/init_date.jsp"%>
		<script language="javascript" type="text/javascript"
			src="<%=request.getContextPath()%>/application/zdhopexaminelist/ZdhOpexaminelist_defaultDetail_detail.js"></script>
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
			String strFapplystime=(String)request.getAttribute("fapplystime");
		    String strFapplyetime=(String)request.getAttribute("fapplyetime");
		    //System.out.println("strFapplystime"+strFapplystime);
		     //System.out.println("strFapplyetime"+strFapplyetime);
			Date strDate = DateUtil.stringToSqlDate(currentTime.toString());
			boolean bBingchecktime = false;
			String readonly = "";
			String readonly1 = "readonly";
			if (request.getAttribute("rBeginchecktime") != null) {
				readonly="readonly";
				readonly1 = "  ";
			}

			System.out.println("readonly="+readonly);
			
		%>
		<%
			//班号
			String ondutyno = (String) request.getAttribute("ondutyno");
			String currno = (String) request.getAttribute("currno");			
			if (currno==null&&ondutyno==null&&currno.equalsIgnoreCase("")
					&& !currno.equalsIgnoreCase(ondutyno)) {
				readonly = " readonly ";
			}
			System.out.println("currno="+currno);
			System.out.println("ondutyno="+ondutyno);
			System.out.println("readonly="+readonly);
		%>
		<html:javascript formName="zdhOpexaminelistForm" />
		<logic:messagesPresent message="true">
			<html:messages id="message" message="true" header="messages.header"
				footer="messages.footer">
				<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
			</html:messages>
		</logic:messagesPresent>
		<form name="zdhOpexaminelistForm" action="" method="post">
			<%--hidden--%>

			<input type="hidden" name="zdhOpexaminelistDto.examinationid"
				value="<c:out value="${zdhOpexaminelistForm.zdhOpexaminelistDto.examinationid}"/>">
			<input type="hidden" name="zdhOpexaminelistDto.version"
				value="<c:out value="${zdhOpexaminelistForm.zdhOpexaminelistDto.version}"/>">

			<jhop:ctrlgroup
				ctrlId="UIControlGroupXPanel434beac5d52a4a0c9ad67eb4b4a4507e"
				title="计划信息">
			</jhop:ctrlgroup>

			<table class="detailmain" cellspacing="0" cellpadding="0">
				<tr id="UIControlGroupXPanel434beac5d52a4a0c9ad67eb4b4a4507e">
					<td align="center">
						<table class="detail" width="100%" height="100%" cellspacing="0">
							<tr>

								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhOpexaminelistDto.fapplystime" />
									<%--工作开始时间--%>
								</td>

								<td height="23" width="30%">
								<input type="text" name="fapplystime_1" value="<c:out value="${fapplystime}"/>" readonly=true/>
								<input type="hidden" name="zdhOpexaminelistDto.fapplystime" value="<c:out value="${zdhOpexaminelistForm.zdhOpexaminelistDto.fapplystime}"/>"/>
								</td>				
						  	 	
								
						 		<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhOpexaminelistDto.fapplyetime" />
									<%--工作结束时间--%>
								</td>


								<td height="23" width="30%">
									<input type="text" name="fapplyetime_1" value="<c:out value="${fapplyetime}"/>" readonly/>
									<input type="hidden" name="zdhOpexaminelistDto.fapplyetime" value="<c:out value="${zdhOpexaminelistForm.zdhOpexaminelistDto.fapplyetime}"/>"/>
								</td>

							</tr>
							<tr>

								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhOpexaminelistDto.fworkcontent" />
									<%--工作内容--%>
								</td>


								<td height="23" width="30%" colspan="3">
									<textarea id='zdhOpexaminelistDto.fworkcontent'
										name='zdhOpexaminelistDto.fworkcontent' rows='3' cols='50'
										readonly='true'><c:out value="${zdhOpexaminelistForm.zdhOpexaminelistDto.fworkcontent}"/></textarea>
								</td>

							</tr>

						</table>
					</td>
				</tr>
			</table>
			<jhop:ctrlgroup
				ctrlId="UIControlGroupXPanele0db70d1389b4162bedcfc393379a55d"
				title="日计划开始核查">
			</jhop:ctrlgroup>

			<table class="detailmain" cellspacing="0" cellpadding="0">
				<tr id="UIControlGroupXPanele0db70d1389b4162bedcfc393379a55d">
					<td align="center">
						<table class="detail" width="100%" height="100%" cellspacing="0">
							<tr>

								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhOpexaminelistDto.begincheck" />
									<%--开始工作核查--%>
								</td>


								<td height="23" width="30%">
								
									<input id="zdhOpexaminelistDto.begincheck"
										name="zdhOpexaminelistDto.begincheck" type="text"
										value="<c:out value="${zdhOpexaminelistForm.zdhOpexaminelistDto.begincheck}"/>"
										size="10" <%=readonly %>/>
									


								</td>


								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhOpexaminelistDto.beginchecktime" />
									<%--开始工作核查时间--%>
								</td>


								<td height="23" width="30%">
								
								<% 
									if (readonly!=null&&readonly.trim().length()>0)
									{
									%>
										<input id="eventzdhOpexaminelistDto.beginchecktime_1"
										name="zdhOpexaminelistDto.beginchecktime" type="text"
										value="<c:out value="${zdhOpexaminelistForm.zdhOpexaminelistDto.beginchecktime}"/>"
										size="20" readonly="true" />
								
									<%
									}else{
									%>
										<jhop:dateselect		name="zdhOpexaminelistDto.beginchecktime"
										endName="zdhOpexaminelistDto.finishchecktime"
										showSecond="true"
										initValue="${zdhOpexaminelistForm.zdhOpexaminelistDto.beginchecktime}"
										dateFormat="yyyy-mm-dd hh:mm" group="start"></jhop:dateselect>
									
									<%
									} 
									%>
								</td>

							</tr>
							
							<tr>

								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhOpexaminelistDto.beginchecker" />
									<%--开始核查人--%>
								</td>


								<td height="23" width="30%" colspan="3">
									<input id="zdhOpexaminelistDto.beginchecker"
										name="zdhOpexaminelistDto.beginchecker" type="text"
										value="<c:out value="${zdhOpexaminelistForm.zdhOpexaminelistDto.beginchecker}"/>"
										size="10" readonly="true" />
								</td>

							</tr>
														<%--填写人--%>
							<input name="zdhOpexaminelistDto.sys_fille" type="hidden"
								value="<c:out value="${zdhOpexaminelistForm.zdhOpexaminelistDto.sys_fille}"/>" />
							<%--填写单位--%>
							<input name="zdhOpexaminelistDto.sys_filldept" type="hidden"
								value="<c:out value="${zdhOpexaminelistForm.zdhOpexaminelistDto.sys_filldept}"/>" />
							<%--填写时间--%>
							<input name="zdhOpexaminelistDto.sys_filltime" type="hidden"
								value="<c:out value="${zdhOpexaminelistForm.zdhOpexaminelistDto.sys_filltime}"/>" />
							<%--是否有效字段--%>
							<input name="zdhOpexaminelistDto.sys_isvalid" type="hidden"
								value="<c:out value="${zdhOpexaminelistForm.zdhOpexaminelistDto.sys_isvalid}"/>" />
							<%--数据所属单位--%>
							<input name="zdhOpexaminelistDto.sys_dataowner" type="hidden"
								value="<c:out value="${zdhOpexaminelistForm.zdhOpexaminelistDto.sys_dataowner}"/>" />
							<%--交接班记录编号--%>
							<input name="zdhOpexaminelistDto.zzdhopexaminelist5.ondutyno"
								type="hidden"
								value="<c:out value="${zdhOpexaminelistForm.zdhOpexaminelistDto.zzdhopexaminelist5.ondutyno}"/>" />
							<!-- 
							<tr>

								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhOpexaminelistDto.sys_fille" />
									<%--填写人--%>
								</td>


								<td height="23" width="30%">
									<input id="zdhOpexaminelistDto.sys_fille"
										name="zdhOpexaminelistDto.sys_fille" type="text"
										value="<c:out value="${zdhOpexaminelistForm.zdhOpexaminelistDto.sys_fille}"/>"
										size="10" readonly="true" />
								</td>


								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhOpexaminelistDto.sys_filldept" />
									<%--填写单位--%>
								</td>


								<td height="23" width="30%">
									<input id="zdhOpexaminelistDto.sys_filldept"
										name="zdhOpexaminelistDto.sys_filldept" type="text"
										value="<c:out value="${zdhOpexaminelistForm.zdhOpexaminelistDto.sys_filldept}"/>"
										size="10" readonly="true" />
								</td>

							</tr>
							<tr>

								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhOpexaminelistDto.sys_filltime" />
									<%--填写时间--%>
								</td>


								<td height="23" width="30%">
									<input name="zdhOpexaminelistDto.sys_filltime"
										value="<c:out value="${zdhOpexaminelistForm.zdhOpexaminelistDto.sys_filltime}"/>"
										readonly="true" />
								</td>


								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhOpexaminelistDto.sys_isvalid" />
									<%--是否有效字段--%>
								</td>


								<td height="23" width="30%">
									<input id="zdhOpexaminelistDto.sys_isvalid"
										name="zdhOpexaminelistDto.sys_isvalid" type="text"
										value="<c:out value="${zdhOpexaminelistForm.zdhOpexaminelistDto.sys_isvalid}"/>"
										size="10" readonly="true" />
								</td>

							</tr>
							<tr>

								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhOpexaminelistDto.sys_dataowner" />
									<%--数据所属单位--%>
								</td>


								<td height="23" width="30%">
									<input id="zdhOpexaminelistDto.sys_dataowner"
										name="zdhOpexaminelistDto.sys_dataowner" type="text"
										value="<c:out value="${zdhOpexaminelistForm.zdhOpexaminelistDto.sys_dataowner}"/>"
										size="10" readonly="true" />
								</td>


								<td height="23" class="tab_0" width="20%">
									<bean:message
										key="object.zdhOpexaminelistDto.zzdhopexaminelist5.ondutyno" />
									<%--交接班记录编号--%>
								</td>


								<td height="23" width="30%">
									<input id="zdhOpexaminelistDto.zzdhopexaminelist5.ondutyno"
										name="zdhOpexaminelistDto.zzdhopexaminelist5.ondutyno"
										type="text"
										value="<c:out value="${zdhOpexaminelistForm.zdhOpexaminelistDto.zzdhopexaminelist5.ondutyno}"/>"
										size="10" readonly="true" />
								</td>

							</tr>
							<tr>

								<td height="23" class="tab_0" width="20%">
									&nbsp;
								</td>

							</tr>
 -->





						</table>
					</td>
				</tr>
			</table>

			<jhop:ctrlgroup
				ctrlId="UIControlGroupXPanelb85cb6755c1245f6be972983d687306c"
				title="完成情况核查">
			</jhop:ctrlgroup>

			<table class="detailmain" cellspacing="0" cellpadding="0">
				<tr id="UIControlGroupXPanelb85cb6755c1245f6be972983d687306c">
					<td align="center">
						<table class="detail" width="100%" height="100%" cellspacing="0">
							<tr>

								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhOpexaminelistDto.finishcheck" />
									<%--完成情况核查--%>
								</td>


								<td height="23" width="30%">
									<input id="zdhOpexaminelistDto.finishcheck"
										name="zdhOpexaminelistDto.finishcheck" type="text"
										value="<c:out value="${zdhOpexaminelistForm.zdhOpexaminelistDto.finishcheck}"/>"
										size="10" <%=readonly1 %>/>
								</td>


								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhOpexaminelistDto.finishchecktime" />
									<%--完成核查时间--%>
								</td>


								<td height="23" width="30%">
						
								<%
							
								
							
								if (readonly1!=null&&readonly1.trim().length()>0){
								 %>
								 <input id="eventzdhOpexaminelistDto.finishchecktime_1"	name="zdhOpexaminelistDto.finishchecktime"	value="<c:out value="${zdhOpexaminelistForm.zdhOpexaminelistDto.finishchecktime}"/>" readonly/>

								<%
								}else{
								 %>
								 		<jhop:dateselect 	name="zdhOpexaminelistDto.finishchecktime"
										startName="zdhOpexaminelistDto.beginchecktime"
										showSecond="true"
										initValue="${zdhOpexaminelistForm.zdhOpexaminelistDto.finishchecktime}"
										dateFormat="yyyy-mm-dd hh:mm" group="end"></jhop:dateselect>
								<%} %>
								</td>

							</tr>
							<tr>

								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.zdhOpexaminelistDto.finishchecker" />
									<%--完成核查人--%>
								</td>


								<td height="23" width="30%" colspan="3">
									<input id="zdhOpexaminelistDto.finishchecker"
										name="zdhOpexaminelistDto.finishchecker" type="text"
										value="<c:out value="${zdhOpexaminelistForm.zdhOpexaminelistDto.finishchecker}"/>"
										size="10" readonly="true" />
								</td>

							</tr>

						</table>
						
					</td>
				</tr>
			</table>
		</form>


		<%
		//System.out.println("readonly="+readonly);
		if (readonly!=null&&readonly.trim().length()>0){
		%>
		<script>
		
 document.getElementById('zdhOpexaminelistDto.finishchecker').value = '<%=userName%>';

 </script>
		<%
		}else{
		%>
				<script> 
    
    //进行初始化动作   
       //初始化填单人
       document.getElementById('zdhOpexaminelistDto.sys_fille').value = '<%=userName%>';
       //初始化填写单位       
       document.getElementById('zdhOpexaminelistDto.sys_filldept').value = '<%=userDeptName%>';
       //初始化填写时间

       document.getElementById('zdhOpexaminelistDto.sys_filltime').value = '<%=currentTime%>';
       //数据所属单位       
       document.getElementById('zdhOpexaminelistDto.sys_dataowner').value = '<%=dataOwnerName%>'; 
       document.getElementById('zdhOpexaminelistDto.beginchecker').value = '<%=userName%>';  
    
</script>
<%} %>
	</body>
</html>
