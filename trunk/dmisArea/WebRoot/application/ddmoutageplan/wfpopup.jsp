<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="/common/init_js.jsp"%>
<%@ include file="/common/init_date.jsp"%>
<%@ include file="/common/init_tag.jsp"%>
<script language="javascript" type="text/javascript"
	src="<%=request.getContextPath()%>/script/public.js"></script>
<script language="javascript" type="text/javascript"
	src="<%=request.getContextPath()%>/script/prototype.js"></script>

<%@page import="com.techstar.dmis.common.DispatchConstants"%>
<%
	String id = request.getParameter("id");
	String taskId = request.getParameter("taskId");
	String status = request.getParameter("status");
	String taskInstanceId = request.getParameter("taskInstanceId");
	String taskStatus = "";
%>
<html>
	<head>
		<title>工作流任务流转</title>
		<link rel="STYLESHEET" type="text/css"
			href="<%=request.getContextPath()%>/themes/themes1/style.css">
		<script language="JavaScript">

function wfHandle(){
     var notice=document.getElementById("notice").value;
     var message=document.getElementById("message").value;
     var sentPersons=document.getElementById("sentPersons").value;
     var isSms=document.getElementById("isSms").value;
     //var nextTaskRoles=document.getElementById("nextTaskRoles").value;
     var transition=document.all('transitionFlag');
     var transitionFlag='';
     for (i=0;i<transition.length;i++){  
           if(transition[i].checked)
              transitionFlag=(transition[i].value);
     }
	 var pars   = "wf_busId=<%=id%>&wf_status=<%=status%>&wf_taskId=<%=taskId%>&wf_taskInstanceId=<%=taskInstanceId%>&notice="+notice+"&message="+message+"&sentPersons="+sentPersons+"&isSms="+isSms+"&transitionFlag="+transitionFlag;
	 var paramObj = new Object();
	 paramObj.title    		= "simple";
	 paramObj.type			= pars;
	 window.returnValue=paramObj;
	 window.close();

}
//--></script>
	</head>
	<body bgcolor="#ffffff">
		<form name="theForm" action="" method="post">

			<input type="hidden" name="wf_busId" value="<%=id%>">
			<input type="hidden" name="wf_status" value="<%=status%>">
			<input type="hidden" name="wf_taskId" value="<%=taskId%>">
			<input type="hidden" name="wf_taskInstanceId"
				value="<%=taskInstanceId%>">

			<table class="detailmain" cellspacing="0" cellpadding="0">
				<tr>
					<th class="pt" align="left" height="40">
						业务对象：

						<font color="red"> <b>停电月计划</b> </font> 编号：

						<font color="red"> <b><%=id%>
						</b> </font>
					</th>
				</tr>
				<tr>
					<td>
						<TABLE class="detail" width="100%" height="100%" cellspacing="0">
							<TBODY>
								<TR>
									<TD width="30%" bgcolor="#f6f6f6">
										处理内容
									</TD>
									<TD width="70%">
										<%
										if ("1".equals(status)) {
												taskStatus = DispatchConstants.ddMoutageplan_new;
										%>
										 <input type="radio" name="transitionFlag" value="" checked >发送
                                        <%}else if("2".equals(status)){
	                                            taskStatus = DispatchConstants.ddMoutageplan_CleanUp;
                                        %><input type="radio" name="transitionFlag" value="1" checked>通过
                                          <input type="radio" name="transitionFlag" value="-1">驳回
                                        <%}else if("3".equals(status)){
	                                            taskStatus = DispatchConstants.ddMoutageplan_auditing;
                                        %><input type="radio" name="transitionFlag" value="" checked>分发
                                        <%}else if("5".equals(status)){
	                                            taskStatus = DispatchConstants.ddMoutageplan_approveed;
                                        %><input type="radio" name="transitionFlag" value="" checked>提交                                     
                                        <%}else if("4".equals(status)){
	                                            taskStatus = DispatchConstants.ddMoutageplan_auditing;
                                        %><input type="radio" name="transitionFlag" value="1" checked>通过
                                          <input type="radio" name="transitionFlag" value="-1">驳回                                   
                                        <%}else if("1m".equals(status)){
	                                            taskStatus = DispatchConstants.ddMoutageplan_approveed_approveed_no;
                                        %><input id type="radio" name="transitionFlag" value="" checked>发送

                                        <%}%>
									</td>
								</TR>
								<TR>
									<TD width=30% bgcolor="#f6f6f6">
										处理意见
									</TD>
									<TD width=70%>
										<textarea name="notice" cols="70" rows="4" id="notice"></textarea>
									</TD>
								</TR>
		
								<TR>
									<TD width="30%" bgcolor="#f6f6f6">
										当前状态

									</TD>
									<TD width="70%">
										<font color="red"> <b><%=taskStatus%>
										</b> </font>
									</td>
								</TR>
								<TR>
									<TD width="30%" bgcolor="#f6f6f6">
										通知：

									</TD>
									<TD width="70%">
										<input type=text name="message" id="message" size="71"
											value="">
										<input type=text name="sentPersons" id="sentPersons" size=40
											value="">
										<input type="button" name="buttonx" value="收件人">
										<input type="checkbox" name="isSms" value="1">
										同时发送手机短信？
									</td>
								</TR>
							</TBODY>
						</TABLE>
					</td>
				</tr>
			</table>
			<br>
			<table>
				<tr>
					<td align="center">
						<img src="<%=request.getContextPath()%>/themes/themes1/images/main/ok.gif"
							value="确认" onClick="wfHandle()">
						&nbsp;&nbsp;
						
						<img src="<%=request.getContextPath()%>/themes/themes1/images/main/reset.gif"
							value="取消" onClick="window.close();">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
