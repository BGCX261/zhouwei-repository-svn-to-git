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
	 document.all.theForm.action="<%=request.getContextPath()%>/ddEnsuringpsmanage.do?method=workflowHandle";
	 document.all.theForm.submit();
	 WindowClose();
	 //ˢ�¸�ҳ��
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
        <b>���α������</b> 
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
 if("1".equals(status) || "1m".equals(status)){
 	taskStatus = DispatchConstants.DdEnsuringpsmanage_BUSINESS_CITY_NEW+"/"+DispatchConstants.DdEnsuringpsmanage_BUSINESS_CITY_MODIFY;
%>            
 <input type="radio" name="transitionFlag" value="" checked>��ת����ǩ
<%}else if("2".equals(status)){
	taskStatus = DispatchConstants.DdEnsuringpsmanage_BUSINESS_CITY_COURSIGNING;
%>
 <input type="radio" name="transitionFlag" value="1" checked >��ǩͨ��
 <input type="radio" name="transitionFlag" value="-1">��ǩ����
<%}else if("3".equals(status)){
	taskStatus = DispatchConstants.DdEnsuringpsmanage_BUSINESS_CITY_APPROVING;
%> 
 <input type="radio" name="transitionFlag" value="" checked>����ͨ��
<%}else if("4".equals(status)){
	taskStatus = DispatchConstants.DdEnsuringpsmanage_BUSINESS_CITY_APPROVED;
%>
 <input type="radio" name="transitionFlag" value="1" checked>�·�
<%}else if("5".equals(status)){
	taskStatus = DispatchConstants.DdEnsuringpsmanage_BUSINESS_CITY_SENTED;
%>
 <input type="radio" name="transitionFlag" value="1" checked>ִ��
<%}else if("6".equals(status)){
	taskStatus = DispatchConstants.DdEnsuringpsmanage_BUSINESS_CITY_EXECUTED;
%>
 <input type="radio" name="transitionFlag" value="1" checked>�鵵
<%}%>
            </td>
          </TR>
          <TR>
            <TD width=30% bgcolor="#f6f6f6">�������</TD>
            <TD width=70%>
              <textarea name="notice" cols="70" rows="4" id="notice"></textarea>
            </TD>
          </TR>
          <%if("1".equals(status)){%>
          <TR>
            <TD width="30%" bgcolor="#f6f6f6">��������</TD>
            <TD width="70%">
              <input type="checkbox" name="nextTaskRoles" value="dd" checked="checked" onclick="return false">����&nbsp;
              <input type="checkbox" name="nextTaskRoles" value="fs" >��ʽ&nbsp;
            </td>
          </TR>
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
              <input type="submit" name="Submit" value="�ռ���">
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
