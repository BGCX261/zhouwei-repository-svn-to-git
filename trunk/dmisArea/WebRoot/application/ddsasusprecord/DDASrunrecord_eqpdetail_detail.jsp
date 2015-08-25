<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>自投停用记录详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/ddsasusprecord/DDASrunrecord_eqpdetail_detail.js"></script>
</head>
<body>
<html:javascript formName="ddSasusprecordForm"/>
<logic:messagesPresent message="true">
	<html:messages id="message" message="true" header="messages.header" footer="messages.footer">
		<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
	</html:messages> 
</logic:messagesPresent>
 <form name="ddSasusprecordForm" action="" method="post" >
<%--hidden--%>

<input type="hidden" name="ddSasusprecordDto.fid" value="${ddSasusprecordForm.ddSasusprecordDto.fid}">
<input type="hidden" name="ddSasusprecordDto.version" value="${ddSasusprecordForm.ddSasusprecordDto.version}">

<jhop:ctrlgroup ctrlId="UIControlGroupXPanel4586afb9ec054d218dd449bb3219fbaa" title="设备详情"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanel4586afb9ec054d218dd449bb3219fbaa">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="define.uILabel_39fdedd9-db32-4d72-8115-1e27aa87f7fe"/><%--调用统一的设备台帐详情页面--%></td>
			  	    		    </tr>
	</table>
	</td></tr>
</table>
	</form>
</body>
</html>
