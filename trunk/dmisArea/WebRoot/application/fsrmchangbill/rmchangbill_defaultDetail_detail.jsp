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
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/fsrmchangbill/rmchangbill_defaultDetail_detail.js"></script>
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

<jhop:ctrlgroup ctrlId="UIControlGroupXPaneld2edfdf612f94d7cbb84f7af8e836b33" title="方式变更申请"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPaneld2edfdf612f94d7cbb84f7af8e836b33">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsRmchangbillDto.fchangename"/><%--方式变更名称--%></td>
			  			  
	    		
			  			   <td height="23" width="30%"  colspan="3"  >
				 <textarea id='fsRmchangbillDto.fchangename' name='fsRmchangbillDto.fchangename' rows='3' cols='50' >${fsRmchangbillForm.fsRmchangbillDto.fchangename}</textarea>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsRmchangbillDto.fchangetime"/><%--方式变更时间--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:date name="fsRmchangbillDto.fchangetime" genText="yes" dateFormat="yyyy-mm-dd hh:mm:ss" initValue="${fsRmchangbillForm.fsRmchangbillDto.fchangetime}" ></jhop:date>
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsRmchangbillDto.fpotentialhazard"/><%--安全隐患--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="fsRmchangbillDto.fpotentialhazard" name="fsRmchangbillDto.fpotentialhazard" type="text" value="${fsRmchangbillForm.fsRmchangbillDto.fpotentialhazard}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsRmchangbillDto.fvoltage"/><%--电压等级(kV)--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:select name="fsRmchangbillDto.fvoltage" hiddName="" type="StdVoltage" initValue="${fsRmchangbillForm.fsRmchangbillDto.fvoltage}"> </jhop:select>
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsRmchangbillDto.fchangereason"/><%--方式变更原因--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:select name="fsRmchangbillDto.fchangereason" hiddName="" type="StdRunmodereason" initValue="${fsRmchangbillForm.fsRmchangbillDto.fchangereason}"> </jhop:select>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsRmchangbillDto.fisrenormal"/><%--是否需恢复方式--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:select name="fsRmchangbillDto.fisrenormal" hiddName="" type="StdIsornot" initValue="${fsRmchangbillForm.fsRmchangbillDto.fisrenormal}"> </jhop:select>
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsRmchangbillDto.frnormaltime"/><%--恢复正常方式时间--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:date name="fsRmchangbillDto.frnormaltime" genText="yes" dateFormat="yyyy-mm-dd hh:mm:ss" initValue="${fsRmchangbillForm.fsRmchangbillDto.frnormaltime}" ></jhop:date>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsRmchangbillDto.fkeeptime"/><%--变更持续时间(分)--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="fsRmchangbillDto.fkeeptime" name="fsRmchangbillDto.fkeeptime" type="text" value="${fsRmchangbillForm.fsRmchangbillDto.fkeeptime}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsRmchangbillDto.rmchangbillno"/><%--正式编号--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="fsRmchangbillDto.rmchangbillno" name="fsRmchangbillDto.rmchangbillno" type="text" value="${fsRmchangbillForm.fsRmchangbillDto.rmchangbillno}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsRmchangbillDto.fremark"/><%--变更备注--%></td>
			  			  
	    		
			  			   <td height="23" width="30%"  colspan="3"  >
				 <textarea id='fsRmchangbillDto.fremark' name='fsRmchangbillDto.fremark' rows='3' cols='50' >${fsRmchangbillForm.fsRmchangbillDto.fremark}</textarea>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsRmchangbillDto.fchangetype"/><%--申请类型--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="fsRmchangbillDto.fchangetype" name="fsRmchangbillDto.fchangetype" type="text" value="${fsRmchangbillForm.fsRmchangbillDto.fchangetype}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsRmchangbillDto.frelchangebillno"/><%--关联变更单编号--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="fsRmchangbillDto.frelchangebillno" name="fsRmchangbillDto.frelchangebillno" type="text" value="${fsRmchangbillForm.fsRmchangbillDto.frelchangebillno}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsRmchangbillDto.sys_fille"/><%--填写人--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="fsRmchangbillDto.sys_fille" name="fsRmchangbillDto.sys_fille" type="text" value="${fsRmchangbillForm.fsRmchangbillDto.sys_fille}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsRmchangbillDto.sys_filldept"/><%--填写单位--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="fsRmchangbillDto.sys_filldept" name="fsRmchangbillDto.sys_filldept" type="text" value="${fsRmchangbillForm.fsRmchangbillDto.sys_filldept}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsRmchangbillDto.sys_filltime"/><%--填写时间--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:date name="fsRmchangbillDto.sys_filltime" genText="yes" dateFormat="yyyy-MM-dd hh:mm:ss" initValue="${fsRmchangbillForm.fsRmchangbillDto.sys_filltime}" ></jhop:date>
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsRmchangbillDto.sys_isvalid"/><%--是否有效字段--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="fsRmchangbillDto.sys_isvalid" name="fsRmchangbillDto.sys_isvalid" type="text" value="${fsRmchangbillForm.fsRmchangbillDto.sys_isvalid}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsRmchangbillDto.sys_dataowner"/><%--数据所属单位--%></td>
			  			  
	    		
			  			   <td height="23" width="30%"  colspan="3"  >
				 <input id="fsRmchangbillDto.sys_dataowner" name="fsRmchangbillDto.sys_dataowner" type="text" value="${fsRmchangbillForm.fsRmchangbillDto.sys_dataowner}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 &nbsp;</td>
			  			  
	    		    </tr>
		
            		
	 	  
		   

	 </tr>
	
</table>
	</td></tr>
</table>
	<jhop:ctrlgroup ctrlId="UIControlGroupXPanele2b9c1ee2f264cee84b9c6052fb309a7" title="方式变更明细"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanele2b9c1ee2f264cee84b9c6052fb309a7">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="define.uILabel_90cabbf8-6fda-4a18-af8d-b1ea87f78fd4"/><%--列表显示方式变更明细的内容，可以维护--%></td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 &nbsp;</td>
			  			  
	    		    </tr>
		
            		
	 	  
		   

	 </tr>
	
</table>
	</td></tr>
</table>
	</form>
</body>
</html>
