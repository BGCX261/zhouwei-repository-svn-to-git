<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>定值单详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/bhfixedvaluebill/detail.js"></script>
</head>
<body>
<html:javascript formName="bhFixedvaluebillForm"/>
<logic:messagesPresent message="true">
	<html:messages id="message" message="true" header="messages.header" footer="messages.footer">
		<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
	</html:messages> 
</logic:messagesPresent>
 <form name="bhFixedvaluebillForm" action="" method="post"  enctype="multipart/form-data" >
<%--hidden--%>

<input type="hidden" name="bhFixedvaluebillDto.fixvaluebillno" value="${bhFixedvaluebillForm.bhFixedvaluebillDto.fixvaluebillno}">
<input type="hidden" name="bhFixedvaluebillDto.version" value="${bhFixedvaluebillForm.bhFixedvaluebillDto.version}">

<jhop:ctrlgroup ctrlId="UIControlGroupXPanele746dfe85f42421aa53f7f0ed362a650" title="定值单"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanele746dfe85f42421aa53f7f0ed362a650">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhFixedvaluebillDto.fixvaluebillno"/><%--定值单号--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhFixedvaluebillDto.fixvaluebillno" name="bhFixedvaluebillDto.fixvaluebillno" type="text" value="${bhFixedvaluebillForm.bhFixedvaluebillDto.fixvaluebillno}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhFixedvaluebillDto.fixvaluedate"/><%--出单日期--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:date name="bhFixedvaluebillDto.fixvaluedate" genText="yes" dateFormat="yyyy-mm-dd" initValue="${bhFixedvaluebillForm.bhFixedvaluebillDto.fixvaluedate}" ></jhop:date>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhFixedvaluebillDto.fstatus"/><%--业务状态--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhFixedvaluebillDto.fstatus" name="bhFixedvaluebillDto.fstatus" type="text" value="${bhFixedvaluebillForm.bhFixedvaluebillDto.fstatus}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhFixedvaluebillDto.fapprover"/><%--审批人--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhFixedvaluebillDto.fapprover" name="bhFixedvaluebillDto.fapprover" type="text" value="${bhFixedvaluebillForm.bhFixedvaluebillDto.fapprover}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhFixedvaluebillDto.fchecker"/><%--校核人--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhFixedvaluebillDto.fchecker" name="bhFixedvaluebillDto.fchecker" type="text" value="${bhFixedvaluebillForm.bhFixedvaluebillDto.fchecker}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhFixedvaluebillDto.fcaculator"/><%--计算人--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhFixedvaluebillDto.fcaculator" name="bhFixedvaluebillDto.fcaculator" type="text" value="${bhFixedvaluebillForm.bhFixedvaluebillDto.fcaculator}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhFixedvaluebillDto.fremark"/><%--说明--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhFixedvaluebillDto.fremark" name="bhFixedvaluebillDto.fremark" type="text" value="${bhFixedvaluebillForm.bhFixedvaluebillDto.fremark}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhFixedvaluebillDto.fexcutetime"/><%--执行时间--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:date name="bhFixedvaluebillDto.fexcutetime" genText="yes" dateFormat="yyyy-mm-dd" initValue="${bhFixedvaluebillForm.bhFixedvaluebillDto.fexcutetime}" ></jhop:date>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhFixedvaluebillDto.ondutymember"/><%--值班调度员--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhFixedvaluebillDto.ondutymember" name="bhFixedvaluebillDto.ondutymember" type="text" value="${bhFixedvaluebillForm.bhFixedvaluebillDto.ondutymember}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhFixedvaluebillDto.eqpid"/><%--装置编号--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhFixedvaluebillDto.eqpid" name="bhFixedvaluebillDto.eqpid" type="text" value="${bhFixedvaluebillForm.bhFixedvaluebillDto.eqpid}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhFixedvaluebillDto.fixvalueoriginal"/><%--定值单原件--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:upload name="fixvalueoriginal" multiValue="no"></jhop:upload>
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhFixedvaluebillDto.fixvalueno"/><%--定值单编号--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhFixedvaluebillDto.fixvalueno" name="bhFixedvaluebillDto.fixvalueno" type="text" value="${bhFixedvaluebillForm.bhFixedvaluebillDto.fixvalueno}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhFixedvaluebillDto.sys_fille"/><%--填写人--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhFixedvaluebillDto.sys_fille" name="bhFixedvaluebillDto.sys_fille" type="text" value="${bhFixedvaluebillForm.bhFixedvaluebillDto.sys_fille}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhFixedvaluebillDto.sys_filldept"/><%--填写单位--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhFixedvaluebillDto.sys_filldept" name="bhFixedvaluebillDto.sys_filldept" type="text" value="${bhFixedvaluebillForm.bhFixedvaluebillDto.sys_filldept}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhFixedvaluebillDto.sys_filltime"/><%--填写时间--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:date name="bhFixedvaluebillDto.sys_filltime" genText="yes" dateFormat="yyyy-mm-dd hh:mm:ss" initValue="${bhFixedvaluebillForm.bhFixedvaluebillDto.sys_filltime}" ></jhop:date>
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhFixedvaluebillDto.sys_isvalid"/><%--是否有效字段--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhFixedvaluebillDto.sys_isvalid" name="bhFixedvaluebillDto.sys_isvalid" type="text" value="${bhFixedvaluebillForm.bhFixedvaluebillDto.sys_isvalid}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhFixedvaluebillDto.sys_dataowner"/><%--数据所属单位--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhFixedvaluebillDto.sys_dataowner" name="bhFixedvaluebillDto.sys_dataowner" type="text" value="${bhFixedvaluebillForm.bhFixedvaluebillDto.sys_dataowner}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhFixedvaluebillDto.version"/><%--数据库版本控制--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhFixedvaluebillDto.version" name="bhFixedvaluebillDto.version" type="text" value="${bhFixedvaluebillForm.bhFixedvaluebillDto.version}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhFixedvaluebillDto.fchangereason"/><%--改变原因--%></td>
			  			  
	    		
			  			   <td height="23" width="30%"  colspan="3"  >
				 <input id="bhFixedvaluebillDto.fchangereason" name="bhFixedvaluebillDto.fchangereason" type="text" value="${bhFixedvaluebillForm.bhFixedvaluebillDto.fchangereason}" size="10"  />
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
	</form>
</body>
</html>
