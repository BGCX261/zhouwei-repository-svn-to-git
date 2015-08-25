<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>保护动作记录详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/bhactionrecord/detail.js"></script>
</head>
<body>
<html:javascript formName="bhActionrecordForm"/>
<logic:messagesPresent message="true">
	<html:messages id="message" message="true" header="messages.header" footer="messages.footer">
		<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
	</html:messages> 
</logic:messagesPresent>
 <form name="bhActionrecordForm" action="" method="post"  enctype="multipart/form-data" >
<%--hidden--%>

<input type="hidden" name="bhActionrecordDto.protectionrecordid" value="${bhActionrecordForm.bhActionrecordDto.protectionrecordid}">
<input type="hidden" name="bhActionrecordDto.version" value="${bhActionrecordForm.bhActionrecordDto.version}">

<jhop:ctrlgroup ctrlId="UIControlGroupXPanelc481b9ba96b34adfb19e8b684b3bd5c8" title="保护动作记录"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanelc481b9ba96b34adfb19e8b684b3bd5c8">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhActionrecordDto.protectionrecordid"/><%--保护动作记录--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhActionrecordDto.protectionrecordid" name="bhActionrecordDto.protectionrecordid" type="text" value="${bhActionrecordForm.bhActionrecordDto.protectionrecordid}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhActionrecordDto.eqpid"/><%--保护装置编号--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhActionrecordDto.eqpid" name="bhActionrecordDto.eqpid" type="text" value="${bhActionrecordForm.bhActionrecordDto.eqpid}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhActionrecordDto.fstationname"/><%--厂站名称--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhActionrecordDto.fstationname" name="bhActionrecordDto.fstationname" type="text" value="${bhActionrecordForm.bhActionrecordDto.fstationname}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhActionrecordDto.fstationid"/><%--变电站编号--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhActionrecordDto.fstationid" name="bhActionrecordDto.fstationid" type="text" value="${bhActionrecordForm.bhActionrecordDto.fstationid}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhActionrecordDto.version"/><%--数据库版本控制--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhActionrecordDto.version" name="bhActionrecordDto.version" type="text" value="${bhActionrecordForm.bhActionrecordDto.version}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhActionrecordDto.actionevaluate"/><%--保护装置动作评价--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhActionrecordDto.actionevaluate" name="bhActionrecordDto.actionevaluate" type="text" value="${bhActionrecordForm.bhActionrecordDto.actionevaluate}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhActionrecordDto.reclosuremode"/><%--重合闸方式--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhActionrecordDto.reclosuremode" name="bhActionrecordDto.reclosuremode" type="text" value="${bhActionrecordForm.bhActionrecordDto.reclosuremode}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhActionrecordDto.isreclosure"/><%--重合闸是否动作--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhActionrecordDto.isreclosure" name="bhActionrecordDto.isreclosure" type="text" value="${bhActionrecordForm.bhActionrecordDto.isreclosure}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhActionrecordDto.linereclosure"/><%--线路是否重合成功--%></td>
			  			  
	    		
			  			   <td height="23" width="30%"  colspan="3"  >
				 <input id="bhActionrecordDto.linereclosure" name="bhActionrecordDto.linereclosure" type="text" value="${bhActionrecordForm.bhActionrecordDto.linereclosure}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhActionrecordDto.dispatchno"/><%--调度命名--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhActionrecordDto.dispatchno" name="bhActionrecordDto.dispatchno" type="text" value="${bhActionrecordForm.bhActionrecordDto.dispatchno}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhActionrecordDto.actiontime"/><%--发生时间--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:date name="bhActionrecordDto.actiontime" genText="yes" dateFormat="yyyy-mm-dd" initValue="${bhActionrecordForm.bhActionrecordDto.actiontime}" ></jhop:date>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhActionrecordDto.actionevaluatetimes"/><%--保护装置动作评价次数--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhActionrecordDto.actionevaluatetimes" name="bhActionrecordDto.actionevaluatetimes" type="text" value="${bhActionrecordForm.bhActionrecordDto.actionevaluatetimes}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhActionrecordDto.faultrecordertimes"/><%--故障录波器录波次数--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhActionrecordDto.faultrecordertimes" name="bhActionrecordDto.faultrecordertimes" type="text" value="${bhActionrecordForm.bhActionrecordDto.faultrecordertimes}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhActionrecordDto.faultrecordergoodtimes"/><%--故障录波器完好次数--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhActionrecordDto.faultrecordergoodtimes" name="bhActionrecordDto.faultrecordergoodtimes" type="text" value="${bhActionrecordForm.bhActionrecordDto.faultrecordergoodtimes}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhActionrecordDto.faulteqp"/><%--故障设备--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhActionrecordDto.faulteqp" name="bhActionrecordDto.faulteqp" type="text" value="${bhActionrecordForm.bhActionrecordDto.faulteqp}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhActionrecordDto.actiondescription"/><%--保护动作情况简述--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:upload name="actiondescription" multiValue="no"></jhop:upload>
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhActionrecordDto.actionkeeptimes"/><%--保护动作时间--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhActionrecordDto.actionkeeptimes" name="bhActionrecordDto.actionkeeptimes" type="text" value="${bhActionrecordForm.bhActionrecordDto.actionkeeptimes}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhActionrecordDto.faultkeeptimes"/><%--故障持续时间--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhActionrecordDto.faultkeeptimes" name="bhActionrecordDto.faultkeeptimes" type="text" value="${bhActionrecordForm.bhActionrecordDto.faultkeeptimes}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhActionrecordDto.switchmodel"/><%--开关型号--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhActionrecordDto.switchmodel" name="bhActionrecordDto.switchmodel" type="text" value="${bhActionrecordForm.bhActionrecordDto.switchmodel}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhActionrecordDto.remarks"/><%--备注--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhActionrecordDto.remarks" name="bhActionrecordDto.remarks" type="text" value="${bhActionrecordForm.bhActionrecordDto.remarks}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhActionrecordDto.sys_fille"/><%--填写人--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhActionrecordDto.sys_fille" name="bhActionrecordDto.sys_fille" type="text" value="${bhActionrecordForm.bhActionrecordDto.sys_fille}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhActionrecordDto.sys_filldept"/><%--填写单位--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhActionrecordDto.sys_filldept" name="bhActionrecordDto.sys_filldept" type="text" value="${bhActionrecordForm.bhActionrecordDto.sys_filldept}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhActionrecordDto.sys_filltime"/><%--填写时间--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:date name="bhActionrecordDto.sys_filltime" genText="yes" dateFormat="yyyy-mm-dd hh:mm:ss" initValue="${bhActionrecordForm.bhActionrecordDto.sys_filltime}" ></jhop:date>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhActionrecordDto.sys_isvalid"/><%--是否有效字段--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhActionrecordDto.sys_isvalid" name="bhActionrecordDto.sys_isvalid" type="text" value="${bhActionrecordForm.bhActionrecordDto.sys_isvalid}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhActionrecordDto.sys_dataowner"/><%--数据所属单位--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhActionrecordDto.sys_dataowner" name="bhActionrecordDto.sys_dataowner" type="text" value="${bhActionrecordForm.bhActionrecordDto.sys_dataowner}" size="10"  />
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
