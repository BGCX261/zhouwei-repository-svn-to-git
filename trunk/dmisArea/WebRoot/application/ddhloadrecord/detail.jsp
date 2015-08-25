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
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/ddhloadrecord/detail.js"></script>
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

<jhop:ctrlgroup ctrlId="UIControlGroupXPanela1c3b47f486a4cdab5d0a84bee978adc" title="设备重载记录"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanela1c3b47f486a4cdab5d0a84bee978adc">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHloadrecordDto.fid"/><%--记录ID--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddHloadrecordDto.fid" name="ddHloadrecordDto.fid" type="text" value="${ddHloadrecordForm.ddHloadrecordDto.fid}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHloadrecordDto.flogdate"/><%--记录日期--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="ddHloadrecordDto.flogdate" genText="yes" dateFormat="yyyy-MM-dd" initValue="${ddHloadrecordForm.ddHloadrecordDto.flogdate}" ></jhop:date>
			   </td>
			  	    		    </tr>
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
				 <input id="ddHloadrecordDto.ffixcurrent" name="ddHloadrecordDto.ffixcurrent" type="text" value="${ddHloadrecordForm.ddHloadrecordDto.ffixcurrent}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHloadrecordDto.fmaxloadcur"/><%--最大负荷电流(A)--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddHloadrecordDto.fmaxloadcur" name="ddHloadrecordDto.fmaxloadcur" type="text" value="${ddHloadrecordForm.ddHloadrecordDto.fmaxloadcur}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHloadrecordDto.fstarttime"/><%--开始时间--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="ddHloadrecordDto.fstarttime" genText="yes" dateFormat="yyyy-MM-dd hh:mm:ss" initValue="${ddHloadrecordForm.ddHloadrecordDto.fstarttime}" ></jhop:date>
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHloadrecordDto.fendtime"/><%--结束时间--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="ddHloadrecordDto.fendtime" genText="yes" dateFormat="yyyy-MM-dd" initValue="${ddHloadrecordForm.ddHloadrecordDto.fendtime}" ></jhop:date>
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
				 <bean:message key="object.ddHloadrecordDto.ftemperature"/><%--温度(℃)--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddHloadrecordDto.ftemperature" name="ddHloadrecordDto.ftemperature" type="text" value="${ddHloadrecordForm.ddHloadrecordDto.ftemperature}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHloadrecordDto.fremark"/><%--说明--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddHloadrecordDto.fremark" name="ddHloadrecordDto.fremark" type="text" value="${ddHloadrecordForm.ddHloadrecordDto.fremark}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHloadrecordDto.fiswritelog"/><%--是否写入日志--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddHloadrecordDto.fiswritelog" name="ddHloadrecordDto.fiswritelog" type="text" value="${ddHloadrecordForm.ddHloadrecordDto.fiswritelog}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHloadrecordDto.fiswriteinwglog"/><%--是否写入班志--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddHloadrecordDto.fiswriteinwglog" name="ddHloadrecordDto.fiswriteinwglog" type="text" value="${ddHloadrecordForm.ddHloadrecordDto.fiswriteinwglog}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHloadrecordDto.fstationid"/><%--重载设备厂站ID--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddHloadrecordDto.fstationid" name="ddHloadrecordDto.fstationid" type="text" value="${ddHloadrecordForm.ddHloadrecordDto.fstationid}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHloadrecordDto.flineid"/><%--路名ID--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddHloadrecordDto.flineid" name="ddHloadrecordDto.flineid" type="text" value="${ddHloadrecordForm.ddHloadrecordDto.flineid}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHloadrecordDto.sys_fille"/><%--填写人--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddHloadrecordDto.sys_fille" name="ddHloadrecordDto.sys_fille" type="text" value="${ddHloadrecordForm.ddHloadrecordDto.sys_fille}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHloadrecordDto.sys_filldept"/><%--填写单位--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddHloadrecordDto.sys_filldept" name="ddHloadrecordDto.sys_filldept" type="text" value="${ddHloadrecordForm.ddHloadrecordDto.sys_filldept}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHloadrecordDto.sys_filltime"/><%--填写时间--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="ddHloadrecordDto.sys_filltime" genText="yes" dateFormat="yyyy-MM-dd hh:mm:ss" initValue="${ddHloadrecordForm.ddHloadrecordDto.sys_filltime}" ></jhop:date>
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHloadrecordDto.sys_isvalid"/><%--是否有效字段--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddHloadrecordDto.sys_isvalid" name="ddHloadrecordDto.sys_isvalid" type="text" value="${ddHloadrecordForm.ddHloadrecordDto.sys_isvalid}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHloadrecordDto.sys_dataowner"/><%--数据所属单位--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddHloadrecordDto.sys_dataowner" name="ddHloadrecordDto.sys_dataowner" type="text" value="${ddHloadrecordForm.ddHloadrecordDto.sys_dataowner}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHloadrecordDto.fadopmeasure"/><%--采取措施--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddHloadrecordDto.fadopmeasure" name="ddHloadrecordDto.fadopmeasure" type="text" value="${ddHloadrecordForm.ddHloadrecordDto.fadopmeasure}" size="10"  />
			   </td>
			  	    		    </tr>
	</table>
	</td></tr>
</table>
	</form>
</body>
</html>
