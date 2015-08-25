<%@ page contentType="text/html; charset=utf-8" language="java" buffer="18kb"%>
<%@ page import="java.util.Map"%>

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
		String coopnum = (String)request.getAttribute("coopnum");
		String fexstatus =ddDoutageplanDto.getFexcutestatus();
		String fdayplanno = ddDoutageplanDto.getFdayplanno();
        String stampid=ddDoutageplanDto.getStampid();
        java.sql.Timestamp csendtime = ddDoutageplanDto.getCsendtime();
        java.sql.Timestamp creturntime = ddDoutageplanDto.getCreturntime();
        
        java.sql.Timestamp fapplystime  = ddDoutageplanDto.getFapplystime();
        
        java.sql.Timestamp fapplyoutagetime  = ddDoutageplanDto.getFapplyoutagetime();
 %>


 
<html>
	<head>
		<html:base />
		<title>日计划执行详情</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="../../themes/themes1/style.css" rel="stylesheet"
			type="text/css" />
		<%@ include file="/common/init_js.jsp"%>
		<%@ include file="/common/init_date.jsp"%>
	</head>
	<body bgcolor="#ffffff">
        
		<form name="ddDoutageplanForm" action="" method="post">
			<%--hidden--%>
			<input type="hidden" name="ddDoutageplanDto.fdayplanno"
				id='ddDoutageplanDto.fdayplanno'
				value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.fdayplanno}"/>">
			<input type="hidden" name="ddDoutageplanDto.version"
				id='ddDoutageplanDto.version'
				value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.version}"/>">

			<input type="hidden" name="ddDoutageplanDto.stampid"
				id='ddDoutageplanDto.stampid'
				value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.stampid}"/>">
			
			
			<input type="hidden" name="ddDoutageplanDto.fexcutestatus"
				id='ddDoutageplanDto.fexcutestatus'
				value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.fexcutestatus}"/>">
			
			<jhop:ctrlgroup
				ctrlId="UIControlGroupXPanel2941c258bf014ce0b83a7c5da5440e8a"
				title="基本信息">

			</jhop:ctrlgroup>

			<table class="detailmain" cellspacing="0" cellpadding="0">
				<tr id="UIControlGroupXPanel2941c258bf014ce0b83a7c5da5440e8a">
					<td align="center">
						<table class="detail" width="100%" height="100%" cellspacing="0">
							<TR>
								<td height="23" class="tab_0" width="12%">
									<bean:message key="object.ddDoutageplanDto.fmanualno" />
									<%--日计划编号--%>
								</td>
								<td height="23" width="38%">
									<c:out value="${ddDoutageplanForm.ddDoutageplanDto.fmanualno}"/>
								</td>
								<td height="23" class="tab_0" width="12%">
									<bean:message key="object.ddDoutageplanDto.fworkarea" />
									<%-- 工作地点 --%>
								</TD>
								<td height="23" width="38%">
									<c:out value="${ddDoutageplanForm.ddDoutageplanDto.fworkarea}"/>
								</td>
							</TR>

							<TR>
								<TD class="tab_0">

									<bean:message key="object.ddDoutageplanDto.planeworktime" />
									<%-- 计划工作时间 --%>
								</TD>
								<TD>
								    <%if(fapplystime!=null){ %>
									<c:out value="${ddDoutageplanForm.ddDoutageplanDto.fapplystime}"/>
									<bean:message key="object.ddDoutageplanDto.to" />
									<%} %>
									<%-- 到 --%>
									<c:out value="${ddDoutageplanForm.ddDoutageplanDto.fapplyetime}"/>
								</TD>
								<TD class="tab_0">
									<bean:message key="object.ddDoutageplanDto.planecuttime" />
									<%-- 计划停电时间 --%>

								</TD>
								<TD>
								  <%if(fapplyoutagetime!=null){ %>
									<c:out value="${ddDoutageplanForm.ddDoutageplanDto.fapplyoutagetime}"/>
									<bean:message key="object.ddDoutageplanDto.to" />
									<%} %>
									<%-- 到 --%>
									<c:out value="${ddDoutageplanForm.ddDoutageplanDto.fapplyrestoretime}"/>
								</TD>
							</TR>
						</table>
					</td>
				</tr>
			</table>
		</form>
		<%
			//判断日计划编号是否为空
			if(fdayplanno!=null){
		 %>
		<table>
			<tr>
				<td height="8"></td>
			</tr>
		</table>
		<%
			
				boolean stampflag =  ResourceHelp.isHaveRes(DispatchResConstants.DDDOUTAGEPLAN_STAMP); 
				if(stampflag){
					boolean stampedit = ResourceHelp.isHaveRes(DispatchResConstants.DDDOUTAGEPLAN_STAMP_EDIT); 
					
		%>
		<jhop:ctrlgroup ctrlId="ffff" title="电子章" isEdit="yes">
		   <%if(stampedit){ %>
		   	<%if(coopnum.equals("0")){ %>
			<img name='add' alt="查询配合"
				src="<%=request.getContextPath()%>/themes/themes1/images/main/mag.gif"
				onClick="showCooperater()">
				<%} %>
			<img name='save' alt ="盖电子章"
				src="<%=request.getContextPath()%>/themes/themes1/images/main/iconTask.gif"
				onClick="showgraf()">
			<img name='del' alt="删除电子章"
				src="<%=request.getContextPath()%>/themes/themes1/images/main/delete.gif"
				onClick="deletegraf()">
			<%} %>
		</jhop:ctrlgroup>
       
		<table class="detailmain" cellspacing="0" cellpadding="0" id="ffff">
			<tr id="qqq">
				<td colspan="0">
					<table class="" align="center" width="100%">
						<tr>
							<td height="50" width="20%" align="center">
								<table width="143" height="50" border="0" cellpadding="0"
									cellspacing="0">
									<tr>
										<td background="stamp/chart12.jpg">
											<span id='coopspan'
												style="padding-left:103px; font-weight:bold; color:#FF0000"><%=coopnum %></span>
										</td>
									</tr>
								</table>

							</td>
							<td>
						
								<iframe id="coprrerateIframe"
									src="<%=request.getContextPath()%>/application/dddoutageplan/DDdayoutageplan_copperate_grid.jsp?edit=<%=stampedit%>&planid=<%=fdayplanno %>"
									width="100%" height="100" frameborder="0" scrolling="yes"></iframe>
						
							</td>
						</tr>

					</table>
				</td>
			</tr>

			<tr id="sss">
				<td colspan="0">
					<table class="" align="center" width="100%">

						<tr valign="middle">
							<td>
								<iframe name="graf"
									src="<%=request.getContextPath()%>/ddDoutageplan.do?method=loadstamps&ids=<%=stampid %>&edit=<%=stampedit %>"
									width="100%" height="40" frameborder="0" scrolling="no"></iframe>
							</td>

						</tr>
					</table>
				</td>
			</tr>
	
		</table>
	
      <%
      	} 
      %>
		<table height="8">
			<tr>
				<td height="8"></td>
			</tr>
		</table>
        <%
        
             boolean orderflag = ResourceHelp.isHaveRes(DispatchResConstants.DDDOUTAGEPLAN_ORDER); 
             boolean orderedit = ResourceHelp.isHaveRes(DispatchResConstants.DDDOUTAGEPLAN_ORDER_EDIT1);
        	 boolean orderdelete = ResourceHelp.isHaveRes(DispatchResConstants.DDDOUTAGEPLAN_ORDER_DELETE);
        	 boolean ordercancle =  ResourceHelp.isHaveRes(DispatchResConstants.DDDOUTAGEPLAN_ORDER_CANCLEREASON_EDIT);
        	if(orderflag){
         %>
		<jhop:ctrlgroup ctrlId="xialingshouling" title="下令收令情况" isEdit="yes">
		    <%if(orderedit){ %>
			<img name='add'
				src="<%=request.getContextPath()%>/themes/themes1/images/main/new.gif"
				onClick="xlgrid.mygrid.addNewRow()">
			<img name='save'
				src="<%=request.getContextPath()%>/themes/themes1/images/main/save.gif"
				onClick="saveDTOS('<%=request.getContextPath()%>/ddDoutageplan.do?method=saveExecuteGrid',xlgrid.mygrid,false,'<%=request.getContextPath()%>/application/dddoutageplan/modechangevalidate.xml','modechange')">
			<%} %>
			<%if(orderdelete){ %>
			<img name='del'
				src="<%=request.getContextPath()%>/themes/themes1/images/main/delete.gif"
				onClick="deleteDTOS('<%=request.getContextPath()%>/ddDoutageplan.do?method=deleteExecuteGrid',xlgrid.mygrid,'fid','version')">
			<%} %>
		</jhop:ctrlgroup>

		<table class="detailmain" cellspacing="0" height="150" cellpadding="0"
			id="xialingshouling">
			<tr>
				<td align="center" height="150">
					<iframe name="xlgrid" frameborder='0' width="100%" 　scrolling="no"
						height="150" src=''></iframe>

				</td>
			</tr>
			<tr>
				<td align="left" width="100%">
					取消原因：
                     
					<input type="hidden" name="ddDoutageplanDto.cancelcode"
						id="ddDoutageplanDto.cancelcode"
						value='<c:out value="${ddDoutageplanForm.ddDoutageplanDto.cancelcode}"/>'>
					<%if(ordercancle){ %>
					<input type="text" size="80" name="ddDoutageplanDto.fabolishReason"
						id="ddDoutageplanDto.fabolishReason"
						value='<c:out value="${ddDoutageplanForm.ddDoutageplanDto.fabolishReason}"/>'>
					<img name=''
						src="<%=request.getContextPath()%>/themes/themes1/images/main/mag.gif"
						onClick="showSystemdic()">
					<input type="button" name="Submit2" value="盖取消章" onclick="cancle()">
					<%}else{ %>
					<input type="text" size="80" name="ddDoutageplanDto.fabolishReason"
						id="ddDoutageplanDto.fabolishReason" onFocus="this.blur()" 
						value='<c:out value="${ddDoutageplanForm.ddDoutageplanDto.fabolishReason}"/>'>
					<%} %>
				</td>
			</tr>
		</table>
        <%} %>


		<table>
			<tr>
				<td height="8"></td>
			</tr>
		</table>
		<%
		
				boolean  report = ResourceHelp.isHaveRes(DispatchResConstants.DDDOUTAGEPLAN_REPORT);
				if(report){
					boolean  reqporedit = ResourceHelp.isHaveRes(DispatchResConstants.DDDOUTAGEPLAN_REPORT_EDIT);
		 %>
		<jhop:ctrlgroup ctrlId="zdml" title="中调命令" isEdit="yes">
		   <%if(reqporedit){%>
			<img name='save'
				src="<%=request.getContextPath()%>/themes/themes1/images/main/save.gif"
				onClick="savezd()">
			<%} %>
		</jhop:ctrlgroup>
		<form method="post" name="zdmlform" action="">
			<table class="detailmain" cellspacing="0" cellpadding="0">
				<tr id="zdml">
					<td align="center" colspan="4">
						<TABLE class="detail" width="100%" height="100%" cellspacing="0">
							<TBODY>
							    <%if(reqporedit){%>
								<TR>
									<TD width="13%" bgcolor="#f6f6f6">
										<%--中调下令时间--%>
										<bean:message key="object.ddDoutageplanDto.csendtime" />
									</TD>
									<TD width="20%">
									   <%if(csendtime==null){ %>
										<jhop:dateselect name="ddDoutageplanDto.csendtime"
											endName="ddDoutageplanDto.creturntime"  showSecond="true" 
											initValue=""
											dateFormat="yyyy-mm-dd hh:mm" group="start"></jhop:dateselect>
										<%}else{ %>
										<jhop:dateselect name="ddDoutageplanDto.csendtime"
											endName="ddDoutageplanDto.creturntime"  showSecond="true" 
											initValue="<%=csendtime.toString() %>"
											dateFormat="yyyy-mm-dd hh:mm" group="start"></jhop:dateselect>
										<%} %>
									</TD>
									<TD width="13%" bgcolor="#f6f6f6">
										<%--中调下令人--%>
										<bean:message key="object.ddDoutageplanDto.csender" />

									</TD>
									<TD width="20%">
										<input type=text name="ddDoutageplanDto.csender"
											id="ddDoutageplanDto.csender" size=16
											value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.csender}"/>">
										<img name=''
											src="<%=request.getContextPath()%>/themes/themes1/images/main/mag.gif"
											onClick="showGGreperson('ddDoutageplanDto.csender')">
									</TD>
									<TD width="13%" bgcolor="#f6f6f6">
										<%--市调接令人姓名--%>
										<bean:message key="object.ddDoutageplanDto.creceiver2" />

									</TD>
									<TD width="20%">
										<input type=text name="ddDoutageplanDto.creceiver2"
											id="ddDoutageplanDtocreceiver2" size=16
											value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.creceiver2}"/>">
											
										<img name=''
											src="<%=request.getContextPath()%>/themes/themes1/images/main/mag.gif"
											onClick="showGGperson('ddDoutageplanDtocreceiver2')">
									</TD>
								</TR>
								<TR>
									<TD bgcolor="#f6f6f6">
										<%--中调下令内容--%>
										<bean:message key="object.ddDoutageplanDto.cmdcontent" />
									</TD>
									<TD colSpan=5>
										<input type=text name="ddDoutageplanDto.cmdcontent"
											id="ddDoutageplanDto.cmdcontent" size=100
											value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.cmdcontent}"/>">
									</TD>
								</TR>
								<TR>
									<TD width="13%" bgcolor="#f6f6f6">
										<%--向中调交令时间--%>
										<bean:message key="object.ddDoutageplanDto.creturntime" />

									</TD>
									<TD width="20%">
									   <%if(creturntime==null){ %>
										<jhop:dateselect name="ddDoutageplanDto.creturntime"
											startName="ddDoutageplanDto.csendtime"  showSecond="true" 
											initValue=""
											dateFormat="yyyy-mm-dd hh:mm" group="end"></jhop:dateselect>
                                       <%}else{ %>
                                       <jhop:dateselect name="ddDoutageplanDto.creturntime"
											startName="ddDoutageplanDto.csendtime"  showSecond="true" 
											initValue="<%=creturntime.toString() %>"
											dateFormat="yyyy-mm-dd hh:mm" group="end"></jhop:dateselect>
                                       <%} %>

									</TD>
									<TD width="13%" bgcolor="#f6f6f6">
										<%--中调收令人--%>
										<bean:message key="object.ddDoutageplanDto.creceiver1" />

									</TD>
									<TD width="20%">
										<input type=text name="ddDoutageplanDto.creceiver1"
											id="ddDoutageplanDto.creceiver1" size=16
											value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.creceiver1}"/>">
											<img name=''
											src="<%=request.getContextPath()%>/themes/themes1/images/main/mag.gif"
											onClick="showGGreperson('ddDoutageplanDto.creceiver1')">
									</TD>
									<TD width="13%" bgcolor="#f6f6f6">
										<%--市调交令人姓名--%>
										<bean:message key="object.ddDoutageplanDto.creturner" />

									</TD>
									<TD width="20%">
										<input type=text name="ddDoutageplanDto.creturner"
											id="ddDoutageplanDto.creturner" size=16
											value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.creturner}"/>">
											<img name=''
											src="<%=request.getContextPath()%>/themes/themes1/images/main/mag.gif"
											onClick="showGGperson('ddDoutageplanDto.creturner')">
									</TD>
								</TR>
								<TR>
									<TD bgcolor="#f6f6f6">
										<%--向中调交令内容--%>
										<bean:message key="object.ddDoutageplanDto.creturncontent" />

									</TD>
									<TD colSpan=5>
										<input type=text name=".ddDoutageplanDto.creturncontent"
											id="ddDoutageplanDto.creturncontent" size=100
											value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.creturncontent}"/>">
									</TD>
								</TR>
								<%}else{ %>
								
								<TR>
									<TD width="13%" bgcolor="#f6f6f6">
										<%--中调下令时间--%>
										<bean:message key="object.ddDoutageplanDto.csendtime" />
									</TD>
									<TD width="20%">
								
										
										<input type=text name="ddDoutageplanDto.csendtime"
											id="ddDoutageplanDto.csender" size=16 onFocus="this.blur()" 
											value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.csendtime}"/>">
									</TD>
									<TD width="13%" bgcolor="#f6f6f6">
										<%--中调下令人--%>
										<bean:message key="object.ddDoutageplanDto.csender" />

									</TD>
									<TD width="20%">
										<input type=text name="ddDoutageplanDto.csender"
											id="ddDoutageplanDto.csender" size=16 onFocus="this.blur()" 
											value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.csender}"/>">
									</TD>
									<TD width="13%" bgcolor="#f6f6f6">
										<%--市调接令人姓名--%>
										<bean:message key="object.ddDoutageplanDto.creceiver2" />

									</TD>
									<TD width="20%">
										<input type=text name="ddDoutageplanDto.creceiver2"
											id="ddDoutageplanDtocreceiver2" size=16 onFocus="this.blur()" 
											value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.creceiver2}"/>">
									</TD>
								</TR>
								<TR>
									<TD bgcolor="#f6f6f6">
										<%--中调下令内容--%>
										<bean:message key="object.ddDoutageplanDto.cmdcontent" />
									</TD>
									<TD colSpan=5>
										<input type=text name="ddDoutageplanDto.cmdcontent"
											id="ddDoutageplanDto.cmdcontent" size=100 onFocus="this.blur()" 
											value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.cmdcontent}"/>">
									</TD>
								</TR>
								<TR>
									<TD width="13%" bgcolor="#f6f6f6">
										<%--向中调交令时间--%>
										<bean:message key="object.ddDoutageplanDto.creturntime" />

									</TD>
									<TD width="20%">
                                       <input type=text name="ddDoutageplanDto.creturntime"
											id="ddDoutageplanDto.creceiver1" size=16 onFocus="this.blur()" 
											value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.creturntime}"/>">

									</TD>
									<TD width="13%" bgcolor="#f6f6f6">
										<%--中调收令人--%>
										<bean:message key="object.ddDoutageplanDto.creceiver1" />

									</TD>
									<TD width="20%">
										<input type=text name="ddDoutageplanDto.creceiver1"
											id="ddDoutageplanDto.creceiver1" size=16 onFocus="this.blur()" 
											value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.creceiver1}"/>">
									</TD>
									<TD width="13%" bgcolor="#f6f6f6">
										<%--市调交令人姓名--%>
										<bean:message key="object.ddDoutageplanDto.creturner" />

									</TD>
									<TD width="20%">
										<input type=text name="ddDoutageplanDto.creturner"
											id="ddDoutageplanDto.creturner" size=16 onFocus="this.blur()" 
											value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.creturner}"/>">
									</TD>
								</TR>
								<TR>
									<TD bgcolor="#f6f6f6">
										<%--向中调交令内容--%>
										<bean:message key="object.ddDoutageplanDto.creturncontent" />

									</TD>
									<TD colSpan=5>
										<input type=text name=".ddDoutageplanDto.creturncontent"
											id="ddDoutageplanDto.creturncontent" size=100 onFocus="this.blur()" 
											value="<c:out value="${ddDoutageplanForm.ddDoutageplanDto.creturncontent}"/>">
									</TD>
								</TR>
								<%} %>
							</TBODY>
						</TABLE>
					</td>
				</tr>
			</table>
		</form>
		<%} %>
		<table>
			<tr>
				<td height="8"></td>
			</tr>
		</table>
         
         
         <%
         	 boolean delayflag =  ResourceHelp.isHaveRes(DispatchResConstants.DDDOUTAGEPLAN_DELAY); 
             boolean delayedit =  ResourceHelp.isHaveRes(DispatchResConstants.DDDOUTAGEPLAN_DELAY_EDIT); 
             boolean delayedelete =  ResourceHelp.isHaveRes(DispatchResConstants.DDDOUTAGEPLAN_DELAY_DELETE); 
             if(delayflag){
             	
         %>

		<jhop:ctrlgroup ctrlId="jhyq" title="计划延期" isEdit="yes">
		    <%if(delayedit){ %>
			<img name='add'
				src="<%=request.getContextPath()%>/themes/themes1/images/main/new.gif"
				onClick="yqgrid.mygrid.addNewRow()">
			<img name='save'
				src="<%=request.getContextPath()%>/themes/themes1/images/main/save.gif"
				onClick="saveDTOS('<%=request.getContextPath()%>/ddDoutageplan.do?method=saveDelayGrid',yqgrid.mygrid,false,'<%=request.getContextPath()%>/application/dddoutageplan/modechangevalidate.xml','modechange')">
            <%} %>
            
            <%if(delayedelete){ %>
			<img name='del'
				src="<%=request.getContextPath()%>/themes/themes1/images/main/delete.gif"
				onClick="deleteDTOS('<%=request.getContextPath()%>/ddDoutageplan.do?method=deleteDelayGrid',yqgrid.mygrid,'fid','version')">
			<%}%>
		</jhop:ctrlgroup>

		<table class="detailmain" cellspacing="0" height="150" cellpadding="0"
			id="jhyq">
			<tr>
				<td align="center" height="150">
					<iframe name="yqgrid" frameborder='0' width="100%" 　scrolling="yes"
						height="150" src=''></iframe>
				</td>
			</tr>
		</table>

       <%} %>
	
	</body>
	<script>
	        //显示日计划配合

			function showCooperater(){
			    var  status = document.getElementById('ddDoutageplanDto.fexcutestatus').value;
			    if(status!="已下发"&&status!="已下令"){
			    	alert("当状态为已下发时或已下令时才能加入配合");
			    	return false;
			    }
			    
				var url="/application/dddoutageplan/DDdayoutageplan_joincopprate.jsp";
			    var qq = new Object();
				var  returnval=showModalDialogYY(url,600,600,qq,"日计划配合",1);
				if(returnval){
					var name = returnval.split("\^")[0];
					var dat = returnval.split("\^")[1];
					var ids = document.getElementById('ddDoutageplanDto.fdayplanno').value;
					coprrerateIframe.document.all.copperateplanform.action="<%=request.getContextPath()%>/ddDoutageplan.do?method=dayplanjoinCopperate";
					(coprrerateIframe.document.getElementById("name")).value=name;
					(coprrerateIframe.document.getElementById("date")).value=dat;
					(coprrerateIframe.document.getElementById("ids")).value=ids;
					coprrerateIframe.document.all.copperateplanform.submit();
				}
			} 
			
			
		 //保存中调命令
	      function savezd(){
	            var zform = document.all.zdmlform;
	            //alert(zform);
	      		//document.all.zdmlform.action="<%=request.getContextPath()%>/ddDoutageplan.do?method=dayplanjoinCopperate";
	      		var  id = document.getElementById('ddDoutageplanDto.fdayplanno').value;
	      		var version =  document.getElementById('ddDoutageplanDto.version').value;
	      		var csendtime = document.getElementById('ddDoutageplanDto.csendtime').value;
	      		var csender = document.getElementById('ddDoutageplanDto.csender').value;
	      		var creceiver2 = document.getElementById('ddDoutageplanDto.creceiver2').value;
	      		var cmdcontent = document.getElementById('ddDoutageplanDto.cmdcontent').value;
	      		
	      		var creturntime = document.getElementById('ddDoutageplanDto.creturntime').value;
	      		var creceiver1 = document.getElementById('ddDoutageplanDto.creceiver1').value;
	      		var creturner = document.getElementById('ddDoutageplanDto.creturner').value;
	      		var creturncontent = document.getElementById('ddDoutageplanDto.creturncontent').value;
	      		var para ="id="+id;
	      		para+="&version="+version;
	      		para+="&csendtime="+csendtime;
	      		para+="&csender="+csender;
	      		para+="&creceiver2="+creceiver2;
	      		para+="&cmdcontent="+cmdcontent;
	      		para+="&creturntime="+creturntime;
	      		para+="&creceiver1="+creceiver1;
	      		para+="&creturner="+creturner;
	      		para+="&creturncontent="+creturncontent;
                var url="<%=request.getContextPath()%>/ddDoutageplan.do?method=saveReportOrder";
		        var myAjax = new Ajax.Request(url,{method: 'post', parameters: para,  onComplete: showResponse});
			     function showResponse(originalRequest){
		            var savesucces = originalRequest.responseText;
		            var  mess = savesucces.split("\^");
		          
		            if(Number(mess[0])==1){
		            	alert("生成中调命令成功");
		            	var  ver  = document.getElementById("ddDoutageplanDto.version");
		            	ver.value=mess[1];
		            }
		          
		            else{
		            	alert("生成中调命令失败");
		            }
	                //parent.downFrame.iframe1.createGrid('','0','','','','','','');
		         }
	      }
	      
	      
	      

       var xl = setInterval(xlgridlocation,500) ;
        var yq = setInterval(yqgridlocation,500) ;
        //初始化执行表格

       function xlgridlocation(){
          var edit='<%=orderedit%>';
          var dele ='<%=orderdelete%>';
	      if(coprrerateIframe.mygrid){
	    	 	var  parentid= document.getElementById('ddDoutageplanDto.fdayplanno').value;
	   			xlgrid.location='<%=request.getContextPath()%>/application/dddoutageplan/DDdayoutageplan_excutelist_grid.jsp?parentid='+parentid+'&edit='+edit+'&delete='+dele;
	   			clearInterval(xl);
	   		}
	   }
	   //初始化延期表格

	   function yqgridlocation(){
	      var delayedit ='<%=delayedit%>';
	      var delaydelete ='<%=delayedelete%>';
	        if(xlgrid.mygrid){
	    		var  parentid= document.getElementById('ddDoutageplanDto.fdayplanno').value;
	   			yqgrid.location='<%=request.getContextPath()%>/application/dddoutageplan/DDdayoutageplan_delaylist_grid.jsp?parentid='+parentid+'&edit='+delayedit+'&delete='+delaydelete;
	   			clearInterval(yq);
	   		}
	   }
	   
	   
	   //显示取消原因
	   function   showSystemdic(){
	   	var url="/application/systemdic/showsystemdic.jsp?typeId=51";
			    var qq = new Object();
				var  returnval=showModalDialogYY(url,600,600,qq,"取消原因",1);
				if(returnval){
					var  reason= returnval.split("\^")[0];
					var rcode = returnval.split("\^")[1];
					var val = document.getElementById('ddDoutageplanDto.fabolishReason'); 
					var  code = document.getElementById('ddDoutageplanDto.cancelcode');
					val.value=reason;
					code.value=rcode;
				}
	   }
	   
	  //取消原因
	  function cancle(){
	    var  status = document.getElementById('ddDoutageplanDto.fexcutestatus').value;
	    if(status!="已下发"&&status!="已下令"){
	    	alert("当状态为已下发时或已下令时才能取消");
	    	return false;
	    }
	  	var val = document.getElementById('ddDoutageplanDto.fabolishReason').value;
	    var  id= document.getElementById('ddDoutageplanDto.fdayplanno').value;
	    var  code = document.getElementById('ddDoutageplanDto.cancelcode').value;
	    var  version = document.getElementById('ddDoutageplanDto.version').value
	    var para = 'id='+id+'&cancleval='+val+'&code='+code+'&version='+version;

	  	 var url="<%=request.getContextPath()%>/ddDoutageplan.do?method=savecancleReason";
		        var myAjax = new Ajax.Request(url,{method: 'post', parameters: para,  onComplete: showResponse});
			     function showResponse(originalRequest){
		            var savesucces = originalRequest.responseText;
		            //alert(savesucces);
		            var mess = savesucces.split('\^');
		            if(mess[0]=='1'){
		            	alert("添加取消原因成功");
		            	var  ver  = document.getElementById("ddDoutageplanDto.version");
		            	ver.value=mess[1];
		            	}
		            else{
		            	alert("添加取消原因失败");
		            	}
		         }
	  }
	
	  //加盖电子章

	  function  showgraf(){
	     var  stampedit = '<%=ResourceHelp.isHaveRes(DispatchResConstants.DDDOUTAGEPLAN_STAMP_EDIT)%>';
	     var  status = document.getElementById('ddDoutageplanDto.fexcutestatus').value;
			    if(status!="已下发"&&status!="已下令"){
			    	alert("当状态为已下发时或已下令时才能加入加盖电子章");
			    	return false;
			    }
	    var da = new Date()
	    var url="/application/stdelectricstamp/showgrafe.jsp?dd="+da;
	    var qq = new Object();
		var vReturnValue=showModalDialogYY(url,600,600,qq,"盖章",1);
		if(vReturnValue){
		　　 var  dd = checkgraf(vReturnValue);
		    //alert("gggg"+dd);
		    if(dd){
				var  id= document.getElementById('ddDoutageplanDto.fdayplanno').value;
		    	var  version = document.getElementById('ddDoutageplanDto.version').value;
		    	para = 'id='+id+'&version='+version+'&gids='+vReturnValue;
			 	var url="<%=request.getContextPath()%>/ddDoutageplan.do?method=saveGrafe";
			 	var myAjax = new Ajax.Request(url,{method: 'post', parameters: para,  onComplete: showResponse});
			 	 function showResponse(originalRequest){
			            var savesucces = originalRequest.responseText;
			            var mess = savesucces.split('\^');
			            if(mess[0]=='1'){
			            	alert("盖章成功");
			            	var  ver  = document.getElementById("ddDoutageplanDto.version");
			            	ver.value=mess[1];
			            	var  sids = mess[2];
			            	var  stamps = document.getElementById('ddDoutageplanDto.stampid');
			            	stamps.value= mess[2];
			            	graf.location="<%=request.getContextPath()%>/stdElectricstamp.do?method=loadstamps&edit="+stampedit+"&ids="+sids;
			            }else{
			            	alert("盖章失败");
			            	}
			         }
		 	}
		}
		
	}
	
	
	function  checkgraf(gids){
		var  oldgids = document.getElementById('ddDoutageplanDto.stampid').value;
		//alert(oldgids);
		//alert(gids);
		var nids ="" ;
		if(oldgids){
		   var  oids = oldgids.split(";");
		   var  ngid = gids.split(";");
		   for(var i=0;i<oids.length;i++){
		      //alert(oids[i]);
		      for(var j =0;j<ngid.length;j++){
		        //alert(ngid[j]);
		      	if(ngid[j]==oids[i]){
		      	  alert("不可以重复盖电子章");
		      	  return false;
		      	}
		      }
		   }
		   return gids;
		}else{
			return gids;
		}
	}
	
	//删除电子章

	function deletegraf(){
	   var  stampedit = '<%=ResourceHelp.isHaveRes(DispatchResConstants.DDDOUTAGEPLAN_STAMP_EDIT)%>';
	    var doc =  graf.document;
	    var inputs = doc.getElementsByTagName('input');
	    var ids="";
	    if(inputs){
	   	 for(var i=0;i<inputs.length;i++){
	   	 	if(inputs[i].type=="checkbox"&&inputs[i].checked==true){
	   	 		ids+=inputs[i].id+";"
	   	 	}
	   	 }
	    }

       if(ids==""){
       	return false;
       }
	   	var  id= document.getElementById('ddDoutageplanDto.fdayplanno').value;
	    	var  version = document.getElementById('ddDoutageplanDto.version').value;
	    	para = 'id='+id+'&version='+version+'&delids='+ids;
		 	var url="<%=request.getContextPath()%>/ddDoutageplan.do?method=deleteGrafe";
		 	var myAjax = new Ajax.Request(url,{method: 'post', parameters: para,  onComplete: showResponse});
		 	 function showResponse(originalRequest){
		            var savesucces = originalRequest.responseText;
		            var mess = savesucces.split('\^');
		            if(mess[0]=='1'){
		            	alert("删除电子章成功");
		            	var  ver  = document.getElementById("ddDoutageplanDto.version");
		            	ver.value=mess[1];
		            	var  sids = mess[2];
		            	//alert(sids);
		            	if(sids=='null'||sids==null)
		            	   sids="";
		            	var  stamps = document.getElementById('ddDoutageplanDto.stampid');
			            	stamps.value= sids;
		            	graf.location="<%=request.getContextPath()%>/stdElectricstamp.do?method=loadstamps&&edit="+stampedit+"&ids="+sids;
		            }else{
		            	alert("删除电子章失败");
		            	}
		         }
	}
	

	
	//显示内部人员
	
	function  showGGperson(id){
	    var  qq= document;
	   var  impo = new importDatasObj('/application/ggperson/GgPerson_show_grid.jsp',{'name':id},false,qq,'内部人员表');  
	       impo.height = 500;
           impo.width = 600;
           impo.inportdatastoinput();
	}
	
	//显示外部人员
	function  showGGreperson(id){
		   var  impo = new importDatasObj('/application/ggrelperson/GgRelperson_show_grid.jsp',{'name':id},false,document,'外部人员表');  
	       impo.height = 500;
           impo.width = 600;
           impo.inportdatastoinput();
	
	}
	</script>
<%} %>

</html>
