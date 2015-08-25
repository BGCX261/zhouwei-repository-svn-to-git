<%@ page contentType="text/html; charset=utf-8" language="java" buffer="18kb"%>
<%@ page import="java.util.Map"%>
<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/common/init_js.jsp"%>
<%@ include file="/common/init_tag.jsp"%>
<%@ include file="/common/init_grid.jsp"%>
<%@ page import="com.techstar.dmis.web.form.DdDoutageplanForm" %>
<%@ page import="com.techstar.dmis.dto.DdDoutageplanDto" %>
<%@ page import="com.techstar.dmis.helper.ResourceHelp" %>
<%@ page import="com.techstar.dmis.common.DispatchResConstants" %>
<%
	DdDoutageplanForm ddDoutageplanForm = (DdDoutageplanForm) request.getAttribute("ddDoutageplanForm");
	DdDoutageplanDto  ddDoutageplanDto = (DdDoutageplanDto)ddDoutageplanForm.getDdDoutageplanDto();
	java.sql.Date fapplytime = null;//申请时间
	java.sql.Timestamp fapplyoutagetime = null;//申请停电时间
	java.sql.Timestamp fapplyrestoretime = null;//申请发电时间
	java.sql.Timestamp fapplystime = null;//申请工作起始时间
	java.sql.Timestamp fapplyetime = null;//申请工作结束时间
	String fplanclass = null;//计划分类
	String fdispatchrange =null;//调度范围
	String fline =null;//线路名

	String fstationname = null;//变电站

	String fvoltage=null;//电压等级
	String ispassed =null;//是否合格
	if(ddDoutageplanDto!=null){
		fapplytime = ddDoutageplanDto.getFapplytime();
		fapplyoutagetime = ddDoutageplanDto.getFapplyoutagetime();
		fapplyrestoretime = ddDoutageplanDto.getFapplyrestoretime();
		fapplystime = ddDoutageplanDto.getFapplystime();
		fapplyetime = ddDoutageplanDto.getFapplyetime();
		fplanclass = ddDoutageplanDto.getFplanclass();
		fdispatchrange = ddDoutageplanDto.getFdispatchrange();
		fline = ddDoutageplanDto.getFline();
		fstationname = ddDoutageplanDto.getFstationname();
		fvoltage = ddDoutageplanDto.getFvoltage(); 
		ispassed = ddDoutageplanDto.getIspassed();
	}
 %>
 <c:set var="strTasksource" value="${ddDoutageplanForm.ddDoutageplanDto.fapplyoutagetime}"/>

 
