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
	
	<%if("3".equals(status)){%>
	 if(transitionFlag=="-1") paramObj.title = "dayplan";;
	<%}%>
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
						<font color="red"> <b>故障简报管理</b> </font> 编号：
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
											if ("1".equals(status) || "1m".equals(status)) {
												taskStatus = DispatchConstants.ddAccidentbrief_new;
										%>
										 <input type="radio" name="transitionFlag" value="" checked >流转到审核                                      
										<%}else if("2".equals(status)){
	                                            taskStatus = DispatchConstants.ddAccidentbrief_auditing;
                                        %><input type="radio" name="transitionFlag" value="1" checked>审核通过
                                          <input type="radio" name="transitionFlag" value="-1">审核驳回
                                        <%}else if("3".equals(status)){
	                                            taskStatus = DispatchConstants.ddAccidentbrief_auditing;
                                        %><input id type="radio" name="transitionFlag" value="1" checked >盖处理完毕章
                                          <input type="radio" name="transitionFlag" value="-1">转日计划
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
