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
<title>������������ת</title>
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
	 //ˢ�¸�ҳ��
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
		 //ˢ�¸�ҳ��
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
       ҵ�����
      <font color="red">
        <b>����Ʊ����</b> 
      </font>
       ��ţ�
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
            <TD width="30%" bgcolor="#f6f6f6">��������</TD>
            <TD width="70%">
<%	
 if("1".equals(status) || "5".equals(status)){
 	//taskStatus = ZdhConstants.ZdhWorkbill_WORKFLOW_CITY_STATUS_NEW+"/"+ZdhConstants.ZdhWorkbill_WORKFLOW_CITY_STATUS_MODIFY;
 	taskStatus = ZdhConstants.ZdhWorkbill_WORKFLOW_CITY_STATUS_NEW;
 	//taskStatus = ZdhConstants.ZdhWorkbill_WORKFLOW_CITY_STATUS_YWZRINK;//��ת����ά��������ǩ��
%>            
<input type="radio" name="transitionFlag" value="1" checked>����
 
<%}else if("2".equals(status)){
	taskStatus = ZdhConstants.ZdhWorkbill_BUSINESS_CITY_APPROVING;	//��ת����ά��������ǩ��ͨ��
%>
<input type="radio" name="transitionFlag" value="1" checked>��ת����ά��������ǩ��ͨ��
<input type="radio" name="transitionFlag" value="-1">����
 

<%} else if("3".equals(status)){	
    taskStatus = ZdhConstants.ZdhWorkbill_BUSINESS_CITY_APPROVING;  //�����ǩ��	
%>
<input type="radio" name="transitionFlag" value="1" checked >�����ǩ��ͨ��
<input type="radio" name="transitionFlag" value="-1" >����

<%} else if("4".equals(status)){	
    taskStatus = ZdhConstants.ZdhWorkbill_BUSINESS_CITY_APPROVING;  //����������ǩ��
%>
<input type="radio" name="transitionFlag" value="1" checked >����������ǩ��

<%} else if("5".equals(status)){	
    taskStatus = ZdhConstants.ZdhWorkbill_BUSINESS_CITY_APPROVING;  //�޸Ĺ���Ʊ
%>
<input type="radio" name="transitionFlag" value="1" checked >�޸Ĺ���Ʊ    
   
<% }%>
            </td>
          </TR>
          <TR>
            <TD width=30% bgcolor="#f6f6f6">�������</TD>
            <TD width=70%>
              <textarea name="notice" cols="70" rows="4" id="notice"></textarea>
            </TD>
          </TR>
          <%if("1".equals(status)){%>
          <!--
          <TR>
            <TD width="30%" bgcolor="#f6f6f6">��������</TD>
            <TD width="70%">
              <input type="checkbox" name="nextTaskRoles" value="dd" checked="checked" onclick="return false">����&nbsp;
              <input type="checkbox" name="nextTaskRoles" value="fs" >��ʽ&nbsp;
            </td>
          </TR>
            -->
          <%}%>
          <TR>
            <TD width="30%" bgcolor="#f6f6f6">��ǰ״̬</TD>
            <TD width="70%">
              <font color="red">
                <b><%=taskStatus%></b>
              </font>
            </td>
          </TR>
          <TR>
            <TD width="30%" bgcolor="#f6f6f6">֪ͨ��</TD>
            <TD width="70%">
              <input type=text name="message" id="message" size="71" value="">
              <input type=text name="sentPersons" id="sentPersons" size=40 value="">
              <input type="button" name="button" value="�ռ���">
              <input type="checkbox" name="isSms" value="1">ͬʱ�����ֻ����ţ�
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
      <input name="" align="middle" type="image" src="<%=request.getContextPath()%>/themes/themes1/images/main/ok.gif" value="ȷ��" onClick="wfHandle()">
      &nbsp;&nbsp;
      <input name="" align="middle" type="image" src="<%=request.getContextPath()%>/themes/themes1/images/main/reset.gif" value="ȡ��" onClick="WindowClose()">
    </td>
  </tr>
</table>
</form>
</body>
</html>
