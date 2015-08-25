<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/common/init_js.jsp"%>


<html>
<head>
<title>任务流转</title>
<link rel="STYLESHEET" type="text/css" href="<%=request.getContextPath()%>/themes/themes1/style.css">
<script language="JavaScript"><!--
function WindowClose(){
    if(document.all){
        if(parseFloat(window.navigator.appVersion.substr(window.navigator.appVersion.indexOf("MSIE")+5, 3)) < 5.5){
            var str  = '<object id=meizzMax classid="clsid:ADB880A6-D8FF-11CF-9377-00AA003B7A11">'
                str += '<param name="Command" value="Close"></object>';
            document.body.insertAdjacentHTML("beforeEnd", str);
            document.all.meizzClose.Click();
        }else{
            window.opener = "meizz";
            window.close();
        }
    }else    window.close();
}

/**
 *  返回值函数
 */
function returnObj(){
	var paramObj = new Object();
		paramObj.sendMessage  	= document.getElementById("message").value;
		paramObj.sendPerson		= document.getElementById("sentlist").value;
		paramObj.sendMobile		= document.getElementById("SMS").checked;
			
	window.returnValue = paramObj;
	window.close();
}
//--></script>
</head>
<body bgcolor="#ffffff">
<table class="detailmain" cellspacing="0" cellpadding="0">
  <tr>
    <th class="pt" align="left" height="20">
      工作流任务流转——业务对象：<span id="objName"></span>
      编号：<span id="objNum"></span>
    </th>
  </tr>
  <tr>
    <td>
      <TABLE class="detail" width="100%" height="100%" cellspacing="0">
        <TBODY>
          <TR>
            <TD width="50%" bgcolor="#f6f6f6">任务状态</TD>
            <TD width="50%">
        		<span id="eventStatus"></span>
            </td>
          </TR>
          <TR>
            <TD width="40%" bgcolor="#f6f6f6">发送提示</TD>
            <TD width="60%">
              <span id="sendClew"></span>
            </td>
          </TR>
          <!--
          <TR>
            <TD width="40%" bgcolor="#f6f6f6">待办事项：</TD>
            <TD width="70%">
              <input type=text name="message" id="message" size=90 value="编号为《业务对象编号》的《业务对象名》处于《业务状态名称》，请于《完成期限》前《任务》">
              <input type=text name="sentlist" id="sentlist" size=40 value="张三、李四">
              <input type="submit" name="Submit" value="收件人">
              <input type="checkbox" name="SMS" value="radiobutton">
              同时发送手机短信？
            </td>
          </TR>
          -->
          <TR>
            <TD width="40%" bgcolor="#f6f6f6">通知：</TD>
            <TD width="60%">
              <input type=text name="message" id="message" size=90 value="">
              <input type=text name="sentlist" id="sentlist" size=40 value="王五、赵六">
              <input type="submit" name="Submit" value="收件人">
              <input type="checkbox" name="SMS" value="radiobutton">
              同时发送手机短信？
            </td>
          </TR>
        </TBODY>
      </TABLE>
    </td>
  </tr>
</table>
<table>
  <tr>
    <td width="60%">    </td>
    <td align="center">
      <input name="" align="middle" type="image" src="/prototype/themes/themes1/images/main/ok.gif" value="确认" onClick="returnObj()">
      &nbsp;&nbsp;&nbsp;
      <input name="" align="middle" type="image" src="/prototype/themes/themes1/images/main/reset.gif" value="取消" onClick="WindowClose()">
    </td>
  </tr>
</table>
</body>
</html>
<script>
	var param = window.dialogArguments;
	var objNum  	= param.objNum;
	var objName 	= param.objName;
	var eventStatus = param.eventStatus;	
	var sendClew    = param.sendClew;
	var message		= param.message;
	
	document.getElementById("objNum").innerHTML 	= objNum;
	document.getElementById("objName").innerHTML 	= objName;
	document.getElementById("eventStatus").innerHTML = eventStatus;
	document.getElementById("sendClew").innerHTML 	= sendClew;
	document.getElementById("message").value 		= message;
</script>
