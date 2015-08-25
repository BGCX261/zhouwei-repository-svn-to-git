<%@page contentType="text/html; charset=GBK"%>
<%@page import="com.techstar.dmis.common.ZdhConstants"%>
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
<link rel="STYLESHEET" type="text/css" href="<%=request.getContextPath()%>/themes/themes1/style.css">
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
		 //刷新父页面
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
	     
	     window.returnValue = paramObj;
	     
		 window.close();
}
//--></script>
</head>
<body bgcolor="#ffffff">
<form name="theForm" action="" method="post">

<input type="hidden" name="wf_busId" value="<%=id%>">
<input type="hidden" name="wf_status" value="<%=status%>">
<input type="hidden" name="wf_taskId" value="<%=taskId%>">
<input type="hidden" name="wf_taskInstanceId" value="<%=taskInstanceId%>">

<table class="detailmain" cellspacing="0" cellpadding="0">
  <tr>
    <th class="pt" align="left" height="40">
       业务对象：
      <font color="red">
        <b>工作票管理</b> 
      </font>
       编号：
      <font color="red">
        <b><%=id%></b>
      </font>
    </th>
  </tr>
  <tr>
    <td>
      <TABLE class="detail" width="100%" height="100%" cellspacing="0">
        <TBODY>
          <TR>
            <TD width="30%" bgcolor="#f6f6f6">处理内容</TD>
            <TD width="70%">
<%	
 if("1".equals(status) || "5".equals(status)){
 	//taskStatus = ZdhConstants.ZdhWorkbill_WORKFLOW_CITY_STATUS_NEW+"/"+ZdhConstants.ZdhWorkbill_WORKFLOW_CITY_STATUS_MODIFY;
 	taskStatus = ZdhConstants.ZdhWorkbill_WORKFLOW_CITY_STATUS_NEW;
 	//taskStatus = ZdhConstants.ZdhWorkbill_WORKFLOW_CITY_STATUS_YWZRINK;//流转到运维中心主任签发
%>            
<input type="radio" name="transitionFlag" value="1" checked>启动
 
<%}else if("2".equals(status)){
	taskStatus = ZdhConstants.ZdhWorkbill_BUSINESS_CITY_APPROVING;	//流转到运维中心主任签发通过
%>
<input type="radio" name="transitionFlag" value="1" checked>流转到运维中心主任签发通过
<input type="radio" name="transitionFlag" value="-1">驳回
 

<%} else if("3".equals(status)){	
    taskStatus = ZdhConstants.ZdhWorkbill_BUSINESS_CITY_APPROVING;  //许可人签字	
%>
<input type="radio" name="transitionFlag" value="1" checked >许可人签字通过
<input type="radio" name="transitionFlag" value="-1" >驳回

<%} else if("4".equals(status)){	
    taskStatus = ZdhConstants.ZdhWorkbill_BUSINESS_CITY_APPROVING;  //工作负责人签字
%>
<input type="radio" name="transitionFlag" value="1" checked >工作负责人签字

<%} else if("5".equals(status)){	
    taskStatus = ZdhConstants.ZdhWorkbill_BUSINESS_CITY_APPROVING;  //修改工作票
%>
<input type="radio" name="transitionFlag" value="1" checked >修改工作票    
   
<% }%>
            </td>
          </TR>
          <TR>
            <TD width=30% bgcolor="#f6f6f6">处理意见</TD>
            <TD width=70%>
              <textarea name="notice" cols="70" rows="4" id="notice"></textarea>
            </TD>
          </TR>
          <%if("1".equals(status)){%>
          <!--
          <TR>
            <TD width="30%" bgcolor="#f6f6f6">任务流向</TD>
            <TD width="70%">
              <input type="checkbox" name="nextTaskRoles" value="dd" checked="checked" onclick="return false">调度&nbsp;
              <input type="checkbox" name="nextTaskRoles" value="fs" >方式&nbsp;
            </td>
          </TR>
            -->
          <%}%>
          <TR>
            <TD width="30%" bgcolor="#f6f6f6">当前状态</TD>
            <TD width="70%">
              <font color="red">
                <b><%=taskStatus%></b>
              </font>
            </td>
          </TR>
          <TR>
            <TD width="30%" bgcolor="#f6f6f6">通知：</TD>
            <TD width="70%">
              <input type=text name="message" id="message" size="71" value="">
              <input type=text name="sentPersons" id="sentPersons" size=40 value="">
              <input type="button" name="button" value="收件人">
              <input type="checkbox" name="isSms" value="1">同时发送手机短信？
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
      <input name="" align="middle" type="image" src="<%=request.getContextPath()%>/themes/themes1/images/main/ok.gif" value="确认" onClick="wfHandle()">
      &nbsp;&nbsp;
      <input name="" align="middle" type="image" src="<%=request.getContextPath()%>/themes/themes1/images/main/reset.gif" value="取消" onClick="WindowClose()">
    </td>
  </tr>
</table>
</form>
</body>
</html>
