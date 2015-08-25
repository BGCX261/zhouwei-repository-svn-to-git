<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>序位表详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/zdhsequencetable/detail.js"></script>
</head>
<body>
<html:javascript formName="zdhSequencetableForm"/>
<logic:messagesPresent message="true">
	<html:messages id="message" message="true" header="messages.header" footer="messages.footer">
		<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
	</html:messages> 
</logic:messagesPresent>
 <form name="zdhSequencetableForm" action="" method="post" >
<%--hidden--%>

<input type="hidden" name="zdhSequencetableDto.sequenceno" value="${zdhSequencetableForm.zdhSequencetableDto.sequenceno}">
<input type="hidden" name="zdhSequencetableDto.version" value="${zdhSequencetableForm.zdhSequencetableDto.version}">

<jhop:ctrlgroup ctrlId="UIControlGroupXPanel6ed7a9915c3e442590ff3522933f4677" title="序位表"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanel6ed7a9915c3e442590ff3522933f4677">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhSequencetableDto.sequenceno"/><%--编号--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="zdhSequencetableDto.sequenceno" name="zdhSequencetableDto.sequenceno" type="text" value="${zdhSequencetableForm.zdhSequencetableDto.sequenceno}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhSequencetableDto.fstationid"/><%--变电站编号--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="zdhSequencetableDto.fstationid" name="zdhSequencetableDto.fstationid" type="text" value="${zdhSequencetableForm.zdhSequencetableDto.fstationid}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhSequencetableDto.fstationname"/><%--厂站名称--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="zdhSequencetableDto.fstationname" name="zdhSequencetableDto.fstationname" type="text" value="${zdhSequencetableForm.zdhSequencetableDto.fstationname}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhSequencetableDto.serialno"/><%--序号--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="zdhSequencetableDto.serialno" name="zdhSequencetableDto.serialno" type="text" value="${zdhSequencetableForm.zdhSequencetableDto.serialno}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhSequencetableDto.name"/><%--标识--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="zdhSequencetableDto.name" name="zdhSequencetableDto.name" type="text" value="${zdhSequencetableForm.zdhSequencetableDto.name}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhSequencetableDto.status"/><%--状态--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="zdhSequencetableDto.status" name="zdhSequencetableDto.status" type="text" value="${zdhSequencetableForm.zdhSequencetableDto.status}" size="10"  />
			   </td>
			  	    		    </tr>
	</table>
	</td></tr>
</table>
	</form>
</body>
</html>
