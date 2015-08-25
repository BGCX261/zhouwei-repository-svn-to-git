<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>设备重载记录详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/ddhloadrecord/DDeqoheavyload_defaultDetail_detail.js"></script>
</head>
<body>
<html:javascript formName="ddHloadrecordForm"/>
<logic:messagesPresent message="true">
	<html:messages id="message" message="true" header="messages.header" footer="messages.footer">
		<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
	</html:messages> 
</logic:messagesPresent>
 <form name="ddHloadrecordForm" action="" method="post" >
<%--hidden--%>

<input type="hidden" name="ddHloadrecordDto.fid" value="${ddHloadrecordForm.ddHloadrecordDto.fid}">
<input type="hidden" name="ddHloadrecordDto.version" value="${ddHloadrecordForm.ddHloadrecordDto.version}">
<input type="hidden" name="ddHloadrecordDto.flogdate" value="${ddHloadrecordForm.ddHloadrecordDto.flogdate}">

<input type="hidden" name="ddHloadrecordDto.sys_fille" 
				value="${ddHloadrecordForm.ddHloadrecordDto.sys_fille}">	
			<input type="hidden" name="ddHloadrecordDto.sys_filldept" 
				value="${ddHloadrecordForm.ddHloadrecordDto.sys_filldept}">
			<input type="hidden" name="ddHloadrecordDto.sys_filltime" 
				value="${ddHloadrecordForm.ddHloadrecordDto.sys_filltime}">
			<input type="hidden" name="ddHloadrecordDto.sys_isvalid" 
				value="${ddHloadrecordForm.ddHloadrecordDto.sys_isvalid}">
			<input type="hidden"	name="ddHloadrecordDto.sys_dataowner" 
				value="${ddHloadrecordForm.ddHloadrecordDto.sys_dataowner}">
			<input type="hidden" name="ddHloadrecordDto.zddhloadrecord6.feqpid" 
				value="${ddHloadrecordForm.ddHloadrecordDto.zddhloadrecord6.feqpid}">
			<input type="hidden" name="ddHloadrecordDto.zddhloadrecord4.fid" 
				value="${ddHloadrecordForm.ddHloadrecordDto.zddhloadrecord4.fid}">	
			<input type="hidden" name="ddHloadrecordDto.ddHloadrecordDto.fstationid" 
				value="${ddHloadrecordForm.ddHloadrecordDto.fstationid}">	
			<input type="hidden" name="ddHloadrecordDto.flineid" 
				value="${ddHloadrecordForm.ddHloadrecordDto.flineid}">	
				



<jhop:ctrlgroup ctrlId="UIControlGroupXPaneld4f100689a5049479165fd3655e082e8" title="设备重载记录"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPaneld4f100689a5049479165fd3655e082e8">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHloadrecordDto.fstationname"/><%--重载设备厂站--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddHloadrecordDto.fstationname" name="ddHloadrecordDto.fstationname" type="text" value="${ddHloadrecordForm.ddHloadrecordDto.fstationname}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHloadrecordDto.fdevclass"/><%--重载设备类型--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddHloadrecordDto.fdevclass" name="ddHloadrecordDto.fdevclass" type="text" value="${ddHloadrecordForm.ddHloadrecordDto.fdevclass}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHloadrecordDto.fdevname"/><%--重载设备名称--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddHloadrecordDto.fdevname" name="ddHloadrecordDto.fdevname" type="text" value="${ddHloadrecordForm.ddHloadrecordDto.fdevname}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHloadrecordDto.flinename"/><%--路名--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddHloadrecordDto.flinename" name="ddHloadrecordDto.flinename" type="text" value="${ddHloadrecordForm.ddHloadrecordDto.flinename}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   
	  
	  
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHloadrecordDto.ffixcurrent"/><%--额定电流(A)--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddHloadrecordDto.ffixcurrent" name="ddHloadrecordDto.ffixcurrent" type="text" value="${ddHloadrecordForm.ddHloadrecordDto.ffixcurrent}" size="10" onchange="calaRate();"/>
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHloadrecordDto.fmaxloadcur"/><%--最大负荷电�?A)--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddHloadrecordDto.fmaxloadcur" name="ddHloadrecordDto.fmaxloadcur" type="text" value="${ddHloadrecordForm.ddHloadrecordDto.fmaxloadcur}" size="10" onchange="calaRate();" />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHloadrecordDto.fstarttime"/><%--开始时时间--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:date name="ddHloadrecordDto.fstarttime" genText="yes" dateFormat="yyyy-mm-dd hh:mm:ss" initValue="${ddHloadrecordForm.ddHloadrecordDto.fstarttime}" ></jhop:date>
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHloadrecordDto.fendtime"/><%--结束时间--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:date name="ddHloadrecordDto.fendtime" genText="yes" dateFormat="yyyy-mm-dd hh:mm:ss" initValue="${ddHloadrecordForm.ddHloadrecordDto.fendtime}" ></jhop:date>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHloadrecordDto.fkeeptime"/><%--累计重载时间(分钟)--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddHloadrecordDto.fkeeptime" name="ddHloadrecordDto.fkeeptime" type="text" value="${ddHloadrecordForm.ddHloadrecordDto.fkeeptime}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHloadrecordDto.fhighestloadrate"/><%--最高负载率(%)--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddHloadrecordDto.fhighestloadrate" name="ddHloadrecordDto.fhighestloadrate" type="text" value="${ddHloadrecordForm.ddHloadrecordDto.fhighestloadrate}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHloadrecordDto.ftemperature"/><%--温度(�?--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddHloadrecordDto.ftemperature" name="ddHloadrecordDto.ftemperature" type="text" value="${ddHloadrecordForm.ddHloadrecordDto.ftemperature}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHloadrecordDto.fadopmeasure"/><%--采取措施--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:select name="ddHloadrecordDto.fadopmeasure" hiddName="" type="fadopmeasure" initValue="${ddHloadrecordForm.ddHloadrecordDto.fadopmeasure}"> </jhop:select>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHloadrecordDto.fremark"/><%--说明--%></td>
			  			  
	    		
			  			   <td height="23" width="30%"  colspan="3"  >
				 <textarea id='ddHloadrecordDto.fremark' name='ddHloadrecordDto.fremark' rows='3' cols='50' type="_moz">${ddHloadrecordForm.ddHloadrecordDto.fremark}</textarea>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHloadrecordDto.fiswritelog"/><%--是否写入日志--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:select name="ddHloadrecordDto.fiswritelog" type="text" initValue="是@@@是#否" ></jhop:select>
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHloadrecordDto.fiswriteinwglog"/><%--是否写入班志--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 
				 				 <jhop:select name="ddHloadrecordDto.fiswriteinwglog" type="text" initValue="是@@@是#否" ></jhop:select>
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
