<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>自动化设备缺陷详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/zdhfaultlist/autoeqpfaultlist_EQpinfo_detail.js"></script>
</head>
<body>
<html:javascript formName="zdhFaultlistForm"/>
<logic:messagesPresent message="true">
	<html:messages id="message" message="true" header="messages.header" footer="messages.footer">
		<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
	</html:messages> 
</logic:messagesPresent>
 <form name="zdhFaultlistForm" action="" method="post" >
<%--hidden--%>

<input type="hidden" name="zdhFaultlistDto.ffaultno" value="${zdhFaultlistForm.zdhFaultlistDto.ffaultno}">
<input type="hidden" name="zdhFaultlistDto.version" value="${zdhFaultlistForm.zdhFaultlistDto.version}">

<jhop:ctrlgroup ctrlId="UIControlGroupXPanela5ec4d62db31477b91792a43491f0223" title="设备信息"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanela5ec4d62db31477b91792a43491f0223">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="define.uILabel_2de28b0d-62d1-4596-b81c-66d0feff26de"/><%--显示对应设备的详情--%></td>
			  	    		    </tr>
	</table>
	</td></tr>
</table>
	</form>
</body>
</html>