<html>
	<head>
		<html:base />
		<title>日停电计划详情</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="../../themes/themes1/style.css" rel="stylesheet"
			type="text/css" />
		<%@ include file="/common/init_js.jsp"%>
		<%@ include file="/common/init_date.jsp"%>
		<script language="javascript" type="text/javascript"
			src="<%=request.getContextPath()%>/application/dddoutageplan/DDdayoutageplan_defaultDetail_detail.js"></script>
		<link rel="STYLESHEET" type="text/css"
			href="<%=request.getContextPath()%>/themes/themes1/style.css">
	</head>
	</head>
	<body>
		<html:javascript formName="ddDoutageplanForm" />
		<logic:messagesPresent message="true">
			<html:messages id="message" message="true" header="messages.header"
				footer="messages.footer">
				<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
			</html:messages>
		</logic:messagesPresent>
		<form name="ddDoutageplanForm" action="" method="post"
			enctype="multipart/form-data">
			<%--hidden--%>

			<input type="hidden" name="ddDoutageplanDto.fdayplanno"
				value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.fdayplanno}"/>">
			<input type="hidden" name="ddDoutageplanDto.version"
				value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.version}"/>">
			<%--计划来源序号--%>

			<input type="hidden" name="ddDoutageplanDto.fplansourceno"
				value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.fplansourceno}"/>">
			<%--计划来源类型--%>
			<input type="hidden" name="ddDoutageplanDto.fplansourcetype"
				value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.fplansourcetype}"/>">
			<%--上报日期--%>

			<input type="hidden" name="ddDoutageplanDto.freportdate"
				value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.freportdate}"/>">
			<%--是否调度员填写--%>
			<input type="hidden" name="ddDoutageplanDto.ffilltype"
				value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.ffilltype}"/>">

			<%--变电站ID--%>
			<input type="hidden" name="ddDoutageplanDto.fstationid"
				value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.fstationid}"/>">
				
			<%--线路名ID--%>
			<input type="hidden" name="ddDoutageplanDto.flinenameid"
				value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.flinenameid}"/>">
			<%--正式编号--%>
			<input type="hidden" name="ddDoutageplanDto.fmanualno"
				value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.fmanualno}"/>">

			<%--许可内容--%>
			<input type="hidden" name="ddDoutageplanDto.fpermitcontent"
				value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.fpermitcontent}"/>">
			<%--中调计划批准人--%>
			<input type="hidden" name="ddDoutageplanDto.fplanappropeople"
				value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.fplanappropeople}"/>">
			<%--/取消时间--%>
			<input type="hidden" name="ddDoutageplanDto.fcanceltime"
				value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.fcanceltime}"/>">
			<%--取消人--%>
			<input type="hidden" name="ddDoutageplanDto.fabolish"
				value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.fabolish}"/>">

			<%--取消原因--%>
			<input type="hidden" name="ddDoutageplanDto.fabolishReason"
				value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.fabolishReason}"/>">
			<%--取消原因code--%>
			<input type="hidden" name="ddDoutageplanDto.cancelcode"
				value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.cancelcode}"/>">
			<%--状态--%>
			<input type="hidden" name="ddDoutageplanDto.fstatus"
				value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.fstatus}"/>">
			<%--执行状态--%>
			<input type="hidden" name="ddDoutageplanDto.fexcutestatus"
				value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.fexcutestatus}"/>">
			<%--申请单位ID--%>
			<input type="hidden" name="ddDoutageplanDto.fapplyunitid"
				value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.fapplyunitid}"/>">
		
			<%--核查人--%>
			<input type="hidden" name="ddDoutageplanDto.fchecker"
				value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.fchecker}"/>">
			
			<%--核查时间--%>
			<input type="hidden" name="ddDoutageplanDto.fchecktime"
				value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.fchecktime}"/>">
			<%--中调下令时间--%>
			<input type="hidden" name="ddDoutageplanDto.csendtime"
				value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.csendtime}"/>">
			<%--向中调交令内容--%>
			<input type="hidden" name="ddDoutageplanDto.creturncontent"
				value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.creturncontent}"/>">
			<%--中调下令人--%>
			<input type="hidden" name="ddDoutageplanDto.csender"
				value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.csender}"/>">
			<%--市调接令人--%>
			<input type="hidden" name="ddDoutageplanDto.creceiver2"
				value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.creceiver2}"/>">
			<%--下令内容--%>
			<input type="hidden" name="ddDoutageplanDto.cmdcontent"
				value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.cmdcontent}"/>">
			<%--向中调回令人--%>
			<input type="hidden" name="ddDoutageplanDto.creturner"
				value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.creturner}"/>">
			<%--向中调回令时间--%>
			<input type="hidden" name="ddDoutageplanDto.creturntime"
				value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.creturntime}"/>">
			<%--中调收令人--%>
			<input type="hidden" name="ddDoutageplanDto.creceiver1"
				value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.creceiver1}"/>">

			<%--是否有效字段--%>
			<input type="hidden" name="ddDoutageplanDto.sys_isvalid"
				value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.sys_isvalid}"/>">

			<%--填写人--%>

			<input type="hidden" name="ddDoutageplanDto.sys_fille"
				value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.sys_fille}"/>">
			<%--填写单位--%>
			<input type="hidden" name="ddDoutageplanDto.sys_filldept"
				value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.sys_filldept}"/>">


			<%--填写时间--%>
			<input type="hidden" name="ddDoutageplanDto.sys_filltime"
				value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.sys_filltime}"/>">
			<%--数据所属单位--%>
			<input type="hidden" name="ddDoutageplanDto.sys_dataowner"
				value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.sys_dataowner}"/>">

			<%--电子章ids--%>
			<input type="hidden" name="ddDoutageplanDto.stampid"
				value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.stampid}"/>">
            
			
            <% 
            		
            		boolean  applay_flag = ResourceHelp.isHaveRes(DispatchResConstants.DDDOUTAGEPLAN_APPROVE);
            		boolean  applay_edit_flag = ResourceHelp.isHaveRes(DispatchResConstants.DDDOUTAGEPLAN_APPROVE_EDIT);
            		//可看的权限

            		if(applay_flag){
            %>
            <jhop:ctrlgroup
				ctrlId="UIControlGroupXPanel329efd278b0844faad4b05650e0f63fe"
				title="日计划申请">
			</jhop:ctrlgroup>
			     <% 
			            //可编辑的权限
			      		if(applay_edit_flag){
			     %>
			<table class="detailmain" cellspacing="0" cellpadding="0">
				<tr id="UIControlGroupXPanel329efd278b0844faad4b05650e0f63fe">
					<td align="center">
						<table class="detail" width="100%" height="100%" cellspacing="0">
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddDoutageplanDto.fapplyunit" />
									<%--申请单位--%>
								</td>
								<td height="23" width="30%">
									<input id="ddDoutageplanDto.fapplyunit"
										name="ddDoutageplanDto.fapplyunit" type="text"
										value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.fapplyunit}"/>"
										size="20" />
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddDoutageplanDto.fapplicant" />
									<%--申请人--%>
								</td>
								<td height="23" width="30%">
									<input id="ddDoutageplanDto.fapplicant"
										name="ddDoutageplanDto.fapplicant" type="text"
										value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.fapplicant}"/>"
										size="20" />
								</td>
							</tr>
							<tr>
							<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddDoutageplanDto.fapplytime" />
									<%--申请时间--%>
								</td>
								<td height="23" width="30%">
							        <% 
							           if(fapplytime==null){
							        
							        %>
							        	<jhop:date name="ddDoutageplanDto.fapplytime" genText="yes"
										dateFormat="yyyy-mm-dd"
										initValue=""></jhop:date>
							        <%}else{ %>
									<jhop:date name="ddDoutageplanDto.fapplytime" genText="yes"
										dateFormat="yyyy-mm-dd" 
										initValue="<%=fapplytime.toString() %>"></jhop:date>
									<%} %>
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddDoutageplanDto.fapplyoutagetime" />
									<%--申请停电时间--%>
									<span class="article_required">*</span>
								</td>
								<td height="23" width="30%">
								
									<%
							           if(fapplyoutagetime==null){
							        
							        %>
							           <jhop:dateselect name="ddDoutageplanDto.fapplyoutagetime"
										endName="ddDoutageplanDto.fapplyrestoretime" showSecond="true" 
										initValue=""
										dateFormat="yyyy-mm-dd hh:mm" group="start"></jhop:dateselect>
									
									<% }else{%>
										<jhop:dateselect name="ddDoutageplanDto.fapplyoutagetime"
										endName="ddDoutageplanDto.fapplyrestoretime" showSecond="true" 
										initValue="<%=fapplyoutagetime.toString() %>"
										dateFormat="yyyy-mm-dd hh:mm" group="start"></jhop:dateselect>
									
									<%} %>
								</td>
								
							</tr>
							<tr>
							<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddDoutageplanDto.fapplyrestoretime" />
									<%--申请发电时间--%>
									<span class="article_required">*</span>
								</td>
								<td height="23" width="30%">
								<%
							           

							           if(fapplyrestoretime==null){
							        
							        %>
									<jhop:dateselect name="ddDoutageplanDto.fapplyrestoretime"
										startName="ddDoutageplanDto.fapplyoutagetime" showSecond="true" 
										initValue=""
										dateFormat="yyyy-mm-dd hh:mm" group="end"></jhop:dateselect>
									<%}else{ %>
									
									<jhop:dateselect name="ddDoutageplanDto.fapplyrestoretime"
										startName="ddDoutageplanDto.fapplyoutagetime" showSecond="true" 
										initValue="<%=fapplyrestoretime.toString() %>"
										dateFormat="yyyy-mm-dd hh:mm" group="end"></jhop:dateselect>
									<%} %>
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddDoutageplanDto.fapplystime" />
									<%--申请工作起始时间--%>
									<span class="article_required">*</span>
								</td>
								<td height="23" width="30%">
								
								<%

							           if(fapplystime==null){
							        
							        %>
								
									<jhop:dateselect name="ddDoutageplanDto.fapplystime"  
										endName="ddDoutageplanDto.fapplyetime" 
										initValue=""  showSecond="true" 
										dateFormat="yyyy-mm-dd hh:mm" group="start"></jhop:dateselect>
									
									<%}else{ %>
									<jhop:dateselect name="ddDoutageplanDto.fapplystime"  
										endName="ddDoutageplanDto.fapplyetime" 
										initValue="<%=fapplystime.toString() %>"  showSecond="true" 
										dateFormat="yyyy-mm-dd hh:mm" group="start"></jhop:dateselect>
									<%} %>
								</td>
								
							</tr>

						
							<tr>

								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddDoutageplanDto.fapplyetime" />
									<%--申请工作结束时间--%>
									<span class="article_required">*</span>
								</td>
								<td height="23" width="30%">
								   <%
							         

							           if(fapplyetime==null){
							        
							        %>
									<jhop:dateselect name="ddDoutageplanDto.fapplyetime"
										startName="ddDoutageplanDto.fapplystime" showSecond="true" 
										initValue="" 
										dateFormat="yyyy-mm-dd hh:mm" group="end"></jhop:dateselect>
									<%}else{ %>
										<jhop:dateselect name="ddDoutageplanDto.fapplyetime"
										startName="ddDoutageplanDto.fapplystime" showSecond="true" 
										initValue="<%=fapplyetime.toString() %>" 
										dateFormat="yyyy-mm-dd hh:mm" group="end"></jhop:dateselect>
									<%} %>
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddDoutageplanDto.fplanclass" />
									<%--计划分类--%>
								</td>
								<td height="23" width="30%">
								   <%
								   
								   		if(fplanclass==null){
								    %>
									<jhop:select name="ddDoutageplanDto.fplanclass" hiddName=""
										type="fplanclass"
										initValue="">
									</jhop:select>
									<%}else{ %>
										<jhop:select name="ddDoutageplanDto.fplanclass" hiddName=""
										type="fplanclass"
										initValue="<%=fplanclass %>">
									</jhop:select>
									<%} %>
								</td>
							</tr>
							<tr>
							   <td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddDoutageplanDto.fdispatchrange" />
									<%--调度范围--%>
								</td>
								<td height="23" width="30%">
								        <%
								        	if(fdispatchrange==null){
								        	
								         %>
								        <input type="text" name="ddDoutageplanDto.fdispatchrange" value="">
										<img id="img1" src="<%=request.getContextPath()%>/themes/themes1/images/main/find.gif" onClick="showDispathUnit();">
										<%}else{ %>
								        <input type="text" name="ddDoutageplanDto.fdispatchrange" value="<%=fdispatchrange %>">
										<img id="img1" src="<%=request.getContextPath()%>/themes/themes1/images/main/find.gif" onClick="showDispathUnit();">
										<%} %>
									
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddDoutageplanDto.fline" />
									<%--线路名--%>
								</td>
								<td height="23" width="30%">
								    <%if(fline==null){ %>

										<input type="text" name="ddDoutageplanDto.fline" value="">
										</input>
										<img id="img1" src="<%=request.getContextPath()%>/themes/themes1/images/main/find.gif" onClick="setStdLineSelect();">
										
									<%}else{ %>
										<input type="text" name="ddDoutageplanDto.fline" value="<%=fline %>">
										<img id="img1" src="<%=request.getContextPath()%>/themes/themes1/images/main/find.gif" onClick="setStdLineSelect();">
									<%} %>
								</td>
								

							</tr>
							
                            <tr>
							   <td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddDoutageplanDto.fstationname" />
									<%--变电站--%>
								</td>
								<td height="23" width="30%">
									 <%if(fstationname==null){ %>
										<input type="text" name="ddDoutageplanDto.fstationname" value="">
										
										<img id="img1" src="<%=request.getContextPath()%>/themes/themes1/images/main/find.gif" onClick="setStdStationSelect();">
									<%}else{ %>
									<input type="text" name="ddDoutageplanDto.fstationname" value="<%=fstationname %>">
										
									<%} %>
								</td>

								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddDoutageplanDto.fvoltage" />
									<%--电压等级--%>
								</td>
								<td height="23" width="30%">
								   <%if(fvoltage==null){ %>
									<jhop:select name="ddDoutageplanDto.fvoltage" hiddName=""
										type="fvoltage"
										initValue="">
									</jhop:select>
									<%}else{ %>
										<jhop:select name="ddDoutageplanDto.fvoltage" hiddName=""
										type="fvoltage"
										initValue="<%=fvoltage %>">
									</jhop:select>
									<% }%>
								</td>
								

							</tr>

							
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddDoutageplanDto.foutagearea" />
									<%--停电范围--%>
									<span class="article_required">*</span>
								</td>
								<td height="23" width="30%" colspan="3">
									<textarea id='ddDoutageplanDto.foutagearea'
										name='ddDoutageplanDto.foutagearea' rows='3' cols='100'
										readonly='true' type="_moz"><c:out value="${ddDoutageplanForm.ddDoutageplanDto.foutagearea}"/></textarea>
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddDoutageplanDto.workcontent" />
									<%--工作内容--%>
									<span class="article_required">*</span>
								</td>
								<td height="23" width="30%" colspan="3">
									<textarea id='ddDoutageplanDto.workcontent'
										name='ddDoutageplanDto.workcontent' rows='3' cols='100'
										readonly='true' type="_moz"><c:out value="${ddDoutageplanForm.ddDoutageplanDto.workcontent}"/></textarea>
								</td>
							</tr>
							
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddDoutageplanDto.fworkarea" />
									<%--工作地点--%>
									<span class="article_required">*</span>
								</td>
								<td height="23" width="30%" colspan="3">
									<textarea id='ddDoutageplanDto.fworkarea'
										name='ddDoutageplanDto.fworkarea' rows='3' cols='100'
										readonly='true' type="_moz"><c:out value="${ddDoutageplanForm.ddDoutageplanDto.fworkarea}"/></textarea>
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddDoutageplanDto.faddipicture" />
									<%--附图--%>
								</td>
								<td height="23" width="80%" colspan="3">
									<jhop:upload name="faddipicture" multiValue="no"></jhop:upload>
								</td>

								
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddDoutageplanDto.fremark" />
									<%--备注--%>
								</td>
								<td height="23" width="80%" colspan="6">
									<textarea id='ddDoutageplanDto.fremark'
										name='ddDoutageplanDto.fremark' rows='3' cols='100' type="_moz"><c:out value="${ddDoutageplanForm.ddDoutageplanDto.fremark}"/></textarea>
								</td>
							</tr>
						</table>
					</td>
				</tr>

			</table>
			<% 
				}else{//不可编辑
			
			%>
			
	
			<table class="detailmain" cellspacing="0" cellpadding="0">
				<tr id="UIControlGroupXPanel329efd278b0844faad4b05650e0f63fe">
					<td align="center">
						<table class="detail" width="100%" height="100%" cellspacing="0">
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddDoutageplanDto.fapplyunit" />
									<%--申请单位--%>
								</td>
								<td height="23" width="30%">
									<input id="ddDoutageplanDto.fapplyunit"
										name="ddDoutageplanDto.fapplyunit" type="text"
										value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.fapplyunit}"/>"
										size="20"  readonly='true'/>
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddDoutageplanDto.fapplicant" />
									<%--申请人--%>
								</td>
								<td height="23" width="30%">
									<input id="ddDoutageplanDto.fapplicant"
										name="ddDoutageplanDto.fapplicant" type="text"
										value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.fapplicant}"/>"
										size="20"  readonly='true'/>
								</td>
							</tr>
							<tr>
							<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddDoutageplanDto.fapplytime" />
									<%--申请时间--%>
								</td>
								<td height="23" width="30%">
							       <input id="ddDoutageplanDto.fapplytime"
										name="ddDoutageplanDto.fapplytime" type="text"
										value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.fapplytime}"/>"
										size="20"  readonly='true'/>
							        	
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddDoutageplanDto.fapplyoutagetime" />
									<%--申请停电时间--%>
									
								</td>
								<td height="23" width="30%">
								
									<input id="ddDoutageplanDto.fapplyoutagetime"
										name="ddDoutageplanDto.fapplyoutagetime" type="text"
										value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.fapplyoutagetime}"/>"
										size="20"  readonly='true'/>
							         
								</td>
								
							</tr>
							<tr>
							<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddDoutageplanDto.fapplyrestoretime" />
									<%--申请发电时间--%>
									
								</td>
								<td height="23" width="30%">
								<input id="ddDoutageplanDto.fapplyrestoretime"
										name="ddDoutageplanDto.fapplyrestoretime" type="text"
										value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.fapplyrestoretime}"/>"
										size="20"  readonly='true'/>
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddDoutageplanDto.fapplystime" />
									<%--申请工作起始时间--%>
									
								</td>
								<td height="23" width="30%">
								
								<input id="ddDoutageplanDto.fapplystime"
										name="ddDoutageplanDto.fapplystime" type="text"
										value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.fapplystime}"/>"
										size="20"  readonly='true'/>
									
								</td>
								
							</tr>

						


							<tr>

								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddDoutageplanDto.fapplyetime" />
									<%--申请工作结束时间--%>
									<span class="article_required">*</span>
								</td>
								<td height="23" width="30%">
								<input id="ddDoutageplanDto.fapplyetime"
										name="ddDoutageplanDto.fapplyetime" type="text"
										value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.fapplyetime}"/>"
										size="20"  readonly='true'/>
									
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddDoutageplanDto.fplanclass" />
									<%--计划分类--%>
								</td>
								<td height="23" width="30%">
								  <input id="ddDoutageplanDto.fplanclass"
										name="ddDoutageplanDto.fplanclass" type="text"
										value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.fplanclass}"/>"
										size="20"  readonly='true'/>
								</td>
							</tr>

							<tr>
							   <td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddDoutageplanDto.fdispatchrange" />
									<%--调度范围--%>
								</td>
								<td height="23" width="30%">
							
										  <input id="ddDoutageplanDto.fdispatchrang"
										name="ddDoutageplanDto.fdispatchrang" type="text"
										value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.fdispatchrange}"/>"
										size="20"  readonly='true'/>  
										
								</td>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddDoutageplanDto.fline" />
									<%--线路名--%>
								</td>
								<td height="23" width="30%">
								   <input id="ddDoutageplanDto.fline"
										name="ddDoutageplanDto.fline" type="text"
										value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.fline}"/>"
										size="20"  readonly='true'/>
										
								</td>
								

							</tr>


							<tr>
							   <td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddDoutageplanDto.fstationname" />
									<%--变电站--%>
								</td>
								<td height="23" width="30%">
									  <input id="ddDoutageplanDto.fstationname"
										name="ddDoutageplanDto.fstationname" type="text"
										value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.fstationname}"/>"
										size="20"  readonly='true'/>
										
								
								</td>

								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddDoutageplanDto.fvoltage" />
									<%--电压等级--%>
								</td>
								<td height="23" width="30%">
								   <input id="ddDoutageplanDto.fvoltage"
										name="ddDoutageplanDto.fvoltage" type="text"
										value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.fvoltage}"/>"
										size="20"  readonly='true'/>
								</td>
								

							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddDoutageplanDto.foutagearea" />
									<%--停电范围--%>
									
								</td>
								<td height="23" width="30%" colspan="3">
									<textarea id='ddDoutageplanDto.workcontent'
										name='ddDoutageplanDto.workcontent' rows='3' cols='100'
										readonly='true' type="_moz"><c:out value="${ddDoutageplanForm.ddDoutageplanDto.workcontent}"/></textarea>
								</td>
							</tr>
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddDoutageplanDto.workcontent" />
									<%--工作内容--%>
									
								</td>
								<td height="23" width="30%" colspan="3">
									<textarea id='ddDoutageplanDto.foutagearea'
										name='ddDoutageplanDto.foutagearea' rows='3' cols='100'
										readonly='true' type="_moz"><c:out value="${ddDoutageplanForm.ddDoutageplanDto.foutagearea}"/></textarea>
								</td>
							</tr>
							
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddDoutageplanDto.fworkarea" />
									<%--工作地点--%>
									
								</td>
								<td height="23" width="30%" colspan="3">
									<textarea id='ddDoutageplanDto.fworkarea'
										name='ddDoutageplanDto.fworkarea' rows='3' cols='100'
										readonly='true' type="_moz"><c:out value="${ddDoutageplanForm.ddDoutageplanDto.fworkarea}"/></textarea>
								</td>
							</tr>
							
	
							<tr>
								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddDoutageplanDto.fremark" />
									<%--备注--%>
								</td>
								<td height="23" width="80%" colspan="6">
									<textarea id='ddDoutageplanDto.fremark'
										name='ddDoutageplanDto.fremark' rows='3' cols='100' type="_moz" readonly='true'><c:out value="${ddDoutageplanForm.ddDoutageplanDto.fremark}"/></textarea>
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
			   
			    if(ddDoutageplanDto!=null){
			        boolean  modelchangeflag =  ResourceHelp.isHaveRes(DispatchResConstants.DDDOUTAGEPLAN_MODECHANGE);
					if(modelchangeflag){ //可见
						boolean   modelchangedit = ResourceHelp.isHaveRes(DispatchResConstants.DDDOUTAGEPLAN_MODECHANGE_EDIT);
						boolean   modelchangdelete = ResourceHelp.isHaveRes(DispatchResConstants.DDDOUTAGEPLAN_MODECHANGE_DELETE);
			%>
				
			<jhop:ctrlgroup
				ctrlId="UIControlGroupXPanelac9ff0c612e7436ab2da51151b3a499d"
				title="方式变更" isEdit="yes">
                
                       <% if(modelchangedit){%>
							<img name='add'
								src="<%=request.getContextPath()%>/themes/themes1/images/main/new.gif"
								onClick="iGrid.mygrid.addNewRow()">
							<img name='save'
								src="<%=request.getContextPath()%>/themes/themes1/images/main/save.gif"
								onClick="saveDTOS('<%=request.getContextPath()%>/ddDoutageplan.do?method=saveModechangeGrid',iGrid.mygrid,false,'<%=request.getContextPath()%>/application/dddoutageplan/modechangevalidate.xml','modechange',true)">
						<%  
						}
						if(modelchangdelete){
						
						%>

							<img name='del'
								src="<%=request.getContextPath()%>/themes/themes1/images/main/delete.gif"
								onClick="deleteDTOS('<%=request.getContextPath()%>/ddDoutageplan.do?method=deleteModechangeGrid',iGrid.mygrid,'fid','version')">
				       <%} %>
			</jhop:ctrlgroup>

			<table class="detailmain" cellspacing="0" height="150"
				cellpadding="0"
				id="UIControlGroupXPanelac9ff0c612e7436ab2da51151b3a499d">
				<tr>
					<td align="center" height="150">
					    
						<iframe name="iGrid" frameborder='0' width="100%" 　scrolling="no"
							height="150"
							src='<%=request.getContextPath()%>/application/dddoutageplan/DDdayoutageplan_ddrmchang_grid.jsp?parentid=<%=ddDoutageplanDto.getFdayplanno() %>&edit=<%=modelchangedit %>&delete=<%=modelchangdelete %>'></iframe>

					</td>
				</tr>
			</table>
		
			<%
					} 
				}
			
			%>
				
				
				
	
		
			<%
				 if(ddDoutageplanDto.getFdayplanno()!=null){ 
			      	boolean   confirmflag =  ResourceHelp.isHaveRes(DispatchResConstants.DDDOUTAGEPLAN_CONFIRM);
			      	if(confirmflag){
			      		boolean confirmedit= ResourceHelp.isHaveRes(DispatchResConstants.DDDOUTAGEPLAN_CONFIRM_EDIT);
			      		
			
			%>
							<jhop:ctrlgroup name="aprrove"
								ctrlId="UIControlGroupXPanelebc3d44793cf45c5b0689e7b5a59674f"
								title="批准情况" isEdit="yes">
								<%if(confirmedit){ %>
								<img name='save'
									src="<%=request.getContextPath()%>/themes/themes1/images/main/save.gif"
									onClick="onSaveApprove('<%=request.getContextPath()%>')">
								<%} %>
							</jhop:ctrlgroup>
							<%
							
							
								if(confirmedit){ 
							        java.sql.Timestamp fapproworkstime =  ddDoutageplanDto.getFapproworkstime();
							        java.sql.Timestamp fapproworketime = ddDoutageplanDto.getFapproworketime();
							        java.sql.Timestamp fapprostime = ddDoutageplanDto.getFapprostime();
									java.sql.Timestamp fapproetime = ddDoutageplanDto.getFapproetime();
							%>
							<table class="detailmain" cellspacing="0" cellpadding="0">
								<tr id="UIControlGroupXPanelebc3d44793cf45c5b0689e7b5a59674f">
									<td align="center">
										<table class="detail" width="100%" height="100%" cellspacing="0">
											
											<tr>
												<td height="23" class="tab_0" width="20%">
													<bean:message key="object.ddDoutageplanDto.fapprooutageword" />
													<%--批准停电字--%>
												</td>
												<td height="23" width="30%">
													<input id="ddDoutageplanDto.fapprooutageword"
														name="ddDoutageplanDto.fapprooutageword" type="text"
														value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.fapprooutageword}"/>"
														size="20" />
												</td>
												<td height="23" class="tab_0" width="20%">
													<bean:message key="object.ddDoutageplanDto.fapprooutageno" />
													<%--批准停电号--%>
												</td>
												<td height="23" width="30%">
													<input id="ddDoutageplanDto.fapprooutageno"
														name="ddDoutageplanDto.fapprooutageno" type="text"
														value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.fapprooutageno}"/>"
														size="20" />
												</td>
											</tr>
											

											<tr>
												<td height="23" class="tab_0" width="20%">
													<bean:message key="object.ddDoutageplanDto.fapproworkstime" />
													<%--批准工作开始时间--%>
												</td>
												<td height="23" width="30%">
												   <%if(fapproworkstime==null){%>
												   			<jhop:dateselect name="ddDoutageplanDto.fapproworkstime"
												   		endName="ddDoutageplanDto.fapproworketime"  group="start"
														 dateFormat="yyyy-mm-dd hh:mm"  showSecond="true" 
														initValue=""></jhop:dateselect>
												   <%}else{%>
												   		<jhop:dateselect name="ddDoutageplanDto.fapproworkstime"
												   		endName="ddDoutageplanDto.fapproworketime" group="start"
														dateFormat="yyyy-mm-dd hh:mm"  showSecond="true" 
														initValue="<%=fapproworkstime.toString() %>"></jhop:dateselect>
												   <%} %>
												
												</td>
												<td height="23" class="tab_0" width="20%">
													<bean:message key="object.ddDoutageplanDto.fapproworketime" />
													<%--批准工作结束时间--%>
												</td>
												<td height="23" width="30%">
												<%if(fapproworketime==null){ %>
													<jhop:dateselect name="ddDoutageplanDto.fapproworketime" group="end"
														 dateFormat="yyyy-mm-dd hh:mm"  showSecond="true"  
														startName="ddDoutageplanDto.fapproworkstime"
														initValue=""></jhop:dateselect>
												<%}else{ %>
													<jhop:dateselect name="ddDoutageplanDto.fapproworketime" group="end"
														 dateFormat="yyyy-mm-dd hh:mm"  showSecond="true" 
														startName="ddDoutageplanDto.fapproworkstime"
														initValue="<%=fapproworketime.toString() %>"></jhop:dateselect>
												<%} %>
												</td>
											</tr>
											<tr>
												<td height="23" class="tab_0" width="20%">
													<bean:message key="object.ddDoutageplanDto.fapprostime" />
													<%--批准停电开始时间--%>
												</td>
												<td height="23" width="30%">
												<%if(fapprostime==null){ %>
													<jhop:dateselect name="ddDoutageplanDto.fapprostime" 
														endName="ddDoutageplanDto.fapproetime"  group="start"
														dateFormat="yyyy-mm-dd hh:mm"   showSecond="true"  
														initValue=""></jhop:dateselect>
												<%}else{ %>
													<jhop:dateselect name="ddDoutageplanDto.fapprostime"
													    endName="ddDoutageplanDto.fapproetime"  group="start"
														dateFormat="yyyy-mm-dd hh:mm"   showSecond="true" 
														initValue="<%=fapprostime.toString() %>"></jhop:dateselect>
												<%} %>
												</td>
												<td height="23" class="tab_0" width="20%">
													<bean:message key="object.ddDoutageplanDto.fapproetime" />
													<%--批准停电结束时间--%>
												</td>
												<td height="23" width="30%">
												    <%if(fapproetime==null){ %>
														<jhop:dateselect name="ddDoutageplanDto.fapproetime" group="end"
															startName="ddDoutageplanDto.fapprostime"
															dateFormat="yyyy-mm-dd hh:mm"  showSecond="true" 
															initValue=""></jhop:dateselect>
													<%}else{ %>
														<jhop:dateselect name="ddDoutageplanDto.fapproetime" group="end"
														 dateFormat="yyyy-mm-dd hh:mm"  showSecond="true" 
														 startName="ddDoutageplanDto.fapprostime"
														initValue="<%=fapproetime.toString() %>"></jhop:dateselect>
													<%} %>
													
												
												</td>
											</tr>
			                                  <tr>
												<td height="23" class="tab_0" width="20%">
													<bean:message key="object.ddDoutageplanDto.fattention" />
													<%--注意事项--%>
												</td>
												<td height="23" width="30%" colspan="3">
													<textarea id='ddDoutageplanDto.fattention'
														name='ddDoutageplanDto.fattention' rows='3' cols='100'
														type="_moz"><c:out value="${ddDoutageplanForm.ddDoutageplanDto.fattention}"/></textarea>
												</td>
											</tr>
			
										</table>
									</td>
								</tr>
							</table>
							
				    <%}else{ %>
			
			              <table class="detailmain" cellspacing="0" cellpadding="0">
								<tr id="UIControlGroupXPanelebc3d44793cf45c5b0689e7b5a59674f">
									<td align="center">
										<table class="detail" width="100%" height="100%" cellspacing="0">
											
											<tr>
												<td height="23" class="tab_0" width="20%">
													<bean:message key="object.ddDoutageplanDto.fapprooutageword" />
													<%--批准停电字--%>
												</td>
												<td height="23" width="30%">
													<input id="ddDoutageplanDto.fapprooutageword"
														name="ddDoutageplanDto.fapprooutageword" type="text" readonly='true'
														value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.fapprooutageword}"/>"
														size="20" />
												</td>
												<td height="23" class="tab_0" width="20%">
													<bean:message key="object.ddDoutageplanDto.fapprooutageno" />
													<%--批准停电号--%>
												</td>
												<td height="23" width="30%">
													<input id="ddDoutageplanDto.fapprooutageno" readonly='true'
														name="ddDoutageplanDto.fapprooutageno" type="text"
														value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.fapprooutageno}"/>"
														size="20" />
												</td>
											</tr>
											
											
											
											
											
											
											<tr>
												<td height="23" class="tab_0" width="20%">
													<bean:message key="object.ddDoutageplanDto.fapproworkstime" />
													<%--批准工作开始时间--%>
												</td>
												<td height="23" width="30%">
													
													<input id="ddDoutageplanDto.fapproworkstime" readonly='true'
														name="ddDoutageplanDto.fapproworkstime" type="text"
														value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.fapproworkstime}"/>"
														size="20" />
												</td>
												<td height="23" class="tab_0" width="20%">
													<bean:message key="object.ddDoutageplanDto.fapproworketime" />
													<%--批准工作结束时间--%>
												</td>
												<td height="23" width="30%">
												<input id="ddDoutageplanDto.fapproworketime" readonly='true'
														name="ddDoutageplanDto.fapproworketime" type="text"
														value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.fapproworketime}"/>"
														size="20" />
												</td>
											</tr>
											<tr>
												<td height="23" class="tab_0" width="20%">
													<bean:message key="object.ddDoutageplanDto.fapprostime" />
													<%--批准停电开始时间--%>
												</td>
												<td height="23" width="30%">
												<input id="ddDoutageplanDto.fapprostime" readonly='true'
														name="ddDoutageplanDto.fapprostime" type="text"
														value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.fapprostime}"/>"
														size="20" />
													
												</td>
												<td height="23" class="tab_0" width="20%">
													<bean:message key="object.ddDoutageplanDto.fapproetime" />
													<%--批准停电结束时间--%>
												</td>
												<td height="23" width="30%">
												<input id="ddDoutageplanDto.fapproetime" readonly='true'
														name="ddDoutageplanDto.fapproetime" type="text"
														value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.fapproetime}"/>"
														size="20" />
													
													
												</td>
											</tr>
			                                  <tr>
												<td height="23" class="tab_0" width="20%">
													<bean:message key="object.ddDoutageplanDto.fattention" />
													<%--注意事项--%>
												</td>
												<td height="23" width="30%" colspan="3">
													<textarea id='ddDoutageplanDto.fattention'　readonly='true'
														name='ddDoutageplanDto.fattention' rows='3' cols='100'
														type="_moz"><c:out value="${ddDoutageplanForm.ddDoutageplanDto.fattention}"/></textarea>
												</td>
											</tr>
			
										</table>
									</td>
								</tr>
							</table>
			
			
			<%	
					}
				}
				 
			  } 
			%>
			
			
	   <table>
			<tr>
				<td height="8"></td>
			</tr>
		</table>
		
		
		<% 
		   if(ddDoutageplanDto.getFdayplanno()!=null){ 
			      	boolean   checkshow =  ResourceHelp.isHaveRes(DispatchResConstants.DDDOUTAGEPLAN_CHECK); 
			      	
		    	    if(checkshow){ 
		    	    	boolean  checkedit=ResourceHelp.isHaveRes(DispatchResConstants.DDDOUTAGEPLAN_CHECK_EDIT); 
		    	    	//checkedit = true;
		%> 
		<jhop:ctrlgroup ctrlId="rjhhc" title="日计划核查" isEdit="yes">
		      <%if(checkedit){ %>
			<img name='save'
				src="<%=request.getContextPath()%>/themes/themes1/images/main/save.gif"
				onClick="checkup()">
				<%} %>
		</jhop:ctrlgroup>
                 <%
                 
                 	
                 		//可编辑

		    	    	if(checkedit){
                  %>
					<table class="detailmain" cellspacing="0" height="40" cellpadding="0"
						id="rjhhc">
						<tr>
			
							<td height="23" class="tab_0" width="20%">
			
								是否合格
			
							</TD>
							<td height="23" width="30%">
							    <%if(ispassed==null){ %>
									<jhop:select name="ddDoutageplanDto.ispassed"
														hiddName="" type="fiswriteinwglog"
														initValue="是@@@是^是#否^否">
									</jhop:select>
								<%}else{    String isp =  ispassed+"@@@是#否";   %>
									<jhop:select name="ddDoutageplanDto.ispassed"
														hiddName="" type="fiswriteinwglog"
														initValue="<%=isp%>">
									</jhop:select>
								<%} %>
							</td>
							<td height="23" class="tab_0" width="20%">
							
								不合格原因

			
							</td>
							<td height="23" width="30%">
								<input type="text" size="20" name="ddDoutageplanDto.reason"
									id="ddDoutageplanDto.reason"
									value='<c:out value="${ddDoutageplanForm.ddDoutageplanDto.reason}"/>'>
							</td>
						</tr>
			
					</table>
					<% }else{%>
					
						<table class="detailmain" cellspacing="0" height="40" cellpadding="0"
						id="rjhhc">
						<tr>
			
							<td height="23" class="tab_0" width="20%">
			
								是否合格
			
							</TD>
							<td height="23" width="30%">
								
									<input type="text" size="20" name="ddDoutageplanDto.ispassed"
									id="ddDoutageplanDto.ispassed"　　　readonly='true'
									value='<c:out value="${ddDoutageplanForm.ddDoutageplanDto.ispassed}"/>'>
							</td>
							<td height="23" class="tab_0" width="20%">
							
								不合格原因

			
							</td>
							<td height="23" width="30%">
								<input type="text" size="20" name="ddDoutageplanDto.reason"
									id="ddDoutageplanDto.reason"　　　readonly='true'
									value='<c:out value="${ddDoutageplanForm.ddDoutageplanDto.reason}"/>'>
							</td>
						</tr>
			
					</table>
		
		<%
					}
		
				} 
				
			}
		%>
					
		</form>
	</body>
