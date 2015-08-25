<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>调度交接班记录详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/ddclassondutylog/DDclassonduty_DDdayloadcurve_detail.js"></script>
</head>
<body>
<html:javascript formName="ddClassondutylogForm"/>
<logic:messagesPresent message="true">
	<html:messages id="message" message="true" header="messages.header" footer="messages.footer">
		<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
	</html:messages> 
</logic:messagesPresent>
 <form name="ddClassondutylogForm" action="" method="post"  enctype="multipart/form-data" >
<%--hidden--%>

<input type="hidden" name="ddClassondutylogDto.fid" value="${ddClassondutylogForm.ddClassondutylogDto.fid}">
<input type="hidden" name="ddClassondutylogDto.version" value="${ddClassondutylogForm.ddClassondutylogDto.version}">

<jhop:ctrlgroup ctrlId="UIControlGroupXPanel6a18fe8625014d40804ac345f9dc8d2e" title="日负荷曲线"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanel6a18fe8625014d40804ac345f9dc8d2e">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="define.uILabel_e30cda80-ff1b-48bf-b458-e107a509fa26"/><%--显示当日采集负荷曲线业务逻辑同应急系统--%></td>
			  	    		    </tr>
	</table>
	</td></tr>
</table>
	</form>
</body>
</html>
