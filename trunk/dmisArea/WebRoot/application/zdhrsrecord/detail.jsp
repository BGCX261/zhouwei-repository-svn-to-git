<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>遥信记录详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/zdhrsrecord/detail.js"></script>
</head>
<body>
<html:javascript formName="zdhRsrecordForm"/>
<logic:messagesPresent message="true">
	<html:messages id="message" message="true" header="messages.header" footer="messages.footer">
		<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
	</html:messages> 
</logic:messagesPresent>
 <form name="zdhRsrecordForm" action="" method="post" >
<%--hidden--%>

<input type="hidden" name="zdhRsrecordDto.recordid" value="${zdhRsrecordForm.zdhRsrecordDto.recordid}">
<input type="hidden" name="zdhRsrecordDto.version" value="${zdhRsrecordForm.zdhRsrecordDto.version}">

<jhop:ctrlgroup ctrlId="UIControlGroupXPanel6bed6bdd1e6345268cb3c79f80c5e35c" title="遥信记录"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanel6bed6bdd1e6345268cb3c79f80c5e35c">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhRsrecordDto.recordid"/><%--记录编号--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="zdhRsrecordDto.recordid" name="zdhRsrecordDto.recordid" type="text" value="${zdhRsrecordForm.zdhRsrecordDto.recordid}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhRsrecordDto.righttimes"/><%--应动作次数--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="zdhRsrecordDto.righttimes" name="zdhRsrecordDto.righttimes" type="text" value="${zdhRsrecordForm.zdhRsrecordDto.righttimes}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhRsrecordDto.correcttimes"/><%--正确动作次数--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="zdhRsrecordDto.correcttimes" name="zdhRsrecordDto.correcttimes" type="text" value="${zdhRsrecordForm.zdhRsrecordDto.correcttimes}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhRsrecordDto.actionnote"/><%--动作说明--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="zdhRsrecordDto.actionnote" name="zdhRsrecordDto.actionnote" type="text" value="${zdhRsrecordForm.zdhRsrecordDto.actionnote}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhRsrecordDto.sys_fille"/><%--填写人--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="zdhRsrecordDto.sys_fille" name="zdhRsrecordDto.sys_fille" type="text" value="${zdhRsrecordForm.zdhRsrecordDto.sys_fille}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhRsrecordDto.sys_filldept"/><%--填写单位--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="zdhRsrecordDto.sys_filldept" name="zdhRsrecordDto.sys_filldept" type="text" value="${zdhRsrecordForm.zdhRsrecordDto.sys_filldept}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhRsrecordDto.sys_filltime"/><%--填写时间--%></td>
			  	    			  			   <td height="23" width="30%"  colspan="3"  >
				 <jhop:date name="zdhRsrecordDto.sys_filltime" genText="yes" dateFormat="yyyy-mm-dd" initValue="${zdhRsrecordForm.zdhRsrecordDto.sys_filltime}" ></jhop:date>
			   </td>
			  	    		    </tr>
	</table>
	</td></tr>
</table>
	</form>
</body>
</html>