<script>

		 function  checkup(){
	  	var  id= document.getElementById('ddDoutageplanDto.fdayplanno').value;
	  	alert("id="+id);
	    var  version = document.getElementById('ddDoutageplanDto.version').value;
	    var  ispass = document.getElementById('ddDoutageplanDto.ispassed').value;
	    var  reason = document.getElementById('ddDoutageplanDto.reason').value;
	    para = 'id='+id+'&version='+version+'&ispass='+ispass+'&reason='+reason;
		 var url="<%=request.getContextPath()%>/ddDoutageplan.do?method=dayPlanCheckup";
		        var myAjax = new Ajax.Request(url,{method: 'post', parameters: para,  onComplete: showResponse});
			     function showResponse(originalRequest){
		            var savesucces = originalRequest.responseText;
		            var mess = savesucces.split('\^');
		            if(mess[0]=='1'){
		            	dealAlertMessage2("保存核查成功");
		            	var  ver  = document.getElementById("ddDoutageplanDto.version");
		            	ver.value=mess[1];
		            	
		            	}
		            else{
		            	alert("保存核查失败");
		            	}
		         }
	  }
	  
	  
	  
function dealAlertMessage2(message){
	parent.message_mask.style.visibility='visible';
	parent.message_box.style.visibility='visible'
	parent.document.getElementById("mainMessage").innerText = message;
}
</script>
</html>
