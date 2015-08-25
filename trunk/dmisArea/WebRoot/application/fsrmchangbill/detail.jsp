<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>方式变更单详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/fsrmchangbill/detail.js"></script>
</head>
<body>
<html:javascript formName="fsRmchangbillForm"/>
<logic:messagesPresent message="true">
	<html:messages id="message" message="true" header="messages.header" footer="messages.footer">
		<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
	</html:messages> 
</logic:messagesPresent>
 <form name="fsRmchangbillForm" action="" method="post" >
<%--hidden--%>

<input type="hidden" name="fsRmchangbillDto.fchangno" value="${fsRmchangbillForm.fsRmchangbillDto.fchangno}">
<input type="hidden" name="fsRmchangbillDto.version" value="${fsRmchangbillForm.fsRmchangbillDto.version}">

<jhop:ctrlgroup ctrlId="UIControlGroupXPanel55bf7c340d1f410aaf7c001cd83c59d6" title="方式变更单"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanel55bf7c340d1f410aaf7c001cd83c59d6">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsRmchangbillDto.fchangno"/><%--变更单编号--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="fsRmchangbillDto.fchangno" name="fsRmchangbillDto.fchangno" type="text" value="${fsRmchangbillForm.fsRmchangbillDto.fchangno}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsRmchangbillDto.fstationname"/><%--厂站名--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="fsRmchangbillDto.fstationname" name="fsRmchangbillDto.fstationname" type="text" value="${fsRmchangbillForm.fsRmchangbillDto.fstationname}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsRmchangbillDto.fstationid"/><%--厂站编号--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="fsRmchangbillDto.fstationid" name="fsRmchangbillDto.fstationid" type="text" value="${fsRmchangbillForm.fsRmchangbillDto.fstationid}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsRmchangbillDto.fchangetype"/><%--申请类型--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="fsRmchangbillDto.fchangetype" name="fsRmchangbillDto.fchangetype" type="text" value="${fsRmchangbillForm.fsRmchangbillDto.fchangetype}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsRmchangbillDto.fchangename"/><%--方式变更名称--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="fsRmchangbillDto.fchangename" name="fsRmchangbillDto.fchangename" type="text" value="${fsRmchangbillForm.fsRmchangbillDto.fchangename}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsRmchangbillDto.fchangetime"/><%--方式变更时间--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="fsRmchangbillDto.fchangetime" genText="yes" dateFormat="yyyy-mm-dd" initValue="${fsRmchangbillForm.fsRmchangbillDto.fchangetime}" ></jhop:date>
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsRmchangbillDto.fpotentialhazard"/><%--安全隐患--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="fsRmchangbillDto.fpotentialhazard" name="fsRmchangbillDto.fpotentialhazard" type="text" value="${fsRmchangbillForm.fsRmchangbillDto.fpotentialhazard}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsRmchangbillDto.frnormaltime"/><%--恢复正常方式时间--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="fsRmchangbillDto.frnormaltime" genText="yes" dateFormat="yyyy-mm-dd" initValue="${fsRmchangbillForm.fsRmchangbillDto.frnormaltime}" ></jhop:date>
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsRmchangbillDto.fkeeptime"/><%--变更持续时间(分)--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="fsRmchangbillDto.fkeeptime" name="fsRmchangbillDto.fkeeptime" type="text" value="${fsRmchangbillForm.fsRmchangbillDto.fkeeptime}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsRmchangbillDto.fremark"/><%--变更备注--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="fsRmchangbillDto.fremark" name="fsRmchangbillDto.fremark" type="text" value="${fsRmchangbillForm.fsRmchangbillDto.fremark}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsRmchangbillDto.frelchangebillno"/><%--关联变更单编号--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="fsRmchangbillDto.frelchangebillno" name="fsRmchangbillDto.frelchangebillno" type="text" value="${fsRmchangbillForm.fsRmchangbillDto.frelchangebillno}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsRmchangbillDto.fattribute"/><%--性质--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="fsRmchangbillDto.fattribute" name="fsRmchangbillDto.fattribute" type="text" value="${fsRmchangbillForm.fsRmchangbillDto.fattribute}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsRmchangbillDto.fstatus"/><%--流转状态--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="fsRmchangbillDto.fstatus" name="fsRmchangbillDto.fstatus" type="text" value="${fsRmchangbillForm.fsRmchangbillDto.fstatus}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsRmchangbillDto.rmchangbillno"/><%--正式编号--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="fsRmchangbillDto.rmchangbillno" name="fsRmchangbillDto.rmchangbillno" type="text" value="${fsRmchangbillForm.fsRmchangbillDto.rmchangbillno}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsRmchangbillDto.fvoltage"/><%--电压等级(kV)--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="fsRmchangbillDto.fvoltage" name="fsRmchangbillDto.fvoltage" type="text" value="${fsRmchangbillForm.fsRmchangbillDto.fvoltage}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsRmchangbillDto.fchangereason"/><%--方式变更原因--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="fsRmchangbillDto.fchangereason" name="fsRmchangbillDto.fchangereason" type="text" value="${fsRmchangbillForm.fsRmchangbillDto.fchangereason}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsRmchangbillDto.fchangeperformance"/><%--执行状态--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="fsRmchangbillDto.fchangeperformance" name="fsRmchangbillDto.fchangeperformance" type="text" value="${fsRmchangbillForm.fsRmchangbillDto.fchangeperformance}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsRmchangbillDto.fisrenormal"/><%--是否需恢复方式--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="fsRmchangbillDto.fisrenormal" name="fsRmchangbillDto.fisrenormal" type="text" value="${fsRmchangbillForm.fsRmchangbillDto.fisrenormal}" size="10"  />
			   </td>
			  	    		    </tr>
	</table>
	</td></tr>
</table>
	</form>
</body>
</html>
