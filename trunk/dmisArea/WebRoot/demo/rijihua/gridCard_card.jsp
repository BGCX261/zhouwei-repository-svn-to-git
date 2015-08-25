<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>子卡片信息</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/demo/rijihua/gridCard_card.js"></script>
</head>
<body>
<html:javascript formName="rijihuaForm"/>
<logic:messagesPresent message="true">
	<html:messages id="message" message="true" header="messages.header" footer="messages.footer">
		<script language="javascript">
			alert('<bean:write name="message" ignore="true" />');
		</script>
	</html:messages> 
</logic:messagesPresent>

<form name="rijihuaForm" action="" method="post">
<%--hidden--%>
<input type="hidden" name="sheDto.id" value="<c:out value='${rijihuaForm.sheDto.id}'/>">
<input type="hidden" name="sheDto.version" value="<c:out value='${rijihuaForm.sheDto.version}'/>">

<table class="detailmain" cellspacing="0" cellpadding="0">
	<tr id="table0"><td align="center">
		<table class="detail" width="100%" height="100%" cellspacing="0" >
			<tr>
			  <td height="23" class="tab_0" width="20%"><bean:message key="dayPlan.equipment"/><%--设备名称--%><span class="article_required">*</span></td>
			  <td height="23" width="30%"><input type="text" name="sheDto.equipment" value="${rijihuaForm.sheDto.equipment}"></td>
			  <td height="23" class="tab_0" width="20%"><bean:message key="dayPlan.status"/><%--状态--%></td>
			  <td height="23" width="30%"><input type="text" name="sheDto.status" value="${rijihuaForm.sheDto.status}"></td>
		    </tr>
			<tr>
			  <td height="23" class="tab_0"><bean:message key="dayPlan.voltage_level"/><%--电压等级--%></td>
			  <td height="23"><jhop:select name="sheDto.voltage_level" hiddName="" type="voltage_level" initValue="${rijihuaForm.sheDto.voltage_level}"></jhop:select></td>
			  <td height="23" class="tab_0"><bean:message key="dayPlan.apply_date"/><%--申请日期--%></td>
			  <td height="23"><jhop:date name="sheDto.apply_date" genText="yes" dateFormat="yyyy-mm-dd hh:mm:ss" initValue="${rijihuaForm.sheDto.apply_date}"></jhop:date></td>
		    </tr>
		</table>
	</td></tr>
</table>
</form>
</body>
</html>
