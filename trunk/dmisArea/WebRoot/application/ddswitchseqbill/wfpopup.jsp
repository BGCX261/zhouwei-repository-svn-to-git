<%@page contentType="text/html; charset=GBK"%>
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
function WindowClose()
{
   
    if(document.all)
    {
        if(parseFloat(window.navigator.appVersion.substr(window.navigator.appVersion.indexOf("MSIE")+5, 3)) < 5.5)
        {
            var str  = '<object id=meizzMax classid="clsid:ADB880A6-D8FF-11CF-9377-00AA003B7A11">'
                str += '<param name="Command" value="Close"></object>';
            document.body.insertAdjacentHTML("beforeEnd", str);
            document.all.meizzClose.Click();
        }else{
            window.opener = "meizz";
            window.close();
        }
    }else{    
    	window.close();
    }
}


/*
function wfHandle(){

   	 document.all.theForm.action="<%=request.getContextPath()%>/ddSwitchseqbill.do?method=workflowHandle";
	 document.all.theForm.submit();
	 var paramObj = new Object();
	 paramObj.title    	= "display";


	 var  busId = 
	 window.returnValue = paramObj;
	 setInterval(clo,700); //设置一个超时对象
	 function clo(){
	 	 window.close();
	 }
	 
	 //刷新父页面
}*/


function wfHandle(){
	//刷新父页面
	 var notice=document.getElementById("notice").value;
     var message=document.getElementById("message").value;
     var sentPersons=document.getElementById("sentPersons").value;
     var isSms=document.getElementById("isSms").value;
     var nextTaskRoles = '';
     if(document.all("nextTaskRoles") != null){
	     if(document.all("nextTaskRoles").length){
	     	 var taskRoles = document.all("nextTaskRoles");
	     	 for (i=0;i<taskRoles.length;i++){
		           if(taskRoles[i].checked){
		           	  if(nextTaskRoles == ''){
		           	  	nextTaskRoles += (taskRoles[i].value);
		           	  } else {
		           	  	nextTaskRoles += ","+(taskRoles[i].value)
		           	  }
		           }
		     }
	     }
	 }
     var transitionFlag = '';
     if(document.all("transitionFlag").length){
	     var transition = document.all("transitionFlag");
	     for (i=0;i<transition.length;i++){
	           if(transition[i].checked){
	              transitionFlag = (transition[i].value);
	           }
	     }
	 } else {
	 	transitionFlag = document.all.transitionFlag.value;
	 }
	 
	 var paramObj = new Object();
	 	 paramObj.wf_busId  		= "<%=id%>";
     	 paramObj.wf_status 		= "<%=status%>";
     	 paramObj.wf_taskId 		= "<%=taskId%>";
     	 paramObj.wf_taskInstanceId = "<%=taskInstanceId%>";
     	 paramObj.notice 		 	= notice;
     	 paramObj.message 		 	= message;
     	 paramObj.sentPersons 	 	= sentPersons;
     	 paramObj.isSms   		 	= isSms;
     	 paramObj.transitionFlag 	= transitionFlag;
     	 paramObj.nextTaskRoles   = nextTaskRoles;
     window.returnValue 			= paramObj;
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
						<font color="red"> <b>操作票</b> </font> 编号：
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
											if ("1".equals(status)){
												taskStatus = DispatchConstants.ddSwitchSeqbill_NEW;
										%>
										 <input type="radio" name="transitionFlag" value="1" checked >发送                                     
										<%}else if("2".equals(status)){
	                                            taskStatus = DispatchConstants.ddSeqbillDetailStepStatus_APPROVE;
                                        %><input type="radio" name="transitionFlag" value="1" checked >流转到执行
                                          <input type="radio" name="transitionFlag" value="-1">修改拟定操作票
                                        <%}else if("3".equals(status)){    
                                           taskStatus = DispatchConstants.ddSeqbillDetailStepStatus_APPROVED;
                                         %>
                                           <input type="radio" name="transitionFlag" value="301" checked >执行
 										   <input type="radio" name="transitionFlag" value="302">终止
 										   <input type="radio" name="transitionFlag" value="303">驳回
                                        <%
                                        }else if("101".equals(status)){
                                        	 taskStatus = DispatchConstants.ddSeqbillDetailStepStatus_MODIFY;
                                        %>
                                        	 <input type="radio" name="transitionFlag" value="1" checked >流转到审核 
											
                                        <%
                                        }
                                        %>
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
						<input name="" align="middle" type="image"
							src="<%=request.getContextPath()%>/themes/themes1/images/main/ok.gif"
							value="确认" onClick="wfHandle()">
						&nbsp;&nbsp;
						<input name="" align="middle" type="image"
							src="<%=request.getContextPath()%>/themes/themes1/images/main/reset.gif"
							value="取消" onClick="WindowClose()">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
